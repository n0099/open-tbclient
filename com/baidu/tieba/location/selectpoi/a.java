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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private boolean cYD = false;
    private com.baidu.tieba.location.data.a eVC;
    private SearchLocationActivity eVD;
    private NoDataView eVE;

    public a(SearchLocationActivity searchLocationActivity) {
        this.eVD = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVC == null || this.eVC.aSJ() == null || this.eVC.aSJ().isEmpty()) {
            this.cYD = false;
            return 1;
        }
        this.cYD = true;
        return this.eVC.aSJ().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVC == null || this.eVC.aSJ() == null || this.eVC.aSJ().isEmpty()) {
            return null;
        }
        return this.eVC.aSJ().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.cYD) {
            return bg(viewGroup);
        }
        C0194a c0194a = null;
        if (view != null && (view.getTag() instanceof C0194a)) {
            c0194a = (C0194a) view.getTag();
        }
        if (c0194a == null) {
            view = LayoutInflater.from(this.eVD.getPageContext().getPageActivity()).inflate(f.h.location_search_item_layout, viewGroup, false);
            c0194a = aU(view);
            view.setTag(c0194a);
        }
        C0194a c0194a2 = c0194a;
        c0194a2.eVF.setText(this.eVC.aSJ().get(i).getName());
        am.j(c0194a2.efJ, f.d.cp_bg_line_b);
        am.c(c0194a2.eVF, f.d.cp_cont_b, 1);
        am.i(view, f.C0146f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.eVC = aVar;
    }

    public boolean aSN() {
        return this.cYD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0194a {
        TextView eVF;
        View efJ;

        private C0194a() {
        }
    }

    public C0194a aU(View view) {
        C0194a c0194a = new C0194a();
        c0194a.eVF = (TextView) view.findViewById(f.g.location_search_address_name);
        c0194a.efJ = view.findViewById(f.g.location_search_line);
        return c0194a;
    }

    public View bg(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eVE = NoDataViewFactory.a(this.eVD.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dt(f.j.text_try_to_chage_location), null);
        this.eVE.onChangeSkinType(this.eVD.getPageContext(), skinType);
        this.eVE.setVisibility(0);
        return this.eVE;
    }
}
