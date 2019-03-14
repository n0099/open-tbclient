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
    private boolean eKY = false;
    private com.baidu.tieba.location.data.a gMH;
    private SearchLocationActivity gMI;
    private NoDataView gMJ;

    public a(SearchLocationActivity searchLocationActivity) {
        this.gMI = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gMH == null || this.gMH.bBp() == null || this.gMH.bBp().isEmpty()) {
            this.eKY = false;
            return 1;
        }
        this.eKY = true;
        return this.gMH.bBp().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gMH == null || this.gMH.bBp() == null || this.gMH.bBp().isEmpty()) {
            return null;
        }
        return this.gMH.bBp().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.eKY) {
            return bu(viewGroup);
        }
        C0335a c0335a = null;
        if (view != null && (view.getTag() instanceof C0335a)) {
            c0335a = (C0335a) view.getTag();
        }
        if (c0335a == null) {
            view = LayoutInflater.from(this.gMI.getPageContext().getPageActivity()).inflate(d.h.location_search_item_layout, viewGroup, false);
            c0335a = cc(view);
            view.setTag(c0335a);
        }
        C0335a c0335a2 = c0335a;
        c0335a2.gMK.setText(this.gMH.bBp().get(i).getName());
        al.l(c0335a2.dYo, d.C0277d.cp_bg_line_b);
        al.d(c0335a2.gMK, d.C0277d.cp_cont_b, 1);
        al.k(view, d.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.gMH = aVar;
    }

    public boolean bBt() {
        return this.eKY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0335a {
        View dYo;
        TextView gMK;

        private C0335a() {
        }
    }

    public C0335a cc(View view) {
        C0335a c0335a = new C0335a();
        c0335a.gMK = (TextView) view.findViewById(d.g.location_search_address_name);
        c0335a.dYo = view.findViewById(d.g.location_search_line);
        return c0335a;
    }

    public View bu(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gMJ = NoDataViewFactory.a(this.gMI.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.hU(d.j.text_try_to_chage_location), null);
        this.gMJ.onChangeSkinType(this.gMI.getPageContext(), skinType);
        this.gMJ.setVisibility(0);
        return this.gMJ;
    }
}
