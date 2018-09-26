package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void blS() {
        this.ghW.clear();
        if (this.mCardNullPolymericData != null) {
            this.ghW.add(this.mCardNullPolymericData);
        }
        if (!v.z(this.ghY)) {
            this.ghW.addAll(this.ghY);
        }
        if (!v.z(this.ghV)) {
            this.ghW.addAll(this.ghV);
        }
    }
}
