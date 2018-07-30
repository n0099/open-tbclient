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
    private com.baidu.adp.widget.ListView.a dCa;
    private com.baidu.adp.widget.ListView.a dCb;
    private List<com.baidu.adp.widget.ListView.a> dtx;
    private ag fxA;
    private ah fxB;
    private com.baidu.tieba.pb.pb.a.b fxC;
    private v fxD;
    private ae fxE;
    private com.baidu.tieba.pb.pb.a.d fxF;
    private ao fxG;
    private com.baidu.tieba.pb.data.d fxI;
    private boolean fxN;
    private boolean fxO;
    private int fxQ;
    private Runnable fxT;
    private int fxV;
    private PbActivity fxt;
    private o fxu;
    private ap fxv;
    private ak fxw;
    private ak fxx;
    private i fxy;
    private com.baidu.tieba.pb.video.a fxz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fxH = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fxJ = true;
    private boolean fxK = true;
    private boolean fxL = false;
    private boolean fxM = false;
    private boolean fxP = false;
    private String mHostId = null;
    private View.OnClickListener fxR = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bgd = null;
    private com.baidu.tieba.pb.a.c bge = null;
    private View.OnLongClickListener aHk = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fxS = new ArrayList();
    private int fxU = -1;
    private CustomMessageListener dsH = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bvF = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bvF();
                Iterator it = bvF.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ap(f.this.fxt);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fxH.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fxC = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bvF);
                f.this.fxS.clear();
                f.this.fxS.addAll(arrayList);
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
            if (customResponsedMessage != null && f.this.fxI != null && !com.baidu.adp.base.i.ab(f.this.fxt.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dtG = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.w.z(f.this.dtx)) {
                f.this.awX();
                f.this.a(f.this.fxI, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fxQ = 0;
        this.width = -1;
        this.fxV = 0;
        this.fxQ = com.baidu.adp.lib.util.l.ah(pbActivity.getPageContext().getPageActivity());
        this.width = this.fxQ;
        this.fxt = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aDX);
        this.fxV = com.baidu.adp.lib.util.l.aj(this.fxt) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fxu = new o(pbActivity, PostData.gNT);
        this.fxu.a(pbActivity);
        this.fxv = new ap(pbActivity, com.baidu.tieba.pb.data.j.fto);
        this.fxw = new ak(pbActivity, com.baidu.tieba.pb.data.h.fth);
        this.fxx = new ak(pbActivity, com.baidu.tieba.pb.data.h.fti);
        this.fxy = new i(pbActivity, PostData.gNU);
        this.fxy.a(pbActivity);
        this.dCa = com.baidu.tieba.recapp.r.bnn().a(pbActivity, AdvertAppInfo.ads);
        this.dCb = com.baidu.tieba.recapp.r.bnn().a(pbActivity, AdvertAppInfo.adw);
        this.fxD = new v(pbActivity, com.baidu.tieba.pb.data.a.fsp);
        this.fxE = new ae(pbActivity, com.baidu.tieba.pb.data.g.ftg);
        this.fxA = new ag(pbActivity, ad.fCU);
        this.fxB = new ah(pbActivity, com.baidu.tbadk.core.data.ao.agI);
        this.fxF = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gNY);
        this.fxG = new ao(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fxz = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fMp);
        this.fxz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fxI.aZy() != null) {
                    pbActivity.baK().bdN().bao();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fxu);
        this.mAdapters.add(this.fxv);
        this.mAdapters.add(this.fxy);
        this.mAdapters.add(this.fxw);
        this.mAdapters.add(this.fxx);
        this.mAdapters.add(this.dCa);
        this.mAdapters.add(this.dCb);
        this.mAdapters.add(this.fxD);
        this.mAdapters.add(this.fxE);
        this.mAdapters.add(this.fxA);
        this.mAdapters.add(this.fxB);
        this.mAdapters.add(this.fxz);
        this.mAdapters.add(this.fxF);
        this.mAdapters.add(this.fxG);
        this.dsH.setPriority(1);
        this.dsH.setSelfListener(true);
        pbActivity.registerListener(this.dsH);
        awW();
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
        com.baidu.adp.widget.ListView.h bbJ;
        PostData postData2;
        if (dVar != null) {
            boolean z4 = false;
            if (this.fxI != dVar) {
                z4 = true;
                if ((dVar != null && !dVar.aZk()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z4 = false;
                }
            }
            this.fxI = dVar;
            if (z4) {
                bbO();
                if (dVar != null) {
                    dVar.jq(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fxI != null && this.fxI.aZp() != null && this.fxI.aZp().size() > 0) {
                this.postList.addAll(this.fxI.aZp());
            }
            if (dVar != null && dVar.aZn() != null && dVar.aZn().vk() != null) {
                this.mHostId = dVar.aZn().vk().getUserId();
            }
            if (this.fxu != null) {
                this.fxu.b(dVar);
                this.fxu.setFromCDN(this.mIsFromCDN);
                this.fxu.qp(this.fxQ);
                this.fxu.jt(this.fxJ);
                this.fxu.q(this.mCommonClickListener);
                this.fxu.G(this.fxR);
                this.fxu.setOnImageClickListener(this.bgd);
                this.fxu.setOnLongClickListener(this.aHk);
                this.fxu.setTbGestureDetector(this.bge);
                this.fxy.b(dVar);
                this.fxy.setFromCDN(this.mIsFromCDN);
                this.fxy.setHostId(this.mHostId);
                this.fxy.jt(this.fxJ);
                this.fxy.q(this.mCommonClickListener);
                this.fxy.G(this.fxR);
                this.fxy.setOnImageClickListener(this.bgd);
                this.fxy.setOnLongClickListener(this.aHk);
                this.fxy.setTbGestureDetector(this.bge);
                this.fxv.setOnClickListener(this.mCommonClickListener);
                this.fxv.setTbGestureDetector(this.bge);
                this.fxF.setOnClickListener(this.mCommonClickListener);
                if (this.dCb != null && (this.dCb instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dCb).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fxH.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.qp(this.fxQ);
                        next.jt(this.fxJ);
                        next.ju(this.fxK);
                        next.jv(this.fxP);
                        next.q(this.mCommonClickListener);
                        next.G(this.fxR);
                        next.setOnImageClickListener(this.bgd);
                        next.setOnLongClickListener(this.aHk);
                    }
                }
                this.fxw.q(this.mCommonClickListener);
                this.fxx.q(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.aZp());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bwf() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (!this.fxK && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.w.a(arrayList, 0, postData);
                    z2 = true;
                    if (dVar.aZM() && postData.bwh() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.aZu() != null) {
                    postData = dVar.aZu();
                    com.baidu.tbadk.core.util.w.a(arrayList, 0, dVar.aZu());
                    z2 = true;
                    if (!this.fxK && dVar.aZM() && postData.bwh() != null) {
                        postData.c(null);
                    }
                }
                boolean z5 = z2;
                PostData postData3 = postData;
                cU(arrayList);
                if (this.fxt.bbh()) {
                    if (dVar.aZp().size() > 0 && (postData2 = dVar.aZp().get(0)) != null && postData2.bwf() == 1 && !com.baidu.tbadk.core.util.w.z(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fxI, arrayList, this.fxK);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.w.a(arrayList, a, this.fxI.aZq());
                    }
                }
                int b = b(this.fxI, arrayList, this.fxK);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.w.a(arrayList, b, this.fxI.aZr());
                }
                if (arrayList.size() == 0 && this.fxt.bbh()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z6 = false;
                int c = c(dVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fth);
                    if (dVar != null && dVar.aZn() != null) {
                        hVar.ftj = dVar.aZn().vb();
                    }
                    hVar.isNew = !this.fxK;
                    hVar.ftl = this.fxt.bbt();
                    com.baidu.tbadk.core.util.w.a(arrayList, c, hVar);
                    z6 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.h> g = g(dVar);
                if (com.baidu.tbadk.core.util.w.z(g) || b2 < 0) {
                    z3 = z6;
                } else {
                    com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.d(arrayList, b2);
                    if (hVar2 instanceof PostData) {
                        ((PostData) hVar2).gOD = true;
                    }
                    com.baidu.tbadk.core.util.w.a((List) arrayList, b2, (List) g);
                    z3 = true;
                }
                int i = -1;
                boolean z7 = false;
                if (z5) {
                    i = d(dVar, arrayList);
                }
                if (i >= 0 && dVar.aZL() != null) {
                    com.baidu.tbadk.core.util.w.a(arrayList, i, dVar.aZL());
                    dVar.aZL().jr((b(arrayList, i) || z3) ? false : true);
                    z3 = true;
                    z7 = true;
                }
                if (!this.fxt.bbq() && this.fxI != null && this.fxI.aZl() != null && !StringUtils.isNull(this.fxI.aZl().getName()) && !StringUtils.isNull(this.fxI.aZl().getId())) {
                    i++;
                    com.baidu.tbadk.core.util.w.a(arrayList, i, this.fxI.aZl());
                    if (this.fxG != null && this.fxI.aZn() != null) {
                        this.fxG.setThreadId(this.fxI.aZn().getId());
                    }
                }
                int i2 = i;
                boolean z8 = false;
                if (z5 && (bbJ = bbJ()) != null && i2 >= 0) {
                    z8 = true;
                    com.baidu.tbadk.core.util.w.a(arrayList, i2 + 1, bbJ);
                }
                if (z5 && !z8) {
                    com.baidu.adp.widget.ListView.h bbK = bbK();
                    int i3 = -1;
                    if (i2 >= 0) {
                        i3 = i2 + 1;
                    } else if (b2 >= 0) {
                        i3 = b2;
                    } else if (c >= 0) {
                        i3 = c;
                    }
                    if (bbK != null && i3 >= 0) {
                        com.baidu.tbadk.core.util.w.a(arrayList, i3, bbK);
                    }
                }
                this.fxu.jL(!z3);
                boolean z9 = false;
                if (this.fxt.bat() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.fxt.bat().getPostId())) {
                    z9 = true;
                }
                if (this.fxL && !z9) {
                    arrayList.remove(postData3);
                    this.fxL = false;
                }
                if (z7 && (com.baidu.tbadk.core.util.w.d(arrayList, 0) instanceof com.baidu.tieba.pb.data.j)) {
                    jK(false);
                } else {
                    jK(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z9 && !z) {
                    if ((this.fxN || this.fxM) && b2 != -1 && !com.baidu.tbadk.core.util.w.z(g) && !this.fxO) {
                        this.fxT = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fxV);
                                f.this.fxO = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.in().post(this.fxT);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h bbJ() {
        PbModel bat = this.fxt.bat();
        if (bat == null) {
            return null;
        }
        String bcT = bat.bcT();
        if (TextUtils.isEmpty(bcT)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.tJ(bcT);
        b(lVar);
        return lVar;
    }

    private com.baidu.adp.widget.ListView.h bbK() {
        com.baidu.tieba.tbadkCore.data.l aZD;
        if (this.fxI == null || (aZD = this.fxI.aZD()) == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bvU = aZD.bvU();
        if (bvU != null) {
            bvU.setAdvertAppInfo(aZD.om());
        }
        int tF = aZD.bvT().tF();
        if (tF != 0) {
            a(aZD, tF);
            if (tF == 28 || tF == 31 || aZD.bvT().goods == null) {
                return null;
            }
            aZD.bvT().goods.goods_style = -1001;
            return null;
        }
        if (this.fxI.aZl() != null) {
            aZD.forumId = this.fxI.aZl().getId();
        }
        if (this.fxI.aZn() != null) {
            aZD.threadId = com.baidu.adp.lib.g.b.c(this.fxI.aZn().getId(), 0L);
        }
        if (this.fxI != null && this.fxI.uw() != null) {
            aZD.pageNumber = this.fxI.uw().uq();
        }
        b(aZD);
        return aZD;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, int i) {
        if (this.fxt.aZu() == null || this.fxt.baK() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fxM || dVar == null || com.baidu.tbadk.core.util.w.z(dVar.aZp()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.aZM() && this.fxK) ? 0 : -1;
        } else if (this.fxt.bat() == null || !this.fxt.bat().getIsFromMark()) {
            if (this.fxt.baK() == null || !this.fxt.baK().beM()) {
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
                        if (postData.bwf() == 1 && postData.gOA == 0) {
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
                return dVar.aZM() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.w.z(dVar.aZp()) || com.baidu.tbadk.core.util.w.z(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.w.d(dVar.aZp(), 0)) == null) {
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
                if (postData.bwf() == 1 && postData.gOA == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.w.z(dVar.aZp()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.aZM()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i);
            if ((hVar instanceof PostData) && ((PostData) hVar).bwf() == 1) {
                return i + 1;
            }
        }
        return !dVar.aZM() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.aZy() == null || com.baidu.tbadk.core.util.w.z(dVar.aZy().ftB)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.aZy().ftB;
        if (com.baidu.tbadk.core.util.w.z(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gOC = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.w.y(dVar.aZy().ftC) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.d(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).gOC = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.d(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).gOC = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fti);
        hVar3.ftk = dVar.aZy().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void awW() {
        if (this.fxt != null && !awX()) {
            this.fxt.registerListener(this.dtG);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean awX() {
        if (this.fxt == null) {
            return false;
        }
        this.dtx = new ArrayList();
        ArrayList<BdUniqueId> bvs = com.baidu.tieba.tbadkCore.q.bvs();
        if (bvs == null || bvs.size() <= 0) {
            return false;
        }
        int size = bvs.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aSI().a(this.fxt.getPageContext(), bvs.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dtx.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.w.z(this.dtx)) {
            this.mListView.addAdapters(this.dtx);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.aZp() == null || dVar.aZq() == null || dVar.aZp().size() == 0 || dVar.aZn() == null || arrayList == null) {
            return -1;
        }
        if (dVar.aZq().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.aZp().get(0) == null || dVar.aZp().get(0).bwf() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.uw() == null || dVar.uw().uq() != dVar.uw().un()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.aZp() == null || dVar.aZr() == null || dVar.aZp().size() == 0 || dVar.aZn() == null || arrayList == null) {
            return -1;
        }
        if (dVar.aZr().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.aZp().get(0) == null || dVar.aZp().get(0).bwf() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.uw() == null || dVar.uw().uq() != dVar.uw().un()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bbL() {
        return this.postList;
    }

    public BdUniqueId qx(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fxC == null || !this.fxC.bam()) {
            this.fxU = bbM();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bbM() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fth) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bbN() {
        return this.fxU;
    }

    private void bbO() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fxI != null) {
            ArrayList<PostData> aZp = this.fxI.aZp();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aZC = this.fxI.aZC();
            if (aZC != null) {
                int size = aZC.size();
                if (aZp != null && aZp.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aZC.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aZC.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dCA = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aZC.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bvT() != null) {
                            int tF = next3.bvT().tF();
                            if (tF != 0) {
                                a(next3, tF);
                                if (tF != 28 && tF != 31) {
                                    if (next3.bvT().goods != null) {
                                        next3.bvT().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bvT().apk_name)) {
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
                        if (this.fxI.aZl() != null) {
                            lVar4.forumId = this.fxI.aZl().getId();
                        }
                        if (this.fxI.aZn() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fxI.aZn().getId(), 0L);
                        }
                        if (this.fxI != null && this.fxI.uw() != null) {
                            lVar4.pageNumber = this.fxI.uw().uq();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aZp.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fxK) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aZp.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fxt.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bvT().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, 5);
        c.sn(i);
        com.baidu.tieba.recapp.report.c.boi().a(c);
        if (lVar != null && lVar.bvT() != null) {
            lVar.bvT().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bvT() != null && lVar.bvT().goods != null && lVar.bvT().goods.goods_style != 1001 && lVar.bvT().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aZl;
        if (lVar != null && this.fxI != null && lVar.bvT() != null) {
            lVar.bvT().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fxI.uw() != null) {
                lVar.bvT().advertAppContext.pn = this.fxI.uw().uq();
            }
            lVar.bvT().advertAppContext.adi = lVar.bvW();
            if (this.fxI.aZl() != null && (aZl = this.fxI.aZl()) != null) {
                lVar.bvT().advertAppContext.fid = aZl.getId();
                lVar.bvT().advertAppContext.adk = aZl.getFirst_class();
                lVar.bvT().advertAppContext.adl = aZl.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bvT().advertAppContext.adm = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bvT().advertAppContext.extensionInfo = lVar.bvT().ext_info;
            lVar.bvT().advertAppContext.OY = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fxu.setFromCDN(z);
        if (this.dCb != null && (this.dCb instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dCb).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fxH.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bbP() {
        return this.fxJ;
    }

    public void jt(boolean z) {
        this.fxJ = z;
    }

    public void ju(boolean z) {
        this.fxK = z;
    }

    public void jv(boolean z) {
        this.fxP = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fxR = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bgd = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bge = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHk = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void qy(int i) {
        if (this.fxv != null) {
            this.fxv.qy(i);
        }
        switch (i) {
            case 1:
                if (this.fxC != null) {
                    this.fxC.pause();
                }
                if (this.fxu != null) {
                    this.fxu.pause();
                    return;
                }
                return;
            case 2:
                if (this.fxC != null) {
                    this.fxC.resume();
                }
                if (this.fxu != null) {
                    this.fxu.resume();
                    return;
                }
                return;
            case 3:
                if (this.fxC != null) {
                    this.fxC.release();
                }
                if (this.fxu != null) {
                    this.fxu.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cU(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.wc())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.dg(postData.wc());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fxT);
        if (this.fxw != null) {
            this.fxw.onDestroy();
        }
        if (this.fxx != null) {
            this.fxx.onDestroy();
        }
    }

    public void jG(boolean z) {
        this.fxM = z;
    }

    public void jH(boolean z) {
        this.fxN = z;
    }

    public void jI(boolean z) {
        this.fxL = z;
    }

    public void jJ(boolean z) {
        this.fxO = z;
    }

    public ap bbQ() {
        return this.fxv;
    }

    public void jK(boolean z) {
        if (this.fxv != null) {
            this.fxv.fEp = z;
        }
    }
}
