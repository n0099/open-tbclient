package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.data.f;
import com.baidu.tieba.personCenter.data.g;
import com.baidu.tieba.personCenter.data.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c gtQ;
    private d gug;
    private com.baidu.tieba.personCenter.a.a guh;
    private com.baidu.tieba.personCenter.a.b gui;
    private e guj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.gug = new d(tbPageContext, g.guM);
        this.guh = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.c.guw);
        this.gui = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.d.gux);
        this.guj = new e(tbPageContext, i.guR);
        this.gtQ = new com.baidu.tieba.personCenter.a.c(tbPageContext, f.guL);
        this.mAdapters.add(this.gug);
        this.mAdapters.add(this.guh);
        this.mAdapters.add(this.gui);
        this.mAdapters.add(this.guj);
        this.mAdapters.add(this.gtQ);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bpm() {
        this.guh.bpm();
    }

    public void bpn() {
        this.guh.destroy();
    }
}
