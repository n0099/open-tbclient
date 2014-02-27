package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class f extends BaseAdapter {
    private final com.baidu.tieba.f a;
    private final String c;
    private ArrayList<String> b = null;
    private boolean d = true;

    public f(com.baidu.tieba.f fVar, ArrayList<String> arrayList) {
        this.a = fVar;
        this.c = this.a.getText(R.string.forum).toString();
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        int ae;
        g gVar;
        View view3;
        Object item;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.home_dialog_search_item, (ViewGroup) null);
                try {
                    gVar = new g(this, (byte) 0);
                    gVar.a = (TextView) view3.findViewById(R.id.home_lv_search_forum);
                    view3.setTag(gVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "", "SearchAdapter.getView error = " + exc.getMessage());
                    ae = TiebaApplication.g().ae();
                    this.a.getLayoutMode().a(ae != 1);
                    this.a.getLayoutMode().a(view2);
                    View findViewById = view2.findViewById(R.id.parent);
                    if (ae != 1) {
                    }
                }
            } else {
                gVar = (g) view.getTag();
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
        bq.b(gVar.a, TiebaApplication.g().ae());
        String str = (String) item;
        if (this.d) {
            gVar.a.setText(str.concat(this.c));
            view2 = view3;
        } else {
            gVar.a.setText(str);
            view2 = view3;
        }
        ae = TiebaApplication.g().ae();
        this.a.getLayoutMode().a(ae != 1);
        this.a.getLayoutMode().a(view2);
        View findViewById2 = view2.findViewById(R.id.parent);
        if (ae != 1) {
            if (findViewById2 != null) {
                findViewById2.setBackgroundResource(R.drawable.common_list_item_bg_selector_1);
                return view2;
            }
            return view2;
        } else if (findViewById2 != null) {
            findViewById2.setBackgroundResource(R.drawable.common_list_item_bg_selector);
            return view2;
        } else {
            return view2;
        }
    }
}
