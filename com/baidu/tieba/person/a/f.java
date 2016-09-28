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
    private List<com.baidu.adp.widget.ListView.a> bOo = new ArrayList();
    private HTypeListView eDK;
    private d eDL;
    private a eDM;
    private com.baidu.tieba.personCenter.a.b eDN;
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public f(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.eDK = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        aqE();
    }

    private void aqE() {
        this.eDL = new d(this.mTbPageContext, k.asG);
        this.eDM = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.eDZ);
        this.eDN = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eFB);
        this.bOo.add(this.eDL);
        this.bOo.add(this.eDM);
        this.bOo.add(this.eDN);
        this.eDK.g(this.bOo);
    }

    public void setDatas(List<v> list) {
        if (this.eDK != null) {
            this.eDK.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eDK != null && (this.eDK.getAdapter() instanceof y)) {
            ((y) this.eDK.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eDL.G(onClickListener);
        this.eDM.G(onClickListener);
    }
}
