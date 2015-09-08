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
    private ArrayList<String> Xn;
    private final String aUF;
    private boolean bQi = true;
    private final Context mContext;

    public f(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.Xn = arrayList;
        this.aUF = this.mContext.getText(i.h.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.Xn = arrayList;
    }

    public void dJ(boolean z) {
        this.bQi = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xn == null) {
            return 0;
        }
        return this.Xn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Xn.get(i);
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
            aVar.aOv = (TextView) view.findViewById(i.f.home_lv_search_forum);
            aVar.aEA = view.findViewById(i.f.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.bQi) {
                aVar.aOv.setText(str.concat(this.aUF));
            } else {
                aVar.aOv.setText(str);
            }
            com.baidu.tbadk.core.util.al.b(aVar.aOv, i.c.cp_cont_b, 1);
            com.baidu.tbadk.core.util.al.i(aVar.aEA, i.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.h(view, i.e.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        View aEA;
        TextView aOv;

        private a() {
        }

        /* synthetic */ a(f fVar, a aVar) {
            this();
        }
    }
}
