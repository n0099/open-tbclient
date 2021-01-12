package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.o;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private TbPageContext mTbPageContext;
    private HTypeListView mjg;
    private c mjh;
    private b mji;
    private a mjj;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.mjg = hTypeListView;
        IY();
    }

    private void IY() {
        this.mjh = new c(this.mTbPageContext, o.agN);
        this.mji = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.mjr);
        this.mjj = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.miU);
        this.bjZ.add(this.mjh);
        this.bjZ.add(this.mji);
        this.bjZ.add(this.mjj);
        this.mjg.addAdapters(this.bjZ);
    }

    public void setDatas(List<n> list) {
        if (this.mjg != null) {
            this.mjg.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.mjg != null && (this.mjg.getAdapter() instanceof TypeAdapter)) {
            ((TypeAdapter) this.mjg.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.mjh.H(onClickListener);
        this.mji.H(onClickListener);
    }
}
