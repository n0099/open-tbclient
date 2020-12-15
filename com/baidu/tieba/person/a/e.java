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
    private HTypeListView miD;
    private c miE;
    private b miF;
    private a miG;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.miD = hTypeListView;
        Nt();
    }

    private void Nt() {
        this.miE = new c(this.mTbPageContext, o.ajD);
        this.miF = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.miO);
        this.miG = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.mir);
        this.bnf.add(this.miE);
        this.bnf.add(this.miF);
        this.bnf.add(this.miG);
        this.miD.addAdapters(this.bnf);
    }

    public void setDatas(List<q> list) {
        if (this.miD != null) {
            this.miD.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.miD != null && (this.miD.getAdapter() instanceof af)) {
            ((af) this.miD.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.miE.F(onClickListener);
        this.miF.F(onClickListener);
    }
}
