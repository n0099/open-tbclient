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
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private ArrayList<Object> data;
    private TbPageContext<SelectLocationActivity> eXu;
    private boolean isShowLocation;

    public b(TbPageContext<SelectLocationActivity> tbPageContext) {
        this.eXu = tbPageContext;
        LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dPR().getLocationData();
        this.isShowLocation = !com.baidu.tieba.tbadkCore.location.b.dPR().dPS();
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
        if (this.eXu != null) {
            arrayList.add(0, this.eXu.getString(R.string.select_position_no_location));
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
    /* loaded from: classes8.dex */
    public static class C0802b {
        View ibo;
        ImageView leU;
        TextView title;

        private C0802b() {
        }
    }

    private View e(View view, int i, boolean z) {
        View inflate;
        C0802b c0802b;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof C0802b)) {
                inflate = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.select_location_nolocation_item, (ViewGroup) null);
                C0802b c0802b2 = new C0802b();
                c0802b2.title = (TextView) inflate.findViewById(R.id.select_location_title);
                c0802b2.leU = (ImageView) inflate.findViewById(R.id.select_location_tick);
                c0802b2.ibo = inflate.findViewById(R.id.select_location_line);
                inflate.setTag(c0802b2);
                c0802b = c0802b2;
            } else {
                c0802b = (C0802b) view.getTag();
                inflate = view;
            }
            if (i == 0 && !this.isShowLocation) {
                c0802b.leU.setVisibility(0);
                c0802b.leU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_chx__site_ok24, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                c0802b.leU.setVisibility(4);
            }
            c0802b.title.setText(str);
            ao.setBackgroundColor(c0802b.ibo, R.color.CAM_X0204);
            ao.setViewTextColor(c0802b.title, R.color.CAM_X0302, 1);
            ao.setBackgroundResource(inflate, R.drawable.home_recommend_item_bg);
            return inflate;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        TextView epX;
        TextView leQ;
        ImageView leU;

        private a() {
        }
    }

    private View f(View view, int i, boolean z) {
        a aVar;
        Object item = getItem(i);
        if (item instanceof LocationData.NearByAddressData) {
            LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
            if (view == null || !(view.getTag() instanceof C0802b)) {
                view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.select_location_address_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.epX = (TextView) view.findViewById(R.id.select_location_name);
                aVar2.leQ = (TextView) view.findViewById(R.id.select_location_address);
                aVar2.leU = (ImageView) view.findViewById(R.id.select_location_tick);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.leQ.setText(nearByAddressData.getAddr());
            if (this.isShowLocation && i == 1) {
                aVar.leU.setVisibility(0);
                aVar.leU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_chx__site_ok24, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL_PRESS));
                if (TextUtils.isEmpty(nearByAddressData.getAddr())) {
                    aVar.leQ.setText(R.string.select_location_current);
                }
            } else {
                aVar.leU.setVisibility(4);
            }
            aVar.epX.setText(nearByAddressData.getName());
            this.eXu.getLayoutMode().setNightMode(z);
            this.eXu.getLayoutMode().onModeChanged(view);
            ao.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
