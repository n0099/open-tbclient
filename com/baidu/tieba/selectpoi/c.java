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
    private ArrayList<Object> bIE;
    private SelectLocationActivity bIF;
    private boolean isShowLocation;

    public c(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.bIF = selectLocationActivity;
        com.baidu.tieba.location.a locationData = com.baidu.tieba.location.c.So().getLocationData();
        this.isShowLocation = com.baidu.tieba.location.c.So().Sp() ? false : true;
        if (locationData != null) {
            this.bIE = b(locationData.Sm(), locationData.Sl());
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
        if (this.bIF != null) {
            arrayList.add(0, this.bIF.getString(y.select_position_no_location));
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
        if (this.bIE == null) {
            return 0;
        }
        return this.bIE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bIE == null || i < 0 || i >= this.bIE.size()) {
            return null;
        }
        return this.bIE.get(i);
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
                View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bIF, w.select_location_nolocation_item, null);
                eVar = new e(null);
                eVar.QG = (TextView) inflate.findViewById(v.select_location_title);
                eVar.bIH = (ImageView) inflate.findViewById(v.select_location_tick);
                eVar.bhZ = inflate.findViewById(v.select_location_line);
                inflate.setTag(eVar);
                view2 = inflate;
            } else {
                eVar = (e) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                eVar.bIH.setVisibility(0);
                aw.c(eVar.bIH, u.icon_site_ok);
            } else {
                eVar.bIH.setVisibility(4);
            }
            eVar.QG.setText(str);
            aw.i(eVar.bhZ, s.cp_bg_line_b);
            aw.b(eVar.QG, s.cp_link_tip_a, 1);
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
                view = com.baidu.adp.lib.g.b.ek().inflate(this.bIF, w.select_location_address_item, null);
                d dVar2 = new d(null);
                dVar2.UD = (TextView) view.findViewById(v.select_location_name);
                dVar2.bIG = (TextView) view.findViewById(v.select_location_address);
                dVar2.bIH = (ImageView) view.findViewById(v.select_location_tick);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.bIG.setText(bVar.Sn());
            if (this.isShowLocation && i == 1) {
                dVar.bIH.setVisibility(0);
                if (TextUtils.isEmpty(bVar.Sn())) {
                    dVar.bIG.setText(y.select_location_current);
                }
            } else {
                dVar.bIH.setVisibility(4);
            }
            dVar.UD.setText(bVar.getName());
            this.bIF.getLayoutMode().L(z);
            this.bIF.getLayoutMode().h(view);
            aw.h(view, u.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
