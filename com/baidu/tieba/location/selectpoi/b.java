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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private TbPageContext<SelectLocationActivity> eGu;
    private boolean isShowLocation;

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        this.eGu = tbPageContext;
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dKB().getLocationData();
        this.isShowLocation = !com.baidu.tieba.tbadkCore.location.b.dKB().dKC();
        if (locationData != null) {
            this.data = l(locationData.getPoi_info(), locationData.getFormatted_address());
        }
    }

    private ArrayList<Object> l(List<LocationData.NearByAddressData> list, String str) {
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
        if (this.eGu != null) {
            arrayList.add(0, this.eGu.getString(R.string.select_position_no_location));
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
    /* loaded from: classes22.dex */
    public static class C0789b {
        View hFk;
        ImageView kLW;
        TextView title;

        private C0789b() {
        }
    }

    private View d(View view, int i, boolean z) {
        C0789b c0789b;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0789b)) {
                View inflate = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                c0789b = new C0789b();
                c0789b.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0789b.kLW = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0789b.hFk = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0789b);
                view2 = inflate;
            } else {
                c0789b = (C0789b) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0789b.kLW.setVisibility(0);
                c0789b.kLW.setImageDrawable(WebPManager.a(R.drawable.icon_pure_chx__site_ok24, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                c0789b.kLW.setVisibility(4);
            }
            c0789b.title.setText(str);
            ap.setBackgroundColor(c0789b.hFk, R.color.CAM_X0204);
            ap.setViewTextColor(c0789b.title, R.color.CAM_X0302, 1);
            ap.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a {
        TextView dZV;
        TextView kLS;
        ImageView kLW;

        private a() {
        }
    }

    private View e(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            if (view == null || !(view.getTag() instanceof C0789b)) {
                view = LayoutInflater.from(this.eGu.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.dZV = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.kLS = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.kLW = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.kLS.setText(nearByAddressData.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.kLW.setVisibility(0);
                aVar.kLW.setImageDrawable(WebPManager.a(R.drawable.icon_pure_chx__site_ok24, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                if (TextUtils.isEmpty(nearByAddressData.getAddr())) {
                    aVar.kLS.setText(R.string.select_location_current);
                }
            } else {
                aVar.kLW.setVisibility(4);
            }
            aVar.dZV.setText(nearByAddressData.getName());
            this.eGu.getLayoutMode().setNightMode(z);
            this.eGu.getLayoutMode().onModeChanged(view);
            ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
