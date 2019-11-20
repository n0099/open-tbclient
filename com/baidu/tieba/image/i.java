package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class i {
    private String gZh;
    private int gZi;
    private int gZj;
    private int gZk;
    private long gZg = 0;
    private HashMap<String, Boolean> gZf = new HashMap<>();

    public void uV(int i) {
        this.gZj = i;
    }

    public int bGI() {
        return this.gZj;
    }

    public void uW(int i) {
        this.gZk = i;
    }

    public int bGJ() {
        return this.gZk;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.gZh = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.gZh = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.gZi = intExtra;
            this.gZj = intExtra;
            this.gZk = intExtra;
        }
    }

    public void Y(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.gZh);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.gZf) {
            if (System.nanoTime() - this.gZg > 300000000 && list != null && i < list.size()) {
                this.gZf.put(list.get(i), true);
            }
            this.gZg = System.nanoTime();
            if (list != null && i2 < list.size() && this.gZf.get(list.get(i2)) == null) {
                this.gZf.put(list.get(i2), false);
            }
        }
        if (this.gZf.size() >= 100) {
            bGK();
        }
    }

    public void bGK() {
        if (this.gZf != null) {
            synchronized (this.gZf) {
                if (this.gZf.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.gZf.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.gZf.size(), this.gZh, this.gZi + 1, this.gZj + 1);
                    this.gZf.clear();
                }
            }
        }
    }

    public void ar(int i, String str) {
        if (i == 1 && System.nanoTime() - this.gZg > 300000000) {
            this.gZf.put(str, true);
        }
    }

    public void e(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.gZk == this.gZj) {
            sb.append(this.gZk + 1);
            if (this.gZj == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.gZk; i2 <= this.gZj; i2++) {
                if (i2 == this.gZj) {
                    sb.append(i2 + 1);
                    if (this.gZj == i - 1) {
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
        anVar.bS("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!aq.isEmpty(str2)) {
            anVar.bS("fid", str2);
        }
        if (!aq.isEmpty(str3)) {
            anVar.bS("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().ctT);
        }
        anVar.O("pic_count", i);
        anVar.bS("obj_floors", sb.toString());
        anVar.bS("obj_isads", sb2.toString());
        int i3 = (this.gZj - this.gZk) + 1;
        if (i3 == 1) {
            if (this.gZj == i - 1) {
                anVar.bS("obj_id", str);
            } else {
                anVar.bS("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.gZj == i - 1) {
                sb3.append(str);
            }
            anVar.bS("obj_ids", str);
        }
        TiebaStatic.log(anVar);
    }
}
