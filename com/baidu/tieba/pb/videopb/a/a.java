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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView jmj;
    private com.baidu.adp.widget.ListView.a kkM;
    private PbFirstFloorEnterForumAdapter lNB;
    private PbFirstFloorItemAdapter lNC;
    private com.baidu.adp.widget.ListView.a lNJ;
    private f lOq;
    private DetailInfoFragment mlo;
    private List<n> mlp;
    private e mlq;
    private PbFirstFloorCommentAndPraiseAdapter mlr;
    private c mls;
    private h mlt;
    private w mlu;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private View.OnClickListener mlv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
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
        this.mlo = detailInfoFragment;
        this.jmj = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mlq = new e(detailInfoFragment.dnZ(), PostData.nwx);
        this.mlr = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.dnZ(), p.lLx);
        this.mlr.setOnClickListener(this.mlv);
        this.mls = new c(detailInfoFragment.getContext(), t.TYPE);
        this.lNB = new PbFirstFloorEnterForumAdapter(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mlt = new h(detailInfoFragment.dnZ(), com.baidu.tbadk.core.data.p.eMv);
        this.mlt.uU(true);
        this.mlu = new w(detailInfoFragment.dnZ());
        this.lNC = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), i.TYPE);
        this.bns.add(this.mlq);
        this.bns.add(this.mlr);
        this.bns.add(this.mls);
        this.bns.add(this.lNB);
        this.bns.add(this.mlt);
        this.bns.add(this.mlu);
        this.bns.add(this.lNC);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.bns);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.kkM = r.dDm().a(detailInfoFragment.dnZ().getBaseFragmentActivity(), AdvertAppInfo.eLf);
        this.lNJ = r.dDm().a(detailInfoFragment.dnZ().getBaseFragmentActivity(), AdvertAppInfo.eLj);
        this.bns.add(this.kkM);
        this.bns.add(this.lNJ);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lOq = fVar;
            if (this.jmj != null) {
                this.jmj.setVisibility(0);
            }
            this.mlq.setPbData(fVar);
            this.mlt.setPbData(fVar);
            this.mlu.setPbData(fVar);
            this.jmj.setData(P(fVar));
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
        this.mlp = new ArrayList();
        Iterator<PostData> it = fVar.dlb().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dNx() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && fVar.dli() != null) {
            postData = fVar.dli();
        }
        if (postData != null) {
            this.mlp.add(postData);
        }
        p pVar = new p(fVar.dkZ(), fVar.getAnti());
        pVar.uH(true);
        pVar.lLz = true;
        this.mlp.add(pVar);
        if (postData == null || postData.nxy == null || (fVar.getForum() != null && TextUtils.equals(fVar.getForum().getName(), this.mlo.dmq().dmj()) && this.mlo.dmq().dow())) {
            z = false;
        } else {
            i iVar = new i(postData.nxy);
            iVar.tid = this.mlo.dmq().dot();
            this.mlp.add(iVar);
            z = true;
        }
        if (!z && fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mlo.dmq().dmj()) || !this.mlo.dmq().dow())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.mlo.dmq().dot();
            hVar.lKW = true;
            this.mlp.add(hVar);
            pVar.uH(false);
            pVar.lLz = false;
        }
        List<o> dlG = fVar.dlG();
        int i4 = -1;
        if (com.baidu.tieba.lego.card.c.a.isEmpty(dlG)) {
            oVar = null;
        } else {
            oVar = (o) com.baidu.tieba.lego.card.c.a.l(dlG, 0);
            if (oVar != null) {
                i4 = oVar.getPosition();
            }
        }
        if (fVar.dlB() != null) {
            int i5 = 1;
            int i6 = i4;
            o oVar3 = oVar;
            for (com.baidu.tbadk.core.data.p pVar2 : fVar.dlB()) {
                if (dlG != null && i5 == i6) {
                    if (oVar3 != null) {
                        c(oVar3);
                        com.baidu.tieba.lego.card.c.a.a(this.mlp, oVar3);
                        i3++;
                        if (oVar3.getType() != AdvertAppInfo.eLf) {
                            i5++;
                        }
                    }
                    if (i3 < dlG.size()) {
                        oVar2 = (o) com.baidu.tieba.lego.card.c.a.l(dlG, i3);
                        i = oVar2 != null ? oVar2.getPosition() : i6;
                        com.baidu.tieba.lego.card.c.a.a(this.mlp, pVar2);
                        i2 = i5 + 1;
                        if (i2 == 4 && fVar.dlf() != null) {
                            com.baidu.tieba.lego.card.c.a.a(this.mlp, fVar.dlf());
                            i2++;
                        }
                        i5 = i2;
                        i6 = i;
                        oVar3 = oVar2;
                    }
                }
                i = i6;
                oVar2 = oVar3;
                com.baidu.tieba.lego.card.c.a.a(this.mlp, pVar2);
                i2 = i5 + 1;
                if (i2 == 4) {
                    com.baidu.tieba.lego.card.c.a.a(this.mlp, fVar.dlf());
                    i2++;
                }
                i5 = i2;
                i6 = i;
                oVar3 = oVar2;
            }
        }
        return this.mlp;
    }

    private void c(o oVar) {
        ForumData forum;
        if (oVar != null && this.lOq != null && oVar.dNl() != null) {
            oVar.dNl().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lOq.getPage() != null) {
                oVar.dNl().advertAppContext.pn = this.lOq.getPage().bmD();
            }
            oVar.dNl().advertAppContext.page = oVar.dNo();
            if (this.lOq.getForum() != null && (forum = this.lOq.getForum()) != null) {
                oVar.dNl().advertAppContext.fid = forum.getId();
                oVar.dNl().advertAppContext.eKW = forum.getFirst_class();
                oVar.dNl().advertAppContext.eKX = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dNl().advertAppContext.eKY = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dNl().advertAppContext.extensionInfo = oVar.dNl().ext_info;
            oVar.dNl().advertAppContext.aas = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.jmj != null && this.jmj.getAdapter() != null) {
            this.jmj.getListAdapter().notifyDataSetChanged();
        }
    }

    public void duG() {
        if (this.mlq != null) {
            this.mlq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FK(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mlo.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mlo.doa(), true, i)));
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
                return com.baidu.tieba.pb.pb.main.d.b.a(a.this.mlo.getContext(), a.this.dnu(), i2, a.this.mlo.dmq());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.mlo.getContext(), i, shareItem, false));
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
    public int dnu() {
        if (this.lOq == null || this.lOq.dkZ() == null) {
            return -1;
        }
        return this.lOq.dkZ().boC();
    }
}
