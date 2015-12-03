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
    private SelectLocationActivity dML;
    private ArrayList<Object> data;
    private boolean isShowLocation;

    public l(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.dML = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.aDJ().getLocationData();
        this.isShowLocation = com.baidu.tieba.tbadkCore.location.c.aDJ().aDK() ? false : true;
        if (locationData != null) {
            this.data = e(locationData.aDG(), locationData.aDF());
        }
    }

    private ArrayList<Object> e(List<a.C0087a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0087a c0087a = null;
        for (a.C0087a c0087a2 : list) {
            if (c0087a2 != null && !TextUtils.isEmpty(c0087a2.getName())) {
                if (TextUtils.equals(c0087a2.getName(), str)) {
                    c0087a = c0087a2;
                } else {
                    arrayList.add(c0087a2);
                }
            }
        }
        if (c0087a != null) {
            arrayList.add(0, c0087a);
        } else {
            a.C0087a c0087a3 = new a.C0087a();
            c0087a3.setName(str);
            arrayList.add(0, c0087a3);
        }
        if (this.dML != null) {
            arrayList.add(0, this.dML.getPageContext().getString(n.i.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0087a) {
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
        TextView agd;
        ImageView dMM;
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
                View inflate = LayoutInflater.from(this.dML.getPageContext().getPageActivity()).inflate(n.g.select_location_nolocation_item, (ViewGroup) null);
                bVar = new b(null);
                bVar.agd = (TextView) inflate.findViewById(n.f.select_location_title);
                bVar.dMM = (ImageView) inflate.findViewById(n.f.select_location_tick);
                bVar.line = inflate.findViewById(n.f.select_location_line);
                inflate.setTag(bVar);
                view2 = inflate;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                bVar.dMM.setVisibility(0);
                as.c(bVar.dMM, n.e.icon_site_ok);
            } else {
                bVar.dMM.setVisibility(4);
            }
            bVar.agd.setText(str);
            as.j(bVar.line, n.c.cp_bg_line_b);
            as.b(bVar.agd, n.c.cp_link_tip_a, 1);
            as.i(view2, n.e.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TextView aER;
        TextView dMF;
        ImageView dMM;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private View c(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0087a) {
            a.C0087a c0087a = (a.C0087a) item;
            if (view == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.dML.getPageContext().getPageActivity()).inflate(n.g.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a(null);
                aVar2.aER = (TextView) view.findViewById(n.f.select_location_name);
                aVar2.dMF = (TextView) view.findViewById(n.f.select_location_address);
                aVar2.dMM = (ImageView) view.findViewById(n.f.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.dMF.setText(c0087a.aDI());
            if (this.isShowLocation && i == 1) {
                aVar.dMM.setVisibility(0);
                if (TextUtils.isEmpty(c0087a.aDI())) {
                    aVar.dMF.setText(n.i.select_location_current);
                }
            } else {
                aVar.dMM.setVisibility(4);
            }
            aVar.aER.setText(c0087a.getName());
            this.dML.getLayoutMode().af(z);
            this.dML.getLayoutMode().k(view);
            as.i(view, n.e.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
