package com.baidu.tieba.write.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity eIL;
    private boolean isShowLocation;

    public l(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.eIL = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aUd().getLocationData();
        this.isShowLocation = com.baidu.tieba.tbadkCore.location.c.aUd().aUe() ? false : true;
        if (locationData != null) {
            this.data = g(locationData.aUa(), locationData.aTZ());
        }
    }

    private ArrayList<Object> g(List<a.C0085a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0085a c0085a = null;
        for (a.C0085a c0085a2 : list) {
            if (c0085a2 != null && !TextUtils.isEmpty(c0085a2.getName())) {
                if (TextUtils.equals(c0085a2.getName(), str)) {
                    c0085a = c0085a2;
                } else {
                    arrayList.add(c0085a2);
                }
            }
        }
        if (c0085a != null) {
            arrayList.add(0, c0085a);
        } else {
            a.C0085a c0085a3 = new a.C0085a();
            c0085a3.setName(str);
            arrayList.add(0, c0085a3);
        }
        if (this.eIL != null) {
            arrayList.add(0, this.eIL.getPageContext().getString(t.j.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0085a) {
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
                return d(view, i, z);
            case 1:
                return e(view, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        View aKi;
        TextView apE;
        ImageView eIM;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }

    private View d(View view, int i, boolean z) {
        b bVar;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof b)) {
                View inflate = LayoutInflater.from(this.eIL.getPageContext().getPageActivity()).inflate(t.h.select_location_nolocation_item, (ViewGroup) null);
                bVar = new b(null);
                bVar.apE = (TextView) inflate.findViewById(t.g.select_location_title);
                bVar.eIM = (ImageView) inflate.findViewById(t.g.select_location_tick);
                bVar.aKi = inflate.findViewById(t.g.select_location_line);
                inflate.setTag(bVar);
                view2 = inflate;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                bVar.eIM.setVisibility(0);
                at.c(bVar.eIM, t.f.icon_site_ok);
            } else {
                bVar.eIM.setVisibility(4);
            }
            bVar.apE.setText(str);
            at.l(bVar.aKi, t.d.cp_bg_line_b);
            at.b(bVar.apE, t.d.cp_link_tip_a, 1);
            at.k(view2, t.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TextView aKg;
        TextView eIF;
        ImageView eIM;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private View e(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0085a) {
            a.C0085a c0085a = (a.C0085a) item;
            if (view == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.eIL.getPageContext().getPageActivity()).inflate(t.h.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a(null);
                aVar2.aKg = (TextView) view.findViewById(t.g.select_location_name);
                aVar2.eIF = (TextView) view.findViewById(t.g.select_location_address);
                aVar2.eIM = (ImageView) view.findViewById(t.g.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.eIF.setText(c0085a.aUc());
            if (this.isShowLocation && i == 1) {
                aVar.eIM.setVisibility(0);
                if (TextUtils.isEmpty(c0085a.aUc())) {
                    aVar.eIF.setText(t.j.select_location_current);
                }
            } else {
                aVar.eIM.setVisibility(4);
            }
            aVar.aKg.setText(c0085a.getName());
            this.eIL.getLayoutMode().ab(z);
            this.eIL.getLayoutMode().x(view);
            at.k(view, t.f.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
