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
    private String gBD;
    private int gBE;
    private int gBF;
    private int gBG;
    private long gBC = 0;
    private HashMap<String, Boolean> gBB = new HashMap<>();

    public void uC(int i) {
        this.gBF = i;
    }

    public int byE() {
        return this.gBF;
    }

    public void uD(int i) {
        this.gBG = i;
    }

    public int byF() {
        return this.gBG;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.gBD = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.gBD = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.gBE = intExtra;
            this.gBF = intExtra;
            this.gBG = intExtra;
        }
    }

    public void Y(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.gBD);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.gBB) {
            if (System.nanoTime() - this.gBC > 300000000 && list != null && i < list.size()) {
                this.gBB.put(list.get(i), true);
            }
            this.gBC = System.nanoTime();
            if (list != null && i2 < list.size() && this.gBB.get(list.get(i2)) == null) {
                this.gBB.put(list.get(i2), false);
            }
        }
        if (this.gBB.size() >= 100) {
            byG();
        }
    }

    public void byG() {
        if (this.gBB != null) {
            synchronized (this.gBB) {
                if (this.gBB.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.gBB.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.gBB.size(), this.gBD, this.gBE + 1, this.gBF + 1);
                    this.gBB.clear();
                }
            }
        }
    }

    public void ap(int i, String str) {
        if (i == 1 && System.nanoTime() - this.gBC > 300000000) {
            this.gBB.put(str, true);
        }
    }

    public void d(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.gBG == this.gBF) {
            sb.append(this.gBG + 1);
            if (this.gBF == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.gBG; i2 <= this.gBF; i2++) {
                if (i2 == this.gBF) {
                    sb.append(i2 + 1);
                    if (this.gBF == i - 1) {
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
        amVar.bJ("page_type", "a008");
        if (!ap.isEmpty(str2)) {
            amVar.bJ(ImageViewerConfig.FORUM_ID, str2);
        }
        if (!ap.isEmpty(str3)) {
            amVar.bJ("tid", str3);
        }
        amVar.T("pic_count", i);
        amVar.bJ("obj_floors", sb.toString());
        amVar.bJ("obj_isads", sb2.toString());
        int i3 = (this.gBF - this.gBG) + 1;
        if (i3 == 1) {
            if (this.gBF == i - 1) {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, str);
            } else {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.gBF == i - 1) {
                sb3.append(str);
            }
            amVar.bJ("obj_ids", str);
        }
        TiebaStatic.log(amVar);
    }
}
