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
/* loaded from: classes6.dex */
public class f {
    private ArrayList<com.baidu.adp.widget.ListView.m> eea;
    private BdTypeListView efM;
    private List<com.baidu.adp.widget.ListView.a> gAz;
    private com.baidu.adp.widget.ListView.a gYO;
    private PbFragment iyA;
    private boolean izA;
    private boolean izB;
    private int izD;
    private Runnable izH;
    private int izJ;
    private q ize;
    private com.baidu.tieba.pb.pb.main.adapter.c izf;
    private com.baidu.tieba.pb.pb.main.adapter.a izg;
    private al izh;
    private al izi;
    private k izj;
    private com.baidu.tieba.pb.video.a izk;
    private com.baidu.tieba.card.divider.a izl;
    private com.baidu.adp.widget.ListView.a izm;
    private ah izn;
    private ai izo;
    private com.baidu.tieba.pb.pb.a.b izp;
    private w izq;
    private af izr;
    private com.baidu.tieba.pb.pb.a.d izs;
    private g izu;
    private com.baidu.tieba.pb.data.f izv;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> izt = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean izw = true;
    private boolean izx = true;
    private boolean izy = false;
    private boolean izz = false;
    private boolean izC = false;
    private String amQ = null;
    private PostData izE = null;
    private View.OnClickListener izF = null;
    private View.OnClickListener ahD = null;
    private TbRichTextView.i dIi = null;
    private com.baidu.tieba.pb.a.c dmm = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> izG = new ArrayList();
    private int izI = -1;
    private CustomMessageListener gqo = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cHU = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cHU();
                Iterator it = cHU.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).a(f.this.iyA);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.izt.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.izp = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cHU);
                f.this.izG.clear();
                f.this.izG.addAll(arrayList);
                if (f.this.efM != null) {
                    f.this.efM.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener djU = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.izv != null && !com.baidu.adp.base.i.Z(f.this.iyA.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener izK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.iyA != null && f.this.izv != null && f.this.izv.chV() != null) {
                f.this.iyA.cjP().cmR().ciP();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener gAB = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.gAz)) {
                f.this.bMn();
                f.this.a(f.this.izv, false);
            }
        }
    };

    public f(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.izD = 0;
        this.width = -1;
        this.izJ = 0;
        this.izD = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.izD;
        this.iyA = pbFragment;
        this.efM = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.djU);
        this.izJ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.iyA.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.ize = new q(pbFragment, PostData.kbI);
        this.ize.a((TbRichTextView.c) pbFragment);
        this.izf = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.l.ixk);
        this.izg = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.b.ivT);
        this.izh = new al(pbFragment, com.baidu.tieba.pb.data.k.ixe);
        this.izi = new al(pbFragment, com.baidu.tieba.pb.data.k.ixf);
        this.izj = new k(pbFragment, PostData.kbJ);
        this.izj.a((TbRichTextView.c) pbFragment);
        this.gYO = com.baidu.tieba.recapp.r.czO().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cIu);
        this.izm = com.baidu.tieba.recapp.r.czO().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cIy);
        this.izq = new w(pbFragment, com.baidu.tieba.pb.data.a.ivQ);
        this.izr = new af(pbFragment, com.baidu.tieba.pb.data.j.ixc);
        this.izn = new ah(pbFragment, ae.iHh);
        this.izo = new ai(pbFragment, com.baidu.tbadk.core.data.at.cLG);
        this.izs = new com.baidu.tieba.pb.pb.a.d(pbFragment, PostData.kbO);
        this.izk = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.iRQ);
        this.izl = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.izu = new g(pbFragment, com.baidu.tbadk.core.data.l.cJF);
        this.aoz.add(this.ize);
        this.aoz.add(this.izf);
        this.aoz.add(this.izg);
        this.aoz.add(this.izj);
        this.aoz.add(this.izh);
        this.aoz.add(this.izi);
        this.aoz.add(this.gYO);
        this.aoz.add(this.izm);
        this.aoz.add(this.izq);
        this.aoz.add(this.izr);
        this.aoz.add(this.izn);
        this.aoz.add(this.izo);
        this.aoz.add(this.izk);
        this.aoz.add(this.izs);
        this.aoz.add(this.izl);
        this.aoz.add(this.izu);
        this.gqo.setPriority(1);
        this.gqo.setSelfListener(true);
        pbFragment.registerListener(this.gqo);
        bMm();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.aoz);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04cf A[LOOP:3: B:175:0x04cd->B:176:0x04cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x04b2 A[EDGE_INSN: B:251:0x04b2->B:165:0x04b2 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.pb.data.f fVar, boolean z) {
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
        com.baidu.adp.widget.ListView.m cjs;
        bj chK;
        PostData postData2;
        if (fVar != null) {
            boolean z9 = false;
            if (this.izv != fVar) {
                z9 = true;
                if ((fVar != null && !fVar.chI()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z9 = false;
                }
            }
            this.izv = fVar;
            if (z9) {
                cjx();
                if (fVar != null) {
                    fVar.pf(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.izv != null && this.izv.chM() != null && this.izv.chM().size() > 0) {
                this.postList.addAll(this.izv.chM());
            }
            if (fVar != null && fVar.chK() != null && fVar.chK().azE() != null) {
                this.amQ = fVar.chK().azE().getUserId();
            }
            if (this.ize != null) {
                this.ize.setData(fVar);
                this.ize.setFromCDN(this.mIsFromCDN);
                this.ize.setImageMaxWidth(this.izD);
                this.ize.ph(this.izw);
                this.ize.y(this.ahD);
                this.ize.P(this.izF);
                this.ize.setOnImageClickListener(this.dIi);
                this.ize.setOnLongClickListener(this.mOnLongClickListener);
                this.ize.setTbGestureDetector(this.dmm);
                this.izj.setData(fVar);
                this.izj.setFromCDN(this.mIsFromCDN);
                this.izj.dv(this.amQ);
                this.izj.ph(this.izw);
                this.izj.y(this.ahD);
                this.izj.P(this.izF);
                this.izj.setOnImageClickListener(this.dIi);
                this.izj.setOnLongClickListener(this.mOnLongClickListener);
                this.izj.setTbGestureDetector(this.dmm);
                this.izf.setOnClickListener(this.ahD);
                this.izs.setOnClickListener(this.ahD);
                this.izk.setOnClickListener(this.izK);
                if (this.izm != null && (this.izm instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.izm).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.izt.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.dv(this.amQ);
                        next.setImageMaxWidth(this.izD);
                        next.ph(this.izw);
                        next.pi(this.izx);
                        next.pj(this.izC);
                        next.y(this.ahD);
                        next.P(this.izF);
                        next.setOnImageClickListener(this.dIi);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.izh.y(this.ahD);
                this.izi.y(this.ahD);
                this.izh.setData(fVar);
                this.izg.setData(fVar);
                this.izi.setData(fVar);
                this.izn.setData(fVar);
                this.izo.setData(fVar);
                this.izq.setData(fVar);
                this.izu.setPbData(fVar);
                this.izu.setFrom(this.iyA.iCW);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>(fVar.chM());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cIt() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.izE = postData;
                }
                boolean z10 = false;
                if (!this.izx && postData != null) {
                    arrayList2.remove(postData);
                    z10 = true;
                    z2 = true;
                    if (fVar.cih() && postData.cIv() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && fVar.chR() != null) {
                    postData = fVar.chR();
                    z10 = true;
                    z2 = true;
                    if (!this.izx && fVar.cih() && postData.cIv() != null) {
                        postData.c(null);
                    }
                }
                boolean z11 = z2;
                PostData postData3 = postData;
                boolean z12 = z10;
                dJ(arrayList2);
                if (this.iyA.cko()) {
                    if (fVar.chM().size() > 0 && (postData2 = fVar.chM().get(0)) != null && postData2.cIt() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        arrayList2.remove(0);
                    }
                } else {
                    int b = b(this.izv, arrayList2, this.izx);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, b, this.izv.chN());
                    }
                }
                int c = c(this.izv, arrayList2, this.izx);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, c, this.izv.chO());
                }
                com.baidu.tieba.tbadkCore.s.n(arrayList2, 1);
                boolean z13 = false;
                int b2 = b(fVar, arrayList2);
                if (b2 >= 0) {
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k(com.baidu.tieba.pb.data.k.ixe);
                    kVar.ixg = fVar.chK() != null ? chK.azv() : 0L;
                    kVar.isNew = !this.izx;
                    kVar.ixj = this.iyA.cky();
                    kVar.sortType = fVar.iwg;
                    kVar.ixi = fVar.cil();
                    kVar.isDynamic = fVar.cik();
                    com.baidu.tbadk.core.util.v.add(arrayList2, b2, kVar);
                    z13 = true;
                }
                int a = a(fVar, arrayList2);
                final List<com.baidu.adp.widget.ListView.m> f = f(fVar);
                if (com.baidu.tbadk.core.util.v.isEmpty(f) || a < 0) {
                    z3 = z13;
                } else {
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList2, a);
                    if (mVar instanceof PostData) {
                        ((PostData) mVar).kcv = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList2, a, f);
                    z3 = true;
                }
                int i6 = -1;
                if (z11) {
                    i6 = a(fVar, arrayList2, this.izx);
                }
                if (i6 >= 0 && fVar.cig() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, fVar.cig());
                    z4 = true;
                    z5 = true;
                } else {
                    postData3.kcu = true;
                    z4 = false;
                    z5 = z3;
                }
                if (i6 < 0 || !fVar.iwk || fVar.iwl == null) {
                    i = i6;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, fVar.iwl);
                    i = i6 + 1;
                }
                boolean z14 = false;
                if (!z11 || (cjs = cjs()) == null || i < 0) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i + 1, cjs);
                    z14 = true;
                    z6 = true;
                }
                int i7 = -1;
                if (z11 && !z6) {
                    com.baidu.adp.widget.ListView.m cjt = cjt();
                    if (i >= 0) {
                        i7 = i + 1;
                    } else if (a >= 0) {
                        i7 = a;
                    } else if (b2 >= 0) {
                        i7 = b2;
                    }
                    if (cjt != null && i7 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, i7, cjt);
                        z7 = true;
                        i2 = i7;
                        arrayList = new ArrayList();
                        if (!com.baidu.tbadk.core.util.v.isEmpty(fVar.cij()) && fVar.cij().size() > 2) {
                            min = Math.min(fVar.cij().size(), 7);
                            i4 = 0;
                            while (true) {
                                i5 = i4;
                                if (i5 < min) {
                                    break;
                                }
                                com.baidu.tbadk.core.data.l lVar = fVar.cij().get(i5);
                                if (i5 == 0) {
                                    lVar.fi(true);
                                }
                                if (lVar.azV() == null) {
                                    if (i5 == min - 1) {
                                        lVar.fj(true);
                                    }
                                } else if (i5 == min - 2) {
                                    lVar.fj(true);
                                } else if (i5 == min - 1) {
                                    lVar.fk(true);
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
                        this.ize.pu(z5);
                        z8 = false;
                        if (this.iyA.ciU() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.iyA.ciU().ckS())) {
                            z8 = true;
                        }
                        if (this.izy && !z8) {
                            arrayList2.remove(postData3);
                            this.izy = false;
                        }
                        if (fVar.cig() != null) {
                            fVar.cig().pg(!z4);
                        }
                        if (this.efM != null) {
                            this.eea = arrayList2;
                            this.efM.setData(this.eea);
                        }
                        if (!z8 && !z && ((this.izA || this.izz) && a != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.izB)) {
                            this.izH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.efM.setSelectionFromTop(f.this.efM.getHeaderViewsCount() + f.size(), 0 - f.this.izJ);
                                    f.this.izB = false;
                                }
                            };
                            com.baidu.adp.lib.f.e.gy().post(this.izH);
                        }
                        if (postData3 != null) {
                            if (this.izE != null && !this.izz) {
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, this.izE);
                            } else {
                                PostData postData4 = new PostData();
                                postData4.Cl(1);
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData4);
                            }
                            this.efM.setData(arrayList2);
                            return;
                        } else if (z12) {
                            com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData3);
                            this.efM.setData(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z7 = z14;
                i2 = i7;
                arrayList = new ArrayList();
                if (!com.baidu.tbadk.core.util.v.isEmpty(fVar.cij())) {
                    min = Math.min(fVar.cij().size(), 7);
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
                this.ize.pu(z5);
                z8 = false;
                if (this.iyA.ciU() != null) {
                    z8 = true;
                }
                if (this.izy) {
                    arrayList2.remove(postData3);
                    this.izy = false;
                }
                if (fVar.cig() != null) {
                }
                if (this.efM != null) {
                }
                if (!z8) {
                    this.izH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.efM.setSelectionFromTop(f.this.efM.getHeaderViewsCount() + f.size(), 0 - f.this.izJ);
                            f.this.izB = false;
                        }
                    };
                    com.baidu.adp.lib.f.e.gy().post(this.izH);
                }
                if (postData3 != null) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m cjs() {
        PbModel ciU = this.iyA.ciU();
        if (ciU == null) {
            return null;
        }
        String clM = ciU.clM();
        if (TextUtils.isEmpty(clM)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.IC(clM);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m cjt() {
        if (this.izv == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m clh = this.iyA.ciU().clh();
        if (clh == null) {
            clh = this.izv.chZ();
        }
        if (clh != null) {
            AdvertAppInfo.ILegoAdvert cIi = clh.cIi();
            if (cIi != null) {
                cIi.setAdvertAppInfo(clh.ku());
            }
            int axG = clh.cIh().axG();
            if (axG != 0) {
                a(clh, axG);
                if (axG == 28 || axG == 31 || clh.cIh().goods == null) {
                    return null;
                }
                clh.cIh().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                return null;
            }
            if (this.izv.getForum() != null) {
                clh.forumId = this.izv.getForum().getId();
            }
            if (this.izv.chK() != null) {
                clh.threadId = com.baidu.adp.lib.f.b.toLong(this.izv.chK().getId(), 0L);
            }
            if (this.izv != null && this.izv.getPage() != null) {
                clh.pageNumber = this.izv.getPage().ayw();
            }
            c(clh);
            return clh;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.izz || fVar == null || com.baidu.tbadk.core.util.v.isEmpty(fVar.chM()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.cih() && this.izx) ? 0 : -1;
        } else if (this.iyA.ciU() == null || !this.iyA.ciU().getIsFromMark()) {
            if (this.iyA.cjP() == null || !this.iyA.cjP().cnS()) {
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
                        if (postData.cIt() == 1 && postData.kcr == 0) {
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
                return fVar.cih() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.isEmpty(fVar.chM()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(fVar.chM(), 0)) == null) {
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
                if (postData.cIt() == 1 && postData.kcr == 0) {
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

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (fVar == null || com.baidu.tbadk.core.util.v.isEmpty(fVar.chM()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.cih()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.chM().get(0) == null || fVar.chM().get(0).cIt() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.chV() == null || com.baidu.tbadk.core.util.v.isEmpty(fVar.chV().ixt)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.chV().ixt;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.kcF = true;
                postData.kct = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(fVar.chV().ixu) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).kct = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).kct = true;
            }
        }
        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k(com.baidu.tieba.pb.data.k.ixf);
        kVar.ixh = fVar.chV().forum_top_list;
        arrayList.add(0, kVar);
        return arrayList;
    }

    private void bMm() {
        if (this.iyA != null && !bMn()) {
            this.iyA.registerListener(this.gAB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bMn() {
        if (this.iyA == null) {
            return false;
        }
        this.gAz = new ArrayList();
        ArrayList<BdUniqueId> cHG = com.baidu.tieba.tbadkCore.s.cHG();
        if (cHG == null || cHG.size() <= 0) {
            return false;
        }
        int size = cHG.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cay().a(this.iyA.getPageContext(), cHG.get(i), 2);
            if (a != null) {
                this.aoz.add(a);
                this.gAz.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gAz)) {
            this.efM.addAdapters(this.gAz);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.efM.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (fVar == null || fVar.chM() == null || fVar.chN() == null || fVar.chM().size() == 0 || fVar.chK() == null || arrayList == null) {
            return -1;
        }
        if (fVar.chN().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.chM().get(0) == null || fVar.chM().get(0).cIt() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().ayw() != fVar.getPage().ayt()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (fVar == null || fVar.chM() == null || fVar.chO() == null || fVar.chM().size() == 0 || fVar.chK() == null || arrayList == null) {
            return -1;
        }
        if (fVar.chO().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.chM().get(0) == null || fVar.chM().get(0).cIt() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().ayw() != fVar.getPage().ayt()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.efM.getItem(i);
    }

    public ArrayList<PostData> cju() {
        return this.postList;
    }

    public BdUniqueId yu(int i) {
        if (this.efM.getItem(i) != null) {
            return this.efM.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.izp == null || !this.izp.ciN()) {
            this.izI = cjv();
            if (this.efM.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.efM.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int cjv() {
        if (this.efM != null && this.efM.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.efM.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.efM.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.k.ixe) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cjw() {
        return this.izI;
    }

    private void cjx() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.izv != null) {
            ArrayList<PostData> chM = this.izv.chM();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> chY = this.izv.chY();
            if (chY != null) {
                int size = chY.size();
                if (chM != null && chM.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = chY.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = chY.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.gAx = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = chY.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cIh() != null) {
                            int axG = next3.cIh().axG();
                            if (axG != 0) {
                                a(next3, axG);
                                if (axG != 28 && axG != 31) {
                                    if (next3.cIh().goods != null) {
                                        next3.cIh().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.w.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cIh().apk_name)) {
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
                        if (this.izv.getForum() != null) {
                            mVar4.forumId = this.izv.getForum().getId();
                        }
                        if (this.izv.chK() != null) {
                            mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.izv.chK().getId(), 0L);
                        }
                        if (this.izv != null && this.izv.getPage() != null) {
                            mVar4.pageNumber = this.izv.getPage().ayw();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= chM.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.izx) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        chM.add(position2, mVar4);
                        TiebaStatic.eventStat(this.iyA.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cIh().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.AM(i);
        com.baidu.tieba.recapp.report.c.cAJ().a(c);
        if (mVar != null && mVar.cIh() != null) {
            mVar.cIh().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cIh() != null && mVar.cIh().goods != null && mVar.cIh().goods.goods_style != 1001 && mVar.cIh().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.izv != null && mVar.cIh() != null) {
            mVar.cIh().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.izv.getPage() != null) {
                mVar.cIh().advertAppContext.pn = this.izv.getPage().ayw();
            }
            mVar.cIh().advertAppContext.page = mVar.cIk();
            if (this.izv.getForum() != null && (forum = this.izv.getForum()) != null) {
                mVar.cIh().advertAppContext.fid = forum.getId();
                mVar.cIh().advertAppContext.cIl = forum.getFirst_class();
                mVar.cIh().advertAppContext.cIm = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cIh().advertAppContext.cIn = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cIh().advertAppContext.extensionInfo = mVar.cIh().ext_info;
            mVar.cIh().advertAppContext.CN = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.ize.setFromCDN(z);
        if (this.izm != null && (this.izm instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.izm).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.izt.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cjy() {
        return this.izw;
    }

    public void ph(boolean z) {
        this.izw = z;
    }

    public void pi(boolean z) {
        this.izx = z;
    }

    public void pj(boolean z) {
        this.izC = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.izF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIi = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dmm = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.ahD = onClickListener;
    }

    public void yv(int i) {
        switch (i) {
            case 1:
                if (this.izp != null) {
                    this.izp.pause();
                }
                if (this.ize != null) {
                    this.ize.pause();
                    return;
                }
                return;
            case 2:
                if (this.izp != null) {
                    this.izp.resume();
                }
                if (this.ize != null) {
                    this.ize.resume();
                    return;
                }
                return;
            case 3:
                if (this.izp != null) {
                    this.izp.release();
                }
                if (this.ize != null) {
                    this.ize.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dJ(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.aAM())) {
                        com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
                        aeVar.sd(postData.aAM());
                        list.set(i, aeVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.izH);
        if (this.izh != null) {
            this.izh.onDestroy();
        }
        if (this.izi != null) {
            this.izi.onDestroy();
        }
        if (this.izf != null) {
            this.izf.onDestroy();
        }
        if (this.izg != null) {
            this.izg.onDestroy();
        }
    }

    public void pn(boolean z) {
        this.izz = z;
    }

    public void po(boolean z) {
        this.izA = z;
    }

    public void pp(boolean z) {
        this.izy = z;
    }

    public void pq(boolean z) {
        this.izB = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cjz() {
        return this.izf;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.eea;
    }

    public View cjA() {
        if (this.ize == null || this.ize.cjE() == null) {
            return null;
        }
        if (this.ize.cjE().iBC != null && this.ize.cjE().iBC.isShown()) {
            return this.ize.cjE().iBC;
        }
        return this.ize.cjE().iBB;
    }

    public r cjB() {
        if (this.ize == null || this.ize.cjE() == null) {
            return null;
        }
        return this.ize.cjE();
    }
}
