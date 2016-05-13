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
    private com.baidu.tieba.write.data.b eZt;
    private SearchLocationActivity eZu;

    public h(SearchLocationActivity searchLocationActivity) {
        this.eZu = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eZt == null || this.eZt.getSearchLocationDataList() == null || this.eZt.getSearchLocationDataList().isEmpty()) {
            this.bbU = false;
            return 1;
        }
        this.bbU = true;
        return this.eZt.getSearchLocationDataList().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eZt == null || this.eZt.getSearchLocationDataList() == null || this.eZt.getSearchLocationDataList().isEmpty()) {
            return null;
        }
        return this.eZt.getSearchLocationDataList().get(i);
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
            view = LayoutInflater.from(this.eZu.getPageContext().getPageActivity()).inflate(t.h.location_search_item_layout, viewGroup, false);
            aVar = bt(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.eZv.setText(this.eZt.getSearchLocationDataList().get(i).getName());
        at.l(aVar2.aGr, t.d.cp_bg_line_b);
        at.c(aVar2.eZv, t.d.cp_cont_b, 1);
        at.k(view, t.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.eZt = bVar;
    }

    public boolean bbY() {
        return this.bbU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aGr;
        TextView eZv;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a bt(View view) {
        a aVar = new a(this, null);
        aVar.eZv = (TextView) view.findViewById(t.g.location_search_address_name);
        aVar.aGr = view.findViewById(t.g.location_search_line);
        return aVar;
    }

    public View bF(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        this.bDx = NoDataViewFactory.a(this.eZu.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cO(t.j.text_try_to_chage_location), null);
        this.bDx.onChangeSkinType(this.eZu.getPageContext(), skinType);
        this.bDx.setVisibility(0);
        return this.bDx;
    }
}
