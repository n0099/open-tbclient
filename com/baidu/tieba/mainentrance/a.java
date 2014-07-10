package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final BaseActivity a;
    private ArrayList<String> b;
    private final String c;
    private boolean d = true;

    public a(BaseActivity baseActivity, ArrayList<String> arrayList) {
        this.a = baseActivity;
        this.b = arrayList;
        this.c = this.a.getText(com.baidu.tieba.y.forum).toString();
    }

    public void a(ArrayList<String> arrayList) {
        this.b = arrayList;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(int i) {
        this.b.remove(i);
        this.b.add(0, this.b.get(i));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.b.get(i);
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
                view3 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.home_dialog_search_item, (ViewGroup) null);
                try {
                    bVar = new b(this, null);
                    bVar.a = (TextView) view3.findViewById(com.baidu.tieba.v.home_lv_search_forum);
                    bVar.b = view3.findViewById(com.baidu.tieba.v.home_dialog_lv_search_forum_divider);
                    view3.setTag(bVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    a(view2);
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
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            bVar.a.setTextColor(-6574132);
            bVar.b.setBackgroundColor(this.a.getResources().getColor(com.baidu.tieba.s.square_dividing_line_1));
        } else {
            bVar.a.setTextColor(-13553101);
            bVar.b.setBackgroundColor(this.a.getResources().getColor(com.baidu.tieba.s.square_dividing_line));
        }
        String str = (String) item;
        if (this.d) {
            bVar.a.setText(str.concat(this.c));
            view2 = view3;
        } else {
            bVar.a.setText(str);
            view2 = view3;
        }
        a(view2);
        return view2;
    }

    private void a(View view) {
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.a.getLayoutMode().a(skinType == 1);
        this.a.getLayoutMode().a(view);
        View findViewById = view.findViewById(com.baidu.tieba.v.parent);
        if (skinType == 1) {
            if (findViewById != null) {
                findViewById.setBackgroundResource(com.baidu.tieba.u.common_list_item_bg_selector_1);
            }
        } else if (findViewById != null) {
            findViewById.setBackgroundResource(com.baidu.tieba.u.common_list_item_bg_selector);
        }
    }
}
