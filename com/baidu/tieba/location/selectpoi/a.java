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
    private boolean gdR = false;
    private com.baidu.tieba.location.data.a iev;
    private SearchLocationActivity iew;
    private NoDataView iex;

    public a(SearchLocationActivity searchLocationActivity) {
        this.iew = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iev == null || this.iev.cdL() == null || this.iev.cdL().isEmpty()) {
            this.gdR = false;
            return 1;
        }
        this.gdR = true;
        return this.iev.cdL().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iev == null || this.iev.cdL() == null || this.iev.cdL().isEmpty()) {
            return null;
        }
        return this.iev.cdL().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.gdR) {
            return bC(viewGroup);
        }
        C0555a c0555a = null;
        if (view != null && (view.getTag() instanceof C0555a)) {
            c0555a = (C0555a) view.getTag();
        }
        if (c0555a == null) {
            view = LayoutInflater.from(this.iew.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0555a = cm(view);
            view.setTag(c0555a);
        }
        C0555a c0555a2 = c0555a;
        c0555a2.iey.setText(this.iev.cdL().get(i).getName());
        am.setBackgroundColor(c0555a2.fvH, R.color.cp_bg_line_c);
        am.setViewTextColor(c0555a2.iey, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.iev = aVar;
    }

    public boolean cdP() {
        return this.gdR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0555a {
        View fvH;
        TextView iey;

        private C0555a() {
        }
    }

    public C0555a cm(View view) {
        C0555a c0555a = new C0555a();
        c0555a.iey = (TextView) view.findViewById(R.id.location_search_address_name);
        c0555a.fvH = view.findViewById(R.id.location_search_line);
        return c0555a;
    }

    public View bC(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iex = NoDataViewFactory.a(this.iew.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lh(R.string.text_try_to_chage_location), null);
        this.iex.onChangeSkinType(this.iew.getPageContext(), skinType);
        this.iex.setVisibility(0);
        return this.iex;
    }
}
