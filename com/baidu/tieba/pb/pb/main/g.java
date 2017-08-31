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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
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
/* loaded from: classes.dex */
public class g {
    private List<com.baidu.adp.widget.ListView.a> cuz;
    private com.baidu.adp.widget.ListView.a cyf;
    private com.baidu.adp.widget.ListView.a cyg;
    private int eFI;
    private com.baidu.tieba.pb.data.f eFL;
    private PbActivity eGQ;
    private com.baidu.tieba.pb.pb.a.f eJA;
    private r eJB;
    private aa eJC;
    private com.baidu.tieba.pb.pb.a.c eJD;
    private boolean eJI;
    private boolean eJJ;
    private Runnable eJO;
    private o eJk;
    private aj eJl;
    private ag eJm;
    private ag eJn;
    private j eJo;
    private com.baidu.tieba.pb.video.j eJp;
    private com.baidu.tieba.pb.video.l eJq;
    private com.baidu.tieba.pb.video.a eJr;
    private int eJs;
    private com.baidu.adp.widget.ListView.a eJu;
    private com.baidu.adp.widget.ListView.a eJv;
    private com.baidu.adp.widget.ListView.a eJw;
    private ac eJx;
    private ad eJy;
    private com.baidu.tieba.pb.pb.a.b eJz;
    private BdTypeListView mListView;
    private int width;
    private int eJt = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eJE = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eFJ = true;
    private boolean eJF = true;
    private boolean eFK = true;
    private boolean eJG = false;
    private boolean eJH = false;
    private boolean eJK = false;
    private boolean eJL = false;
    private String mHostId = null;
    private View.OnClickListener eFO = null;
    private View.OnClickListener cUc = null;
    private TbRichTextView.e aRy = null;
    private com.baidu.tieba.pb.a.c aRz = null;
    private View.OnLongClickListener avB = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eJM = new ArrayList();
    private boolean eJN = false;
    private int eJP = -1;
    private CustomMessageListener cuG = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList brO = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).brO();
                Iterator it = brO.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).al(g.this.eGQ);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.eJE.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            g.this.eJz = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(brO);
                g.this.eJM.clear();
                g.this.eJM.addAll(arrayList);
                if (g.this.mListView != null) {
                    g.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cqf = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.eFL != null && !com.baidu.adp.base.i.V(g.this.eGQ.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener cuH = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.v(g.this.cuz)) {
                g.this.aiN();
                g.this.a(g.this.eFL, false);
            }
        }
    };

    public g(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eFI = 0;
        this.width = -1;
        this.eFI = com.baidu.adp.lib.util.k.ad(pbActivity.getPageContext().getPageActivity());
        this.width = this.eFI;
        this.eGQ = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cqf);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eJA = new com.baidu.tieba.pb.pb.a.f(pbActivity, PostData.gil);
        this.eJk = new o(pbActivity, PostData.gii);
        this.eJk.a(pbActivity);
        this.eJl = new aj(pbActivity, com.baidu.tieba.pb.data.l.eER);
        this.eJm = new ag(pbActivity, com.baidu.tieba.pb.data.j.eEL);
        this.eJn = new ag(pbActivity, com.baidu.tieba.pb.data.j.eEM);
        this.eJo = new j(pbActivity, PostData.gij);
        this.eJo.a(pbActivity);
        this.cyf = com.baidu.tieba.recapp.r.bhd().a(pbActivity, AdvertAppInfo.TC);
        this.eJu = com.baidu.tieba.recapp.r.bhd().a(pbActivity, AdvertAppInfo.TD);
        this.eJv = com.baidu.tieba.recapp.r.bhd().a(pbActivity, AdvertAppInfo.TE);
        this.eJw = com.baidu.tieba.recapp.r.bhd().a(pbActivity, AdvertAppInfo.TF);
        this.cyg = com.baidu.tieba.recapp.r.bhd().a(pbActivity, AdvertAppInfo.TJ);
        this.eJB = new r(pbActivity, com.baidu.tieba.pb.data.a.eDN);
        this.eJC = new aa(pbActivity, com.baidu.tieba.pb.data.i.eEK);
        this.eJx = new ac(pbActivity, z.eMY);
        this.eJy = new ad(pbActivity, au.Xr);
        this.eJp = new com.baidu.tieba.pb.video.j(pbActivity, com.baidu.tieba.pb.video.k.eYO);
        this.eJq = new com.baidu.tieba.pb.video.l(pbActivity, com.baidu.tieba.pb.video.m.eYW);
        this.eJq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.a(g.this.eFL, false);
                g.this.notifyDataSetChanged();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11926"));
            }
        });
        this.eJr = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.eXB);
        this.eJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eFL.aPh() != null) {
                    List<Long> list = g.this.eFL.aPh().eFf;
                    int count = g.this.eFL.aPh().getCount();
                    if (list.size() != count) {
                        if (list.size() >= count + 5) {
                            g.this.eFL.aPh().setCount(count + 5);
                            g.this.eGQ.aQc().aRS().cC(list.subList(count, count + 5));
                        } else if (list.size() < count + 5) {
                            g.this.eGQ.aQc().aRS().cC(list.subList(count, list.size()));
                            g.this.eFL.aPh().setCount(list.size());
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                    }
                }
            }
        });
        this.eJD = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Vc);
        if (this.eFL != null && this.eFL.aOX() != null) {
            this.eJD.anP = this.eFL.aOX().aac;
        }
        this.mAdapters.add(this.eJk);
        this.mAdapters.add(this.eJl);
        this.mAdapters.add(this.eJo);
        this.mAdapters.add(this.eJm);
        this.mAdapters.add(this.eJn);
        this.mAdapters.add(this.eJA);
        this.mAdapters.add(this.cyf);
        this.mAdapters.add(this.eJu);
        this.mAdapters.add(this.eJv);
        this.mAdapters.add(this.eJw);
        this.mAdapters.add(this.cyg);
        this.mAdapters.add(this.eJB);
        this.mAdapters.add(this.eJC);
        this.mAdapters.add(this.eJx);
        this.mAdapters.add(this.eJy);
        this.mAdapters.add(this.eJp);
        this.mAdapters.add(this.eJq);
        this.mAdapters.add(this.eJD);
        this.mAdapters.add(this.eJr);
        this.cuG.setPriority(1);
        this.cuG.setSelfListener(true);
        pbActivity.registerListener(this.cuG);
        aiM();
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
        boolean z5;
        PostData postData2;
        boolean z6 = true;
        if (fVar != null) {
            if (this.eFL != fVar) {
                z2 = (fVar == null || fVar.aOS()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eFL = fVar;
            if (z2) {
                aRd();
                if (fVar != null) {
                    fVar.iQ(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eFL != null && this.eFL.aOZ() != null && this.eFL.aOZ().size() > 0) {
                this.postList.addAll(this.eFL.aOZ());
            }
            if (fVar != null && fVar.aOX() != null && fVar.aOX().getAuthor() != null) {
                this.mHostId = fVar.aOX().getAuthor().getUserId();
            }
            if (this.eJk != null) {
                this.eJA.b(fVar);
                this.eJA.setFromCDN(this.mIsFromCDN);
                this.eJA.setHostId(this.mHostId);
                this.eJA.pf(this.eFI);
                this.eJA.iS(this.eFJ);
                this.eJA.iT(this.eFK);
                this.eJA.setCommonClickListener(this.cUc);
                this.eJA.A(this.eFO);
                this.eJA.setOnImageClickListener(this.aRy);
                this.eJA.setOnLongClickListener(this.avB);
                this.eJk.b(fVar);
                this.eJk.setFromCDN(this.mIsFromCDN);
                this.eJk.setHostId(this.mHostId);
                this.eJk.pf(this.eFI);
                this.eJk.iS(this.eFJ);
                this.eJk.iT(this.eFK);
                this.eJk.setCommonClickListener(this.cUc);
                this.eJk.A(this.eFO);
                this.eJk.setOnImageClickListener(this.aRy);
                this.eJk.setOnLongClickListener(this.avB);
                this.eJk.setTbGestureDetector(this.aRz);
                this.eJk.po(fVar != null ? fVar.aOX().rt() : 0);
                this.eJo.b(fVar);
                this.eJo.setFromCDN(this.mIsFromCDN);
                this.eJo.setHostId(this.mHostId);
                this.eJo.iS(this.eFJ);
                this.eJo.setCommonClickListener(this.cUc);
                this.eJo.A(this.eFO);
                this.eJo.setOnImageClickListener(this.aRy);
                this.eJo.setOnLongClickListener(this.avB);
                this.eJo.setTbGestureDetector(this.aRz);
                this.eJl.setOnClickListener(this.cUc);
                this.eJl.setTbGestureDetector(this.aRz);
                if (this.eJu != null && (this.eJu instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eJu).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eJv != null && (this.eJv instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eJv).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.cyg != null && (this.cyg instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.cyg).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eJE.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.pf(this.eFI);
                        next.iS(this.eFJ);
                        next.iT(this.eFK);
                        next.iU(this.eJL);
                        next.setCommonClickListener(this.cUc);
                        next.A(this.eFO);
                        next.setOnImageClickListener(this.aRy);
                        next.setOnLongClickListener(this.avB);
                    }
                }
                this.eJm.setCommonClickListener(this.cUc);
                this.eJn.setCommonClickListener(this.cUc);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aOZ());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bso() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (postData != null) {
                    if (!this.eFK || fVar.aPu()) {
                        arrayList.remove(postData);
                        z3 = false;
                    }
                    if (!this.eFK && !fVar.aPu()) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                        z3 = true;
                    }
                }
                if (z3 || fVar.aPe() == null || fVar.aPu()) {
                    z4 = z3;
                } else {
                    PostData aPe = fVar.aPe();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aPe());
                    postData = aPe;
                    z4 = true;
                }
                cB(arrayList);
                if (this.eGQ.aQz()) {
                    if (fVar.aOZ().size() > 0 && (postData2 = fVar.aOZ().get(0)) != null && postData2.bso() == 1 && !com.baidu.tbadk.core.util.v.v(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.eFL, arrayList, this.eFK);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.eFL.aPa());
                    }
                }
                int c = c(this.eFL, arrayList, this.eFK);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.eFL.aPb());
                }
                if (arrayList.size() == 0 && this.eGQ.aQz()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.eFK);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.f> e = e(fVar, arrayList);
                    if (e != null && e.size() > 0) {
                        com.baidu.tbadk.core.util.v.a((List) arrayList, a, (List) e);
                    } else {
                        this.eJs = 0;
                    }
                } else {
                    this.eJs = 0;
                }
                com.baidu.tieba.tbadkCore.n.p(arrayList, 1);
                int c2 = c(fVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eEL);
                    if (fVar != null && fVar.aOX() != null) {
                        jVar.eEN = fVar.aOX().rt();
                    }
                    jVar.aFp = !this.eFK;
                    jVar.eEO = this.eGQ.aQM();
                    com.baidu.tbadk.core.util.v.a(arrayList, c2, jVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(fVar, arrayList);
                final List<com.baidu.adp.widget.ListView.f> e2 = e(fVar);
                if (!com.baidu.tbadk.core.util.v.v(e2) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, b2);
                    if (fVar2 instanceof PostData) {
                        ((PostData) fVar2).czO = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) e2);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d >= 0 && fVar.aPt() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aPt());
                    fVar.aPt().iR((b(arrayList, d) || z5) ? false : true);
                    z5 = true;
                }
                this.eJk.jj(!z5);
                if (this.eGQ.aQc() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.eGQ.aQc().getPostId())) {
                    z6 = false;
                }
                if (this.eJG && !z6) {
                    arrayList.remove(postData);
                    this.eJG = false;
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z6 && !z) {
                    if ((this.eJI || this.eJH) && b2 != -1 && !com.baidu.tbadk.core.util.v.v(e2) && !this.eJJ) {
                        this.eJO = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.mListView.setSelection(g.this.mListView.getHeaderViewsCount() + e2.size());
                                g.this.eJJ = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fQ().post(this.eJO);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        if (this.eGQ.aPe() == null || this.eGQ.aQb() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (this.eJH || fVar == null || fVar.aPu() || com.baidu.tbadk.core.util.v.v(fVar.aOZ()) || arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        if (this.eGQ.aQc() == null || !this.eGQ.aQc().getIsFromMark()) {
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
                if (fVar2 instanceof PostData) {
                    PostData postData = (PostData) fVar2;
                    if (postData.bso() == 1 && postData.giR == 0) {
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
            return -1;
        }
        return -1;
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aOZ()) || com.baidu.tbadk.core.util.v.v(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(fVar.aOZ(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
            if (fVar2 instanceof PostData) {
                PostData postData = (PostData) fVar2;
                if (postData.bso() == 1 && postData.giR == 0) {
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

    private int d(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aOZ()) || arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return -1;
            }
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
            if (!(fVar2 instanceof PostData) || ((PostData) fVar2).bso() != 1) {
                i = i2 + 1;
            } else {
                return i2 + 1;
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.f> e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPh() == null || com.baidu.tbadk.core.util.v.v(fVar.aPh().eFe)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aPh().eFe;
        if (com.baidu.tbadk.core.util.v.v(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.giT = true;
                arrayList.add(postData);
            }
        }
        int u = com.baidu.tbadk.core.util.v.u(fVar.aPh().eFf);
        if (fVar.aPh().getCount() != u && u > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).giT = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).giT = true;
            }
        }
        arrayList.add(0, new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eEM));
        return arrayList;
    }

    public void aQX() {
        this.eJs = 0;
    }

    public int aQY() {
        return this.eJt;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.v.v(fVar.aOZ()) || com.baidu.tbadk.core.util.v.v(fVar.aOY())) {
            return -1;
        }
        if (z) {
            return (fVar.aOZ().get(0) == null || fVar.aOZ().get(0).bso() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.f> e(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (fVar == null || arrayList == null || fVar.aOY() == null || fVar.aOY().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<bj> aOY = fVar.aOY();
        int size = aOY.size();
        this.eJt = 0;
        if (this.eJs + 5 >= size) {
            int i2 = 0;
            for (bj bjVar : aOY) {
                if (bjVar != null) {
                    com.baidu.tieba.pb.video.k kVar = new com.baidu.tieba.pb.video.k();
                    int i3 = i2 + 1;
                    if (i3 == 1) {
                        kVar.a(bjVar, true, true, true, i3);
                    } else {
                        kVar.a(bjVar, true, true, false, i3);
                    }
                    arrayList2.add(kVar);
                    this.eJs++;
                    i = i3;
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (this.eJs <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.eJt = arrayList2.size();
            }
            return arrayList2;
        }
        int i4 = this.eJs + 5;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            bj bjVar2 = aOY.get(i6);
            if (bjVar2 != null) {
                com.baidu.tieba.pb.video.k kVar2 = new com.baidu.tieba.pb.video.k();
                i5++;
                boolean z = i5 == 1;
                if (i6 == i4 - 1) {
                    kVar2.a(bjVar2, false, true, z, i5);
                } else {
                    kVar2.a(bjVar2, true, true, z, i5);
                }
                arrayList2.add(kVar2);
                this.eJs++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.m());
        this.eJt = arrayList2.size();
        return arrayList2;
    }

    private void aiM() {
        if (this.eGQ != null && !aiN()) {
            this.eGQ.registerListener(this.cuH);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aiN() {
        if (this.eGQ == null) {
            return false;
        }
        this.cuz = new ArrayList();
        ArrayList<BdUniqueId> bry = com.baidu.tieba.tbadkCore.n.bry();
        if (bry == null || bry.size() <= 0) {
            return false;
        }
        int size = bry.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aFX().a(this.eGQ.getPageContext(), bry.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cuz.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.v(this.cuz)) {
            this.mListView.addAdapters(this.cuz);
        }
        return true;
    }

    public int aQZ() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aOZ() == null || fVar.aPa() == null || fVar.aOZ().size() == 0 || fVar.aOX() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPa().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aOZ().get(0) == null || fVar.aOZ().get(0).bso() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qD() == null || fVar.qD().qx() != fVar.qD().qu()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aOZ() == null || fVar.aPb() == null || fVar.aOZ().size() == 0 || fVar.aOX() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPb().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aOZ().get(0) == null || fVar.aOZ().get(0).bso() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qD() == null || fVar.qD().qx() != fVar.qD().qu()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aRa() {
        return this.postList;
    }

    public BdUniqueId pl(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.eJz == null || !this.eJz.aPQ()) {
            this.eJP = aRb();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private int aRb() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.mListView.getData().get(i2);
                if (fVar == null || fVar.getType() != com.baidu.tieba.pb.data.j.eEL) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aRc() {
        return this.eJP;
    }

    private void aRd() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eFL != null) {
            ArrayList<PostData> aOZ = this.eFL.aOZ();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aPl = this.eFL.aPl();
            if (aPl != null) {
                int size = aPl.size();
                if (aOZ != null && aOZ.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aPl.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.bsf() != null) {
                            sb.append(next.bsf());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aPl.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.czc = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aPl.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bsd() != null) {
                            int ps = next3.bsd().ps();
                            if (ps != 0) {
                                a(next3, ps);
                                if (ps != 28 && ps != 31) {
                                    if (next3.bsd().goods != null) {
                                        next3.bsd().goods.goods_style = TbErrInfo.ERR_IMG_GET_REMOTE;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bsd().apk_name)) {
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
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.bsf(), lVar3)) != null) {
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
                        if (this.eFL.aOV() != null) {
                            lVar4.forumId = this.eFL.aOV().getId();
                        }
                        if (this.eFL.aOX() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.eFL.aOX().getId(), 0L);
                        }
                        if (this.eFL != null && this.eFL.qD() != null) {
                            lVar4.pageNumber = this.eFL.qD().qx();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (a(lVar4, aOZ)) {
                            aOZ.add(lVar4);
                        } else if (position2 + i3 >= aOZ.size()) {
                            a(lVar4, 2);
                            return;
                        } else {
                            aOZ.add(position2, lVar4);
                            TiebaStatic.eventStat(this.eGQ.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bsd().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sc(i);
        com.baidu.tieba.recapp.report.b.bhN().a(c);
        if (lVar != null && lVar.bsd() != null) {
            lVar.bsd().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bsd() != null && lVar.bsd().goods != null && lVar.bsd().goods.goods_style != 1001 && lVar.bsd().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aOV;
        if (lVar != null && this.eFL != null && lVar.bsd() != null) {
            lVar.bsd().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eFL.qD() != null) {
                lVar.bsd().advertAppContext.pn = this.eFL.qD().qx();
            }
            lVar.bsd().advertAppContext.Tr = "PB";
            if (this.eFL.aOV() != null && (aOV = this.eFL.aOV()) != null) {
                lVar.bsd().advertAppContext.fid = aOV.getId();
                lVar.bsd().advertAppContext.Tt = aOV.getFirst_class();
                lVar.bsd().advertAppContext.Tu = aOV.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bsd().advertAppContext.Tv = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bsd().advertAppContext.extensionInfo = lVar.bsd().ext_info;
            lVar.bsd().advertAppContext.Tw = false;
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.l lVar, ArrayList<PostData> arrayList) {
        int u = com.baidu.tbadk.core.util.v.u(arrayList);
        if (lVar == null || u <= 0) {
            return false;
        }
        int position = lVar.getPosition();
        if (u >= 2 || position != u + 1) {
            return false;
        }
        if (this.eFL != null && this.eFL.qD() != null) {
            lVar.pageNumber = this.eFL.qD().qx();
        }
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eJA.setFromCDN(z);
        this.eJk.setFromCDN(z);
        if (this.eJu != null && (this.eJu instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eJu).setIsFromCDN(z);
        }
        if (this.eJv != null && (this.eJv instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eJv).setIsFromCDN(z);
        }
        if (this.cyg != null && (this.cyg instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cyg).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eJE.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void iS(boolean z) {
        this.eFJ = z;
    }

    public void iT(boolean z) {
        this.eFK = z;
    }

    public void iU(boolean z) {
        this.eJL = z;
    }

    public void A(View.OnClickListener onClickListener) {
        this.eFO = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRy = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRz = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avB = onLongClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.cUc = onClickListener;
    }

    public void pm(int i) {
        if (this.eJl != null) {
            this.eJl.pm(i);
        }
        switch (i) {
            case 1:
                if (this.eJz != null) {
                    this.eJz.pause();
                }
                if (this.eJk != null) {
                    this.eJk.pause();
                }
                if (this.eJw != null && (this.eJw instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eJw).release();
                    return;
                }
                return;
            case 2:
                if (this.eJz != null) {
                    this.eJz.resume();
                }
                if (this.eJk != null) {
                    this.eJk.resume();
                }
                if (this.eJw != null && (this.eJw instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eJw).resume();
                    return;
                }
                return;
            case 3:
                if (this.eJz != null) {
                    this.eJz.release();
                }
                if (this.eJk != null) {
                    this.eJk.release();
                }
                if (this.eJw != null && (this.eJw instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eJw).release();
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
                    if (!TextUtils.isEmpty(postData.sw())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.cx(postData.sw());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.eJO);
        if (this.eJm != null) {
            this.eJm.onDestory();
        }
    }

    public void je(boolean z) {
        this.eJK = z;
    }

    public void jf(boolean z) {
        this.eJH = z;
    }

    public void jg(boolean z) {
        this.eJI = z;
    }

    public void jh(boolean z) {
        this.eJG = z;
    }

    public void ji(boolean z) {
        this.eJJ = z;
    }

    public aj aRe() {
        return this.eJl;
    }
}
