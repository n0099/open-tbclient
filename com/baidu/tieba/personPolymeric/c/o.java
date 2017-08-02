package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class o extends a {
    public o(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void VB() {
        this.fiJ.clear();
        if (this.fiH != null) {
            this.fiJ.add(this.fiH);
        }
        if (this.mCardNullPolymericData != null && this.fiH == null) {
            this.fiJ.add(this.mCardNullPolymericData);
        }
        if (!u.v(this.fiI)) {
            this.fiJ.addAll(this.fiI);
        }
    }
}
