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
    private BdTypeRecyclerView hrX;
    private com.baidu.adp.widget.ListView.a ifc;
    private e jIU;
    private d jIl;
    private com.baidu.adp.widget.ListView.a jIs;
    private b keA;
    private h keB;
    private z keC;
    private DetailInfoFragment kev;
    private List<o> kew;
    private c kex;
    private com.baidu.tieba.pb.pb.main.adapter.c kez;
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private View.OnClickListener keD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.jIU == null || a.this.jIU.cCy() == null || a.this.jIU.cCy().aQo() == 0) {
                    a.this.kev.cFr().cEK();
                    a.this.kev.cFr().sz(false);
                } else {
                    ((com.baidu.tieba.pb.videopb.e) y.b(a.this.kev.cFs()).l(com.baidu.tieba.pb.videopb.e.class)).setCurrentTab(VideoPbFragment.kdc);
                }
                String str = "";
                String str2 = "";
                if (a.this.jIU != null) {
                    str = a.this.jIU.getThreadId();
                    if (a.this.jIU.cCy() != null) {
                        str2 = a.this.jIU.cCy().getNid();
                    }
                }
                TiebaStatic.log(new an("c12942").ag("obj_type", 1).ag("obj_locate", 4).dh("tid", str).dh("nid", str2));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.kev.cFr().sy(false);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kev = detailInfoFragment;
        this.hrX = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kex = new c(detailInfoFragment.cFr(), PostData.llR);
        this.kez = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cFr(), m.jGv);
        this.kez.setOnClickListener(this.keD);
        this.keA = new b(detailInfoFragment.getContext(), q.TYPE);
        this.jIl = new d(detailInfoFragment.getContext(), g.TYPE);
        this.keB = new h(detailInfoFragment.cFr(), k.dBs);
        this.keB.ro(true);
        this.keC = new z(detailInfoFragment.cFr());
        this.aSj.add(this.kex);
        this.aSj.add(this.kez);
        this.aSj.add(this.keA);
        this.aSj.add(this.jIl);
        this.aSj.add(this.keB);
        this.aSj.add(this.keC);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.aSj);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.ifc = com.baidu.tieba.recapp.q.cUC().a(detailInfoFragment.cFr().getBaseFragmentActivity(), AdvertAppInfo.dAi);
        this.jIs = com.baidu.tieba.recapp.q.cUC().a(detailInfoFragment.cFr().getBaseFragmentActivity(), AdvertAppInfo.dAm);
        this.aSj.add(this.ifc);
        this.aSj.add(this.jIs);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            this.jIU = eVar;
            if (this.hrX != null) {
                this.hrX.setVisibility(0);
            }
            this.kex.setPbData(eVar);
            this.keB.setPbData(eVar);
            this.keC.setPbData(eVar);
            this.hrX.setData(L(eVar));
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
        this.kew = new ArrayList();
        Iterator<PostData> it = eVar.cCA().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.ddJ() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && eVar.cCH() != null) {
            postData = eVar.cCH();
        }
        if (postData != null) {
            this.kew.add(postData);
        }
        m mVar = new m(eVar.cCy(), eVar.getAnti());
        mVar.rd(true);
        mVar.jGx = true;
        this.kew.add(mVar);
        if (eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.kev.cDO().cDF()) || !this.kev.cDO().cFM())) {
            if (com.baidu.tbadk.a.d.aMr()) {
                g gVar = new g(eVar.getForum());
                gVar.tid = this.kev.cDO().cFJ();
                gVar.jFY = true;
                this.kew.add(gVar);
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
                this.kew.add(qVar);
            }
            mVar.rd(false);
            mVar.jGx = false;
        }
        List<n> cDd = eVar.cDd();
        int i6 = -1;
        if (cDd == null || cDd.isEmpty()) {
            nVar = null;
        } else {
            n nVar3 = cDd.get(0);
            nVar = nVar3;
            i6 = nVar3.getPosition();
        }
        if (eVar.cCY() != null) {
            int i7 = i6;
            int i8 = 0;
            n nVar4 = nVar;
            int i9 = 1;
            for (k kVar : eVar.cCY()) {
                if (cDd == null || i9 != i7) {
                    int i10 = i9;
                    i = i7;
                    i2 = i8;
                    nVar2 = nVar4;
                    i3 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        this.kew.add(nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.dAi) {
                            i4 = i8;
                            i5 = i9 + 1;
                            if (i4 >= cDd.size()) {
                                n nVar5 = cDd.get(i4);
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
                    if (i4 >= cDd.size()) {
                    }
                }
                this.kew.add(kVar);
                int i12 = i3 + 1;
                if (i12 == 4 && eVar.cCE() != null) {
                    this.kew.add(eVar.cCE());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i2;
                i7 = i;
                i9 = i12;
            }
        }
        return this.kew;
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.jIU != null && nVar.ddx() != null) {
            nVar.ddx().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.jIU.getPage() != null) {
                nVar.ddx().advertAppContext.pn = this.jIU.getPage().aPr();
            }
            nVar.ddx().advertAppContext.page = nVar.ddA();
            if (this.jIU.getForum() != null && (forum = this.jIU.getForum()) != null) {
                nVar.ddx().advertAppContext.fid = forum.getId();
                nVar.ddx().advertAppContext.dzZ = forum.getFirst_class();
                nVar.ddx().advertAppContext.dAa = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.ddx().advertAppContext.dAb = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.ddx().advertAppContext.extensionInfo = nVar.ddx().ext_info;
            nVar.ddx().advertAppContext.WZ = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.hrX != null && this.hrX.getAdapter() != null) {
            this.hrX.getListAdapter().notifyDataSetChanged();
        }
    }

    public void cLH() {
        if (this.kex != null) {
            this.kex.notifyDataSetChanged();
        }
    }
}
