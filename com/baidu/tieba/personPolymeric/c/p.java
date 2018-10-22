package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bpd() {
        this.gpy.clear();
        if (this.mCardNullPolymericData != null) {
            this.gpy.add(this.mCardNullPolymericData);
        }
        if (!v.J(this.gpA)) {
            this.gpy.addAll(this.gpA);
        }
        if (!v.J(this.gpx)) {
            this.gpy.addAll(this.gpx);
        }
    }
}
