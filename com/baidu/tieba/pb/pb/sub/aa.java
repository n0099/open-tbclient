package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    final /* synthetic */ s bPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(s sVar) {
        this.bPT = sVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        MorePopupWindow morePopupWindow;
        MorePopupWindow morePopupWindow2;
        MorePopupWindow morePopupWindow3;
        MorePopupWindow morePopupWindow4;
        MorePopupWindow morePopupWindow5;
        MorePopupWindow morePopupWindow6;
        MorePopupWindow morePopupWindow7;
        MorePopupWindow morePopupWindow8;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        morePopupWindow = this.bPT.bKD;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.bPT.bKD;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.bPT.bKD;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.bPT.bKD;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.bPT.bKD;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.bPT.bKD;
                morePopupWindow7.dismiss();
                morePopupWindow8 = this.bPT.bKD;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.bPT.bKD;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
