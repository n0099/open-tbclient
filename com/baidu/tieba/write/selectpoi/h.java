package com.baidu.tieba.write.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private boolean bbv = false;
    private o bxU;
    private com.baidu.tieba.write.data.b eoH;
    private SearchLocationActivity eoI;

    public h(SearchLocationActivity searchLocationActivity) {
        this.eoI = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eoH == null || this.eoH.aSY() == null || this.eoH.aSY().isEmpty()) {
            this.bbv = false;
            return 1;
        }
        this.bbv = true;
        return this.eoH.aSY().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eoH == null || this.eoH.aSY() == null || this.eoH.aSY().isEmpty()) {
            return null;
        }
        return this.eoH.aSY().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.bbv) {
            return aZ(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.eoI.getPageContext().getPageActivity()).inflate(t.h.location_search_item_layout, viewGroup, false);
            aVar = bf(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.eoJ.setText(this.eoH.aSY().get(i).getName());
        ar.l(aVar2.aHm, t.d.cp_bg_line_b);
        ar.b(aVar2.eoJ, t.d.cp_cont_b, 1);
        ar.k(view, t.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.eoH = bVar;
    }

    public boolean aTf() {
        return this.bbv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aHm;
        TextView eoJ;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a bf(View view) {
        a aVar = new a(this, null);
        aVar.eoJ = (TextView) view.findViewById(t.g.location_search_address_name);
        aVar.aHm = view.findViewById(t.g.location_search_line);
        return aVar;
    }

    public View aZ(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bxU = NoDataViewFactory.a(this.eoI.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dd(t.j.text_try_to_chage_location), null);
        this.bxU.onChangeSkinType(this.eoI.getPageContext(), skinType);
        this.bxU.setVisibility(0);
        return this.bxU;
    }
}
