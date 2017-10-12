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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
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
public class f {
    private List<com.baidu.adp.widget.ListView.a> cvY;
    private com.baidu.adp.widget.ListView.a czP;
    private com.baidu.adp.widget.ListView.a czQ;
    private com.baidu.tieba.pb.data.f eAc;
    private PbActivity eDC;
    private o eDD;
    private aj eDE;
    private af eDF;
    private af eDG;
    private i eDH;
    private com.baidu.tieba.pb.video.j eDI;
    private com.baidu.tieba.pb.video.l eDJ;
    private com.baidu.tieba.pb.video.a eDK;
    private int eDL;
    private com.baidu.adp.widget.ListView.a eDN;
    private com.baidu.adp.widget.ListView.a eDO;
    private com.baidu.adp.widget.ListView.a eDP;
    private ab eDQ;
    private ac eDR;
    private com.baidu.tieba.pb.pb.a.b eDS;
    private com.baidu.tieba.pb.pb.a.g eDT;
    private r eDU;
    private z eDV;
    private com.baidu.tieba.pb.pb.a.c eDW;
    private com.baidu.tieba.pb.pb.a.f eDX;
    private boolean eEc;
    private boolean eEd;
    private Runnable eEi;
    private int ezZ;
    private BdTypeListView mListView;
    private int width;
    private int eDM = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eDY = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eAa = true;
    private boolean eDZ = true;
    private boolean eAb = true;
    private boolean eEa = false;
    private boolean eEb = false;
    private boolean eEe = false;
    private boolean eEf = false;
    private String mHostId = null;
    private View.OnClickListener eAf = null;
    private View.OnClickListener eAg = null;
    private TbRichTextView.f aSw = null;
    private com.baidu.tieba.pb.a.c aSx = null;
    private View.OnLongClickListener auG = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eEg = new ArrayList();
    private boolean eEh = false;
    private int eEj = -1;
    private CustomMessageListener cwg = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bqW = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bqW();
                Iterator it = bqW.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ao(f.this.eDC);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.eDY.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.eDS = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bqW);
                f.this.eEg.clear();
                f.this.eEg.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cru = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.eAc != null && !com.baidu.adp.base.i.W(f.this.eDC.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener cwh = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.u(f.this.cvY)) {
                f.this.ajc();
                f.this.a(f.this.eAc, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ezZ = 0;
        this.width = -1;
        this.ezZ = com.baidu.adp.lib.util.l.ad(pbActivity.getPageContext().getPageActivity());
        this.width = this.ezZ;
        this.eDC = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cru);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eDT = new com.baidu.tieba.pb.pb.a.g(pbActivity, PostData.ggK);
        this.eDD = new o(pbActivity, PostData.ggH);
        this.eDD.a(pbActivity);
        this.eDE = new aj(pbActivity, com.baidu.tieba.pb.data.l.ezh);
        this.eDF = new af(pbActivity, com.baidu.tieba.pb.data.j.ezb);
        this.eDG = new af(pbActivity, com.baidu.tieba.pb.data.j.ezc);
        this.eDH = new i(pbActivity, PostData.ggI);
        this.eDH.a(pbActivity);
        this.czP = com.baidu.tieba.recapp.r.bfT().a(pbActivity, AdvertAppInfo.TR);
        this.eDN = com.baidu.tieba.recapp.r.bfT().a(pbActivity, AdvertAppInfo.TS);
        this.eDO = com.baidu.tieba.recapp.r.bfT().a(pbActivity, AdvertAppInfo.TT);
        this.eDP = com.baidu.tieba.recapp.r.bfT().a(pbActivity, AdvertAppInfo.TU);
        this.czQ = com.baidu.tieba.recapp.r.bfT().a(pbActivity, AdvertAppInfo.TY);
        this.eDU = new r(pbActivity, com.baidu.tieba.pb.data.a.eyb);
        this.eDV = new z(pbActivity, com.baidu.tieba.pb.data.i.eza);
        this.eDQ = new ab(pbActivity, y.eHF);
        this.eDR = new ac(pbActivity, as.Xs);
        this.eDI = new com.baidu.tieba.pb.video.j(pbActivity, com.baidu.tieba.pb.video.k.eTR);
        this.eDJ = new com.baidu.tieba.pb.video.l(pbActivity, com.baidu.tieba.pb.video.m.eTZ);
        this.eDX = new com.baidu.tieba.pb.pb.a.f(pbActivity, PostData.ggS);
        this.eDJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.a(f.this.eAc, false);
                f.this.notifyDataSetChanged();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11926"));
            }
        });
        this.eDK = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.eSE);
        this.eDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eAc.aNl() != null) {
                    List<Long> list = f.this.eAc.aNl().ezv;
                    int count = f.this.eAc.aNl().getCount();
                    if (list.size() != count) {
                        if (list.size() >= count + 5) {
                            f.this.eAc.aNl().setCount(count + 5);
                            f.this.eDC.aOi().aPW().cu(list.subList(count, count + 5));
                        } else if (list.size() < count + 5) {
                            f.this.eDC.aOi().aPW().cu(list.subList(count, list.size()));
                            f.this.eAc.aNl().setCount(list.size());
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                    }
                }
            }
        });
        this.eDW = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Vq);
        if (this.eAc != null && this.eAc.aNb() != null) {
            this.eDW.anb = this.eAc.aNb().aac;
        }
        this.mAdapters.add(this.eDD);
        this.mAdapters.add(this.eDE);
        this.mAdapters.add(this.eDH);
        this.mAdapters.add(this.eDF);
        this.mAdapters.add(this.eDG);
        this.mAdapters.add(this.eDT);
        this.mAdapters.add(this.czP);
        this.mAdapters.add(this.eDN);
        this.mAdapters.add(this.eDO);
        this.mAdapters.add(this.eDP);
        this.mAdapters.add(this.czQ);
        this.mAdapters.add(this.eDU);
        this.mAdapters.add(this.eDV);
        this.mAdapters.add(this.eDQ);
        this.mAdapters.add(this.eDR);
        this.mAdapters.add(this.eDI);
        this.mAdapters.add(this.eDJ);
        this.mAdapters.add(this.eDW);
        this.mAdapters.add(this.eDK);
        this.mAdapters.add(this.eDX);
        this.cwg.setPriority(1);
        this.cwg.setSelfListener(true);
        pbActivity.registerListener(this.cwg);
        ajb();
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
            if (this.eAc != fVar) {
                z2 = (fVar == null || fVar.aMX()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eAc = fVar;
            if (z2) {
                aPk();
                if (fVar != null) {
                    fVar.iC(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eAc != null && this.eAc.aNd() != null && this.eAc.aNd().size() > 0) {
                this.postList.addAll(this.eAc.aNd());
            }
            if (fVar != null && fVar.aNb() != null && fVar.aNb().getAuthor() != null) {
                this.mHostId = fVar.aNb().getAuthor().getUserId();
            }
            if (this.eDD != null) {
                this.eDT.b(fVar);
                this.eDT.setFromCDN(this.mIsFromCDN);
                this.eDT.setHostId(this.mHostId);
                this.eDT.pa(this.ezZ);
                this.eDT.iE(this.eAa);
                this.eDT.iF(this.eAb);
                this.eDT.setCommonClickListener(this.eAg);
                this.eDT.C(this.eAf);
                this.eDT.setOnImageClickListener(this.aSw);
                this.eDT.setOnLongClickListener(this.auG);
                this.eDD.b(fVar);
                this.eDD.setFromCDN(this.mIsFromCDN);
                this.eDD.setHostId(this.mHostId);
                this.eDD.pa(this.ezZ);
                this.eDD.iE(this.eAa);
                this.eDD.iF(this.eAb);
                this.eDD.setCommonClickListener(this.eAg);
                this.eDD.C(this.eAf);
                this.eDD.setOnImageClickListener(this.aSw);
                this.eDD.setOnLongClickListener(this.auG);
                this.eDD.setTbGestureDetector(this.aSx);
                this.eDD.pj(fVar != null ? fVar.aNb().rn() : 0);
                this.eDH.b(fVar);
                this.eDH.setFromCDN(this.mIsFromCDN);
                this.eDH.setHostId(this.mHostId);
                this.eDH.iE(this.eAa);
                this.eDH.setCommonClickListener(this.eAg);
                this.eDH.C(this.eAf);
                this.eDH.setOnImageClickListener(this.aSw);
                this.eDH.setOnLongClickListener(this.auG);
                this.eDH.setTbGestureDetector(this.aSx);
                this.eDE.setOnClickListener(this.eAg);
                this.eDE.setTbGestureDetector(this.aSx);
                this.eDX.setOnClickListener(this.eAg);
                if (this.eDN != null && (this.eDN instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eDN).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eDO != null && (this.eDO instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eDO).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.czQ != null && (this.czQ instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.czQ).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eDY.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.pa(this.ezZ);
                        next.iE(this.eAa);
                        next.iF(this.eAb);
                        next.iG(this.eEf);
                        next.setCommonClickListener(this.eAg);
                        next.C(this.eAf);
                        next.setOnImageClickListener(this.aSw);
                        next.setOnLongClickListener(this.auG);
                    }
                }
                this.eDF.setCommonClickListener(this.eAg);
                this.eDG.setCommonClickListener(this.eAg);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aNd());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).brx() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.eAb && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aNy() && postData.aCd() != null) {
                        postData.g(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aNi() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aNi = fVar.aNi();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aNi());
                    if (!this.eAb && fVar.aNy() && aNi.aCd() != null) {
                        aNi.g(null);
                    }
                    postData2 = aNi;
                    z4 = true;
                }
                ct(arrayList);
                if (this.eDC.aOF()) {
                    if (fVar.aNd().size() > 0 && (postData3 = fVar.aNd().get(0)) != null && postData3.brx() == 1 && !com.baidu.tbadk.core.util.v.u(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.eAc, arrayList, this.eAb);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.eAc.aNe());
                    }
                }
                int c = c(this.eAc, arrayList, this.eAb);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.eAc.aNf());
                }
                if (arrayList.size() == 0 && this.eDC.aOF()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.eAb);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.f> e = e(fVar, arrayList);
                    if (e != null && e.size() > 0) {
                        com.baidu.tbadk.core.util.v.a((List) arrayList, a, (List) e);
                    } else {
                        this.eDL = 0;
                    }
                } else {
                    this.eDL = 0;
                }
                com.baidu.tieba.tbadkCore.n.p(arrayList, 1);
                int c2 = c(fVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.ezb);
                    if (fVar != null && fVar.aNb() != null) {
                        jVar.ezd = fVar.aNb().rn();
                    }
                    jVar.aEG = !this.eAb;
                    jVar.eze = this.eDC.aOS();
                    com.baidu.tbadk.core.util.v.a(arrayList, c2, jVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(fVar, arrayList);
                final List<com.baidu.adp.widget.ListView.f> f = f(fVar);
                if (!com.baidu.tbadk.core.util.v.u(f) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, b2);
                    if (fVar2 instanceof PostData) {
                        ((PostData) fVar2).cBz = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) f);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d >= 0 && fVar.aNx() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aNx());
                    fVar.aNx().iD((b(arrayList, d) || z5) ? false : true);
                    z5 = true;
                }
                this.eDD.iW(!z5);
                if (this.eDC.aOi() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.eDC.aOi().getPostId())) {
                    z6 = false;
                }
                if (this.eEa && !z6) {
                    arrayList.remove(postData2);
                    this.eEa = false;
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z6 && !z) {
                    if ((this.eEc || this.eEb) && b2 != -1 && !com.baidu.tbadk.core.util.v.u(f) && !this.eEd) {
                        this.eEi = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.5
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelection(f.this.mListView.getHeaderViewsCount() + f.size());
                                f.this.eEd = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fP().post(this.eEi);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        if (this.eDC.aNi() == null || this.eDC.aOh() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (this.eEb || fVar == null || com.baidu.tbadk.core.util.v.u(fVar.aNd()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aNy() && this.eAb) ? 0 : -1;
        } else if (this.eDC.aOi() == null || !this.eDC.aOi().getIsFromMark()) {
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
                    if (postData.brx() == 1 && postData.ghu == 0) {
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
            return fVar.aNy() ? 0 : -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.u(fVar.aNd()) || com.baidu.tbadk.core.util.v.u(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(fVar.aNd(), 0)) == null) {
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
                if (postData.brx() == 1 && postData.ghu == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.v.u(fVar.aNd()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aNy()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i);
            if ((fVar2 instanceof PostData) && ((PostData) fVar2).brx() == 1) {
                return i + 1;
            }
        }
        return !fVar.aNy() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.f> f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aNl() == null || com.baidu.tbadk.core.util.v.u(fVar.aNl().ezu)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aNl().ezu;
        if (com.baidu.tbadk.core.util.v.u(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.ghw = true;
                arrayList.add(postData);
            }
        }
        int t = com.baidu.tbadk.core.util.v.t(fVar.aNl().ezv);
        if (fVar.aNl().getCount() != t && t > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).ghw = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).ghw = true;
            }
        }
        arrayList.add(0, new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.ezc));
        return arrayList;
    }

    public void aPe() {
        this.eDL = 0;
    }

    public int aPf() {
        return this.eDM;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.v.u(fVar.aNd()) || com.baidu.tbadk.core.util.v.u(fVar.aNc())) {
            return -1;
        }
        if (z) {
            return (fVar.aNd().get(0) == null || fVar.aNd().get(0).brx() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.f> e(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (fVar == null || arrayList == null || fVar.aNc() == null || fVar.aNc().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<bh> aNc = fVar.aNc();
        int size = aNc.size();
        this.eDM = 0;
        if (this.eDL + 5 >= size) {
            int i2 = 0;
            for (bh bhVar : aNc) {
                if (bhVar != null) {
                    com.baidu.tieba.pb.video.k kVar = new com.baidu.tieba.pb.video.k();
                    int i3 = i2 + 1;
                    if (i3 == 1) {
                        kVar.a(bhVar, true, true, true, i3);
                    } else {
                        kVar.a(bhVar, true, true, false, i3);
                    }
                    arrayList2.add(kVar);
                    this.eDL++;
                    i = i3;
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (this.eDL <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.eDM = arrayList2.size();
            }
            return arrayList2;
        }
        int i4 = this.eDL + 5;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            bh bhVar2 = aNc.get(i6);
            if (bhVar2 != null) {
                com.baidu.tieba.pb.video.k kVar2 = new com.baidu.tieba.pb.video.k();
                i5++;
                boolean z = i5 == 1;
                if (i6 == i4 - 1) {
                    kVar2.a(bhVar2, false, true, z, i5);
                } else {
                    kVar2.a(bhVar2, true, true, z, i5);
                }
                arrayList2.add(kVar2);
                this.eDL++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.m());
        this.eDM = arrayList2.size();
        return arrayList2;
    }

    private void ajb() {
        if (this.eDC != null && !ajc()) {
            this.eDC.registerListener(this.cwh);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ajc() {
        if (this.eDC == null) {
            return false;
        }
        this.cvY = new ArrayList();
        ArrayList<BdUniqueId> bqG = com.baidu.tieba.tbadkCore.n.bqG();
        if (bqG == null || bqG.size() <= 0) {
            return false;
        }
        int size = bqG.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aEZ().a(this.eDC.getPageContext(), bqG.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cvY.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.u(this.cvY)) {
            this.mListView.addAdapters(this.cvY);
        }
        return true;
    }

    public int aPg() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aNd() == null || fVar.aNe() == null || fVar.aNd().size() == 0 || fVar.aNb() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aNe().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aNd().get(0) == null || fVar.aNd().get(0).brx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qx() == null || fVar.qx().qr() != fVar.qx().qo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aNd() == null || fVar.aNf() == null || fVar.aNd().size() == 0 || fVar.aNb() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aNf().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aNd().get(0) == null || fVar.aNd().get(0).brx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qx() == null || fVar.qx().qr() != fVar.qx().qo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aPh() {
        return this.postList;
    }

    public BdUniqueId pg(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.eDS == null || !this.eDS.aNV()) {
            this.eEj = aPi();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public int aPi() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.mListView.getData().get(i2);
                if (fVar == null || fVar.getType() != com.baidu.tieba.pb.data.j.ezb) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aPj() {
        return this.eEj;
    }

    private void aPk() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eAc != null) {
            ArrayList<PostData> aNd = this.eAc.aNd();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aNp = this.eAc.aNp();
            if (aNp != null) {
                int size = aNp.size();
                if (aNd != null && aNd.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aNp.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.brn() != null) {
                            sb.append(next.brn());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aNp.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.cAN = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aNp.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.brl() != null) {
                            int pt = next3.brl().pt();
                            if (pt != 0) {
                                a(next3, pt);
                                if (pt != 28 && pt != 31) {
                                    if (next3.brl().goods != null) {
                                        next3.brl().goods.goods_style = TbErrInfo.ERR_IMG_GET_REMOTE;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.brl().apk_name)) {
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
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.brn(), lVar3)) != null) {
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
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.f.7
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.eAc.aMZ() != null) {
                            lVar4.forumId = this.eAc.aMZ().getId();
                        }
                        if (this.eAc.aNb() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.eAc.aNb().getId(), 0L);
                        }
                        if (this.eAc != null && this.eAc.qx() != null) {
                            lVar4.pageNumber = this.eAc.qx().qr();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aNd.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.eAb) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aNd.add(position2, lVar4);
                        TiebaStatic.eventStat(this.eDC.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.brl().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sg(i);
        com.baidu.tieba.recapp.report.b.bgD().a(c);
        if (lVar != null && lVar.brl() != null) {
            lVar.brl().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.brl() != null && lVar.brl().goods != null && lVar.brl().goods.goods_style != 1001 && lVar.brl().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aMZ;
        if (lVar != null && this.eAc != null && lVar.brl() != null) {
            lVar.brl().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eAc.qx() != null) {
                lVar.brl().advertAppContext.pn = this.eAc.qx().qr();
            }
            lVar.brl().advertAppContext.TF = "PB";
            if (this.eAc.aMZ() != null && (aMZ = this.eAc.aMZ()) != null) {
                lVar.brl().advertAppContext.fid = aMZ.getId();
                lVar.brl().advertAppContext.TH = aMZ.getFirst_class();
                lVar.brl().advertAppContext.TI = aMZ.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.brl().advertAppContext.TJ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.brl().advertAppContext.extensionInfo = lVar.brl().ext_info;
            lVar.brl().advertAppContext.TK = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eDT.setFromCDN(z);
        this.eDD.setFromCDN(z);
        if (this.eDN != null && (this.eDN instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eDN).setIsFromCDN(z);
        }
        if (this.eDO != null && (this.eDO instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eDO).setIsFromCDN(z);
        }
        if (this.czQ != null && (this.czQ instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.czQ).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eDY.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void iE(boolean z) {
        this.eAa = z;
    }

    public void iF(boolean z) {
        this.eAb = z;
    }

    public void iG(boolean z) {
        this.eEf = z;
    }

    public void C(View.OnClickListener onClickListener) {
        this.eAf = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSw = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auG = onLongClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.eAg = onClickListener;
    }

    public void ph(int i) {
        if (this.eDE != null) {
            this.eDE.ph(i);
        }
        switch (i) {
            case 1:
                if (this.eDS != null) {
                    this.eDS.pause();
                }
                if (this.eDD != null) {
                    this.eDD.pause();
                }
                if (this.eDP != null && (this.eDP instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eDP).release();
                    return;
                }
                return;
            case 2:
                if (this.eDS != null) {
                    this.eDS.resume();
                }
                if (this.eDD != null) {
                    this.eDD.resume();
                }
                if (this.eDP != null && (this.eDP instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eDP).resume();
                    return;
                }
                return;
            case 3:
                if (this.eDS != null) {
                    this.eDS.release();
                }
                if (this.eDD != null) {
                    this.eDD.release();
                }
                if (this.eDP != null && (this.eDP instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eDP).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void ct(List<com.baidu.adp.widget.ListView.f> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sq())) {
                        com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
                        afVar.cx(postData.sq());
                        list.set(i, afVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eEi);
        if (this.eDF != null) {
            this.eDF.onDestory();
        }
    }

    public void iR(boolean z) {
        this.eEe = z;
    }

    public void iS(boolean z) {
        this.eEb = z;
    }

    public void iT(boolean z) {
        this.eEc = z;
    }

    public void iU(boolean z) {
        this.eEa = z;
    }

    public void iV(boolean z) {
        this.eEd = z;
    }

    public aj aPl() {
        return this.eDE;
    }
}
