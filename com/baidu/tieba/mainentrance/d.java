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
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    private ArrayList<String> eTF;
    private final String jat;
    private boolean lao = true;
    private final Context mContext;

    public d(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.eTF = arrayList;
        this.jat = this.mContext.getText(R.string.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.eTF = arrayList;
    }

    public void tB(boolean z) {
        this.lao = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTF == null) {
            return 0;
        }
        return this.eTF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.eTF.get(i);
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
            aVar.fiz = (TextView) view.findViewById(R.id.home_lv_search_forum);
            aVar.dividerLine = view.findViewById(R.id.home_dialog_lv_search_forum_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.lao) {
                aVar.fiz.setText(str.concat(this.jat));
            } else {
                aVar.fiz.setText(str);
            }
            ao.setViewTextColor(aVar.fiz, R.color.CAM_X0105, 1);
            ao.setBackgroundColor(aVar.dividerLine, R.color.CAM_X0204);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes7.dex */
    private class a {
        View dividerLine;
        TextView fiz;

        private a() {
        }
    }
}
