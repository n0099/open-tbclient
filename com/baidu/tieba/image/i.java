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
    private String gZj;
    private int gZk;
    private int gZl;
    private int gZm;
    private long gZi = 0;
    private HashMap<String, Boolean> gZh = new HashMap<>();

    public void wl(int i) {
        this.gZl = i;
    }

    public int bIZ() {
        return this.gZl;
    }

    public void wm(int i) {
        this.gZm = i;
    }

    public int bJa() {
        return this.gZm;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.gZj = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.gZj = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.gZk = intExtra;
            this.gZl = intExtra;
            this.gZm = intExtra;
        }
    }

    public void Z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.gZj);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.gZh) {
            if (System.nanoTime() - this.gZi > 300000000 && list != null && i < list.size()) {
                this.gZh.put(list.get(i), true);
            }
            this.gZi = System.nanoTime();
            if (list != null && i2 < list.size() && this.gZh.get(list.get(i2)) == null) {
                this.gZh.put(list.get(i2), false);
            }
        }
        if (this.gZh.size() >= 100) {
            bJb();
        }
    }

    public void bJb() {
        if (this.gZh != null) {
            synchronized (this.gZh) {
                if (this.gZh.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.gZh.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.gZh.size(), this.gZj, this.gZk + 1, this.gZl + 1);
                    this.gZh.clear();
                }
            }
        }
    }

    public void as(int i, String str) {
        if (i == 1 && System.nanoTime() - this.gZi > 300000000) {
            this.gZh.put(str, true);
        }
    }

    public void d(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.gZm == this.gZl) {
            sb.append(this.gZm + 1);
            if (this.gZl == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.gZm; i2 <= this.gZl; i2++) {
                if (i2 == this.gZl) {
                    sb.append(i2 + 1);
                    if (this.gZl == i - 1) {
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
            anVar.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cfM);
        }
        anVar.P("pic_count", i);
        anVar.bT("obj_floors", sb.toString());
        anVar.bT("obj_isads", sb2.toString());
        int i3 = (this.gZl - this.gZm) + 1;
        if (i3 == 1) {
            if (this.gZl == i - 1) {
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
            if (this.gZl == i - 1) {
                sb3.append(str);
            }
            anVar.bT("obj_ids", str);
        }
        TiebaStatic.log(anVar);
    }
}
