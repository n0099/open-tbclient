package com.baidu.tieba.write;

import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0773a muc;

    public f(Context context, a.C0773a c0773a) {
        super(context, c0773a);
        this.muc = c0773a;
    }

    @Override // com.baidu.tieba.write.h
    public void duh() {
        if (this.mState == 4) {
            this.mState = 1;
            this.mState = 2;
            if (this.mui != null) {
                this.mui.FL(this.mState);
            }
            due();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void akZ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mui != null) {
                this.mui.FL(this.mState);
            }
            dug();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dui() {
        dug();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
    }

    private void due() {
        this.muc.dpw.setClickable(true);
        this.mState = 2;
        if (this.mui != null) {
            this.mui.FL(this.mState);
        }
    }

    private void dug() {
        this.muc.dpw.setClickable(false);
        this.mState = 4;
        if (this.mui != null) {
            this.mui.FL(this.mState);
        }
    }
}
