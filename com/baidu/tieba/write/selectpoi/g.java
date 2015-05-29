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
    private boolean aIY = false;
    private x aTW;
    private com.baidu.tieba.tbadkCore.location.l czQ;
    private SearchLocationActivity czR;

    public g(SearchLocationActivity searchLocationActivity) {
        this.czR = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.czQ == null || this.czQ.apq() == null || this.czQ.apq().isEmpty()) {
            this.aIY = false;
            return 1;
        }
        this.aIY = true;
        return this.czQ.apq().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.czQ == null || this.czQ.apq() == null || this.czQ.apq().isEmpty()) {
            return null;
        }
        return this.czQ.apq().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aIY) {
            return s(viewGroup);
        }
        h hVar = null;
        if (view != null && (view.getTag() instanceof h)) {
            hVar = (h) view.getTag();
        }
        if (hVar == null) {
            view = com.baidu.adp.lib.g.b.hr().a(this.czR.getPageContext().getPageActivity(), r.location_search_item_layout, viewGroup, false);
            hVar = ae(view);
            view.setTag(hVar);
        }
        h hVar2 = hVar;
        hVar2.czS.setText(this.czQ.apq().get(i).getName());
        ay.j(hVar2.line, com.baidu.tieba.n.cp_bg_line_b);
        ay.b(hVar2.czS, com.baidu.tieba.n.cp_cont_b, 1);
        ay.i(view, p.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.tbadkCore.location.l lVar) {
        this.czQ = lVar;
    }

    public boolean asq() {
        return this.aIY;
    }

    public h ae(View view) {
        h hVar = new h(this, null);
        hVar.czS = (TextView) view.findViewById(q.location_search_address_name);
        hVar.line = view.findViewById(q.location_search_line);
        return hVar;
    }

    public View s(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aTW = NoDataViewFactory.a(this.czR.getPageContext().getPageActivity(), viewGroup, aa.a(NoDataViewFactory.ImgType.NODATA), ab.cv(t.text_try_to_chage_location), null);
        this.aTW.onChangeSkinType(this.czR.getPageContext(), skinType);
        this.aTW.setVisibility(0);
        return this.aTW;
    }
}
