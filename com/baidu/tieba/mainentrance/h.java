package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private ArrayList<String> SE;
    private final String bgf;
    private boolean cLn = true;
    private final Context mContext;

    public h(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.SE = arrayList;
        this.bgf = this.mContext.getText(t.j.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.SE = arrayList;
    }

    public void ft(boolean z) {
        this.cLn = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.SE == null) {
            return 0;
        }
        return this.SE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.SE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(t.h.home_dialog_search_item, (ViewGroup) null);
            aVar = new a(this, null);
            aVar.aZB = (TextView) view.findViewById(t.g.home_lv_search_forum);
            aVar.aHq = view.findViewById(t.g.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.cLn) {
                aVar.aZB.setText(str.concat(this.bgf));
            } else {
                aVar.aZB.setText(str);
            }
            com.baidu.tbadk.core.util.at.c(aVar.aZB, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.l(aVar.aHq, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(view, t.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        View aHq;
        TextView aZB;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
