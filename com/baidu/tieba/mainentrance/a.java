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
    private final BaseActivity UJ;
    private final String aCQ;
    private ArrayList<String> amP;
    private boolean bsm = true;

    public a(BaseActivity baseActivity, ArrayList<String> arrayList) {
        this.UJ = baseActivity;
        this.amP = arrayList;
        this.aCQ = this.UJ.getPageContext().getPageActivity().getText(com.baidu.tieba.z.forum).toString();
    }

    public void s(ArrayList<String> arrayList) {
        this.amP = arrayList;
    }

    public void dp(boolean z) {
        this.bsm = z;
    }

    public void gM(int i) {
        this.amP.remove(i);
        this.amP.add(0, this.amP.get(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amP == null) {
            return 0;
        }
        return this.amP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.amP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.UJ.getPageContext().getPageActivity(), com.baidu.tieba.x.home_dialog_search_item, null);
            bVar = new b(this, null);
            bVar.aQx = (TextView) view.findViewById(com.baidu.tieba.w.home_lv_search_forum);
            bVar.bsn = view.findViewById(com.baidu.tieba.w.home_dialog_lv_search_forum_divider);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        Object item = getItem(i);
        if (item != null) {
            String str = (String) item;
            if (this.bsm) {
                bVar.aQx.setText(str.concat(this.aCQ));
            } else {
                bVar.aQx.setText(str);
            }
            bc.i(view, com.baidu.tieba.v.common_list_item_bg_selector);
            bc.j(bVar.bsn, com.baidu.tieba.t.cp_bg_line_b);
            bc.b(bVar.aQx, com.baidu.tieba.t.cp_cont_b, 1);
        }
        return view;
    }
}
