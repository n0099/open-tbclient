package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private final String aIK;
    private final BaseActivity auA;
    private ArrayList<String> auC;
    private boolean bys = true;

    public m(BaseActivity baseActivity, ArrayList<String> arrayList) {
        this.auA = baseActivity;
        this.auC = arrayList;
        this.aIK = this.auA.getPageContext().getPageActivity().getText(com.baidu.tieba.y.forum).toString();
    }

    public void p(ArrayList<String> arrayList) {
        this.auC = arrayList;
    }

    public void ds(boolean z) {
        this.bys = z;
    }

    public void gM(int i) {
        this.auC.remove(i);
        this.auC.add(0, this.auC.get(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auC == null) {
            return 0;
        }
        return this.auC.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.auC.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        n nVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.auA.getPageContext().getPageActivity(), com.baidu.tieba.w.home_dialog_search_item, null);
            nVar = new n(this, null);
            nVar.aEv = (TextView) view.findViewById(com.baidu.tieba.v.home_lv_search_forum);
            nVar.byN = view.findViewById(com.baidu.tieba.v.home_dialog_lv_search_forum_divider);
            view.setTag(nVar);
        } else {
            nVar = (n) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.bys) {
                nVar.aEv.setText(str.concat(this.aIK));
            } else {
                nVar.aEv.setText(str);
            }
            ba.b(nVar.aEv, com.baidu.tieba.s.cp_cont_b, 1);
            ba.j(nVar.byN, com.baidu.tieba.s.cp_bg_line_b);
            ba.i(view, com.baidu.tieba.u.addresslist_item_bg);
        }
        return view;
    }
}
