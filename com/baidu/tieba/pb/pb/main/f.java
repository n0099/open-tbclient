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
/* loaded from: classes2.dex */
public class f {
    private List<com.baidu.adp.widget.ListView.a> dAa;
    private com.baidu.adp.widget.ListView.a dIN;
    private com.baidu.adp.widget.ListView.a dIO;
    private int fFA;
    private Runnable fFD;
    private int fFF;
    private PbActivity fFd;
    private o fFe;
    private com.baidu.tieba.pb.pb.main.a.a fFf;
    private ak fFg;
    private ak fFh;
    private i fFi;
    private com.baidu.tieba.pb.video.a fFj;
    private ag fFk;
    private ah fFl;
    private com.baidu.tieba.pb.pb.a.b fFm;
    private v fFn;
    private ae fFo;
    private com.baidu.tieba.pb.pb.a.d fFp;
    private ao fFq;
    private com.baidu.tieba.pb.data.d fFs;
    private boolean fFx;
    private boolean fFy;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fFr = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fFt = true;
    private boolean fFu = true;
    private boolean fFv = false;
    private boolean fFw = false;
    private boolean fFz = false;
    private String mHostId = null;
    private View.OnClickListener fFB = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bjz = null;
    private com.baidu.tieba.pb.a.c bjA = null;
    private View.OnLongClickListener aKx = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fFC = new ArrayList();
    private int fFE = -1;
    private CustomMessageListener dzk = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bym = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bym();
                Iterator it = bym.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ap(f.this.fFd);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fFr.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fFm = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bym);
                f.this.fFC.clear();
                f.this.fFC.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener aHc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fFs != null && !com.baidu.adp.base.i.aI(f.this.fFd.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dAj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.z(f.this.dAa)) {
                f.this.azk();
                f.this.a(f.this.fFs, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fFA = 0;
        this.width = -1;
        this.fFF = 0;
        this.fFA = com.baidu.adp.lib.util.l.aO(pbActivity.getPageContext().getPageActivity());
        this.width = this.fFA;
        this.fFd = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aHc);
        this.fFF = com.baidu.adp.lib.util.l.aQ(this.fFd) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fFe = new o(pbActivity, PostData.gVz);
        this.fFe.a(pbActivity);
        this.fFf = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.i.fAT);
        this.fFg = new ak(pbActivity, com.baidu.tieba.pb.data.h.fAN);
        this.fFh = new ak(pbActivity, com.baidu.tieba.pb.data.h.fAO);
        this.fFi = new i(pbActivity, PostData.gVA);
        this.fFi.a(pbActivity);
        this.dIN = com.baidu.tieba.recapp.r.bpV().a(pbActivity, AdvertAppInfo.afS);
        this.dIO = com.baidu.tieba.recapp.r.bpV().a(pbActivity, AdvertAppInfo.afW);
        this.fFn = new v(pbActivity, com.baidu.tieba.pb.data.a.fzS);
        this.fFo = new ae(pbActivity, com.baidu.tieba.pb.data.g.fAM);
        this.fFk = new ag(pbActivity, ad.fKx);
        this.fFl = new ah(pbActivity, com.baidu.tbadk.core.data.ao.aji);
        this.fFp = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gVE);
        this.fFq = new ao(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fFj = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fTY);
        this.fFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fFs.bbU() != null) {
                    pbActivity.bdf().bgh().bcJ();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fFe);
        this.mAdapters.add(this.fFf);
        this.mAdapters.add(this.fFi);
        this.mAdapters.add(this.fFg);
        this.mAdapters.add(this.fFh);
        this.mAdapters.add(this.dIN);
        this.mAdapters.add(this.dIO);
        this.mAdapters.add(this.fFn);
        this.mAdapters.add(this.fFo);
        this.mAdapters.add(this.fFk);
        this.mAdapters.add(this.fFl);
        this.mAdapters.add(this.fFj);
        this.mAdapters.add(this.fFp);
        this.mAdapters.add(this.fFq);
        this.dzk.setPriority(1);
        this.dzk.setSelfListener(true);
        pbActivity.registerListener(this.dzk);
        azj();
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
        com.baidu.adp.widget.ListView.h bef;
        PostData postData3;
        if (dVar != null) {
            boolean z7 = false;
            if (this.fFs != dVar) {
                z7 = true;
                if ((dVar != null && !dVar.bbG()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z7 = false;
                }
            }
            this.fFs = dVar;
            if (z7) {
                bek();
                if (dVar != null) {
                    dVar.jR(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fFs != null && this.fFs.bbL() != null && this.fFs.bbL().size() > 0) {
                this.postList.addAll(this.fFs.bbL());
            }
            if (dVar != null && dVar.bbJ() != null && dVar.bbJ().wm() != null) {
                this.mHostId = dVar.bbJ().wm().getUserId();
            }
            if (this.fFe != null) {
                this.fFe.b(dVar);
                this.fFe.setFromCDN(this.mIsFromCDN);
                this.fFe.qQ(this.fFA);
                this.fFe.jU(this.fFt);
                this.fFe.q(this.mCommonClickListener);
                this.fFe.G(this.fFB);
                this.fFe.setOnImageClickListener(this.bjz);
                this.fFe.setOnLongClickListener(this.aKx);
                this.fFe.setTbGestureDetector(this.bjA);
                this.fFi.b(dVar);
                this.fFi.setFromCDN(this.mIsFromCDN);
                this.fFi.setHostId(this.mHostId);
                this.fFi.jU(this.fFt);
                this.fFi.q(this.mCommonClickListener);
                this.fFi.G(this.fFB);
                this.fFi.setOnImageClickListener(this.bjz);
                this.fFi.setOnLongClickListener(this.aKx);
                this.fFi.setTbGestureDetector(this.bjA);
                this.fFf.setOnClickListener(this.mCommonClickListener);
                this.fFp.setOnClickListener(this.mCommonClickListener);
                if (this.dIO != null && (this.dIO instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dIO).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fFr.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.qQ(this.fFA);
                        next.jU(this.fFt);
                        next.jV(this.fFu);
                        next.jW(this.fFz);
                        next.q(this.mCommonClickListener);
                        next.G(this.fFB);
                        next.setOnImageClickListener(this.bjz);
                        next.setOnLongClickListener(this.aKx);
                    }
                }
                this.fFg.q(this.mCommonClickListener);
                this.fFh.q(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.bbL());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).byM() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (this.fFu || postData == null) {
                    z3 = z2;
                    z4 = false;
                } else {
                    arrayList.remove(postData);
                    z4 = true;
                    z3 = true;
                    if (dVar.bci() && postData.byO() != null) {
                        postData.c(null);
                    }
                }
                if (z3 || dVar.bbQ() == null) {
                    z5 = z3;
                    postData2 = postData;
                } else {
                    PostData bbQ = dVar.bbQ();
                    if (!this.fFu && dVar.bci() && bbQ.byO() != null) {
                        bbQ.c(null);
                    }
                    z5 = true;
                    postData2 = bbQ;
                    z4 = true;
                }
                cV(arrayList);
                if (this.fFd.bdE()) {
                    if (dVar.bbL().size() > 0 && (postData3 = dVar.bbL().get(0)) != null && postData3.byM() == 1 && !com.baidu.tbadk.core.util.v.z(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.fFs, arrayList, this.fFu);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.fFs.bbM());
                    }
                }
                int c = c(this.fFs, arrayList, this.fFu);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.fFs.bbN());
                }
                if (arrayList.size() == 0 && this.fFd.bdE()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z8 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fAN);
                    if (dVar != null && dVar.bbJ() != null) {
                        hVar.fAP = dVar.bbJ().wd();
                    }
                    hVar.isNew = !this.fFu;
                    hVar.fAS = this.fFd.bdQ();
                    hVar.sortType = dVar.fAE;
                    if (dVar.fAD != null && dVar.fAD.size() > dVar.fAE) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= dVar.fAD.size()) {
                                break;
                            } else if (dVar.fAD.get(i2).sort_type.intValue() != dVar.fAE) {
                                i = i2 + 1;
                            } else {
                                hVar.fAR = dVar.fAD.get(i2).sort_name;
                                break;
                            }
                        }
                    }
                    com.baidu.tbadk.core.util.v.a(arrayList, c2, hVar);
                    z8 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.h> g = g(dVar);
                if (com.baidu.tbadk.core.util.v.z(g) || b2 < 0) {
                    z6 = z8;
                } else {
                    com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, b2);
                    if (hVar2 instanceof PostData) {
                        ((PostData) hVar2).gWj = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z6 = true;
                }
                int i3 = -1;
                boolean z9 = false;
                if (z5) {
                    i3 = a(dVar, arrayList, this.fFu);
                }
                if (i3 >= 0 && dVar.bch() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, dVar.bch());
                    z6 = true;
                    z9 = true;
                }
                boolean z10 = false;
                if (!this.fFd.bdN() && this.fFs != null && this.fFs.bbH() != null && !StringUtils.isNull(this.fFs.bbH().getName()) && !StringUtils.isNull(this.fFs.bbH().getId())) {
                    i3++;
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, this.fFs.bbH());
                    z10 = true;
                    if (this.fFq != null && this.fFs.bbJ() != null) {
                        this.fFq.setThreadId(this.fFs.bbJ().getId());
                    }
                }
                int i4 = i3;
                boolean z11 = z10;
                boolean z12 = false;
                if (z5 && (bef = bef()) != null && i4 >= 0) {
                    z12 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i4 + 1, bef);
                }
                if (z5 && !z12) {
                    com.baidu.adp.widget.ListView.h beg = beg();
                    int i5 = -1;
                    if (i4 >= 0) {
                        i5 = i4 + 1;
                    } else if (b2 >= 0) {
                        i5 = b2;
                    } else if (c2 >= 0) {
                        i5 = c2;
                    }
                    if (beg != null && i5 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i5, beg);
                    }
                }
                this.fFe.kl(!z6);
                boolean z13 = false;
                if (this.fFd.bcO() != null && postData2 != null && postData2.getId() != null && postData2.getId().equals(this.fFd.bcO().getPostId())) {
                    z13 = true;
                }
                if (this.fFv && !z13) {
                    arrayList.remove(postData2);
                    this.fFv = false;
                }
                if (dVar.bch() != null) {
                    if (z9 && !z11) {
                        dVar.bch().jS(false);
                    } else {
                        dVar.bch().jS(true);
                    }
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z13 && !z && ((this.fFx || this.fFw) && b2 != -1 && !com.baidu.tbadk.core.util.v.z(g) && !this.fFy)) {
                    this.fFD = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fFF);
                            f.this.fFy = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.jt().post(this.fFD);
                }
                if (postData2 == null) {
                    PostData postData4 = new PostData();
                    postData4.uj(1);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData4);
                    this.mListView.setData(arrayList);
                } else if (z4) {
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData2);
                    this.mListView.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h bef() {
        PbModel bcO = this.fFd.bcO();
        if (bcO == null) {
            return null;
        }
        String bfn = bcO.bfn();
        if (TextUtils.isEmpty(bfn)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.uu(bfn);
        b(lVar);
        return lVar;
    }

    private com.baidu.adp.widget.ListView.h beg() {
        com.baidu.tieba.tbadkCore.data.l bbZ;
        if (this.fFs == null || (bbZ = this.fFs.bbZ()) == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert byB = bbZ.byB();
        if (byB != null) {
            byB.setAdvertAppInfo(bbZ.pp());
        }
        int uH = bbZ.byA().uH();
        if (uH != 0) {
            a(bbZ, uH);
            if (uH == 28 || uH == 31 || bbZ.byA().goods == null) {
                return null;
            }
            bbZ.byA().goods.goods_style = -1001;
            return null;
        }
        if (this.fFs.bbH() != null) {
            bbZ.forumId = this.fFs.bbH().getId();
        }
        if (this.fFs.bbJ() != null) {
            bbZ.threadId = com.baidu.adp.lib.g.b.d(this.fFs.bbJ().getId(), 0L);
        }
        if (this.fFs != null && this.fFs.vy() != null) {
            bbZ.pageNumber = this.fFs.vy().vs();
        }
        b(bbZ);
        return bbZ;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fFw || dVar == null || com.baidu.tbadk.core.util.v.z(dVar.bbL()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bci() && this.fFu) ? 0 : -1;
        } else if (this.fFd.bcO() == null || !this.fFd.bcO().getIsFromMark()) {
            if (this.fFd.bdf() == null || !this.fFd.bdf().bhh()) {
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
                        if (postData.byM() == 1 && postData.gWg == 0) {
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
                return dVar.bci() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.z(dVar.bbL()) || com.baidu.tbadk.core.util.v.z(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.d(dVar.bbL(), 0)) == null) {
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
                if (postData.byM() == 1 && postData.gWg == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.z(dVar.bbL()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bci()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bbL().get(0) == null || dVar.bbL().get(0).byM() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bbU() == null || com.baidu.tbadk.core.util.v.z(dVar.bbU().fBd)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bbU().fBd;
        if (com.baidu.tbadk.core.util.v.z(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gWi = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.y(dVar.bbU().fBe) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).gWi = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).gWi = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fAO);
        hVar3.fAQ = dVar.bbU().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void azj() {
        if (this.fFd != null && !azk()) {
            this.fFd.registerListener(this.dAj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean azk() {
        if (this.fFd == null) {
            return false;
        }
        this.dAa = new ArrayList();
        ArrayList<BdUniqueId> bxZ = com.baidu.tieba.tbadkCore.q.bxZ();
        if (bxZ == null || bxZ.size() <= 0) {
            return false;
        }
        int size = bxZ.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aUT().a(this.fFd.getPageContext(), bxZ.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dAa.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.z(this.dAa)) {
            this.mListView.addAdapters(this.dAa);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bbL() == null || dVar.bbM() == null || dVar.bbL().size() == 0 || dVar.bbJ() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bbM().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bbL().get(0) == null || dVar.bbL().get(0).byM() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.vy() == null || dVar.vy().vs() != dVar.vy().vp()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bbL() == null || dVar.bbN() == null || dVar.bbL().size() == 0 || dVar.bbJ() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bbN().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bbL().get(0) == null || dVar.bbL().get(0).byM() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.vy() == null || dVar.vy().vs() != dVar.vy().vp()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> beh() {
        return this.postList;
    }

    public BdUniqueId qX(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fFm == null || !this.fFm.bcH()) {
            this.fFE = bei();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bei() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fAN) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bej() {
        return this.fFE;
    }

    private void bek() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fFs != null) {
            ArrayList<PostData> bbL = this.fFs.bbL();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> bbY = this.fFs.bbY();
            if (bbY != null) {
                int size = bbY.size();
                if (bbL != null && bbL.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = bbY.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = bbY.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dJn = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = bbY.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.byA() != null) {
                            int uH = next3.byA().uH();
                            if (uH != 0) {
                                a(next3, uH);
                                if (uH != 28 && uH != 31) {
                                    if (next3.byA().goods != null) {
                                        next3.byA().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.byA().apk_name)) {
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
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.fFs.bbH() != null) {
                            lVar4.forumId = this.fFs.bbH().getId();
                        }
                        if (this.fFs.bbJ() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.d(this.fFs.bbJ().getId(), 0L);
                        }
                        if (this.fFs != null && this.fFs.vy() != null) {
                            lVar4.pageNumber = this.fFs.vy().vs();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= bbL.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fFu) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        bbL.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fFd.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.byA().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, 5);
        c.sL(i);
        com.baidu.tieba.recapp.report.c.bqQ().a(c);
        if (lVar != null && lVar.byA() != null) {
            lVar.byA().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.byA() != null && lVar.byA().goods != null && lVar.byA().goods.goods_style != 1001 && lVar.byA().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData bbH;
        if (lVar != null && this.fFs != null && lVar.byA() != null) {
            lVar.byA().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fFs.vy() != null) {
                lVar.byA().advertAppContext.pn = this.fFs.vy().vs();
            }
            lVar.byA().advertAppContext.page = lVar.byD();
            if (this.fFs.bbH() != null && (bbH = this.fFs.bbH()) != null) {
                lVar.byA().advertAppContext.fid = bbH.getId();
                lVar.byA().advertAppContext.afK = bbH.getFirst_class();
                lVar.byA().advertAppContext.afL = bbH.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.byA().advertAppContext.afM = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.byA().advertAppContext.extensionInfo = lVar.byA().ext_info;
            lVar.byA().advertAppContext.Rz = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fFe.setFromCDN(z);
        if (this.dIO != null && (this.dIO instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dIO).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fFr.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bel() {
        return this.fFt;
    }

    public void jU(boolean z) {
        this.fFt = z;
    }

    public void jV(boolean z) {
        this.fFu = z;
    }

    public void jW(boolean z) {
        this.fFz = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fFB = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bjz = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bjA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aKx = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void qY(int i) {
        switch (i) {
            case 1:
                if (this.fFm != null) {
                    this.fFm.pause();
                }
                if (this.fFe != null) {
                    this.fFe.pause();
                    return;
                }
                return;
            case 2:
                if (this.fFm != null) {
                    this.fFm.resume();
                }
                if (this.fFe != null) {
                    this.fFe.resume();
                    return;
                }
                return;
            case 3:
                if (this.fFm != null) {
                    this.fFm.release();
                }
                if (this.fFe != null) {
                    this.fFe.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cV(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.xg())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.dz(postData.xg());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fFD);
        if (this.fFg != null) {
            this.fFg.onDestroy();
        }
        if (this.fFh != null) {
            this.fFh.onDestroy();
        }
        if (this.fFf != null) {
            this.fFf.onDestroy();
        }
    }

    public void kh(boolean z) {
        this.fFw = z;
    }

    public void ki(boolean z) {
        this.fFx = z;
    }

    public void kj(boolean z) {
        this.fFv = z;
    }

    public void kk(boolean z) {
        this.fFy = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bem() {
        return this.fFf;
    }
}
