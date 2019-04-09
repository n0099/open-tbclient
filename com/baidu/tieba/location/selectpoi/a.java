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
    private boolean eKL = false;
    private com.baidu.tieba.location.data.a gMv;
    private SearchLocationActivity gMw;
    private NoDataView gMx;

    public a(SearchLocationActivity searchLocationActivity) {
        this.gMw = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gMv == null || this.gMv.bBm() == null || this.gMv.bBm().isEmpty()) {
            this.eKL = false;
            return 1;
        }
        this.eKL = true;
        return this.gMv.bBm().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gMv == null || this.gMv.bBm() == null || this.gMv.bBm().isEmpty()) {
            return null;
        }
        return this.gMv.bBm().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.eKL) {
            return bu(viewGroup);
        }
        C0335a c0335a = null;
        if (view != null && (view.getTag() instanceof C0335a)) {
            c0335a = (C0335a) view.getTag();
        }
        if (c0335a == null) {
            view = LayoutInflater.from(this.gMw.getPageContext().getPageActivity()).inflate(d.h.location_search_item_layout, viewGroup, false);
            c0335a = cc(view);
            view.setTag(c0335a);
        }
        C0335a c0335a2 = c0335a;
        c0335a2.gMy.setText(this.gMv.bBm().get(i).getName());
        al.l(c0335a2.dXM, d.C0277d.cp_bg_line_b);
        al.d(c0335a2.gMy, d.C0277d.cp_cont_b, 1);
        al.k(view, d.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.gMv = aVar;
    }

    public boolean bBq() {
        return this.eKL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0335a {
        View dXM;
        TextView gMy;

        private C0335a() {
        }
    }

    public C0335a cc(View view) {
        C0335a c0335a = new C0335a();
        c0335a.gMy = (TextView) view.findViewById(d.g.location_search_address_name);
        c0335a.dXM = view.findViewById(d.g.location_search_line);
        return c0335a;
    }

    public View bu(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gMx = NoDataViewFactory.a(this.gMw.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hT(d.j.text_try_to_chage_location), null);
        this.gMx.onChangeSkinType(this.gMw.getPageContext(), skinType);
        this.gMx.setVisibility(0);
        return this.gMx;
    }
}
