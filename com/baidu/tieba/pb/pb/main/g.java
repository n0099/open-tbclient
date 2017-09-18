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
    private List<com.baidu.adp.widget.ListView.a> cvr;
    private com.baidu.adp.widget.ListView.a cyX;
    private com.baidu.adp.widget.ListView.a cyY;
    private int eGC;
    private com.baidu.tieba.pb.data.f eGF;
    private PbActivity eHK;
    private boolean eKC;
    private boolean eKD;
    private Runnable eKI;
    private o eKe;
    private aj eKf;
    private ag eKg;
    private ag eKh;
    private j eKi;
    private com.baidu.tieba.pb.video.j eKj;
    private com.baidu.tieba.pb.video.l eKk;
    private com.baidu.tieba.pb.video.a eKl;
    private int eKm;
    private com.baidu.adp.widget.ListView.a eKo;
    private com.baidu.adp.widget.ListView.a eKp;
    private com.baidu.adp.widget.ListView.a eKq;
    private ac eKr;
    private ad eKs;
    private com.baidu.tieba.pb.pb.a.b eKt;
    private com.baidu.tieba.pb.pb.a.f eKu;
    private r eKv;
    private aa eKw;
    private com.baidu.tieba.pb.pb.a.c eKx;
    private BdTypeListView mListView;
    private int width;
    private int eKn = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eKy = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eGD = true;
    private boolean eKz = true;
    private boolean eGE = true;
    private boolean eKA = false;
    private boolean eKB = false;
    private boolean eKE = false;
    private boolean eKF = false;
    private String mHostId = null;
    private View.OnClickListener eGI = null;
    private View.OnClickListener cUW = null;
    private TbRichTextView.e aRv = null;
    private com.baidu.tieba.pb.a.c aRw = null;
    private View.OnLongClickListener avy = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eKG = new ArrayList();
    private boolean eKH = false;
    private int eKJ = -1;
    private CustomMessageListener cvy = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList brZ = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).brZ();
                Iterator it = brZ.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).al(g.this.eHK);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.eKy.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            g.this.eKt = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(brZ);
                g.this.eKG.clear();
                g.this.eKG.addAll(arrayList);
                if (g.this.mListView != null) {
                    g.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cqX = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.eGF != null && !com.baidu.adp.base.i.W(g.this.eHK.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener cvz = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.v(g.this.cvr)) {
                g.this.aiY();
                g.this.a(g.this.eGF, false);
            }
        }
    };

    public g(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eGC = 0;
        this.width = -1;
        this.eGC = com.baidu.adp.lib.util.k.ae(pbActivity.getPageContext().getPageActivity());
        this.width = this.eGC;
        this.eHK = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cqX);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eKu = new com.baidu.tieba.pb.pb.a.f(pbActivity, PostData.gjf);
        this.eKe = new o(pbActivity, PostData.gjc);
        this.eKe.a(pbActivity);
        this.eKf = new aj(pbActivity, com.baidu.tieba.pb.data.l.eFL);
        this.eKg = new ag(pbActivity, com.baidu.tieba.pb.data.j.eFF);
        this.eKh = new ag(pbActivity, com.baidu.tieba.pb.data.j.eFG);
        this.eKi = new j(pbActivity, PostData.gjd);
        this.eKi.a(pbActivity);
        this.cyX = com.baidu.tieba.recapp.r.bho().a(pbActivity, AdvertAppInfo.TC);
        this.eKo = com.baidu.tieba.recapp.r.bho().a(pbActivity, AdvertAppInfo.TD);
        this.eKp = com.baidu.tieba.recapp.r.bho().a(pbActivity, AdvertAppInfo.TE);
        this.eKq = com.baidu.tieba.recapp.r.bho().a(pbActivity, AdvertAppInfo.TF);
        this.cyY = com.baidu.tieba.recapp.r.bho().a(pbActivity, AdvertAppInfo.TJ);
        this.eKv = new r(pbActivity, com.baidu.tieba.pb.data.a.eEH);
        this.eKw = new aa(pbActivity, com.baidu.tieba.pb.data.i.eFE);
        this.eKr = new ac(pbActivity, z.eNS);
        this.eKs = new ad(pbActivity, au.Xr);
        this.eKj = new com.baidu.tieba.pb.video.j(pbActivity, com.baidu.tieba.pb.video.k.eZI);
        this.eKk = new com.baidu.tieba.pb.video.l(pbActivity, com.baidu.tieba.pb.video.m.eZQ);
        this.eKk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.a(g.this.eGF, false);
                g.this.notifyDataSetChanged();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11926"));
            }
        });
        this.eKl = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.eYv);
        this.eKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eGF.aPs() != null) {
                    List<Long> list = g.this.eGF.aPs().eFZ;
                    int count = g.this.eGF.aPs().getCount();
                    if (list.size() != count) {
                        if (list.size() >= count + 5) {
                            g.this.eGF.aPs().setCount(count + 5);
                            g.this.eHK.aQn().aSd().cD(list.subList(count, count + 5));
                        } else if (list.size() < count + 5) {
                            g.this.eHK.aQn().aSd().cD(list.subList(count, list.size()));
                            g.this.eGF.aPs().setCount(list.size());
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                    }
                }
            }
        });
        this.eKx = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Vc);
        if (this.eGF != null && this.eGF.aPi() != null) {
            this.eKx.anN = this.eGF.aPi().aac;
        }
        this.mAdapters.add(this.eKe);
        this.mAdapters.add(this.eKf);
        this.mAdapters.add(this.eKi);
        this.mAdapters.add(this.eKg);
        this.mAdapters.add(this.eKh);
        this.mAdapters.add(this.eKu);
        this.mAdapters.add(this.cyX);
        this.mAdapters.add(this.eKo);
        this.mAdapters.add(this.eKp);
        this.mAdapters.add(this.eKq);
        this.mAdapters.add(this.cyY);
        this.mAdapters.add(this.eKv);
        this.mAdapters.add(this.eKw);
        this.mAdapters.add(this.eKr);
        this.mAdapters.add(this.eKs);
        this.mAdapters.add(this.eKj);
        this.mAdapters.add(this.eKk);
        this.mAdapters.add(this.eKx);
        this.mAdapters.add(this.eKl);
        this.cvy.setPriority(1);
        this.cvy.setSelfListener(true);
        pbActivity.registerListener(this.cvy);
        aiX();
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
        PostData postData2;
        boolean z5;
        PostData postData3;
        boolean z6 = true;
        if (fVar != null) {
            if (this.eGF != fVar) {
                z2 = (fVar == null || fVar.aPd()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eGF = fVar;
            if (z2) {
                aRo();
                if (fVar != null) {
                    fVar.iR(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eGF != null && this.eGF.aPk() != null && this.eGF.aPk().size() > 0) {
                this.postList.addAll(this.eGF.aPk());
            }
            if (fVar != null && fVar.aPi() != null && fVar.aPi().getAuthor() != null) {
                this.mHostId = fVar.aPi().getAuthor().getUserId();
            }
            if (this.eKe != null) {
                this.eKu.b(fVar);
                this.eKu.setFromCDN(this.mIsFromCDN);
                this.eKu.setHostId(this.mHostId);
                this.eKu.ph(this.eGC);
                this.eKu.iT(this.eGD);
                this.eKu.iU(this.eGE);
                this.eKu.setCommonClickListener(this.cUW);
                this.eKu.A(this.eGI);
                this.eKu.setOnImageClickListener(this.aRv);
                this.eKu.setOnLongClickListener(this.avy);
                this.eKe.b(fVar);
                this.eKe.setFromCDN(this.mIsFromCDN);
                this.eKe.setHostId(this.mHostId);
                this.eKe.ph(this.eGC);
                this.eKe.iT(this.eGD);
                this.eKe.iU(this.eGE);
                this.eKe.setCommonClickListener(this.cUW);
                this.eKe.A(this.eGI);
                this.eKe.setOnImageClickListener(this.aRv);
                this.eKe.setOnLongClickListener(this.avy);
                this.eKe.setTbGestureDetector(this.aRw);
                this.eKe.pq(fVar != null ? fVar.aPi().rt() : 0);
                this.eKi.b(fVar);
                this.eKi.setFromCDN(this.mIsFromCDN);
                this.eKi.setHostId(this.mHostId);
                this.eKi.iT(this.eGD);
                this.eKi.setCommonClickListener(this.cUW);
                this.eKi.A(this.eGI);
                this.eKi.setOnImageClickListener(this.aRv);
                this.eKi.setOnLongClickListener(this.avy);
                this.eKi.setTbGestureDetector(this.aRw);
                this.eKf.setOnClickListener(this.cUW);
                this.eKf.setTbGestureDetector(this.aRw);
                if (this.eKo != null && (this.eKo instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eKo).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eKp != null && (this.eKp instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eKp).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.cyY != null && (this.cyY instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.cyY).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eKy.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.ph(this.eGC);
                        next.iT(this.eGD);
                        next.iU(this.eGE);
                        next.iV(this.eKF);
                        next.setCommonClickListener(this.cUW);
                        next.A(this.eGI);
                        next.setOnImageClickListener(this.aRv);
                        next.setOnLongClickListener(this.avy);
                    }
                }
                this.eKg.setCommonClickListener(this.cUW);
                this.eKh.setCommonClickListener(this.cUW);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aPk());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bsz() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.eGE && postData != null) {
                    arrayList.remove(postData);
                    if (fVar.aPF()) {
                        z3 = false;
                    } else {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                        z3 = true;
                    }
                }
                if (!z3 && fVar.aPp() != null && !fVar.aPF()) {
                    postData = fVar.aPp();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aPp());
                    z3 = true;
                }
                if (z3 || fVar.aPp() == null || fVar.aPF()) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aPp = fVar.aPp();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aPp());
                    postData2 = aPp;
                    z4 = true;
                }
                cC(arrayList);
                if (this.eHK.aQK()) {
                    if (fVar.aPk().size() > 0 && (postData3 = fVar.aPk().get(0)) != null && postData3.bsz() == 1 && !com.baidu.tbadk.core.util.v.v(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.eGF, arrayList, this.eGE);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.eGF.aPl());
                    }
                }
                int c = c(this.eGF, arrayList, this.eGE);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.eGF.aPm());
                }
                if (arrayList.size() == 0 && this.eHK.aQK()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.eGE);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.f> e = e(fVar, arrayList);
                    if (e != null && e.size() > 0) {
                        com.baidu.tbadk.core.util.v.a((List) arrayList, a, (List) e);
                    } else {
                        this.eKm = 0;
                    }
                } else {
                    this.eKm = 0;
                }
                com.baidu.tieba.tbadkCore.n.p(arrayList, 1);
                int c2 = c(fVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eFF);
                    if (fVar != null && fVar.aPi() != null) {
                        jVar.eFH = fVar.aPi().rt();
                    }
                    jVar.aFm = !this.eGE;
                    jVar.eFI = this.eHK.aQX();
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
                        ((PostData) fVar2).cAG = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) e2);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d >= 0 && fVar.aPE() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aPE());
                    fVar.aPE().iS((b(arrayList, d) || z5) ? false : true);
                    z5 = true;
                }
                this.eKe.jk(!z5);
                if (this.eHK.aQn() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.eHK.aQn().getPostId())) {
                    z6 = false;
                }
                if (this.eKA && !z6) {
                    arrayList.remove(postData2);
                    this.eKA = false;
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z6 && !z) {
                    if ((this.eKC || this.eKB) && b2 != -1 && !com.baidu.tbadk.core.util.v.v(e2) && !this.eKD) {
                        this.eKI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.mListView.setSelection(g.this.mListView.getHeaderViewsCount() + e2.size());
                                g.this.eKD = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fQ().post(this.eKI);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        if (this.eHK.aPp() == null || this.eHK.aQm() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (this.eKB || fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aPk()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aPF() && this.eGE) ? 0 : -1;
        } else if (this.eHK.aQn() == null || !this.eHK.aQn().getIsFromMark()) {
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
                    if (postData.bsz() == 1 && postData.gjL == 0) {
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
            return (fVar.aPF() && this.eGE) ? 0 : -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aPk()) || com.baidu.tbadk.core.util.v.v(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(fVar.aPk(), 0)) == null) {
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
                if (postData.bsz() == 1 && postData.gjL == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aPk()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aPF()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i);
            if ((fVar2 instanceof PostData) && ((PostData) fVar2).bsz() == 1) {
                return i + 1;
            }
        }
        return !fVar.aPF() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.f> e(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPs() == null || com.baidu.tbadk.core.util.v.v(fVar.aPs().eFY)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aPs().eFY;
        if (com.baidu.tbadk.core.util.v.v(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.gjN = true;
                arrayList.add(postData);
            }
        }
        int u = com.baidu.tbadk.core.util.v.u(fVar.aPs().eFZ);
        if (fVar.aPs().getCount() != u && u > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).gjN = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).gjN = true;
            }
        }
        arrayList.add(0, new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eFG));
        return arrayList;
    }

    public void aRi() {
        this.eKm = 0;
    }

    public int aRj() {
        return this.eKn;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.v.v(fVar.aPk()) || com.baidu.tbadk.core.util.v.v(fVar.aPj())) {
            return -1;
        }
        if (z) {
            return (fVar.aPk().get(0) == null || fVar.aPk().get(0).bsz() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.f> e(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (fVar == null || arrayList == null || fVar.aPj() == null || fVar.aPj().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<bj> aPj = fVar.aPj();
        int size = aPj.size();
        this.eKn = 0;
        if (this.eKm + 5 >= size) {
            int i2 = 0;
            for (bj bjVar : aPj) {
                if (bjVar != null) {
                    com.baidu.tieba.pb.video.k kVar = new com.baidu.tieba.pb.video.k();
                    int i3 = i2 + 1;
                    if (i3 == 1) {
                        kVar.a(bjVar, true, true, true, i3);
                    } else {
                        kVar.a(bjVar, true, true, false, i3);
                    }
                    arrayList2.add(kVar);
                    this.eKm++;
                    i = i3;
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (this.eKm <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.eKn = arrayList2.size();
            }
            return arrayList2;
        }
        int i4 = this.eKm + 5;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            bj bjVar2 = aPj.get(i6);
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
                this.eKm++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.m());
        this.eKn = arrayList2.size();
        return arrayList2;
    }

    private void aiX() {
        if (this.eHK != null && !aiY()) {
            this.eHK.registerListener(this.cvz);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aiY() {
        if (this.eHK == null) {
            return false;
        }
        this.cvr = new ArrayList();
        ArrayList<BdUniqueId> brJ = com.baidu.tieba.tbadkCore.n.brJ();
        if (brJ == null || brJ.size() <= 0) {
            return false;
        }
        int size = brJ.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aGi().a(this.eHK.getPageContext(), brJ.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cvr.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.v(this.cvr)) {
            this.mListView.addAdapters(this.cvr);
        }
        return true;
    }

    public int aRk() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPk() == null || fVar.aPl() == null || fVar.aPk().size() == 0 || fVar.aPi() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPl().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPk().get(0) == null || fVar.aPk().get(0).bsz() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qD() == null || fVar.qD().qx() != fVar.qD().qu()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPk() == null || fVar.aPm() == null || fVar.aPk().size() == 0 || fVar.aPi() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPm().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPk().get(0) == null || fVar.aPk().get(0).bsz() != 1) ? -1 : 1;
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

    public ArrayList<PostData> aRl() {
        return this.postList;
    }

    public BdUniqueId pn(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.eKt == null || !this.eKt.aQb()) {
            this.eKJ = aRm();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    private int aRm() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.mListView.getData().get(i2);
                if (fVar == null || fVar.getType() != com.baidu.tieba.pb.data.j.eFF) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aRn() {
        return this.eKJ;
    }

    private void aRo() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eGF != null) {
            ArrayList<PostData> aPk = this.eGF.aPk();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aPw = this.eGF.aPw();
            if (aPw != null) {
                int size = aPw.size();
                if (aPk != null && aPk.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aPw.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.bsq() != null) {
                            sb.append(next.bsq());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aPw.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.czU = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aPw.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bso() != null) {
                            int ps = next3.bso().ps();
                            if (ps != 0) {
                                a(next3, ps);
                                if (ps != 28 && ps != 31) {
                                    if (next3.bso().goods != null) {
                                        next3.bso().goods.goods_style = TbErrInfo.ERR_IMG_GET_REMOTE;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bso().apk_name)) {
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
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.bsq(), lVar3)) != null) {
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
                        if (this.eGF.aPg() != null) {
                            lVar4.forumId = this.eGF.aPg().getId();
                        }
                        if (this.eGF.aPi() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.eGF.aPi().getId(), 0L);
                        }
                        if (this.eGF != null && this.eGF.qD() != null) {
                            lVar4.pageNumber = this.eGF.qD().qx();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (a(lVar4, aPk)) {
                            aPk.add(lVar4);
                        } else if (position2 + i3 >= aPk.size()) {
                            a(lVar4, 2);
                            return;
                        } else {
                            aPk.add(position2, lVar4);
                            TiebaStatic.eventStat(this.eHK.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bso().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.se(i);
        com.baidu.tieba.recapp.report.b.bhY().a(c);
        if (lVar != null && lVar.bso() != null) {
            lVar.bso().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bso() != null && lVar.bso().goods != null && lVar.bso().goods.goods_style != 1001 && lVar.bso().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aPg;
        if (lVar != null && this.eGF != null && lVar.bso() != null) {
            lVar.bso().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eGF.qD() != null) {
                lVar.bso().advertAppContext.pn = this.eGF.qD().qx();
            }
            lVar.bso().advertAppContext.Tr = "PB";
            if (this.eGF.aPg() != null && (aPg = this.eGF.aPg()) != null) {
                lVar.bso().advertAppContext.fid = aPg.getId();
                lVar.bso().advertAppContext.Tt = aPg.getFirst_class();
                lVar.bso().advertAppContext.Tu = aPg.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bso().advertAppContext.Tv = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bso().advertAppContext.extensionInfo = lVar.bso().ext_info;
            lVar.bso().advertAppContext.Tw = false;
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
        if (this.eGF != null && this.eGF.qD() != null) {
            lVar.pageNumber = this.eGF.qD().qx();
        }
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eKu.setFromCDN(z);
        this.eKe.setFromCDN(z);
        if (this.eKo != null && (this.eKo instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eKo).setIsFromCDN(z);
        }
        if (this.eKp != null && (this.eKp instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eKp).setIsFromCDN(z);
        }
        if (this.cyY != null && (this.cyY instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cyY).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eKy.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void iT(boolean z) {
        this.eGD = z;
    }

    public void iU(boolean z) {
        this.eGE = z;
    }

    public void iV(boolean z) {
        this.eKF = z;
    }

    public void A(View.OnClickListener onClickListener) {
        this.eGI = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRv = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRw = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avy = onLongClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.cUW = onClickListener;
    }

    public void po(int i) {
        if (this.eKf != null) {
            this.eKf.po(i);
        }
        switch (i) {
            case 1:
                if (this.eKt != null) {
                    this.eKt.pause();
                }
                if (this.eKe != null) {
                    this.eKe.pause();
                }
                if (this.eKq != null && (this.eKq instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eKq).release();
                    return;
                }
                return;
            case 2:
                if (this.eKt != null) {
                    this.eKt.resume();
                }
                if (this.eKe != null) {
                    this.eKe.resume();
                }
                if (this.eKq != null && (this.eKq instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eKq).resume();
                    return;
                }
                return;
            case 3:
                if (this.eKt != null) {
                    this.eKt.release();
                }
                if (this.eKe != null) {
                    this.eKe.release();
                }
                if (this.eKq != null && (this.eKq instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eKq).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cC(List<com.baidu.adp.widget.ListView.f> list) {
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
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.eKI);
        if (this.eKg != null) {
            this.eKg.onDestory();
        }
    }

    public void jf(boolean z) {
        this.eKE = z;
    }

    public void jg(boolean z) {
        this.eKB = z;
    }

    public void jh(boolean z) {
        this.eKC = z;
    }

    public void ji(boolean z) {
        this.eKA = z;
    }

    public void jj(boolean z) {
        this.eKD = z;
    }

    public aj aRp() {
        return this.eKf;
    }
}
