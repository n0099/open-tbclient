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
    private String fkP;
    private int fkQ;
    private int fkR;
    private long fkO = 0;
    private HashMap<String, Boolean> fkN = new HashMap<>();

    public void qV(int i) {
        this.fkR = i;
    }

    public int aXC() {
        return this.fkR;
    }

    public void b(Bundle bundle, Intent intent) {
        if (bundle != null) {
            this.fkP = bundle.getString(ImageViewerConfig.PV_TYPE);
        } else if (intent != null) {
            this.fkP = intent.getStringExtra(ImageViewerConfig.PV_TYPE);
            int intExtra = intent.getIntExtra("index", -1);
            this.fkQ = intExtra;
            this.fkR = intExtra;
        }
    }

    public void D(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(ImageViewerConfig.PV_TYPE, this.fkP);
        }
    }

    public void e(List<String> list, int i, int i2) {
        synchronized (this.fkN) {
            if (System.nanoTime() - this.fkO > 300000000 && list != null && i < list.size()) {
                this.fkN.put(list.get(i), true);
            }
            this.fkO = System.nanoTime();
            if (list != null && i2 < list.size() && this.fkN.get(list.get(i2)) == null) {
                this.fkN.put(list.get(i2), false);
            }
        }
        if (this.fkN.size() >= 100) {
            aXD();
        }
    }

    public void aXD() {
        if (this.fkN != null) {
            synchronized (this.fkN) {
                if (this.fkN.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.fkN.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TbadkCoreApplication.getInst().sendImagePv(i, this.fkN.size(), this.fkP, this.fkQ + 1, this.fkR + 1);
                    this.fkN.clear();
                }
            }
        }
    }

    public void V(int i, String str) {
        if (i == 1 && System.nanoTime() - this.fkO > 300000000) {
            this.fkN.put(str, true);
        }
    }
}
