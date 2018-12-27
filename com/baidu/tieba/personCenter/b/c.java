package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.data.e;
/* loaded from: classes5.dex */
public class c {
    a guq;
    private BdTypeListView mListView;

    public c(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        this.guq = new a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    public void b(e eVar) {
        this.mListView.setData(eVar.edS);
    }

    public void notifyDataSetChanged() {
        this.guq.onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.guq.onChangeSkinType();
    }

    public void bpm() {
        this.guq.bpm();
    }

    public void bpn() {
        this.guq.bpn();
    }
}
