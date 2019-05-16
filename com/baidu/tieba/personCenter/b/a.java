package com.baidu.tieba.personCenter.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personCenter.a.d;
import com.baidu.tieba.personCenter.a.e;
import com.baidu.tieba.personCenter.a.f;
import com.baidu.tieba.personCenter.data.g;
import com.baidu.tieba.personCenter.data.h;
import com.baidu.tieba.personCenter.data.j;
import com.baidu.tieba.personCenter.data.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private com.baidu.tieba.personCenter.a.c icS;
    private d idi;
    private com.baidu.tieba.personCenter.a.a idj;
    private com.baidu.tieba.personCenter.a.b idk;
    private f idm;
    private e idn;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mListView = bdTypeListView;
        a(bdTypeListView, tbPageContext, bdUniqueId);
    }

    private void a(BdTypeListView bdTypeListView, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.idi = new d(tbPageContext, h.idT);
        this.idj = new com.baidu.tieba.personCenter.a.a(tbPageContext, com.baidu.tieba.personCenter.data.d.idC);
        this.idk = new com.baidu.tieba.personCenter.a.b(tbPageContext, com.baidu.tieba.personCenter.data.e.idD);
        this.idm = new f(tbPageContext, m.ied);
        this.icS = new com.baidu.tieba.personCenter.a.c(tbPageContext, g.idS);
        this.idn = new e(tbPageContext, j.idX);
        this.mAdapters.add(this.idi);
        this.mAdapters.add(this.idj);
        this.mAdapters.add(this.idk);
        this.mAdapters.add(this.idm);
        this.mAdapters.add(this.icS);
        this.mAdapters.add(this.idn);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void onChangeSkinType() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void bYi() {
        this.idj.bYi();
    }

    public void bYj() {
        this.idj.destroy();
    }
}
