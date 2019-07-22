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
    private com.baidu.tieba.person.a.a iiD;
    private m ioS;
    private b ioT;
    private i ioU;
    private a ioV;
    private c ioW;
    private h ioX;
    private e ioY;
    private k ioZ;
    private d ipa;
    private com.baidu.tieba.person.a.d ipb;
    private p ipc;
    private BdPersonListView ipd;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdUniqueId mBdUniqueId;

    public n(TbPageContext tbPageContext, BdPersonListView bdPersonListView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdPersonListView);
    }

    private void a(TbPageContext tbPageContext, BdPersonListView bdPersonListView) {
        this.ipd = bdPersonListView;
        this.ioS = new m(tbPageContext);
        this.ioT = new b(tbPageContext);
        this.ioU = new i(tbPageContext);
        this.ioV = new a(tbPageContext);
        this.ioW = new c(tbPageContext);
        this.ioX = new h(tbPageContext, tbPageContext.getUniqueId());
        this.ioY = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.iqY);
        this.ioZ = new k(tbPageContext);
        this.ipa = new d(tbPageContext);
        this.ipb = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.iiE);
        this.iiD = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.iil);
        this.ipc = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mAdapters.add(this.ioS);
        this.mAdapters.add(this.ioT);
        this.mAdapters.add(this.ioU);
        this.mAdapters.add(this.ioV);
        this.mAdapters.add(this.ioW);
        this.mAdapters.add(this.ioX);
        this.mAdapters.add(this.ioY);
        this.mAdapters.add(this.ioZ);
        this.mAdapters.add(this.ipa);
        this.mAdapters.add(this.ipb);
        this.mAdapters.add(this.iiD);
        this.mAdapters.add(this.ipc);
        bdPersonListView.addAdapters(this.mAdapters);
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.ipb != null) {
            this.ipb.S(onClickListener);
        }
    }

    public void setIsHost(boolean z) {
        this.ipc.setIsHost(z);
        this.ioU.setIsHost(z);
    }
}
