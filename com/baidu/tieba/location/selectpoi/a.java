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
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private boolean iIu = false;
    private com.baidu.tieba.location.data.a kZi;
    private SearchLocationActivity kZj;
    private NoDataView kZk;

    public a(SearchLocationActivity searchLocationActivity) {
        this.kZj = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kZi == null || this.kZi.dfL() == null || this.kZi.dfL().isEmpty()) {
            this.iIu = false;
            return 1;
        }
        this.iIu = true;
        return this.kZi.dfL().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kZi == null || this.kZi.dfL() == null || this.kZi.dfL().isEmpty()) {
            return null;
        }
        return this.kZi.dfL().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.iIu) {
            return ca(viewGroup);
        }
        C0804a c0804a = null;
        if (view != null && (view.getTag() instanceof C0804a)) {
            c0804a = (C0804a) view.getTag();
        }
        if (c0804a == null) {
            view = LayoutInflater.from(this.kZj.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0804a = dm(view);
            view.setTag(c0804a);
        }
        C0804a c0804a2 = c0804a;
        c0804a2.kZl.setText(this.kZi.dfL().get(i).getName());
        ap.setBackgroundColor(c0804a2.hOT, R.color.CAM_X0204);
        ap.setViewTextColor(c0804a2.kZl, R.color.CAM_X0105, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.kZi = aVar;
    }

    public boolean dfP() {
        return this.iIu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0804a {
        View hOT;
        TextView kZl;

        private C0804a() {
        }
    }

    public C0804a dm(View view) {
        C0804a c0804a = new C0804a();
        c0804a.kZl = (TextView) view.findViewById(R.id.location_search_address_name);
        c0804a.hOT = view.findViewById(R.id.location_search_line);
        return c0804a;
    }

    public View ca(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kZk = NoDataViewFactory.a(this.kZj.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.qP(R.string.text_try_to_chage_location), null);
        this.kZk.onChangeSkinType(this.kZj.getPageContext(), skinType);
        this.kZk.setVisibility(0);
        return this.kZk;
    }
}
