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
    private boolean iIs = false;
    private com.baidu.tieba.location.data.a kZg;
    private SearchLocationActivity kZh;
    private NoDataView kZi;

    public a(SearchLocationActivity searchLocationActivity) {
        this.kZh = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kZg == null || this.kZg.dfK() == null || this.kZg.dfK().isEmpty()) {
            this.iIs = false;
            return 1;
        }
        this.iIs = true;
        return this.kZg.dfK().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kZg == null || this.kZg.dfK() == null || this.kZg.dfK().isEmpty()) {
            return null;
        }
        return this.kZg.dfK().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.iIs) {
            return ca(viewGroup);
        }
        C0804a c0804a = null;
        if (view != null && (view.getTag() instanceof C0804a)) {
            c0804a = (C0804a) view.getTag();
        }
        if (c0804a == null) {
            view = LayoutInflater.from(this.kZh.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0804a = dm(view);
            view.setTag(c0804a);
        }
        C0804a c0804a2 = c0804a;
        c0804a2.kZj.setText(this.kZg.dfK().get(i).getName());
        ap.setBackgroundColor(c0804a2.hOR, R.color.CAM_X0204);
        ap.setViewTextColor(c0804a2.kZj, R.color.CAM_X0105, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.kZg = aVar;
    }

    public boolean dfO() {
        return this.iIs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0804a {
        View hOR;
        TextView kZj;

        private C0804a() {
        }
    }

    public C0804a dm(View view) {
        C0804a c0804a = new C0804a();
        c0804a.kZj = (TextView) view.findViewById(R.id.location_search_address_name);
        c0804a.hOR = view.findViewById(R.id.location_search_line);
        return c0804a;
    }

    public View ca(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kZi = NoDataViewFactory.a(this.kZh.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.qP(R.string.text_try_to_chage_location), null);
        this.kZi.onChangeSkinType(this.kZh.getPageContext(), skinType);
        this.kZi.setVisibility(0);
        return this.kZi;
    }
}
