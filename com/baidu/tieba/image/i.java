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
    private String gSU;
    private int gSV;
    private int gSW;
    private int gSX;
    private long gST = 0;
    private HashMap<String, Boolean> gSS = new HashMap<>();

    public void vJ(int i) {
        this.gSW = i;
    }

    public int bGo() {
        return this.gSW;
    }

    public void vK(int i) {
        this.gSX = i;
    }

    public int bGp() {
        return this.gSX;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.gSU = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.gSU = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.gSV = intExtra;
            this.gSW = intExtra;
            this.gSX = intExtra;
        }
    }

    public void Z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.gSU);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.gSS) {
            if (System.nanoTime() - this.gST > 300000000 && list != null && i < list.size()) {
                this.gSS.put(list.get(i), true);
            }
            this.gST = System.nanoTime();
            if (list != null && i2 < list.size() && this.gSS.get(list.get(i2)) == null) {
                this.gSS.put(list.get(i2), false);
            }
        }
        if (this.gSS.size() >= 100) {
            bGq();
        }
    }

    public void bGq() {
        if (this.gSS != null) {
            synchronized (this.gSS) {
                if (this.gSS.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.gSS.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.gSS.size(), this.gSU, this.gSV + 1, this.gSW + 1);
                    this.gSS.clear();
                }
            }
        }
    }

    public void as(int i, String str) {
        if (i == 1 && System.nanoTime() - this.gST > 300000000) {
            this.gSS.put(str, true);
        }
    }

    public void d(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.gSX == this.gSW) {
            sb.append(this.gSX + 1);
            if (this.gSW == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.gSX; i2 <= this.gSW; i2++) {
                if (i2 == this.gSW) {
                    sb.append(i2 + 1);
                    if (this.gSW == i - 1) {
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
        int i3 = (this.gSW - this.gSX) + 1;
        if (i3 == 1) {
            if (this.gSW == i - 1) {
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
            if (this.gSW == i - 1) {
                sb3.append(str);
            }
            amVar.bT("obj_ids", str);
        }
        TiebaStatic.log(amVar);
    }
}
