package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class at implements View.OnTouchListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        FrameLayout frameLayout = (FrameLayout) this.enc.getPageContext().getPageActivity().getWindow().getDecorView();
        for (int i = 0; i < frameLayout.getChildCount(); i++) {
            View childAt = frameLayout.getChildAt(i);
            if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag())) {
                FrameLayout frameLayout2 = (FrameLayout) childAt;
                if (frameLayout2.getChildCount() <= 0) {
                    break;
                }
                View childAt2 = frameLayout2.getChildAt(0);
                if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.t) && ((com.baidu.tieba.pb.view.t) childAt2).ajM()) {
                    break;
                }
            }
        }
        cVar = this.enc.bwH;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
