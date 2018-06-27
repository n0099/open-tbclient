package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class h {
    private String eGT;
    private int eGU;
    private int eGV;
    private long eGS = 0;
    private HashMap<String, Boolean> eGR = new HashMap<>();

    public void oE(int i) {
        this.eGV = i;
    }

    public int aPb() {
        return this.eGV;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eGT = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eGT = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eGU = intExtra;
            this.eGV = intExtra;
        }
    }

    public void w(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eGT);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.eGR) {
            if (System.nanoTime() - this.eGS > 300000000 && list != null && i < list.size()) {
                this.eGR.put(list.get(i), true);
            }
            this.eGS = System.nanoTime();
            if (list != null && i2 < list.size() && this.eGR.get(list.get(i2)) == null) {
                this.eGR.put(list.get(i2), false);
            }
        }
        if (this.eGR.size() >= 100) {
            aPc();
        }
    }

    public void aPc() {
        if (this.eGR != null) {
            synchronized (this.eGR) {
                if (this.eGR.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eGR.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eGR.size(), this.eGT, this.eGU + 1, this.eGV + 1);
                    this.eGR.clear();
                }
            }
        }
    }

    public void W(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eGS > 300000000) {
            this.eGR.put(str, true);
        }
    }
}
