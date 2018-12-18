package com.baidu.tieba.location.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity ftb;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.ftb = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.bDW().getLocationData();
        this.isShowLocation = c.bDW().bDX() ? false : true;
        if (locationData != null) {
            this.data = i(locationData.bDU(), locationData.bDT());
        }
    }

    private ArrayList<Object> i(List<a.C0318a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0318a c0318a = null;
        for (a.C0318a c0318a2 : list) {
            if (c0318a2 != null && !TextUtils.isEmpty(c0318a2.getName())) {
                if (TextUtils.equals(c0318a2.getName(), str)) {
                    c0318a = c0318a2;
                } else {
                    arrayList.add(c0318a2);
                }
            }
        }
        if (c0318a != null) {
            arrayList.add(0, c0318a);
        } else {
            a.C0318a c0318a3 = new a.C0318a();
            c0318a3.setName(str);
            arrayList.add(0, c0318a3);
        }
        if (this.ftb != null) {
            arrayList.add(0, this.ftb.getPageContext().getString(e.j.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0318a) {
            return 1;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.data == null) {
            return 0;
        }
        return this.data.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.data == null || i < 0 || i >= this.data.size()) {
            return null;
        }
        return this.data.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        switch (itemViewType) {
            case 0:
                return c(view, i, z);
            case 1:
                return d(view, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0268b {
        View cJd;
        ImageView ftc;
        TextView title;

        private C0268b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0268b c0268b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0268b)) {
                View inflate = LayoutInflater.from(this.ftb.getPageContext().getPageActivity()).inflate(e.h.select_location_nolocation_item, (ViewGroup) null);
                c0268b = new C0268b();
                c0268b.title = (TextView) inflate.findViewById(e.g.select_location_title);
                c0268b.ftc = (ImageView) inflate.findViewById(e.g.select_location_tick);
                c0268b.cJd = inflate.findViewById(e.g.select_location_line);
                inflate.setTag(c0268b);
                view2 = inflate;
            } else {
                c0268b = (C0268b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0268b.ftc.setVisibility(0);
                al.c(c0268b.ftc, e.f.icon_site_ok);
            } else {
                c0268b.ftc.setVisibility(4);
            }
            c0268b.title.setText(str);
            al.j(c0268b.cJd, e.d.cp_bg_line_b);
            al.c(c0268b.title, e.d.cp_link_tip_a, 1);
            al.i(view2, e.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        TextView bPh;
        TextView fsU;
        ImageView ftc;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0318a) {
            a.C0318a c0318a = (a.C0318a) item;
            if (view == null || !(view.getTag() instanceof C0268b)) {
                view = LayoutInflater.from(this.ftb.getPageContext().getPageActivity()).inflate(e.h.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.bPh = (TextView) view.findViewById(e.g.select_location_name);
                aVar2.fsU = (TextView) view.findViewById(e.g.select_location_address);
                aVar2.ftc = (ImageView) view.findViewById(e.g.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.fsU.setText(c0318a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.ftc.setVisibility(0);
                if (TextUtils.isEmpty(c0318a.getAddr())) {
                    aVar.fsU.setText(e.j.select_location_current);
                }
            } else {
                aVar.ftc.setVisibility(4);
            }
            aVar.bPh.setText(c0318a.getName());
            this.ftb.getLayoutMode().setNightMode(z);
            this.ftb.getLayoutMode().onModeChanged(view);
            al.i(view, e.f.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
