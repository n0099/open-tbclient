package com.baidu.tieba.write;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    boolean b;
    private Context d;
    private com.baidu.tieba.c.a e;
    private ArrayList c = null;
    private boolean f = false;
    private boolean g = false;
    boolean a = false;
    private ArrayList h = new ArrayList();

    public k(Context context, boolean z) {
        this.d = null;
        this.e = null;
        this.b = false;
        this.d = context;
        this.e = new com.baidu.tieba.c.a(this.d);
        this.b = z;
    }

    public void a() {
        if (this.h == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                this.h.clear();
                return;
            }
            try {
                ((ProgressBar) this.h.get(i2)).setVisibility(8);
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    public void a(ArrayList arrayList) {
        this.c = arrayList;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b() {
        this.a = false;
        if (this.c == null || this.c.size() != 0) {
            return;
        }
        this.a = true;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public com.baidu.tieba.c.a c() {
        return this.e;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a) {
            return 1;
        }
        int size = this.c != null ? this.c.size() : 0;
        return this.f ? size + 1 : size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.c == null || i >= this.c.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.a) {
            return 0;
        }
        return (this.c == null || i >= this.c.size()) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        View view2;
        if (this.c != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.d);
                l lVar2 = new l(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.at_list_item, (ViewGroup) null);
                    lVar2.a = (ImageView) inflate.findViewById(R.id.photo);
                    lVar2.a.setBackgroundDrawable(new BitmapDrawable(com.baidu.tieba.c.e.a((int) R.drawable.photo_bg)));
                    lVar2.b = (TextView) inflate.findViewById(R.id.name);
                    lVar2.d = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    lVar2.b = (TextView) inflate2.findViewById(R.id.page_text);
                    lVar2.c = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.h.add(lVar2.c);
                    view2 = inflate2;
                }
                view2.setTag(lVar2);
                lVar = lVar2;
                view = view2;
            } else {
                lVar = (l) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.a) {
                    lVar.a.setVisibility(8);
                    lVar.b.setVisibility(8);
                    lVar.d.setVisibility(0);
                    if (this.b) {
                        lVar.d.setText(R.string.not_have_attention);
                    } else {
                        lVar.d.setText(R.string.not_have_fans);
                    }
                } else {
                    lVar.a.setVisibility(0);
                    lVar.b.setVisibility(0);
                    lVar.d.setVisibility(8);
                    String d = ((com.baidu.tieba.a.ah) this.c.get(i)).d();
                    Bitmap b = this.e.b(d);
                    if (b != null) {
                        lVar.a.setTag(null);
                        lVar.a.setImageBitmap(b);
                    } else {
                        lVar.a.setTag(d);
                        lVar.a.setImageBitmap(com.baidu.tieba.c.e.a((int) R.drawable.photo));
                    }
                    lVar.b.setText(((com.baidu.tieba.a.ah) this.c.get(i)).c());
                }
            } else if (this.g) {
                lVar.b.setText(this.d.getString(R.string.loading));
                lVar.c.setVisibility(0);
            } else {
                lVar.b.setText(this.d.getString(R.string.load_more));
                lVar.c.setVisibility(8);
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.a) {
            return false;
        }
        return super.isEnabled(i);
    }
}
