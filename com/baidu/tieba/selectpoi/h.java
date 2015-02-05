package com.baidu.tieba.selectpoi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private x aLF;
    private boolean ayv = false;
    private com.baidu.tieba.tbadkCore.location.k bOH;
    private SearchLocationActivity bOI;

    public h(SearchLocationActivity searchLocationActivity) {
        this.bOI = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bOH == null || this.bOH.aig() == null || this.bOH.aig().isEmpty()) {
            this.ayv = false;
            return 1;
        }
        this.ayv = true;
        return this.bOH.aig().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bOH == null || this.bOH.aig() == null || this.bOH.aig().isEmpty()) {
            return null;
        }
        return this.bOH.aig().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.ayv) {
            return e(viewGroup);
        }
        i iVar = null;
        if (view != null && (view.getTag() instanceof i)) {
            iVar = (i) view.getTag();
        }
        if (iVar == null) {
            view = com.baidu.adp.lib.g.b.ei().a(this.bOI.getPageContext().getPageActivity(), com.baidu.tieba.x.location_search_item_layout, viewGroup, false);
            iVar = U(view);
            view.setTag(iVar);
        }
        i iVar2 = iVar;
        iVar2.bOJ.setText(this.bOH.aig().get(i).getName());
        bc.j(iVar2.line, t.cp_bg_line_b);
        bc.b(iVar2.bOJ, t.cp_cont_b, 1);
        bc.i(view, v.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.tbadkCore.location.k kVar) {
        this.bOH = kVar;
    }

    public boolean acM() {
        return this.ayv;
    }

    public i U(View view) {
        i iVar = new i(this, null);
        iVar.bOJ = (TextView) view.findViewById(w.location_search_address_name);
        iVar.line = view.findViewById(w.location_search_line);
        return iVar;
    }

    public View e(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.aLF = NoDataViewFactory.a(this.bOI.getPageContext().getPageActivity(), viewGroup, aa.a(NoDataViewFactory.ImgType.NODATA), ab.cp(z.text_try_to_chage_location), null);
        this.aLF.onChangeSkinType(this.bOI.getPageContext(), skinType);
        this.aLF.setVisibility(0);
        return this.aLF;
    }
}
