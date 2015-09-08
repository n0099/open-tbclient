package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnTouchListener {
    final /* synthetic */ t chq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(t tVar) {
        this.chq = tVar;
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
        morePopupWindow = this.chq.cbP;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.chq.cbP;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.chq.cbP;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.chq.cbP;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.chq.cbP;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.chq.cbP;
                newSubPbActivity = this.chq.cgZ;
                com.baidu.adp.lib.g.j.a(morePopupWindow7, newSubPbActivity.getPageContext().getPageActivity());
                morePopupWindow8 = this.chq.cbP;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.chq.cbP;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
