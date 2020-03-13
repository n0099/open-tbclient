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
    private boolean gee = false;
    private com.baidu.tieba.location.data.a ieH;
    private SearchLocationActivity ieI;
    private NoDataView ieJ;

    public a(SearchLocationActivity searchLocationActivity) {
        this.ieI = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ieH == null || this.ieH.cdM() == null || this.ieH.cdM().isEmpty()) {
            this.gee = false;
            return 1;
        }
        this.gee = true;
        return this.ieH.cdM().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ieH == null || this.ieH.cdM() == null || this.ieH.cdM().isEmpty()) {
            return null;
        }
        return this.ieH.cdM().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.gee) {
            return bC(viewGroup);
        }
        C0555a c0555a = null;
        if (view != null && (view.getTag() instanceof C0555a)) {
            c0555a = (C0555a) view.getTag();
        }
        if (c0555a == null) {
            view = LayoutInflater.from(this.ieI.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0555a = cm(view);
            view.setTag(c0555a);
        }
        C0555a c0555a2 = c0555a;
        c0555a2.ieK.setText(this.ieH.cdM().get(i).getName());
        am.setBackgroundColor(c0555a2.fvU, R.color.cp_bg_line_c);
        am.setViewTextColor(c0555a2.ieK, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.ieH = aVar;
    }

    public boolean cdQ() {
        return this.gee;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0555a {
        View fvU;
        TextView ieK;

        private C0555a() {
        }
    }

    public C0555a cm(View view) {
        C0555a c0555a = new C0555a();
        c0555a.ieK = (TextView) view.findViewById(R.id.location_search_address_name);
        c0555a.fvU = view.findViewById(R.id.location_search_line);
        return c0555a;
    }

    public View bC(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ieJ = NoDataViewFactory.a(this.ieI.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lh(R.string.text_try_to_chage_location), null);
        this.ieJ.onChangeSkinType(this.ieI.getPageContext(), skinType);
        this.ieJ.setVisibility(0);
        return this.ieJ;
    }
}
