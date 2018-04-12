package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private ArrayList<String> adv;
    private final String cXd;
    private boolean eBI = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.adv = arrayList;
        this.cXd = this.mContext.getText(d.k.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.adv = arrayList;
    }

    public void id(boolean z) {
        this.eBI = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.adv == null) {
            return 0;
        }
        return this.adv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.adv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"ResourceAsColor"})
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mContext).inflate(d.i.home_dialog_search_item, (ViewGroup) null);
            aVar = new a();
            aVar.apV = (TextView) view2.findViewById(d.g.home_lv_search_forum);
            aVar.bae = view2.findViewById(d.g.home_dialog_lv_search_forum_divider);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.eBI) {
                aVar.apV.setText(str.concat(this.cXd));
            } else {
                aVar.apV.setText(str);
            }
            ak.c(aVar.apV, d.C0126d.cp_cont_b, 1);
            ak.j(aVar.bae, d.C0126d.cp_bg_line_b);
            ak.i(view2, d.f.addresslist_item_bg);
        }
        return view2;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView apV;
        View bae;

        private a() {
        }
    }
}
