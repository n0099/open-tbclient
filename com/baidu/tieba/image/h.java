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
    private String eVM;
    private int eVN;
    private int eVO;
    private long eVL = 0;
    private HashMap<String, Boolean> eVK = new HashMap<>();

    public void qR(int i) {
        this.eVO = i;
    }

    public int aOx() {
        return this.eVO;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.eVM = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.eVM = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.eVN = intExtra;
            this.eVO = intExtra;
        }
    }

    public void A(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.eVM);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.eVK) {
            if (System.nanoTime() - this.eVL > 300000000 && list != null && i < list.size()) {
                this.eVK.put(list.get(i), true);
            }
            this.eVL = System.nanoTime();
            if (list != null && i2 < list.size() && this.eVK.get(list.get(i2)) == null) {
                this.eVK.put(list.get(i2), false);
            }
        }
        if (this.eVK.size() >= 100) {
            aOy();
        }
    }

    public void aOy() {
        if (this.eVK != null) {
            synchronized (this.eVK) {
                if (this.eVK.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.eVK.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.eVK.size(), this.eVM, this.eVN + 1, this.eVO + 1);
                    this.eVK.clear();
                }
            }
        }
    }

    public void Q(int i, String str) {
        if (i == 1 && System.nanoTime() - this.eVL > 300000000) {
            this.eVK.put(str, true);
        }
    }
}
