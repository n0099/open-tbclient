package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes7.dex */
public class l implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId iAO = BdUniqueId.gen();
    public bj Np;
    private boolean iAP = false;
    public boolean iAQ = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iAO;
    }

    public int aBv() {
        if (this.Np != null) {
            return this.Np.aBv();
        }
        return 0;
    }

    public boolean cjC() {
        return this.Np != null && this.Np.aBu() == 1;
    }

    public void ps(boolean z) {
        this.iAP = z;
    }

    public boolean cjD() {
        return this.iAP;
    }
}
