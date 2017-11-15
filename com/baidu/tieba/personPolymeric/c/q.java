package com.baidu.tieba.personPolymeric.c;

import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class q extends a {
    public q(boolean z) {
        super(z);
    }

    @Override // com.baidu.tieba.personPolymeric.c.a
    public void bae() {
        this.fpk.clear();
        if (this.fpi != null) {
            this.fpk.add(this.fpi);
        } else if (this.fph != null) {
            this.fpk.add(this.fph);
        } else if (this.mCardNullPolymericData != null) {
            this.fpk.add(this.mCardNullPolymericData);
        }
        if (!v.v(this.fpm)) {
            this.fpk.addAll(this.fpm);
        }
        if (!v.v(this.fpj)) {
            this.fpk.addAll(this.fpj);
        }
    }
}
