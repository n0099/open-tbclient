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
    private String eKI;
    private int eKJ;
    private int eKK;
    private long eKH = 0;
    private HashMap<String, Boolean> eKG = new HashMap<>();

    public void oT(int i) {
        this.eKK = i;
    }

    public int aPY() {
        return this.eKK;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eKI = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eKI = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eKJ = intExtra;
            this.eKK = intExtra;
        }
    }

    public void w(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eKI);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.eKG) {
            if (System.nanoTime() - this.eKH > 300000000 && list != null && i < list.size()) {
                this.eKG.put(list.get(i), true);
            }
            this.eKH = System.nanoTime();
            if (list != null && i2 < list.size() && this.eKG.get(list.get(i2)) == null) {
                this.eKG.put(list.get(i2), false);
            }
        }
        if (this.eKG.size() >= 100) {
            aPZ();
        }
    }

    public void aPZ() {
        if (this.eKG != null) {
            synchronized (this.eKG) {
                if (this.eKG.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eKG.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eKG.size(), this.eKI, this.eKJ + 1, this.eKK + 1);
                    this.eKG.clear();
                }
            }
        }
    }

    public void Y(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eKH > 300000000) {
            this.eKG.put(str, true);
        }
    }
}
