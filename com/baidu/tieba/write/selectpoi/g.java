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
    private boolean aGI = false;
    private s aRH;
    private com.baidu.tieba.tbadkCore.location.l cvj;
    private SearchLocationActivity cvk;

    public g(SearchLocationActivity searchLocationActivity) {
        this.cvk = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cvj == null || this.cvj.ank() == null || this.cvj.ank().isEmpty()) {
            this.aGI = false;
            return 1;
        }
        this.aGI = true;
        return this.cvj.ank().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cvj == null || this.cvj.ank() == null || this.cvj.ank().isEmpty()) {
            return null;
        }
        return this.cvj.ank().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aGI) {
            return t(viewGroup);
        }
        h hVar = null;
        if (view != null && (view.getTag() instanceof h)) {
            hVar = (h) view.getTag();
        }
        if (hVar == null) {
            view = com.baidu.adp.lib.g.b.hH().a(this.cvk.getPageContext().getPageActivity(), w.location_search_item_layout, viewGroup, false);
            hVar = ad(view);
            view.setTag(hVar);
        }
        h hVar2 = hVar;
        hVar2.cvl.setText(this.cvj.ank().get(i).getName());
        ba.j(hVar2.line, com.baidu.tieba.s.cp_bg_line_b);
        ba.b(hVar2.cvl, com.baidu.tieba.s.cp_cont_b, 1);
        ba.i(view, u.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.tbadkCore.location.l lVar) {
        this.cvj = lVar;
    }

    public boolean aql() {
        return this.aGI;
    }

    public h ad(View view) {
        h hVar = new h(this, null);
        hVar.cvl = (TextView) view.findViewById(v.location_search_address_name);
        hVar.line = view.findViewById(v.location_search_line);
        return hVar;
    }

    public View t(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.aRH = NoDataViewFactory.a(this.cvk.getPageContext().getPageActivity(), viewGroup, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.cq(y.text_try_to_chage_location), null);
        this.aRH.onChangeSkinType(this.cvk.getPageContext(), skinType);
        this.aRH.setVisibility(0);
        return this.aRH;
    }
}
