package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnTouchListener {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.bKT = pbActivity;
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
        morePopupWindow = this.bKT.bKD;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.bKT.bKD;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.bKT.bKD;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.bKT.bKD;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.bKT.bKD;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.bKT.bKD;
                morePopupWindow7.dismiss();
                morePopupWindow8 = this.bKT.bKD;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.bKT.bKD;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
