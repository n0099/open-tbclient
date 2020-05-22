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
    private String iTi;
    private int iTj;
    private int iTk;
    private int iTl;
    private long iTh = 0;
    private HashMap<String, Boolean> iTg = new HashMap<>();

    public void yx(int i) {
        this.iTk = i;
    }

    public int cse() {
        return this.iTk;
    }

    public void yy(int i) {
        this.iTl = i;
    }

    public int csf() {
        return this.iTl;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.iTi = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.iTi = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.iTj = intExtra;
            this.iTk = intExtra;
            this.iTl = intExtra;
        }
    }

    public void ax(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.iTi);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.iTg) {
            if (System.nanoTime() - this.iTh > 300000000 && list != null && i < list.size()) {
                this.iTg.put(list.get(i), true);
            }
            this.iTh = System.nanoTime();
            if (list != null && i2 < list.size() && this.iTg.get(list.get(i2)) == null) {
                this.iTg.put(list.get(i2), false);
            }
        }
        if (this.iTg.size() >= 100) {
            csg();
        }
    }

    public void csg() {
        if (this.iTg != null) {
            synchronized (this.iTg) {
                if (this.iTg.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.iTg.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.iTg.size(), this.iTi, this.iTj + 1, this.iTk + 1);
                    this.iTg.clear();
                }
            }
        }
    }

    public void bg(int i, String str) {
        if (i == 1 && System.nanoTime() - this.iTh > 300000000) {
            this.iTg.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.iTl == this.iTk) {
            sb.append(this.iTl + 1);
            if (this.iTk == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.iTl; i2 <= this.iTk; i2++) {
                if (i2 == this.iTk) {
                    sb.append(i2 + 1);
                    if (this.iTk == i - 1) {
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
        int i3 = (this.iTk - this.iTl) + 1;
        if (i3 == 1) {
            if (this.iTk == i - 1) {
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
            if (this.iTk == i - 1) {
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
