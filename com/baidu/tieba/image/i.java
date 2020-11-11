package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
public class i {
    private String kyT;
    private int kyU;
    private int kyV;
    private int kyW;
    private long kyS = 0;
    private HashMap<String, Boolean> kyR = new HashMap<>();

    public void DQ(int i) {
        this.kyV = i;
    }

    public int cXO() {
        return this.kyV;
    }

    public void DR(int i) {
        this.kyW = i;
    }

    public int cXP() {
        return this.kyW;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.kyT = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.kyT = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.kyU = intExtra;
            this.kyV = intExtra;
            this.kyW = intExtra;
        }
    }

    public void ay(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.kyT);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.kyR) {
            if (System.nanoTime() - this.kyS > 300000000 && list != null && i < list.size()) {
                this.kyR.put(list.get(i), true);
            }
            this.kyS = System.nanoTime();
            if (list != null && i2 < list.size() && this.kyR.get(list.get(i2)) == null) {
                this.kyR.put(list.get(i2), false);
            }
        }
        if (this.kyR.size() >= 100) {
            cXQ();
        }
    }

    public void cXQ() {
        if (this.kyR != null) {
            synchronized (this.kyR) {
                if (this.kyR.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.kyR.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.kyR.size(), this.kyT, this.kyU + 1, this.kyV + 1);
                    this.kyR.clear();
                }
            }
        }
    }

    public void bC(int i, String str) {
        if (i == 1 && System.nanoTime() - this.kyS > 300000000) {
            this.kyR.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.kyW == this.kyV) {
            sb.append(this.kyW + 1);
            if (this.kyV == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.kyW; i2 <= this.kyV; i2++) {
                if (i2 == this.kyV) {
                    sb.append(i2 + 1);
                    if (this.kyV == i - 1) {
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
        aq aqVar = new aq("common_exp");
        aqVar.dR("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!at.isEmpty(str2)) {
            aqVar.dR("fid", str2);
        }
        if (!at.isEmpty(str3)) {
            aqVar.dR("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fcx);
        }
        aqVar.al("pic_count", i);
        aqVar.dR("obj_floors", sb.toString());
        aqVar.dR("obj_isads", sb2.toString());
        int i3 = (this.kyV - this.kyW) + 1;
        if (i3 == 1) {
            if (this.kyV == i - 1) {
                aqVar.dR("obj_id", str);
            } else {
                aqVar.dR("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.kyV == i - 1) {
                sb3.append(str);
            }
            aqVar.dR("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dR("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            aqVar.dR("second_dir", str5);
        }
        TiebaStatic.log(aqVar);
    }
}
