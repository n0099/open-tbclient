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
    private SelectLocationActivity fgZ;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.fgZ = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.bxA().getLocationData();
        this.isShowLocation = c.bxA().bxB() ? false : true;
        if (locationData != null) {
            this.data = h(locationData.bxx(), locationData.bxw());
        }
    }

    private ArrayList<Object> h(List<a.C0237a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0237a c0237a = null;
        for (a.C0237a c0237a2 : list) {
            if (c0237a2 != null && !TextUtils.isEmpty(c0237a2.getName())) {
                if (TextUtils.equals(c0237a2.getName(), str)) {
                    c0237a = c0237a2;
                } else {
                    arrayList.add(c0237a2);
                }
            }
        }
        if (c0237a != null) {
            arrayList.add(0, c0237a);
        } else {
            a.C0237a c0237a3 = new a.C0237a();
            c0237a3.setName(str);
            arrayList.add(0, c0237a3);
        }
        if (this.fgZ != null) {
            arrayList.add(0, this.fgZ.getPageContext().getString(d.j.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0237a) {
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
    public static class C0194b {
        View eqX;
        ImageView fha;
        TextView title;

        private C0194b() {
        }
    }

    private View g(View view, int i, boolean z) {
        C0194b c0194b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0194b)) {
                View inflate = LayoutInflater.from(this.fgZ.getPageContext().getPageActivity()).inflate(d.h.select_location_nolocation_item, (ViewGroup) null);
                c0194b = new C0194b();
                c0194b.title = (TextView) inflate.findViewById(d.g.select_location_title);
                c0194b.fha = (ImageView) inflate.findViewById(d.g.select_location_tick);
                c0194b.eqX = inflate.findViewById(d.g.select_location_line);
                inflate.setTag(c0194b);
                view2 = inflate;
            } else {
                c0194b = (C0194b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0194b.fha.setVisibility(0);
                aj.c(c0194b.fha, d.f.icon_site_ok);
            } else {
                c0194b.fha.setVisibility(4);
            }
            c0194b.title.setText(str);
            aj.t(c0194b.eqX, d.C0140d.cp_bg_line_b);
            aj.e(c0194b.title, d.C0140d.cp_link_tip_a, 1);
            aj.s(view2, d.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        TextView bNf;
        TextView fgS;
        ImageView fha;

        private a() {
        }
    }

    private View h(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0237a) {
            a.C0237a c0237a = (a.C0237a) item;
            if (view == null || !(view.getTag() instanceof C0194b)) {
                view = LayoutInflater.from(this.fgZ.getPageContext().getPageActivity()).inflate(d.h.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.bNf = (TextView) view.findViewById(d.g.select_location_name);
                aVar2.fgS = (TextView) view.findViewById(d.g.select_location_address);
                aVar2.fha = (ImageView) view.findViewById(d.g.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.fgS.setText(c0237a.bxz());
            if (this.isShowLocation && i == 1) {
                aVar.fha.setVisibility(0);
                if (TextUtils.isEmpty(c0237a.bxz())) {
                    aVar.fgS.setText(d.j.select_location_current);
                }
            } else {
                aVar.fha.setVisibility(4);
            }
            aVar.bNf.setText(c0237a.getName());
            this.fgZ.getLayoutMode().aQ(z);
            this.fgZ.getLayoutMode().aM(view);
            aj.s(view, d.f.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
