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
    private BdTypeRecyclerView iYU;
    private com.baidu.adp.widget.ListView.a jTV;
    private f lEN;
    private com.baidu.tieba.pb.pb.main.adapter.d lEe;
    private com.baidu.adp.widget.ListView.a lEl;
    private DetailInfoFragment mbF;
    private List<q> mbG;
    private e mbH;
    private com.baidu.tieba.pb.pb.main.adapter.c mbI;
    private c mbJ;
    private h mbK;
    private ab mbL;
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private View.OnClickListener mbM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
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
        this.mbF = detailInfoFragment;
        this.iYU = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mbH = new e(detailInfoFragment.dpP(), PostData.nlG);
        this.mbI = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.dpP(), o.lCh);
        this.mbI.setOnClickListener(this.mbM);
        this.mbJ = new c(detailInfoFragment.getContext(), s.TYPE);
        this.lEe = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mbK = new h(detailInfoFragment.dpP(), com.baidu.tbadk.core.data.o.eFe);
        this.mbK.uI(true);
        this.mbL = new ab(detailInfoFragment.dpP());
        this.bnf.add(this.mbH);
        this.bnf.add(this.mbI);
        this.bnf.add(this.mbJ);
        this.bnf.add(this.lEe);
        this.bnf.add(this.mbK);
        this.bnf.add(this.mbL);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bnf);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.jTV = r.dFf().a(detailInfoFragment.dpP().getBaseFragmentActivity(), AdvertAppInfo.eDR);
        this.lEl = r.dFf().a(detailInfoFragment.dpP().getBaseFragmentActivity(), AdvertAppInfo.eDV);
        this.bnf.add(this.jTV);
        this.bnf.add(this.lEl);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lEN = fVar;
            if (this.iYU != null) {
                this.iYU.setVisibility(0);
            }
            this.mbH.setPbData(fVar);
            this.mbK.setPbData(fVar);
            this.mbL.setPbData(fVar);
            this.iYU.setData(P(fVar));
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
        this.mbG = new ArrayList();
        Iterator<PostData> it = fVar.dmV().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dPg() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dnc() != null) {
            postData = fVar.dnc();
        }
        if (postData != null) {
            this.mbG.add(postData);
        }
        o oVar = new o(fVar.dmT(), fVar.getAnti());
        oVar.ux(true);
        oVar.lCj = true;
        this.mbG.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mbF.dok().dod()) || !this.mbF.dok().dqm())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.mbF.dok().dqj();
            hVar.lBG = true;
            this.mbG.add(hVar);
            oVar.ux(false);
            oVar.lCj = false;
        }
        List<n> dnB = fVar.dnB();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(dnB)) {
            i = -1;
            nVar = null;
        } else {
            n nVar3 = (n) com.baidu.tieba.lego.card.d.a.l(dnB, 0);
            if (nVar3 == null) {
                nVar = nVar3;
                i = -1;
            } else {
                nVar = nVar3;
                i = nVar3.getPosition();
            }
        }
        if (fVar.dnw() != null) {
            int i7 = i;
            int i8 = 0;
            n nVar4 = nVar;
            int i9 = 1;
            for (com.baidu.tbadk.core.data.o oVar2 : fVar.dnw()) {
                if (dnB == null || i9 != i7) {
                    int i10 = i9;
                    i2 = i7;
                    i3 = i8;
                    nVar2 = nVar4;
                    i4 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        com.baidu.tieba.lego.card.d.a.a(this.mbG, nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.eDR) {
                            i5 = i8;
                            i6 = i9 + 1;
                            if (i5 >= dnB.size()) {
                                n nVar5 = (n) com.baidu.tieba.lego.card.d.a.l(dnB, i5);
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
                    if (i5 >= dnB.size()) {
                    }
                }
                com.baidu.tieba.lego.card.d.a.a(this.mbG, oVar2);
                int i12 = i4 + 1;
                if (i12 == 4 && fVar.dmZ() != null) {
                    com.baidu.tieba.lego.card.d.a.a(this.mbG, fVar.dmZ());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i3;
                i7 = i2;
                i9 = i12;
            }
        }
        return this.mbG;
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.lEN != null && nVar.dOU() != null) {
            nVar.dOU().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lEN.getPage() != null) {
                nVar.dOU().advertAppContext.pn = this.lEN.getPage().bnD();
            }
            nVar.dOU().advertAppContext.page = nVar.dOX();
            if (this.lEN.getForum() != null && (forum = this.lEN.getForum()) != null) {
                nVar.dOU().advertAppContext.fid = forum.getId();
                nVar.dOU().advertAppContext.eDI = forum.getFirst_class();
                nVar.dOU().advertAppContext.eDJ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dOU().advertAppContext.eDK = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dOU().advertAppContext.extensionInfo = nVar.dOU().ext_info;
            nVar.dOU().advertAppContext.ZP = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.iYU != null && this.iYU.getAdapter() != null) {
            this.iYU.getListAdapter().notifyDataSetChanged();
        }
    }

    public void dww() {
        if (this.mbH != null) {
            this.mbH.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean He(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mbF.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mbF.dpQ(), true, i)));
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
                return com.baidu.tieba.pb.pb.main.d.b.a(a.this.mbF.getContext(), a.this.dpk(), i2, a.this.mbF.dok());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.mbF.getContext(), i, shareItem, false));
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
    public int dpk() {
        if (this.lEN == null || this.lEN.dmT() == null) {
            return -1;
        }
        return this.lEN.dmT().bpC();
    }
}
