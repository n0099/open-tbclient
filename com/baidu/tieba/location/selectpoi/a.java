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
    private boolean dmF = false;
    private com.baidu.tieba.location.data.a fkG;
    private SearchLocationActivity fkH;
    private NoDataView fkI;

    public a(SearchLocationActivity searchLocationActivity) {
        this.fkH = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fkG == null || this.fkG.aYk() == null || this.fkG.aYk().isEmpty()) {
            this.dmF = false;
            return 1;
        }
        this.dmF = true;
        return this.fkG.aYk().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fkG == null || this.fkG.aYk() == null || this.fkG.aYk().isEmpty()) {
            return null;
        }
        return this.fkG.aYk().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.dmF) {
            return bg(viewGroup);
        }
        C0230a c0230a = null;
        if (view != null && (view.getTag() instanceof C0230a)) {
            c0230a = (C0230a) view.getTag();
        }
        if (c0230a == null) {
            view = LayoutInflater.from(this.fkH.getPageContext().getPageActivity()).inflate(e.h.location_search_item_layout, viewGroup, false);
            c0230a = bi(view);
            view.setTag(c0230a);
        }
        C0230a c0230a2 = c0230a;
        c0230a2.fkJ.setText(this.fkG.aYk().get(i).getName());
        al.j(c0230a2.euX, e.d.cp_bg_line_b);
        al.c(c0230a2.fkJ, e.d.cp_cont_b, 1);
        al.i(view, e.f.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.fkG = aVar;
    }

    public boolean aYo() {
        return this.dmF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0230a {
        View euX;
        TextView fkJ;

        private C0230a() {
        }
    }

    public C0230a bi(View view) {
        C0230a c0230a = new C0230a();
        c0230a.fkJ = (TextView) view.findViewById(e.g.location_search_address_name);
        c0230a.euX = view.findViewById(e.g.location_search_line);
        return c0230a;
    }

    public View bg(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fkI = NoDataViewFactory.a(this.fkH.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.dO(e.j.text_try_to_chage_location), null);
        this.fkI.onChangeSkinType(this.fkH.getPageContext(), skinType);
        this.fkI.setVisibility(0);
        return this.fkI;
    }
}
