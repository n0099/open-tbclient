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
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView iHt;
    private com.baidu.adp.widget.ListView.a jzw;
    private DetailInfoFragment lHp;
    private List<q> lHq;
    private d lHr;
    private com.baidu.tieba.pb.pb.main.adapter.c lHs;
    private c lHt;
    private h lHu;
    private ab lHv;
    private f lkO;
    private com.baidu.tieba.pb.pb.main.adapter.d lkf;
    private com.baidu.adp.widget.ListView.a lkm;
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private View.OnClickListener lHw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.FD(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.FF(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.FD(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.FF(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lHp = detailInfoFragment;
        this.iHt = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lHr = new d(detailInfoFragment.diB(), PostData.mQM);
        this.lHs = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.diB(), o.lit);
        this.lHs.setOnClickListener(this.lHw);
        this.lHt = new c(detailInfoFragment.getContext(), s.TYPE);
        this.lkf = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lHu = new h(detailInfoFragment.diB(), n.etV);
        this.lHu.tU(true);
        this.lHv = new ab(detailInfoFragment.diB());
        this.bje.add(this.lHr);
        this.bje.add(this.lHs);
        this.bje.add(this.lHt);
        this.bje.add(this.lkf);
        this.bje.add(this.lHu);
        this.bje.add(this.lHv);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bje);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.jzw = r.dxM().a(detailInfoFragment.diB().getBaseFragmentActivity(), AdvertAppInfo.esI);
        this.lkm = r.dxM().a(detailInfoFragment.diB().getBaseFragmentActivity(), AdvertAppInfo.esM);
        this.bje.add(this.jzw);
        this.bje.add(this.lkm);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lkO = fVar;
            if (this.iHt != null) {
                this.iHt.setVisibility(0);
            }
            this.lHr.setPbData(fVar);
            this.lHu.setPbData(fVar);
            this.lHv.setPbData(fVar);
            this.iHt.setData(M(fVar));
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
        this.lHq = new ArrayList();
        Iterator<PostData> it = fVar.dfK().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dHx() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dfR() != null) {
            postData = fVar.dfR();
        }
        if (postData != null) {
            this.lHq.add(postData);
        }
        o oVar = new o(fVar.dfI(), fVar.getAnti());
        oVar.tJ(true);
        oVar.liv = true;
        this.lHq.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lHp.dgX().dgP()) || !this.lHp.dgX().diY())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.lHp.dgX().diV();
            hVar.lhT = true;
            this.lHq.add(hVar);
            oVar.tJ(false);
            oVar.liv = false;
        }
        List<com.baidu.tieba.tbadkCore.data.n> dgp = fVar.dgp();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(dgp)) {
            i = -1;
            nVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(dgp, 0);
            if (nVar3 == null) {
                nVar = nVar3;
                i = -1;
            } else {
                nVar = nVar3;
                i = nVar3.getPosition();
            }
        }
        if (fVar.dgk() != null) {
            int i7 = i;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
            int i9 = 1;
            for (n nVar5 : fVar.dgk()) {
                if (dgp == null || i9 != i7) {
                    int i10 = i9;
                    i2 = i7;
                    i3 = i8;
                    nVar2 = nVar4;
                    i4 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        com.baidu.tieba.lego.card.d.a.a(this.lHq, nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.esI) {
                            i5 = i8;
                            i6 = i9 + 1;
                            if (i5 >= dgp.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(dgp, i5);
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
                    if (i5 >= dgp.size()) {
                    }
                }
                com.baidu.tieba.lego.card.d.a.a(this.lHq, nVar5);
                int i12 = i4 + 1;
                if (i12 == 4 && fVar.dfO() != null) {
                    com.baidu.tieba.lego.card.d.a.a(this.lHq, fVar.dfO());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i3;
                i7 = i2;
                i9 = i12;
            }
        }
        return this.lHq;
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lkO != null && nVar.dHl() != null) {
            nVar.dHl().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.lkO.getPage() != null) {
                nVar.dHl().advertAppContext.pn = this.lkO.getPage().biO();
            }
            nVar.dHl().advertAppContext.page = nVar.dHo();
            if (this.lkO.getForum() != null && (forum = this.lkO.getForum()) != null) {
                nVar.dHl().advertAppContext.fid = forum.getId();
                nVar.dHl().advertAppContext.esz = forum.getFirst_class();
                nVar.dHl().advertAppContext.esA = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dHl().advertAppContext.esB = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dHl().advertAppContext.extensionInfo = nVar.dHl().ext_info;
            nVar.dHl().advertAppContext.YN = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.iHt != null && this.iHt.getAdapter() != null) {
            this.iHt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void dpb() {
        if (this.lHr != null) {
            this.lHr.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FD(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.lHp.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lHp.diC(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FF(final int i) {
        ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bhc */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(a.this.lHp.getContext(), a.this.dhW(), i2, a.this.lHp.dgX());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.lHp.getContext(), i, shareItem, false));
            }
        });
        aq aqVar = new aq("c13833");
        aqVar.aj("obj_locate", 1);
        if (i == 3) {
            aqVar.aj("obj_type", 1);
        } else if (i == 8) {
            aqVar.aj("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dhW() {
        if (this.lkO == null || this.lkO.dfI() == null) {
            return -1;
        }
        return this.lkO.dfI().bkN();
    }
}
