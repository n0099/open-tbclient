package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;
@TargetApi(9)
/* loaded from: classes4.dex */
public class a extends d {
    protected final OverScroller mScroller;
    private boolean otZ = false;

    public a(Context context) {
        this.mScroller = new OverScroller(context);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d
    public boolean computeScrollOffset() {
        if (this.otZ) {
            this.mScroller.computeScrollOffset();
            this.otZ = false;
        }
        return this.mScroller.computeScrollOffset();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.mScroller.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d
    public void zJ(boolean z) {
        this.mScroller.forceFinished(z);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }
}
