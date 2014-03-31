package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a extends BaseAdapter {
    private final com.baidu.tbadk.a a;
    private final String c;
    private ArrayList<String> b = null;
    private boolean d = true;

    public a(com.baidu.tbadk.a aVar, ArrayList<String> arrayList) {
        this.a = aVar;
        this.c = this.a.getText(com.baidu.tieba.a.k.forum).toString();
    }

    public final void a(ArrayList<String> arrayList) {
        this.b = arrayList;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final void a(int i) {
        this.b.remove(i);
        this.b.add(0, this.b.get(i));
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e7  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int l;
        b bVar;
        View view3;
        Object item;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.home_dialog_search_item, (ViewGroup) null);
                try {
                    bVar = new b(this, (byte) 0);
                    bVar.a = (TextView) view3.findViewById(com.baidu.tieba.a.h.home_lv_search_forum);
                    bVar.b = view3.findViewById(com.baidu.tieba.a.h.home_dialog_lv_search_forum_divider);
                    view3.setTag(bVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "", "SearchAdapter.getView error = " + exc.getMessage());
                    l = TbadkApplication.j().l();
                    this.a.getLayoutMode().a(l != 1);
                    this.a.getLayoutMode().a(view2);
                    View findViewById = view2.findViewById(com.baidu.tieba.a.h.parent);
                    if (l != 1) {
                    }
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
        if (TbadkApplication.j().l() == 1) {
            bVar.a.setTextColor(-6574132);
            bVar.b.setBackgroundColor(this.a.getResources().getColor(com.baidu.tieba.a.e.square_dividing_line_1));
        } else {
            bVar.a.setTextColor(-13553101);
            bVar.b.setBackgroundColor(this.a.getResources().getColor(com.baidu.tieba.a.e.square_dividing_line));
        }
        String str = (String) item;
        if (this.d) {
            bVar.a.setText(str.concat(this.c));
            view2 = view3;
        } else {
            bVar.a.setText(str);
            view2 = view3;
        }
        l = TbadkApplication.j().l();
        this.a.getLayoutMode().a(l != 1);
        this.a.getLayoutMode().a(view2);
        View findViewById2 = view2.findViewById(com.baidu.tieba.a.h.parent);
        if (l != 1) {
            if (findViewById2 != null) {
                findViewById2.setBackgroundResource(com.baidu.tieba.a.g.common_list_item_bg_selector_1);
                return view2;
            }
            return view2;
        } else if (findViewById2 != null) {
            findViewById2.setBackgroundResource(com.baidu.tieba.a.g.common_list_item_bg_selector);
            return view2;
        } else {
            return view2;
        }
    }
}
