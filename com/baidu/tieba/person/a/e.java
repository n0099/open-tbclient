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
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private HTypeListView lBJ;
    private c lBK;
    private b lBL;
    private a lBM;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.lBJ = hTypeListView;
        Le();
    }

    private void Le() {
        this.lBK = new c(this.mTbPageContext, n.aiy);
        this.lBL = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.lBU);
        this.lBM = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.lBz);
        this.bhH.add(this.lBK);
        this.bhH.add(this.lBL);
        this.bhH.add(this.lBM);
        this.lBJ.addAdapters(this.bhH);
    }

    public void setDatas(List<q> list) {
        if (this.lBJ != null) {
            this.lBJ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.lBJ != null && (this.lBJ.getAdapter() instanceof af)) {
            ((af) this.lBJ.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.lBK.F(onClickListener);
        this.lBL.F(onClickListener);
    }
}
