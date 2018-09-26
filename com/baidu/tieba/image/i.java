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
    private String eSd;
    private int eSe;
    private int eSf;
    private long eSc = 0;
    private HashMap<String, Boolean> eSb = new HashMap<>();

    public void px(int i) {
        this.eSf = i;
    }

    public int aSm() {
        return this.eSf;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eSd = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eSd = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eSe = intExtra;
            this.eSf = intExtra;
        }
    }

    public void w(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eSd);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.eSb) {
            if (System.nanoTime() - this.eSc > 300000000 && list != null && i < list.size()) {
                this.eSb.put(list.get(i), true);
            }
            this.eSc = System.nanoTime();
            if (list != null && i2 < list.size() && this.eSb.get(list.get(i2)) == null) {
                this.eSb.put(list.get(i2), false);
            }
        }
        if (this.eSb.size() >= 100) {
            aSn();
        }
    }

    public void aSn() {
        if (this.eSb != null) {
            synchronized (this.eSb) {
                if (this.eSb.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eSb.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eSb.size(), this.eSd, this.eSe + 1, this.eSf + 1);
                    this.eSb.clear();
                }
            }
        }
    }

    public void Y(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eSc > 300000000) {
            this.eSb.put(str, true);
        }
    }
}
