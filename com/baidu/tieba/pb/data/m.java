package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes9.dex */
public class m implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId jGv = BdUniqueId.gen();
    private bk ahg;
    private AntiData dUO;
    private boolean jGw = false;
    public boolean jGx = false;

    public m(bk bkVar, AntiData antiData) {
        this.ahg = bkVar;
        this.dUO = antiData;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return jGv;
    }

    public int aRZ() {
        if (this.ahg != null) {
            return this.ahg.aRZ();
        }
        return 0;
    }

    public boolean cDp() {
        return this.ahg != null && this.ahg.aRY() == 1;
    }

    public AntiData getAnti() {
        return this.dUO;
    }

    public bk aOi() {
        return this.ahg;
    }

    public void rd(boolean z) {
        this.jGw = z;
    }

    public boolean cDq() {
        return this.jGw;
    }
}
