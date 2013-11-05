package com.baidu.tieba.square;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bj;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class o extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f2371a = new p(this);
    private Activity b;
    private final r c;
    private final String d;
    private final String e;

    public o(Activity activity, r rVar, String str, String str2) {
        this.b = activity;
        this.d = str;
        this.e = str2;
        this.c = rVar;
    }

    public r a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        s d = this.c.d();
        if (d == null || d.e == null) {
            return 0;
        }
        return (d.e.size() * 2) - 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(viewGroup, itemViewType);
            bj.b(view);
        }
        bj.a(view);
        if (itemViewType != 3) {
            int as = TiebaApplication.g().as();
            View findViewById = view.findViewById(R.id.container);
            View findViewById2 = view.findViewById(R.id.item_up);
            View findViewById3 = view.findViewById(R.id.item_down);
            if (itemViewType == 0) {
                findViewById2.setVisibility(0);
                findViewById3.setVisibility(8);
            } else if (itemViewType == 2) {
                findViewById2.setVisibility(8);
                findViewById3.setVisibility(0);
            } else {
                findViewById2.setVisibility(8);
                findViewById3.setVisibility(8);
            }
            bj.a(findViewById, itemViewType, as);
            a(viewGroup, (q) view.getTag(), i);
        }
        return view;
    }

    private View a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 3) {
            return from.inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        View inflate = from.inflate(R.layout.bar_folder_second_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.f2371a);
        q qVar = new q();
        qVar.f2373a = (TextView) inflate.findViewById(R.id.name);
        inflate.setTag(qVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, q qVar, int i) {
        s sVar = this.c.d().e.get(i / 2);
        qVar.b = sVar;
        qVar.f2373a.setText(sVar.b);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == getCount() - 1) {
            return 2;
        }
        if (i % 2 != 0) {
            return 3;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity b() {
        return this.b;
    }
}
