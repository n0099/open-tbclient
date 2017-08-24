package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class o extends a {
    public o(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void VZ() {
        this.flQ.clear();
        if (this.flO != null) {
            this.flQ.add(this.flO);
        }
        if (this.mCardNullPolymericData != null && this.flO == null) {
            this.flQ.add(this.mCardNullPolymericData);
        }
        if (!u.v(this.flP)) {
            this.flQ.addAll(this.flP);
        }
    }
}
