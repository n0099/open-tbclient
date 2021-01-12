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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.data.s;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView jgC;
    private com.baidu.adp.widget.ListView.a kcC;
    private PbFirstFloorEnterForumAdapter lEM;
    private com.baidu.adp.widget.ListView.a lET;
    private f lFA;
    private DetailInfoFragment mcn;
    private List<n> mco;
    private e mcp;
    private PbFirstFloorCommentAndPraiseAdapter mcq;
    private c mcr;
    private h mcs;
    private w mct;
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private View.OnClickListener mcu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.Fr(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.Ft(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.Fr(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.Ft(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mcn = detailInfoFragment;
        this.jgC = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mcp = new e(detailInfoFragment.dlK(), PostData.nmM);
        this.mcq = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.dlK(), o.lCJ);
        this.mcq.setOnClickListener(this.mcu);
        this.mcr = new c(detailInfoFragment.getContext(), s.TYPE);
        this.lEM = new PbFirstFloorEnterForumAdapter(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mcs = new h(detailInfoFragment.dlK(), com.baidu.tbadk.core.data.o.eKj);
        this.mcs.uF(true);
        this.mct = new w(detailInfoFragment.dlK());
        this.bjZ.add(this.mcp);
        this.bjZ.add(this.mcq);
        this.bjZ.add(this.mcr);
        this.bjZ.add(this.lEM);
        this.bjZ.add(this.mcs);
        this.bjZ.add(this.mct);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bjZ);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.kcC = r.dBe().a(detailInfoFragment.dlK().getBaseFragmentActivity(), AdvertAppInfo.eIT);
        this.lET = r.dBe().a(detailInfoFragment.dlK().getBaseFragmentActivity(), AdvertAppInfo.eIX);
        this.bjZ.add(this.kcC);
        this.bjZ.add(this.lET);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lFA = fVar;
            if (this.jgC != null) {
                this.jgC.setVisibility(0);
            }
            this.mcp.setPbData(fVar);
            this.mcs.setPbData(fVar);
            this.mct.setPbData(fVar);
            this.jgC.setData(P(fVar));
        }
    }

    private List<n> P(f fVar) {
        PostData postData;
        com.baidu.tieba.tbadkCore.data.o oVar;
        int i;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        int i2;
        int i3 = 0;
        if (fVar == null) {
            return null;
        }
        this.mco = new ArrayList();
        Iterator<PostData> it = fVar.diP().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dLm() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.diW() != null) {
            postData = fVar.diW();
        }
        if (postData != null) {
            this.mco.add(postData);
        }
        o oVar3 = new o(fVar.diN(), fVar.getAnti());
        oVar3.uu(true);
        oVar3.lCL = true;
        this.mco.add(oVar3);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mcn.dkd().djW()) || !this.mcn.dkd().dmh())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.mcn.dkd().dme();
            hVar.lCi = true;
            this.mco.add(hVar);
            oVar3.uu(false);
            oVar3.lCL = false;
        }
        List<com.baidu.tieba.tbadkCore.data.o> dju = fVar.dju();
        int i4 = -1;
        if (com.baidu.tieba.lego.card.c.a.isEmpty(dju)) {
            oVar = null;
        } else {
            oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tieba.lego.card.c.a.l(dju, 0);
            if (oVar != null) {
                i4 = oVar.getPosition();
            }
        }
        if (fVar.djp() != null) {
            int i5 = 1;
            int i6 = i4;
            com.baidu.tieba.tbadkCore.data.o oVar4 = oVar;
            for (com.baidu.tbadk.core.data.o oVar5 : fVar.djp()) {
                if (dju != null && i5 == i6) {
                    if (oVar4 != null) {
                        c(oVar4);
                        com.baidu.tieba.lego.card.c.a.a(this.mco, oVar4);
                        i3++;
                        if (oVar4.getType() != AdvertAppInfo.eIT) {
                            i5++;
                        }
                    }
                    if (i3 < dju.size()) {
                        oVar2 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tieba.lego.card.c.a.l(dju, i3);
                        i = oVar2 != null ? oVar2.getPosition() : i6;
                        com.baidu.tieba.lego.card.c.a.a(this.mco, oVar5);
                        i2 = i5 + 1;
                        if (i2 == 4 && fVar.diT() != null) {
                            com.baidu.tieba.lego.card.c.a.a(this.mco, fVar.diT());
                            i2++;
                        }
                        i5 = i2;
                        i6 = i;
                        oVar4 = oVar2;
                    }
                }
                i = i6;
                oVar2 = oVar4;
                com.baidu.tieba.lego.card.c.a.a(this.mco, oVar5);
                i2 = i5 + 1;
                if (i2 == 4) {
                    com.baidu.tieba.lego.card.c.a.a(this.mco, fVar.diT());
                    i2++;
                }
                i5 = i2;
                i6 = i;
                oVar4 = oVar2;
            }
        }
        return this.mco;
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lFA != null && oVar.dLa() != null) {
            oVar.dLa().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lFA.getPage() != null) {
                oVar.dLa().advertAppContext.pn = this.lFA.getPage().bmk();
            }
            oVar.dLa().advertAppContext.page = oVar.dLd();
            if (this.lFA.getForum() != null && (forum = this.lFA.getForum()) != null) {
                oVar.dLa().advertAppContext.fid = forum.getId();
                oVar.dLa().advertAppContext.eIK = forum.getFirst_class();
                oVar.dLa().advertAppContext.eIL = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dLa().advertAppContext.eIM = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dLa().advertAppContext.extensionInfo = oVar.dLa().ext_info;
            oVar.dLa().advertAppContext.aaw = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.jgC != null && this.jgC.getAdapter() != null) {
            this.jgC.getListAdapter().notifyDataSetChanged();
        }
    }

    public void dsv() {
        if (this.mcp != null) {
            this.mcp.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fr(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mcn.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mcn.dlL(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ft(final int i) {
        ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bkw */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(a.this.mcn.getContext(), a.this.dlf(), i2, a.this.mcn.dkd());
            }
        }, new l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.mcn.getContext(), i, shareItem, false));
            }
        });
        aq aqVar = new aq("c13833");
        aqVar.an("obj_locate", 1);
        if (i == 3) {
            aqVar.an("obj_type", 1);
        } else if (i == 8) {
            aqVar.an("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dlf() {
        if (this.lFA == null || this.lFA.diN() == null) {
            return -1;
        }
        return this.lFA.diN().bok();
    }
}
