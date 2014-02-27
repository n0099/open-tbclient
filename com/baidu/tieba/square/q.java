package com.baidu.tieba.square;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ch;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class q extends BaseAdapter {
    View.OnClickListener a = new r(this);
    private Activity b;
    private final t c;
    private final String d;
    private final String e;

    public q(Activity activity, t tVar, String str, String str2) {
        this.b = activity;
        this.d = str;
        this.e = str2;
        this.c = tVar;
    }

    public final t a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ab d = this.c.d();
        if (d == null || d.e == null) {
            return 0;
        }
        return (d.e.size() * 2) - 1;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.b);
            if (itemViewType == 3) {
                view2 = from.inflate(R.layout.bar_home_list_line, viewGroup, false);
            } else {
                View inflate = from.inflate(R.layout.bar_folder_second_dir_item, viewGroup, false);
                inflate.setOnClickListener(this.a);
                s sVar = new s();
                sVar.a = (TextView) inflate.findViewById(R.id.name);
                inflate.setTag(sVar);
                view2 = inflate;
            }
            ch.b(view2);
            view = view2;
        }
        ch.a(view);
        if (itemViewType != 3) {
            int ae = TiebaApplication.g().ae();
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
            ch.a(findViewById, itemViewType, ae);
            s sVar2 = (s) view.getTag();
            ab abVar = this.c.d().e.get(i / 2);
            sVar2.b = abVar;
            sVar2.a.setText(abVar.b);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
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
    public final Activity b() {
        return this.b;
    }
}
