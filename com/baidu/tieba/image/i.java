package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class i {
    private String kSf;
    private int kSg;
    private int kSh;
    private int kSi;
    private long kSe = 0;
    private HashMap<String, Boolean> kSd = new HashMap<>();

    public void EX(int i) {
        this.kSh = i;
    }

    public int dcg() {
        return this.kSh;
    }

    public void EY(int i) {
        this.kSi = i;
    }

    public int dch() {
        return this.kSi;
    }

    public void a(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.kSf = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.kSf = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.kSg = intExtra;
            this.kSh = intExtra;
            this.kSi = intExtra;
        }
    }

    public void az(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.kSf);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.kSd) {
            if (System.nanoTime() - this.kSe > 300000000 && list != null && i < list.size()) {
                this.kSd.put(list.get(i), true);
            }
            this.kSe = System.nanoTime();
            if (list != null && i2 < list.size() && this.kSd.get(list.get(i2)) == null) {
                this.kSd.put(list.get(i2), false);
            }
        }
        if (this.kSd.size() >= 100) {
            dci();
        }
    }

    public void dci() {
        if (this.kSd != null) {
            synchronized (this.kSd) {
                if (this.kSd.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.kSd.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.kSd.size(), this.kSf, this.kSg + 1, this.kSh + 1);
                    this.kSd.clear();
                }
            }
        }
    }

    public void bA(int i, String str) {
        if (i == 1 && System.nanoTime() - this.kSe > 300000000) {
            this.kSd.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.kSi == this.kSh) {
            sb.append(this.kSi + 1);
            if (this.kSh == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.kSi; i2 <= this.kSh; i2++) {
                if (i2 == this.kSh) {
                    sb.append(i2 + 1);
                    if (this.kSh == i - 1) {
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
        aq aqVar = new aq("common_exp");
        aqVar.dX("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!at.isEmpty(str2)) {
            aqVar.dX("fid", str2);
        }
        if (!at.isEmpty(str3)) {
            aqVar.dX("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dX("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fsN);
        }
        aqVar.an("pic_count", i);
        aqVar.dX("obj_floors", sb.toString());
        aqVar.dX("obj_isads", sb2.toString());
        int i3 = (this.kSh - this.kSi) + 1;
        if (i3 == 1) {
            if (this.kSh == i - 1) {
                aqVar.dX("obj_id", str);
            } else {
                aqVar.dX("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.kSh == i - 1) {
                sb3.append(str);
            }
            aqVar.dX("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dX("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            aqVar.dX("second_dir", str5);
        }
        TiebaStatic.log(aqVar);
    }
}
