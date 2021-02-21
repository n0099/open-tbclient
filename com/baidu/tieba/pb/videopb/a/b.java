package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.i;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.data.t;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.pb.main.ag;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.recapp.s;
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
    private ArrayList<n> gqm;
    private BdTypeRecyclerView jmy;
    private com.baidu.adp.widget.ListView.a kla;
    private PbFirstFloorEnterForumAdapter lNQ;
    private k lNV;
    private com.baidu.adp.widget.ListView.a lNY;
    private ag lOd;
    private PbReplyLoadMoreAdapter lOe;
    private f lOi;
    private SortSwitchButton.a lOt;
    private e mlF;
    private PbFirstFloorCommentAndPraiseAdapter mlG;
    private c mlH;
    private h mlI;
    private w mlJ;
    private DetailInfoAndReplyFragment mlN;
    private ak mlO;
    private y mlP;
    private j mlQ;
    private d mlR;
    private PbFirstFloorItemAdapter mlS;
    private final BdUniqueId mlM = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private boolean mlc = true;
    private String bkB = null;
    private boolean lOj = true;
    private boolean mIsFromCDN = false;
    private int mlT = -1;
    private int mlU = -1;
    private View.OnClickListener lOs = null;
    private View.OnClickListener bbI = null;
    private TbRichTextView.i fUw = null;
    private com.baidu.tieba.pb.a.c fvK = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener mlK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.FM(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.FK(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.FM(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mlN = detailInfoAndReplyFragment;
        this.jmy = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.mlF = new e(this.mlN.dog(), PostData.nwX);
        this.mlG = new PbFirstFloorCommentAndPraiseAdapter(this.mlN.dog(), p.lLM);
        this.mlG.setOnClickListener(this.mlK);
        this.mlH = new c(this.mlN.getContext(), t.TYPE);
        this.lNQ = new PbFirstFloorEnterForumAdapter(this.mlN.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mlO = new ak(this.mlN.dog(), o.lLF);
        this.mlP = new y(this.mlN.dog(), com.baidu.tieba.pb.data.k.lLo, this.mlN.getUniqueId());
        this.lOd = new ag(this.mlN.dog(), m.Yl);
        this.mlQ = new j(this.mlN.dog(), com.baidu.tieba.pb.data.e.lKf);
        this.mlI = new h(this.mlN.dog(), com.baidu.tbadk.core.data.p.eMv);
        this.mlI.uU(true);
        this.mlJ = new w(this.mlN.dog());
        this.lNV = new k(this.mlN.dog(), PostData.nwY);
        this.lNV.a((TbRichTextView.c) this.mlN.dog());
        this.lOe = new PbReplyLoadMoreAdapter(this.mlN.dog(), PostData.nxc);
        this.kla = s.dDt().a(this.mlN.dog().getBaseFragmentActivity(), AdvertAppInfo.eLf);
        this.lNY = s.dDt().a(this.mlN.dog().getBaseFragmentActivity(), AdvertAppInfo.eLj);
        this.mlR = new d(this.mlN.getPageContext(), cb.eQD, this.mlN.getUniqueId());
        this.mlR.a(this.jmy);
        this.mlS = new PbFirstFloorItemAdapter(this.mlN.getContext(), i.TYPE);
        this.bns.add(this.mlF);
        this.bns.add(this.mlG);
        this.bns.add(this.mlH);
        this.bns.add(this.lNQ);
        this.bns.add(this.mlO);
        this.bns.add(this.lOd);
        this.bns.add(this.mlP);
        this.bns.add(this.mlQ);
        this.bns.add(this.mlI);
        this.bns.add(this.mlJ);
        this.bns.add(this.kla);
        this.bns.add(this.lNY);
        this.bns.add(this.lNV);
        this.bns.add(this.lOe);
        this.bns.add(this.mlR);
        this.bns.add(this.mlS);
        this.jmy.addAdapters(this.bns);
    }

    public void setData(f fVar) {
        a(fVar, false);
    }

    public void a(f fVar, boolean z) {
        PostData postData;
        boolean z2;
        cb dlg;
        int i;
        com.baidu.tieba.tbadkCore.data.o oVar;
        int i2;
        int i3;
        boolean z3;
        int i4 = 1;
        if (fVar != null) {
            this.lOi = fVar;
            if (fVar != null && fVar.dlg() != null && fVar.dlg().bnQ() != null) {
                this.bkB = fVar.dlg().bnQ().getUserId();
            }
            if (this.gqm == null) {
                this.gqm = new ArrayList<>();
            }
            this.gqm.clear();
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
            PostData dlp = (postData != null || fVar.dlp() == null) ? postData : fVar.dlp();
            if (dlp != null) {
                this.gqm.add(dlp);
            }
            this.mlF.setPbData(fVar);
            this.mlF.gW(this.bkB);
            if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dli()) && fVar.dli().get(0) != null && fVar.dlg() != null) {
                fVar.dlg().a(fVar.dli().get(0).bpW());
                fVar.dlg().bt(fVar.dli().get(0).bpX());
            }
            if (fVar.dlg() != null && fVar.dlg().bpT() != null) {
                ca caVar = new ca();
                caVar.eJQ = fVar.dlg();
                caVar.eQe = true;
                this.gqm.add(caVar);
            }
            p pVar = new p(fVar.dlg(), fVar.getAnti());
            pVar.uH(false);
            pVar.lLO = false;
            this.gqm.add(pVar);
            if (dlp == null || dlp.nxY == null || (fVar.getForum() != null && TextUtils.equals(fVar.getForum().getName(), this.mlN.dmx().dmq()) && this.mlN.dmx().doD())) {
                z2 = false;
            } else {
                i iVar = new i(dlp.nxY);
                iVar.tid = this.mlN.dmx().doA();
                this.gqm.add(iVar);
                z2 = true;
            }
            if (!z2 && fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mlN.dmx().dmq()) || !this.mlN.dmx().doD())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.mlN.dmx().doA();
                hVar.lLl = false;
                this.gqm.add(hVar);
                pVar.uH(false);
                pVar.lLO = false;
            }
            o oVar2 = new o(o.lLF);
            oVar2.lLH = fVar.dlg() != null ? dlg.bnH() : 0L;
            oVar2.isNew = !this.mlN.dmx().doC();
            oVar2.lLK = doa();
            oVar2.sortType = fVar.lKn;
            oVar2.lLJ = fVar.dlK();
            oVar2.isDynamic = fVar.dlJ();
            oVar2.lLL = fVar.lKm;
            this.mlO.setData(fVar);
            this.gqm.add(oVar2);
            dmY();
            if (this.lNY != null && (this.lNY instanceof com.baidu.tieba.recapp.p)) {
                ((com.baidu.tieba.recapp.p) this.lNY).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dli().iterator();
            boolean z4 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dNF() == 1) {
                    z3 = z4;
                } else {
                    this.gqm.add(next2);
                    z3 = true;
                }
                z4 = z3;
            }
            if (!z4 && (!z || !com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                m mVar = new m();
                mVar.lLy = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                mVar.lLx = R.drawable.new_pic_emotion_03;
                mVar.gAL = -2;
                mVar.lLz = l.getDimens(this.mlN.getContext(), R.dimen.tbds74);
                this.gqm.add(mVar);
            }
            this.lNV.setData(fVar);
            this.lNV.setFromCDN(this.mIsFromCDN);
            this.lNV.gW(this.bkB);
            this.lNV.uJ(this.lOj);
            this.lNV.C(this.bbI);
            this.lNV.U(this.lOs);
            this.lNV.setOnImageClickListener(this.fUw);
            this.lNV.setOnLongClickListener(this.mOnLongClickListener);
            this.lNV.setTbGestureDetector(this.fvK);
            this.mlO.C(this.bbI);
            this.mlO.a(this.lOt);
            this.lOe.setOnClickListener(this.bbI);
            if (fVar.getPage().bmF() == 0) {
                if (z4) {
                    this.mlP.setOnClickListener(this.mlN.dog().duc());
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.gqm.add(kVar);
                }
                List<com.baidu.tieba.tbadkCore.data.o> dlN = fVar.dlN();
                if (dlN == null || dlN.isEmpty()) {
                    i = -1;
                    oVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = dlN.get(0);
                    i = oVar3.getPosition();
                    oVar = oVar3;
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlI())) {
                    com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.mlM);
                    this.gqm.add(eVar);
                    int i5 = 0;
                    com.baidu.tieba.tbadkCore.data.o oVar4 = oVar;
                    for (com.baidu.tbadk.core.data.p pVar2 : fVar.dlI()) {
                        if (dlN != null && i4 == i) {
                            if (oVar4 != null) {
                                c(oVar4);
                                this.gqm.add(oVar4);
                                i5++;
                                if (oVar4.getType() != AdvertAppInfo.eLf) {
                                    i4++;
                                }
                            }
                            if (i5 < dlN.size()) {
                                com.baidu.tieba.tbadkCore.data.o oVar5 = dlN.get(i5);
                                i2 = oVar5.getPosition();
                                i3 = i5;
                                oVar4 = oVar5;
                                this.gqm.add(pVar2);
                                i4++;
                                if (i4 == 4 && fVar.dlm() != null) {
                                    this.gqm.add(fVar.dlm());
                                    i4++;
                                }
                                i = i2;
                                i5 = i3;
                            }
                        }
                        i2 = i;
                        i3 = i5;
                        this.gqm.add(pVar2);
                        i4++;
                        if (i4 == 4) {
                            this.gqm.add(fVar.dlm());
                            i4++;
                        }
                        i = i2;
                        i5 = i3;
                    }
                }
            }
            if (this.jmy != null) {
                this.jmy.setData(this.gqm);
            }
            duO();
        }
    }

    private void dmY() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lOi != null && !this.lOi.lLb && this.lOi.aam != 2) {
            ArrayList<PostData> dli = this.lOi.dli();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dlx = this.lOi.dlx();
            if (dlx != null && !dlx.isEmpty() && dli != null && !dli.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dlx.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dlx.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jDY = sb.toString();
                        next2.position = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dlx.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dNt() != null) {
                        int blD = next3.dNt().blD();
                        if (blD != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, blD);
                            if (blD != 28 && blD != 31) {
                                if (next3.dNt().goods != null) {
                                    next3.dNt().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + blD);
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
                    if (this.lOi.getForum() != null) {
                        oVar4.forumId = this.lOi.getForum().getId();
                    }
                    if (this.lOi.dlg() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lOi.dlg().getId(), 0L);
                    }
                    if (this.lOi != null && this.lOi.getPage() != null) {
                        oVar4.pageNumber = this.lOi.getPage().bmD();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lOi.lLa;
                    if (position >= dli.size()) {
                        oVar4.position = position;
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, dli.size());
                        return;
                    }
                    if (!this.mlc) {
                        position--;
                        oVar4.position = position;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dli, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dli.add(position, oVar4);
                        TiebaStatic.eventStat(this.mlN.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dNt().apk_name);
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
        if (oVar != null && this.lOi != null && oVar.dNt() != null) {
            oVar.dNt().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lOi.getPage() != null) {
                oVar.dNt().advertAppContext.pn = this.lOi.getPage().bmD();
            }
            oVar.dNt().advertAppContext.page = oVar.dNw();
            if (this.lOi.getForum() != null && (forum = this.lOi.getForum()) != null) {
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

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOs = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fUw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fvK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.jmy.getAdapter() instanceof BdRecyclerAdapter) {
            this.jmy.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.gqm;
    }

    public void wp(boolean z) {
        this.mlc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FK(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mlN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mlN.doh(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM(final int i) {
        af.a(new ae<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: bkO */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(b.this.mlN.getContext(), b.this.dnB(), i2, b.this.mlN.dmx());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mlN.getContext(), i, shareItem, false));
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
        if (this.lOi == null || this.lOi.dlg() == null) {
            return -1;
        }
        return this.lOi.dlg().boC();
    }

    private void duO() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.gqm.size(); i++) {
            n nVar = this.gqm.get(i);
            if (nVar instanceof o) {
                this.mlT = i;
                z2 = true;
            } else if ((nVar instanceof com.baidu.tieba.pb.data.e) && ((com.baidu.tieba.pb.data.e) nVar).getTag() == this.mlM) {
                this.mlU = i;
                z = true;
            }
        }
        if (!z2) {
            this.mlT = -1;
        }
        if (!z) {
            this.mlU = -1;
        }
    }

    public int duP() {
        return this.mlT;
    }

    public int duQ() {
        return this.mlU;
    }

    public boolean doa() {
        if (this.mlN.dmx() != null) {
            return this.mlN.dmx().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lOt = aVar;
    }

    public void onDestroy() {
        if (this.mlO != null) {
            this.mlO.onDestroy();
        }
        if (this.mlG != null) {
            this.mlG.onDestroy();
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter duR() {
        return this.mlG;
    }

    public k duS() {
        return this.lNV;
    }
}
