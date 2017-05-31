package com.baidu.tieba.pb.pb.main.emotion.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnTouchListener {
    final /* synthetic */ PbEmotionView ewx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbEmotionView pbEmotionView) {
        this.ewx = pbEmotionView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        float f;
        float f2;
        z = this.ewx.ewv;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.ewx.ewt = true;
                    this.ewx.FG = motionEvent.getRawX();
                    this.ewx.bkY = motionEvent.getRawY();
                    PbEmotionView pbEmotionView = this.ewx;
                    f = this.ewx.FG;
                    pbEmotionView.mCurrentX = f;
                    PbEmotionView pbEmotionView2 = this.ewx;
                    f2 = this.ewx.bkY;
                    pbEmotionView2.mCurrentY = f2;
                    this.ewx.postDelayed(new h(this), 500L);
                    return true;
                case 1:
                    this.ewx.ewt = false;
                    z2 = this.ewx.ewu;
                    if (!z2) {
                        onClickListener = this.ewx.bhc;
                        if (onClickListener != null) {
                            onClickListener2 = this.ewx.bhc;
                            onClickListener2.onClick(this.ewx);
                            return true;
                        }
                        return true;
                    }
                    this.ewx.stopPreview();
                    return true;
                case 2:
                default:
                    return true;
                case 3:
                    this.ewx.ewt = false;
                    this.ewx.stopPreview();
                    return true;
            }
        }
        return false;
    }
}
