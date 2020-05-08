package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class i {
    private String iEj;
    private int iEk;
    private int iEl;
    private int iEm;
    private long iEi = 0;
    private HashMap<String, Boolean> iEh = new HashMap<>();

    public void xP(int i) {
        this.iEl = i;
    }

    public int clB() {
        return this.iEl;
    }

    public void xQ(int i) {
        this.iEm = i;
    }

    public int clC() {
        return this.iEm;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.iEj = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.iEj = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.iEk = intExtra;
            this.iEl = intExtra;
            this.iEm = intExtra;
        }
    }

    public void ar(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.iEj);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.iEh) {
            if (System.nanoTime() - this.iEi > 300000000 && list != null && i < list.size()) {
                this.iEh.put(list.get(i), true);
            }
            this.iEi = System.nanoTime();
            if (list != null && i2 < list.size() && this.iEh.get(list.get(i2)) == null) {
                this.iEh.put(list.get(i2), false);
            }
        }
        if (this.iEh.size() >= 100) {
            clD();
        }
    }

    public void clD() {
        if (this.iEh != null) {
            synchronized (this.iEh) {
                if (this.iEh.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.iEh.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.iEh.size(), this.iEj, this.iEk + 1, this.iEl + 1);
                    this.iEh.clear();
                }
            }
        }
    }

    public void bb(int i, String str) {
        if (i == 1 && System.nanoTime() - this.iEi > 300000000) {
            this.iEh.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.iEm == this.iEl) {
            sb.append(this.iEm + 1);
            if (this.iEl == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.iEm; i2 <= this.iEl; i2++) {
                if (i2 == this.iEl) {
                    sb.append(i2 + 1);
                    if (this.iEl == i - 1) {
                        sb2.append(1);
                    } else {
                        sb2.append(0);
                    }
                } else {
                    sb.append(i2 + 1);
                    sb.append("|");
                    sb2.append(0);
                    sb2.append("|");
                }
            }
        }
        an anVar = new an("common_exp");
        anVar.cI("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!aq.isEmpty(str2)) {
            anVar.cI("fid", str2);
        }
        if (!aq.isEmpty(str3)) {
            anVar.cI("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cI(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dMx);
        }
        anVar.af("pic_count", i);
        anVar.cI("obj_floors", sb.toString());
        anVar.cI("obj_isads", sb2.toString());
        int i3 = (this.iEl - this.iEm) + 1;
        if (i3 == 1) {
            if (this.iEl == i - 1) {
                anVar.cI("obj_id", str);
            } else {
                anVar.cI("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.iEl == i - 1) {
                sb3.append(str);
            }
            anVar.cI("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            anVar.cI("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            anVar.cI("second_dir", str5);
        }
        TiebaStatic.log(anVar);
    }
}
