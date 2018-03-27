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
    private List<com.baidu.adp.widget.ListView.a> dKc;
    private com.baidu.adp.widget.ListView.a dRx;
    private com.baidu.adp.widget.ListView.a dRy;
    private int fIR;
    private com.baidu.tieba.pb.data.d fIU;
    private Runnable fNB;
    private int fND;
    private PbActivity fNg;
    private o fNh;
    private an fNi;
    private aj fNj;
    private aj fNk;
    private i fNl;
    private com.baidu.tieba.pb.video.a fNm;
    private af fNn;
    private ag fNo;
    private com.baidu.tieba.pb.pb.a.b fNp;
    private com.baidu.tieba.pb.pb.a.e fNq;
    private u fNr;
    private ad fNs;
    private com.baidu.tieba.pb.pb.a.d fNt;
    private boolean fNx;
    private boolean fNy;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fNu = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fIS = true;
    private boolean fIT = true;
    private boolean fNv = false;
    private boolean fNw = false;
    private boolean fNz = false;
    private String mHostId = null;
    private View.OnClickListener fIX = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bLI = null;
    private com.baidu.tieba.pb.a.c bLJ = null;
    private View.OnLongClickListener bmk = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fNA = new ArrayList();
    private int fNC = -1;
    private CustomMessageListener dKk = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bwz = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bwz();
                Iterator it = bwz.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ao(f.this.fNg);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fNu.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fNp = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bwz);
                f.this.fNA.clear();
                f.this.fNA.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener bjn = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fIU != null && !com.baidu.adp.base.i.ai(f.this.fNg.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener dKl = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.E(f.this.dKc)) {
                f.this.axm();
                f.this.a(f.this.fIU, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fIR = 0;
        this.width = -1;
        this.fND = 0;
        this.fIR = com.baidu.adp.lib.util.l.ao(pbActivity.getPageContext().getPageActivity());
        this.width = this.fIR;
        this.fNg = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bjn);
        this.fND = com.baidu.adp.lib.util.l.aq(this.fNg) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fNq = new com.baidu.tieba.pb.pb.a.e(pbActivity, PostData.hba);
        this.fNh = new o(pbActivity, PostData.haY);
        this.fNh.a(pbActivity);
        this.fNi = new an(pbActivity, com.baidu.tieba.pb.data.j.fIe);
        this.fNj = new aj(pbActivity, com.baidu.tieba.pb.data.h.fHX);
        this.fNk = new aj(pbActivity, com.baidu.tieba.pb.data.h.fHY);
        this.fNl = new i(pbActivity, PostData.haZ);
        this.fNl.a(pbActivity);
        this.dRx = com.baidu.tieba.recapp.r.bof().a(pbActivity, AdvertAppInfo.aKj);
        this.dRy = com.baidu.tieba.recapp.r.bof().a(pbActivity, AdvertAppInfo.aKn);
        this.fNr = new u(pbActivity, com.baidu.tieba.pb.data.a.fHf);
        this.fNs = new ad(pbActivity, com.baidu.tieba.pb.data.g.fHW);
        this.fNn = new af(pbActivity, ac.fSj);
        this.fNo = new ag(pbActivity, com.baidu.tbadk.core.data.ao.aNt);
        this.fNt = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.hbd);
        this.fNm = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.gbt);
        this.fNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fIU.baF() != null) {
                    pbActivity.bbR().beR().bbv();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fNh);
        this.mAdapters.add(this.fNi);
        this.mAdapters.add(this.fNl);
        this.mAdapters.add(this.fNj);
        this.mAdapters.add(this.fNk);
        this.mAdapters.add(this.fNq);
        this.mAdapters.add(this.dRx);
        this.mAdapters.add(this.dRy);
        this.mAdapters.add(this.fNr);
        this.mAdapters.add(this.fNs);
        this.mAdapters.add(this.fNn);
        this.mAdapters.add(this.fNo);
        this.mAdapters.add(this.fNm);
        this.mAdapters.add(this.fNt);
        this.dKk.setPriority(1);
        this.dKk.setSelfListener(true);
        pbActivity.registerListener(this.dKk);
        axl();
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
            if (this.fIU != dVar) {
                z2 = (dVar == null || dVar.baq()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.fIU = dVar;
            if (z2) {
                bcR();
                if (dVar != null) {
                    dVar.jS(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fIU != null && this.fIU.baw() != null && this.fIU.baw().size() > 0) {
                this.postList.addAll(this.fIU.baw());
            }
            if (dVar != null && dVar.bau() != null && dVar.bau().zn() != null) {
                this.mHostId = dVar.bau().zn().getUserId();
            }
            if (this.fNh != null) {
                this.fNq.b(dVar);
                this.fNq.setFromCDN(this.mIsFromCDN);
                this.fNq.setHostId(this.mHostId);
                this.fNq.sF(this.fIR);
                this.fNq.jU(this.fIS);
                this.fNq.jV(this.fIT);
                this.fNq.l(this.mCommonClickListener);
                this.fNq.E(this.fIX);
                this.fNq.setOnImageClickListener(this.bLI);
                this.fNq.setOnLongClickListener(this.bmk);
                this.fNh.b(dVar);
                this.fNh.setFromCDN(this.mIsFromCDN);
                this.fNh.sF(this.fIR);
                this.fNh.jU(this.fIS);
                this.fNh.l(this.mCommonClickListener);
                this.fNh.E(this.fIX);
                this.fNh.setOnImageClickListener(this.bLI);
                this.fNh.setOnLongClickListener(this.bmk);
                this.fNh.setTbGestureDetector(this.bLJ);
                this.fNl.b(dVar);
                this.fNl.setFromCDN(this.mIsFromCDN);
                this.fNl.setHostId(this.mHostId);
                this.fNl.jU(this.fIS);
                this.fNl.l(this.mCommonClickListener);
                this.fNl.E(this.fIX);
                this.fNl.setOnImageClickListener(this.bLI);
                this.fNl.setOnLongClickListener(this.bmk);
                this.fNl.setTbGestureDetector(this.bLJ);
                this.fNi.setOnClickListener(this.mCommonClickListener);
                this.fNi.setTbGestureDetector(this.bLJ);
                this.fNt.setOnClickListener(this.mCommonClickListener);
                if (this.dRy != null && (this.dRy instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dRy).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fNu.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.sF(this.fIR);
                        next.jU(this.fIS);
                        next.jV(this.fIT);
                        next.jW(this.fNz);
                        next.l(this.mCommonClickListener);
                        next.E(this.fIX);
                        next.setOnImageClickListener(this.bLI);
                        next.setOnLongClickListener(this.bmk);
                    }
                }
                this.fNj.l(this.mCommonClickListener);
                this.fNk.l(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>(dVar.baw());
                Iterator<com.baidu.adp.widget.ListView.i> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bwY() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.fIT && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (dVar.baR() && postData.bxb() != null) {
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
                    if (!this.fIT && dVar.baR() && baB.bxb() != null) {
                        baB.c(null);
                    }
                    postData2 = baB;
                    z4 = true;
                }
                cU(arrayList);
                if (this.fNg.bcn()) {
                    if (dVar.baw().size() > 0 && (postData3 = dVar.baw().get(0)) != null && postData3.bwY() == 1 && !com.baidu.tbadk.core.util.v.E(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fIU, arrayList, this.fIT);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.fIU.bax());
                    }
                }
                int b = b(this.fIU, arrayList, this.fIT);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.fIU.bay());
                }
                if (arrayList.size() == 0 && this.fNg.bcn()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.r.r(arrayList, 1);
                int c = c(dVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fHX);
                    if (dVar != null && dVar.bau() != null) {
                        hVar.fHZ = dVar.bau().zf();
                    }
                    hVar.isNew = !this.fIT;
                    hVar.fIb = this.fNg.bcz();
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
                        ((PostData) iVar).hbI = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(dVar, arrayList) : -1;
                if (d < 0 || dVar.baQ() == null) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, dVar.baQ());
                    dVar.baQ().jT((b(arrayList, d) || z5) ? false : true);
                    z6 = true;
                    z5 = true;
                }
                if (z4 && (bcN = bcN()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, bcN);
                }
                this.fNh.km(!z5);
                boolean z7 = (this.fNg.bbA() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.fNg.bbA().getPostId())) ? false : true;
                if (this.fNv && !z7) {
                    arrayList.remove(postData2);
                    this.fNv = false;
                }
                if (z6 && (com.baidu.tbadk.core.util.v.f(arrayList, 0) instanceof com.baidu.tieba.pb.data.j)) {
                    kl(false);
                } else {
                    kl(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z7 && !z) {
                    if ((this.fNx || this.fNw) && b2 != -1 && !com.baidu.tbadk.core.util.v.E(g) && !this.fNy) {
                        this.fNB = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fND);
                                f.this.fNy = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.ns().post(this.fNB);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.i bcN() {
        PbModel bbA = this.fNg.bbA();
        if (bbA == null) {
            return null;
        }
        String bdX = bbA.bdX();
        if (TextUtils.isEmpty(bdX)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.sL(bdX);
        b(mVar);
        return mVar;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, int i) {
        if (this.fNg.baB() == null || this.fNg.bbR() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (this.fNw || dVar == null || com.baidu.tbadk.core.util.v.E(dVar.baw()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.baR() && this.fIT) ? 0 : -1;
        } else if (this.fNg.bbA() == null || !this.fNg.bbA().getIsFromMark()) {
            if (this.fNg.bbR() == null || !this.fNg.bbR().getIsInterviewLive()) {
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
                        if (postData.bwY() == 1 && postData.hbF == 0) {
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
                if (postData.bwY() == 1 && postData.hbF == 0) {
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
            if ((iVar instanceof PostData) && ((PostData) iVar).bwY() == 1) {
                return i + 1;
            }
        }
        return !dVar.baR() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.i> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.baF() == null || com.baidu.tbadk.core.util.v.E(dVar.baF().fIu)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.baF().fIu;
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.hbH = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.D(dVar.baF().fIv) > 2) {
            com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar instanceof PostData) {
                ((PostData) iVar).hbH = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar2 instanceof PostData) {
                ((PostData) iVar2).hbH = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fHY);
        hVar.fIa = dVar.baF().forum_top_list;
        arrayList.add(0, hVar);
        return arrayList;
    }

    private void axl() {
        if (this.fNg != null && !axm()) {
            this.fNg.registerListener(this.dKl);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean axm() {
        if (this.fNg == null) {
            return false;
        }
        this.dKc = new ArrayList();
        ArrayList<BdUniqueId> bwn = com.baidu.tieba.tbadkCore.r.bwn();
        if (bwn == null || bwn.size() <= 0) {
            return false;
        }
        int size = bwn.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRf().a(this.fNg.getPageContext(), bwn.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dKc.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.E(this.dKc)) {
            this.mListView.addAdapters(this.dKc);
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
                return (dVar.baw().get(0) == null || dVar.baw().get(0).bwY() != 1) ? -1 : 1;
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
                return (dVar.baw().get(0) == null || dVar.baw().get(0).bwY() != 1) ? -1 : 1;
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

    public BdUniqueId sM(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fNp == null || !this.fNp.bbt()) {
            this.fNC = bcP();
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
                if (iVar == null || iVar.getType() != com.baidu.tieba.pb.data.h.fHX) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bcQ() {
        return this.fNC;
    }

    private void bcR() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.fIU != null) {
            ArrayList<PostData> baw = this.fIU.baw();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> baJ = this.fIU.baJ();
            if (baJ != null) {
                int size = baJ.size();
                if (baw != null && baw.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = baJ.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = baJ.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.dRZ = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = baJ.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.bwN() != null) {
                            int xJ = next3.bwN().xJ();
                            if (xJ != 0) {
                                a(next3, xJ);
                                if (xJ != 28 && xJ != 31) {
                                    if (next3.bwN().goods != null) {
                                        next3.bwN().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.v.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bwN().apk_name)) {
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
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.m mVar4 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.fIU.bas() != null) {
                            mVar4.forumId = this.fIU.bas().getId();
                        }
                        if (this.fIU.bau() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.c(this.fIU.bau().getId(), 0L);
                        }
                        if (this.fIU != null && this.fIU.yA() != null) {
                            mVar4.pageNumber = this.fIU.yA().yu();
                        }
                        b(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= baw.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.fIT) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        baw.add(position2, mVar4);
                        TiebaStatic.eventStat(this.fNg.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", mVar4.bwN().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(mVar, 5);
        c.uu(i);
        com.baidu.tieba.recapp.report.b.boX().a(c);
        if (mVar != null && mVar.bwN() != null) {
            mVar.bwN().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.bwN() != null && mVar.bwN().goods != null && mVar.bwN().goods.goods_style != 1001 && mVar.bwN().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData bas;
        if (mVar != null && this.fIU != null && mVar.bwN() != null) {
            mVar.bwN().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fIU.yA() != null) {
                mVar.bwN().advertAppContext.pn = this.fIU.yA().yu();
            }
            mVar.bwN().advertAppContext.aJY = "PB";
            if (this.fIU.bas() != null && (bas = this.fIU.bas()) != null) {
                mVar.bwN().advertAppContext.fid = bas.getId();
                mVar.bwN().advertAppContext.aKa = bas.getFirst_class();
                mVar.bwN().advertAppContext.aKb = bas.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.bwN().advertAppContext.aKc = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.bwN().advertAppContext.extensionInfo = mVar.bwN().ext_info;
            mVar.bwN().advertAppContext.aKd = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fNq.setFromCDN(z);
        this.fNh.setFromCDN(z);
        if (this.dRy != null && (this.dRy instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dRy).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fNu.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bcS() {
        return this.fIS;
    }

    public void jU(boolean z) {
        this.fIS = z;
    }

    public void jV(boolean z) {
        this.fIT = z;
    }

    public void jW(boolean z) {
        this.fNz = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fIX = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bLI = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bLJ = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bmk = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void sN(int i) {
        if (this.fNi != null) {
            this.fNi.sN(i);
        }
        switch (i) {
            case 1:
                if (this.fNp != null) {
                    this.fNp.pause();
                }
                if (this.fNh != null) {
                    this.fNh.pause();
                    return;
                }
                return;
            case 2:
                if (this.fNp != null) {
                    this.fNp.resume();
                }
                if (this.fNh != null) {
                    this.fNh.resume();
                    return;
                }
                return;
            case 3:
                if (this.fNp != null) {
                    this.fNp.release();
                }
                if (this.fNh != null) {
                    this.fNh.release();
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
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fNB);
        if (this.fNj != null) {
            this.fNj.onDestroy();
        }
        if (this.fNk != null) {
            this.fNk.onDestroy();
        }
    }

    public void kh(boolean z) {
        this.fNw = z;
    }

    public void ki(boolean z) {
        this.fNx = z;
    }

    public void kj(boolean z) {
        this.fNv = z;
    }

    public void kk(boolean z) {
        this.fNy = z;
    }

    public an bcT() {
        return this.fNi;
    }

    public void kl(boolean z) {
        if (this.fNi != null) {
            this.fNi.fTz = z;
        }
    }
}
