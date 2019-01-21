package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void brL() {
        this.gBJ.clear();
        if (this.mCardNullPolymericData != null) {
            this.gBJ.add(this.mCardNullPolymericData);
        }
        if (!v.I(this.gBL)) {
            this.gBJ.addAll(this.gBL);
        }
        if (!v.I(this.gBI)) {
            this.gBJ.addAll(this.gBI);
        }
    }
}
