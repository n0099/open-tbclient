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

    /* renamed from: a  reason: collision with root package name */
    private Context f1695a;
    private com.baidu.tieba.model.d b;
    private boolean c = false;
    private View.OnClickListener d = null;
    private boolean e = false;
    private boolean f = true;
    private int g;

    public i(Context context, com.baidu.tieba.model.d dVar, int i) {
        this.g = 0;
        this.f1695a = context;
        this.b = dVar;
        this.g = i;
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
        com.baidu.tieba.data.v vVar;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.f1695a).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    jVar = new j(this, null);
                    jVar.f1696a = (TextView) view3.findViewById(R.id.name);
                    jVar.b = new StringBuffer(10);
                    jVar.c = (TextView) view3.findViewById(R.id.degree);
                    jVar.d = new StringBuffer(10);
                    jVar.f = (ImageButton) view3.findViewById(R.id.item_delete);
                    jVar.e = (TextView) view3.findViewById(R.id.edit_bar_nodata);
                    view3.setTag(jVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.util.av.b(getClass().getName(), "getView", exc.getMessage());
                    return view2;
                }
            } else {
                jVar = (j) view.getTag();
                view3 = view;
            }
            if (this.e) {
                jVar.c.setVisibility(8);
                jVar.f.setVisibility(8);
                jVar.f1696a.setVisibility(8);
                if (this.f) {
                    jVar.e.setText(this.f1695a.getString(R.string.not_have_like_bars));
                } else if (this.g == 2) {
                    jVar.e.setText(this.f1695a.getString(R.string.she_no_like_forum_other));
                } else if (this.g == 1) {
                    jVar.e.setText(this.f1695a.getString(R.string.he_no_like_forum_other));
                } else {
                    jVar.e.setText(this.f1695a.getString(R.string.no_like_forum_other));
                }
                jVar.e.setVisibility(0);
            } else {
                jVar.c.setVisibility(0);
                jVar.f.setVisibility(0);
                jVar.f1696a.setVisibility(0);
                jVar.e.setVisibility(8);
            }
            if (this.b != null && this.b.a() != null && i >= 0 && i < this.b.a().size() && (vVar = this.b.a().get(i)) != null) {
                jVar.b.delete(0, jVar.b.length());
                jVar.b.append(vVar.b());
                jVar.b.append(this.f1695a.getString(R.string.bar));
                jVar.f1696a.setText(jVar.b);
                jVar.d.delete(0, jVar.d.length());
                jVar.d.append(this.f1695a.getString(R.string.degree));
                jVar.d.append(vVar.f());
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
            if (TiebaApplication.g().ap() == 1) {
                int a2 = com.baidu.tieba.util.as.a(1);
                jVar.f1696a.setTextColor(a2);
                jVar.c.setTextColor(a2);
                jVar.e.setTextColor(a2);
                return view3;
            }
            jVar.f1696a.setTextColor(-12895429);
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
