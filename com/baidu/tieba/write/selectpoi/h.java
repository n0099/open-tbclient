package com.baidu.tieba.write.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private p bDt;
    private boolean bgf = false;
    private com.baidu.tieba.write.data.b eID;
    private SearchLocationActivity eIE;

    public h(SearchLocationActivity searchLocationActivity) {
        this.eIE = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eID == null || this.eID.aZy() == null || this.eID.aZy().isEmpty()) {
            this.bgf = false;
            return 1;
        }
        this.bgf = true;
        return this.eID.aZy().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eID == null || this.eID.aZy() == null || this.eID.aZy().isEmpty()) {
            return null;
        }
        return this.eID.aZy().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.bgf) {
            return bo(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.eIE.getPageContext().getPageActivity()).inflate(t.h.location_search_item_layout, viewGroup, false);
            aVar = bk(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.eIF.setText(this.eID.aZy().get(i).getName());
        at.l(aVar2.aKi, t.d.cp_bg_line_b);
        at.b(aVar2.eIF, t.d.cp_cont_b, 1);
        at.k(view, t.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.eID = bVar;
    }

    public boolean aZF() {
        return this.bgf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aKi;
        TextView eIF;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a bk(View view) {
        a aVar = new a(this, null);
        aVar.eIF = (TextView) view.findViewById(t.g.location_search_address_name);
        aVar.aKi = view.findViewById(t.g.location_search_line);
        return aVar;
    }

    public View bo(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bDt = NoDataViewFactory.a(this.eIE.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dg(t.j.text_try_to_chage_location), null);
        this.bDt.onChangeSkinType(this.eIE.getPageContext(), skinType);
        this.bDt.setVisibility(0);
        return this.bDt;
    }
}
