package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final BaseActivity UG;
    private final String aCN;
    private ArrayList<String> amM;
    private boolean bsl = true;

    public a(BaseActivity baseActivity, ArrayList<String> arrayList) {
        this.UG = baseActivity;
        this.amM = arrayList;
        this.aCN = this.UG.getPageContext().getPageActivity().getText(com.baidu.tieba.z.forum).toString();
    }

    public void s(ArrayList<String> arrayList) {
        this.amM = arrayList;
    }

    public void dp(boolean z) {
        this.bsl = z;
    }

    public void gM(int i) {
        this.amM.remove(i);
        this.amM.add(0, this.amM.get(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amM == null) {
            return 0;
        }
        return this.amM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.amM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.UG.getPageContext().getPageActivity(), com.baidu.tieba.x.home_dialog_search_item, null);
            bVar = new b(this, null);
            bVar.aQw = (TextView) view.findViewById(com.baidu.tieba.w.home_lv_search_forum);
            bVar.bsm = view.findViewById(com.baidu.tieba.w.home_dialog_lv_search_forum_divider);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.bsl) {
                bVar.aQw.setText(str.concat(this.aCN));
            } else {
                bVar.aQw.setText(str);
            }
            bc.i(view, com.baidu.tieba.v.common_list_item_bg_selector);
            bc.j(bVar.bsm, com.baidu.tieba.t.cp_bg_line_b);
            bc.b(bVar.aQw, com.baidu.tieba.t.cp_cont_b, 1);
        }
        return view;
    }
}
