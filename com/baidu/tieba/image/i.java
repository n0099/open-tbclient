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
    private String fbg;
    private int fbh;
    private int fbi;
    private long fbf = 0;
    private HashMap<String, Boolean> fbe = new HashMap<>();

    public void qo(int i) {
        this.fbi = i;
    }

    public int aUX() {
        return this.fbi;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.fbg = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.fbg = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.fbh = intExtra;
            this.fbi = intExtra;
        }
    }

    public void A(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.fbg);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.fbe) {
            if (System.nanoTime() - this.fbf > 300000000 && list != null && i < list.size()) {
                this.fbe.put(list.get(i), true);
            }
            this.fbf = System.nanoTime();
            if (list != null && i2 < list.size() && this.fbe.get(list.get(i2)) == null) {
                this.fbe.put(list.get(i2), false);
            }
        }
        if (this.fbe.size() >= 100) {
            aUY();
        }
    }

    public void aUY() {
        if (this.fbe != null) {
            synchronized (this.fbe) {
                if (this.fbe.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.fbe.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.fbe.size(), this.fbg, this.fbh + 1, this.fbi + 1);
                    this.fbe.clear();
                }
            }
        }
    }

    public void U(int i, String str) {
        if (i == 1 && System.nanoTime() - this.fbf > 300000000) {
            this.fbe.put(str, true);
        }
    }
}
