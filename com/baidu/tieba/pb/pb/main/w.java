package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.ciz = pbActivity;
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
        morePopupWindow = this.ciz.cif;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.ciz.cif;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.ciz.cif;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.ciz.cif;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.ciz.cif;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.ciz.cif;
                com.baidu.adp.lib.g.j.a(morePopupWindow7, this.ciz.getPageContext().getPageActivity());
                morePopupWindow8 = this.ciz.cif;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.ciz.cif;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
