package com.baidu.tieba.write.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private boolean aZg = false;
    private o buP;
    private com.baidu.tieba.write.data.b dUc;
    private SearchLocationActivity dUd;

    public h(SearchLocationActivity searchLocationActivity) {
        this.dUd = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dUc == null || this.dUc.aKo() == null || this.dUc.aKo().isEmpty()) {
            this.aZg = false;
            return 1;
        }
        this.aZg = true;
        return this.dUc.aKo().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dUc == null || this.dUc.aKo() == null || this.dUc.aKo().isEmpty()) {
            return null;
        }
        return this.dUc.aKo().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aZg) {
            return aE(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.dUd.getPageContext().getPageActivity()).inflate(n.h.location_search_item_layout, viewGroup, false);
            aVar = aN(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.dUe.setText(this.dUc.aKo().get(i).getName());
        as.j(aVar2.line, n.d.cp_bg_line_b);
        as.b(aVar2.dUe, n.d.cp_cont_b, 1);
        as.i(view, n.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.dUc = bVar;
    }

    public boolean aKv() {
        return this.aZg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView dUe;
        View line;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a aN(View view) {
        a aVar = new a(this, null);
        aVar.dUe = (TextView) view.findViewById(n.g.location_search_address_name);
        aVar.line = view.findViewById(n.g.location_search_line);
        return aVar;
    }

    public View aE(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.buP = NoDataViewFactory.a(this.dUd.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cM(n.j.text_try_to_chage_location), null);
        this.buP.onChangeSkinType(this.dUd.getPageContext(), skinType);
        this.buP.setVisibility(0);
        return this.buP;
    }
}
