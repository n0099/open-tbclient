package com.baidu.tieba.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.b.b b;
    private boolean c = false;
    private View.OnClickListener d = null;
    private boolean e = false;

    public g(Context context, com.baidu.tieba.b.b bVar) {
        this.a = context;
        this.b = bVar;
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a() {
        return this.c;
    }

    public void b() {
        this.e = false;
        if (this.b != null) {
            if (this.b.a() == null || this.b.a().size() == 0) {
                this.e = true;
            }
        }
    }

    public boolean c() {
        return this.e;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.e) {
            return 1;
        }
        if (this.b == null || this.b.a() == null) {
            return 0;
        }
        return this.b.a().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || this.b.a() == null || i < 0 || i >= this.b.a().size()) {
            return null;
        }
        return this.b.a().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        h hVar;
        View view3;
        com.baidu.tieba.a.p pVar;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    hVar = new h(this, null);
                    hVar.a = (TextView) view3.findViewById(R.id.name);
                    hVar.b = new StringBuffer(10);
                    hVar.c = (TextView) view3.findViewById(R.id.degree);
                    hVar.d = new StringBuffer(10);
                    hVar.f = (ImageButton) view3.findViewById(R.id.item_delete);
                    hVar.e = (TextView) view3.findViewById(R.id.edit_bar_nodata);
                    view3.setTag(hVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.c.ae.b(getClass().getName(), "getView", exc.getMessage());
                    return view2;
                }
            } else {
                hVar = (h) view.getTag();
                view3 = view;
            }
            if (this.e) {
                hVar.c.setVisibility(8);
                hVar.f.setVisibility(8);
                hVar.a.setVisibility(8);
                hVar.e.setVisibility(0);
            } else {
                hVar.c.setVisibility(0);
                hVar.f.setVisibility(0);
                hVar.a.setVisibility(0);
                hVar.e.setVisibility(8);
            }
            if (this.b == null || this.b.a() == null || i < 0 || i >= this.b.a().size() || (pVar = (com.baidu.tieba.a.p) this.b.a().get(i)) == null) {
                return view3;
            }
            hVar.b.delete(0, hVar.b.length());
            hVar.b.append(pVar.c());
            hVar.b.append(this.a.getString(R.string.bar));
            hVar.a.setText(hVar.b);
            hVar.d.delete(0, hVar.d.length());
            hVar.d.append(this.a.getString(R.string.degree));
            hVar.d.append(pVar.e());
            hVar.c.setText(hVar.d);
            hVar.c.setVisibility(0);
            hVar.f.setOnClickListener(this.d);
            hVar.f.setTag(Integer.valueOf(i));
            if (this.c) {
                hVar.f.setVisibility(0);
                return view3;
            }
            hVar.f.setVisibility(8);
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.e) {
            return false;
        }
        return super.isEnabled(i);
    }
}
