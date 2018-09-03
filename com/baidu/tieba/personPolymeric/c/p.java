package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.w;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bjr() {
        this.gaF.clear();
        if (this.mCardNullPolymericData != null) {
            this.gaF.add(this.mCardNullPolymericData);
        }
        if (!w.z(this.gaH)) {
            this.gaF.addAll(this.gaH);
        }
        if (!w.z(this.gaE)) {
            this.gaF.addAll(this.gaE);
        }
    }
}
