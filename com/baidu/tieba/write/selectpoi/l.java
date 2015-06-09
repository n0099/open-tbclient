package com.baidu.tieba.write.selectpoi;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private SelectLocationActivity cAa;
    private ArrayList<Object> data;
    private boolean isShowLocation;

    public l(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.cAa = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.d.api().getLocationData();
        this.isShowLocation = com.baidu.tieba.tbadkCore.location.d.api().apj() ? false : true;
        if (locationData != null) {
            this.data = c(locationData.apf(), locationData.ape());
        }
    }

    private ArrayList<Object> c(List<com.baidu.tieba.tbadkCore.location.b> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        com.baidu.tieba.tbadkCore.location.b bVar = null;
        for (com.baidu.tieba.tbadkCore.location.b bVar2 : list) {
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
            com.baidu.tieba.tbadkCore.location.b bVar3 = new com.baidu.tieba.tbadkCore.location.b();
            bVar3.setName(str);
            arrayList.add(0, bVar3);
        }
        if (this.cAa != null) {
            arrayList.add(0, this.cAa.getPageContext().getString(t.select_position_no_location));
        }
        return arrayList;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (item instanceof String) {
            return 0;
        }
        if (item instanceof com.baidu.tieba.tbadkCore.location.b) {
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

    private View b(View view, int i, boolean z) {
        n nVar;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof n)) {
                View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.cAa.getPageContext().getPageActivity(), r.select_location_nolocation_item, null);
                nVar = new n(null);
                nVar.aiA = (TextView) inflate.findViewById(q.select_location_title);
                nVar.cAb = (ImageView) inflate.findViewById(q.select_location_tick);
                nVar.line = inflate.findViewById(q.select_location_line);
                inflate.setTag(nVar);
                view2 = inflate;
            } else {
                nVar = (n) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                nVar.cAb.setVisibility(0);
                ay.c(nVar.cAb, p.icon_site_ok);
            } else {
                nVar.cAb.setVisibility(4);
            }
            nVar.aiA.setText(str);
            ay.j(nVar.line, com.baidu.tieba.n.cp_bg_line_b);
            ay.b(nVar.aiA, com.baidu.tieba.n.cp_link_tip_a, 1);
            ay.i(view2, p.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    private View c(View view, int i, boolean z) {
        m mVar;
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.tbadkCore.location.b) {
            com.baidu.tieba.tbadkCore.location.b bVar = (com.baidu.tieba.tbadkCore.location.b) item;
            if (view == null || !(view.getTag() instanceof n)) {
                view = com.baidu.adp.lib.g.b.hr().inflate(this.cAa.getPageContext().getPageActivity(), r.select_location_address_item, null);
                m mVar2 = new m(null);
                mVar2.aHI = (TextView) view.findViewById(q.select_location_name);
                mVar2.czT = (TextView) view.findViewById(q.select_location_address);
                mVar2.cAb = (ImageView) view.findViewById(q.select_location_tick);
                view.setTag(mVar2);
                mVar = mVar2;
            } else {
                mVar = (m) view.getTag();
            }
            mVar.czT.setText(bVar.aph());
            if (this.isShowLocation && i == 1) {
                mVar.cAb.setVisibility(0);
                if (TextUtils.isEmpty(bVar.aph())) {
                    mVar.czT.setText(t.select_location_current);
                }
            } else {
                mVar.cAb.setVisibility(4);
            }
            mVar.aHI.setText(bVar.getName());
            this.cAa.getLayoutMode().ab(z);
            this.cAa.getLayoutMode().j(view);
            ay.i(view, p.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
