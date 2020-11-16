package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes20.dex */
public class g {
    private String kzi;
    private int kzj;
    private int kzk;
    private int kzl;
    private long kzh = 0;
    private HashMap<String, Boolean> kzg = new HashMap<>();

    public void Eo(int i) {
        this.kzk = i;
    }

    public int cXk() {
        return this.kzk;
    }

    public void Ep(int i) {
        this.kzl = i;
    }

    public int cXl() {
        return this.kzl;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.kzi = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.kzi = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.kzj = intExtra;
            this.kzk = intExtra;
            this.kzl = intExtra;
        }
    }

    public void ay(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.kzi);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.kzg) {
            if (System.nanoTime() - this.kzh > 300000000 && list != null && i < list.size()) {
                this.kzg.put(list.get(i), true);
            }
            this.kzh = System.nanoTime();
            if (list != null && i2 < list.size() && this.kzg.get(list.get(i2)) == null) {
                this.kzg.put(list.get(i2), false);
            }
        }
        if (this.kzg.size() >= 100) {
            cXm();
        }
    }

    public void cXm() {
        if (this.kzg != null) {
            synchronized (this.kzg) {
                if (this.kzg.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.kzg.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.kzg.size(), this.kzi, this.kzj + 1, this.kzk + 1);
                    this.kzg.clear();
                }
            }
        }
    }

    public void bA(int i, String str) {
        if (i == 1 && System.nanoTime() - this.kzh > 300000000) {
            this.kzg.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.kzl == this.kzk) {
            sb.append(this.kzl + 1);
            if (this.kzk == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.kzl; i2 <= this.kzk; i2++) {
                if (i2 == this.kzk) {
                    sb.append(i2 + 1);
                    if (this.kzk == i - 1) {
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
        ar arVar = new ar("common_exp");
        arVar.dR("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!au.isEmpty(str2)) {
            arVar.dR("fid", str2);
        }
        if (!au.isEmpty(str3)) {
            arVar.dR("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            arVar.dR("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().fbE);
        }
        arVar.ak("pic_count", i);
        arVar.dR("obj_floors", sb.toString());
        arVar.dR("obj_isads", sb2.toString());
        int i3 = (this.kzk - this.kzl) + 1;
        if (i3 == 1) {
            if (this.kzk == i - 1) {
                arVar.dR("obj_id", str);
            } else {
                arVar.dR("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.kzk == i - 1) {
                sb3.append(str);
            }
            arVar.dR("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            arVar.dR("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            arVar.dR("second_dir", str5);
        }
        TiebaStatic.log(arVar);
    }
}
