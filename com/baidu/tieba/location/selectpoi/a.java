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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private boolean cXP = false;
    private com.baidu.tieba.location.data.a eNV;
    private SearchLocationActivity eNW;
    private NoDataView eNX;

    public a(SearchLocationActivity searchLocationActivity) {
        this.eNW = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eNV == null || this.eNV.aRe() == null || this.eNV.aRe().isEmpty()) {
            this.cXP = false;
            return 1;
        }
        this.cXP = true;
        return this.eNV.aRe().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eNV == null || this.eNV.aRe() == null || this.eNV.aRe().isEmpty()) {
            return null;
        }
        return this.eNV.aRe().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.cXP) {
            return bh(viewGroup);
        }
        C0193a c0193a = null;
        if (view != null && (view.getTag() instanceof C0193a)) {
            c0193a = (C0193a) view.getTag();
        }
        if (c0193a == null) {
            view = LayoutInflater.from(this.eNW.getPageContext().getPageActivity()).inflate(d.i.location_search_item_layout, viewGroup, false);
            c0193a = aQ(view);
            view.setTag(c0193a);
        }
        C0193a c0193a2 = c0193a;
        c0193a2.eNY.setText(this.eNV.aRe().get(i).getName());
        al.j(c0193a2.dYc, d.C0141d.cp_bg_line_b);
        al.c(c0193a2.eNY, d.C0141d.cp_cont_b, 1);
        al.i(view, d.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.eNV = aVar;
    }

    public boolean aRi() {
        return this.cXP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0193a {
        View dYc;
        TextView eNY;

        private C0193a() {
        }
    }

    public C0193a aQ(View view) {
        C0193a c0193a = new C0193a();
        c0193a.eNY = (TextView) view.findViewById(d.g.location_search_address_name);
        c0193a.dYc = view.findViewById(d.g.location_search_line);
        return c0193a;
    }

    public View bh(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eNX = NoDataViewFactory.a(this.eNW.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dr(d.k.text_try_to_chage_location), null);
        this.eNX.onChangeSkinType(this.eNW.getPageContext(), skinType);
        this.eNX.setVisibility(0);
        return this.eNX;
    }
}
