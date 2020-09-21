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
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private boolean hPr = false;
    private com.baidu.tieba.location.data.a kdT;
    private SearchLocationActivity kdU;
    private NoDataView kdV;

    public a(SearchLocationActivity searchLocationActivity) {
        this.kdU = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kdT == null || this.kdT.cRH() == null || this.kdT.cRH().isEmpty()) {
            this.hPr = false;
            return 1;
        }
        this.hPr = true;
        return this.kdT.cRH().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kdT == null || this.kdT.cRH() == null || this.kdT.cRH().isEmpty()) {
            return null;
        }
        return this.kdT.cRH().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.hPr) {
            return bW(viewGroup);
        }
        C0737a c0737a = null;
        if (view != null && (view.getTag() instanceof C0737a)) {
            c0737a = (C0737a) view.getTag();
        }
        if (c0737a == null) {
            view = LayoutInflater.from(this.kdU.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0737a = cO(view);
            view.setTag(c0737a);
        }
        C0737a c0737a2 = c0737a;
        c0737a2.kdW.setText(this.kdT.cRH().get(i).getName());
        ap.setBackgroundColor(c0737a2.gYK, R.color.cp_bg_line_c);
        ap.setViewTextColor(c0737a2.kdW, R.color.cp_cont_b, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.kdT = aVar;
    }

    public boolean cRL() {
        return this.hPr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0737a {
        View gYK;
        TextView kdW;

        private C0737a() {
        }
    }

    public C0737a cO(View view) {
        C0737a c0737a = new C0737a();
        c0737a.kdW = (TextView) view.findViewById(R.id.location_search_address_name);
        c0737a.gYK = view.findViewById(R.id.location_search_line);
        return c0737a;
    }

    public View bW(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kdV = NoDataViewFactory.a(this.kdU.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oW(R.string.text_try_to_chage_location), null);
        this.kdV.onChangeSkinType(this.kdU.getPageContext(), skinType);
        this.kdV.setVisibility(0);
        return this.kdV;
    }
}
