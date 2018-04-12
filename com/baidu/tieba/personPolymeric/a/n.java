package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class n {
    private com.baidu.tieba.person.a.a fCI;
    private m fId;
    private b fIe;
    private i fIf;
    private a fIg;
    private c fIh;
    private h fIi;
    private e fIj;
    private k fIk;
    private d fIl;
    private com.baidu.tieba.person.a.d fIm;
    private p fIn;
    private BdPersonListView fIo;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.fIo = bdPersonListView;
        this.fId = new m(tbPageContext);
        this.fIe = new b(tbPageContext);
        this.fIf = new i(tbPageContext);
        this.fIg = new a(tbPageContext);
        this.fIh = new c(tbPageContext);
        this.fIi = new h(tbPageContext, tbPageContext.getUniqueId());
        this.fIj = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.fKu);
        this.fIk = new k(tbPageContext);
        this.fIl = new d(tbPageContext);
        this.fIm = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.fCJ);
        this.fCI = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.fCp);
        this.fIn = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.fId);
        this.mAdapters.add(this.fIe);
        this.mAdapters.add(this.fIf);
        this.mAdapters.add(this.fIg);
        this.mAdapters.add(this.fIh);
        this.mAdapters.add(this.fIi);
        this.mAdapters.add(this.fIj);
        this.mAdapters.add(this.fIk);
        this.mAdapters.add(this.fIl);
        this.mAdapters.add(this.fIm);
        this.mAdapters.add(this.fCI);
        this.mAdapters.add(this.fIn);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fIm != null) {
            this.fIm.L(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.fIn.setIsHost(z);
        this.fIf.setIsHost(z);
    }
}
