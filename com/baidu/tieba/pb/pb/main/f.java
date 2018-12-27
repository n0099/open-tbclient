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
    private List<com.baidu.adp.widget.ListView.a> dSv;
    private com.baidu.adp.widget.ListView.a ebh;
    private com.baidu.adp.widget.ListView.a ebi;
    private PbActivity fXM;
    private o fXN;
    private com.baidu.tieba.pb.pb.main.a.a fXO;
    private ak fXP;
    private ak fXQ;
    private i fXR;
    private com.baidu.tieba.pb.video.a fXS;
    private ag fXT;
    private ah fXU;
    private com.baidu.tieba.pb.pb.a.b fXV;
    private v fXW;
    private ae fXX;
    private com.baidu.tieba.pb.pb.a.d fXY;
    private ao fXZ;
    private com.baidu.tieba.pb.data.d fYb;
    private boolean fYg;
    private boolean fYh;
    private int fYj;
    private Runnable fYm;
    private int fYo;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fYa = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fYc = true;
    private boolean fYd = true;
    private boolean fYe = false;
    private boolean fYf = false;
    private boolean fYi = false;
    private String mHostId = null;
    private View.OnClickListener fYk = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h brP = null;
    private com.baidu.tieba.pb.a.c brQ = null;
    private View.OnLongClickListener aTr = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fYl = new ArrayList();
    private int fYn = -1;
    private CustomMessageListener dRx = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bDJ = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bDJ();
                Iterator it = bDJ.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).aq(f.this.fXM);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fYa.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fXV = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bDJ);
                f.this.fYl.clear();
                f.this.fYl.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener aPW = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fYb != null && !com.baidu.adp.base.i.aI(f.this.fXM.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener dSF = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.I(f.this.dSv)) {
                f.this.aEz();
                f.this.a(f.this.fYb, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fYj = 0;
        this.width = -1;
        this.fYo = 0;
        this.fYj = com.baidu.adp.lib.util.l.aO(pbActivity.getPageContext().getPageActivity());
        this.width = this.fYj;
        this.fXM = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aPW);
        this.fYo = com.baidu.adp.lib.util.l.aQ(this.fXM) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fXN = new o(pbActivity, PostData.hox);
        this.fXN.a(pbActivity);
        this.fXO = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.i.fTC);
        this.fXP = new ak(pbActivity, com.baidu.tieba.pb.data.h.fTw);
        this.fXQ = new ak(pbActivity, com.baidu.tieba.pb.data.h.fTx);
        this.fXR = new i(pbActivity, PostData.hoy);
        this.fXR.a(pbActivity);
        this.ebh = com.baidu.tieba.recapp.r.bvk().a(pbActivity, AdvertAppInfo.apd);
        this.ebi = com.baidu.tieba.recapp.r.bvk().a(pbActivity, AdvertAppInfo.aph);
        this.fXW = new v(pbActivity, com.baidu.tieba.pb.data.a.fSB);
        this.fXX = new ae(pbActivity, com.baidu.tieba.pb.data.g.fTv);
        this.fXT = new ag(pbActivity, ad.gdg);
        this.fXU = new ah(pbActivity, com.baidu.tbadk.core.data.ao.asr);
        this.fXY = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.hoC);
        this.fXZ = new ao(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fXS = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.gmE);
        this.fXS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fYb.bhg() != null) {
                    pbActivity.biq().blt().bhU();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fXN);
        this.mAdapters.add(this.fXO);
        this.mAdapters.add(this.fXR);
        this.mAdapters.add(this.fXP);
        this.mAdapters.add(this.fXQ);
        this.mAdapters.add(this.ebh);
        this.mAdapters.add(this.ebi);
        this.mAdapters.add(this.fXW);
        this.mAdapters.add(this.fXX);
        this.mAdapters.add(this.fXT);
        this.mAdapters.add(this.fXU);
        this.mAdapters.add(this.fXS);
        this.mAdapters.add(this.fXY);
        this.mAdapters.add(this.fXZ);
        this.dRx.setPriority(1);
        this.dRx.setSelfListener(true);
        pbActivity.registerListener(this.dRx);
        aEy();
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
        com.baidu.adp.widget.ListView.h bjr;
        PostData postData3;
        if (dVar != null) {
            boolean z7 = false;
            if (this.fYb != dVar) {
                z7 = true;
                if ((dVar != null && !dVar.bgS()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z7 = false;
                }
            }
            this.fYb = dVar;
            if (z7) {
                bjw();
                if (dVar != null) {
                    dVar.ky(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fYb != null && this.fYb.bgX() != null && this.fYb.bgX().size() > 0) {
                this.postList.addAll(this.fYb.bgX());
            }
            if (dVar != null && dVar.bgV() != null && dVar.bgV().zG() != null) {
                this.mHostId = dVar.bgV().zG().getUserId();
            }
            if (this.fXN != null) {
                this.fXN.b(dVar);
                this.fXN.setFromCDN(this.mIsFromCDN);
                this.fXN.setImageMaxWidth(this.fYj);
                this.fXN.kC(this.fYc);
                this.fXN.s(this.mCommonClickListener);
                this.fXN.I(this.fYk);
                this.fXN.setOnImageClickListener(this.brP);
                this.fXN.setOnLongClickListener(this.aTr);
                this.fXN.setTbGestureDetector(this.brQ);
                this.fXR.b(dVar);
                this.fXR.setFromCDN(this.mIsFromCDN);
                this.fXR.setHostId(this.mHostId);
                this.fXR.kC(this.fYc);
                this.fXR.s(this.mCommonClickListener);
                this.fXR.I(this.fYk);
                this.fXR.setOnImageClickListener(this.brP);
                this.fXR.setOnLongClickListener(this.aTr);
                this.fXR.setTbGestureDetector(this.brQ);
                this.fXO.setOnClickListener(this.mCommonClickListener);
                this.fXY.setOnClickListener(this.mCommonClickListener);
                if (this.ebi != null && (this.ebi instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.ebi).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fYa.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.setImageMaxWidth(this.fYj);
                        next.kC(this.fYc);
                        next.kD(this.fYd);
                        next.kE(this.fYi);
                        next.s(this.mCommonClickListener);
                        next.I(this.fYk);
                        next.setOnImageClickListener(this.brP);
                        next.setOnLongClickListener(this.aTr);
                    }
                }
                this.fXP.s(this.mCommonClickListener);
                this.fXQ.s(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.bgX());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bEj() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (this.fYd || postData == null) {
                    z3 = z2;
                    z4 = false;
                } else {
                    arrayList.remove(postData);
                    z4 = true;
                    z3 = true;
                    if (dVar.bhu() && postData.bEl() != null) {
                        postData.c(null);
                    }
                }
                if (z3 || dVar.bhc() == null) {
                    z5 = z3;
                    postData2 = postData;
                } else {
                    PostData bhc = dVar.bhc();
                    if (!this.fYd && dVar.bhu() && bhc.bEl() != null) {
                        bhc.c(null);
                    }
                    z5 = true;
                    postData2 = bhc;
                    z4 = true;
                }
                dm(arrayList);
                if (this.fXM.biP()) {
                    if (dVar.bgX().size() > 0 && (postData3 = dVar.bgX().get(0)) != null && postData3.bEj() == 1 && !com.baidu.tbadk.core.util.v.I(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.fYb, arrayList, this.fYd);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.fYb.bgY());
                    }
                }
                int c = c(this.fYb, arrayList, this.fYd);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.fYb.bgZ());
                }
                if (arrayList.size() == 0 && this.fXM.biP()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.q(arrayList, 1);
                boolean z8 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fTw);
                    if (dVar != null && dVar.bgV() != null) {
                        hVar.fTy = dVar.bgV().zx();
                    }
                    hVar.isNew = !this.fYd;
                    hVar.fTB = this.fXM.bjb();
                    hVar.sortType = dVar.fTn;
                    if (dVar.fTm != null && dVar.fTm.size() > dVar.fTn) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= dVar.fTm.size()) {
                                break;
                            } else if (dVar.fTm.get(i2).sort_type.intValue() != dVar.fTn) {
                                i = i2 + 1;
                            } else {
                                hVar.fTA = dVar.fTm.get(i2).sort_name;
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
                        ((PostData) hVar2).hph = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z6 = true;
                }
                int i3 = -1;
                boolean z9 = false;
                if (z5) {
                    i3 = a(dVar, arrayList, this.fYd);
                }
                if (i3 >= 0 && dVar.bht() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, dVar.bht());
                    z6 = true;
                    z9 = true;
                }
                boolean z10 = false;
                if (!this.fXM.biY() && this.fYb != null && this.fYb.bgT() != null && !StringUtils.isNull(this.fYb.bgT().getName()) && !StringUtils.isNull(this.fYb.bgT().getId())) {
                    i3++;
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, this.fYb.bgT());
                    z10 = true;
                    if (this.fXZ != null && this.fYb.bgV() != null) {
                        this.fXZ.setThreadId(this.fYb.bgV().getId());
                    }
                }
                int i4 = i3;
                boolean z11 = z10;
                boolean z12 = false;
                if (z5 && (bjr = bjr()) != null && i4 >= 0) {
                    z12 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i4 + 1, bjr);
                }
                if (z5 && !z12) {
                    com.baidu.adp.widget.ListView.h bjs = bjs();
                    int i5 = -1;
                    if (i4 >= 0) {
                        i5 = i4 + 1;
                    } else if (b2 >= 0) {
                        i5 = b2;
                    } else if (c2 >= 0) {
                        i5 = c2;
                    }
                    if (bjs != null && i5 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i5, bjs);
                    }
                }
                this.fXN.kT(!z6);
                boolean z13 = false;
                if (this.fXM.bhZ() != null && postData2 != null && postData2.getId() != null && postData2.getId().equals(this.fXM.bhZ().getPostId())) {
                    z13 = true;
                }
                if (this.fYe && !z13) {
                    arrayList.remove(postData2);
                    this.fYe = false;
                }
                if (dVar.bht() != null) {
                    if (z9 && !z11) {
                        dVar.bht().kz(false);
                    } else {
                        dVar.bht().kz(true);
                    }
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z13 && !z && ((this.fYg || this.fYf) && b2 != -1 && !com.baidu.tbadk.core.util.v.I(g) && !this.fYh)) {
                    this.fYm = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fYo);
                            f.this.fYh = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.jG().post(this.fYm);
                }
                if (postData2 == null) {
                    PostData postData4 = new PostData();
                    postData4.vI(1);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData4);
                    this.mListView.setData(arrayList);
                } else if (z4) {
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData2);
                    this.mListView.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h bjr() {
        PbModel bhZ = this.fXM.bhZ();
        if (bhZ == null) {
            return null;
        }
        String bkz = bhZ.bkz();
        if (TextUtils.isEmpty(bkz)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.vF(bkz);
        b(lVar);
        return lVar;
    }

    private com.baidu.adp.widget.ListView.h bjs() {
        com.baidu.tieba.tbadkCore.data.l bhl;
        if (this.fYb == null || (bhl = this.fYb.bhl()) == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bDY = bhl.bDY();
        if (bDY != null) {
            bDY.setAdvertAppInfo(bhl.pu());
        }
        int yc = bhl.bDX().yc();
        if (yc != 0) {
            a(bhl, yc);
            if (yc == 28 || yc == 31 || bhl.bDX().goods == null) {
                return null;
            }
            bhl.bDX().goods.goods_style = -1001;
            return null;
        }
        if (this.fYb.bgT() != null) {
            bhl.forumId = this.fYb.bgT().getId();
        }
        if (this.fYb.bgV() != null) {
            bhl.threadId = com.baidu.adp.lib.g.b.d(this.fYb.bgV().getId(), 0L);
        }
        if (this.fYb != null && this.fYb.yS() != null) {
            bhl.pageNumber = this.fYb.yS().yN();
        }
        b(bhl);
        return bhl;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fYf || dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bgX()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bhu() && this.fYd) ? 0 : -1;
        } else if (this.fXM.bhZ() == null || !this.fXM.bhZ().getIsFromMark()) {
            if (this.fXM.biq() == null || !this.fXM.biq().bmu()) {
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
                        if (postData.bEj() == 1 && postData.hpe == 0) {
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
                return dVar.bhu() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bgX()) || com.baidu.tbadk.core.util.v.I(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.d(dVar.bgX(), 0)) == null) {
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
                if (postData.bEj() == 1 && postData.hpe == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bgX()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bhu()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bgX().get(0) == null || dVar.bgX().get(0).bEj() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bhg() == null || com.baidu.tbadk.core.util.v.I(dVar.bhg().fTM)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bhg().fTM;
        if (com.baidu.tbadk.core.util.v.I(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.hpg = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.H(dVar.bhg().fTN) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).hpg = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).hpg = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fTx);
        hVar3.fTz = dVar.bhg().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void aEy() {
        if (this.fXM != null && !aEz()) {
            this.fXM.registerListener(this.dSF);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aEz() {
        if (this.fXM == null) {
            return false;
        }
        this.dSv = new ArrayList();
        ArrayList<BdUniqueId> bDw = com.baidu.tieba.tbadkCore.q.bDw();
        if (bDw == null || bDw.size() <= 0) {
            return false;
        }
        int size = bDw.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bai().a(this.fXM.getPageContext(), bDw.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dSv.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.I(this.dSv)) {
            this.mListView.addAdapters(this.dSv);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bgX() == null || dVar.bgY() == null || dVar.bgX().size() == 0 || dVar.bgV() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bgY().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bgX().get(0) == null || dVar.bgX().get(0).bEj() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.yS() == null || dVar.yS().yN() != dVar.yS().yK()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bgX() == null || dVar.bgZ() == null || dVar.bgX().size() == 0 || dVar.bgV() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bgZ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bgX().get(0) == null || dVar.bgX().get(0).bEj() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.yS() == null || dVar.yS().yN() != dVar.yS().yK()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bjt() {
        return this.postList;
    }

    public BdUniqueId su(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fXV == null || !this.fXV.bhS()) {
            this.fYn = bju();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bju() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fTw) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bjv() {
        return this.fYn;
    }

    private void bjw() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fYb != null) {
            ArrayList<PostData> bgX = this.fYb.bgX();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> bhk = this.fYb.bhk();
            if (bhk != null) {
                int size = bhk.size();
                if (bgX != null && bgX.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = bhk.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = bhk.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.ebK = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = bhk.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bDX() != null) {
                            int yc = next3.bDX().yc();
                            if (yc != 0) {
                                a(next3, yc);
                                if (yc != 28 && yc != 31) {
                                    if (next3.bDX().goods != null) {
                                        next3.bDX().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bDX().apk_name)) {
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
                        if (this.fYb.bgT() != null) {
                            lVar4.forumId = this.fYb.bgT().getId();
                        }
                        if (this.fYb.bgV() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.d(this.fYb.bgV().getId(), 0L);
                        }
                        if (this.fYb != null && this.fYb.yS() != null) {
                            lVar4.pageNumber = this.fYb.yS().yN();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= bgX.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fYd) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        bgX.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fXM.getPageContext().getContext(), "pb_show_app", "", 1, AiAppsApsUtils.APP_NAME, lVar4.bDX().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, 5);
        c.ui(i);
        com.baidu.tieba.recapp.report.c.bwf().a(c);
        if (lVar != null && lVar.bDX() != null) {
            lVar.bDX().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bDX() != null && lVar.bDX().goods != null && lVar.bDX().goods.goods_style != 1001 && lVar.bDX().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData bgT;
        if (lVar != null && this.fYb != null && lVar.bDX() != null) {
            lVar.bDX().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fYb.yS() != null) {
                lVar.bDX().advertAppContext.pn = this.fYb.yS().yN();
            }
            lVar.bDX().advertAppContext.page = lVar.bEa();
            if (this.fYb.bgT() != null && (bgT = this.fYb.bgT()) != null) {
                lVar.bDX().advertAppContext.fid = bgT.getId();
                lVar.bDX().advertAppContext.aoV = bgT.getFirst_class();
                lVar.bDX().advertAppContext.aoW = bgT.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bDX().advertAppContext.aoX = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bDX().advertAppContext.extensionInfo = lVar.bDX().ext_info;
            lVar.bDX().advertAppContext.RT = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fXN.setFromCDN(z);
        if (this.ebi != null && (this.ebi instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ebi).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fYa.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bjx() {
        return this.fYc;
    }

    public void kC(boolean z) {
        this.fYc = z;
    }

    public void kD(boolean z) {
        this.fYd = z;
    }

    public void kE(boolean z) {
        this.fYi = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fYk = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brP = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.brQ = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTr = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void sv(int i) {
        switch (i) {
            case 1:
                if (this.fXV != null) {
                    this.fXV.pause();
                }
                if (this.fXN != null) {
                    this.fXN.pause();
                    return;
                }
                return;
            case 2:
                if (this.fXV != null) {
                    this.fXV.resume();
                }
                if (this.fXN != null) {
                    this.fXN.resume();
                    return;
                }
                return;
            case 3:
                if (this.fXV != null) {
                    this.fXV.release();
                }
                if (this.fXN != null) {
                    this.fXN.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dm(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.AA())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.eh(postData.AA());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fYm);
        if (this.fXP != null) {
            this.fXP.onDestroy();
        }
        if (this.fXQ != null) {
            this.fXQ.onDestroy();
        }
        if (this.fXO != null) {
            this.fXO.onDestroy();
        }
    }

    public void kP(boolean z) {
        this.fYf = z;
    }

    public void kQ(boolean z) {
        this.fYg = z;
    }

    public void kR(boolean z) {
        this.fYe = z;
    }

    public void kS(boolean z) {
        this.fYh = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bjy() {
        return this.fXO;
    }
}
