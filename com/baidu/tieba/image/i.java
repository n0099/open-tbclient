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
    private String iEd;
    private int iEe;
    private int iEf;
    private int iEg;
    private long iEc = 0;
    private HashMap<String, Boolean> iEb = new HashMap<>();

    public void xP(int i) {
        this.iEf = i;
    }

    public int clD() {
        return this.iEf;
    }

    public void xQ(int i) {
        this.iEg = i;
    }

    public int clE() {
        return this.iEg;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.iEd = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.iEd = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.iEe = intExtra;
            this.iEf = intExtra;
            this.iEg = intExtra;
        }
    }

    public void ar(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.iEd);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.iEb) {
            if (System.nanoTime() - this.iEc > 300000000 && list != null && i < list.size()) {
                this.iEb.put(list.get(i), true);
            }
            this.iEc = System.nanoTime();
            if (list != null && i2 < list.size() && this.iEb.get(list.get(i2)) == null) {
                this.iEb.put(list.get(i2), false);
            }
        }
        if (this.iEb.size() >= 100) {
            clF();
        }
    }

    public void clF() {
        if (this.iEb != null) {
            synchronized (this.iEb) {
                if (this.iEb.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.iEb.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.iEb.size(), this.iEd, this.iEe + 1, this.iEf + 1);
                    this.iEb.clear();
                }
            }
        }
    }

    public void bb(int i, String str) {
        if (i == 1 && System.nanoTime() - this.iEc > 300000000) {
            this.iEb.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.iEg == this.iEf) {
            sb.append(this.iEg + 1);
            if (this.iEf == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.iEg; i2 <= this.iEf; i2++) {
                if (i2 == this.iEf) {
                    sb.append(i2 + 1);
                    if (this.iEf == i - 1) {
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
            anVar.cI(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dMt);
        }
        anVar.af("pic_count", i);
        anVar.cI("obj_floors", sb.toString());
        anVar.cI("obj_isads", sb2.toString());
        int i3 = (this.iEf - this.iEg) + 1;
        if (i3 == 1) {
            if (this.iEf == i - 1) {
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
            if (this.iEf == i - 1) {
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
