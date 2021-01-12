package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.data.s;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.ag;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<n> gnp;
    private BdTypeRecyclerView jgC;
    private com.baidu.adp.widget.ListView.a kcC;
    private PbFirstFloorEnterForumAdapter lEM;
    private k lEQ;
    private com.baidu.adp.widget.ListView.a lET;
    private ag lEY;
    private PbReplyLoadMoreAdapter lEZ;
    private f lFd;
    private SortSwitchButton.a lFo;
    private j mcA;
    private d mcB;
    private e mcp;
    private PbFirstFloorCommentAndPraiseAdapter mcq;
    private c mcr;
    private h mcs;
    private w mct;
    private DetailInfoAndReplyFragment mcx;
    private ak mcy;
    private y mcz;
    private final BdUniqueId mcw = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private boolean mbK = true;
    private String bhj = null;
    private boolean lFe = true;
    private boolean mIsFromCDN = false;
    private int mcC = -1;
    private int mcD = -1;
    private View.OnClickListener lFn = null;
    private View.OnClickListener aYB = null;
    private TbRichTextView.i fSh = null;
    private com.baidu.tieba.pb.a.c ftt = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener mcu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.Fr(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.Ft(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.Fr(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.Ft(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mcx = detailInfoAndReplyFragment;
        this.jgC = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.mcp = new e(this.mcx.dlK(), PostData.nmM);
        this.mcq = new PbFirstFloorCommentAndPraiseAdapter(this.mcx.dlK(), o.lCJ);
        this.mcq.setOnClickListener(this.mcu);
        this.mcr = new c(this.mcx.getContext(), s.TYPE);
        this.lEM = new PbFirstFloorEnterForumAdapter(this.mcx.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mcy = new ak(this.mcx.dlK(), com.baidu.tieba.pb.data.n.lCC);
        this.mcz = new y(this.mcx.dlK(), com.baidu.tieba.pb.data.j.lCl, this.mcx.getUniqueId());
        this.lEY = new ag(this.mcx.dlK(), l.Yp);
        this.mcA = new j(this.mcx.dlK(), com.baidu.tieba.pb.data.e.lBe);
        this.mcs = new h(this.mcx.dlK(), com.baidu.tbadk.core.data.o.eKj);
        this.mcs.uF(true);
        this.mct = new w(this.mcx.dlK());
        this.lEQ = new k(this.mcx.dlK(), PostData.nmN);
        this.lEQ.a((TbRichTextView.c) this.mcx.dlK());
        this.lEZ = new PbReplyLoadMoreAdapter(this.mcx.dlK(), PostData.nmR);
        this.kcC = r.dBe().a(this.mcx.dlK().getBaseFragmentActivity(), AdvertAppInfo.eIT);
        this.lET = r.dBe().a(this.mcx.dlK().getBaseFragmentActivity(), AdvertAppInfo.eIX);
        this.mcB = new d(this.mcx.getPageContext(), bz.eOr, this.mcx.getUniqueId());
        this.mcB.a(this.jgC);
        this.bjZ.add(this.mcp);
        this.bjZ.add(this.mcq);
        this.bjZ.add(this.mcr);
        this.bjZ.add(this.lEM);
        this.bjZ.add(this.mcy);
        this.bjZ.add(this.lEY);
        this.bjZ.add(this.mcz);
        this.bjZ.add(this.mcA);
        this.bjZ.add(this.mcs);
        this.bjZ.add(this.mct);
        this.bjZ.add(this.kcC);
        this.bjZ.add(this.lET);
        this.bjZ.add(this.lEQ);
        this.bjZ.add(this.lEZ);
        this.bjZ.add(this.mcB);
        this.jgC.addAdapters(this.bjZ);
    }

    public void setData(f fVar) {
        a(fVar, false);
    }

    public void a(f fVar, boolean z) {
        PostData postData;
        bz diN;
        int i;
        com.baidu.tieba.tbadkCore.data.o oVar;
        int i2;
        int i3;
        boolean z2;
        int i4 = 1;
        if (fVar != null) {
            this.lFd = fVar;
            if (fVar != null && fVar.diN() != null && fVar.diN().bnx() != null) {
                this.bhj = fVar.diN().bnx().getUserId();
            }
            if (this.gnp == null) {
                this.gnp = new ArrayList<>();
            }
            this.gnp.clear();
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
                this.gnp.add(postData);
            }
            this.mcp.setPbData(fVar);
            this.mcp.gy(this.bhj);
            if (!x.isEmpty(fVar.diP()) && fVar.diP().get(0) != null && fVar.diN() != null) {
                fVar.diN().a(fVar.diP().get(0).bpE());
                fVar.diN().by(fVar.diP().get(0).bpF());
            }
            if (fVar.diN() != null && fVar.diN().bpB() != null) {
                by byVar = new by();
                byVar.eHK = fVar.diN();
                byVar.eNS = true;
                this.gnp.add(byVar);
            }
            o oVar2 = new o(fVar.diN(), fVar.getAnti());
            oVar2.uu(false);
            oVar2.lCL = false;
            this.gnp.add(oVar2);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mcx.dkd().djW()) || !this.mcx.dkd().dmh())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.mcx.dkd().dme();
                hVar.lCi = false;
                this.gnp.add(hVar);
                oVar2.uu(false);
                oVar2.lCL = false;
            }
            com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCC);
            nVar.lCE = fVar.diN() != null ? diN.bno() : 0L;
            nVar.isNew = !this.mcx.dkd().dmg();
            nVar.lCH = dlE();
            nVar.sortType = fVar.lBm;
            nVar.lCG = fVar.djr();
            nVar.isDynamic = fVar.djq();
            nVar.lCI = fVar.lBl;
            this.mcy.setData(fVar);
            this.gnp.add(nVar);
            dkE();
            if (this.lET != null && (this.lET instanceof com.baidu.tieba.recapp.o)) {
                ((com.baidu.tieba.recapp.o) this.lET).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.diP().iterator();
            boolean z3 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dLm() == 1) {
                    z2 = z3;
                } else {
                    this.gnp.add(next2);
                    z2 = true;
                }
                z3 = z2;
            }
            if (!z3 && (!z || !com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                l lVar = new l();
                lVar.lCv = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.lCu = R.drawable.new_pic_emotion_03;
                lVar.gxN = -2;
                lVar.lCw = com.baidu.adp.lib.util.l.getDimens(this.mcx.getContext(), R.dimen.tbds74);
                this.gnp.add(lVar);
            }
            this.lEQ.setData(fVar);
            this.lEQ.setFromCDN(this.mIsFromCDN);
            this.lEQ.gy(this.bhj);
            this.lEQ.uv(this.lFe);
            this.lEQ.C(this.aYB);
            this.lEQ.U(this.lFn);
            this.lEQ.setOnImageClickListener(this.fSh);
            this.lEQ.setOnLongClickListener(this.mOnLongClickListener);
            this.lEQ.setTbGestureDetector(this.ftt);
            this.mcy.C(this.aYB);
            this.mcy.a(this.lFo);
            this.lEZ.setOnClickListener(this.aYB);
            if (fVar.getPage().bmm() == 0) {
                if (z3) {
                    this.mcz.setOnClickListener(this.mcx.dlK().drI());
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.gnp.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.o> dju = fVar.dju();
                if (dju == null || dju.isEmpty()) {
                    i = -1;
                    oVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = dju.get(0);
                    i = oVar3.getPosition();
                    oVar = oVar3;
                }
                if (!x.isEmpty(fVar.djp())) {
                    com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.mcw);
                    this.gnp.add(eVar);
                    int i5 = 0;
                    com.baidu.tieba.tbadkCore.data.o oVar4 = oVar;
                    for (com.baidu.tbadk.core.data.o oVar5 : fVar.djp()) {
                        if (dju != null && i4 == i) {
                            if (oVar4 != null) {
                                c(oVar4);
                                this.gnp.add(oVar4);
                                i5++;
                                if (oVar4.getType() != AdvertAppInfo.eIT) {
                                    i4++;
                                }
                            }
                            if (i5 < dju.size()) {
                                com.baidu.tieba.tbadkCore.data.o oVar6 = dju.get(i5);
                                i2 = oVar6.getPosition();
                                i3 = i5;
                                oVar4 = oVar6;
                                this.gnp.add(oVar5);
                                i4++;
                                if (i4 == 4 && fVar.diT() != null) {
                                    this.gnp.add(fVar.diT());
                                    i4++;
                                }
                                i = i2;
                                i5 = i3;
                            }
                        }
                        i2 = i;
                        i3 = i5;
                        this.gnp.add(oVar5);
                        i4++;
                        if (i4 == 4) {
                            this.gnp.add(fVar.diT());
                            i4++;
                        }
                        i = i2;
                        i5 = i3;
                    }
                }
            }
            if (this.jgC != null) {
                this.jgC.setData(this.gnp);
            }
            dsw();
        }
    }

    private void dkE() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lFd != null && !this.lFd.lCa && this.lFd.aaq != 2) {
            ArrayList<PostData> diP = this.lFd.diP();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dje = this.lFd.dje();
            if (dje != null && !dje.isEmpty() && diP != null && !diP.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dje.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dje.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jyf = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dje.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dLa() != null) {
                        int bll = next3.dLa().bll();
                        if (bll != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, bll);
                            if (bll != 28 && bll != 31) {
                                if (next3.dLa().goods != null) {
                                    next3.dLa().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bll);
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(sparseArray.keyAt(i));
                    if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.getAdId(), oVar3)) != null) {
                        com.baidu.tieba.recapp.report.d.a(oVar2, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && (oVar = (com.baidu.tieba.tbadkCore.data.o) entry.getValue()) != null) {
                        sparseArray.put(oVar.getPosition(), oVar);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.lFd.getForum() != null) {
                        oVar4.forumId = this.lFd.getForum().getId();
                    }
                    if (this.lFd.diN() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lFd.diN().getId(), 0L);
                    }
                    if (this.lFd != null && this.lFd.getPage() != null) {
                        oVar4.pageNumber = this.lFd.getPage().bmk();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lFd.lBZ;
                    if (position + i3 >= diP.size()) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, diP.size());
                        return;
                    }
                    if (!this.mbK) {
                        position--;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(diP, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        diP.add(position, oVar4);
                        TiebaStatic.eventStat(this.mcx.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dLa().apk_name);
                    }
                }
            }
        }
    }

    private boolean g(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof com.baidu.tieba.tbadkCore.data.o) {
                return true;
            }
        }
        return false;
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lFd != null && oVar.dLa() != null) {
            oVar.dLa().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lFd.getPage() != null) {
                oVar.dLa().advertAppContext.pn = this.lFd.getPage().bmk();
            }
            oVar.dLa().advertAppContext.page = oVar.dLd();
            if (this.lFd.getForum() != null && (forum = this.lFd.getForum()) != null) {
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

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lFn = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fSh = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ftt = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.jgC.getAdapter() instanceof BdRecyclerAdapter) {
            this.jgC.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.gnp;
    }

    public void vY(boolean z) {
        this.mbK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fr(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mcx.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mcx.dlL(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ft(final int i) {
        ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bkw */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(b.this.mcx.getContext(), b.this.dlf(), i2, b.this.mcx.dkd());
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mcx.getContext(), i, shareItem, false));
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
        if (this.lFd == null || this.lFd.diN() == null) {
            return -1;
        }
        return this.lFd.diN().bok();
    }

    private void dsw() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.gnp.size(); i++) {
            n nVar = this.gnp.get(i);
            if (nVar instanceof com.baidu.tieba.pb.data.n) {
                this.mcC = i;
                z2 = true;
            } else if ((nVar instanceof com.baidu.tieba.pb.data.e) && ((com.baidu.tieba.pb.data.e) nVar).getTag() == this.mcw) {
                this.mcD = i;
                z = true;
            }
        }
        if (!z2) {
            this.mcC = -1;
        }
        if (!z) {
            this.mcD = -1;
        }
    }

    public int dsx() {
        return this.mcC;
    }

    public int dsy() {
        return this.mcD;
    }

    public boolean dlE() {
        if (this.mcx.dkd() != null) {
            return this.mcx.dkd().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lFo = aVar;
    }

    public void onDestroy() {
        if (this.mcy != null) {
            this.mcy.onDestroy();
        }
        if (this.mcq != null) {
            this.mcq.onDestroy();
        }
    }
}
