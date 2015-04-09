package com.baidu.tieba.write.selectpoi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private boolean aGQ = false;
    private s aRX;
    private SearchLocationActivity cvA;
    private com.baidu.tieba.tbadkCore.location.l cvz;

    public g(SearchLocationActivity searchLocationActivity) {
        this.cvA = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cvz == null || this.cvz.anz() == null || this.cvz.anz().isEmpty()) {
            this.aGQ = false;
            return 1;
        }
        this.aGQ = true;
        return this.cvz.anz().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cvz == null || this.cvz.anz() == null || this.cvz.anz().isEmpty()) {
            return null;
        }
        return this.cvz.anz().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aGQ) {
            return t(viewGroup);
        }
        h hVar = null;
        if (view != null && (view.getTag() instanceof h)) {
            hVar = (h) view.getTag();
        }
        if (hVar == null) {
            view = com.baidu.adp.lib.g.b.hH().a(this.cvA.getPageContext().getPageActivity(), w.location_search_item_layout, viewGroup, false);
            hVar = ad(view);
            view.setTag(hVar);
        }
        h hVar2 = hVar;
        hVar2.cvB.setText(this.cvz.anz().get(i).getName());
        ba.j(hVar2.line, com.baidu.tieba.s.cp_bg_line_b);
        ba.b(hVar2.cvB, com.baidu.tieba.s.cp_cont_b, 1);
        ba.i(view, u.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.tbadkCore.location.l lVar) {
        this.cvz = lVar;
    }

    public boolean aqA() {
        return this.aGQ;
    }

    public h ad(View view) {
        h hVar = new h(this, null);
        hVar.cvB = (TextView) view.findViewById(v.location_search_address_name);
        hVar.line = view.findViewById(v.location_search_line);
        return hVar;
    }

    public View t(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aRX = NoDataViewFactory.a(this.cvA.getPageContext().getPageActivity(), viewGroup, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(y.text_try_to_chage_location), null);
        this.aRX.onChangeSkinType(this.cvA.getPageContext(), skinType);
        this.aRX.setVisibility(0);
        return this.aRX;
    }
}
