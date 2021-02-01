package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private boolean iVF = false;
    private com.baidu.tieba.location.data.a lij;
    private SearchLocationActivity lik;
    private NoDataView lil;

    public a(SearchLocationActivity searchLocationActivity) {
        this.lik = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lij == null || this.lij.ddE() == null || this.lij.ddE().isEmpty()) {
            this.iVF = false;
            return 1;
        }
        this.iVF = true;
        return this.lij.ddE().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lij == null || this.lij.ddE() == null || this.lij.ddE().isEmpty()) {
            return null;
        }
        return this.lij.ddE().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.iVF) {
            return cm(viewGroup);
        }
        C0786a c0786a = null;
        if (view != null && (view.getTag() instanceof C0786a)) {
            c0786a = (C0786a) view.getTag();
        }
        if (c0786a == null) {
            view = LayoutInflater.from(this.lik.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0786a = du(view);
            view.setTag(c0786a);
        }
        C0786a c0786a2 = c0786a;
        c0786a2.lim.setText(this.lij.ddE().get(i).getName());
        ap.setBackgroundColor(c0786a2.hhX, R.color.CAM_X0204);
        ap.setViewTextColor(c0786a2.lim, R.color.CAM_X0105, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.lij = aVar;
    }

    public boolean ddI() {
        return this.iVF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0786a {
        View hhX;
        TextView lim;

        private C0786a() {
        }
    }

    public C0786a du(View view) {
        C0786a c0786a = new C0786a();
        c0786a.lim = (TextView) view.findViewById(R.id.location_search_address_name);
        c0786a.hhX = view.findViewById(R.id.location_search_line);
        return c0786a;
    }

    public View cm(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lil = NoDataViewFactory.a(this.lik.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pz(R.string.text_try_to_chage_location), null);
        this.lil.onChangeSkinType(this.lik.getPageContext(), skinType);
        this.lil.setVisibility(0);
        return this.lil;
    }
}
