package com.baidu.tieba.personPolymeric.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class n {
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private BdTypeRecyclerView iNq;
    private com.baidu.tieba.person.a.a lUf;
    private BdUniqueId mBdUniqueId;
    private m mbb;
    private b mbc;
    private i mbd;
    private a mbe;
    private c mbf;
    private h mbg;
    private e mbh;
    private k mbi;
    private d mbj;
    private com.baidu.tieba.person.a.d mbk;
    private p mbl;
    private com.baidu.tieba.personPolymeric.a.a.g mbm;
    private com.baidu.tieba.personPolymeric.a.a.d mbn;
    private com.baidu.tieba.personPolymeric.a.a.i mbo;
    private com.baidu.tieba.personPolymeric.a.a.h mbp;
    private com.baidu.tieba.personPolymeric.a.a.a mbq;
    private com.baidu.tieba.personPolymeric.a.a.c mbr;
    private com.baidu.tieba.personPolymeric.a.a.b mbs;
    private com.baidu.tieba.personPolymeric.a.a.e mbt;
    private com.baidu.tieba.personPolymeric.a.a.f mbu;

    public n(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        a(tbPageContext, bdTypeRecyclerView);
        setPageUniqueId(bdUniqueId);
    }

    private void a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iNq = bdTypeRecyclerView;
        this.mbb = new m(tbPageContext);
        this.mbc = new b(tbPageContext);
        this.mbd = new i(tbPageContext);
        this.mbe = new a(tbPageContext);
        this.mbf = new c(tbPageContext);
        this.mbg = new h(tbPageContext, tbPageContext.getUniqueId());
        this.mbh = new e(tbPageContext, com.baidu.tieba.personPolymeric.c.g.mdt);
        this.mbi = new k(tbPageContext);
        this.mbj = new d(tbPageContext);
        this.mbk = new com.baidu.tieba.person.a.d(tbPageContext, com.baidu.tieba.person.a.f.lUg);
        this.lUf = new com.baidu.tieba.person.a.a(tbPageContext.getPageActivity(), com.baidu.tieba.person.d.lTS);
        this.mbl = new p(tbPageContext, PersonPostModel.PostInfoList.POST_INFO);
        this.mbm = new com.baidu.tieba.personPolymeric.a.a.g(tbPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.mbn = new com.baidu.tieba.personPolymeric.a.a.d(tbPageContext, com.baidu.tieba.card.data.l.eDU);
        this.mbo = new com.baidu.tieba.personPolymeric.a.a.i(tbPageContext, com.baidu.tieba.card.data.m.eDW);
        this.mbp = new com.baidu.tieba.personPolymeric.a.a.h(tbPageContext, com.baidu.tieba.card.data.l.eEb);
        this.mbs = new com.baidu.tieba.personPolymeric.a.a.b(tbPageContext, com.baidu.tieba.card.data.l.eEd);
        this.mbt = new com.baidu.tieba.personPolymeric.a.a.e(tbPageContext, com.baidu.tieba.card.data.l.eEc);
        this.mbu = new com.baidu.tieba.personPolymeric.a.a.f(tbPageContext, com.baidu.tieba.card.data.l.eEe);
        this.mbq = new com.baidu.tieba.personPolymeric.a.a.a(tbPageContext, com.baidu.tieba.card.data.f.iaZ);
        this.mbr = new com.baidu.tieba.personPolymeric.a.a.c(tbPageContext, com.baidu.tieba.card.data.g.iba);
        this.bky.add(this.mbb);
        this.bky.add(this.mbc);
        this.bky.add(this.mbd);
        this.bky.add(this.mbe);
        this.bky.add(this.mbf);
        this.bky.add(this.mbg);
        this.bky.add(this.mbh);
        this.bky.add(this.mbi);
        this.bky.add(this.mbj);
        this.bky.add(this.mbk);
        this.bky.add(this.lUf);
        this.bky.add(this.mbl);
        this.bky.add(this.mbm);
        this.bky.add(this.mbn);
        this.bky.add(this.mbo);
        this.bky.add(this.mbp);
        this.bky.add(this.mbs);
        this.bky.add(this.mbt);
        this.bky.add(this.mbu);
        this.bky.add(this.mbq);
        this.bky.add(this.mbr);
        bdTypeRecyclerView.addAdapters(this.bky);
        EZ("page_recommend");
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.mbm.fsQ = bdUniqueId;
        this.mbn.fsQ = bdUniqueId;
        this.mbo.fsQ = bdUniqueId;
        this.mbp.fsQ = bdUniqueId;
        this.mbs.fsQ = bdUniqueId;
        this.mbt.fsQ = bdUniqueId;
        this.mbu.fsQ = bdUniqueId;
        this.mbq.fsQ = bdUniqueId;
        this.mbr.fsQ = bdUniqueId;
    }

    public void Hb(int i) {
        this.mbm.Hd(i);
        this.mbn.Hd(i);
        this.mbo.Hd(i);
        this.mbp.Hd(i);
        this.mbq.Hd(i);
        this.mbr.Hd(i);
        this.mbs.Hd(i);
        this.mbt.Hd(i);
        this.mbu.Hd(i);
    }

    public void Hc(int i) {
        this.mbm.Hc(i);
        this.mbn.Hc(i);
        this.mbo.Hc(i);
        this.mbp.Hc(i);
        this.mbq.Hc(i);
        this.mbr.Hc(i);
        this.mbs.Hc(i);
        this.mbt.Hc(i);
        this.mbu.Hc(i);
    }

    public void setTabType(int i) {
        this.mbm.setTabType(i);
        this.mbn.setTabType(i);
        this.mbo.setTabType(i);
        this.mbp.setTabType(i);
        this.mbq.setTabType(i);
        this.mbr.setTabType(i);
        this.mbs.setTabType(i);
        this.mbt.setTabType(i);
        this.mbu.setTabType(i);
    }

    public void setIsHost(boolean z) {
        this.mbl.setIsHost(z);
        this.mbd.setIsHost(z);
        this.mbm.setIsHost(z);
        this.mbn.setIsHost(z);
        this.mbo.setIsHost(z);
        this.mbp.setIsHost(z);
        this.mbq.setIsHost(z);
        this.mbr.setIsHost(z);
        this.mbs.setIsHost(z);
        this.mbt.setIsHost(z);
        this.mbu.setIsHost(z);
    }

    private void EZ(String str) {
        if (this.bky != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EZ(str);
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.iNq.getListAdapter() != null) {
            this.iNq.getListAdapter().notifyDataSetChanged();
        }
    }
}
