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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity gMR;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.gMR = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.ceZ().getLocationData();
        this.isShowLocation = c.ceZ().cfa() ? false : true;
        if (locationData != null) {
            this.data = j(locationData.ceX(), locationData.ceW());
        }
    }

    private ArrayList<Object> j(List<a.C0391a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0391a c0391a = null;
        for (a.C0391a c0391a2 : list) {
            if (c0391a2 != null && !TextUtils.isEmpty(c0391a2.getName())) {
                if (TextUtils.equals(c0391a2.getName(), str)) {
                    c0391a = c0391a2;
                } else {
                    arrayList.add(c0391a2);
                }
            }
        }
        if (c0391a != null) {
            arrayList.add(0, c0391a);
        } else {
            a.C0391a c0391a3 = new a.C0391a();
            c0391a3.setName(str);
            arrayList.add(0, c0391a3);
        }
        if (this.gMR != null) {
            arrayList.add(0, this.gMR.getPageContext().getString(d.j.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0391a) {
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
    /* loaded from: classes5.dex */
    public static class C0336b {
        View dYo;
        ImageView gMS;
        TextView title;

        private C0336b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0336b c0336b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0336b)) {
                View inflate = LayoutInflater.from(this.gMR.getPageContext().getPageActivity()).inflate(d.h.select_location_nolocation_item, (ViewGroup) null);
                c0336b = new C0336b();
                c0336b.title = (TextView) inflate.findViewById(d.g.select_location_title);
                c0336b.gMS = (ImageView) inflate.findViewById(d.g.select_location_tick);
                c0336b.dYo = inflate.findViewById(d.g.select_location_line);
                inflate.setTag(c0336b);
                view2 = inflate;
            } else {
                c0336b = (C0336b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0336b.gMS.setVisibility(0);
                al.c(c0336b.gMS, d.f.icon_site_ok);
            } else {
                c0336b.gMS.setVisibility(4);
            }
            c0336b.title.setText(str);
            al.l(c0336b.dYo, d.C0277d.cp_bg_line_b);
            al.d(c0336b.title, d.C0277d.cp_link_tip_a, 1);
            al.k(view2, d.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView dfk;
        TextView gMK;
        ImageView gMS;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0391a) {
            a.C0391a c0391a = (a.C0391a) item;
            if (view == null || !(view.getTag() instanceof C0336b)) {
                view = LayoutInflater.from(this.gMR.getPageContext().getPageActivity()).inflate(d.h.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.dfk = (TextView) view.findViewById(d.g.select_location_name);
                aVar2.gMK = (TextView) view.findViewById(d.g.select_location_address);
                aVar2.gMS = (ImageView) view.findViewById(d.g.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.gMK.setText(c0391a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.gMS.setVisibility(0);
                if (TextUtils.isEmpty(c0391a.getAddr())) {
                    aVar.gMK.setText(d.j.select_location_current);
                }
            } else {
                aVar.gMS.setVisibility(4);
            }
            aVar.dfk.setText(c0391a.getName());
            this.gMR.getLayoutMode().setNightMode(z);
            this.gMR.getLayoutMode().onModeChanged(view);
            al.k(view, d.f.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
