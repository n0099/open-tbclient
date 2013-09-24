package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class o extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f2122a;

    public o(Context context) {
        this.f2122a = null;
        this.f2122a = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.a.a.a().b();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.a.a.a().b(i).f();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            ImageView imageView2 = new ImageView(this.f2122a);
            imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int a2 = UtilHelper.a(this.f2122a, 50.0f);
            imageView2.setLayoutParams(new AbsListView.LayoutParams(a2, a2));
            imageView = imageView2;
            view = imageView2;
        } else {
            imageView = (ImageView) view;
        }
        imageView.setFocusable(false);
        imageView.setImageBitmap((Bitmap) getItem(i));
        return view;
    }

    public String a(int i) {
        return com.baidu.tbadk.a.a.a().c(i);
    }
}
