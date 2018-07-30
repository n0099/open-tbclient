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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private boolean cYH = false;
    private com.baidu.tieba.location.data.a eVH;
    private SearchLocationActivity eVI;
    private NoDataView eVJ;

    public a(SearchLocationActivity searchLocationActivity) {
        this.eVI = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVH == null || this.eVH.aSM() == null || this.eVH.aSM().isEmpty()) {
            this.cYH = false;
            return 1;
        }
        this.cYH = true;
        return this.eVH.aSM().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVH == null || this.eVH.aSM() == null || this.eVH.aSM().isEmpty()) {
            return null;
        }
        return this.eVH.aSM().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.cYH) {
            return bg(viewGroup);
        }
        C0194a c0194a = null;
        if (view != null && (view.getTag() instanceof C0194a)) {
            c0194a = (C0194a) view.getTag();
        }
        if (c0194a == null) {
            view = LayoutInflater.from(this.eVI.getPageContext().getPageActivity()).inflate(d.h.location_search_item_layout, viewGroup, false);
            c0194a = aU(view);
            view.setTag(c0194a);
        }
        C0194a c0194a2 = c0194a;
        c0194a2.eVK.setText(this.eVH.aSM().get(i).getName());
        am.j(c0194a2.efM, d.C0140d.cp_bg_line_b);
        am.c(c0194a2.eVK, d.C0140d.cp_cont_b, 1);
        am.i(view, d.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.eVH = aVar;
    }

    public boolean aSQ() {
        return this.cYH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0194a {
        TextView eVK;
        View efM;

        private C0194a() {
        }
    }

    public C0194a aU(View view) {
        C0194a c0194a = new C0194a();
        c0194a.eVK = (TextView) view.findViewById(d.g.location_search_address_name);
        c0194a.efM = view.findViewById(d.g.location_search_line);
        return c0194a;
    }

    public View bg(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eVJ = NoDataViewFactory.a(this.eVI.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.du(d.j.text_try_to_chage_location), null);
        this.eVJ.onChangeSkinType(this.eVI.getPageContext(), skinType);
        this.eVJ.setVisibility(0);
        return this.eVJ;
    }
}
