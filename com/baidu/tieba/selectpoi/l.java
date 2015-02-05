package com.baidu.tieba.selectpoi;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private ArrayList<Object> bOP;
    private SelectLocationActivity bOQ;
    private boolean isShowLocation;

    public l(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.bOQ = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.ahX().getLocationData();
        this.isShowLocation = com.baidu.tieba.tbadkCore.location.c.ahX().ahY() ? false : true;
        if (locationData != null) {
            this.bOP = d(locationData.ahU(), locationData.ahT());
        }
    }

    private ArrayList<Object> d(List<com.baidu.tieba.tbadkCore.location.b> list, String str) {
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
        if (this.bOQ != null) {
            arrayList.add(0, this.bOQ.getPageContext().getString(z.select_position_no_location));
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
        if (this.bOP == null) {
            return 0;
        }
        return this.bOP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bOP == null || i < 0 || i >= this.bOP.size()) {
            return null;
        }
        return this.bOP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        boolean z = TbadkCoreApplication.m255getInst().getSkinType() == 1;
        switch (itemViewType) {
            case 0:
                return a(view, i, z);
            case 1:
                return b(view, i, z);
            default:
                return null;
        }
    }

    private View a(View view, int i, boolean z) {
        n nVar;
        View view2;
        Object item = getItem(i);
        if (item instanceof String) {
            String str = (String) item;
            if (view == null || !(view.getTag() instanceof n)) {
                View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bOQ.getPageContext().getPageActivity(), x.select_location_nolocation_item, null);
                nVar = new n(null);
                nVar.Xl = (TextView) inflate.findViewById(w.select_location_title);
                nVar.bOR = (ImageView) inflate.findViewById(w.select_location_tick);
                nVar.line = inflate.findViewById(w.select_location_line);
                inflate.setTag(nVar);
                view2 = inflate;
            } else {
                nVar = (n) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                nVar.bOR.setVisibility(0);
                bc.c(nVar.bOR, v.icon_site_ok);
            } else {
                nVar.bOR.setVisibility(4);
            }
            nVar.Xl.setText(str);
            bc.j(nVar.line, t.cp_bg_line_b);
            bc.b(nVar.Xl, t.cp_link_tip_a, 1);
            bc.i(view2, v.home_recommend_item_bg);
            return view2;
        }
        return null;
    }

    private View b(View view, int i, boolean z) {
        m mVar;
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.tbadkCore.location.b) {
            com.baidu.tieba.tbadkCore.location.b bVar = (com.baidu.tieba.tbadkCore.location.b) item;
            if (view == null || !(view.getTag() instanceof n)) {
                view = com.baidu.adp.lib.g.b.ei().inflate(this.bOQ.getPageContext().getPageActivity(), x.select_location_address_item, null);
                m mVar2 = new m(null);
                mVar2.abj = (TextView) view.findViewById(w.select_location_name);
                mVar2.bOJ = (TextView) view.findViewById(w.select_location_address);
                mVar2.bOR = (ImageView) view.findViewById(w.select_location_tick);
                view.setTag(mVar2);
                mVar = mVar2;
            } else {
                mVar = (m) view.getTag();
            }
            mVar.bOJ.setText(bVar.ahW());
            if (this.isShowLocation && i == 1) {
                mVar.bOR.setVisibility(0);
                if (TextUtils.isEmpty(bVar.ahW())) {
                    mVar.bOJ.setText(z.select_location_current);
                }
            } else {
                mVar.bOR.setVisibility(4);
            }
            mVar.abj.setText(bVar.getName());
            this.bOQ.getLayoutMode().ab(z);
            this.bOQ.getLayoutMode().h(view);
            bc.i(view, v.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
