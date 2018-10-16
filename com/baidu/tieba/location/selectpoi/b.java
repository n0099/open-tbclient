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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.location.a;
import com.baidu.tieba.tbadkCore.location.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity fkQ;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.fkQ = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.bCH().getLocationData();
        this.isShowLocation = c.bCH().bCI() ? false : true;
        if (locationData != null) {
            this.data = i(locationData.bCE(), locationData.bCD());
        }
    }

    private ArrayList<Object> i(List<a.C0279a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0279a c0279a = null;
        for (a.C0279a c0279a2 : list) {
            if (c0279a2 != null && !TextUtils.isEmpty(c0279a2.getName())) {
                if (TextUtils.equals(c0279a2.getName(), str)) {
                    c0279a = c0279a2;
                } else {
                    arrayList.add(c0279a2);
                }
            }
        }
        if (c0279a != null) {
            arrayList.add(0, c0279a);
        } else {
            a.C0279a c0279a3 = new a.C0279a();
            c0279a3.setName(str);
            arrayList.add(0, c0279a3);
        }
        if (this.fkQ != null) {
            arrayList.add(0, this.fkQ.getPageContext().getString(e.j.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0279a) {
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
    /* loaded from: classes3.dex */
    public static class C0231b {
        View euX;
        ImageView fkR;
        TextView title;

        private C0231b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0231b c0231b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0231b)) {
                View inflate = LayoutInflater.from(this.fkQ.getPageContext().getPageActivity()).inflate(e.h.select_location_nolocation_item, (ViewGroup) null);
                c0231b = new C0231b();
                c0231b.title = (TextView) inflate.findViewById(e.g.select_location_title);
                c0231b.fkR = (ImageView) inflate.findViewById(e.g.select_location_tick);
                c0231b.euX = inflate.findViewById(e.g.select_location_line);
                inflate.setTag(c0231b);
                view2 = inflate;
            } else {
                c0231b = (C0231b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0231b.fkR.setVisibility(0);
                al.c(c0231b.fkR, e.f.icon_site_ok);
            } else {
                c0231b.fkR.setVisibility(4);
            }
            c0231b.title.setText(str);
            al.j(c0231b.euX, e.d.cp_bg_line_b);
            al.c(c0231b.title, e.d.cp_link_tip_a, 1);
            al.i(view2, e.f.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        TextView bKH;
        TextView fkJ;
        ImageView fkR;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0279a) {
            a.C0279a c0279a = (a.C0279a) item;
            if (view == null || !(view.getTag() instanceof C0231b)) {
                view = LayoutInflater.from(this.fkQ.getPageContext().getPageActivity()).inflate(e.h.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.bKH = (TextView) view.findViewById(e.g.select_location_name);
                aVar2.fkJ = (TextView) view.findViewById(e.g.select_location_address);
                aVar2.fkR = (ImageView) view.findViewById(e.g.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.fkJ.setText(c0279a.bCG());
            if (this.isShowLocation && i == 1) {
                aVar.fkR.setVisibility(0);
                if (TextUtils.isEmpty(c0279a.bCG())) {
                    aVar.fkJ.setText(e.j.select_location_current);
                }
            } else {
                aVar.fkR.setVisibility(4);
            }
            aVar.bKH.setText(c0279a.getName());
            this.fkQ.getLayoutMode().setNightMode(z);
            this.fkQ.getLayoutMode().onModeChanged(view);
            al.i(view, e.f.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
