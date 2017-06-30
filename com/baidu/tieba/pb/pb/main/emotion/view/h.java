package com.baidu.tieba.pb.pb.main.emotion.view;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ PbEmotionView eFT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbEmotionView pbEmotionView) {
        this.eFT = pbEmotionView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        float f;
        float f2;
        z = this.eFT.eFR;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.eFT.eFP = true;
                    this.eFT.FG = motionEvent.getRawX();
                    this.eFT.boN = motionEvent.getRawY();
                    PbEmotionView pbEmotionView = this.eFT;
                    f = this.eFT.FG;
                    pbEmotionView.mCurrentX = f;
                    PbEmotionView pbEmotionView2 = this.eFT;
                    f2 = this.eFT.boN;
                    pbEmotionView2.mCurrentY = f2;
                    this.eFT.postDelayed(new i(this), 500L);
                    return true;
                case 1:
                    this.eFT.eFP = false;
                    z2 = this.eFT.eFQ;
                    if (!z2) {
                        onClickListener = this.eFT.bkk;
                        if (onClickListener != null) {
                            onClickListener2 = this.eFT.bkk;
                            onClickListener2.onClick(this.eFT);
                            return true;
                        }
                        return true;
                    }
                    this.eFT.stopPreview();
                    return true;
                case 2:
                default:
                    return true;
                case 3:
                    this.eFT.eFP = false;
                    this.eFT.stopPreview();
                    return true;
            }
        }
        return false;
    }
}
