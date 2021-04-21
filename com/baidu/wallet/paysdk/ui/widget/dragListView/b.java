package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView;
/* loaded from: classes5.dex */
public class b implements DragSortListView.i {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f26225a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f26226b;

    /* renamed from: c  reason: collision with root package name */
    public int f26227c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    public ListView f26228d;

    public b(ListView listView) {
        this.f26228d = listView;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f26225a.recycle();
        this.f26225a = null;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public View d(int i) {
        ListView listView = this.f26228d;
        View childAt = listView.getChildAt((i + listView.getHeaderViewsCount()) - this.f26228d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f26225a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f26226b == null) {
            this.f26226b = new ImageView(this.f26228d.getContext());
        }
        this.f26226b.setBackgroundColor(this.f26227c);
        this.f26226b.setPadding(0, 0, 0, 0);
        this.f26226b.setImageBitmap(this.f26225a);
        this.f26226b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f26226b;
    }

    public void e(int i) {
        this.f26227c = i;
    }
}
