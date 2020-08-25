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
/* loaded from: classes15.dex */
public class i {
    private String jIU;
    private int jIV;
    private int jIW;
    private int jIX;
    private long jIT = 0;
    private HashMap<String, Boolean> jIS = new HashMap<>();

    public void Cd(int i) {
        this.jIW = i;
    }

    public int cKR() {
        return this.jIW;
    }

    public void Ce(int i) {
        this.jIX = i;
    }

    public int cKS() {
        return this.jIX;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.jIU = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.jIU = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.jIV = intExtra;
            this.jIW = intExtra;
            this.jIX = intExtra;
        }
    }

    public void ay(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.jIU);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.jIS) {
            if (System.nanoTime() - this.jIT > 300000000 && list != null && i < list.size()) {
                this.jIS.put(list.get(i), true);
            }
            this.jIT = System.nanoTime();
            if (list != null && i2 < list.size() && this.jIS.get(list.get(i2)) == null) {
                this.jIS.put(list.get(i2), false);
            }
        }
        if (this.jIS.size() >= 100) {
            cKT();
        }
    }

    public void cKT() {
        if (this.jIS != null) {
            synchronized (this.jIS) {
                if (this.jIS.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.jIS.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.jIS.size(), this.jIU, this.jIV + 1, this.jIW + 1);
                    this.jIS.clear();
                }
            }
        }
    }

    public void bk(int i, String str) {
        if (i == 1 && System.nanoTime() - this.jIT > 300000000) {
            this.jIS.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.jIX == this.jIW) {
            sb.append(this.jIX + 1);
            if (this.jIW == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.jIX; i2 <= this.jIW; i2++) {
                if (i2 == this.jIW) {
                    sb.append(i2 + 1);
                    if (this.jIW == i - 1) {
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
        aqVar.dD("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!at.isEmpty(str2)) {
            aqVar.dD("fid", str2);
        }
        if (!at.isEmpty(str3)) {
            aqVar.dD("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dD("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ezW);
        }
        aqVar.ai("pic_count", i);
        aqVar.dD("obj_floors", sb.toString());
        aqVar.dD("obj_isads", sb2.toString());
        int i3 = (this.jIW - this.jIX) + 1;
        if (i3 == 1) {
            if (this.jIW == i - 1) {
                aqVar.dD("obj_id", str);
            } else {
                aqVar.dD("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.jIW == i - 1) {
                sb3.append(str);
            }
            aqVar.dD("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dD("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            aqVar.dD("second_dir", str5);
        }
        TiebaStatic.log(aqVar);
    }
}
