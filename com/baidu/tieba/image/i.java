package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
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
    private String iTV;
    private int iTW;
    private int iTX;
    private int iTY;
    private long iTU = 0;
    private HashMap<String, Boolean> iTT = new HashMap<>();

    public void yz(int i) {
        this.iTX = i;
    }

    public int csn() {
        return this.iTX;
    }

    public void yA(int i) {
        this.iTY = i;
    }

    public int cso() {
        return this.iTY;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.iTV = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.iTV = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.iTW = intExtra;
            this.iTX = intExtra;
            this.iTY = intExtra;
        }
    }

    public void ax(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.iTV);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.iTT) {
            if (System.nanoTime() - this.iTU > 300000000 && list != null && i < list.size()) {
                this.iTT.put(list.get(i), true);
            }
            this.iTU = System.nanoTime();
            if (list != null && i2 < list.size() && this.iTT.get(list.get(i2)) == null) {
                this.iTT.put(list.get(i2), false);
            }
        }
        if (this.iTT.size() >= 100) {
            csp();
        }
    }

    public void csp() {
        if (this.iTT != null) {
            synchronized (this.iTT) {
                if (this.iTT.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.iTT.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.iTT.size(), this.iTV, this.iTW + 1, this.iTX + 1);
                    this.iTT.clear();
                }
            }
        }
    }

    public void bg(int i, String str) {
        if (i == 1 && System.nanoTime() - this.iTU > 300000000) {
            this.iTT.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.iTY == this.iTX) {
            sb.append(this.iTY + 1);
            if (this.iTX == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.iTY; i2 <= this.iTX; i2++) {
                if (i2 == this.iTX) {
                    sb.append(i2 + 1);
                    if (this.iTX == i - 1) {
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
        anVar.dh("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!aq.isEmpty(str2)) {
            anVar.dh("fid", str2);
        }
        if (!aq.isEmpty(str3)) {
            anVar.dh("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.dh("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().eaO);
        }
        anVar.ag("pic_count", i);
        anVar.dh("obj_floors", sb.toString());
        anVar.dh("obj_isads", sb2.toString());
        int i3 = (this.iTX - this.iTY) + 1;
        if (i3 == 1) {
            if (this.iTX == i - 1) {
                anVar.dh("obj_id", str);
            } else {
                anVar.dh("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.iTX == i - 1) {
                sb3.append(str);
            }
            anVar.dh("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            anVar.dh("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            anVar.dh("second_dir", str5);
        }
        TiebaStatic.log(anVar);
    }
}
