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
    private ArrayList<com.baidu.adp.widget.ListView.m> dMa;
    private List<com.baidu.adp.widget.ListView.a> fGh;
    private com.baidu.adp.widget.ListView.a gdG;
    private com.baidu.tieba.pb.data.d hGB;
    private boolean hGG;
    private boolean hGH;
    private int hGJ;
    private Runnable hGN;
    private int hGP;
    private PbActivity hGm;
    private o hGn;
    private com.baidu.tieba.pb.pb.main.a.a hGo;
    private ak hGp;
    private ak hGq;
    private i hGr;
    private com.baidu.tieba.pb.video.a hGs;
    private com.baidu.adp.widget.ListView.a hGt;
    private ag hGu;
    private ah hGv;
    private com.baidu.tieba.pb.pb.a.b hGw;
    private v hGx;
    private ae hGy;
    private com.baidu.tieba.pb.pb.a.d hGz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hGA = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hGC = true;
    private boolean hGD = true;
    private boolean hGE = false;
    private boolean hGF = false;
    private boolean hGI = false;
    private String mHostId = null;
    private PostData hGK = null;
    private View.OnClickListener hGL = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h cIM = null;
    private com.baidu.tieba.pb.a.c ckg = null;
    private View.OnLongClickListener clk = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hGM = new ArrayList();
    private int hGO = -1;
    private CustomMessageListener fwf = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList clU = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).clU();
                Iterator it = clU.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).au(f.this.hGm);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hGA.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hGw = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(clU);
                f.this.hGM.clear();
                f.this.hGM.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener chc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hGB != null && !com.baidu.adp.base.i.Z(f.this.hGm.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener fGi = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.aa(f.this.fGh)) {
                f.this.bun();
                f.this.a(f.this.hGB, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hGJ = 0;
        this.width = -1;
        this.hGP = 0;
        this.hGJ = com.baidu.adp.lib.util.l.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.hGJ;
        this.hGm = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.chc);
        this.hGP = com.baidu.adp.lib.util.l.ah(this.hGm) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hGn = new o(pbActivity, PostData.iYz);
        this.hGn.a(pbActivity);
        this.hGo = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.j.hCa);
        this.hGp = new ak(pbActivity, com.baidu.tieba.pb.data.i.hBU);
        this.hGq = new ak(pbActivity, com.baidu.tieba.pb.data.i.hBV);
        this.hGr = new i(pbActivity, PostData.iYA);
        this.hGr.a(pbActivity);
        this.gdG = com.baidu.tieba.recapp.r.ceJ().a(pbActivity, AdvertAppInfo.bDG);
        this.hGt = com.baidu.tieba.recapp.r.ceJ().a(pbActivity, AdvertAppInfo.bDK);
        this.hGx = new v(pbActivity, com.baidu.tieba.pb.data.a.hAS);
        this.hGy = new ae(pbActivity, com.baidu.tieba.pb.data.h.hBS);
        this.hGu = new ag(pbActivity, ad.hLA);
        this.hGv = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bGY);
        this.hGz = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.iYF);
        this.hGs = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.hVA);
        this.hGs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hGB.bPT() != null) {
                    pbActivity.bRe().bUk().bQJ();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.hGn);
        this.mAdapters.add(this.hGo);
        this.mAdapters.add(this.hGr);
        this.mAdapters.add(this.hGp);
        this.mAdapters.add(this.hGq);
        this.mAdapters.add(this.gdG);
        this.mAdapters.add(this.hGt);
        this.mAdapters.add(this.hGx);
        this.mAdapters.add(this.hGy);
        this.mAdapters.add(this.hGu);
        this.mAdapters.add(this.hGv);
        this.mAdapters.add(this.hGs);
        this.mAdapters.add(this.hGz);
        this.fwf.setPriority(1);
        this.fwf.setSelfListener(true);
        pbActivity.registerListener(this.fwf);
        bum();
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
        com.baidu.adp.widget.ListView.m bSf;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hGB != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bPG()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hGB = dVar;
            if (z6) {
                bSk();
                if (dVar != null) {
                    dVar.nO(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hGB != null && this.hGB.bPK() != null && this.hGB.bPK().size() > 0) {
                this.postList.addAll(this.hGB.bPK());
            }
            if (dVar != null && dVar.bPI() != null && dVar.bPI().adv() != null) {
                this.mHostId = dVar.bPI().adv().getUserId();
            }
            if (this.hGn != null) {
                this.hGn.setData(dVar);
                this.hGn.setFromCDN(this.mIsFromCDN);
                this.hGn.xc(this.hGJ);
                this.hGn.nR(this.hGC);
                this.hGn.v(this.mCommonClickListener);
                this.hGn.L(this.hGL);
                this.hGn.setOnImageClickListener(this.cIM);
                this.hGn.setOnLongClickListener(this.clk);
                this.hGn.setTbGestureDetector(this.ckg);
                this.hGr.setData(dVar);
                this.hGr.setFromCDN(this.mIsFromCDN);
                this.hGr.setHostId(this.mHostId);
                this.hGr.nR(this.hGC);
                this.hGr.v(this.mCommonClickListener);
                this.hGr.L(this.hGL);
                this.hGr.setOnImageClickListener(this.cIM);
                this.hGr.setOnLongClickListener(this.clk);
                this.hGr.setTbGestureDetector(this.ckg);
                this.hGo.setOnClickListener(this.mCommonClickListener);
                this.hGz.setOnClickListener(this.mCommonClickListener);
                if (this.hGt != null && (this.hGt instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hGt).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hGA.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.xc(this.hGJ);
                        next.nR(this.hGC);
                        next.nS(this.hGD);
                        next.nT(this.hGI);
                        next.v(this.mCommonClickListener);
                        next.L(this.hGL);
                        next.setOnImageClickListener(this.cIM);
                        next.setOnLongClickListener(this.clk);
                    }
                }
                this.hGp.v(this.mCommonClickListener);
                this.hGq.v(this.mCommonClickListener);
                this.hGu.setData(dVar);
                this.hGv.setData(dVar);
                this.hGx.setData(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bPK());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cmu() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hGK = postData;
                }
                boolean z7 = false;
                if (!this.hGD && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bQg() && postData.cmw() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bPP() != null) {
                    postData = dVar.bPP();
                    z7 = true;
                    z2 = true;
                    if (!this.hGD && dVar.bQg() && postData.cmw() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dG(arrayList);
                if (this.hGm.bRD()) {
                    if (dVar.bPK().size() > 0 && (postData2 = dVar.bPK().get(0)) != null && postData2.cmu() == 1 && !com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hGB, arrayList, this.hGD);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.hGB.bPL());
                    }
                }
                int c = c(this.hGB, arrayList, this.hGD);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.hGB.bPM());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hBU);
                    if (dVar != null && dVar.bPI() != null) {
                        iVar.hBW = dVar.bPI().adm();
                    }
                    iVar.isNew = !this.hGD;
                    iVar.hBZ = this.hGm.bRP();
                    iVar.sortType = dVar.hBC;
                    if (dVar.hBB != null && dVar.hBB.size() > dVar.hBC) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hBB.size()) {
                                break;
                            } else if (dVar.hBB.get(i3).sort_type.intValue() != dVar.hBC) {
                                i2 = i3 + 1;
                            } else {
                                iVar.hBY = dVar.hBB.get(i3).sort_name;
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
                        ((PostData) mVar).iZl = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) f);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hGD);
                }
                if (i < 0 || dVar.bQf() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, i, dVar.bQf());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bSf = bSf()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i + 1, bSf);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bSg = bSg();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bSg != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i4, bSg);
                    }
                }
                this.hGn.oj(!z4);
                boolean z12 = false;
                if (this.hGm.bQO() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hGm.bQO().getPostId())) {
                    z12 = true;
                }
                if (this.hGE && !z12) {
                    arrayList.remove(postData3);
                    this.hGE = false;
                }
                if (dVar.bQf() != null) {
                    if (z5) {
                        dVar.bQf().nP(false);
                    } else {
                        dVar.bQf().nP(true);
                    }
                }
                if (this.mListView != null) {
                    this.dMa = arrayList;
                    this.mListView.setData(this.dMa);
                }
                if (!z12 && !z && ((this.hGG || this.hGF) && b2 != -1 && !com.baidu.tbadk.core.util.v.aa(f) && !this.hGH)) {
                    this.hGN = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + f.size(), 0 - f.this.hGP);
                            f.this.hGH = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.iB().post(this.hGN);
                }
                if (postData3 == null) {
                    if (this.hGK != null && !this.hGF) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, this.hGK);
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

    private com.baidu.adp.widget.ListView.m bSf() {
        PbModel bQO = this.hGm.bQO();
        if (bQO == null) {
            return null;
        }
        String bTs = bQO.bTs();
        if (TextUtils.isEmpty(bTs)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.DT(bTs);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bSg() {
        if (this.hGB == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bSQ = this.hGm.bQO().bSQ();
        if (bSQ == null) {
            bSQ = this.hGB.bPX();
        }
        if (bSQ != null) {
            AdvertAppInfo.ILegoAdvert cmj = bSQ.cmj();
            if (cmj != null) {
                cmj.setAdvertAppInfo(bSQ.oM());
            }
            int abE = bSQ.cmi().abE();
            if (abE != 0) {
                a(bSQ, abE);
                if (abE == 28 || abE == 31 || bSQ.cmi().goods == null) {
                    return null;
                }
                bSQ.cmi().goods.goods_style = -1001;
                return null;
            }
            if (this.hGB.getForum() != null) {
                bSQ.forumId = this.hGB.getForum().getId();
            }
            if (this.hGB.bPI() != null) {
                bSQ.threadId = com.baidu.adp.lib.g.b.c(this.hGB.bPI().getId(), 0L);
            }
            if (this.hGB != null && this.hGB.getPage() != null) {
                bSQ.pageNumber = this.hGB.getPage().acn();
            }
            c(bSQ);
            return bSQ;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hGF || dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bPK()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bQg() && this.hGD) ? 0 : -1;
        } else if (this.hGm.bQO() == null || !this.hGm.bQO().getIsFromMark()) {
            if (this.hGm.bRe() == null || !this.hGm.bRe().bVl()) {
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
                        if (postData.cmu() == 1 && postData.iZi == 0) {
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
                return dVar.bQg() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bPK()) || com.baidu.tbadk.core.util.v.aa(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.bPK(), 0)) == null) {
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
                if (postData.cmu() == 1 && postData.iZi == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bPK()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bQg()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bPK().get(0) == null || dVar.bPK().get(0).cmu() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bPT() == null || com.baidu.tbadk.core.util.v.aa(dVar.bPT().hCk)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bPT().hCk;
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.iZv = true;
                postData.iZk = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.Z(dVar.bPT().hCl) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).iZk = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).iZk = true;
            }
        }
        com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hBV);
        iVar.hBX = dVar.bPT().forum_top_list;
        arrayList.add(0, iVar);
        return arrayList;
    }

    private void bum() {
        if (this.hGm != null && !bun()) {
            this.hGm.registerListener(this.fGi);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bun() {
        if (this.hGm == null) {
            return false;
        }
        this.fGh = new ArrayList();
        ArrayList<BdUniqueId> clH = com.baidu.tieba.tbadkCore.q.clH();
        if (clH == null || clH.size() <= 0) {
            return false;
        }
        int size = clH.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bIS().a(this.hGm.getPageContext(), clH.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.fGh.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fGh)) {
            this.mListView.addAdapters(this.fGh);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bPK() == null || dVar.bPL() == null || dVar.bPK().size() == 0 || dVar.bPI() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bPL().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bPK().get(0) == null || dVar.bPK().get(0).cmu() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().acn() != dVar.getPage().ack()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bPK() == null || dVar.bPM() == null || dVar.bPK().size() == 0 || dVar.bPI() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bPM().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bPK().get(0) == null || dVar.bPK().get(0).cmu() != 1) ? -1 : 1;
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

    public ArrayList<PostData> bSh() {
        return this.postList;
    }

    public BdUniqueId xj(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hGw == null || !this.hGw.bQH()) {
            this.hGO = bSi();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bSi() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.mListView.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.i.hBU) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bSj() {
        return this.hGO;
    }

    private void bSk() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hGB != null) {
            ArrayList<PostData> bPK = this.hGB.bPK();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bPW = this.hGB.bPW();
            if (bPW != null) {
                int size = bPW.size();
                if (bPK != null && bPK.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bPW.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bPW.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fGf = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bPW.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cmi() != null) {
                            int abE = next3.cmi().abE();
                            if (abE != 0) {
                                a(next3, abE);
                                if (abE != 28 && abE != 31) {
                                    if (next3.cmi().goods != null) {
                                        next3.cmi().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cmi().apk_name)) {
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
                        if (this.hGB.getForum() != null) {
                            mVar4.forumId = this.hGB.getForum().getId();
                        }
                        if (this.hGB.bPI() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.c(this.hGB.bPI().getId(), 0L);
                        }
                        if (this.hGB != null && this.hGB.getPage() != null) {
                            mVar4.pageNumber = this.hGB.getPage().acn();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bPK.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hGD) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bPK.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hGm.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", mVar4.cmi().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.zb(i);
        com.baidu.tieba.recapp.report.c.cfE().a(c);
        if (mVar != null && mVar.cmi() != null) {
            mVar.cmi().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cmi() != null && mVar.cmi().goods != null && mVar.cmi().goods.goods_style != 1001 && mVar.cmi().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hGB != null && mVar.cmi() != null) {
            mVar.cmi().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hGB.getPage() != null) {
                mVar.cmi().advertAppContext.pn = this.hGB.getPage().acn();
            }
            mVar.cmi().advertAppContext.page = mVar.cml();
            if (this.hGB.getForum() != null && (forum = this.hGB.getForum()) != null) {
                mVar.cmi().advertAppContext.fid = forum.getId();
                mVar.cmi().advertAppContext.bDy = forum.getFirst_class();
                mVar.cmi().advertAppContext.bDz = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cmi().advertAppContext.bDA = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cmi().advertAppContext.extensionInfo = mVar.cmi().ext_info;
            mVar.cmi().advertAppContext.QW = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hGn.setFromCDN(z);
        if (this.hGt != null && (this.hGt instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hGt).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hGA.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bSl() {
        return this.hGC;
    }

    public void nR(boolean z) {
        this.hGC = z;
    }

    public void nS(boolean z) {
        this.hGD = z;
    }

    public void nT(boolean z) {
        this.hGI = z;
    }

    public void L(View.OnClickListener onClickListener) {
        this.hGL = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cIM = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ckg = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.clk = onLongClickListener;
    }

    public void z(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void xk(int i) {
        switch (i) {
            case 1:
                if (this.hGw != null) {
                    this.hGw.pause();
                }
                if (this.hGn != null) {
                    this.hGn.pause();
                    return;
                }
                return;
            case 2:
                if (this.hGw != null) {
                    this.hGw.resume();
                }
                if (this.hGn != null) {
                    this.hGn.resume();
                    return;
                }
                return;
            case 3:
                if (this.hGw != null) {
                    this.hGw.release();
                }
                if (this.hGn != null) {
                    this.hGn.release();
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
                        adVar.mg(postData.aex());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hGN);
        if (this.hGp != null) {
            this.hGp.onDestroy();
        }
        if (this.hGq != null) {
            this.hGq.onDestroy();
        }
        if (this.hGo != null) {
            this.hGo.onDestroy();
        }
    }

    public void oe(boolean z) {
        this.hGF = z;
    }

    public void of(boolean z) {
        this.hGG = z;
    }

    public void og(boolean z) {
        this.hGE = z;
    }

    public void oh(boolean z) {
        this.hGH = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bSm() {
        return this.hGo;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.dMa;
    }

    public ThreadForumEnterButtonContainer bSn() {
        if (this.hGn == null || this.hGn.bSr() == null) {
            return null;
        }
        return this.hGn.bSr().hIl;
    }

    public p bSo() {
        if (this.hGn == null || this.hGn.bSr() == null) {
            return null;
        }
        return this.hGn.bSr();
    }
}
