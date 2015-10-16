package com.baidu.tieba.write.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.m;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private boolean aPV = false;
    private m biR;
    private com.baidu.tieba.write.data.b dlP;
    private SearchLocationActivity dlQ;

    public h(SearchLocationActivity searchLocationActivity) {
        this.dlQ = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dlP == null || this.dlP.aBK() == null || this.dlP.aBK().isEmpty()) {
            this.aPV = false;
            return 1;
        }
        this.aPV = true;
        return this.dlP.aBK().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dlP == null || this.dlP.aBK() == null || this.dlP.aBK().isEmpty()) {
            return null;
        }
        return this.dlP.aBK().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aPV) {
            return R(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.dlQ.getPageContext().getPageActivity()).inflate(i.g.location_search_item_layout, viewGroup, false);
            aVar = az(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.dlR.setText(this.dlP.aBK().get(i).getName());
        an.j(aVar2.line, i.c.cp_bg_line_b);
        an.b(aVar2.dlR, i.c.cp_cont_b, 1);
        an.i(view, i.e.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.dlP = bVar;
    }

    public boolean aBR() {
        return this.aPV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView dlR;
        View line;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a az(View view) {
        a aVar = new a(this, null);
        aVar.dlR = (TextView) view.findViewById(i.f.location_search_address_name);
        aVar.line = view.findViewById(i.f.location_search_line);
        return aVar;
    }

    public View R(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.biR = NoDataViewFactory.a(this.dlQ.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.text_try_to_chage_location), null);
        this.biR.onChangeSkinType(this.dlQ.getPageContext(), skinType);
        this.biR.setVisibility(0);
        return this.biR;
    }
}
