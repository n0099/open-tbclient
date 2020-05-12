package com.baidu.tieba.pb.videopb.a;

import android.arch.lifecycle.y;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.pb.main.g;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private com.baidu.adp.widget.ListView.a hPK;
    private BdTypeRecyclerView hcY;
    private DetailInfoFragment jLD;
    private List<m> jLE;
    private c jLF;
    private com.baidu.tieba.pb.pb.main.adapter.c jLG;
    private b jLH;
    private g jLI;
    private e jqZ;
    private com.baidu.adp.widget.ListView.a jqz;
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private View.OnClickListener jLJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.jqZ == null || a.this.jqZ.cvs() == null || a.this.jqZ.cvs().aKt() == 0) {
                    a.this.jLD.cyh().cxz();
                    a.this.jLD.cyh().sb(false);
                } else {
                    ((com.baidu.tieba.pb.videopb.e) y.b(a.this.jLD.cyi()).l(com.baidu.tieba.pb.videopb.e.class)).setCurrentTab(VideoPbFragment.jKl);
                }
                String str = "";
                if (a.this.jqZ != null) {
                    str = a.this.jqZ.getThreadId();
                }
                TiebaStatic.log(new an("c12942").af("obj_type", 1).af("obj_locate", 4).cI("tid", str));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.jLD.cyh().sa(false);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jLD = detailInfoFragment;
        this.hcY = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jLF = new c(detailInfoFragment.cyh(), PostData.kSr);
        this.jLG = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cyh(), k.joG);
        this.jLG.setOnClickListener(this.jLJ);
        this.jLH = new b(detailInfoFragment.getContext(), o.TYPE);
        this.jLI = new g(detailInfoFragment.cyh(), l.dnq);
        this.jLI.qQ(true);
        this.aMj.add(this.jLF);
        this.aMj.add(this.jLG);
        this.aMj.add(this.jLH);
        this.aMj.add(this.jLI);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.aMj);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.hPK = q.cNm().a(detailInfoFragment.cyh().getBaseFragmentActivity(), AdvertAppInfo.dmg);
        this.jqz = q.cNm().a(detailInfoFragment.cyh().getBaseFragmentActivity(), AdvertAppInfo.dmk);
        this.aMj.add(this.hPK);
        this.aMj.add(this.jqz);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            this.jqZ = eVar;
            if (this.hcY != null) {
                this.hcY.setVisibility(0);
            }
            this.jLF.setPbData(eVar);
            this.jLI.setPbData(eVar);
            this.hcY.setData(J(eVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<m> J(e eVar) {
        PostData postData;
        com.baidu.tieba.tbadkCore.data.m mVar;
        int i;
        int i2;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        int i3;
        int i4;
        int i5;
        if (eVar == null) {
            return null;
        }
        this.jLE = new ArrayList();
        Iterator<PostData> it = eVar.cvu().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.cWp() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && eVar.cvz() != null) {
            postData = eVar.cvz();
        }
        if (postData != null) {
            this.jLE.add(postData);
        }
        k kVar = new k(eVar.cvs(), eVar.getAnti());
        kVar.qF(true);
        kVar.joI = true;
        this.jLE.add(kVar);
        if (eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.jLD.cwB().cws()) || !this.jLD.cwB().cyA())) {
            o oVar = new o();
            bj bjVar = new bj();
            bjVar.tid = eVar.getThreadId();
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForumId(), 0L));
            bf bfVar = new bf();
            bfVar.avatar = eVar.getForum().getImage_url();
            bfVar.forumName = eVar.getForum().getName();
            bfVar.memberNum = eVar.getForum().getMember_num();
            bfVar.postNum = eVar.getForum().getPost_num();
            bfVar.forumId = eVar.getForumId();
            bjVar.a(bfVar);
            oVar.dqE = bjVar;
            this.jLE.add(oVar);
            kVar.qF(false);
            kVar.joI = false;
        }
        List<com.baidu.tieba.tbadkCore.data.m> cvU = eVar.cvU();
        int i6 = -1;
        if (cvU == null || cvU.isEmpty()) {
            mVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.m mVar3 = cvU.get(0);
            mVar = mVar3;
            i6 = mVar3.getPosition();
        }
        if (eVar.cvP() != null) {
            int i7 = i6;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.m mVar4 = mVar;
            int i9 = 1;
            for (l lVar : eVar.cvP()) {
                if (cvU == null || i9 != i7) {
                    int i10 = i9;
                    i = i7;
                    i2 = i8;
                    mVar2 = mVar4;
                    i3 = i10;
                } else {
                    if (mVar4 != null) {
                        c(mVar4);
                        this.jLE.add(mVar4);
                        i8++;
                        if (mVar4.getType() != AdvertAppInfo.dmg) {
                            i4 = i8;
                            i5 = i9 + 1;
                            if (i4 >= cvU.size()) {
                                com.baidu.tieba.tbadkCore.data.m mVar5 = cvU.get(i4);
                                i3 = i5;
                                mVar2 = mVar5;
                                i = mVar5.getPosition();
                                i2 = i4;
                            } else {
                                i = i7;
                                i2 = i4;
                                int i11 = i5;
                                mVar2 = mVar4;
                                i3 = i11;
                            }
                        }
                    }
                    i4 = i8;
                    i5 = i9;
                    if (i4 >= cvU.size()) {
                    }
                }
                this.jLE.add(lVar);
                int i12 = i3 + 1;
                mVar4 = mVar2;
                i8 = i2;
                i7 = i;
                i9 = i12;
            }
        }
        return this.jLE;
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.jqZ != null && mVar.cWd() != null) {
            mVar.cWd().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.jqZ.getPage() != null) {
                mVar.cWd().advertAppContext.pn = this.jqZ.getPage().aJw();
            }
            mVar.cWd().advertAppContext.page = mVar.cWg();
            if (this.jqZ.getForum() != null && (forum = this.jqZ.getForum()) != null) {
                mVar.cWd().advertAppContext.fid = forum.getId();
                mVar.cWd().advertAppContext.dlX = forum.getFirst_class();
                mVar.cWd().advertAppContext.dlY = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cWd().advertAppContext.dlZ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cWd().advertAppContext.extensionInfo = mVar.cWd().ext_info;
            mVar.cWd().advertAppContext.WL = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.hcY != null && this.hcY.getAdapter() != null) {
            this.hcY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void cEu() {
        if (this.jLF != null) {
            this.jLF.notifyDataSetChanged();
        }
    }
}
