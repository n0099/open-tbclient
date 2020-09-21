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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
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
/* loaded from: classes21.dex */
public class a {
    private com.baidu.adp.widget.ListView.a iXX;
    private BdTypeRecyclerView iga;
    private com.baidu.adp.widget.ListView.a kIC;
    private com.baidu.tieba.pb.pb.main.adapter.d kIv;
    private f kJe;
    private DetailInfoFragment lfA;
    private List<q> lfB;
    private d lfC;
    private com.baidu.tieba.pb.pb.main.adapter.c lfD;
    private c lfE;
    private h lfF;
    private ab lfG;
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private View.OnClickListener lfH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.EE(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.EG(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.EE(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.EG(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lfA = detailInfoFragment;
        this.iga = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lfC = new d(detailInfoFragment.dbL(), PostData.moA);
        this.lfD = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.dbL(), o.kGJ);
        this.lfD.setOnClickListener(this.lfH);
        this.lfE = new c(detailInfoFragment.getContext(), s.TYPE);
        this.kIv = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lfF = new h(detailInfoFragment.dbL(), n.dZt);
        this.lfF.sW(true);
        this.lfG = new ab(detailInfoFragment.dbL());
        this.bdV.add(this.lfC);
        this.bdV.add(this.lfD);
        this.bdV.add(this.lfE);
        this.bdV.add(this.kIv);
        this.bdV.add(this.lfF);
        this.bdV.add(this.lfG);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bdV);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.iXX = r.dqU().a(detailInfoFragment.dbL().getBaseFragmentActivity(), AdvertAppInfo.dYh);
        this.kIC = r.dqU().a(detailInfoFragment.dbL().getBaseFragmentActivity(), AdvertAppInfo.dYl);
        this.bdV.add(this.iXX);
        this.bdV.add(this.kIC);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.kJe = fVar;
            if (this.iga != null) {
                this.iga.setVisibility(0);
            }
            this.lfC.setPbData(fVar);
            this.lfF.setPbData(fVar);
            this.lfG.setPbData(fVar);
            this.iga.setData(M(fVar));
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
        this.lfB = new ArrayList();
        Iterator<PostData> it = fVar.cYT().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dAD() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.cZa() != null) {
            postData = fVar.cZa();
        }
        if (postData != null) {
            this.lfB.add(postData);
        }
        o oVar = new o(fVar.cYR(), fVar.getAnti());
        oVar.sL(true);
        oVar.kGL = true;
        this.lfB.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lfA.dah().cZY()) || !this.lfA.dah().dci())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.lfA.dah().dcf();
            hVar.kGj = true;
            this.lfB.add(hVar);
            oVar.sL(false);
            oVar.kGL = false;
        }
        List<com.baidu.tieba.tbadkCore.data.n> cZy = fVar.cZy();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(cZy)) {
            i = -1;
            nVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(cZy, 0);
            if (nVar3 == null) {
                nVar = nVar3;
                i = -1;
            } else {
                nVar = nVar3;
                i = nVar3.getPosition();
            }
        }
        if (fVar.cZt() != null) {
            int i7 = i;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
            int i9 = 1;
            for (n nVar5 : fVar.cZt()) {
                if (cZy == null || i9 != i7) {
                    int i10 = i9;
                    i2 = i7;
                    i3 = i8;
                    nVar2 = nVar4;
                    i4 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        com.baidu.tieba.lego.card.d.a.a(this.lfB, nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.dYh) {
                            i5 = i8;
                            i6 = i9 + 1;
                            if (i5 >= cZy.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(cZy, i5);
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
                    if (i5 >= cZy.size()) {
                    }
                }
                com.baidu.tieba.lego.card.d.a.a(this.lfB, nVar5);
                int i12 = i4 + 1;
                if (i12 == 4 && fVar.cYX() != null) {
                    com.baidu.tieba.lego.card.d.a.a(this.lfB, fVar.cYX());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i3;
                i7 = i2;
                i9 = i12;
            }
        }
        return this.lfB;
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kJe != null && nVar.dAr() != null) {
            nVar.dAr().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kJe.getPage() != null) {
                nVar.dAr().advertAppContext.pn = this.kJe.getPage().bem();
            }
            nVar.dAr().advertAppContext.page = nVar.dAu();
            if (this.kJe.getForum() != null && (forum = this.kJe.getForum()) != null) {
                nVar.dAr().advertAppContext.fid = forum.getId();
                nVar.dAr().advertAppContext.dXY = forum.getFirst_class();
                nVar.dAr().advertAppContext.dXZ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dAr().advertAppContext.dYa = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dAr().advertAppContext.extensionInfo = nVar.dAr().ext_info;
            nVar.dAr().advertAppContext.Yw = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.iga != null && this.iga.getAdapter() != null) {
            this.iga.getListAdapter().notifyDataSetChanged();
        }
    }

    public void dik() {
        if (this.lfC != null) {
            this.lfC.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean EE(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.lfA.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lfA.dbM(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG(final int i) {
        ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bcB */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(a.this.lfA.getContext(), a.this.dbg(), i2, a.this.lfA.dah());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.lfA.getContext(), i, shareItem, false));
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
    public int dbg() {
        if (this.kJe == null || this.kJe.cYR() == null) {
            return -1;
        }
        return this.kJe.cYR().bgl();
    }
}
