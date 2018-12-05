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
    private boolean dul = false;
    private com.baidu.tieba.location.data.a fsR;
    private SearchLocationActivity fsS;
    private NoDataView fsT;

    public a(SearchLocationActivity searchLocationActivity) {
        this.fsS = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fsR == null || this.fsR.aZz() == null || this.fsR.aZz().isEmpty()) {
            this.dul = false;
            return 1;
        }
        this.dul = true;
        return this.fsR.aZz().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fsR == null || this.fsR.aZz() == null || this.fsR.aZz().isEmpty()) {
            return null;
        }
        return this.fsR.aZz().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.dul) {
            return bh(viewGroup);
        }
        C0267a c0267a = null;
        if (view != null && (view.getTag() instanceof C0267a)) {
            c0267a = (C0267a) view.getTag();
        }
        if (c0267a == null) {
            view = LayoutInflater.from(this.fsS.getPageContext().getPageActivity()).inflate(e.h.location_search_item_layout, viewGroup, false);
            c0267a = bk(view);
            view.setTag(c0267a);
        }
        C0267a c0267a2 = c0267a;
        c0267a2.fsU.setText(this.fsR.aZz().get(i).getName());
        al.j(c0267a2.cJd, e.d.cp_bg_line_b);
        al.c(c0267a2.fsU, e.d.cp_cont_b, 1);
        al.i(view, e.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.fsR = aVar;
    }

    public boolean aZD() {
        return this.dul;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0267a {
        View cJd;
        TextView fsU;

        private C0267a() {
        }
    }

    public C0267a bk(View view) {
        C0267a c0267a = new C0267a();
        c0267a.fsU = (TextView) view.findViewById(e.g.location_search_address_name);
        c0267a.cJd = view.findViewById(e.g.location_search_line);
        return c0267a;
    }

    public View bh(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fsT = NoDataViewFactory.a(this.fsS.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eq(e.j.text_try_to_chage_location), null);
        this.fsT.onChangeSkinType(this.fsS.getPageContext(), skinType);
        this.fsT.setVisibility(0);
        return this.fsT;
    }
}
