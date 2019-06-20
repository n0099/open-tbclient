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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity hec;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.hec = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.cnc().getLocationData();
        this.isShowLocation = c.cnc().cnd() ? false : true;
        if (locationData != null) {
            this.data = j(locationData.cnb(), locationData.cna());
        }
    }

    private ArrayList<Object> j(List<a.C0410a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0410a c0410a = null;
        for (a.C0410a c0410a2 : list) {
            if (c0410a2 != null && !TextUtils.isEmpty(c0410a2.getName())) {
                if (TextUtils.equals(c0410a2.getName(), str)) {
                    c0410a = c0410a2;
                } else {
                    arrayList.add(c0410a2);
                }
            }
        }
        if (c0410a != null) {
            arrayList.add(0, c0410a);
        } else {
            a.C0410a c0410a3 = new a.C0410a();
            c0410a3.setName(str);
            arrayList.add(0, c0410a3);
        }
        if (this.hec != null) {
            arrayList.add(0, this.hec.getPageContext().getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0410a) {
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
    public static class C0354b {
        View eim;
        ImageView hed;
        TextView title;

        private C0354b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0354b c0354b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0354b)) {
                View inflate = LayoutInflater.from(this.hec.getPageContext().getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0354b = new C0354b();
                c0354b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0354b.hed = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0354b.eim = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0354b);
                view2 = inflate;
            } else {
                c0354b = (C0354b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0354b.hed.setVisibility(0);
                al.c(c0354b.hed, (int) R.drawable.icon_site_ok);
            } else {
                c0354b.hed.setVisibility(4);
            }
            c0354b.title.setText(str);
            al.l(c0354b.eim, R.color.cp_bg_line_b);
            al.f(c0354b.title, R.color.cp_link_tip_a, 1);
            al.k(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView bmf;
        TextView hdV;
        ImageView hed;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0410a) {
            a.C0410a c0410a = (a.C0410a) item;
            if (view == null || !(view.getTag() instanceof C0354b)) {
                view = LayoutInflater.from(this.hec.getPageContext().getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.bmf = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.hdV = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.hed = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.hdV.setText(c0410a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.hed.setVisibility(0);
                if (TextUtils.isEmpty(c0410a.getAddr())) {
                    aVar.hdV.setText(R.string.select_location_current);
                }
            } else {
                aVar.hed.setVisibility(4);
            }
            aVar.bmf.setText(c0410a.getName());
            this.hec.getLayoutMode().setNightMode(z);
            this.hec.getLayoutMode().onModeChanged(view);
            al.k(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
