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
    private String eDd;
    private int eDe;
    private int eDf;
    private long eDc = 0;
    private HashMap<String, Boolean> eDb = new HashMap<>();

    public void ox(int i) {
        this.eDf = i;
    }

    public int aOv() {
        return this.eDf;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eDd = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eDd = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eDe = intExtra;
            this.eDf = intExtra;
        }
    }

    public void w(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eDd);
        }
    }

    public void d(List<String> list, int i, int i2) {
        synchronized (this.eDb) {
            if (System.nanoTime() - this.eDc > 300000000 && list != null && i < list.size()) {
                this.eDb.put(list.get(i), true);
            }
            this.eDc = System.nanoTime();
            if (list != null && i2 < list.size() && this.eDb.get(list.get(i2)) == null) {
                this.eDb.put(list.get(i2), false);
            }
        }
        if (this.eDb.size() >= 100) {
            aOw();
        }
    }

    public void aOw() {
        if (this.eDb != null) {
            synchronized (this.eDb) {
                if (this.eDb.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eDb.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eDb.size(), this.eDd, this.eDe + 1, this.eDf + 1);
                    this.eDb.clear();
                }
            }
        }
    }

    public void Z(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eDc > 300000000) {
            this.eDb.put(str, true);
        }
    }
}
