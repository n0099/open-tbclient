package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes6.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cag() {
        this.ikh.clear();
        if (this.mCardNullPolymericData != null) {
            this.ikh.add(this.mCardNullPolymericData);
        }
        if (!v.aa(this.ikj)) {
            this.ikh.addAll(this.ikj);
        }
        if (!v.aa(this.ikg)) {
            this.ikh.addAll(this.ikg);
        }
    }
}
