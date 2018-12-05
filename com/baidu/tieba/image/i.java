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
    private String fhW;
    private int fhX;
    private int fhY;
    private long fhV = 0;
    private HashMap<String, Boolean> fhU = new HashMap<>();

    public void qI(int i) {
        this.fhY = i;
    }

    public int aWP() {
        return this.fhY;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.fhW = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.fhW = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.fhX = intExtra;
            this.fhY = intExtra;
        }
    }

    public void D(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.fhW);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.fhU) {
            if (System.nanoTime() - this.fhV > 300000000 && list != null && i < list.size()) {
                this.fhU.put(list.get(i), true);
            }
            this.fhV = System.nanoTime();
            if (list != null && i2 < list.size() && this.fhU.get(list.get(i2)) == null) {
                this.fhU.put(list.get(i2), false);
            }
        }
        if (this.fhU.size() >= 100) {
            aWQ();
        }
    }

    public void aWQ() {
        if (this.fhU != null) {
            synchronized (this.fhU) {
                if (this.fhU.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.fhU.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.fhU.size(), this.fhW, this.fhX + 1, this.fhY + 1);
                    this.fhU.clear();
                }
            }
        }
    }

    public void U(int i, String str) {
        if (i == 1 && System.nanoTime() - this.fhV > 300000000) {
            this.fhU.put(str, true);
        }
    }
}
