package com.baidu.tieba.write.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private q bDx;
    private boolean bbU = false;
    private com.baidu.tieba.write.data.b eZu;
    private SearchLocationActivity eZv;

    public h(SearchLocationActivity searchLocationActivity) {
        this.eZv = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eZu == null || this.eZu.getSearchLocationDataList() == null || this.eZu.getSearchLocationDataList().isEmpty()) {
            this.bbU = false;
            return 1;
        }
        this.bbU = true;
        return this.eZu.getSearchLocationDataList().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eZu == null || this.eZu.getSearchLocationDataList() == null || this.eZu.getSearchLocationDataList().isEmpty()) {
            return null;
        }
        return this.eZu.getSearchLocationDataList().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.bbU) {
            return bF(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.eZv.getPageContext().getPageActivity()).inflate(t.h.location_search_item_layout, viewGroup, false);
            aVar = bt(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.eZw.setText(this.eZu.getSearchLocationDataList().get(i).getName());
        at.l(aVar2.aGr, t.d.cp_bg_line_b);
        at.c(aVar2.eZw, t.d.cp_cont_b, 1);
        at.k(view, t.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.eZu = bVar;
    }

    public boolean bbR() {
        return this.bbU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aGr;
        TextView eZw;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a bt(View view) {
        a aVar = new a(this, null);
        aVar.eZw = (TextView) view.findViewById(t.g.location_search_address_name);
        aVar.aGr = view.findViewById(t.g.location_search_line);
        return aVar;
    }

    public View bF(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        this.bDx = NoDataViewFactory.a(this.eZv.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cP(t.j.text_try_to_chage_location), null);
        this.bDx.onChangeSkinType(this.eZv.getPageContext(), skinType);
        this.bDx.setVisibility(0);
        return this.bDx;
    }
}
