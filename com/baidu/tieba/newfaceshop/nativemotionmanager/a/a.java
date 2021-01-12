package com.baidu.tieba.newfaceshop.nativemotionmanager.a;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tbadk.widget.dragsort.a;
import com.baidu.tbadk.widget.dragsort.b;
/* loaded from: classes8.dex */
public class a {
    private final com.baidu.tbadk.widget.dragsort.a fPE;
    private final SimpleDragSortListView luN;
    private final C0810a luO;

    public a(SimpleDragSortListView simpleDragSortListView) {
        this.luN = simpleDragSortListView;
        this.fPE = new com.baidu.tbadk.widget.dragsort.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        simpleDragSortListView.setDragSortViewEventDelegate(this.fPE);
        this.luO = new C0810a(this.fPE, simpleDragSortListView);
        this.luO.setBackgroundColor(-1);
        this.fPE.a((b) this.luO);
        this.fPE.a((a.h) this.luO);
        simpleDragSortListView.setOnTouchListener(this.luO);
    }

    public void ui(boolean z) {
        this.fPE.setDragEnabled(z);
    }

    public void a(a.g gVar) {
        this.fPE.a(gVar);
    }

    public void cY(int i, int i2) {
        this.luO.cZ(i, i2);
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0810a extends b {
        private ListView aXd;
        private com.baidu.tbadk.widget.dragsort.a fPE;
        private int luP;
        private int luQ;

        public C0810a(com.baidu.tbadk.widget.dragsort.a aVar, ListView listView) {
            super(aVar, listView, 0, 2, 0);
            this.luP = 0;
            this.luQ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            lC(false);
            this.aXd = listView;
            this.fPE = aVar;
        }

        public void cZ(int i, int i2) {
            this.luP = i;
            this.luQ = i2;
        }

        @Override // com.baidu.tbadk.widget.dragsort.b
        public int H(MotionEvent motionEvent) {
            int J = super.J(motionEvent);
            int headerViewsCount = J - this.aXd.getHeaderViewsCount();
            if (headerViewsCount < this.luP || headerViewsCount >= this.luQ) {
                return -1;
            }
            return J;
        }

        @Override // com.baidu.tbadk.widget.dragsort.b, com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
        public void b(View view, Point point, Point point2) {
            int top;
            int top2;
            View view2 = null;
            int firstVisiblePosition = this.aXd.getFirstVisiblePosition();
            int dividerHeight = this.aXd.getDividerHeight();
            int headerViewsCount = (this.luP - firstVisiblePosition) + this.aXd.getHeaderViewsCount();
            int headerViewsCount2 = this.aXd.getHeaderViewsCount() + (this.luQ - firstVisiblePosition);
            int childCount = this.aXd.getChildCount();
            View childAt = (headerViewsCount < 0 || headerViewsCount >= childCount) ? null : this.aXd.getChildAt(headerViewsCount);
            if (headerViewsCount2 >= 0 && headerViewsCount2 < childCount) {
                view2 = this.aXd.getChildAt(headerViewsCount2);
            }
            if (childAt != null && point.y < (top2 = childAt.getTop())) {
                point.y = top2;
            }
            if (view2 != null && point.y > (top = (view2.getTop() - dividerHeight) - view.getHeight())) {
                point.y = top;
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
        public void ca(View view) {
        }
    }
}
