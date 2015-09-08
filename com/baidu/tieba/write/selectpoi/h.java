package com.baidu.tieba.write.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private boolean aQO = false;
    private u bis;
    private com.baidu.tieba.tbadkCore.location.i daq;
    private SearchLocationActivity dar;

    public h(SearchLocationActivity searchLocationActivity) {
        this.dar = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.daq == null || this.daq.auZ() == null || this.daq.auZ().isEmpty()) {
            this.aQO = false;
            return 1;
        }
        this.aQO = true;
        return this.daq.auZ().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.daq == null || this.daq.auZ() == null || this.daq.auZ().isEmpty()) {
            return null;
        }
        return this.daq.auZ().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aQO) {
            return G(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.dar.getPageContext().getPageActivity()).inflate(i.g.location_search_item_layout, viewGroup, false);
            aVar = ay(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.das.setText(this.daq.auZ().get(i).getName());
        al.i(aVar2.line, i.c.cp_bg_line_b);
        al.b(aVar2.das, i.c.cp_cont_b, 1);
        al.h(view, i.e.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.tbadkCore.location.i iVar) {
        this.daq = iVar;
    }

    public boolean ayA() {
        return this.aQO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView das;
        View line;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a ay(View view) {
        a aVar = new a(this, null);
        aVar.das = (TextView) view.findViewById(i.f.location_search_address_name);
        aVar.line = view.findViewById(i.f.location_search_line);
        return aVar;
    }

    public View G(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bis = NoDataViewFactory.a(this.dar.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cJ(i.h.text_try_to_chage_location), null);
        this.bis.onChangeSkinType(this.dar.getPageContext(), skinType);
        this.bis.setVisibility(0);
        return this.bis;
    }
}
