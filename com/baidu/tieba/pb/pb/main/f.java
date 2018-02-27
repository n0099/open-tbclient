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
/* loaded from: classes2.dex */
public class f {
    private List<com.baidu.adp.widget.ListView.a> dJX;
    private com.baidu.adp.widget.ListView.a dRs;
    private com.baidu.adp.widget.ListView.a dRt;
    private int fIB;
    private com.baidu.tieba.pb.data.d fIE;
    private PbActivity fMQ;
    private o fMR;
    private an fMS;
    private aj fMT;
    private aj fMU;
    private i fMV;
    private com.baidu.tieba.pb.video.a fMW;
    private af fMX;
    private ag fMY;
    private com.baidu.tieba.pb.pb.a.b fMZ;
    private com.baidu.tieba.pb.pb.a.e fNa;
    private u fNb;
    private ad fNc;
    private com.baidu.tieba.pb.pb.a.d fNd;
    private boolean fNh;
    private boolean fNi;
    private Runnable fNl;
    private int fNn;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fNe = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fIC = true;
    private boolean fID = true;
    private boolean fNf = false;
    private boolean fNg = false;
    private boolean fNj = false;
    private String mHostId = null;
    private View.OnClickListener fIH = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bLF = null;
    private com.baidu.tieba.pb.a.c bLG = null;
    private View.OnLongClickListener bmh = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fNk = new ArrayList();
    private int fNm = -1;
    private CustomMessageListener dKf = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bwu = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bwu();
                Iterator it = bwu.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ao(f.this.fMQ);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fNe.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fMZ = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bwu);
                f.this.fNk.clear();
                f.this.fNk.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener bjk = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fIE != null && !com.baidu.adp.base.i.ai(f.this.fMQ.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dKg = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.E(f.this.dJX)) {
                f.this.axk();
                f.this.a(f.this.fIE, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fIB = 0;
        this.width = -1;
        this.fNn = 0;
        this.fIB = com.baidu.adp.lib.util.l.ao(pbActivity.getPageContext().getPageActivity());
        this.width = this.fIB;
        this.fMQ = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bjk);
        this.fNn = com.baidu.adp.lib.util.l.aq(this.fMQ) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fNa = new com.baidu.tieba.pb.pb.a.e(pbActivity, PostData.haC);
        this.fMR = new o(pbActivity, PostData.haA);
        this.fMR.a(pbActivity);
        this.fMS = new an(pbActivity, com.baidu.tieba.pb.data.j.fHO);
        this.fMT = new aj(pbActivity, com.baidu.tieba.pb.data.h.fHH);
        this.fMU = new aj(pbActivity, com.baidu.tieba.pb.data.h.fHI);
        this.fMV = new i(pbActivity, PostData.haB);
        this.fMV.a(pbActivity);
        this.dRs = com.baidu.tieba.recapp.r.boe().a(pbActivity, AdvertAppInfo.aKi);
        this.dRt = com.baidu.tieba.recapp.r.boe().a(pbActivity, AdvertAppInfo.aKm);
        this.fNb = new u(pbActivity, com.baidu.tieba.pb.data.a.fGP);
        this.fNc = new ad(pbActivity, com.baidu.tieba.pb.data.g.fHG);
        this.fMX = new af(pbActivity, ac.fRT);
        this.fMY = new ag(pbActivity, com.baidu.tbadk.core.data.ao.aNs);
        this.fNd = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.haF);
        this.fMW = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.gbd);
        this.fMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fIE.baE() != null) {
                    pbActivity.bbQ().beQ().bbu();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fMR);
        this.mAdapters.add(this.fMS);
        this.mAdapters.add(this.fMV);
        this.mAdapters.add(this.fMT);
        this.mAdapters.add(this.fMU);
        this.mAdapters.add(this.fNa);
        this.mAdapters.add(this.dRs);
        this.mAdapters.add(this.dRt);
        this.mAdapters.add(this.fNb);
        this.mAdapters.add(this.fNc);
        this.mAdapters.add(this.fMX);
        this.mAdapters.add(this.fMY);
        this.mAdapters.add(this.fMW);
        this.mAdapters.add(this.fNd);
        this.dKf.setPriority(1);
        this.dKf.setSelfListener(true);
        pbActivity.registerListener(this.dKf);
        axj();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(2004015);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        PostData postData2;
        boolean z5;
        boolean z6;
        com.baidu.adp.widget.ListView.i bcM;
        PostData postData3;
        if (dVar != null) {
            if (this.fIE != dVar) {
                z2 = (dVar == null || dVar.bap()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.fIE = dVar;
            if (z2) {
                bcQ();
                if (dVar != null) {
                    dVar.jN(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fIE != null && this.fIE.bav() != null && this.fIE.bav().size() > 0) {
                this.postList.addAll(this.fIE.bav());
            }
            if (dVar != null && dVar.bat() != null && dVar.bat().zn() != null) {
                this.mHostId = dVar.bat().zn().getUserId();
            }
            if (this.fMR != null) {
                this.fNa.b(dVar);
                this.fNa.setFromCDN(this.mIsFromCDN);
                this.fNa.setHostId(this.mHostId);
                this.fNa.sF(this.fIB);
                this.fNa.jP(this.fIC);
                this.fNa.jQ(this.fID);
                this.fNa.l(this.mCommonClickListener);
                this.fNa.E(this.fIH);
                this.fNa.setOnImageClickListener(this.bLF);
                this.fNa.setOnLongClickListener(this.bmh);
                this.fMR.b(dVar);
                this.fMR.setFromCDN(this.mIsFromCDN);
                this.fMR.sF(this.fIB);
                this.fMR.jP(this.fIC);
                this.fMR.l(this.mCommonClickListener);
                this.fMR.E(this.fIH);
                this.fMR.setOnImageClickListener(this.bLF);
                this.fMR.setOnLongClickListener(this.bmh);
                this.fMR.setTbGestureDetector(this.bLG);
                this.fMV.b(dVar);
                this.fMV.setFromCDN(this.mIsFromCDN);
                this.fMV.setHostId(this.mHostId);
                this.fMV.jP(this.fIC);
                this.fMV.l(this.mCommonClickListener);
                this.fMV.E(this.fIH);
                this.fMV.setOnImageClickListener(this.bLF);
                this.fMV.setOnLongClickListener(this.bmh);
                this.fMV.setTbGestureDetector(this.bLG);
                this.fMS.setOnClickListener(this.mCommonClickListener);
                this.fMS.setTbGestureDetector(this.bLG);
                this.fNd.setOnClickListener(this.mCommonClickListener);
                if (this.dRt != null && (this.dRt instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dRt).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fNe.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.sF(this.fIB);
                        next.jP(this.fIC);
                        next.jQ(this.fID);
                        next.jR(this.fNj);
                        next.l(this.mCommonClickListener);
                        next.E(this.fIH);
                        next.setOnImageClickListener(this.bLF);
                        next.setOnLongClickListener(this.bmh);
                    }
                }
                this.fMT.l(this.mCommonClickListener);
                this.fMU.l(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>(dVar.bav());
                Iterator<com.baidu.adp.widget.ListView.i> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bwT() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.fID && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (dVar.baQ() && postData.bwW() != null) {
                        postData.c(null);
                    }
                    z3 = true;
                }
                if (z3 || dVar.baA() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData baA = dVar.baA();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, dVar.baA());
                    if (!this.fID && dVar.baQ() && baA.bwW() != null) {
                        baA.c(null);
                    }
                    postData2 = baA;
                    z4 = true;
                }
                cU(arrayList);
                if (this.fMQ.bcm()) {
                    if (dVar.bav().size() > 0 && (postData3 = dVar.bav().get(0)) != null && postData3.bwT() == 1 && !com.baidu.tbadk.core.util.v.E(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fIE, arrayList, this.fID);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.fIE.baw());
                    }
                }
                int b = b(this.fIE, arrayList, this.fID);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.fIE.bax());
                }
                if (arrayList.size() == 0 && this.fMQ.bcm()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.r(arrayList, 1);
                int c = c(dVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fHH);
                    if (dVar != null && dVar.bat() != null) {
                        hVar.fHJ = dVar.bat().zf();
                    }
                    hVar.isNew = !this.fID;
                    hVar.fHL = this.fMQ.bcy();
                    com.baidu.tbadk.core.util.v.a(arrayList, c, hVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.i> g = g(dVar);
                if (!com.baidu.tbadk.core.util.v.E(g) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, b2);
                    if (iVar instanceof PostData) {
                        ((PostData) iVar).hbk = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(dVar, arrayList) : -1;
                if (d < 0 || dVar.baP() == null) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, dVar.baP());
                    dVar.baP().jO((b(arrayList, d) || z5) ? false : true);
                    z6 = true;
                    z5 = true;
                }
                if (z4 && (bcM = bcM()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, bcM);
                }
                this.fMR.kh(!z5);
                boolean z7 = (this.fMQ.bbz() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.fMQ.bbz().getPostId())) ? false : true;
                if (this.fNf && !z7) {
                    arrayList.remove(postData2);
                    this.fNf = false;
                }
                if (z6 && (com.baidu.tbadk.core.util.v.f(arrayList, 0) instanceof com.baidu.tieba.pb.data.j)) {
                    kg(false);
                } else {
                    kg(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z7 && !z) {
                    if ((this.fNh || this.fNg) && b2 != -1 && !com.baidu.tbadk.core.util.v.E(g) && !this.fNi) {
                        this.fNl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fNn);
                                f.this.fNi = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.ns().post(this.fNl);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.i bcM() {
        PbModel bbz = this.fMQ.bbz();
        if (bbz == null) {
            return null;
        }
        String bdW = bbz.bdW();
        if (TextUtils.isEmpty(bdW)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.sL(bdW);
        b(lVar);
        return lVar;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, int i) {
        if (this.fMQ.baA() == null || this.fMQ.bbQ() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (this.fNg || dVar == null || com.baidu.tbadk.core.util.v.E(dVar.bav()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.baQ() && this.fID) ? 0 : -1;
        } else if (this.fMQ.bbz() == null || !this.fMQ.bbz().getIsFromMark()) {
            if (this.fMQ.bbQ() == null || !this.fMQ.bbQ().getIsInterviewLive()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i iVar = arrayList.get(i2);
                    if (iVar instanceof PostData) {
                        PostData postData = (PostData) iVar;
                        if (postData.bwT() == 1 && postData.hbh == 0) {
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
                return dVar.baQ() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.E(dVar.bav()) || com.baidu.tbadk.core.util.v.E(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.f(dVar.bav(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.i iVar = arrayList.get(i2);
            if (iVar instanceof PostData) {
                PostData postData = (PostData) iVar;
                if (postData.bwT() == 1 && postData.hbh == 0) {
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

    private int d(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (dVar == null || com.baidu.tbadk.core.util.v.E(dVar.bav()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.baQ()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.i iVar = arrayList.get(i);
            if ((iVar instanceof PostData) && ((PostData) iVar).bwT() == 1) {
                return i + 1;
            }
        }
        return !dVar.baQ() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.i> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.baE() == null || com.baidu.tbadk.core.util.v.E(dVar.baE().fIe)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.baE().fIe;
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.hbj = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.D(dVar.baE().fIf) > 2) {
            com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar instanceof PostData) {
                ((PostData) iVar).hbj = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar2 instanceof PostData) {
                ((PostData) iVar2).hbj = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fHI);
        hVar.fHK = dVar.baE().forum_top_list;
        arrayList.add(0, hVar);
        return arrayList;
    }

    private void axj() {
        if (this.fMQ != null && !axk()) {
            this.fMQ.registerListener(this.dKg);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean axk() {
        if (this.fMQ == null) {
            return false;
        }
        this.dJX = new ArrayList();
        ArrayList<BdUniqueId> bwi = com.baidu.tieba.tbadkCore.q.bwi();
        if (bwi == null || bwi.size() <= 0) {
            return false;
        }
        int size = bwi.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRe().a(this.fMQ.getPageContext(), bwi.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dJX.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.E(this.dJX)) {
            this.mListView.addAdapters(this.dJX);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (dVar == null || dVar.bav() == null || dVar.baw() == null || dVar.bav().size() == 0 || dVar.bat() == null || arrayList == null) {
            return -1;
        }
        if (dVar.baw().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bav().get(0) == null || dVar.bav().get(0).bwT() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.yA() == null || dVar.yA().yu() != dVar.yA().yr()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (dVar == null || dVar.bav() == null || dVar.bax() == null || dVar.bav().size() == 0 || dVar.bat() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bax().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bav().get(0) == null || dVar.bav().get(0).bwT() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.yA() == null || dVar.yA().yu() != dVar.yA().yr()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.i getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bcN() {
        return this.postList;
    }

    public BdUniqueId sM(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fMZ == null || !this.fMZ.bbs()) {
            this.fNm = bcO();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bcO() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.mListView.getData().get(i2);
                if (iVar == null || iVar.getType() != com.baidu.tieba.pb.data.h.fHH) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bcP() {
        return this.fNm;
    }

    private void bcQ() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fIE != null) {
            ArrayList<PostData> bav = this.fIE.bav();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> baI = this.fIE.baI();
            if (baI != null) {
                int size = baI.size();
                if (bav != null && bav.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = baI.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.getAdId() != null) {
                            sb.append(next.getAdId());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = baI.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dRU = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = baI.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bwI() != null) {
                            int xJ = next3.bwI().xJ();
                            if (xJ != 0) {
                                a(next3, xJ);
                                if (xJ != 28 && xJ != 31) {
                                    if (next3.bwI().goods != null) {
                                        next3.bwI().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bwI().apk_name)) {
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
                        if (this.fIE.bar() != null) {
                            lVar4.forumId = this.fIE.bar().getId();
                        }
                        if (this.fIE.bat() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fIE.bat().getId(), 0L);
                        }
                        if (this.fIE != null && this.fIE.yA() != null) {
                            lVar4.pageNumber = this.fIE.yA().yu();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= bav.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fID) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        bav.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fMQ.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bwI().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.uu(i);
        com.baidu.tieba.recapp.report.b.boW().a(c);
        if (lVar != null && lVar.bwI() != null) {
            lVar.bwI().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bwI() != null && lVar.bwI().goods != null && lVar.bwI().goods.goods_style != 1001 && lVar.bwI().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData bar;
        if (lVar != null && this.fIE != null && lVar.bwI() != null) {
            lVar.bwI().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fIE.yA() != null) {
                lVar.bwI().advertAppContext.pn = this.fIE.yA().yu();
            }
            lVar.bwI().advertAppContext.aJX = "PB";
            if (this.fIE.bar() != null && (bar = this.fIE.bar()) != null) {
                lVar.bwI().advertAppContext.fid = bar.getId();
                lVar.bwI().advertAppContext.aJZ = bar.getFirst_class();
                lVar.bwI().advertAppContext.aKa = bar.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bwI().advertAppContext.aKb = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bwI().advertAppContext.extensionInfo = lVar.bwI().ext_info;
            lVar.bwI().advertAppContext.aKc = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fNa.setFromCDN(z);
        this.fMR.setFromCDN(z);
        if (this.dRt != null && (this.dRt instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dRt).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fNe.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bcR() {
        return this.fIC;
    }

    public void jP(boolean z) {
        this.fIC = z;
    }

    public void jQ(boolean z) {
        this.fID = z;
    }

    public void jR(boolean z) {
        this.fNj = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fIH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLF = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bLG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmh = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void sN(int i) {
        if (this.fMS != null) {
            this.fMS.sN(i);
        }
        switch (i) {
            case 1:
                if (this.fMZ != null) {
                    this.fMZ.pause();
                }
                if (this.fMR != null) {
                    this.fMR.pause();
                    return;
                }
                return;
            case 2:
                if (this.fMZ != null) {
                    this.fMZ.resume();
                }
                if (this.fMR != null) {
                    this.fMR.resume();
                    return;
                }
                return;
            case 3:
                if (this.fMZ != null) {
                    this.fMZ.release();
                }
                if (this.fMR != null) {
                    this.fMR.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cU(List<com.baidu.adp.widget.ListView.i> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.Af())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.cU(postData.Af());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fNl);
        if (this.fMT != null) {
            this.fMT.onDestroy();
        }
        if (this.fMU != null) {
            this.fMU.onDestroy();
        }
    }

    public void kc(boolean z) {
        this.fNg = z;
    }

    public void kd(boolean z) {
        this.fNh = z;
    }

    public void ke(boolean z) {
        this.fNf = z;
    }

    public void kf(boolean z) {
        this.fNi = z;
    }

    public an bcS() {
        return this.fMS;
    }

    public void kg(boolean z) {
        if (this.fMS != null) {
            this.fMS.fTj = z;
        }
    }
}
