package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private HTypeListView kkN;
    private c kkO;
    private b kkP;
    private a kkQ;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.kkN = hTypeListView;
        CY();
    }

    private void CY() {
        this.kkO = new c(this.mTbPageContext, m.afZ);
        this.kkP = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.kkY);
        this.kkQ = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.kkD);
        this.aSj.add(this.kkO);
        this.aSj.add(this.kkP);
        this.aSj.add(this.kkQ);
        this.kkN.addAdapters(this.aSj);
    }

    public void setDatas(List<o> list) {
        if (this.kkN != null) {
            this.kkN.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.kkN != null && (this.kkN.getAdapter() instanceof aa)) {
            ((aa) this.kkN.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.kkO.D(onClickListener);
        this.kkP.D(onClickListener);
    }
}
