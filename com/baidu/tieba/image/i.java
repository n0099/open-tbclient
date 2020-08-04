package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes15.dex */
public class i {
    private String jtO;
    private int jtP;
    private int jtQ;
    private int jtR;
    private long jtN = 0;
    private HashMap<String, Boolean> jtM = new HashMap<>();

    public void zK(int i) {
        this.jtQ = i;
    }

    public int cAb() {
        return this.jtQ;
    }

    public void zL(int i) {
        this.jtR = i;
    }

    public int cAc() {
        return this.jtR;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.jtO = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.jtO = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.jtP = intExtra;
            this.jtQ = intExtra;
            this.jtR = intExtra;
        }
    }

    public void az(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.jtO);
        }
    }

    public void g(List<String> list, int i, int i2) {
        synchronized (this.jtM) {
            if (System.nanoTime() - this.jtN > 300000000 && list != null && i < list.size()) {
                this.jtM.put(list.get(i), true);
            }
            this.jtN = System.nanoTime();
            if (list != null && i2 < list.size() && this.jtM.get(list.get(i2)) == null) {
                this.jtM.put(list.get(i2), false);
            }
        }
        if (this.jtM.size() >= 100) {
            cAd();
        }
    }

    public void cAd() {
        if (this.jtM != null) {
            synchronized (this.jtM) {
                if (this.jtM.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.jtM.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.jtM.size(), this.jtO, this.jtP + 1, this.jtQ + 1);
                    this.jtM.clear();
                }
            }
        }
    }

    public void bm(int i, String str) {
        if (i == 1 && System.nanoTime() - this.jtN > 300000000) {
            this.jtM.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.jtR == this.jtQ) {
            sb.append(this.jtR + 1);
            if (this.jtQ == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.jtR; i2 <= this.jtQ; i2++) {
                if (i2 == this.jtQ) {
                    sb.append(i2 + 1);
                    if (this.jtQ == i - 1) {
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
        ap apVar = new ap("common_exp");
        apVar.dn("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!as.isEmpty(str2)) {
            apVar.dn("fid", str2);
        }
        if (!as.isEmpty(str3)) {
            apVar.dn("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            apVar.dn("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().epK);
        }
        apVar.ah("pic_count", i);
        apVar.dn("obj_floors", sb.toString());
        apVar.dn("obj_isads", sb2.toString());
        int i3 = (this.jtQ - this.jtR) + 1;
        if (i3 == 1) {
            if (this.jtQ == i - 1) {
                apVar.dn("obj_id", str);
            } else {
                apVar.dn("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.jtQ == i - 1) {
                sb3.append(str);
            }
            apVar.dn("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            apVar.dn("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            apVar.dn("second_dir", str5);
        }
        TiebaStatic.log(apVar);
    }
}
