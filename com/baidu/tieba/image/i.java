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
    private String gSX;
    private int gSY;
    private int gSZ;
    private int gTa;
    private long gSW = 0;
    private HashMap<String, Boolean> gSV = new HashMap<>();

    public void vJ(int i) {
        this.gSZ = i;
    }

    public int bGr() {
        return this.gSZ;
    }

    public void vK(int i) {
        this.gTa = i;
    }

    public int bGs() {
        return this.gTa;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.gSX = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.gSX = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.gSY = intExtra;
            this.gSZ = intExtra;
            this.gTa = intExtra;
        }
    }

    public void Z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.gSX);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.gSV) {
            if (System.nanoTime() - this.gSW > 300000000 && list != null && i < list.size()) {
                this.gSV.put(list.get(i), true);
            }
            this.gSW = System.nanoTime();
            if (list != null && i2 < list.size() && this.gSV.get(list.get(i2)) == null) {
                this.gSV.put(list.get(i2), false);
            }
        }
        if (this.gSV.size() >= 100) {
            bGt();
        }
    }

    public void bGt() {
        if (this.gSV != null) {
            synchronized (this.gSV) {
                if (this.gSV.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.gSV.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.gSV.size(), this.gSX, this.gSY + 1, this.gSZ + 1);
                    this.gSV.clear();
                }
            }
        }
    }

    public void as(int i, String str) {
        if (i == 1 && System.nanoTime() - this.gSW > 300000000) {
            this.gSV.put(str, true);
        }
    }

    public void d(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.gTa == this.gSZ) {
            sb.append(this.gTa + 1);
            if (this.gSZ == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.gTa; i2 <= this.gSZ; i2++) {
                if (i2 == this.gSZ) {
                    sb.append(i2 + 1);
                    if (this.gSZ == i - 1) {
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
        int i3 = (this.gSZ - this.gTa) + 1;
        if (i3 == 1) {
            if (this.gSZ == i - 1) {
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
            if (this.gSZ == i - 1) {
                sb3.append(str);
            }
            amVar.bT("obj_ids", str);
        }
        TiebaStatic.log(amVar);
    }
}
