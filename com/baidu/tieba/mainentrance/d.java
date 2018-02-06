package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private ArrayList<String> aSi;
    private final String dEq;
    private boolean fhb = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.aSi = arrayList;
        this.dEq = this.mContext.getText(d.j.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aSi = arrayList;
    }

    public void iB(boolean z) {
        this.fhb = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aSi == null) {
            return 0;
        }
        return this.aSi.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.aSi.get(i);
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
            aVar.beO = (TextView) view.findViewById(d.g.home_lv_search_forum);
            aVar.bQs = view.findViewById(d.g.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.fhb) {
                aVar.beO.setText(str.concat(this.dEq));
            } else {
                aVar.beO.setText(str);
            }
            aj.e(aVar.beO, d.C0140d.cp_cont_b, 1);
            aj.t(aVar.bQs, d.C0140d.cp_bg_line_b);
            aj.s(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        View bQs;
        TextView beO;

        private a() {
        }
    }
}
