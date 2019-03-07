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
    private String gBO;
    private int gBP;
    private int gBQ;
    private int gBR;
    private long gBN = 0;
    private HashMap<String, Boolean> gBM = new HashMap<>();

    public void uG(int i) {
        this.gBQ = i;
    }

    public int byH() {
        return this.gBQ;
    }

    public void uH(int i) {
        this.gBR = i;
    }

    public int byI() {
        return this.gBR;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.gBO = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.gBO = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.gBP = intExtra;
            this.gBQ = intExtra;
            this.gBR = intExtra;
        }
    }

    public void Y(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.gBO);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.gBM) {
            if (System.nanoTime() - this.gBN > 300000000 && list != null && i < list.size()) {
                this.gBM.put(list.get(i), true);
            }
            this.gBN = System.nanoTime();
            if (list != null && i2 < list.size() && this.gBM.get(list.get(i2)) == null) {
                this.gBM.put(list.get(i2), false);
            }
        }
        if (this.gBM.size() >= 100) {
            byJ();
        }
    }

    public void byJ() {
        if (this.gBM != null) {
            synchronized (this.gBM) {
                if (this.gBM.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.gBM.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.gBM.size(), this.gBO, this.gBP + 1, this.gBQ + 1);
                    this.gBM.clear();
                }
            }
        }
    }

    public void an(int i, String str) {
        if (i == 1 && System.nanoTime() - this.gBN > 300000000) {
            this.gBM.put(str, true);
        }
    }

    public void d(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.gBR == this.gBQ) {
            sb.append(this.gBR + 1);
            if (this.gBQ == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.gBR; i2 <= this.gBQ; i2++) {
                if (i2 == this.gBQ) {
                    sb.append(i2 + 1);
                    if (this.gBQ == i - 1) {
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
        int i3 = (this.gBQ - this.gBR) + 1;
        if (i3 == 1) {
            if (this.gBQ == i - 1) {
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
            if (this.gBQ == i - 1) {
                sb3.append(str);
            }
            amVar.bJ("obj_ids", str);
        }
        TiebaStatic.log(amVar);
    }
}
