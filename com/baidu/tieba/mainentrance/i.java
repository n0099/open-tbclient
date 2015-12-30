package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private ArrayList<String> YA;
    private final String bde;
    private boolean coN = true;
    private final Context mContext;

    public i(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.YA = arrayList;
        this.bde = this.mContext.getText(n.j.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.YA = arrayList;
    }

    public void ek(boolean z) {
        this.coN = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YA == null) {
            return 0;
        }
        return this.YA.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.YA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.h.home_dialog_search_item, (ViewGroup) null);
            aVar = new a(this, null);
            aVar.aNz = (TextView) view.findViewById(n.g.home_lv_search_forum);
            aVar.aHh = view.findViewById(n.g.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.coN) {
                aVar.aNz.setText(str.concat(this.bde));
            } else {
                aVar.aNz.setText(str);
            }
            com.baidu.tbadk.core.util.as.b(aVar.aNz, n.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.as.j(aVar.aHh, n.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.as.i(view, n.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        View aHh;
        TextView aNz;

        private a() {
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }
    }
}
