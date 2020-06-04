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
    private boolean hcY = false;
    private com.baidu.tieba.location.data.a jgc;
    private SearchLocationActivity jgd;
    private NoDataView jge;

    public a(SearchLocationActivity searchLocationActivity) {
        this.jgd = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jgc == null || this.jgc.cvv() == null || this.jgc.cvv().isEmpty()) {
            this.hcY = false;
            return 1;
        }
        this.hcY = true;
        return this.jgc.cvv().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jgc == null || this.jgc.cvv() == null || this.jgc.cvv().isEmpty()) {
            return null;
        }
        return this.jgc.cvv().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.hcY) {
            return bP(viewGroup);
        }
        C0665a c0665a = null;
        if (view != null && (view.getTag() instanceof C0665a)) {
            c0665a = (C0665a) view.getTag();
        }
        if (c0665a == null) {
            view = LayoutInflater.from(this.jgd.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0665a = cu(view);
            view.setTag(c0665a);
        }
        C0665a c0665a2 = c0665a;
        c0665a2.jgf.setText(this.jgc.cvv().get(i).getName());
        am.setBackgroundColor(c0665a2.gqk, R.color.cp_bg_line_c);
        am.setViewTextColor(c0665a2.jgf, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.jgc = aVar;
    }

    public boolean cvz() {
        return this.hcY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0665a {
        View gqk;
        TextView jgf;

        private C0665a() {
        }
    }

    public C0665a cu(View view) {
        C0665a c0665a = new C0665a();
        c0665a.jgf = (TextView) view.findViewById(R.id.location_search_address_name);
        c0665a.gqk = view.findViewById(R.id.location_search_line);
        return c0665a;
    }

    public View bP(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jge = NoDataViewFactory.a(this.jgd.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lV(R.string.text_try_to_chage_location), null);
        this.jge.onChangeSkinType(this.jgd.getPageContext(), skinType);
        this.jge.setVisibility(0);
        return this.jge;
    }
}
