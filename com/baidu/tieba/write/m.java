package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private HashMap a = com.baidu.tieba.c.n.a();
    private ArrayList b = com.baidu.tieba.c.n.b();
    private HashMap c = new HashMap();
    private Context d;

    public m(Context context) {
        this.d = null;
        this.d = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return this.b.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Bitmap bitmap;
        int intValue = ((Integer) this.b.get(i)).intValue();
        SoftReference softReference = (SoftReference) this.c.get(Integer.valueOf(intValue));
        if (softReference == null) {
            bitmap = null;
        } else {
            bitmap = (Bitmap) softReference.get();
        }
        if (bitmap == null) {
            Bitmap a = com.baidu.tieba.c.e.a(this.d, intValue);
            this.c.put(Integer.valueOf(intValue), new SoftReference(a));
            return a;
        }
        return bitmap;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            ImageView imageView2 = new ImageView(this.d);
            imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int a = com.baidu.tieba.c.ah.a(this.d, 50.0f);
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
        int intValue = ((Integer) this.b.get(i)).intValue();
        for (Map.Entry entry : this.a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == intValue) {
                return (String) entry.getKey();
            }
        }
        return null;
    }
}
