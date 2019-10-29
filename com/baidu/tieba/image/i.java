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
    private String gZY;
    private int gZZ;
    private int haa;
    private int hab;
    private long gZX = 0;
    private HashMap<String, Boolean> gZW = new HashMap<>();

    public void uW(int i) {
        this.haa = i;
    }

    public int bGK() {
        return this.haa;
    }

    public void uX(int i) {
        this.hab = i;
    }

    public int bGL() {
        return this.hab;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.gZY = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.gZY = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.gZZ = intExtra;
            this.haa = intExtra;
            this.hab = intExtra;
        }
    }

    public void Y(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.gZY);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.gZW) {
            if (System.nanoTime() - this.gZX > 300000000 && list != null && i < list.size()) {
                this.gZW.put(list.get(i), true);
            }
            this.gZX = System.nanoTime();
            if (list != null && i2 < list.size() && this.gZW.get(list.get(i2)) == null) {
                this.gZW.put(list.get(i2), false);
            }
        }
        if (this.gZW.size() >= 100) {
            bGM();
        }
    }

    public void bGM() {
        if (this.gZW != null) {
            synchronized (this.gZW) {
                if (this.gZW.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.gZW.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.gZW.size(), this.gZY, this.gZZ + 1, this.haa + 1);
                    this.gZW.clear();
                }
            }
        }
    }

    public void as(int i, String str) {
        if (i == 1 && System.nanoTime() - this.gZX > 300000000) {
            this.gZW.put(str, true);
        }
    }

    public void e(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.hab == this.haa) {
            sb.append(this.hab + 1);
            if (this.haa == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.hab; i2 <= this.haa; i2++) {
                if (i2 == this.haa) {
                    sb.append(i2 + 1);
                    if (this.haa == i - 1) {
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
            anVar.bS(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().cuL);
        }
        anVar.O("pic_count", i);
        anVar.bS("obj_floors", sb.toString());
        anVar.bS("obj_isads", sb2.toString());
        int i3 = (this.haa - this.hab) + 1;
        if (i3 == 1) {
            if (this.haa == i - 1) {
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
            if (this.haa == i - 1) {
                sb3.append(str);
            }
            anVar.bS("obj_ids", str);
        }
        TiebaStatic.log(anVar);
    }
}
