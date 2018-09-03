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
    private com.baidu.adp.widget.ListView.a dBX;
    private com.baidu.adp.widget.ListView.a dBY;
    private List<com.baidu.adp.widget.ListView.a> dtu;
    private com.baidu.tieba.pb.data.d fxB;
    private boolean fxG;
    private boolean fxH;
    private int fxJ;
    private Runnable fxM;
    private int fxO;
    private PbActivity fxm;
    private o fxn;
    private ap fxo;
    private ak fxp;
    private ak fxq;
    private i fxr;
    private com.baidu.tieba.pb.video.a fxs;
    private ag fxt;
    private ah fxu;
    private com.baidu.tieba.pb.pb.a.b fxv;
    private v fxw;
    private ae fxx;
    private com.baidu.tieba.pb.pb.a.d fxy;
    private ao fxz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fxA = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fxC = true;
    private boolean fxD = true;
    private boolean fxE = false;
    private boolean fxF = false;
    private boolean fxI = false;
    private String mHostId = null;
    private View.OnClickListener fxK = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bge = null;
    private com.baidu.tieba.pb.a.c bgf = null;
    private View.OnLongClickListener aHj = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fxL = new ArrayList();
    private int fxN = -1;
    private CustomMessageListener dsE = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bvG = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bvG();
                Iterator it = bvG.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ap(f.this.fxm);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fxA.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fxv = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bvG);
                f.this.fxL.clear();
                f.this.fxL.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener aDW = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fxB != null && !com.baidu.adp.base.i.ab(f.this.fxm.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener dtD = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.w.z(f.this.dtu)) {
                f.this.awW();
                f.this.a(f.this.fxB, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fxJ = 0;
        this.width = -1;
        this.fxO = 0;
        this.fxJ = com.baidu.adp.lib.util.l.ah(pbActivity.getPageContext().getPageActivity());
        this.width = this.fxJ;
        this.fxm = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aDW);
        this.fxO = com.baidu.adp.lib.util.l.aj(this.fxm) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fxn = new o(pbActivity, PostData.gNV);
        this.fxn.a(pbActivity);
        this.fxo = new ap(pbActivity, com.baidu.tieba.pb.data.j.fth);
        this.fxp = new ak(pbActivity, com.baidu.tieba.pb.data.h.fta);
        this.fxq = new ak(pbActivity, com.baidu.tieba.pb.data.h.ftb);
        this.fxr = new i(pbActivity, PostData.gNW);
        this.fxr.a(pbActivity);
        this.dBX = com.baidu.tieba.recapp.r.bno().a(pbActivity, AdvertAppInfo.ads);
        this.dBY = com.baidu.tieba.recapp.r.bno().a(pbActivity, AdvertAppInfo.adw);
        this.fxw = new v(pbActivity, com.baidu.tieba.pb.data.a.fsi);
        this.fxx = new ae(pbActivity, com.baidu.tieba.pb.data.g.fsZ);
        this.fxt = new ag(pbActivity, ad.fCN);
        this.fxu = new ah(pbActivity, com.baidu.tbadk.core.data.ao.agI);
        this.fxy = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gOa);
        this.fxz = new ao(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fxs = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fMi);
        this.fxs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fxB.aZt() != null) {
                    pbActivity.baF().bdI().baj();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fxn);
        this.mAdapters.add(this.fxo);
        this.mAdapters.add(this.fxr);
        this.mAdapters.add(this.fxp);
        this.mAdapters.add(this.fxq);
        this.mAdapters.add(this.dBX);
        this.mAdapters.add(this.dBY);
        this.mAdapters.add(this.fxw);
        this.mAdapters.add(this.fxx);
        this.mAdapters.add(this.fxt);
        this.mAdapters.add(this.fxu);
        this.mAdapters.add(this.fxs);
        this.mAdapters.add(this.fxy);
        this.mAdapters.add(this.fxz);
        this.dsE.setPriority(1);
        this.dsE.setSelfListener(true);
        pbActivity.registerListener(this.dsE);
        awV();
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
        com.baidu.adp.widget.ListView.h bbE;
        PostData postData2;
        if (dVar != null) {
            boolean z4 = false;
            if (this.fxB != dVar) {
                z4 = true;
                if ((dVar != null && !dVar.aZf()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z4 = false;
                }
            }
            this.fxB = dVar;
            if (z4) {
                bbJ();
                if (dVar != null) {
                    dVar.jq(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fxB != null && this.fxB.aZk() != null && this.fxB.aZk().size() > 0) {
                this.postList.addAll(this.fxB.aZk());
            }
            if (dVar != null && dVar.aZi() != null && dVar.aZi().vj() != null) {
                this.mHostId = dVar.aZi().vj().getUserId();
            }
            if (this.fxn != null) {
                this.fxn.b(dVar);
                this.fxn.setFromCDN(this.mIsFromCDN);
                this.fxn.qp(this.fxJ);
                this.fxn.jt(this.fxC);
                this.fxn.q(this.mCommonClickListener);
                this.fxn.G(this.fxK);
                this.fxn.setOnImageClickListener(this.bge);
                this.fxn.setOnLongClickListener(this.aHj);
                this.fxn.setTbGestureDetector(this.bgf);
                this.fxr.b(dVar);
                this.fxr.setFromCDN(this.mIsFromCDN);
                this.fxr.setHostId(this.mHostId);
                this.fxr.jt(this.fxC);
                this.fxr.q(this.mCommonClickListener);
                this.fxr.G(this.fxK);
                this.fxr.setOnImageClickListener(this.bge);
                this.fxr.setOnLongClickListener(this.aHj);
                this.fxr.setTbGestureDetector(this.bgf);
                this.fxo.setOnClickListener(this.mCommonClickListener);
                this.fxo.setTbGestureDetector(this.bgf);
                this.fxy.setOnClickListener(this.mCommonClickListener);
                if (this.dBY != null && (this.dBY instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dBY).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fxA.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.qp(this.fxJ);
                        next.jt(this.fxC);
                        next.ju(this.fxD);
                        next.jv(this.fxI);
                        next.q(this.mCommonClickListener);
                        next.G(this.fxK);
                        next.setOnImageClickListener(this.bge);
                        next.setOnLongClickListener(this.aHj);
                    }
                }
                this.fxp.q(this.mCommonClickListener);
                this.fxq.q(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.aZk());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bwg() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (!this.fxD && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.w.a(arrayList, 0, postData);
                    z2 = true;
                    if (dVar.aZH() && postData.bwi() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.aZp() != null) {
                    postData = dVar.aZp();
                    com.baidu.tbadk.core.util.w.a(arrayList, 0, dVar.aZp());
                    z2 = true;
                    if (!this.fxD && dVar.aZH() && postData.bwi() != null) {
                        postData.c(null);
                    }
                }
                boolean z5 = z2;
                PostData postData3 = postData;
                cU(arrayList);
                if (this.fxm.bbc()) {
                    if (dVar.aZk().size() > 0 && (postData2 = dVar.aZk().get(0)) != null && postData2.bwg() == 1 && !com.baidu.tbadk.core.util.w.z(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fxB, arrayList, this.fxD);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.w.a(arrayList, a, this.fxB.aZl());
                    }
                }
                int b = b(this.fxB, arrayList, this.fxD);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.w.a(arrayList, b, this.fxB.aZm());
                }
                if (arrayList.size() == 0 && this.fxm.bbc()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z6 = false;
                int c = c(dVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fta);
                    if (dVar != null && dVar.aZi() != null) {
                        hVar.ftc = dVar.aZi().va();
                    }
                    hVar.isNew = !this.fxD;
                    hVar.fte = this.fxm.bbo();
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
                        ((PostData) hVar2).gOF = true;
                    }
                    com.baidu.tbadk.core.util.w.a((List) arrayList, b2, (List) g);
                    z3 = true;
                }
                int i = -1;
                boolean z7 = false;
                if (z5) {
                    i = d(dVar, arrayList);
                }
                if (i >= 0 && dVar.aZG() != null) {
                    com.baidu.tbadk.core.util.w.a(arrayList, i, dVar.aZG());
                    dVar.aZG().jr((b(arrayList, i) || z3) ? false : true);
                    z3 = true;
                    z7 = true;
                }
                if (!this.fxm.bbl() && this.fxB != null && this.fxB.aZg() != null && !StringUtils.isNull(this.fxB.aZg().getName()) && !StringUtils.isNull(this.fxB.aZg().getId())) {
                    i++;
                    com.baidu.tbadk.core.util.w.a(arrayList, i, this.fxB.aZg());
                    if (this.fxz != null && this.fxB.aZi() != null) {
                        this.fxz.setThreadId(this.fxB.aZi().getId());
                    }
                }
                int i2 = i;
                boolean z8 = false;
                if (z5 && (bbE = bbE()) != null && i2 >= 0) {
                    z8 = true;
                    com.baidu.tbadk.core.util.w.a(arrayList, i2 + 1, bbE);
                }
                if (z5 && !z8) {
                    com.baidu.adp.widget.ListView.h bbF = bbF();
                    int i3 = -1;
                    if (i2 >= 0) {
                        i3 = i2 + 1;
                    } else if (b2 >= 0) {
                        i3 = b2;
                    } else if (c >= 0) {
                        i3 = c;
                    }
                    if (bbF != null && i3 >= 0) {
                        com.baidu.tbadk.core.util.w.a(arrayList, i3, bbF);
                    }
                }
                this.fxn.jL(!z3);
                boolean z9 = false;
                if (this.fxm.bao() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.fxm.bao().getPostId())) {
                    z9 = true;
                }
                if (this.fxE && !z9) {
                    arrayList.remove(postData3);
                    this.fxE = false;
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
                    if ((this.fxG || this.fxF) && b2 != -1 && !com.baidu.tbadk.core.util.w.z(g) && !this.fxH) {
                        this.fxM = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fxO);
                                f.this.fxH = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.in().post(this.fxM);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h bbE() {
        PbModel bao = this.fxm.bao();
        if (bao == null) {
            return null;
        }
        String bcO = bao.bcO();
        if (TextUtils.isEmpty(bcO)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.tN(bcO);
        b(lVar);
        return lVar;
    }

    private com.baidu.adp.widget.ListView.h bbF() {
        com.baidu.tieba.tbadkCore.data.l aZy;
        if (this.fxB == null || (aZy = this.fxB.aZy()) == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bvV = aZy.bvV();
        if (bvV != null) {
            bvV.setAdvertAppInfo(aZy.oj());
        }
        int tE = aZy.bvU().tE();
        if (tE != 0) {
            a(aZy, tE);
            if (tE == 28 || tE == 31 || aZy.bvU().goods == null) {
                return null;
            }
            aZy.bvU().goods.goods_style = -1001;
            return null;
        }
        if (this.fxB.aZg() != null) {
            aZy.forumId = this.fxB.aZg().getId();
        }
        if (this.fxB.aZi() != null) {
            aZy.threadId = com.baidu.adp.lib.g.b.c(this.fxB.aZi().getId(), 0L);
        }
        if (this.fxB != null && this.fxB.uv() != null) {
            aZy.pageNumber = this.fxB.uv().up();
        }
        b(aZy);
        return aZy;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, int i) {
        if (this.fxm.aZp() == null || this.fxm.baF() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fxF || dVar == null || com.baidu.tbadk.core.util.w.z(dVar.aZk()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.aZH() && this.fxD) ? 0 : -1;
        } else if (this.fxm.bao() == null || !this.fxm.bao().getIsFromMark()) {
            if (this.fxm.baF() == null || !this.fxm.baF().beH()) {
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
                        if (postData.bwg() == 1 && postData.gOC == 0) {
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
                return dVar.aZH() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.w.z(dVar.aZk()) || com.baidu.tbadk.core.util.w.z(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.w.d(dVar.aZk(), 0)) == null) {
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
                if (postData.bwg() == 1 && postData.gOC == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.w.z(dVar.aZk()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.aZH()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i);
            if ((hVar instanceof PostData) && ((PostData) hVar).bwg() == 1) {
                return i + 1;
            }
        }
        return !dVar.aZH() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.aZt() == null || com.baidu.tbadk.core.util.w.z(dVar.aZt().ftu)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.aZt().ftu;
        if (com.baidu.tbadk.core.util.w.z(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gOE = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.w.y(dVar.aZt().ftv) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.d(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).gOE = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.d(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).gOE = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.ftb);
        hVar3.ftd = dVar.aZt().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void awV() {
        if (this.fxm != null && !awW()) {
            this.fxm.registerListener(this.dtD);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean awW() {
        if (this.fxm == null) {
            return false;
        }
        this.dtu = new ArrayList();
        ArrayList<BdUniqueId> bvt = com.baidu.tieba.tbadkCore.q.bvt();
        if (bvt == null || bvt.size() <= 0) {
            return false;
        }
        int size = bvt.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aSF().a(this.fxm.getPageContext(), bvt.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dtu.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.w.z(this.dtu)) {
            this.mListView.addAdapters(this.dtu);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.aZk() == null || dVar.aZl() == null || dVar.aZk().size() == 0 || dVar.aZi() == null || arrayList == null) {
            return -1;
        }
        if (dVar.aZl().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.aZk().get(0) == null || dVar.aZk().get(0).bwg() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.uv() == null || dVar.uv().up() != dVar.uv().um()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.aZk() == null || dVar.aZm() == null || dVar.aZk().size() == 0 || dVar.aZi() == null || arrayList == null) {
            return -1;
        }
        if (dVar.aZm().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.aZk().get(0) == null || dVar.aZk().get(0).bwg() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.uv() == null || dVar.uv().up() != dVar.uv().um()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bbG() {
        return this.postList;
    }

    public BdUniqueId qx(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fxv == null || !this.fxv.bah()) {
            this.fxN = bbH();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bbH() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fta) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bbI() {
        return this.fxN;
    }

    private void bbJ() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fxB != null) {
            ArrayList<PostData> aZk = this.fxB.aZk();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aZx = this.fxB.aZx();
            if (aZx != null) {
                int size = aZx.size();
                if (aZk != null && aZk.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aZx.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aZx.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dCx = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aZx.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bvU() != null) {
                            int tE = next3.bvU().tE();
                            if (tE != 0) {
                                a(next3, tE);
                                if (tE != 28 && tE != 31) {
                                    if (next3.bvU().goods != null) {
                                        next3.bvU().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bvU().apk_name)) {
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
                        if (this.fxB.aZg() != null) {
                            lVar4.forumId = this.fxB.aZg().getId();
                        }
                        if (this.fxB.aZi() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fxB.aZi().getId(), 0L);
                        }
                        if (this.fxB != null && this.fxB.uv() != null) {
                            lVar4.pageNumber = this.fxB.uv().up();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aZk.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fxD) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aZk.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fxm.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bvU().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, 5);
        c.sn(i);
        com.baidu.tieba.recapp.report.c.boj().a(c);
        if (lVar != null && lVar.bvU() != null) {
            lVar.bvU().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bvU() != null && lVar.bvU().goods != null && lVar.bvU().goods.goods_style != 1001 && lVar.bvU().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aZg;
        if (lVar != null && this.fxB != null && lVar.bvU() != null) {
            lVar.bvU().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fxB.uv() != null) {
                lVar.bvU().advertAppContext.pn = this.fxB.uv().up();
            }
            lVar.bvU().advertAppContext.page = lVar.bvX();
            if (this.fxB.aZg() != null && (aZg = this.fxB.aZg()) != null) {
                lVar.bvU().advertAppContext.fid = aZg.getId();
                lVar.bvU().advertAppContext.adk = aZg.getFirst_class();
                lVar.bvU().advertAppContext.adl = aZg.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bvU().advertAppContext.adm = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bvU().advertAppContext.extensionInfo = lVar.bvU().ext_info;
            lVar.bvU().advertAppContext.OY = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fxn.setFromCDN(z);
        if (this.dBY != null && (this.dBY instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dBY).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fxA.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bbK() {
        return this.fxC;
    }

    public void jt(boolean z) {
        this.fxC = z;
    }

    public void ju(boolean z) {
        this.fxD = z;
    }

    public void jv(boolean z) {
        this.fxI = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.fxK = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bge = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bgf = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aHj = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void qy(int i) {
        if (this.fxo != null) {
            this.fxo.qy(i);
        }
        switch (i) {
            case 1:
                if (this.fxv != null) {
                    this.fxv.pause();
                }
                if (this.fxn != null) {
                    this.fxn.pause();
                    return;
                }
                return;
            case 2:
                if (this.fxv != null) {
                    this.fxv.resume();
                }
                if (this.fxn != null) {
                    this.fxn.resume();
                    return;
                }
                return;
            case 3:
                if (this.fxv != null) {
                    this.fxv.release();
                }
                if (this.fxn != null) {
                    this.fxn.release();
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
                    if (!TextUtils.isEmpty(postData.wb())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.dh(postData.wb());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fxM);
        if (this.fxp != null) {
            this.fxp.onDestroy();
        }
        if (this.fxq != null) {
            this.fxq.onDestroy();
        }
    }

    public void jG(boolean z) {
        this.fxF = z;
    }

    public void jH(boolean z) {
        this.fxG = z;
    }

    public void jI(boolean z) {
        this.fxE = z;
    }

    public void jJ(boolean z) {
        this.fxH = z;
    }

    public ap bbL() {
        return this.fxo;
    }

    public void jK(boolean z) {
        if (this.fxo != null) {
            this.fxo.fEi = z;
        }
    }
}
