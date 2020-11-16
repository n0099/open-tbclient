package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private HTypeListView lUu;
    private c lUv;
    private b lUw;
    private a lUx;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.lUu = hTypeListView;
        Lp();
    }

    private void Lp() {
        this.lUv = new c(this.mTbPageContext, n.aiE);
        this.lUw = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.lUF);
        this.lUx = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.lUi);
        this.biN.add(this.lUv);
        this.biN.add(this.lUw);
        this.biN.add(this.lUx);
        this.lUu.addAdapters(this.biN);
    }

    public void setDatas(List<q> list) {
        if (this.lUu != null) {
            this.lUu.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.lUu != null && (this.lUu.getAdapter() instanceof af)) {
            ((af) this.lUu.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.lUv.F(onClickListener);
        this.lUw.F(onClickListener);
    }
}
