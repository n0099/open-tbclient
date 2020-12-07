package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.o;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private TbPageContext mTbPageContext;
    private HTypeListView miB;
    private c miC;
    private b miD;
    private a miE;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.miB = hTypeListView;
        Nt();
    }

    private void Nt() {
        this.miC = new c(this.mTbPageContext, o.ajD);
        this.miD = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.miM);
        this.miE = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.mip);
        this.bnf.add(this.miC);
        this.bnf.add(this.miD);
        this.bnf.add(this.miE);
        this.miB.addAdapters(this.bnf);
    }

    public void setDatas(List<q> list) {
        if (this.miB != null) {
            this.miB.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.miB != null && (this.miB.getAdapter() instanceof af)) {
            ((af) this.miB.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.miC.F(onClickListener);
        this.miD.F(onClickListener);
    }
}
