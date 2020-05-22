package com.baidu.tieba.pb.videopb.a;

import android.arch.lifecycle.y;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.g;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.data.q;
import com.baidu.tieba.pb.pb.main.adapter.d;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView hrM;
    private com.baidu.adp.widget.ListView.a iep;
    private e jHO;
    private d jHf;
    private com.baidu.adp.widget.ListView.a jHm;
    private DetailInfoFragment kdp;
    private List<o> kdq;
    private c kdr;
    private com.baidu.tieba.pb.pb.main.adapter.c kds;
    private b kdt;
    private h kdu;
    private z kdv;
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private View.OnClickListener kdw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.jHO == null || a.this.jHO.cCi() == null || a.this.jHO.cCi().aQo() == 0) {
                    a.this.kdp.cFb().cEu();
                    a.this.kdp.cFb().sz(false);
                } else {
                    ((com.baidu.tieba.pb.videopb.e) y.b(a.this.kdp.cFc()).l(com.baidu.tieba.pb.videopb.e.class)).setCurrentTab(VideoPbFragment.kbW);
                }
                String str = "";
                String str2 = "";
                if (a.this.jHO != null) {
                    str = a.this.jHO.getThreadId();
                    if (a.this.jHO.cCi() != null) {
                        str2 = a.this.jHO.cCi().getNid();
                    }
                }
                TiebaStatic.log(new an("c12942").ag("obj_type", 1).ag("obj_locate", 4).dh("tid", str).dh("nid", str2));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.kdp.cFb().sy(false);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kdp = detailInfoFragment;
        this.hrM = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kdr = new c(detailInfoFragment.cFb(), PostData.lkI);
        this.kds = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cFb(), m.jFp);
        this.kds.setOnClickListener(this.kdw);
        this.kdt = new b(detailInfoFragment.getContext(), q.TYPE);
        this.jHf = new d(detailInfoFragment.getContext(), g.TYPE);
        this.kdu = new h(detailInfoFragment.cFb(), k.dBs);
        this.kdu.ro(true);
        this.kdv = new z(detailInfoFragment.cFb());
        this.aSj.add(this.kdr);
        this.aSj.add(this.kds);
        this.aSj.add(this.kdt);
        this.aSj.add(this.jHf);
        this.aSj.add(this.kdu);
        this.aSj.add(this.kdv);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.aSj);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.iep = com.baidu.tieba.recapp.q.cUm().a(detailInfoFragment.cFb().getBaseFragmentActivity(), AdvertAppInfo.dAi);
        this.jHm = com.baidu.tieba.recapp.q.cUm().a(detailInfoFragment.cFb().getBaseFragmentActivity(), AdvertAppInfo.dAm);
        this.aSj.add(this.iep);
        this.aSj.add(this.jHm);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            this.jHO = eVar;
            if (this.hrM != null) {
                this.hrM.setVisibility(0);
            }
            this.kdr.setPbData(eVar);
            this.kdu.setPbData(eVar);
            this.kdv.setPbData(eVar);
            this.hrM.setData(L(eVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<o> L(e eVar) {
        PostData postData;
        n nVar;
        int i;
        int i2;
        n nVar2;
        int i3;
        int i4;
        int i5;
        if (eVar == null) {
            return null;
        }
        this.kdq = new ArrayList();
        Iterator<PostData> it = eVar.cCk().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.ddu() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && eVar.cCr() != null) {
            postData = eVar.cCr();
        }
        if (postData != null) {
            this.kdq.add(postData);
        }
        m mVar = new m(eVar.cCi(), eVar.getAnti());
        mVar.rd(true);
        mVar.jFr = true;
        this.kdq.add(mVar);
        if (eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.kdp.cDy().cDp()) || !this.kdp.cDy().cFw())) {
            if (com.baidu.tbadk.a.d.aMr()) {
                g gVar = new g(eVar.getForum());
                gVar.tid = this.kdp.cDy().cFt();
                gVar.jES = true;
                this.kdq.add(gVar);
            } else {
                q qVar = new q();
                bk bkVar = new bk();
                bkVar.tid = eVar.getThreadId();
                bkVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForumId(), 0L));
                bg bgVar = new bg();
                bgVar.avatar = eVar.getForum().getImage_url();
                bgVar.forumName = eVar.getForum().getName();
                bgVar.memberNum = eVar.getForum().getMember_num();
                bgVar.postNum = eVar.getForum().getPost_num();
                bgVar.forumId = eVar.getForumId();
                bkVar.a(bgVar);
                qVar.dEA = bkVar;
                this.kdq.add(qVar);
            }
            mVar.rd(false);
            mVar.jFr = false;
        }
        List<n> cCN = eVar.cCN();
        int i6 = -1;
        if (cCN == null || cCN.isEmpty()) {
            nVar = null;
        } else {
            n nVar3 = cCN.get(0);
            nVar = nVar3;
            i6 = nVar3.getPosition();
        }
        if (eVar.cCI() != null) {
            int i7 = i6;
            int i8 = 0;
            n nVar4 = nVar;
            int i9 = 1;
            for (k kVar : eVar.cCI()) {
                if (cCN == null || i9 != i7) {
                    int i10 = i9;
                    i = i7;
                    i2 = i8;
                    nVar2 = nVar4;
                    i3 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        this.kdq.add(nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.dAi) {
                            i4 = i8;
                            i5 = i9 + 1;
                            if (i4 >= cCN.size()) {
                                n nVar5 = cCN.get(i4);
                                i3 = i5;
                                nVar2 = nVar5;
                                i = nVar5.getPosition();
                                i2 = i4;
                            } else {
                                i = i7;
                                i2 = i4;
                                int i11 = i5;
                                nVar2 = nVar4;
                                i3 = i11;
                            }
                        }
                    }
                    i4 = i8;
                    i5 = i9;
                    if (i4 >= cCN.size()) {
                    }
                }
                this.kdq.add(kVar);
                int i12 = i3 + 1;
                if (i12 == 4 && eVar.cCo() != null) {
                    this.kdq.add(eVar.cCo());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i2;
                i7 = i;
                i9 = i12;
            }
        }
        return this.kdq;
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.jHO != null && nVar.ddi() != null) {
            nVar.ddi().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.jHO.getPage() != null) {
                nVar.ddi().advertAppContext.pn = this.jHO.getPage().aPr();
            }
            nVar.ddi().advertAppContext.page = nVar.ddl();
            if (this.jHO.getForum() != null && (forum = this.jHO.getForum()) != null) {
                nVar.ddi().advertAppContext.fid = forum.getId();
                nVar.ddi().advertAppContext.dzZ = forum.getFirst_class();
                nVar.ddi().advertAppContext.dAa = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.ddi().advertAppContext.dAb = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.ddi().advertAppContext.extensionInfo = nVar.ddi().ext_info;
            nVar.ddi().advertAppContext.WZ = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.hrM != null && this.hrM.getAdapter() != null) {
            this.hrM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void cLr() {
        if (this.kdr != null) {
            this.kdr.notifyDataSetChanged();
        }
    }
}
