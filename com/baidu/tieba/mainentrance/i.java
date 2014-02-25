package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private final com.baidu.tieba.f a;
    private ArrayList<String> b;
    private final String c;
    private boolean d = true;

    public i(com.baidu.tieba.f fVar, ArrayList<String> arrayList) {
        this.a = fVar;
        this.b = arrayList;
        this.c = this.a.getText(R.string.forum).toString();
    }

    public void a(ArrayList<String> arrayList) {
        this.b = arrayList;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(int i) {
        this.b.remove(i);
        this.b.add(0, this.b.get(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.b.get(i);
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
        Object item;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                try {
                    jVar = new j(this, null);
                    jVar.a = (TextView) view3.findViewById(R.id.home_lv_search_forum);
                    view3.setTag(jVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "", "SearchAdapter.getView error = " + exc.getMessage());
                    a(view2);
                    return view2;
                }
            } else {
                jVar = (j) view.getTag();
                view3 = view;
            }
            item = getItem(i);
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        if (item == null) {
            return view3;
        }
        bq.b(jVar.a, TiebaApplication.g().al());
        String str = (String) item;
        if (this.d) {
            jVar.a.setText(str.concat(this.c));
            view2 = view3;
        } else {
            jVar.a.setText(str);
            view2 = view3;
        }
        a(view2);
        return view2;
    }

    private void a(View view) {
        int al = TiebaApplication.g().al();
        this.a.getLayoutMode().a(al == 1);
        this.a.getLayoutMode().a(view);
        View findViewById = view.findViewById(R.id.parent);
        if (al == 1) {
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.common_list_item_bg_selector_1);
            }
        } else if (findViewById != null) {
            findViewById.setBackgroundResource(R.drawable.common_list_item_bg_selector);
        }
    }
}
