package com.baidu.tieba.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.bzj = pbActivity;
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
        morePopupWindow = this.bzj.byS;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.bzj.byS;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.bzj.byS;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.bzj.byS;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.bzj.byS;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.bzj.byS;
                morePopupWindow7.dismiss();
                morePopupWindow8 = this.bzj.byS;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.bzj.byS;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
