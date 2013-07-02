package com.baidu.tieba.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.model.b b;
    private boolean c = false;
    private View.OnClickListener d = null;
    private boolean e = false;
    private boolean f = true;

    public j(Context context, com.baidu.tieba.model.b bVar) {
        this.a = context;
        this.b = bVar;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.e) {
            return 1;
        }
        if (this.b != null && this.b.a() != null) {
            return this.b.a().size();
        }
        return 0;
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
        k kVar;
        View view3;
        com.baidu.tieba.data.r rVar;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    kVar = new k(this, null);
                    kVar.a = (TextView) view3.findViewById(R.id.name);
                    kVar.b = new StringBuffer(10);
                    kVar.c = (TextView) view3.findViewById(R.id.degree);
                    kVar.d = new StringBuffer(10);
                    kVar.f = (ImageButton) view3.findViewById(R.id.item_delete);
                    kVar.e = (TextView) view3.findViewById(R.id.edit_bar_nodata);
                    view3.setTag(kVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.util.z.b(getClass().getName(), "getView", exc.getMessage());
                    return view2;
                }
            } else {
                kVar = (k) view.getTag();
                view3 = view;
            }
            if (this.e) {
                kVar.c.setVisibility(8);
                kVar.f.setVisibility(8);
                kVar.a.setVisibility(8);
                if (this.f) {
                    kVar.e.setText(this.a.getString(R.string.not_have_like_bars));
                } else {
                    kVar.e.setText(this.a.getString(R.string.no_like_forum_other));
                }
                kVar.e.setVisibility(0);
            } else {
                kVar.c.setVisibility(0);
                kVar.f.setVisibility(0);
                kVar.a.setVisibility(0);
                kVar.e.setVisibility(8);
            }
            if (this.b != null && this.b.a() != null && i >= 0 && i < this.b.a().size() && (rVar = (com.baidu.tieba.data.r) this.b.a().get(i)) != null) {
                kVar.b.delete(0, kVar.b.length());
                kVar.b.append(rVar.b());
                kVar.b.append(this.a.getString(R.string.bar));
                kVar.a.setText(kVar.b);
                kVar.d.delete(0, kVar.d.length());
                kVar.d.append(this.a.getString(R.string.degree));
                kVar.d.append(rVar.f());
                kVar.c.setText(kVar.d);
                kVar.c.setVisibility(0);
                kVar.f.setOnClickListener(this.d);
                kVar.f.setTag(Integer.valueOf(i));
                if (this.c) {
                    kVar.f.setVisibility(0);
                } else {
                    kVar.f.setVisibility(8);
                }
            }
            if (TiebaApplication.f().at() == 1) {
                int a = com.baidu.tieba.util.x.a(1);
                kVar.a.setTextColor(a);
                kVar.c.setTextColor(a);
                kVar.e.setTextColor(a);
                return view3;
            }
            kVar.a.setTextColor(-12895429);
            kVar.c.setTextColor(-12895429);
            kVar.e.setTextColor(-4276546);
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.e) {
            return false;
        }
        return super.isEnabled(i);
    }
}
