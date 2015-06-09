package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private ArrayList<String> Sk;
    private final String aLc;
    private boolean bBt = true;
    private final Context mContext;

    public i(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.Sk = arrayList;
        this.aLc = this.mContext.getText(com.baidu.tieba.t.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.Sk = arrayList;
    }

    public void dB(boolean z) {
        this.bBt = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Sk == null) {
            return 0;
        }
        return this.Sk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.Sk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        j jVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.home_dialog_search_item, null);
            jVar = new j(this, null);
            jVar.aGI = (TextView) view.findViewById(com.baidu.tieba.q.home_lv_search_forum);
            jVar.avA = view.findViewById(com.baidu.tieba.q.home_dialog_lv_search_forum_divider);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.bBt) {
                jVar.aGI.setText(str.concat(this.aLc));
            } else {
                jVar.aGI.setText(str);
            }
            ay.b(jVar.aGI, com.baidu.tieba.n.cp_cont_b, 1);
            ay.j(jVar.avA, com.baidu.tieba.n.cp_bg_line_b);
            ay.i(view, com.baidu.tieba.p.addresslist_item_bg);
        }
        return view;
    }
}
