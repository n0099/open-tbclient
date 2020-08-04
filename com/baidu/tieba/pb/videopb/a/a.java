package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.data.s;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView hKL;
    private com.baidu.adp.widget.ListView.a iAt;
    private DetailInfoFragment kHh;
    private List<q> kHi;
    private d kHj;
    private com.baidu.tieba.pb.pb.main.adapter.c kHk;
    private c kHl;
    private h kHm;
    private ab kHn;
    private com.baidu.adp.widget.ListView.a kkG;
    private com.baidu.tieba.pb.pb.main.adapter.d kkz;
    private f kli;
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private View.OnClickListener kHo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.BJ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.BL(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.BJ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.BL(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kHh = detailInfoFragment;
        this.hKL = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kHj = new d(detailInfoFragment.cNs(), PostData.lNc);
        this.kHk = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cNs(), o.kiN);
        this.kHk.setOnClickListener(this.kHo);
        this.kHl = new c(detailInfoFragment.getContext(), s.TYPE);
        this.kkz = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kHm = new h(detailInfoFragment.cNs(), n.dNW);
        this.kHm.sg(true);
        this.kHn = new ab(detailInfoFragment.cNs());
        this.aWf.add(this.kHj);
        this.aWf.add(this.kHk);
        this.aWf.add(this.kHl);
        this.aWf.add(this.kkz);
        this.aWf.add(this.kHm);
        this.aWf.add(this.kHn);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.aWf);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.iAt = r.dca().a(detailInfoFragment.cNs().getBaseFragmentActivity(), AdvertAppInfo.dMK);
        this.kkG = r.dca().a(detailInfoFragment.cNs().getBaseFragmentActivity(), AdvertAppInfo.dMO);
        this.aWf.add(this.iAt);
        this.aWf.add(this.kkG);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.kli = fVar;
            if (this.hKL != null) {
                this.hKL.setVisibility(0);
            }
            this.kHj.setPbData(fVar);
            this.kHm.setPbData(fVar);
            this.kHn.setPbData(fVar);
            this.hKL.setData(M(fVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<q> M(f fVar) {
        PostData postData;
        com.baidu.tieba.tbadkCore.data.n nVar;
        int i;
        int i2;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        int i3;
        int i4;
        int i5;
        if (fVar == null) {
            return null;
        }
        this.kHi = new ArrayList();
        Iterator<PostData> it = fVar.cKz().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dli() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.cKG() != null) {
            postData = fVar.cKG();
        }
        if (postData != null) {
            this.kHi.add(postData);
        }
        o oVar = new o(fVar.cKx(), fVar.getAnti());
        oVar.rV(true);
        oVar.kiP = true;
        this.kHi.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kHh.cLP().cLG()) || !this.kHh.cLP().cNO())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.kHh.cLP().cNL();
            hVar.kim = true;
            this.kHi.add(hVar);
            oVar.rV(false);
            oVar.kiP = false;
        }
        List<com.baidu.tieba.tbadkCore.data.n> cLe = fVar.cLe();
        int i6 = -1;
        if (cLe == null || cLe.isEmpty()) {
            nVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.n nVar3 = cLe.get(0);
            nVar = nVar3;
            i6 = nVar3.getPosition();
        }
        if (fVar.cKZ() != null) {
            int i7 = i6;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
            int i9 = 1;
            for (n nVar5 : fVar.cKZ()) {
                if (cLe == null || i9 != i7) {
                    int i10 = i9;
                    i = i7;
                    i2 = i8;
                    nVar2 = nVar4;
                    i3 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        this.kHi.add(nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.dMK) {
                            i4 = i8;
                            i5 = i9 + 1;
                            if (i4 >= cLe.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = cLe.get(i4);
                                i3 = i5;
                                nVar2 = nVar6;
                                i = nVar6.getPosition();
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
                    if (i4 >= cLe.size()) {
                    }
                }
                this.kHi.add(nVar5);
                int i12 = i3 + 1;
                if (i12 == 4 && fVar.cKD() != null) {
                    this.kHi.add(fVar.cKD());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i2;
                i7 = i;
                i9 = i12;
            }
        }
        return this.kHi;
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kli != null && nVar.dkW() != null) {
            nVar.dkW().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kli.getPage() != null) {
                nVar.dkW().advertAppContext.pn = this.kli.getPage().aUZ();
            }
            nVar.dkW().advertAppContext.page = nVar.dkZ();
            if (this.kli.getForum() != null && (forum = this.kli.getForum()) != null) {
                nVar.dkW().advertAppContext.fid = forum.getId();
                nVar.dkW().advertAppContext.dMB = forum.getFirst_class();
                nVar.dkW().advertAppContext.dMC = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dkW().advertAppContext.dMD = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dkW().advertAppContext.extensionInfo = nVar.dkW().ext_info;
            nVar.dkW().advertAppContext.Xw = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.hKL != null && this.hKL.getAdapter() != null) {
            this.hKL.getListAdapter().notifyDataSetChanged();
        }
    }

    public void cTN() {
        if (this.kHj != null) {
            this.kHj.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BJ(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.kHh.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.kHh.cNt(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BL(final int i) {
        ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: aTq */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(a.this.kHh.getContext(), a.this.cMO(), i2, a.this.kHh.cLP());
            }
        }, new l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.kHh.getContext(), i, shareItem, false));
            }
        });
        ap apVar = new ap("c13833");
        apVar.ah("obj_locate", 1);
        if (i == 3) {
            apVar.ah("obj_type", 1);
        } else if (i == 8) {
            apVar.ah("obj_type", 2);
        }
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cMO() {
        if (this.kli == null || this.kli.cKx() == null) {
            return -1;
        }
        return this.kli.cKx().aWY();
    }
}
