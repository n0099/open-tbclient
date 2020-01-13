package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes9.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cvF() {
        this.jnt.clear();
        if (this.mCardNullPolymericData != null) {
            this.jnt.add(this.mCardNullPolymericData);
        }
        if (!v.isEmpty(this.jns)) {
            this.jnt.addAll(this.jns);
        }
    }
}
