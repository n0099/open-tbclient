package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private Context a;

    public m(Context context) {
        this.a = null;
        this.a = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.a.a.a().b();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.a.a.a().b(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            ImageView imageView2 = new ImageView(this.a);
            imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int a = com.baidu.tieba.d.ag.a(this.a, 50.0f);
            imageView2.setLayoutParams(new AbsListView.LayoutParams(a, a));
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
