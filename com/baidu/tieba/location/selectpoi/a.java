package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private boolean duP = false;
    private com.baidu.tieba.location.data.a fgD;
    private SearchLocationActivity fgE;
    private h fgF;

    public a(SearchLocationActivity searchLocationActivity) {
        this.fgE = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fgD == null || this.fgD.aRl() == null || this.fgD.aRl().isEmpty()) {
            this.duP = false;
            return 1;
        }
        this.duP = true;
        return this.fgD.aRl().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fgD == null || this.fgD.aRl() == null || this.fgD.aRl().isEmpty()) {
            return null;
        }
        return this.fgD.aRl().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.duP) {
            return bi(viewGroup);
        }
        C0194a c0194a = null;
        if (view != null && (view.getTag() instanceof C0194a)) {
            c0194a = (C0194a) view.getTag();
        }
        if (c0194a == null) {
            view = LayoutInflater.from(this.fgE.getPageContext().getPageActivity()).inflate(d.h.location_search_item_layout, viewGroup, false);
            c0194a = ch(view);
            view.setTag(c0194a);
        }
        C0194a c0194a2 = c0194a;
        c0194a2.fgG.setText(this.fgD.aRl().get(i).getName());
        aj.t(c0194a2.eqL, d.C0141d.cp_bg_line_b);
        aj.e(c0194a2.fgG, d.C0141d.cp_cont_b, 1);
        aj.s(view, d.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.fgD = aVar;
    }

    public boolean aRp() {
        return this.duP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0194a {
        View eqL;
        TextView fgG;

        private C0194a() {
        }
    }

    public C0194a ch(View view) {
        C0194a c0194a = new C0194a();
        c0194a.fgG = (TextView) view.findViewById(d.g.location_search_address_name);
        c0194a.eqL = view.findViewById(d.g.location_search_line);
        return c0194a;
    }

    public View bi(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fgF = NoDataViewFactory.a(this.fgE.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gp(d.j.text_try_to_chage_location), null);
        this.fgF.onChangeSkinType(this.fgE.getPageContext(), skinType);
        this.fgF.setVisibility(0);
        return this.fgF;
    }
}
