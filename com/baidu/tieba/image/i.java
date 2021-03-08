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
/* loaded from: classes7.dex */
public class i {
    private String kXT;
    private int kXU;
    private int kXV;
    private int kXW;
    private long kXS = 0;
    private HashMap<String, Boolean> kXR = new HashMap<>();

    public void DM(int i) {
        this.kXV = i;
    }

    public int daC() {
        return this.kXV;
    }

    public void DN(int i) {
        this.kXW = i;
    }

    public int daD() {
        return this.kXW;
    }

    public void a(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.kXT = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.kXT = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.kXU = intExtra;
            this.kXV = intExtra;
            this.kXW = intExtra;
        }
    }

    public void az(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.kXT);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.kXR) {
            if (System.nanoTime() - this.kXS > 300000000 && list != null && i < list.size()) {
                this.kXR.put(list.get(i), true);
            }
            this.kXS = System.nanoTime();
            if (list != null && i2 < list.size() && this.kXR.get(list.get(i2)) == null) {
                this.kXR.put(list.get(i2), false);
            }
        }
        if (this.kXR.size() >= 100) {
            daE();
        }
    }

    public void daE() {
        if (this.kXR != null) {
            synchronized (this.kXR) {
                if (this.kXR.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.kXR.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.kXR.size(), this.kXT, this.kXU + 1, this.kXV + 1);
                    this.kXR.clear();
                }
            }
        }
    }

    public void bH(int i, String str) {
        if (i == 1 && System.nanoTime() - this.kXS > 300000000) {
            this.kXR.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.kXW == this.kXV) {
            sb.append(this.kXW + 1);
            if (this.kXV == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.kXW; i2 <= this.kXV; i2++) {
                if (i2 == this.kXV) {
                    sb.append(i2 + 1);
                    if (this.kXV == i - 1) {
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
            arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().frW);
        }
        arVar.aq("pic_count", i);
        arVar.dR("obj_floors", sb.toString());
        arVar.dR("obj_isads", sb2.toString());
        int i3 = (this.kXV - this.kXW) + 1;
        if (i3 == 1) {
            if (this.kXV == i - 1) {
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
            if (this.kXV == i - 1) {
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
