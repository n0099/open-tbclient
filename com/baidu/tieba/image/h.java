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
    private String eqE;
    private int eqF;
    private int eqG;
    private long eqD = 0;
    private HashMap<String, Boolean> eqC = new HashMap<>();

    public void om(int i) {
        this.eqG = i;
    }

    public int aJA() {
        return this.eqG;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eqE = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eqE = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eqF = intExtra;
            this.eqG = intExtra;
        }
    }

    public void v(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eqE);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.eqC) {
            if (System.nanoTime() - this.eqD > 300000000 && list != null && i < list.size()) {
                this.eqC.put(list.get(i), true);
            }
            this.eqD = System.nanoTime();
            if (list != null && i2 < list.size() && this.eqC.get(list.get(i2)) == null) {
                this.eqC.put(list.get(i2), false);
            }
        }
        if (this.eqC.size() >= 100) {
            aJB();
        }
    }

    public void aJB() {
        if (this.eqC != null) {
            synchronized (this.eqC) {
                if (this.eqC.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eqC.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eqC.size(), this.eqE, this.eqF + 1, this.eqG + 1);
                    this.eqC.clear();
                }
            }
        }
    }

    public void Z(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eqD > 300000000) {
            this.eqC.put(str, true);
        }
    }
}
