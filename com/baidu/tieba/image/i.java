package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class i {
    private String hbV;
    private int hbW;
    private int hbX;
    private int hbY;
    private long hbU = 0;
    private HashMap<String, Boolean> hbT = new HashMap<>();

    public void wq(int i) {
        this.hbX = i;
    }

    public int bKa() {
        return this.hbX;
    }

    public void wr(int i) {
        this.hbY = i;
    }

    public int bKb() {
        return this.hbY;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.hbV = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.hbV = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.hbW = intExtra;
            this.hbX = intExtra;
            this.hbY = intExtra;
        }
    }

    public void Z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.hbV);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.hbT) {
            if (System.nanoTime() - this.hbU > 300000000 && list != null && i < list.size()) {
                this.hbT.put(list.get(i), true);
            }
            this.hbU = System.nanoTime();
            if (list != null && i2 < list.size() && this.hbT.get(list.get(i2)) == null) {
                this.hbT.put(list.get(i2), false);
            }
        }
        if (this.hbT.size() >= 100) {
            bKc();
        }
    }

    public void bKc() {
        if (this.hbT != null) {
            synchronized (this.hbT) {
                if (this.hbT.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.hbT.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.hbT.size(), this.hbV, this.hbW + 1, this.hbX + 1);
                    this.hbT.clear();
                }
            }
        }
    }

    public void as(int i, String str) {
        if (i == 1 && System.nanoTime() - this.hbU > 300000000) {
            this.hbT.put(str, true);
        }
    }

    public void e(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.hbY == this.hbX) {
            sb.append(this.hbY + 1);
            if (this.hbX == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.hbY; i2 <= this.hbX; i2++) {
                if (i2 == this.hbX) {
                    sb.append(i2 + 1);
                    if (this.hbX == i - 1) {
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
        an anVar = new an("common_exp");
        anVar.bT("page_type", "a008");
        if (!aq.isEmpty(str2)) {
            anVar.bT("fid", str2);
        }
        if (!aq.isEmpty(str3)) {
            anVar.bT("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cgM);
        }
        anVar.P("pic_count", i);
        anVar.bT("obj_floors", sb.toString());
        anVar.bT("obj_isads", sb2.toString());
        int i3 = (this.hbX - this.hbY) + 1;
        if (i3 == 1) {
            if (this.hbX == i - 1) {
                anVar.bT(VideoPlayActivityConfig.OBJ_ID, str);
            } else {
                anVar.bT(VideoPlayActivityConfig.OBJ_ID, "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.hbX == i - 1) {
                sb3.append(str);
            }
            anVar.bT("obj_ids", str);
        }
        TiebaStatic.log(anVar);
    }
}
