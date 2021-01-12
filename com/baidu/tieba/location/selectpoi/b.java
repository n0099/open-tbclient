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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private TbPageContext<SelectLocationActivity> eSJ;
    private boolean isShowLocation;

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        this.eSJ = tbPageContext;
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dLZ().getLocationData();
        this.isShowLocation = !com.baidu.tieba.tbadkCore.location.b.dLZ().dMa();
        if (locationData != null) {
            this.data = n(locationData.getPoi_info(), locationData.getFormatted_address());
        }
    }

    private ArrayList<Object> n(List<LocationData.NearByAddressData> list, String str) {
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
        if (this.eSJ != null) {
            arrayList.add(0, this.eSJ.getString(R.string.select_position_no_location));
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
                return e(view, i, z);
            case 1:
                return f(view, i, z);
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0785b {
        View hWH;
        ImageView lam;
        TextView title;

        private C0785b() {
        }
    }

    private View e(View view, int i, boolean z) {
        View inflate;
        C0785b c0785b;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0785b)) {
                inflate = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                C0785b c0785b2 = new C0785b();
                c0785b2.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0785b2.lam = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0785b2.hWH = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0785b2);
                c0785b = c0785b2;
            } else {
                c0785b = (C0785b) view.getTag();
                inflate = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0785b.lam.setVisibility(0);
                c0785b.lam.setImageDrawable(WebPManager.a(R.drawable.icon_pure_chx__site_ok24, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                c0785b.lam.setVisibility(4);
            }
            c0785b.title.setText(str);
            ao.setBackgroundColor(c0785b.hWH, R.color.CAM_X0204);
            ao.setViewTextColor(c0785b.title, R.color.CAM_X0302, 1);
            ao.setBackgroundResource(inflate, R.drawable.home_recommend_item_bg);
            return inflate;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        TextView eli;
        TextView lai;
        ImageView lam;

        private a() {
        }
    }

    private View f(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            if (view == null || !(view.getTag() instanceof C0785b)) {
                view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.eli = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.lai = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.lam = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.lai.setText(nearByAddressData.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.lam.setVisibility(0);
                aVar.lam.setImageDrawable(WebPManager.a(R.drawable.icon_pure_chx__site_ok24, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                if (TextUtils.isEmpty(nearByAddressData.getAddr())) {
                    aVar.lai.setText(R.string.select_location_current);
                }
            } else {
                aVar.lam.setVisibility(4);
            }
            aVar.eli.setText(nearByAddressData.getName());
            this.eSJ.getLayoutMode().setNightMode(z);
            this.eSJ.getLayoutMode().onModeChanged(view);
            ao.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
