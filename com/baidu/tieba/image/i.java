package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class i {
    private String gSZ;
    private int gTa;
    private int gTb;
    private int gTc;
    private long gSY = 0;
    private HashMap<String, Boolean> gSX = new HashMap<>();

    public void vJ(int i) {
        this.gTb = i;
    }

    public int bGs() {
        return this.gTb;
    }

    public void vK(int i) {
        this.gTc = i;
    }

    public int bGt() {
        return this.gTc;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.gSZ = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.gSZ = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.gTa = intExtra;
            this.gTb = intExtra;
            this.gTc = intExtra;
        }
    }

    public void Z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.gSZ);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.gSX) {
            if (System.nanoTime() - this.gSY > 300000000 && list != null && i < list.size()) {
                this.gSX.put(list.get(i), true);
            }
            this.gSY = System.nanoTime();
            if (list != null && i2 < list.size() && this.gSX.get(list.get(i2)) == null) {
                this.gSX.put(list.get(i2), false);
            }
        }
        if (this.gSX.size() >= 100) {
            bGu();
        }
    }

    public void bGu() {
        if (this.gSX != null) {
            synchronized (this.gSX) {
                if (this.gSX.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.gSX.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.gSX.size(), this.gSZ, this.gTa + 1, this.gTb + 1);
                    this.gSX.clear();
                }
            }
        }
    }

    public void as(int i, String str) {
        if (i == 1 && System.nanoTime() - this.gSY > 300000000) {
            this.gSX.put(str, true);
        }
    }

    public void d(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.gTc == this.gTb) {
            sb.append(this.gTc + 1);
            if (this.gTb == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.gTc; i2 <= this.gTb; i2++) {
                if (i2 == this.gTb) {
                    sb.append(i2 + 1);
                    if (this.gTb == i - 1) {
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
        am amVar = new am("common_exp");
        amVar.bT("page_type", "a008");
        if (!ap.isEmpty(str2)) {
            amVar.bT("fid", str2);
        }
        if (!ap.isEmpty(str3)) {
            amVar.bT("tid", str3);
        }
        amVar.P("pic_count", i);
        amVar.bT("obj_floors", sb.toString());
        amVar.bT("obj_isads", sb2.toString());
        int i3 = (this.gTb - this.gTc) + 1;
        if (i3 == 1) {
            if (this.gTb == i - 1) {
                amVar.bT(VideoPlayActivityConfig.OBJ_ID, str);
            } else {
                amVar.bT(VideoPlayActivityConfig.OBJ_ID, "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.gTb == i - 1) {
                sb3.append(str);
            }
            amVar.bT("obj_ids", str);
        }
        TiebaStatic.log(amVar);
    }
}
