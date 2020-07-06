package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0763a mma;

    public f(Context context, a.C0763a c0763a) {
        super(context, c0763a);
        this.mma = c0763a;
    }

    @Override // com.baidu.tieba.write.h
    public void dqU() {
        if (this.mState == 4) {
            this.mState = 1;
            this.mState = 2;
            if (this.mmg != null) {
                this.mmg.Fp(this.mState);
            }
            dqR();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void ajJ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mmg != null) {
                this.mmg.Fp(this.mState);
            }
            dqT();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dqV() {
        dqT();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
    }

    private void dqR() {
        this.mma.djB.setClickable(true);
        this.mState = 2;
        if (this.mmg != null) {
            this.mmg.Fp(this.mState);
        }
    }

    private void dqT() {
        this.mma.djB.setClickable(false);
        this.mState = 4;
        if (this.mmg != null) {
            this.mmg.Fp(this.mState);
        }
    }
}
