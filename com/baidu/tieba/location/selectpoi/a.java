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
    private boolean iVT = false;
    private com.baidu.tieba.location.data.a lix;
    private SearchLocationActivity liy;
    private NoDataView liz;

    public a(SearchLocationActivity searchLocationActivity) {
        this.liy = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lix == null || this.lix.ddL() == null || this.lix.ddL().isEmpty()) {
            this.iVT = false;
            return 1;
        }
        this.iVT = true;
        return this.lix.ddL().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lix == null || this.lix.ddL() == null || this.lix.ddL().isEmpty()) {
            return null;
        }
        return this.lix.ddL().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.iVT) {
            return cm(viewGroup);
        }
        C0787a c0787a = null;
        if (view != null && (view.getTag() instanceof C0787a)) {
            c0787a = (C0787a) view.getTag();
        }
        if (c0787a == null) {
            view = LayoutInflater.from(this.liy.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0787a = du(view);
            view.setTag(c0787a);
        }
        C0787a c0787a2 = c0787a;
        c0787a2.liA.setText(this.lix.ddL().get(i).getName());
        ap.setBackgroundColor(c0787a2.him, R.color.CAM_X0204);
        ap.setViewTextColor(c0787a2.liA, R.color.CAM_X0105, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.lix = aVar;
    }

    public boolean ddP() {
        return this.iVT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0787a {
        View him;
        TextView liA;

        private C0787a() {
        }
    }

    public C0787a du(View view) {
        C0787a c0787a = new C0787a();
        c0787a.liA = (TextView) view.findViewById(R.id.location_search_address_name);
        c0787a.him = view.findViewById(R.id.location_search_line);
        return c0787a;
    }

    public View cm(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.liz = NoDataViewFactory.a(this.liy.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pz(R.string.text_try_to_chage_location), null);
        this.liz.onChangeSkinType(this.liy.getPageContext(), skinType);
        this.liz.setVisibility(0);
        return this.liz;
    }
}
