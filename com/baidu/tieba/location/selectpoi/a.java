package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private boolean hIq = false;
    private com.baidu.tieba.location.data.a jVr;
    private SearchLocationActivity jVs;
    private NoDataView jVt;

    public a(SearchLocationActivity searchLocationActivity) {
        this.jVs = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jVr == null || this.jVr.cOc() == null || this.jVr.cOc().isEmpty()) {
            this.hIq = false;
            return 1;
        }
        this.hIq = true;
        return this.jVr.cOc().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jVr == null || this.jVr.cOc() == null || this.jVr.cOc().isEmpty()) {
            return null;
        }
        return this.jVr.cOc().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.hIq) {
            return bV(viewGroup);
        }
        C0740a c0740a = null;
        if (view != null && (view.getTag() instanceof C0740a)) {
            c0740a = (C0740a) view.getTag();
        }
        if (c0740a == null) {
            view = LayoutInflater.from(this.jVs.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0740a = cF(view);
            view.setTag(c0740a);
        }
        C0740a c0740a2 = c0740a;
        c0740a2.jVu.setText(this.jVr.cOc().get(i).getName());
        ap.setBackgroundColor(c0740a2.gVd, R.color.cp_bg_line_c);
        ap.setViewTextColor(c0740a2.jVu, R.color.cp_cont_b, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.jVr = aVar;
    }

    public boolean cOg() {
        return this.hIq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C0740a {
        View gVd;
        TextView jVu;

        private C0740a() {
        }
    }

    public C0740a cF(View view) {
        C0740a c0740a = new C0740a();
        c0740a.jVu = (TextView) view.findViewById(R.id.location_search_address_name);
        c0740a.gVd = view.findViewById(R.id.location_search_line);
        return c0740a;
    }

    public View bV(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jVt = NoDataViewFactory.a(this.jVs.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oK(R.string.text_try_to_chage_location), null);
        this.jVt.onChangeSkinType(this.jVs.getPageContext(), skinType);
        this.jVt.setVisibility(0);
        return this.jVt;
    }
}
