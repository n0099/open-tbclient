package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class d extends BaseAdapter {
    private ArrayList<String> eiq;
    private final String hZN;
    private boolean kec = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.eiq = arrayList;
        this.hZN = this.mContext.getText(R.string.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.eiq = arrayList;
    }

    public void rQ(boolean z) {
        this.kec = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eiq == null) {
            return 0;
        }
        return this.eiq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.eiq.get(i);
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
            aVar.ewA = (TextView) view.findViewById(R.id.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(R.id.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.kec) {
                aVar.ewA.setText(str.concat(this.hZN));
            } else {
                aVar.ewA.setText(str);
            }
            ap.setViewTextColor(aVar.ewA, R.color.cp_cont_b, 1);
            ap.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes23.dex */
    private class a {
        View dividerLine;
        TextView ewA;

        private a() {
        }
    }
}
