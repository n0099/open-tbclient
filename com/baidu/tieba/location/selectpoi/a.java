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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private boolean iPY = false;
    private com.baidu.tieba.location.data.a laf;
    private SearchLocationActivity lag;
    private NoDataView lah;

    public a(SearchLocationActivity searchLocationActivity) {
        this.lag = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.laf == null || this.laf.dbG() == null || this.laf.dbG().isEmpty()) {
            this.iPY = false;
            return 1;
        }
        this.iPY = true;
        return this.laf.dbG().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.laf == null || this.laf.dbG() == null || this.laf.dbG().isEmpty()) {
            return null;
        }
        return this.laf.dbG().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.iPY) {
            return cm(viewGroup);
        }
        C0784a c0784a = null;
        if (view != null && (view.getTag() instanceof C0784a)) {
            c0784a = (C0784a) view.getTag();
        }
        if (c0784a == null) {
            view = LayoutInflater.from(this.lag.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0784a = dw(view);
            view.setTag(c0784a);
        }
        C0784a c0784a2 = c0784a;
        c0784a2.lai.setText(this.laf.dbG().get(i).getName());
        ao.setBackgroundColor(c0784a2.hWH, R.color.CAM_X0204);
        ao.setViewTextColor(c0784a2.lai, R.color.CAM_X0105, 1);
        ao.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.laf = aVar;
    }

    public boolean dbK() {
        return this.iPY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0784a {
        View hWH;
        TextView lai;

        private C0784a() {
        }
    }

    public C0784a dw(View view) {
        C0784a c0784a = new C0784a();
        c0784a.lai = (TextView) view.findViewById(R.id.location_search_address_name);
        c0784a.hWH = view.findViewById(R.id.location_search_line);
        return c0784a;
    }

    public View cm(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lah = NoDataViewFactory.a(this.lag.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pu(R.string.text_try_to_chage_location), null);
        this.lah.onChangeSkinType(this.lag.getPageContext(), skinType);
        this.lah.setVisibility(0);
        return this.lah;
    }
}
