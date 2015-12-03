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
    private ArrayList<String> XX;
    private final String aZi;
    private boolean ckJ = true;
    private final Context mContext;

    public i(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.XX = arrayList;
        this.aZi = this.mContext.getText(n.i.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.XX = arrayList;
    }

    public void ek(boolean z) {
        this.ckJ = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XX == null) {
            return 0;
        }
        return this.XX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.XX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(n.g.home_dialog_search_item, (ViewGroup) null);
            aVar = new a(this, null);
            aVar.aLY = (TextView) view.findViewById(n.f.home_lv_search_forum);
            aVar.aFH = view.findViewById(n.f.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.ckJ) {
                aVar.aLY.setText(str.concat(this.aZi));
            } else {
                aVar.aLY.setText(str);
            }
            com.baidu.tbadk.core.util.as.b(aVar.aLY, n.c.cp_cont_b, 1);
            com.baidu.tbadk.core.util.as.j(aVar.aFH, n.c.cp_bg_line_b);
            com.baidu.tbadk.core.util.as.i(view, n.e.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        View aFH;
        TextView aLY;

        private a() {
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }
    }
}
