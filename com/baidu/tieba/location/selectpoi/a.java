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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private boolean iXC = false;
    private SearchLocationActivity lkA;
    private NoDataView lkB;
    private com.baidu.tieba.location.data.a lkz;

    public a(SearchLocationActivity searchLocationActivity) {
        this.lkA = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lkz == null || this.lkz.ddU() == null || this.lkz.ddU().isEmpty()) {
            this.iXC = false;
            return 1;
        }
        this.iXC = true;
        return this.lkz.ddU().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lkz == null || this.lkz.ddU() == null || this.lkz.ddU().isEmpty()) {
            return null;
        }
        return this.lkz.ddU().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.iXC) {
            return cl(viewGroup);
        }
        C0793a c0793a = null;
        if (view != null && (view.getTag() instanceof C0793a)) {
            c0793a = (C0793a) view.getTag();
        }
        if (c0793a == null) {
            view = LayoutInflater.from(this.lkA.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0793a = du(view);
            view.setTag(c0793a);
        }
        C0793a c0793a2 = c0793a;
        c0793a2.lkC.setText(this.lkz.ddU().get(i).getName());
        ap.setBackgroundColor(c0793a2.hjV, R.color.CAM_X0204);
        ap.setViewTextColor(c0793a2.lkC, R.color.CAM_X0105, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.lkz = aVar;
    }

    public boolean ddY() {
        return this.iXC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0793a {
        View hjV;
        TextView lkC;

        private C0793a() {
        }
    }

    public C0793a du(View view) {
        C0793a c0793a = new C0793a();
        c0793a.lkC = (TextView) view.findViewById(R.id.location_search_address_name);
        c0793a.hjV = view.findViewById(R.id.location_search_line);
        return c0793a;
    }

    public View cl(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.lkB = NoDataViewFactory.a(this.lkA.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pA(R.string.text_try_to_chage_location), null);
        this.lkB.onChangeSkinType(this.lkA.getPageContext(), skinType);
        this.lkB.setVisibility(0);
        return this.lkB;
    }
}
