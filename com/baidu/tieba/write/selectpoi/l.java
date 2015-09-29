package com.baidu.tieba.write.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity dlx;
    private boolean isShowLocation;

    public l(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.dlx = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.axc().getLocationData();
        this.isShowLocation = com.baidu.tieba.tbadkCore.location.c.axc().axd() ? false : true;
        if (locationData != null) {
            this.data = d(locationData.awZ(), locationData.awY());
        }
    }

    private ArrayList<Object> d(List<a.C0078a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0078a c0078a = null;
        for (a.C0078a c0078a2 : list) {
            if (c0078a2 != null && !TextUtils.isEmpty(c0078a2.getName())) {
                if (TextUtils.equals(c0078a2.getName(), str)) {
                    c0078a = c0078a2;
                } else {
                    arrayList.add(c0078a2);
                }
            }
        }
        if (c0078a != null) {
            arrayList.add(0, c0078a);
        } else {
            a.C0078a c0078a3 = new a.C0078a();
            c0078a3.setName(str);
            arrayList.add(0, c0078a3);
        }
        if (this.dlx != null) {
            arrayList.add(0, this.dlx.getPageContext().getString(i.h.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0078a) {
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
        TextView alt;
        ImageView dly;
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
                View inflate = LayoutInflater.from(this.dlx.getPageContext().getPageActivity()).inflate(i.g.select_location_nolocation_item, (ViewGroup) null);
                bVar = new b(null);
                bVar.alt = (TextView) inflate.findViewById(i.f.select_location_title);
                bVar.dly = (ImageView) inflate.findViewById(i.f.select_location_tick);
                bVar.line = inflate.findViewById(i.f.select_location_line);
                inflate.setTag(bVar);
                view2 = inflate;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                bVar.dly.setVisibility(0);
                am.c(bVar.dly, i.e.icon_site_ok);
            } else {
                bVar.dly.setVisibility(4);
            }
            bVar.alt.setText(str);
            am.j(bVar.line, i.c.cp_bg_line_b);
            am.b(bVar.alt, i.c.cp_link_tip_a, 1);
            am.i(view2, i.e.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        TextView aDa;
        TextView dlr;
        ImageView dly;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private View c(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0078a) {
            a.C0078a c0078a = (a.C0078a) item;
            if (view == null || !(view.getTag() instanceof b)) {
                view = LayoutInflater.from(this.dlx.getPageContext().getPageActivity()).inflate(i.g.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a(null);
                aVar2.aDa = (TextView) view.findViewById(i.f.select_location_name);
                aVar2.dlr = (TextView) view.findViewById(i.f.select_location_address);
                aVar2.dly = (ImageView) view.findViewById(i.f.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.dlr.setText(c0078a.axb());
            if (this.isShowLocation && i == 1) {
                aVar.dly.setVisibility(0);
                if (TextUtils.isEmpty(c0078a.axb())) {
                    aVar.dlr.setText(i.h.select_location_current);
                }
            } else {
                aVar.dly.setVisibility(4);
            }
            aVar.aDa.setText(c0078a.getName());
            this.dlx.getLayoutMode().ad(z);
            this.dlx.getLayoutMode().k(view);
            am.i(view, i.e.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
