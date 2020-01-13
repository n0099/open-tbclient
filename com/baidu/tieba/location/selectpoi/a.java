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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private boolean gbO = false;
    private com.baidu.tieba.location.data.a ics;
    private SearchLocationActivity ict;
    private NoDataView icu;

    public a(SearchLocationActivity searchLocationActivity) {
        this.ict = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ics == null || this.ics.ccf() == null || this.ics.ccf().isEmpty()) {
            this.gbO = false;
            return 1;
        }
        this.gbO = true;
        return this.ics.ccf().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ics == null || this.ics.ccf() == null || this.ics.ccf().isEmpty()) {
            return null;
        }
        return this.ics.ccf().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.gbO) {
            return bC(viewGroup);
        }
        C0549a c0549a = null;
        if (view != null && (view.getTag() instanceof C0549a)) {
            c0549a = (C0549a) view.getTag();
        }
        if (c0549a == null) {
            view = LayoutInflater.from(this.ict.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0549a = cm(view);
            view.setTag(c0549a);
        }
        C0549a c0549a2 = c0549a;
        c0549a2.icv.setText(this.ics.ccf().get(i).getName());
        am.setBackgroundColor(c0549a2.fte, R.color.cp_bg_line_c);
        am.setViewTextColor(c0549a2.icv, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.ics = aVar;
    }

    public boolean ccj() {
        return this.gbO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0549a {
        View fte;
        TextView icv;

        private C0549a() {
        }
    }

    public C0549a cm(View view) {
        C0549a c0549a = new C0549a();
        c0549a.icv = (TextView) view.findViewById(R.id.location_search_address_name);
        c0549a.fte = view.findViewById(R.id.location_search_line);
        return c0549a;
    }

    public View bC(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.icu = NoDataViewFactory.a(this.ict.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.kQ(R.string.text_try_to_chage_location), null);
        this.icu.onChangeSkinType(this.ict.getPageContext(), skinType);
        this.icu.setVisibility(0);
        return this.icu;
    }
}
