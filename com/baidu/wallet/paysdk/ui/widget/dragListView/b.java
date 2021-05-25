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
    public Bitmap f26202a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f26203b;

    /* renamed from: c  reason: collision with root package name */
    public int f26204c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    public ListView f26205d;

    public b(ListView listView) {
        this.f26205d = listView;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f26202a.recycle();
        this.f26202a = null;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public View d(int i2) {
        ListView listView = this.f26205d;
        View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f26205d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f26202a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f26203b == null) {
            this.f26203b = new ImageView(this.f26205d.getContext());
        }
        this.f26203b.setBackgroundColor(this.f26204c);
        this.f26203b.setPadding(0, 0, 0, 0);
        this.f26203b.setImageBitmap(this.f26202a);
        this.f26203b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f26203b;
    }

    public void e(int i2) {
        this.f26204c = i2;
    }
}
