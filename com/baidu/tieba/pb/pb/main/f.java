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
    private List<com.baidu.adp.widget.ListView.a> dIa;
    private com.baidu.adp.widget.ListView.a dQK;
    private com.baidu.adp.widget.ListView.a dQL;
    private PbActivity fME;
    private o fMF;
    private com.baidu.tieba.pb.pb.main.a.a fMG;
    private ak fMH;
    private ak fMI;
    private i fMJ;
    private com.baidu.tieba.pb.video.a fMK;
    private ag fML;
    private ah fMM;
    private com.baidu.tieba.pb.pb.a.b fMN;
    private v fMO;
    private ae fMP;
    private com.baidu.tieba.pb.pb.a.d fMQ;
    private ao fMR;
    private com.baidu.tieba.pb.data.d fMT;
    private boolean fMY;
    private boolean fMZ;
    private int fNb;
    private Runnable fNe;
    private int fNg;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fMS = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fMU = true;
    private boolean fMV = true;
    private boolean fMW = false;
    private boolean fMX = false;
    private boolean fNa = false;
    private String mHostId = null;
    private View.OnClickListener fNc = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bnD = null;
    private com.baidu.tieba.pb.a.c bnE = null;
    private View.OnLongClickListener aOZ = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fNd = new ArrayList();
    private int fNf = -1;
    private CustomMessageListener dHk = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bBB = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bBB();
                Iterator it = bBB.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ap(f.this.fME);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fMS.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fMN = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bBB);
                f.this.fNd.clear();
                f.this.fNd.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener aLF = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fMT != null && !com.baidu.adp.base.i.aI(f.this.fME.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dIj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.J(f.this.dIa)) {
                f.this.aCD();
                f.this.a(f.this.fMT, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fNb = 0;
        this.width = -1;
        this.fNg = 0;
        this.fNb = com.baidu.adp.lib.util.l.aO(pbActivity.getPageContext().getPageActivity());
        this.width = this.fNb;
        this.fME = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aLF);
        this.fNg = com.baidu.adp.lib.util.l.aQ(this.fME) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fMF = new o(pbActivity, PostData.hcU);
        this.fMF.a(pbActivity);
        this.fMG = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.i.fIv);
        this.fMH = new ak(pbActivity, com.baidu.tieba.pb.data.h.fIp);
        this.fMI = new ak(pbActivity, com.baidu.tieba.pb.data.h.fIq);
        this.fMJ = new i(pbActivity, PostData.hcV);
        this.fMJ.a(pbActivity);
        this.dQK = com.baidu.tieba.recapp.r.btk().a(pbActivity, AdvertAppInfo.akP);
        this.dQL = com.baidu.tieba.recapp.r.btk().a(pbActivity, AdvertAppInfo.akT);
        this.fMO = new v(pbActivity, com.baidu.tieba.pb.data.a.fHu);
        this.fMP = new ae(pbActivity, com.baidu.tieba.pb.data.g.fIo);
        this.fML = new ag(pbActivity, ad.fRY);
        this.fMM = new ah(pbActivity, com.baidu.tbadk.core.data.ao.aod);
        this.fMQ = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.hcZ);
        this.fMR = new ao(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fMK = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.gby);
        this.fMK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fMT.bfg() != null) {
                    pbActivity.bgr().bjt().bfV();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fMF);
        this.mAdapters.add(this.fMG);
        this.mAdapters.add(this.fMJ);
        this.mAdapters.add(this.fMH);
        this.mAdapters.add(this.fMI);
        this.mAdapters.add(this.dQK);
        this.mAdapters.add(this.dQL);
        this.mAdapters.add(this.fMO);
        this.mAdapters.add(this.fMP);
        this.mAdapters.add(this.fML);
        this.mAdapters.add(this.fMM);
        this.mAdapters.add(this.fMK);
        this.mAdapters.add(this.fMQ);
        this.mAdapters.add(this.fMR);
        this.dHk.setPriority(1);
        this.dHk.setSelfListener(true);
        pbActivity.registerListener(this.dHk);
        aCC();
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
        com.baidu.adp.widget.ListView.h bhr;
        PostData postData3;
        if (dVar != null) {
            boolean z7 = false;
            if (this.fMT != dVar) {
                z7 = true;
                if ((dVar != null && !dVar.beS()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z7 = false;
                }
            }
            this.fMT = dVar;
            if (z7) {
                bhw();
                if (dVar != null) {
                    dVar.ki(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fMT != null && this.fMT.beX() != null && this.fMT.beX().size() > 0) {
                this.postList.addAll(this.fMT.beX());
            }
            if (dVar != null && dVar.beV() != null && dVar.beV().yv() != null) {
                this.mHostId = dVar.beV().yv().getUserId();
            }
            if (this.fMF != null) {
                this.fMF.b(dVar);
                this.fMF.setFromCDN(this.mIsFromCDN);
                this.fMF.setImageMaxWidth(this.fNb);
                this.fMF.kl(this.fMU);
                this.fMF.q(this.mCommonClickListener);
                this.fMF.G(this.fNc);
                this.fMF.setOnImageClickListener(this.bnD);
                this.fMF.setOnLongClickListener(this.aOZ);
                this.fMF.setTbGestureDetector(this.bnE);
                this.fMJ.b(dVar);
                this.fMJ.setFromCDN(this.mIsFromCDN);
                this.fMJ.setHostId(this.mHostId);
                this.fMJ.kl(this.fMU);
                this.fMJ.q(this.mCommonClickListener);
                this.fMJ.G(this.fNc);
                this.fMJ.setOnImageClickListener(this.bnD);
                this.fMJ.setOnLongClickListener(this.aOZ);
                this.fMJ.setTbGestureDetector(this.bnE);
                this.fMG.setOnClickListener(this.mCommonClickListener);
                this.fMQ.setOnClickListener(this.mCommonClickListener);
                if (this.dQL != null && (this.dQL instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dQL).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fMS.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.setImageMaxWidth(this.fNb);
                        next.kl(this.fMU);
                        next.km(this.fMV);
                        next.kn(this.fNa);
                        next.q(this.mCommonClickListener);
                        next.G(this.fNc);
                        next.setOnImageClickListener(this.bnD);
                        next.setOnLongClickListener(this.aOZ);
                    }
                }
                this.fMH.q(this.mCommonClickListener);
                this.fMI.q(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.beX());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bCb() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (this.fMV || postData == null) {
                    z3 = z2;
                    z4 = false;
                } else {
                    arrayList.remove(postData);
                    z4 = true;
                    z3 = true;
                    if (dVar.bfu() && postData.bCd() != null) {
                        postData.c(null);
                    }
                }
                if (z3 || dVar.bfc() == null) {
                    z5 = z3;
                    postData2 = postData;
                } else {
                    PostData bfc = dVar.bfc();
                    if (!this.fMV && dVar.bfu() && bfc.bCd() != null) {
                        bfc.c(null);
                    }
                    z5 = true;
                    postData2 = bfc;
                    z4 = true;
                }
                dj(arrayList);
                if (this.fME.bgQ()) {
                    if (dVar.beX().size() > 0 && (postData3 = dVar.beX().get(0)) != null && postData3.bCb() == 1 && !com.baidu.tbadk.core.util.v.J(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.fMT, arrayList, this.fMV);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.fMT.beY());
                    }
                }
                int c = c(this.fMT, arrayList, this.fMV);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.fMT.beZ());
                }
                if (arrayList.size() == 0 && this.fME.bgQ()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.q(arrayList, 1);
                boolean z8 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fIp);
                    if (dVar != null && dVar.beV() != null) {
                        hVar.fIr = dVar.beV().ym();
                    }
                    hVar.isNew = !this.fMV;
                    hVar.fIu = this.fME.bhc();
                    hVar.sortType = dVar.fIg;
                    if (dVar.fIf != null && dVar.fIf.size() > dVar.fIg) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= dVar.fIf.size()) {
                                break;
                            } else if (dVar.fIf.get(i2).sort_type.intValue() != dVar.fIg) {
                                i = i2 + 1;
                            } else {
                                hVar.fIt = dVar.fIf.get(i2).sort_name;
                                break;
                            }
                        }
                    }
                    com.baidu.tbadk.core.util.v.a(arrayList, c2, hVar);
                    z8 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.h> g = g(dVar);
                if (com.baidu.tbadk.core.util.v.J(g) || b2 < 0) {
                    z6 = z8;
                } else {
                    com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, b2);
                    if (hVar2 instanceof PostData) {
                        ((PostData) hVar2).hdE = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z6 = true;
                }
                int i3 = -1;
                boolean z9 = false;
                if (z5) {
                    i3 = a(dVar, arrayList, this.fMV);
                }
                if (i3 >= 0 && dVar.bft() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, dVar.bft());
                    z6 = true;
                    z9 = true;
                }
                boolean z10 = false;
                if (!this.fME.bgZ() && this.fMT != null && this.fMT.beT() != null && !StringUtils.isNull(this.fMT.beT().getName()) && !StringUtils.isNull(this.fMT.beT().getId())) {
                    i3++;
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, this.fMT.beT());
                    z10 = true;
                    if (this.fMR != null && this.fMT.beV() != null) {
                        this.fMR.setThreadId(this.fMT.beV().getId());
                    }
                }
                int i4 = i3;
                boolean z11 = z10;
                boolean z12 = false;
                if (z5 && (bhr = bhr()) != null && i4 >= 0) {
                    z12 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i4 + 1, bhr);
                }
                if (z5 && !z12) {
                    com.baidu.adp.widget.ListView.h bhs = bhs();
                    int i5 = -1;
                    if (i4 >= 0) {
                        i5 = i4 + 1;
                    } else if (b2 >= 0) {
                        i5 = b2;
                    } else if (c2 >= 0) {
                        i5 = c2;
                    }
                    if (bhs != null && i5 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i5, bhs);
                    }
                }
                this.fMF.kC(!z6);
                boolean z13 = false;
                if (this.fME.bga() != null && postData2 != null && postData2.getId() != null && postData2.getId().equals(this.fME.bga().getPostId())) {
                    z13 = true;
                }
                if (this.fMW && !z13) {
                    arrayList.remove(postData2);
                    this.fMW = false;
                }
                if (dVar.bft() != null) {
                    if (z9 && !z11) {
                        dVar.bft().kj(false);
                    } else {
                        dVar.bft().kj(true);
                    }
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z13 && !z && ((this.fMY || this.fMX) && b2 != -1 && !com.baidu.tbadk.core.util.v.J(g) && !this.fMZ)) {
                    this.fNe = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fNg);
                            f.this.fMZ = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.jI().post(this.fNe);
                }
                if (postData2 == null) {
                    PostData postData4 = new PostData();
                    postData4.uG(1);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData4);
                    this.mListView.setData(arrayList);
                } else if (z4) {
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData2);
                    this.mListView.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h bhr() {
        PbModel bga = this.fME.bga();
        if (bga == null) {
            return null;
        }
        String biz = bga.biz();
        if (TextUtils.isEmpty(biz)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.uW(biz);
        b(lVar);
        return lVar;
    }

    private com.baidu.adp.widget.ListView.h bhs() {
        com.baidu.tieba.tbadkCore.data.l bfl;
        if (this.fMT == null || (bfl = this.fMT.bfl()) == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bBQ = bfl.bBQ();
        if (bBQ != null) {
            bBQ.setAdvertAppInfo(bfl.px());
        }
        int wQ = bfl.bBP().wQ();
        if (wQ != 0) {
            a(bfl, wQ);
            if (wQ == 28 || wQ == 31 || bfl.bBP().goods == null) {
                return null;
            }
            bfl.bBP().goods.goods_style = -1001;
            return null;
        }
        if (this.fMT.beT() != null) {
            bfl.forumId = this.fMT.beT().getId();
        }
        if (this.fMT.beV() != null) {
            bfl.threadId = com.baidu.adp.lib.g.b.d(this.fMT.beV().getId(), 0L);
        }
        if (this.fMT != null && this.fMT.xH() != null) {
            bfl.pageNumber = this.fMT.xH().xB();
        }
        b(bfl);
        return bfl;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fMX || dVar == null || com.baidu.tbadk.core.util.v.J(dVar.beX()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bfu() && this.fMV) ? 0 : -1;
        } else if (this.fME.bga() == null || !this.fME.bga().getIsFromMark()) {
            if (this.fME.bgr() == null || !this.fME.bgr().bkt()) {
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
                        if (postData.bCb() == 1 && postData.hdB == 0) {
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
                return dVar.bfu() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.J(dVar.beX()) || com.baidu.tbadk.core.util.v.J(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.d(dVar.beX(), 0)) == null) {
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
                if (postData.bCb() == 1 && postData.hdB == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.J(dVar.beX()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bfu()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.beX().get(0) == null || dVar.beX().get(0).bCb() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bfg() == null || com.baidu.tbadk.core.util.v.J(dVar.bfg().fIF)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bfg().fIF;
        if (com.baidu.tbadk.core.util.v.J(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.hdD = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.I(dVar.bfg().fIG) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).hdD = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).hdD = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fIq);
        hVar3.fIs = dVar.bfg().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void aCC() {
        if (this.fME != null && !aCD()) {
            this.fME.registerListener(this.dIj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aCD() {
        if (this.fME == null) {
            return false;
        }
        this.dIa = new ArrayList();
        ArrayList<BdUniqueId> bBo = com.baidu.tieba.tbadkCore.q.bBo();
        if (bBo == null || bBo.size() <= 0) {
            return false;
        }
        int size = bBo.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aYg().a(this.fME.getPageContext(), bBo.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dIa.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.J(this.dIa)) {
            this.mListView.addAdapters(this.dIa);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.beX() == null || dVar.beY() == null || dVar.beX().size() == 0 || dVar.beV() == null || arrayList == null) {
            return -1;
        }
        if (dVar.beY().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.beX().get(0) == null || dVar.beX().get(0).bCb() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.xH() == null || dVar.xH().xB() != dVar.xH().xy()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.beX() == null || dVar.beZ() == null || dVar.beX().size() == 0 || dVar.beV() == null || arrayList == null) {
            return -1;
        }
        if (dVar.beZ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.beX().get(0) == null || dVar.beX().get(0).bCb() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.xH() == null || dVar.xH().xB() != dVar.xH().xy()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bht() {
        return this.postList;
    }

    public BdUniqueId ru(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fMN == null || !this.fMN.bfT()) {
            this.fNf = bhu();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bhu() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fIp) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bhv() {
        return this.fNf;
    }

    private void bhw() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fMT != null) {
            ArrayList<PostData> beX = this.fMT.beX();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> bfk = this.fMT.bfk();
            if (bfk != null) {
                int size = bfk.size();
                if (beX != null && beX.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = bfk.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = bfk.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dRk = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = bfk.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bBP() != null) {
                            int wQ = next3.bBP().wQ();
                            if (wQ != 0) {
                                a(next3, wQ);
                                if (wQ != 28 && wQ != 31) {
                                    if (next3.bBP().goods != null) {
                                        next3.bBP().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bBP().apk_name)) {
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
                        if (this.fMT.beT() != null) {
                            lVar4.forumId = this.fMT.beT().getId();
                        }
                        if (this.fMT.beV() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.d(this.fMT.beV().getId(), 0L);
                        }
                        if (this.fMT != null && this.fMT.xH() != null) {
                            lVar4.pageNumber = this.fMT.xH().xB();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= beX.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fMV) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        beX.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fME.getPageContext().getContext(), "pb_show_app", "", 1, AiAppsApsUtils.APP_NAME, lVar4.bBP().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, 5);
        c.ti(i);
        com.baidu.tieba.recapp.report.c.buf().a(c);
        if (lVar != null && lVar.bBP() != null) {
            lVar.bBP().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bBP() != null && lVar.bBP().goods != null && lVar.bBP().goods.goods_style != 1001 && lVar.bBP().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData beT;
        if (lVar != null && this.fMT != null && lVar.bBP() != null) {
            lVar.bBP().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fMT.xH() != null) {
                lVar.bBP().advertAppContext.pn = this.fMT.xH().xB();
            }
            lVar.bBP().advertAppContext.page = lVar.bBS();
            if (this.fMT.beT() != null && (beT = this.fMT.beT()) != null) {
                lVar.bBP().advertAppContext.fid = beT.getId();
                lVar.bBP().advertAppContext.akH = beT.getFirst_class();
                lVar.bBP().advertAppContext.akI = beT.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bBP().advertAppContext.akJ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bBP().advertAppContext.extensionInfo = lVar.bBP().ext_info;
            lVar.bBP().advertAppContext.RQ = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fMF.setFromCDN(z);
        if (this.dQL != null && (this.dQL instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dQL).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fMS.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bhx() {
        return this.fMU;
    }

    public void kl(boolean z) {
        this.fMU = z;
    }

    public void km(boolean z) {
        this.fMV = z;
    }

    public void kn(boolean z) {
        this.fNa = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fNc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bnD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bnE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aOZ = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void rv(int i) {
        switch (i) {
            case 1:
                if (this.fMN != null) {
                    this.fMN.pause();
                }
                if (this.fMF != null) {
                    this.fMF.pause();
                    return;
                }
                return;
            case 2:
                if (this.fMN != null) {
                    this.fMN.resume();
                }
                if (this.fMF != null) {
                    this.fMF.resume();
                    return;
                }
                return;
            case 3:
                if (this.fMN != null) {
                    this.fMN.release();
                }
                if (this.fMF != null) {
                    this.fMF.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dj(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.zp())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.dP(postData.zp());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fNe);
        if (this.fMH != null) {
            this.fMH.onDestroy();
        }
        if (this.fMI != null) {
            this.fMI.onDestroy();
        }
        if (this.fMG != null) {
            this.fMG.onDestroy();
        }
    }

    public void ky(boolean z) {
        this.fMX = z;
    }

    public void kz(boolean z) {
        this.fMY = z;
    }

    public void kA(boolean z) {
        this.fMW = z;
    }

    public void kB(boolean z) {
        this.fMZ = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bhy() {
        return this.fMG;
    }
}
