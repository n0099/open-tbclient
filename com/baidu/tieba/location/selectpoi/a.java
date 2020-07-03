package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private boolean hpj = false;
    private com.baidu.tieba.location.data.a jxo;
    private SearchLocationActivity jxp;
    private NoDataView jxq;

    public a(SearchLocationActivity searchLocationActivity) {
        this.jxp = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jxo == null || this.jxo.czm() == null || this.jxo.czm().isEmpty()) {
            this.hpj = false;
            return 1;
        }
        this.hpj = true;
        return this.jxo.czm().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jxo == null || this.jxo.czm() == null || this.jxo.czm().isEmpty()) {
            return null;
        }
        return this.jxo.czm().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.hpj) {
            return bY(viewGroup);
        }
        C0678a c0678a = null;
        if (view != null && (view.getTag() instanceof C0678a)) {
            c0678a = (C0678a) view.getTag();
        }
        if (c0678a == null) {
            view = LayoutInflater.from(this.jxp.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0678a = cv(view);
            view.setTag(c0678a);
        }
        C0678a c0678a2 = c0678a;
        c0678a2.jxr.setText(this.jxo.czm().get(i).getName());
        an.setBackgroundColor(c0678a2.gCZ, R.color.cp_bg_line_c);
        an.setViewTextColor(c0678a2.jxr, R.color.cp_cont_b, 1);
        an.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.jxo = aVar;
    }

    public boolean czq() {
        return this.hpj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0678a {
        View gCZ;
        TextView jxr;

        private C0678a() {
        }
    }

    public C0678a cv(View view) {
        C0678a c0678a = new C0678a();
        c0678a.jxr = (TextView) view.findViewById(R.id.location_search_address_name);
        c0678a.gCZ = view.findViewById(R.id.location_search_line);
        return c0678a;
    }

    public View bY(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jxq = NoDataViewFactory.a(this.jxp.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.mm(R.string.text_try_to_chage_location), null);
        this.jxq.onChangeSkinType(this.jxp.getPageContext(), skinType);
        this.jxq.setVisibility(0);
        return this.jxq;
    }
}
