package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.y;
/* loaded from: classes23.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dvc() {
        this.mdr.clear();
        if (this.mCardNullPolymericData != null) {
            this.mdr.add(this.mCardNullPolymericData);
        }
        if (!y.isEmpty(this.mdq)) {
            this.mdr.addAll(this.mdq);
        }
    }
}
