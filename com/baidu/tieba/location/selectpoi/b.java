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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity hnb;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.hnb = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.crf().getLocationData();
        this.isShowLocation = c.crf().crg() ? false : true;
        if (locationData != null) {
            this.data = j(locationData.cre(), locationData.crd());
        }
    }

    private ArrayList<Object> j(List<a.C0426a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0426a c0426a = null;
        for (a.C0426a c0426a2 : list) {
            if (c0426a2 != null && !TextUtils.isEmpty(c0426a2.getName())) {
                if (TextUtils.equals(c0426a2.getName(), str)) {
                    c0426a = c0426a2;
                } else {
                    arrayList.add(c0426a2);
                }
            }
        }
        if (c0426a != null) {
            arrayList.add(0, c0426a);
        } else {
            a.C0426a c0426a3 = new a.C0426a();
            c0426a3.setName(str);
            arrayList.add(0, c0426a3);
        }
        if (this.hnb != null) {
            arrayList.add(0, this.hnb.getPageContext().getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0426a) {
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
    public static class C0370b {
        View eoV;
        ImageView hnc;
        TextView title;

        private C0370b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0370b c0370b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0370b)) {
                View inflate = LayoutInflater.from(this.hnb.getPageContext().getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0370b = new C0370b();
                c0370b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0370b.hnc = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0370b.eoV = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0370b);
                view2 = inflate;
            } else {
                c0370b = (C0370b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0370b.hnc.setVisibility(0);
                am.c(c0370b.hnc, (int) R.drawable.icon_site_ok);
            } else {
                c0370b.hnc.setVisibility(4);
            }
            c0370b.title.setText(str);
            am.l(c0370b.eoV, R.color.cp_bg_line_c);
            am.f(c0370b.title, R.color.cp_link_tip_a, 1);
            am.k(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView bnr;
        TextView hmU;
        ImageView hnc;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0426a) {
            a.C0426a c0426a = (a.C0426a) item;
            if (view == null || !(view.getTag() instanceof C0370b)) {
                view = LayoutInflater.from(this.hnb.getPageContext().getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.bnr = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.hmU = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.hnc = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.hmU.setText(c0426a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.hnc.setVisibility(0);
                if (TextUtils.isEmpty(c0426a.getAddr())) {
                    aVar.hmU.setText(R.string.select_location_current);
                }
            } else {
                aVar.hnc.setVisibility(4);
            }
            aVar.bnr.setText(c0426a.getName());
            this.hnb.getLayoutMode().setNightMode(z);
            this.hnb.getLayoutMode().onModeChanged(view);
            am.k(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
