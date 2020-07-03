package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0762a mlX;

    public f(Context context, a.C0762a c0762a) {
        super(context, c0762a);
        this.mlX = c0762a;
    }

    @Override // com.baidu.tieba.write.h
    public void dqQ() {
        if (this.mState == 4) {
            this.mState = 1;
            this.mState = 2;
            if (this.mmd != null) {
                this.mmd.Fp(this.mState);
            }
            dqN();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void ajJ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mmd != null) {
                this.mmd.Fp(this.mState);
            }
            dqP();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dqR() {
        dqP();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
    }

    private void dqN() {
        this.mlX.djB.setClickable(true);
        this.mState = 2;
        if (this.mmd != null) {
            this.mmd.Fp(this.mState);
        }
    }

    private void dqP() {
        this.mlX.djB.setClickable(false);
        this.mState = 4;
        if (this.mmd != null) {
            this.mmd.Fp(this.mState);
        }
    }
}
