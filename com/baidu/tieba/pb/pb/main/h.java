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
    private List<com.baidu.adp.widget.ListView.a> cNf;
    private com.baidu.adp.widget.ListView.a cRl;
    private com.baidu.adp.widget.ListView.a cRm;
    private int eQT;
    private com.baidu.tieba.pb.data.f eQW;
    private com.baidu.tieba.pb.video.a eVA;
    private af eVB;
    private ag eVC;
    private com.baidu.tieba.pb.pb.a.b eVD;
    private com.baidu.tieba.pb.pb.a.e eVE;
    private v eVF;
    private ad eVG;
    private com.baidu.tieba.pb.pb.a.d eVH;
    private boolean eVL;
    private boolean eVM;
    private Runnable eVP;
    private PbActivity eVu;
    private q eVv;
    private an eVw;
    private aj eVx;
    private aj eVy;
    private k eVz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eVI = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eQU = true;
    private boolean eQV = true;
    private boolean eVJ = false;
    private boolean eVK = false;
    private boolean eVN = false;
    private String mHostId = null;
    private View.OnClickListener eQZ = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.g aVJ = null;
    private com.baidu.tieba.pb.a.c aVK = null;
    private View.OnLongClickListener avI = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eVO = new ArrayList();
    private int eVQ = -1;
    private CustomMessageListener cNo = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bww = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bww();
                Iterator it = bww.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).ao(h.this.eVu);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            h.this.eVI.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            h.this.eVD = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bww);
                h.this.eVO.clear();
                h.this.eVO.addAll(arrayList);
                if (h.this.mListView != null) {
                    h.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cIo = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.h.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && h.this.eQW != null && !com.baidu.adp.base.i.W(h.this.eVu.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener cNp = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.h.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.w(h.this.cNf)) {
                h.this.anB();
                h.this.a(h.this.eQW, false);
            }
        }
    };

    public h(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eQT = 0;
        this.width = -1;
        this.eQT = com.baidu.adp.lib.util.l.ac(pbActivity.getPageContext().getPageActivity());
        this.width = this.eQT;
        this.eVu = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cIo);
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eVE = new com.baidu.tieba.pb.pb.a.e(pbActivity, PostData.gBV);
        this.eVv = new q(pbActivity, PostData.gBS);
        this.eVv.a(pbActivity);
        this.eVw = new an(pbActivity, com.baidu.tieba.pb.data.l.eQh);
        this.eVx = new aj(pbActivity, com.baidu.tieba.pb.data.j.eQa);
        this.eVy = new aj(pbActivity, com.baidu.tieba.pb.data.j.eQb);
        this.eVz = new k(pbActivity, PostData.gBT);
        this.eVz.a(pbActivity);
        this.cRl = com.baidu.tieba.recapp.q.blR().a(pbActivity, AdvertAppInfo.UC);
        this.cRm = com.baidu.tieba.recapp.q.blR().a(pbActivity, AdvertAppInfo.UG);
        this.eVF = new v(pbActivity, com.baidu.tieba.pb.data.a.ePg);
        this.eVG = new ad(pbActivity, com.baidu.tieba.pb.data.i.ePZ);
        this.eVB = new af(pbActivity, ac.faj);
        this.eVC = new ag(pbActivity, com.baidu.tbadk.core.data.ao.XN);
        this.eVH = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gBZ);
        this.eVA = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fjp);
        this.eVA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.eQW.aRA() != null) {
                    pbActivity.aSR().aVU().aSs();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.mAdapters.add(this.eVv);
        this.mAdapters.add(this.eVw);
        this.mAdapters.add(this.eVz);
        this.mAdapters.add(this.eVx);
        this.mAdapters.add(this.eVy);
        this.mAdapters.add(this.eVE);
        this.mAdapters.add(this.cRl);
        this.mAdapters.add(this.cRm);
        this.mAdapters.add(this.eVF);
        this.mAdapters.add(this.eVG);
        this.mAdapters.add(this.eVB);
        this.mAdapters.add(this.eVC);
        this.mAdapters.add(this.eVA);
        this.mAdapters.add(this.eVH);
        this.cNo.setPriority(1);
        this.cNo.setSelfListener(true);
        pbActivity.registerListener(this.cNo);
        anA();
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
        com.baidu.adp.widget.ListView.f aTQ;
        PostData postData3;
        boolean z6 = true;
        if (fVar != null) {
            if (this.eQW != fVar) {
                z2 = (fVar == null || fVar.aRm()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eQW = fVar;
            if (z2) {
                aTV();
                if (fVar != null) {
                    fVar.iW(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eQW != null && this.eQW.aRs() != null && this.eQW.aRs().size() > 0) {
                this.postList.addAll(this.eQW.aRs());
            }
            if (fVar != null && fVar.aRq() != null && fVar.aRq().rv() != null) {
                this.mHostId = fVar.aRq().rv().getUserId();
            }
            if (this.eVv != null) {
                this.eVE.b(fVar);
                this.eVE.setFromCDN(this.mIsFromCDN);
                this.eVE.setHostId(this.mHostId);
                this.eVE.pO(this.eQT);
                this.eVE.iY(this.eQU);
                this.eVE.iZ(this.eQV);
                this.eVE.setCommonClickListener(this.mCommonClickListener);
                this.eVE.D(this.eQZ);
                this.eVE.setOnImageClickListener(this.aVJ);
                this.eVE.setOnLongClickListener(this.avI);
                this.eVv.b(fVar);
                this.eVv.setFromCDN(this.mIsFromCDN);
                this.eVv.pO(this.eQT);
                this.eVv.iY(this.eQU);
                this.eVv.setCommonClickListener(this.mCommonClickListener);
                this.eVv.D(this.eQZ);
                this.eVv.setOnImageClickListener(this.aVJ);
                this.eVv.setOnLongClickListener(this.avI);
                this.eVv.setTbGestureDetector(this.aVK);
                this.eVz.b(fVar);
                this.eVz.setFromCDN(this.mIsFromCDN);
                this.eVz.setHostId(this.mHostId);
                this.eVz.iY(this.eQU);
                this.eVz.setCommonClickListener(this.mCommonClickListener);
                this.eVz.D(this.eQZ);
                this.eVz.setOnImageClickListener(this.aVJ);
                this.eVz.setOnLongClickListener(this.avI);
                this.eVz.setTbGestureDetector(this.aVK);
                this.eVw.setOnClickListener(this.mCommonClickListener);
                this.eVw.setTbGestureDetector(this.aVK);
                this.eVH.setOnClickListener(this.mCommonClickListener);
                if (this.cRm != null && (this.cRm instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.cRm).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eVI.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.pO(this.eQT);
                        next.iY(this.eQU);
                        next.iZ(this.eQV);
                        next.ja(this.eVN);
                        next.setCommonClickListener(this.mCommonClickListener);
                        next.D(this.eQZ);
                        next.setOnImageClickListener(this.aVJ);
                        next.setOnLongClickListener(this.avI);
                    }
                }
                this.eVx.setCommonClickListener(this.mCommonClickListener);
                this.eVy.setCommonClickListener(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aRs());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bwV() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.eQV && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aRN() && postData.bwY() != null) {
                        postData.d(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aRx() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aRx = fVar.aRx();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aRx());
                    if (!this.eQV && fVar.aRN() && aRx.bwY() != null) {
                        aRx.d(null);
                    }
                    postData2 = aRx;
                    z4 = true;
                }
                cJ(arrayList);
                if (this.eVu.aTp()) {
                    if (fVar.aRs().size() > 0 && (postData3 = fVar.aRs().get(0)) != null && postData3.bwV() == 1 && !com.baidu.tbadk.core.util.v.w(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.eQW, arrayList, this.eQV);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.eQW.aRt());
                    }
                }
                int b = b(this.eQW, arrayList, this.eQV);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.eQW.aRu());
                }
                if (arrayList.size() == 0 && this.eVu.aTp()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                com.baidu.tieba.tbadkCore.p.p(arrayList, 1);
                int c = c(fVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eQa);
                    if (fVar != null && fVar.aRq() != null) {
                        jVar.eQc = fVar.aRq().rn();
                    }
                    jVar.aFS = !this.eQV;
                    jVar.eQe = this.eVu.aTC();
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
                        ((PostData) fVar2).cTh = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d >= 0 && fVar.aRM() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aRM());
                    fVar.aRM().iX((a(arrayList, d) || z5) ? false : true);
                    z5 = true;
                }
                if (z4 && (aTQ = aTQ()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, aTQ);
                }
                this.eVv.jq(!z5);
                if (this.eVu.aSx() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.eVu.aSx().getPostId())) {
                    z6 = false;
                }
                if (this.eVJ && !z6) {
                    arrayList.remove(postData2);
                    this.eVJ = false;
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z6 && !z) {
                    if ((this.eVL || this.eVK) && b2 != -1 && !com.baidu.tbadk.core.util.v.w(g) && !this.eVM) {
                        this.eVP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.4
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.mListView.setSelection(h.this.mListView.getHeaderViewsCount() + g.size());
                                h.this.eVM = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fP().post(this.eVP);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.f aTQ() {
        PbModel aSx = this.eVu.aSx();
        if (aSx == null) {
            return null;
        }
        String aUZ = aSx.aUZ();
        if (TextUtils.isEmpty(aUZ)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.td(aUZ);
        b(lVar);
        return lVar;
    }

    private boolean a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        if (this.eVu.aRx() == null || this.eVu.aSR() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (this.eVK || fVar == null || com.baidu.tbadk.core.util.v.w(fVar.aRs()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aRN() && this.eQV) ? 0 : -1;
        } else if (this.eVu.aSx() == null || !this.eVu.aSx().getIsFromMark()) {
            if (this.eVu.aSR() == null || !this.eVu.aSR().getIsInterviewLive()) {
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
                        if (postData.bwV() == 1 && postData.gCB == 0) {
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
                return fVar.aRN() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.w(fVar.aRs()) || com.baidu.tbadk.core.util.v.w(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(fVar.aRs(), 0)) == null) {
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
                if (postData.bwV() == 1 && postData.gCB == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.v.w(fVar.aRs()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aRN()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i);
            if ((fVar2 instanceof PostData) && ((PostData) fVar2).bwV() == 1) {
                return i + 1;
            }
        }
        return !fVar.aRN() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.f> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aRA() == null || com.baidu.tbadk.core.util.v.w(fVar.aRA().eQw)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aRA().eQw;
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gCD = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.v(fVar.aRA().eQx) > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).gCD = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).gCD = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eQb);
        jVar.eQd = fVar.aRA().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void anA() {
        if (this.eVu != null && !anB()) {
            this.eVu.registerListener(this.cNp);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean anB() {
        if (this.eVu == null) {
            return false;
        }
        this.cNf = new ArrayList();
        ArrayList<BdUniqueId> bwg = com.baidu.tieba.tbadkCore.p.bwg();
        if (bwg == null || bwg.size() <= 0) {
            return false;
        }
        int size = bwg.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aIk().a(this.eVu.getPageContext(), bwg.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cNf.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.w(this.cNf)) {
            this.mListView.addAdapters(this.cNf);
        }
        return true;
    }

    public int aTR() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aRs() == null || fVar.aRt() == null || fVar.aRs().size() == 0 || fVar.aRq() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aRt().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aRs().get(0) == null || fVar.aRs().get(0).bwV() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qy() == null || fVar.qy().qs() != fVar.qy().qp()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aRs() == null || fVar.aRu() == null || fVar.aRs().size() == 0 || fVar.aRq() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aRu().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aRs().get(0) == null || fVar.aRs().get(0).bwV() != 1) ? -1 : 1;
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

    public ArrayList<PostData> aTS() {
        return this.postList;
    }

    public BdUniqueId pV(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.eVD == null || !this.eVD.aSq()) {
            this.eVQ = aTT();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public int aTT() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.mListView.getData().get(i2);
                if (fVar == null || fVar.getType() != com.baidu.tieba.pb.data.j.eQa) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aTU() {
        return this.eVQ;
    }

    private void aTV() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eQW != null) {
            ArrayList<PostData> aRs = this.eQW.aRs();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aRE = this.eQW.aRE();
            if (aRE != null) {
                int size = aRE.size();
                if (aRs != null && aRs.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aRE.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aRE.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.cSj = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aRE.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bwK() != null) {
                            int pw = next3.bwK().pw();
                            if (pw != 0) {
                                a(next3, pw);
                                if (pw != 28 && pw != 31) {
                                    if (next3.bwK().goods != null) {
                                        next3.bwK().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bwK().apk_name)) {
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
                        if (this.eQW.aRo() != null) {
                            lVar4.forumId = this.eQW.aRo().getId();
                        }
                        if (this.eQW.aRq() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.eQW.aRq().getId(), 0L);
                        }
                        if (this.eQW != null && this.eQW.qy() != null) {
                            lVar4.pageNumber = this.eQW.qy().qs();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aRs.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.eQV) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aRs.add(position2, lVar4);
                        TiebaStatic.eventStat(this.eVu.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bwK().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sW(i);
        com.baidu.tieba.recapp.report.b.bmB().a(c);
        if (lVar != null && lVar.bwK() != null) {
            lVar.bwK().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bwK() != null && lVar.bwK().goods != null && lVar.bwK().goods.goods_style != 1001 && lVar.bwK().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aRo;
        if (lVar != null && this.eQW != null && lVar.bwK() != null) {
            lVar.bwK().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eQW.qy() != null) {
                lVar.bwK().advertAppContext.pn = this.eQW.qy().qs();
            }
            lVar.bwK().advertAppContext.Uq = "PB";
            if (this.eQW.aRo() != null && (aRo = this.eQW.aRo()) != null) {
                lVar.bwK().advertAppContext.fid = aRo.getId();
                lVar.bwK().advertAppContext.Us = aRo.getFirst_class();
                lVar.bwK().advertAppContext.Ut = aRo.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bwK().advertAppContext.Uu = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bwK().advertAppContext.extensionInfo = lVar.bwK().ext_info;
            lVar.bwK().advertAppContext.Uv = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eVE.setFromCDN(z);
        this.eVv.setFromCDN(z);
        if (this.cRm != null && (this.cRm instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cRm).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eVI.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean aTW() {
        return this.eQU;
    }

    public void iY(boolean z) {
        this.eQU = z;
    }

    public void iZ(boolean z) {
        this.eQV = z;
    }

    public void ja(boolean z) {
        this.eVN = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eQZ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.g gVar) {
        this.aVJ = gVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avI = onLongClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void pW(int i) {
        if (this.eVw != null) {
            this.eVw.pW(i);
        }
        switch (i) {
            case 1:
                if (this.eVD != null) {
                    this.eVD.pause();
                }
                if (this.eVv != null) {
                    this.eVv.pause();
                    return;
                }
                return;
            case 2:
                if (this.eVD != null) {
                    this.eVD.resume();
                }
                if (this.eVv != null) {
                    this.eVv.resume();
                    return;
                }
                return;
            case 3:
                if (this.eVD != null) {
                    this.eVD.release();
                }
                if (this.eVv != null) {
                    this.eVv.release();
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eVP);
        if (this.eVx != null) {
            this.eVx.onDestory();
        }
    }

    public void jl(boolean z) {
        this.eVK = z;
    }

    public void jm(boolean z) {
        this.eVL = z;
    }

    public void jn(boolean z) {
        this.eVJ = z;
    }

    public void jo(boolean z) {
        this.eVM = z;
    }

    public an aTX() {
        return this.eVw;
    }

    public void jp(boolean z) {
        if (this.eVw != null) {
            this.eVw.fbv = z;
        }
    }
}
