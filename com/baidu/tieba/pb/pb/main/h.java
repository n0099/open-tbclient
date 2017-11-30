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
    private List<com.baidu.adp.widget.ListView.a> cMQ;
    private com.baidu.adp.widget.ListView.a cQW;
    private com.baidu.adp.widget.ListView.a cQX;
    private int ePL;
    private com.baidu.tieba.pb.data.f ePO;
    private boolean eUD;
    private boolean eUE;
    private Runnable eUH;
    private PbActivity eUm;
    private q eUn;
    private an eUo;
    private aj eUp;
    private aj eUq;
    private k eUr;
    private com.baidu.tieba.pb.video.a eUs;
    private af eUt;
    private ag eUu;
    private com.baidu.tieba.pb.pb.a.b eUv;
    private com.baidu.tieba.pb.pb.a.e eUw;
    private v eUx;
    private ad eUy;
    private com.baidu.tieba.pb.pb.a.d eUz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eUA = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean ePM = true;
    private boolean ePN = true;
    private boolean eUB = false;
    private boolean eUC = false;
    private boolean eUF = false;
    private String mHostId = null;
    private View.OnClickListener ePR = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.f aVE = null;
    private com.baidu.tieba.pb.a.c aVF = null;
    private View.OnLongClickListener avA = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eUG = new ArrayList();
    private int eUI = -1;
    private CustomMessageListener cMZ = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bvP = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bvP();
                Iterator it = bvP.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).ao(h.this.eUm);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            h.this.eUA.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            h.this.eUv = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bvP);
                h.this.eUG.clear();
                h.this.eUG.addAll(arrayList);
                if (h.this.mListView != null) {
                    h.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cIb = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.h.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && h.this.ePO != null && !com.baidu.adp.base.i.W(h.this.eUm.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener cNa = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.h.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.w(h.this.cMQ)) {
                h.this.ans();
                h.this.a(h.this.ePO, false);
            }
        }
    };

    public h(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ePL = 0;
        this.width = -1;
        this.ePL = com.baidu.adp.lib.util.l.ac(pbActivity.getPageContext().getPageActivity());
        this.width = this.ePL;
        this.eUm = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cIb);
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eUw = new com.baidu.tieba.pb.pb.a.e(pbActivity, PostData.gzh);
        this.eUn = new q(pbActivity, PostData.gze);
        this.eUn.a(pbActivity);
        this.eUo = new an(pbActivity, com.baidu.tieba.pb.data.l.eOZ);
        this.eUp = new aj(pbActivity, com.baidu.tieba.pb.data.j.eOS);
        this.eUq = new aj(pbActivity, com.baidu.tieba.pb.data.j.eOT);
        this.eUr = new k(pbActivity, PostData.gzf);
        this.eUr.a(pbActivity);
        this.cQW = com.baidu.tieba.recapp.q.bll().a(pbActivity, AdvertAppInfo.UF);
        this.cQX = com.baidu.tieba.recapp.q.bll().a(pbActivity, AdvertAppInfo.UJ);
        this.eUx = new v(pbActivity, com.baidu.tieba.pb.data.a.eNY);
        this.eUy = new ad(pbActivity, com.baidu.tieba.pb.data.i.eOR);
        this.eUt = new af(pbActivity, ac.eZb);
        this.eUu = new ag(pbActivity, com.baidu.tbadk.core.data.ao.XQ);
        this.eUz = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gzl);
        this.eUs = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fil);
        this.eUs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.ePO.aRr() != null) {
                    pbActivity.aSI().aVL().aSj();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.mAdapters.add(this.eUn);
        this.mAdapters.add(this.eUo);
        this.mAdapters.add(this.eUr);
        this.mAdapters.add(this.eUp);
        this.mAdapters.add(this.eUq);
        this.mAdapters.add(this.eUw);
        this.mAdapters.add(this.cQW);
        this.mAdapters.add(this.cQX);
        this.mAdapters.add(this.eUx);
        this.mAdapters.add(this.eUy);
        this.mAdapters.add(this.eUt);
        this.mAdapters.add(this.eUu);
        this.mAdapters.add(this.eUs);
        this.mAdapters.add(this.eUz);
        this.cMZ.setPriority(1);
        this.cMZ.setSelfListener(true);
        pbActivity.registerListener(this.cMZ);
        anr();
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
        com.baidu.adp.widget.ListView.f aTH;
        PostData postData3;
        boolean z6 = true;
        if (fVar != null) {
            if (this.ePO != fVar) {
                z2 = (fVar == null || fVar.aRd()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.ePO = fVar;
            if (z2) {
                aTM();
                if (fVar != null) {
                    fVar.iV(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.ePO != null && this.ePO.aRj() != null && this.ePO.aRj().size() > 0) {
                this.postList.addAll(this.ePO.aRj());
            }
            if (fVar != null && fVar.aRh() != null && fVar.aRh().rx() != null) {
                this.mHostId = fVar.aRh().rx().getUserId();
            }
            if (this.eUn != null) {
                this.eUw.b(fVar);
                this.eUw.setFromCDN(this.mIsFromCDN);
                this.eUw.setHostId(this.mHostId);
                this.eUw.pH(this.ePL);
                this.eUw.iX(this.ePM);
                this.eUw.iY(this.ePN);
                this.eUw.setCommonClickListener(this.mCommonClickListener);
                this.eUw.D(this.ePR);
                this.eUw.setOnImageClickListener(this.aVE);
                this.eUw.setOnLongClickListener(this.avA);
                this.eUn.b(fVar);
                this.eUn.setFromCDN(this.mIsFromCDN);
                this.eUn.pH(this.ePL);
                this.eUn.iX(this.ePM);
                this.eUn.setCommonClickListener(this.mCommonClickListener);
                this.eUn.D(this.ePR);
                this.eUn.setOnImageClickListener(this.aVE);
                this.eUn.setOnLongClickListener(this.avA);
                this.eUn.setTbGestureDetector(this.aVF);
                this.eUr.b(fVar);
                this.eUr.setFromCDN(this.mIsFromCDN);
                this.eUr.setHostId(this.mHostId);
                this.eUr.iX(this.ePM);
                this.eUr.setCommonClickListener(this.mCommonClickListener);
                this.eUr.D(this.ePR);
                this.eUr.setOnImageClickListener(this.aVE);
                this.eUr.setOnLongClickListener(this.avA);
                this.eUr.setTbGestureDetector(this.aVF);
                this.eUo.setOnClickListener(this.mCommonClickListener);
                this.eUo.setTbGestureDetector(this.aVF);
                this.eUz.setOnClickListener(this.mCommonClickListener);
                if (this.cQX != null && (this.cQX instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.cQX).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eUA.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.pH(this.ePL);
                        next.iX(this.ePM);
                        next.iY(this.ePN);
                        next.iZ(this.eUF);
                        next.setCommonClickListener(this.mCommonClickListener);
                        next.D(this.ePR);
                        next.setOnImageClickListener(this.aVE);
                        next.setOnLongClickListener(this.avA);
                    }
                }
                this.eUp.setCommonClickListener(this.mCommonClickListener);
                this.eUq.setCommonClickListener(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aRj());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bwo() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.ePN && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aRE() && postData.bwr() != null) {
                        postData.d(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aRo() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aRo = fVar.aRo();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aRo());
                    if (!this.ePN && fVar.aRE() && aRo.bwr() != null) {
                        aRo.d(null);
                    }
                    postData2 = aRo;
                    z4 = true;
                }
                cI(arrayList);
                if (this.eUm.aTg()) {
                    if (fVar.aRj().size() > 0 && (postData3 = fVar.aRj().get(0)) != null && postData3.bwo() == 1 && !com.baidu.tbadk.core.util.v.w(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.ePO, arrayList, this.ePN);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.ePO.aRk());
                    }
                }
                int b = b(this.ePO, arrayList, this.ePN);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.ePO.aRl());
                }
                if (arrayList.size() == 0 && this.eUm.aTg()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                com.baidu.tieba.tbadkCore.p.p(arrayList, 1);
                int c = c(fVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eOS);
                    if (fVar != null && fVar.aRh() != null) {
                        jVar.eOU = fVar.aRh().rp();
                    }
                    jVar.aFL = !this.ePN;
                    jVar.eOW = this.eUm.aTt();
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
                        ((PostData) fVar2).cSS = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d >= 0 && fVar.aRD() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aRD());
                    fVar.aRD().iW((a(arrayList, d) || z5) ? false : true);
                    z5 = true;
                }
                if (z4 && (aTH = aTH()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, aTH);
                }
                this.eUn.jp(!z5);
                if (this.eUm.aSo() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.eUm.aSo().getPostId())) {
                    z6 = false;
                }
                if (this.eUB && !z6) {
                    arrayList.remove(postData2);
                    this.eUB = false;
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z6 && !z) {
                    if ((this.eUD || this.eUC) && b2 != -1 && !com.baidu.tbadk.core.util.v.w(g) && !this.eUE) {
                        this.eUH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.4
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.mListView.setSelection(h.this.mListView.getHeaderViewsCount() + g.size());
                                h.this.eUE = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fP().post(this.eUH);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.f aTH() {
        PbModel aSo = this.eUm.aSo();
        if (aSo == null) {
            return null;
        }
        String aUQ = aSo.aUQ();
        if (TextUtils.isEmpty(aUQ)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.sY(aUQ);
        b(lVar);
        return lVar;
    }

    private boolean a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        if (this.eUm.aRo() == null || this.eUm.aSI() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (this.eUC || fVar == null || com.baidu.tbadk.core.util.v.w(fVar.aRj()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aRE() && this.ePN) ? 0 : -1;
        } else if (this.eUm.aSo() == null || !this.eUm.aSo().getIsFromMark()) {
            if (this.eUm.aSI() == null || !this.eUm.aSI().getIsInterviewLive()) {
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
                        if (postData.bwo() == 1 && postData.gzN == 0) {
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
                return fVar.aRE() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.w(fVar.aRj()) || com.baidu.tbadk.core.util.v.w(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(fVar.aRj(), 0)) == null) {
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
                if (postData.bwo() == 1 && postData.gzN == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.v.w(fVar.aRj()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aRE()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i);
            if ((fVar2 instanceof PostData) && ((PostData) fVar2).bwo() == 1) {
                return i + 1;
            }
        }
        return !fVar.aRE() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.f> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aRr() == null || com.baidu.tbadk.core.util.v.w(fVar.aRr().ePo)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aRr().ePo;
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gzP = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.v(fVar.aRr().ePp) > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).gzP = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).gzP = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eOT);
        jVar.eOV = fVar.aRr().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void anr() {
        if (this.eUm != null && !ans()) {
            this.eUm.registerListener(this.cNa);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ans() {
        if (this.eUm == null) {
            return false;
        }
        this.cMQ = new ArrayList();
        ArrayList<BdUniqueId> bvz = com.baidu.tieba.tbadkCore.p.bvz();
        if (bvz == null || bvz.size() <= 0) {
            return false;
        }
        int size = bvz.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aIb().a(this.eUm.getPageContext(), bvz.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cMQ.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.w(this.cMQ)) {
            this.mListView.addAdapters(this.cMQ);
        }
        return true;
    }

    public int aTI() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aRj() == null || fVar.aRk() == null || fVar.aRj().size() == 0 || fVar.aRh() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aRk().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aRj().get(0) == null || fVar.aRj().get(0).bwo() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qA() == null || fVar.qA().qu() != fVar.qA().qr()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aRj() == null || fVar.aRl() == null || fVar.aRj().size() == 0 || fVar.aRh() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aRl().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aRj().get(0) == null || fVar.aRj().get(0).bwo() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qA() == null || fVar.qA().qu() != fVar.qA().qr()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aTJ() {
        return this.postList;
    }

    public BdUniqueId pO(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.eUv == null || !this.eUv.aSh()) {
            this.eUI = aTK();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public int aTK() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.mListView.getData().get(i2);
                if (fVar == null || fVar.getType() != com.baidu.tieba.pb.data.j.eOS) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aTL() {
        return this.eUI;
    }

    private void aTM() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.ePO != null) {
            ArrayList<PostData> aRj = this.ePO.aRj();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aRv = this.ePO.aRv();
            if (aRv != null) {
                int size = aRv.size();
                if (aRj != null && aRj.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aRv.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aRv.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.cRU = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aRv.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bwd() != null) {
                            int py = next3.bwd().py();
                            if (py != 0) {
                                a(next3, py);
                                if (py != 28 && py != 31) {
                                    if (next3.bwd().goods != null) {
                                        next3.bwd().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bwd().apk_name)) {
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
                        if (this.ePO.aRf() != null) {
                            lVar4.forumId = this.ePO.aRf().getId();
                        }
                        if (this.ePO.aRh() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.ePO.aRh().getId(), 0L);
                        }
                        if (this.ePO != null && this.ePO.qA() != null) {
                            lVar4.pageNumber = this.ePO.qA().qu();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aRj.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.ePN) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aRj.add(position2, lVar4);
                        TiebaStatic.eventStat(this.eUm.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bwd().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sL(i);
        com.baidu.tieba.recapp.report.b.blV().a(c);
        if (lVar != null && lVar.bwd() != null) {
            lVar.bwd().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bwd() != null && lVar.bwd().goods != null && lVar.bwd().goods.goods_style != 1001 && lVar.bwd().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aRf;
        if (lVar != null && this.ePO != null && lVar.bwd() != null) {
            lVar.bwd().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.ePO.qA() != null) {
                lVar.bwd().advertAppContext.pn = this.ePO.qA().qu();
            }
            lVar.bwd().advertAppContext.Ut = "PB";
            if (this.ePO.aRf() != null && (aRf = this.ePO.aRf()) != null) {
                lVar.bwd().advertAppContext.fid = aRf.getId();
                lVar.bwd().advertAppContext.Uv = aRf.getFirst_class();
                lVar.bwd().advertAppContext.Uw = aRf.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bwd().advertAppContext.Ux = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bwd().advertAppContext.extensionInfo = lVar.bwd().ext_info;
            lVar.bwd().advertAppContext.Uy = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eUw.setFromCDN(z);
        this.eUn.setFromCDN(z);
        if (this.cQX != null && (this.cQX instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cQX).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eUA.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean aTN() {
        return this.ePM;
    }

    public void iX(boolean z) {
        this.ePM = z;
    }

    public void iY(boolean z) {
        this.ePN = z;
    }

    public void iZ(boolean z) {
        this.eUF = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.ePR = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aVE = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aVF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avA = onLongClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void pP(int i) {
        if (this.eUo != null) {
            this.eUo.pP(i);
        }
        switch (i) {
            case 1:
                if (this.eUv != null) {
                    this.eUv.pause();
                }
                if (this.eUn != null) {
                    this.eUn.pause();
                    return;
                }
                return;
            case 2:
                if (this.eUv != null) {
                    this.eUv.resume();
                }
                if (this.eUn != null) {
                    this.eUn.resume();
                    return;
                }
                return;
            case 3:
                if (this.eUv != null) {
                    this.eUv.release();
                }
                if (this.eUn != null) {
                    this.eUn.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cI(List<com.baidu.adp.widget.ListView.f> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.st())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.cC(postData.st());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eUH);
        if (this.eUp != null) {
            this.eUp.onDestory();
        }
    }

    public void jk(boolean z) {
        this.eUC = z;
    }

    public void jl(boolean z) {
        this.eUD = z;
    }

    public void jm(boolean z) {
        this.eUB = z;
    }

    public void jn(boolean z) {
        this.eUE = z;
    }

    public an aTO() {
        return this.eUo;
    }

    public void jo(boolean z) {
        if (this.eUo != null) {
            this.eUo.fan = z;
        }
    }
}
