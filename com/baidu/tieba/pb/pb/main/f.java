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
    private ArrayList<com.baidu.adp.widget.ListView.m> eiz;
    private BdTypeListView eko;
    private List<com.baidu.adp.widget.ListView.a> gFW;
    private com.baidu.adp.widget.ListView.a heA;
    private p iEF;
    private com.baidu.tieba.pb.pb.main.adapter.c iEG;
    private com.baidu.tieba.pb.pb.main.adapter.a iEH;
    private ai iEI;
    private ai iEJ;
    private j iEK;
    private com.baidu.tieba.pb.video.a iEL;
    private com.baidu.tieba.card.divider.a iEM;
    private com.baidu.adp.widget.ListView.a iEN;
    private ae iEO;
    private af iEP;
    private ac iEQ;
    private com.baidu.tieba.pb.pb.a.c iER;
    private g iET;
    private com.baidu.tieba.pb.data.e iEU;
    private boolean iEZ;
    private PbFragment iEk;
    private boolean iFa;
    private int iFc;
    private Runnable iFg;
    private int iFi;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> iES = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean iEV = true;
    private boolean iEW = true;
    private boolean iEX = false;
    private boolean iEY = false;
    private boolean iFb = false;
    private String aqW = null;
    private PostData iFd = null;
    private View.OnClickListener iFe = null;
    private View.OnClickListener aku = null;
    private TbRichTextView.i dMK = null;
    private com.baidu.tieba.pb.a.c dqX = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> iFf = new ArrayList();
    private int iFh = -1;
    private CustomMessageListener gvM = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cKH = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cKH();
                Iterator it = cKH.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(f.this.iEk);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.iES.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cKH);
                f.this.iFf.clear();
                f.this.iFf.addAll(arrayList);
                if (f.this.eko != null) {
                    f.this.eko.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener doF = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.iEU != null && !com.baidu.adp.base.i.Z(f.this.iEk.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener iFj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.iEk != null && f.this.iEU != null && f.this.iEU.ckG() != null) {
                f.this.iEk.cmu().cps().clx();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener gFY = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.gFW)) {
                f.this.bPa();
                f.this.a(f.this.iEU, false);
            }
        }
    };

    public f(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iFc = 0;
        this.width = -1;
        this.iFi = 0;
        this.iFc = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.iFc;
        this.iEk = pbFragment;
        this.eko = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.doF);
        this.iFi = com.baidu.adp.lib.util.l.getEquipmentHeight(this.iEk.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iEF = new p(pbFragment, PostData.kgE);
        this.iEF.a((TbRichTextView.c) pbFragment);
        this.iEG = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.k.iCV);
        this.iEH = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.iBD);
        this.iEI = new ai(pbFragment, com.baidu.tieba.pb.data.j.iCP);
        this.iEJ = new ai(pbFragment, com.baidu.tieba.pb.data.j.iCQ);
        this.iEK = new j(pbFragment, PostData.kgF);
        this.iEK.a((TbRichTextView.c) pbFragment);
        this.heA = com.baidu.tieba.recapp.r.cCw().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cML);
        this.iEN = com.baidu.tieba.recapp.r.cCw().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cMP);
        this.iEQ = new ac(pbFragment, com.baidu.tieba.pb.data.i.iCN);
        this.iEO = new ae(pbFragment, ab.iMu);
        this.iEP = new af(pbFragment, at.cPV);
        this.iER = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.kgK);
        this.iEL = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.iXb);
        this.iEM = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.iET = new g(pbFragment, com.baidu.tbadk.core.data.l.cNV);
        this.asF.add(this.iEF);
        this.asF.add(this.iEG);
        this.asF.add(this.iEH);
        this.asF.add(this.iEK);
        this.asF.add(this.iEI);
        this.asF.add(this.iEJ);
        this.asF.add(this.heA);
        this.asF.add(this.iEN);
        this.asF.add(this.iEQ);
        this.asF.add(this.iEO);
        this.asF.add(this.iEP);
        this.asF.add(this.iEL);
        this.asF.add(this.iER);
        this.asF.add(this.iEM);
        this.asF.add(this.iET);
        this.gvM.setPriority(1);
        this.gvM.setSelfListener(true);
        pbFragment.registerListener(this.gvM);
        bOZ();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.asF);
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
        com.baidu.adp.widget.ListView.m clY;
        bj ckv;
        PostData postData2;
        if (eVar != null) {
            boolean z9 = false;
            if (this.iEU != eVar) {
                z9 = true;
                if ((eVar != null && !eVar.ckt()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z9 = false;
                }
            }
            this.iEU = eVar;
            if (z9) {
                cmd();
                if (eVar != null) {
                    eVar.pu(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iEU != null && this.iEU.ckx() != null && this.iEU.ckx().size() > 0) {
                this.postList.addAll(this.iEU.ckx());
            }
            if (eVar != null && eVar.ckv() != null && eVar.ckv().aCo() != null) {
                this.aqW = eVar.ckv().aCo().getUserId();
            }
            if (this.iEF != null) {
                this.iEF.setData(eVar);
                this.iEF.setFromCDN(this.mIsFromCDN);
                this.iEF.setImageMaxWidth(this.iFc);
                this.iEF.pw(this.iEV);
                this.iEF.y(this.aku);
                this.iEF.P(this.iFe);
                this.iEF.setOnImageClickListener(this.dMK);
                this.iEF.setOnLongClickListener(this.mOnLongClickListener);
                this.iEF.setTbGestureDetector(this.dqX);
                this.iEK.setData(eVar);
                this.iEK.setFromCDN(this.mIsFromCDN);
                this.iEK.dI(this.aqW);
                this.iEK.pw(this.iEV);
                this.iEK.y(this.aku);
                this.iEK.P(this.iFe);
                this.iEK.setOnImageClickListener(this.dMK);
                this.iEK.setOnLongClickListener(this.mOnLongClickListener);
                this.iEK.setTbGestureDetector(this.dqX);
                this.iEG.setOnClickListener(this.aku);
                this.iER.setOnClickListener(this.aku);
                this.iEL.setOnClickListener(this.iFj);
                if (this.iEN != null && (this.iEN instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.iEN).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iES.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(eVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.dI(this.aqW);
                        next.setImageMaxWidth(this.iFc);
                        next.pw(this.iEV);
                        next.px(this.iEW);
                        next.py(this.iFb);
                        next.y(this.aku);
                        next.P(this.iFe);
                        next.setOnImageClickListener(this.dMK);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.iEI.y(this.aku);
                this.iEJ.y(this.aku);
                this.iEI.setData(eVar);
                this.iEH.setData(eVar);
                this.iEJ.setData(eVar);
                this.iEO.setData(eVar);
                this.iEP.setData(eVar);
                this.iET.setPbData(eVar);
                this.iET.setFrom(this.iEk.iIs);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>(eVar.ckx());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cLb() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.iFd = postData;
                }
                boolean z10 = false;
                if (!this.iEW && postData != null) {
                    arrayList2.remove(postData);
                    z10 = true;
                    z2 = true;
                    if (eVar.aHL() && postData.cLd() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && eVar.ckC() != null) {
                    postData = eVar.ckC();
                    z10 = true;
                    z2 = true;
                    if (!this.iEW && eVar.aHL() && postData.cLd() != null) {
                        postData.c(null);
                    }
                }
                boolean z11 = z2;
                PostData postData3 = postData;
                boolean z12 = z10;
                dF(arrayList2);
                if (this.iEk.cmT()) {
                    if (eVar.ckx().size() > 0 && (postData2 = eVar.ckx().get(0)) != null && postData2.cLb() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        arrayList2.remove(0);
                    }
                } else {
                    int b = b(this.iEU, arrayList2, this.iEW);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, b, this.iEU.cky());
                    }
                }
                int c = c(this.iEU, arrayList2, this.iEW);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, c, this.iEU.ckz());
                }
                com.baidu.tieba.tbadkCore.s.o(arrayList2, 1);
                boolean z13 = false;
                int b2 = b(eVar, arrayList2);
                if (b2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iCP);
                    jVar.iCR = eVar.ckv() != null ? ckv.aCf() : 0L;
                    jVar.isNew = !this.iEW;
                    jVar.iCU = this.iEk.cnd();
                    jVar.sortType = eVar.iBQ;
                    jVar.iCT = eVar.ckU();
                    jVar.isDynamic = eVar.ckT();
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
                        ((PostData) mVar).khs = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList2, a, f);
                    z3 = true;
                }
                int i6 = -1;
                if (z11) {
                    i6 = a(eVar, arrayList2, this.iEW);
                }
                if (i6 >= 0 && eVar.ckQ() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.ckQ());
                    z4 = true;
                    z5 = true;
                } else {
                    postData3.khr = true;
                    z4 = false;
                    z5 = z3;
                }
                if (i6 < 0 || !eVar.iBU || eVar.iBV == null) {
                    i = i6;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.iBV);
                    i = i6 + 1;
                }
                boolean z14 = false;
                if (!z11 || (clY = clY()) == null || i < 0) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i + 1, clY);
                    z14 = true;
                    z6 = true;
                }
                int i7 = -1;
                if (z11 && !z6) {
                    com.baidu.adp.widget.ListView.m clZ = clZ();
                    if (i >= 0) {
                        i7 = i + 1;
                    } else if (a >= 0) {
                        i7 = a;
                    } else if (b2 >= 0) {
                        i7 = b2;
                    }
                    if (clZ != null && i7 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, i7, clZ);
                        z7 = true;
                        i2 = i7;
                        arrayList = new ArrayList();
                        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.ckS()) && eVar.ckS().size() > 2) {
                            min = Math.min(eVar.ckS().size(), 7);
                            i4 = 0;
                            while (true) {
                                i5 = i4;
                                if (i5 < min) {
                                    break;
                                }
                                com.baidu.tbadk.core.data.l lVar = eVar.ckS().get(i5);
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
                        this.iEF.pJ(z5);
                        z8 = false;
                        if (this.iEk.clC() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.iEk.clC().cnx())) {
                            z8 = true;
                        }
                        if (this.iEX && !z8) {
                            arrayList2.remove(postData3);
                            this.iEX = false;
                        }
                        if (eVar.ckQ() != null) {
                            eVar.ckQ().pv(!z4);
                        }
                        if (this.eko != null) {
                            this.eiz = arrayList2;
                            this.eko.setData(this.eiz);
                        }
                        if (!z8 && !z && ((this.iEZ || this.iEY) && a != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.iFa)) {
                            this.iFg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.eko.setSelectionFromTop(f.this.eko.getHeaderViewsCount() + f.size(), 0 - f.this.iFi);
                                    f.this.iFa = false;
                                }
                            };
                            com.baidu.adp.lib.f.e.gx().post(this.iFg);
                        }
                        if (postData3 != null) {
                            if (this.iFd != null && !this.iEY) {
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, this.iFd);
                            } else {
                                PostData postData4 = new PostData();
                                postData4.Cw(1);
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData4);
                            }
                            this.eko.setData(arrayList2);
                            return;
                        } else if (z12) {
                            com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData3);
                            this.eko.setData(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z7 = z14;
                i2 = i7;
                arrayList = new ArrayList();
                if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.ckS())) {
                    min = Math.min(eVar.ckS().size(), 7);
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
                this.iEF.pJ(z5);
                z8 = false;
                if (this.iEk.clC() != null) {
                    z8 = true;
                }
                if (this.iEX) {
                    arrayList2.remove(postData3);
                    this.iEX = false;
                }
                if (eVar.ckQ() != null) {
                }
                if (this.eko != null) {
                }
                if (!z8) {
                    this.iFg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.eko.setSelectionFromTop(f.this.eko.getHeaderViewsCount() + f.size(), 0 - f.this.iFi);
                            f.this.iFa = false;
                        }
                    };
                    com.baidu.adp.lib.f.e.gx().post(this.iFg);
                }
                if (postData3 != null) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m clY() {
        PbModel clC = this.iEk.clC();
        if (clC == null) {
            return null;
        }
        String coo = clC.coo();
        if (TextUtils.isEmpty(coo)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.Jb(coo);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m clZ() {
        if (this.iEU == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m cnM = this.iEk.clC().cnM();
        if (cnM == null) {
            cnM = this.iEU.ckK();
        }
        if (cnM != null) {
            AdvertAppInfo.ILegoAdvert cKQ = cnM.cKQ();
            if (cKQ != null) {
                cKQ.setAdvertAppInfo(cnM.kK());
            }
            int aAp = cnM.cKP().aAp();
            if (aAp != 0) {
                a(cnM, aAp);
                if (aAp == 28 || aAp == 31 || cnM.cKP().goods == null) {
                    return null;
                }
                cnM.cKP().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                return null;
            }
            if (this.iEU.getForum() != null) {
                cnM.forumId = this.iEU.getForum().getId();
            }
            if (this.iEU.ckv() != null) {
                cnM.threadId = com.baidu.adp.lib.f.b.toLong(this.iEU.ckv().getId(), 0L);
            }
            if (this.iEU != null && this.iEU.getPage() != null) {
                cnM.pageNumber = this.iEU.getPage().aBi();
            }
            c(cnM);
            return cnM;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.iEY || eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckx()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.aHL() && this.iEW) ? 0 : -1;
        } else if (this.iEk.clC() == null || !this.iEk.clC().getIsFromMark()) {
            if (this.iEk.cmu() == null || !this.iEk.cmu().cqu()) {
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
                        if (postData.cLb() == 1 && postData.kho == 0) {
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
                return eVar.aHL() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckx()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(eVar.ckx(), 0)) == null) {
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
                if (postData.cLb() == 1 && postData.kho == 0) {
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
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckx()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.aHL()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.ckx().get(0) == null || eVar.ckx().get(0).cLb() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.ckG() == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckG().iDe)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.ckG().iDe;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.khC = true;
                postData.khq = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(eVar.ckG().iDf) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).khq = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).khq = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iCQ);
        jVar.iCS = eVar.ckG().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void bOZ() {
        if (this.iEk != null && !bPa()) {
            this.iEk.registerListener(this.gFY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPa() {
        if (this.iEk == null) {
            return false;
        }
        this.gFW = new ArrayList();
        ArrayList<BdUniqueId> cKt = com.baidu.tieba.tbadkCore.s.cKt();
        if (cKt == null || cKt.size() <= 0) {
            return false;
        }
        int size = cKt.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cdl().a(this.iEk.getPageContext(), cKt.get(i), 2);
            if (a != null) {
                this.asF.add(a);
                this.gFW.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gFW)) {
            this.eko.addAdapters(this.gFW);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.eko.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.ckx() == null || eVar.cky() == null || eVar.ckx().size() == 0 || eVar.ckv() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cky().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.ckx().get(0) == null || eVar.ckx().get(0).cLb() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aBi() != eVar.getPage().aBf()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.ckx() == null || eVar.ckz() == null || eVar.ckx().size() == 0 || eVar.ckv() == null || arrayList == null) {
            return -1;
        }
        if (eVar.ckz().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.ckx().get(0) == null || eVar.ckx().get(0).cLb() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aBi() != eVar.getPage().aBf()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.eko.getItem(i);
    }

    public ArrayList<PostData> cma() {
        return this.postList;
    }

    public BdUniqueId yG(int i) {
        if (this.eko.getItem(i) != null) {
            return this.eko.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.iFh = cmb();
        if (this.eko.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }

    public int cmb() {
        if (this.eko != null && this.eko.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eko.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.eko.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.j.iCP) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cmc() {
        return this.iFh;
    }

    private void cmd() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.iEU != null) {
            ArrayList<PostData> ckx = this.iEU.ckx();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> ckJ = this.iEU.ckJ();
            if (ckJ != null) {
                int size = ckJ.size();
                if (ckx != null && ckx.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = ckJ.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = ckJ.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.gFU = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = ckJ.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cKP() != null) {
                            int aAp = next3.cKP().aAp();
                            if (aAp != 0) {
                                a(next3, aAp);
                                if (aAp != 28 && aAp != 31) {
                                    if (next3.cKP().goods != null) {
                                        next3.cKP().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.w.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cKP().apk_name)) {
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
                        if (this.iEU.getForum() != null) {
                            mVar4.forumId = this.iEU.getForum().getId();
                        }
                        if (this.iEU.ckv() != null) {
                            mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.iEU.ckv().getId(), 0L);
                        }
                        if (this.iEU != null && this.iEU.getPage() != null) {
                            mVar4.pageNumber = this.iEU.getPage().aBi();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= ckx.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.iEW) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        ckx.add(position2, mVar4);
                        TiebaStatic.eventStat(this.iEk.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cKP().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.Ba(i);
        com.baidu.tieba.recapp.report.c.cDq().a(c);
        if (mVar != null && mVar.cKP() != null) {
            mVar.cKP().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cKP() != null && mVar.cKP().goods != null && mVar.cKP().goods.goods_style != 1001 && mVar.cKP().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.iEU != null && mVar.cKP() != null) {
            mVar.cKP().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.iEU.getPage() != null) {
                mVar.cKP().advertAppContext.pn = this.iEU.getPage().aBi();
            }
            mVar.cKP().advertAppContext.page = mVar.cKS();
            if (this.iEU.getForum() != null && (forum = this.iEU.getForum()) != null) {
                mVar.cKP().advertAppContext.fid = forum.getId();
                mVar.cKP().advertAppContext.cMC = forum.getFirst_class();
                mVar.cKP().advertAppContext.cMD = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cKP().advertAppContext.cME = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cKP().advertAppContext.extensionInfo = mVar.cKP().ext_info;
            mVar.cKP().advertAppContext.Dn = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.iEF.setFromCDN(z);
        if (this.iEN != null && (this.iEN instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iEN).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iES.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cme() {
        return this.iEV;
    }

    public void pw(boolean z) {
        this.iEV = z;
    }

    public void px(boolean z) {
        this.iEW = z;
    }

    public void py(boolean z) {
        this.iFb = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iFe = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dMK = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dqX = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.aku = onClickListener;
    }

    public void yH(int i) {
        switch (i) {
            case 1:
                if (this.iEF != null) {
                    this.iEF.pause();
                    return;
                }
                return;
            case 2:
                if (this.iEF != null) {
                    this.iEF.resume();
                    return;
                }
                return;
            case 3:
                if (this.iEF != null) {
                    this.iEF.release();
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
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iFg);
        if (this.iEI != null) {
            this.iEI.onDestroy();
        }
        if (this.iEJ != null) {
            this.iEJ.onDestroy();
        }
        if (this.iEG != null) {
            this.iEG.onDestroy();
        }
        if (this.iEH != null) {
            this.iEH.onDestroy();
        }
    }

    public void pC(boolean z) {
        this.iEY = z;
    }

    public void pD(boolean z) {
        this.iEZ = z;
    }

    public void pE(boolean z) {
        this.iEX = z;
    }

    public void pF(boolean z) {
        this.iFa = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cmf() {
        return this.iEG;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.eiz;
    }

    public View cmg() {
        if (this.iEF == null || this.iEF.cmj() == null) {
            return null;
        }
        if (this.iEF.cmj().iGY != null && this.iEF.cmj().iGY.isShown()) {
            return this.iEF.cmj().iGY;
        }
        return this.iEF.cmj().iGX;
    }

    public q cmh() {
        if (this.iEF == null || this.iEF.cmj() == null) {
            return null;
        }
        return this.iEF.cmj();
    }
}
