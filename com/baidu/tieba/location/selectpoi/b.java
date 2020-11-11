package com.baidu.tieba.location.selectpoi;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private TbPageContext<SelectLocationActivity> eIc;
    private boolean isShowLocation;

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        this.eIc = tbPageContext;
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData();
        this.isShowLocation = !com.baidu.tieba.tbadkCore.location.b.dKC().dKD();
        if (locationData != null) {
            this.data = m(locationData.getPoi_info(), locationData.getFormatted_address());
        }
    }

    private ArrayList<Object> m(List<LocationData.NearByAddressData> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        LocationData.NearByAddressData nearByAddressData = null;
        for (LocationData.NearByAddressData nearByAddressData2 : list) {
            if (nearByAddressData2 != null && !TextUtils.isEmpty(nearByAddressData2.getName())) {
                if (TextUtils.equals(nearByAddressData2.getName(), str)) {
                    nearByAddressData = nearByAddressData2;
                } else {
                    arrayList.add(nearByAddressData2);
                }
            }
        }
        if (nearByAddressData != null) {
            arrayList.add(0, nearByAddressData);
        } else {
            LocationData.NearByAddressData nearByAddressData3 = new LocationData.NearByAddressData();
            nearByAddressData3.setName(str);
            arrayList.add(0, nearByAddressData3);
        }
        if (this.eIc != null) {
            arrayList.add(0, this.eIc.getString(R.string.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof LocationData.NearByAddressData) {
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
    /* loaded from: classes23.dex */
    public static class C0786b {
        View hFD;
        ImageView kLH;
        TextView title;

        private C0786b() {
        }
    }

    private View d(View view, int i, boolean z) {
        C0786b c0786b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0786b)) {
                View inflate = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0786b = new C0786b();
                c0786b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0786b.kLH = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0786b.hFD = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0786b);
                view2 = inflate;
            } else {
                c0786b = (C0786b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0786b.kLH.setVisibility(0);
                ap.setImageResource(c0786b.kLH, R.drawable.icon_site_ok);
            } else {
                c0786b.kLH.setVisibility(4);
            }
            c0786b.title.setText(str);
            ap.setBackgroundColor(c0786b.hFD, R.color.cp_bg_line_c);
            ap.setViewTextColor(c0786b.title, R.color.cp_link_tip_a, 1);
            ap.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a {
        TextView ebD;
        TextView kLD;
        ImageView kLH;

        private a() {
        }
    }

    private View e(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            if (view == null || !(view.getTag() instanceof C0786b)) {
                view = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.ebD = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.kLD = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.kLH = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.kLD.setText(nearByAddressData.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.kLH.setVisibility(0);
                if (TextUtils.isEmpty(nearByAddressData.getAddr())) {
                    aVar.kLD.setText(R.string.select_location_current);
                }
            } else {
                aVar.kLH.setVisibility(4);
            }
            aVar.ebD.setText(nearByAddressData.getName());
            this.eIc.getLayoutMode().setNightMode(z);
            this.eIc.getLayoutMode().onModeChanged(view);
            ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
