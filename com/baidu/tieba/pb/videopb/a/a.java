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
    private BdTypeRecyclerView iuX;
    private com.baidu.adp.widget.ListView.a jmW;
    private com.baidu.tieba.pb.pb.main.adapter.d kXG;
    private com.baidu.adp.widget.ListView.a kXN;
    private f kYp;
    private DetailInfoFragment luR;
    private List<q> luS;
    private d luT;
    private com.baidu.tieba.pb.pb.main.adapter.c luU;
    private c luV;
    private h luW;
    private ab luX;
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private View.OnClickListener luY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.Fk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.Fm(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.Fk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.Fm(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.luR = detailInfoFragment;
        this.iuX = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.luT = new d(detailInfoFragment.dfu(), PostData.mEg);
        this.luU = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.dfu(), o.kVU);
        this.luU.setOnClickListener(this.luY);
        this.luV = new c(detailInfoFragment.getContext(), s.TYPE);
        this.kXG = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.luW = new h(detailInfoFragment.dfu(), n.elv);
        this.luW.tD(true);
        this.luX = new ab(detailInfoFragment.dfu());
        this.bhH.add(this.luT);
        this.bhH.add(this.luU);
        this.bhH.add(this.luV);
        this.bhH.add(this.kXG);
        this.bhH.add(this.luW);
        this.bhH.add(this.luX);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bhH);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.jmW = r.duF().a(detailInfoFragment.dfu().getBaseFragmentActivity(), AdvertAppInfo.ekj);
        this.kXN = r.duF().a(detailInfoFragment.dfu().getBaseFragmentActivity(), AdvertAppInfo.ekn);
        this.bhH.add(this.jmW);
        this.bhH.add(this.kXN);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.kYp = fVar;
            if (this.iuX != null) {
                this.iuX.setVisibility(0);
            }
            this.luT.setPbData(fVar);
            this.luW.setPbData(fVar);
            this.luX.setPbData(fVar);
            this.iuX.setData(M(fVar));
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
        this.luS = new ArrayList();
        Iterator<PostData> it = fVar.dcC().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dEp() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dcJ() != null) {
            postData = fVar.dcJ();
        }
        if (postData != null) {
            this.luS.add(postData);
        }
        o oVar = new o(fVar.dcA(), fVar.getAnti());
        oVar.ts(true);
        oVar.kVW = true;
        this.luS.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.luR.ddQ().ddH()) || !this.luR.ddQ().dfR())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.luR.ddQ().dfO();
            hVar.kVu = true;
            this.luS.add(hVar);
            oVar.ts(false);
            oVar.kVW = false;
        }
        List<com.baidu.tieba.tbadkCore.data.n> ddh = fVar.ddh();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(ddh)) {
            i = -1;
            nVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(ddh, 0);
            if (nVar3 == null) {
                nVar = nVar3;
                i = -1;
            } else {
                nVar = nVar3;
                i = nVar3.getPosition();
            }
        }
        if (fVar.ddc() != null) {
            int i7 = i;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
            int i9 = 1;
            for (n nVar5 : fVar.ddc()) {
                if (ddh == null || i9 != i7) {
                    int i10 = i9;
                    i2 = i7;
                    i3 = i8;
                    nVar2 = nVar4;
                    i4 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        com.baidu.tieba.lego.card.d.a.a(this.luS, nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.ekj) {
                            i5 = i8;
                            i6 = i9 + 1;
                            if (i5 >= ddh.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(ddh, i5);
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
                    if (i5 >= ddh.size()) {
                    }
                }
                com.baidu.tieba.lego.card.d.a.a(this.luS, nVar5);
                int i12 = i4 + 1;
                if (i12 == 4 && fVar.dcG() != null) {
                    com.baidu.tieba.lego.card.d.a.a(this.luS, fVar.dcG());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i3;
                i7 = i2;
                i9 = i12;
            }
        }
        return this.luS;
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kYp != null && nVar.dEd() != null) {
            nVar.dEd().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kYp.getPage() != null) {
                nVar.dEd().advertAppContext.pn = this.kYp.getPage().bgV();
            }
            nVar.dEd().advertAppContext.page = nVar.dEg();
            if (this.kYp.getForum() != null && (forum = this.kYp.getForum()) != null) {
                nVar.dEd().advertAppContext.fid = forum.getId();
                nVar.dEd().advertAppContext.eka = forum.getFirst_class();
                nVar.dEd().advertAppContext.ekb = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dEd().advertAppContext.ekc = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dEd().advertAppContext.extensionInfo = nVar.dEd().ext_info;
            nVar.dEd().advertAppContext.YM = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.iuX != null && this.iuX.getAdapter() != null) {
            this.iuX.getListAdapter().notifyDataSetChanged();
        }
    }

    public void dlT() {
        if (this.luT != null) {
            this.luT.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fk(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.luR.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.luR.dfv(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm(final int i) {
        ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bfj */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(a.this.luR.getContext(), a.this.deP(), i2, a.this.luR.ddQ());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.luR.getContext(), i, shareItem, false));
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
    public int deP() {
        if (this.kYp == null || this.kYp.dcA() == null) {
            return -1;
        }
        return this.kYp.dcA().biU();
    }
}
