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
    private ArrayList<com.baidu.adp.widget.ListView.m> eIA;
    private BdTypeListView eOe;
    private com.baidu.adp.widget.ListView.a hPE;
    private List<com.baidu.adp.widget.ListView.a> hqn;
    private PbFragment jpS;
    private g jqB;
    private com.baidu.tieba.pb.data.e jqC;
    private boolean jqH;
    private boolean jqI;
    private int jqK;
    private Runnable jqO;
    private int jqQ;
    private p jqn;
    private com.baidu.tieba.pb.pb.main.adapter.c jqo;
    private com.baidu.tieba.pb.pb.main.adapter.a jqp;
    private ai jqq;
    private ai jqr;
    private j jqs;
    private com.baidu.tieba.pb.video.a jqt;
    private com.baidu.tieba.card.divider.a jqu;
    private com.baidu.adp.widget.ListView.a jqv;
    private ae jqw;
    private af jqx;
    private ac jqy;
    private com.baidu.tieba.pb.pb.a.c jqz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> jqA = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean jqD = true;
    private boolean jqE = true;
    private boolean jqF = false;
    private boolean jqG = false;
    private boolean jqJ = false;
    private String aJP = null;
    private PostData jqL = null;
    private View.OnClickListener jqM = null;
    private View.OnClickListener aDc = null;
    private TbRichTextView.i emS = null;
    private com.baidu.tieba.pb.a.c dRh = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> jqN = new ArrayList();
    private int jqP = -1;
    private CustomMessageListener hfE = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cVX = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cVX();
                Iterator it = cVX.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(f.this.jpS);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.jqA.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cVX);
                f.this.jqN.clear();
                f.this.jqN.addAll(arrayList);
                if (f.this.eOe != null) {
                    f.this.eOe.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener dOK = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.jqC != null && !com.baidu.adp.base.i.R(f.this.jpS.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener jqR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.jpS != null && f.this.jqC != null && f.this.jqC.cvF() != null) {
                f.this.jpS.cxv().cAt().cwy();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener hqp = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.hqn)) {
                f.this.bZP();
                f.this.a(f.this.jqC, false);
            }
        }
    };

    public f(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.jqK = 0;
        this.width = -1;
        this.jqQ = 0;
        this.jqK = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.jqK;
        this.jpS = pbFragment;
        this.eOe = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.dOK);
        this.jqQ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jpS.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.jqn = new p(pbFragment, PostData.kSn);
        this.jqn.a((TbRichTextView.c) pbFragment);
        this.jqo = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.k.joC);
        this.jqp = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.jnj);
        this.jqq = new ai(pbFragment, com.baidu.tieba.pb.data.j.jow);
        this.jqr = new ai(pbFragment, com.baidu.tieba.pb.data.j.jox);
        this.jqs = new j(pbFragment, PostData.kSo);
        this.jqs.a((TbRichTextView.c) pbFragment);
        this.hPE = com.baidu.tieba.recapp.q.cNo().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dmc);
        this.jqv = com.baidu.tieba.recapp.q.cNo().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dmg);
        this.jqy = new ac(pbFragment, com.baidu.tieba.pb.data.i.Vm);
        this.jqw = new ae(pbFragment, ab.jye);
        this.jqx = new af(pbFragment, at.dpo);
        this.jqz = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.kSt);
        this.jqt = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.jIK);
        this.jqu = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.jqB = new g(pbFragment, com.baidu.tbadk.core.data.l.dnm);
        this.aMd.add(this.jqn);
        this.aMd.add(this.jqo);
        this.aMd.add(this.jqp);
        this.aMd.add(this.jqs);
        this.aMd.add(this.jqq);
        this.aMd.add(this.jqr);
        this.aMd.add(this.hPE);
        this.aMd.add(this.jqv);
        this.aMd.add(this.jqy);
        this.aMd.add(this.jqw);
        this.aMd.add(this.jqx);
        this.aMd.add(this.jqt);
        this.aMd.add(this.jqz);
        this.aMd.add(this.jqu);
        this.aMd.add(this.jqB);
        this.hfE.setPriority(1);
        this.hfE.setSelfListener(true);
        pbFragment.registerListener(this.hfE);
        bZO();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.aMd);
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
        com.baidu.adp.widget.ListView.m cwZ;
        bj cvu;
        PostData postData2;
        if (eVar != null) {
            boolean z9 = false;
            if (this.jqC != eVar) {
                z9 = true;
                if ((eVar != null && !eVar.cvs()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z9 = false;
                }
            }
            this.jqC = eVar;
            if (z9) {
                cxe();
                if (eVar != null) {
                    eVar.qE(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.jqC != null && this.jqC.cvw() != null && this.jqC.cvw().size() > 0) {
                this.postList.addAll(this.jqC.cvw());
            }
            if (eVar != null && eVar.cvu() != null && eVar.cvu().aKE() != null) {
                this.aJP = eVar.cvu().aKE().getUserId();
            }
            if (this.jqn != null) {
                this.jqn.setData(eVar);
                this.jqn.setFromCDN(this.mIsFromCDN);
                this.jqn.setImageMaxWidth(this.jqK);
                this.jqn.qG(this.jqD);
                this.jqn.z(this.aDc);
                this.jqn.Q(this.jqM);
                this.jqn.setOnImageClickListener(this.emS);
                this.jqn.setOnLongClickListener(this.mOnLongClickListener);
                this.jqn.setTbGestureDetector(this.dRh);
                this.jqs.setData(eVar);
                this.jqs.setFromCDN(this.mIsFromCDN);
                this.jqs.eA(this.aJP);
                this.jqs.qG(this.jqD);
                this.jqs.z(this.aDc);
                this.jqs.Q(this.jqM);
                this.jqs.setOnImageClickListener(this.emS);
                this.jqs.setOnLongClickListener(this.mOnLongClickListener);
                this.jqs.setTbGestureDetector(this.dRh);
                this.jqo.setOnClickListener(this.aDc);
                this.jqz.setOnClickListener(this.aDc);
                this.jqt.setOnClickListener(this.jqR);
                if (this.jqv != null && (this.jqv instanceof com.baidu.tieba.recapp.l)) {
                    ((com.baidu.tieba.recapp.l) this.jqv).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.jqA.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(eVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.eA(this.aJP);
                        next.setImageMaxWidth(this.jqK);
                        next.qG(this.jqD);
                        next.qH(this.jqE);
                        next.qI(this.jqJ);
                        next.z(this.aDc);
                        next.Q(this.jqM);
                        next.setOnImageClickListener(this.emS);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.jqq.z(this.aDc);
                this.jqr.z(this.aDc);
                this.jqq.setData(eVar);
                this.jqp.setData(eVar);
                this.jqr.setData(eVar);
                this.jqw.setData(eVar);
                this.jqx.setData(eVar);
                this.jqB.setPbData(eVar);
                this.jqB.setFrom(this.jpS.jua);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>(eVar.cvw());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cWr() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.jqL = postData;
                }
                boolean z10 = false;
                if (!this.jqE && postData != null) {
                    arrayList2.remove(postData);
                    z10 = true;
                    z2 = true;
                    if (eVar.aQh() && postData.cWt() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && eVar.cvB() != null) {
                    postData = eVar.cvB();
                    z10 = true;
                    z2 = true;
                    if (!this.jqE && eVar.aQh() && postData.cWt() != null) {
                        postData.c(null);
                    }
                }
                boolean z11 = z2;
                PostData postData3 = postData;
                boolean z12 = z10;
                dQ(arrayList2);
                if (this.jpS.cxU()) {
                    if (eVar.cvw().size() > 0 && (postData2 = eVar.cvw().get(0)) != null && postData2.cWr() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        arrayList2.remove(0);
                    }
                } else {
                    int b = b(this.jqC, arrayList2, this.jqE);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, b, this.jqC.cvx());
                    }
                }
                int c = c(this.jqC, arrayList2, this.jqE);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, c, this.jqC.cvy());
                }
                com.baidu.tieba.tbadkCore.t.q(arrayList2, 1);
                boolean z13 = false;
                int b2 = b(eVar, arrayList2);
                if (b2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.jow);
                    jVar.joy = eVar.cvu() != null ? cvu.aKv() : 0L;
                    jVar.isNew = !this.jqE;
                    jVar.joB = this.jpS.cye();
                    jVar.sortType = eVar.jnw;
                    jVar.joA = eVar.cvT();
                    jVar.isDynamic = eVar.cvS();
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
                        ((PostData) mVar).kTb = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList2, a, f);
                    z3 = true;
                }
                int i6 = -1;
                if (z11) {
                    i6 = a(eVar, arrayList2, this.jqE);
                }
                if (i6 >= 0 && eVar.cvP() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.cvP());
                    z4 = true;
                    z5 = true;
                } else {
                    postData3.kTa = true;
                    z4 = false;
                    z5 = z3;
                }
                if (i6 < 0 || !eVar.jnA || eVar.jnB == null) {
                    i = i6;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.jnB);
                    i = i6 + 1;
                }
                boolean z14 = false;
                if (!z11 || (cwZ = cwZ()) == null || i < 0) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i + 1, cwZ);
                    z14 = true;
                    z6 = true;
                }
                int i7 = -1;
                if (z11 && !z6) {
                    com.baidu.adp.widget.ListView.m cxa = cxa();
                    if (i >= 0) {
                        i7 = i + 1;
                    } else if (a >= 0) {
                        i7 = a;
                    } else if (b2 >= 0) {
                        i7 = b2;
                    }
                    if (cxa != null && i7 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, i7, cxa);
                        z7 = true;
                        i2 = i7;
                        arrayList = new ArrayList();
                        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cvR()) && eVar.cvR().size() > 2) {
                            min = Math.min(eVar.cvR().size(), 7);
                            i4 = 0;
                            while (true) {
                                i5 = i4;
                                if (i5 < min) {
                                    break;
                                }
                                com.baidu.tbadk.core.data.l lVar = eVar.cvR().get(i5);
                                if (i5 == 0) {
                                    lVar.gs(true);
                                }
                                if (lVar.aKV() == null) {
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
                        this.jqn.qT(z5);
                        z8 = false;
                        if (this.jpS.cwD() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.jpS.cwD().cyy())) {
                            z8 = true;
                        }
                        if (this.jqF && !z8) {
                            arrayList2.remove(postData3);
                            this.jqF = false;
                        }
                        if (eVar.cvP() != null) {
                            eVar.cvP().qF(!z4);
                        }
                        if (this.eOe != null) {
                            this.eIA = arrayList2;
                            this.eOe.setData(this.eIA);
                        }
                        if (!z8 && !z && ((this.jqH || this.jqG) && a != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.jqI)) {
                            this.jqO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.eOe.setSelectionFromTop(f.this.eOe.getHeaderViewsCount() + f.size(), 0 - f.this.jqQ);
                                    f.this.jqI = false;
                                }
                            };
                            com.baidu.adp.lib.f.e.lb().post(this.jqO);
                        }
                        if (postData3 != null) {
                            if (this.jqL != null && !this.jqG) {
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, this.jqL);
                            } else {
                                PostData postData4 = new PostData();
                                postData4.Di(1);
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData4);
                            }
                            this.eOe.setData(arrayList2);
                            return;
                        } else if (z12) {
                            com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData3);
                            this.eOe.setData(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z7 = z14;
                i2 = i7;
                arrayList = new ArrayList();
                if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cvR())) {
                    min = Math.min(eVar.cvR().size(), 7);
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
                this.jqn.qT(z5);
                z8 = false;
                if (this.jpS.cwD() != null) {
                    z8 = true;
                }
                if (this.jqF) {
                    arrayList2.remove(postData3);
                    this.jqF = false;
                }
                if (eVar.cvP() != null) {
                }
                if (this.eOe != null) {
                }
                if (!z8) {
                    this.jqO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.eOe.setSelectionFromTop(f.this.eOe.getHeaderViewsCount() + f.size(), 0 - f.this.jqQ);
                            f.this.jqI = false;
                        }
                    };
                    com.baidu.adp.lib.f.e.lb().post(this.jqO);
                }
                if (postData3 != null) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m cwZ() {
        PbModel cwD = this.jpS.cwD();
        if (cwD == null) {
            return null;
        }
        String czp = cwD.czp();
        if (TextUtils.isEmpty(czp)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.KK(czp);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m cxa() {
        if (this.jqC == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m cyN = this.jpS.cwD().cyN();
        if (cyN == null) {
            cyN = this.jqC.cvJ();
        }
        if (cyN != null) {
            AdvertAppInfo.ILegoAdvert cWg = cyN.cWg();
            if (cWg != null) {
                cWg.setAdvertAppInfo(cyN.po());
            }
            int aIF = cyN.cWf().aIF();
            if (aIF != 0) {
                a(cyN, aIF);
                if (aIF == 28 || aIF == 31 || cyN.cWf().goods == null) {
                    return null;
                }
                cyN.cWf().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                return null;
            }
            if (this.jqC.getForum() != null) {
                cyN.forumId = this.jqC.getForum().getId();
            }
            if (this.jqC.cvu() != null) {
                cyN.threadId = com.baidu.adp.lib.f.b.toLong(this.jqC.cvu().getId(), 0L);
            }
            if (this.jqC != null && this.jqC.getPage() != null) {
                cyN.pageNumber = this.jqC.getPage().aJy();
            }
            c(cyN);
            return cyN;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.jqG || eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cvw()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.aQh() && this.jqE) ? 0 : -1;
        } else if (this.jpS.cwD() == null || !this.jpS.cwD().getIsFromMark()) {
            if (this.jpS.cxv() == null || !this.jpS.cxv().cBv()) {
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
                        if (postData.cWr() == 1 && postData.kSX == 0) {
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
                return eVar.aQh() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cvw()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cvw(), 0)) == null) {
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
                if (postData.cWr() == 1 && postData.kSX == 0) {
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
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cvw()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.aQh()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.cvw().get(0) == null || eVar.cvw().get(0).cWr() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cvF() == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cvF().joL)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.cvF().joL;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.kTl = true;
                postData.kSZ = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(eVar.cvF().joM) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).kSZ = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).kSZ = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.jox);
        jVar.joz = eVar.cvF().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void bZO() {
        if (this.jpS != null && !bZP()) {
            this.jpS.registerListener(this.hqp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZP() {
        if (this.jpS == null) {
            return false;
        }
        this.hqn = new ArrayList();
        ArrayList<BdUniqueId> cVJ = com.baidu.tieba.tbadkCore.t.cVJ();
        if (cVJ == null || cVJ.size() <= 0) {
            return false;
        }
        int size = cVJ.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cof().a(this.jpS.getPageContext(), cVJ.get(i), 2);
            if (a != null) {
                this.aMd.add(a);
                this.hqn.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.hqn)) {
            this.eOe.addAdapters(this.hqn);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.eOe.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.cvw() == null || eVar.cvx() == null || eVar.cvw().size() == 0 || eVar.cvu() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cvx().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cvw().get(0) == null || eVar.cvw().get(0).cWr() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aJy() != eVar.getPage().aJv()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.cvw() == null || eVar.cvy() == null || eVar.cvw().size() == 0 || eVar.cvu() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cvy().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cvw().get(0) == null || eVar.cvw().get(0).cWr() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aJy() != eVar.getPage().aJv()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.eOe.getItem(i);
    }

    public ArrayList<PostData> cxb() {
        return this.postList;
    }

    public BdUniqueId zp(int i) {
        if (this.eOe.getItem(i) != null) {
            return this.eOe.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.jqP = cxc();
        if (this.eOe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }

    public int cxc() {
        if (this.eOe != null && this.eOe.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.eOe.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.eOe.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.j.jow) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cxd() {
        return this.jqP;
    }

    private void cxe() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.jqC != null) {
            ArrayList<PostData> cvw = this.jqC.cvw();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> cvI = this.jqC.cvI();
            if (cvI != null) {
                int size = cvI.size();
                if (cvw != null && cvw.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = cvI.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = cvI.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.hql = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = cvI.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cWf() != null) {
                            int aIF = next3.cWf().aIF();
                            if (aIF != 0) {
                                a(next3, aIF);
                                if (aIF != 28 && aIF != 31) {
                                    if (next3.cWf().goods != null) {
                                        next3.cWf().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.x.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cWf().apk_name)) {
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
                        if (this.jqC.getForum() != null) {
                            mVar4.forumId = this.jqC.getForum().getId();
                        }
                        if (this.jqC.cvu() != null) {
                            mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.jqC.cvu().getId(), 0L);
                        }
                        if (this.jqC != null && this.jqC.getPage() != null) {
                            mVar4.pageNumber = this.jqC.getPage().aJy();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= cvw.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.jqE) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        cvw.add(position2, mVar4);
                        TiebaStatic.eventStat(this.jpS.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cWf().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(mVar, 5);
        c.BI(i);
        com.baidu.tieba.recapp.report.d.cOl().a(c);
        if (mVar != null && mVar.cWf() != null) {
            mVar.cWf().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cWf() != null && mVar.cWf().goods != null && mVar.cWf().goods.goods_style != 1001 && mVar.cWf().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.jqC != null && mVar.cWf() != null) {
            mVar.cWf().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.jqC.getPage() != null) {
                mVar.cWf().advertAppContext.pn = this.jqC.getPage().aJy();
            }
            mVar.cWf().advertAppContext.page = mVar.cWi();
            if (this.jqC.getForum() != null && (forum = this.jqC.getForum()) != null) {
                mVar.cWf().advertAppContext.fid = forum.getId();
                mVar.cWf().advertAppContext.dlT = forum.getFirst_class();
                mVar.cWf().advertAppContext.dlU = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cWf().advertAppContext.dlV = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cWf().advertAppContext.extensionInfo = mVar.cWf().ext_info;
            mVar.cWf().advertAppContext.WI = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.jqn.setFromCDN(z);
        if (this.jqv != null && (this.jqv instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.jqv).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.jqA.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cxf() {
        return this.jqD;
    }

    public void qG(boolean z) {
        this.jqD = z;
    }

    public void qH(boolean z) {
        this.jqE = z;
    }

    public void qI(boolean z) {
        this.jqJ = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jqM = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.emS = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dRh = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.aDc = onClickListener;
    }

    public void zq(int i) {
        switch (i) {
            case 1:
                if (this.jqn != null) {
                    this.jqn.pause();
                    return;
                }
                return;
            case 2:
                if (this.jqn != null) {
                    this.jqn.resume();
                    return;
                }
                return;
            case 3:
                if (this.jqn != null) {
                    this.jqn.release();
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
                    if (!TextUtils.isEmpty(postData.aLL())) {
                        com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
                        aeVar.tK(postData.aLL());
                        list.set(i, aeVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jqO);
        if (this.jqq != null) {
            this.jqq.onDestroy();
        }
        if (this.jqr != null) {
            this.jqr.onDestroy();
        }
        if (this.jqo != null) {
            this.jqo.onDestroy();
        }
        if (this.jqp != null) {
            this.jqp.onDestroy();
        }
    }

    public void qM(boolean z) {
        this.jqG = z;
    }

    public void qN(boolean z) {
        this.jqH = z;
    }

    public void qO(boolean z) {
        this.jqF = z;
    }

    public void qP(boolean z) {
        this.jqI = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cxg() {
        return this.jqo;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.eIA;
    }

    public View cxh() {
        if (this.jqn == null || this.jqn.cxk() == null) {
            return null;
        }
        if (this.jqn.cxk().jsG != null && this.jqn.cxk().jsG.isShown()) {
            return this.jqn.cxk().jsG;
        }
        return this.jqn.cxk().jsF;
    }

    public q cxi() {
        if (this.jqn == null || this.jqn.cxk() == null) {
            return null;
        }
        return this.jqn.cxk();
    }
}
