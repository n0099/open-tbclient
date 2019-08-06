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
/* loaded from: classes4.dex */
public class f {
    private ArrayList<com.baidu.adp.widget.ListView.m> dPQ;
    private List<com.baidu.adp.widget.ListView.a> fLV;
    private com.baidu.adp.widget.ListView.a gkL;
    private ak hNA;
    private ak hNB;
    private i hNC;
    private com.baidu.tieba.pb.video.a hND;
    private com.baidu.adp.widget.ListView.a hNE;
    private ag hNF;
    private ah hNG;
    private com.baidu.tieba.pb.pb.a.b hNH;
    private v hNI;
    private ae hNJ;
    private com.baidu.tieba.pb.pb.a.d hNK;
    private com.baidu.tieba.pb.data.d hNM;
    private boolean hNR;
    private boolean hNS;
    private int hNU;
    private Runnable hNY;
    private PbActivity hNx;
    private o hNy;
    private com.baidu.tieba.pb.pb.main.a.a hNz;
    private int hOa;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hNL = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hNN = true;
    private boolean hNO = true;
    private boolean hNP = false;
    private boolean hNQ = false;
    private boolean hNT = false;
    private String mHostId = null;
    private PostData hNV = null;
    private View.OnClickListener hNW = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h cKo = null;
    private com.baidu.tieba.pb.a.c clA = null;
    private View.OnLongClickListener cmF = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hNX = new ArrayList();
    private int hNZ = -1;
    private CustomMessageListener fBQ = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cpl = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cpl();
                Iterator it = cpl.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).av(f.this.hNx);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hNL.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hNH = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cpl);
                f.this.hNX.clear();
                f.this.hNX.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener ciq = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hNM != null && !com.baidu.adp.base.i.Z(f.this.hNx.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener fLX = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.aa(f.this.fLV)) {
                f.this.bxj();
                f.this.a(f.this.hNM, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hNU = 0;
        this.width = -1;
        this.hOa = 0;
        this.hNU = com.baidu.adp.lib.util.l.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.hNU;
        this.hNx = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.ciq);
        this.hOa = com.baidu.adp.lib.util.l.ah(this.hNx) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hNy = new o(pbActivity, PostData.jgd);
        this.hNy.a(pbActivity);
        this.hNz = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.j.hJk);
        this.hNA = new ak(pbActivity, com.baidu.tieba.pb.data.i.hJe);
        this.hNB = new ak(pbActivity, com.baidu.tieba.pb.data.i.hJf);
        this.hNC = new i(pbActivity, PostData.jge);
        this.hNC.a(pbActivity);
        this.gkL = com.baidu.tieba.recapp.r.chV().a(pbActivity, AdvertAppInfo.bEI);
        this.hNE = com.baidu.tieba.recapp.r.chV().a(pbActivity, AdvertAppInfo.bEM);
        this.hNI = new v(pbActivity, com.baidu.tieba.pb.data.a.hIc);
        this.hNJ = new ae(pbActivity, com.baidu.tieba.pb.data.h.hJc);
        this.hNF = new ag(pbActivity, ad.hSM);
        this.hNG = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bIa);
        this.hNK = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.jgj);
        this.hND = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.icO);
        this.hND.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hNM.bSW() != null) {
                    pbActivity.bUj().bXs().bTM();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
                }
            }
        });
        this.mAdapters.add(this.hNy);
        this.mAdapters.add(this.hNz);
        this.mAdapters.add(this.hNC);
        this.mAdapters.add(this.hNA);
        this.mAdapters.add(this.hNB);
        this.mAdapters.add(this.gkL);
        this.mAdapters.add(this.hNE);
        this.mAdapters.add(this.hNI);
        this.mAdapters.add(this.hNJ);
        this.mAdapters.add(this.hNF);
        this.mAdapters.add(this.hNG);
        this.mAdapters.add(this.hND);
        this.mAdapters.add(this.hNK);
        this.fBQ.setPriority(1);
        this.fBQ.setSelfListener(true);
        pbActivity.registerListener(this.fBQ);
        bxi();
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
        int i;
        boolean z4;
        boolean z5;
        com.baidu.adp.widget.ListView.m bVl;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hNM != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bSJ()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hNM = dVar;
            if (z6) {
                bVq();
                if (dVar != null) {
                    dVar.od(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hNM != null && this.hNM.bSN() != null && this.hNM.bSN().size() > 0) {
                this.postList.addAll(this.hNM.bSN());
            }
            if (dVar != null && dVar.bSL() != null && dVar.bSL().aey() != null) {
                this.mHostId = dVar.bSL().aey().getUserId();
            }
            if (this.hNy != null) {
                this.hNy.setData(dVar);
                this.hNy.setFromCDN(this.mIsFromCDN);
                this.hNy.xI(this.hNU);
                this.hNy.og(this.hNN);
                this.hNy.v(this.mCommonClickListener);
                this.hNy.N(this.hNW);
                this.hNy.setOnImageClickListener(this.cKo);
                this.hNy.setOnLongClickListener(this.cmF);
                this.hNy.setTbGestureDetector(this.clA);
                this.hNC.setData(dVar);
                this.hNC.setFromCDN(this.mIsFromCDN);
                this.hNC.setHostId(this.mHostId);
                this.hNC.og(this.hNN);
                this.hNC.v(this.mCommonClickListener);
                this.hNC.N(this.hNW);
                this.hNC.setOnImageClickListener(this.cKo);
                this.hNC.setOnLongClickListener(this.cmF);
                this.hNC.setTbGestureDetector(this.clA);
                this.hNz.setOnClickListener(this.mCommonClickListener);
                this.hNK.setOnClickListener(this.mCommonClickListener);
                if (this.hNE != null && (this.hNE instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hNE).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hNL.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.xI(this.hNU);
                        next.og(this.hNN);
                        next.oh(this.hNO);
                        next.oi(this.hNT);
                        next.v(this.mCommonClickListener);
                        next.N(this.hNW);
                        next.setOnImageClickListener(this.cKo);
                        next.setOnLongClickListener(this.cmF);
                    }
                }
                this.hNA.v(this.mCommonClickListener);
                this.hNB.v(this.mCommonClickListener);
                this.hNA.setData(dVar);
                this.hNB.setData(dVar);
                this.hNF.setData(dVar);
                this.hNG.setData(dVar);
                this.hNI.setData(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bSN());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cpL() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hNV = postData;
                }
                boolean z7 = false;
                if (!this.hNO && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bTj() && postData.cpN() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bSS() != null) {
                    postData = dVar.bSS();
                    z7 = true;
                    z2 = true;
                    if (!this.hNO && dVar.bTj() && postData.cpN() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dH(arrayList);
                if (this.hNx.bUI()) {
                    if (dVar.bSN().size() > 0 && (postData2 = dVar.bSN().get(0)) != null && postData2.cpL() == 1 && !com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hNM, arrayList, this.hNO);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.hNM.bSO());
                    }
                }
                int c = c(this.hNM, arrayList, this.hNO);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.hNM.bSP());
                }
                com.baidu.tieba.tbadkCore.s.p(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hJe);
                    if (dVar != null && dVar.bSL() != null) {
                        iVar.hJg = dVar.bSL().aep();
                    }
                    iVar.isNew = !this.hNO;
                    iVar.hJj = this.hNx.bUU();
                    iVar.sortType = dVar.hIM;
                    if (dVar.hIL != null && dVar.hIL.size() > dVar.hIM) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hIL.size()) {
                                break;
                            } else if (dVar.hIL.get(i3).sort_type.intValue() != dVar.hIM) {
                                i2 = i3 + 1;
                            } else {
                                iVar.hJi = dVar.hIL.get(i3).sort_name;
                                break;
                            }
                        }
                    }
                    com.baidu.tbadk.core.util.v.a(arrayList, c2, iVar);
                    z10 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.m> f = f(dVar);
                if (com.baidu.tbadk.core.util.v.aa(f) || b2 < 0) {
                    z3 = z10;
                } else {
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, b2);
                    if (mVar instanceof PostData) {
                        ((PostData) mVar).jgP = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) f);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hNO);
                }
                if (i < 0 || dVar.bTi() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, i, dVar.bTi());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bVl = bVl()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i + 1, bVl);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bVm = bVm();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bVm != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i4, bVm);
                    }
                }
                this.hNy.oy(!z4);
                boolean z12 = false;
                if (this.hNx.bTR() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hNx.bTR().getPostId())) {
                    z12 = true;
                }
                if (this.hNP && !z12) {
                    arrayList.remove(postData3);
                    this.hNP = false;
                }
                if (dVar.bTi() != null) {
                    if (z5) {
                        dVar.bTi().oe(false);
                    } else {
                        dVar.bTi().oe(true);
                    }
                }
                if (this.mListView != null) {
                    this.dPQ = arrayList;
                    this.mListView.setData(this.dPQ);
                }
                if (!z12 && !z && ((this.hNR || this.hNQ) && b2 != -1 && !com.baidu.tbadk.core.util.v.aa(f) && !this.hNS)) {
                    this.hNY = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + f.size(), 0 - f.this.hOa);
                            f.this.hNS = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.iK().post(this.hNY);
                }
                if (postData3 == null) {
                    if (this.hNV != null && !this.hNQ) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, this.hNV);
                    } else {
                        PostData postData4 = new PostData();
                        postData4.Bg(1);
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, postData4);
                    }
                    this.mListView.setData(arrayList);
                } else if (z9) {
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData3);
                    this.mListView.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m bVl() {
        PbModel bTR = this.hNx.bTR();
        if (bTR == null) {
            return null;
        }
        String bWz = bTR.bWz();
        if (TextUtils.isEmpty(bWz)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.EJ(bWz);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bVm() {
        if (this.hNM == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bVW = this.hNx.bTR().bVW();
        if (bVW == null) {
            bVW = this.hNM.bTa();
        }
        if (bVW != null) {
            AdvertAppInfo.ILegoAdvert cpA = bVW.cpA();
            if (cpA != null) {
                cpA.setAdvertAppInfo(bVW.ph());
            }
            int acH = bVW.cpz().acH();
            if (acH != 0) {
                a(bVW, acH);
                if (acH == 28 || acH == 31 || bVW.cpz().goods == null) {
                    return null;
                }
                bVW.cpz().goods.goods_style = -1001;
                return null;
            }
            if (this.hNM.getForum() != null) {
                bVW.forumId = this.hNM.getForum().getId();
            }
            if (this.hNM.bSL() != null) {
                bVW.threadId = com.baidu.adp.lib.g.b.c(this.hNM.bSL().getId(), 0L);
            }
            if (this.hNM != null && this.hNM.getPage() != null) {
                bVW.pageNumber = this.hNM.getPage().adq();
            }
            c(bVW);
            return bVW;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hNQ || dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bSN()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bTj() && this.hNO) ? 0 : -1;
        } else if (this.hNx.bTR() == null || !this.hNx.bTR().getIsFromMark()) {
            if (this.hNx.bUj() == null || !this.hNx.bUj().bYu()) {
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
                        if (postData.cpL() == 1 && postData.jgM == 0) {
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
                return dVar.bTj() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bSN()) || com.baidu.tbadk.core.util.v.aa(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.bSN(), 0)) == null) {
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
                if (postData.cpL() == 1 && postData.jgM == 0) {
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

    private int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bSN()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bTj()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bSN().get(0) == null || dVar.bSN().get(0).cpL() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bSW() == null || com.baidu.tbadk.core.util.v.aa(dVar.bSW().hJu)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bSW().hJu;
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.jgZ = true;
                postData.jgO = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.Z(dVar.bSW().hJv) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).jgO = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).jgO = true;
            }
        }
        com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hJf);
        iVar.hJh = dVar.bSW().forum_top_list;
        arrayList.add(0, iVar);
        return arrayList;
    }

    private void bxi() {
        if (this.hNx != null && !bxj()) {
            this.hNx.registerListener(this.fLX);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bxj() {
        if (this.hNx == null) {
            return false;
        }
        this.fLV = new ArrayList();
        ArrayList<BdUniqueId> coY = com.baidu.tieba.tbadkCore.s.coY();
        if (coY == null || coY.size() <= 0) {
            return false;
        }
        int size = coY.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bLR().a(this.hNx.getPageContext(), coY.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.fLV.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fLV)) {
            this.mListView.addAdapters(this.fLV);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bSN() == null || dVar.bSO() == null || dVar.bSN().size() == 0 || dVar.bSL() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bSO().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bSN().get(0) == null || dVar.bSN().get(0).cpL() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().adq() != dVar.getPage().adn()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bSN() == null || dVar.bSP() == null || dVar.bSN().size() == 0 || dVar.bSL() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bSP().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bSN().get(0) == null || dVar.bSN().get(0).cpL() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().adq() != dVar.getPage().adn()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bVn() {
        return this.postList;
    }

    public BdUniqueId xP(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hNH == null || !this.hNH.bTK()) {
            this.hNZ = bVo();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bVo() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.mListView.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.i.hJe) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bVp() {
        return this.hNZ;
    }

    private void bVq() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hNM != null) {
            ArrayList<PostData> bSN = this.hNM.bSN();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bSZ = this.hNM.bSZ();
            if (bSZ != null) {
                int size = bSZ.size();
                if (bSN != null && bSN.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bSZ.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bSZ.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fLT = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bSZ.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cpz() != null) {
                            int acH = next3.cpz().acH();
                            if (acH != 0) {
                                a(next3, acH);
                                if (acH != 28 && acH != 31) {
                                    if (next3.cpz().goods != null) {
                                        next3.cpz().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.w.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cpz().apk_name)) {
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
                        if (this.hNM.getForum() != null) {
                            mVar4.forumId = this.hNM.getForum().getId();
                        }
                        if (this.hNM.bSL() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.c(this.hNM.bSL().getId(), 0L);
                        }
                        if (this.hNM != null && this.hNM.getPage() != null) {
                            mVar4.pageNumber = this.hNM.getPage().adq();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bSN.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hNO) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bSN.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hNx.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", mVar4.cpz().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.zI(i);
        com.baidu.tieba.recapp.report.c.ciQ().a(c);
        if (mVar != null && mVar.cpz() != null) {
            mVar.cpz().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cpz() != null && mVar.cpz().goods != null && mVar.cpz().goods.goods_style != 1001 && mVar.cpz().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hNM != null && mVar.cpz() != null) {
            mVar.cpz().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hNM.getPage() != null) {
                mVar.cpz().advertAppContext.pn = this.hNM.getPage().adq();
            }
            mVar.cpz().advertAppContext.page = mVar.cpC();
            if (this.hNM.getForum() != null && (forum = this.hNM.getForum()) != null) {
                mVar.cpz().advertAppContext.fid = forum.getId();
                mVar.cpz().advertAppContext.bEz = forum.getFirst_class();
                mVar.cpz().advertAppContext.bEA = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cpz().advertAppContext.bEB = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cpz().advertAppContext.extensionInfo = mVar.cpz().ext_info;
            mVar.cpz().advertAppContext.Rn = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hNy.setFromCDN(z);
        if (this.hNE != null && (this.hNE instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hNE).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hNL.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bVr() {
        return this.hNN;
    }

    public void og(boolean z) {
        this.hNN = z;
    }

    public void oh(boolean z) {
        this.hNO = z;
    }

    public void oi(boolean z) {
        this.hNT = z;
    }

    public void N(View.OnClickListener onClickListener) {
        this.hNW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKo = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.clA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmF = onLongClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void xQ(int i) {
        switch (i) {
            case 1:
                if (this.hNH != null) {
                    this.hNH.pause();
                }
                if (this.hNy != null) {
                    this.hNy.pause();
                    return;
                }
                return;
            case 2:
                if (this.hNH != null) {
                    this.hNH.resume();
                }
                if (this.hNy != null) {
                    this.hNy.resume();
                    return;
                }
                return;
            case 3:
                if (this.hNH != null) {
                    this.hNH.release();
                }
                if (this.hNy != null) {
                    this.hNy.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dH(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.afA())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.mq(postData.afA());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hNY);
        if (this.hNA != null) {
            this.hNA.onDestroy();
        }
        if (this.hNB != null) {
            this.hNB.onDestroy();
        }
        if (this.hNz != null) {
            this.hNz.onDestroy();
        }
    }

    public void ot(boolean z) {
        this.hNQ = z;
    }

    public void ou(boolean z) {
        this.hNR = z;
    }

    public void ov(boolean z) {
        this.hNP = z;
    }

    public void ow(boolean z) {
        this.hNS = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bVs() {
        return this.hNz;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.dPQ;
    }

    public View bVt() {
        if (this.hNy == null || this.hNy.bVx() == null) {
            return null;
        }
        if (this.hNy.bVx().hPx != null && this.hNy.bVx().hPx.isShown()) {
            return this.hNy.bVx().hPx;
        }
        return this.hNy.bVx().hPw;
    }

    public p bVu() {
        if (this.hNy == null || this.hNy.bVx() == null) {
            return null;
        }
        return this.hNy.bVx();
    }
}
