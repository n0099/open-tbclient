package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private com.baidu.tieba.person.a.a iko;
    private h iqA;
    private e iqB;
    private k iqC;
    private d iqD;
    private com.baidu.tieba.person.a.d iqE;
    private p iqF;
    private BdPersonListView iqG;
    private m iqv;
    private b iqw;
    private i iqx;
    private a iqy;
    private c iqz;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.iqG = bdPersonListView;
        this.iqv = new m(tbPageContext);
        this.iqw = new b(tbPageContext);
        this.iqx = new i(tbPageContext);
        this.iqy = new a(tbPageContext);
        this.iqz = new c(tbPageContext);
        this.iqA = new h(tbPageContext, tbPageContext.getUniqueId());
        this.iqB = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.isB);
        this.iqC = new k(tbPageContext);
        this.iqD = new d(tbPageContext);
        this.iqE = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.ikp);
        this.iko = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ijW);
        this.iqF = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.agQ.add(this.iqv);
        this.agQ.add(this.iqw);
        this.agQ.add(this.iqx);
        this.agQ.add(this.iqy);
        this.agQ.add(this.iqz);
        this.agQ.add(this.iqA);
        this.agQ.add(this.iqB);
        this.agQ.add(this.iqC);
        this.agQ.add(this.iqD);
        this.agQ.add(this.iqE);
        this.agQ.add(this.iko);
        this.agQ.add(this.iqF);
        bdPersonListView.addAdapters(this.agQ);
    }

    public void W(View.OnClickListener onClickListener) {
        if (this.iqE != null) {
            this.iqE.T(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.iqF.setIsHost(z);
        this.iqx.setIsHost(z);
    }
}
