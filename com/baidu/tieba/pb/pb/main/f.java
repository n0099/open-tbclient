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
    private ArrayList<com.baidu.adp.widget.ListView.h> cnn;
    private List<com.baidu.adp.widget.ListView.a> dTe;
    private com.baidu.adp.widget.ListView.a ebN;
    private com.baidu.adp.widget.ListView.a ebO;
    private PbActivity fYJ;
    private o fYK;
    private com.baidu.tieba.pb.pb.main.a.a fYL;
    private ak fYM;
    private ak fYN;
    private i fYO;
    private com.baidu.tieba.pb.video.a fYP;
    private ag fYQ;
    private ah fYR;
    private com.baidu.tieba.pb.pb.a.b fYS;
    private v fYT;
    private ae fYU;
    private com.baidu.tieba.pb.pb.a.d fYV;
    private ao fYW;
    private com.baidu.tieba.pb.data.d fYY;
    private boolean fZd;
    private boolean fZe;
    private int fZg;
    private Runnable fZj;
    private int fZl;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fYX = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fYZ = true;
    private boolean fZa = true;
    private boolean fZb = false;
    private boolean fZc = false;
    private boolean fZf = false;
    private String mHostId = null;
    private View.OnClickListener fZh = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bsD = null;
    private com.baidu.tieba.pb.a.c bsE = null;
    private View.OnLongClickListener aTZ = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fZi = new ArrayList();
    private int fZk = -1;
    private CustomMessageListener dSg = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bEs = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bEs();
                Iterator it = bEs.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).aq(f.this.fYJ);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fYX.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fYS = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bEs);
                f.this.fZi.clear();
                f.this.fZi.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener aQA = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fYY != null && !com.baidu.adp.base.i.aI(f.this.fYJ.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener dTn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.I(f.this.dTe)) {
                f.this.aEW();
                f.this.a(f.this.fYY, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fZg = 0;
        this.width = -1;
        this.fZl = 0;
        this.fZg = com.baidu.adp.lib.util.l.aO(pbActivity.getPageContext().getPageActivity());
        this.width = this.fZg;
        this.fYJ = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aQA);
        this.fZl = com.baidu.adp.lib.util.l.aQ(this.fYJ) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fYK = new o(pbActivity, PostData.hpC);
        this.fYK.a(pbActivity);
        this.fYL = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.i.fUz);
        this.fYM = new ak(pbActivity, com.baidu.tieba.pb.data.h.fUt);
        this.fYN = new ak(pbActivity, com.baidu.tieba.pb.data.h.fUu);
        this.fYO = new i(pbActivity, PostData.hpD);
        this.fYO.a(pbActivity);
        this.ebN = com.baidu.tieba.recapp.r.bvT().a(pbActivity, AdvertAppInfo.apG);
        this.ebO = com.baidu.tieba.recapp.r.bvT().a(pbActivity, AdvertAppInfo.apK);
        this.fYT = new v(pbActivity, com.baidu.tieba.pb.data.a.fTy);
        this.fYU = new ae(pbActivity, com.baidu.tieba.pb.data.g.fUs);
        this.fYQ = new ag(pbActivity, ad.gee);
        this.fYR = new ah(pbActivity, com.baidu.tbadk.core.data.ao.asT);
        this.fYV = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.hpH);
        this.fYW = new ao(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fYP = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.gnH);
        this.fYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fYY.bhK() != null) {
                    pbActivity.biU().bmb().biy();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fYK);
        this.mAdapters.add(this.fYL);
        this.mAdapters.add(this.fYO);
        this.mAdapters.add(this.fYM);
        this.mAdapters.add(this.fYN);
        this.mAdapters.add(this.ebN);
        this.mAdapters.add(this.ebO);
        this.mAdapters.add(this.fYT);
        this.mAdapters.add(this.fYU);
        this.mAdapters.add(this.fYQ);
        this.mAdapters.add(this.fYR);
        this.mAdapters.add(this.fYP);
        this.mAdapters.add(this.fYV);
        this.mAdapters.add(this.fYW);
        this.dSg.setPriority(1);
        this.dSg.setSelfListener(true);
        pbActivity.registerListener(this.dSg);
        aEV();
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
        com.baidu.adp.widget.ListView.h bjV;
        PostData postData3;
        if (dVar != null) {
            boolean z7 = false;
            if (this.fYY != dVar) {
                z7 = true;
                if ((dVar != null && !dVar.bhw()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z7 = false;
                }
            }
            this.fYY = dVar;
            if (z7) {
                bka();
                if (dVar != null) {
                    dVar.ky(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fYY != null && this.fYY.bhB() != null && this.fYY.bhB().size() > 0) {
                this.postList.addAll(this.fYY.bhB());
            }
            if (dVar != null && dVar.bhz() != null && dVar.bhz().zT() != null) {
                this.mHostId = dVar.bhz().zT().getUserId();
            }
            if (this.fYK != null) {
                this.fYK.b(dVar);
                this.fYK.setFromCDN(this.mIsFromCDN);
                this.fYK.setImageMaxWidth(this.fZg);
                this.fYK.kC(this.fYZ);
                this.fYK.s(this.mCommonClickListener);
                this.fYK.I(this.fZh);
                this.fYK.setOnImageClickListener(this.bsD);
                this.fYK.setOnLongClickListener(this.aTZ);
                this.fYK.setTbGestureDetector(this.bsE);
                this.fYO.b(dVar);
                this.fYO.setFromCDN(this.mIsFromCDN);
                this.fYO.setHostId(this.mHostId);
                this.fYO.kC(this.fYZ);
                this.fYO.s(this.mCommonClickListener);
                this.fYO.I(this.fZh);
                this.fYO.setOnImageClickListener(this.bsD);
                this.fYO.setOnLongClickListener(this.aTZ);
                this.fYO.setTbGestureDetector(this.bsE);
                this.fYL.setOnClickListener(this.mCommonClickListener);
                this.fYV.setOnClickListener(this.mCommonClickListener);
                if (this.ebO != null && (this.ebO instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.ebO).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fYX.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.setImageMaxWidth(this.fZg);
                        next.kC(this.fYZ);
                        next.kD(this.fZa);
                        next.kE(this.fZf);
                        next.s(this.mCommonClickListener);
                        next.I(this.fZh);
                        next.setOnImageClickListener(this.bsD);
                        next.setOnLongClickListener(this.aTZ);
                    }
                }
                this.fYM.s(this.mCommonClickListener);
                this.fYN.s(this.mCommonClickListener);
                this.fYQ.b(dVar);
                this.fYR.b(dVar);
                this.fYT.b(dVar);
                this.fYW.b(dVar);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.bhB());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bES() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (this.fZa || postData == null) {
                    z3 = z2;
                    z4 = false;
                } else {
                    arrayList.remove(postData);
                    z4 = true;
                    z3 = true;
                    if (dVar.bhY() && postData.bEU() != null) {
                        postData.c(null);
                    }
                }
                if (z3 || dVar.bhG() == null) {
                    z5 = z3;
                    postData2 = postData;
                } else {
                    PostData bhG = dVar.bhG();
                    if (!this.fZa && dVar.bhY() && bhG.bEU() != null) {
                        bhG.c(null);
                    }
                    z5 = true;
                    postData2 = bhG;
                    z4 = true;
                }
                dn(arrayList);
                if (this.fYJ.bjt()) {
                    if (dVar.bhB().size() > 0 && (postData3 = dVar.bhB().get(0)) != null && postData3.bES() == 1 && !com.baidu.tbadk.core.util.v.I(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.fYY, arrayList, this.fZa);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.fYY.bhC());
                    }
                }
                int c = c(this.fYY, arrayList, this.fZa);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.fYY.bhD());
                }
                if (arrayList.size() == 0 && this.fYJ.bjt()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.q(arrayList, 1);
                boolean z8 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fUt);
                    if (dVar != null && dVar.bhz() != null) {
                        hVar.fUv = dVar.bhz().zK();
                    }
                    hVar.isNew = !this.fZa;
                    hVar.fUy = this.fYJ.bjF();
                    hVar.sortType = dVar.fUk;
                    if (dVar.fUj != null && dVar.fUj.size() > dVar.fUk) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= dVar.fUj.size()) {
                                break;
                            } else if (dVar.fUj.get(i2).sort_type.intValue() != dVar.fUk) {
                                i = i2 + 1;
                            } else {
                                hVar.fUx = dVar.fUj.get(i2).sort_name;
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
                        ((PostData) hVar2).hqm = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z6 = true;
                }
                int i3 = -1;
                boolean z9 = false;
                if (z5) {
                    i3 = a(dVar, arrayList, this.fZa);
                }
                if (i3 >= 0 && dVar.bhX() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, dVar.bhX());
                    z6 = true;
                    z9 = true;
                }
                boolean z10 = false;
                if (!this.fYJ.bjC() && this.fYY != null && this.fYY.bhx() != null && !StringUtils.isNull(this.fYY.bhx().getName()) && !StringUtils.isNull(this.fYY.bhx().getId())) {
                    i3++;
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, this.fYY.bhx());
                    z10 = true;
                    if (this.fYW != null && this.fYY.bhz() != null) {
                        this.fYW.setThreadId(this.fYY.bhz().getId());
                    }
                }
                int i4 = i3;
                boolean z11 = z10;
                boolean z12 = false;
                if (z5 && (bjV = bjV()) != null && i4 >= 0) {
                    z12 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i4 + 1, bjV);
                }
                if (z5 && !z12) {
                    com.baidu.adp.widget.ListView.h bjW = bjW();
                    int i5 = -1;
                    if (i4 >= 0) {
                        i5 = i4 + 1;
                    } else if (b2 >= 0) {
                        i5 = b2;
                    } else if (c2 >= 0) {
                        i5 = c2;
                    }
                    if (bjW != null && i5 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i5, bjW);
                    }
                }
                this.fYK.kT(!z6);
                boolean z13 = false;
                if (this.fYJ.biD() != null && postData2 != null && postData2.getId() != null && postData2.getId().equals(this.fYJ.biD().getPostId())) {
                    z13 = true;
                }
                if (this.fZb && !z13) {
                    arrayList.remove(postData2);
                    this.fZb = false;
                }
                if (dVar.bhX() != null) {
                    if (z9 && !z11) {
                        dVar.bhX().kz(false);
                    } else {
                        dVar.bhX().kz(true);
                    }
                }
                if (this.mListView != null) {
                    this.cnn = arrayList;
                    this.mListView.setData(this.cnn);
                }
                if (!z13 && !z && ((this.fZd || this.fZc) && b2 != -1 && !com.baidu.tbadk.core.util.v.I(g) && !this.fZe)) {
                    this.fZj = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fZl);
                            f.this.fZe = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.jG().post(this.fZj);
                }
                if (postData2 == null) {
                    PostData postData4 = new PostData();
                    postData4.vL(1);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData4);
                    this.mListView.setData(arrayList);
                } else if (z4) {
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData2);
                    this.mListView.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h bjV() {
        PbModel biD = this.fYJ.biD();
        if (biD == null) {
            return null;
        }
        String blh = biD.blh();
        if (TextUtils.isEmpty(blh)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.vV(blh);
        c(lVar);
        return lVar;
    }

    private com.baidu.adp.widget.ListView.h bjW() {
        if (this.fYY == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l bkF = this.fYJ.biD().bkF();
        if (bkF == null) {
            bkF = this.fYY.bhP();
        }
        if (bkF != null) {
            AdvertAppInfo.ILegoAdvert bEH = bkF.bEH();
            if (bEH != null) {
                bEH.setAdvertAppInfo(bkF.py());
            }
            int yp = bkF.bEG().yp();
            if (yp != 0) {
                a(bkF, yp);
                if (yp == 28 || yp == 31 || bkF.bEG().goods == null) {
                    return null;
                }
                bkF.bEG().goods.goods_style = -1001;
                return null;
            }
            if (this.fYY.bhx() != null) {
                bkF.forumId = this.fYY.bhx().getId();
            }
            if (this.fYY.bhz() != null) {
                bkF.threadId = com.baidu.adp.lib.g.b.d(this.fYY.bhz().getId(), 0L);
            }
            if (this.fYY != null && this.fYY.zf() != null) {
                bkF.pageNumber = this.fYY.zf().za();
            }
            c(bkF);
            return bkF;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fZc || dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bhB()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bhY() && this.fZa) ? 0 : -1;
        } else if (this.fYJ.biD() == null || !this.fYJ.biD().getIsFromMark()) {
            if (this.fYJ.biU() == null || !this.fYJ.biU().bnc()) {
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
                        if (postData.bES() == 1 && postData.hqj == 0) {
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
                return dVar.bhY() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bhB()) || com.baidu.tbadk.core.util.v.I(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.d(dVar.bhB(), 0)) == null) {
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
                if (postData.bES() == 1 && postData.hqj == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bhB()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bhY()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bhB().get(0) == null || dVar.bhB().get(0).bES() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bhK() == null || com.baidu.tbadk.core.util.v.I(dVar.bhK().fUJ)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bhK().fUJ;
        if (com.baidu.tbadk.core.util.v.I(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.hqt = true;
                postData.hql = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.H(dVar.bhK().fUK) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).hql = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).hql = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fUu);
        hVar3.fUw = dVar.bhK().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void aEV() {
        if (this.fYJ != null && !aEW()) {
            this.fYJ.registerListener(this.dTn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aEW() {
        if (this.fYJ == null) {
            return false;
        }
        this.dTe = new ArrayList();
        ArrayList<BdUniqueId> bEf = com.baidu.tieba.tbadkCore.q.bEf();
        if (bEf == null || bEf.size() <= 0) {
            return false;
        }
        int size = bEf.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.baI().a(this.fYJ.getPageContext(), bEf.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dTe.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.I(this.dTe)) {
            this.mListView.addAdapters(this.dTe);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bhB() == null || dVar.bhC() == null || dVar.bhB().size() == 0 || dVar.bhz() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bhC().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bhB().get(0) == null || dVar.bhB().get(0).bES() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.zf() == null || dVar.zf().za() != dVar.zf().yX()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bhB() == null || dVar.bhD() == null || dVar.bhB().size() == 0 || dVar.bhz() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bhD().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bhB().get(0) == null || dVar.bhB().get(0).bES() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.zf() == null || dVar.zf().za() != dVar.zf().yX()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bjX() {
        return this.postList;
    }

    public BdUniqueId sy(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fYS == null || !this.fYS.biw()) {
            this.fZk = bjY();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bjY() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fUt) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bjZ() {
        return this.fZk;
    }

    private void bka() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fYY != null) {
            ArrayList<PostData> bhB = this.fYY.bhB();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> bhO = this.fYY.bhO();
            if (bhO != null) {
                int size = bhO.size();
                if (bhB != null && bhB.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = bhO.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = bhO.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.ecq = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = bhO.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bEG() != null) {
                            int yp = next3.bEG().yp();
                            if (yp != 0) {
                                a(next3, yp);
                                if (yp != 28 && yp != 31) {
                                    if (next3.bEG().goods != null) {
                                        next3.bEG().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bEG().apk_name)) {
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
                        if (this.fYY.bhx() != null) {
                            lVar4.forumId = this.fYY.bhx().getId();
                        }
                        if (this.fYY.bhz() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.d(this.fYY.bhz().getId(), 0L);
                        }
                        if (this.fYY != null && this.fYY.zf() != null) {
                            lVar4.pageNumber = this.fYY.zf().za();
                        }
                        c(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= bhB.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fZa) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        bhB.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fYJ.getPageContext().getContext(), "pb_show_app", "", 1, AiAppsApsUtils.APP_NAME, lVar4.bEG().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, 5);
        c.ul(i);
        com.baidu.tieba.recapp.report.c.bwO().a(c);
        if (lVar != null && lVar.bEG() != null) {
            lVar.bEG().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bEG() != null && lVar.bEG().goods != null && lVar.bEG().goods.goods_style != 1001 && lVar.bEG().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData bhx;
        if (lVar != null && this.fYY != null && lVar.bEG() != null) {
            lVar.bEG().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fYY.zf() != null) {
                lVar.bEG().advertAppContext.pn = this.fYY.zf().za();
            }
            lVar.bEG().advertAppContext.page = lVar.bEJ();
            if (this.fYY.bhx() != null && (bhx = this.fYY.bhx()) != null) {
                lVar.bEG().advertAppContext.fid = bhx.getId();
                lVar.bEG().advertAppContext.apy = bhx.getFirst_class();
                lVar.bEG().advertAppContext.apz = bhx.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bEG().advertAppContext.apA = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bEG().advertAppContext.extensionInfo = lVar.bEG().ext_info;
            lVar.bEG().advertAppContext.Sc = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fYK.setFromCDN(z);
        if (this.ebO != null && (this.ebO instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ebO).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fYX.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bkb() {
        return this.fYZ;
    }

    public void kC(boolean z) {
        this.fYZ = z;
    }

    public void kD(boolean z) {
        this.fZa = z;
    }

    public void kE(boolean z) {
        this.fZf = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fZh = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bsD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bsE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTZ = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void sz(int i) {
        switch (i) {
            case 1:
                if (this.fYS != null) {
                    this.fYS.pause();
                }
                if (this.fYK != null) {
                    this.fYK.pause();
                    return;
                }
                return;
            case 2:
                if (this.fYS != null) {
                    this.fYS.resume();
                }
                if (this.fYK != null) {
                    this.fYK.resume();
                    return;
                }
                return;
            case 3:
                if (this.fYS != null) {
                    this.fYS.release();
                }
                if (this.fYK != null) {
                    this.fYK.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dn(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.AN())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.eq(postData.AN());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fZj);
        if (this.fYM != null) {
            this.fYM.onDestroy();
        }
        if (this.fYN != null) {
            this.fYN.onDestroy();
        }
        if (this.fYL != null) {
            this.fYL.onDestroy();
        }
    }

    public void kP(boolean z) {
        this.fZc = z;
    }

    public void kQ(boolean z) {
        this.fZd = z;
    }

    public void kR(boolean z) {
        this.fZb = z;
    }

    public void kS(boolean z) {
        this.fZe = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bkc() {
        return this.fYL;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.cnn;
    }
}
