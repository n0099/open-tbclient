package com.baidu.tieba.mainentrance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    private ArrayList<String> cRO;
    private final String gmb;
    private boolean icE = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.cRO = arrayList;
        this.gmb = this.mContext.getText(R.string.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.cRO = arrayList;
    }

    public void oA(boolean z) {
        this.icE = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.cRO.get(i);
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
            aVar.ddX = (TextView) view.findViewById(R.id.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(R.id.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.icE) {
                aVar.ddX.setText(str.concat(this.gmb));
            } else {
                aVar.ddX.setText(str);
            }
            am.setViewTextColor(aVar.ddX, R.color.cp_cont_b, 1);
            am.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes9.dex */
    private class a {
        TextView ddX;
        View dividerLine;

        private a() {
        }
    }
}
