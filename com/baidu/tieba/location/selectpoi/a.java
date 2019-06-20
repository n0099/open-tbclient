package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private boolean faV = false;
    private com.baidu.tieba.location.data.a hdS;
    private SearchLocationActivity hdT;
    private NoDataView hdU;

    public a(SearchLocationActivity searchLocationActivity) {
        this.hdT = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hdS == null || this.hdS.bJa() == null || this.hdS.bJa().isEmpty()) {
            this.faV = false;
            return 1;
        }
        this.faV = true;
        return this.hdS.bJa().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hdS == null || this.hdS.bJa() == null || this.hdS.bJa().isEmpty()) {
            return null;
        }
        return this.hdS.bJa().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.faV) {
            return bu(viewGroup);
        }
        C0353a c0353a = null;
        if (view != null && (view.getTag() instanceof C0353a)) {
            c0353a = (C0353a) view.getTag();
        }
        if (c0353a == null) {
            view = LayoutInflater.from(this.hdT.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0353a = ck(view);
            view.setTag(c0353a);
        }
        C0353a c0353a2 = c0353a;
        c0353a2.hdV.setText(this.hdS.bJa().get(i).getName());
        al.l(c0353a2.eim, R.color.cp_bg_line_b);
        al.f(c0353a2.hdV, R.color.cp_cont_b, 1);
        al.k(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.hdS = aVar;
    }

    public boolean bJe() {
        return this.faV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0353a {
        View eim;
        TextView hdV;

        private C0353a() {
        }
    }

    public C0353a ck(View view) {
        C0353a c0353a = new C0353a();
        c0353a.hdV = (TextView) view.findViewById(R.id.location_search_address_name);
        c0353a.eim = view.findViewById(R.id.location_search_line);
        return c0353a;
    }

    public View bu(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hdU = NoDataViewFactory.a(this.hdT.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iH(R.string.text_try_to_chage_location), null);
        this.hdU.onChangeSkinType(this.hdT.getPageContext(), skinType);
        this.hdU.setVisibility(0);
        return this.hdU;
    }
}
