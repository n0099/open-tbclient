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
    private boolean iwL = false;
    private com.baidu.tieba.location.data.a kLA;
    private SearchLocationActivity kLB;
    private NoDataView kLC;

    public a(SearchLocationActivity searchLocationActivity) {
        this.kLB = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kLA == null || this.kLA.dbb() == null || this.kLA.dbb().isEmpty()) {
            this.iwL = false;
            return 1;
        }
        this.iwL = true;
        return this.kLA.dbb().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kLA == null || this.kLA.dbb() == null || this.kLA.dbb().isEmpty()) {
            return null;
        }
        return this.kLA.dbb().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.iwL) {
            return cb(viewGroup);
        }
        C0785a c0785a = null;
        if (view != null && (view.getTag() instanceof C0785a)) {
            c0785a = (C0785a) view.getTag();
        }
        if (c0785a == null) {
            view = LayoutInflater.from(this.kLB.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0785a = db(view);
            view.setTag(c0785a);
        }
        C0785a c0785a2 = c0785a;
        c0785a2.kLD.setText(this.kLA.dbb().get(i).getName());
        ap.setBackgroundColor(c0785a2.hFD, R.color.cp_bg_line_c);
        ap.setViewTextColor(c0785a2.kLD, R.color.cp_cont_b, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.kLA = aVar;
    }

    public boolean dbf() {
        return this.iwL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0785a {
        View hFD;
        TextView kLD;

        private C0785a() {
        }
    }

    public C0785a db(View view) {
        C0785a c0785a = new C0785a();
        c0785a.kLD = (TextView) view.findViewById(R.id.location_search_address_name);
        c0785a.hFD = view.findViewById(R.id.location_search_line);
        return c0785a;
    }

    public View cb(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kLC = NoDataViewFactory.a(this.kLB.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pQ(R.string.text_try_to_chage_location), null);
        this.kLC.onChangeSkinType(this.kLB.getPageContext(), skinType);
        this.kLC.setVisibility(0);
        return this.kLC;
    }
}
