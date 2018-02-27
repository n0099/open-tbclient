package com.baidu.tieba.location.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity fgN;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.fgN = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxz().getLocationData();
        this.isShowLocation = c.bxz().bxA() ? false : true;
        if (locationData != null) {
            this.data = h(locationData.bxw(), locationData.bxv());
        }
    }

    private ArrayList<Object> h(List<a.C0238a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0238a c0238a = null;
        for (a.C0238a c0238a2 : list) {
            if (c0238a2 != null && !TextUtils.isEmpty(c0238a2.getName())) {
                if (TextUtils.equals(c0238a2.getName(), str)) {
                    c0238a = c0238a2;
                } else {
                    arrayList.add(c0238a2);
                }
            }
        }
        if (c0238a != null) {
            arrayList.add(0, c0238a);
        } else {
            a.C0238a c0238a3 = new a.C0238a();
            c0238a3.setName(str);
            arrayList.add(0, c0238a3);
        }
        if (this.fgN != null) {
            arrayList.add(0, this.fgN.getPageContext().getString(d.j.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0238a) {
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
                return g(view, i, z);
            case 1:
                return h(view, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0195b {
        View eqL;
        ImageView fgO;
        TextView title;

        private C0195b() {
        }
    }

    private View g(View view, int i, boolean z) {
        C0195b c0195b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0195b)) {
                View inflate = LayoutInflater.from(this.fgN.getPageContext().getPageActivity()).inflate(d.h.select_location_nolocation_item, (ViewGroup) null);
                c0195b = new C0195b();
                c0195b.title = (TextView) inflate.findViewById(d.g.select_location_title);
                c0195b.fgO = (ImageView) inflate.findViewById(d.g.select_location_tick);
                c0195b.eqL = inflate.findViewById(d.g.select_location_line);
                inflate.setTag(c0195b);
                view2 = inflate;
            } else {
                c0195b = (C0195b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0195b.fgO.setVisibility(0);
                aj.c(c0195b.fgO, d.f.icon_site_ok);
            } else {
                c0195b.fgO.setVisibility(4);
            }
            c0195b.title.setText(str);
            aj.t(c0195b.eqL, d.C0141d.cp_bg_line_b);
            aj.e(c0195b.title, d.C0141d.cp_link_tip_a, 1);
            aj.s(view2, d.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        TextView bMS;
        TextView fgG;
        ImageView fgO;

        private a() {
        }
    }

    private View h(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0238a) {
            a.C0238a c0238a = (a.C0238a) item;
            if (view == null || !(view.getTag() instanceof C0195b)) {
                view = LayoutInflater.from(this.fgN.getPageContext().getPageActivity()).inflate(d.h.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.bMS = (TextView) view.findViewById(d.g.select_location_name);
                aVar2.fgG = (TextView) view.findViewById(d.g.select_location_address);
                aVar2.fgO = (ImageView) view.findViewById(d.g.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.fgG.setText(c0238a.bxy());
            if (this.isShowLocation && i == 1) {
                aVar.fgO.setVisibility(0);
                if (TextUtils.isEmpty(c0238a.bxy())) {
                    aVar.fgG.setText(d.j.select_location_current);
                }
            } else {
                aVar.fgO.setVisibility(4);
            }
            aVar.bMS.setText(c0238a.getName());
            this.fgN.getLayoutMode().aQ(z);
            this.fgN.getLayoutMode().aM(view);
            aj.s(view, d.f.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
