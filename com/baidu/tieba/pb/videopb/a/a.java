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
    private BdTypeRecyclerView joh;
    private com.baidu.adp.widget.ListView.a knc;
    private PbFirstFloorEnterForumAdapter lPS;
    private PbFirstFloorItemAdapter lPT;
    private f lQH;
    private com.baidu.adp.widget.ListView.a lQa;
    private DetailInfoFragment mnF;
    private List<n> mnG;
    private e mnH;
    private PbFirstFloorCommentAndPraiseAdapter mnI;
    private c mnJ;
    private h mnK;
    private w mnL;
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private View.OnClickListener mnM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.FN(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.FP(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.FN(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.FP(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mnF = detailInfoFragment;
        this.joh = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mnH = new e(detailInfoFragment.dop(), PostData.nzc);
        this.mnI = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.dop(), p.lNO);
        this.mnI.setOnClickListener(this.mnM);
        this.mnJ = new c(detailInfoFragment.getContext(), t.TYPE);
        this.lPS = new PbFirstFloorEnterForumAdapter(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mnK = new h(detailInfoFragment.dop(), com.baidu.tbadk.core.data.p.eNW);
        this.mnK.uU(true);
        this.mnL = new w(detailInfoFragment.dop());
        this.lPT = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), i.TYPE);
        this.boS.add(this.mnH);
        this.boS.add(this.mnI);
        this.boS.add(this.mnJ);
        this.boS.add(this.lPS);
        this.boS.add(this.mnK);
        this.boS.add(this.mnL);
        this.boS.add(this.lPT);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.boS);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.knc = s.dDB().a(detailInfoFragment.dop().getBaseFragmentActivity(), AdvertAppInfo.eMG);
        this.lQa = s.dDB().a(detailInfoFragment.dop().getBaseFragmentActivity(), AdvertAppInfo.eMK);
        this.boS.add(this.knc);
        this.boS.add(this.lQa);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lQH = fVar;
            if (this.joh != null) {
                this.joh.setVisibility(0);
            }
            this.mnH.setPbData(fVar);
            this.mnK.setPbData(fVar);
            this.mnL.setPbData(fVar);
            this.joh.setData(P(fVar));
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
        this.mnG = new ArrayList();
        Iterator<PostData> it = fVar.dlr().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dNO() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dly() != null) {
            postData = fVar.dly();
        }
        if (postData != null) {
            this.mnG.add(postData);
        }
        p pVar = new p(fVar.dlp(), fVar.getAnti());
        pVar.uH(true);
        pVar.lNQ = true;
        this.mnG.add(pVar);
        if (postData == null || postData.nAd == null || (fVar.getForum() != null && TextUtils.equals(fVar.getForum().getName(), this.mnF.dmG().dmz()) && this.mnF.dmG().doM())) {
            z = false;
        } else {
            i iVar = new i(postData.nAd);
            iVar.tid = this.mnF.dmG().doJ();
            this.mnG.add(iVar);
            z = true;
        }
        if (!z && fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mnF.dmG().dmz()) || !this.mnF.dmG().doM())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.mnF.dmG().doJ();
            hVar.lNn = true;
            this.mnG.add(hVar);
            pVar.uH(false);
            pVar.lNQ = false;
        }
        List<o> dlW = fVar.dlW();
        int i4 = -1;
        if (com.baidu.tieba.lego.card.c.a.isEmpty(dlW)) {
            oVar = null;
        } else {
            oVar = (o) com.baidu.tieba.lego.card.c.a.l(dlW, 0);
            if (oVar != null) {
                i4 = oVar.getPosition();
            }
        }
        if (fVar.dlR() != null) {
            int i5 = 1;
            int i6 = i4;
            o oVar3 = oVar;
            for (com.baidu.tbadk.core.data.p pVar2 : fVar.dlR()) {
                if (dlW != null && i5 == i6) {
                    if (oVar3 != null) {
                        c(oVar3);
                        com.baidu.tieba.lego.card.c.a.a(this.mnG, oVar3);
                        i3++;
                        if (oVar3.getType() != AdvertAppInfo.eMG) {
                            i5++;
                        }
                    }
                    if (i3 < dlW.size()) {
                        oVar2 = (o) com.baidu.tieba.lego.card.c.a.l(dlW, i3);
                        i = oVar2 != null ? oVar2.getPosition() : i6;
                        com.baidu.tieba.lego.card.c.a.a(this.mnG, pVar2);
                        i2 = i5 + 1;
                        if (i2 == 4 && fVar.dlv() != null) {
                            com.baidu.tieba.lego.card.c.a.a(this.mnG, fVar.dlv());
                            i2++;
                        }
                        i5 = i2;
                        i6 = i;
                        oVar3 = oVar2;
                    }
                }
                i = i6;
                oVar2 = oVar3;
                com.baidu.tieba.lego.card.c.a.a(this.mnG, pVar2);
                i2 = i5 + 1;
                if (i2 == 4) {
                    com.baidu.tieba.lego.card.c.a.a(this.mnG, fVar.dlv());
                    i2++;
                }
                i5 = i2;
                i6 = i;
                oVar3 = oVar2;
            }
        }
        return this.mnG;
    }

    private void c(o oVar) {
        ForumData forum;
        if (oVar != null && this.lQH != null && oVar.dNC() != null) {
            oVar.dNC().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lQH.getPage() != null) {
                oVar.dNC().advertAppContext.pn = this.lQH.getPage().bmF();
            }
            oVar.dNC().advertAppContext.page = oVar.dNF();
            if (this.lQH.getForum() != null && (forum = this.lQH.getForum()) != null) {
                oVar.dNC().advertAppContext.fid = forum.getId();
                oVar.dNC().advertAppContext.eMx = forum.getFirst_class();
                oVar.dNC().advertAppContext.eMy = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dNC().advertAppContext.eMz = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dNC().advertAppContext.extensionInfo = oVar.dNC().ext_info;
            oVar.dNC().advertAppContext.abM = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.joh != null && this.joh.getAdapter() != null) {
            this.joh.getListAdapter().notifyDataSetChanged();
        }
    }

    public void duW() {
        if (this.mnH != null) {
            this.mnH.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FN(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mnF.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mnF.doq(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(final int i) {
        af.a(new ae<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: bkQ */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(a.this.mnF.getContext(), a.this.dnK(), i2, a.this.mnF.dmG());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.mnF.getContext(), i, shareItem, false));
            }
        });
        ar arVar = new ar("c13833");
        arVar.aq("obj_locate", 1);
        if (i == 3) {
            arVar.aq("obj_type", 1);
        } else if (i == 8) {
            arVar.aq("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dnK() {
        if (this.lQH == null || this.lQH.dlp() == null) {
            return -1;
        }
        return this.lQH.dlp().boE();
    }
}
