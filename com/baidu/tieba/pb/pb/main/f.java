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
    private ArrayList<com.baidu.adp.widget.ListView.m> eIF;
    private BdTypeListView eOj;
    private com.baidu.adp.widget.ListView.a hPK;
    private List<com.baidu.adp.widget.ListView.a> hqt;
    private PbFragment jpW;
    private ae jqA;
    private af jqB;
    private ac jqC;
    private com.baidu.tieba.pb.pb.a.c jqD;
    private g jqF;
    private com.baidu.tieba.pb.data.e jqG;
    private boolean jqL;
    private boolean jqM;
    private int jqO;
    private Runnable jqS;
    private int jqU;
    private p jqr;
    private com.baidu.tieba.pb.pb.main.adapter.c jqs;
    private com.baidu.tieba.pb.pb.main.adapter.a jqt;
    private ai jqu;
    private ai jqv;
    private j jqw;
    private com.baidu.tieba.pb.video.a jqx;
    private com.baidu.tieba.card.divider.a jqy;
    private com.baidu.adp.widget.ListView.a jqz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> jqE = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean jqH = true;
    private boolean jqI = true;
    private boolean jqJ = false;
    private boolean jqK = false;
    private boolean jqN = false;
    private String aJV = null;
    private PostData jqP = null;
    private View.OnClickListener jqQ = null;
    private View.OnClickListener aDi = null;
    private TbRichTextView.i emX = null;
    private com.baidu.tieba.pb.a.c dRm = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> jqR = new ArrayList();
    private int jqT = -1;
    private CustomMessageListener hfK = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cVV = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cVV();
                Iterator it = cVV.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(f.this.jpW);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.jqE.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cVV);
                f.this.jqR.clear();
                f.this.jqR.addAll(arrayList);
                if (f.this.eOj != null) {
                    f.this.eOj.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener dOP = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.jqG != null && !com.baidu.adp.base.i.E(f.this.jpW.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener jqV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.jpW != null && f.this.jqG != null && f.this.jqG.cvD() != null) {
                f.this.jpW.cxt().cAr().cww();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener hqv = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.hqt)) {
                f.this.bZO();
                f.this.a(f.this.jqG, false);
            }
        }
    };

    public f(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.jqO = 0;
        this.width = -1;
        this.jqU = 0;
        this.jqO = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.jqO;
        this.jpW = pbFragment;
        this.eOj = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.dOP);
        this.jqU = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jpW.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.jqr = new p(pbFragment, PostData.kSr);
        this.jqr.a((TbRichTextView.c) pbFragment);
        this.jqs = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.k.joG);
        this.jqt = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.jnn);
        this.jqu = new ai(pbFragment, com.baidu.tieba.pb.data.j.joA);
        this.jqv = new ai(pbFragment, com.baidu.tieba.pb.data.j.joB);
        this.jqw = new j(pbFragment, PostData.kSs);
        this.jqw.a((TbRichTextView.c) pbFragment);
        this.hPK = com.baidu.tieba.recapp.q.cNm().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dmg);
        this.jqz = com.baidu.tieba.recapp.q.cNm().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dmk);
        this.jqC = new ac(pbFragment, com.baidu.tieba.pb.data.i.Vp);
        this.jqA = new ae(pbFragment, ab.jyi);
        this.jqB = new af(pbFragment, at.dps);
        this.jqD = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.kSx);
        this.jqx = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.jIO);
        this.jqy = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.jqF = new g(pbFragment, com.baidu.tbadk.core.data.l.dnq);
        this.aMj.add(this.jqr);
        this.aMj.add(this.jqs);
        this.aMj.add(this.jqt);
        this.aMj.add(this.jqw);
        this.aMj.add(this.jqu);
        this.aMj.add(this.jqv);
        this.aMj.add(this.hPK);
        this.aMj.add(this.jqz);
        this.aMj.add(this.jqC);
        this.aMj.add(this.jqA);
        this.aMj.add(this.jqB);
        this.aMj.add(this.jqx);
        this.aMj.add(this.jqD);
        this.aMj.add(this.jqy);
        this.aMj.add(this.jqF);
        this.hfK.setPriority(1);
        this.hfK.setSelfListener(true);
        pbFragment.registerListener(this.hfK);
        bZN();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.aMj);
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
        com.baidu.adp.widget.ListView.m cwX;
        bj cvs;
        PostData postData2;
        if (eVar != null) {
            boolean z9 = false;
            if (this.jqG != eVar) {
                z9 = true;
                if ((eVar != null && !eVar.cvq()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z9 = false;
                }
            }
            this.jqG = eVar;
            if (z9) {
                cxc();
                if (eVar != null) {
                    eVar.qE(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.jqG != null && this.jqG.cvu() != null && this.jqG.cvu().size() > 0) {
                this.postList.addAll(this.jqG.cvu());
            }
            if (eVar != null && eVar.cvs() != null && eVar.cvs().aKC() != null) {
                this.aJV = eVar.cvs().aKC().getUserId();
            }
            if (this.jqr != null) {
                this.jqr.setData(eVar);
                this.jqr.setFromCDN(this.mIsFromCDN);
                this.jqr.setImageMaxWidth(this.jqO);
                this.jqr.qG(this.jqH);
                this.jqr.z(this.aDi);
                this.jqr.Q(this.jqQ);
                this.jqr.setOnImageClickListener(this.emX);
                this.jqr.setOnLongClickListener(this.mOnLongClickListener);
                this.jqr.setTbGestureDetector(this.dRm);
                this.jqw.setData(eVar);
                this.jqw.setFromCDN(this.mIsFromCDN);
                this.jqw.eA(this.aJV);
                this.jqw.qG(this.jqH);
                this.jqw.z(this.aDi);
                this.jqw.Q(this.jqQ);
                this.jqw.setOnImageClickListener(this.emX);
                this.jqw.setOnLongClickListener(this.mOnLongClickListener);
                this.jqw.setTbGestureDetector(this.dRm);
                this.jqs.setOnClickListener(this.aDi);
                this.jqD.setOnClickListener(this.aDi);
                this.jqx.setOnClickListener(this.jqV);
                if (this.jqz != null && (this.jqz instanceof com.baidu.tieba.recapp.l)) {
                    ((com.baidu.tieba.recapp.l) this.jqz).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.jqE.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(eVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.eA(this.aJV);
                        next.setImageMaxWidth(this.jqO);
                        next.qG(this.jqH);
                        next.qH(this.jqI);
                        next.qI(this.jqN);
                        next.z(this.aDi);
                        next.Q(this.jqQ);
                        next.setOnImageClickListener(this.emX);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.jqu.z(this.aDi);
                this.jqv.z(this.aDi);
                this.jqu.setData(eVar);
                this.jqt.setData(eVar);
                this.jqv.setData(eVar);
                this.jqA.setData(eVar);
                this.jqB.setData(eVar);
                this.jqF.setPbData(eVar);
                this.jqF.setFrom(this.jpW.jue);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>(eVar.cvu());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cWp() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.jqP = postData;
                }
                boolean z10 = false;
                if (!this.jqI && postData != null) {
                    arrayList2.remove(postData);
                    z10 = true;
                    z2 = true;
                    if (eVar.aQe() && postData.cWr() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && eVar.cvz() != null) {
                    postData = eVar.cvz();
                    z10 = true;
                    z2 = true;
                    if (!this.jqI && eVar.aQe() && postData.cWr() != null) {
                        postData.c(null);
                    }
                }
                boolean z11 = z2;
                PostData postData3 = postData;
                boolean z12 = z10;
                dQ(arrayList2);
                if (this.jpW.cxS()) {
                    if (eVar.cvu().size() > 0 && (postData2 = eVar.cvu().get(0)) != null && postData2.cWp() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        arrayList2.remove(0);
                    }
                } else {
                    int b = b(this.jqG, arrayList2, this.jqI);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, b, this.jqG.cvv());
                    }
                }
                int c = c(this.jqG, arrayList2, this.jqI);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, c, this.jqG.cvw());
                }
                com.baidu.tieba.tbadkCore.t.q(arrayList2, 1);
                boolean z13 = false;
                int b2 = b(eVar, arrayList2);
                if (b2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.joA);
                    jVar.joC = eVar.cvs() != null ? cvs.aKt() : 0L;
                    jVar.isNew = !this.jqI;
                    jVar.joF = this.jpW.cyc();
                    jVar.sortType = eVar.jnA;
                    jVar.joE = eVar.cvR();
                    jVar.isDynamic = eVar.cvQ();
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
                        ((PostData) mVar).kTf = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList2, a, f);
                    z3 = true;
                }
                int i6 = -1;
                if (z11) {
                    i6 = a(eVar, arrayList2, this.jqI);
                }
                if (i6 >= 0 && eVar.cvN() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.cvN());
                    z4 = true;
                    z5 = true;
                } else {
                    postData3.kTe = true;
                    z4 = false;
                    z5 = z3;
                }
                if (i6 < 0 || !eVar.jnE || eVar.jnF == null) {
                    i = i6;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.jnF);
                    i = i6 + 1;
                }
                boolean z14 = false;
                if (!z11 || (cwX = cwX()) == null || i < 0) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i + 1, cwX);
                    z14 = true;
                    z6 = true;
                }
                int i7 = -1;
                if (z11 && !z6) {
                    com.baidu.adp.widget.ListView.m cwY = cwY();
                    if (i >= 0) {
                        i7 = i + 1;
                    } else if (a >= 0) {
                        i7 = a;
                    } else if (b2 >= 0) {
                        i7 = b2;
                    }
                    if (cwY != null && i7 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, i7, cwY);
                        z7 = true;
                        i2 = i7;
                        arrayList = new ArrayList();
                        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cvP()) && eVar.cvP().size() > 2) {
                            min = Math.min(eVar.cvP().size(), 7);
                            i4 = 0;
                            while (true) {
                                i5 = i4;
                                if (i5 < min) {
                                    break;
                                }
                                com.baidu.tbadk.core.data.l lVar = eVar.cvP().get(i5);
                                if (i5 == 0) {
                                    lVar.gs(true);
                                }
                                if (lVar.aKT() == null) {
                                    if (i5 == min - 1) {
                                        lVar.gt(true);
                                    }
                                } else if (i5 == min - 2) {
                                    lVar.gt(true);
                                } else if (i5 == min - 1) {
                                    lVar.gu(true);
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
                        this.jqr.qT(z5);
                        z8 = false;
                        if (this.jpW.cwB() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.jpW.cwB().cyw())) {
                            z8 = true;
                        }
                        if (this.jqJ && !z8) {
                            arrayList2.remove(postData3);
                            this.jqJ = false;
                        }
                        if (eVar.cvN() != null) {
                            eVar.cvN().qF(!z4);
                        }
                        if (this.eOj != null) {
                            this.eIF = arrayList2;
                            this.eOj.setData(this.eIF);
                        }
                        if (!z8 && !z && ((this.jqL || this.jqK) && a != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.jqM)) {
                            this.jqS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.eOj.setSelectionFromTop(f.this.eOj.getHeaderViewsCount() + f.size(), 0 - f.this.jqU);
                                    f.this.jqM = false;
                                }
                            };
                            com.baidu.adp.lib.f.e.lb().post(this.jqS);
                        }
                        if (postData3 != null) {
                            if (this.jqP != null && !this.jqK) {
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, this.jqP);
                            } else {
                                PostData postData4 = new PostData();
                                postData4.Di(1);
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData4);
                            }
                            this.eOj.setData(arrayList2);
                            return;
                        } else if (z12) {
                            com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData3);
                            this.eOj.setData(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z7 = z14;
                i2 = i7;
                arrayList = new ArrayList();
                if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cvP())) {
                    min = Math.min(eVar.cvP().size(), 7);
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
                this.jqr.qT(z5);
                z8 = false;
                if (this.jpW.cwB() != null) {
                    z8 = true;
                }
                if (this.jqJ) {
                    arrayList2.remove(postData3);
                    this.jqJ = false;
                }
                if (eVar.cvN() != null) {
                }
                if (this.eOj != null) {
                }
                if (!z8) {
                    this.jqS = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.eOj.setSelectionFromTop(f.this.eOj.getHeaderViewsCount() + f.size(), 0 - f.this.jqU);
                            f.this.jqM = false;
                        }
                    };
                    com.baidu.adp.lib.f.e.lb().post(this.jqS);
                }
                if (postData3 != null) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m cwX() {
        PbModel cwB = this.jpW.cwB();
        if (cwB == null) {
            return null;
        }
        String czn = cwB.czn();
        if (TextUtils.isEmpty(czn)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.KN(czn);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m cwY() {
        if (this.jqG == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m cyL = this.jpW.cwB().cyL();
        if (cyL == null) {
            cyL = this.jqG.cvH();
        }
        if (cyL != null) {
            AdvertAppInfo.ILegoAdvert cWe = cyL.cWe();
            if (cWe != null) {
                cWe.setAdvertAppInfo(cyL.po());
            }
            int aID = cyL.cWd().aID();
            if (aID != 0) {
                a(cyL, aID);
                if (aID == 28 || aID == 31 || cyL.cWd().goods == null) {
                    return null;
                }
                cyL.cWd().goods.goods_style = -1001;
                return null;
            }
            if (this.jqG.getForum() != null) {
                cyL.forumId = this.jqG.getForum().getId();
            }
            if (this.jqG.cvs() != null) {
                cyL.threadId = com.baidu.adp.lib.f.b.toLong(this.jqG.cvs().getId(), 0L);
            }
            if (this.jqG != null && this.jqG.getPage() != null) {
                cyL.pageNumber = this.jqG.getPage().aJw();
            }
            c(cyL);
            return cyL;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.jqK || eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cvu()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.aQe() && this.jqI) ? 0 : -1;
        } else if (this.jpW.cwB() == null || !this.jpW.cwB().getIsFromMark()) {
            if (this.jpW.cxt() == null || !this.jpW.cxt().cBt()) {
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
                        if (postData.cWp() == 1 && postData.kTb == 0) {
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
                return eVar.aQe() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cvu()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cvu(), 0)) == null) {
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
                if (postData.cWp() == 1 && postData.kTb == 0) {
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
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cvu()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.aQe()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.cvu().get(0) == null || eVar.cvu().get(0).cWp() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cvD() == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cvD().joP)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.cvD().joP;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.kTp = true;
                postData.kTd = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(eVar.cvD().joQ) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).kTd = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).kTd = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.joB);
        jVar.joD = eVar.cvD().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void bZN() {
        if (this.jpW != null && !bZO()) {
            this.jpW.registerListener(this.hqv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZO() {
        if (this.jpW == null) {
            return false;
        }
        this.hqt = new ArrayList();
        ArrayList<BdUniqueId> cVH = com.baidu.tieba.tbadkCore.t.cVH();
        if (cVH == null || cVH.size() <= 0) {
            return false;
        }
        int size = cVH.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cod().a(this.jpW.getPageContext(), cVH.get(i), 2);
            if (a != null) {
                this.aMj.add(a);
                this.hqt.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.hqt)) {
            this.eOj.addAdapters(this.hqt);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.eOj.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.cvu() == null || eVar.cvv() == null || eVar.cvu().size() == 0 || eVar.cvs() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cvv().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cvu().get(0) == null || eVar.cvu().get(0).cWp() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aJw() != eVar.getPage().aJt()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.cvu() == null || eVar.cvw() == null || eVar.cvu().size() == 0 || eVar.cvs() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cvw().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cvu().get(0) == null || eVar.cvu().get(0).cWp() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aJw() != eVar.getPage().aJt()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.eOj.getItem(i);
    }

    public ArrayList<PostData> cwZ() {
        return this.postList;
    }

    public BdUniqueId zp(int i) {
        if (this.eOj.getItem(i) != null) {
            return this.eOj.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.jqT = cxa();
        if (this.eOj.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }

    public int cxa() {
        if (this.eOj != null && this.eOj.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eOj.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.eOj.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.j.joA) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cxb() {
        return this.jqT;
    }

    private void cxc() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.jqG != null) {
            ArrayList<PostData> cvu = this.jqG.cvu();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> cvG = this.jqG.cvG();
            if (cvG != null) {
                int size = cvG.size();
                if (cvu != null && cvu.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = cvG.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = cvG.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.hqr = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = cvG.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cWd() != null) {
                            int aID = next3.cWd().aID();
                            if (aID != 0) {
                                a(next3, aID);
                                if (aID != 28 && aID != 31) {
                                    if (next3.cWd().goods != null) {
                                        next3.cWd().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.x.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cWd().apk_name)) {
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
                        /* renamed from: a */
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.m mVar4 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.jqG.getForum() != null) {
                            mVar4.forumId = this.jqG.getForum().getId();
                        }
                        if (this.jqG.cvs() != null) {
                            mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.jqG.cvs().getId(), 0L);
                        }
                        if (this.jqG != null && this.jqG.getPage() != null) {
                            mVar4.pageNumber = this.jqG.getPage().aJw();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= cvu.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.jqI) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        cvu.add(position2, mVar4);
                        TiebaStatic.eventStat(this.jpW.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cWd().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(mVar, 5);
        c.BI(i);
        com.baidu.tieba.recapp.report.d.cOj().a(c);
        if (mVar != null && mVar.cWd() != null) {
            mVar.cWd().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cWd() != null && mVar.cWd().goods != null && mVar.cWd().goods.goods_style != 1001 && mVar.cWd().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.jqG != null && mVar.cWd() != null) {
            mVar.cWd().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.jqG.getPage() != null) {
                mVar.cWd().advertAppContext.pn = this.jqG.getPage().aJw();
            }
            mVar.cWd().advertAppContext.page = mVar.cWg();
            if (this.jqG.getForum() != null && (forum = this.jqG.getForum()) != null) {
                mVar.cWd().advertAppContext.fid = forum.getId();
                mVar.cWd().advertAppContext.dlX = forum.getFirst_class();
                mVar.cWd().advertAppContext.dlY = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cWd().advertAppContext.dlZ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cWd().advertAppContext.extensionInfo = mVar.cWd().ext_info;
            mVar.cWd().advertAppContext.WL = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.jqr.setFromCDN(z);
        if (this.jqz != null && (this.jqz instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.jqz).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.jqE.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cxd() {
        return this.jqH;
    }

    public void qG(boolean z) {
        this.jqH = z;
    }

    public void qH(boolean z) {
        this.jqI = z;
    }

    public void qI(boolean z) {
        this.jqN = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jqQ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emX = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dRm = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.aDi = onClickListener;
    }

    public void zq(int i) {
        switch (i) {
            case 1:
                if (this.jqr != null) {
                    this.jqr.pause();
                    return;
                }
                return;
            case 2:
                if (this.jqr != null) {
                    this.jqr.resume();
                    return;
                }
                return;
            case 3:
                if (this.jqr != null) {
                    this.jqr.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dQ(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.aLJ())) {
                        com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
                        aeVar.tN(postData.aLJ());
                        list.set(i, aeVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jqS);
        if (this.jqu != null) {
            this.jqu.onDestroy();
        }
        if (this.jqv != null) {
            this.jqv.onDestroy();
        }
        if (this.jqs != null) {
            this.jqs.onDestroy();
        }
        if (this.jqt != null) {
            this.jqt.onDestroy();
        }
    }

    public void qM(boolean z) {
        this.jqK = z;
    }

    public void qN(boolean z) {
        this.jqL = z;
    }

    public void qO(boolean z) {
        this.jqJ = z;
    }

    public void qP(boolean z) {
        this.jqM = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cxe() {
        return this.jqs;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.eIF;
    }

    public View cxf() {
        if (this.jqr == null || this.jqr.cxi() == null) {
            return null;
        }
        if (this.jqr.cxi().jsK != null && this.jqr.cxi().jsK.isShown()) {
            return this.jqr.cxi().jsK;
        }
        return this.jqr.cxi().jsJ;
    }

    public q cxg() {
        if (this.jqr == null || this.jqr.cxi() == null) {
            return null;
        }
        return this.jqr.cxi();
    }
}
