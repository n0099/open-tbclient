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
    private List<com.baidu.adp.widget.ListView.a> cDL;
    private com.baidu.adp.widget.ListView.a cHL;
    private com.baidu.adp.widget.ListView.a cHM;
    private int eIi;
    private com.baidu.tieba.pb.data.f eIl;
    private PbActivity eMB;
    private q eMC;
    private al eMD;
    private ah eME;
    private ah eMF;
    private k eMG;
    private com.baidu.tieba.pb.video.a eMH;
    private com.baidu.adp.widget.ListView.a eMI;
    private com.baidu.adp.widget.ListView.a eMJ;
    private com.baidu.adp.widget.ListView.a eMK;
    private ad eML;
    private ae eMM;
    private com.baidu.tieba.pb.pb.a.b eMN;
    private com.baidu.tieba.pb.pb.a.g eMO;
    private t eMP;
    private ab eMQ;
    private com.baidu.tieba.pb.pb.a.c eMR;
    private com.baidu.tieba.pb.pb.a.f eMS;
    private boolean eMW;
    private boolean eMX;
    private Runnable eNa;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eMT = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eIj = true;
    private boolean eIk = true;
    private boolean eMU = false;
    private boolean eMV = false;
    private boolean eMY = false;
    private String mHostId = null;
    private View.OnClickListener eIo = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.f aSD = null;
    private com.baidu.tieba.pb.a.c aSE = null;
    private View.OnLongClickListener auZ = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eMZ = new ArrayList();
    private int eNb = -1;
    private CustomMessageListener cDU = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList buh = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).buh();
                Iterator it = buh.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).ap(h.this.eMB);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            h.this.eMT.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            h.this.eMN = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(buh);
                h.this.eMZ.clear();
                h.this.eMZ.addAll(arrayList);
                if (h.this.mListView != null) {
                    h.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cyW = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.h.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && h.this.eIl != null && !com.baidu.adp.base.i.W(h.this.eMB.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener cDV = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.h.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.v(h.this.cDL)) {
                h.this.alx();
                h.this.a(h.this.eIl, false);
            }
        }
    };

    public h(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eIi = 0;
        this.width = -1;
        this.eIi = com.baidu.adp.lib.util.l.ac(pbActivity.getPageContext().getPageActivity());
        this.width = this.eIi;
        this.eMB = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cyW);
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eMO = new com.baidu.tieba.pb.pb.a.g(pbActivity, PostData.gqp);
        this.eMC = new q(pbActivity, PostData.gqm);
        this.eMC.a(pbActivity);
        this.eMD = new al(pbActivity, com.baidu.tieba.pb.data.l.eHp);
        this.eME = new ah(pbActivity, com.baidu.tieba.pb.data.j.eHi);
        this.eMF = new ah(pbActivity, com.baidu.tieba.pb.data.j.eHj);
        this.eMG = new k(pbActivity, PostData.gqn);
        this.eMG.a(pbActivity);
        this.cHL = com.baidu.tieba.recapp.r.bjl().a(pbActivity, AdvertAppInfo.TX);
        this.eMI = com.baidu.tieba.recapp.r.bjl().a(pbActivity, AdvertAppInfo.TY);
        this.eMJ = com.baidu.tieba.recapp.r.bjl().a(pbActivity, AdvertAppInfo.TZ);
        this.eMK = com.baidu.tieba.recapp.r.bjl().a(pbActivity, AdvertAppInfo.Ua);
        this.cHM = com.baidu.tieba.recapp.r.bjl().a(pbActivity, AdvertAppInfo.Ue);
        this.eMP = new t(pbActivity, com.baidu.tieba.pb.data.a.eGp);
        this.eMQ = new ab(pbActivity, com.baidu.tieba.pb.data.i.eHh);
        this.eML = new ad(pbActivity, aa.eQv);
        this.eMM = new ae(pbActivity, com.baidu.tbadk.core.data.as.Xy);
        this.eMS = new com.baidu.tieba.pb.pb.a.f(pbActivity, PostData.gqt);
        this.eMH = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fbr);
        this.eMH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.eIl.aQg() != null) {
                    pbActivity.aRs().aUl().aQW();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.eMR = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Vw);
        if (this.eIl != null && this.eIl.aPW() != null) {
            this.eMR.anj = this.eIl.aPW().aal;
        }
        this.mAdapters.add(this.eMC);
        this.mAdapters.add(this.eMD);
        this.mAdapters.add(this.eMG);
        this.mAdapters.add(this.eME);
        this.mAdapters.add(this.eMF);
        this.mAdapters.add(this.eMO);
        this.mAdapters.add(this.cHL);
        this.mAdapters.add(this.eMI);
        this.mAdapters.add(this.eMJ);
        this.mAdapters.add(this.eMK);
        this.mAdapters.add(this.cHM);
        this.mAdapters.add(this.eMP);
        this.mAdapters.add(this.eMQ);
        this.mAdapters.add(this.eML);
        this.mAdapters.add(this.eMM);
        this.mAdapters.add(this.eMR);
        this.mAdapters.add(this.eMH);
        this.mAdapters.add(this.eMS);
        this.cDU.setPriority(1);
        this.cDU.setSelfListener(true);
        pbActivity.registerListener(this.cDU);
        alw();
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
        PostData postData3;
        boolean z6 = true;
        if (fVar != null) {
            if (this.eIl != fVar) {
                z2 = (fVar == null || fVar.aPS()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eIl = fVar;
            if (z2) {
                aSs();
                if (fVar != null) {
                    fVar.iC(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eIl != null && this.eIl.aPY() != null && this.eIl.aPY().size() > 0) {
                this.postList.addAll(this.eIl.aPY());
            }
            if (fVar != null && fVar.aPW() != null && fVar.aPW().rt() != null) {
                this.mHostId = fVar.aPW().rt().getUserId();
            }
            if (this.eMC != null) {
                this.eMO.b(fVar);
                this.eMO.setFromCDN(this.mIsFromCDN);
                this.eMO.setHostId(this.mHostId);
                this.eMO.pu(this.eIi);
                this.eMO.iE(this.eIj);
                this.eMO.iF(this.eIk);
                this.eMO.setCommonClickListener(this.mCommonClickListener);
                this.eMO.D(this.eIo);
                this.eMO.setOnImageClickListener(this.aSD);
                this.eMO.setOnLongClickListener(this.auZ);
                this.eMC.b(fVar);
                this.eMC.setFromCDN(this.mIsFromCDN);
                this.eMC.pu(this.eIi);
                this.eMC.iE(this.eIj);
                this.eMC.setCommonClickListener(this.mCommonClickListener);
                this.eMC.D(this.eIo);
                this.eMC.setOnImageClickListener(this.aSD);
                this.eMC.setOnLongClickListener(this.auZ);
                this.eMC.setTbGestureDetector(this.aSE);
                this.eMG.b(fVar);
                this.eMG.setFromCDN(this.mIsFromCDN);
                this.eMG.setHostId(this.mHostId);
                this.eMG.iE(this.eIj);
                this.eMG.setCommonClickListener(this.mCommonClickListener);
                this.eMG.D(this.eIo);
                this.eMG.setOnImageClickListener(this.aSD);
                this.eMG.setOnLongClickListener(this.auZ);
                this.eMG.setTbGestureDetector(this.aSE);
                this.eMD.setOnClickListener(this.mCommonClickListener);
                this.eMD.setTbGestureDetector(this.aSE);
                this.eMS.setOnClickListener(this.mCommonClickListener);
                if (this.eMI != null && (this.eMI instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eMI).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eMJ != null && (this.eMJ instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eMJ).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.cHM != null && (this.cHM instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.cHM).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eMT.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.pu(this.eIi);
                        next.iE(this.eIj);
                        next.iF(this.eIk);
                        next.iG(this.eMY);
                        next.setCommonClickListener(this.mCommonClickListener);
                        next.D(this.eIo);
                        next.setOnImageClickListener(this.aSD);
                        next.setOnLongClickListener(this.auZ);
                    }
                }
                this.eME.setCommonClickListener(this.mCommonClickListener);
                this.eMF.setCommonClickListener(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aPY());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).buG() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.eIk && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aQt() && postData.aEx() != null) {
                        postData.g(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aQd() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aQd = fVar.aQd();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aQd());
                    if (!this.eIk && fVar.aQt() && aQd.aEx() != null) {
                        aQd.g(null);
                    }
                    postData2 = aQd;
                    z4 = true;
                }
                cv(arrayList);
                if (this.eMB.aRP()) {
                    if (fVar.aPY().size() > 0 && (postData3 = fVar.aPY().get(0)) != null && postData3.buG() == 1 && !com.baidu.tbadk.core.util.v.v(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.eIl, arrayList, this.eIk);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.eIl.aPZ());
                    }
                }
                int b = b(this.eIl, arrayList, this.eIk);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.eIl.aQa());
                }
                if (arrayList.size() == 0 && this.eMB.aRP()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                com.baidu.tieba.tbadkCore.o.p(arrayList, 1);
                int c = c(fVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eHi);
                    if (fVar != null && fVar.aPW() != null) {
                        jVar.eHk = fVar.aPW().rl();
                    }
                    jVar.aFk = !this.eIk;
                    jVar.eHm = this.eMB.aSc();
                    com.baidu.tbadk.core.util.v.a(arrayList, c, jVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(fVar, arrayList);
                final List<com.baidu.adp.widget.ListView.f> g = g(fVar);
                if (!com.baidu.tbadk.core.util.v.v(g) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, b2);
                    if (fVar2 instanceof PostData) {
                        ((PostData) fVar2).cJv = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d >= 0 && fVar.aQs() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aQs());
                    fVar.aQs().iD((b(arrayList, d) || z5) ? false : true);
                    z5 = true;
                }
                this.eMC.iX(!z5);
                if (this.eMB.aRa() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.eMB.aRa().getPostId())) {
                    z6 = false;
                }
                if (this.eMU && !z6) {
                    arrayList.remove(postData2);
                    this.eMU = false;
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z6 && !z) {
                    if ((this.eMW || this.eMV) && b2 != -1 && !com.baidu.tbadk.core.util.v.v(g) && !this.eMX) {
                        this.eNa = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.4
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.mListView.setSelection(h.this.mListView.getHeaderViewsCount() + g.size());
                                h.this.eMX = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fP().post(this.eNa);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        if (this.eMB.aQd() == null || this.eMB.aRs() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (this.eMV || fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aPY()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aQt() && this.eIk) ? 0 : -1;
        } else if (this.eMB.aRa() == null || !this.eMB.aRa().getIsFromMark()) {
            if (this.eMB.aRs() == null || !this.eMB.aRs().getIsInterviewLive()) {
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
                        if (postData.buG() == 1 && postData.gqU == 0) {
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
                return fVar.aQt() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aPY()) || com.baidu.tbadk.core.util.v.v(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(fVar.aPY(), 0)) == null) {
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
                if (postData.buG() == 1 && postData.gqU == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aPY()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aQt()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i);
            if ((fVar2 instanceof PostData) && ((PostData) fVar2).buG() == 1) {
                return i + 1;
            }
        }
        return !fVar.aQt() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.f> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aQg() == null || com.baidu.tbadk.core.util.v.v(fVar.aQg().eHD)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aQg().eHD;
        if (com.baidu.tbadk.core.util.v.v(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gqW = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.u(fVar.aQg().eHE) > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).gqW = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).gqW = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eHj);
        jVar.eHl = fVar.aQg().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void alw() {
        if (this.eMB != null && !alx()) {
            this.eMB.registerListener(this.cDV);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean alx() {
        if (this.eMB == null) {
            return false;
        }
        this.cDL = new ArrayList();
        ArrayList<BdUniqueId> btR = com.baidu.tieba.tbadkCore.o.btR();
        if (btR == null || btR.size() <= 0) {
            return false;
        }
        int size = btR.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aHt().a(this.eMB.getPageContext(), btR.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cDL.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.v(this.cDL)) {
            this.mListView.addAdapters(this.cDL);
        }
        return true;
    }

    public int aSo() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPY() == null || fVar.aPZ() == null || fVar.aPY().size() == 0 || fVar.aPW() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPZ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPY().get(0) == null || fVar.aPY().get(0).buG() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qv() == null || fVar.qv().qp() != fVar.qv().qm()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPY() == null || fVar.aQa() == null || fVar.aPY().size() == 0 || fVar.aPW() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aQa().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPY().get(0) == null || fVar.aPY().get(0).buG() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qv() == null || fVar.qv().qp() != fVar.qv().qm()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aSp() {
        return this.postList;
    }

    public BdUniqueId pB(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.eMN == null || !this.eMN.aQR()) {
            this.eNb = aSq();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public int aSq() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.mListView.getData().get(i2);
                if (fVar == null || fVar.getType() != com.baidu.tieba.pb.data.j.eHi) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aSr() {
        return this.eNb;
    }

    private void aSs() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eIl != null) {
            ArrayList<PostData> aPY = this.eIl.aPY();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aQk = this.eIl.aQk();
            if (aQk != null) {
                int size = aQk.size();
                if (aPY != null && aPY.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aQk.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aQk.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.cIJ = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aQk.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.buv() != null) {
                            int pr = next3.buv().pr();
                            if (pr != 0) {
                                a(next3, pr);
                                if (pr != 28 && pr != 31) {
                                    if (next3.buv().goods != null) {
                                        next3.buv().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.t.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.buv().apk_name)) {
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
                        if (this.eIl.aPU() != null) {
                            lVar4.forumId = this.eIl.aPU().getId();
                        }
                        if (this.eIl.aPW() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.eIl.aPW().getId(), 0L);
                        }
                        if (this.eIl != null && this.eIl.qv() != null) {
                            lVar4.pageNumber = this.eIl.qv().qp();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aPY.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.eIk) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aPY.add(position2, lVar4);
                        TiebaStatic.eventStat(this.eMB.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.buv().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sy(i);
        com.baidu.tieba.recapp.report.b.bjV().a(c);
        if (lVar != null && lVar.buv() != null) {
            lVar.buv().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.buv() != null && lVar.buv().goods != null && lVar.buv().goods.goods_style != 1001 && lVar.buv().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aPU;
        if (lVar != null && this.eIl != null && lVar.buv() != null) {
            lVar.buv().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eIl.qv() != null) {
                lVar.buv().advertAppContext.pn = this.eIl.qv().qp();
            }
            lVar.buv().advertAppContext.TL = "PB";
            if (this.eIl.aPU() != null && (aPU = this.eIl.aPU()) != null) {
                lVar.buv().advertAppContext.fid = aPU.getId();
                lVar.buv().advertAppContext.TO = aPU.getFirst_class();
                lVar.buv().advertAppContext.TP = aPU.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.buv().advertAppContext.TQ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.buv().advertAppContext.extensionInfo = lVar.buv().ext_info;
            lVar.buv().advertAppContext.TR = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eMO.setFromCDN(z);
        this.eMC.setFromCDN(z);
        if (this.eMI != null && (this.eMI instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eMI).setIsFromCDN(z);
        }
        if (this.eMJ != null && (this.eMJ instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eMJ).setIsFromCDN(z);
        }
        if (this.cHM != null && (this.cHM instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cHM).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eMT.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean aSt() {
        return this.eIj;
    }

    public void iE(boolean z) {
        this.eIj = z;
    }

    public void iF(boolean z) {
        this.eIk = z;
    }

    public void iG(boolean z) {
        this.eMY = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eIo = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSD = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auZ = onLongClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void pC(int i) {
        if (this.eMD != null) {
            this.eMD.pC(i);
        }
        switch (i) {
            case 1:
                if (this.eMN != null) {
                    this.eMN.pause();
                }
                if (this.eMC != null) {
                    this.eMC.pause();
                }
                if (this.eMK != null && (this.eMK instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eMK).release();
                    return;
                }
                return;
            case 2:
                if (this.eMN != null) {
                    this.eMN.resume();
                }
                if (this.eMC != null) {
                    this.eMC.resume();
                }
                if (this.eMK != null && (this.eMK instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eMK).resume();
                    return;
                }
                return;
            case 3:
                if (this.eMN != null) {
                    this.eMN.release();
                }
                if (this.eMC != null) {
                    this.eMC.release();
                }
                if (this.eMK != null && (this.eMK instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eMK).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cv(List<com.baidu.adp.widget.ListView.f> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sq())) {
                        com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
                        afVar.cC(postData.sq());
                        list.set(i, afVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eNa);
        if (this.eME != null) {
            this.eME.onDestory();
        }
    }

    public void iT(boolean z) {
        this.eMV = z;
    }

    public void iU(boolean z) {
        this.eMW = z;
    }

    public void iV(boolean z) {
        this.eMU = z;
    }

    public void iW(boolean z) {
        this.eMX = z;
    }

    public al aSu() {
        return this.eMD;
    }
}
