package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    private ArrayList<String> Xe;
    private final String aUq;
    private boolean bPC = true;
    private final Context mContext;

    public f(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.Xe = arrayList;
        this.aUq = this.mContext.getText(i.C0057i.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.Xe = arrayList;
    }

    public void dE(boolean z) {
        this.bPC = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xe == null) {
            return 0;
        }
        return this.Xe.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Xe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(i.g.home_dialog_search_item, (ViewGroup) null);
            aVar = new a(this, null);
            aVar.aOi = (TextView) view.findViewById(i.f.home_lv_search_forum);
            aVar.aCS = view.findViewById(i.f.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.bPC) {
                aVar.aOi.setText(str.concat(this.aUq));
            } else {
                aVar.aOi.setText(str);
            }
            com.baidu.tbadk.core.util.al.b(aVar.aOi, i.c.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.j(aVar.aCS, i.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.i(view, i.e.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        View aCS;
        TextView aOi;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
