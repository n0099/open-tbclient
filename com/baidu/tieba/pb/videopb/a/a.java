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
import com.baidu.tbadk.core.util.aq;
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
    private BdTypeRecyclerView hYQ;
    private com.baidu.adp.widget.ListView.a iPl;
    private f kAA;
    private DetailInfoFragment kWO;
    private List<q> kWP;
    private d kWQ;
    private com.baidu.tieba.pb.pb.main.adapter.c kWR;
    private c kWS;
    private h kWT;
    private ab kWU;
    private com.baidu.tieba.pb.pb.main.adapter.d kzR;
    private com.baidu.adp.widget.ListView.a kzY;
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private View.OnClickListener kWV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.Ef(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.Ef(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kWO = detailInfoFragment;
        this.hYQ = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kWQ = new d(detailInfoFragment.cYh(), PostData.meM);
        this.kWR = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cYh(), o.kyf);
        this.kWR.setOnClickListener(this.kWV);
        this.kWS = new c(detailInfoFragment.getContext(), s.TYPE);
        this.kzR = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kWT = new h(detailInfoFragment.cYh(), n.dXf);
        this.kWT.sN(true);
        this.kWU = new ab(detailInfoFragment.cYh());
        this.bbu.add(this.kWQ);
        this.bbu.add(this.kWR);
        this.bbu.add(this.kWS);
        this.bbu.add(this.kzR);
        this.bbu.add(this.kWT);
        this.bbu.add(this.kWU);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bbu);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.iPl = r.dnh().a(detailInfoFragment.cYh().getBaseFragmentActivity(), AdvertAppInfo.dVT);
        this.kzY = r.dnh().a(detailInfoFragment.cYh().getBaseFragmentActivity(), AdvertAppInfo.dVX);
        this.bbu.add(this.iPl);
        this.bbu.add(this.kzY);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.kAA = fVar;
            if (this.hYQ != null) {
                this.hYQ.setVisibility(0);
            }
            this.kWQ.setPbData(fVar);
            this.kWT.setPbData(fVar);
            this.kWU.setPbData(fVar);
            this.hYQ.setData(M(fVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<q> M(f fVar) {
        PostData postData;
        int i;
        com.baidu.tieba.tbadkCore.data.n nVar;
        int i2;
        int i3;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        int i4;
        int i5;
        int i6;
        if (fVar == null) {
            return null;
        }
        this.kWP = new ArrayList();
        Iterator<PostData> it = fVar.cVn().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dwF() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.cVu() != null) {
            postData = fVar.cVu();
        }
        if (postData != null) {
            this.kWP.add(postData);
        }
        o oVar = new o(fVar.cVl(), fVar.getAnti());
        oVar.sC(true);
        oVar.kyh = true;
        this.kWP.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kWO.cWD().cWu()) || !this.kWO.cWD().cYE())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.kWO.cWD().cYB();
            hVar.kxE = true;
            this.kWP.add(hVar);
            oVar.sC(false);
            oVar.kyh = false;
        }
        List<com.baidu.tieba.tbadkCore.data.n> cVS = fVar.cVS();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(cVS)) {
            i = -1;
            nVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(cVS, 0);
            if (nVar3 == null) {
                nVar = nVar3;
                i = -1;
            } else {
                nVar = nVar3;
                i = nVar3.getPosition();
            }
        }
        if (fVar.cVN() != null) {
            int i7 = i;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
            int i9 = 1;
            for (n nVar5 : fVar.cVN()) {
                if (cVS == null || i9 != i7) {
                    int i10 = i9;
                    i2 = i7;
                    i3 = i8;
                    nVar2 = nVar4;
                    i4 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        com.baidu.tieba.lego.card.d.a.a(this.kWP, nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.dVT) {
                            i5 = i8;
                            i6 = i9 + 1;
                            if (i5 >= cVS.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(cVS, i5);
                                if (nVar6 != null) {
                                    i4 = i6;
                                    nVar2 = nVar6;
                                    i2 = nVar6.getPosition();
                                    i3 = i5;
                                } else {
                                    i4 = i6;
                                    nVar2 = nVar6;
                                    i2 = i7;
                                    i3 = i5;
                                }
                            } else {
                                i2 = i7;
                                i3 = i5;
                                int i11 = i6;
                                nVar2 = nVar4;
                                i4 = i11;
                            }
                        }
                    }
                    i5 = i8;
                    i6 = i9;
                    if (i5 >= cVS.size()) {
                    }
                }
                com.baidu.tieba.lego.card.d.a.a(this.kWP, nVar5);
                int i12 = i4 + 1;
                if (i12 == 4 && fVar.cVr() != null) {
                    com.baidu.tieba.lego.card.d.a.a(this.kWP, fVar.cVr());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i3;
                i7 = i2;
                i9 = i12;
            }
        }
        return this.kWP;
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kAA != null && nVar.dwt() != null) {
            nVar.dwt().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kAA.getPage() != null) {
                nVar.dwt().advertAppContext.pn = this.kAA.getPage().bds();
            }
            nVar.dwt().advertAppContext.page = nVar.dww();
            if (this.kAA.getForum() != null && (forum = this.kAA.getForum()) != null) {
                nVar.dwt().advertAppContext.fid = forum.getId();
                nVar.dwt().advertAppContext.dVK = forum.getFirst_class();
                nVar.dwt().advertAppContext.dVL = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dwt().advertAppContext.dVM = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dwt().advertAppContext.extensionInfo = nVar.dwt().ext_info;
            nVar.dwt().advertAppContext.Yb = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.hYQ != null && this.hYQ.getAdapter() != null) {
            this.hYQ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void deF() {
        if (this.kWQ != null) {
            this.kWQ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ed(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.kWO.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.kWO.cYi(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ef(final int i) {
        ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bbH */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(a.this.kWO.getContext(), a.this.cXC(), i2, a.this.kWO.cWD());
            }
        }, new l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.kWO.getContext(), i, shareItem, false));
            }
        });
        aq aqVar = new aq("c13833");
        aqVar.ai("obj_locate", 1);
        if (i == 3) {
            aqVar.ai("obj_type", 1);
        } else if (i == 8) {
            aqVar.ai("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cXC() {
        if (this.kAA == null || this.kAA.cVl() == null) {
            return -1;
        }
        return this.kAA.cVl().bfr();
    }
}
