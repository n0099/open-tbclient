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
    private com.baidu.adp.widget.ListView.a hPE;
    private BdTypeRecyclerView hcS;
    private List<m> jLA;
    private c jLB;
    private com.baidu.tieba.pb.pb.main.adapter.c jLC;
    private b jLD;
    private g jLE;
    private DetailInfoFragment jLz;
    private e jqV;
    private com.baidu.adp.widget.ListView.a jqv;
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private View.OnClickListener jLF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.jqV == null || a.this.jqV.cvu() == null || a.this.jqV.cvu().aKv() == 0) {
                    a.this.jLz.cyj().cxB();
                    a.this.jLz.cyj().sb(false);
                } else {
                    ((com.baidu.tieba.pb.videopb.e) y.b(a.this.jLz.cyk()).l(com.baidu.tieba.pb.videopb.e.class)).setCurrentTab(VideoPbFragment.jKh);
                }
                String str = "";
                if (a.this.jqV != null) {
                    str = a.this.jqV.getThreadId();
                }
                TiebaStatic.log(new an("c12942").af("obj_type", 1).af("obj_locate", 4).cI("tid", str));
            } else if (view.getId() == R.id.share_num_container) {
                a.this.jLz.cyj().sa(false);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jLz = detailInfoFragment;
        this.hcS = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jLB = new c(detailInfoFragment.cyj(), PostData.kSn);
        this.jLC = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cyj(), k.joC);
        this.jLC.setOnClickListener(this.jLF);
        this.jLD = new b(detailInfoFragment.getContext(), o.TYPE);
        this.jLE = new g(detailInfoFragment.cyj(), l.dnm);
        this.jLE.qQ(true);
        this.aMd.add(this.jLB);
        this.aMd.add(this.jLC);
        this.aMd.add(this.jLD);
        this.aMd.add(this.jLE);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.aMd);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.hPE = q.cNo().a(detailInfoFragment.cyj().getBaseFragmentActivity(), AdvertAppInfo.dmc);
        this.jqv = q.cNo().a(detailInfoFragment.cyj().getBaseFragmentActivity(), AdvertAppInfo.dmg);
        this.aMd.add(this.hPE);
        this.aMd.add(this.jqv);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            this.jqV = eVar;
            if (this.hcS != null) {
                this.hcS.setVisibility(0);
            }
            this.jLB.setPbData(eVar);
            this.jLE.setPbData(eVar);
            this.hcS.setData(J(eVar));
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
        this.jLA = new ArrayList();
        Iterator<PostData> it = eVar.cvw().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.cWr() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && eVar.cvB() != null) {
            postData = eVar.cvB();
        }
        if (postData != null) {
            this.jLA.add(postData);
        }
        k kVar = new k(eVar.cvu(), eVar.getAnti());
        kVar.qF(true);
        kVar.joE = true;
        this.jLA.add(kVar);
        if (eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.jLz.cwD().cwu()) || !this.jLz.cwD().cyC())) {
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
            oVar.dqA = bjVar;
            this.jLA.add(oVar);
            kVar.qF(false);
            kVar.joE = false;
        }
        List<com.baidu.tieba.tbadkCore.data.m> cvW = eVar.cvW();
        int i6 = -1;
        if (cvW == null || cvW.isEmpty()) {
            mVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.m mVar3 = cvW.get(0);
            mVar = mVar3;
            i6 = mVar3.getPosition();
        }
        if (eVar.cvR() != null) {
            int i7 = i6;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.m mVar4 = mVar;
            int i9 = 1;
            for (l lVar : eVar.cvR()) {
                if (cvW == null || i9 != i7) {
                    int i10 = i9;
                    i = i7;
                    i2 = i8;
                    mVar2 = mVar4;
                    i3 = i10;
                } else {
                    if (mVar4 != null) {
                        c(mVar4);
                        this.jLA.add(mVar4);
                        i8++;
                        if (mVar4.getType() != AdvertAppInfo.dmc) {
                            i4 = i8;
                            i5 = i9 + 1;
                            if (i4 >= cvW.size()) {
                                com.baidu.tieba.tbadkCore.data.m mVar5 = cvW.get(i4);
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
                    if (i4 >= cvW.size()) {
                    }
                }
                this.jLA.add(lVar);
                int i12 = i3 + 1;
                mVar4 = mVar2;
                i8 = i2;
                i7 = i;
                i9 = i12;
            }
        }
        return this.jLA;
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.jqV != null && mVar.cWf() != null) {
            mVar.cWf().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.jqV.getPage() != null) {
                mVar.cWf().advertAppContext.pn = this.jqV.getPage().aJy();
            }
            mVar.cWf().advertAppContext.page = mVar.cWi();
            if (this.jqV.getForum() != null && (forum = this.jqV.getForum()) != null) {
                mVar.cWf().advertAppContext.fid = forum.getId();
                mVar.cWf().advertAppContext.dlT = forum.getFirst_class();
                mVar.cWf().advertAppContext.dlU = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cWf().advertAppContext.dlV = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cWf().advertAppContext.extensionInfo = mVar.cWf().ext_info;
            mVar.cWf().advertAppContext.WI = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.hcS != null && this.hcS.getAdapter() != null) {
            this.hcS.getListAdapter().notifyDataSetChanged();
        }
    }

    public void cEw() {
        if (this.jLB != null) {
            this.jLB.notifyDataSetChanged();
        }
    }
}
