package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
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
    private List<com.baidu.adp.widget.ListView.a> dJe;
    private com.baidu.adp.widget.ListView.a dRO;
    private com.baidu.adp.widget.ListView.a dRP;
    private int fOB;
    private Runnable fOE;
    private int fOG;
    private PbActivity fOe;
    private o fOf;
    private com.baidu.tieba.pb.pb.main.a.a fOg;
    private ak fOh;
    private ak fOi;
    private i fOj;
    private com.baidu.tieba.pb.video.a fOk;
    private ag fOl;
    private ah fOm;
    private com.baidu.tieba.pb.pb.a.b fOn;
    private v fOo;
    private ae fOp;
    private com.baidu.tieba.pb.pb.a.d fOq;
    private ao fOr;
    private com.baidu.tieba.pb.data.d fOt;
    private boolean fOy;
    private boolean fOz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fOs = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fOu = true;
    private boolean fOv = true;
    private boolean fOw = false;
    private boolean fOx = false;
    private boolean fOA = false;
    private String mHostId = null;
    private View.OnClickListener fOC = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bop = null;
    private com.baidu.tieba.pb.a.c boq = null;
    private View.OnLongClickListener aPP = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fOD = new ArrayList();
    private int fOF = -1;
    private CustomMessageListener dIk = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bAX = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bAX();
                Iterator it = bAX.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ap(f.this.fOe);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fOs.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fOn = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bAX);
                f.this.fOD.clear();
                f.this.fOD.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener aMv = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fOt != null && !com.baidu.adp.base.i.aI(f.this.fOe.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dJn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.I(f.this.dJe)) {
                f.this.aBY();
                f.this.a(f.this.fOt, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fOB = 0;
        this.width = -1;
        this.fOG = 0;
        this.fOB = com.baidu.adp.lib.util.l.aO(pbActivity.getPageContext().getPageActivity());
        this.width = this.fOB;
        this.fOe = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aMv);
        this.fOG = com.baidu.adp.lib.util.l.aQ(this.fOe) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fOf = new o(pbActivity, PostData.hes);
        this.fOf.a(pbActivity);
        this.fOg = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.i.fJU);
        this.fOh = new ak(pbActivity, com.baidu.tieba.pb.data.h.fJO);
        this.fOi = new ak(pbActivity, com.baidu.tieba.pb.data.h.fJP);
        this.fOj = new i(pbActivity, PostData.het);
        this.fOj.a(pbActivity);
        this.dRO = com.baidu.tieba.recapp.r.bsG().a(pbActivity, AdvertAppInfo.alD);
        this.dRP = com.baidu.tieba.recapp.r.bsG().a(pbActivity, AdvertAppInfo.alH);
        this.fOo = new v(pbActivity, com.baidu.tieba.pb.data.a.fIT);
        this.fOp = new ae(pbActivity, com.baidu.tieba.pb.data.g.fJN);
        this.fOl = new ag(pbActivity, ad.fTy);
        this.fOm = new ah(pbActivity, com.baidu.tbadk.core.data.ao.aoQ);
        this.fOq = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.hex);
        this.fOr = new ao(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fOk = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.gcV);
        this.fOk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fOt.beE() != null) {
                    pbActivity.bfO().biQ().bfs();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fOf);
        this.mAdapters.add(this.fOg);
        this.mAdapters.add(this.fOj);
        this.mAdapters.add(this.fOh);
        this.mAdapters.add(this.fOi);
        this.mAdapters.add(this.dRO);
        this.mAdapters.add(this.dRP);
        this.mAdapters.add(this.fOo);
        this.mAdapters.add(this.fOp);
        this.mAdapters.add(this.fOl);
        this.mAdapters.add(this.fOm);
        this.mAdapters.add(this.fOk);
        this.mAdapters.add(this.fOq);
        this.mAdapters.add(this.fOr);
        this.dIk.setPriority(1);
        this.dIk.setSelfListener(true);
        pbActivity.registerListener(this.dIk);
        aBX();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(2004015);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        PostData postData2;
        boolean z6;
        com.baidu.adp.widget.ListView.h bgO;
        PostData postData3;
        if (dVar != null) {
            boolean z7 = false;
            if (this.fOt != dVar) {
                z7 = true;
                if ((dVar != null && !dVar.beq()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z7 = false;
                }
            }
            this.fOt = dVar;
            if (z7) {
                bgT();
                if (dVar != null) {
                    dVar.ks(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fOt != null && this.fOt.bev() != null && this.fOt.bev().size() > 0) {
                this.postList.addAll(this.fOt.bev());
            }
            if (dVar != null && dVar.bet() != null && dVar.bet().yC() != null) {
                this.mHostId = dVar.bet().yC().getUserId();
            }
            if (this.fOf != null) {
                this.fOf.b(dVar);
                this.fOf.setFromCDN(this.mIsFromCDN);
                this.fOf.setImageMaxWidth(this.fOB);
                this.fOf.kw(this.fOu);
                this.fOf.s(this.mCommonClickListener);
                this.fOf.I(this.fOC);
                this.fOf.setOnImageClickListener(this.bop);
                this.fOf.setOnLongClickListener(this.aPP);
                this.fOf.setTbGestureDetector(this.boq);
                this.fOj.b(dVar);
                this.fOj.setFromCDN(this.mIsFromCDN);
                this.fOj.setHostId(this.mHostId);
                this.fOj.kw(this.fOu);
                this.fOj.s(this.mCommonClickListener);
                this.fOj.I(this.fOC);
                this.fOj.setOnImageClickListener(this.bop);
                this.fOj.setOnLongClickListener(this.aPP);
                this.fOj.setTbGestureDetector(this.boq);
                this.fOg.setOnClickListener(this.mCommonClickListener);
                this.fOq.setOnClickListener(this.mCommonClickListener);
                if (this.dRP != null && (this.dRP instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dRP).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fOs.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.setImageMaxWidth(this.fOB);
                        next.kw(this.fOu);
                        next.kx(this.fOv);
                        next.ky(this.fOA);
                        next.s(this.mCommonClickListener);
                        next.I(this.fOC);
                        next.setOnImageClickListener(this.bop);
                        next.setOnLongClickListener(this.aPP);
                    }
                }
                this.fOh.s(this.mCommonClickListener);
                this.fOi.s(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.bev());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bBx() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (this.fOv || postData == null) {
                    z3 = z2;
                    z4 = false;
                } else {
                    arrayList.remove(postData);
                    z4 = true;
                    z3 = true;
                    if (dVar.beS() && postData.bBz() != null) {
                        postData.c(null);
                    }
                }
                if (z3 || dVar.beA() == null) {
                    z5 = z3;
                    postData2 = postData;
                } else {
                    PostData beA = dVar.beA();
                    if (!this.fOv && dVar.beS() && beA.bBz() != null) {
                        beA.c(null);
                    }
                    z5 = true;
                    postData2 = beA;
                    z4 = true;
                }
                dh(arrayList);
                if (this.fOe.bgn()) {
                    if (dVar.bev().size() > 0 && (postData3 = dVar.bev().get(0)) != null && postData3.bBx() == 1 && !com.baidu.tbadk.core.util.v.I(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.fOt, arrayList, this.fOv);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.fOt.bew());
                    }
                }
                int c = c(this.fOt, arrayList, this.fOv);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.fOt.bex());
                }
                if (arrayList.size() == 0 && this.fOe.bgn()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.q(arrayList, 1);
                boolean z8 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fJO);
                    if (dVar != null && dVar.bet() != null) {
                        hVar.fJQ = dVar.bet().yt();
                    }
                    hVar.isNew = !this.fOv;
                    hVar.fJT = this.fOe.bgz();
                    hVar.sortType = dVar.fJF;
                    if (dVar.fJE != null && dVar.fJE.size() > dVar.fJF) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= dVar.fJE.size()) {
                                break;
                            } else if (dVar.fJE.get(i2).sort_type.intValue() != dVar.fJF) {
                                i = i2 + 1;
                            } else {
                                hVar.fJS = dVar.fJE.get(i2).sort_name;
                                break;
                            }
                        }
                    }
                    com.baidu.tbadk.core.util.v.a(arrayList, c2, hVar);
                    z8 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.h> g = g(dVar);
                if (com.baidu.tbadk.core.util.v.I(g) || b2 < 0) {
                    z6 = z8;
                } else {
                    com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, b2);
                    if (hVar2 instanceof PostData) {
                        ((PostData) hVar2).hfc = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z6 = true;
                }
                int i3 = -1;
                boolean z9 = false;
                if (z5) {
                    i3 = a(dVar, arrayList, this.fOv);
                }
                if (i3 >= 0 && dVar.beR() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, dVar.beR());
                    z6 = true;
                    z9 = true;
                }
                boolean z10 = false;
                if (!this.fOe.bgw() && this.fOt != null && this.fOt.ber() != null && !StringUtils.isNull(this.fOt.ber().getName()) && !StringUtils.isNull(this.fOt.ber().getId())) {
                    i3++;
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, this.fOt.ber());
                    z10 = true;
                    if (this.fOr != null && this.fOt.bet() != null) {
                        this.fOr.setThreadId(this.fOt.bet().getId());
                    }
                }
                int i4 = i3;
                boolean z11 = z10;
                boolean z12 = false;
                if (z5 && (bgO = bgO()) != null && i4 >= 0) {
                    z12 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i4 + 1, bgO);
                }
                if (z5 && !z12) {
                    com.baidu.adp.widget.ListView.h bgP = bgP();
                    int i5 = -1;
                    if (i4 >= 0) {
                        i5 = i4 + 1;
                    } else if (b2 >= 0) {
                        i5 = b2;
                    } else if (c2 >= 0) {
                        i5 = c2;
                    }
                    if (bgP != null && i5 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i5, bgP);
                    }
                }
                this.fOf.kN(!z6);
                boolean z13 = false;
                if (this.fOe.bfx() != null && postData2 != null && postData2.getId() != null && postData2.getId().equals(this.fOe.bfx().getPostId())) {
                    z13 = true;
                }
                if (this.fOw && !z13) {
                    arrayList.remove(postData2);
                    this.fOw = false;
                }
                if (dVar.beR() != null) {
                    if (z9 && !z11) {
                        dVar.beR().kt(false);
                    } else {
                        dVar.beR().kt(true);
                    }
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z13 && !z && ((this.fOy || this.fOx) && b2 != -1 && !com.baidu.tbadk.core.util.v.I(g) && !this.fOz)) {
                    this.fOE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fOG);
                            f.this.fOz = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.jG().post(this.fOE);
                }
                if (postData2 == null) {
                    PostData postData4 = new PostData();
                    postData4.uZ(1);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData4);
                    this.mListView.setData(arrayList);
                } else if (z4) {
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData2);
                    this.mListView.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h bgO() {
        PbModel bfx = this.fOe.bfx();
        if (bfx == null) {
            return null;
        }
        String bhW = bfx.bhW();
        if (TextUtils.isEmpty(bhW)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.vb(bhW);
        b(lVar);
        return lVar;
    }

    private com.baidu.adp.widget.ListView.h bgP() {
        com.baidu.tieba.tbadkCore.data.l beJ;
        if (this.fOt == null || (beJ = this.fOt.beJ()) == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bBm = beJ.bBm();
        if (bBm != null) {
            bBm.setAdvertAppInfo(beJ.pv());
        }
        int wY = beJ.bBl().wY();
        if (wY != 0) {
            a(beJ, wY);
            if (wY == 28 || wY == 31 || beJ.bBl().goods == null) {
                return null;
            }
            beJ.bBl().goods.goods_style = -1001;
            return null;
        }
        if (this.fOt.ber() != null) {
            beJ.forumId = this.fOt.ber().getId();
        }
        if (this.fOt.bet() != null) {
            beJ.threadId = com.baidu.adp.lib.g.b.d(this.fOt.bet().getId(), 0L);
        }
        if (this.fOt != null && this.fOt.xO() != null) {
            beJ.pageNumber = this.fOt.xO().xJ();
        }
        b(beJ);
        return beJ;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fOx || dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bev()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.beS() && this.fOv) ? 0 : -1;
        } else if (this.fOe.bfx() == null || !this.fOe.bfx().getIsFromMark()) {
            if (this.fOe.bfO() == null || !this.fOe.bfO().bjQ()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
                    if (hVar instanceof PostData) {
                        PostData postData = (PostData) hVar;
                        if (postData.bBx() == 1 && postData.heZ == 0) {
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
                return dVar.beS() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bev()) || com.baidu.tbadk.core.util.v.I(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.d(dVar.bev(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
            if (hVar instanceof PostData) {
                PostData postData = (PostData) hVar;
                if (postData.bBx() == 1 && postData.heZ == 0) {
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

    private int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bev()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.beS()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bev().get(0) == null || dVar.bev().get(0).bBx() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.beE() == null || com.baidu.tbadk.core.util.v.I(dVar.beE().fKe)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.beE().fKe;
        if (com.baidu.tbadk.core.util.v.I(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.hfb = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.H(dVar.beE().fKf) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).hfb = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).hfb = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fJP);
        hVar3.fJR = dVar.beE().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void aBX() {
        if (this.fOe != null && !aBY()) {
            this.fOe.registerListener(this.dJn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aBY() {
        if (this.fOe == null) {
            return false;
        }
        this.dJe = new ArrayList();
        ArrayList<BdUniqueId> bAK = com.baidu.tieba.tbadkCore.q.bAK();
        if (bAK == null || bAK.size() <= 0) {
            return false;
        }
        int size = bAK.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aXD().a(this.fOe.getPageContext(), bAK.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dJe.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.I(this.dJe)) {
            this.mListView.addAdapters(this.dJe);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bev() == null || dVar.bew() == null || dVar.bev().size() == 0 || dVar.bet() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bew().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bev().get(0) == null || dVar.bev().get(0).bBx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.xO() == null || dVar.xO().xJ() != dVar.xO().xG()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bev() == null || dVar.bex() == null || dVar.bev().size() == 0 || dVar.bet() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bex().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bev().get(0) == null || dVar.bev().get(0).bBx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.xO() == null || dVar.xO().xJ() != dVar.xO().xG()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bgQ() {
        return this.postList;
    }

    public BdUniqueId rN(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fOn == null || !this.fOn.bfq()) {
            this.fOF = bgR();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bgR() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fJO) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bgS() {
        return this.fOF;
    }

    private void bgT() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fOt != null) {
            ArrayList<PostData> bev = this.fOt.bev();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> beI = this.fOt.beI();
            if (beI != null) {
                int size = beI.size();
                if (bev != null && bev.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = beI.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.getAdId() != null) {
                            sb.append(next.getAdId());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = beI.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dSr = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = beI.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bBl() != null) {
                            int wY = next3.bBl().wY();
                            if (wY != 0) {
                                a(next3, wY);
                                if (wY != 28 && wY != 31) {
                                    if (next3.bBl().goods != null) {
                                        next3.bBl().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bBl().apk_name)) {
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
                        com.baidu.tieba.tbadkCore.data.l lVar3 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(sparseArray.keyAt(i));
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.getAdId(), lVar3)) != null) {
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
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.f.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: b */
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.fOt.ber() != null) {
                            lVar4.forumId = this.fOt.ber().getId();
                        }
                        if (this.fOt.bet() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.d(this.fOt.bet().getId(), 0L);
                        }
                        if (this.fOt != null && this.fOt.xO() != null) {
                            lVar4.pageNumber = this.fOt.xO().xJ();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= bev.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fOv) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        bev.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fOe.getPageContext().getContext(), "pb_show_app", "", 1, AiAppsApsUtils.APP_NAME, lVar4.bBl().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, 5);
        c.tB(i);
        com.baidu.tieba.recapp.report.c.btB().a(c);
        if (lVar != null && lVar.bBl() != null) {
            lVar.bBl().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bBl() != null && lVar.bBl().goods != null && lVar.bBl().goods.goods_style != 1001 && lVar.bBl().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData ber;
        if (lVar != null && this.fOt != null && lVar.bBl() != null) {
            lVar.bBl().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fOt.xO() != null) {
                lVar.bBl().advertAppContext.pn = this.fOt.xO().xJ();
            }
            lVar.bBl().advertAppContext.page = lVar.bBo();
            if (this.fOt.ber() != null && (ber = this.fOt.ber()) != null) {
                lVar.bBl().advertAppContext.fid = ber.getId();
                lVar.bBl().advertAppContext.alv = ber.getFirst_class();
                lVar.bBl().advertAppContext.alw = ber.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bBl().advertAppContext.alx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bBl().advertAppContext.extensionInfo = lVar.bBl().ext_info;
            lVar.bBl().advertAppContext.RT = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fOf.setFromCDN(z);
        if (this.dRP != null && (this.dRP instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dRP).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fOs.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bgU() {
        return this.fOu;
    }

    public void kw(boolean z) {
        this.fOu = z;
    }

    public void kx(boolean z) {
        this.fOv = z;
    }

    public void ky(boolean z) {
        this.fOA = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fOC = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bop = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.boq = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aPP = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void rO(int i) {
        switch (i) {
            case 1:
                if (this.fOn != null) {
                    this.fOn.pause();
                }
                if (this.fOf != null) {
                    this.fOf.pause();
                    return;
                }
                return;
            case 2:
                if (this.fOn != null) {
                    this.fOn.resume();
                }
                if (this.fOf != null) {
                    this.fOf.resume();
                    return;
                }
                return;
            case 3:
                if (this.fOn != null) {
                    this.fOn.release();
                }
                if (this.fOf != null) {
                    this.fOf.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dh(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.zw())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.dP(postData.zw());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fOE);
        if (this.fOh != null) {
            this.fOh.onDestroy();
        }
        if (this.fOi != null) {
            this.fOi.onDestroy();
        }
        if (this.fOg != null) {
            this.fOg.onDestroy();
        }
    }

    public void kJ(boolean z) {
        this.fOx = z;
    }

    public void kK(boolean z) {
        this.fOy = z;
    }

    public void kL(boolean z) {
        this.fOw = z;
    }

    public void kM(boolean z) {
        this.fOz = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bgV() {
        return this.fOg;
    }
}
