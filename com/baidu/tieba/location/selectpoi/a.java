package com.baidu.tieba.location.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private boolean huV = false;
    private com.baidu.tieba.location.data.a jFU;
    private SearchLocationActivity jFV;
    private NoDataView jFW;

    public a(SearchLocationActivity searchLocationActivity) {
        this.jFV = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jFU == null || this.jFU.cDk() == null || this.jFU.cDk().isEmpty()) {
            this.huV = false;
            return 1;
        }
        this.huV = true;
        return this.jFU.cDk().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jFU == null || this.jFU.cDk() == null || this.jFU.cDk().isEmpty()) {
            return null;
        }
        return this.jFU.cDk().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.huV) {
            return bZ(viewGroup);
        }
        C0689a c0689a = null;
        if (view != null && (view.getTag() instanceof C0689a)) {
            c0689a = (C0689a) view.getTag();
        }
        if (c0689a == null) {
            view = LayoutInflater.from(this.jFV.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0689a = cB(view);
            view.setTag(c0689a);
        }
        C0689a c0689a2 = c0689a;
        c0689a2.jFX.setText(this.jFU.cDk().get(i).getName());
        ao.setBackgroundColor(c0689a2.gIw, R.color.cp_bg_line_c);
        ao.setViewTextColor(c0689a2.jFX, R.color.cp_cont_b, 1);
        ao.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.jFU = aVar;
    }

    public boolean cDo() {
        return this.huV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C0689a {
        View gIw;
        TextView jFX;

        private C0689a() {
        }
    }

    public C0689a cB(View view) {
        C0689a c0689a = new C0689a();
        c0689a.jFX = (TextView) view.findViewById(R.id.location_search_address_name);
        c0689a.gIw = view.findViewById(R.id.location_search_line);
        return c0689a;
    }

    public View bZ(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jFW = NoDataViewFactory.a(this.jFV.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.mF(R.string.text_try_to_chage_location), null);
        this.jFW.onChangeSkinType(this.jFV.getPageContext(), skinType);
        this.jFW.setVisibility(0);
        return this.jFW;
    }
}
