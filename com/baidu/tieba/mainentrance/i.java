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
public class i extends BaseAdapter {
    private ArrayList<String> Xk;
    private final String aTU;
    private boolean bUw = true;
    private final Context mContext;

    public i(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.Xk = arrayList;
        this.aTU = this.mContext.getText(i.h.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.Xk = arrayList;
    }

    public void dL(boolean z) {
        this.bUw = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xk == null) {
            return 0;
        }
        return this.Xk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Xk.get(i);
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
            aVar.aNK = (TextView) view.findViewById(i.f.home_lv_search_forum);
            aVar.aCK = view.findViewById(i.f.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.bUw) {
                aVar.aNK.setText(str.concat(this.aTU));
            } else {
                aVar.aNK.setText(str);
            }
            com.baidu.tbadk.core.util.an.b(aVar.aNK, i.c.cp_cont_b, 1);
            com.baidu.tbadk.core.util.an.j(aVar.aCK, i.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.an.i(view, i.e.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        View aCK;
        TextView aNK;

        private a() {
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }
    }
}
