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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private boolean gOb = false;
    private com.baidu.tieba.location.data.a iQo;
    private SearchLocationActivity iQp;
    private NoDataView iQq;

    public a(SearchLocationActivity searchLocationActivity) {
        this.iQp = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iQo == null || this.iQo.coJ() == null || this.iQo.coJ().isEmpty()) {
            this.gOb = false;
            return 1;
        }
        this.gOb = true;
        return this.iQo.coJ().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iQo == null || this.iQo.coJ() == null || this.iQo.coJ().isEmpty()) {
            return null;
        }
        return this.iQo.coJ().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.gOb) {
            return bF(viewGroup);
        }
        C0615a c0615a = null;
        if (view != null && (view.getTag() instanceof C0615a)) {
            c0615a = (C0615a) view.getTag();
        }
        if (c0615a == null) {
            view = LayoutInflater.from(this.iQp.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0615a = cu(view);
            view.setTag(c0615a);
        }
        C0615a c0615a2 = c0615a;
        c0615a2.iQr.setText(this.iQo.coJ().get(i).getName());
        am.setBackgroundColor(c0615a2.gbf, R.color.cp_bg_line_c);
        am.setViewTextColor(c0615a2.iQr, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.iQo = aVar;
    }

    public boolean coN() {
        return this.gOb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0615a {
        View gbf;
        TextView iQr;

        private C0615a() {
        }
    }

    public C0615a cu(View view) {
        C0615a c0615a = new C0615a();
        c0615a.iQr = (TextView) view.findViewById(R.id.location_search_address_name);
        c0615a.gbf = view.findViewById(R.id.location_search_line);
        return c0615a;
    }

    public View bF(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iQq = NoDataViewFactory.a(this.iQp.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lr(R.string.text_try_to_chage_location), null);
        this.iQq.onChangeSkinType(this.iQp.getPageContext(), skinType);
        this.iQq.setVisibility(0);
        return this.iQq;
    }
}
