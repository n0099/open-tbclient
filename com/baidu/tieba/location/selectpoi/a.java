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
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private boolean iqO = false;
    private com.baidu.tieba.location.data.a kFE;
    private SearchLocationActivity kFF;
    private NoDataView kFG;

    public a(SearchLocationActivity searchLocationActivity) {
        this.kFF = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kFE == null || this.kFE.cYz() == null || this.kFE.cYz().isEmpty()) {
            this.iqO = false;
            return 1;
        }
        this.iqO = true;
        return this.kFE.cYz().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kFE == null || this.kFE.cYz() == null || this.kFE.cYz().isEmpty()) {
            return null;
        }
        return this.kFE.cYz().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.iqO) {
            return bZ(viewGroup);
        }
        C0770a c0770a = null;
        if (view != null && (view.getTag() instanceof C0770a)) {
            c0770a = (C0770a) view.getTag();
        }
        if (c0770a == null) {
            view = LayoutInflater.from(this.kFF.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0770a = cW(view);
            view.setTag(c0770a);
        }
        C0770a c0770a2 = c0770a;
        c0770a2.kFH.setText(this.kFE.cYz().get(i).getName());
        ap.setBackgroundColor(c0770a2.hzG, R.color.cp_bg_line_c);
        ap.setViewTextColor(c0770a2.kFH, R.color.cp_cont_b, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.kFE = aVar;
    }

    public boolean cYD() {
        return this.iqO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0770a {
        View hzG;
        TextView kFH;

        private C0770a() {
        }
    }

    public C0770a cW(View view) {
        C0770a c0770a = new C0770a();
        c0770a.kFH = (TextView) view.findViewById(R.id.location_search_address_name);
        c0770a.hzG = view.findViewById(R.id.location_search_line);
        return c0770a;
    }

    public View bZ(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kFG = NoDataViewFactory.a(this.kFF.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pG(R.string.text_try_to_chage_location), null);
        this.kFG.onChangeSkinType(this.kFF.getPageContext(), skinType);
        this.kFG.setVisibility(0);
        return this.kFG;
    }
}
