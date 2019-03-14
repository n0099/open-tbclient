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
    private ArrayList<String> aFI;
    private final String eYK;
    private boolean gMT = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.aFI = arrayList;
        this.eYK = this.mContext.getText(d.j.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aFI = arrayList;
    }

    public void mf(boolean z) {
        this.gMT = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aFI == null) {
            return 0;
        }
        return this.aFI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.aFI.get(i);
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
            aVar.bSY = (TextView) view.findViewById(d.g.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(d.g.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.gMT) {
                aVar.bSY.setText(str.concat(this.eYK));
            } else {
                aVar.bSY.setText(str);
            }
            al.d(aVar.bSY, d.C0277d.cp_cont_b, 1);
            al.l(aVar.dividerLine, d.C0277d.cp_bg_line_b);
            al.k(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView bSY;
        View dividerLine;

        private a() {
        }
    }
}
