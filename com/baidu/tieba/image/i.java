package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class i {
    private String jlh;
    private int jli;
    private int jlj;
    private int jlk;
    private long jlg = 0;
    private HashMap<String, Boolean> jlf = new HashMap<>();

    public void zl(int i) {
        this.jlj = i;
    }

    public int cwd() {
        return this.jlj;
    }

    public void zm(int i) {
        this.jlk = i;
    }

    public int cwe() {
        return this.jlk;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.jlh = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.jlh = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.jli = intExtra;
            this.jlj = intExtra;
            this.jlk = intExtra;
        }
    }

    public void ay(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.jlh);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.jlf) {
            if (System.nanoTime() - this.jlg > 300000000 && list != null && i < list.size()) {
                this.jlf.put(list.get(i), true);
            }
            this.jlg = System.nanoTime();
            if (list != null && i2 < list.size() && this.jlf.get(list.get(i2)) == null) {
                this.jlf.put(list.get(i2), false);
            }
        }
        if (this.jlf.size() >= 100) {
            cwf();
        }
    }

    public void cwf() {
        if (this.jlf != null) {
            synchronized (this.jlf) {
                if (this.jlf.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.jlf.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.jlf.size(), this.jlh, this.jli + 1, this.jlj + 1);
                    this.jlf.clear();
                }
            }
        }
    }

    public void bk(int i, String str) {
        if (i == 1 && System.nanoTime() - this.jlg > 300000000) {
            this.jlf.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.jlk == this.jlj) {
            sb.append(this.jlk + 1);
            if (this.jlj == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.jlk; i2 <= this.jlj; i2++) {
                if (i2 == this.jlj) {
                    sb.append(i2 + 1);
                    if (this.jlj == i - 1) {
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
        ao aoVar = new ao("common_exp");
        aoVar.dk("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!ar.isEmpty(str2)) {
            aoVar.dk("fid", str2);
        }
        if (!ar.isEmpty(str3)) {
            aoVar.dk("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            aoVar.dk("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().ejy);
        }
        aoVar.ag("pic_count", i);
        aoVar.dk("obj_floors", sb.toString());
        aoVar.dk("obj_isads", sb2.toString());
        int i3 = (this.jlj - this.jlk) + 1;
        if (i3 == 1) {
            if (this.jlj == i - 1) {
                aoVar.dk("obj_id", str);
            } else {
                aoVar.dk("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.jlj == i - 1) {
                sb3.append(str);
            }
            aoVar.dk("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            aoVar.dk("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            aoVar.dk("second_dir", str5);
        }
        TiebaStatic.log(aoVar);
    }
}
