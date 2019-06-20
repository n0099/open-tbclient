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
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
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
    private ArrayList<com.baidu.adp.widget.ListView.m> dMb;
    private List<com.baidu.adp.widget.ListView.a> fGj;
    private com.baidu.adp.widget.ListView.a gdJ;
    private com.baidu.tieba.pb.pb.a.b hGA;
    private v hGB;
    private ae hGC;
    private com.baidu.tieba.pb.pb.a.d hGD;
    private com.baidu.tieba.pb.data.d hGF;
    private boolean hGK;
    private boolean hGL;
    private int hGN;
    private Runnable hGR;
    private int hGT;
    private PbActivity hGq;
    private o hGr;
    private com.baidu.tieba.pb.pb.main.a.a hGs;
    private ak hGt;
    private ak hGu;
    private i hGv;
    private com.baidu.tieba.pb.video.a hGw;
    private com.baidu.adp.widget.ListView.a hGx;
    private ag hGy;
    private ah hGz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hGE = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hGG = true;
    private boolean hGH = true;
    private boolean hGI = false;
    private boolean hGJ = false;
    private boolean hGM = false;
    private String mHostId = null;
    private PostData hGO = null;
    private View.OnClickListener hGP = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h cIN = null;
    private com.baidu.tieba.pb.a.c ckh = null;
    private View.OnLongClickListener cll = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hGQ = new ArrayList();
    private int hGS = -1;
    private CustomMessageListener fwg = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList clX = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).clX();
                Iterator it = clX.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).au(f.this.hGq);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hGE.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hGA = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(clX);
                f.this.hGQ.clear();
                f.this.hGQ.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener chd = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hGF != null && !com.baidu.adp.base.i.Z(f.this.hGq.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener fGl = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.aa(f.this.fGj)) {
                f.this.bur();
                f.this.a(f.this.hGF, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hGN = 0;
        this.width = -1;
        this.hGT = 0;
        this.hGN = com.baidu.adp.lib.util.l.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.hGN;
        this.hGq = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.chd);
        this.hGT = com.baidu.adp.lib.util.l.ah(this.hGq) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hGr = new o(pbActivity, PostData.iYF);
        this.hGr.a(pbActivity);
        this.hGs = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.j.hCe);
        this.hGt = new ak(pbActivity, com.baidu.tieba.pb.data.i.hBY);
        this.hGu = new ak(pbActivity, com.baidu.tieba.pb.data.i.hBZ);
        this.hGv = new i(pbActivity, PostData.iYG);
        this.hGv.a(pbActivity);
        this.gdJ = com.baidu.tieba.recapp.r.ceM().a(pbActivity, AdvertAppInfo.bDH);
        this.hGx = com.baidu.tieba.recapp.r.ceM().a(pbActivity, AdvertAppInfo.bDL);
        this.hGB = new v(pbActivity, com.baidu.tieba.pb.data.a.hAW);
        this.hGC = new ae(pbActivity, com.baidu.tieba.pb.data.h.hBW);
        this.hGy = new ag(pbActivity, ad.hLE);
        this.hGz = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bGZ);
        this.hGD = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.iYL);
        this.hGw = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.hVE);
        this.hGw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hGF.bPX() != null) {
                    pbActivity.bRi().bUo().bQN();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.hGr);
        this.mAdapters.add(this.hGs);
        this.mAdapters.add(this.hGv);
        this.mAdapters.add(this.hGt);
        this.mAdapters.add(this.hGu);
        this.mAdapters.add(this.gdJ);
        this.mAdapters.add(this.hGx);
        this.mAdapters.add(this.hGB);
        this.mAdapters.add(this.hGC);
        this.mAdapters.add(this.hGy);
        this.mAdapters.add(this.hGz);
        this.mAdapters.add(this.hGw);
        this.mAdapters.add(this.hGD);
        this.fwg.setPriority(1);
        this.fwg.setSelfListener(true);
        pbActivity.registerListener(this.fwg);
        buq();
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
        com.baidu.adp.widget.ListView.m bSj;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hGF != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bPK()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hGF = dVar;
            if (z6) {
                bSo();
                if (dVar != null) {
                    dVar.nP(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hGF != null && this.hGF.bPO() != null && this.hGF.bPO().size() > 0) {
                this.postList.addAll(this.hGF.bPO());
            }
            if (dVar != null && dVar.bPM() != null && dVar.bPM().adv() != null) {
                this.mHostId = dVar.bPM().adv().getUserId();
            }
            if (this.hGr != null) {
                this.hGr.setData(dVar);
                this.hGr.setFromCDN(this.mIsFromCDN);
                this.hGr.xc(this.hGN);
                this.hGr.nS(this.hGG);
                this.hGr.v(this.mCommonClickListener);
                this.hGr.L(this.hGP);
                this.hGr.setOnImageClickListener(this.cIN);
                this.hGr.setOnLongClickListener(this.cll);
                this.hGr.setTbGestureDetector(this.ckh);
                this.hGv.setData(dVar);
                this.hGv.setFromCDN(this.mIsFromCDN);
                this.hGv.setHostId(this.mHostId);
                this.hGv.nS(this.hGG);
                this.hGv.v(this.mCommonClickListener);
                this.hGv.L(this.hGP);
                this.hGv.setOnImageClickListener(this.cIN);
                this.hGv.setOnLongClickListener(this.cll);
                this.hGv.setTbGestureDetector(this.ckh);
                this.hGs.setOnClickListener(this.mCommonClickListener);
                this.hGD.setOnClickListener(this.mCommonClickListener);
                if (this.hGx != null && (this.hGx instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hGx).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hGE.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.xc(this.hGN);
                        next.nS(this.hGG);
                        next.nT(this.hGH);
                        next.nU(this.hGM);
                        next.v(this.mCommonClickListener);
                        next.L(this.hGP);
                        next.setOnImageClickListener(this.cIN);
                        next.setOnLongClickListener(this.cll);
                    }
                }
                this.hGt.v(this.mCommonClickListener);
                this.hGu.v(this.mCommonClickListener);
                this.hGy.setData(dVar);
                this.hGz.setData(dVar);
                this.hGB.setData(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bPO());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cmx() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hGO = postData;
                }
                boolean z7 = false;
                if (!this.hGH && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bQk() && postData.cmz() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bPT() != null) {
                    postData = dVar.bPT();
                    z7 = true;
                    z2 = true;
                    if (!this.hGH && dVar.bQk() && postData.cmz() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dG(arrayList);
                if (this.hGq.bRH()) {
                    if (dVar.bPO().size() > 0 && (postData2 = dVar.bPO().get(0)) != null && postData2.cmx() == 1 && !com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hGF, arrayList, this.hGH);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.hGF.bPP());
                    }
                }
                int c = c(this.hGF, arrayList, this.hGH);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.hGF.bPQ());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hBY);
                    if (dVar != null && dVar.bPM() != null) {
                        iVar.hCa = dVar.bPM().adm();
                    }
                    iVar.isNew = !this.hGH;
                    iVar.hCd = this.hGq.bRT();
                    iVar.sortType = dVar.hBG;
                    if (dVar.hBF != null && dVar.hBF.size() > dVar.hBG) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hBF.size()) {
                                break;
                            } else if (dVar.hBF.get(i3).sort_type.intValue() != dVar.hBG) {
                                i2 = i3 + 1;
                            } else {
                                iVar.hCc = dVar.hBF.get(i3).sort_name;
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
                        ((PostData) mVar).iZr = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) f);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hGH);
                }
                if (i < 0 || dVar.bQj() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, i, dVar.bQj());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bSj = bSj()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i + 1, bSj);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bSk = bSk();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bSk != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i4, bSk);
                    }
                }
                this.hGr.ok(!z4);
                boolean z12 = false;
                if (this.hGq.bQS() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hGq.bQS().getPostId())) {
                    z12 = true;
                }
                if (this.hGI && !z12) {
                    arrayList.remove(postData3);
                    this.hGI = false;
                }
                if (dVar.bQj() != null) {
                    if (z5) {
                        dVar.bQj().nQ(false);
                    } else {
                        dVar.bQj().nQ(true);
                    }
                }
                if (this.mListView != null) {
                    this.dMb = arrayList;
                    this.mListView.setData(this.dMb);
                }
                if (!z12 && !z && ((this.hGK || this.hGJ) && b2 != -1 && !com.baidu.tbadk.core.util.v.aa(f) && !this.hGL)) {
                    this.hGR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + f.size(), 0 - f.this.hGT);
                            f.this.hGL = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.iB().post(this.hGR);
                }
                if (postData3 == null) {
                    if (this.hGO != null && !this.hGJ) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, this.hGO);
                    } else {
                        PostData postData4 = new PostData();
                        postData4.Ay(1);
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

    private com.baidu.adp.widget.ListView.m bSj() {
        PbModel bQS = this.hGq.bQS();
        if (bQS == null) {
            return null;
        }
        String bTw = bQS.bTw();
        if (TextUtils.isEmpty(bTw)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.DV(bTw);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bSk() {
        if (this.hGF == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bSU = this.hGq.bQS().bSU();
        if (bSU == null) {
            bSU = this.hGF.bQb();
        }
        if (bSU != null) {
            AdvertAppInfo.ILegoAdvert cmm = bSU.cmm();
            if (cmm != null) {
                cmm.setAdvertAppInfo(bSU.oM());
            }
            int abE = bSU.cml().abE();
            if (abE != 0) {
                a(bSU, abE);
                if (abE == 28 || abE == 31 || bSU.cml().goods == null) {
                    return null;
                }
                bSU.cml().goods.goods_style = -1001;
                return null;
            }
            if (this.hGF.getForum() != null) {
                bSU.forumId = this.hGF.getForum().getId();
            }
            if (this.hGF.bPM() != null) {
                bSU.threadId = com.baidu.adp.lib.g.b.c(this.hGF.bPM().getId(), 0L);
            }
            if (this.hGF != null && this.hGF.getPage() != null) {
                bSU.pageNumber = this.hGF.getPage().acn();
            }
            c(bSU);
            return bSU;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hGJ || dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bPO()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bQk() && this.hGH) ? 0 : -1;
        } else if (this.hGq.bQS() == null || !this.hGq.bQS().getIsFromMark()) {
            if (this.hGq.bRi() == null || !this.hGq.bRi().bVp()) {
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
                        if (postData.cmx() == 1 && postData.iZo == 0) {
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
                return dVar.bQk() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bPO()) || com.baidu.tbadk.core.util.v.aa(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.bPO(), 0)) == null) {
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
                if (postData.cmx() == 1 && postData.iZo == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bPO()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bQk()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bPO().get(0) == null || dVar.bPO().get(0).cmx() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bPX() == null || com.baidu.tbadk.core.util.v.aa(dVar.bPX().hCo)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bPX().hCo;
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.iZB = true;
                postData.iZq = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.Z(dVar.bPX().hCp) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).iZq = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).iZq = true;
            }
        }
        com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hBZ);
        iVar.hCb = dVar.bPX().forum_top_list;
        arrayList.add(0, iVar);
        return arrayList;
    }

    private void buq() {
        if (this.hGq != null && !bur()) {
            this.hGq.registerListener(this.fGl);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bur() {
        if (this.hGq == null) {
            return false;
        }
        this.fGj = new ArrayList();
        ArrayList<BdUniqueId> clK = com.baidu.tieba.tbadkCore.q.clK();
        if (clK == null || clK.size() <= 0) {
            return false;
        }
        int size = clK.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bIW().a(this.hGq.getPageContext(), clK.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.fGj.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fGj)) {
            this.mListView.addAdapters(this.fGj);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bPO() == null || dVar.bPP() == null || dVar.bPO().size() == 0 || dVar.bPM() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bPP().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bPO().get(0) == null || dVar.bPO().get(0).cmx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().acn() != dVar.getPage().ack()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bPO() == null || dVar.bPQ() == null || dVar.bPO().size() == 0 || dVar.bPM() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bPQ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bPO().get(0) == null || dVar.bPO().get(0).cmx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().acn() != dVar.getPage().ack()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bSl() {
        return this.postList;
    }

    public BdUniqueId xj(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hGA == null || !this.hGA.bQL()) {
            this.hGS = bSm();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bSm() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.mListView.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.i.hBY) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bSn() {
        return this.hGS;
    }

    private void bSo() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hGF != null) {
            ArrayList<PostData> bPO = this.hGF.bPO();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bQa = this.hGF.bQa();
            if (bQa != null) {
                int size = bQa.size();
                if (bPO != null && bPO.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bQa.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bQa.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fGh = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bQa.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cml() != null) {
                            int abE = next3.cml().abE();
                            if (abE != 0) {
                                a(next3, abE);
                                if (abE != 28 && abE != 31) {
                                    if (next3.cml().goods != null) {
                                        next3.cml().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cml().apk_name)) {
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
                        if (this.hGF.getForum() != null) {
                            mVar4.forumId = this.hGF.getForum().getId();
                        }
                        if (this.hGF.bPM() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.c(this.hGF.bPM().getId(), 0L);
                        }
                        if (this.hGF != null && this.hGF.getPage() != null) {
                            mVar4.pageNumber = this.hGF.getPage().acn();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bPO.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hGH) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bPO.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hGq.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", mVar4.cml().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.zb(i);
        com.baidu.tieba.recapp.report.c.cfH().a(c);
        if (mVar != null && mVar.cml() != null) {
            mVar.cml().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cml() != null && mVar.cml().goods != null && mVar.cml().goods.goods_style != 1001 && mVar.cml().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hGF != null && mVar.cml() != null) {
            mVar.cml().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hGF.getPage() != null) {
                mVar.cml().advertAppContext.pn = this.hGF.getPage().acn();
            }
            mVar.cml().advertAppContext.page = mVar.cmo();
            if (this.hGF.getForum() != null && (forum = this.hGF.getForum()) != null) {
                mVar.cml().advertAppContext.fid = forum.getId();
                mVar.cml().advertAppContext.bDz = forum.getFirst_class();
                mVar.cml().advertAppContext.bDA = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cml().advertAppContext.bDB = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cml().advertAppContext.extensionInfo = mVar.cml().ext_info;
            mVar.cml().advertAppContext.QV = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hGr.setFromCDN(z);
        if (this.hGx != null && (this.hGx instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hGx).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hGE.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bSp() {
        return this.hGG;
    }

    public void nS(boolean z) {
        this.hGG = z;
    }

    public void nT(boolean z) {
        this.hGH = z;
    }

    public void nU(boolean z) {
        this.hGM = z;
    }

    public void L(View.OnClickListener onClickListener) {
        this.hGP = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIN = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ckh = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cll = onLongClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void xk(int i) {
        switch (i) {
            case 1:
                if (this.hGA != null) {
                    this.hGA.pause();
                }
                if (this.hGr != null) {
                    this.hGr.pause();
                    return;
                }
                return;
            case 2:
                if (this.hGA != null) {
                    this.hGA.resume();
                }
                if (this.hGr != null) {
                    this.hGr.resume();
                    return;
                }
                return;
            case 3:
                if (this.hGA != null) {
                    this.hGA.release();
                }
                if (this.hGr != null) {
                    this.hGr.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dG(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.aex())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.mf(postData.aex());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hGR);
        if (this.hGt != null) {
            this.hGt.onDestroy();
        }
        if (this.hGu != null) {
            this.hGu.onDestroy();
        }
        if (this.hGs != null) {
            this.hGs.onDestroy();
        }
    }

    public void of(boolean z) {
        this.hGJ = z;
    }

    public void og(boolean z) {
        this.hGK = z;
    }

    public void oh(boolean z) {
        this.hGI = z;
    }

    public void oi(boolean z) {
        this.hGL = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bSq() {
        return this.hGs;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.dMb;
    }

    public ThreadForumEnterButtonContainer bSr() {
        if (this.hGr == null || this.hGr.bSv() == null) {
            return null;
        }
        return this.hGr.bSv().hIp;
    }

    public p bSs() {
        if (this.hGr == null || this.hGr.bSv() == null) {
            return null;
        }
        return this.hGr.bSv();
    }
}
