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
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private HTypeListView lmr;
    private c lms;
    private b lmt;
    private a lmu;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.lmr = hTypeListView;
        JZ();
    }

    private void JZ() {
        this.lms = new c(this.mTbPageContext, n.aih);
        this.lmt = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.lmC);
        this.lmu = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.lmh);
        this.bdV.add(this.lms);
        this.bdV.add(this.lmt);
        this.bdV.add(this.lmu);
        this.lmr.addAdapters(this.bdV);
    }

    public void setDatas(List<q> list) {
        if (this.lmr != null) {
            this.lmr.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.lmr != null && (this.lmr.getAdapter() instanceof af)) {
            ((af) this.lmr.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.lms.F(onClickListener);
        this.lmt.F(onClickListener);
    }
}
