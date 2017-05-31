package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class o extends a {
    public o(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void Tr() {
        this.eMa.clear();
        if (this.eLY != null) {
            this.eMa.add(this.eLY);
        }
        if (this.mCardNullPolymericData != null && this.eLY == null) {
            this.eMa.add(this.mCardNullPolymericData);
        }
        if (!x.r(this.eLZ)) {
            this.eMa.addAll(this.eLZ);
        }
    }
}
