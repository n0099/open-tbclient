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
    private List<com.baidu.adp.widget.ListView.a> dKj;
    private com.baidu.adp.widget.ListView.a dRE;
    private com.baidu.adp.widget.ListView.a dRF;
    private int fIM;
    private com.baidu.tieba.pb.data.d fIP;
    private PbActivity fNb;
    private o fNc;
    private an fNd;
    private aj fNe;
    private aj fNf;
    private i fNg;
    private com.baidu.tieba.pb.video.a fNh;
    private af fNi;
    private ag fNj;
    private com.baidu.tieba.pb.pb.a.b fNk;
    private com.baidu.tieba.pb.pb.a.e fNl;
    private u fNm;
    private ad fNn;
    private com.baidu.tieba.pb.pb.a.d fNo;
    private boolean fNs;
    private boolean fNt;
    private Runnable fNw;
    private int fNy;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fNp = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fIN = true;
    private boolean fIO = true;
    private boolean fNq = false;
    private boolean fNr = false;
    private boolean fNu = false;
    private String mHostId = null;
    private View.OnClickListener fIS = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bLS = null;
    private com.baidu.tieba.pb.a.c bLT = null;
    private View.OnLongClickListener bmu = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fNv = new ArrayList();
    private int fNx = -1;
    private CustomMessageListener dKr = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bwv = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bwv();
                Iterator it = bwv.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ao(f.this.fNb);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fNp.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fNk = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bwv);
                f.this.fNv.clear();
                f.this.fNv.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener bjx = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fIP != null && !com.baidu.adp.base.i.ai(f.this.fNb.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener dKs = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.E(f.this.dKj)) {
                f.this.axl();
                f.this.a(f.this.fIP, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fIM = 0;
        this.width = -1;
        this.fNy = 0;
        this.fIM = com.baidu.adp.lib.util.l.ao(pbActivity.getPageContext().getPageActivity());
        this.width = this.fIM;
        this.fNb = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bjx);
        this.fNy = com.baidu.adp.lib.util.l.aq(this.fNb) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fNl = new com.baidu.tieba.pb.pb.a.e(pbActivity, PostData.haR);
        this.fNc = new o(pbActivity, PostData.haP);
        this.fNc.a(pbActivity);
        this.fNd = new an(pbActivity, com.baidu.tieba.pb.data.j.fHZ);
        this.fNe = new aj(pbActivity, com.baidu.tieba.pb.data.h.fHS);
        this.fNf = new aj(pbActivity, com.baidu.tieba.pb.data.h.fHT);
        this.fNg = new i(pbActivity, PostData.haQ);
        this.fNg.a(pbActivity);
        this.dRE = com.baidu.tieba.recapp.r.bof().a(pbActivity, AdvertAppInfo.aKt);
        this.dRF = com.baidu.tieba.recapp.r.bof().a(pbActivity, AdvertAppInfo.aKx);
        this.fNm = new u(pbActivity, com.baidu.tieba.pb.data.a.fHa);
        this.fNn = new ad(pbActivity, com.baidu.tieba.pb.data.g.fHR);
        this.fNi = new af(pbActivity, ac.fSe);
        this.fNj = new ag(pbActivity, com.baidu.tbadk.core.data.ao.aND);
        this.fNo = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.haU);
        this.fNh = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.gbo);
        this.fNh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fIP.baF() != null) {
                    pbActivity.bbR().beR().bbv();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fNc);
        this.mAdapters.add(this.fNd);
        this.mAdapters.add(this.fNg);
        this.mAdapters.add(this.fNe);
        this.mAdapters.add(this.fNf);
        this.mAdapters.add(this.fNl);
        this.mAdapters.add(this.dRE);
        this.mAdapters.add(this.dRF);
        this.mAdapters.add(this.fNm);
        this.mAdapters.add(this.fNn);
        this.mAdapters.add(this.fNi);
        this.mAdapters.add(this.fNj);
        this.mAdapters.add(this.fNh);
        this.mAdapters.add(this.fNo);
        this.dKr.setPriority(1);
        this.dKr.setSelfListener(true);
        pbActivity.registerListener(this.dKr);
        axk();
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
        com.baidu.adp.widget.ListView.i bcN;
        PostData postData3;
        if (dVar != null) {
            if (this.fIP != dVar) {
                z2 = (dVar == null || dVar.baq()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.fIP = dVar;
            if (z2) {
                bcR();
                if (dVar != null) {
                    dVar.jN(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fIP != null && this.fIP.baw() != null && this.fIP.baw().size() > 0) {
                this.postList.addAll(this.fIP.baw());
            }
            if (dVar != null && dVar.bau() != null && dVar.bau().zn() != null) {
                this.mHostId = dVar.bau().zn().getUserId();
            }
            if (this.fNc != null) {
                this.fNl.b(dVar);
                this.fNl.setFromCDN(this.mIsFromCDN);
                this.fNl.setHostId(this.mHostId);
                this.fNl.sE(this.fIM);
                this.fNl.jP(this.fIN);
                this.fNl.jQ(this.fIO);
                this.fNl.l(this.mCommonClickListener);
                this.fNl.E(this.fIS);
                this.fNl.setOnImageClickListener(this.bLS);
                this.fNl.setOnLongClickListener(this.bmu);
                this.fNc.b(dVar);
                this.fNc.setFromCDN(this.mIsFromCDN);
                this.fNc.sE(this.fIM);
                this.fNc.jP(this.fIN);
                this.fNc.l(this.mCommonClickListener);
                this.fNc.E(this.fIS);
                this.fNc.setOnImageClickListener(this.bLS);
                this.fNc.setOnLongClickListener(this.bmu);
                this.fNc.setTbGestureDetector(this.bLT);
                this.fNg.b(dVar);
                this.fNg.setFromCDN(this.mIsFromCDN);
                this.fNg.setHostId(this.mHostId);
                this.fNg.jP(this.fIN);
                this.fNg.l(this.mCommonClickListener);
                this.fNg.E(this.fIS);
                this.fNg.setOnImageClickListener(this.bLS);
                this.fNg.setOnLongClickListener(this.bmu);
                this.fNg.setTbGestureDetector(this.bLT);
                this.fNd.setOnClickListener(this.mCommonClickListener);
                this.fNd.setTbGestureDetector(this.bLT);
                this.fNo.setOnClickListener(this.mCommonClickListener);
                if (this.dRF != null && (this.dRF instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dRF).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fNp.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.sE(this.fIM);
                        next.jP(this.fIN);
                        next.jQ(this.fIO);
                        next.jR(this.fNu);
                        next.l(this.mCommonClickListener);
                        next.E(this.fIS);
                        next.setOnImageClickListener(this.bLS);
                        next.setOnLongClickListener(this.bmu);
                    }
                }
                this.fNe.l(this.mCommonClickListener);
                this.fNf.l(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>(dVar.baw());
                Iterator<com.baidu.adp.widget.ListView.i> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bwU() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.fIO && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (dVar.baR() && postData.bwX() != null) {
                        postData.c(null);
                    }
                    z3 = true;
                }
                if (z3 || dVar.baB() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData baB = dVar.baB();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, dVar.baB());
                    if (!this.fIO && dVar.baR() && baB.bwX() != null) {
                        baB.c(null);
                    }
                    postData2 = baB;
                    z4 = true;
                }
                cU(arrayList);
                if (this.fNb.bcn()) {
                    if (dVar.baw().size() > 0 && (postData3 = dVar.baw().get(0)) != null && postData3.bwU() == 1 && !com.baidu.tbadk.core.util.v.E(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fIP, arrayList, this.fIO);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.fIP.bax());
                    }
                }
                int b = b(this.fIP, arrayList, this.fIO);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.fIP.bay());
                }
                if (arrayList.size() == 0 && this.fNb.bcn()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.r(arrayList, 1);
                int c = c(dVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fHS);
                    if (dVar != null && dVar.bau() != null) {
                        hVar.fHU = dVar.bau().zf();
                    }
                    hVar.isNew = !this.fIO;
                    hVar.fHW = this.fNb.bcz();
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
                        ((PostData) iVar).hbz = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(dVar, arrayList) : -1;
                if (d < 0 || dVar.baQ() == null) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, dVar.baQ());
                    dVar.baQ().jO((b(arrayList, d) || z5) ? false : true);
                    z6 = true;
                    z5 = true;
                }
                if (z4 && (bcN = bcN()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, bcN);
                }
                this.fNc.kh(!z5);
                boolean z7 = (this.fNb.bbA() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.fNb.bbA().getPostId())) ? false : true;
                if (this.fNq && !z7) {
                    arrayList.remove(postData2);
                    this.fNq = false;
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
                    if ((this.fNs || this.fNr) && b2 != -1 && !com.baidu.tbadk.core.util.v.E(g) && !this.fNt) {
                        this.fNw = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fNy);
                                f.this.fNt = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.ns().post(this.fNw);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.i bcN() {
        PbModel bbA = this.fNb.bbA();
        if (bbA == null) {
            return null;
        }
        String bdX = bbA.bdX();
        if (TextUtils.isEmpty(bdX)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.sL(bdX);
        b(lVar);
        return lVar;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, int i) {
        if (this.fNb.baB() == null || this.fNb.bbR() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (this.fNr || dVar == null || com.baidu.tbadk.core.util.v.E(dVar.baw()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.baR() && this.fIO) ? 0 : -1;
        } else if (this.fNb.bbA() == null || !this.fNb.bbA().getIsFromMark()) {
            if (this.fNb.bbR() == null || !this.fNb.bbR().getIsInterviewLive()) {
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
                        if (postData.bwU() == 1 && postData.hbw == 0) {
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
                return dVar.baR() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.E(dVar.baw()) || com.baidu.tbadk.core.util.v.E(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.f(dVar.baw(), 0)) == null) {
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
                if (postData.bwU() == 1 && postData.hbw == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.E(dVar.baw()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.baR()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.i iVar = arrayList.get(i);
            if ((iVar instanceof PostData) && ((PostData) iVar).bwU() == 1) {
                return i + 1;
            }
        }
        return !dVar.baR() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.i> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.baF() == null || com.baidu.tbadk.core.util.v.E(dVar.baF().fIp)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.baF().fIp;
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.hby = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.D(dVar.baF().fIq) > 2) {
            com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar instanceof PostData) {
                ((PostData) iVar).hby = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar2 instanceof PostData) {
                ((PostData) iVar2).hby = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fHT);
        hVar.fHV = dVar.baF().forum_top_list;
        arrayList.add(0, hVar);
        return arrayList;
    }

    private void axk() {
        if (this.fNb != null && !axl()) {
            this.fNb.registerListener(this.dKs);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean axl() {
        if (this.fNb == null) {
            return false;
        }
        this.dKj = new ArrayList();
        ArrayList<BdUniqueId> bwj = com.baidu.tieba.tbadkCore.q.bwj();
        if (bwj == null || bwj.size() <= 0) {
            return false;
        }
        int size = bwj.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRf().a(this.fNb.getPageContext(), bwj.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dKj.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.E(this.dKj)) {
            this.mListView.addAdapters(this.dKj);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (dVar == null || dVar.baw() == null || dVar.bax() == null || dVar.baw().size() == 0 || dVar.bau() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bax().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.baw().get(0) == null || dVar.baw().get(0).bwU() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.yA() == null || dVar.yA().yu() != dVar.yA().yr()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (dVar == null || dVar.baw() == null || dVar.bay() == null || dVar.baw().size() == 0 || dVar.bau() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bay().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.baw().get(0) == null || dVar.baw().get(0).bwU() != 1) ? -1 : 1;
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

    public ArrayList<PostData> bcO() {
        return this.postList;
    }

    public BdUniqueId sL(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fNk == null || !this.fNk.bbt()) {
            this.fNx = bcP();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bcP() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.mListView.getData().get(i2);
                if (iVar == null || iVar.getType() != com.baidu.tieba.pb.data.h.fHS) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bcQ() {
        return this.fNx;
    }

    private void bcR() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fIP != null) {
            ArrayList<PostData> baw = this.fIP.baw();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> baJ = this.fIP.baJ();
            if (baJ != null) {
                int size = baJ.size();
                if (baw != null && baw.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = baJ.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = baJ.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dSg = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = baJ.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bwJ() != null) {
                            int xJ = next3.bwJ().xJ();
                            if (xJ != 0) {
                                a(next3, xJ);
                                if (xJ != 28 && xJ != 31) {
                                    if (next3.bwJ().goods != null) {
                                        next3.bwJ().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bwJ().apk_name)) {
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
                        if (this.fIP.bas() != null) {
                            lVar4.forumId = this.fIP.bas().getId();
                        }
                        if (this.fIP.bau() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fIP.bau().getId(), 0L);
                        }
                        if (this.fIP != null && this.fIP.yA() != null) {
                            lVar4.pageNumber = this.fIP.yA().yu();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= baw.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fIO) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        baw.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fNb.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bwJ().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.ut(i);
        com.baidu.tieba.recapp.report.b.boX().a(c);
        if (lVar != null && lVar.bwJ() != null) {
            lVar.bwJ().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bwJ() != null && lVar.bwJ().goods != null && lVar.bwJ().goods.goods_style != 1001 && lVar.bwJ().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData bas;
        if (lVar != null && this.fIP != null && lVar.bwJ() != null) {
            lVar.bwJ().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fIP.yA() != null) {
                lVar.bwJ().advertAppContext.pn = this.fIP.yA().yu();
            }
            lVar.bwJ().advertAppContext.aKi = "PB";
            if (this.fIP.bas() != null && (bas = this.fIP.bas()) != null) {
                lVar.bwJ().advertAppContext.fid = bas.getId();
                lVar.bwJ().advertAppContext.aKk = bas.getFirst_class();
                lVar.bwJ().advertAppContext.aKl = bas.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bwJ().advertAppContext.aKm = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bwJ().advertAppContext.extensionInfo = lVar.bwJ().ext_info;
            lVar.bwJ().advertAppContext.aKn = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fNl.setFromCDN(z);
        this.fNc.setFromCDN(z);
        if (this.dRF != null && (this.dRF instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dRF).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fNp.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bcS() {
        return this.fIN;
    }

    public void jP(boolean z) {
        this.fIN = z;
    }

    public void jQ(boolean z) {
        this.fIO = z;
    }

    public void jR(boolean z) {
        this.fNu = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fIS = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLS = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bLT = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmu = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void sM(int i) {
        if (this.fNd != null) {
            this.fNd.sM(i);
        }
        switch (i) {
            case 1:
                if (this.fNk != null) {
                    this.fNk.pause();
                }
                if (this.fNc != null) {
                    this.fNc.pause();
                    return;
                }
                return;
            case 2:
                if (this.fNk != null) {
                    this.fNk.resume();
                }
                if (this.fNc != null) {
                    this.fNc.resume();
                    return;
                }
                return;
            case 3:
                if (this.fNk != null) {
                    this.fNk.release();
                }
                if (this.fNc != null) {
                    this.fNc.release();
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
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fNw);
        if (this.fNe != null) {
            this.fNe.onDestroy();
        }
        if (this.fNf != null) {
            this.fNf.onDestroy();
        }
    }

    public void kc(boolean z) {
        this.fNr = z;
    }

    public void kd(boolean z) {
        this.fNs = z;
    }

    public void ke(boolean z) {
        this.fNq = z;
    }

    public void kf(boolean z) {
        this.fNt = z;
    }

    public an bcT() {
        return this.fNd;
    }

    public void kg(boolean z) {
        if (this.fNd != null) {
            this.fNd.fTu = z;
        }
    }
}
