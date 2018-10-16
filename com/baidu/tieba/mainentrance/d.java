package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private final String dAf;
    private boolean fkS = true;
    private final Context mContext;
    private ArrayList<String> mData;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
        this.dAf = this.mContext.getText(e.j.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.mData = arrayList;
    }

    public void jo(boolean z) {
        this.fkS = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.mData.get(i);
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
            view = LayoutInflater.from(this.mContext).inflate(e.h.home_dialog_search_item, (ViewGroup) null);
            aVar = new a();
            aVar.aFu = (TextView) view.findViewById(e.g.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(e.g.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.fkS) {
                aVar.aFu.setText(str.concat(this.dAf));
            } else {
                aVar.aFu.setText(str);
            }
            al.c(aVar.aFu, e.d.cp_cont_b, 1);
            al.j(aVar.dividerLine, e.d.cp_bg_line_b);
            al.i(view, e.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView aFu;
        View dividerLine;

        private a() {
        }
    }
}
