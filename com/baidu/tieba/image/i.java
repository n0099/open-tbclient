package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class i {
    private String flJ;
    private int flK;
    private int flL;
    private int flM;
    private long flI = 0;
    private HashMap<String, Boolean> flH = new HashMap<>();

    public void qW(int i) {
        this.flL = i;
    }

    public int aYb() {
        return this.flL;
    }

    public void qX(int i) {
        this.flM = i;
    }

    public int aYc() {
        return this.flM;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.flJ = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.flJ = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.flK = intExtra;
            this.flL = intExtra;
            this.flM = intExtra;
        }
    }

    public void D(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.flJ);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.flH) {
            if (System.nanoTime() - this.flI > 300000000 && list != null && i < list.size()) {
                this.flH.put(list.get(i), true);
            }
            this.flI = System.nanoTime();
            if (list != null && i2 < list.size() && this.flH.get(list.get(i2)) == null) {
                this.flH.put(list.get(i2), false);
            }
        }
        if (this.flH.size() >= 100) {
            aYd();
        }
    }

    public void aYd() {
        if (this.flH != null) {
            synchronized (this.flH) {
                if (this.flH.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.flH.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.flH.size(), this.flJ, this.flK + 1, this.flL + 1);
                    this.flH.clear();
                }
            }
        }
    }

    public void X(int i, String str) {
        if (i == 1 && System.nanoTime() - this.flI > 300000000) {
            this.flH.put(str, true);
        }
    }

    public void b(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.flM == this.flL) {
            sb.append(this.flM + 1);
            if (this.flL == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.flM; i2 <= this.flL; i2++) {
                if (i2 == this.flL) {
                    sb.append(i2 + 1);
                    if (this.flL == i - 1) {
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
        amVar.aB("page_type", "a008");
        if (!ao.isEmpty(str2)) {
            amVar.aB(ImageViewerConfig.FORUM_ID, str2);
        }
        if (!ao.isEmpty(str3)) {
            amVar.aB("tid", str3);
        }
        amVar.y("pic_count", i);
        amVar.aB("obj_floors", sb.toString());
        amVar.aB("obj_isads", sb2.toString());
        int i3 = (this.flL - this.flM) + 1;
        if (i3 == 1) {
            if (this.flL == i - 1) {
                amVar.aB(VideoPlayActivityConfig.OBJ_ID, str);
            } else {
                amVar.aB(VideoPlayActivityConfig.OBJ_ID, "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.flL == i - 1) {
                sb3.append(str);
            }
            amVar.aB("obj_ids", str);
        }
        TiebaStatic.log(amVar);
    }
}
