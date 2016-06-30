package com.baidu.tieba.write.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity fEF;
    private boolean isShowLocation;

    public l(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.fEF = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.bcT().getLocationData();
        this.isShowLocation = com.baidu.tieba.tbadkCore.location.c.bcT().isNoLongerShowAddress() ? false : true;
        if (locationData != null) {
            this.data = e(locationData.getPoi_info(), locationData.getFormatted_address());
        }
    }

    private ArrayList<Object> e(List<a.C0079a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0079a c0079a = null;
        for (a.C0079a c0079a2 : list) {
            if (c0079a2 != null && !TextUtils.isEmpty(c0079a2.getName())) {
                if (TextUtils.equals(c0079a2.getName(), str)) {
                    c0079a = c0079a2;
                } else {
                    arrayList.add(c0079a2);
                }
            }
        }
        if (c0079a != null) {
            arrayList.add(0, c0079a);
        } else {
            a.C0079a c0079a3 = new a.C0079a();
            c0079a3.setName(str);
            arrayList.add(0, c0079a3);
        }
        if (this.fEF != null) {
            arrayList.add(0, this.fEF.getPageContext().getString(u.j.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0079a) {
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
        boolean z = TbadkCoreApplication.m9getInst().getSkinType() == 1;
        switch (itemViewType) {
            case 0:
                return e(view, i, z);
            case 1:
                return f(view, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        View aGT;
        ImageView fEG;
        TextView title;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }

    private View e(View view, int i, boolean z) {
        b bVar;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof b)) {
                View inflate = LayoutInflater.from(this.fEF.getPageContext().getPageActivity()).inflate(u.h.select_location_nolocation_item, (ViewGroup) null);
                bVar = new b(null);
                bVar.title = (TextView) inflate.findViewById(u.g.select_location_title);
                bVar.fEG = (ImageView) inflate.findViewById(u.g.select_location_tick);
                bVar.aGT = inflate.findViewById(u.g.select_location_line);
                inflate.setTag(bVar);
                view2 = inflate;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                bVar.fEG.setVisibility(0);
                av.c(bVar.fEG, u.f.icon_site_ok);
            } else {
                bVar.fEG.setVisibility(4);
            }
            bVar.title.setText(str);
            av.l(bVar.aGT, u.d.cp_bg_line_b);
            av.c(bVar.title, u.d.cp_link_tip_a, 1);
            av.k(view2, u.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TextView aGR;
        ImageView fEG;
        TextView fEz;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private View f(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0079a) {
            a.C0079a c0079a = (a.C0079a) item;
            if (view == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.fEF.getPageContext().getPageActivity()).inflate(u.h.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a(null);
                aVar2.aGR = (TextView) view.findViewById(u.g.select_location_name);
                aVar2.fEz = (TextView) view.findViewById(u.g.select_location_address);
                aVar2.fEG = (ImageView) view.findViewById(u.g.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.fEz.setText(c0079a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.fEG.setVisibility(0);
                if (TextUtils.isEmpty(c0079a.getAddr())) {
                    aVar.fEz.setText(u.j.select_location_current);
                }
            } else {
                aVar.fEG.setVisibility(4);
            }
            aVar.aGR.setText(c0079a.getName());
            this.fEF.getLayoutMode().ad(z);
            this.fEF.getLayoutMode().w(view);
            av.k(view, u.f.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
