package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.w;
/* loaded from: classes11.dex */
public class p extends a {
    public p(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void cTM() {
        this.kNt.clear();
        if (this.mCardNullPolymericData != null) {
            this.kNt.add(this.mCardNullPolymericData);
        }
        if (!w.isEmpty(this.kNs)) {
            this.kNt.addAll(this.kNs);
        }
    }
}
