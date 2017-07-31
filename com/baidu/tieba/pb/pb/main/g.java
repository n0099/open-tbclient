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
    private List<com.baidu.adp.widget.ListView.a> cnl;
    private com.baidu.adp.widget.ListView.a cqT;
    private com.baidu.adp.widget.ListView.a cqU;
    private int eFt;
    private com.baidu.tieba.pb.data.f eFw;
    private PbActivity eGA;
    private boolean eJA;
    private boolean eJB;
    private Runnable eJG;
    private com.baidu.tieba.pb.pb.a.f eJd;
    private o eJe;
    private am eJf;
    private aj eJg;
    private j eJh;
    private com.baidu.tieba.pb.video.j eJi;
    private com.baidu.tieba.pb.video.l eJj;
    private com.baidu.tieba.pb.video.a eJk;
    private int eJl;
    private com.baidu.adp.widget.ListView.a eJn;
    private com.baidu.adp.widget.ListView.a eJo;
    private com.baidu.adp.widget.ListView.a eJp;
    private ac eJq;
    private ag eJr;
    private com.baidu.tieba.pb.pb.a.b eJs;
    private com.baidu.tieba.pb.pb.a.g eJt;
    private r eJu;
    private aa eJv;
    private com.baidu.tieba.pb.pb.a.c eJw;
    private BdTypeListView mListView;
    private int width;
    private int eJm = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eJx = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eFu = true;
    private boolean eJy = true;
    private boolean eFv = true;
    private boolean eJz = false;
    private boolean eJC = false;
    private boolean eJD = false;
    private String mHostId = null;
    private View.OnClickListener eFz = null;
    private View.OnClickListener cLO = null;
    private TbRichTextView.e aRM = null;
    private com.baidu.tieba.pb.a.c aRN = null;
    private View.OnLongClickListener awn = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eJE = new ArrayList();
    private boolean eJF = false;
    private CustomMessageListener cns = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList brY = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).brY();
                Iterator it = brY.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).aq(g.this.eGA);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.eJx.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            g.this.eJs = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(brY);
                g.this.eJE.clear();
                g.this.eJE.addAll(arrayList);
                if (g.this.mListView != null) {
                    g.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cjY = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.eFw != null && !com.baidu.adp.base.i.Y(g.this.eGA.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener cnu = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.u.v(g.this.cnl)) {
                g.this.agM();
                g.this.a(g.this.eFw, false);
            }
        }
    };

    public g(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eFt = 0;
        this.width = -1;
        this.eFt = com.baidu.adp.lib.util.k.ag(pbActivity.getPageContext().getPageActivity());
        this.width = this.eFt;
        this.eGA = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cjY);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eJt = new com.baidu.tieba.pb.pb.a.g(pbActivity, PostData.ghQ);
        this.eJe = new o(pbActivity, PostData.ghN);
        this.eJe.a(pbActivity);
        this.eJd = new com.baidu.tieba.pb.pb.a.f(pbActivity, com.baidu.tieba.pb.data.j.TYPE);
        this.eJf = new am(pbActivity, com.baidu.tieba.pb.data.m.eEC);
        this.eJg = new aj(pbActivity, com.baidu.tieba.pb.data.k.eEy);
        this.eJh = new j(pbActivity, PostData.ghO);
        this.eJh.a(pbActivity);
        this.cqT = com.baidu.tieba.recapp.r.bhF().a(pbActivity, AdvertAppInfo.Ux);
        this.eJn = com.baidu.tieba.recapp.r.bhF().a(pbActivity, AdvertAppInfo.Uy);
        this.eJo = com.baidu.tieba.recapp.r.bhF().a(pbActivity, AdvertAppInfo.Uz);
        this.eJp = com.baidu.tieba.recapp.r.bhF().a(pbActivity, AdvertAppInfo.UB);
        this.cqU = com.baidu.tieba.recapp.r.bhF().a(pbActivity, AdvertAppInfo.UF);
        this.eJu = new r(pbActivity, com.baidu.tieba.pb.data.a.eDx);
        this.eJv = new aa(pbActivity, com.baidu.tieba.pb.data.i.eEu);
        this.eJq = new ac(pbActivity, z.eMI);
        this.eJr = new ag(pbActivity, com.baidu.tbadk.core.data.au.Yg);
        this.eJi = new com.baidu.tieba.pb.video.j(pbActivity, com.baidu.tieba.pb.video.k.eYk);
        this.eJj = new com.baidu.tieba.pb.video.l(pbActivity, com.baidu.tieba.pb.video.m.eYt);
        this.eJj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.a(g.this.eFw, false);
                g.this.notifyDataSetChanged();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11926"));
            }
        });
        this.eJk = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.eWW);
        this.eJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eFw.aPt() != null) {
                    List<Long> list = g.this.eFw.aPt().eEP;
                    int count = g.this.eFw.aPt().getCount();
                    if (list.size() != count) {
                        if (list.size() >= count + 5) {
                            g.this.eFw.aPt().setCount(count + 5);
                            g.this.eGA.aQn().aRY().cC(list.subList(count, count + 5));
                        } else if (list.size() < count + 5) {
                            g.this.eGA.aQn().aRY().cC(list.subList(count, list.size()));
                            g.this.eFw.aPt().setCount(list.size());
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12040"));
                    }
                }
            }
        });
        this.eJw = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.VW);
        if (this.eFw != null && this.eFw.aPj() != null) {
            this.eJw.aot = this.eFw.aPj().aaU;
        }
        this.mAdapters.add(this.eJe);
        this.mAdapters.add(this.eJf);
        this.mAdapters.add(this.eJh);
        this.mAdapters.add(this.eJg);
        this.mAdapters.add(this.eJt);
        this.mAdapters.add(this.cqT);
        this.mAdapters.add(this.eJn);
        this.mAdapters.add(this.eJo);
        this.mAdapters.add(this.eJp);
        this.mAdapters.add(this.cqU);
        this.mAdapters.add(this.eJu);
        this.mAdapters.add(this.eJv);
        this.mAdapters.add(this.eJq);
        this.mAdapters.add(this.eJr);
        this.mAdapters.add(this.eJi);
        this.mAdapters.add(this.eJj);
        this.mAdapters.add(this.eJw);
        this.mAdapters.add(this.eJk);
        this.mAdapters.add(this.eJd);
        this.cns.setPriority(1);
        this.cns.setSelfListener(true);
        pbActivity.registerListener(this.cns);
        agL();
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
            if (this.eFw != fVar) {
                z2 = (fVar == null || fVar.aPe()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eFw = fVar;
            if (z2) {
                aRk();
                if (fVar != null) {
                    fVar.iN(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eFw != null && this.eFw.aPl() != null && this.eFw.aPl().size() > 0) {
                this.postList.addAll(this.eFw.aPl());
            }
            if (fVar != null && fVar.aPj() != null && fVar.aPj().getAuthor() != null) {
                this.mHostId = fVar.aPj().getAuthor().getUserId();
            }
            if (this.eJe != null) {
                this.eJt.b(fVar);
                this.eJt.setFromCDN(this.mIsFromCDN);
                this.eJt.setHostId(this.mHostId);
                this.eJt.oO(this.eFt);
                this.eJt.iP(this.eFu);
                this.eJt.iQ(this.eFv);
                this.eJt.setCommonClickListener(this.cLO);
                this.eJt.G(this.eFz);
                this.eJt.setOnImageClickListener(this.aRM);
                this.eJt.setOnLongClickListener(this.awn);
                this.eJe.b(fVar);
                this.eJe.setFromCDN(this.mIsFromCDN);
                this.eJe.setHostId(this.mHostId);
                this.eJe.oO(this.eFt);
                this.eJe.iP(this.eFu);
                this.eJe.iQ(this.eFv);
                this.eJe.setCommonClickListener(this.cLO);
                this.eJe.G(this.eFz);
                this.eJe.setOnImageClickListener(this.aRM);
                this.eJe.setOnLongClickListener(this.awn);
                this.eJe.setTbGestureDetector(this.aRN);
                this.eJe.oX(fVar != null ? fVar.aPj().rx() : 0);
                this.eJh.b(fVar);
                this.eJh.setFromCDN(this.mIsFromCDN);
                this.eJh.setHostId(this.mHostId);
                this.eJh.iP(this.eFu);
                this.eJh.setCommonClickListener(this.cLO);
                this.eJh.G(this.eFz);
                this.eJh.setOnImageClickListener(this.aRM);
                this.eJh.setOnLongClickListener(this.awn);
                this.eJh.setTbGestureDetector(this.aRN);
                this.eJf.setOnClickListener(this.cLO);
                this.eJf.setTbGestureDetector(this.aRN);
                if (this.eJn != null && (this.eJn instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eJn).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eJo != null && (this.eJo instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eJo).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.cqU != null && (this.cqU instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.cqU).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eJx.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.oO(this.eFt);
                        next.iP(this.eFu);
                        next.iQ(this.eFv);
                        next.iR(this.eJD);
                        next.setCommonClickListener(this.cLO);
                        next.G(this.eFz);
                        next.setOnImageClickListener(this.aRM);
                        next.setOnLongClickListener(this.awn);
                    }
                }
                this.eJg.setCommonClickListener(this.cLO);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aPl());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bsy() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                cB(arrayList);
                if (this.eGA.aQJ()) {
                    if (fVar.aPl().size() > 0 && (postData3 = fVar.aPl().get(0)) != null && postData3.bsy() == 1 && !com.baidu.tbadk.core.util.u.v(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.eFw, arrayList, this.eFv);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.u.a(arrayList, b, this.eFw.aPm());
                    }
                }
                int c = c(this.eFw, arrayList, this.eFv);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.u.a(arrayList, c, this.eFw.aPn());
                }
                if (arrayList.size() == 0 && this.eGA.aQJ()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.eFv);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.f> c2 = c(fVar, arrayList);
                    if (c2 != null && c2.size() > 0) {
                        com.baidu.tbadk.core.util.u.a((List) arrayList, a, (List) c2);
                    } else {
                        this.eJl = 0;
                    }
                } else {
                    this.eJl = 0;
                }
                com.baidu.tieba.tbadkCore.n.q(arrayList, 1);
                int u = com.baidu.tbadk.core.util.u.u(arrayList);
                int i = 0;
                while (i < u) {
                    com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, i);
                    if (fVar2 instanceof PostData) {
                        ((PostData) fVar2).csE = i == 0;
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
                        ((PostData) fVar3).csE = true;
                    }
                    com.baidu.tbadk.core.util.u.a((List) arrayList, a2, (List) d);
                    z4 = true;
                }
                int b2 = z3 ? b(fVar, arrayList) : -1;
                if (b2 >= 0 && fVar.aPG() != null) {
                    com.baidu.tbadk.core.util.u.a(arrayList, b2, fVar.aPG());
                    fVar.aPG().iO((b(arrayList, b2) || z4) ? false : true);
                    z4 = true;
                }
                this.eJe.jf(!z4);
                if (!this.eFv && fVar != null && fVar.aPl() != null && (size = fVar.aPl().size()) > 0 && (postData2 = fVar.aPl().get(size - 1)) != null && postData2.bsy() == 1 && (size2 = arrayList.size()) > 0) {
                    arrayList.remove(size2 - 1);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (this.eGA.aQn() != null && postData != null && postData.getId() != null && postData.getId().equals(this.eGA.aQn().getPostId())) {
                    z5 = true;
                }
                if (!z5 && !z) {
                    if ((this.eJA || this.eJz) && a2 != -1 && !com.baidu.tbadk.core.util.u.v(d) && !this.eJB) {
                        this.eJG = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.mListView.setSelection(g.this.mListView.getHeaderViewsCount() + d.size());
                                g.this.eJB = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.ga().post(this.eJG);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        MetaData author;
        GodUserData godUserData;
        if (this.eGA.aPq() == null || this.eGA.aQm() == null) {
            return false;
        }
        if (this.eGA.aQm().aTM() || (author = this.eGA.aPq().getAuthor()) == null || (godUserData = author.getGodUserData()) == null || !godUserData.isBigV() || godUserData.getIsLike()) {
            return false;
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
        jVar.eEv = author;
        com.baidu.tbadk.core.util.u.a(arrayList, i + 1, jVar);
        jVar.eEw = true;
        if (!UtilHelper.isCurrentAccount(author.getUserId())) {
            jVar.eEx = true;
            return true;
        }
        jVar.eEx = false;
        return true;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        PostData postData;
        int i;
        int i2 = 0;
        if (fVar == null || com.baidu.tbadk.core.util.u.v(fVar.aPl()) || arrayList == null || arrayList.size() <= 0 || this.eGA.aQW() || this.eJC) {
            return -1;
        }
        if ((this.eGA.aQn() == null || !this.eGA.aQn().getIsFromMark()) && (postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPl(), 0)) != null) {
            int bsy = postData.bsy();
            int size = arrayList.size();
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
                if (fVar2 != null && (fVar2 instanceof PostData)) {
                    PostData postData2 = (PostData) fVar2;
                    if (postData2.bsy() == bsy && postData2.giy == 0) {
                        i = bsy == 1 ? i2 + 1 : i2;
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
        if (!this.eFv) {
            return -1;
        }
        if (fVar == null || com.baidu.tbadk.core.util.u.v(fVar.aPl()) || arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return -1;
            }
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
            if (!(fVar2 instanceof PostData) || ((PostData) fVar2).bsy() != 1) {
                i = i2 + 1;
            } else {
                return i2 + 1;
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.f> d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPt() == null || com.baidu.tbadk.core.util.u.v(fVar.aPt().eEO) || this.eGA.aQW() || this.eJC) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aPt().eEO;
        if (com.baidu.tbadk.core.util.u.v(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.giA = true;
                arrayList.add(postData);
            }
        }
        int u = com.baidu.tbadk.core.util.u.u(fVar.aPt().eEP);
        if (fVar.aPt().getCount() != u && u > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).giA = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).giA = true;
            }
        }
        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
        kVar.mType = 0;
        arrayList.add(0, kVar);
        return arrayList;
    }

    public void aRg() {
        this.eJl = 0;
    }

    public int aRh() {
        return this.eJm;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.u.v(fVar.aPl()) || com.baidu.tbadk.core.util.u.v(fVar.aPk())) {
            return -1;
        }
        if (z) {
            return (fVar.aPl().get(0) == null || fVar.aPl().get(0).bsy() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.f> c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (fVar == null || arrayList == null || fVar.aPk() == null || fVar.aPk().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<bl> aPk = fVar.aPk();
        int size = aPk.size();
        this.eJm = 0;
        if (this.eJl + 5 >= size) {
            int i2 = 0;
            for (bl blVar : aPk) {
                if (blVar != null) {
                    com.baidu.tieba.pb.video.k kVar = new com.baidu.tieba.pb.video.k();
                    int i3 = i2 + 1;
                    if (i3 == 1) {
                        kVar.a(blVar, true, true, true, i3);
                    } else {
                        kVar.a(blVar, true, true, false, i3);
                    }
                    arrayList2.add(kVar);
                    this.eJl++;
                    i = i3;
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (this.eJl <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.eJm = arrayList2.size();
            }
            return arrayList2;
        }
        int i4 = this.eJl + 5;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            bl blVar2 = aPk.get(i6);
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
                this.eJl++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.m());
        this.eJm = arrayList2.size();
        return arrayList2;
    }

    private void agL() {
        if (this.eGA != null && !agM()) {
            this.eGA.registerListener(this.cnu);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean agM() {
        if (this.eGA == null) {
            return false;
        }
        this.cnl = new ArrayList();
        ArrayList<BdUniqueId> brI = com.baidu.tieba.tbadkCore.n.brI();
        if (brI == null || brI.size() <= 0) {
            return false;
        }
        int size = brI.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aDI().a(this.eGA.getPageContext(), brI.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cnl.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.u.v(this.cnl)) {
            this.mListView.addAdapters(this.cnl);
        }
        return true;
    }

    public int aRi() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPl() == null || fVar.aPm() == null || fVar.aPl().size() == 0 || fVar.aPj() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPm().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPl().get(0) == null || fVar.aPl().get(0).bsy() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qH() == null || fVar.qH().qB() != fVar.qH().qy()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPl() == null || fVar.aPn() == null || fVar.aPl().size() == 0 || fVar.aPj() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPn().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPl().get(0) == null || fVar.aPl().get(0).bsy() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qH() == null || fVar.qH().qB() != fVar.qH().qy()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aRj() {
        return this.postList;
    }

    public BdUniqueId oU(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.eJs == null || !this.eJs.aQb()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aRk() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eFw != null) {
            ArrayList<PostData> aPl = this.eFw.aPl();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aPx = this.eFw.aPx();
            if (aPx != null) {
                int size = aPx.size();
                if (aPl != null && aPl.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aPx.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.bsp() != null) {
                            sb.append(next.bsp());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aPx.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.crS = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aPx.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bsn() != null) {
                            int px = next3.bsn().px();
                            if (px != 0) {
                                a(next3, px);
                                if (px != 28 && px != 31) {
                                    if (next3.bsn().goods != null) {
                                        next3.bsn().goods.goods_style = TbErrInfo.ERR_IMG_GET_REMOTE;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bsn().apk_name)) {
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
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.bsp(), lVar3)) != null) {
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
                        if (this.eFw.aPh() != null) {
                            lVar4.forumId = this.eFw.aPh().getId();
                        }
                        if (this.eFw.aPj() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.d(this.eFw.aPj().getId(), 0L);
                        }
                        if (this.eFw != null && this.eFw.qH() != null) {
                            lVar4.pageNumber = this.eFw.qH().qB();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (a(lVar4, aPl)) {
                            aPl.add(lVar4);
                        } else if (position2 + i3 >= aPl.size()) {
                            a(lVar4, 2);
                            return;
                        } else {
                            aPl.add(position2, lVar4);
                            TiebaStatic.eventStat(this.eGA.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bsn().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 5);
        c.rV(i);
        com.baidu.tieba.recapp.report.b.bin().a(c);
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bsn() != null && lVar.bsn().goods != null && lVar.bsn().goods.goods_style != 1001 && lVar.bsn().goods.goods_style != -1001) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 5);
            c.rV(i);
            com.baidu.tieba.recapp.report.b.bin().a(c);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aPh;
        if (lVar != null && this.eFw != null && lVar.bsn() != null) {
            lVar.bsn().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eFw.qH() != null) {
                lVar.bsn().advertAppContext.pn = this.eFw.qH().qB();
            }
            lVar.bsn().advertAppContext.Um = "PB";
            if (this.eFw.aPh() != null && (aPh = this.eFw.aPh()) != null) {
                lVar.bsn().advertAppContext.fid = aPh.getId();
                lVar.bsn().advertAppContext.Uo = aPh.getFirst_class();
                lVar.bsn().advertAppContext.Up = aPh.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bsn().advertAppContext.Uq = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bsn().advertAppContext.extensionInfo = lVar.bsn().ext_info;
            lVar.bsn().advertAppContext.Ur = false;
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
        if (this.eFw != null && this.eFw.qH() != null) {
            lVar.pageNumber = this.eFw.qH().qB();
        }
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eJt.setFromCDN(z);
        this.eJe.setFromCDN(z);
        if (this.eJn != null && (this.eJn instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eJn).setIsFromCDN(z);
        }
        if (this.eJo != null && (this.eJo instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eJo).setIsFromCDN(z);
        }
        if (this.cqU != null && (this.cqU instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cqU).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eJx.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void iP(boolean z) {
        this.eFu = z;
    }

    public void iQ(boolean z) {
        this.eFv = z;
    }

    public void iR(boolean z) {
        this.eJD = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eFz = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRM = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRN = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awn = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.cLO = onClickListener;
    }

    public void oV(int i) {
        if (this.eJf != null) {
            this.eJf.oV(i);
        }
        switch (i) {
            case 1:
                if (this.eJs != null) {
                    this.eJs.pause();
                }
                if (this.eJe != null) {
                    this.eJe.pause();
                }
                if (this.eJp != null && (this.eJp instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eJp).release();
                    return;
                }
                return;
            case 2:
                if (this.eJs != null) {
                    this.eJs.resume();
                }
                if (this.eJe != null) {
                    this.eJe.resume();
                }
                if (this.eJp != null && (this.eJp instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eJp).resume();
                    return;
                }
                return;
            case 3:
                if (this.eJs != null) {
                    this.eJs.release();
                }
                if (this.eJe != null) {
                    this.eJe.release();
                }
                if (this.eJp != null && (this.eJp instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eJp).release();
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
                    if (!TextUtils.isEmpty(postData.sA())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.cE(postData.sA());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.eJG);
    }

    public void jb(boolean z) {
        this.eJC = z;
    }

    public void jc(boolean z) {
        this.eJz = z;
    }

    public void jd(boolean z) {
        this.eJA = z;
    }

    public void je(boolean z) {
        this.eJB = z;
    }

    public am aRl() {
        return this.eJf;
    }
}
