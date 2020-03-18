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
    private ArrayList<com.baidu.adp.widget.ListView.m> eiP;
    private BdTypeListView ekE;
    private List<com.baidu.adp.widget.ListView.a> gGU;
    private com.baidu.adp.widget.ListView.a hfS;
    private PbFragment iFL;
    private boolean iGA;
    private boolean iGB;
    private int iGD;
    private Runnable iGH;
    private int iGJ;
    private p iGg;
    private com.baidu.tieba.pb.pb.main.adapter.c iGh;
    private com.baidu.tieba.pb.pb.main.adapter.a iGi;
    private ai iGj;
    private ai iGk;
    private j iGl;
    private com.baidu.tieba.pb.video.a iGm;
    private com.baidu.tieba.card.divider.a iGn;
    private com.baidu.adp.widget.ListView.a iGo;
    private ae iGp;
    private af iGq;
    private ac iGr;
    private com.baidu.tieba.pb.pb.a.c iGs;
    private g iGu;
    private com.baidu.tieba.pb.data.e iGv;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> iGt = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean iGw = true;
    private boolean iGx = true;
    private boolean iGy = false;
    private boolean iGz = false;
    private boolean iGC = false;
    private String arg = null;
    private PostData iGE = null;
    private View.OnClickListener iGF = null;
    private View.OnClickListener akE = null;
    private TbRichTextView.i dNb = null;
    private com.baidu.tieba.pb.a.c drk = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> iGG = new ArrayList();
    private int iGI = -1;
    private CustomMessageListener gwt = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cLb = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cLb();
                Iterator it = cLb.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(f.this.iFL);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.iGt.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cLb);
                f.this.iGG.clear();
                f.this.iGG.addAll(arrayList);
                if (f.this.ekE != null) {
                    f.this.ekE.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener doS = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.iGv != null && !com.baidu.adp.base.i.Z(f.this.iFL.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener iGK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.iFL != null && f.this.iGv != null && f.this.iGv.cla() != null) {
                f.this.iFL.cmP().cpN().clS();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener gGW = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.gGU)) {
                f.this.bPo();
                f.this.a(f.this.iGv, false);
            }
        }
    };

    public f(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iGD = 0;
        this.width = -1;
        this.iGJ = 0;
        this.iGD = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.iGD;
        this.iFL = pbFragment;
        this.ekE = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.doS);
        this.iGJ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.iFL.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iGg = new p(pbFragment, PostData.kih);
        this.iGg.a((TbRichTextView.c) pbFragment);
        this.iGh = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.k.iEw);
        this.iGi = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.iDd);
        this.iGj = new ai(pbFragment, com.baidu.tieba.pb.data.j.iEq);
        this.iGk = new ai(pbFragment, com.baidu.tieba.pb.data.j.iEr);
        this.iGl = new j(pbFragment, PostData.kii);
        this.iGl.a((TbRichTextView.c) pbFragment);
        this.hfS = com.baidu.tieba.recapp.r.cCQ().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cMW);
        this.iGo = com.baidu.tieba.recapp.r.cCQ().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cNa);
        this.iGr = new ac(pbFragment, com.baidu.tieba.pb.data.i.iEo);
        this.iGp = new ae(pbFragment, ab.iNV);
        this.iGq = new af(pbFragment, at.cQi);
        this.iGs = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.kin);
        this.iGm = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.iYC);
        this.iGn = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.iGu = new g(pbFragment, com.baidu.tbadk.core.data.l.cOi);
        this.asP.add(this.iGg);
        this.asP.add(this.iGh);
        this.asP.add(this.iGi);
        this.asP.add(this.iGl);
        this.asP.add(this.iGj);
        this.asP.add(this.iGk);
        this.asP.add(this.hfS);
        this.asP.add(this.iGo);
        this.asP.add(this.iGr);
        this.asP.add(this.iGp);
        this.asP.add(this.iGq);
        this.asP.add(this.iGm);
        this.asP.add(this.iGs);
        this.asP.add(this.iGn);
        this.asP.add(this.iGu);
        this.gwt.setPriority(1);
        this.gwt.setSelfListener(true);
        pbFragment.registerListener(this.gwt);
        bPn();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.asP);
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
        com.baidu.adp.widget.ListView.m cmt;
        bj ckP;
        PostData postData2;
        if (eVar != null) {
            boolean z9 = false;
            if (this.iGv != eVar) {
                z9 = true;
                if ((eVar != null && !eVar.ckN()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z9 = false;
                }
            }
            this.iGv = eVar;
            if (z9) {
                cmy();
                if (eVar != null) {
                    eVar.pA(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iGv != null && this.iGv.ckR() != null && this.iGv.ckR().size() > 0) {
                this.postList.addAll(this.iGv.ckR());
            }
            if (eVar != null && eVar.ckP() != null && eVar.ckP().aCr() != null) {
                this.arg = eVar.ckP().aCr().getUserId();
            }
            if (this.iGg != null) {
                this.iGg.setData(eVar);
                this.iGg.setFromCDN(this.mIsFromCDN);
                this.iGg.setImageMaxWidth(this.iGD);
                this.iGg.pC(this.iGw);
                this.iGg.y(this.akE);
                this.iGg.P(this.iGF);
                this.iGg.setOnImageClickListener(this.dNb);
                this.iGg.setOnLongClickListener(this.mOnLongClickListener);
                this.iGg.setTbGestureDetector(this.drk);
                this.iGl.setData(eVar);
                this.iGl.setFromCDN(this.mIsFromCDN);
                this.iGl.dH(this.arg);
                this.iGl.pC(this.iGw);
                this.iGl.y(this.akE);
                this.iGl.P(this.iGF);
                this.iGl.setOnImageClickListener(this.dNb);
                this.iGl.setOnLongClickListener(this.mOnLongClickListener);
                this.iGl.setTbGestureDetector(this.drk);
                this.iGh.setOnClickListener(this.akE);
                this.iGs.setOnClickListener(this.akE);
                this.iGm.setOnClickListener(this.iGK);
                if (this.iGo != null && (this.iGo instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.iGo).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iGt.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(eVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.dH(this.arg);
                        next.setImageMaxWidth(this.iGD);
                        next.pC(this.iGw);
                        next.pD(this.iGx);
                        next.pE(this.iGC);
                        next.y(this.akE);
                        next.P(this.iGF);
                        next.setOnImageClickListener(this.dNb);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.iGj.y(this.akE);
                this.iGk.y(this.akE);
                this.iGj.setData(eVar);
                this.iGi.setData(eVar);
                this.iGk.setData(eVar);
                this.iGp.setData(eVar);
                this.iGq.setData(eVar);
                this.iGu.setPbData(eVar);
                this.iGu.setFrom(this.iFL.iJT);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>(eVar.ckR());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cLv() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.iGE = postData;
                }
                boolean z10 = false;
                if (!this.iGx && postData != null) {
                    arrayList2.remove(postData);
                    z10 = true;
                    z2 = true;
                    if (eVar.aHP() && postData.cLx() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && eVar.ckW() != null) {
                    postData = eVar.ckW();
                    z10 = true;
                    z2 = true;
                    if (!this.iGx && eVar.aHP() && postData.cLx() != null) {
                        postData.c(null);
                    }
                }
                boolean z11 = z2;
                PostData postData3 = postData;
                boolean z12 = z10;
                dF(arrayList2);
                if (this.iFL.cno()) {
                    if (eVar.ckR().size() > 0 && (postData2 = eVar.ckR().get(0)) != null && postData2.cLv() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        arrayList2.remove(0);
                    }
                } else {
                    int b = b(this.iGv, arrayList2, this.iGx);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, b, this.iGv.ckS());
                    }
                }
                int c = c(this.iGv, arrayList2, this.iGx);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, c, this.iGv.ckT());
                }
                com.baidu.tieba.tbadkCore.t.n(arrayList2, 1);
                boolean z13 = false;
                int b2 = b(eVar, arrayList2);
                if (b2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iEq);
                    jVar.iEs = eVar.ckP() != null ? ckP.aCi() : 0L;
                    jVar.isNew = !this.iGx;
                    jVar.iEv = this.iFL.cny();
                    jVar.sortType = eVar.iDq;
                    jVar.iEu = eVar.clo();
                    jVar.isDynamic = eVar.cln();
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
                        ((PostData) mVar).kiV = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList2, a, f);
                    z3 = true;
                }
                int i6 = -1;
                if (z11) {
                    i6 = a(eVar, arrayList2, this.iGx);
                }
                if (i6 >= 0 && eVar.clk() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.clk());
                    z4 = true;
                    z5 = true;
                } else {
                    postData3.kiU = true;
                    z4 = false;
                    z5 = z3;
                }
                if (i6 < 0 || !eVar.iDu || eVar.iDv == null) {
                    i = i6;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, eVar.iDv);
                    i = i6 + 1;
                }
                boolean z14 = false;
                if (!z11 || (cmt = cmt()) == null || i < 0) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i + 1, cmt);
                    z14 = true;
                    z6 = true;
                }
                int i7 = -1;
                if (z11 && !z6) {
                    com.baidu.adp.widget.ListView.m cmu = cmu();
                    if (i >= 0) {
                        i7 = i + 1;
                    } else if (a >= 0) {
                        i7 = a;
                    } else if (b2 >= 0) {
                        i7 = b2;
                    }
                    if (cmu != null && i7 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, i7, cmu);
                        z7 = true;
                        i2 = i7;
                        arrayList = new ArrayList();
                        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.clm()) && eVar.clm().size() > 2) {
                            min = Math.min(eVar.clm().size(), 7);
                            i4 = 0;
                            while (true) {
                                i5 = i4;
                                if (i5 < min) {
                                    break;
                                }
                                com.baidu.tbadk.core.data.l lVar = eVar.clm().get(i5);
                                if (i5 == 0) {
                                    lVar.fv(true);
                                }
                                if (lVar.aCI() == null) {
                                    if (i5 == min - 1) {
                                        lVar.fw(true);
                                    }
                                } else if (i5 == min - 2) {
                                    lVar.fw(true);
                                } else if (i5 == min - 1) {
                                    lVar.fx(true);
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
                        this.iGg.pP(z5);
                        z8 = false;
                        if (this.iFL.clX() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.iFL.clX().cnS())) {
                            z8 = true;
                        }
                        if (this.iGy && !z8) {
                            arrayList2.remove(postData3);
                            this.iGy = false;
                        }
                        if (eVar.clk() != null) {
                            eVar.clk().pB(!z4);
                        }
                        if (this.ekE != null) {
                            this.eiP = arrayList2;
                            this.ekE.setData(this.eiP);
                        }
                        if (!z8 && !z && ((this.iGA || this.iGz) && a != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.iGB)) {
                            this.iGH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.ekE.setSelectionFromTop(f.this.ekE.getHeaderViewsCount() + f.size(), 0 - f.this.iGJ);
                                    f.this.iGB = false;
                                }
                            };
                            com.baidu.adp.lib.f.e.gx().post(this.iGH);
                        }
                        if (postData3 != null) {
                            if (this.iGE != null && !this.iGz) {
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, this.iGE);
                            } else {
                                PostData postData4 = new PostData();
                                postData4.CE(1);
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData4);
                            }
                            this.ekE.setData(arrayList2);
                            return;
                        } else if (z12) {
                            com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData3);
                            this.ekE.setData(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z7 = z14;
                i2 = i7;
                arrayList = new ArrayList();
                if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.clm())) {
                    min = Math.min(eVar.clm().size(), 7);
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
                this.iGg.pP(z5);
                z8 = false;
                if (this.iFL.clX() != null) {
                    z8 = true;
                }
                if (this.iGy) {
                    arrayList2.remove(postData3);
                    this.iGy = false;
                }
                if (eVar.clk() != null) {
                }
                if (this.ekE != null) {
                }
                if (!z8) {
                    this.iGH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.ekE.setSelectionFromTop(f.this.ekE.getHeaderViewsCount() + f.size(), 0 - f.this.iGJ);
                            f.this.iGB = false;
                        }
                    };
                    com.baidu.adp.lib.f.e.gx().post(this.iGH);
                }
                if (postData3 != null) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m cmt() {
        PbModel clX = this.iFL.clX();
        if (clX == null) {
            return null;
        }
        String coJ = clX.coJ();
        if (TextUtils.isEmpty(coJ)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.Ja(coJ);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m cmu() {
        if (this.iGv == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m coh = this.iFL.clX().coh();
        if (coh == null) {
            coh = this.iGv.cle();
        }
        if (coh != null) {
            AdvertAppInfo.ILegoAdvert cLk = coh.cLk();
            if (cLk != null) {
                cLk.setAdvertAppInfo(coh.kK());
            }
            int aAs = coh.cLj().aAs();
            if (aAs != 0) {
                a(coh, aAs);
                if (aAs == 28 || aAs == 31 || coh.cLj().goods == null) {
                    return null;
                }
                coh.cLj().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                return null;
            }
            if (this.iGv.getForum() != null) {
                coh.forumId = this.iGv.getForum().getId();
            }
            if (this.iGv.ckP() != null) {
                coh.threadId = com.baidu.adp.lib.f.b.toLong(this.iGv.ckP().getId(), 0L);
            }
            if (this.iGv != null && this.iGv.getPage() != null) {
                coh.pageNumber = this.iGv.getPage().aBl();
            }
            c(coh);
            return coh;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.iGz || eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckR()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.aHP() && this.iGx) ? 0 : -1;
        } else if (this.iFL.clX() == null || !this.iFL.clX().getIsFromMark()) {
            if (this.iFL.cmP() == null || !this.iFL.cmP().cqP()) {
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
                        if (postData.cLv() == 1 && postData.kiR == 0) {
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
                return eVar.aHP() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckR()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(eVar.ckR(), 0)) == null) {
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
                if (postData.cLv() == 1 && postData.kiR == 0) {
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
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.ckR()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.aHP()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.ckR().get(0) == null || eVar.ckR().get(0).cLv() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cla() == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cla().iEF)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.cla().iEF;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.kjf = true;
                postData.kiT = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(eVar.cla().iEG) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).kiT = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).kiT = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.iEr);
        jVar.iEt = eVar.cla().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void bPn() {
        if (this.iFL != null && !bPo()) {
            this.iFL.registerListener(this.gGW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPo() {
        if (this.iFL == null) {
            return false;
        }
        this.gGU = new ArrayList();
        ArrayList<BdUniqueId> cKN = com.baidu.tieba.tbadkCore.t.cKN();
        if (cKN == null || cKN.size() <= 0) {
            return false;
        }
        int size = cKN.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cdE().a(this.iFL.getPageContext(), cKN.get(i), 2);
            if (a != null) {
                this.asP.add(a);
                this.gGU.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gGU)) {
            this.ekE.addAdapters(this.gGU);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.ekE.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.ckR() == null || eVar.ckS() == null || eVar.ckR().size() == 0 || eVar.ckP() == null || arrayList == null) {
            return -1;
        }
        if (eVar.ckS().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.ckR().get(0) == null || eVar.ckR().get(0).cLv() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aBl() != eVar.getPage().aBi()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (eVar == null || eVar.ckR() == null || eVar.ckT() == null || eVar.ckR().size() == 0 || eVar.ckP() == null || arrayList == null) {
            return -1;
        }
        if (eVar.ckT().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.ckR().get(0) == null || eVar.ckR().get(0).cLv() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aBl() != eVar.getPage().aBi()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.ekE.getItem(i);
    }

    public ArrayList<PostData> cmv() {
        return this.postList;
    }

    public BdUniqueId yO(int i) {
        if (this.ekE.getItem(i) != null) {
            return this.ekE.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.iGI = cmw();
        if (this.ekE.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }

    public int cmw() {
        if (this.ekE != null && this.ekE.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ekE.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.ekE.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.j.iEq) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cmx() {
        return this.iGI;
    }

    private void cmy() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.iGv != null) {
            ArrayList<PostData> ckR = this.iGv.ckR();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> cld = this.iGv.cld();
            if (cld != null) {
                int size = cld.size();
                if (ckR != null && ckR.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = cld.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = cld.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.gGS = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = cld.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cLj() != null) {
                            int aAs = next3.cLj().aAs();
                            if (aAs != 0) {
                                a(next3, aAs);
                                if (aAs != 28 && aAs != 31) {
                                    if (next3.cLj().goods != null) {
                                        next3.cLj().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.x.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cLj().apk_name)) {
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
                        if (this.iGv.getForum() != null) {
                            mVar4.forumId = this.iGv.getForum().getId();
                        }
                        if (this.iGv.ckP() != null) {
                            mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.iGv.ckP().getId(), 0L);
                        }
                        if (this.iGv != null && this.iGv.getPage() != null) {
                            mVar4.pageNumber = this.iGv.getPage().aBl();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= ckR.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.iGx) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        ckR.add(position2, mVar4);
                        TiebaStatic.eventStat(this.iFL.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cLj().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.Bi(i);
        com.baidu.tieba.recapp.report.c.cDK().a(c);
        if (mVar != null && mVar.cLj() != null) {
            mVar.cLj().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cLj() != null && mVar.cLj().goods != null && mVar.cLj().goods.goods_style != 1001 && mVar.cLj().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.iGv != null && mVar.cLj() != null) {
            mVar.cLj().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.iGv.getPage() != null) {
                mVar.cLj().advertAppContext.pn = this.iGv.getPage().aBl();
            }
            mVar.cLj().advertAppContext.page = mVar.cLm();
            if (this.iGv.getForum() != null && (forum = this.iGv.getForum()) != null) {
                mVar.cLj().advertAppContext.fid = forum.getId();
                mVar.cLj().advertAppContext.cMN = forum.getFirst_class();
                mVar.cLj().advertAppContext.cMO = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cLj().advertAppContext.cMP = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cLj().advertAppContext.extensionInfo = mVar.cLj().ext_info;
            mVar.cLj().advertAppContext.Dn = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.iGg.setFromCDN(z);
        if (this.iGo != null && (this.iGo instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iGo).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iGt.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cmz() {
        return this.iGw;
    }

    public void pC(boolean z) {
        this.iGw = z;
    }

    public void pD(boolean z) {
        this.iGx = z;
    }

    public void pE(boolean z) {
        this.iGC = z;
    }

    public void P(View.OnClickListener onClickListener) {
        this.iGF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dNb = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.drk = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.akE = onClickListener;
    }

    public void yP(int i) {
        switch (i) {
            case 1:
                if (this.iGg != null) {
                    this.iGg.pause();
                    return;
                }
                return;
            case 2:
                if (this.iGg != null) {
                    this.iGg.resume();
                    return;
                }
                return;
            case 3:
                if (this.iGg != null) {
                    this.iGg.release();
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
                    if (!TextUtils.isEmpty(postData.aDy())) {
                        com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
                        aeVar.sw(postData.aDy());
                        list.set(i, aeVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iGH);
        if (this.iGj != null) {
            this.iGj.onDestroy();
        }
        if (this.iGk != null) {
            this.iGk.onDestroy();
        }
        if (this.iGh != null) {
            this.iGh.onDestroy();
        }
        if (this.iGi != null) {
            this.iGi.onDestroy();
        }
    }

    public void pI(boolean z) {
        this.iGz = z;
    }

    public void pJ(boolean z) {
        this.iGA = z;
    }

    public void pK(boolean z) {
        this.iGy = z;
    }

    public void pL(boolean z) {
        this.iGB = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cmA() {
        return this.iGh;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.eiP;
    }

    public View cmB() {
        if (this.iGg == null || this.iGg.cmE() == null) {
            return null;
        }
        if (this.iGg.cmE().iIz != null && this.iGg.cmE().iIz.isShown()) {
            return this.iGg.cmE().iIz;
        }
        return this.iGg.cmE().iIy;
    }

    public q cmC() {
        if (this.iGg == null || this.iGg.cmE() == null) {
            return null;
        }
        return this.iGg.cmE();
    }
}
