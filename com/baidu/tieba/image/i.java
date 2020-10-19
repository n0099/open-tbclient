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
/* loaded from: classes21.dex */
public class i {
    private int kgA;
    private int kgB;
    private int kgC;
    private String kgz;
    private long kgy = 0;
    private HashMap<String, Boolean> kgx = new HashMap<>();

    public void Dk(int i) {
        this.kgB = i;
    }

    public int cSg() {
        return this.kgB;
    }

    public void Dl(int i) {
        this.kgC = i;
    }

    public int cSh() {
        return this.kgC;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.kgz = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.kgz = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.kgA = intExtra;
            this.kgB = intExtra;
            this.kgC = intExtra;
        }
    }

    public void ay(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.kgz);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.kgx) {
            if (System.nanoTime() - this.kgy > 300000000 && list != null && i < list.size()) {
                this.kgx.put(list.get(i), true);
            }
            this.kgy = System.nanoTime();
            if (list != null && i2 < list.size() && this.kgx.get(list.get(i2)) == null) {
                this.kgx.put(list.get(i2), false);
            }
        }
        if (this.kgx.size() >= 100) {
            cSi();
        }
    }

    public void cSi() {
        if (this.kgx != null) {
            synchronized (this.kgx) {
                if (this.kgx.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.kgx.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.kgx.size(), this.kgz, this.kgA + 1, this.kgB + 1);
                    this.kgx.clear();
                }
            }
        }
    }

    public void bx(int i, String str) {
        if (i == 1 && System.nanoTime() - this.kgy > 300000000) {
            this.kgx.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.kgC == this.kgB) {
            sb.append(this.kgC + 1);
            if (this.kgB == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.kgC; i2 <= this.kgB; i2++) {
                if (i2 == this.kgB) {
                    sb.append(i2 + 1);
                    if (this.kgB == i - 1) {
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
        aqVar.dK("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!at.isEmpty(str2)) {
            aqVar.dK("fid", str2);
        }
        if (!at.isEmpty(str3)) {
            aqVar.dK("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dK("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eOl);
        }
        aqVar.aj("pic_count", i);
        aqVar.dK("obj_floors", sb.toString());
        aqVar.dK("obj_isads", sb2.toString());
        int i3 = (this.kgB - this.kgC) + 1;
        if (i3 == 1) {
            if (this.kgB == i - 1) {
                aqVar.dK("obj_id", str);
            } else {
                aqVar.dK("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.kgB == i - 1) {
                sb3.append(str);
            }
            aqVar.dK("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dK("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            aqVar.dK("second_dir", str5);
        }
        TiebaStatic.log(aqVar);
    }
}
