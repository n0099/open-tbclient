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
    private BdTypeRecyclerView jlj;
    private com.baidu.adp.widget.ListView.a khi;
    private PbFirstFloorEnterForumAdapter lJq;
    private com.baidu.adp.widget.ListView.a lJx;
    private f lKe;
    private DetailInfoFragment mgS;
    private List<n> mgT;
    private e mgU;
    private PbFirstFloorCommentAndPraiseAdapter mgV;
    private c mgW;
    private h mgX;
    private w mgY;
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private View.OnClickListener mgZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.GZ(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.GZ(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mgS = detailInfoFragment;
        this.jlj = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mgU = new e(detailInfoFragment.dpD(), PostData.nrt);
        this.mgV = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.dpD(), o.lHo);
        this.mgV.setOnClickListener(this.mgZ);
        this.mgW = new c(detailInfoFragment.getContext(), s.TYPE);
        this.lJq = new PbFirstFloorEnterForumAdapter(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mgX = new h(detailInfoFragment.dpD(), com.baidu.tbadk.core.data.o.eOU);
        this.mgX.uJ(true);
        this.mgY = new w(detailInfoFragment.dpD());
        this.boM.add(this.mgU);
        this.boM.add(this.mgV);
        this.boM.add(this.mgW);
        this.boM.add(this.lJq);
        this.boM.add(this.mgX);
        this.boM.add(this.mgY);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.boM);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.khi = r.dEW().a(detailInfoFragment.dpD().getBaseFragmentActivity(), AdvertAppInfo.eNE);
        this.lJx = r.dEW().a(detailInfoFragment.dpD().getBaseFragmentActivity(), AdvertAppInfo.eNI);
        this.boM.add(this.khi);
        this.boM.add(this.lJx);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lKe = fVar;
            if (this.jlj != null) {
                this.jlj.setVisibility(0);
            }
            this.mgU.setPbData(fVar);
            this.mgX.setPbData(fVar);
            this.mgY.setPbData(fVar);
            this.jlj.setData(P(fVar));
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
        this.mgT = new ArrayList();
        Iterator<PostData> it = fVar.dmH().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dPe() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dmO() != null) {
            postData = fVar.dmO();
        }
        if (postData != null) {
            this.mgT.add(postData);
        }
        o oVar3 = new o(fVar.dmF(), fVar.getAnti());
        oVar3.uy(true);
        oVar3.lHq = true;
        this.mgT.add(oVar3);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mgS.dnW().dnP()) || !this.mgS.dnW().dqa())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.mgS.dnW().dpX();
            hVar.lGN = true;
            this.mgT.add(hVar);
            oVar3.uy(false);
            oVar3.lHq = false;
        }
        List<com.baidu.tieba.tbadkCore.data.o> dnm = fVar.dnm();
        int i4 = -1;
        if (com.baidu.tieba.lego.card.c.a.isEmpty(dnm)) {
            oVar = null;
        } else {
            oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tieba.lego.card.c.a.l(dnm, 0);
            if (oVar != null) {
                i4 = oVar.getPosition();
            }
        }
        if (fVar.dnh() != null) {
            int i5 = 1;
            int i6 = i4;
            com.baidu.tieba.tbadkCore.data.o oVar4 = oVar;
            for (com.baidu.tbadk.core.data.o oVar5 : fVar.dnh()) {
                if (dnm != null && i5 == i6) {
                    if (oVar4 != null) {
                        c(oVar4);
                        com.baidu.tieba.lego.card.c.a.a(this.mgT, oVar4);
                        i3++;
                        if (oVar4.getType() != AdvertAppInfo.eNE) {
                            i5++;
                        }
                    }
                    if (i3 < dnm.size()) {
                        oVar2 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tieba.lego.card.c.a.l(dnm, i3);
                        i = oVar2 != null ? oVar2.getPosition() : i6;
                        com.baidu.tieba.lego.card.c.a.a(this.mgT, oVar5);
                        i2 = i5 + 1;
                        if (i2 == 4 && fVar.dmL() != null) {
                            com.baidu.tieba.lego.card.c.a.a(this.mgT, fVar.dmL());
                            i2++;
                        }
                        i5 = i2;
                        i6 = i;
                        oVar4 = oVar2;
                    }
                }
                i = i6;
                oVar2 = oVar4;
                com.baidu.tieba.lego.card.c.a.a(this.mgT, oVar5);
                i2 = i5 + 1;
                if (i2 == 4) {
                    com.baidu.tieba.lego.card.c.a.a(this.mgT, fVar.dmL());
                    i2++;
                }
                i5 = i2;
                i6 = i;
                oVar4 = oVar2;
            }
        }
        return this.mgT;
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lKe != null && oVar.dOS() != null) {
            oVar.dOS().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lKe.getPage() != null) {
                oVar.dOS().advertAppContext.pn = this.lKe.getPage().bqe();
            }
            oVar.dOS().advertAppContext.page = oVar.dOV();
            if (this.lKe.getForum() != null && (forum = this.lKe.getForum()) != null) {
                oVar.dOS().advertAppContext.fid = forum.getId();
                oVar.dOS().advertAppContext.eNv = forum.getFirst_class();
                oVar.dOS().advertAppContext.eNw = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dOS().advertAppContext.eNx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dOS().advertAppContext.extensionInfo = oVar.dOS().ext_info;
            oVar.dOS().advertAppContext.aay = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.jlj != null && this.jlj.getAdapter() != null) {
            this.jlj.getListAdapter().notifyDataSetChanged();
        }
    }

    public void dwn() {
        if (this.mgU != null) {
            this.mgU.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GX(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mgS.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mgS.dpE(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ(final int i) {
        ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: boq */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(a.this.mgS.getContext(), a.this.doY(), i2, a.this.mgS.dnW());
            }
        }, new l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.mgS.getContext(), i, shareItem, false));
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
    public int doY() {
        if (this.lKe == null || this.lKe.dmF() == null) {
            return -1;
        }
        return this.lKe.dmF().bse();
    }
}
