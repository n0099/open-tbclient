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
/* loaded from: classes11.dex */
public class d extends BaseAdapter {
    private ArrayList<String> cVQ;
    private final String goc;
    private boolean ieF = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.cVQ = arrayList;
        this.goc = this.mContext.getText(R.string.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.cVQ = arrayList;
    }

    public void oC(boolean z) {
        this.ieF = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cVQ == null) {
            return 0;
        }
        return this.cVQ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.cVQ.get(i);
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
            aVar.dib = (TextView) view.findViewById(R.id.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(R.id.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.ieF) {
                aVar.dib.setText(str.concat(this.goc));
            } else {
                aVar.dib.setText(str);
            }
            am.setViewTextColor(aVar.dib, R.color.cp_cont_b, 1);
            am.setBackgroundColor(aVar.dividerLine, R.color.cp_bg_line_c);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes11.dex */
    private class a {
        TextView dib;
        View dividerLine;

        private a() {
        }
    }
}
