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
    private boolean gNV = false;
    private com.baidu.tieba.location.data.a iQk;
    private SearchLocationActivity iQl;
    private NoDataView iQm;

    public a(SearchLocationActivity searchLocationActivity) {
        this.iQl = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iQk == null || this.iQk.coM() == null || this.iQk.coM().isEmpty()) {
            this.gNV = false;
            return 1;
        }
        this.gNV = true;
        return this.iQk.coM().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iQk == null || this.iQk.coM() == null || this.iQk.coM().isEmpty()) {
            return null;
        }
        return this.iQk.coM().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.gNV) {
            return bF(viewGroup);
        }
        C0594a c0594a = null;
        if (view != null && (view.getTag() instanceof C0594a)) {
            c0594a = (C0594a) view.getTag();
        }
        if (c0594a == null) {
            view = LayoutInflater.from(this.iQl.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0594a = cu(view);
            view.setTag(c0594a);
        }
        C0594a c0594a2 = c0594a;
        c0594a2.iQn.setText(this.iQk.coM().get(i).getName());
        am.setBackgroundColor(c0594a2.gba, R.color.cp_bg_line_c);
        am.setViewTextColor(c0594a2.iQn, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.iQk = aVar;
    }

    public boolean coQ() {
        return this.gNV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0594a {
        View gba;
        TextView iQn;

        private C0594a() {
        }
    }

    public C0594a cu(View view) {
        C0594a c0594a = new C0594a();
        c0594a.iQn = (TextView) view.findViewById(R.id.location_search_address_name);
        c0594a.gba = view.findViewById(R.id.location_search_line);
        return c0594a;
    }

    public View bF(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iQm = NoDataViewFactory.a(this.iQl.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lr(R.string.text_try_to_chage_location), null);
        this.iQm.onChangeSkinType(this.iQl.getPageContext(), skinType);
        this.iQm.setVisibility(0);
        return this.iQm;
    }
}
