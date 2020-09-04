package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0826a mMH;

    public f(Context context, a.C0826a c0826a) {
        super(context, c0826a);
        this.mMH = c0826a;
    }

    @Override // com.baidu.tieba.write.h
    public void dFL() {
        if (this.mState == 4) {
            this.mState = 1;
            this.mState = 2;
            if (this.mMO != null) {
                this.mMO.Jw(this.mState);
            }
            dFI();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void asN() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mMO != null) {
                this.mMO.Jw(this.mState);
            }
            dFK();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dFM() {
        dFK();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
    }

    private void dFI() {
        this.mMH.dzC.setClickable(true);
        this.mState = 2;
        if (this.mMO != null) {
            this.mMO.Jw(this.mState);
        }
    }

    private void dFK() {
        this.mMH.dzC.setClickable(false);
        this.mState = 4;
        if (this.mMO != null) {
            this.mMO.Jw(this.mState);
        }
    }
}
