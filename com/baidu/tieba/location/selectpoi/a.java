package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private boolean cOK = false;
    private com.baidu.tieba.location.data.a eCB;
    private SearchLocationActivity eCC;
    private NoDataView eCD;

    public a(SearchLocationActivity searchLocationActivity) {
        this.eCC = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eCB == null || this.eCB.aMh() == null || this.eCB.aMh().isEmpty()) {
            this.cOK = false;
            return 1;
        }
        this.cOK = true;
        return this.eCB.aMh().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eCB == null || this.eCB.aMh() == null || this.eCB.aMh().isEmpty()) {
            return null;
        }
        return this.eCB.aMh().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        if (!this.cOK) {
            return bg(viewGroup);
        }
        C0177a c0177a = null;
        if (view2 != null && (view2.getTag() instanceof C0177a)) {
            c0177a = (C0177a) view2.getTag();
        }
        if (c0177a == null) {
            view2 = LayoutInflater.from(this.eCC.getPageContext().getPageActivity()).inflate(d.i.location_search_item_layout, viewGroup, false);
            c0177a = aN(view2);
            view2.setTag(c0177a);
        }
        C0177a c0177a2 = c0177a;
        c0177a2.eCE.setText(this.eCB.aMh().get(i).getName());
        ak.j(c0177a2.dMQ, d.C0126d.cp_bg_line_b);
        ak.c(c0177a2.eCE, d.C0126d.cp_cont_b, 1);
        ak.i(view2, d.f.home_recommend_item_bg);
        return view2;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.eCB = aVar;
    }

    public boolean aMl() {
        return this.cOK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0177a {
        View dMQ;
        TextView eCE;

        private C0177a() {
        }
    }

    public C0177a aN(View view2) {
        C0177a c0177a = new C0177a();
        c0177a.eCE = (TextView) view2.findViewById(d.g.location_search_address_name);
        c0177a.dMQ = view2.findViewById(d.g.location_search_line);
        return c0177a;
    }

    public View bg(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eCD = NoDataViewFactory.a(this.eCC.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dp(d.k.text_try_to_chage_location), null);
        this.eCD.onChangeSkinType(this.eCC.getPageContext(), skinType);
        this.eCD.setVisibility(0);
        return this.eCD;
    }
}
