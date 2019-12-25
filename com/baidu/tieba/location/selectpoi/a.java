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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private boolean fYF = false;
    private com.baidu.tieba.location.data.a hYO;
    private SearchLocationActivity hYP;
    private NoDataView hYQ;

    public a(SearchLocationActivity searchLocationActivity) {
        this.hYP = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hYO == null || this.hYO.caW() == null || this.hYO.caW().isEmpty()) {
            this.fYF = false;
            return 1;
        }
        this.fYF = true;
        return this.hYO.caW().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hYO == null || this.hYO.caW() == null || this.hYO.caW().isEmpty()) {
            return null;
        }
        return this.hYO.caW().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.fYF) {
            return by(viewGroup);
        }
        C0544a c0544a = null;
        if (view != null && (view.getTag() instanceof C0544a)) {
            c0544a = (C0544a) view.getTag();
        }
        if (c0544a == null) {
            view = LayoutInflater.from(this.hYP.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0544a = ch(view);
            view.setTag(c0544a);
        }
        C0544a c0544a2 = c0544a;
        c0544a2.hYR.setText(this.hYO.caW().get(i).getName());
        am.setBackgroundColor(c0544a2.fpV, R.color.cp_bg_line_c);
        am.setViewTextColor(c0544a2.hYR, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.hYO = aVar;
    }

    public boolean cba() {
        return this.fYF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0544a {
        View fpV;
        TextView hYR;

        private C0544a() {
        }
    }

    public C0544a ch(View view) {
        C0544a c0544a = new C0544a();
        c0544a.hYR = (TextView) view.findViewById(R.id.location_search_address_name);
        c0544a.fpV = view.findViewById(R.id.location_search_line);
        return c0544a;
    }

    public View by(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hYQ = NoDataViewFactory.a(this.hYP.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.kQ(R.string.text_try_to_chage_location), null);
        this.hYQ.onChangeSkinType(this.hYP.getPageContext(), skinType);
        this.hYQ.setVisibility(0);
        return this.hYQ;
    }
}
