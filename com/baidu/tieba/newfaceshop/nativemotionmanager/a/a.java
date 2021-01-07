package com.baidu.tieba.newfaceshop.nativemotionmanager.a;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tbadk.widget.dragsort.a;
import com.baidu.tbadk.widget.dragsort.b;
/* loaded from: classes9.dex */
public class a {
    private final com.baidu.tbadk.widget.dragsort.a fUl;
    private final SimpleDragSortListView lzt;
    private final C0827a lzu;

    public a(SimpleDragSortListView simpleDragSortListView) {
        this.lzt = simpleDragSortListView;
        this.fUl = new com.baidu.tbadk.widget.dragsort.a(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        simpleDragSortListView.setDragSortViewEventDelegate(this.fUl);
        this.lzu = new C0827a(this.fUl, simpleDragSortListView);
        this.lzu.setBackgroundColor(-1);
        this.fUl.a((b) this.lzu);
        this.fUl.a((a.h) this.lzu);
        simpleDragSortListView.setOnTouchListener(this.lzu);
    }

    public void um(boolean z) {
        this.fUl.setDragEnabled(z);
    }

    public void a(a.g gVar) {
        this.fUl.a(gVar);
    }

    public void cY(int i, int i2) {
        this.lzu.cZ(i, i2);
    }

    /* renamed from: com.baidu.tieba.newfaceshop.nativemotionmanager.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0827a extends b {
        private ListView bbR;
        private com.baidu.tbadk.widget.dragsort.a fUl;
        private int lzv;
        private int lzw;

        public C0827a(com.baidu.tbadk.widget.dragsort.a aVar, ListView listView) {
            super(aVar, listView, 0, 2, 0);
            this.lzv = 0;
            this.lzw = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            lG(false);
            this.bbR = listView;
            this.fUl = aVar;
        }

        public void cZ(int i, int i2) {
            this.lzv = i;
            this.lzw = i2;
        }

        @Override // com.baidu.tbadk.widget.dragsort.b
        public int H(MotionEvent motionEvent) {
            int J = super.J(motionEvent);
            int headerViewsCount = J - this.bbR.getHeaderViewsCount();
            if (headerViewsCount < this.lzv || headerViewsCount >= this.lzw) {
                return -1;
            }
            return J;
        }

        @Override // com.baidu.tbadk.widget.dragsort.b, com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
        public void b(View view, Point point, Point point2) {
            int top;
            int top2;
            View view2 = null;
            int firstVisiblePosition = this.bbR.getFirstVisiblePosition();
            int dividerHeight = this.bbR.getDividerHeight();
            int headerViewsCount = (this.lzv - firstVisiblePosition) + this.bbR.getHeaderViewsCount();
            int headerViewsCount2 = this.bbR.getHeaderViewsCount() + (this.lzw - firstVisiblePosition);
            int childCount = this.bbR.getChildCount();
            View childAt = (headerViewsCount < 0 || headerViewsCount >= childCount) ? null : this.bbR.getChildAt(headerViewsCount);
            if (headerViewsCount2 >= 0 && headerViewsCount2 < childCount) {
                view2 = this.bbR.getChildAt(headerViewsCount2);
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
