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
    private boolean fgw = false;
    private com.baidu.tieba.location.data.a hkX;
    private SearchLocationActivity hkY;
    private NoDataView hkZ;

    public a(SearchLocationActivity searchLocationActivity) {
        this.hkY = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hkX == null || this.hkX.bLV() == null || this.hkX.bLV().isEmpty()) {
            this.fgw = false;
            return 1;
        }
        this.fgw = true;
        return this.hkX.bLV().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hkX == null || this.hkX.bLV() == null || this.hkX.bLV().isEmpty()) {
            return null;
        }
        return this.hkX.bLV().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.fgw) {
            return bA(viewGroup);
        }
        C0358a c0358a = null;
        if (view != null && (view.getTag() instanceof C0358a)) {
            c0358a = (C0358a) view.getTag();
        }
        if (c0358a == null) {
            view = LayoutInflater.from(this.hkY.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0358a = co(view);
            view.setTag(c0358a);
        }
        C0358a c0358a2 = c0358a;
        c0358a2.hla.setText(this.hkX.bLV().get(i).getName());
        am.l(c0358a2.enk, R.color.cp_bg_line_b);
        am.f(c0358a2.hla, R.color.cp_cont_b, 1);
        am.k(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.hkX = aVar;
    }

    public boolean bLZ() {
        return this.fgw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0358a {
        View enk;
        TextView hla;

        private C0358a() {
        }
    }

    public C0358a co(View view) {
        C0358a c0358a = new C0358a();
        c0358a.hla = (TextView) view.findViewById(R.id.location_search_address_name);
        c0358a.enk = view.findViewById(R.id.location_search_line);
        return c0358a;
    }

    public View bA(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hkZ = NoDataViewFactory.a(this.hkY.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iN(R.string.text_try_to_chage_location), null);
        this.hkZ.onChangeSkinType(this.hkY.getPageContext(), skinType);
        this.hkZ.setVisibility(0);
        return this.hkZ;
    }
}
