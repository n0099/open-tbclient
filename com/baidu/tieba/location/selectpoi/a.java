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
    private boolean ffW = false;
    private com.baidu.tieba.location.data.a hkf;
    private SearchLocationActivity hkg;
    private NoDataView hkh;

    public a(SearchLocationActivity searchLocationActivity) {
        this.hkg = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hkf == null || this.hkf.bLH() == null || this.hkf.bLH().isEmpty()) {
            this.ffW = false;
            return 1;
        }
        this.ffW = true;
        return this.hkf.bLH().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hkf == null || this.hkf.bLH() == null || this.hkf.bLH().isEmpty()) {
            return null;
        }
        return this.hkf.bLH().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.ffW) {
            return bA(viewGroup);
        }
        C0358a c0358a = null;
        if (view != null && (view.getTag() instanceof C0358a)) {
            c0358a = (C0358a) view.getTag();
        }
        if (c0358a == null) {
            view = LayoutInflater.from(this.hkg.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0358a = cn(view);
            view.setTag(c0358a);
        }
        C0358a c0358a2 = c0358a;
        c0358a2.hki.setText(this.hkf.bLH().get(i).getName());
        am.l(c0358a2.enc, R.color.cp_bg_line_b);
        am.f(c0358a2.hki, R.color.cp_cont_b, 1);
        am.k(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.hkf = aVar;
    }

    public boolean bLL() {
        return this.ffW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0358a {
        View enc;
        TextView hki;

        private C0358a() {
        }
    }

    public C0358a cn(View view) {
        C0358a c0358a = new C0358a();
        c0358a.hki = (TextView) view.findViewById(R.id.location_search_address_name);
        c0358a.enc = view.findViewById(R.id.location_search_line);
        return c0358a;
    }

    public View bA(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hkh = NoDataViewFactory.a(this.hkg.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iN(R.string.text_try_to_chage_location), null);
        this.hkh.onChangeSkinType(this.hkg.getPageContext(), skinType);
        this.hkh.setVisibility(0);
        return this.hkh;
    }
}
