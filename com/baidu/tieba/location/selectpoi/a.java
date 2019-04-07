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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private boolean eKK = false;
    private com.baidu.tieba.location.data.a gMu;
    private SearchLocationActivity gMv;
    private NoDataView gMw;

    public a(SearchLocationActivity searchLocationActivity) {
        this.gMv = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gMu == null || this.gMu.bBm() == null || this.gMu.bBm().isEmpty()) {
            this.eKK = false;
            return 1;
        }
        this.eKK = true;
        return this.gMu.bBm().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gMu == null || this.gMu.bBm() == null || this.gMu.bBm().isEmpty()) {
            return null;
        }
        return this.gMu.bBm().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.eKK) {
            return bu(viewGroup);
        }
        C0335a c0335a = null;
        if (view != null && (view.getTag() instanceof C0335a)) {
            c0335a = (C0335a) view.getTag();
        }
        if (c0335a == null) {
            view = LayoutInflater.from(this.gMv.getPageContext().getPageActivity()).inflate(d.h.location_search_item_layout, viewGroup, false);
            c0335a = cc(view);
            view.setTag(c0335a);
        }
        C0335a c0335a2 = c0335a;
        c0335a2.gMx.setText(this.gMu.bBm().get(i).getName());
        al.l(c0335a2.dXL, d.C0277d.cp_bg_line_b);
        al.d(c0335a2.gMx, d.C0277d.cp_cont_b, 1);
        al.k(view, d.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.gMu = aVar;
    }

    public boolean bBq() {
        return this.eKK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0335a {
        View dXL;
        TextView gMx;

        private C0335a() {
        }
    }

    public C0335a cc(View view) {
        C0335a c0335a = new C0335a();
        c0335a.gMx = (TextView) view.findViewById(d.g.location_search_address_name);
        c0335a.dXL = view.findViewById(d.g.location_search_line);
        return c0335a;
    }

    public View bu(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gMw = NoDataViewFactory.a(this.gMv.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hT(d.j.text_try_to_chage_location), null);
        this.gMw.onChangeSkinType(this.gMv.getPageContext(), skinType);
        this.gMw.setVisibility(0);
        return this.gMw;
    }
}
