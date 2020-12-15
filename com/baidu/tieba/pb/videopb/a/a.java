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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
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
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView iYW;
    private com.baidu.adp.widget.ListView.a jTX;
    private f lEP;
    private com.baidu.tieba.pb.pb.main.adapter.d lEg;
    private com.baidu.adp.widget.ListView.a lEn;
    private DetailInfoFragment mbH;
    private List<q> mbI;
    private e mbJ;
    private com.baidu.tieba.pb.pb.main.adapter.c mbK;
    private c mbL;
    private h mbM;
    private ab mbN;
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private View.OnClickListener mbO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.Hg(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.Hg(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mbH = detailInfoFragment;
        this.iYW = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mbJ = new e(detailInfoFragment.dpQ(), PostData.nlI);
        this.mbK = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.dpQ(), o.lCj);
        this.mbK.setOnClickListener(this.mbO);
        this.mbL = new c(detailInfoFragment.getContext(), s.TYPE);
        this.lEg = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mbM = new h(detailInfoFragment.dpQ(), com.baidu.tbadk.core.data.o.eFe);
        this.mbM.uI(true);
        this.mbN = new ab(detailInfoFragment.dpQ());
        this.bnf.add(this.mbJ);
        this.bnf.add(this.mbK);
        this.bnf.add(this.mbL);
        this.bnf.add(this.lEg);
        this.bnf.add(this.mbM);
        this.bnf.add(this.mbN);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bnf);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.jTX = r.dFg().a(detailInfoFragment.dpQ().getBaseFragmentActivity(), AdvertAppInfo.eDR);
        this.lEn = r.dFg().a(detailInfoFragment.dpQ().getBaseFragmentActivity(), AdvertAppInfo.eDV);
        this.bnf.add(this.jTX);
        this.bnf.add(this.lEn);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lEP = fVar;
            if (this.iYW != null) {
                this.iYW.setVisibility(0);
            }
            this.mbJ.setPbData(fVar);
            this.mbM.setPbData(fVar);
            this.mbN.setPbData(fVar);
            this.iYW.setData(P(fVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<q> P(f fVar) {
        PostData postData;
        int i;
        n nVar;
        int i2;
        int i3;
        n nVar2;
        int i4;
        int i5;
        int i6;
        if (fVar == null) {
            return null;
        }
        this.mbI = new ArrayList();
        Iterator<PostData> it = fVar.dmW().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dPh() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dnd() != null) {
            postData = fVar.dnd();
        }
        if (postData != null) {
            this.mbI.add(postData);
        }
        o oVar = new o(fVar.dmU(), fVar.getAnti());
        oVar.ux(true);
        oVar.lCl = true;
        this.mbI.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mbH.dol().doe()) || !this.mbH.dol().dqn())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.mbH.dol().dqk();
            hVar.lBI = true;
            this.mbI.add(hVar);
            oVar.ux(false);
            oVar.lCl = false;
        }
        List<n> dnC = fVar.dnC();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(dnC)) {
            i = -1;
            nVar = null;
        } else {
            n nVar3 = (n) com.baidu.tieba.lego.card.d.a.l(dnC, 0);
            if (nVar3 == null) {
                nVar = nVar3;
                i = -1;
            } else {
                nVar = nVar3;
                i = nVar3.getPosition();
            }
        }
        if (fVar.dnx() != null) {
            int i7 = i;
            int i8 = 0;
            n nVar4 = nVar;
            int i9 = 1;
            for (com.baidu.tbadk.core.data.o oVar2 : fVar.dnx()) {
                if (dnC == null || i9 != i7) {
                    int i10 = i9;
                    i2 = i7;
                    i3 = i8;
                    nVar2 = nVar4;
                    i4 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        com.baidu.tieba.lego.card.d.a.a(this.mbI, nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.eDR) {
                            i5 = i8;
                            i6 = i9 + 1;
                            if (i5 >= dnC.size()) {
                                n nVar5 = (n) com.baidu.tieba.lego.card.d.a.l(dnC, i5);
                                if (nVar5 != null) {
                                    i4 = i6;
                                    nVar2 = nVar5;
                                    i2 = nVar5.getPosition();
                                    i3 = i5;
                                } else {
                                    i4 = i6;
                                    nVar2 = nVar5;
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
                    if (i5 >= dnC.size()) {
                    }
                }
                com.baidu.tieba.lego.card.d.a.a(this.mbI, oVar2);
                int i12 = i4 + 1;
                if (i12 == 4 && fVar.dna() != null) {
                    com.baidu.tieba.lego.card.d.a.a(this.mbI, fVar.dna());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i3;
                i7 = i2;
                i9 = i12;
            }
        }
        return this.mbI;
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.lEP != null && nVar.dOV() != null) {
            nVar.dOV().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lEP.getPage() != null) {
                nVar.dOV().advertAppContext.pn = this.lEP.getPage().bnD();
            }
            nVar.dOV().advertAppContext.page = nVar.dOY();
            if (this.lEP.getForum() != null && (forum = this.lEP.getForum()) != null) {
                nVar.dOV().advertAppContext.fid = forum.getId();
                nVar.dOV().advertAppContext.eDI = forum.getFirst_class();
                nVar.dOV().advertAppContext.eDJ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dOV().advertAppContext.eDK = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dOV().advertAppContext.extensionInfo = nVar.dOV().ext_info;
            nVar.dOV().advertAppContext.ZP = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.iYW != null && this.iYW.getAdapter() != null) {
            this.iYW.getListAdapter().notifyDataSetChanged();
        }
    }

    public void dwx() {
        if (this.mbJ != null) {
            this.mbJ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean He(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mbH.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mbH.dpR(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg(final int i) {
        ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: blQ */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(a.this.mbH.getContext(), a.this.dpl(), i2, a.this.mbH.dol());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.mbH.getContext(), i, shareItem, false));
            }
        });
        ar arVar = new ar("c13833");
        arVar.al("obj_locate", 1);
        if (i == 3) {
            arVar.al("obj_type", 1);
        } else if (i == 8) {
            arVar.al("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dpl() {
        if (this.lEP == null || this.lEP.dmU() == null) {
            return -1;
        }
        return this.lEP.dmU().bpC();
    }
}
