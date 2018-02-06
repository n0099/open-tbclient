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
    private boolean dvb = false;
    private com.baidu.tieba.location.data.a fgP;
    private SearchLocationActivity fgQ;
    private h fgR;

    public a(SearchLocationActivity searchLocationActivity) {
        this.fgQ = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fgP == null || this.fgP.aRm() == null || this.fgP.aRm().isEmpty()) {
            this.dvb = false;
            return 1;
        }
        this.dvb = true;
        return this.fgP.aRm().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fgP == null || this.fgP.aRm() == null || this.fgP.aRm().isEmpty()) {
            return null;
        }
        return this.fgP.aRm().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.dvb) {
            return bi(viewGroup);
        }
        C0193a c0193a = null;
        if (view != null && (view.getTag() instanceof C0193a)) {
            c0193a = (C0193a) view.getTag();
        }
        if (c0193a == null) {
            view = LayoutInflater.from(this.fgQ.getPageContext().getPageActivity()).inflate(d.h.location_search_item_layout, viewGroup, false);
            c0193a = ch(view);
            view.setTag(c0193a);
        }
        C0193a c0193a2 = c0193a;
        c0193a2.fgS.setText(this.fgP.aRm().get(i).getName());
        aj.t(c0193a2.eqX, d.C0140d.cp_bg_line_b);
        aj.e(c0193a2.fgS, d.C0140d.cp_cont_b, 1);
        aj.s(view, d.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.fgP = aVar;
    }

    public boolean aRq() {
        return this.dvb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0193a {
        View eqX;
        TextView fgS;

        private C0193a() {
        }
    }

    public C0193a ch(View view) {
        C0193a c0193a = new C0193a();
        c0193a.fgS = (TextView) view.findViewById(d.g.location_search_address_name);
        c0193a.eqX = view.findViewById(d.g.location_search_line);
        return c0193a;
    }

    public View bi(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fgR = NoDataViewFactory.a(this.fgQ.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.gp(d.j.text_try_to_chage_location), null);
        this.fgR.onChangeSkinType(this.fgQ.getPageContext(), skinType);
        this.fgR.setVisibility(0);
        return this.fgR;
    }
}
