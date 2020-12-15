package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
public class g {
    private String kMC;
    private int kMD;
    private int kME;
    private int kMF;
    private long kMB = 0;
    private HashMap<String, Boolean> kMA = new HashMap<>();

    public void Fd(int i) {
        this.kME = i;
    }

    public int dcw() {
        return this.kME;
    }

    public void Fe(int i) {
        this.kMF = i;
    }

    public int dcx() {
        return this.kMF;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.kMC = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.kMC = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.kMD = intExtra;
            this.kME = intExtra;
            this.kMF = intExtra;
        }
    }

    public void az(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.kMC);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.kMA) {
            if (System.nanoTime() - this.kMB > 300000000 && list != null && i < list.size()) {
                this.kMA.put(list.get(i), true);
            }
            this.kMB = System.nanoTime();
            if (list != null && i2 < list.size() && this.kMA.get(list.get(i2)) == null) {
                this.kMA.put(list.get(i2), false);
            }
        }
        if (this.kMA.size() >= 100) {
            dcy();
        }
    }

    public void dcy() {
        if (this.kMA != null) {
            synchronized (this.kMA) {
                if (this.kMA.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.kMA.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.kMA.size(), this.kMC, this.kMD + 1, this.kME + 1);
                    this.kMA.clear();
                }
            }
        }
    }

    public void bA(int i, String str) {
        if (i == 1 && System.nanoTime() - this.kMB > 300000000) {
            this.kMA.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.kMF == this.kME) {
            sb.append(this.kMF + 1);
            if (this.kME == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.kMF; i2 <= this.kME; i2++) {
                if (i2 == this.kME) {
                    sb.append(i2 + 1);
                    if (this.kME == i - 1) {
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
        ar arVar = new ar("common_exp");
        arVar.dY("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!au.isEmpty(str2)) {
            arVar.dY("fid", str2);
        }
        if (!au.isEmpty(str3)) {
            arVar.dY("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            arVar.dY("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fje);
        }
        arVar.al("pic_count", i);
        arVar.dY("obj_floors", sb.toString());
        arVar.dY("obj_isads", sb2.toString());
        int i3 = (this.kME - this.kMF) + 1;
        if (i3 == 1) {
            if (this.kME == i - 1) {
                arVar.dY("obj_id", str);
            } else {
                arVar.dY("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.kME == i - 1) {
                sb3.append(str);
            }
            arVar.dY("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            arVar.dY("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            arVar.dY("second_dir", str5);
        }
        TiebaStatic.log(arVar);
    }
}
