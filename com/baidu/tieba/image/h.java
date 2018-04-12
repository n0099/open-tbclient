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
    private String eqH;
    private int eqI;
    private int eqJ;
    private long eqG = 0;
    private HashMap<String, Boolean> eqF = new HashMap<>();

    public void on(int i) {
        this.eqJ = i;
    }

    public int aJA() {
        return this.eqJ;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eqH = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eqH = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eqI = intExtra;
            this.eqJ = intExtra;
        }
    }

    public void v(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eqH);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.eqF) {
            if (System.nanoTime() - this.eqG > 300000000 && list != null && i < list.size()) {
                this.eqF.put(list.get(i), true);
            }
            this.eqG = System.nanoTime();
            if (list != null && i2 < list.size() && this.eqF.get(list.get(i2)) == null) {
                this.eqF.put(list.get(i2), false);
            }
        }
        if (this.eqF.size() >= 100) {
            aJB();
        }
    }

    public void aJB() {
        if (this.eqF != null) {
            synchronized (this.eqF) {
                if (this.eqF.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eqF.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eqF.size(), this.eqH, this.eqI + 1, this.eqJ + 1);
                    this.eqF.clear();
                }
            }
        }
    }

    public void Z(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eqG > 300000000) {
            this.eqF.put(str, true);
        }
    }
}
