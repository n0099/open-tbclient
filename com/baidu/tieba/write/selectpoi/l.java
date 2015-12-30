package com.baidu.tieba.write.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private SelectLocationActivity dUk;
    private ArrayList<Object> data;
    private boolean isShowLocation;

    public l(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.dUk = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aFW().getLocationData();
        this.isShowLocation = com.baidu.tieba.tbadkCore.location.c.aFW().aFX() ? false : true;
        if (locationData != null) {
            this.data = e(locationData.aFT(), locationData.aFS());
        }
    }

    private ArrayList<Object> e(List<a.C0083a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0083a c0083a = null;
        for (a.C0083a c0083a2 : list) {
            if (c0083a2 != null && !TextUtils.isEmpty(c0083a2.getName())) {
                if (TextUtils.equals(c0083a2.getName(), str)) {
                    c0083a = c0083a2;
                } else {
                    arrayList.add(c0083a2);
                }
            }
        }
        if (c0083a != null) {
            arrayList.add(0, c0083a);
        } else {
            a.C0083a c0083a3 = new a.C0083a();
            c0083a3.setName(str);
            arrayList.add(0, c0083a3);
        }
        if (this.dUk != null) {
            arrayList.add(0, this.dUk.getPageContext().getString(n.j.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0083a) {
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
        TextView ahk;
        ImageView dUl;
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
                View inflate = LayoutInflater.from(this.dUk.getPageContext().getPageActivity()).inflate(n.h.select_location_nolocation_item, (ViewGroup) null);
                bVar = new b(null);
                bVar.ahk = (TextView) inflate.findViewById(n.g.select_location_title);
                bVar.dUl = (ImageView) inflate.findViewById(n.g.select_location_tick);
                bVar.line = inflate.findViewById(n.g.select_location_line);
                inflate.setTag(bVar);
                view2 = inflate;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                bVar.dUl.setVisibility(0);
                as.c(bVar.dUl, n.f.icon_site_ok);
            } else {
                bVar.dUl.setVisibility(4);
            }
            bVar.ahk.setText(str);
            as.j(bVar.line, n.d.cp_bg_line_b);
            as.b(bVar.ahk, n.d.cp_link_tip_a, 1);
            as.i(view2, n.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TextView aGr;
        TextView dUe;
        ImageView dUl;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private View c(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0083a) {
            a.C0083a c0083a = (a.C0083a) item;
            if (view == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.dUk.getPageContext().getPageActivity()).inflate(n.h.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a(null);
                aVar2.aGr = (TextView) view.findViewById(n.g.select_location_name);
                aVar2.dUe = (TextView) view.findViewById(n.g.select_location_address);
                aVar2.dUl = (ImageView) view.findViewById(n.g.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.dUe.setText(c0083a.aFV());
            if (this.isShowLocation && i == 1) {
                aVar.dUl.setVisibility(0);
                if (TextUtils.isEmpty(c0083a.aFV())) {
                    aVar.dUe.setText(n.j.select_location_current);
                }
            } else {
                aVar.dUl.setVisibility(4);
            }
            aVar.aGr.setText(c0083a.getName());
            this.dUk.getLayoutMode().ac(z);
            this.dUk.getLayoutMode().k(view);
            as.i(view, n.f.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
