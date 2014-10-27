package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final BaseActivity On;
    private final String aAn;
    private ArrayList<String> aew;
    private boolean blW = true;

    public a(BaseActivity baseActivity, ArrayList<String> arrayList) {
        this.On = baseActivity;
        this.aew = arrayList;
        this.aAn = this.On.getText(com.baidu.tieba.y.forum).toString();
    }

    public void setData(ArrayList<String> arrayList) {
        this.aew = arrayList;
    }

    public void dy(boolean z) {
        this.blW = z;
    }

    public void gs(int i) {
        this.aew.remove(i);
        this.aew.add(0, this.aew.get(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aew == null) {
            return 0;
        }
        return this.aew.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.aew.get(i);
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
                view3 = com.baidu.adp.lib.g.b.ek().inflate(this.On, com.baidu.tieba.w.home_dialog_search_item, null);
                try {
                    bVar = new b(this, null);
                    bVar.axq = (TextView) view3.findViewById(com.baidu.tieba.v.home_lv_search_forum);
                    bVar.blX = view3.findViewById(com.baidu.tieba.v.home_dialog_lv_search_forum_divider);
                    view3.setTag(bVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    F(view2);
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
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            bVar.axq.setTextColor(-6574132);
        } else {
            bVar.axq.setTextColor(-13553101);
        }
        aw.i(bVar.blX, com.baidu.tieba.s.square_dividing_line);
        String str = (String) item;
        if (this.blW) {
            bVar.axq.setText(str.concat(this.aAn));
            view2 = view3;
        } else {
            bVar.axq.setText(str);
            view2 = view3;
        }
        F(view2);
        return view2;
    }

    private void F(View view) {
        this.On.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.On.getLayoutMode().h(view);
        View findViewById = view.findViewById(com.baidu.tieba.v.parent);
        if (findViewById != null) {
            aw.h(findViewById, com.baidu.tieba.u.common_list_item_bg_selector);
        }
    }
}
