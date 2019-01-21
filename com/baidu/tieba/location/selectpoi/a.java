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
    private boolean cPs = false;
    private com.baidu.tieba.location.data.a fwE;
    private SearchLocationActivity fwF;
    private NoDataView fwG;

    public a(SearchLocationActivity searchLocationActivity) {
        this.fwF = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fwE == null || this.fwE.baM() == null || this.fwE.baM().isEmpty()) {
            this.cPs = false;
            return 1;
        }
        this.cPs = true;
        return this.fwE.baM().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fwE == null || this.fwE.baM() == null || this.fwE.baM().isEmpty()) {
            return null;
        }
        return this.fwE.baM().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.cPs) {
            return bi(viewGroup);
        }
        C0267a c0267a = null;
        if (view != null && (view.getTag() instanceof C0267a)) {
            c0267a = (C0267a) view.getTag();
        }
        if (c0267a == null) {
            view = LayoutInflater.from(this.fwF.getPageContext().getPageActivity()).inflate(e.h.location_search_item_layout, viewGroup, false);
            c0267a = bn(view);
            view.setTag(c0267a);
        }
        C0267a c0267a2 = c0267a;
        c0267a2.fwH.setText(this.fwE.baM().get(i).getName());
        al.j(c0267a2.cKP, e.d.cp_bg_line_b);
        al.c(c0267a2.fwH, e.d.cp_cont_b, 1);
        al.i(view, e.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.fwE = aVar;
    }

    public boolean baQ() {
        return this.cPs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0267a {
        View cKP;
        TextView fwH;

        private C0267a() {
        }
    }

    public C0267a bn(View view) {
        C0267a c0267a = new C0267a();
        c0267a.fwH = (TextView) view.findViewById(e.g.location_search_address_name);
        c0267a.cKP = view.findViewById(e.g.location_search_line);
        return c0267a;
    }

    public View bi(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fwG = NoDataViewFactory.a(this.fwF.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eq(e.j.text_try_to_chage_location), null);
        this.fwG.onChangeSkinType(this.fwF.getPageContext(), skinType);
        this.fwG.setVisibility(0);
        return this.fwG;
    }
}
