package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private ArrayList<String> aHF;
    private final String foI;
    private boolean hed = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.aHF = arrayList;
        this.foI = this.mContext.getText(R.string.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aHF = arrayList;
    }

    public void mU(boolean z) {
        this.hed = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aHF == null) {
            return 0;
        }
        return this.aHF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.aHF.get(i);
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
            view = LayoutInflater.from(this.mContext).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
            aVar = new a();
            aVar.caT = (TextView) view.findViewById(R.id.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(R.id.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.hed) {
                aVar.caT.setText(str.concat(this.foI));
            } else {
                aVar.caT.setText(str);
            }
            al.f(aVar.caT, R.color.cp_cont_b, 1);
            al.l(aVar.dividerLine, R.color.cp_bg_line_b);
            al.k(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        TextView caT;
        View dividerLine;

        private a() {
        }
    }
}
