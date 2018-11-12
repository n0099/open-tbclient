package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private boolean dnK = false;
    private com.baidu.tieba.location.data.a flZ;
    private SearchLocationActivity fma;
    private NoDataView fmb;

    public a(SearchLocationActivity searchLocationActivity) {
        this.fma = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.flZ == null || this.flZ.aXH() == null || this.flZ.aXH().isEmpty()) {
            this.dnK = false;
            return 1;
        }
        this.dnK = true;
        return this.flZ.aXH().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.flZ == null || this.flZ.aXH() == null || this.flZ.aXH().isEmpty()) {
            return null;
        }
        return this.flZ.aXH().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.dnK) {
            return bh(viewGroup);
        }
        C0256a c0256a = null;
        if (view != null && (view.getTag() instanceof C0256a)) {
            c0256a = (C0256a) view.getTag();
        }
        if (c0256a == null) {
            view = LayoutInflater.from(this.fma.getPageContext().getPageActivity()).inflate(e.h.location_search_item_layout, viewGroup, false);
            c0256a = bk(view);
            view.setTag(c0256a);
        }
        C0256a c0256a2 = c0256a;
        c0256a2.fmc.setText(this.flZ.aXH().get(i).getName());
        al.j(c0256a2.ewr, e.d.cp_bg_line_b);
        al.c(c0256a2.fmc, e.d.cp_cont_b, 1);
        al.i(view, e.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.flZ = aVar;
    }

    public boolean aXL() {
        return this.dnK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0256a {
        View ewr;
        TextView fmc;

        private C0256a() {
        }
    }

    public C0256a bk(View view) {
        C0256a c0256a = new C0256a();
        c0256a.fmc = (TextView) view.findViewById(e.g.location_search_address_name);
        c0256a.ewr = view.findViewById(e.g.location_search_line);
        return c0256a;
    }

    public View bh(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fmb = NoDataViewFactory.a(this.fma.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ec(e.j.text_try_to_chage_location), null);
        this.fmb.onChangeSkinType(this.fma.getPageContext(), skinType);
        this.fmb.setVisibility(0);
        return this.fmb;
    }
}
