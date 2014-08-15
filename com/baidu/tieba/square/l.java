package com.baidu.tieba.square;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bo;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    View.OnClickListener a = new m(this);
    private Activity b;
    private final o c;
    private final String d;
    private final String e;

    public l(Activity activity, o oVar, String str, String str2) {
        this.b = activity;
        this.d = str;
        this.e = str2;
        this.c = oVar;
    }

    public o a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        w d = this.c.d();
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
            bo.b(view);
        }
        bo.a(view);
        if (itemViewType != 3) {
            int skinType = TbadkApplication.m252getInst().getSkinType();
            View findViewById = view.findViewById(com.baidu.tieba.u.container);
            View findViewById2 = view.findViewById(com.baidu.tieba.u.item_up);
            View findViewById3 = view.findViewById(com.baidu.tieba.u.item_down);
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
            bo.a(findViewById, itemViewType, skinType);
            a(viewGroup, (n) view.getTag(), i);
        }
        return view;
    }

    private View a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 3) {
            return from.inflate(com.baidu.tieba.v.bar_home_list_line, viewGroup, false);
        }
        View inflate = from.inflate(com.baidu.tieba.v.bar_folder_second_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.a);
        n nVar = new n();
        nVar.a = (TextView) inflate.findViewById(com.baidu.tieba.u.name);
        inflate.setTag(nVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, n nVar, int i) {
        w wVar = this.c.d().e.get(i / 2);
        nVar.b = wVar;
        nVar.a.setText(wVar.b);
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
