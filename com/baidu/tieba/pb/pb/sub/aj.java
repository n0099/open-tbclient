package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnTouchListener {
    final /* synthetic */ x dpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(x xVar) {
        this.dpf = xVar;
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
        morePopupWindow = this.dpf.doV;
        if (morePopupWindow.getContentView() == null) {
            return false;
        }
        morePopupWindow2 = this.dpf.doV;
        int top = morePopupWindow2.getContentView().getTop();
        morePopupWindow3 = this.dpf.doV;
        int right = morePopupWindow3.getContentView().getRight();
        morePopupWindow4 = this.dpf.doV;
        int bottom = morePopupWindow4.getContentView().getBottom();
        if (motionEvent.getAction() == 4 && x > right && y > top && y < bottom) {
            morePopupWindow6 = this.dpf.doV;
            if (morePopupWindow6.isShowing()) {
                morePopupWindow7 = this.dpf.doV;
                newSubPbActivity = this.dpf.doJ;
                com.baidu.adp.lib.h.j.a(morePopupWindow7, newSubPbActivity.getPageContext().getPageActivity());
                morePopupWindow8 = this.dpf.doV;
                morePopupWindow8.setIsIntercepted(true);
                return true;
            }
        }
        morePopupWindow5 = this.dpf.doV;
        morePopupWindow5.setIsIntercepted(false);
        return false;
    }
}
