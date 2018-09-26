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
    private ArrayList<String> anX;
    private final String dsd;
    private boolean fdj = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.anX = arrayList;
        this.dsd = this.mContext.getText(e.j.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.anX = arrayList;
    }

    public void iW(boolean z) {
        this.fdj = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anX == null) {
            return 0;
        }
        return this.anX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.anX.get(i);
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
            aVar.aAN = (TextView) view.findViewById(e.g.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(e.g.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.fdj) {
                aVar.aAN.setText(str.concat(this.dsd));
            } else {
                aVar.aAN.setText(str);
            }
            al.c(aVar.aAN, e.d.cp_cont_b, 1);
            al.j(aVar.dividerLine, e.d.cp_bg_line_b);
            al.i(view, e.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView aAN;
        View dividerLine;

        private a() {
        }
    }
}
