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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private boolean fik = false;
    private com.baidu.tieba.location.data.a hmR;
    private SearchLocationActivity hmS;
    private NoDataView hmT;

    public a(SearchLocationActivity searchLocationActivity) {
        this.hmS = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hmR == null || this.hmR.bMI() == null || this.hmR.bMI().isEmpty()) {
            this.fik = false;
            return 1;
        }
        this.fik = true;
        return this.hmR.bMI().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hmR == null || this.hmR.bMI() == null || this.hmR.bMI().isEmpty()) {
            return null;
        }
        return this.hmR.bMI().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.fik) {
            return bA(viewGroup);
        }
        C0369a c0369a = null;
        if (view != null && (view.getTag() instanceof C0369a)) {
            c0369a = (C0369a) view.getTag();
        }
        if (c0369a == null) {
            view = LayoutInflater.from(this.hmS.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0369a = co(view);
            view.setTag(c0369a);
        }
        C0369a c0369a2 = c0369a;
        c0369a2.hmU.setText(this.hmR.bMI().get(i).getName());
        am.l(c0369a2.eoV, R.color.cp_bg_line_c);
        am.f(c0369a2.hmU, R.color.cp_cont_b, 1);
        am.k(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.hmR = aVar;
    }

    public boolean bMM() {
        return this.fik;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0369a {
        View eoV;
        TextView hmU;

        private C0369a() {
        }
    }

    public C0369a co(View view) {
        C0369a c0369a = new C0369a();
        c0369a.hmU = (TextView) view.findViewById(R.id.location_search_address_name);
        c0369a.eoV = view.findViewById(R.id.location_search_line);
        return c0369a;
    }

    public View bA(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hmT = NoDataViewFactory.a(this.hmS.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iQ(R.string.text_try_to_chage_location), null);
        this.hmT.onChangeSkinType(this.hmS.getPageContext(), skinType);
        this.hmT.setVisibility(0);
        return this.hmT;
    }
}
