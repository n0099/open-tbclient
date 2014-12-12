package com.baidu.tieba.selectpoi;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
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
    private x aKz;
    private boolean axy = false;
    private com.baidu.tieba.tbadkCore.location.k bMY;
    private SearchLocationActivity bMZ;

    public h(SearchLocationActivity searchLocationActivity) {
        this.bMZ = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bMY == null || this.bMY.ahH() == null || this.bMY.ahH().isEmpty()) {
            this.axy = false;
            return 1;
        }
        this.axy = true;
        return this.bMY.ahH().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bMY == null || this.bMY.ahH() == null || this.bMY.ahH().isEmpty()) {
            return null;
        }
        return this.bMY.ahH().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.axy) {
            return d(viewGroup);
        }
        i iVar = null;
        if (view != null && (view.getTag() instanceof i)) {
            iVar = (i) view.getTag();
        }
        if (iVar == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.bMZ.getPageContext().getPageActivity(), com.baidu.tieba.x.location_search_item_layout, viewGroup, false);
            iVar = S(view);
            view.setTag(iVar);
        }
        i iVar2 = iVar;
        iVar2.bNa.setText(this.bMY.ahH().get(i).getName());
        ax.j(iVar2.line, t.cp_bg_line_b);
        ax.b(iVar2.bNa, t.cp_cont_b, 1);
        ax.i(view, v.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.tbadkCore.location.k kVar) {
        this.bMY = kVar;
    }

    public boolean acn() {
        return this.axy;
    }

    public i S(View view) {
        i iVar = new i(this, null);
        iVar.bNa = (TextView) view.findViewById(w.location_search_address_name);
        iVar.line = view.findViewById(w.location_search_line);
        return iVar;
    }

    public View d(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.aKz = NoDataViewFactory.a(this.bMZ.getPageContext().getPageActivity(), viewGroup, aa.a(NoDataViewFactory.ImgType.NODATA), ab.ci(z.text_try_to_chage_location), null);
        this.aKz.onChangeSkinType(this.bMZ.getPageContext(), skinType);
        this.aKz.setVisibility(0);
        return this.aKz;
    }
}
