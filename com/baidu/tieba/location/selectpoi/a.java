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
    private boolean fkX = false;
    private com.baidu.tieba.location.data.a hlE;
    private SearchLocationActivity hlF;
    private NoDataView hlG;

    public a(SearchLocationActivity searchLocationActivity) {
        this.hlF = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hlE == null || this.hlE.bJL() == null || this.hlE.bJL().isEmpty()) {
            this.fkX = false;
            return 1;
        }
        this.fkX = true;
        return this.hlE.bJL().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hlE == null || this.hlE.bJL() == null || this.hlE.bJL().isEmpty()) {
            return null;
        }
        return this.hlE.bJL().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.fkX) {
            return bC(viewGroup);
        }
        C0463a c0463a = null;
        if (view != null && (view.getTag() instanceof C0463a)) {
            c0463a = (C0463a) view.getTag();
        }
        if (c0463a == null) {
            view = LayoutInflater.from(this.hlF.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0463a = cl(view);
            view.setTag(c0463a);
        }
        C0463a c0463a2 = c0463a;
        c0463a2.hlH.setText(this.hlE.bJL().get(i).getName());
        am.setBackgroundColor(c0463a2.ezl, R.color.cp_bg_line_c);
        am.setViewTextColor(c0463a2.hlH, R.color.cp_cont_b, 1);
        am.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.hlE = aVar;
    }

    public boolean bJP() {
        return this.fkX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0463a {
        View ezl;
        TextView hlH;

        private C0463a() {
        }
    }

    public C0463a cl(View view) {
        C0463a c0463a = new C0463a();
        c0463a.hlH = (TextView) view.findViewById(R.id.location_search_address_name);
        c0463a.ezl = view.findViewById(R.id.location_search_line);
        return c0463a;
    }

    public View bC(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hlG = NoDataViewFactory.a(this.hlF.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iL(R.string.text_try_to_chage_location), null);
        this.hlG.onChangeSkinType(this.hlF.getPageContext(), skinType);
        this.hlG.setVisibility(0);
        return this.hlG;
    }
}
