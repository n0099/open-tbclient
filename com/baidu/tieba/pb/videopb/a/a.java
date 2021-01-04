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
    private PbFirstFloorEnterForumAdapter lJr;
    private com.baidu.adp.widget.ListView.a lJy;
    private f lKf;
    private DetailInfoFragment mgT;
    private List<n> mgU;
    private e mgV;
    private PbFirstFloorCommentAndPraiseAdapter mgW;
    private c mgX;
    private h mgY;
    private w mgZ;
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private View.OnClickListener mha = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
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
        this.mgT = detailInfoFragment;
        this.jlj = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mgV = new e(detailInfoFragment.dpC(), PostData.nru);
        this.mgW = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.dpC(), o.lHp);
        this.mgW.setOnClickListener(this.mha);
        this.mgX = new c(detailInfoFragment.getContext(), s.TYPE);
        this.lJr = new PbFirstFloorEnterForumAdapter(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mgY = new h(detailInfoFragment.dpC(), com.baidu.tbadk.core.data.o.eOU);
        this.mgY.uJ(true);
        this.mgZ = new w(detailInfoFragment.dpC());
        this.boM.add(this.mgV);
        this.boM.add(this.mgW);
        this.boM.add(this.mgX);
        this.boM.add(this.lJr);
        this.boM.add(this.mgY);
        this.boM.add(this.mgZ);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.boM);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.khi = r.dEV().a(detailInfoFragment.dpC().getBaseFragmentActivity(), AdvertAppInfo.eNE);
        this.lJy = r.dEV().a(detailInfoFragment.dpC().getBaseFragmentActivity(), AdvertAppInfo.eNI);
        this.boM.add(this.khi);
        this.boM.add(this.lJy);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lKf = fVar;
            if (this.jlj != null) {
                this.jlj.setVisibility(0);
            }
            this.mgV.setPbData(fVar);
            this.mgY.setPbData(fVar);
            this.mgZ.setPbData(fVar);
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
        this.mgU = new ArrayList();
        Iterator<PostData> it = fVar.dmG().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dPd() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dmN() != null) {
            postData = fVar.dmN();
        }
        if (postData != null) {
            this.mgU.add(postData);
        }
        o oVar3 = new o(fVar.dmE(), fVar.getAnti());
        oVar3.uy(true);
        oVar3.lHr = true;
        this.mgU.add(oVar3);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mgT.dnV().dnO()) || !this.mgT.dnV().dpZ())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.mgT.dnV().dpW();
            hVar.lGO = true;
            this.mgU.add(hVar);
            oVar3.uy(false);
            oVar3.lHr = false;
        }
        List<com.baidu.tieba.tbadkCore.data.o> dnl = fVar.dnl();
        int i4 = -1;
        if (com.baidu.tieba.lego.card.c.a.isEmpty(dnl)) {
            oVar = null;
        } else {
            oVar = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tieba.lego.card.c.a.l(dnl, 0);
            if (oVar != null) {
                i4 = oVar.getPosition();
            }
        }
        if (fVar.dng() != null) {
            int i5 = 1;
            int i6 = i4;
            com.baidu.tieba.tbadkCore.data.o oVar4 = oVar;
            for (com.baidu.tbadk.core.data.o oVar5 : fVar.dng()) {
                if (dnl != null && i5 == i6) {
                    if (oVar4 != null) {
                        c(oVar4);
                        com.baidu.tieba.lego.card.c.a.a(this.mgU, oVar4);
                        i3++;
                        if (oVar4.getType() != AdvertAppInfo.eNE) {
                            i5++;
                        }
                    }
                    if (i3 < dnl.size()) {
                        oVar2 = (com.baidu.tieba.tbadkCore.data.o) com.baidu.tieba.lego.card.c.a.l(dnl, i3);
                        i = oVar2 != null ? oVar2.getPosition() : i6;
                        com.baidu.tieba.lego.card.c.a.a(this.mgU, oVar5);
                        i2 = i5 + 1;
                        if (i2 == 4 && fVar.dmK() != null) {
                            com.baidu.tieba.lego.card.c.a.a(this.mgU, fVar.dmK());
                            i2++;
                        }
                        i5 = i2;
                        i6 = i;
                        oVar4 = oVar2;
                    }
                }
                i = i6;
                oVar2 = oVar4;
                com.baidu.tieba.lego.card.c.a.a(this.mgU, oVar5);
                i2 = i5 + 1;
                if (i2 == 4) {
                    com.baidu.tieba.lego.card.c.a.a(this.mgU, fVar.dmK());
                    i2++;
                }
                i5 = i2;
                i6 = i;
                oVar4 = oVar2;
            }
        }
        return this.mgU;
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lKf != null && oVar.dOR() != null) {
            oVar.dOR().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lKf.getPage() != null) {
                oVar.dOR().advertAppContext.pn = this.lKf.getPage().bqd();
            }
            oVar.dOR().advertAppContext.page = oVar.dOU();
            if (this.lKf.getForum() != null && (forum = this.lKf.getForum()) != null) {
                oVar.dOR().advertAppContext.fid = forum.getId();
                oVar.dOR().advertAppContext.eNv = forum.getFirst_class();
                oVar.dOR().advertAppContext.eNw = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dOR().advertAppContext.eNx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dOR().advertAppContext.extensionInfo = oVar.dOR().ext_info;
            oVar.dOR().advertAppContext.aay = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.jlj != null && this.jlj.getAdapter() != null) {
            this.jlj.getListAdapter().notifyDataSetChanged();
        }
    }

    public void dwm() {
        if (this.mgV != null) {
            this.mgV.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GX(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mgT.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mgT.dpD(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ(final int i) {
        ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bop */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(a.this.mgT.getContext(), a.this.doX(), i2, a.this.mgT.dnV());
            }
        }, new l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.mgT.getContext(), i, shareItem, false));
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
    public int doX() {
        if (this.lKf == null || this.lKf.dmE() == null) {
            return -1;
        }
        return this.lKf.dmE().bsd();
    }
}
