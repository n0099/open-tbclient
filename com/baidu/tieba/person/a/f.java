package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private HTypeListView bbO;
    private List<com.baidu.adp.widget.ListView.a> bbV = new ArrayList();
    private d eoa;
    private a eob;
    private com.baidu.tieba.personCenter.a.b eoc;
    private BdUniqueId mId;
    private TbPageContext mTbPageContext;

    public f(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.bbO = hTypeListView;
        this.mId = tbPageContext.getUniqueId();
        Ou();
    }

    private void Ou() {
        this.eoa = new d(this.mTbPageContext, l.ate);
        this.eob = new a(this.mTbPageContext, com.baidu.tieba.person.data.a.eon);
        this.eoc = new com.baidu.tieba.personCenter.a.b(this.mTbPageContext.getPageActivity(), com.baidu.tieba.personCenter.c.b.epy);
        this.bbV.add(this.eoa);
        this.bbV.add(this.eob);
        this.bbV.add(this.eoc);
        this.bbO.g(this.bbV);
    }

    public void setDatas(List<v> list) {
        if (this.bbO != null) {
            this.bbO.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.bbO != null && (this.bbO.getAdapter() instanceof y)) {
            ((y) this.bbO.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eoa.u(onClickListener);
        this.eob.u(onClickListener);
    }
}
