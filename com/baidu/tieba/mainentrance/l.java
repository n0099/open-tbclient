package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private final String aIS;
    private final BaseActivity auI;
    private ArrayList<String> auK;
    private boolean byI = true;

    public l(BaseActivity baseActivity, ArrayList<String> arrayList) {
        this.auI = baseActivity;
        this.auK = arrayList;
        this.aIS = this.auI.getPageContext().getPageActivity().getText(com.baidu.tieba.y.forum).toString();
    }

    public void p(ArrayList<String> arrayList) {
        this.auK = arrayList;
    }

    public void dq(boolean z) {
        this.byI = z;
    }

    public void gO(int i) {
        this.auK.remove(i);
        this.auK.add(0, this.auK.get(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auK == null) {
            return 0;
        }
        return this.auK.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.auK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        m mVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.auI.getPageContext().getPageActivity(), com.baidu.tieba.w.home_dialog_search_item, null);
            mVar = new m(this, null);
            mVar.aED = (TextView) view.findViewById(com.baidu.tieba.v.home_lv_search_forum);
            mVar.byZ = view.findViewById(com.baidu.tieba.v.home_dialog_lv_search_forum_divider);
            view.setTag(mVar);
        } else {
            mVar = (m) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.byI) {
                mVar.aED.setText(str.concat(this.aIS));
            } else {
                mVar.aED.setText(str);
            }
            ba.b(mVar.aED, com.baidu.tieba.s.cp_cont_b, 1);
            ba.j(mVar.byZ, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(view, com.baidu.tieba.u.addresslist_item_bg);
        }
        return view;
    }
}
