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
    private boolean cOG = false;
    private com.baidu.tieba.location.data.a fvJ;
    private SearchLocationActivity fvK;
    private NoDataView fvL;

    public a(SearchLocationActivity searchLocationActivity) {
        this.fvK = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fvJ == null || this.fvJ.bam() == null || this.fvJ.bam().isEmpty()) {
            this.cOG = false;
            return 1;
        }
        this.cOG = true;
        return this.fvJ.bam().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fvJ == null || this.fvJ.bam() == null || this.fvJ.bam().isEmpty()) {
            return null;
        }
        return this.fvJ.bam().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.cOG) {
            return bi(viewGroup);
        }
        C0267a c0267a = null;
        if (view != null && (view.getTag() instanceof C0267a)) {
            c0267a = (C0267a) view.getTag();
        }
        if (c0267a == null) {
            view = LayoutInflater.from(this.fvK.getPageContext().getPageActivity()).inflate(e.h.location_search_item_layout, viewGroup, false);
            c0267a = bn(view);
            view.setTag(c0267a);
        }
        C0267a c0267a2 = c0267a;
        c0267a2.fvM.setText(this.fvJ.bam().get(i).getName());
        al.j(c0267a2.cKd, e.d.cp_bg_line_b);
        al.c(c0267a2.fvM, e.d.cp_cont_b, 1);
        al.i(view, e.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.fvJ = aVar;
    }

    public boolean baq() {
        return this.cOG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0267a {
        View cKd;
        TextView fvM;

        private C0267a() {
        }
    }

    public C0267a bn(View view) {
        C0267a c0267a = new C0267a();
        c0267a.fvM = (TextView) view.findViewById(e.g.location_search_address_name);
        c0267a.cKd = view.findViewById(e.g.location_search_line);
        return c0267a;
    }

    public View bi(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fvL = NoDataViewFactory.a(this.fvK.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eq(e.j.text_try_to_chage_location), null);
        this.fvL.onChangeSkinType(this.fvK.getPageContext(), skinType);
        this.fvL.setVisibility(0);
        return this.fvL;
    }
}
