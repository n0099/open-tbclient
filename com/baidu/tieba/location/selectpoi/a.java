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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private boolean deA = false;
    private com.baidu.tieba.location.data.a fcX;
    private SearchLocationActivity fcY;
    private NoDataView fcZ;

    public a(SearchLocationActivity searchLocationActivity) {
        this.fcY = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fcX == null || this.fcX.aUX() == null || this.fcX.aUX().isEmpty()) {
            this.deA = false;
            return 1;
        }
        this.deA = true;
        return this.fcX.aUX().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fcX == null || this.fcX.aUX() == null || this.fcX.aUX().isEmpty()) {
            return null;
        }
        return this.fcX.aUX().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.deA) {
            return bg(viewGroup);
        }
        C0196a c0196a = null;
        if (view != null && (view.getTag() instanceof C0196a)) {
            c0196a = (C0196a) view.getTag();
        }
        if (c0196a == null) {
            view = LayoutInflater.from(this.fcY.getPageContext().getPageActivity()).inflate(e.h.location_search_item_layout, viewGroup, false);
            c0196a = bi(view);
            view.setTag(c0196a);
        }
        C0196a c0196a2 = c0196a;
        c0196a2.fda.setText(this.fcX.aUX().get(i).getName());
        al.j(c0196a2.enf, e.d.cp_bg_line_b);
        al.c(c0196a2.fda, e.d.cp_cont_b, 1);
        al.i(view, e.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.fcX = aVar;
    }

    public boolean aVb() {
        return this.deA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0196a {
        View enf;
        TextView fda;

        private C0196a() {
        }
    }

    public C0196a bi(View view) {
        C0196a c0196a = new C0196a();
        c0196a.fda = (TextView) view.findViewById(e.g.location_search_address_name);
        c0196a.enf = view.findViewById(e.g.location_search_line);
        return c0196a;
    }

    public View bg(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fcZ = NoDataViewFactory.a(this.fcY.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dE(e.j.text_try_to_chage_location), null);
        this.fcZ.onChangeSkinType(this.fcY.getPageContext(), skinType);
        this.fcZ.setVisibility(0);
        return this.fcZ;
    }
}
