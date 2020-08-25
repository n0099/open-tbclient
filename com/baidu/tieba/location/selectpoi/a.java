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
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private boolean hIk = false;
    private com.baidu.tieba.location.data.a jVl;
    private SearchLocationActivity jVm;
    private NoDataView jVn;

    public a(SearchLocationActivity searchLocationActivity) {
        this.jVm = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jVl == null || this.jVl.cOb() == null || this.jVl.cOb().isEmpty()) {
            this.hIk = false;
            return 1;
        }
        this.hIk = true;
        return this.jVl.cOb().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jVl == null || this.jVl.cOb() == null || this.jVl.cOb().isEmpty()) {
            return null;
        }
        return this.jVl.cOb().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.hIk) {
            return bV(viewGroup);
        }
        C0740a c0740a = null;
        if (view != null && (view.getTag() instanceof C0740a)) {
            c0740a = (C0740a) view.getTag();
        }
        if (c0740a == null) {
            view = LayoutInflater.from(this.jVm.getPageContext().getPageActivity()).inflate(R.layout.location_search_item_layout, viewGroup, false);
            c0740a = cF(view);
            view.setTag(c0740a);
        }
        C0740a c0740a2 = c0740a;
        c0740a2.jVo.setText(this.jVl.cOb().get(i).getName());
        ap.setBackgroundColor(c0740a2.gUZ, R.color.cp_bg_line_c);
        ap.setViewTextColor(c0740a2.jVo, R.color.cp_cont_b, 1);
        ap.setBackgroundResource(view, R.drawable.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.location.data.a aVar) {
        this.jVl = aVar;
    }

    public boolean cOf() {
        return this.hIk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.location.selectpoi.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C0740a {
        View gUZ;
        TextView jVo;

        private C0740a() {
        }
    }

    public C0740a cF(View view) {
        C0740a c0740a = new C0740a();
        c0740a.jVo = (TextView) view.findViewById(R.id.location_search_address_name);
        c0740a.gUZ = view.findViewById(R.id.location_search_line);
        return c0740a;
    }

    public View bV(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jVn = NoDataViewFactory.a(this.jVm.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oK(R.string.text_try_to_chage_location), null);
        this.jVn.onChangeSkinType(this.jVm.getPageContext(), skinType);
        this.jVn.setVisibility(0);
        return this.jVn;
    }
}
