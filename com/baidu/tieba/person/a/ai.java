package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ai {
    private List<com.baidu.adp.widget.ListView.a> bCN = new ArrayList();
    private BaseFragmentActivity bgI;
    private HTypeListView eqT;
    private ag eqU;
    private c eqV;
    private BdUniqueId mId;

    public ai(BaseFragmentActivity baseFragmentActivity, HTypeListView hTypeListView) {
        this.bgI = baseFragmentActivity;
        this.eqT = hTypeListView;
        this.mId = baseFragmentActivity.getUniqueId();
        alq();
    }

    private void alq() {
        this.eqU = new ag(this.bgI, com.baidu.tbadk.data.k.apP);
        this.eqV = new c(this.bgI, com.baidu.tieba.person.data.b.erK);
        this.bCN.add(this.eqU);
        this.bCN.add(this.eqV);
        this.eqT.g(this.bCN);
    }

    public void setDatas(List<com.baidu.adp.widget.ListView.v> list) {
        if (this.eqT != null) {
            this.eqT.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        if (this.eqT != null && (this.eqT.getAdapter() instanceof com.baidu.adp.widget.ListView.y)) {
            ((com.baidu.adp.widget.ListView.y) this.eqT.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        this.eqU.J(onClickListener);
        this.eqV.J(onClickListener);
    }
}
