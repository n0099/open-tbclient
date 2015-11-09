package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnTouchListener {
    final /* synthetic */ v coo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(v vVar) {
        this.coo = vVar;
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
        morePopupWindow = this.coo.cjs;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.coo.cjs;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.coo.cjs;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.coo.cjs;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.coo.cjs;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.coo.cjs;
                newSubPbActivity = this.coo.cnX;
                com.baidu.adp.lib.g.j.a(morePopupWindow7, newSubPbActivity.getPageContext().getPageActivity());
                morePopupWindow8 = this.coo.cjs;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.coo.cjs;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
