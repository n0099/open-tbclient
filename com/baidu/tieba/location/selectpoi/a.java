package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private boolean duS = false;
    private com.baidu.tieba.location.data.a fgR;
    private SearchLocationActivity fgS;
    private h fgT;

    public a(SearchLocationActivity searchLocationActivity) {
        this.fgS = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fgR == null || this.fgR.aRm() == null || this.fgR.aRm().isEmpty()) {
            this.duS = false;
            return 1;
        }
        this.duS = true;
        return this.fgR.aRm().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fgR == null || this.fgR.aRm() == null || this.fgR.aRm().isEmpty()) {
            return null;
        }
        return this.fgR.aRm().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.duS) {
            return bi(viewGroup);
        }
        C0194a c0194a = null;
        if (view != null && (view.getTag() instanceof C0194a)) {
            c0194a = (C0194a) view.getTag();
        }
        if (c0194a == null) {
            view = LayoutInflater.from(this.fgS.getPageContext().getPageActivity()).inflate(d.h.location_search_item_layout, viewGroup, false);
            c0194a = ch(view);
            view.setTag(c0194a);
        }
        C0194a c0194a2 = c0194a;
        c0194a2.fgU.setText(this.fgR.aRm().get(i).getName());
        aj.t(c0194a2.erb, d.C0141d.cp_bg_line_b);
        aj.e(c0194a2.fgU, d.C0141d.cp_cont_b, 1);
        aj.s(view, d.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.fgR = aVar;
    }

    public boolean aRq() {
        return this.duS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0194a {
        View erb;
        TextView fgU;

        private C0194a() {
        }
    }

    public C0194a ch(View view) {
        C0194a c0194a = new C0194a();
        c0194a.fgU = (TextView) view.findViewById(d.g.location_search_address_name);
        c0194a.erb = view.findViewById(d.g.location_search_line);
        return c0194a;
    }

    public View bi(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fgT = NoDataViewFactory.a(this.fgS.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gp(d.j.text_try_to_chage_location), null);
        this.fgT.onChangeSkinType(this.fgS.getPageContext(), skinType);
        this.fgT.setVisibility(0);
        return this.fgT;
    }
}
