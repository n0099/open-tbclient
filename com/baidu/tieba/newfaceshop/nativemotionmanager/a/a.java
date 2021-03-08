package com.baidu.tieba.newfaceshop.nativemotionmanager.a;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tbadk.widget.dragsort.a;
import com.baidu.tbadk.widget.dragsort.b;
/* loaded from: classes8.dex */
public class a {
    private final com.baidu.tbadk.widget.dragsort.a fTr;
    private final SimpleDragSortListView lFh;
    private final C0818a lFi;

    public a(SimpleDragSortListView simpleDragSortListView) {
        this.lFh = simpleDragSortListView;
        this.fTr = new com.baidu.tbadk.widget.dragsort.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        simpleDragSortListView.setDragSortViewEventDelegate(this.fTr);
        this.lFi = new C0818a(this.fTr, simpleDragSortListView);
        this.lFi.setBackgroundColor(-1);
        this.fTr.a((b) this.lFi);
        this.fTr.a((a.h) this.lFi);
        simpleDragSortListView.setOnTouchListener(this.lFi);
    }

    public void uv(boolean z) {
        this.fTr.setDragEnabled(z);
    }

    public void a(a.g gVar) {
        this.fTr.a(gVar);
    }

    public void cW(int i, int i2) {
        this.lFi.cX(i, i2);
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0818a extends b {
        private ListView bbK;
        private com.baidu.tbadk.widget.dragsort.a fTr;
        private int lFj;
        private int lFk;

        public C0818a(com.baidu.tbadk.widget.dragsort.a aVar, ListView listView) {
            super(aVar, listView, 0, 2, 0);
            this.lFj = 0;
            this.lFk = Integer.MAX_VALUE;
            lF(false);
            this.bbK = listView;
            this.fTr = aVar;
        }

        public void cX(int i, int i2) {
            this.lFj = i;
            this.lFk = i2;
        }

        @Override // com.baidu.tbadk.widget.dragsort.b
        public int H(MotionEvent motionEvent) {
            int J = super.J(motionEvent);
            int headerViewsCount = J - this.bbK.getHeaderViewsCount();
            if (headerViewsCount < this.lFj || headerViewsCount >= this.lFk) {
                return -1;
            }
            return J;
        }

        @Override // com.baidu.tbadk.widget.dragsort.b, com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
        public void b(View view, Point point, Point point2) {
            int top;
            int top2;
            View view2 = null;
            int firstVisiblePosition = this.bbK.getFirstVisiblePosition();
            int dividerHeight = this.bbK.getDividerHeight();
            int headerViewsCount = (this.lFj - firstVisiblePosition) + this.bbK.getHeaderViewsCount();
            int headerViewsCount2 = this.bbK.getHeaderViewsCount() + (this.lFk - firstVisiblePosition);
            int childCount = this.bbK.getChildCount();
            View childAt = (headerViewsCount < 0 || headerViewsCount >= childCount) ? null : this.bbK.getChildAt(headerViewsCount);
            if (headerViewsCount2 >= 0 && headerViewsCount2 < childCount) {
                view2 = this.bbK.getChildAt(headerViewsCount2);
            }
            if (childAt != null && point.y < (top2 = childAt.getTop())) {
                point.y = top2;
            }
            if (view2 != null && point.y > (top = (view2.getTop() - dividerHeight) - view.getHeight())) {
                point.y = top;
            }
        }

        @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
        public void bW(View view) {
        }
    }
}
