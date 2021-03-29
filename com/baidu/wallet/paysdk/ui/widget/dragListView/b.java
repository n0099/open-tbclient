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
    public Bitmap f26532a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f26533b;

    /* renamed from: c  reason: collision with root package name */
    public int f26534c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    public ListView f26535d;

    public b(ListView listView) {
        this.f26535d = listView;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view) {
        ((ImageView) view).setImageDrawable(null);
        this.f26532a.recycle();
        this.f26532a = null;
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public void a(View view, Point point, Point point2) {
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.i
    public View d(int i) {
        ListView listView = this.f26535d;
        View childAt = listView.getChildAt((i + listView.getHeaderViewsCount()) - this.f26535d.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.f26532a = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.f26533b == null) {
            this.f26533b = new ImageView(this.f26535d.getContext());
        }
        this.f26533b.setBackgroundColor(this.f26534c);
        this.f26533b.setPadding(0, 0, 0, 0);
        this.f26533b.setImageBitmap(this.f26532a);
        this.f26533b.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.f26533b;
    }

    public void e(int i) {
        this.f26534c = i;
    }
}
