package com.baidu.tieba.write.selectpoi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private boolean aIZ = false;
    private x aTX;
    private com.baidu.tieba.tbadkCore.location.l czR;
    private SearchLocationActivity czS;

    public g(SearchLocationActivity searchLocationActivity) {
        this.czS = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.czR == null || this.czR.apr() == null || this.czR.apr().isEmpty()) {
            this.aIZ = false;
            return 1;
        }
        this.aIZ = true;
        return this.czR.apr().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.czR == null || this.czR.apr() == null || this.czR.apr().isEmpty()) {
            return null;
        }
        return this.czR.apr().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aIZ) {
            return s(viewGroup);
        }
        h hVar = null;
        if (view != null && (view.getTag() instanceof h)) {
            hVar = (h) view.getTag();
        }
        if (hVar == null) {
            view = com.baidu.adp.lib.g.b.hr().a(this.czS.getPageContext().getPageActivity(), r.location_search_item_layout, viewGroup, false);
            hVar = ae(view);
            view.setTag(hVar);
        }
        h hVar2 = hVar;
        hVar2.czT.setText(this.czR.apr().get(i).getName());
        ay.j(hVar2.line, com.baidu.tieba.n.cp_bg_line_b);
        ay.b(hVar2.czT, com.baidu.tieba.n.cp_cont_b, 1);
        ay.i(view, p.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.tbadkCore.location.l lVar) {
        this.czR = lVar;
    }

    public boolean asr() {
        return this.aIZ;
    }

    public h ae(View view) {
        h hVar = new h(this, null);
        hVar.czT = (TextView) view.findViewById(q.location_search_address_name);
        hVar.line = view.findViewById(q.location_search_line);
        return hVar;
    }

    public View s(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aTX = NoDataViewFactory.a(this.czS.getPageContext().getPageActivity(), viewGroup, aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(t.text_try_to_chage_location), null);
        this.aTX.onChangeSkinType(this.czS.getPageContext(), skinType);
        this.aTX.setVisibility(0);
        return this.aTX;
    }
}
