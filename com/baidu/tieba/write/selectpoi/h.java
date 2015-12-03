package com.baidu.tieba.write.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.n;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private boolean aVg = false;
    private n bqY;
    private com.baidu.tieba.write.data.b dMD;
    private SearchLocationActivity dME;

    public h(SearchLocationActivity searchLocationActivity) {
        this.dME = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dMD == null || this.dMD.aHT() == null || this.dMD.aHT().isEmpty()) {
            this.aVg = false;
            return 1;
        }
        this.aVg = true;
        return this.dMD.aHT().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dMD == null || this.dMD.aHT() == null || this.dMD.aHT().isEmpty()) {
            return null;
        }
        return this.dMD.aHT().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aVg) {
            return ay(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.dME.getPageContext().getPageActivity()).inflate(n.g.location_search_item_layout, viewGroup, false);
            aVar = aH(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.dMF.setText(this.dMD.aHT().get(i).getName());
        as.j(aVar2.line, n.c.cp_bg_line_b);
        as.b(aVar2.dMF, n.c.cp_cont_b, 1);
        as.i(view, n.e.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.dMD = bVar;
    }

    public boolean aIa() {
        return this.aVg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView dMF;
        View line;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a aH(View view) {
        a aVar = new a(this, null);
        aVar.dMF = (TextView) view.findViewById(n.f.location_search_address_name);
        aVar.line = view.findViewById(n.f.location_search_line);
        return aVar;
    }

    public View ay(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bqY = NoDataViewFactory.a(this.dME.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cS(n.i.text_try_to_chage_location), null);
        this.bqY.onChangeSkinType(this.dME.getPageContext(), skinType);
        this.bqY.setVisibility(0);
        return this.bqY;
    }
}
