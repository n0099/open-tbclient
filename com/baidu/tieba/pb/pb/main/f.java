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
    private ArrayList<com.baidu.adp.widget.ListView.m> dPJ;
    private List<com.baidu.adp.widget.ListView.a> fLh;
    private com.baidu.adp.widget.ListView.a gjV;
    private PbActivity hMD;
    private o hME;
    private com.baidu.tieba.pb.pb.main.a.a hMF;
    private ak hMG;
    private ak hMH;
    private i hMI;
    private com.baidu.tieba.pb.video.a hMJ;
    private com.baidu.adp.widget.ListView.a hMK;
    private ag hML;
    private ah hMM;
    private com.baidu.tieba.pb.pb.a.b hMN;
    private v hMO;
    private ae hMP;
    private com.baidu.tieba.pb.pb.a.d hMQ;
    private com.baidu.tieba.pb.data.d hMS;
    private boolean hMX;
    private boolean hMY;
    private int hNa;
    private Runnable hNe;
    private int hNg;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hMR = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hMT = true;
    private boolean hMU = true;
    private boolean hMV = false;
    private boolean hMW = false;
    private boolean hMZ = false;
    private String mHostId = null;
    private PostData hNb = null;
    private View.OnClickListener hNc = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h cKh = null;
    private com.baidu.tieba.pb.a.c clt = null;
    private View.OnLongClickListener cmy = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hNd = new ArrayList();
    private int hNf = -1;
    private CustomMessageListener fBc = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList coP = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).coP();
                Iterator it = coP.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).au(f.this.hMD);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hMR.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hMN = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(coP);
                f.this.hNd.clear();
                f.this.hNd.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cij = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hMS != null && !com.baidu.adp.base.i.Z(f.this.hMD.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener fLj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.aa(f.this.fLh)) {
                f.this.bwV();
                f.this.a(f.this.hMS, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hNa = 0;
        this.width = -1;
        this.hNg = 0;
        this.hNa = com.baidu.adp.lib.util.l.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.hNa;
        this.hMD = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cij);
        this.hNg = com.baidu.adp.lib.util.l.ah(this.hMD) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hME = new o(pbActivity, PostData.jeW);
        this.hME.a(pbActivity);
        this.hMF = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.j.hIr);
        this.hMG = new ak(pbActivity, com.baidu.tieba.pb.data.i.hIl);
        this.hMH = new ak(pbActivity, com.baidu.tieba.pb.data.i.hIm);
        this.hMI = new i(pbActivity, PostData.jeX);
        this.hMI.a(pbActivity);
        this.gjV = com.baidu.tieba.recapp.r.chD().a(pbActivity, AdvertAppInfo.bEH);
        this.hMK = com.baidu.tieba.recapp.r.chD().a(pbActivity, AdvertAppInfo.bEL);
        this.hMO = new v(pbActivity, com.baidu.tieba.pb.data.a.hHk);
        this.hMP = new ae(pbActivity, com.baidu.tieba.pb.data.h.hIj);
        this.hML = new ag(pbActivity, ad.hRR);
        this.hMM = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bHZ);
        this.hMQ = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.jfc);
        this.hMJ = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.ibR);
        this.hMJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hMS.bSI() != null) {
                    pbActivity.bTU().bXb().bTy();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
                }
            }
        });
        this.mAdapters.add(this.hME);
        this.mAdapters.add(this.hMF);
        this.mAdapters.add(this.hMI);
        this.mAdapters.add(this.hMG);
        this.mAdapters.add(this.hMH);
        this.mAdapters.add(this.gjV);
        this.mAdapters.add(this.hMK);
        this.mAdapters.add(this.hMO);
        this.mAdapters.add(this.hMP);
        this.mAdapters.add(this.hML);
        this.mAdapters.add(this.hMM);
        this.mAdapters.add(this.hMJ);
        this.mAdapters.add(this.hMQ);
        this.fBc.setPriority(1);
        this.fBc.setSelfListener(true);
        pbActivity.registerListener(this.fBc);
        bwU();
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
        com.baidu.adp.widget.ListView.m bUV;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hMS != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bSv()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hMS = dVar;
            if (z6) {
                bVa();
                if (dVar != null) {
                    dVar.od(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hMS != null && this.hMS.bSz() != null && this.hMS.bSz().size() > 0) {
                this.postList.addAll(this.hMS.bSz());
            }
            if (dVar != null && dVar.bSx() != null && dVar.bSx().aex() != null) {
                this.mHostId = dVar.bSx().aex().getUserId();
            }
            if (this.hME != null) {
                this.hME.setData(dVar);
                this.hME.setFromCDN(this.mIsFromCDN);
                this.hME.xG(this.hNa);
                this.hME.og(this.hMT);
                this.hME.v(this.mCommonClickListener);
                this.hME.N(this.hNc);
                this.hME.setOnImageClickListener(this.cKh);
                this.hME.setOnLongClickListener(this.cmy);
                this.hME.setTbGestureDetector(this.clt);
                this.hMI.setData(dVar);
                this.hMI.setFromCDN(this.mIsFromCDN);
                this.hMI.setHostId(this.mHostId);
                this.hMI.og(this.hMT);
                this.hMI.v(this.mCommonClickListener);
                this.hMI.N(this.hNc);
                this.hMI.setOnImageClickListener(this.cKh);
                this.hMI.setOnLongClickListener(this.cmy);
                this.hMI.setTbGestureDetector(this.clt);
                this.hMF.setOnClickListener(this.mCommonClickListener);
                this.hMQ.setOnClickListener(this.mCommonClickListener);
                if (this.hMK != null && (this.hMK instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hMK).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hMR.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.xG(this.hNa);
                        next.og(this.hMT);
                        next.oh(this.hMU);
                        next.oi(this.hMZ);
                        next.v(this.mCommonClickListener);
                        next.N(this.hNc);
                        next.setOnImageClickListener(this.cKh);
                        next.setOnLongClickListener(this.cmy);
                    }
                }
                this.hMG.v(this.mCommonClickListener);
                this.hMH.v(this.mCommonClickListener);
                this.hML.setData(dVar);
                this.hMM.setData(dVar);
                this.hMO.setData(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bSz());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cpp() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hNb = postData;
                }
                boolean z7 = false;
                if (!this.hMU && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bSV() && postData.cpr() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bSE() != null) {
                    postData = dVar.bSE();
                    z7 = true;
                    z2 = true;
                    if (!this.hMU && dVar.bSV() && postData.cpr() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dI(arrayList);
                if (this.hMD.bUt()) {
                    if (dVar.bSz().size() > 0 && (postData2 = dVar.bSz().get(0)) != null && postData2.cpp() == 1 && !com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hMS, arrayList, this.hMU);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.hMS.bSA());
                    }
                }
                int c = c(this.hMS, arrayList, this.hMU);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.hMS.bSB());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hIl);
                    if (dVar != null && dVar.bSx() != null) {
                        iVar.hIn = dVar.bSx().aeo();
                    }
                    iVar.isNew = !this.hMU;
                    iVar.hIq = this.hMD.bUF();
                    iVar.sortType = dVar.hHU;
                    if (dVar.hHT != null && dVar.hHT.size() > dVar.hHU) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hHT.size()) {
                                break;
                            } else if (dVar.hHT.get(i3).sort_type.intValue() != dVar.hHU) {
                                i2 = i3 + 1;
                            } else {
                                iVar.hIp = dVar.hHT.get(i3).sort_name;
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
                        ((PostData) mVar).jfI = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) f);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hMU);
                }
                if (i < 0 || dVar.bSU() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, i, dVar.bSU());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bUV = bUV()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i + 1, bUV);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bUW = bUW();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bUW != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i4, bUW);
                    }
                }
                this.hME.oy(!z4);
                boolean z12 = false;
                if (this.hMD.bTD() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hMD.bTD().getPostId())) {
                    z12 = true;
                }
                if (this.hMV && !z12) {
                    arrayList.remove(postData3);
                    this.hMV = false;
                }
                if (dVar.bSU() != null) {
                    if (z5) {
                        dVar.bSU().oe(false);
                    } else {
                        dVar.bSU().oe(true);
                    }
                }
                if (this.mListView != null) {
                    this.dPJ = arrayList;
                    this.mListView.setData(this.dPJ);
                }
                if (!z12 && !z && ((this.hMX || this.hMW) && b2 != -1 && !com.baidu.tbadk.core.util.v.aa(f) && !this.hMY)) {
                    this.hNe = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + f.size(), 0 - f.this.hNg);
                            f.this.hMY = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.iK().post(this.hNe);
                }
                if (postData3 == null) {
                    if (this.hNb != null && !this.hMW) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, this.hNb);
                    } else {
                        PostData postData4 = new PostData();
                        postData4.Be(1);
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

    private com.baidu.adp.widget.ListView.m bUV() {
        PbModel bTD = this.hMD.bTD();
        if (bTD == null) {
            return null;
        }
        String bWj = bTD.bWj();
        if (TextUtils.isEmpty(bWj)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.EI(bWj);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bUW() {
        if (this.hMS == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bVG = this.hMD.bTD().bVG();
        if (bVG == null) {
            bVG = this.hMS.bSM();
        }
        if (bVG != null) {
            AdvertAppInfo.ILegoAdvert cpe = bVG.cpe();
            if (cpe != null) {
                cpe.setAdvertAppInfo(bVG.ph());
            }
            int acG = bVG.cpd().acG();
            if (acG != 0) {
                a(bVG, acG);
                if (acG == 28 || acG == 31 || bVG.cpd().goods == null) {
                    return null;
                }
                bVG.cpd().goods.goods_style = -1001;
                return null;
            }
            if (this.hMS.getForum() != null) {
                bVG.forumId = this.hMS.getForum().getId();
            }
            if (this.hMS.bSx() != null) {
                bVG.threadId = com.baidu.adp.lib.g.b.c(this.hMS.bSx().getId(), 0L);
            }
            if (this.hMS != null && this.hMS.getPage() != null) {
                bVG.pageNumber = this.hMS.getPage().adp();
            }
            c(bVG);
            return bVG;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hMW || dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bSz()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bSV() && this.hMU) ? 0 : -1;
        } else if (this.hMD.bTD() == null || !this.hMD.bTD().getIsFromMark()) {
            if (this.hMD.bTU() == null || !this.hMD.bTU().bYd()) {
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
                        if (postData.cpp() == 1 && postData.jfF == 0) {
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
                return dVar.bSV() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bSz()) || com.baidu.tbadk.core.util.v.aa(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.bSz(), 0)) == null) {
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
                if (postData.cpp() == 1 && postData.jfF == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bSz()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bSV()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bSz().get(0) == null || dVar.bSz().get(0).cpp() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bSI() == null || com.baidu.tbadk.core.util.v.aa(dVar.bSI().hIB)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bSI().hIB;
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.jfS = true;
                postData.jfH = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.Z(dVar.bSI().hIC) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).jfH = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).jfH = true;
            }
        }
        com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hIm);
        iVar.hIo = dVar.bSI().forum_top_list;
        arrayList.add(0, iVar);
        return arrayList;
    }

    private void bwU() {
        if (this.hMD != null && !bwV()) {
            this.hMD.registerListener(this.fLj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bwV() {
        if (this.hMD == null) {
            return false;
        }
        this.fLh = new ArrayList();
        ArrayList<BdUniqueId> coC = com.baidu.tieba.tbadkCore.q.coC();
        if (coC == null || coC.size() <= 0) {
            return false;
        }
        int size = coC.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bLD().a(this.hMD.getPageContext(), coC.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.fLh.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fLh)) {
            this.mListView.addAdapters(this.fLh);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bSz() == null || dVar.bSA() == null || dVar.bSz().size() == 0 || dVar.bSx() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bSA().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bSz().get(0) == null || dVar.bSz().get(0).cpp() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().adp() != dVar.getPage().adm()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bSz() == null || dVar.bSB() == null || dVar.bSz().size() == 0 || dVar.bSx() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bSB().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bSz().get(0) == null || dVar.bSz().get(0).cpp() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().adp() != dVar.getPage().adm()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bUX() {
        return this.postList;
    }

    public BdUniqueId xN(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hMN == null || !this.hMN.bTw()) {
            this.hNf = bUY();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bUY() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.mListView.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.i.hIl) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bUZ() {
        return this.hNf;
    }

    private void bVa() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hMS != null) {
            ArrayList<PostData> bSz = this.hMS.bSz();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bSL = this.hMS.bSL();
            if (bSL != null) {
                int size = bSL.size();
                if (bSz != null && bSz.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bSL.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bSL.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fLf = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bSL.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cpd() != null) {
                            int acG = next3.cpd().acG();
                            if (acG != 0) {
                                a(next3, acG);
                                if (acG != 28 && acG != 31) {
                                    if (next3.cpd().goods != null) {
                                        next3.cpd().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cpd().apk_name)) {
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
                        if (this.hMS.getForum() != null) {
                            mVar4.forumId = this.hMS.getForum().getId();
                        }
                        if (this.hMS.bSx() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.c(this.hMS.bSx().getId(), 0L);
                        }
                        if (this.hMS != null && this.hMS.getPage() != null) {
                            mVar4.pageNumber = this.hMS.getPage().adp();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bSz.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hMU) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bSz.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hMD.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", mVar4.cpd().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.zG(i);
        com.baidu.tieba.recapp.report.c.ciy().a(c);
        if (mVar != null && mVar.cpd() != null) {
            mVar.cpd().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cpd() != null && mVar.cpd().goods != null && mVar.cpd().goods.goods_style != 1001 && mVar.cpd().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hMS != null && mVar.cpd() != null) {
            mVar.cpd().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hMS.getPage() != null) {
                mVar.cpd().advertAppContext.pn = this.hMS.getPage().adp();
            }
            mVar.cpd().advertAppContext.page = mVar.cpg();
            if (this.hMS.getForum() != null && (forum = this.hMS.getForum()) != null) {
                mVar.cpd().advertAppContext.fid = forum.getId();
                mVar.cpd().advertAppContext.bEy = forum.getFirst_class();
                mVar.cpd().advertAppContext.bEz = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cpd().advertAppContext.bEA = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cpd().advertAppContext.extensionInfo = mVar.cpd().ext_info;
            mVar.cpd().advertAppContext.Rn = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hME.setFromCDN(z);
        if (this.hMK != null && (this.hMK instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hMK).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hMR.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bVb() {
        return this.hMT;
    }

    public void og(boolean z) {
        this.hMT = z;
    }

    public void oh(boolean z) {
        this.hMU = z;
    }

    public void oi(boolean z) {
        this.hMZ = z;
    }

    public void N(View.OnClickListener onClickListener) {
        this.hNc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cKh = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.clt = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cmy = onLongClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void xO(int i) {
        switch (i) {
            case 1:
                if (this.hMN != null) {
                    this.hMN.pause();
                }
                if (this.hME != null) {
                    this.hME.pause();
                    return;
                }
                return;
            case 2:
                if (this.hMN != null) {
                    this.hMN.resume();
                }
                if (this.hME != null) {
                    this.hME.resume();
                    return;
                }
                return;
            case 3:
                if (this.hMN != null) {
                    this.hMN.release();
                }
                if (this.hME != null) {
                    this.hME.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dI(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.afz())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.mq(postData.afz());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hNe);
        if (this.hMG != null) {
            this.hMG.onDestroy();
        }
        if (this.hMH != null) {
            this.hMH.onDestroy();
        }
        if (this.hMF != null) {
            this.hMF.onDestroy();
        }
    }

    public void ot(boolean z) {
        this.hMW = z;
    }

    public void ou(boolean z) {
        this.hMX = z;
    }

    public void ov(boolean z) {
        this.hMV = z;
    }

    public void ow(boolean z) {
        this.hMY = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bVc() {
        return this.hMF;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.dPJ;
    }

    public ThreadForumEnterButtonContainer bVd() {
        if (this.hME == null || this.hME.bVh() == null) {
            return null;
        }
        return this.hME.bVh().hOC;
    }

    public p bVe() {
        if (this.hME == null || this.hME.bVh() == null) {
            return null;
        }
        return this.hME.bVh();
    }
}
