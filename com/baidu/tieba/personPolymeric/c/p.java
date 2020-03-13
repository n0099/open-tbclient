package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes11.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cxd() {
        this.joG.clear();
        if (this.mCardNullPolymericData != null) {
            this.joG.add(this.mCardNullPolymericData);
        }
        if (!v.isEmpty(this.joF)) {
            this.joG.addAll(this.joF);
        }
    }
}
