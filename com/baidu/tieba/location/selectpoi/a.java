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
    private boolean hcN = false;
    private com.baidu.tieba.location.data.a jfp;
    private SearchLocationActivity jfq;
    private NoDataView jfr;

    public a(SearchLocationActivity searchLocationActivity) {
        this.jfq = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jfp == null || this.jfp.cvm() == null || this.jfp.cvm().isEmpty()) {
            this.hcN = false;
            return 1;
        }
        this.hcN = true;
        return this.jfp.cvm().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jfp == null || this.jfp.cvm() == null || this.jfp.cvm().isEmpty()) {
            return null;
        }
        return this.jfp.cvm().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.hcN) {
            return bP(viewGroup);
        }
        C0665a c0665a = null;
        if (view != null && (view.getTag() instanceof C0665a)) {
            c0665a = (C0665a) view.getTag();
        }
        if (c0665a == null) {
            view = LayoutInflater.from(this.jfq.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0665a = cu(view);
            view.setTag(c0665a);
        }
        C0665a c0665a2 = c0665a;
        c0665a2.jfs.setText(this.jfp.cvm().get(i).getName());
        am.setBackgroundColor(c0665a2.gpZ, R.color.cp_bg_line_c);
        am.setViewTextColor(c0665a2.jfs, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.jfp = aVar;
    }

    public boolean cvq() {
        return this.hcN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0665a {
        View gpZ;
        TextView jfs;

        private C0665a() {
        }
    }

    public C0665a cu(View view) {
        C0665a c0665a = new C0665a();
        c0665a.jfs = (TextView) view.findViewById(R.id.location_search_address_name);
        c0665a.gpZ = view.findViewById(R.id.location_search_line);
        return c0665a;
    }

    public View bP(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jfr = NoDataViewFactory.a(this.jfq.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lT(R.string.text_try_to_chage_location), null);
        this.jfr.onChangeSkinType(this.jfq.getPageContext(), skinType);
        this.jfr.setVisibility(0);
        return this.jfr;
    }
}
