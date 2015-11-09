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
    private boolean aQd = false;
    private m bjw;
    private com.baidu.tieba.write.data.b dnx;
    private SearchLocationActivity dny;

    public h(SearchLocationActivity searchLocationActivity) {
        this.dny = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dnx == null || this.dnx.aCw() == null || this.dnx.aCw().isEmpty()) {
            this.aQd = false;
            return 1;
        }
        this.aQd = true;
        return this.dnx.aCw().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dnx == null || this.dnx.aCw() == null || this.dnx.aCw().isEmpty()) {
            return null;
        }
        return this.dnx.aCw().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aQd) {
            return S(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.dny.getPageContext().getPageActivity()).inflate(i.g.location_search_item_layout, viewGroup, false);
            aVar = ay(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.dnz.setText(this.dnx.aCw().get(i).getName());
        an.j(aVar2.line, i.c.cp_bg_line_b);
        an.b(aVar2.dnz, i.c.cp_cont_b, 1);
        an.i(view, i.e.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.dnx = bVar;
    }

    public boolean aCD() {
        return this.aQd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView dnz;
        View line;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a ay(View view) {
        a aVar = new a(this, null);
        aVar.dnz = (TextView) view.findViewById(i.f.location_search_address_name);
        aVar.line = view.findViewById(i.f.location_search_line);
        return aVar;
    }

    public View S(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bjw = NoDataViewFactory.a(this.dny.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.text_try_to_chage_location), null);
        this.bjw.onChangeSkinType(this.dny.getPageContext(), skinType);
        this.bjw.setVisibility(0);
        return this.bjw;
    }
}
