package com.baidu.tieba.write.selectpoi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.m;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private boolean aPK = false;
    private m biG;
    private com.baidu.tieba.write.data.b dlp;
    private SearchLocationActivity dlq;

    public h(SearchLocationActivity searchLocationActivity) {
        this.dlq = searchLocationActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dlp == null || this.dlp.aBA() == null || this.dlp.aBA().isEmpty()) {
            this.aPK = false;
            return 1;
        }
        this.aPK = true;
        return this.dlp.aBA().size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dlp == null || this.dlp.aBA() == null || this.dlp.aBA().isEmpty()) {
            return null;
        }
        return this.dlp.aBA().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.aPK) {
            return R(viewGroup);
        }
        a aVar = null;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            view = LayoutInflater.from(this.dlq.getPageContext().getPageActivity()).inflate(i.g.location_search_item_layout, viewGroup, false);
            aVar = az(view);
            view.setTag(aVar);
        }
        a aVar2 = aVar;
        aVar2.dlr.setText(this.dlp.aBA().get(i).getName());
        am.j(aVar2.line, i.c.cp_bg_line_b);
        am.b(aVar2.dlr, i.c.cp_cont_b, 1);
        am.i(view, i.e.home_recommend_item_bg);
        return view;
    }

    public void a(com.baidu.tieba.write.data.b bVar) {
        this.dlp = bVar;
    }

    public boolean aBH() {
        return this.aPK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        TextView dlr;
        View line;

        private a() {
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }
    }

    public a az(View view) {
        a aVar = new a(this, null);
        aVar.dlr = (TextView) view.findViewById(i.f.location_search_address_name);
        aVar.line = view.findViewById(i.f.location_search_line);
        return aVar;
    }

    public View R(ViewGroup viewGroup) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.biG = NoDataViewFactory.a(this.dlq.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.cK(i.h.text_try_to_chage_location), null);
        this.biG.onChangeSkinType(this.dlq.getPageContext(), skinType);
        this.biG.setVisibility(0);
        return this.biG;
    }
}
