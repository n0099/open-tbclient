package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bks() {
        this.gpx.clear();
        if (this.mCardNullPolymericData != null) {
            this.gpx.add(this.mCardNullPolymericData);
        }
        if (!v.E(this.gpz)) {
            this.gpx.addAll(this.gpz);
        }
        if (!v.E(this.gpw)) {
            this.gpx.addAll(this.gpw);
        }
    }
}
