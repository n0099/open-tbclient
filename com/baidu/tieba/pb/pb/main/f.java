package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
    private List<com.baidu.adp.widget.ListView.a> dqK;
    private com.baidu.adp.widget.ListView.a dzo;
    private com.baidu.adp.widget.ListView.a dzp;
    private boolean fxB;
    private boolean fxC;
    private int fxE;
    private Runnable fxH;
    private int fxJ;
    private PbActivity fxh;
    private o fxi;
    private ap fxj;
    private ak fxk;
    private ak fxl;
    private i fxm;
    private com.baidu.tieba.pb.video.a fxn;
    private ag fxo;
    private ah fxp;
    private com.baidu.tieba.pb.pb.a.b fxq;
    private v fxr;
    private ae fxs;
    private com.baidu.tieba.pb.pb.a.d fxt;
    private ao fxu;
    private com.baidu.tieba.pb.data.d fxw;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fxv = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fxx = true;
    private boolean fxy = true;
    private boolean fxz = false;
    private boolean fxA = false;
    private boolean fxD = false;
    private String mHostId = null;
    private View.OnClickListener fxF = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bfR = null;
    private com.baidu.tieba.pb.a.c bfS = null;
    private View.OnLongClickListener aHk = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fxG = new ArrayList();
    private int fxI = -1;
    private CustomMessageListener dpU = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bxc = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bxc();
                Iterator it = bxc.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ap(f.this.fxh);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fxv.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fxq = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bxc);
                f.this.fxG.clear();
                f.this.fxG.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener aDX = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fxw != null && !com.baidu.adp.base.i.ab(f.this.fxh.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dqT = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.w.A(f.this.dqK)) {
                f.this.aws();
                f.this.a(f.this.fxw, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fxE = 0;
        this.width = -1;
        this.fxJ = 0;
        this.fxE = com.baidu.adp.lib.util.l.ah(pbActivity.getPageContext().getPageActivity());
        this.width = this.fxE;
        this.fxh = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aDX);
        this.fxJ = com.baidu.adp.lib.util.l.aj(this.fxh) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fxi = new o(pbActivity, PostData.gMV);
        this.fxi.a(pbActivity);
        this.fxj = new ap(pbActivity, com.baidu.tieba.pb.data.j.ftc);
        this.fxk = new ak(pbActivity, com.baidu.tieba.pb.data.h.fsV);
        this.fxl = new ak(pbActivity, com.baidu.tieba.pb.data.h.fsW);
        this.fxm = new i(pbActivity, PostData.gMW);
        this.fxm.a(pbActivity);
        this.dzo = com.baidu.tieba.recapp.r.boJ().a(pbActivity, AdvertAppInfo.adO);
        this.dzp = com.baidu.tieba.recapp.r.boJ().a(pbActivity, AdvertAppInfo.adS);
        this.fxr = new v(pbActivity, com.baidu.tieba.pb.data.a.fsd);
        this.fxs = new ae(pbActivity, com.baidu.tieba.pb.data.g.fsU);
        this.fxo = new ag(pbActivity, ad.fCH);
        this.fxp = new ah(pbActivity, com.baidu.tbadk.core.data.ap.aho);
        this.fxt = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gNa);
        this.fxu = new ao(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fxn = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fMb);
        this.fxn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fxw.bbg() != null) {
                    pbActivity.bcr().bfu().bbV();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fxi);
        this.mAdapters.add(this.fxj);
        this.mAdapters.add(this.fxm);
        this.mAdapters.add(this.fxk);
        this.mAdapters.add(this.fxl);
        this.mAdapters.add(this.dzo);
        this.mAdapters.add(this.dzp);
        this.mAdapters.add(this.fxr);
        this.mAdapters.add(this.fxs);
        this.mAdapters.add(this.fxo);
        this.mAdapters.add(this.fxp);
        this.mAdapters.add(this.fxn);
        this.mAdapters.add(this.fxt);
        this.mAdapters.add(this.fxu);
        this.dpU.setPriority(1);
        this.dpU.setSelfListener(true);
        pbActivity.registerListener(this.dpU);
        awr();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(2004015);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        boolean z2;
        boolean z3;
        com.baidu.adp.widget.ListView.h bdq;
        PostData postData2;
        if (dVar != null) {
            boolean z4 = false;
            if (this.fxw != dVar) {
                z4 = true;
                if ((dVar != null && !dVar.baS()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z4 = false;
                }
            }
            this.fxw = dVar;
            if (z4) {
                bdv();
                if (dVar != null) {
                    dVar.jE(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fxw != null && this.fxw.baX() != null && this.fxw.baX().size() > 0) {
                this.postList.addAll(this.fxw.baX());
            }
            if (dVar != null && dVar.baV() != null && dVar.baV().vw() != null) {
                this.mHostId = dVar.baV().vw().getUserId();
            }
            if (this.fxi != null) {
                this.fxi.b(dVar);
                this.fxi.setFromCDN(this.mIsFromCDN);
                this.fxi.qs(this.fxE);
                this.fxi.jH(this.fxx);
                this.fxi.q(this.mCommonClickListener);
                this.fxi.I(this.fxF);
                this.fxi.setOnImageClickListener(this.bfR);
                this.fxi.setOnLongClickListener(this.aHk);
                this.fxi.setTbGestureDetector(this.bfS);
                this.fxm.b(dVar);
                this.fxm.setFromCDN(this.mIsFromCDN);
                this.fxm.setHostId(this.mHostId);
                this.fxm.jH(this.fxx);
                this.fxm.q(this.mCommonClickListener);
                this.fxm.I(this.fxF);
                this.fxm.setOnImageClickListener(this.bfR);
                this.fxm.setOnLongClickListener(this.aHk);
                this.fxm.setTbGestureDetector(this.bfS);
                this.fxj.setOnClickListener(this.mCommonClickListener);
                this.fxj.setTbGestureDetector(this.bfS);
                this.fxt.setOnClickListener(this.mCommonClickListener);
                if (this.dzp != null && (this.dzp instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dzp).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fxv.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.qs(this.fxE);
                        next.jH(this.fxx);
                        next.jI(this.fxy);
                        next.jJ(this.fxD);
                        next.q(this.mCommonClickListener);
                        next.I(this.fxF);
                        next.setOnImageClickListener(this.bfR);
                        next.setOnLongClickListener(this.aHk);
                    }
                }
                this.fxk.q(this.mCommonClickListener);
                this.fxl.q(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.baX());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bxC() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (!this.fxy && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.w.a(arrayList, 0, postData);
                    z2 = true;
                    if (dVar.bbt() && postData.bxE() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bbc() != null) {
                    postData = dVar.bbc();
                    com.baidu.tbadk.core.util.w.a(arrayList, 0, dVar.bbc());
                    z2 = true;
                    if (!this.fxy && dVar.bbt() && postData.bxE() != null) {
                        postData.c(null);
                    }
                }
                boolean z5 = z2;
                PostData postData3 = postData;
                cY(arrayList);
                if (this.fxh.bcO()) {
                    if (dVar.baX().size() > 0 && (postData2 = dVar.baX().get(0)) != null && postData2.bxC() == 1 && !com.baidu.tbadk.core.util.w.A(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fxw, arrayList, this.fxy);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.w.a(arrayList, a, this.fxw.baY());
                    }
                }
                int b = b(this.fxw, arrayList, this.fxy);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.w.a(arrayList, b, this.fxw.baZ());
                }
                if (arrayList.size() == 0 && this.fxh.bcO()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z6 = false;
                int c = c(dVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fsV);
                    if (dVar != null && dVar.baV() != null) {
                        hVar.fsX = dVar.baV().vn();
                    }
                    hVar.isNew = !this.fxy;
                    hVar.fsZ = this.fxh.bda();
                    com.baidu.tbadk.core.util.w.a(arrayList, c, hVar);
                    z6 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.h> g = g(dVar);
                if (com.baidu.tbadk.core.util.w.A(g) || b2 < 0) {
                    z3 = z6;
                } else {
                    com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.d(arrayList, b2);
                    if (hVar2 instanceof PostData) {
                        ((PostData) hVar2).gNF = true;
                    }
                    com.baidu.tbadk.core.util.w.a((List) arrayList, b2, (List) g);
                    z3 = true;
                }
                int i = -1;
                boolean z7 = false;
                if (z5) {
                    i = d(dVar, arrayList);
                }
                if (i >= 0 && dVar.bbs() != null) {
                    com.baidu.tbadk.core.util.w.a(arrayList, i, dVar.bbs());
                    dVar.bbs().jF((b(arrayList, i) || z3) ? false : true);
                    z3 = true;
                    z7 = true;
                }
                if (!this.fxh.bcX() && this.fxw != null && this.fxw.baT() != null && !StringUtils.isNull(this.fxw.baT().getName()) && !StringUtils.isNull(this.fxw.baT().getId())) {
                    i++;
                    com.baidu.tbadk.core.util.w.a(arrayList, i, this.fxw.baT());
                    if (this.fxu != null && this.fxw.baV() != null) {
                        this.fxu.setThreadId(this.fxw.baV().getId());
                    }
                }
                int i2 = i;
                boolean z8 = false;
                if (z5 && (bdq = bdq()) != null && i2 >= 0) {
                    z8 = true;
                    com.baidu.tbadk.core.util.w.a(arrayList, i2 + 1, bdq);
                }
                if (z5 && !z8) {
                    com.baidu.adp.widget.ListView.h bdr = bdr();
                    int i3 = -1;
                    if (i2 >= 0) {
                        i3 = i2 + 1;
                    } else if (b2 >= 0) {
                        i3 = b2;
                    } else if (c >= 0) {
                        i3 = c;
                    }
                    if (bdr != null && i3 >= 0) {
                        com.baidu.tbadk.core.util.w.a(arrayList, i3, bdr);
                    }
                }
                this.fxi.jZ(!z3);
                boolean z9 = false;
                if (this.fxh.bca() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.fxh.bca().getPostId())) {
                    z9 = true;
                }
                if (this.fxz && !z9) {
                    arrayList.remove(postData3);
                    this.fxz = false;
                }
                if (z7 && (com.baidu.tbadk.core.util.w.d(arrayList, 0) instanceof com.baidu.tieba.pb.data.j)) {
                    jY(false);
                } else {
                    jY(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z9 && !z) {
                    if ((this.fxB || this.fxA) && b2 != -1 && !com.baidu.tbadk.core.util.w.A(g) && !this.fxC) {
                        this.fxH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fxJ);
                                f.this.fxC = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.im().post(this.fxH);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h bdq() {
        PbModel bca = this.fxh.bca();
        if (bca == null) {
            return null;
        }
        String beA = bca.beA();
        if (TextUtils.isEmpty(beA)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.tL(beA);
        b(lVar);
        return lVar;
    }

    private com.baidu.adp.widget.ListView.h bdr() {
        com.baidu.tieba.tbadkCore.data.l bbl;
        if (this.fxw == null || (bbl = this.fxw.bbl()) == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bxr = bbl.bxr();
        if (bxr != null) {
            bxr.setAdvertAppInfo(bbl.ok());
        }
        int tT = bbl.bxq().tT();
        if (tT != 0) {
            a(bbl, tT);
            if (tT == 28 || tT == 31 || bbl.bxq().goods == null) {
                return null;
            }
            bbl.bxq().goods.goods_style = -1001;
            return null;
        }
        if (this.fxw.baT() != null) {
            bbl.forumId = this.fxw.baT().getId();
        }
        if (this.fxw.baV() != null) {
            bbl.threadId = com.baidu.adp.lib.g.b.c(this.fxw.baV().getId(), 0L);
        }
        if (this.fxw != null && this.fxw.uJ() != null) {
            bbl.pageNumber = this.fxw.uJ().uD();
        }
        b(bbl);
        return bbl;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, int i) {
        if (this.fxh.bbc() == null || this.fxh.bcr() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fxA || dVar == null || com.baidu.tbadk.core.util.w.A(dVar.baX()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bbt() && this.fxy) ? 0 : -1;
        } else if (this.fxh.bca() == null || !this.fxh.bca().getIsFromMark()) {
            if (this.fxh.bcr() == null || !this.fxh.bcr().bgt()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
                    if (hVar instanceof PostData) {
                        PostData postData = (PostData) hVar;
                        if (postData.bxC() == 1 && postData.gNC == 0) {
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
                return dVar.bbt() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.w.A(dVar.baX()) || com.baidu.tbadk.core.util.w.A(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.w.d(dVar.baX(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
            if (hVar instanceof PostData) {
                PostData postData = (PostData) hVar;
                if (postData.bxC() == 1 && postData.gNC == 0) {
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

    private int d(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (dVar == null || com.baidu.tbadk.core.util.w.A(dVar.baX()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bbt()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i);
            if ((hVar instanceof PostData) && ((PostData) hVar).bxC() == 1) {
                return i + 1;
            }
        }
        return !dVar.bbt() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bbg() == null || com.baidu.tbadk.core.util.w.A(dVar.bbg().ftq)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bbg().ftq;
        if (com.baidu.tbadk.core.util.w.A(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gNE = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.w.z(dVar.bbg().ftr) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.d(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).gNE = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.d(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).gNE = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fsW);
        hVar3.fsY = dVar.bbg().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void awr() {
        if (this.fxh != null && !aws()) {
            this.fxh.registerListener(this.dqT);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aws() {
        if (this.fxh == null) {
            return false;
        }
        this.dqK = new ArrayList();
        ArrayList<BdUniqueId> bwO = com.baidu.tieba.tbadkCore.q.bwO();
        if (bwO == null || bwO.size() <= 0) {
            return false;
        }
        int size = bwO.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRG().a(this.fxh.getPageContext(), bwO.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dqK.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.w.A(this.dqK)) {
            this.mListView.addAdapters(this.dqK);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.baX() == null || dVar.baY() == null || dVar.baX().size() == 0 || dVar.baV() == null || arrayList == null) {
            return -1;
        }
        if (dVar.baY().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.baX().get(0) == null || dVar.baX().get(0).bxC() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.uJ() == null || dVar.uJ().uD() != dVar.uJ().uA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.baX() == null || dVar.baZ() == null || dVar.baX().size() == 0 || dVar.baV() == null || arrayList == null) {
            return -1;
        }
        if (dVar.baZ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.baX().get(0) == null || dVar.baX().get(0).bxC() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.uJ() == null || dVar.uJ().uD() != dVar.uJ().uA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bds() {
        return this.postList;
    }

    public BdUniqueId qA(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fxq == null || !this.fxq.bbT()) {
            this.fxI = bdt();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bdt() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fsV) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bdu() {
        return this.fxI;
    }

    private void bdv() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fxw != null) {
            ArrayList<PostData> baX = this.fxw.baX();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> bbk = this.fxw.bbk();
            if (bbk != null) {
                int size = bbk.size();
                if (baX != null && baX.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = bbk.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.getAdId() != null) {
                            sb.append(next.getAdId());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = bbk.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dzO = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = bbk.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bxq() != null) {
                            int tT = next3.bxq().tT();
                            if (tT != 0) {
                                a(next3, tT);
                                if (tT != 28 && tT != 31) {
                                    if (next3.bxq().goods != null) {
                                        next3.bxq().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bxq().apk_name)) {
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
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.f.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.fxw.baT() != null) {
                            lVar4.forumId = this.fxw.baT().getId();
                        }
                        if (this.fxw.baV() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fxw.baV().getId(), 0L);
                        }
                        if (this.fxw != null && this.fxw.uJ() != null) {
                            lVar4.pageNumber = this.fxw.uJ().uD();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= baX.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fxy) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        baX.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fxh.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bxq().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sp(i);
        com.baidu.tieba.recapp.report.b.bpD().a(c);
        if (lVar != null && lVar.bxq() != null) {
            lVar.bxq().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bxq() != null && lVar.bxq().goods != null && lVar.bxq().goods.goods_style != 1001 && lVar.bxq().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData baT;
        if (lVar != null && this.fxw != null && lVar.bxq() != null) {
            lVar.bxq().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fxw.uJ() != null) {
                lVar.bxq().advertAppContext.pn = this.fxw.uJ().uD();
            }
            lVar.bxq().advertAppContext.adE = lVar.bxt();
            if (this.fxw.baT() != null && (baT = this.fxw.baT()) != null) {
                lVar.bxq().advertAppContext.fid = baT.getId();
                lVar.bxq().advertAppContext.adG = baT.getFirst_class();
                lVar.bxq().advertAppContext.adH = baT.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bxq().advertAppContext.adI = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bxq().advertAppContext.extensionInfo = lVar.bxq().ext_info;
            lVar.bxq().advertAppContext.Pb = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fxi.setFromCDN(z);
        if (this.dzp != null && (this.dzp instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dzp).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fxv.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bdw() {
        return this.fxx;
    }

    public void jH(boolean z) {
        this.fxx = z;
    }

    public void jI(boolean z) {
        this.fxy = z;
    }

    public void jJ(boolean z) {
        this.fxD = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fxF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bfR = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bfS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void qB(int i) {
        if (this.fxj != null) {
            this.fxj.qB(i);
        }
        switch (i) {
            case 1:
                if (this.fxq != null) {
                    this.fxq.pause();
                }
                if (this.fxi != null) {
                    this.fxi.pause();
                    return;
                }
                return;
            case 2:
                if (this.fxq != null) {
                    this.fxq.resume();
                }
                if (this.fxi != null) {
                    this.fxi.resume();
                    return;
                }
                return;
            case 3:
                if (this.fxq != null) {
                    this.fxq.release();
                }
                if (this.fxi != null) {
                    this.fxi.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cY(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.wn())) {
                        com.baidu.tbadk.core.data.ac acVar = new com.baidu.tbadk.core.data.ac();
                        acVar.dj(postData.wn());
                        list.set(i, acVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fxH);
        if (this.fxk != null) {
            this.fxk.onDestroy();
        }
        if (this.fxl != null) {
            this.fxl.onDestroy();
        }
    }

    public void jU(boolean z) {
        this.fxA = z;
    }

    public void jV(boolean z) {
        this.fxB = z;
    }

    public void jW(boolean z) {
        this.fxz = z;
    }

    public void jX(boolean z) {
        this.fxC = z;
    }

    public ap bdx() {
        return this.fxj;
    }

    public void jY(boolean z) {
        if (this.fxj != null) {
            this.fxj.fEc = z;
        }
    }
}
