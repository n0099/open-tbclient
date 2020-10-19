package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private boolean ieq = false;
    private com.baidu.tieba.location.data.a kth;
    private SearchLocationActivity kti;
    private NoDataView ktj;

    public a(SearchLocationActivity searchLocationActivity) {
        this.kti = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kth == null || this.kth.cVr() == null || this.kth.cVr().isEmpty()) {
            this.ieq = false;
            return 1;
        }
        this.ieq = true;
        return this.kth.cVr().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kth == null || this.kth.cVr() == null || this.kth.cVr().isEmpty()) {
            return null;
        }
        return this.kth.cVr().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.ieq) {
            return bY(viewGroup);
        }
        C0755a c0755a = null;
        if (view != null && (view.getTag() instanceof C0755a)) {
            c0755a = (C0755a) view.getTag();
        }
        if (c0755a == null) {
            view = LayoutInflater.from(this.kti.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0755a = cS(view);
            view.setTag(c0755a);
        }
        C0755a c0755a2 = c0755a;
        c0755a2.ktk.setText(this.kth.cVr().get(i).getName());
        ap.setBackgroundColor(c0755a2.hnL, R.color.cp_bg_line_c);
        ap.setViewTextColor(c0755a2.ktk, R.color.cp_cont_b, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.kth = aVar;
    }

    public boolean cVv() {
        return this.ieq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0755a {
        View hnL;
        TextView ktk;

        private C0755a() {
        }
    }

    public C0755a cS(View view) {
        C0755a c0755a = new C0755a();
        c0755a.ktk = (TextView) view.findViewById(R.id.location_search_address_name);
        c0755a.hnL = view.findViewById(R.id.location_search_line);
        return c0755a;
    }

    public View bY(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ktj = NoDataViewFactory.a(this.kti.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pv(R.string.text_try_to_chage_location), null);
        this.ktj.onChangeSkinType(this.kti.getPageContext(), skinType);
        this.ktj.setVisibility(0);
        return this.ktj;
    }
}
