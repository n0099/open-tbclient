package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class i {
    private String hMX;
    private int hMY;
    private int hMZ;
    private int hNa;
    private long hMW = 0;
    private HashMap<String, Boolean> hMV = new HashMap<>();

    public void wW(int i) {
        this.hMZ = i;
    }

    public int bXW() {
        return this.hMZ;
    }

    public void wX(int i) {
        this.hNa = i;
    }

    public int bXX() {
        return this.hNa;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.hMX = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.hMX = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.hMY = intExtra;
            this.hMZ = intExtra;
            this.hNa = intExtra;
        }
    }

    public void ar(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.hMX);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.hMV) {
            if (System.nanoTime() - this.hMW > 300000000 && list != null && i < list.size()) {
                this.hMV.put(list.get(i), true);
            }
            this.hMW = System.nanoTime();
            if (list != null && i2 < list.size() && this.hMV.get(list.get(i2)) == null) {
                this.hMV.put(list.get(i2), false);
            }
        }
        if (this.hMV.size() >= 100) {
            bXY();
        }
    }

    public void bXY() {
        if (this.hMV != null) {
            synchronized (this.hMV) {
                if (this.hMV.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.hMV.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.hMV.size(), this.hMX, this.hMY + 1, this.hMZ + 1);
                    this.hMV.clear();
                }
            }
        }
    }

    public void aG(int i, String str) {
        if (i == 1 && System.nanoTime() - this.hMW > 300000000) {
            this.hMV.put(str, true);
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.hNa == this.hMZ) {
            sb.append(this.hNa + 1);
            if (this.hMZ == i - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        } else {
            for (int i2 = this.hNa; i2 <= this.hMZ; i2++) {
                if (i2 == this.hMZ) {
                    sb.append(i2 + 1);
                    if (this.hMZ == i - 1) {
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
        anVar.cp("page_type", PageStayDurationConstants.PageName.BIGIMAGE);
        if (!aq.isEmpty(str2)) {
            anVar.cp("fid", str2);
        }
        if (!aq.isEmpty(str3)) {
            anVar.cp("tid", str3);
        }
        if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
            anVar.cp(TiebaInitialize.Params.AB_TAG, TbadkCoreApplication.getInst().getAdAdSense().dhF);
        }
        anVar.Z("pic_count", i);
        anVar.cp("obj_floors", sb.toString());
        anVar.cp("obj_isads", sb2.toString());
        int i3 = (this.hMZ - this.hNa) + 1;
        if (i3 == 1) {
            if (this.hMZ == i - 1) {
                anVar.cp("obj_id", str);
            } else {
                anVar.cp("obj_id", "");
            }
        }
        if (i3 > 1) {
            StringBuilder sb3 = new StringBuilder();
            for (int i4 = 0; i4 < i3 - 1; i4++) {
                sb3.append("|");
            }
            if (this.hMZ == i - 1) {
                sb3.append(str);
            }
            anVar.cp("obj_ids", str);
        }
        if (!StringUtils.isNull(str4)) {
            anVar.cp("first_dir", str4);
        }
        if (!StringUtils.isNull(str5)) {
            anVar.cp("second_dir", str5);
        }
        TiebaStatic.log(anVar);
    }
}
