package com.baidu.tieba.image;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class i {
    private String eZL;
    private int eZM;
    private int eZN;
    private long eZK = 0;
    private HashMap<String, Boolean> eZJ = new HashMap<>();

    public void pV(int i) {
        this.eZN = i;
    }

    public int aVA() {
        return this.eZN;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eZL = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eZL = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eZM = intExtra;
            this.eZN = intExtra;
        }
    }

    public void x(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eZL);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.eZJ) {
            if (System.nanoTime() - this.eZK > 300000000 && list != null && i < list.size()) {
                this.eZJ.put(list.get(i), true);
            }
            this.eZK = System.nanoTime();
            if (list != null && i2 < list.size() && this.eZJ.get(list.get(i2)) == null) {
                this.eZJ.put(list.get(i2), false);
            }
        }
        if (this.eZJ.size() >= 100) {
            aVB();
        }
    }

    public void aVB() {
        if (this.eZJ != null) {
            synchronized (this.eZJ) {
                if (this.eZJ.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eZJ.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eZJ.size(), this.eZL, this.eZM + 1, this.eZN + 1);
                    this.eZJ.clear();
                }
            }
        }
    }

    public void Y(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eZK > 300000000) {
            this.eZJ.put(str, true);
        }
    }
}
