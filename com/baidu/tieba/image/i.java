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
/* loaded from: classes7.dex */
public class i {
    private String kNA;
    private int kNB;
    private int kNC;
    private int kND;
    private long kNz = 0;
    private HashMap<String, Boolean> kNy = new HashMap<>();

    public void Dr(int i) {
        this.kNC = i;
    }

    public int cYo() {
        return this.kNC;
    }

    public void Ds(int i) {
        this.kND = i;
    }

    public int cYp() {
        return this.kND;
    }

    public void a(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.kNA = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.kNA = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.kNB = intExtra;
            this.kNC = intExtra;
            this.kND = intExtra;
        }
    }

    public void az(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.kNA);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.kNy) {
            if (System.nanoTime() - this.kNz > 300000000 && list != null && i < list.size()) {
                this.kNy.put(list.get(i), true);
            }
            this.kNz = System.nanoTime();
            if (list != null && i2 < list.size() && this.kNy.get(list.get(i2)) == null) {
                this.kNy.put(list.get(i2), false);
            }
        }
        if (this.kNy.size() >= 100) {
            cYq();
        }
    }

    public void cYq() {
        if (this.kNy != null) {
            synchronized (this.kNy) {
                if (this.kNy.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.kNy.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.kNy.size(), this.kNA, this.kNB + 1, this.kNC + 1);
                    this.kNy.clear();
                }
            }
        }
    }

    public void bB(int i, String str) {
        if (i == 1 && System.nanoTime() - this.kNz > 300000000) {
            this.kNy.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.kND == this.kNC) {
            sb.append(this.kND + 1);
            if (this.kNC == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.kND; i2 <= this.kNC; i2++) {
                if (i2 == this.kNC) {
                    sb.append(i2 + 1);
                    if (this.kNC == i - 1) {
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
        aqVar.dW("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!at.isEmpty(str2)) {
            aqVar.dW("fid", str2);
        }
        if (!at.isEmpty(str3)) {
            aqVar.dW("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dW("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().foc);
        }
        aqVar.an("pic_count", i);
        aqVar.dW("obj_floors", sb.toString());
        aqVar.dW("obj_isads", sb2.toString());
        int i3 = (this.kNC - this.kND) + 1;
        if (i3 == 1) {
            if (this.kNC == i - 1) {
                aqVar.dW("obj_id", str);
            } else {
                aqVar.dW("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.kNC == i - 1) {
                sb3.append(str);
            }
            aqVar.dW("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dW("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            aqVar.dW("second_dir", str5);
        }
        TiebaStatic.log(aqVar);
    }
}
