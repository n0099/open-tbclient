package com.baidu.tieba.selectpoi;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private ArrayList<Object> bIS;
    private SelectLocationActivity bIT;
    private boolean isShowLocation;

    public c(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.bIT = selectLocationActivity;
        com.baidu.tieba.location.a locationData = com.baidu.tieba.location.c.Sr().getLocationData();
        this.isShowLocation = com.baidu.tieba.location.c.Sr().Ss() ? false : true;
        if (locationData != null) {
            this.bIS = b(locationData.Sp(), locationData.So());
        }
    }

    private ArrayList<Object> b(List<com.baidu.tieba.location.b> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        com.baidu.tieba.location.b bVar = null;
        for (com.baidu.tieba.location.b bVar2 : list) {
            if (bVar2 != null && !TextUtils.isEmpty(bVar2.getName())) {
                if (TextUtils.equals(bVar2.getName(), str)) {
                    bVar = bVar2;
                } else {
                    arrayList.add(bVar2);
                }
            }
        }
        if (bVar != null) {
            arrayList.add(0, bVar);
        } else {
            com.baidu.tieba.location.b bVar3 = new com.baidu.tieba.location.b();
            bVar3.setName(str);
            arrayList.add(0, bVar3);
        }
        if (this.bIT != null) {
            arrayList.add(0, this.bIT.getString(y.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof com.baidu.tieba.location.b) {
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
        if (this.bIS == null) {
            return 0;
        }
        return this.bIS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bIS == null || i < 0 || i >= this.bIS.size()) {
            return null;
        }
        return this.bIS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        boolean z = TbadkApplication.m251getInst().getSkinType() == 1;
        switch (itemViewType) {
            case 0:
                return b(view, i, z);
            case 1:
                return c(view, i, z);
            default:
                return null;
        }
    }

    private View b(View view, int i, boolean z) {
        e eVar;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof e)) {
                View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bIT, w.select_location_nolocation_item, null);
                eVar = new e(null);
                eVar.QK = (TextView) inflate.findViewById(v.select_location_title);
                eVar.bIV = (ImageView) inflate.findViewById(v.select_location_tick);
                eVar.bip = inflate.findViewById(v.select_location_line);
                inflate.setTag(eVar);
                view2 = inflate;
            } else {
                eVar = (e) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                eVar.bIV.setVisibility(0);
                aw.c(eVar.bIV, u.icon_site_ok);
            } else {
                eVar.bIV.setVisibility(4);
            }
            eVar.QK.setText(str);
            aw.i(eVar.bip, s.cp_bg_line_b);
            aw.b(eVar.QK, s.cp_link_tip_a, 1);
            aw.h(view2, u.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    private View c(View view, int i, boolean z) {
        d dVar;
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.location.b) {
            com.baidu.tieba.location.b bVar = (com.baidu.tieba.location.b) item;
            if (view == null || !(view.getTag() instanceof e)) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.bIT, w.select_location_address_item, null);
                d dVar2 = new d(null);
                dVar2.UH = (TextView) view.findViewById(v.select_location_name);
                dVar2.bIU = (TextView) view.findViewById(v.select_location_address);
                dVar2.bIV = (ImageView) view.findViewById(v.select_location_tick);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.bIU.setText(bVar.Sq());
            if (this.isShowLocation && i == 1) {
                dVar.bIV.setVisibility(0);
                if (TextUtils.isEmpty(bVar.Sq())) {
                    dVar.bIU.setText(y.select_location_current);
                }
            } else {
                dVar.bIV.setVisibility(4);
            }
            dVar.UH.setText(bVar.getName());
            this.bIT.getLayoutMode().L(z);
            this.bIT.getLayoutMode().h(view);
            aw.h(view, u.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
