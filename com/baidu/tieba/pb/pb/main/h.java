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
    private List<com.baidu.adp.widget.ListView.a> cDs;
    private com.baidu.adp.widget.ListView.a cHs;
    private com.baidu.adp.widget.ListView.a cHt;
    private int eHO;
    private com.baidu.tieba.pb.data.f eHR;
    private boolean eMC;
    private boolean eMD;
    private Runnable eMG;
    private PbActivity eMh;
    private q eMi;
    private al eMj;
    private ah eMk;
    private ah eMl;
    private k eMm;
    private com.baidu.tieba.pb.video.a eMn;
    private com.baidu.adp.widget.ListView.a eMo;
    private com.baidu.adp.widget.ListView.a eMp;
    private com.baidu.adp.widget.ListView.a eMq;
    private ad eMr;
    private ae eMs;
    private com.baidu.tieba.pb.pb.a.b eMt;
    private com.baidu.tieba.pb.pb.a.g eMu;
    private t eMv;
    private ab eMw;
    private com.baidu.tieba.pb.pb.a.c eMx;
    private com.baidu.tieba.pb.pb.a.f eMy;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eMz = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eHP = true;
    private boolean eHQ = true;
    private boolean eMA = false;
    private boolean eMB = false;
    private boolean eME = false;
    private String mHostId = null;
    private View.OnClickListener eHU = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.f aSv = null;
    private com.baidu.tieba.pb.a.c aSw = null;
    private View.OnLongClickListener auR = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eMF = new ArrayList();
    private int eMH = -1;
    private CustomMessageListener cDB = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList btV = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).btV();
                Iterator it = btV.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).ap(h.this.eMh);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            h.this.eMz.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            h.this.eMt = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(btV);
                h.this.eMF.clear();
                h.this.eMF.addAll(arrayList);
                if (h.this.mListView != null) {
                    h.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cyD = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.h.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && h.this.eHR != null && !com.baidu.adp.base.i.W(h.this.eMh.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener cDC = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.h.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.v(h.this.cDs)) {
                h.this.alj();
                h.this.a(h.this.eHR, false);
            }
        }
    };

    public h(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eHO = 0;
        this.width = -1;
        this.eHO = com.baidu.adp.lib.util.l.ac(pbActivity.getPageContext().getPageActivity());
        this.width = this.eHO;
        this.eMh = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cyD);
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eMu = new com.baidu.tieba.pb.pb.a.g(pbActivity, PostData.gpm);
        this.eMi = new q(pbActivity, PostData.gpj);
        this.eMi.a(pbActivity);
        this.eMj = new al(pbActivity, com.baidu.tieba.pb.data.l.eGV);
        this.eMk = new ah(pbActivity, com.baidu.tieba.pb.data.j.eGO);
        this.eMl = new ah(pbActivity, com.baidu.tieba.pb.data.j.eGP);
        this.eMm = new k(pbActivity, PostData.gpk);
        this.eMm.a(pbActivity);
        this.cHs = com.baidu.tieba.recapp.r.bja().a(pbActivity, AdvertAppInfo.TX);
        this.eMo = com.baidu.tieba.recapp.r.bja().a(pbActivity, AdvertAppInfo.TY);
        this.eMp = com.baidu.tieba.recapp.r.bja().a(pbActivity, AdvertAppInfo.TZ);
        this.eMq = com.baidu.tieba.recapp.r.bja().a(pbActivity, AdvertAppInfo.Ua);
        this.cHt = com.baidu.tieba.recapp.r.bja().a(pbActivity, AdvertAppInfo.Ue);
        this.eMv = new t(pbActivity, com.baidu.tieba.pb.data.a.eFV);
        this.eMw = new ab(pbActivity, com.baidu.tieba.pb.data.i.eGN);
        this.eMr = new ad(pbActivity, aa.eQb);
        this.eMs = new ae(pbActivity, com.baidu.tbadk.core.data.as.Xy);
        this.eMy = new com.baidu.tieba.pb.pb.a.f(pbActivity, PostData.gpq);
        this.eMn = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.faW);
        this.eMn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.eHR.aPY() != null) {
                    pbActivity.aRk().aUd().aQO();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.eMx = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Vw);
        if (this.eHR != null && this.eHR.aPO() != null) {
            this.eMx.ank = this.eHR.aPO().aal;
        }
        this.mAdapters.add(this.eMi);
        this.mAdapters.add(this.eMj);
        this.mAdapters.add(this.eMm);
        this.mAdapters.add(this.eMk);
        this.mAdapters.add(this.eMl);
        this.mAdapters.add(this.eMu);
        this.mAdapters.add(this.cHs);
        this.mAdapters.add(this.eMo);
        this.mAdapters.add(this.eMp);
        this.mAdapters.add(this.eMq);
        this.mAdapters.add(this.cHt);
        this.mAdapters.add(this.eMv);
        this.mAdapters.add(this.eMw);
        this.mAdapters.add(this.eMr);
        this.mAdapters.add(this.eMs);
        this.mAdapters.add(this.eMx);
        this.mAdapters.add(this.eMn);
        this.mAdapters.add(this.eMy);
        this.cDB.setPriority(1);
        this.cDB.setSelfListener(true);
        pbActivity.registerListener(this.cDB);
        ali();
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
            if (this.eHR != fVar) {
                z2 = (fVar == null || fVar.aPK()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eHR = fVar;
            if (z2) {
                aSk();
                if (fVar != null) {
                    fVar.iw(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eHR != null && this.eHR.aPQ() != null && this.eHR.aPQ().size() > 0) {
                this.postList.addAll(this.eHR.aPQ());
            }
            if (fVar != null && fVar.aPO() != null && fVar.aPO().rt() != null) {
                this.mHostId = fVar.aPO().rt().getUserId();
            }
            if (this.eMi != null) {
                this.eMu.b(fVar);
                this.eMu.setFromCDN(this.mIsFromCDN);
                this.eMu.setHostId(this.mHostId);
                this.eMu.pt(this.eHO);
                this.eMu.iy(this.eHP);
                this.eMu.iz(this.eHQ);
                this.eMu.setCommonClickListener(this.mCommonClickListener);
                this.eMu.D(this.eHU);
                this.eMu.setOnImageClickListener(this.aSv);
                this.eMu.setOnLongClickListener(this.auR);
                this.eMi.b(fVar);
                this.eMi.setFromCDN(this.mIsFromCDN);
                this.eMi.pt(this.eHO);
                this.eMi.iy(this.eHP);
                this.eMi.setCommonClickListener(this.mCommonClickListener);
                this.eMi.D(this.eHU);
                this.eMi.setOnImageClickListener(this.aSv);
                this.eMi.setOnLongClickListener(this.auR);
                this.eMi.setTbGestureDetector(this.aSw);
                this.eMm.b(fVar);
                this.eMm.setFromCDN(this.mIsFromCDN);
                this.eMm.setHostId(this.mHostId);
                this.eMm.iy(this.eHP);
                this.eMm.setCommonClickListener(this.mCommonClickListener);
                this.eMm.D(this.eHU);
                this.eMm.setOnImageClickListener(this.aSv);
                this.eMm.setOnLongClickListener(this.auR);
                this.eMm.setTbGestureDetector(this.aSw);
                this.eMj.setOnClickListener(this.mCommonClickListener);
                this.eMj.setTbGestureDetector(this.aSw);
                this.eMy.setOnClickListener(this.mCommonClickListener);
                if (this.eMo != null && (this.eMo instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eMo).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eMp != null && (this.eMp instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eMp).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.cHt != null && (this.cHt instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.cHt).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eMz.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.pt(this.eHO);
                        next.iy(this.eHP);
                        next.iz(this.eHQ);
                        next.iA(this.eME);
                        next.setCommonClickListener(this.mCommonClickListener);
                        next.D(this.eHU);
                        next.setOnImageClickListener(this.aSv);
                        next.setOnLongClickListener(this.auR);
                    }
                }
                this.eMk.setCommonClickListener(this.mCommonClickListener);
                this.eMl.setCommonClickListener(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aPQ());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).buu() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.eHQ && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aQl() && postData.aEt() != null) {
                        postData.g(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aPV() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aPV = fVar.aPV();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aPV());
                    if (!this.eHQ && fVar.aQl() && aPV.aEt() != null) {
                        aPV.g(null);
                    }
                    postData2 = aPV;
                    z4 = true;
                }
                cu(arrayList);
                if (this.eMh.aRH()) {
                    if (fVar.aPQ().size() > 0 && (postData3 = fVar.aPQ().get(0)) != null && postData3.buu() == 1 && !com.baidu.tbadk.core.util.v.v(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.eHR, arrayList, this.eHQ);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.eHR.aPR());
                    }
                }
                int b = b(this.eHR, arrayList, this.eHQ);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.eHR.aPS());
                }
                if (arrayList.size() == 0 && this.eMh.aRH()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                com.baidu.tieba.tbadkCore.o.p(arrayList, 1);
                int c = c(fVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eGO);
                    if (fVar != null && fVar.aPO() != null) {
                        jVar.eGQ = fVar.aPO().rl();
                    }
                    jVar.aFc = !this.eHQ;
                    jVar.eGS = this.eMh.aRU();
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
                        ((PostData) fVar2).cJc = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d >= 0 && fVar.aQk() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aQk());
                    fVar.aQk().ix((b(arrayList, d) || z5) ? false : true);
                    z5 = true;
                }
                this.eMi.iR(!z5);
                if (this.eMh.aQS() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.eMh.aQS().getPostId())) {
                    z6 = false;
                }
                if (this.eMA && !z6) {
                    arrayList.remove(postData2);
                    this.eMA = false;
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z6 && !z) {
                    if ((this.eMC || this.eMB) && b2 != -1 && !com.baidu.tbadk.core.util.v.v(g) && !this.eMD) {
                        this.eMG = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.4
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.mListView.setSelection(h.this.mListView.getHeaderViewsCount() + g.size());
                                h.this.eMD = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fP().post(this.eMG);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        if (this.eMh.aPV() == null || this.eMh.aRk() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (this.eMB || fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aPQ()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aQl() && this.eHQ) ? 0 : -1;
        } else if (this.eMh.aQS() == null || !this.eMh.aQS().getIsFromMark()) {
            if (this.eMh.aRk() == null || !this.eMh.aRk().getIsInterviewLive()) {
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
                        if (postData.buu() == 1 && postData.gpR == 0) {
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
                return fVar.aQl() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aPQ()) || com.baidu.tbadk.core.util.v.v(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(fVar.aPQ(), 0)) == null) {
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
                if (postData.buu() == 1 && postData.gpR == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.v.v(fVar.aPQ()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aQl()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i);
            if ((fVar2 instanceof PostData) && ((PostData) fVar2).buu() == 1) {
                return i + 1;
            }
        }
        return !fVar.aQl() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.f> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPY() == null || com.baidu.tbadk.core.util.v.v(fVar.aPY().eHj)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aPY().eHj;
        if (com.baidu.tbadk.core.util.v.v(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gpT = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.u(fVar.aPY().eHk) > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).gpT = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).gpT = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eGP);
        jVar.eGR = fVar.aPY().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void ali() {
        if (this.eMh != null && !alj()) {
            this.eMh.registerListener(this.cDC);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean alj() {
        if (this.eMh == null) {
            return false;
        }
        this.cDs = new ArrayList();
        ArrayList<BdUniqueId> btF = com.baidu.tieba.tbadkCore.o.btF();
        if (btF == null || btF.size() <= 0) {
            return false;
        }
        int size = btF.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aHp().a(this.eMh.getPageContext(), btF.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cDs.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.v(this.cDs)) {
            this.mListView.addAdapters(this.cDs);
        }
        return true;
    }

    public int aSg() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPQ() == null || fVar.aPR() == null || fVar.aPQ().size() == 0 || fVar.aPO() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPR().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPQ().get(0) == null || fVar.aPQ().get(0).buu() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qv() == null || fVar.qv().qp() != fVar.qv().qm()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPQ() == null || fVar.aPS() == null || fVar.aPQ().size() == 0 || fVar.aPO() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPS().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPQ().get(0) == null || fVar.aPQ().get(0).buu() != 1) ? -1 : 1;
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

    public ArrayList<PostData> aSh() {
        return this.postList;
    }

    public BdUniqueId pA(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.eMt == null || !this.eMt.aQJ()) {
            this.eMH = aSi();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public int aSi() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.mListView.getData().get(i2);
                if (fVar == null || fVar.getType() != com.baidu.tieba.pb.data.j.eGO) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aSj() {
        return this.eMH;
    }

    private void aSk() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eHR != null) {
            ArrayList<PostData> aPQ = this.eHR.aPQ();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aQc = this.eHR.aQc();
            if (aQc != null) {
                int size = aQc.size();
                if (aPQ != null && aPQ.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aQc.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aQc.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.cIq = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aQc.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.buj() != null) {
                            int pr = next3.buj().pr();
                            if (pr != 0) {
                                a(next3, pr);
                                if (pr != 28 && pr != 31) {
                                    if (next3.buj().goods != null) {
                                        next3.buj().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.t.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.buj().apk_name)) {
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
                        if (this.eHR.aPM() != null) {
                            lVar4.forumId = this.eHR.aPM().getId();
                        }
                        if (this.eHR.aPO() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.eHR.aPO().getId(), 0L);
                        }
                        if (this.eHR != null && this.eHR.qv() != null) {
                            lVar4.pageNumber = this.eHR.qv().qp();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aPQ.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.eHQ) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aPQ.add(position2, lVar4);
                        TiebaStatic.eventStat(this.eMh.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.buj().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sv(i);
        com.baidu.tieba.recapp.report.b.bjK().a(c);
        if (lVar != null && lVar.buj() != null) {
            lVar.buj().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.buj() != null && lVar.buj().goods != null && lVar.buj().goods.goods_style != 1001 && lVar.buj().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aPM;
        if (lVar != null && this.eHR != null && lVar.buj() != null) {
            lVar.buj().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eHR.qv() != null) {
                lVar.buj().advertAppContext.pn = this.eHR.qv().qp();
            }
            lVar.buj().advertAppContext.TL = "PB";
            if (this.eHR.aPM() != null && (aPM = this.eHR.aPM()) != null) {
                lVar.buj().advertAppContext.fid = aPM.getId();
                lVar.buj().advertAppContext.TO = aPM.getFirst_class();
                lVar.buj().advertAppContext.TP = aPM.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.buj().advertAppContext.TQ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.buj().advertAppContext.extensionInfo = lVar.buj().ext_info;
            lVar.buj().advertAppContext.TR = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eMu.setFromCDN(z);
        this.eMi.setFromCDN(z);
        if (this.eMo != null && (this.eMo instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eMo).setIsFromCDN(z);
        }
        if (this.eMp != null && (this.eMp instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eMp).setIsFromCDN(z);
        }
        if (this.cHt != null && (this.cHt instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cHt).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eMz.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean aSl() {
        return this.eHP;
    }

    public void iy(boolean z) {
        this.eHP = z;
    }

    public void iz(boolean z) {
        this.eHQ = z;
    }

    public void iA(boolean z) {
        this.eME = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.eHU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSv = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSw = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auR = onLongClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void pB(int i) {
        if (this.eMj != null) {
            this.eMj.pB(i);
        }
        switch (i) {
            case 1:
                if (this.eMt != null) {
                    this.eMt.pause();
                }
                if (this.eMi != null) {
                    this.eMi.pause();
                }
                if (this.eMq != null && (this.eMq instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eMq).release();
                    return;
                }
                return;
            case 2:
                if (this.eMt != null) {
                    this.eMt.resume();
                }
                if (this.eMi != null) {
                    this.eMi.resume();
                }
                if (this.eMq != null && (this.eMq instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eMq).resume();
                    return;
                }
                return;
            case 3:
                if (this.eMt != null) {
                    this.eMt.release();
                }
                if (this.eMi != null) {
                    this.eMi.release();
                }
                if (this.eMq != null && (this.eMq instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eMq).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cu(List<com.baidu.adp.widget.ListView.f> list) {
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
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eMG);
        if (this.eMk != null) {
            this.eMk.onDestory();
        }
    }

    public void iN(boolean z) {
        this.eMB = z;
    }

    public void iO(boolean z) {
        this.eMC = z;
    }

    public void iP(boolean z) {
        this.eMA = z;
    }

    public void iQ(boolean z) {
        this.eMD = z;
    }

    public al aSm() {
        return this.eMj;
    }
}
