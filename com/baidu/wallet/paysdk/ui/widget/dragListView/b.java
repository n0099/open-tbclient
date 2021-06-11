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
    public Bitmap f26305a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f26306b;

    /* renamed from: c  reason: collision with root package name */
    public int f26307c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    public ListView f26308d;

    public b(ListView listView) {
        this.f26308d = listView;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f26305a.recycle();
        this.f26305a = null;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public View d(int i2) {
        ListView listView = this.f26308d;
        View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f26308d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f26305a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f26306b == null) {
            this.f26306b = new ImageView(this.f26308d.getContext());
        }
        this.f26306b.setBackgroundColor(this.f26307c);
        this.f26306b.setPadding(0, 0, 0, 0);
        this.f26306b.setImageBitmap(this.f26305a);
        this.f26306b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f26306b;
    }

    public void e(int i2) {
        this.f26307c = i2;
    }
}
