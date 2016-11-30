package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private List<com.baidu.adp.widget.ListView.a> bRh = new ArrayList();
    private HTypeListView eKj;
    private d eKk;
    private a eKl;
    private com.baidu.tieba.personCenter.a.b eKm;
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public f(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.eKj = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        asB();
    }

    private void asB() {
        this.eKk = new d(this.mTbPageContext, com.baidu.tbadk.data.l.atB);
        this.eKl = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.eKy);
        this.eKm = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.eMa);
        this.bRh.add(this.eKk);
        this.bRh.add(this.eKl);
        this.bRh.add(this.eKm);
        this.eKj.g(this.bRh);
    }

    public void setDatas(List<v> list) {
        if (this.eKj != null) {
            this.eKj.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eKj != null && (this.eKj.getAdapter() instanceof y)) {
            ((y) this.eKj.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eKk.x(onClickListener);
        this.eKl.x(onClickListener);
    }
}
