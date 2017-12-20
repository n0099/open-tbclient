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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
/* loaded from: classes.dex */
public class h {
    private List<com.baidu.adp.widget.ListView.a> cNb;
    private com.baidu.adp.widget.ListView.a cRh;
    private com.baidu.adp.widget.ListView.a cRi;
    private int eQO;
    private com.baidu.tieba.pb.data.f eQR;
    private v eVA;
    private ad eVB;
    private com.baidu.tieba.pb.pb.a.d eVC;
    private boolean eVG;
    private boolean eVH;
    private Runnable eVK;
    private PbActivity eVp;
    private q eVq;
    private an eVr;
    private aj eVs;
    private aj eVt;
    private k eVu;
    private com.baidu.tieba.pb.video.a eVv;
    private af eVw;
    private ag eVx;
    private com.baidu.tieba.pb.pb.a.b eVy;
    private com.baidu.tieba.pb.pb.a.e eVz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eVD = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eQP = true;
    private boolean eQQ = true;
    private boolean eVE = false;
    private boolean eVF = false;
    private boolean eVI = false;
    private String mHostId = null;
    private View.OnClickListener eQU = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.g aVG = null;
    private com.baidu.tieba.pb.a.c aVH = null;
    private View.OnLongClickListener avF = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eVJ = new ArrayList();
    private int eVL = -1;
    private CustomMessageListener cNk = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bwv = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bwv();
                Iterator it = bwv.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).ao(h.this.eVp);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            h.this.eVD.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            h.this.eVy = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bwv);
                h.this.eVJ.clear();
                h.this.eVJ.addAll(arrayList);
                if (h.this.mListView != null) {
                    h.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cIk = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.h.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && h.this.eQR != null && !com.baidu.adp.base.i.W(h.this.eVp.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener cNl = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.h.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.w(h.this.cNb)) {
                h.this.anA();
                h.this.a(h.this.eQR, false);
            }
        }
    };

    public h(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eQO = 0;
        this.width = -1;
        this.eQO = com.baidu.adp.lib.util.l.ac(pbActivity.getPageContext().getPageActivity());
        this.width = this.eQO;
        this.eVp = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cIk);
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eVz = new com.baidu.tieba.pb.pb.a.e(pbActivity, PostData.gBQ);
        this.eVq = new q(pbActivity, PostData.gBN);
        this.eVq.a(pbActivity);
        this.eVr = new an(pbActivity, com.baidu.tieba.pb.data.l.eQc);
        this.eVs = new aj(pbActivity, com.baidu.tieba.pb.data.j.ePV);
        this.eVt = new aj(pbActivity, com.baidu.tieba.pb.data.j.ePW);
        this.eVu = new k(pbActivity, PostData.gBO);
        this.eVu.a(pbActivity);
        this.cRh = com.baidu.tieba.recapp.q.blQ().a(pbActivity, AdvertAppInfo.Uy);
        this.cRi = com.baidu.tieba.recapp.q.blQ().a(pbActivity, AdvertAppInfo.UD);
        this.eVA = new v(pbActivity, com.baidu.tieba.pb.data.a.ePb);
        this.eVB = new ad(pbActivity, com.baidu.tieba.pb.data.i.ePU);
        this.eVw = new af(pbActivity, ac.fae);
        this.eVx = new ag(pbActivity, com.baidu.tbadk.core.data.ao.XK);
        this.eVC = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gBU);
        this.eVv = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fjk);
        this.eVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.eQR.aRz() != null) {
                    pbActivity.aSQ().aVT().aSr();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.mAdapters.add(this.eVq);
        this.mAdapters.add(this.eVr);
        this.mAdapters.add(this.eVu);
        this.mAdapters.add(this.eVs);
        this.mAdapters.add(this.eVt);
        this.mAdapters.add(this.eVz);
        this.mAdapters.add(this.cRh);
        this.mAdapters.add(this.cRi);
        this.mAdapters.add(this.eVA);
        this.mAdapters.add(this.eVB);
        this.mAdapters.add(this.eVw);
        this.mAdapters.add(this.eVx);
        this.mAdapters.add(this.eVv);
        this.mAdapters.add(this.eVC);
        this.cNk.setPriority(1);
        this.cNk.setSelfListener(true);
        pbActivity.registerListener(this.cNk);
        anz();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        PostData postData2;
        boolean z5;
        com.baidu.adp.widget.ListView.f aTP;
        PostData postData3;
        boolean z6 = true;
        if (fVar != null) {
            if (this.eQR != fVar) {
                z2 = (fVar == null || fVar.aRl()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eQR = fVar;
            if (z2) {
                aTU();
                if (fVar != null) {
                    fVar.iW(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eQR != null && this.eQR.aRr() != null && this.eQR.aRr().size() > 0) {
                this.postList.addAll(this.eQR.aRr());
            }
            if (fVar != null && fVar.aRp() != null && fVar.aRp().rv() != null) {
                this.mHostId = fVar.aRp().rv().getUserId();
            }
            if (this.eVq != null) {
                this.eVz.b(fVar);
                this.eVz.setFromCDN(this.mIsFromCDN);
                this.eVz.setHostId(this.mHostId);
                this.eVz.pO(this.eQO);
                this.eVz.iY(this.eQP);
                this.eVz.iZ(this.eQQ);
                this.eVz.setCommonClickListener(this.mCommonClickListener);
                this.eVz.D(this.eQU);
                this.eVz.setOnImageClickListener(this.aVG);
                this.eVz.setOnLongClickListener(this.avF);
                this.eVq.b(fVar);
                this.eVq.setFromCDN(this.mIsFromCDN);
                this.eVq.pO(this.eQO);
                this.eVq.iY(this.eQP);
                this.eVq.setCommonClickListener(this.mCommonClickListener);
                this.eVq.D(this.eQU);
                this.eVq.setOnImageClickListener(this.aVG);
                this.eVq.setOnLongClickListener(this.avF);
                this.eVq.setTbGestureDetector(this.aVH);
                this.eVu.b(fVar);
                this.eVu.setFromCDN(this.mIsFromCDN);
                this.eVu.setHostId(this.mHostId);
                this.eVu.iY(this.eQP);
                this.eVu.setCommonClickListener(this.mCommonClickListener);
                this.eVu.D(this.eQU);
                this.eVu.setOnImageClickListener(this.aVG);
                this.eVu.setOnLongClickListener(this.avF);
                this.eVu.setTbGestureDetector(this.aVH);
                this.eVr.setOnClickListener(this.mCommonClickListener);
                this.eVr.setTbGestureDetector(this.aVH);
                this.eVC.setOnClickListener(this.mCommonClickListener);
                if (this.cRi != null && (this.cRi instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.cRi).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eVD.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.pO(this.eQO);
                        next.iY(this.eQP);
                        next.iZ(this.eQQ);
                        next.ja(this.eVI);
                        next.setCommonClickListener(this.mCommonClickListener);
                        next.D(this.eQU);
                        next.setOnImageClickListener(this.aVG);
                        next.setOnLongClickListener(this.avF);
                    }
                }
                this.eVs.setCommonClickListener(this.mCommonClickListener);
                this.eVt.setCommonClickListener(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aRr());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bwU() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.eQQ && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aRM() && postData.bwX() != null) {
                        postData.d(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aRw() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aRw = fVar.aRw();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aRw());
                    if (!this.eQQ && fVar.aRM() && aRw.bwX() != null) {
                        aRw.d(null);
                    }
                    postData2 = aRw;
                    z4 = true;
                }
                cJ(arrayList);
                if (this.eVp.aTo()) {
                    if (fVar.aRr().size() > 0 && (postData3 = fVar.aRr().get(0)) != null && postData3.bwU() == 1 && !com.baidu.tbadk.core.util.v.w(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.eQR, arrayList, this.eQQ);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.eQR.aRs());
                    }
                }
                int b = b(this.eQR, arrayList, this.eQQ);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.eQR.aRt());
                }
                if (arrayList.size() == 0 && this.eVp.aTo()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                com.baidu.tieba.tbadkCore.p.p(arrayList, 1);
                int c = c(fVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.ePV);
                    if (fVar != null && fVar.aRp() != null) {
                        jVar.ePX = fVar.aRp().rn();
                    }
                    jVar.aFP = !this.eQQ;
                    jVar.ePZ = this.eVp.aTB();
                    com.baidu.tbadk.core.util.v.a(arrayList, c, jVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(fVar, arrayList);
                final List<com.baidu.adp.widget.ListView.f> g = g(fVar);
                if (!com.baidu.tbadk.core.util.v.w(g) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, b2);
                    if (fVar2 instanceof PostData) {
                        ((PostData) fVar2).cTd = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d >= 0 && fVar.aRL() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aRL());
                    fVar.aRL().iX((a(arrayList, d) || z5) ? false : true);
                    z5 = true;
                }
                if (z4 && (aTP = aTP()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, aTP);
                }
                this.eVq.jq(!z5);
                if (this.eVp.aSw() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.eVp.aSw().getPostId())) {
                    z6 = false;
                }
                if (this.eVE && !z6) {
                    arrayList.remove(postData2);
                    this.eVE = false;
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z6 && !z) {
                    if ((this.eVG || this.eVF) && b2 != -1 && !com.baidu.tbadk.core.util.v.w(g) && !this.eVH) {
                        this.eVK = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.4
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.mListView.setSelection(h.this.mListView.getHeaderViewsCount() + g.size());
                                h.this.eVH = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fP().post(this.eVK);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.f aTP() {
        PbModel aSw = this.eVp.aSw();
        if (aSw == null) {
            return null;
        }
        String aUY = aSw.aUY();
        if (TextUtils.isEmpty(aUY)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.td(aUY);
        b(lVar);
        return lVar;
    }

    private boolean a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        if (this.eVp.aRw() == null || this.eVp.aSQ() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (this.eVF || fVar == null || com.baidu.tbadk.core.util.v.w(fVar.aRr()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aRM() && this.eQQ) ? 0 : -1;
        } else if (this.eVp.aSw() == null || !this.eVp.aSw().getIsFromMark()) {
            if (this.eVp.aSQ() == null || !this.eVp.aSQ().getIsInterviewLive()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
                    if (fVar2 instanceof PostData) {
                        PostData postData = (PostData) fVar2;
                        if (postData.bwU() == 1 && postData.gCw == 0) {
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
                return fVar.aRM() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.w(fVar.aRr()) || com.baidu.tbadk.core.util.v.w(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(fVar.aRr(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
            if (fVar2 instanceof PostData) {
                PostData postData = (PostData) fVar2;
                if (postData.bwU() == 1 && postData.gCw == 0) {
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

    private int d(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (fVar == null || com.baidu.tbadk.core.util.v.w(fVar.aRr()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aRM()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i);
            if ((fVar2 instanceof PostData) && ((PostData) fVar2).bwU() == 1) {
                return i + 1;
            }
        }
        return !fVar.aRM() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.f> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aRz() == null || com.baidu.tbadk.core.util.v.w(fVar.aRz().eQr)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aRz().eQr;
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gCy = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.v(fVar.aRz().eQs) > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).gCy = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).gCy = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.ePW);
        jVar.ePY = fVar.aRz().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void anz() {
        if (this.eVp != null && !anA()) {
            this.eVp.registerListener(this.cNl);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean anA() {
        if (this.eVp == null) {
            return false;
        }
        this.cNb = new ArrayList();
        ArrayList<BdUniqueId> bwf = com.baidu.tieba.tbadkCore.p.bwf();
        if (bwf == null || bwf.size() <= 0) {
            return false;
        }
        int size = bwf.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aIj().a(this.eVp.getPageContext(), bwf.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cNb.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.w(this.cNb)) {
            this.mListView.addAdapters(this.cNb);
        }
        return true;
    }

    public int aTQ() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aRr() == null || fVar.aRs() == null || fVar.aRr().size() == 0 || fVar.aRp() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aRs().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aRr().get(0) == null || fVar.aRr().get(0).bwU() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qy() == null || fVar.qy().qs() != fVar.qy().qp()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aRr() == null || fVar.aRt() == null || fVar.aRr().size() == 0 || fVar.aRp() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aRt().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aRr().get(0) == null || fVar.aRr().get(0).bwU() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qy() == null || fVar.qy().qs() != fVar.qy().qp()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aTR() {
        return this.postList;
    }

    public BdUniqueId pV(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.eVy == null || !this.eVy.aSp()) {
            this.eVL = aTS();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public int aTS() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.mListView.getData().get(i2);
                if (fVar == null || fVar.getType() != com.baidu.tieba.pb.data.j.ePV) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aTT() {
        return this.eVL;
    }

    private void aTU() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eQR != null) {
            ArrayList<PostData> aRr = this.eQR.aRr();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aRD = this.eQR.aRD();
            if (aRD != null) {
                int size = aRD.size();
                if (aRr != null && aRr.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aRD.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aRD.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.cSf = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aRD.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bwJ() != null) {
                            int pw = next3.bwJ().pw();
                            if (pw != 0) {
                                a(next3, pw);
                                if (pw != 28 && pw != 31) {
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
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.h.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.eQR.aRn() != null) {
                            lVar4.forumId = this.eQR.aRn().getId();
                        }
                        if (this.eQR.aRp() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.eQR.aRp().getId(), 0L);
                        }
                        if (this.eQR != null && this.eQR.qy() != null) {
                            lVar4.pageNumber = this.eQR.qy().qs();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aRr.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.eQQ) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aRr.add(position2, lVar4);
                        TiebaStatic.eventStat(this.eVp.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bwJ().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sW(i);
        com.baidu.tieba.recapp.report.b.bmA().a(c);
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
        ForumData aRn;
        if (lVar != null && this.eQR != null && lVar.bwJ() != null) {
            lVar.bwJ().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eQR.qy() != null) {
                lVar.bwJ().advertAppContext.pn = this.eQR.qy().qs();
            }
            lVar.bwJ().advertAppContext.Un = "PB";
            if (this.eQR.aRn() != null && (aRn = this.eQR.aRn()) != null) {
                lVar.bwJ().advertAppContext.fid = aRn.getId();
                lVar.bwJ().advertAppContext.Up = aRn.getFirst_class();
                lVar.bwJ().advertAppContext.Uq = aRn.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bwJ().advertAppContext.Ur = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bwJ().advertAppContext.extensionInfo = lVar.bwJ().ext_info;
            lVar.bwJ().advertAppContext.Us = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eVz.setFromCDN(z);
        this.eVq.setFromCDN(z);
        if (this.cRi != null && (this.cRi instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cRi).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eVD.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean aTV() {
        return this.eQP;
    }

    public void iY(boolean z) {
        this.eQP = z;
    }

    public void iZ(boolean z) {
        this.eQQ = z;
    }

    public void ja(boolean z) {
        this.eVI = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eQU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.aVG = gVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVH = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avF = onLongClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void pW(int i) {
        if (this.eVr != null) {
            this.eVr.pW(i);
        }
        switch (i) {
            case 1:
                if (this.eVy != null) {
                    this.eVy.pause();
                }
                if (this.eVq != null) {
                    this.eVq.pause();
                    return;
                }
                return;
            case 2:
                if (this.eVy != null) {
                    this.eVy.resume();
                }
                if (this.eVq != null) {
                    this.eVq.resume();
                    return;
                }
                return;
            case 3:
                if (this.eVy != null) {
                    this.eVy.release();
                }
                if (this.eVq != null) {
                    this.eVq.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cJ(List<com.baidu.adp.widget.ListView.f> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sr())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.cC(postData.sr());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eVK);
        if (this.eVs != null) {
            this.eVs.onDestory();
        }
    }

    public void jl(boolean z) {
        this.eVF = z;
    }

    public void jm(boolean z) {
        this.eVG = z;
    }

    public void jn(boolean z) {
        this.eVE = z;
    }

    public void jo(boolean z) {
        this.eVH = z;
    }

    public an aTW() {
        return this.eVr;
    }

    public void jp(boolean z) {
        if (this.eVr != null) {
            this.eVr.fbq = z;
        }
    }
}
