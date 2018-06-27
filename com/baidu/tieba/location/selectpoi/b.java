package com.baidu.tieba.location.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity eRW;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.eRW = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.byk().getLocationData();
        this.isShowLocation = c.byk().byl() ? false : true;
        if (locationData != null) {
            this.data = i(locationData.byh(), locationData.byg());
        }
    }

    private ArrayList<Object> i(List<a.C0238a> list, String str) {
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
        if (this.eRW != null) {
            arrayList.add(0, this.eRW.getPageContext().getString(d.k.select_position_no_location));
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
                return d(view, i, z);
            case 1:
                return e(view, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0196b {
        ImageView eRX;
        View ebW;
        TextView title;

        private C0196b() {
        }
    }

    private View d(View view, int i, boolean z) {
        C0196b c0196b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0196b)) {
                View inflate = LayoutInflater.from(this.eRW.getPageContext().getPageActivity()).inflate(d.i.select_location_nolocation_item, (ViewGroup) null);
                c0196b = new C0196b();
                c0196b.title = (TextView) inflate.findViewById(d.g.select_location_title);
                c0196b.eRX = (ImageView) inflate.findViewById(d.g.select_location_tick);
                c0196b.ebW = inflate.findViewById(d.g.select_location_line);
                inflate.setTag(c0196b);
                view2 = inflate;
            } else {
                c0196b = (C0196b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0196b.eRX.setVisibility(0);
                am.c(c0196b.eRX, d.f.icon_site_ok);
            } else {
                c0196b.eRX.setVisibility(4);
            }
            c0196b.title.setText(str);
            am.j(c0196b.ebW, d.C0142d.cp_bg_line_b);
            am.c(c0196b.title, d.C0142d.cp_link_tip_a, 1);
            am.i(view2, d.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        TextView bvD;
        TextView eRP;
        ImageView eRX;

        private a() {
        }
    }

    private View e(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0238a) {
            a.C0238a c0238a = (a.C0238a) item;
            if (view == null || !(view.getTag() instanceof C0196b)) {
                view = LayoutInflater.from(this.eRW.getPageContext().getPageActivity()).inflate(d.i.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.bvD = (TextView) view.findViewById(d.g.select_location_name);
                aVar2.eRP = (TextView) view.findViewById(d.g.select_location_address);
                aVar2.eRX = (ImageView) view.findViewById(d.g.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.eRP.setText(c0238a.byj());
            if (this.isShowLocation && i == 1) {
                aVar.eRX.setVisibility(0);
                if (TextUtils.isEmpty(c0238a.byj())) {
                    aVar.eRP.setText(d.k.select_location_current);
                }
            } else {
                aVar.eRX.setVisibility(4);
            }
            aVar.bvD.setText(c0238a.getName());
            this.eRW.getLayoutMode().setNightMode(z);
            this.eRW.getLayoutMode().onModeChanged(view);
            am.i(view, d.f.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
