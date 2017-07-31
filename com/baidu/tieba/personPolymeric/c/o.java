package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class o extends a {
    public o(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void VG() {
        this.fjV.clear();
        if (this.fjT != null) {
            this.fjV.add(this.fjT);
        }
        if (this.mCardNullPolymericData != null && this.fjT == null) {
            this.fjV.add(this.mCardNullPolymericData);
        }
        if (!u.v(this.fjU)) {
            this.fjV.addAll(this.fjU);
        }
    }
}
