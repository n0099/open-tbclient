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
    private String erN;
    private int erO;
    private int erP;
    private long erM = 0;
    private HashMap<String, Boolean> erL = new HashMap<>();

    public void ol(int i) {
        this.erP = i;
    }

    public int aJz() {
        return this.erP;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.erN = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.erN = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.erO = intExtra;
            this.erP = intExtra;
        }
    }

    public void v(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.erN);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.erL) {
            if (System.nanoTime() - this.erM > 300000000 && list != null && i < list.size()) {
                this.erL.put(list.get(i), true);
            }
            this.erM = System.nanoTime();
            if (list != null && i2 < list.size() && this.erL.get(list.get(i2)) == null) {
                this.erL.put(list.get(i2), false);
            }
        }
        if (this.erL.size() >= 100) {
            aJA();
        }
    }

    public void aJA() {
        if (this.erL != null) {
            synchronized (this.erL) {
                if (this.erL.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.erL.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.erL.size(), this.erN, this.erO + 1, this.erP + 1);
                    this.erL.clear();
                }
            }
        }
    }

    public void Z(int i, String str) {
        if (i == 1 && System.nanoTime() - this.erM > 300000000) {
            this.erL.put(str, true);
        }
    }
}
