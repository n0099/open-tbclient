package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.ccj = pbActivity;
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
        morePopupWindow = this.ccj.cbP;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.ccj.cbP;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.ccj.cbP;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.ccj.cbP;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.ccj.cbP;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.ccj.cbP;
                com.baidu.adp.lib.g.j.a(morePopupWindow7, this.ccj.getPageContext().getPageActivity());
                morePopupWindow8 = this.ccj.cbP;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.ccj.cbP;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
