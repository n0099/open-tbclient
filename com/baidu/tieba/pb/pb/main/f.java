package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class f {
    private ArrayList<com.baidu.adp.widget.ListView.m> eil;
    private BdTypeListView eka;
    private List<com.baidu.adp.widget.ListView.a> gFI;
    private com.baidu.adp.widget.ListView.a hem;
    private PbFragment iDW;
    private ae iEA;
    private af iEB;
    private ac iEC;
    private com.baidu.tieba.pb.pb.a.c iED;
    private g iEF;
    private com.baidu.tieba.pb.data.e iEG;
    private boolean iEL;
    private boolean iEM;
    private int iEO;
    private Runnable iES;
    private int iEU;
    private p iEr;
    private com.baidu.tieba.pb.pb.main.adapter.c iEs;
    private com.baidu.tieba.pb.pb.main.adapter.a iEt;
    private ai iEu;
    private ai iEv;
    private j iEw;
    private com.baidu.tieba.pb.video.a iEx;
    private com.baidu.tieba.card.divider.a iEy;
    private com.baidu.adp.widget.ListView.a iEz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> iEE = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean iEH = true;
    private boolean iEI = true;
    private boolean iEJ = false;
    private boolean iEK = false;
    private boolean iEN = false;
    private String aqV = null;
    private PostData iEP = null;
    private View.OnClickListener iEQ = null;
    private View.OnClickListener akt = null;
    private TbRichTextView.i dMw = null;
    private com.baidu.tieba.pb.a.c dqJ = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> iER = new ArrayList();
    private int iET = -1;
    private CustomMessageListener gvy = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cKE = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cKE();
                Iterator it = cKE.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(f.this.iDW);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.iEE.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cKE);
                f.this.iER.clear();
                f.this.iER.addAll(arrayList);
                if (f.this.eka != null) {
                    f.this.eka.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener doq = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.iEG != null && !com.baidu.adp.base.i.Z(f.this.iDW.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                Iterator<DownloadData> it = data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next().getStatus() == 0) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener iEV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.iDW != null && f.this.iEG != null && f.this.iEG.ckD() != null) {
                f.this.iDW.cmr().cpp().clu();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener gFK = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.gFI)) {
                f.this.bOX();
                f.this.a(f.this.iEG, false);
            }
        }
    };

    public f(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iEO = 0;
        this.width = -1;
        this.iEU = 0;
        this.iEO = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.iEO;
        this.iDW = pbFragment;
        this.eka = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.doq);
        this.iEU = com.baidu.adp.lib.util.l.getEquipmentHeight(this.iDW.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iEr = new p(pbFragment, PostData.kgq);
        this.iEr.a((TbRichTextView.c) pbFragment);
        this.iEs = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.k.iCH);
        this.iEt = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.iBp);
        this.iEu = new ai(pbFragment, com.baidu.tieba.pb.data.j.iCB);
        this.iEv = new ai(pbFragment, com.baidu.tieba.pb.data.j.iCC);
        this.iEw = new j(pbFragment, PostData.kgr);
        this.iEw.a((TbRichTextView.c) pbFragment);
        this.hem = com.baidu.tieba.recapp.r.cCt().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cMJ);
        this.iEz = com.baidu.tieba.recapp.r.cCt().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cMN);
        this.iEC = new ac(pbFragment, com.baidu.tieba.pb.data.i.iCz);
        this.iEA = new ae(pbFragment, ab.iMg);
        this.iEB = new af(pbFragment, at.cPT);
        this.iED = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.kgw);
        this.iEx = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.iWN);
        this.iEy = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.iEF = new g(pbFragment, com.baidu.tbadk.core.data.l.cNT);
        this.asE.add(this.iEr);
        this.asE.add(this.iEs);
        this.asE.add(this.iEt);
        this.asE.add(this.iEw);
        this.asE.add(this.iEu);
        this.asE.add(this.iEv);
        this.asE.add(this.hem);
        this.asE.add(this.iEz);
        this.asE.add(this.iEC);
        this.asE.add(this.iEA);
        this.asE.add(this.iEB);
        this.asE.add(this.iEx);
        this.asE.add(this.iED);
        this.asE.add(this.iEy);
        this.asE.add(this.iEF);
        this.gvy.setPriority(1);
        this.gvy.setSelfListener(true);
        pbFragment.registerListener(this.gvy);
        bOW();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.asE);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04c6 A[LOOP:3: B:175:0x04c4->B:176:0x04c6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x04a9 A[EDGE_INSN: B:251:0x04a9->B:165:0x04a9 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.pb.data.e eVar, boolean z) {
        PostData postData;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        ArrayList arrayList;
        boolean z8;
        int i3;
        int size;
        int min;
        int i4;
        int i5;
        com.baidu.adp.widget.ListView.m clV;
        bj cks;
        PostData postData2;
        if (eVar != null) {
            boolean z9 = false;
            if (this.iEG != eVar) {
                z9 = true;
                if ((eVar != null && !eVar.ckq()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z9 = false;
                }
            }
            this.iEG = eVar;
            if (z9) {
                cma();
                if (eVar != null) {
                    eVar.pu(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iEG != null && this.iEG.cku() != null && this.iEG.cku().size() > 0) {
                this.postList.addAll(this.iEG.cku());
            }
            if (eVar != null && eVar.cks() != null && eVar.cks().aCm() != null) {
                this.aqV = eVar.cks().aCm().getUserId();
            }
            if (this.iEr != null) {
                this.iEr.setData(eVar);
                this.iEr.setFromCDN(this.mIsFromCDN);
                this.iEr.setImageMaxWidth(this.iEO);
                this.iEr.pw(this.iEH);
                this.iEr.y(this.akt);
                this.iEr.P(this.iEQ);
                this.iEr.setOnImageClickListener(this.dMw);
                this.iEr.setOnLongClickListener(this.mOnLongClickListener);
                this.iEr.setTbGestureDetector(this.dqJ);
                this.iEw.setData(eVar);
                this.iEw.setFromCDN(this.mIsFromCDN);
                this.iEw.dI(this.aqV);
                this.iEw.pw(this.iEH);
                this.iEw.y(this.akt);
                this.iEw.P(this.iEQ);
                this.iEw.setOnImageClickListener(this.dMw);
                this.iEw.setOnLongClickListener(this.mOnLongClickListener);
                this.iEw.setTbGestureDetector(this.dqJ);
                this.iEs.setOnClickListener(this.akt);
                this.iED.setOnClickListener(this.akt);
                this.iEx.setOnClickListener(this.iEV);
                if (this.iEz != null && (this.iEz instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.iEz).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iEE.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(eVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.dI(this.aqV);
                        next.setImageMaxWidth(this.iEO);
                        next.pw(this.iEH);
                        next.px(this.iEI);
                        next.py(this.iEN);
                        next.y(this.akt);
                        next.P(this.iEQ);
                        next.setOnImageClickListener(this.dMw);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.iEu.y(this.akt);
                this.iEv.y(this.akt);
                this.iEu.setData(eVar);
                this.iEt.setData(eVar);
                this.iEv.setData(eVar);
                this.iEA.setData(eVar);
                this.iEB.setData(eVar);
                this.iEF.setPbData(eVar);
                this.iEF.setFrom(this.iDW.iIe);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>(eVar.cku());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cKY() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.iEP = postData;
                }
                boolean z10 = false;
                if (!this.iEI && postData != null) {
                    arrayList2.remove(postData);
                    z10 = true;
                    z2 = true;
                    if (eVar.aHI() && postData.cLa() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && eVar.ckz() != null) {
                    postData = eVar.ckz();
                    z10 = true;
                    z2 = true;
                    if (!this.iEI && eVar.aHI() && postData.cLa() != null) {
                        postData.c(null);
                    }
                }
                boolean z11 = z2;
                PostData postData3 = postData;
                boolean z12 = z10;
                dF(arrayList2);
                if (this.iDW.cmQ()) {
                    if (eVar.cku().size() > 0 && (postData2 = eVar.cku().get(0)) != null && postData2.cKY() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        arrayList2.remove(0);
                    }
                } else {
                    int b = b(this.iEG, arrayList2, this.iEI);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, b, this.iEG.ckv());
                    }
                }
                int c = c(this.iEG, arrayList2, this.iEI);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, c, this.iEG.ckw());
                }
                com.baidu.tieba.tbadkCore.s.o(arrayList2, 1);
                boolean z13 = false;
                int b2 = b(eVar, arrayList2);
                if (b2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iCB);
                    jVar.iCD = eVar.cks() != null ? cks.aCd() : 0L;
                    jVar.isNew = !this.iEI;
                    jVar.iCG = this.iDW.cna();
                    jVar.sortType = eVar.iBC;
                    jVar.iCF = eVar.ckR();
                    jVar.isDynamic = eVar.ckQ();
                    com.baidu.tbadk.core.util.v.add(arrayList2, b2, jVar);
                    z13 = true;
                }
                int a = a(eVar, arrayList2);
                final List<com.baidu.adp.widget.ListView.m> f = f(eVar);
                if (com.baidu.tbadk.core.util.v.isEmpty(f) || a < 0) {
                    z3 = z13;
                } else {
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList2, a);
                    if (mVar instanceof PostData) {
                        ((PostData) mVar).khe = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList2, a, f);
                    z3 = true;
                }
                int i6 = -1;
                if (z11) {
                    i6 = a(eVar, arrayList2, this.iEI);
                }
                if (i6 >= 0 && eVar.ckN() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.ckN());
                    z4 = true;
                    z5 = true;
                } else {
                    postData3.khd = true;
                    z4 = false;
                    z5 = z3;
                }
                if (i6 < 0 || !eVar.iBG || eVar.iBH == null) {
                    i = i6;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.iBH);
                    i = i6 + 1;
                }
                boolean z14 = false;
                if (!z11 || (clV = clV()) == null || i < 0) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i + 1, clV);
                    z14 = true;
                    z6 = true;
                }
                int i7 = -1;
                if (z11 && !z6) {
                    com.baidu.adp.widget.ListView.m clW = clW();
                    if (i >= 0) {
                        i7 = i + 1;
                    } else if (a >= 0) {
                        i7 = a;
                    } else if (b2 >= 0) {
                        i7 = b2;
                    }
                    if (clW != null && i7 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, i7, clW);
                        z7 = true;
                        i2 = i7;
                        arrayList = new ArrayList();
                        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.ckP()) && eVar.ckP().size() > 2) {
                            min = Math.min(eVar.ckP().size(), 7);
                            i4 = 0;
                            while (true) {
                                i5 = i4;
                                if (i5 < min) {
                                    break;
                                }
                                com.baidu.tbadk.core.data.l lVar = eVar.ckP().get(i5);
                                if (i5 == 0) {
                                    lVar.fu(true);
                                }
                                if (lVar.aCD() == null) {
                                    if (i5 == min - 1) {
                                        lVar.fv(true);
                                    }
                                } else if (i5 == min - 2) {
                                    lVar.fv(true);
                                } else if (i5 == min - 1) {
                                    lVar.fw(true);
                                }
                                arrayList.add(lVar);
                                i4 = i5 + 1;
                            }
                        }
                        if (z11 && arrayList != null) {
                            if (!z7 && i2 >= 0) {
                                i3 = i2 + 1;
                            } else if (!z7) {
                                i3 = i + 2;
                            } else if (i >= 0) {
                                i3 = i + 1;
                            } else if (a >= 0) {
                                i3 = a;
                            } else {
                                i3 = b2 >= 0 ? b2 : -1;
                            }
                            if (i3 >= 0 && arrayList.size() > 1) {
                                for (size = arrayList.size() - 1; size >= 0; size--) {
                                    com.baidu.tbadk.core.util.v.add(arrayList2, i3, arrayList.get(size));
                                }
                            }
                        }
                        this.iEr.pJ(z5);
                        z8 = false;
                        if (this.iDW.clz() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.iDW.clz().cnu())) {
                            z8 = true;
                        }
                        if (this.iEJ && !z8) {
                            arrayList2.remove(postData3);
                            this.iEJ = false;
                        }
                        if (eVar.ckN() != null) {
                            eVar.ckN().pv(!z4);
                        }
                        if (this.eka != null) {
                            this.eil = arrayList2;
                            this.eka.setData(this.eil);
                        }
                        if (!z8 && !z && ((this.iEL || this.iEK) && a != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.iEM)) {
                            this.iES = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.eka.setSelectionFromTop(f.this.eka.getHeaderViewsCount() + f.size(), 0 - f.this.iEU);
                                    f.this.iEM = false;
                                }
                            };
                            com.baidu.adp.lib.f.e.gx().post(this.iES);
                        }
                        if (postData3 != null) {
                            if (this.iEP != null && !this.iEK) {
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, this.iEP);
                            } else {
                                PostData postData4 = new PostData();
                                postData4.Cw(1);
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData4);
                            }
                            this.eka.setData(arrayList2);
                            return;
                        } else if (z12) {
                            com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData3);
                            this.eka.setData(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z7 = z14;
                i2 = i7;
                arrayList = new ArrayList();
                if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.ckP())) {
                    min = Math.min(eVar.ckP().size(), 7);
                    i4 = 0;
                    while (true) {
                        i5 = i4;
                        if (i5 < min) {
                        }
                        arrayList.add(lVar);
                        i4 = i5 + 1;
                    }
                }
                if (z11) {
                    if (!z7) {
                    }
                    if (!z7) {
                    }
                    if (i3 >= 0) {
                        while (size >= 0) {
                        }
                    }
                }
                this.iEr.pJ(z5);
                z8 = false;
                if (this.iDW.clz() != null) {
                    z8 = true;
                }
                if (this.iEJ) {
                    arrayList2.remove(postData3);
                    this.iEJ = false;
                }
                if (eVar.ckN() != null) {
                }
                if (this.eka != null) {
                }
                if (!z8) {
                    this.iES = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.eka.setSelectionFromTop(f.this.eka.getHeaderViewsCount() + f.size(), 0 - f.this.iEU);
                            f.this.iEM = false;
                        }
                    };
                    com.baidu.adp.lib.f.e.gx().post(this.iES);
                }
                if (postData3 != null) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m clV() {
        PbModel clz = this.iDW.clz();
        if (clz == null) {
            return null;
        }
        String col = clz.col();
        if (TextUtils.isEmpty(col)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.Ja(col);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m clW() {
        if (this.iEG == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m cnJ = this.iDW.clz().cnJ();
        if (cnJ == null) {
            cnJ = this.iEG.ckH();
        }
        if (cnJ != null) {
            AdvertAppInfo.ILegoAdvert cKN = cnJ.cKN();
            if (cKN != null) {
                cKN.setAdvertAppInfo(cnJ.kK());
            }
            int aAn = cnJ.cKM().aAn();
            if (aAn != 0) {
                a(cnJ, aAn);
                if (aAn == 28 || aAn == 31 || cnJ.cKM().goods == null) {
                    return null;
                }
                cnJ.cKM().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                return null;
            }
            if (this.iEG.getForum() != null) {
                cnJ.forumId = this.iEG.getForum().getId();
            }
            if (this.iEG.cks() != null) {
                cnJ.threadId = com.baidu.adp.lib.f.b.toLong(this.iEG.cks().getId(), 0L);
            }
            if (this.iEG != null && this.iEG.getPage() != null) {
                cnJ.pageNumber = this.iEG.getPage().aBg();
            }
            c(cnJ);
            return cnJ;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.iEK || eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cku()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.aHI() && this.iEI) ? 0 : -1;
        } else if (this.iDW.clz() == null || !this.iDW.clz().getIsFromMark()) {
            if (this.iDW.cmr() == null || !this.iDW.cmr().cqr()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = arrayList.get(i2);
                    if (mVar instanceof PostData) {
                        PostData postData = (PostData) mVar;
                        if (postData.cKY() == 1 && postData.kha == 0) {
                            z = true;
                            i = i2;
                            break;
                        }
                    }
                    i2++;
                }
                if (z) {
                    return i + 1;
                }
                return eVar.aHI() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cku()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cku(), 0)) == null) {
            return 0;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = false;
                i = 0;
                break;
            }
            com.baidu.adp.widget.ListView.m mVar = arrayList.get(i2);
            if (mVar instanceof PostData) {
                PostData postData = (PostData) mVar;
                if (postData.cKY() == 1 && postData.kha == 0) {
                    z = true;
                    i = i2;
                    break;
                }
            }
            i2++;
        }
        if (z) {
            return i + 1;
        }
        return 0;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cku()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.aHI()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.cku().get(0) == null || eVar.cku().get(0).cKY() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.ckD() == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckD().iCQ)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.ckD().iCQ;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.kho = true;
                postData.khc = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(eVar.ckD().iCR) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).khc = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).khc = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iCC);
        jVar.iCE = eVar.ckD().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void bOW() {
        if (this.iDW != null && !bOX()) {
            this.iDW.registerListener(this.gFK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOX() {
        if (this.iDW == null) {
            return false;
        }
        this.gFI = new ArrayList();
        ArrayList<BdUniqueId> cKq = com.baidu.tieba.tbadkCore.s.cKq();
        if (cKq == null || cKq.size() <= 0) {
            return false;
        }
        int size = cKq.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cdi().a(this.iDW.getPageContext(), cKq.get(i), 2);
            if (a != null) {
                this.asE.add(a);
                this.gFI.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFI)) {
            this.eka.addAdapters(this.gFI);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.eka.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.cku() == null || eVar.ckv() == null || eVar.cku().size() == 0 || eVar.cks() == null || arrayList == null) {
            return -1;
        }
        if (eVar.ckv().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cku().get(0) == null || eVar.cku().get(0).cKY() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aBg() != eVar.getPage().aBd()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.cku() == null || eVar.ckw() == null || eVar.cku().size() == 0 || eVar.cks() == null || arrayList == null) {
            return -1;
        }
        if (eVar.ckw().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cku().get(0) == null || eVar.cku().get(0).cKY() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aBg() != eVar.getPage().aBd()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.eka.getItem(i);
    }

    public ArrayList<PostData> clX() {
        return this.postList;
    }

    public BdUniqueId yG(int i) {
        if (this.eka.getItem(i) != null) {
            return this.eka.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.iET = clY();
        if (this.eka.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }

    public int clY() {
        if (this.eka != null && this.eka.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eka.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.eka.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.j.iCB) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int clZ() {
        return this.iET;
    }

    private void cma() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.iEG != null) {
            ArrayList<PostData> cku = this.iEG.cku();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> ckG = this.iEG.ckG();
            if (ckG != null) {
                int size = ckG.size();
                if (cku != null && cku.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = ckG.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next = it.next();
                        if (next != null && next.getAdId() != null) {
                            sb.append(next.getAdId());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = ckG.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.gFG = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = ckG.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cKM() != null) {
                            int aAn = next3.cKM().aAn();
                            if (aAn != 0) {
                                a(next3, aAn);
                                if (aAn != 28 && aAn != 31) {
                                    if (next3.cKM().goods != null) {
                                        next3.cKM().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.w.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cKM().apk_name)) {
                                int position = next3.getPosition();
                                if (position >= 1 && position < 30) {
                                    sparseArray.put(position, next3);
                                } else {
                                    b(next3, 33);
                                }
                            } else {
                                b(next3, 3);
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.m mVar3 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(sparseArray.keyAt(i));
                        if (mVar3 != null && (mVar2 = (com.baidu.tieba.tbadkCore.data.m) hashMap.put(mVar3.getAdId(), mVar3)) != null) {
                            b(mVar2, 30);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (mVar = (com.baidu.tieba.tbadkCore.data.m) entry.getValue()) != null) {
                            sparseArray.put(mVar.getPosition(), mVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.f.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: b */
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.m mVar4 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.iEG.getForum() != null) {
                            mVar4.forumId = this.iEG.getForum().getId();
                        }
                        if (this.iEG.cks() != null) {
                            mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.iEG.cks().getId(), 0L);
                        }
                        if (this.iEG != null && this.iEG.getPage() != null) {
                            mVar4.pageNumber = this.iEG.getPage().aBg();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= cku.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.iEI) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        cku.add(position2, mVar4);
                        TiebaStatic.eventStat(this.iDW.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cKM().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.Ba(i);
        com.baidu.tieba.recapp.report.c.cDn().a(c);
        if (mVar != null && mVar.cKM() != null) {
            mVar.cKM().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cKM() != null && mVar.cKM().goods != null && mVar.cKM().goods.goods_style != 1001 && mVar.cKM().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.iEG != null && mVar.cKM() != null) {
            mVar.cKM().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.iEG.getPage() != null) {
                mVar.cKM().advertAppContext.pn = this.iEG.getPage().aBg();
            }
            mVar.cKM().advertAppContext.page = mVar.cKP();
            if (this.iEG.getForum() != null && (forum = this.iEG.getForum()) != null) {
                mVar.cKM().advertAppContext.fid = forum.getId();
                mVar.cKM().advertAppContext.cMA = forum.getFirst_class();
                mVar.cKM().advertAppContext.cMB = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cKM().advertAppContext.cMC = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cKM().advertAppContext.extensionInfo = mVar.cKM().ext_info;
            mVar.cKM().advertAppContext.Dn = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.iEr.setFromCDN(z);
        if (this.iEz != null && (this.iEz instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iEz).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iEE.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cmb() {
        return this.iEH;
    }

    public void pw(boolean z) {
        this.iEH = z;
    }

    public void px(boolean z) {
        this.iEI = z;
    }

    public void py(boolean z) {
        this.iEN = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iEQ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqJ = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void yH(int i) {
        switch (i) {
            case 1:
                if (this.iEr != null) {
                    this.iEr.pause();
                    return;
                }
                return;
            case 2:
                if (this.iEr != null) {
                    this.iEr.resume();
                    return;
                }
                return;
            case 3:
                if (this.iEr != null) {
                    this.iEr.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dF(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.aDs())) {
                        com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
                        aeVar.sx(postData.aDs());
                        list.set(i, aeVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iES);
        if (this.iEu != null) {
            this.iEu.onDestroy();
        }
        if (this.iEv != null) {
            this.iEv.onDestroy();
        }
        if (this.iEs != null) {
            this.iEs.onDestroy();
        }
        if (this.iEt != null) {
            this.iEt.onDestroy();
        }
    }

    public void pC(boolean z) {
        this.iEK = z;
    }

    public void pD(boolean z) {
        this.iEL = z;
    }

    public void pE(boolean z) {
        this.iEJ = z;
    }

    public void pF(boolean z) {
        this.iEM = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cmc() {
        return this.iEs;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.eil;
    }

    public View cmd() {
        if (this.iEr == null || this.iEr.cmg() == null) {
            return null;
        }
        if (this.iEr.cmg().iGK != null && this.iEr.cmg().iGK.isShown()) {
            return this.iEr.cmg().iGK;
        }
        return this.iEr.cmg().iGJ;
    }

    public q cme() {
        if (this.iEr == null || this.iEr.cmg() == null) {
            return null;
        }
        return this.iEr.cmg();
    }
}
