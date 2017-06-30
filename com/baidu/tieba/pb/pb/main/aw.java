package com.baidu.tieba.pb.pb.main;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class aw implements View.OnTouchListener {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.baidu.tieba.e.c cVar;
        FrameLayout frameLayout = (FrameLayout) this.ewh.getPageContext().getPageActivity().getWindow().getDecorView();
        for (int i = 0; i < frameLayout.getChildCount(); i++) {
            View childAt = frameLayout.getChildAt(i);
            if ((childAt instanceof FrameLayout) && childAt.getTag() != null && "PraiseContainerView".equals(childAt.getTag())) {
                FrameLayout frameLayout2 = (FrameLayout) childAt;
                if (frameLayout2.getChildCount() <= 0) {
                    break;
                }
                View childAt2 = frameLayout2.getChildAt(0);
                if (frameLayout2 != null && (childAt2 instanceof com.baidu.tieba.pb.view.t) && ((com.baidu.tieba.pb.view.t) childAt2).anx()) {
                    break;
                }
            }
        }
        cVar = this.ewh.cfe;
        cVar.onTouchEvent(motionEvent);
        return false;
    }
}
