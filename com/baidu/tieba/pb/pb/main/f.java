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
    private ArrayList<com.baidu.adp.widget.ListView.m> eim;
    private BdTypeListView ekb;
    private List<com.baidu.adp.widget.ListView.a> gFK;
    private com.baidu.adp.widget.ListView.a heo;
    private PbFragment iDY;
    private com.baidu.tieba.card.divider.a iEA;
    private com.baidu.adp.widget.ListView.a iEB;
    private ae iEC;
    private af iED;
    private ac iEE;
    private com.baidu.tieba.pb.pb.a.c iEF;
    private g iEH;
    private com.baidu.tieba.pb.data.e iEI;
    private boolean iEN;
    private boolean iEO;
    private int iEQ;
    private Runnable iEU;
    private int iEW;
    private p iEt;
    private com.baidu.tieba.pb.pb.main.adapter.c iEu;
    private com.baidu.tieba.pb.pb.main.adapter.a iEv;
    private ai iEw;
    private ai iEx;
    private j iEy;
    private com.baidu.tieba.pb.video.a iEz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> iEG = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean iEJ = true;
    private boolean iEK = true;
    private boolean iEL = false;
    private boolean iEM = false;
    private boolean iEP = false;
    private String aqV = null;
    private PostData iER = null;
    private View.OnClickListener iES = null;
    private View.OnClickListener akt = null;
    private TbRichTextView.i dMx = null;
    private com.baidu.tieba.pb.a.c dqK = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> iET = new ArrayList();
    private int iEV = -1;
    private CustomMessageListener gvA = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cKG = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cKG();
                Iterator it = cKG.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(f.this.iDY);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.iEG.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cKG);
                f.this.iET.clear();
                f.this.iET.addAll(arrayList);
                if (f.this.ekb != null) {
                    f.this.ekb.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener dor = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.iEI != null && !com.baidu.adp.base.i.Z(f.this.iDY.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener iEX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.iDY != null && f.this.iEI != null && f.this.iEI.ckF() != null) {
                f.this.iDY.cmt().cpr().clw();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener gFM = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.gFK)) {
                f.this.bOZ();
                f.this.a(f.this.iEI, false);
            }
        }
    };

    public f(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iEQ = 0;
        this.width = -1;
        this.iEW = 0;
        this.iEQ = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.iEQ;
        this.iDY = pbFragment;
        this.ekb = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.dor);
        this.iEW = com.baidu.adp.lib.util.l.getEquipmentHeight(this.iDY.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iEt = new p(pbFragment, PostData.kgs);
        this.iEt.a((TbRichTextView.c) pbFragment);
        this.iEu = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.k.iCJ);
        this.iEv = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.iBr);
        this.iEw = new ai(pbFragment, com.baidu.tieba.pb.data.j.iCD);
        this.iEx = new ai(pbFragment, com.baidu.tieba.pb.data.j.iCE);
        this.iEy = new j(pbFragment, PostData.kgt);
        this.iEy.a((TbRichTextView.c) pbFragment);
        this.heo = com.baidu.tieba.recapp.r.cCv().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cMK);
        this.iEB = com.baidu.tieba.recapp.r.cCv().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cMO);
        this.iEE = new ac(pbFragment, com.baidu.tieba.pb.data.i.iCB);
        this.iEC = new ae(pbFragment, ab.iMi);
        this.iED = new af(pbFragment, at.cPU);
        this.iEF = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.kgy);
        this.iEz = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.iWP);
        this.iEA = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.iEH = new g(pbFragment, com.baidu.tbadk.core.data.l.cNU);
        this.asE.add(this.iEt);
        this.asE.add(this.iEu);
        this.asE.add(this.iEv);
        this.asE.add(this.iEy);
        this.asE.add(this.iEw);
        this.asE.add(this.iEx);
        this.asE.add(this.heo);
        this.asE.add(this.iEB);
        this.asE.add(this.iEE);
        this.asE.add(this.iEC);
        this.asE.add(this.iED);
        this.asE.add(this.iEz);
        this.asE.add(this.iEF);
        this.asE.add(this.iEA);
        this.asE.add(this.iEH);
        this.gvA.setPriority(1);
        this.gvA.setSelfListener(true);
        pbFragment.registerListener(this.gvA);
        bOY();
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
        com.baidu.adp.widget.ListView.m clX;
        bj cku;
        PostData postData2;
        if (eVar != null) {
            boolean z9 = false;
            if (this.iEI != eVar) {
                z9 = true;
                if ((eVar != null && !eVar.cks()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z9 = false;
                }
            }
            this.iEI = eVar;
            if (z9) {
                cmc();
                if (eVar != null) {
                    eVar.pu(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iEI != null && this.iEI.ckw() != null && this.iEI.ckw().size() > 0) {
                this.postList.addAll(this.iEI.ckw());
            }
            if (eVar != null && eVar.cku() != null && eVar.cku().aCo() != null) {
                this.aqV = eVar.cku().aCo().getUserId();
            }
            if (this.iEt != null) {
                this.iEt.setData(eVar);
                this.iEt.setFromCDN(this.mIsFromCDN);
                this.iEt.setImageMaxWidth(this.iEQ);
                this.iEt.pw(this.iEJ);
                this.iEt.y(this.akt);
                this.iEt.P(this.iES);
                this.iEt.setOnImageClickListener(this.dMx);
                this.iEt.setOnLongClickListener(this.mOnLongClickListener);
                this.iEt.setTbGestureDetector(this.dqK);
                this.iEy.setData(eVar);
                this.iEy.setFromCDN(this.mIsFromCDN);
                this.iEy.dI(this.aqV);
                this.iEy.pw(this.iEJ);
                this.iEy.y(this.akt);
                this.iEy.P(this.iES);
                this.iEy.setOnImageClickListener(this.dMx);
                this.iEy.setOnLongClickListener(this.mOnLongClickListener);
                this.iEy.setTbGestureDetector(this.dqK);
                this.iEu.setOnClickListener(this.akt);
                this.iEF.setOnClickListener(this.akt);
                this.iEz.setOnClickListener(this.iEX);
                if (this.iEB != null && (this.iEB instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.iEB).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iEG.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(eVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.dI(this.aqV);
                        next.setImageMaxWidth(this.iEQ);
                        next.pw(this.iEJ);
                        next.px(this.iEK);
                        next.py(this.iEP);
                        next.y(this.akt);
                        next.P(this.iES);
                        next.setOnImageClickListener(this.dMx);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.iEw.y(this.akt);
                this.iEx.y(this.akt);
                this.iEw.setData(eVar);
                this.iEv.setData(eVar);
                this.iEx.setData(eVar);
                this.iEC.setData(eVar);
                this.iED.setData(eVar);
                this.iEH.setPbData(eVar);
                this.iEH.setFrom(this.iDY.iIg);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>(eVar.ckw());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cLa() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.iER = postData;
                }
                boolean z10 = false;
                if (!this.iEK && postData != null) {
                    arrayList2.remove(postData);
                    z10 = true;
                    z2 = true;
                    if (eVar.aHK() && postData.cLc() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && eVar.ckB() != null) {
                    postData = eVar.ckB();
                    z10 = true;
                    z2 = true;
                    if (!this.iEK && eVar.aHK() && postData.cLc() != null) {
                        postData.c(null);
                    }
                }
                boolean z11 = z2;
                PostData postData3 = postData;
                boolean z12 = z10;
                dF(arrayList2);
                if (this.iDY.cmS()) {
                    if (eVar.ckw().size() > 0 && (postData2 = eVar.ckw().get(0)) != null && postData2.cLa() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        arrayList2.remove(0);
                    }
                } else {
                    int b = b(this.iEI, arrayList2, this.iEK);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, b, this.iEI.ckx());
                    }
                }
                int c = c(this.iEI, arrayList2, this.iEK);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, c, this.iEI.cky());
                }
                com.baidu.tieba.tbadkCore.s.o(arrayList2, 1);
                boolean z13 = false;
                int b2 = b(eVar, arrayList2);
                if (b2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iCD);
                    jVar.iCF = eVar.cku() != null ? cku.aCf() : 0L;
                    jVar.isNew = !this.iEK;
                    jVar.iCI = this.iDY.cnc();
                    jVar.sortType = eVar.iBE;
                    jVar.iCH = eVar.ckT();
                    jVar.isDynamic = eVar.ckS();
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
                        ((PostData) mVar).khg = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList2, a, f);
                    z3 = true;
                }
                int i6 = -1;
                if (z11) {
                    i6 = a(eVar, arrayList2, this.iEK);
                }
                if (i6 >= 0 && eVar.ckP() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.ckP());
                    z4 = true;
                    z5 = true;
                } else {
                    postData3.khf = true;
                    z4 = false;
                    z5 = z3;
                }
                if (i6 < 0 || !eVar.iBI || eVar.iBJ == null) {
                    i = i6;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.iBJ);
                    i = i6 + 1;
                }
                boolean z14 = false;
                if (!z11 || (clX = clX()) == null || i < 0) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i + 1, clX);
                    z14 = true;
                    z6 = true;
                }
                int i7 = -1;
                if (z11 && !z6) {
                    com.baidu.adp.widget.ListView.m clY = clY();
                    if (i >= 0) {
                        i7 = i + 1;
                    } else if (a >= 0) {
                        i7 = a;
                    } else if (b2 >= 0) {
                        i7 = b2;
                    }
                    if (clY != null && i7 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, i7, clY);
                        z7 = true;
                        i2 = i7;
                        arrayList = new ArrayList();
                        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.ckR()) && eVar.ckR().size() > 2) {
                            min = Math.min(eVar.ckR().size(), 7);
                            i4 = 0;
                            while (true) {
                                i5 = i4;
                                if (i5 < min) {
                                    break;
                                }
                                com.baidu.tbadk.core.data.l lVar = eVar.ckR().get(i5);
                                if (i5 == 0) {
                                    lVar.fu(true);
                                }
                                if (lVar.aCF() == null) {
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
                        this.iEt.pJ(z5);
                        z8 = false;
                        if (this.iDY.clB() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.iDY.clB().cnw())) {
                            z8 = true;
                        }
                        if (this.iEL && !z8) {
                            arrayList2.remove(postData3);
                            this.iEL = false;
                        }
                        if (eVar.ckP() != null) {
                            eVar.ckP().pv(!z4);
                        }
                        if (this.ekb != null) {
                            this.eim = arrayList2;
                            this.ekb.setData(this.eim);
                        }
                        if (!z8 && !z && ((this.iEN || this.iEM) && a != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.iEO)) {
                            this.iEU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.ekb.setSelectionFromTop(f.this.ekb.getHeaderViewsCount() + f.size(), 0 - f.this.iEW);
                                    f.this.iEO = false;
                                }
                            };
                            com.baidu.adp.lib.f.e.gx().post(this.iEU);
                        }
                        if (postData3 != null) {
                            if (this.iER != null && !this.iEM) {
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, this.iER);
                            } else {
                                PostData postData4 = new PostData();
                                postData4.Cw(1);
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData4);
                            }
                            this.ekb.setData(arrayList2);
                            return;
                        } else if (z12) {
                            com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData3);
                            this.ekb.setData(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z7 = z14;
                i2 = i7;
                arrayList = new ArrayList();
                if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.ckR())) {
                    min = Math.min(eVar.ckR().size(), 7);
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
                this.iEt.pJ(z5);
                z8 = false;
                if (this.iDY.clB() != null) {
                    z8 = true;
                }
                if (this.iEL) {
                    arrayList2.remove(postData3);
                    this.iEL = false;
                }
                if (eVar.ckP() != null) {
                }
                if (this.ekb != null) {
                }
                if (!z8) {
                    this.iEU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.ekb.setSelectionFromTop(f.this.ekb.getHeaderViewsCount() + f.size(), 0 - f.this.iEW);
                            f.this.iEO = false;
                        }
                    };
                    com.baidu.adp.lib.f.e.gx().post(this.iEU);
                }
                if (postData3 != null) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m clX() {
        PbModel clB = this.iDY.clB();
        if (clB == null) {
            return null;
        }
        String con = clB.con();
        if (TextUtils.isEmpty(con)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.Ja(con);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m clY() {
        if (this.iEI == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m cnL = this.iDY.clB().cnL();
        if (cnL == null) {
            cnL = this.iEI.ckJ();
        }
        if (cnL != null) {
            AdvertAppInfo.ILegoAdvert cKP = cnL.cKP();
            if (cKP != null) {
                cKP.setAdvertAppInfo(cnL.kK());
            }
            int aAp = cnL.cKO().aAp();
            if (aAp != 0) {
                a(cnL, aAp);
                if (aAp == 28 || aAp == 31 || cnL.cKO().goods == null) {
                    return null;
                }
                cnL.cKO().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                return null;
            }
            if (this.iEI.getForum() != null) {
                cnL.forumId = this.iEI.getForum().getId();
            }
            if (this.iEI.cku() != null) {
                cnL.threadId = com.baidu.adp.lib.f.b.toLong(this.iEI.cku().getId(), 0L);
            }
            if (this.iEI != null && this.iEI.getPage() != null) {
                cnL.pageNumber = this.iEI.getPage().aBi();
            }
            c(cnL);
            return cnL;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.iEM || eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckw()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.aHK() && this.iEK) ? 0 : -1;
        } else if (this.iDY.clB() == null || !this.iDY.clB().getIsFromMark()) {
            if (this.iDY.cmt() == null || !this.iDY.cmt().cqt()) {
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
                        if (postData.cLa() == 1 && postData.khc == 0) {
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
                return eVar.aHK() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckw()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(eVar.ckw(), 0)) == null) {
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
                if (postData.cLa() == 1 && postData.khc == 0) {
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
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckw()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.aHK()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.ckw().get(0) == null || eVar.ckw().get(0).cLa() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.ckF() == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckF().iCS)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.ckF().iCS;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.khq = true;
                postData.khe = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(eVar.ckF().iCT) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).khe = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).khe = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iCE);
        jVar.iCG = eVar.ckF().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void bOY() {
        if (this.iDY != null && !bOZ()) {
            this.iDY.registerListener(this.gFM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOZ() {
        if (this.iDY == null) {
            return false;
        }
        this.gFK = new ArrayList();
        ArrayList<BdUniqueId> cKs = com.baidu.tieba.tbadkCore.s.cKs();
        if (cKs == null || cKs.size() <= 0) {
            return false;
        }
        int size = cKs.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cdk().a(this.iDY.getPageContext(), cKs.get(i), 2);
            if (a != null) {
                this.asE.add(a);
                this.gFK.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFK)) {
            this.ekb.addAdapters(this.gFK);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.ekb.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.ckw() == null || eVar.ckx() == null || eVar.ckw().size() == 0 || eVar.cku() == null || arrayList == null) {
            return -1;
        }
        if (eVar.ckx().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.ckw().get(0) == null || eVar.ckw().get(0).cLa() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aBi() != eVar.getPage().aBf()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.ckw() == null || eVar.cky() == null || eVar.ckw().size() == 0 || eVar.cku() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cky().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.ckw().get(0) == null || eVar.ckw().get(0).cLa() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aBi() != eVar.getPage().aBf()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.ekb.getItem(i);
    }

    public ArrayList<PostData> clZ() {
        return this.postList;
    }

    public BdUniqueId yG(int i) {
        if (this.ekb.getItem(i) != null) {
            return this.ekb.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.iEV = cma();
        if (this.ekb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }

    public int cma() {
        if (this.ekb != null && this.ekb.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ekb.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.ekb.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.j.iCD) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cmb() {
        return this.iEV;
    }

    private void cmc() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.iEI != null) {
            ArrayList<PostData> ckw = this.iEI.ckw();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> ckI = this.iEI.ckI();
            if (ckI != null) {
                int size = ckI.size();
                if (ckw != null && ckw.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = ckI.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = ckI.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.gFI = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = ckI.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cKO() != null) {
                            int aAp = next3.cKO().aAp();
                            if (aAp != 0) {
                                a(next3, aAp);
                                if (aAp != 28 && aAp != 31) {
                                    if (next3.cKO().goods != null) {
                                        next3.cKO().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.w.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cKO().apk_name)) {
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
                        if (this.iEI.getForum() != null) {
                            mVar4.forumId = this.iEI.getForum().getId();
                        }
                        if (this.iEI.cku() != null) {
                            mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.iEI.cku().getId(), 0L);
                        }
                        if (this.iEI != null && this.iEI.getPage() != null) {
                            mVar4.pageNumber = this.iEI.getPage().aBi();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= ckw.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.iEK) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        ckw.add(position2, mVar4);
                        TiebaStatic.eventStat(this.iDY.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cKO().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.Ba(i);
        com.baidu.tieba.recapp.report.c.cDp().a(c);
        if (mVar != null && mVar.cKO() != null) {
            mVar.cKO().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cKO() != null && mVar.cKO().goods != null && mVar.cKO().goods.goods_style != 1001 && mVar.cKO().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.iEI != null && mVar.cKO() != null) {
            mVar.cKO().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.iEI.getPage() != null) {
                mVar.cKO().advertAppContext.pn = this.iEI.getPage().aBi();
            }
            mVar.cKO().advertAppContext.page = mVar.cKR();
            if (this.iEI.getForum() != null && (forum = this.iEI.getForum()) != null) {
                mVar.cKO().advertAppContext.fid = forum.getId();
                mVar.cKO().advertAppContext.cMB = forum.getFirst_class();
                mVar.cKO().advertAppContext.cMC = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cKO().advertAppContext.cMD = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cKO().advertAppContext.extensionInfo = mVar.cKO().ext_info;
            mVar.cKO().advertAppContext.Dn = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.iEt.setFromCDN(z);
        if (this.iEB != null && (this.iEB instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iEB).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iEG.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cmd() {
        return this.iEJ;
    }

    public void pw(boolean z) {
        this.iEJ = z;
    }

    public void px(boolean z) {
        this.iEK = z;
    }

    public void py(boolean z) {
        this.iEP = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iES = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMx = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqK = cVar;
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
                if (this.iEt != null) {
                    this.iEt.pause();
                    return;
                }
                return;
            case 2:
                if (this.iEt != null) {
                    this.iEt.resume();
                    return;
                }
                return;
            case 3:
                if (this.iEt != null) {
                    this.iEt.release();
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
                    if (!TextUtils.isEmpty(postData.aDu())) {
                        com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
                        aeVar.sx(postData.aDu());
                        list.set(i, aeVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iEU);
        if (this.iEw != null) {
            this.iEw.onDestroy();
        }
        if (this.iEx != null) {
            this.iEx.onDestroy();
        }
        if (this.iEu != null) {
            this.iEu.onDestroy();
        }
        if (this.iEv != null) {
            this.iEv.onDestroy();
        }
    }

    public void pC(boolean z) {
        this.iEM = z;
    }

    public void pD(boolean z) {
        this.iEN = z;
    }

    public void pE(boolean z) {
        this.iEL = z;
    }

    public void pF(boolean z) {
        this.iEO = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cme() {
        return this.iEu;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.eim;
    }

    public View cmf() {
        if (this.iEt == null || this.iEt.cmi() == null) {
            return null;
        }
        if (this.iEt.cmi().iGM != null && this.iEt.cmi().iGM.isShown()) {
            return this.iEt.cmi().iGM;
        }
        return this.iEt.cmi().iGL;
    }

    public q cmg() {
        if (this.iEt == null || this.iEt.cmi() == null) {
            return null;
        }
        return this.iEt.cmi();
    }
}
