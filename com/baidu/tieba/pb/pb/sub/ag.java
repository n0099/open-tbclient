package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnTouchListener {
    final /* synthetic */ w cHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(w wVar) {
        this.cHA = wVar;
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
        morePopupWindow = this.cHA.cHp;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.cHA.cHp;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.cHA.cHp;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.cHA.cHp;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.cHA.cHp;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.cHA.cHp;
                newSubPbActivity = this.cHA.cHi;
                com.baidu.adp.lib.h.j.a(morePopupWindow7, newSubPbActivity.getPageContext().getPageActivity());
                morePopupWindow8 = this.cHA.cHp;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.cHA.cHp;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
