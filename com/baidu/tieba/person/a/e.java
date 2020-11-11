package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private HTypeListView lUc;
    private c lUd;
    private b lUe;
    private a lUf;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.lUc = hTypeListView;
        LY();
    }

    private void LY() {
        this.lUd = new c(this.mTbPageContext, n.aiz);
        this.lUe = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.lUn);
        this.lUf = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.lTS);
        this.bky.add(this.lUd);
        this.bky.add(this.lUe);
        this.bky.add(this.lUf);
        this.lUc.addAdapters(this.bky);
    }

    public void setDatas(List<q> list) {
        if (this.lUc != null) {
            this.lUc.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.lUc != null && (this.lUc.getAdapter() instanceof af)) {
            ((af) this.lUc.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.lUd.G(onClickListener);
        this.lUe.G(onClickListener);
    }
}
