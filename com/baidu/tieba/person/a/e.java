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
    private HTypeListView kjH;
    private c kjI;
    private b kjJ;
    private a kjK;
    private TbPageContext mTbPageContext;

    public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
        this.mTbPageContext = tbPageContext;
        this.kjH = hTypeListView;
        CY();
    }

    private void CY() {
        this.kjI = new c(this.mTbPageContext, m.afZ);
        this.kjJ = new b(this.mTbPageContext, com.baidu.tieba.person.data.c.kjS);
        this.kjK = new a(this.mTbPageContext.getPageActivity(), com.baidu.tieba.person.d.kjx);
        this.aSj.add(this.kjI);
        this.aSj.add(this.kjJ);
        this.aSj.add(this.kjK);
        this.kjH.addAdapters(this.aSj);
    }

    public void setDatas(List<o> list) {
        if (this.kjH != null) {
            this.kjH.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.kjH != null && (this.kjH.getAdapter() instanceof aa)) {
            ((aa) this.kjH.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.kjI.D(onClickListener);
        this.kjJ.D(onClickListener);
    }
}
