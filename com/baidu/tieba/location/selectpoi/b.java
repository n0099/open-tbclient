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
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private SelectLocationActivity hYY;
    private boolean isShowLocation;

    public b(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.hYY = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = c.cJa().getLocationData();
        this.isShowLocation = c.cJa().cJb() ? false : true;
        if (locationData != null) {
            this.data = i(locationData.cIZ(), locationData.cIY());
        }
    }

    private ArrayList<Object> i(List<a.C0600a> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        a.C0600a c0600a = null;
        for (a.C0600a c0600a2 : list) {
            if (c0600a2 != null && !TextUtils.isEmpty(c0600a2.getName())) {
                if (TextUtils.equals(c0600a2.getName(), str)) {
                    c0600a = c0600a2;
                } else {
                    arrayList.add(c0600a2);
                }
            }
        }
        if (c0600a != null) {
            arrayList.add(0, c0600a);
        } else {
            a.C0600a c0600a3 = new a.C0600a();
            c0600a3.setName(str);
            arrayList.add(0, c0600a3);
        }
        if (this.hYY != null) {
            arrayList.add(0, this.hYY.getPageContext().getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof a.C0600a) {
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
    /* loaded from: classes7.dex */
    public static class C0545b {
        View fpV;
        ImageView hYZ;
        TextView title;

        private C0545b() {
        }
    }

    private View c(View view, int i, boolean z) {
        C0545b c0545b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0545b)) {
                View inflate = LayoutInflater.from(this.hYY.getPageContext().getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0545b = new C0545b();
                c0545b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0545b.hYZ = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0545b.fpV = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0545b);
                view2 = inflate;
            } else {
                c0545b = (C0545b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0545b.hYZ.setVisibility(0);
                am.setImageResource(c0545b.hYZ, R.drawable.icon_site_ok);
            } else {
                c0545b.hYZ.setVisibility(4);
            }
            c0545b.title.setText(str);
            am.setBackgroundColor(c0545b.fpV, R.color.cp_bg_line_c);
            am.setViewTextColor(c0545b.title, R.color.cp_link_tip_a, 1);
            am.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        TextView cpT;
        TextView hYR;
        ImageView hYZ;

        private a() {
        }
    }

    private View d(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof a.C0600a) {
            a.C0600a c0600a = (a.C0600a) item;
            if (view == null || !(view.getTag() instanceof C0545b)) {
                view = LayoutInflater.from(this.hYY.getPageContext().getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.cpT = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.hYR = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.hYZ = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.hYR.setText(c0600a.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.hYZ.setVisibility(0);
                if (TextUtils.isEmpty(c0600a.getAddr())) {
                    aVar.hYR.setText(R.string.select_location_current);
                }
            } else {
                aVar.hYZ.setVisibility(4);
            }
            aVar.cpT.setText(c0600a.getName());
            this.hYY.getLayoutMode().setNightMode(z);
            this.hYY.getLayoutMode().onModeChanged(view);
            am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
