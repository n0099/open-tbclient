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
    private boolean gdP = false;
    private com.baidu.tieba.location.data.a iet;
    private SearchLocationActivity ieu;
    private NoDataView iev;

    public a(SearchLocationActivity searchLocationActivity) {
        this.ieu = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iet == null || this.iet.cdJ() == null || this.iet.cdJ().isEmpty()) {
            this.gdP = false;
            return 1;
        }
        this.gdP = true;
        return this.iet.cdJ().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iet == null || this.iet.cdJ() == null || this.iet.cdJ().isEmpty()) {
            return null;
        }
        return this.iet.cdJ().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.gdP) {
            return bC(viewGroup);
        }
        C0555a c0555a = null;
        if (view != null && (view.getTag() instanceof C0555a)) {
            c0555a = (C0555a) view.getTag();
        }
        if (c0555a == null) {
            view = LayoutInflater.from(this.ieu.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0555a = cm(view);
            view.setTag(c0555a);
        }
        C0555a c0555a2 = c0555a;
        c0555a2.iew.setText(this.iet.cdJ().get(i).getName());
        am.setBackgroundColor(c0555a2.fvG, R.color.cp_bg_line_c);
        am.setViewTextColor(c0555a2.iew, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.iet = aVar;
    }

    public boolean cdN() {
        return this.gdP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0555a {
        View fvG;
        TextView iew;

        private C0555a() {
        }
    }

    public C0555a cm(View view) {
        C0555a c0555a = new C0555a();
        c0555a.iew = (TextView) view.findViewById(R.id.location_search_address_name);
        c0555a.fvG = view.findViewById(R.id.location_search_line);
        return c0555a;
    }

    public View bC(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iev = NoDataViewFactory.a(this.ieu.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lh(R.string.text_try_to_chage_location), null);
        this.iev.onChangeSkinType(this.ieu.getPageContext(), skinType);
        this.iev.setVisibility(0);
        return this.iev;
    }
}
