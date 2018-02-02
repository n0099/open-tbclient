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
/* loaded from: classes2.dex */
public class h {
    private List<com.baidu.adp.widget.ListView.a> dHc;
    private com.baidu.adp.widget.ListView.a dOA;
    private com.baidu.adp.widget.ListView.a dOB;
    private int fFp;
    private com.baidu.tieba.pb.data.f fFs;
    private PbActivity fJR;
    private q fJS;
    private ao fJT;
    private ak fJU;
    private ak fJV;
    private k fJW;
    private com.baidu.tieba.pb.video.a fJX;
    private ag fJY;
    private ah fJZ;
    private com.baidu.tieba.pb.pb.a.b fKa;
    private com.baidu.tieba.pb.pb.a.e fKb;
    private v fKc;
    private ae fKd;
    private com.baidu.tieba.pb.pb.a.d fKe;
    private boolean fKi;
    private boolean fKj;
    private Runnable fKm;
    private int fKo;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fKf = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fFq = true;
    private boolean fFr = true;
    private boolean fKg = false;
    private boolean fKh = false;
    private boolean fKk = false;
    private String mHostId = null;
    private View.OnClickListener fFv = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bJN = null;
    private com.baidu.tieba.pb.a.c bJO = null;
    private View.OnLongClickListener bkf = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fKl = new ArrayList();
    private int fKn = -1;
    private CustomMessageListener dHl = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bvj = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bvj();
                Iterator it = bvj.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).ap(h.this.fJR);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            h.this.fKf.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            h.this.fKa = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bvj);
                h.this.fKl.clear();
                h.this.fKl.addAll(arrayList);
                if (h.this.mListView != null) {
                    h.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener dCG = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.h.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && h.this.fFs != null && !com.baidu.adp.base.i.ai(h.this.fJR.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dHm = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.h.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.E(h.this.dHc)) {
                h.this.awm();
                h.this.a(h.this.fFs, false);
            }
        }
    };

    public h(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fFp = 0;
        this.width = -1;
        this.fKo = 0;
        this.fFp = com.baidu.adp.lib.util.l.ao(pbActivity.getPageContext().getPageActivity());
        this.width = this.fFp;
        this.fJR = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.dCG);
        this.fKo = com.baidu.adp.lib.util.l.aq(this.fJR) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fKb = new com.baidu.tieba.pb.pb.a.e(pbActivity, PostData.gYC);
        this.fJS = new q(pbActivity, PostData.gYz);
        this.fJS.a(pbActivity);
        this.fJT = new ao(pbActivity, com.baidu.tieba.pb.data.l.fEC);
        this.fJU = new ak(pbActivity, com.baidu.tieba.pb.data.j.fEv);
        this.fJV = new ak(pbActivity, com.baidu.tieba.pb.data.j.fEw);
        this.fJW = new k(pbActivity, PostData.gYA);
        this.fJW.a(pbActivity);
        this.dOA = com.baidu.tieba.recapp.q.bmS().a(pbActivity, AdvertAppInfo.aJa);
        this.dOB = com.baidu.tieba.recapp.q.bmS().a(pbActivity, AdvertAppInfo.aJe);
        this.fKc = new v(pbActivity, com.baidu.tieba.pb.data.a.fDx);
        this.fKd = new ae(pbActivity, com.baidu.tieba.pb.data.i.fEu);
        this.fJY = new ag(pbActivity, ad.fOW);
        this.fJZ = new ah(pbActivity, com.baidu.tbadk.core.data.ao.aMk);
        this.fKe = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gYG);
        this.fJX = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fYg);
        this.fJX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.fFs.aYW() != null) {
                    pbActivity.bam().bdq().aZO();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fJS);
        this.mAdapters.add(this.fJT);
        this.mAdapters.add(this.fJW);
        this.mAdapters.add(this.fJU);
        this.mAdapters.add(this.fJV);
        this.mAdapters.add(this.fKb);
        this.mAdapters.add(this.dOA);
        this.mAdapters.add(this.dOB);
        this.mAdapters.add(this.fKc);
        this.mAdapters.add(this.fKd);
        this.mAdapters.add(this.fJY);
        this.mAdapters.add(this.fJZ);
        this.mAdapters.add(this.fJX);
        this.mAdapters.add(this.fKe);
        this.dHl.setPriority(1);
        this.dHl.setSelfListener(true);
        pbActivity.registerListener(this.dHl);
        awl();
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
        boolean z6;
        com.baidu.adp.widget.ListView.i bbl;
        PostData postData3;
        if (fVar != null) {
            if (this.fFs != fVar) {
                z2 = (fVar == null || fVar.aYH()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.fFs = fVar;
            if (z2) {
                bbp();
                if (fVar != null) {
                    fVar.jE(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fFs != null && this.fFs.aYN() != null && this.fFs.aYN().size() > 0) {
                this.postList.addAll(this.fFs.aYN());
            }
            if (fVar != null && fVar.aYL() != null && fVar.aYL().yT() != null) {
                this.mHostId = fVar.aYL().yT().getUserId();
            }
            if (this.fJS != null) {
                this.fKb.b(fVar);
                this.fKb.setFromCDN(this.mIsFromCDN);
                this.fKb.setHostId(this.mHostId);
                this.fKb.sB(this.fFp);
                this.fKb.jG(this.fFq);
                this.fKb.jH(this.fFr);
                this.fKb.l(this.mCommonClickListener);
                this.fKb.E(this.fFv);
                this.fKb.setOnImageClickListener(this.bJN);
                this.fKb.setOnLongClickListener(this.bkf);
                this.fJS.b(fVar);
                this.fJS.setFromCDN(this.mIsFromCDN);
                this.fJS.sB(this.fFp);
                this.fJS.jG(this.fFq);
                this.fJS.l(this.mCommonClickListener);
                this.fJS.E(this.fFv);
                this.fJS.setOnImageClickListener(this.bJN);
                this.fJS.setOnLongClickListener(this.bkf);
                this.fJS.setTbGestureDetector(this.bJO);
                this.fJW.b(fVar);
                this.fJW.setFromCDN(this.mIsFromCDN);
                this.fJW.setHostId(this.mHostId);
                this.fJW.jG(this.fFq);
                this.fJW.l(this.mCommonClickListener);
                this.fJW.E(this.fFv);
                this.fJW.setOnImageClickListener(this.bJN);
                this.fJW.setOnLongClickListener(this.bkf);
                this.fJW.setTbGestureDetector(this.bJO);
                this.fJT.setOnClickListener(this.mCommonClickListener);
                this.fJT.setTbGestureDetector(this.bJO);
                this.fKe.setOnClickListener(this.mCommonClickListener);
                if (this.dOB != null && (this.dOB instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.dOB).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fKf.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.sB(this.fFp);
                        next.jG(this.fFq);
                        next.jH(this.fFr);
                        next.jI(this.fKk);
                        next.l(this.mCommonClickListener);
                        next.E(this.fFv);
                        next.setOnImageClickListener(this.bJN);
                        next.setOnLongClickListener(this.bkf);
                    }
                }
                this.fJU.l(this.mCommonClickListener);
                this.fJV.l(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>(fVar.aYN());
                Iterator<com.baidu.adp.widget.ListView.i> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bvJ() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.fFr && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aZi() && postData.bvM() != null) {
                        postData.c(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aYS() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aYS = fVar.aYS();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aYS());
                    if (!this.fFr && fVar.aZi() && aYS.bvM() != null) {
                        aYS.c(null);
                    }
                    postData2 = aYS;
                    z4 = true;
                }
                cO(arrayList);
                if (this.fJR.baK()) {
                    if (fVar.aYN().size() > 0 && (postData3 = fVar.aYN().get(0)) != null && postData3.bvJ() == 1 && !com.baidu.tbadk.core.util.v.E(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fFs, arrayList, this.fFr);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.fFs.aYO());
                    }
                }
                int b = b(this.fFs, arrayList, this.fFr);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.fFs.aYP());
                }
                if (arrayList.size() == 0 && this.fJR.baK()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                com.baidu.tieba.tbadkCore.q.s(arrayList, 1);
                int c = c(fVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.fEv);
                    if (fVar != null && fVar.aYL() != null) {
                        jVar.fEx = fVar.aYL().yL();
                    }
                    jVar.bud = !this.fFr;
                    jVar.fEz = this.fJR.baX();
                    com.baidu.tbadk.core.util.v.a(arrayList, c, jVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(fVar, arrayList);
                final List<com.baidu.adp.widget.ListView.i> g = g(fVar);
                if (!com.baidu.tbadk.core.util.v.E(g) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, b2);
                    if (iVar instanceof PostData) {
                        ((PostData) iVar).gZl = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d < 0 || fVar.aZh() == null) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aZh());
                    fVar.aZh().jF((b(arrayList, d) || z5) ? false : true);
                    z6 = true;
                    z5 = true;
                }
                if (z4 && (bbl = bbl()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, bbl);
                }
                this.fJS.jY(!z5);
                boolean z7 = (this.fJR.aZT() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.fJR.aZT().getPostId())) ? false : true;
                if (this.fKg && !z7) {
                    arrayList.remove(postData2);
                    this.fKg = false;
                }
                if (z6 && (com.baidu.tbadk.core.util.v.f(arrayList, 0) instanceof com.baidu.tieba.pb.data.l)) {
                    jX(false);
                } else {
                    jX(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z7 && !z) {
                    if ((this.fKi || this.fKh) && b2 != -1 && !com.baidu.tbadk.core.util.v.E(g) && !this.fKj) {
                        this.fKm = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.4
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.mListView.setSelectionFromTop(h.this.mListView.getHeaderViewsCount() + g.size(), 0 - h.this.fKo);
                                h.this.fKj = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.ns().post(this.fKm);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.i bbl() {
        PbModel aZT = this.fJR.aZT();
        if (aZT == null) {
            return null;
        }
        String bcv = aZT.bcv();
        if (TextUtils.isEmpty(bcv)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.sE(bcv);
        b(lVar);
        return lVar;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, int i) {
        if (this.fJR.aYS() == null || this.fJR.bam() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (this.fKh || fVar == null || com.baidu.tbadk.core.util.v.E(fVar.aYN()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aZi() && this.fFr) ? 0 : -1;
        } else if (this.fJR.aZT() == null || !this.fJR.aZT().getIsFromMark()) {
            if (this.fJR.bam() == null || !this.fJR.bam().getIsInterviewLive()) {
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
                        if (postData.bvJ() == 1 && postData.gZi == 0) {
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
                return fVar.aZi() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.E(fVar.aYN()) || com.baidu.tbadk.core.util.v.E(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.f(fVar.aYN(), 0)) == null) {
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
                if (postData.bvJ() == 1 && postData.gZi == 0) {
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

    private int d(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (fVar == null || com.baidu.tbadk.core.util.v.E(fVar.aYN()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aZi()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.i iVar = arrayList.get(i);
            if ((iVar instanceof PostData) && ((PostData) iVar).bvJ() == 1) {
                return i + 1;
            }
        }
        return !fVar.aZi() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.i> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aYW() == null || com.baidu.tbadk.core.util.v.E(fVar.aYW().fES)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aYW().fES;
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gZk = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.D(fVar.aYW().fET) > 2) {
            com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar instanceof PostData) {
                ((PostData) iVar).gZk = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar2 instanceof PostData) {
                ((PostData) iVar2).gZk = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.fEw);
        jVar.fEy = fVar.aYW().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void awl() {
        if (this.fJR != null && !awm()) {
            this.fJR.registerListener(this.dHm);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean awm() {
        if (this.fJR == null) {
            return false;
        }
        this.dHc = new ArrayList();
        ArrayList<BdUniqueId> buT = com.baidu.tieba.tbadkCore.q.buT();
        if (buT == null || buT.size() <= 0) {
            return false;
        }
        int size = buT.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aPu().a(this.fJR.getPageContext(), buT.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dHc.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.E(this.dHc)) {
            this.mListView.addAdapters(this.dHc);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (fVar == null || fVar.aYN() == null || fVar.aYO() == null || fVar.aYN().size() == 0 || fVar.aYL() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aYO().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aYN().get(0) == null || fVar.aYN().get(0).bvJ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.xZ() == null || fVar.xZ().xT() != fVar.xZ().xQ()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (fVar == null || fVar.aYN() == null || fVar.aYP() == null || fVar.aYN().size() == 0 || fVar.aYL() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aYP().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aYN().get(0) == null || fVar.aYN().get(0).bvJ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.xZ() == null || fVar.xZ().xT() != fVar.xZ().xQ()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.i getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bbm() {
        return this.postList;
    }

    public BdUniqueId sI(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fKa == null || !this.fKa.aZM()) {
            this.fKn = bbn();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bbn() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.mListView.getData().get(i2);
                if (iVar == null || iVar.getType() != com.baidu.tieba.pb.data.j.fEv) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bbo() {
        return this.fKn;
    }

    private void bbp() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fFs != null) {
            ArrayList<PostData> aYN = this.fFs.aYN();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aZa = this.fFs.aZa();
            if (aZa != null) {
                int size = aZa.size();
                if (aYN != null && aYN.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aZa.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aZa.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dPd = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aZa.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bvx() != null) {
                            int wZ = next3.bvx().wZ();
                            if (wZ != 0) {
                                a(next3, wZ);
                                if (wZ != 28 && wZ != 31) {
                                    if (next3.bvx().goods != null) {
                                        next3.bvx().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.v.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bvx().apk_name)) {
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
                        if (this.fFs.aYJ() != null) {
                            lVar4.forumId = this.fFs.aYJ().getId();
                        }
                        if (this.fFs.aYL() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fFs.aYL().getId(), 0L);
                        }
                        if (this.fFs != null && this.fFs.xZ() != null) {
                            lVar4.pageNumber = this.fFs.xZ().xT();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aYN.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fFr) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aYN.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fJR.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bvx().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.uu(i);
        com.baidu.tieba.recapp.report.b.bnC().a(c);
        if (lVar != null && lVar.bvx() != null) {
            lVar.bvx().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bvx() != null && lVar.bvx().goods != null && lVar.bvx().goods.goods_style != 1001 && lVar.bvx().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aYJ;
        if (lVar != null && this.fFs != null && lVar.bvx() != null) {
            lVar.bvx().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fFs.xZ() != null) {
                lVar.bvx().advertAppContext.pn = this.fFs.xZ().xT();
            }
            lVar.bvx().advertAppContext.aIP = "PB";
            if (this.fFs.aYJ() != null && (aYJ = this.fFs.aYJ()) != null) {
                lVar.bvx().advertAppContext.fid = aYJ.getId();
                lVar.bvx().advertAppContext.aIR = aYJ.getFirst_class();
                lVar.bvx().advertAppContext.aIS = aYJ.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bvx().advertAppContext.aIT = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bvx().advertAppContext.extensionInfo = lVar.bvx().ext_info;
            lVar.bvx().advertAppContext.aIU = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fKb.setFromCDN(z);
        this.fJS.setFromCDN(z);
        if (this.dOB != null && (this.dOB instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.dOB).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fKf.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bbq() {
        return this.fFq;
    }

    public void jG(boolean z) {
        this.fFq = z;
    }

    public void jH(boolean z) {
        this.fFr = z;
    }

    public void jI(boolean z) {
        this.fKk = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fFv = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJN = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJO = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bkf = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void sJ(int i) {
        if (this.fJT != null) {
            this.fJT.sJ(i);
        }
        switch (i) {
            case 1:
                if (this.fKa != null) {
                    this.fKa.pause();
                }
                if (this.fJS != null) {
                    this.fJS.pause();
                    return;
                }
                return;
            case 2:
                if (this.fKa != null) {
                    this.fKa.resume();
                }
                if (this.fJS != null) {
                    this.fJS.resume();
                    return;
                }
                return;
            case 3:
                if (this.fKa != null) {
                    this.fKa.release();
                }
                if (this.fJS != null) {
                    this.fJS.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cO(List<com.baidu.adp.widget.ListView.i> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.zM())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.cJ(postData.zM());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.fKm);
        if (this.fJU != null) {
            this.fJU.onDestory();
        }
    }

    public void jT(boolean z) {
        this.fKh = z;
    }

    public void jU(boolean z) {
        this.fKi = z;
    }

    public void jV(boolean z) {
        this.fKg = z;
    }

    public void jW(boolean z) {
        this.fKj = z;
    }

    public ao bbr() {
        return this.fJT;
    }

    public void jX(boolean z) {
        if (this.fJT != null) {
            this.fJT.fQi = z;
        }
    }
}
