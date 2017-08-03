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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.GodUserData;
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
/* loaded from: classes.dex */
public class g {
    private List<com.baidu.adp.widget.ListView.a> clZ;
    private com.baidu.adp.widget.ListView.a cpI;
    private com.baidu.adp.widget.ListView.a cpJ;
    private int eEg;
    private com.baidu.tieba.pb.data.f eEj;
    private PbActivity eFn;
    private com.baidu.tieba.pb.pb.a.f eHQ;
    private o eHR;
    private am eHS;
    private aj eHT;
    private j eHU;
    private com.baidu.tieba.pb.video.j eHV;
    private com.baidu.tieba.pb.video.l eHW;
    private com.baidu.tieba.pb.video.a eHX;
    private int eHY;
    private com.baidu.adp.widget.ListView.a eIa;
    private com.baidu.adp.widget.ListView.a eIb;
    private com.baidu.adp.widget.ListView.a eIc;
    private ac eId;
    private ag eIe;
    private com.baidu.tieba.pb.pb.a.b eIf;
    private com.baidu.tieba.pb.pb.a.g eIg;
    private r eIh;
    private aa eIi;
    private com.baidu.tieba.pb.pb.a.c eIj;
    private boolean eIn;
    private boolean eIo;
    private Runnable eIt;
    private BdTypeListView mListView;
    private int width;
    private int eHZ = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eIk = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eEh = true;
    private boolean eIl = true;
    private boolean eEi = true;
    private boolean eIm = false;
    private boolean eIp = false;
    private boolean eIq = false;
    private String mHostId = null;
    private View.OnClickListener eEm = null;
    private View.OnClickListener cKt = null;
    private TbRichTextView.e aQA = null;
    private com.baidu.tieba.pb.a.c aQB = null;
    private View.OnLongClickListener auW = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eIr = new ArrayList();
    private boolean eIs = false;
    private CustomMessageListener cmh = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList brR = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).brR();
                Iterator it = brR.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).aq(g.this.eFn);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.eIk.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            g.this.eIf = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(brR);
                g.this.eIr.clear();
                g.this.eIr.addAll(arrayList);
                if (g.this.mListView != null) {
                    g.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener ciS = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.eEj != null && !com.baidu.adp.base.i.X(g.this.eFn.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener cmi = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.u.v(g.this.clZ)) {
                g.this.agF();
                g.this.a(g.this.eEj, false);
            }
        }
    };

    public g(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eEg = 0;
        this.width = -1;
        this.eEg = com.baidu.adp.lib.util.k.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.eEg;
        this.eFn = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.ciS);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eIg = new com.baidu.tieba.pb.pb.a.g(pbActivity, PostData.ggF);
        this.eHR = new o(pbActivity, PostData.ggC);
        this.eHR.a(pbActivity);
        this.eHQ = new com.baidu.tieba.pb.pb.a.f(pbActivity, com.baidu.tieba.pb.data.j.TYPE);
        this.eHS = new am(pbActivity, com.baidu.tieba.pb.data.m.eDp);
        this.eHT = new aj(pbActivity, com.baidu.tieba.pb.data.k.eDl);
        this.eHU = new j(pbActivity, PostData.ggD);
        this.eHU.a(pbActivity);
        this.cpI = com.baidu.tieba.recapp.r.bhv().a(pbActivity, AdvertAppInfo.SZ);
        this.eIa = com.baidu.tieba.recapp.r.bhv().a(pbActivity, AdvertAppInfo.Ta);
        this.eIb = com.baidu.tieba.recapp.r.bhv().a(pbActivity, AdvertAppInfo.Tb);
        this.eIc = com.baidu.tieba.recapp.r.bhv().a(pbActivity, AdvertAppInfo.Tc);
        this.cpJ = com.baidu.tieba.recapp.r.bhv().a(pbActivity, AdvertAppInfo.Tg);
        this.eIh = new r(pbActivity, com.baidu.tieba.pb.data.a.eCk);
        this.eIi = new aa(pbActivity, com.baidu.tieba.pb.data.i.eDh);
        this.eId = new ac(pbActivity, z.eLv);
        this.eIe = new ag(pbActivity, com.baidu.tbadk.core.data.au.WK);
        this.eHV = new com.baidu.tieba.pb.video.j(pbActivity, com.baidu.tieba.pb.video.k.eWY);
        this.eHW = new com.baidu.tieba.pb.video.l(pbActivity, com.baidu.tieba.pb.video.m.eXh);
        this.eHW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.a(g.this.eEj, false);
                g.this.notifyDataSetChanged();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11926"));
            }
        });
        this.eHX = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.eVK);
        this.eHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eEj.aPi() != null) {
                    List<Long> list = g.this.eEj.aPi().eDC;
                    int count = g.this.eEj.aPi().getCount();
                    if (list.size() != count) {
                        if (list.size() >= count + 5) {
                            g.this.eEj.aPi().setCount(count + 5);
                            g.this.eFn.aQc().aRN().cC(list.subList(count, count + 5));
                        } else if (list.size() < count + 5) {
                            g.this.eFn.aQc().aRN().cC(list.subList(count, list.size()));
                            g.this.eEj.aPi().setCount(list.size());
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12040"));
                    }
                }
            }
        });
        this.eIj = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Ux);
        if (this.eEj != null && this.eEj.aOY() != null) {
            this.eIj.ana = this.eEj.aOY().Zy;
        }
        this.mAdapters.add(this.eHR);
        this.mAdapters.add(this.eHS);
        this.mAdapters.add(this.eHU);
        this.mAdapters.add(this.eHT);
        this.mAdapters.add(this.eIg);
        this.mAdapters.add(this.cpI);
        this.mAdapters.add(this.eIa);
        this.mAdapters.add(this.eIb);
        this.mAdapters.add(this.eIc);
        this.mAdapters.add(this.cpJ);
        this.mAdapters.add(this.eIh);
        this.mAdapters.add(this.eIi);
        this.mAdapters.add(this.eId);
        this.mAdapters.add(this.eIe);
        this.mAdapters.add(this.eHV);
        this.mAdapters.add(this.eHW);
        this.mAdapters.add(this.eIj);
        this.mAdapters.add(this.eHX);
        this.mAdapters.add(this.eHQ);
        this.cmh.setPriority(1);
        this.cmh.setSelfListener(true);
        pbActivity.registerListener(this.cmh);
        agE();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        int size;
        PostData postData2;
        int size2;
        PostData postData3;
        boolean z5 = false;
        if (fVar != null) {
            if (this.eEj != fVar) {
                z2 = (fVar == null || fVar.aOT()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eEj = fVar;
            if (z2) {
                aQZ();
                if (fVar != null) {
                    fVar.iN(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eEj != null && this.eEj.aPa() != null && this.eEj.aPa().size() > 0) {
                this.postList.addAll(this.eEj.aPa());
            }
            if (fVar != null && fVar.aOY() != null && fVar.aOY().getAuthor() != null) {
                this.mHostId = fVar.aOY().getAuthor().getUserId();
            }
            if (this.eHR != null) {
                this.eIg.b(fVar);
                this.eIg.setFromCDN(this.mIsFromCDN);
                this.eIg.setHostId(this.mHostId);
                this.eIg.oO(this.eEg);
                this.eIg.iP(this.eEh);
                this.eIg.iQ(this.eEi);
                this.eIg.setCommonClickListener(this.cKt);
                this.eIg.G(this.eEm);
                this.eIg.setOnImageClickListener(this.aQA);
                this.eIg.setOnLongClickListener(this.auW);
                this.eHR.b(fVar);
                this.eHR.setFromCDN(this.mIsFromCDN);
                this.eHR.setHostId(this.mHostId);
                this.eHR.oO(this.eEg);
                this.eHR.iP(this.eEh);
                this.eHR.iQ(this.eEi);
                this.eHR.setCommonClickListener(this.cKt);
                this.eHR.G(this.eEm);
                this.eHR.setOnImageClickListener(this.aQA);
                this.eHR.setOnLongClickListener(this.auW);
                this.eHR.setTbGestureDetector(this.aQB);
                this.eHR.oX(fVar != null ? fVar.aOY().rn() : 0);
                this.eHU.b(fVar);
                this.eHU.setFromCDN(this.mIsFromCDN);
                this.eHU.setHostId(this.mHostId);
                this.eHU.iP(this.eEh);
                this.eHU.setCommonClickListener(this.cKt);
                this.eHU.G(this.eEm);
                this.eHU.setOnImageClickListener(this.aQA);
                this.eHU.setOnLongClickListener(this.auW);
                this.eHU.setTbGestureDetector(this.aQB);
                this.eHS.setOnClickListener(this.cKt);
                this.eHS.setTbGestureDetector(this.aQB);
                if (this.eIa != null && (this.eIa instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eIa).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eIb != null && (this.eIb instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eIb).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.cpJ != null && (this.cpJ instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.cpJ).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eIk.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.oO(this.eEg);
                        next.iP(this.eEh);
                        next.iQ(this.eEi);
                        next.iR(this.eIq);
                        next.setCommonClickListener(this.cKt);
                        next.G(this.eEm);
                        next.setOnImageClickListener(this.aQA);
                        next.setOnLongClickListener(this.auW);
                    }
                }
                this.eHT.setCommonClickListener(this.cKt);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aPa());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bsr() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                cB(arrayList);
                if (this.eFn.aQy()) {
                    if (fVar.aPa().size() > 0 && (postData3 = fVar.aPa().get(0)) != null && postData3.bsr() == 1 && !com.baidu.tbadk.core.util.u.v(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.eEj, arrayList, this.eEi);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.u.a(arrayList, b, this.eEj.aPb());
                    }
                }
                int c = c(this.eEj, arrayList, this.eEi);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.u.a(arrayList, c, this.eEj.aPc());
                }
                if (arrayList.size() == 0 && this.eFn.aQy()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.eEi);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.f> c2 = c(fVar, arrayList);
                    if (c2 != null && c2.size() > 0) {
                        com.baidu.tbadk.core.util.u.a((List) arrayList, a, (List) c2);
                    } else {
                        this.eHY = 0;
                    }
                } else {
                    this.eHY = 0;
                }
                com.baidu.tieba.tbadkCore.n.q(arrayList, 1);
                int u = com.baidu.tbadk.core.util.u.u(arrayList);
                int i = 0;
                while (i < u) {
                    com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, i);
                    if (fVar2 instanceof PostData) {
                        ((PostData) fVar2).crt = i == 0;
                    }
                    i++;
                }
                int a2 = a(fVar, arrayList);
                final List<com.baidu.adp.widget.ListView.f> d = d(fVar);
                if (com.baidu.tbadk.core.util.u.v(d) || a2 < 0) {
                    z4 = false;
                } else {
                    com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, a2);
                    if (fVar3 instanceof PostData) {
                        ((PostData) fVar3).crt = true;
                    }
                    com.baidu.tbadk.core.util.u.a((List) arrayList, a2, (List) d);
                    z4 = true;
                }
                int b2 = z3 ? b(fVar, arrayList) : -1;
                if (b2 >= 0 && fVar.aPv() != null) {
                    com.baidu.tbadk.core.util.u.a(arrayList, b2, fVar.aPv());
                    fVar.aPv().iO((b(arrayList, b2) || z4) ? false : true);
                    z4 = true;
                }
                this.eHR.jf(!z4);
                if (!this.eEi && fVar != null && fVar.aPa() != null && (size = fVar.aPa().size()) > 0 && (postData2 = fVar.aPa().get(size - 1)) != null && postData2.bsr() == 1 && (size2 = arrayList.size()) > 0) {
                    arrayList.remove(size2 - 1);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (this.eFn.aQc() != null && postData != null && postData.getId() != null && postData.getId().equals(this.eFn.aQc().getPostId())) {
                    z5 = true;
                }
                if (!z5 && !z) {
                    if ((this.eIn || this.eIm) && a2 != -1 && !com.baidu.tbadk.core.util.u.v(d) && !this.eIo) {
                        this.eIt = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.mListView.setSelection(g.this.mListView.getHeaderViewsCount() + d.size());
                                g.this.eIo = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fP().post(this.eIt);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        MetaData author;
        GodUserData godUserData;
        if (this.eFn.aPf() == null || this.eFn.aQb() == null) {
            return false;
        }
        if (this.eFn.aQb().aTB() || (author = this.eFn.aPf().getAuthor()) == null || (godUserData = author.getGodUserData()) == null || !godUserData.isBigV() || godUserData.getIsLike()) {
            return false;
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
        jVar.eDi = author;
        com.baidu.tbadk.core.util.u.a(arrayList, i + 1, jVar);
        jVar.eDj = true;
        if (!UtilHelper.isCurrentAccount(author.getUserId())) {
            jVar.eDk = true;
            return true;
        }
        jVar.eDk = false;
        return true;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        PostData postData;
        int i;
        int i2 = 0;
        if (fVar == null || com.baidu.tbadk.core.util.u.v(fVar.aPa()) || arrayList == null || arrayList.size() <= 0 || this.eFn.aQL() || this.eIp) {
            return -1;
        }
        if ((this.eFn.aQc() == null || !this.eFn.aQc().getIsFromMark()) && (postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPa(), 0)) != null) {
            int bsr = postData.bsr();
            int size = arrayList.size();
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
                if (fVar2 != null && (fVar2 instanceof PostData)) {
                    PostData postData2 = (PostData) fVar2;
                    if (postData2.bsr() == bsr && postData2.ghm == 0) {
                        i = bsr == 1 ? i2 + 1 : i2;
                    }
                    i2++;
                } else {
                    if (fVar2 != null && (fVar2 instanceof com.baidu.tieba.pb.data.k)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            return i;
        }
        return -1;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!this.eEi) {
            return -1;
        }
        if (fVar == null || com.baidu.tbadk.core.util.u.v(fVar.aPa()) || arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return -1;
            }
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
            if (!(fVar2 instanceof PostData) || ((PostData) fVar2).bsr() != 1) {
                i = i2 + 1;
            } else {
                return i2 + 1;
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.f> d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPi() == null || com.baidu.tbadk.core.util.u.v(fVar.aPi().eDB) || this.eFn.aQL() || this.eIp) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aPi().eDB;
        if (com.baidu.tbadk.core.util.u.v(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.gho = true;
                arrayList.add(postData);
            }
        }
        int u = com.baidu.tbadk.core.util.u.u(fVar.aPi().eDC);
        if (fVar.aPi().getCount() != u && u > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).gho = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).gho = true;
            }
        }
        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
        kVar.mType = 0;
        arrayList.add(0, kVar);
        return arrayList;
    }

    public void aQV() {
        this.eHY = 0;
    }

    public int aQW() {
        return this.eHZ;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.u.v(fVar.aPa()) || com.baidu.tbadk.core.util.u.v(fVar.aOZ())) {
            return -1;
        }
        if (z) {
            return (fVar.aPa().get(0) == null || fVar.aPa().get(0).bsr() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.f> c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (fVar == null || arrayList == null || fVar.aOZ() == null || fVar.aOZ().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<bl> aOZ = fVar.aOZ();
        int size = aOZ.size();
        this.eHZ = 0;
        if (this.eHY + 5 >= size) {
            int i2 = 0;
            for (bl blVar : aOZ) {
                if (blVar != null) {
                    com.baidu.tieba.pb.video.k kVar = new com.baidu.tieba.pb.video.k();
                    int i3 = i2 + 1;
                    if (i3 == 1) {
                        kVar.a(blVar, true, true, true, i3);
                    } else {
                        kVar.a(blVar, true, true, false, i3);
                    }
                    arrayList2.add(kVar);
                    this.eHY++;
                    i = i3;
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (this.eHY <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.eHZ = arrayList2.size();
            }
            return arrayList2;
        }
        int i4 = this.eHY + 5;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            bl blVar2 = aOZ.get(i6);
            if (blVar2 != null) {
                com.baidu.tieba.pb.video.k kVar2 = new com.baidu.tieba.pb.video.k();
                i5++;
                boolean z = i5 == 1;
                if (i6 == i4 - 1) {
                    kVar2.a(blVar2, false, true, z, i5);
                } else {
                    kVar2.a(blVar2, true, true, z, i5);
                }
                arrayList2.add(kVar2);
                this.eHY++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.m());
        this.eHZ = arrayList2.size();
        return arrayList2;
    }

    private void agE() {
        if (this.eFn != null && !agF()) {
            this.eFn.registerListener(this.cmi);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean agF() {
        if (this.eFn == null) {
            return false;
        }
        this.clZ = new ArrayList();
        ArrayList<BdUniqueId> brB = com.baidu.tieba.tbadkCore.n.brB();
        if (brB == null || brB.size() <= 0) {
            return false;
        }
        int size = brB.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aDx().a(this.eFn.getPageContext(), brB.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.clZ.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.u.v(this.clZ)) {
            this.mListView.addAdapters(this.clZ);
        }
        return true;
    }

    public int aQX() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPa() == null || fVar.aPb() == null || fVar.aPa().size() == 0 || fVar.aOY() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPb().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPa().get(0) == null || fVar.aPa().get(0).bsr() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qx() == null || fVar.qx().qr() != fVar.qx().qo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPa() == null || fVar.aPc() == null || fVar.aPa().size() == 0 || fVar.aOY() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPc().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPa().get(0) == null || fVar.aPa().get(0).bsr() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qx() == null || fVar.qx().qr() != fVar.qx().qo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aQY() {
        return this.postList;
    }

    public BdUniqueId oU(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.eIf == null || !this.eIf.aPQ()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aQZ() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eEj != null) {
            ArrayList<PostData> aPa = this.eEj.aPa();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aPm = this.eEj.aPm();
            if (aPm != null) {
                int size = aPm.size();
                if (aPa != null && aPa.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aPm.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.bsi() != null) {
                            sb.append(next.bsi());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aPm.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.cqG = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aPm.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bsg() != null) {
                            int pn = next3.bsg().pn();
                            if (pn != 0) {
                                a(next3, pn);
                                if (pn != 28 && pn != 31) {
                                    if (next3.bsg().goods != null) {
                                        next3.bsg().goods.goods_style = TbErrInfo.ERR_IMG_GET_REMOTE;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bsg().apk_name)) {
                                int position = next3.getPosition();
                                if (position >= 2 && position < 30) {
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
                        com.baidu.tieba.tbadkCore.data.l lVar3 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(sparseArray.keyAt(i));
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.bsi(), lVar3)) != null) {
                            b(lVar2, 30);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (lVar = (com.baidu.tieba.tbadkCore.data.l) entry.getValue()) != null) {
                            sparseArray.put(lVar.getPosition(), lVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.g.7
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.eEj.aOW() != null) {
                            lVar4.forumId = this.eEj.aOW().getId();
                        }
                        if (this.eEj.aOY() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.eEj.aOY().getId(), 0L);
                        }
                        if (this.eEj != null && this.eEj.qx() != null) {
                            lVar4.pageNumber = this.eEj.qx().qr();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (a(lVar4, aPa)) {
                            aPa.add(lVar4);
                        } else if (position2 + i3 >= aPa.size()) {
                            a(lVar4, 2);
                            return;
                        } else {
                            aPa.add(position2, lVar4);
                            TiebaStatic.eventStat(this.eFn.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bsg().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 5);
        c.rV(i);
        com.baidu.tieba.recapp.report.b.bid().a(c);
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bsg() != null && lVar.bsg().goods != null && lVar.bsg().goods.goods_style != 1001 && lVar.bsg().goods.goods_style != -1001) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 5);
            c.rV(i);
            com.baidu.tieba.recapp.report.b.bid().a(c);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aOW;
        if (lVar != null && this.eEj != null && lVar.bsg() != null) {
            lVar.bsg().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eEj.qx() != null) {
                lVar.bsg().advertAppContext.pn = this.eEj.qx().qr();
            }
            lVar.bsg().advertAppContext.SO = "PB";
            if (this.eEj.aOW() != null && (aOW = this.eEj.aOW()) != null) {
                lVar.bsg().advertAppContext.fid = aOW.getId();
                lVar.bsg().advertAppContext.SQ = aOW.getFirst_class();
                lVar.bsg().advertAppContext.SR = aOW.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bsg().advertAppContext.SS = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bsg().advertAppContext.extensionInfo = lVar.bsg().ext_info;
            lVar.bsg().advertAppContext.ST = false;
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.l lVar, ArrayList<PostData> arrayList) {
        int u = com.baidu.tbadk.core.util.u.u(arrayList);
        if (lVar == null || u <= 0) {
            return false;
        }
        int position = lVar.getPosition();
        if (u >= 2 || position != u + 1) {
            return false;
        }
        if (this.eEj != null && this.eEj.qx() != null) {
            lVar.pageNumber = this.eEj.qx().qr();
        }
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eIg.setFromCDN(z);
        this.eHR.setFromCDN(z);
        if (this.eIa != null && (this.eIa instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eIa).setIsFromCDN(z);
        }
        if (this.eIb != null && (this.eIb instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eIb).setIsFromCDN(z);
        }
        if (this.cpJ != null && (this.cpJ instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cpJ).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eIk.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void iP(boolean z) {
        this.eEh = z;
    }

    public void iQ(boolean z) {
        this.eEi = z;
    }

    public void iR(boolean z) {
        this.eIq = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eEm = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aQA = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aQB = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auW = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.cKt = onClickListener;
    }

    public void oV(int i) {
        if (this.eHS != null) {
            this.eHS.oV(i);
        }
        switch (i) {
            case 1:
                if (this.eIf != null) {
                    this.eIf.pause();
                }
                if (this.eHR != null) {
                    this.eHR.pause();
                }
                if (this.eIc != null && (this.eIc instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eIc).release();
                    return;
                }
                return;
            case 2:
                if (this.eIf != null) {
                    this.eIf.resume();
                }
                if (this.eHR != null) {
                    this.eHR.resume();
                }
                if (this.eIc != null && (this.eIc instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eIc).resume();
                    return;
                }
                return;
            case 3:
                if (this.eIf != null) {
                    this.eIf.release();
                }
                if (this.eHR != null) {
                    this.eHR.release();
                }
                if (this.eIc != null && (this.eIc instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eIc).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cB(List<com.baidu.adp.widget.ListView.f> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sq())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.cy(postData.sq());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eIt);
    }

    public void jb(boolean z) {
        this.eIp = z;
    }

    public void jc(boolean z) {
        this.eIm = z;
    }

    public void jd(boolean z) {
        this.eIn = z;
    }

    public void je(boolean z) {
        this.eIo = z;
    }

    public am aRa() {
        return this.eHS;
    }
}
