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
/* loaded from: classes8.dex */
public class i {
    private String kVD;
    private int kVE;
    private int kVF;
    private int kVG;
    private long kVC = 0;
    private HashMap<String, Boolean> kVB = new HashMap<>();

    public void DJ(int i) {
        this.kVF = i;
    }

    public int dam() {
        return this.kVF;
    }

    public void DK(int i) {
        this.kVG = i;
    }

    public int dan() {
        return this.kVG;
    }

    public void a(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.kVD = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.kVD = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.kVE = intExtra;
            this.kVF = intExtra;
            this.kVG = intExtra;
        }
    }

    public void az(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.kVD);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.kVB) {
            if (System.nanoTime() - this.kVC > 300000000 && list != null && i < list.size()) {
                this.kVB.put(list.get(i), true);
            }
            this.kVC = System.nanoTime();
            if (list != null && i2 < list.size() && this.kVB.get(list.get(i2)) == null) {
                this.kVB.put(list.get(i2), false);
            }
        }
        if (this.kVB.size() >= 100) {
            dao();
        }
    }

    public void dao() {
        if (this.kVB != null) {
            synchronized (this.kVB) {
                if (this.kVB.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.kVB.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.kVB.size(), this.kVD, this.kVE + 1, this.kVF + 1);
                    this.kVB.clear();
                }
            }
        }
    }

    public void bH(int i, String str) {
        if (i == 1 && System.nanoTime() - this.kVC > 300000000) {
            this.kVB.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.kVG == this.kVF) {
            sb.append(this.kVG + 1);
            if (this.kVF == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.kVG; i2 <= this.kVF; i2++) {
                if (i2 == this.kVF) {
                    sb.append(i2 + 1);
                    if (this.kVF == i - 1) {
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
        arVar.dR("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!au.isEmpty(str2)) {
            arVar.dR("fid", str2);
        }
        if (!au.isEmpty(str3)) {
            arVar.dR("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fqv);
        }
        arVar.ap("pic_count", i);
        arVar.dR("obj_floors", sb.toString());
        arVar.dR("obj_isads", sb2.toString());
        int i3 = (this.kVF - this.kVG) + 1;
        if (i3 == 1) {
            if (this.kVF == i - 1) {
                arVar.dR("obj_id", str);
            } else {
                arVar.dR("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.kVF == i - 1) {
                sb3.append(str);
            }
            arVar.dR("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            arVar.dR("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            arVar.dR("second_dir", str5);
        }
        TiebaStatic.log(arVar);
    }
}
