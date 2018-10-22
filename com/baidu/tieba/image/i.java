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
    private String eZM;
    private int eZN;
    private int eZO;
    private long eZL = 0;
    private HashMap<String, Boolean> eZK = new HashMap<>();

    public void pV(int i) {
        this.eZO = i;
    }

    public int aVA() {
        return this.eZO;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eZM = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eZM = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eZN = intExtra;
            this.eZO = intExtra;
        }
    }

    public void x(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eZM);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.eZK) {
            if (System.nanoTime() - this.eZL > 300000000 && list != null && i < list.size()) {
                this.eZK.put(list.get(i), true);
            }
            this.eZL = System.nanoTime();
            if (list != null && i2 < list.size() && this.eZK.get(list.get(i2)) == null) {
                this.eZK.put(list.get(i2), false);
            }
        }
        if (this.eZK.size() >= 100) {
            aVB();
        }
    }

    public void aVB() {
        if (this.eZK != null) {
            synchronized (this.eZK) {
                if (this.eZK.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eZK.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eZK.size(), this.eZM, this.eZN + 1, this.eZO + 1);
                    this.eZK.clear();
                }
            }
        }
    }

    public void Y(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eZL > 300000000) {
            this.eZK.put(str, true);
        }
    }
}
