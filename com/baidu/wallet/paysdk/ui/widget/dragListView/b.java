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
    public Bitmap f26273a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f26274b;

    /* renamed from: c  reason: collision with root package name */
    public int f26275c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    public ListView f26276d;

    public b(ListView listView) {
        this.f26276d = listView;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f26273a.recycle();
        this.f26273a = null;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public View d(int i2) {
        ListView listView = this.f26276d;
        View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f26276d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f26273a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f26274b == null) {
            this.f26274b = new ImageView(this.f26276d.getContext());
        }
        this.f26274b.setBackgroundColor(this.f26275c);
        this.f26274b.setPadding(0, 0, 0, 0);
        this.f26274b.setImageBitmap(this.f26273a);
        this.f26274b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f26274b;
    }

    public void e(int i2) {
        this.f26275c = i2;
    }
}
