package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private ArrayList<String> aFM;
    private final String eYx;
    private boolean gMH = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.aFM = arrayList;
        this.eYx = this.mContext.getText(d.j.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aFM = arrayList;
    }

    public void mf(boolean z) {
        this.gMH = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFM == null) {
            return 0;
        }
        return this.aFM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.aFM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"ResourceAsColor"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(d.h.home_dialog_search_item, (ViewGroup) null);
            aVar = new a();
            aVar.bTb = (TextView) view.findViewById(d.g.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(d.g.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.gMH) {
                aVar.bTb.setText(str.concat(this.eYx));
            } else {
                aVar.bTb.setText(str);
            }
            al.d(aVar.bTb, d.C0277d.cp_cont_b, 1);
            al.l(aVar.dividerLine, d.C0277d.cp_bg_line_b);
            al.k(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView bTb;
        View dividerLine;

        private a() {
        }
    }
}
