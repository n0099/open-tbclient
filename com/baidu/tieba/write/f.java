package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes2.dex */
public class f extends h {
    private a.C0826a mMp;

    public f(Context context, a.C0826a c0826a) {
        super(context, c0826a);
        this.mMp = c0826a;
    }

    @Override // com.baidu.tieba.write.h
    public void dFC() {
        if (this.mState == 4) {
            this.mState = 1;
            this.mState = 2;
            if (this.mMw != null) {
                this.mMw.Jw(this.mState);
            }
            dFz();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void asN() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mMw != null) {
                this.mMw.Jw(this.mState);
            }
            dFB();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dFD() {
        dFB();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
    }

    private void dFz() {
        this.mMp.dzy.setClickable(true);
        this.mState = 2;
        if (this.mMw != null) {
            this.mMw.Jw(this.mState);
        }
    }

    private void dFB() {
        this.mMp.dzy.setClickable(false);
        this.mState = 4;
        if (this.mMw != null) {
            this.mMw.Jw(this.mState);
        }
    }
}
