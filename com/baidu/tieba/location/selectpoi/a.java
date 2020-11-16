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
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    private boolean ixA = false;
    private com.baidu.tieba.location.data.a kLP;
    private SearchLocationActivity kLQ;
    private NoDataView kLR;

    public a(SearchLocationActivity searchLocationActivity) {
        this.kLQ = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kLP == null || this.kLP.day() == null || this.kLP.day().isEmpty()) {
            this.ixA = false;
            return 1;
        }
        this.ixA = true;
        return this.kLP.day().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kLP == null || this.kLP.day() == null || this.kLP.day().isEmpty()) {
            return null;
        }
        return this.kLP.day().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.ixA) {
            return bX(viewGroup);
        }
        C0788a c0788a = null;
        if (view != null && (view.getTag() instanceof C0788a)) {
            c0788a = (C0788a) view.getTag();
        }
        if (c0788a == null) {
            view = LayoutInflater.from(this.kLQ.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0788a = df(view);
            view.setTag(c0788a);
        }
        C0788a c0788a2 = c0788a;
        c0788a2.kLS.setText(this.kLP.day().get(i).getName());
        ap.setBackgroundColor(c0788a2.hFk, R.color.CAM_X0204);
        ap.setViewTextColor(c0788a2.kLS, R.color.CAM_X0105, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.kLP = aVar;
    }

    public boolean daC() {
        return this.ixA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0788a {
        View hFk;
        TextView kLS;

        private C0788a() {
        }
    }

    public C0788a df(View view) {
        C0788a c0788a = new C0788a();
        c0788a.kLS = (TextView) view.findViewById(R.id.location_search_address_name);
        c0788a.hFk = view.findViewById(R.id.location_search_line);
        return c0788a;
    }

    public View bX(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kLR = NoDataViewFactory.a(this.kLQ.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.qo(R.string.text_try_to_chage_location), null);
        this.kLR.onChangeSkinType(this.kLQ.getPageContext(), skinType);
        this.kLR.setVisibility(0);
        return this.kLR;
    }
}
