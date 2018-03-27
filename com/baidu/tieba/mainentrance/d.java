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
    private ArrayList<String> aRZ;
    private final String dEh;
    private boolean fhd = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.aRZ = arrayList;
        this.dEh = this.mContext.getText(d.j.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aRZ = arrayList;
    }

    public void iG(boolean z) {
        this.fhd = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRZ == null) {
            return 0;
        }
        return this.aRZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.aRZ.get(i);
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
            aVar.beF = (TextView) view.findViewById(d.g.home_lv_search_forum);
            aVar.bQi = view.findViewById(d.g.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.fhd) {
                aVar.beF.setText(str.concat(this.dEh));
            } else {
                aVar.beF.setText(str);
            }
            aj.e(aVar.beF, d.C0141d.cp_cont_b, 1);
            aj.t(aVar.bQi, d.C0141d.cp_bg_line_b);
            aj.s(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        View bQi;
        TextView beF;

        private a() {
        }
    }
}
