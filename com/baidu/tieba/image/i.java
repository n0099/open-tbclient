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
/* loaded from: classes20.dex */
public class i {
    private String jRA;
    private int jRB;
    private int jRC;
    private int jRD;
    private long jRz = 0;
    private HashMap<String, Boolean> jRy = new HashMap<>();

    public void CE(int i) {
        this.jRC = i;
    }

    public int cOy() {
        return this.jRC;
    }

    public void CF(int i) {
        this.jRD = i;
    }

    public int cOz() {
        return this.jRD;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.jRA = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.jRA = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.jRB = intExtra;
            this.jRC = intExtra;
            this.jRD = intExtra;
        }
    }

    public void ay(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.jRA);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.jRy) {
            if (System.nanoTime() - this.jRz > 300000000 && list != null && i < list.size()) {
                this.jRy.put(list.get(i), true);
            }
            this.jRz = System.nanoTime();
            if (list != null && i2 < list.size() && this.jRy.get(list.get(i2)) == null) {
                this.jRy.put(list.get(i2), false);
            }
        }
        if (this.jRy.size() >= 100) {
            cOA();
        }
    }

    public void cOA() {
        if (this.jRy != null) {
            synchronized (this.jRy) {
                if (this.jRy.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.jRy.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.jRy.size(), this.jRA, this.jRB + 1, this.jRC + 1);
                    this.jRy.clear();
                }
            }
        }
    }

    public void bn(int i, String str) {
        if (i == 1 && System.nanoTime() - this.jRz > 300000000) {
            this.jRy.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.jRD == this.jRC) {
            sb.append(this.jRD + 1);
            if (this.jRC == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.jRD; i2 <= this.jRC; i2++) {
                if (i2 == this.jRC) {
                    sb.append(i2 + 1);
                    if (this.jRC == i - 1) {
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
        aqVar.dF("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!at.isEmpty(str2)) {
            aqVar.dF("fid", str2);
        }
        if (!at.isEmpty(str3)) {
            aqVar.dF("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aqVar.dF("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eCe);
        }
        aqVar.ai("pic_count", i);
        aqVar.dF("obj_floors", sb.toString());
        aqVar.dF("obj_isads", sb2.toString());
        int i3 = (this.jRC - this.jRD) + 1;
        if (i3 == 1) {
            if (this.jRC == i - 1) {
                aqVar.dF("obj_id", str);
            } else {
                aqVar.dF("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.jRC == i - 1) {
                sb3.append(str);
            }
            aqVar.dF("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            aqVar.dF("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            aqVar.dF("second_dir", str5);
        }
        TiebaStatic.log(aqVar);
    }
}
