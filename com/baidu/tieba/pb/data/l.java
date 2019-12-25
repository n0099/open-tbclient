package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes6.dex */
public class l implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ixk = BdUniqueId.gen();
    public bj Nl;
    private boolean ixl = false;
    public boolean ixm = false;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ixk;
    }

    public int aBc() {
        if (this.Nl != null) {
            return this.Nl.aBc();
        }
        return 0;
    }

    public boolean ciu() {
        return this.Nl != null && this.Nl.aBb() == 1;
    }

    public void pg(boolean z) {
        this.ixl = z;
    }

    public boolean civ() {
        return this.ixl;
    }
}
