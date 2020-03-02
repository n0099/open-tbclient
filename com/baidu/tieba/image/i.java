package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes8.dex */
public class i {
    private String hSA;
    private int hSB;
    private int hSC;
    private int hSD;
    private long hSz = 0;
    private HashMap<String, Boolean> hSy = new HashMap<>();

    public void xh(int i) {
        this.hSC = i;
    }

    public int caI() {
        return this.hSC;
    }

    public void xi(int i) {
        this.hSD = i;
    }

    public int caJ() {
        return this.hSD;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.hSA = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.hSA = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.hSB = intExtra;
            this.hSC = intExtra;
            this.hSD = intExtra;
        }
    }

    public void ar(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.hSA);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.hSy) {
            if (System.nanoTime() - this.hSz > 300000000 && list != null && i < list.size()) {
                this.hSy.put(list.get(i), true);
            }
            this.hSz = System.nanoTime();
            if (list != null && i2 < list.size() && this.hSy.get(list.get(i2)) == null) {
                this.hSy.put(list.get(i2), false);
            }
        }
        if (this.hSy.size() >= 100) {
            caK();
        }
    }

    public void caK() {
        if (this.hSy != null) {
            synchronized (this.hSy) {
                if (this.hSy.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.hSy.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.hSy.size(), this.hSA, this.hSB + 1, this.hSC + 1);
                    this.hSy.clear();
                }
            }
        }
    }

    public void aM(int i, String str) {
        if (i == 1 && System.nanoTime() - this.hSz > 300000000) {
            this.hSy.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.hSD == this.hSC) {
            sb.append(this.hSD + 1);
            if (this.hSC == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.hSD; i2 <= this.hSC; i2++) {
                if (i2 == this.hSC) {
                    sb.append(i2 + 1);
                    if (this.hSC == i - 1) {
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
        anVar.cy("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!aq.isEmpty(str2)) {
            anVar.cy("fid", str2);
        }
        if (!aq.isEmpty(str3)) {
            anVar.cy("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cy(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dlY);
        }
        anVar.X("pic_count", i);
        anVar.cy("obj_floors", sb.toString());
        anVar.cy("obj_isads", sb2.toString());
        int i3 = (this.hSC - this.hSD) + 1;
        if (i3 == 1) {
            if (this.hSC == i - 1) {
                anVar.cy("obj_id", str);
            } else {
                anVar.cy("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.hSC == i - 1) {
                sb3.append(str);
            }
            anVar.cy("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            anVar.cy("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            anVar.cy("second_dir", str5);
        }
        TiebaStatic.log(anVar);
    }
}
