package com.baidu.tieba.write.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private boolean bxP = false;
    private q cba;
    private com.baidu.tieba.write.data.b fEx;
    private SearchLocationActivity fEy;

    public h(SearchLocationActivity searchLocationActivity) {
        this.fEy = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fEx == null || this.fEx.getSearchLocationDataList() == null || this.fEx.getSearchLocationDataList().isEmpty()) {
            this.bxP = false;
            return 1;
        }
        this.bxP = true;
        return this.fEx.getSearchLocationDataList().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fEx == null || this.fEx.getSearchLocationDataList() == null || this.fEx.getSearchLocationDataList().isEmpty()) {
            return null;
        }
        return this.fEx.getSearchLocationDataList().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.bxP) {
            return bW(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.fEy.getPageContext().getPageActivity()).inflate(u.h.location_search_item_layout, viewGroup, false);
            aVar = bB(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.fEz.setText(this.fEx.getSearchLocationDataList().get(i).getName());
        av.l(aVar2.aGT, u.d.cp_bg_line_b);
        av.c(aVar2.fEz, u.d.cp_cont_b, 1);
        av.k(view, u.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.fEx = bVar;
    }

    public boolean bku() {
        return this.bxP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View aGT;
        TextView fEz;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a bB(View view) {
        a aVar = new a(this, null);
        aVar.fEz = (TextView) view.findViewById(u.g.location_search_address_name);
        aVar.aGT = view.findViewById(u.g.location_search_line);
        return aVar;
    }

    public View bW(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.cba = NoDataViewFactory.a(this.fEy.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cQ(u.j.text_try_to_chage_location), null);
        this.cba.onChangeSkinType(this.fEy.getPageContext(), skinType);
        this.cba.setVisibility(0);
        return this.cba;
    }
}
