package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private boolean cVS = false;
    private com.baidu.tieba.location.data.a eRM;
    private SearchLocationActivity eRN;
    private NoDataView eRO;

    public a(SearchLocationActivity searchLocationActivity) {
        this.eRN = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eRM == null || this.eRM.aRK() == null || this.eRM.aRK().isEmpty()) {
            this.cVS = false;
            return 1;
        }
        this.cVS = true;
        return this.eRM.aRK().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eRM == null || this.eRM.aRK() == null || this.eRM.aRK().isEmpty()) {
            return null;
        }
        return this.eRM.aRK().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.cVS) {
            return bf(viewGroup);
        }
        C0195a c0195a = null;
        if (view != null && (view.getTag() instanceof C0195a)) {
            c0195a = (C0195a) view.getTag();
        }
        if (c0195a == null) {
            view = LayoutInflater.from(this.eRN.getPageContext().getPageActivity()).inflate(d.i.location_search_item_layout, viewGroup, false);
            c0195a = aR(view);
            view.setTag(c0195a);
        }
        C0195a c0195a2 = c0195a;
        c0195a2.eRP.setText(this.eRM.aRK().get(i).getName());
        am.j(c0195a2.ebW, d.C0142d.cp_bg_line_b);
        am.c(c0195a2.eRP, d.C0142d.cp_cont_b, 1);
        am.i(view, d.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.eRM = aVar;
    }

    public boolean aRO() {
        return this.cVS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0195a {
        TextView eRP;
        View ebW;

        private C0195a() {
        }
    }

    public C0195a aR(View view) {
        C0195a c0195a = new C0195a();
        c0195a.eRP = (TextView) view.findViewById(d.g.location_search_address_name);
        c0195a.ebW = view.findViewById(d.g.location_search_line);
        return c0195a;
    }

    public View bf(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eRO = NoDataViewFactory.a(this.eRN.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ds(d.k.text_try_to_chage_location), null);
        this.eRO.onChangeSkinType(this.eRN.getPageContext(), skinType);
        this.eRO.setVisibility(0);
        return this.eRO;
    }
}
