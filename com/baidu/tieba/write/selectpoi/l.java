package com.baidu.tieba.write.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private SelectLocationActivity daB;
    private ArrayList<Object> data;
    private boolean isShowLocation;

    public l(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.daB = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.auQ().getLocationData();
        this.isShowLocation = com.baidu.tieba.tbadkCore.location.c.auQ().auR() ? false : true;
        if (locationData != null) {
            this.data = d(locationData.auN(), locationData.auM());
        }
    }

    private ArrayList<Object> d(List<a.C0075a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0075a c0075a = null;
        for (a.C0075a c0075a2 : list) {
            if (c0075a2 != null && !TextUtils.isEmpty(c0075a2.getName())) {
                if (TextUtils.equals(c0075a2.getName(), str)) {
                    c0075a = c0075a2;
                } else {
                    arrayList.add(c0075a2);
                }
            }
        }
        if (c0075a != null) {
            arrayList.add(0, c0075a);
        } else {
            a.C0075a c0075a3 = new a.C0075a();
            c0075a3.setName(str);
            arrayList.add(0, c0075a3);
        }
        if (this.daB != null) {
            arrayList.add(0, this.daB.getPageContext().getString(i.h.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0075a) {
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
        boolean z = TbadkCoreApplication.m411getInst().getSkinType() == 1;
        switch (itemViewType) {
            case 0:
                return b(view, i, z);
            case 1:
                return c(view, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        TextView amV;
        ImageView daC;
        View line;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }

    private View b(View view, int i, boolean z) {
        b bVar;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof b)) {
                View inflate = LayoutInflater.from(this.daB.getPageContext().getPageActivity()).inflate(i.g.select_location_nolocation_item, (ViewGroup) null);
                bVar = new b(null);
                bVar.amV = (TextView) inflate.findViewById(i.f.select_location_title);
                bVar.daC = (ImageView) inflate.findViewById(i.f.select_location_tick);
                bVar.line = inflate.findViewById(i.f.select_location_line);
                inflate.setTag(bVar);
                view2 = inflate;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                bVar.daC.setVisibility(0);
                al.c(bVar.daC, i.e.icon_site_ok);
            } else {
                bVar.daC.setVisibility(4);
            }
            bVar.amV.setText(str);
            al.i(bVar.line, i.c.cp_bg_line_b);
            al.b(bVar.amV, i.c.cp_link_tip_a, 1);
            al.h(view2, i.e.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TextView aPv;
        ImageView daC;
        TextView das;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private View c(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0075a) {
            a.C0075a c0075a = (a.C0075a) item;
            if (view == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.daB.getPageContext().getPageActivity()).inflate(i.g.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a(null);
                aVar2.aPv = (TextView) view.findViewById(i.f.select_location_name);
                aVar2.das = (TextView) view.findViewById(i.f.select_location_address);
                aVar2.daC = (ImageView) view.findViewById(i.f.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.das.setText(c0075a.auP());
            if (this.isShowLocation && i == 1) {
                aVar.daC.setVisibility(0);
                if (TextUtils.isEmpty(c0075a.auP())) {
                    aVar.das.setText(i.h.select_location_current);
                }
            } else {
                aVar.daC.setVisibility(4);
            }
            aVar.aPv.setText(c0075a.getName());
            this.daB.getLayoutMode().ad(z);
            this.daB.getLayoutMode().k(view);
            al.h(view, i.e.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
