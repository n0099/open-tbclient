package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.x;
/* loaded from: classes18.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cXC() {
        this.kWt.clear();
        if (this.mCardNullPolymericData != null) {
            this.kWt.add(this.mCardNullPolymericData);
        }
        if (!x.isEmpty(this.kWs)) {
            this.kWt.addAll(this.kWs);
        }
    }
}
