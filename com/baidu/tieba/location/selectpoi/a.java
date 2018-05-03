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
    private boolean cND = false;
    private com.baidu.tieba.location.data.a eBt;
    private SearchLocationActivity eBu;
    private NoDataView eBv;

    public a(SearchLocationActivity searchLocationActivity) {
        this.eBu = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eBt == null || this.eBt.aMi() == null || this.eBt.aMi().isEmpty()) {
            this.cND = false;
            return 1;
        }
        this.cND = true;
        return this.eBt.aMi().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eBt == null || this.eBt.aMi() == null || this.eBt.aMi().isEmpty()) {
            return null;
        }
        return this.eBt.aMi().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        if (!this.cND) {
            return bg(viewGroup);
        }
        C0177a c0177a = null;
        if (view2 != null && (view2.getTag() instanceof C0177a)) {
            c0177a = (C0177a) view2.getTag();
        }
        if (c0177a == null) {
            view2 = LayoutInflater.from(this.eBu.getPageContext().getPageActivity()).inflate(d.i.location_search_item_layout, viewGroup, false);
            c0177a = aN(view2);
            view2.setTag(c0177a);
        }
        C0177a c0177a2 = c0177a;
        c0177a2.eBw.setText(this.eBt.aMi().get(i).getName());
        ak.j(c0177a2.dLK, d.C0126d.cp_bg_line_b);
        ak.c(c0177a2.eBw, d.C0126d.cp_cont_b, 1);
        ak.i(view2, d.f.home_recommend_item_bg);
        return view2;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.eBt = aVar;
    }

    public boolean aMm() {
        return this.cND;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0177a {
        View dLK;
        TextView eBw;

        private C0177a() {
        }
    }

    public C0177a aN(View view2) {
        C0177a c0177a = new C0177a();
        c0177a.eBw = (TextView) view2.findViewById(d.g.location_search_address_name);
        c0177a.dLK = view2.findViewById(d.g.location_search_line);
        return c0177a;
    }

    public View bg(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eBv = NoDataViewFactory.a(this.eBu.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.m16do(d.k.text_try_to_chage_location), null);
        this.eBv.onChangeSkinType(this.eBu.getPageContext(), skinType);
        this.eBv.setVisibility(0);
        return this.eBv;
    }
}
