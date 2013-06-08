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
public class i extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.c.b b;
    private boolean c = false;
    private View.OnClickListener d = null;
    private boolean e = false;
    private boolean f = true;

    public i(Context context, com.baidu.tieba.c.b bVar) {
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
        j jVar;
        View view3;
        com.baidu.tieba.a.s sVar;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    jVar = new j(this, null);
                    jVar.a = (TextView) view3.findViewById(R.id.name);
                    jVar.b = new StringBuffer(10);
                    jVar.c = (TextView) view3.findViewById(R.id.degree);
                    jVar.d = new StringBuffer(10);
                    jVar.f = (ImageButton) view3.findViewById(R.id.item_delete);
                    jVar.e = (TextView) view3.findViewById(R.id.edit_bar_nodata);
                    view3.setTag(jVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.d.ae.b(getClass().getName(), "getView", exc.getMessage());
                    return view2;
                }
            } else {
                jVar = (j) view.getTag();
                view3 = view;
            }
            if (this.e) {
                jVar.c.setVisibility(8);
                jVar.f.setVisibility(8);
                jVar.a.setVisibility(8);
                if (this.f) {
                    jVar.e.setText(this.a.getString(R.string.not_have_like_bars));
                } else {
                    jVar.e.setText(this.a.getString(R.string.no_like_forum_other));
                }
                jVar.e.setVisibility(0);
            } else {
                jVar.c.setVisibility(0);
                jVar.f.setVisibility(0);
                jVar.a.setVisibility(0);
                jVar.e.setVisibility(8);
            }
            if (this.b != null && this.b.a() != null && i >= 0 && i < this.b.a().size() && (sVar = (com.baidu.tieba.a.s) this.b.a().get(i)) != null) {
                jVar.b.delete(0, jVar.b.length());
                jVar.b.append(sVar.b());
                jVar.b.append(this.a.getString(R.string.bar));
                jVar.a.setText(jVar.b);
                jVar.d.delete(0, jVar.d.length());
                jVar.d.append(this.a.getString(R.string.degree));
                jVar.d.append(sVar.f());
                jVar.c.setText(jVar.d);
                jVar.c.setVisibility(0);
                jVar.f.setOnClickListener(this.d);
                jVar.f.setTag(Integer.valueOf(i));
                if (this.c) {
                    jVar.f.setVisibility(0);
                } else {
                    jVar.f.setVisibility(8);
                }
            }
            if (TiebaApplication.d().ar() == 1) {
                int a = com.baidu.tieba.d.ac.a(1);
                jVar.a.setTextColor(a);
                jVar.c.setTextColor(a);
                jVar.e.setTextColor(a);
                return view3;
            }
            jVar.a.setTextColor(-12895429);
            jVar.c.setTextColor(-12895429);
            jVar.e.setTextColor(-4276546);
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
