package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.cjN = pbActivity;
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
        morePopupWindow = this.cjN.cjs;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.cjN.cjs;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.cjN.cjs;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.cjN.cjs;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.cjN.cjs;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.cjN.cjs;
                com.baidu.adp.lib.g.j.a(morePopupWindow7, this.cjN.getPageContext().getPageActivity());
                morePopupWindow8 = this.cjN.cjs;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.cjN.cjs;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
