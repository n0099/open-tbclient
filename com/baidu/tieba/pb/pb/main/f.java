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
    private List<com.baidu.adp.widget.ListView.a> dem;
    private com.baidu.adp.widget.ListView.a dmM;
    private com.baidu.adp.widget.ListView.a dmN;
    private PbActivity fhQ;
    private o fhR;
    private ao fhS;
    private aj fhT;
    private aj fhU;
    private i fhV;
    private com.baidu.tieba.pb.video.a fhW;
    private af fhX;
    private ag fhY;
    private com.baidu.tieba.pb.pb.a.b fhZ;
    private u fia;
    private ad fib;
    private com.baidu.tieba.pb.pb.a.d fic;
    private an fie;
    private com.baidu.tieba.pb.data.d fig;
    private boolean fil;
    private boolean fim;
    private int fio;
    private Runnable fir;
    private int fit;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fif = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fih = true;
    private boolean fii = true;
    private boolean fij = false;
    private boolean fik = false;
    private boolean fin = false;
    private String mHostId = null;
    private View.OnClickListener fip = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h aWx = null;
    private com.baidu.tieba.pb.a.c aWy = null;
    private View.OnLongClickListener axX = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fiq = new ArrayList();
    private int fis = -1;
    private CustomMessageListener ddt = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList brz = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).brz();
                Iterator it = brz.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).aq(f.this.fhQ);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fif.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fhZ = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(brz);
                f.this.fiq.clear();
                f.this.fiq.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener auS = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fig != null && !com.baidu.adp.base.i.Z(f.this.fhQ.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dew = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.w(f.this.dem)) {
                f.this.arJ();
                f.this.a(f.this.fig, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fio = 0;
        this.width = -1;
        this.fit = 0;
        this.fio = com.baidu.adp.lib.util.l.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.fio;
        this.fhQ = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.auS);
        this.fit = com.baidu.adp.lib.util.l.ah(this.fhQ) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fhR = new o(pbActivity, PostData.gxv);
        this.fhR.a(pbActivity);
        this.fhS = new ao(pbActivity, com.baidu.tieba.pb.data.j.fdM);
        this.fhT = new aj(pbActivity, com.baidu.tieba.pb.data.h.fdF);
        this.fhU = new aj(pbActivity, com.baidu.tieba.pb.data.h.fdG);
        this.fhV = new i(pbActivity, PostData.gxw);
        this.fhV.a(pbActivity);
        this.dmM = com.baidu.tieba.recapp.r.bjk().a(pbActivity, AdvertAppInfo.Vz);
        this.dmN = com.baidu.tieba.recapp.r.bjk().a(pbActivity, AdvertAppInfo.VD);
        this.fia = new u(pbActivity, com.baidu.tieba.pb.data.a.fcO);
        this.fib = new ad(pbActivity, com.baidu.tieba.pb.data.g.fdE);
        this.fhX = new af(pbActivity, ac.fnm);
        this.fhY = new ag(pbActivity, com.baidu.tbadk.core.data.ap.YU);
        this.fic = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gxA);
        this.fie = new an(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fhW = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fwF);
        this.fhW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.fig.aVD() != null) {
                    pbActivity.aWO().aZO().aWs();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fhR);
        this.mAdapters.add(this.fhS);
        this.mAdapters.add(this.fhV);
        this.mAdapters.add(this.fhT);
        this.mAdapters.add(this.fhU);
        this.mAdapters.add(this.dmM);
        this.mAdapters.add(this.dmN);
        this.mAdapters.add(this.fia);
        this.mAdapters.add(this.fib);
        this.mAdapters.add(this.fhX);
        this.mAdapters.add(this.fhY);
        this.mAdapters.add(this.fhW);
        this.mAdapters.add(this.fic);
        this.mAdapters.add(this.fie);
        this.ddt.setPriority(1);
        this.ddt.setSelfListener(true);
        pbActivity.registerListener(this.ddt);
        arI();
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
        boolean z7;
        com.baidu.adp.widget.ListView.h aXL;
        PostData postData3;
        if (dVar != null) {
            if (this.fig != dVar) {
                z2 = (dVar == null || dVar.aVp()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.fig = dVar;
            if (z2) {
                aXP();
                if (dVar != null) {
                    dVar.jp(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fig != null && this.fig.aVu() != null && this.fig.aVu().size() > 0) {
                this.postList.addAll(this.fig.aVu());
            }
            if (dVar != null && dVar.aVs() != null && dVar.aVs().rP() != null) {
                this.mHostId = dVar.aVs().rP().getUserId();
            }
            if (this.fhR != null) {
                this.fhR.b(dVar);
                this.fhR.setFromCDN(this.mIsFromCDN);
                this.fhR.pZ(this.fio);
                this.fhR.jr(this.fih);
                this.fhR.n(this.mCommonClickListener);
                this.fhR.F(this.fip);
                this.fhR.setOnImageClickListener(this.aWx);
                this.fhR.setOnLongClickListener(this.axX);
                this.fhR.setTbGestureDetector(this.aWy);
                this.fhV.b(dVar);
                this.fhV.setFromCDN(this.mIsFromCDN);
                this.fhV.setHostId(this.mHostId);
                this.fhV.jr(this.fih);
                this.fhV.n(this.mCommonClickListener);
                this.fhV.F(this.fip);
                this.fhV.setOnImageClickListener(this.aWx);
                this.fhV.setOnLongClickListener(this.axX);
                this.fhV.setTbGestureDetector(this.aWy);
                this.fhS.setOnClickListener(this.mCommonClickListener);
                this.fhS.setTbGestureDetector(this.aWy);
                this.fic.setOnClickListener(this.mCommonClickListener);
                if (this.dmN != null && (this.dmN instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dmN).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fif.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.pZ(this.fio);
                        next.jr(this.fih);
                        next.js(this.fii);
                        next.jt(this.fin);
                        next.n(this.mCommonClickListener);
                        next.F(this.fip);
                        next.setOnImageClickListener(this.aWx);
                        next.setOnLongClickListener(this.axX);
                    }
                }
                this.fhT.n(this.mCommonClickListener);
                this.fhU.n(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.aVu());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).brX() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.fii && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (dVar.aVP() && postData.brZ() != null) {
                        postData.c(null);
                    }
                    z3 = true;
                }
                if (z3 || dVar.aVz() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aVz = dVar.aVz();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, dVar.aVz());
                    if (!this.fii && dVar.aVP() && aVz.brZ() != null) {
                        aVz.c(null);
                    }
                    postData2 = aVz;
                    z4 = true;
                }
                cP(arrayList);
                if (this.fhQ.aXl()) {
                    if (dVar.aVu().size() > 0 && (postData3 = dVar.aVu().get(0)) != null && postData3.brX() == 1 && !com.baidu.tbadk.core.util.v.w(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fig, arrayList, this.fii);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.fig.aVv());
                    }
                }
                int b = b(this.fig, arrayList, this.fii);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.fig.aVw());
                }
                if (arrayList.size() == 0 && this.fhQ.aXl()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.n(arrayList, 1);
                int c = c(dVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fdF);
                    if (dVar != null && dVar.aVs() != null) {
                        hVar.fdH = dVar.aVs().rH();
                    }
                    hVar.isNew = !this.fii;
                    hVar.fdJ = this.fhQ.aXx();
                    com.baidu.tbadk.core.util.v.a(arrayList, c, hVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.h> g = g(dVar);
                if (!com.baidu.tbadk.core.util.v.w(g) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.c(arrayList, b2);
                    if (hVar2 instanceof PostData) {
                        ((PostData) hVar2).gyf = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(dVar, arrayList) : -1;
                if (d < 0 || dVar.aVO() == null) {
                    z6 = z5;
                    z7 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, dVar.aVO());
                    dVar.aVO().jq((b(arrayList, d) || z5) ? false : true);
                    z7 = true;
                    z6 = true;
                }
                if (!this.fhQ.aXu() && this.fig != null && this.fig.aVq() != null && !StringUtils.isNull(this.fig.aVq().getName()) && !StringUtils.isNull(this.fig.aVq().getId())) {
                    d++;
                    com.baidu.tbadk.core.util.v.a(arrayList, d, this.fig.aVq());
                    if (this.fie != null && this.fig.aVs() != null) {
                        this.fie.setThreadId(this.fig.aVs().getId());
                    }
                }
                if (z4 && (aXL = aXL()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, aXL);
                }
                this.fhR.jJ(!z6);
                boolean z8 = (this.fhQ.aWx() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.fhQ.aWx().getPostId())) ? false : true;
                if (this.fij && !z8) {
                    arrayList.remove(postData2);
                    this.fij = false;
                }
                if (z7 && (com.baidu.tbadk.core.util.v.c(arrayList, 0) instanceof com.baidu.tieba.pb.data.j)) {
                    jI(false);
                } else {
                    jI(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z8 && !z) {
                    if ((this.fil || this.fik) && b2 != -1 && !com.baidu.tbadk.core.util.v.w(g) && !this.fim) {
                        this.fir = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fit);
                                f.this.fim = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fw().post(this.fir);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h aXL() {
        PbModel aWx = this.fhQ.aWx();
        if (aWx == null) {
            return null;
        }
        String aYU = aWx.aYU();
        if (TextUtils.isEmpty(aYU)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.sV(aYU);
        b(lVar);
        return lVar;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, int i) {
        if (this.fhQ.aVz() == null || this.fhQ.aWO() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fik || dVar == null || com.baidu.tbadk.core.util.v.w(dVar.aVu()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.aVP() && this.fii) ? 0 : -1;
        } else if (this.fhQ.aWx() == null || !this.fhQ.aWx().getIsFromMark()) {
            if (this.fhQ.aWO() == null || !this.fhQ.aWO().baN()) {
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
                        if (postData.brX() == 1 && postData.gyc == 0) {
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
                return dVar.aVP() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.w(dVar.aVu()) || com.baidu.tbadk.core.util.v.w(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.aVu(), 0)) == null) {
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
                if (postData.brX() == 1 && postData.gyc == 0) {
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

    private int d(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (dVar == null || com.baidu.tbadk.core.util.v.w(dVar.aVu()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.aVP()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i);
            if ((hVar instanceof PostData) && ((PostData) hVar).brX() == 1) {
                return i + 1;
            }
        }
        return !dVar.aVP() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.aVD() == null || com.baidu.tbadk.core.util.v.w(dVar.aVD().feb)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.aVD().feb;
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gye = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.v(dVar.aVD().fec) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).gye = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).gye = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fdG);
        hVar3.fdI = dVar.aVD().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void arI() {
        if (this.fhQ != null && !arJ()) {
            this.fhQ.registerListener(this.dew);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean arJ() {
        if (this.fhQ == null) {
            return false;
        }
        this.dem = new ArrayList();
        ArrayList<BdUniqueId> brl = com.baidu.tieba.tbadkCore.q.brl();
        if (brl == null || brl.size() <= 0) {
            return false;
        }
        int size = brl.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aMd().a(this.fhQ.getPageContext(), brl.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dem.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.w(this.dem)) {
            this.mListView.addAdapters(this.dem);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.aVu() == null || dVar.aVv() == null || dVar.aVu().size() == 0 || dVar.aVs() == null || arrayList == null) {
            return -1;
        }
        if (dVar.aVv().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.aVu().get(0) == null || dVar.aVu().get(0).brX() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.rf() == null || dVar.rf().qZ() != dVar.rf().qW()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.aVu() == null || dVar.aVw() == null || dVar.aVu().size() == 0 || dVar.aVs() == null || arrayList == null) {
            return -1;
        }
        if (dVar.aVw().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.aVu().get(0) == null || dVar.aVu().get(0).brX() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.rf() == null || dVar.rf().qZ() != dVar.rf().qW()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aXM() {
        return this.postList;
    }

    public BdUniqueId qh(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fhZ == null || !this.fhZ.aWq()) {
            this.fis = aXN();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int aXN() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fdF) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aXO() {
        return this.fis;
    }

    private void aXP() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fig != null) {
            ArrayList<PostData> aVu = this.fig.aVu();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aVH = this.fig.aVH();
            if (aVH != null) {
                int size = aVH.size();
                if (aVu != null && aVu.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aVH.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aVH.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dnk = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aVH.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.brN() != null) {
                            int qr = next3.brN().qr();
                            if (qr != 0) {
                                a(next3, qr);
                                if (qr != 28 && qr != 31) {
                                    if (next3.brN().goods != null) {
                                        next3.brN().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.brN().apk_name)) {
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
                        if (this.fig.aVq() != null) {
                            lVar4.forumId = this.fig.aVq().getId();
                        }
                        if (this.fig.aVs() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fig.aVs().getId(), 0L);
                        }
                        if (this.fig != null && this.fig.rf() != null) {
                            lVar4.pageNumber = this.fig.rf().qZ();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aVu.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fii) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aVu.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fhQ.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.brN().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.rT(i);
        com.baidu.tieba.recapp.report.b.bkd().a(c);
        if (lVar != null && lVar.brN() != null) {
            lVar.brN().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.brN() != null && lVar.brN().goods != null && lVar.brN().goods.goods_style != 1001 && lVar.brN().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aVq;
        if (lVar != null && this.fig != null && lVar.brN() != null) {
            lVar.brN().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fig.rf() != null) {
                lVar.brN().advertAppContext.pn = this.fig.rf().qZ();
            }
            lVar.brN().advertAppContext.Vp = "PB";
            if (this.fig.aVq() != null && (aVq = this.fig.aVq()) != null) {
                lVar.brN().advertAppContext.fid = aVq.getId();
                lVar.brN().advertAppContext.Vr = aVq.getFirst_class();
                lVar.brN().advertAppContext.Vs = aVq.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.brN().advertAppContext.Vt = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.brN().advertAppContext.extensionInfo = lVar.brN().ext_info;
            lVar.brN().advertAppContext.IM = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fhR.setFromCDN(z);
        if (this.dmN != null && (this.dmN instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dmN).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fif.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean aXQ() {
        return this.fih;
    }

    public void jr(boolean z) {
        this.fih = z;
    }

    public void js(boolean z) {
        this.fii = z;
    }

    public void jt(boolean z) {
        this.fin = z;
    }

    public void F(View.OnClickListener onClickListener) {
        this.fip = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWx = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aWy = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axX = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void qi(int i) {
        if (this.fhS != null) {
            this.fhS.qi(i);
        }
        switch (i) {
            case 1:
                if (this.fhZ != null) {
                    this.fhZ.pause();
                }
                if (this.fhR != null) {
                    this.fhR.pause();
                    return;
                }
                return;
            case 2:
                if (this.fhZ != null) {
                    this.fhZ.resume();
                }
                if (this.fhR != null) {
                    this.fhR.resume();
                    return;
                }
                return;
            case 3:
                if (this.fhZ != null) {
                    this.fhZ.release();
                }
                if (this.fhR != null) {
                    this.fhR.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cP(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sG())) {
                        com.baidu.tbadk.core.data.ac acVar = new com.baidu.tbadk.core.data.ac();
                        acVar.cI(postData.sG());
                        list.set(i, acVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fir);
        if (this.fhT != null) {
            this.fhT.onDestroy();
        }
        if (this.fhU != null) {
            this.fhU.onDestroy();
        }
    }

    public void jE(boolean z) {
        this.fik = z;
    }

    public void jF(boolean z) {
        this.fil = z;
    }

    public void jG(boolean z) {
        this.fij = z;
    }

    public void jH(boolean z) {
        this.fim = z;
    }

    public ao aXR() {
        return this.fhS;
    }

    public void jI(boolean z) {
        if (this.fhS != null) {
            this.fhS.foI = z;
        }
    }
}
