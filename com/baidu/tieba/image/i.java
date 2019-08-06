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
    private String hab;
    private int hac;
    private int had;
    private int hae;
    private long haa = 0;
    private HashMap<String, Boolean> gZZ = new HashMap<>();

    public void wn(int i) {
        this.had = i;
    }

    public int bJn() {
        return this.had;
    }

    public void wo(int i) {
        this.hae = i;
    }

    public int bJo() {
        return this.hae;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.hab = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.hab = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.hac = intExtra;
            this.had = intExtra;
            this.hae = intExtra;
        }
    }

    public void Z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.hab);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.gZZ) {
            if (System.nanoTime() - this.haa > 300000000 && list != null && i < list.size()) {
                this.gZZ.put(list.get(i), true);
            }
            this.haa = System.nanoTime();
            if (list != null && i2 < list.size() && this.gZZ.get(list.get(i2)) == null) {
                this.gZZ.put(list.get(i2), false);
            }
        }
        if (this.gZZ.size() >= 100) {
            bJp();
        }
    }

    public void bJp() {
        if (this.gZZ != null) {
            synchronized (this.gZZ) {
                if (this.gZZ.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.gZZ.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.gZZ.size(), this.hab, this.hac + 1, this.had + 1);
                    this.gZZ.clear();
                }
            }
        }
    }

    public void as(int i, String str) {
        if (i == 1 && System.nanoTime() - this.haa > 300000000) {
            this.gZZ.put(str, true);
        }
    }

    public void d(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.hae == this.had) {
            sb.append(this.hae + 1);
            if (this.had == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.hae; i2 <= this.had; i2++) {
                if (i2 == this.had) {
                    sb.append(i2 + 1);
                    if (this.had == i - 1) {
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
            anVar.bT("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().cfT);
        }
        anVar.P("pic_count", i);
        anVar.bT("obj_floors", sb.toString());
        anVar.bT("obj_isads", sb2.toString());
        int i3 = (this.had - this.hae) + 1;
        if (i3 == 1) {
            if (this.had == i - 1) {
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
            if (this.had == i - 1) {
                sb3.append(str);
            }
            anVar.bT("obj_ids", str);
        }
        TiebaStatic.log(anVar);
    }
}
