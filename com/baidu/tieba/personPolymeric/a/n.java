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
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private com.baidu.tieba.person.a.a ijx;
    private m ipE;
    private b ipF;
    private i ipG;
    private a ipH;
    private c ipI;
    private h ipJ;
    private e ipK;
    private k ipL;
    private d ipM;
    private com.baidu.tieba.person.a.d ipN;
    private p ipO;
    private BdPersonListView ipP;
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.ipP = bdPersonListView;
        this.ipE = new m(tbPageContext);
        this.ipF = new b(tbPageContext);
        this.ipG = new i(tbPageContext);
        this.ipH = new a(tbPageContext);
        this.ipI = new c(tbPageContext);
        this.ipJ = new h(tbPageContext, tbPageContext.getUniqueId());
        this.ipK = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.irK);
        this.ipL = new k(tbPageContext);
        this.ipM = new d(tbPageContext);
        this.ipN = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.ijy);
        this.ijx = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.ijf);
        this.ipO = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.agy.add(this.ipE);
        this.agy.add(this.ipF);
        this.agy.add(this.ipG);
        this.agy.add(this.ipH);
        this.agy.add(this.ipI);
        this.agy.add(this.ipJ);
        this.agy.add(this.ipK);
        this.agy.add(this.ipL);
        this.agy.add(this.ipM);
        this.agy.add(this.ipN);
        this.agy.add(this.ijx);
        this.agy.add(this.ipO);
        bdPersonListView.addAdapters(this.agy);
    }

    public void W(View.OnClickListener onClickListener) {
        if (this.ipN != null) {
            this.ipN.T(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.ipO.setIsHost(z);
        this.ipG.setIsHost(z);
    }
}
