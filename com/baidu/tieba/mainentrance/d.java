package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class d extends BaseAdapter {
    private ArrayList<String> dWx;
    private final String hFr;
    private boolean jGd = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.dWx = arrayList;
        this.hFr = this.mContext.getText(R.string.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.dWx = arrayList;
    }

    public void ra(boolean z) {
        this.jGd = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dWx == null) {
            return 0;
        }
        return this.dWx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.dWx.get(i);
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
            aVar.ekx = (TextView) view.findViewById(R.id.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(R.id.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.jGd) {
                aVar.ekx.setText(str.concat(this.hFr));
            } else {
                aVar.ekx.setText(str);
            }
            ao.setViewTextColor(aVar.ekx, R.color.cp_cont_b, 1);
            ao.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes18.dex */
    private class a {
        View dividerLine;
        TextView ekx;

        private a() {
        }
    }
}
