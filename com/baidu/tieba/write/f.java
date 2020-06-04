package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0747a lRN;

    public f(Context context, a.C0747a c0747a) {
        super(context, c0747a);
        this.lRN = c0747a;
    }

    @Override // com.baidu.tieba.write.h
    public void dmD() {
        if (this.mState == 4) {
            this.mState = 1;
            this.mState = 2;
            if (this.lRT != null) {
                this.lRT.En(this.mState);
            }
            dmA();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aiD() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.lRT != null) {
                this.lRT.En(this.mState);
            }
            dmC();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dmE() {
        dmC();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
    }

    private void dmA() {
        this.lRN.deP.setClickable(true);
        this.mState = 2;
        if (this.lRT != null) {
            this.lRT.En(this.mState);
        }
    }

    private void dmC() {
        this.lRN.deP.setClickable(false);
        this.mState = 4;
        if (this.lRT != null) {
            this.lRT.En(this.mState);
        }
    }
}
