package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private List<com.baidu.adp.widget.ListView.a> bOr = new ArrayList();
    private HTypeListView eBH;
    private d eBI;
    private a eBJ;
    private com.baidu.tieba.personCenter.a.b eBK;
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public f(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.eBH = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        aqf();
    }

    private void aqf() {
        this.eBI = new d(this.mTbPageContext, k.asV);
        this.eBJ = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.eBW);
        this.eBK = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eDy);
        this.bOr.add(this.eBI);
        this.bOr.add(this.eBJ);
        this.bOr.add(this.eBK);
        this.eBH.g(this.bOr);
    }

    public void setDatas(List<v> list) {
        if (this.eBH != null) {
            this.eBH.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eBH != null && (this.eBH.getAdapter() instanceof y)) {
            ((y) this.eBH.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eBI.H(onClickListener);
        this.eBJ.H(onClickListener);
    }
}
