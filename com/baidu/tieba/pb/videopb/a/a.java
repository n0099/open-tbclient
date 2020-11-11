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
    private BdTypeRecyclerView iNq;
    private com.baidu.adp.widget.ListView.a jFt;
    private DetailInfoFragment lNl;
    private List<q> lNm;
    private d lNn;
    private com.baidu.tieba.pb.pb.main.adapter.c lNo;
    private c lNp;
    private h lNq;
    private ab lNr;
    private f lqP;
    private com.baidu.tieba.pb.pb.main.adapter.d lqg;
    private com.baidu.adp.widget.ListView.a lqn;
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private View.OnClickListener lNs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.FQ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.FS(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.FQ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.FS(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lNl = detailInfoFragment;
        this.iNq = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lNn = new d(detailInfoFragment.dld(), PostData.mWQ);
        this.lNo = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.dld(), o.lot);
        this.lNo.setOnClickListener(this.lNs);
        this.lNp = new c(detailInfoFragment.getContext(), s.TYPE);
        this.lqg = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lNq = new h(detailInfoFragment.dld(), n.ezO);
        this.lNq.ud(true);
        this.lNr = new ab(detailInfoFragment.dld());
        this.bky.add(this.lNn);
        this.bky.add(this.lNo);
        this.bky.add(this.lNp);
        this.bky.add(this.lqg);
        this.bky.add(this.lNq);
        this.bky.add(this.lNr);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bky);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.jFt = r.dAo().a(detailInfoFragment.dld().getBaseFragmentActivity(), AdvertAppInfo.eyC);
        this.lqn = r.dAo().a(detailInfoFragment.dld().getBaseFragmentActivity(), AdvertAppInfo.eyG);
        this.bky.add(this.jFt);
        this.bky.add(this.lqn);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lqP = fVar;
            if (this.iNq != null) {
                this.iNq.setVisibility(0);
            }
            this.lNn.setPbData(fVar);
            this.lNq.setPbData(fVar);
            this.lNr.setPbData(fVar);
            this.iNq.setData(M(fVar));
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
        this.lNm = new ArrayList();
        Iterator<PostData> it = fVar.dim().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dJZ() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dit() != null) {
            postData = fVar.dit();
        }
        if (postData != null) {
            this.lNm.add(postData);
        }
        o oVar = new o(fVar.dik(), fVar.getAnti());
        oVar.tS(true);
        oVar.lov = true;
        this.lNm.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lNl.djz().djr()) || !this.lNl.djz().dlA())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.lNl.djz().dlx();
            hVar.lnQ = true;
            this.lNm.add(hVar);
            oVar.tS(false);
            oVar.lov = false;
        }
        List<com.baidu.tieba.tbadkCore.data.n> diR = fVar.diR();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(diR)) {
            i = -1;
            nVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(diR, 0);
            if (nVar3 == null) {
                nVar = nVar3;
                i = -1;
            } else {
                nVar = nVar3;
                i = nVar3.getPosition();
            }
        }
        if (fVar.diM() != null) {
            int i7 = i;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
            int i9 = 1;
            for (n nVar5 : fVar.diM()) {
                if (diR == null || i9 != i7) {
                    int i10 = i9;
                    i2 = i7;
                    i3 = i8;
                    nVar2 = nVar4;
                    i4 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        com.baidu.tieba.lego.card.d.a.a(this.lNm, nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.eyC) {
                            i5 = i8;
                            i6 = i9 + 1;
                            if (i5 >= diR.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = (com.baidu.tieba.tbadkCore.data.n) com.baidu.tieba.lego.card.d.a.l(diR, i5);
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
                    if (i5 >= diR.size()) {
                    }
                }
                com.baidu.tieba.lego.card.d.a.a(this.lNm, nVar5);
                int i12 = i4 + 1;
                if (i12 == 4 && fVar.diq() != null) {
                    com.baidu.tieba.lego.card.d.a.a(this.lNm, fVar.diq());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i3;
                i7 = i2;
                i9 = i12;
            }
        }
        return this.lNm;
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lqP != null && nVar.dJN() != null) {
            nVar.dJN().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.lqP.getPage() != null) {
                nVar.dJN().advertAppContext.pn = this.lqP.getPage().blo();
            }
            nVar.dJN().advertAppContext.page = nVar.dJQ();
            if (this.lqP.getForum() != null && (forum = this.lqP.getForum()) != null) {
                nVar.dJN().advertAppContext.fid = forum.getId();
                nVar.dJN().advertAppContext.eyt = forum.getFirst_class();
                nVar.dJN().advertAppContext.eyu = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dJN().advertAppContext.eyv = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dJN().advertAppContext.extensionInfo = nVar.dJN().ext_info;
            nVar.dJN().advertAppContext.YN = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.iNq != null && this.iNq.getAdapter() != null) {
            this.iNq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void drD() {
        if (this.lNn != null) {
            this.lNn.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FQ(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.lNl.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lNl.dle(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS(final int i) {
        ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bjC */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(a.this.lNl.getContext(), a.this.dky(), i2, a.this.lNl.djz());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.lNl.getContext(), i, shareItem, false));
            }
        });
        aq aqVar = new aq("c13833");
        aqVar.al("obj_locate", 1);
        if (i == 3) {
            aqVar.al("obj_type", 1);
        } else if (i == 8) {
            aqVar.al("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dky() {
        if (this.lqP == null || this.lqP.dik() == null) {
            return -1;
        }
        return this.lqP.dik().bnn();
    }
}
