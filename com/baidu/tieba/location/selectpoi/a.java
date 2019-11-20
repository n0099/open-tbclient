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
    private boolean fkg = false;
    private com.baidu.tieba.location.data.a hkN;
    private SearchLocationActivity hkO;
    private NoDataView hkP;

    public a(SearchLocationActivity searchLocationActivity) {
        this.hkO = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hkN == null || this.hkN.bJJ() == null || this.hkN.bJJ().isEmpty()) {
            this.fkg = false;
            return 1;
        }
        this.fkg = true;
        return this.hkN.bJJ().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hkN == null || this.hkN.bJJ() == null || this.hkN.bJJ().isEmpty()) {
            return null;
        }
        return this.hkN.bJJ().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.fkg) {
            return bC(viewGroup);
        }
        C0463a c0463a = null;
        if (view != null && (view.getTag() instanceof C0463a)) {
            c0463a = (C0463a) view.getTag();
        }
        if (c0463a == null) {
            view = LayoutInflater.from(this.hkO.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0463a = cl(view);
            view.setTag(c0463a);
        }
        C0463a c0463a2 = c0463a;
        c0463a2.hkQ.setText(this.hkN.bJJ().get(i).getName());
        am.setBackgroundColor(c0463a2.eyu, R.color.cp_bg_line_c);
        am.setViewTextColor(c0463a2.hkQ, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.hkN = aVar;
    }

    public boolean bJN() {
        return this.fkg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0463a {
        View eyu;
        TextView hkQ;

        private C0463a() {
        }
    }

    public C0463a cl(View view) {
        C0463a c0463a = new C0463a();
        c0463a.hkQ = (TextView) view.findViewById(R.id.location_search_address_name);
        c0463a.eyu = view.findViewById(R.id.location_search_line);
        return c0463a;
    }

    public View bC(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hkP = NoDataViewFactory.a(this.hkO.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iK(R.string.text_try_to_chage_location), null);
        this.hkP.onChangeSkinType(this.hkO.getPageContext(), skinType);
        this.hkP.setVisibility(0);
        return this.hkP;
    }
}
