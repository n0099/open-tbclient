package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.i;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.data.t;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView jmy;
    private com.baidu.adp.widget.ListView.a kla;
    private PbFirstFloorEnterForumAdapter lNQ;
    private PbFirstFloorItemAdapter lNR;
    private com.baidu.adp.widget.ListView.a lNY;
    private f lOF;
    private DetailInfoFragment mlD;
    private List<n> mlE;
    private e mlF;
    private PbFirstFloorCommentAndPraiseAdapter mlG;
    private c mlH;
    private h mlI;
    private w mlJ;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private View.OnClickListener mlK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.FM(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.FM(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mlD = detailInfoFragment;
        this.jmy = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mlF = new e(detailInfoFragment.dog(), PostData.nwX);
        this.mlG = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.dog(), p.lLM);
        this.mlG.setOnClickListener(this.mlK);
        this.mlH = new c(detailInfoFragment.getContext(), t.TYPE);
        this.lNQ = new PbFirstFloorEnterForumAdapter(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mlI = new h(detailInfoFragment.dog(), com.baidu.tbadk.core.data.p.eMv);
        this.mlI.uU(true);
        this.mlJ = new w(detailInfoFragment.dog());
        this.lNR = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), i.TYPE);
        this.bns.add(this.mlF);
        this.bns.add(this.mlG);
        this.bns.add(this.mlH);
        this.bns.add(this.lNQ);
        this.bns.add(this.mlI);
        this.bns.add(this.mlJ);
        this.bns.add(this.lNR);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bns);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.kla = s.dDt().a(detailInfoFragment.dog().getBaseFragmentActivity(), AdvertAppInfo.eLf);
        this.lNY = s.dDt().a(detailInfoFragment.dog().getBaseFragmentActivity(), AdvertAppInfo.eLj);
        this.bns.add(this.kla);
        this.bns.add(this.lNY);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lOF = fVar;
            if (this.jmy != null) {
                this.jmy.setVisibility(0);
            }
            this.mlF.setPbData(fVar);
            this.mlI.setPbData(fVar);
            this.mlJ.setPbData(fVar);
            this.jmy.setData(P(fVar));
        }
    }

    private List<n> P(f fVar) {
        PostData postData;
        boolean z;
        o oVar;
        int i;
        o oVar2;
        int i2;
        int i3 = 0;
        if (fVar == null) {
            return null;
        }
        this.mlE = new ArrayList();
        Iterator<PostData> it = fVar.dli().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dNF() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dlp() != null) {
            postData = fVar.dlp();
        }
        if (postData != null) {
            this.mlE.add(postData);
        }
        p pVar = new p(fVar.dlg(), fVar.getAnti());
        pVar.uH(true);
        pVar.lLO = true;
        this.mlE.add(pVar);
        if (postData == null || postData.nxY == null || (fVar.getForum() != null && TextUtils.equals(fVar.getForum().getName(), this.mlD.dmx().dmq()) && this.mlD.dmx().doD())) {
            z = false;
        } else {
            i iVar = new i(postData.nxY);
            iVar.tid = this.mlD.dmx().doA();
            this.mlE.add(iVar);
            z = true;
        }
        if (!z && fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mlD.dmx().dmq()) || !this.mlD.dmx().doD())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.mlD.dmx().doA();
            hVar.lLl = true;
            this.mlE.add(hVar);
            pVar.uH(false);
            pVar.lLO = false;
        }
        List<o> dlN = fVar.dlN();
        int i4 = -1;
        if (com.baidu.tieba.lego.card.c.a.isEmpty(dlN)) {
            oVar = null;
        } else {
            oVar = (o) com.baidu.tieba.lego.card.c.a.l(dlN, 0);
            if (oVar != null) {
                i4 = oVar.getPosition();
            }
        }
        if (fVar.dlI() != null) {
            int i5 = 1;
            int i6 = i4;
            o oVar3 = oVar;
            for (com.baidu.tbadk.core.data.p pVar2 : fVar.dlI()) {
                if (dlN != null && i5 == i6) {
                    if (oVar3 != null) {
                        c(oVar3);
                        com.baidu.tieba.lego.card.c.a.a(this.mlE, oVar3);
                        i3++;
                        if (oVar3.getType() != AdvertAppInfo.eLf) {
                            i5++;
                        }
                    }
                    if (i3 < dlN.size()) {
                        oVar2 = (o) com.baidu.tieba.lego.card.c.a.l(dlN, i3);
                        i = oVar2 != null ? oVar2.getPosition() : i6;
                        com.baidu.tieba.lego.card.c.a.a(this.mlE, pVar2);
                        i2 = i5 + 1;
                        if (i2 == 4 && fVar.dlm() != null) {
                            com.baidu.tieba.lego.card.c.a.a(this.mlE, fVar.dlm());
                            i2++;
                        }
                        i5 = i2;
                        i6 = i;
                        oVar3 = oVar2;
                    }
                }
                i = i6;
                oVar2 = oVar3;
                com.baidu.tieba.lego.card.c.a.a(this.mlE, pVar2);
                i2 = i5 + 1;
                if (i2 == 4) {
                    com.baidu.tieba.lego.card.c.a.a(this.mlE, fVar.dlm());
                    i2++;
                }
                i5 = i2;
                i6 = i;
                oVar3 = oVar2;
            }
        }
        return this.mlE;
    }

    private void c(o oVar) {
        ForumData forum;
        if (oVar != null && this.lOF != null && oVar.dNt() != null) {
            oVar.dNt().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lOF.getPage() != null) {
                oVar.dNt().advertAppContext.pn = this.lOF.getPage().bmD();
            }
            oVar.dNt().advertAppContext.page = oVar.dNw();
            if (this.lOF.getForum() != null && (forum = this.lOF.getForum()) != null) {
                oVar.dNt().advertAppContext.fid = forum.getId();
                oVar.dNt().advertAppContext.eKW = forum.getFirst_class();
                oVar.dNt().advertAppContext.eKX = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dNt().advertAppContext.eKY = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dNt().advertAppContext.extensionInfo = oVar.dNt().ext_info;
            oVar.dNt().advertAppContext.aas = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.jmy != null && this.jmy.getAdapter() != null) {
            this.jmy.getListAdapter().notifyDataSetChanged();
        }
    }

    public void duN() {
        if (this.mlF != null) {
            this.mlF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FK(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mlD.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mlD.doh(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM(final int i) {
        af.a(new ae<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: bkO */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(a.this.mlD.getContext(), a.this.dnB(), i2, a.this.mlD.dmx());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.mlD.getContext(), i, shareItem, false));
            }
        });
        ar arVar = new ar("c13833");
        arVar.ap("obj_locate", 1);
        if (i == 3) {
            arVar.ap("obj_type", 1);
        } else if (i == 8) {
            arVar.ap("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dnB() {
        if (this.lOF == null || this.lOF.dlg() == null) {
            return -1;
        }
        return this.lOF.dlg().boC();
    }
}
