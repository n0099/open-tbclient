package com.baidu.tieba.square;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.br;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
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

    public t a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ab d = this.c.d();
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
            br.b(view);
        }
        br.a(view);
        if (itemViewType != 3) {
            int skinType = TbadkApplication.m252getInst().getSkinType();
            View findViewById = view.findViewById(com.baidu.tieba.v.container);
            View findViewById2 = view.findViewById(com.baidu.tieba.v.item_up);
            View findViewById3 = view.findViewById(com.baidu.tieba.v.item_down);
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
            br.a(findViewById, itemViewType, skinType);
            a(viewGroup, (s) view.getTag(), i);
        }
        return view;
    }

    private View a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 3) {
            return from.inflate(com.baidu.tieba.w.bar_home_list_line, viewGroup, false);
        }
        View inflate = from.inflate(com.baidu.tieba.w.bar_folder_second_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.a);
        s sVar = new s();
        sVar.a = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
        inflate.setTag(sVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, s sVar, int i) {
        ab abVar = this.c.d().e.get(i / 2);
        sVar.b = abVar;
        sVar.a.setText(abVar.b);
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
