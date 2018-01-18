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
    private List<com.baidu.adp.widget.ListView.a> dGH;
    private com.baidu.adp.widget.ListView.a dOf;
    private com.baidu.adp.widget.ListView.a dOg;
    private int fEU;
    private com.baidu.tieba.pb.data.f fEX;
    private ak fJA;
    private k fJB;
    private com.baidu.tieba.pb.video.a fJC;
    private ag fJD;
    private ah fJE;
    private com.baidu.tieba.pb.pb.a.b fJF;
    private com.baidu.tieba.pb.pb.a.e fJG;
    private v fJH;
    private ae fJI;
    private com.baidu.tieba.pb.pb.a.d fJJ;
    private boolean fJN;
    private boolean fJO;
    private Runnable fJR;
    private int fJT;
    private PbActivity fJw;
    private q fJx;
    private ao fJy;
    private ak fJz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fJK = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fEV = true;
    private boolean fEW = true;
    private boolean fJL = false;
    private boolean fJM = false;
    private boolean fJP = false;
    private String mHostId = null;
    private View.OnClickListener fFa = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bJF = null;
    private com.baidu.tieba.pb.a.c bJG = null;
    private View.OnLongClickListener bjX = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fJQ = new ArrayList();
    private int fJS = -1;
    private CustomMessageListener dGQ = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bvh = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bvh();
                Iterator it = bvh.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).ao(h.this.fJw);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            h.this.fJK.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            h.this.fJF = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bvh);
                h.this.fJQ.clear();
                h.this.fJQ.addAll(arrayList);
                if (h.this.mListView != null) {
                    h.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener dCl = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.h.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && h.this.fEX != null && !com.baidu.adp.base.i.ai(h.this.fJw.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dGR = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.h.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.E(h.this.dGH)) {
                h.this.awh();
                h.this.a(h.this.fEX, false);
            }
        }
    };

    public h(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fEU = 0;
        this.width = -1;
        this.fJT = 0;
        this.fEU = com.baidu.adp.lib.util.l.ao(pbActivity.getPageContext().getPageActivity());
        this.width = this.fEU;
        this.fJw = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.dCl);
        this.fJT = com.baidu.adp.lib.util.l.aq(this.fJw) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fJG = new com.baidu.tieba.pb.pb.a.e(pbActivity, PostData.gYi);
        this.fJx = new q(pbActivity, PostData.gYf);
        this.fJx.a(pbActivity);
        this.fJy = new ao(pbActivity, com.baidu.tieba.pb.data.l.fEh);
        this.fJz = new ak(pbActivity, com.baidu.tieba.pb.data.j.fEa);
        this.fJA = new ak(pbActivity, com.baidu.tieba.pb.data.j.fEb);
        this.fJB = new k(pbActivity, PostData.gYg);
        this.fJB.a(pbActivity);
        this.dOf = com.baidu.tieba.recapp.q.bmR().a(pbActivity, AdvertAppInfo.aIX);
        this.dOg = com.baidu.tieba.recapp.q.bmR().a(pbActivity, AdvertAppInfo.aJb);
        this.fJH = new v(pbActivity, com.baidu.tieba.pb.data.a.fDc);
        this.fJI = new ae(pbActivity, com.baidu.tieba.pb.data.i.fDZ);
        this.fJD = new ag(pbActivity, ad.fOB);
        this.fJE = new ah(pbActivity, com.baidu.tbadk.core.data.ao.aMh);
        this.fJJ = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gYm);
        this.fJC = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fXL);
        this.fJC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.fEX.aYR() != null) {
                    pbActivity.bah().bdl().aZJ();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fJx);
        this.mAdapters.add(this.fJy);
        this.mAdapters.add(this.fJB);
        this.mAdapters.add(this.fJz);
        this.mAdapters.add(this.fJA);
        this.mAdapters.add(this.fJG);
        this.mAdapters.add(this.dOf);
        this.mAdapters.add(this.dOg);
        this.mAdapters.add(this.fJH);
        this.mAdapters.add(this.fJI);
        this.mAdapters.add(this.fJD);
        this.mAdapters.add(this.fJE);
        this.mAdapters.add(this.fJC);
        this.mAdapters.add(this.fJJ);
        this.dGQ.setPriority(1);
        this.dGQ.setSelfListener(true);
        pbActivity.registerListener(this.dGQ);
        awg();
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
        com.baidu.adp.widget.ListView.i bbg;
        PostData postData3;
        if (fVar != null) {
            if (this.fEX != fVar) {
                z2 = (fVar == null || fVar.aYC()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.fEX = fVar;
            if (z2) {
                bbk();
                if (fVar != null) {
                    fVar.jB(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fEX != null && this.fEX.aYI() != null && this.fEX.aYI().size() > 0) {
                this.postList.addAll(this.fEX.aYI());
            }
            if (fVar != null && fVar.aYG() != null && fVar.aYG().yS() != null) {
                this.mHostId = fVar.aYG().yS().getUserId();
            }
            if (this.fJx != null) {
                this.fJG.b(fVar);
                this.fJG.setFromCDN(this.mIsFromCDN);
                this.fJG.setHostId(this.mHostId);
                this.fJG.sB(this.fEU);
                this.fJG.jD(this.fEV);
                this.fJG.jE(this.fEW);
                this.fJG.l(this.mCommonClickListener);
                this.fJG.E(this.fFa);
                this.fJG.setOnImageClickListener(this.bJF);
                this.fJG.setOnLongClickListener(this.bjX);
                this.fJx.b(fVar);
                this.fJx.setFromCDN(this.mIsFromCDN);
                this.fJx.sB(this.fEU);
                this.fJx.jD(this.fEV);
                this.fJx.l(this.mCommonClickListener);
                this.fJx.E(this.fFa);
                this.fJx.setOnImageClickListener(this.bJF);
                this.fJx.setOnLongClickListener(this.bjX);
                this.fJx.setTbGestureDetector(this.bJG);
                this.fJB.b(fVar);
                this.fJB.setFromCDN(this.mIsFromCDN);
                this.fJB.setHostId(this.mHostId);
                this.fJB.jD(this.fEV);
                this.fJB.l(this.mCommonClickListener);
                this.fJB.E(this.fFa);
                this.fJB.setOnImageClickListener(this.bJF);
                this.fJB.setOnLongClickListener(this.bjX);
                this.fJB.setTbGestureDetector(this.bJG);
                this.fJy.setOnClickListener(this.mCommonClickListener);
                this.fJy.setTbGestureDetector(this.bJG);
                this.fJJ.setOnClickListener(this.mCommonClickListener);
                if (this.dOg != null && (this.dOg instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.dOg).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fJK.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.sB(this.fEU);
                        next.jD(this.fEV);
                        next.jE(this.fEW);
                        next.jF(this.fJP);
                        next.l(this.mCommonClickListener);
                        next.E(this.fFa);
                        next.setOnImageClickListener(this.bJF);
                        next.setOnLongClickListener(this.bjX);
                    }
                }
                this.fJz.l(this.mCommonClickListener);
                this.fJA.l(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>(fVar.aYI());
                Iterator<com.baidu.adp.widget.ListView.i> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bvH() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.fEW && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aZd() && postData.bvK() != null) {
                        postData.c(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aYN() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aYN = fVar.aYN();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aYN());
                    if (!this.fEW && fVar.aZd() && aYN.bvK() != null) {
                        aYN.c(null);
                    }
                    postData2 = aYN;
                    z4 = true;
                }
                cO(arrayList);
                if (this.fJw.baF()) {
                    if (fVar.aYI().size() > 0 && (postData3 = fVar.aYI().get(0)) != null && postData3.bvH() == 1 && !com.baidu.tbadk.core.util.v.E(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fEX, arrayList, this.fEW);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.fEX.aYJ());
                    }
                }
                int b = b(this.fEX, arrayList, this.fEW);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.fEX.aYK());
                }
                if (arrayList.size() == 0 && this.fJw.baF()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                com.baidu.tieba.tbadkCore.q.s(arrayList, 1);
                int c = c(fVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.fEa);
                    if (fVar != null && fVar.aYG() != null) {
                        jVar.fEc = fVar.aYG().yK();
                    }
                    jVar.btU = !this.fEW;
                    jVar.fEe = this.fJw.baS();
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
                        ((PostData) iVar).gYR = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d < 0 || fVar.aZc() == null) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aZc());
                    fVar.aZc().jC((b(arrayList, d) || z5) ? false : true);
                    z6 = true;
                    z5 = true;
                }
                if (z4 && (bbg = bbg()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, bbg);
                }
                this.fJx.jV(!z5);
                boolean z7 = (this.fJw.aZO() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.fJw.aZO().getPostId())) ? false : true;
                if (this.fJL && !z7) {
                    arrayList.remove(postData2);
                    this.fJL = false;
                }
                if (z6 && (com.baidu.tbadk.core.util.v.f(arrayList, 0) instanceof com.baidu.tieba.pb.data.l)) {
                    jU(false);
                } else {
                    jU(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z7 && !z) {
                    if ((this.fJN || this.fJM) && b2 != -1 && !com.baidu.tbadk.core.util.v.E(g) && !this.fJO) {
                        this.fJR = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.4
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.mListView.setSelectionFromTop(h.this.mListView.getHeaderViewsCount() + g.size(), 0 - h.this.fJT);
                                h.this.fJO = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.nr().post(this.fJR);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.i bbg() {
        PbModel aZO = this.fJw.aZO();
        if (aZO == null) {
            return null;
        }
        String bcq = aZO.bcq();
        if (TextUtils.isEmpty(bcq)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.sw(bcq);
        b(lVar);
        return lVar;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, int i) {
        if (this.fJw.aYN() == null || this.fJw.bah() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (this.fJM || fVar == null || com.baidu.tbadk.core.util.v.E(fVar.aYI()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aZd() && this.fEW) ? 0 : -1;
        } else if (this.fJw.aZO() == null || !this.fJw.aZO().getIsFromMark()) {
            if (this.fJw.bah() == null || !this.fJw.bah().getIsInterviewLive()) {
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
                        if (postData.bvH() == 1 && postData.gYO == 0) {
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
                return fVar.aZd() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.E(fVar.aYI()) || com.baidu.tbadk.core.util.v.E(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.f(fVar.aYI(), 0)) == null) {
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
                if (postData.bvH() == 1 && postData.gYO == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.v.E(fVar.aYI()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aZd()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.i iVar = arrayList.get(i);
            if ((iVar instanceof PostData) && ((PostData) iVar).bvH() == 1) {
                return i + 1;
            }
        }
        return !fVar.aZd() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.i> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aYR() == null || com.baidu.tbadk.core.util.v.E(fVar.aYR().fEx)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aYR().fEx;
        if (com.baidu.tbadk.core.util.v.E(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gYQ = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.D(fVar.aYR().fEy) > 2) {
            com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar instanceof PostData) {
                ((PostData) iVar).gYQ = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar2 instanceof PostData) {
                ((PostData) iVar2).gYQ = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.fEb);
        jVar.fEd = fVar.aYR().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void awg() {
        if (this.fJw != null && !awh()) {
            this.fJw.registerListener(this.dGR);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean awh() {
        if (this.fJw == null) {
            return false;
        }
        this.dGH = new ArrayList();
        ArrayList<BdUniqueId> buR = com.baidu.tieba.tbadkCore.q.buR();
        if (buR == null || buR.size() <= 0) {
            return false;
        }
        int size = buR.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aPp().a(this.fJw.getPageContext(), buR.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dGH.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.E(this.dGH)) {
            this.mListView.addAdapters(this.dGH);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (fVar == null || fVar.aYI() == null || fVar.aYJ() == null || fVar.aYI().size() == 0 || fVar.aYG() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aYJ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aYI().get(0) == null || fVar.aYI().get(0).bvH() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.xY() == null || fVar.xY().xS() != fVar.xY().xP()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (fVar == null || fVar.aYI() == null || fVar.aYK() == null || fVar.aYI().size() == 0 || fVar.aYG() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aYK().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aYI().get(0) == null || fVar.aYI().get(0).bvH() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.xY() == null || fVar.xY().xS() != fVar.xY().xP()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.i getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bbh() {
        return this.postList;
    }

    public BdUniqueId sI(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fJF == null || !this.fJF.aZH()) {
            this.fJS = bbi();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bbi() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.mListView.getData().get(i2);
                if (iVar == null || iVar.getType() != com.baidu.tieba.pb.data.j.fEa) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bbj() {
        return this.fJS;
    }

    private void bbk() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fEX != null) {
            ArrayList<PostData> aYI = this.fEX.aYI();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aYV = this.fEX.aYV();
            if (aYV != null) {
                int size = aYV.size();
                if (aYI != null && aYI.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aYV.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aYV.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dOI = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aYV.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bvv() != null) {
                            int wY = next3.bvv().wY();
                            if (wY != 0) {
                                a(next3, wY);
                                if (wY != 28 && wY != 31) {
                                    if (next3.bvv().goods != null) {
                                        next3.bvv().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.v.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bvv().apk_name)) {
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
                        if (this.fEX.aYE() != null) {
                            lVar4.forumId = this.fEX.aYE().getId();
                        }
                        if (this.fEX.aYG() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fEX.aYG().getId(), 0L);
                        }
                        if (this.fEX != null && this.fEX.xY() != null) {
                            lVar4.pageNumber = this.fEX.xY().xS();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aYI.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fEW) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aYI.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fJw.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bvv().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.uu(i);
        com.baidu.tieba.recapp.report.b.bnB().a(c);
        if (lVar != null && lVar.bvv() != null) {
            lVar.bvv().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bvv() != null && lVar.bvv().goods != null && lVar.bvv().goods.goods_style != 1001 && lVar.bvv().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aYE;
        if (lVar != null && this.fEX != null && lVar.bvv() != null) {
            lVar.bvv().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fEX.xY() != null) {
                lVar.bvv().advertAppContext.pn = this.fEX.xY().xS();
            }
            lVar.bvv().advertAppContext.aIM = "PB";
            if (this.fEX.aYE() != null && (aYE = this.fEX.aYE()) != null) {
                lVar.bvv().advertAppContext.fid = aYE.getId();
                lVar.bvv().advertAppContext.aIO = aYE.getFirst_class();
                lVar.bvv().advertAppContext.aIP = aYE.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bvv().advertAppContext.aIQ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bvv().advertAppContext.extensionInfo = lVar.bvv().ext_info;
            lVar.bvv().advertAppContext.aIR = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fJG.setFromCDN(z);
        this.fJx.setFromCDN(z);
        if (this.dOg != null && (this.dOg instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.dOg).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fJK.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bbl() {
        return this.fEV;
    }

    public void jD(boolean z) {
        this.fEV = z;
    }

    public void jE(boolean z) {
        this.fEW = z;
    }

    public void jF(boolean z) {
        this.fJP = z;
    }

    public void E(View.OnClickListener onClickListener) {
        this.fFa = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJF = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjX = onLongClickListener;
    }

    public void r(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void sJ(int i) {
        if (this.fJy != null) {
            this.fJy.sJ(i);
        }
        switch (i) {
            case 1:
                if (this.fJF != null) {
                    this.fJF.pause();
                }
                if (this.fJx != null) {
                    this.fJx.pause();
                    return;
                }
                return;
            case 2:
                if (this.fJF != null) {
                    this.fJF.resume();
                }
                if (this.fJx != null) {
                    this.fJx.resume();
                    return;
                }
                return;
            case 3:
                if (this.fJF != null) {
                    this.fJF.release();
                }
                if (this.fJx != null) {
                    this.fJx.release();
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
                    if (!TextUtils.isEmpty(postData.zL())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.cJ(postData.zL());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.fJR);
        if (this.fJz != null) {
            this.fJz.onDestory();
        }
    }

    public void jQ(boolean z) {
        this.fJM = z;
    }

    public void jR(boolean z) {
        this.fJN = z;
    }

    public void jS(boolean z) {
        this.fJL = z;
    }

    public void jT(boolean z) {
        this.fJO = z;
    }

    public ao bbm() {
        return this.fJy;
    }

    public void jU(boolean z) {
        if (this.fJy != null) {
            this.fJy.fPN = z;
        }
    }
}
