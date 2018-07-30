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
    private String eKN;
    private int eKO;
    private int eKP;
    private long eKM = 0;
    private HashMap<String, Boolean> eKL = new HashMap<>();

    public void oT(int i) {
        this.eKP = i;
    }

    public int aQb() {
        return this.eKP;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eKN = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eKN = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eKO = intExtra;
            this.eKP = intExtra;
        }
    }

    public void w(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eKN);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.eKL) {
            if (System.nanoTime() - this.eKM > 300000000 && list != null && i < list.size()) {
                this.eKL.put(list.get(i), true);
            }
            this.eKM = System.nanoTime();
            if (list != null && i2 < list.size() && this.eKL.get(list.get(i2)) == null) {
                this.eKL.put(list.get(i2), false);
            }
        }
        if (this.eKL.size() >= 100) {
            aQc();
        }
    }

    public void aQc() {
        if (this.eKL != null) {
            synchronized (this.eKL) {
                if (this.eKL.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eKL.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eKL.size(), this.eKN, this.eKO + 1, this.eKP + 1);
                    this.eKL.clear();
                }
            }
        }
    }

    public void Y(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eKM > 300000000) {
            this.eKL.put(str, true);
        }
    }
}
