package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnTouchListener {
    final /* synthetic */ w cLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(w wVar) {
        this.cLC = wVar;
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
        NewSubPbActivity newSubPbActivity;
        MorePopupWindow morePopupWindow8;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        morePopupWindow = this.cLC.cLr;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.cLC.cLr;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.cLC.cLr;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.cLC.cLr;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.cLC.cLr;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.cLC.cLr;
                newSubPbActivity = this.cLC.cLg;
                com.baidu.adp.lib.h.j.a(morePopupWindow7, newSubPbActivity.getPageContext().getPageActivity());
                morePopupWindow8 = this.cLC.cLr;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.cLC.cLr;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
