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
    private SelectLocationActivity hkX;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.hkX = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.coU().getLocationData();
        this.isShowLocation = c.coU().coV() ? false : true;
        if (locationData != null) {
            this.data = h(locationData.coT(), locationData.coS());
        }
    }

    private ArrayList<Object> h(List<a.C0516a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0516a c0516a = null;
        for (a.C0516a c0516a2 : list) {
            if (c0516a2 != null && !TextUtils.isEmpty(c0516a2.getName())) {
                if (TextUtils.equals(c0516a2.getName(), str)) {
                    c0516a = c0516a2;
                } else {
                    arrayList.add(c0516a2);
                }
            }
        }
        if (c0516a != null) {
            arrayList.add(0, c0516a);
        } else {
            a.C0516a c0516a3 = new a.C0516a();
            c0516a3.setName(str);
            arrayList.add(0, c0516a3);
        }
        if (this.hkX != null) {
            arrayList.add(0, this.hkX.getPageContext().getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0516a) {
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
    public static class C0459b {
        View eyu;
        ImageView hkY;
        TextView title;

        private C0459b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0459b c0459b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0459b)) {
                View inflate = LayoutInflater.from(this.hkX.getPageContext().getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0459b = new C0459b();
                c0459b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0459b.hkY = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0459b.eyu = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0459b);
                view2 = inflate;
            } else {
                c0459b = (C0459b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0459b.hkY.setVisibility(0);
                am.setImageResource(c0459b.hkY, R.drawable.icon_site_ok);
            } else {
                c0459b.hkY.setVisibility(4);
            }
            c0459b.title.setText(str);
            am.setBackgroundColor(c0459b.eyu, R.color.cp_bg_line_c);
            am.setViewTextColor(c0459b.title, R.color.cp_link_tip_a, 1);
            am.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        TextView bFm;
        TextView hkQ;
        ImageView hkY;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0516a) {
            a.C0516a c0516a = (a.C0516a) item;
            if (view == null || !(view.getTag() instanceof C0459b)) {
                view = LayoutInflater.from(this.hkX.getPageContext().getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.bFm = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.hkQ = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.hkY = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.hkQ.setText(c0516a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.hkY.setVisibility(0);
                if (TextUtils.isEmpty(c0516a.getAddr())) {
                    aVar.hkQ.setText(R.string.select_location_current);
                }
            } else {
                aVar.hkY.setVisibility(4);
            }
            aVar.bFm.setText(c0516a.getName());
            this.hkX.getLayoutMode().setNightMode(z);
            this.hkX.getLayoutMode().onModeChanged(view);
            am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
