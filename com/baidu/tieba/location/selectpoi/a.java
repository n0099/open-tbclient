package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private boolean iUF = false;
    private com.baidu.tieba.location.data.a leN;
    private SearchLocationActivity leO;
    private NoDataView leP;

    public a(SearchLocationActivity searchLocationActivity) {
        this.leO = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.leN == null || this.leN.dfx() == null || this.leN.dfx().isEmpty()) {
            this.iUF = false;
            return 1;
        }
        this.iUF = true;
        return this.leN.dfx().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.leN == null || this.leN.dfx() == null || this.leN.dfx().isEmpty()) {
            return null;
        }
        return this.leN.dfx().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.iUF) {
            return cm(viewGroup);
        }
        C0788a c0788a = null;
        if (view != null && (view.getTag() instanceof C0788a)) {
            c0788a = (C0788a) view.getTag();
        }
        if (c0788a == null) {
            view = LayoutInflater.from(this.leO.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0788a = dw(view);
            view.setTag(c0788a);
        }
        C0788a c0788a2 = c0788a;
        c0788a2.leQ.setText(this.leN.dfx().get(i).getName());
        ao.setBackgroundColor(c0788a2.ibo, R.color.CAM_X0204);
        ao.setViewTextColor(c0788a2.leQ, R.color.CAM_X0105, 1);
        ao.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.leN = aVar;
    }

    public boolean dfB() {
        return this.iUF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0788a {
        View ibo;
        TextView leQ;

        private C0788a() {
        }
    }

    public C0788a dw(View view) {
        C0788a c0788a = new C0788a();
        c0788a.leQ = (TextView) view.findViewById(R.id.location_search_address_name);
        c0788a.ibo = view.findViewById(R.id.location_search_line);
        return c0788a;
    }

    public View cm(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.leP = NoDataViewFactory.a(this.leO.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.ra(R.string.text_try_to_chage_location), null);
        this.leP.onChangeSkinType(this.leO.getPageContext(), skinType);
        this.leP.setVisibility(0);
        return this.leP;
    }
}
