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
    private ArrayList<String> Xq;
    private final String bkf;
    private boolean cKr = true;
    private final Context mContext;

    public h(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.Xq = arrayList;
        this.bkf = this.mContext.getText(t.j.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.Xq = arrayList;
    }

    public void eV(boolean z) {
        this.cKr = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xq == null) {
            return 0;
        }
        return this.Xq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Xq.get(i);
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
            aVar.aRQ = (TextView) view.findViewById(t.g.home_lv_search_forum);
            aVar.aLf = view.findViewById(t.g.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.cKr) {
                aVar.aRQ.setText(str.concat(this.bkf));
            } else {
                aVar.aRQ.setText(str);
            }
            com.baidu.tbadk.core.util.at.b(aVar.aRQ, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.l(aVar.aLf, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.k(view, t.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        View aLf;
        TextView aRQ;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }
}
