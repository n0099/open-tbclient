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
    private List<com.baidu.adp.widget.ListView.a> cvM;
    private com.baidu.adp.widget.ListView.a czD;
    private com.baidu.adp.widget.ListView.a czE;
    private com.baidu.adp.widget.ListView.a eDA;
    private com.baidu.adp.widget.ListView.a eDB;
    private ab eDC;
    private ac eDD;
    private com.baidu.tieba.pb.pb.a.b eDE;
    private com.baidu.tieba.pb.pb.a.g eDF;
    private r eDG;
    private z eDH;
    private com.baidu.tieba.pb.pb.a.c eDI;
    private com.baidu.tieba.pb.pb.a.f eDJ;
    private boolean eDO;
    private boolean eDP;
    private Runnable eDU;
    private PbActivity eDo;
    private o eDp;
    private aj eDq;
    private af eDr;
    private af eDs;
    private i eDt;
    private com.baidu.tieba.pb.video.j eDu;
    private com.baidu.tieba.pb.video.l eDv;
    private com.baidu.tieba.pb.video.a eDw;
    private int eDx;
    private com.baidu.adp.widget.ListView.a eDz;
    private int ezL;
    private com.baidu.tieba.pb.data.f ezO;
    private BdTypeListView mListView;
    private int width;
    private int eDy = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eDK = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean ezM = true;
    private boolean eDL = true;
    private boolean ezN = true;
    private boolean eDM = false;
    private boolean eDN = false;
    private boolean eDQ = false;
    private boolean eDR = false;
    private String mHostId = null;
    private View.OnClickListener ezR = null;
    private View.OnClickListener ezS = null;
    private TbRichTextView.f aSj = null;
    private com.baidu.tieba.pb.a.c aSk = null;
    private View.OnLongClickListener auu = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eDS = new ArrayList();
    private boolean eDT = false;
    private int eDV = -1;
    private CustomMessageListener cvU = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bqP = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bqP();
                Iterator it = bqP.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ao(f.this.eDo);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.eDK.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.eDE = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bqP);
                f.this.eDS.clear();
                f.this.eDS.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cri = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.ezO != null && !com.baidu.adp.base.i.W(f.this.eDo.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener cvV = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.u(f.this.cvM)) {
                f.this.aiX();
                f.this.a(f.this.ezO, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ezL = 0;
        this.width = -1;
        this.ezL = com.baidu.adp.lib.util.l.ad(pbActivity.getPageContext().getPageActivity());
        this.width = this.ezL;
        this.eDo = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cri);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eDF = new com.baidu.tieba.pb.pb.a.g(pbActivity, PostData.ggw);
        this.eDp = new o(pbActivity, PostData.ggt);
        this.eDp.a(pbActivity);
        this.eDq = new aj(pbActivity, com.baidu.tieba.pb.data.l.eyT);
        this.eDr = new af(pbActivity, com.baidu.tieba.pb.data.j.eyN);
        this.eDs = new af(pbActivity, com.baidu.tieba.pb.data.j.eyO);
        this.eDt = new i(pbActivity, PostData.ggu);
        this.eDt.a(pbActivity);
        this.czD = com.baidu.tieba.recapp.r.bfO().a(pbActivity, AdvertAppInfo.TE);
        this.eDz = com.baidu.tieba.recapp.r.bfO().a(pbActivity, AdvertAppInfo.TF);
        this.eDA = com.baidu.tieba.recapp.r.bfO().a(pbActivity, AdvertAppInfo.TG);
        this.eDB = com.baidu.tieba.recapp.r.bfO().a(pbActivity, AdvertAppInfo.TH);
        this.czE = com.baidu.tieba.recapp.r.bfO().a(pbActivity, AdvertAppInfo.TL);
        this.eDG = new r(pbActivity, com.baidu.tieba.pb.data.a.exN);
        this.eDH = new z(pbActivity, com.baidu.tieba.pb.data.i.eyM);
        this.eDC = new ab(pbActivity, y.eHr);
        this.eDD = new ac(pbActivity, as.Xg);
        this.eDu = new com.baidu.tieba.pb.video.j(pbActivity, com.baidu.tieba.pb.video.k.eTD);
        this.eDv = new com.baidu.tieba.pb.video.l(pbActivity, com.baidu.tieba.pb.video.m.eTL);
        this.eDJ = new com.baidu.tieba.pb.pb.a.f(pbActivity, PostData.ggE);
        this.eDv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.a(f.this.ezO, false);
                f.this.notifyDataSetChanged();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11926"));
            }
        });
        this.eDw = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.eSq);
        this.eDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ezO.aNg() != null) {
                    List<Long> list = f.this.ezO.aNg().ezh;
                    int count = f.this.ezO.aNg().getCount();
                    if (list.size() != count) {
                        if (list.size() >= count + 5) {
                            f.this.ezO.aNg().setCount(count + 5);
                            f.this.eDo.aOd().aPR().cu(list.subList(count, count + 5));
                        } else if (list.size() < count + 5) {
                            f.this.eDo.aOd().aPR().cu(list.subList(count, list.size()));
                            f.this.ezO.aNg().setCount(list.size());
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                    }
                }
            }
        });
        this.eDI = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Ve);
        if (this.ezO != null && this.ezO.aMW() != null) {
            this.eDI.amP = this.ezO.aMW().ZQ;
        }
        this.mAdapters.add(this.eDp);
        this.mAdapters.add(this.eDq);
        this.mAdapters.add(this.eDt);
        this.mAdapters.add(this.eDr);
        this.mAdapters.add(this.eDs);
        this.mAdapters.add(this.eDF);
        this.mAdapters.add(this.czD);
        this.mAdapters.add(this.eDz);
        this.mAdapters.add(this.eDA);
        this.mAdapters.add(this.eDB);
        this.mAdapters.add(this.czE);
        this.mAdapters.add(this.eDG);
        this.mAdapters.add(this.eDH);
        this.mAdapters.add(this.eDC);
        this.mAdapters.add(this.eDD);
        this.mAdapters.add(this.eDu);
        this.mAdapters.add(this.eDv);
        this.mAdapters.add(this.eDI);
        this.mAdapters.add(this.eDw);
        this.mAdapters.add(this.eDJ);
        this.cvU.setPriority(1);
        this.cvU.setSelfListener(true);
        pbActivity.registerListener(this.cvU);
        aiW();
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
            if (this.ezO != fVar) {
                z2 = (fVar == null || fVar.aMS()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.ezO = fVar;
            if (z2) {
                aPf();
                if (fVar != null) {
                    fVar.iB(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.ezO != null && this.ezO.aMY() != null && this.ezO.aMY().size() > 0) {
                this.postList.addAll(this.ezO.aMY());
            }
            if (fVar != null && fVar.aMW() != null && fVar.aMW().getAuthor() != null) {
                this.mHostId = fVar.aMW().getAuthor().getUserId();
            }
            if (this.eDp != null) {
                this.eDF.b(fVar);
                this.eDF.setFromCDN(this.mIsFromCDN);
                this.eDF.setHostId(this.mHostId);
                this.eDF.oZ(this.ezL);
                this.eDF.iD(this.ezM);
                this.eDF.iE(this.ezN);
                this.eDF.setCommonClickListener(this.ezS);
                this.eDF.C(this.ezR);
                this.eDF.setOnImageClickListener(this.aSj);
                this.eDF.setOnLongClickListener(this.auu);
                this.eDp.b(fVar);
                this.eDp.setFromCDN(this.mIsFromCDN);
                this.eDp.setHostId(this.mHostId);
                this.eDp.oZ(this.ezL);
                this.eDp.iD(this.ezM);
                this.eDp.iE(this.ezN);
                this.eDp.setCommonClickListener(this.ezS);
                this.eDp.C(this.ezR);
                this.eDp.setOnImageClickListener(this.aSj);
                this.eDp.setOnLongClickListener(this.auu);
                this.eDp.setTbGestureDetector(this.aSk);
                this.eDp.pi(fVar != null ? fVar.aMW().rg() : 0);
                this.eDt.b(fVar);
                this.eDt.setFromCDN(this.mIsFromCDN);
                this.eDt.setHostId(this.mHostId);
                this.eDt.iD(this.ezM);
                this.eDt.setCommonClickListener(this.ezS);
                this.eDt.C(this.ezR);
                this.eDt.setOnImageClickListener(this.aSj);
                this.eDt.setOnLongClickListener(this.auu);
                this.eDt.setTbGestureDetector(this.aSk);
                this.eDq.setOnClickListener(this.ezS);
                this.eDq.setTbGestureDetector(this.aSk);
                this.eDJ.setOnClickListener(this.ezS);
                if (this.eDz != null && (this.eDz instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eDz).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eDA != null && (this.eDA instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eDA).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.czE != null && (this.czE instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.czE).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eDK.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.oZ(this.ezL);
                        next.iD(this.ezM);
                        next.iE(this.ezN);
                        next.iF(this.eDR);
                        next.setCommonClickListener(this.ezS);
                        next.C(this.ezR);
                        next.setOnImageClickListener(this.aSj);
                        next.setOnLongClickListener(this.auu);
                    }
                }
                this.eDr.setCommonClickListener(this.ezS);
                this.eDs.setCommonClickListener(this.ezS);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aMY());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).brq() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.ezN && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aNt() && postData.aBY() != null) {
                        postData.g(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aNd() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aNd = fVar.aNd();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aNd());
                    if (!this.ezN && fVar.aNt() && aNd.aBY() != null) {
                        aNd.g(null);
                    }
                    postData2 = aNd;
                    z4 = true;
                }
                ct(arrayList);
                if (this.eDo.aOA()) {
                    if (fVar.aMY().size() > 0 && (postData3 = fVar.aMY().get(0)) != null && postData3.brq() == 1 && !com.baidu.tbadk.core.util.v.u(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.ezO, arrayList, this.ezN);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.ezO.aMZ());
                    }
                }
                int c = c(this.ezO, arrayList, this.ezN);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.ezO.aNa());
                }
                if (arrayList.size() == 0 && this.eDo.aOA()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.ezN);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.f> e = e(fVar, arrayList);
                    if (e != null && e.size() > 0) {
                        com.baidu.tbadk.core.util.v.a((List) arrayList, a, (List) e);
                    } else {
                        this.eDx = 0;
                    }
                } else {
                    this.eDx = 0;
                }
                com.baidu.tieba.tbadkCore.n.p(arrayList, 1);
                int c2 = c(fVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eyN);
                    if (fVar != null && fVar.aMW() != null) {
                        jVar.eyP = fVar.aMW().rg();
                    }
                    jVar.aEt = !this.ezN;
                    jVar.eyQ = this.eDo.aON();
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
                        ((PostData) fVar2).cBn = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) f);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d >= 0 && fVar.aNs() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aNs());
                    fVar.aNs().iC((b(arrayList, d) || z5) ? false : true);
                    z5 = true;
                }
                this.eDp.iV(!z5);
                if (this.eDo.aOd() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.eDo.aOd().getPostId())) {
                    z6 = false;
                }
                if (this.eDM && !z6) {
                    arrayList.remove(postData2);
                    this.eDM = false;
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z6 && !z) {
                    if ((this.eDO || this.eDN) && b2 != -1 && !com.baidu.tbadk.core.util.v.u(f) && !this.eDP) {
                        this.eDU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.5
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelection(f.this.mListView.getHeaderViewsCount() + f.size());
                                f.this.eDP = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fP().post(this.eDU);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        if (this.eDo.aNd() == null || this.eDo.aOc() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (this.eDN || fVar == null || com.baidu.tbadk.core.util.v.u(fVar.aMY()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aNt() && this.ezN) ? 0 : -1;
        } else if (this.eDo.aOd() == null || !this.eDo.aOd().getIsFromMark()) {
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
                    if (postData.brq() == 1 && postData.ghg == 0) {
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
            return fVar.aNt() ? 0 : -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.u(fVar.aMY()) || com.baidu.tbadk.core.util.v.u(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(fVar.aMY(), 0)) == null) {
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
                if (postData.brq() == 1 && postData.ghg == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.v.u(fVar.aMY()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aNt()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i);
            if ((fVar2 instanceof PostData) && ((PostData) fVar2).brq() == 1) {
                return i + 1;
            }
        }
        return !fVar.aNt() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.f> f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aNg() == null || com.baidu.tbadk.core.util.v.u(fVar.aNg().ezg)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aNg().ezg;
        if (com.baidu.tbadk.core.util.v.u(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.ghi = true;
                arrayList.add(postData);
            }
        }
        int t = com.baidu.tbadk.core.util.v.t(fVar.aNg().ezh);
        if (fVar.aNg().getCount() != t && t > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).ghi = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).ghi = true;
            }
        }
        arrayList.add(0, new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.eyO));
        return arrayList;
    }

    public void aOZ() {
        this.eDx = 0;
    }

    public int aPa() {
        return this.eDy;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.v.u(fVar.aMY()) || com.baidu.tbadk.core.util.v.u(fVar.aMX())) {
            return -1;
        }
        if (z) {
            return (fVar.aMY().get(0) == null || fVar.aMY().get(0).brq() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.f> e(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (fVar == null || arrayList == null || fVar.aMX() == null || fVar.aMX().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<bh> aMX = fVar.aMX();
        int size = aMX.size();
        this.eDy = 0;
        if (this.eDx + 5 >= size) {
            int i2 = 0;
            for (bh bhVar : aMX) {
                if (bhVar != null) {
                    com.baidu.tieba.pb.video.k kVar = new com.baidu.tieba.pb.video.k();
                    int i3 = i2 + 1;
                    if (i3 == 1) {
                        kVar.a(bhVar, true, true, true, i3);
                    } else {
                        kVar.a(bhVar, true, true, false, i3);
                    }
                    arrayList2.add(kVar);
                    this.eDx++;
                    i = i3;
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (this.eDx <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.eDy = arrayList2.size();
            }
            return arrayList2;
        }
        int i4 = this.eDx + 5;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            bh bhVar2 = aMX.get(i6);
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
                this.eDx++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.m());
        this.eDy = arrayList2.size();
        return arrayList2;
    }

    private void aiW() {
        if (this.eDo != null && !aiX()) {
            this.eDo.registerListener(this.cvV);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aiX() {
        if (this.eDo == null) {
            return false;
        }
        this.cvM = new ArrayList();
        ArrayList<BdUniqueId> bqz = com.baidu.tieba.tbadkCore.n.bqz();
        if (bqz == null || bqz.size() <= 0) {
            return false;
        }
        int size = bqz.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aEU().a(this.eDo.getPageContext(), bqz.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cvM.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.u(this.cvM)) {
            this.mListView.addAdapters(this.cvM);
        }
        return true;
    }

    public int aPb() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aMY() == null || fVar.aMZ() == null || fVar.aMY().size() == 0 || fVar.aMW() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aMZ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aMY().get(0) == null || fVar.aMY().get(0).brq() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qq() == null || fVar.qq().qk() != fVar.qq().qh()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aMY() == null || fVar.aNa() == null || fVar.aMY().size() == 0 || fVar.aMW() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aNa().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aMY().get(0) == null || fVar.aMY().get(0).brq() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qq() == null || fVar.qq().qk() != fVar.qq().qh()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aPc() {
        return this.postList;
    }

    public BdUniqueId pf(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.eDE == null || !this.eDE.aNQ()) {
            this.eDV = aPd();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
                ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
            }
        }
    }

    public int aPd() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar = this.mListView.getData().get(i2);
                if (fVar == null || fVar.getType() != com.baidu.tieba.pb.data.j.eyN) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aPe() {
        return this.eDV;
    }

    private void aPf() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.ezO != null) {
            ArrayList<PostData> aMY = this.ezO.aMY();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aNk = this.ezO.aNk();
            if (aNk != null) {
                int size = aNk.size();
                if (aMY != null && aMY.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aNk.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.brg() != null) {
                            sb.append(next.brg());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aNk.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.cAB = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aNk.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bre() != null) {
                            int pm = next3.bre().pm();
                            if (pm != 0) {
                                a(next3, pm);
                                if (pm != 28 && pm != 31) {
                                    if (next3.bre().goods != null) {
                                        next3.bre().goods.goods_style = TbErrInfo.ERR_IMG_GET_REMOTE;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bre().apk_name)) {
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
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.brg(), lVar3)) != null) {
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
                        if (this.ezO.aMU() != null) {
                            lVar4.forumId = this.ezO.aMU().getId();
                        }
                        if (this.ezO.aMW() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.ezO.aMW().getId(), 0L);
                        }
                        if (this.ezO != null && this.ezO.qq() != null) {
                            lVar4.pageNumber = this.ezO.qq().qk();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aMY.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.ezN) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aMY.add(position2, lVar4);
                        TiebaStatic.eventStat(this.eDo.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bre().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sf(i);
        com.baidu.tieba.recapp.report.b.bgy().a(c);
        if (lVar != null && lVar.bre() != null) {
            lVar.bre().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bre() != null && lVar.bre().goods != null && lVar.bre().goods.goods_style != 1001 && lVar.bre().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aMU;
        if (lVar != null && this.ezO != null && lVar.bre() != null) {
            lVar.bre().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.ezO.qq() != null) {
                lVar.bre().advertAppContext.pn = this.ezO.qq().qk();
            }
            lVar.bre().advertAppContext.Tt = "PB";
            if (this.ezO.aMU() != null && (aMU = this.ezO.aMU()) != null) {
                lVar.bre().advertAppContext.fid = aMU.getId();
                lVar.bre().advertAppContext.Tv = aMU.getFirst_class();
                lVar.bre().advertAppContext.Tw = aMU.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bre().advertAppContext.Tx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bre().advertAppContext.extensionInfo = lVar.bre().ext_info;
            lVar.bre().advertAppContext.Ty = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eDF.setFromCDN(z);
        this.eDp.setFromCDN(z);
        if (this.eDz != null && (this.eDz instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eDz).setIsFromCDN(z);
        }
        if (this.eDA != null && (this.eDA instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eDA).setIsFromCDN(z);
        }
        if (this.czE != null && (this.czE instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.czE).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eDK.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void iD(boolean z) {
        this.ezM = z;
    }

    public void iE(boolean z) {
        this.ezN = z;
    }

    public void iF(boolean z) {
        this.eDR = z;
    }

    public void C(View.OnClickListener onClickListener) {
        this.ezR = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.f fVar) {
        this.aSj = fVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aSk = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auu = onLongClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.ezS = onClickListener;
    }

    public void pg(int i) {
        if (this.eDq != null) {
            this.eDq.pg(i);
        }
        switch (i) {
            case 1:
                if (this.eDE != null) {
                    this.eDE.pause();
                }
                if (this.eDp != null) {
                    this.eDp.pause();
                }
                if (this.eDB != null && (this.eDB instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eDB).release();
                    return;
                }
                return;
            case 2:
                if (this.eDE != null) {
                    this.eDE.resume();
                }
                if (this.eDp != null) {
                    this.eDp.resume();
                }
                if (this.eDB != null && (this.eDB instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eDB).resume();
                    return;
                }
                return;
            case 3:
                if (this.eDE != null) {
                    this.eDE.release();
                }
                if (this.eDp != null) {
                    this.eDp.release();
                }
                if (this.eDB != null && (this.eDB instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eDB).release();
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
                    if (!TextUtils.isEmpty(postData.sj())) {
                        com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
                        afVar.cw(postData.sj());
                        list.set(i, afVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.eDU);
        if (this.eDr != null) {
            this.eDr.onDestory();
        }
    }

    public void iQ(boolean z) {
        this.eDQ = z;
    }

    public void iR(boolean z) {
        this.eDN = z;
    }

    public void iS(boolean z) {
        this.eDO = z;
    }

    public void iT(boolean z) {
        this.eDM = z;
    }

    public void iU(boolean z) {
        this.eDP = z;
    }

    public aj aPg() {
        return this.eDq;
    }
}
