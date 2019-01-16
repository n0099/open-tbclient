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
    private String flI;
    private int flJ;
    private int flK;
    private int flL;
    private long flH = 0;
    private HashMap<String, Boolean> flG = new HashMap<>();

    public void qW(int i) {
        this.flK = i;
    }

    public int aYb() {
        return this.flK;
    }

    public void qX(int i) {
        this.flL = i;
    }

    public int aYc() {
        return this.flL;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.flI = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.flI = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.flJ = intExtra;
            this.flK = intExtra;
            this.flL = intExtra;
        }
    }

    public void D(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.flI);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.flG) {
            if (System.nanoTime() - this.flH > 300000000 && list != null && i < list.size()) {
                this.flG.put(list.get(i), true);
            }
            this.flH = System.nanoTime();
            if (list != null && i2 < list.size() && this.flG.get(list.get(i2)) == null) {
                this.flG.put(list.get(i2), false);
            }
        }
        if (this.flG.size() >= 100) {
            aYd();
        }
    }

    public void aYd() {
        if (this.flG != null) {
            synchronized (this.flG) {
                if (this.flG.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.flG.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.flG.size(), this.flI, this.flJ + 1, this.flK + 1);
                    this.flG.clear();
                }
            }
        }
    }

    public void X(int i, String str) {
        if (i == 1 && System.nanoTime() - this.flH > 300000000) {
            this.flG.put(str, true);
        }
    }

    public void b(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.flL == this.flK) {
            sb.append(this.flL + 1);
            if (this.flK == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.flL; i2 <= this.flK; i2++) {
                if (i2 == this.flK) {
                    sb.append(i2 + 1);
                    if (this.flK == i - 1) {
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
        int i3 = (this.flK - this.flL) + 1;
        if (i3 == 1) {
            if (this.flK == i - 1) {
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
            if (this.flK == i - 1) {
                sb3.append(str);
            }
            amVar.aB("obj_ids", str);
        }
        TiebaStatic.log(amVar);
    }
}
