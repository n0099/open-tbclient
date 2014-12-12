package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final BaseActivity Ud;
    private final String aBP;
    private boolean bqO = true;
    private ArrayList<String> mData;

    public a(BaseActivity baseActivity, ArrayList<String> arrayList) {
        this.Ud = baseActivity;
        this.mData = arrayList;
        this.aBP = this.Ud.getPageContext().getPageActivity().getText(com.baidu.tieba.z.forum).toString();
    }

    public void r(ArrayList<String> arrayList) {
        this.mData = arrayList;
    }

    public void dj(boolean z) {
        this.bqO = z;
    }

    public void gD(int i) {
        this.mData.remove(i);
        this.mData.add(0, this.mData.get(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        b bVar;
        View view3;
        Object item;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.g.b.ek().inflate(this.Ud.getPageContext().getPageActivity(), com.baidu.tieba.x.home_dialog_search_item, null);
                try {
                    bVar = new b(this, null);
                    bVar.aPs = (TextView) view3.findViewById(com.baidu.tieba.w.home_lv_search_forum);
                    bVar.bqP = view3.findViewById(com.baidu.tieba.w.home_dialog_lv_search_forum_divider);
                    view3.setTag(bVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    applyNightMode(view2);
                    return view2;
                }
            } else {
                bVar = (b) view.getTag();
                view3 = view;
            }
            item = getItem(i);
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        if (item == null) {
            return view3;
        }
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            bVar.aPs.setTextColor(-6574132);
        } else {
            bVar.aPs.setTextColor(-13553101);
        }
        ax.j(bVar.bqP, com.baidu.tieba.t.cp_bg_line_b);
        String str = (String) item;
        if (this.bqO) {
            bVar.aPs.setText(str.concat(this.aBP));
            view2 = view3;
        } else {
            bVar.aPs.setText(str);
            view2 = view3;
        }
        applyNightMode(view2);
        return view2;
    }

    private void applyNightMode(View view) {
        this.Ud.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.Ud.getLayoutMode().h(view);
        View findViewById = view.findViewById(com.baidu.tieba.w.parent);
        if (findViewById != null) {
            ax.i(findViewById, com.baidu.tieba.v.common_list_item_bg_selector);
        }
    }
}
