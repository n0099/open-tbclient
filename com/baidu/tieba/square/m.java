package com.baidu.tieba.square;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ae;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    View.OnClickListener a = new n(this);
    private Activity b;
    private final p c;
    private final String d;
    private final String e;

    public m(Activity activity, p pVar, String str, String str2) {
        this.b = activity;
        this.d = str;
        this.e = str2;
        this.c = pVar;
    }

    public p a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        q c = this.c.c();
        if (c == null || c.e == null) {
            return 0;
        }
        return (c.e.size() * 2) - 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(viewGroup, itemViewType);
            ae.b(view);
        }
        ae.a(view);
        if (itemViewType != 3) {
            int at = TiebaApplication.f().at();
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
            ae.a(findViewById, itemViewType, at);
            a(viewGroup, (o) view.getTag(), i);
        }
        return view;
    }

    private View a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 3) {
            return from.inflate(R.layout.bar_home_list_line, viewGroup, false);
        }
        View inflate = from.inflate(R.layout.bar_folder_second_dir_item, viewGroup, false);
        inflate.setOnClickListener(this.a);
        o oVar = new o();
        oVar.a = (TextView) inflate.findViewById(R.id.name);
        inflate.setTag(oVar);
        return inflate;
    }

    private void a(ViewGroup viewGroup, o oVar, int i) {
        q qVar = (q) this.c.c().e.get(i / 2);
        oVar.b = qVar;
        oVar.a.setText(qVar.b);
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
        return i % 2 == 1 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity b() {
        return this.b;
    }
}
