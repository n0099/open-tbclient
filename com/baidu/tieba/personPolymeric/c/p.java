package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.w;
/* loaded from: classes3.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bkv() {
        this.fWo.clear();
        if (this.mCardNullPolymericData != null) {
            this.fWo.add(this.mCardNullPolymericData);
        }
        if (!w.z(this.fWq)) {
            this.fWo.addAll(this.fWq);
        }
        if (!w.z(this.fWn)) {
            this.fWo.addAll(this.fWn);
        }
    }
}
