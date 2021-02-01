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
    private ArrayList<n> gpY;
    private BdTypeRecyclerView jmj;
    private com.baidu.adp.widget.ListView.a kkM;
    private PbFirstFloorEnterForumAdapter lNB;
    private k lNG;
    private com.baidu.adp.widget.ListView.a lNJ;
    private ag lNO;
    private PbReplyLoadMoreAdapter lNP;
    private f lNT;
    private SortSwitchButton.a lOe;
    private y mlA;
    private j mlB;
    private d mlC;
    private PbFirstFloorItemAdapter mlD;
    private e mlq;
    private PbFirstFloorCommentAndPraiseAdapter mlr;
    private c mls;
    private h mlt;
    private w mlu;
    private DetailInfoAndReplyFragment mly;
    private ak mlz;
    private final BdUniqueId mlx = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private boolean mkN = true;
    private String bkB = null;
    private boolean lNU = true;
    private boolean mIsFromCDN = false;
    private int mlE = -1;
    private int mlF = -1;
    private View.OnClickListener lOd = null;
    private View.OnClickListener bbI = null;
    private TbRichTextView.i fUw = null;
    private com.baidu.tieba.pb.a.c fvK = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener mlv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
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
        this.mly = detailInfoAndReplyFragment;
        this.jmj = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.mlq = new e(this.mly.dnZ(), PostData.nwx);
        this.mlr = new PbFirstFloorCommentAndPraiseAdapter(this.mly.dnZ(), p.lLx);
        this.mlr.setOnClickListener(this.mlv);
        this.mls = new c(this.mly.getContext(), t.TYPE);
        this.lNB = new PbFirstFloorEnterForumAdapter(this.mly.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mlz = new ak(this.mly.dnZ(), o.lLq);
        this.mlA = new y(this.mly.dnZ(), com.baidu.tieba.pb.data.k.lKZ, this.mly.getUniqueId());
        this.lNO = new ag(this.mly.dnZ(), m.Yl);
        this.mlB = new j(this.mly.dnZ(), com.baidu.tieba.pb.data.e.lJR);
        this.mlt = new h(this.mly.dnZ(), com.baidu.tbadk.core.data.p.eMv);
        this.mlt.uU(true);
        this.mlu = new w(this.mly.dnZ());
        this.lNG = new k(this.mly.dnZ(), PostData.nwy);
        this.lNG.a((TbRichTextView.c) this.mly.dnZ());
        this.lNP = new PbReplyLoadMoreAdapter(this.mly.dnZ(), PostData.nwC);
        this.kkM = r.dDm().a(this.mly.dnZ().getBaseFragmentActivity(), AdvertAppInfo.eLf);
        this.lNJ = r.dDm().a(this.mly.dnZ().getBaseFragmentActivity(), AdvertAppInfo.eLj);
        this.mlC = new d(this.mly.getPageContext(), cb.eQD, this.mly.getUniqueId());
        this.mlC.a(this.jmj);
        this.mlD = new PbFirstFloorItemAdapter(this.mly.getContext(), i.TYPE);
        this.bns.add(this.mlq);
        this.bns.add(this.mlr);
        this.bns.add(this.mls);
        this.bns.add(this.lNB);
        this.bns.add(this.mlz);
        this.bns.add(this.lNO);
        this.bns.add(this.mlA);
        this.bns.add(this.mlB);
        this.bns.add(this.mlt);
        this.bns.add(this.mlu);
        this.bns.add(this.kkM);
        this.bns.add(this.lNJ);
        this.bns.add(this.lNG);
        this.bns.add(this.lNP);
        this.bns.add(this.mlC);
        this.bns.add(this.mlD);
        this.jmj.addAdapters(this.bns);
    }

    public void setData(f fVar) {
        a(fVar, false);
    }

    public void a(f fVar, boolean z) {
        PostData postData;
        boolean z2;
        cb dkZ;
        int i;
        com.baidu.tieba.tbadkCore.data.o oVar;
        int i2;
        int i3;
        boolean z3;
        int i4 = 1;
        if (fVar != null) {
            this.lNT = fVar;
            if (fVar != null && fVar.dkZ() != null && fVar.dkZ().bnQ() != null) {
                this.bkB = fVar.dkZ().bnQ().getUserId();
            }
            if (this.gpY == null) {
                this.gpY = new ArrayList<>();
            }
            this.gpY.clear();
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
            PostData dli = (postData != null || fVar.dli() == null) ? postData : fVar.dli();
            if (dli != null) {
                this.gpY.add(dli);
            }
            this.mlq.setPbData(fVar);
            this.mlq.gW(this.bkB);
            if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlb()) && fVar.dlb().get(0) != null && fVar.dkZ() != null) {
                fVar.dkZ().a(fVar.dlb().get(0).bpW());
                fVar.dkZ().bt(fVar.dlb().get(0).bpX());
            }
            if (fVar.dkZ() != null && fVar.dkZ().bpT() != null) {
                ca caVar = new ca();
                caVar.eJQ = fVar.dkZ();
                caVar.eQe = true;
                this.gpY.add(caVar);
            }
            p pVar = new p(fVar.dkZ(), fVar.getAnti());
            pVar.uH(false);
            pVar.lLz = false;
            this.gpY.add(pVar);
            if (dli == null || dli.nxy == null || (fVar.getForum() != null && TextUtils.equals(fVar.getForum().getName(), this.mly.dmq().dmj()) && this.mly.dmq().dow())) {
                z2 = false;
            } else {
                i iVar = new i(dli.nxy);
                iVar.tid = this.mly.dmq().dot();
                this.gpY.add(iVar);
                z2 = true;
            }
            if (!z2 && fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mly.dmq().dmj()) || !this.mly.dmq().dow())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.mly.dmq().dot();
                hVar.lKW = false;
                this.gpY.add(hVar);
                pVar.uH(false);
                pVar.lLz = false;
            }
            o oVar2 = new o(o.lLq);
            oVar2.lLs = fVar.dkZ() != null ? dkZ.bnH() : 0L;
            oVar2.isNew = !this.mly.dmq().dov();
            oVar2.lLv = dnT();
            oVar2.sortType = fVar.lJZ;
            oVar2.lLu = fVar.dlD();
            oVar2.isDynamic = fVar.dlC();
            oVar2.lLw = fVar.lJY;
            this.mlz.setData(fVar);
            this.gpY.add(oVar2);
            dmR();
            if (this.lNJ != null && (this.lNJ instanceof com.baidu.tieba.recapp.o)) {
                ((com.baidu.tieba.recapp.o) this.lNJ).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dlb().iterator();
            boolean z4 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dNx() == 1) {
                    z3 = z4;
                } else {
                    this.gpY.add(next2);
                    z3 = true;
                }
                z4 = z3;
            }
            if (!z4 && (!z || !com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                m mVar = new m();
                mVar.lLj = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                mVar.lLi = R.drawable.new_pic_emotion_03;
                mVar.gAx = -2;
                mVar.lLk = l.getDimens(this.mly.getContext(), R.dimen.tbds74);
                this.gpY.add(mVar);
            }
            this.lNG.setData(fVar);
            this.lNG.setFromCDN(this.mIsFromCDN);
            this.lNG.gW(this.bkB);
            this.lNG.uJ(this.lNU);
            this.lNG.C(this.bbI);
            this.lNG.U(this.lOd);
            this.lNG.setOnImageClickListener(this.fUw);
            this.lNG.setOnLongClickListener(this.mOnLongClickListener);
            this.lNG.setTbGestureDetector(this.fvK);
            this.mlz.C(this.bbI);
            this.mlz.a(this.lOe);
            this.lNP.setOnClickListener(this.bbI);
            if (fVar.getPage().bmF() == 0) {
                if (z4) {
                    this.mlA.setOnClickListener(this.mly.dnZ().dtV());
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.gpY.add(kVar);
                }
                List<com.baidu.tieba.tbadkCore.data.o> dlG = fVar.dlG();
                if (dlG == null || dlG.isEmpty()) {
                    i = -1;
                    oVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = dlG.get(0);
                    i = oVar3.getPosition();
                    oVar = oVar3;
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlB())) {
                    com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.mlx);
                    this.gpY.add(eVar);
                    int i5 = 0;
                    com.baidu.tieba.tbadkCore.data.o oVar4 = oVar;
                    for (com.baidu.tbadk.core.data.p pVar2 : fVar.dlB()) {
                        if (dlG != null && i4 == i) {
                            if (oVar4 != null) {
                                c(oVar4);
                                this.gpY.add(oVar4);
                                i5++;
                                if (oVar4.getType() != AdvertAppInfo.eLf) {
                                    i4++;
                                }
                            }
                            if (i5 < dlG.size()) {
                                com.baidu.tieba.tbadkCore.data.o oVar5 = dlG.get(i5);
                                i2 = oVar5.getPosition();
                                i3 = i5;
                                oVar4 = oVar5;
                                this.gpY.add(pVar2);
                                i4++;
                                if (i4 == 4 && fVar.dlf() != null) {
                                    this.gpY.add(fVar.dlf());
                                    i4++;
                                }
                                i = i2;
                                i5 = i3;
                            }
                        }
                        i2 = i;
                        i3 = i5;
                        this.gpY.add(pVar2);
                        i4++;
                        if (i4 == 4) {
                            this.gpY.add(fVar.dlf());
                            i4++;
                        }
                        i = i2;
                        i5 = i3;
                    }
                }
            }
            if (this.jmj != null) {
                this.jmj.setData(this.gpY);
            }
            duH();
        }
    }

    private void dmR() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lNT != null && !this.lNT.lKN && this.lNT.aam != 2) {
            ArrayList<PostData> dlb = this.lNT.dlb();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dlq = this.lNT.dlq();
            if (dlq != null && !dlq.isEmpty() && dlb != null && !dlb.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dlq.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dlq.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jDK = sb.toString();
                        next2.position = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dlq.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dNl() != null) {
                        int blD = next3.dNl().blD();
                        if (blD != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, blD);
                            if (blD != 28 && blD != 31) {
                                if (next3.dNl().goods != null) {
                                    next3.dNl().goods.goods_style = -1001;
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
                    if (this.lNT.getForum() != null) {
                        oVar4.forumId = this.lNT.getForum().getId();
                    }
                    if (this.lNT.dkZ() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lNT.dkZ().getId(), 0L);
                    }
                    if (this.lNT != null && this.lNT.getPage() != null) {
                        oVar4.pageNumber = this.lNT.getPage().bmD();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lNT.lKM;
                    if (position >= dlb.size()) {
                        oVar4.position = position;
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, dlb.size());
                        return;
                    }
                    if (!this.mkN) {
                        position--;
                        oVar4.position = position;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dlb, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dlb.add(position, oVar4);
                        TiebaStatic.eventStat(this.mly.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dNl().apk_name);
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
        if (oVar != null && this.lNT != null && oVar.dNl() != null) {
            oVar.dNl().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lNT.getPage() != null) {
                oVar.dNl().advertAppContext.pn = this.lNT.getPage().bmD();
            }
            oVar.dNl().advertAppContext.page = oVar.dNo();
            if (this.lNT.getForum() != null && (forum = this.lNT.getForum()) != null) {
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

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOd = onClickListener;
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
        if (this.jmj.getAdapter() instanceof BdRecyclerAdapter) {
            this.jmj.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.gpY;
    }

    public void wp(boolean z) {
        this.mkN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FK(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mly.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mly.doa(), true, i)));
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
                return com.baidu.tieba.pb.pb.main.d.b.a(b.this.mly.getContext(), b.this.dnu(), i2, b.this.mly.dmq());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mly.getContext(), i, shareItem, false));
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
        if (this.lNT == null || this.lNT.dkZ() == null) {
            return -1;
        }
        return this.lNT.dkZ().boC();
    }

    private void duH() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.gpY.size(); i++) {
            n nVar = this.gpY.get(i);
            if (nVar instanceof o) {
                this.mlE = i;
                z2 = true;
            } else if ((nVar instanceof com.baidu.tieba.pb.data.e) && ((com.baidu.tieba.pb.data.e) nVar).getTag() == this.mlx) {
                this.mlF = i;
                z = true;
            }
        }
        if (!z2) {
            this.mlE = -1;
        }
        if (!z) {
            this.mlF = -1;
        }
    }

    public int duI() {
        return this.mlE;
    }

    public int duJ() {
        return this.mlF;
    }

    public boolean dnT() {
        if (this.mly.dmq() != null) {
            return this.mly.dmq().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lOe = aVar;
    }

    public void onDestroy() {
        if (this.mlz != null) {
            this.mlz.onDestroy();
        }
        if (this.mlr != null) {
            this.mlr.onDestroy();
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter duK() {
        return this.mlr;
    }

    public k duL() {
        return this.lNG;
    }
}
