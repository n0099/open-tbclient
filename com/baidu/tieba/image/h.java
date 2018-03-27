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
    private String eWa;
    private int eWb;
    private int eWc;
    private long eVZ = 0;
    private HashMap<String, Boolean> eVY = new HashMap<>();

    public void qR(int i) {
        this.eWc = i;
    }

    public int aOy() {
        return this.eWc;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eWa = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eWa = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eWb = intExtra;
            this.eWc = intExtra;
        }
    }

    public void A(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eWa);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.eVY) {
            if (System.nanoTime() - this.eVZ > 300000000 && list != null && i < list.size()) {
                this.eVY.put(list.get(i), true);
            }
            this.eVZ = System.nanoTime();
            if (list != null && i2 < list.size() && this.eVY.get(list.get(i2)) == null) {
                this.eVY.put(list.get(i2), false);
            }
        }
        if (this.eVY.size() >= 100) {
            aOz();
        }
    }

    public void aOz() {
        if (this.eVY != null) {
            synchronized (this.eVY) {
                if (this.eVY.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eVY.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eVY.size(), this.eWa, this.eWb + 1, this.eWc + 1);
                    this.eVY.clear();
                }
            }
        }
    }

    public void Q(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eVZ > 300000000) {
            this.eVY.put(str, true);
        }
    }
}
