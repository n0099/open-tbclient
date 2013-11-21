package com.baidu.tieba.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class i extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f2237a;
    private com.baidu.tieba.model.e b;
    private boolean c = false;
    private View.OnClickListener d = null;
    private boolean e = false;

    public i(Context context, com.baidu.tieba.model.e eVar) {
        this.f2237a = context;
        this.b = eVar;
    }

    public void a(boolean z) {
        this.c = z;
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
        ForumData forumData;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.f2237a).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    kVar = new k(this);
                    kVar.f2238a = (TextView) view3.findViewById(R.id.name);
                    kVar.b = new StringBuffer(10);
                    kVar.c = (TextView) view3.findViewById(R.id.degree);
                    kVar.d = new StringBuffer(10);
                    kVar.e = (ImageButton) view3.findViewById(R.id.item_delete);
                    view3.setTag(kVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.tieba.util.bg.b(getClass().getName(), "getView", exc.getMessage());
                    return view2;
                }
            } else {
                kVar = (k) view.getTag();
                view3 = view;
            }
            if (this.e) {
                kVar.c.setVisibility(8);
                kVar.e.setVisibility(8);
                kVar.f2238a.setVisibility(8);
            } else {
                kVar.c.setVisibility(0);
                kVar.e.setVisibility(0);
                kVar.f2238a.setVisibility(0);
            }
            if (this.b != null && this.b.a() != null && i >= 0 && i < this.b.a().size() && (forumData = this.b.a().get(i)) != null) {
                kVar.b.delete(0, kVar.b.length());
                kVar.b.append(forumData.getName());
                kVar.b.append(this.f2237a.getString(R.string.bar));
                kVar.f2238a.setText(kVar.b);
                kVar.d.delete(0, kVar.d.length());
                kVar.d.append(this.f2237a.getString(R.string.degree));
                kVar.d.append(forumData.getUser_level());
                kVar.c.setText(kVar.d);
                kVar.c.setVisibility(0);
                kVar.e.setOnClickListener(this.d);
                kVar.e.setTag(Integer.valueOf(i));
                if (this.c) {
                    kVar.e.setVisibility(0);
                } else {
                    kVar.e.setVisibility(8);
                }
            }
            if (TiebaApplication.g().ap() == 1) {
                int a2 = com.baidu.tieba.util.bd.a(1);
                kVar.f2238a.setTextColor(a2);
                kVar.c.setTextColor(a2);
            } else {
                kVar.f2238a.setTextColor(-12895429);
                kVar.c.setTextColor(-12895429);
            }
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
