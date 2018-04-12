package com.baidu.tieba.location.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity eBG;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.eBG = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.bsE().getLocationData();
        this.isShowLocation = c.bsE().bsF() ? false : true;
        if (locationData != null) {
            this.data = i(locationData.bsB(), locationData.bsA());
        }
    }

    private ArrayList<Object> i(List<a.C0219a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0219a c0219a = null;
        for (a.C0219a c0219a2 : list) {
            if (c0219a2 != null && !TextUtils.isEmpty(c0219a2.getName())) {
                if (TextUtils.equals(c0219a2.getName(), str)) {
                    c0219a = c0219a2;
                } else {
                    arrayList.add(c0219a2);
                }
            }
        }
        if (c0219a != null) {
            arrayList.add(0, c0219a);
        } else {
            a.C0219a c0219a3 = new a.C0219a();
            c0219a3.setName(str);
            arrayList.add(0, c0219a3);
        }
        if (this.eBG != null) {
            arrayList.add(0, this.eBG.getPageContext().getString(d.k.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0219a) {
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        switch (itemViewType) {
            case 0:
                return d(view2, i, z);
            case 1:
                return e(view2, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0178b {
        View dLN;
        ImageView eBH;
        TextView title;

        private C0178b() {
        }
    }

    private View d(View view2, int i, boolean z) {
        C0178b c0178b;
        View view3;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view2 == null || !(view2.getTag() instanceof C0178b)) {
                View inflate = LayoutInflater.from(this.eBG.getPageContext().getPageActivity()).inflate(d.i.select_location_nolocation_item, (ViewGroup) null);
                c0178b = new C0178b();
                c0178b.title = (TextView) inflate.findViewById(d.g.select_location_title);
                c0178b.eBH = (ImageView) inflate.findViewById(d.g.select_location_tick);
                c0178b.dLN = inflate.findViewById(d.g.select_location_line);
                inflate.setTag(c0178b);
                view3 = inflate;
            } else {
                c0178b = (C0178b) view2.getTag();
                view3 = view2;
            }
            if (i == 0 && !this.isShowLocation) {
                c0178b.eBH.setVisibility(0);
                ak.c(c0178b.eBH, d.f.icon_site_ok);
            } else {
                c0178b.eBH.setVisibility(4);
            }
            c0178b.title.setText(str);
            ak.j(c0178b.dLN, d.C0126d.cp_bg_line_b);
            ak.c(c0178b.title, d.C0126d.cp_link_tip_a, 1);
            ak.i(view3, d.f.home_recommend_item_bg);
            return view3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        TextView blN;
        ImageView eBH;
        TextView eBz;

        private a() {
        }
    }

    private View e(View view2, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0219a) {
            a.C0219a c0219a = (a.C0219a) item;
            if (view2 == null || !(view2.getTag() instanceof C0178b)) {
                view2 = LayoutInflater.from(this.eBG.getPageContext().getPageActivity()).inflate(d.i.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.blN = (TextView) view2.findViewById(d.g.select_location_name);
                aVar2.eBz = (TextView) view2.findViewById(d.g.select_location_address);
                aVar2.eBH = (ImageView) view2.findViewById(d.g.select_location_tick);
                view2.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view2.getTag();
            }
            aVar.eBz.setText(c0219a.bsD());
            if (this.isShowLocation && i == 1) {
                aVar.eBH.setVisibility(0);
                if (TextUtils.isEmpty(c0219a.bsD())) {
                    aVar.eBz.setText(d.k.select_location_current);
                }
            } else {
                aVar.eBH.setVisibility(4);
            }
            aVar.blN.setText(c0219a.getName());
            this.eBG.getLayoutMode().setNightMode(z);
            this.eBG.getLayoutMode().u(view2);
            ak.i(view2, d.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }
}
