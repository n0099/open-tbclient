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
    private boolean aQA = false;
    private u bhV;
    private com.baidu.tieba.tbadkCore.location.i cRF;
    private SearchLocationActivity cRG;

    public h(SearchLocationActivity searchLocationActivity) {
        this.cRG = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRF == null || this.cRF.aqL() == null || this.cRF.aqL().isEmpty()) {
            this.aQA = false;
            return 1;
        }
        this.aQA = true;
        return this.cRF.aqL().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.cRF == null || this.cRF.aqL() == null || this.cRF.aqL().isEmpty()) {
            return null;
        }
        return this.cRF.aqL().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aQA) {
            return A(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.cRG.getPageContext().getPageActivity()).inflate(i.g.location_search_item_layout, viewGroup, false);
            aVar = ap(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.cRH.setText(this.cRF.aqL().get(i).getName());
        al.j(aVar2.line, i.c.cp_bg_line_b);
        al.b(aVar2.cRH, i.c.cp_cont_b, 1);
        al.i(view, i.e.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.tbadkCore.location.i iVar) {
        this.cRF = iVar;
    }

    public boolean auh() {
        return this.aQA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView cRH;
        View line;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a ap(View view) {
        a aVar = new a(this, null);
        aVar.cRH = (TextView) view.findViewById(i.f.location_search_address_name);
        aVar.line = view.findViewById(i.f.location_search_line);
        return aVar;
    }

    public View A(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bhV = NoDataViewFactory.a(this.cRG.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cD(i.C0057i.text_try_to_chage_location), null);
        this.bhV.onChangeSkinType(this.cRG.getPageContext(), skinType);
        this.bhV.setVisibility(0);
        return this.bhV;
    }
}
