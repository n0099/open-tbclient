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
    private List<com.baidu.adp.widget.ListView.a> fGi;
    private com.baidu.adp.widget.ListView.a gdH;
    private v hGA;
    private ae hGB;
    private com.baidu.tieba.pb.pb.a.d hGC;
    private com.baidu.tieba.pb.data.d hGE;
    private boolean hGJ;
    private boolean hGK;
    private int hGM;
    private Runnable hGQ;
    private int hGS;
    private PbActivity hGp;
    private o hGq;
    private com.baidu.tieba.pb.pb.main.a.a hGr;
    private ak hGs;
    private ak hGt;
    private i hGu;
    private com.baidu.tieba.pb.video.a hGv;
    private com.baidu.adp.widget.ListView.a hGw;
    private ag hGx;
    private ah hGy;
    private com.baidu.tieba.pb.pb.a.b hGz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hGD = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hGF = true;
    private boolean hGG = true;
    private boolean hGH = false;
    private boolean hGI = false;
    private boolean hGL = false;
    private String mHostId = null;
    private PostData hGN = null;
    private View.OnClickListener hGO = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h cIM = null;
    private com.baidu.tieba.pb.a.c ckg = null;
    private View.OnLongClickListener clk = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hGP = new ArrayList();
    private int hGR = -1;
    private CustomMessageListener fwg = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList clW = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).clW();
                Iterator it = clW.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).au(f.this.hGp);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hGD.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hGz = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(clW);
                f.this.hGP.clear();
                f.this.hGP.addAll(arrayList);
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
            if (customResponsedMessage != null && f.this.hGE != null && !com.baidu.adp.base.i.Z(f.this.hGp.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener fGj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.aa(f.this.fGi)) {
                f.this.buq();
                f.this.a(f.this.hGE, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hGM = 0;
        this.width = -1;
        this.hGS = 0;
        this.hGM = com.baidu.adp.lib.util.l.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.hGM;
        this.hGp = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.chc);
        this.hGS = com.baidu.adp.lib.util.l.ah(this.hGp) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hGq = new o(pbActivity, PostData.iYB);
        this.hGq.a(pbActivity);
        this.hGr = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.j.hCd);
        this.hGs = new ak(pbActivity, com.baidu.tieba.pb.data.i.hBX);
        this.hGt = new ak(pbActivity, com.baidu.tieba.pb.data.i.hBY);
        this.hGu = new i(pbActivity, PostData.iYC);
        this.hGu.a(pbActivity);
        this.gdH = com.baidu.tieba.recapp.r.ceL().a(pbActivity, AdvertAppInfo.bDG);
        this.hGw = com.baidu.tieba.recapp.r.ceL().a(pbActivity, AdvertAppInfo.bDK);
        this.hGA = new v(pbActivity, com.baidu.tieba.pb.data.a.hAV);
        this.hGB = new ae(pbActivity, com.baidu.tieba.pb.data.h.hBV);
        this.hGx = new ag(pbActivity, ad.hLD);
        this.hGy = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bGY);
        this.hGC = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.iYH);
        this.hGv = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.hVD);
        this.hGv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hGE.bPW() != null) {
                    pbActivity.bRh().bUn().bQM();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.hGq);
        this.mAdapters.add(this.hGr);
        this.mAdapters.add(this.hGu);
        this.mAdapters.add(this.hGs);
        this.mAdapters.add(this.hGt);
        this.mAdapters.add(this.gdH);
        this.mAdapters.add(this.hGw);
        this.mAdapters.add(this.hGA);
        this.mAdapters.add(this.hGB);
        this.mAdapters.add(this.hGx);
        this.mAdapters.add(this.hGy);
        this.mAdapters.add(this.hGv);
        this.mAdapters.add(this.hGC);
        this.fwg.setPriority(1);
        this.fwg.setSelfListener(true);
        pbActivity.registerListener(this.fwg);
        bup();
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
        com.baidu.adp.widget.ListView.m bSi;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hGE != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bPJ()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hGE = dVar;
            if (z6) {
                bSn();
                if (dVar != null) {
                    dVar.nO(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hGE != null && this.hGE.bPN() != null && this.hGE.bPN().size() > 0) {
                this.postList.addAll(this.hGE.bPN());
            }
            if (dVar != null && dVar.bPL() != null && dVar.bPL().adv() != null) {
                this.mHostId = dVar.bPL().adv().getUserId();
            }
            if (this.hGq != null) {
                this.hGq.setData(dVar);
                this.hGq.setFromCDN(this.mIsFromCDN);
                this.hGq.xc(this.hGM);
                this.hGq.nR(this.hGF);
                this.hGq.v(this.mCommonClickListener);
                this.hGq.L(this.hGO);
                this.hGq.setOnImageClickListener(this.cIM);
                this.hGq.setOnLongClickListener(this.clk);
                this.hGq.setTbGestureDetector(this.ckg);
                this.hGu.setData(dVar);
                this.hGu.setFromCDN(this.mIsFromCDN);
                this.hGu.setHostId(this.mHostId);
                this.hGu.nR(this.hGF);
                this.hGu.v(this.mCommonClickListener);
                this.hGu.L(this.hGO);
                this.hGu.setOnImageClickListener(this.cIM);
                this.hGu.setOnLongClickListener(this.clk);
                this.hGu.setTbGestureDetector(this.ckg);
                this.hGr.setOnClickListener(this.mCommonClickListener);
                this.hGC.setOnClickListener(this.mCommonClickListener);
                if (this.hGw != null && (this.hGw instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hGw).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hGD.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.xc(this.hGM);
                        next.nR(this.hGF);
                        next.nS(this.hGG);
                        next.nT(this.hGL);
                        next.v(this.mCommonClickListener);
                        next.L(this.hGO);
                        next.setOnImageClickListener(this.cIM);
                        next.setOnLongClickListener(this.clk);
                    }
                }
                this.hGs.v(this.mCommonClickListener);
                this.hGt.v(this.mCommonClickListener);
                this.hGx.setData(dVar);
                this.hGy.setData(dVar);
                this.hGA.setData(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bPN());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cmw() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hGN = postData;
                }
                boolean z7 = false;
                if (!this.hGG && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bQj() && postData.cmy() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bPS() != null) {
                    postData = dVar.bPS();
                    z7 = true;
                    z2 = true;
                    if (!this.hGG && dVar.bQj() && postData.cmy() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dG(arrayList);
                if (this.hGp.bRG()) {
                    if (dVar.bPN().size() > 0 && (postData2 = dVar.bPN().get(0)) != null && postData2.cmw() == 1 && !com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hGE, arrayList, this.hGG);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.hGE.bPO());
                    }
                }
                int c = c(this.hGE, arrayList, this.hGG);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.hGE.bPP());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hBX);
                    if (dVar != null && dVar.bPL() != null) {
                        iVar.hBZ = dVar.bPL().adm();
                    }
                    iVar.isNew = !this.hGG;
                    iVar.hCc = this.hGp.bRS();
                    iVar.sortType = dVar.hBF;
                    if (dVar.hBE != null && dVar.hBE.size() > dVar.hBF) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hBE.size()) {
                                break;
                            } else if (dVar.hBE.get(i3).sort_type.intValue() != dVar.hBF) {
                                i2 = i3 + 1;
                            } else {
                                iVar.hCb = dVar.hBE.get(i3).sort_name;
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
                        ((PostData) mVar).iZn = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) f);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hGG);
                }
                if (i < 0 || dVar.bQi() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, i, dVar.bQi());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bSi = bSi()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i + 1, bSi);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bSj = bSj();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bSj != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i4, bSj);
                    }
                }
                this.hGq.oj(!z4);
                boolean z12 = false;
                if (this.hGp.bQR() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hGp.bQR().getPostId())) {
                    z12 = true;
                }
                if (this.hGH && !z12) {
                    arrayList.remove(postData3);
                    this.hGH = false;
                }
                if (dVar.bQi() != null) {
                    if (z5) {
                        dVar.bQi().nP(false);
                    } else {
                        dVar.bQi().nP(true);
                    }
                }
                if (this.mListView != null) {
                    this.dMb = arrayList;
                    this.mListView.setData(this.dMb);
                }
                if (!z12 && !z && ((this.hGJ || this.hGI) && b2 != -1 && !com.baidu.tbadk.core.util.v.aa(f) && !this.hGK)) {
                    this.hGQ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + f.size(), 0 - f.this.hGS);
                            f.this.hGK = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.iB().post(this.hGQ);
                }
                if (postData3 == null) {
                    if (this.hGN != null && !this.hGI) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, this.hGN);
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

    private com.baidu.adp.widget.ListView.m bSi() {
        PbModel bQR = this.hGp.bQR();
        if (bQR == null) {
            return null;
        }
        String bTv = bQR.bTv();
        if (TextUtils.isEmpty(bTv)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.DT(bTv);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bSj() {
        if (this.hGE == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bST = this.hGp.bQR().bST();
        if (bST == null) {
            bST = this.hGE.bQa();
        }
        if (bST != null) {
            AdvertAppInfo.ILegoAdvert cml = bST.cml();
            if (cml != null) {
                cml.setAdvertAppInfo(bST.oM());
            }
            int abE = bST.cmk().abE();
            if (abE != 0) {
                a(bST, abE);
                if (abE == 28 || abE == 31 || bST.cmk().goods == null) {
                    return null;
                }
                bST.cmk().goods.goods_style = -1001;
                return null;
            }
            if (this.hGE.getForum() != null) {
                bST.forumId = this.hGE.getForum().getId();
            }
            if (this.hGE.bPL() != null) {
                bST.threadId = com.baidu.adp.lib.g.b.c(this.hGE.bPL().getId(), 0L);
            }
            if (this.hGE != null && this.hGE.getPage() != null) {
                bST.pageNumber = this.hGE.getPage().acn();
            }
            c(bST);
            return bST;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hGI || dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bPN()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bQj() && this.hGG) ? 0 : -1;
        } else if (this.hGp.bQR() == null || !this.hGp.bQR().getIsFromMark()) {
            if (this.hGp.bRh() == null || !this.hGp.bRh().bVo()) {
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
                        if (postData.cmw() == 1 && postData.iZk == 0) {
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
                return dVar.bQj() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bPN()) || com.baidu.tbadk.core.util.v.aa(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.bPN(), 0)) == null) {
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
                if (postData.cmw() == 1 && postData.iZk == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bPN()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bQj()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bPN().get(0) == null || dVar.bPN().get(0).cmw() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bPW() == null || com.baidu.tbadk.core.util.v.aa(dVar.bPW().hCn)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bPW().hCn;
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.iZx = true;
                postData.iZm = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.Z(dVar.bPW().hCo) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).iZm = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).iZm = true;
            }
        }
        com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hBY);
        iVar.hCa = dVar.bPW().forum_top_list;
        arrayList.add(0, iVar);
        return arrayList;
    }

    private void bup() {
        if (this.hGp != null && !buq()) {
            this.hGp.registerListener(this.fGj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean buq() {
        if (this.hGp == null) {
            return false;
        }
        this.fGi = new ArrayList();
        ArrayList<BdUniqueId> clJ = com.baidu.tieba.tbadkCore.q.clJ();
        if (clJ == null || clJ.size() <= 0) {
            return false;
        }
        int size = clJ.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bIV().a(this.hGp.getPageContext(), clJ.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.fGi.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fGi)) {
            this.mListView.addAdapters(this.fGi);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bPN() == null || dVar.bPO() == null || dVar.bPN().size() == 0 || dVar.bPL() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bPO().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bPN().get(0) == null || dVar.bPN().get(0).cmw() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().acn() != dVar.getPage().ack()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bPN() == null || dVar.bPP() == null || dVar.bPN().size() == 0 || dVar.bPL() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bPP().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bPN().get(0) == null || dVar.bPN().get(0).cmw() != 1) ? -1 : 1;
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

    public ArrayList<PostData> bSk() {
        return this.postList;
    }

    public BdUniqueId xj(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hGz == null || !this.hGz.bQK()) {
            this.hGR = bSl();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bSl() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.mListView.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.i.hBX) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bSm() {
        return this.hGR;
    }

    private void bSn() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hGE != null) {
            ArrayList<PostData> bPN = this.hGE.bPN();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bPZ = this.hGE.bPZ();
            if (bPZ != null) {
                int size = bPZ.size();
                if (bPN != null && bPN.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bPZ.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bPZ.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fGg = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bPZ.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cmk() != null) {
                            int abE = next3.cmk().abE();
                            if (abE != 0) {
                                a(next3, abE);
                                if (abE != 28 && abE != 31) {
                                    if (next3.cmk().goods != null) {
                                        next3.cmk().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cmk().apk_name)) {
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
                        if (this.hGE.getForum() != null) {
                            mVar4.forumId = this.hGE.getForum().getId();
                        }
                        if (this.hGE.bPL() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.c(this.hGE.bPL().getId(), 0L);
                        }
                        if (this.hGE != null && this.hGE.getPage() != null) {
                            mVar4.pageNumber = this.hGE.getPage().acn();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bPN.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hGG) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bPN.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hGp.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", mVar4.cmk().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.zb(i);
        com.baidu.tieba.recapp.report.c.cfG().a(c);
        if (mVar != null && mVar.cmk() != null) {
            mVar.cmk().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cmk() != null && mVar.cmk().goods != null && mVar.cmk().goods.goods_style != 1001 && mVar.cmk().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hGE != null && mVar.cmk() != null) {
            mVar.cmk().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hGE.getPage() != null) {
                mVar.cmk().advertAppContext.pn = this.hGE.getPage().acn();
            }
            mVar.cmk().advertAppContext.page = mVar.cmn();
            if (this.hGE.getForum() != null && (forum = this.hGE.getForum()) != null) {
                mVar.cmk().advertAppContext.fid = forum.getId();
                mVar.cmk().advertAppContext.bDy = forum.getFirst_class();
                mVar.cmk().advertAppContext.bDz = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cmk().advertAppContext.bDA = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cmk().advertAppContext.extensionInfo = mVar.cmk().ext_info;
            mVar.cmk().advertAppContext.QW = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hGq.setFromCDN(z);
        if (this.hGw != null && (this.hGw instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hGw).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hGD.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bSo() {
        return this.hGF;
    }

    public void nR(boolean z) {
        this.hGF = z;
    }

    public void nS(boolean z) {
        this.hGG = z;
    }

    public void nT(boolean z) {
        this.hGL = z;
    }

    public void L(View.OnClickListener onClickListener) {
        this.hGO = onClickListener;
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
                if (this.hGz != null) {
                    this.hGz.pause();
                }
                if (this.hGq != null) {
                    this.hGq.pause();
                    return;
                }
                return;
            case 2:
                if (this.hGz != null) {
                    this.hGz.resume();
                }
                if (this.hGq != null) {
                    this.hGq.resume();
                    return;
                }
                return;
            case 3:
                if (this.hGz != null) {
                    this.hGz.release();
                }
                if (this.hGq != null) {
                    this.hGq.release();
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
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hGQ);
        if (this.hGs != null) {
            this.hGs.onDestroy();
        }
        if (this.hGt != null) {
            this.hGt.onDestroy();
        }
        if (this.hGr != null) {
            this.hGr.onDestroy();
        }
    }

    public void oe(boolean z) {
        this.hGI = z;
    }

    public void of(boolean z) {
        this.hGJ = z;
    }

    public void og(boolean z) {
        this.hGH = z;
    }

    public void oh(boolean z) {
        this.hGK = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bSp() {
        return this.hGr;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.dMb;
    }

    public ThreadForumEnterButtonContainer bSq() {
        if (this.hGq == null || this.hGq.bSu() == null) {
            return null;
        }
        return this.hGq.bSu().hIo;
    }

    public p bSr() {
        if (this.hGq == null || this.hGq.bSu() == null) {
            return null;
        }
        return this.hGq.bSu();
    }
}
