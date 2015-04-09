package com.baidu.tieba.write.selectpoi;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private ArrayList<Object> cvI;
    private SelectLocationActivity cvJ;
    private boolean isShowLocation;

    public l(SelectLocationActivity selectLocationActivity) {
        this.isShowLocation = true;
        this.cvJ = selectLocationActivity;
        com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.d.anq().getLocationData();
        this.isShowLocation = com.baidu.tieba.tbadkCore.location.d.anq().anr() ? false : true;
        if (locationData != null) {
            this.cvI = d(locationData.ann(), locationData.anm());
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
        if (this.cvJ != null) {
            arrayList.add(0, this.cvJ.getPageContext().getString(y.select_position_no_location));
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
        if (this.cvI == null) {
            return 0;
        }
        return this.cvI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cvI == null || i < 0 || i >= this.cvI.size()) {
            return null;
        }
        return this.cvI.get(i);
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
                View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.cvJ.getPageContext().getPageActivity(), w.select_location_nolocation_item, null);
                nVar = new n(null);
                nVar.ahz = (TextView) inflate.findViewById(v.select_location_title);
                nVar.cvK = (ImageView) inflate.findViewById(v.select_location_tick);
                nVar.line = inflate.findViewById(v.select_location_line);
                inflate.setTag(nVar);
                view2 = inflate;
            } else {
                nVar = (n) view.getTag();
                view2 = view;
            }
            if (i == 0 && !this.isShowLocation) {
                nVar.cvK.setVisibility(0);
                ba.c(nVar.cvK, u.icon_site_ok);
            } else {
                nVar.cvK.setVisibility(4);
            }
            nVar.ahz.setText(str);
            ba.j(nVar.line, s.cp_bg_line_b);
            ba.b(nVar.ahz, s.cp_link_tip_a, 1);
            ba.i(view2, u.home_recommend_item_bg);
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
                view = com.baidu.adp.lib.g.b.hH().inflate(this.cvJ.getPageContext().getPageActivity(), w.select_location_address_item, null);
                m mVar2 = new m(null);
                mVar2.aFA = (TextView) view.findViewById(v.select_location_name);
                mVar2.cvB = (TextView) view.findViewById(v.select_location_address);
                mVar2.cvK = (ImageView) view.findViewById(v.select_location_tick);
                view.setTag(mVar2);
                mVar = mVar2;
            } else {
                mVar = (m) view.getTag();
            }
            mVar.cvB.setText(bVar.anp());
            if (this.isShowLocation && i == 1) {
                mVar.cvK.setVisibility(0);
                if (TextUtils.isEmpty(bVar.anp())) {
                    mVar.cvB.setText(y.select_location_current);
                }
            } else {
                mVar.cvK.setVisibility(4);
            }
            mVar.aFA.setText(bVar.getName());
            this.cvJ.getLayoutMode().X(z);
            this.cvJ.getLayoutMode().h(view);
            ba.i(view, u.home_recommend_item_bg);
            return view;
        }
        return null;
    }
}
