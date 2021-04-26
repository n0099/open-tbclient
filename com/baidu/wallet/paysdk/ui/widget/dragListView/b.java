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
    public Bitmap f27028a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f27029b;

    /* renamed from: c  reason: collision with root package name */
    public int f27030c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    public ListView f27031d;

    public b(ListView listView) {
        this.f27031d = listView;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f27028a.recycle();
        this.f27028a = null;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public View d(int i2) {
        ListView listView = this.f27031d;
        View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f27031d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f27028a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f27029b == null) {
            this.f27029b = new ImageView(this.f27031d.getContext());
        }
        this.f27029b.setBackgroundColor(this.f27030c);
        this.f27029b.setPadding(0, 0, 0, 0);
        this.f27029b.setImageBitmap(this.f27028a);
        this.f27029b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f27029b;
    }

    public void e(int i2) {
        this.f27030c = i2;
    }
}
