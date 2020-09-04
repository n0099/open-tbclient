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
    private BdTypeRecyclerView hYW;
    private com.baidu.adp.widget.ListView.a iPr;
    private f kAH;
    private com.baidu.adp.widget.ListView.a kAf;
    private DetailInfoFragment kWV;
    private List<q> kWW;
    private d kWX;
    private com.baidu.tieba.pb.pb.main.adapter.c kWY;
    private c kWZ;
    private h kXa;
    private ab kXb;
    private com.baidu.tieba.pb.pb.main.adapter.d kzY;
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private View.OnClickListener kXc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
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
        this.kWV = detailInfoFragment;
        this.hYW = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kWX = new d(detailInfoFragment.cYi(), PostData.mfb);
        this.kWY = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cYi(), o.kym);
        this.kWY.setOnClickListener(this.kXc);
        this.kWZ = new c(detailInfoFragment.getContext(), s.TYPE);
        this.kzY = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kXa = new h(detailInfoFragment.cYi(), n.dXj);
        this.kXa.sP(true);
        this.kXb = new ab(detailInfoFragment.cYi());
        this.bbw.add(this.kWX);
        this.bbw.add(this.kWY);
        this.bbw.add(this.kWZ);
        this.bbw.add(this.kzY);
        this.bbw.add(this.kXa);
        this.bbw.add(this.kXb);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bbw);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.iPr = r.dnk().a(detailInfoFragment.cYi().getBaseFragmentActivity(), AdvertAppInfo.dVX);
        this.kAf = r.dnk().a(detailInfoFragment.cYi().getBaseFragmentActivity(), AdvertAppInfo.dWb);
        this.bbw.add(this.iPr);
        this.bbw.add(this.kAf);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.kAH = fVar;
            if (this.hYW != null) {
                this.hYW.setVisibility(0);
            }
            this.kWX.setPbData(fVar);
            this.kXa.setPbData(fVar);
            this.kXb.setPbData(fVar);
            this.hYW.setData(M(fVar));
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
        this.kWW = new ArrayList();
        Iterator<PostData> it = fVar.cVo().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dwK() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.cVv() != null) {
            postData = fVar.cVv();
        }
        if (postData != null) {
            this.kWW.add(postData);
        }
        o oVar = new o(fVar.cVm(), fVar.getAnti());
        oVar.sE(true);
        oVar.kyo = true;
        this.kWW.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kWV.cWE().cWv()) || !this.kWV.cWE().cYF())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.kWV.cWE().cYC();
            hVar.kxL = true;
            this.kWW.add(hVar);
            oVar.sE(false);
            oVar.kyo = false;
        }
        List<com.baidu.tieba.tbadkCore.data.n> cVT = fVar.cVT();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(cVT)) {
            i = -1;
            nVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(cVT, 0);
            if (nVar3 == null) {
                nVar = nVar3;
                i = -1;
            } else {
                nVar = nVar3;
                i = nVar3.getPosition();
            }
        }
        if (fVar.cVO() != null) {
            int i7 = i;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
            int i9 = 1;
            for (n nVar5 : fVar.cVO()) {
                if (cVT == null || i9 != i7) {
                    int i10 = i9;
                    i2 = i7;
                    i3 = i8;
                    nVar2 = nVar4;
                    i4 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        com.baidu.tieba.lego.card.d.a.a(this.kWW, nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.dVX) {
                            i5 = i8;
                            i6 = i9 + 1;
                            if (i5 >= cVT.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(cVT, i5);
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
                    if (i5 >= cVT.size()) {
                    }
                }
                com.baidu.tieba.lego.card.d.a.a(this.kWW, nVar5);
                int i12 = i4 + 1;
                if (i12 == 4 && fVar.cVs() != null) {
                    com.baidu.tieba.lego.card.d.a.a(this.kWW, fVar.cVs());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i3;
                i7 = i2;
                i9 = i12;
            }
        }
        return this.kWW;
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kAH != null && nVar.dwy() != null) {
            nVar.dwy().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kAH.getPage() != null) {
                nVar.dwy().advertAppContext.pn = this.kAH.getPage().bds();
            }
            nVar.dwy().advertAppContext.page = nVar.dwB();
            if (this.kAH.getForum() != null && (forum = this.kAH.getForum()) != null) {
                nVar.dwy().advertAppContext.fid = forum.getId();
                nVar.dwy().advertAppContext.dVO = forum.getFirst_class();
                nVar.dwy().advertAppContext.dVP = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dwy().advertAppContext.dVQ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dwy().advertAppContext.extensionInfo = nVar.dwy().ext_info;
            nVar.dwy().advertAppContext.Ye = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.hYW != null && this.hYW.getAdapter() != null) {
            this.hYW.getListAdapter().notifyDataSetChanged();
        }
    }

    public void deG() {
        if (this.kWX != null) {
            this.kWX.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ed(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.kWV.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.kWV.cYj(), true, i)));
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
                return com.baidu.tieba.pb.pb.main.d.a.a(a.this.kWV.getContext(), a.this.cXD(), i2, a.this.kWV.cWE());
            }
        }, new l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.kWV.getContext(), i, shareItem, false));
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
    public int cXD() {
        if (this.kAH == null || this.kAH.cVm() == null) {
            return -1;
        }
        return this.kAH.cVm().bfr();
    }
}
