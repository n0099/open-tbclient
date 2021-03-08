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
    private ArrayList<n> grV;
    private BdTypeRecyclerView joh;
    private com.baidu.adp.widget.ListView.a knc;
    private PbFirstFloorEnterForumAdapter lPS;
    private k lPX;
    private com.baidu.adp.widget.ListView.a lQa;
    private ag lQf;
    private PbReplyLoadMoreAdapter lQg;
    private f lQk;
    private SortSwitchButton.a lQv;
    private e mnH;
    private PbFirstFloorCommentAndPraiseAdapter mnI;
    private c mnJ;
    private h mnK;
    private w mnL;
    private DetailInfoAndReplyFragment mnP;
    private ak mnQ;
    private y mnR;
    private j mnS;
    private d mnT;
    private PbFirstFloorItemAdapter mnU;
    private final BdUniqueId mnO = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private boolean mne = true;
    private String bmb = null;
    private boolean lQl = true;
    private boolean mIsFromCDN = false;
    private int mnV = -1;
    private int mnW = -1;
    private View.OnClickListener lQu = null;
    private View.OnClickListener bdi = null;
    private TbRichTextView.i fVW = null;
    private com.baidu.tieba.pb.a.c fxj = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener mnM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.FN(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.FP(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.FN(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.FP(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mnP = detailInfoAndReplyFragment;
        this.joh = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.mnH = new e(this.mnP.dop(), PostData.nzc);
        this.mnI = new PbFirstFloorCommentAndPraiseAdapter(this.mnP.dop(), p.lNO);
        this.mnI.setOnClickListener(this.mnM);
        this.mnJ = new c(this.mnP.getContext(), t.TYPE);
        this.lPS = new PbFirstFloorEnterForumAdapter(this.mnP.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mnQ = new ak(this.mnP.dop(), o.lNH);
        this.mnR = new y(this.mnP.dop(), com.baidu.tieba.pb.data.k.lNq, this.mnP.getUniqueId());
        this.lQf = new ag(this.mnP.dop(), m.ZE);
        this.mnS = new j(this.mnP.dop(), com.baidu.tieba.pb.data.e.lMh);
        this.mnK = new h(this.mnP.dop(), com.baidu.tbadk.core.data.p.eNW);
        this.mnK.uU(true);
        this.mnL = new w(this.mnP.dop());
        this.lPX = new k(this.mnP.dop(), PostData.nzd);
        this.lPX.a((TbRichTextView.c) this.mnP.dop());
        this.lQg = new PbReplyLoadMoreAdapter(this.mnP.dop(), PostData.nzh);
        this.knc = s.dDB().a(this.mnP.dop().getBaseFragmentActivity(), AdvertAppInfo.eMG);
        this.lQa = s.dDB().a(this.mnP.dop().getBaseFragmentActivity(), AdvertAppInfo.eMK);
        this.mnT = new d(this.mnP.getPageContext(), cb.eSe, this.mnP.getUniqueId());
        this.mnT.a(this.joh);
        this.mnU = new PbFirstFloorItemAdapter(this.mnP.getContext(), i.TYPE);
        this.boS.add(this.mnH);
        this.boS.add(this.mnI);
        this.boS.add(this.mnJ);
        this.boS.add(this.lPS);
        this.boS.add(this.mnQ);
        this.boS.add(this.lQf);
        this.boS.add(this.mnR);
        this.boS.add(this.mnS);
        this.boS.add(this.mnK);
        this.boS.add(this.mnL);
        this.boS.add(this.knc);
        this.boS.add(this.lQa);
        this.boS.add(this.lPX);
        this.boS.add(this.lQg);
        this.boS.add(this.mnT);
        this.boS.add(this.mnU);
        this.joh.addAdapters(this.boS);
    }

    public void setData(f fVar) {
        a(fVar, false);
    }

    public void a(f fVar, boolean z) {
        PostData postData;
        boolean z2;
        cb dlp;
        int i;
        com.baidu.tieba.tbadkCore.data.o oVar;
        int i2;
        int i3;
        boolean z3;
        int i4 = 1;
        if (fVar != null) {
            this.lQk = fVar;
            if (fVar != null && fVar.dlp() != null && fVar.dlp().bnS() != null) {
                this.bmb = fVar.dlp().bnS().getUserId();
            }
            if (this.grV == null) {
                this.grV = new ArrayList<>();
            }
            this.grV.clear();
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
            PostData dly = (postData != null || fVar.dly() == null) ? postData : fVar.dly();
            if (dly != null) {
                this.grV.add(dly);
            }
            this.mnH.setPbData(fVar);
            this.mnH.hc(this.bmb);
            if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlr()) && fVar.dlr().get(0) != null && fVar.dlp() != null) {
                fVar.dlp().a(fVar.dlr().get(0).bpY());
                fVar.dlp().bt(fVar.dlr().get(0).bpZ());
            }
            if (fVar.dlp() != null && fVar.dlp().bpV() != null) {
                ca caVar = new ca();
                caVar.eLr = fVar.dlp();
                caVar.eRF = true;
                this.grV.add(caVar);
            }
            p pVar = new p(fVar.dlp(), fVar.getAnti());
            pVar.uH(false);
            pVar.lNQ = false;
            this.grV.add(pVar);
            if (dly == null || dly.nAd == null || (fVar.getForum() != null && TextUtils.equals(fVar.getForum().getName(), this.mnP.dmG().dmz()) && this.mnP.dmG().doM())) {
                z2 = false;
            } else {
                i iVar = new i(dly.nAd);
                iVar.tid = this.mnP.dmG().doJ();
                this.grV.add(iVar);
                z2 = true;
            }
            if (!z2 && fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mnP.dmG().dmz()) || !this.mnP.dmG().doM())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.mnP.dmG().doJ();
                hVar.lNn = false;
                this.grV.add(hVar);
                pVar.uH(false);
                pVar.lNQ = false;
            }
            o oVar2 = new o(o.lNH);
            oVar2.lNJ = fVar.dlp() != null ? dlp.bnJ() : 0L;
            oVar2.isNew = !this.mnP.dmG().doL();
            oVar2.lNM = doj();
            oVar2.sortType = fVar.lMp;
            oVar2.lNL = fVar.dlT();
            oVar2.isDynamic = fVar.dlS();
            oVar2.lNN = fVar.lMo;
            this.mnQ.setData(fVar);
            this.grV.add(oVar2);
            dnh();
            if (this.lQa != null && (this.lQa instanceof com.baidu.tieba.recapp.p)) {
                ((com.baidu.tieba.recapp.p) this.lQa).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dlr().iterator();
            boolean z4 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dNO() == 1) {
                    z3 = z4;
                } else {
                    this.grV.add(next2);
                    z3 = true;
                }
                z4 = z3;
            }
            if (!z4 && (!z || !com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                m mVar = new m();
                mVar.lNA = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                mVar.lNz = R.drawable.new_pic_emotion_03;
                mVar.gCu = -2;
                mVar.lNB = l.getDimens(this.mnP.getContext(), R.dimen.tbds74);
                this.grV.add(mVar);
            }
            this.lPX.setData(fVar);
            this.lPX.setFromCDN(this.mIsFromCDN);
            this.lPX.hc(this.bmb);
            this.lPX.uJ(this.lQl);
            this.lPX.C(this.bdi);
            this.lPX.V(this.lQu);
            this.lPX.setOnImageClickListener(this.fVW);
            this.lPX.setOnLongClickListener(this.mOnLongClickListener);
            this.lPX.setTbGestureDetector(this.fxj);
            this.mnQ.C(this.bdi);
            this.mnQ.a(this.lQv);
            this.lQg.setOnClickListener(this.bdi);
            if (fVar.getPage().bmH() == 0) {
                if (z4) {
                    this.mnR.setOnClickListener(this.mnP.dop().dul());
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
                    kVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.grV.add(kVar);
                }
                List<com.baidu.tieba.tbadkCore.data.o> dlW = fVar.dlW();
                if (dlW == null || dlW.isEmpty()) {
                    i = -1;
                    oVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = dlW.get(0);
                    i = oVar3.getPosition();
                    oVar = oVar3;
                }
                if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlR())) {
                    com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.mnO);
                    this.grV.add(eVar);
                    int i5 = 0;
                    com.baidu.tieba.tbadkCore.data.o oVar4 = oVar;
                    for (com.baidu.tbadk.core.data.p pVar2 : fVar.dlR()) {
                        if (dlW != null && i4 == i) {
                            if (oVar4 != null) {
                                c(oVar4);
                                this.grV.add(oVar4);
                                i5++;
                                if (oVar4.getType() != AdvertAppInfo.eMG) {
                                    i4++;
                                }
                            }
                            if (i5 < dlW.size()) {
                                com.baidu.tieba.tbadkCore.data.o oVar5 = dlW.get(i5);
                                i2 = oVar5.getPosition();
                                i3 = i5;
                                oVar4 = oVar5;
                                this.grV.add(pVar2);
                                i4++;
                                if (i4 == 4 && fVar.dlv() != null) {
                                    this.grV.add(fVar.dlv());
                                    i4++;
                                }
                                i = i2;
                                i5 = i3;
                            }
                        }
                        i2 = i;
                        i3 = i5;
                        this.grV.add(pVar2);
                        i4++;
                        if (i4 == 4) {
                            this.grV.add(fVar.dlv());
                            i4++;
                        }
                        i = i2;
                        i5 = i3;
                    }
                }
            }
            if (this.joh != null) {
                this.joh.setData(this.grV);
            }
            duX();
        }
    }

    private void dnh() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lQk != null && !this.lQk.lNd && this.lQk.abG != 2) {
            ArrayList<PostData> dlr = this.lQk.dlr();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dlG = this.lQk.dlG();
            if (dlG != null && !dlG.isEmpty() && dlr != null && !dlr.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dlG.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dlG.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jFH = sb.toString();
                        next2.position = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dlG.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dNC() != null) {
                        int blF = next3.dNC().blF();
                        if (blF != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, blF);
                            if (blF != 28 && blF != 31) {
                                if (next3.dNC().goods != null) {
                                    next3.dNC().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + blF);
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
                    if (this.lQk.getForum() != null) {
                        oVar4.forumId = this.lQk.getForum().getId();
                    }
                    if (this.lQk.dlp() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lQk.dlp().getId(), 0L);
                    }
                    if (this.lQk != null && this.lQk.getPage() != null) {
                        oVar4.pageNumber = this.lQk.getPage().bmF();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lQk.lNc;
                    if (position >= dlr.size()) {
                        oVar4.position = position;
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, dlr.size());
                        return;
                    }
                    if (!this.mne) {
                        position--;
                        oVar4.position = position;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dlr, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dlr.add(position, oVar4);
                        TiebaStatic.eventStat(this.mnP.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dNC().apk_name);
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
        if (oVar != null && this.lQk != null && oVar.dNC() != null) {
            oVar.dNC().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lQk.getPage() != null) {
                oVar.dNC().advertAppContext.pn = this.lQk.getPage().bmF();
            }
            oVar.dNC().advertAppContext.page = oVar.dNF();
            if (this.lQk.getForum() != null && (forum = this.lQk.getForum()) != null) {
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

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lQu = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fVW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fxj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.joh.getAdapter() instanceof BdRecyclerAdapter) {
            this.joh.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.grV;
    }

    public void wp(boolean z) {
        this.mne = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FN(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mnP.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mnP.doq(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP(final int i) {
        af.a(new ae<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ae
            /* renamed from: bkQ */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(b.this.mnP.getContext(), b.this.dnK(), i2, b.this.mnP.dmG());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mnP.getContext(), i, shareItem, false));
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
        if (this.lQk == null || this.lQk.dlp() == null) {
            return -1;
        }
        return this.lQk.dlp().boE();
    }

    private void duX() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.grV.size(); i++) {
            n nVar = this.grV.get(i);
            if (nVar instanceof o) {
                this.mnV = i;
                z2 = true;
            } else if ((nVar instanceof com.baidu.tieba.pb.data.e) && ((com.baidu.tieba.pb.data.e) nVar).getTag() == this.mnO) {
                this.mnW = i;
                z = true;
            }
        }
        if (!z2) {
            this.mnV = -1;
        }
        if (!z) {
            this.mnW = -1;
        }
    }

    public int duY() {
        return this.mnV;
    }

    public int duZ() {
        return this.mnW;
    }

    public boolean doj() {
        if (this.mnP.dmG() != null) {
            return this.mnP.dmG().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lQv = aVar;
    }

    public void onDestroy() {
        if (this.mnQ != null) {
            this.mnQ.onDestroy();
        }
        if (this.mnI != null) {
            this.mnI.onDestroy();
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter dva() {
        return this.mnI;
    }

    public k dvb() {
        return this.lPX;
    }
}
