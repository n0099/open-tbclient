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
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private HTypeListView lOg;
    private c lOh;
    private b lOi;
    private a lOj;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.lOg = hTypeListView;
        Ly();
    }

    private void Ly() {
        this.lOh = new c(this.mTbPageContext, n.aiz);
        this.lOi = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.lOr);
        this.lOj = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.lNW);
        this.bje.add(this.lOh);
        this.bje.add(this.lOi);
        this.bje.add(this.lOj);
        this.lOg.addAdapters(this.bje);
    }

    public void setDatas(List<q> list) {
        if (this.lOg != null) {
            this.lOg.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.lOg != null && (this.lOg.getAdapter() instanceof af)) {
            ((af) this.lOg.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.lOh.F(onClickListener);
        this.lOi.F(onClickListener);
    }
}
