package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.n;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private HTypeListView jeO;
    private c jeP;
    private b jeQ;
    private a jeR;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.jeO = hTypeListView;
        vi();
    }

    private void vi() {
        this.jeP = new c(this.mTbPageContext, n.Mm);
        this.jeQ = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.jeZ);
        this.jeR = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.jeE);
        this.apl.add(this.jeP);
        this.apl.add(this.jeQ);
        this.apl.add(this.jeR);
        this.jeO.addAdapters(this.apl);
    }

    public void setDatas(List<m> list) {
        if (this.jeO != null) {
            this.jeO.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.jeO != null && (this.jeO.getAdapter() instanceof v)) {
            ((v) this.jeO.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.jeP.C(onClickListener);
        this.jeQ.C(onClickListener);
    }
}
