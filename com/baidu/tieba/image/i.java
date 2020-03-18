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
    private String hUm;
    private int hUn;
    private int hUo;
    private int hUp;
    private long hUl = 0;
    private HashMap<String, Boolean> hUk = new HashMap<>();

    public void xp(int i) {
        this.hUo = i;
    }

    public int cbc() {
        return this.hUo;
    }

    public void xq(int i) {
        this.hUp = i;
    }

    public int cbd() {
        return this.hUp;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.hUm = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.hUm = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.hUn = intExtra;
            this.hUo = intExtra;
            this.hUp = intExtra;
        }
    }

    public void ar(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.hUm);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.hUk) {
            if (System.nanoTime() - this.hUl > 300000000 && list != null && i < list.size()) {
                this.hUk.put(list.get(i), true);
            }
            this.hUl = System.nanoTime();
            if (list != null && i2 < list.size() && this.hUk.get(list.get(i2)) == null) {
                this.hUk.put(list.get(i2), false);
            }
        }
        if (this.hUk.size() >= 100) {
            cbe();
        }
    }

    public void cbe() {
        if (this.hUk != null) {
            synchronized (this.hUk) {
                if (this.hUk.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.hUk.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.hUk.size(), this.hUm, this.hUn + 1, this.hUo + 1);
                    this.hUk.clear();
                }
            }
        }
    }

    public void aM(int i, String str) {
        if (i == 1 && System.nanoTime() - this.hUl > 300000000) {
            this.hUk.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.hUp == this.hUo) {
            sb.append(this.hUp + 1);
            if (this.hUo == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.hUp; i2 <= this.hUo; i2++) {
                if (i2 == this.hUo) {
                    sb.append(i2 + 1);
                    if (this.hUo == i - 1) {
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
        anVar.cx("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!aq.isEmpty(str2)) {
            anVar.cx("fid", str2);
        }
        if (!aq.isEmpty(str3)) {
            anVar.cx("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cx(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dmy);
        }
        anVar.X("pic_count", i);
        anVar.cx("obj_floors", sb.toString());
        anVar.cx("obj_isads", sb2.toString());
        int i3 = (this.hUo - this.hUp) + 1;
        if (i3 == 1) {
            if (this.hUo == i - 1) {
                anVar.cx("obj_id", str);
            } else {
                anVar.cx("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.hUo == i - 1) {
                sb3.append(str);
            }
            anVar.cx("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            anVar.cx("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            anVar.cx("second_dir", str5);
        }
        TiebaStatic.log(anVar);
    }
}
