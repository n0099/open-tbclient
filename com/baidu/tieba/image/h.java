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
    private String eVY;
    private int eVZ;
    private int eWa;
    private long eVX = 0;
    private HashMap<String, Boolean> eVW = new HashMap<>();

    public void qQ(int i) {
        this.eWa = i;
    }

    public int aOy() {
        return this.eWa;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eVY = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eVY = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eVZ = intExtra;
            this.eWa = intExtra;
        }
    }

    public void A(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eVY);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.eVW) {
            if (System.nanoTime() - this.eVX > 300000000 && list != null && i < list.size()) {
                this.eVW.put(list.get(i), true);
            }
            this.eVX = System.nanoTime();
            if (list != null && i2 < list.size() && this.eVW.get(list.get(i2)) == null) {
                this.eVW.put(list.get(i2), false);
            }
        }
        if (this.eVW.size() >= 100) {
            aOz();
        }
    }

    public void aOz() {
        if (this.eVW != null) {
            synchronized (this.eVW) {
                if (this.eVW.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eVW.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eVW.size(), this.eVY, this.eVZ + 1, this.eWa + 1);
                    this.eVW.clear();
                }
            }
        }
    }

    public void Q(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eVX > 300000000) {
            this.eVW.put(str, true);
        }
    }
}
