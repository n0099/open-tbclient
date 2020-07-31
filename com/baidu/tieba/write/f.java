package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0773a mua;

    public f(Context context, a.C0773a c0773a) {
        super(context, c0773a);
        this.mua = c0773a;
    }

    @Override // com.baidu.tieba.write.h
    public void dug() {
        if (this.mState == 4) {
            this.mState = 1;
            this.mState = 2;
            if (this.mug != null) {
                this.mug.FL(this.mState);
            }
            dud();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void akZ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mug != null) {
                this.mug.FL(this.mState);
            }
            duf();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void duh() {
        duf();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
    }

    private void dud() {
        this.mua.dpw.setClickable(true);
        this.mState = 2;
        if (this.mug != null) {
            this.mug.FL(this.mState);
        }
    }

    private void duf() {
        this.mua.dpw.setClickable(false);
        this.mState = 4;
        if (this.mug != null) {
            this.mug.FL(this.mState);
        }
    }
}
