package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.x;
/* loaded from: classes7.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void dwt() {
        this.msi.clear();
        if (this.mCardNullPolymericData != null) {
            this.msi.add(this.mCardNullPolymericData);
        }
        if (!x.isEmpty(this.msh)) {
            this.msi.addAll(this.msh);
        }
    }
}
