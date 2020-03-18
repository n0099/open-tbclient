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
    private boolean geN = false;
    private com.baidu.tieba.location.data.a igh;
    private SearchLocationActivity igi;
    private NoDataView igj;

    public a(SearchLocationActivity searchLocationActivity) {
        this.igi = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.igh == null || this.igh.cef() == null || this.igh.cef().isEmpty()) {
            this.geN = false;
            return 1;
        }
        this.geN = true;
        return this.igh.cef().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.igh == null || this.igh.cef() == null || this.igh.cef().isEmpty()) {
            return null;
        }
        return this.igh.cef().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.geN) {
            return bD(viewGroup);
        }
        C0556a c0556a = null;
        if (view != null && (view.getTag() instanceof C0556a)) {
            c0556a = (C0556a) view.getTag();
        }
        if (c0556a == null) {
            view = LayoutInflater.from(this.igi.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0556a = cm(view);
            view.setTag(c0556a);
        }
        C0556a c0556a2 = c0556a;
        c0556a2.igk.setText(this.igh.cef().get(i).getName());
        am.setBackgroundColor(c0556a2.fwA, R.color.cp_bg_line_c);
        am.setViewTextColor(c0556a2.igk, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.igh = aVar;
    }

    public boolean cej() {
        return this.geN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0556a {
        View fwA;
        TextView igk;

        private C0556a() {
        }
    }

    public C0556a cm(View view) {
        C0556a c0556a = new C0556a();
        c0556a.igk = (TextView) view.findViewById(R.id.location_search_address_name);
        c0556a.fwA = view.findViewById(R.id.location_search_line);
        return c0556a;
    }

    public View bD(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.igj = NoDataViewFactory.a(this.igi.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lh(R.string.text_try_to_chage_location), null);
        this.igj.onChangeSkinType(this.igi.getPageContext(), skinType);
        this.igj.setVisibility(0);
        return this.igj;
    }
}
