package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class o extends a {
    public o(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void Wc() {
        this.flO.clear();
        if (this.flM != null) {
            this.flO.add(this.flM);
        }
        if (this.mCardNullPolymericData != null && this.flM == null) {
            this.flO.add(this.mCardNullPolymericData);
        }
        if (!u.v(this.flN)) {
            this.flO.addAll(this.flN);
        }
    }
}
