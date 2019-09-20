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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class f {
    private ArrayList<com.baidu.adp.widget.ListView.m> dRB;
    private List<com.baidu.adp.widget.ListView.a> fNK;
    private com.baidu.adp.widget.ListView.a gmD;
    private com.baidu.tieba.pb.video.a hPA;
    private com.baidu.adp.widget.ListView.a hPB;
    private ag hPC;
    private ah hPD;
    private com.baidu.tieba.pb.pb.a.b hPE;
    private v hPF;
    private ae hPG;
    private com.baidu.tieba.pb.pb.a.d hPH;
    private com.baidu.tieba.pb.data.d hPJ;
    private boolean hPO;
    private boolean hPP;
    private int hPR;
    private Runnable hPV;
    private int hPX;
    private PbActivity hPu;
    private o hPv;
    private com.baidu.tieba.pb.pb.main.a.a hPw;
    private ak hPx;
    private ak hPy;
    private i hPz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hPI = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hPK = true;
    private boolean hPL = true;
    private boolean hPM = false;
    private boolean hPN = false;
    private boolean hPQ = false;
    private String mHostId = null;
    private PostData hPS = null;
    private View.OnClickListener hPT = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h cLe = null;
    private com.baidu.tieba.pb.a.c cmw = null;
    private View.OnLongClickListener cnB = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hPU = new ArrayList();
    private int hPW = -1;
    private CustomMessageListener fDD = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cpZ = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cpZ();
                Iterator it = cpZ.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).av(f.this.hPu);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hPI.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hPE = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cpZ);
                f.this.hPU.clear();
                f.this.hPU.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cjl = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hPJ != null && !com.baidu.adp.base.i.Z(f.this.hPu.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener fNM = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.aa(f.this.fNK)) {
                f.this.bxX();
                f.this.a(f.this.hPJ, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hPR = 0;
        this.width = -1;
        this.hPX = 0;
        this.hPR = com.baidu.adp.lib.util.l.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.hPR;
        this.hPu = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cjl);
        this.hPX = com.baidu.adp.lib.util.l.ah(this.hPu) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hPv = new o(pbActivity, PostData.jiz);
        this.hPv.a(pbActivity);
        this.hPw = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.j.hLh);
        this.hPx = new ak(pbActivity, com.baidu.tieba.pb.data.i.hLb);
        this.hPy = new ak(pbActivity, com.baidu.tieba.pb.data.i.hLc);
        this.hPz = new i(pbActivity, PostData.jiA);
        this.hPz.a(pbActivity);
        this.gmD = com.baidu.tieba.recapp.r.ciJ().a(pbActivity, AdvertAppInfo.bFg);
        this.hPB = com.baidu.tieba.recapp.r.ciJ().a(pbActivity, AdvertAppInfo.bFk);
        this.hPF = new v(pbActivity, com.baidu.tieba.pb.data.a.hJY);
        this.hPG = new ae(pbActivity, com.baidu.tieba.pb.data.h.hKZ);
        this.hPC = new ag(pbActivity, ad.hUJ);
        this.hPD = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bIy);
        this.hPH = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.jiF);
        this.hPA = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.ieQ);
        this.hPA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hPJ.bTJ() != null) {
                    pbActivity.bUW().bYf().bUz();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
                }
            }
        });
        this.mAdapters.add(this.hPv);
        this.mAdapters.add(this.hPw);
        this.mAdapters.add(this.hPz);
        this.mAdapters.add(this.hPx);
        this.mAdapters.add(this.hPy);
        this.mAdapters.add(this.gmD);
        this.mAdapters.add(this.hPB);
        this.mAdapters.add(this.hPF);
        this.mAdapters.add(this.hPG);
        this.mAdapters.add(this.hPC);
        this.mAdapters.add(this.hPD);
        this.mAdapters.add(this.hPA);
        this.mAdapters.add(this.hPH);
        this.fDD.setPriority(1);
        this.fDD.setSelfListener(true);
        pbActivity.registerListener(this.fDD);
        bxW();
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
        int i;
        boolean z4;
        boolean z5;
        com.baidu.adp.widget.ListView.m bVY;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hPJ != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bTw()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hPJ = dVar;
            if (z6) {
                bWd();
                if (dVar != null) {
                    dVar.oh(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hPJ != null && this.hPJ.bTA() != null && this.hPJ.bTA().size() > 0) {
                this.postList.addAll(this.hPJ.bTA());
            }
            if (dVar != null && dVar.bTy() != null && dVar.bTy().aeC() != null) {
                this.mHostId = dVar.bTy().aeC().getUserId();
            }
            if (this.hPv != null) {
                this.hPv.setData(dVar);
                this.hPv.setFromCDN(this.mIsFromCDN);
                this.hPv.xL(this.hPR);
                this.hPv.ok(this.hPK);
                this.hPv.v(this.mCommonClickListener);
                this.hPv.N(this.hPT);
                this.hPv.setOnImageClickListener(this.cLe);
                this.hPv.setOnLongClickListener(this.cnB);
                this.hPv.setTbGestureDetector(this.cmw);
                this.hPz.setData(dVar);
                this.hPz.setFromCDN(this.mIsFromCDN);
                this.hPz.setHostId(this.mHostId);
                this.hPz.ok(this.hPK);
                this.hPz.v(this.mCommonClickListener);
                this.hPz.N(this.hPT);
                this.hPz.setOnImageClickListener(this.cLe);
                this.hPz.setOnLongClickListener(this.cnB);
                this.hPz.setTbGestureDetector(this.cmw);
                this.hPw.setOnClickListener(this.mCommonClickListener);
                this.hPH.setOnClickListener(this.mCommonClickListener);
                if (this.hPB != null && (this.hPB instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hPB).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hPI.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.xL(this.hPR);
                        next.ok(this.hPK);
                        next.ol(this.hPL);
                        next.om(this.hPQ);
                        next.v(this.mCommonClickListener);
                        next.N(this.hPT);
                        next.setOnImageClickListener(this.cLe);
                        next.setOnLongClickListener(this.cnB);
                    }
                }
                this.hPx.v(this.mCommonClickListener);
                this.hPy.v(this.mCommonClickListener);
                this.hPx.setData(dVar);
                this.hPy.setData(dVar);
                this.hPC.setData(dVar);
                this.hPD.setData(dVar);
                this.hPF.setData(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bTA());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cqz() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hPS = postData;
                }
                boolean z7 = false;
                if (!this.hPL && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bTW() && postData.cqB() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bTF() != null) {
                    postData = dVar.bTF();
                    z7 = true;
                    z2 = true;
                    if (!this.hPL && dVar.bTW() && postData.cqB() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dH(arrayList);
                if (this.hPu.bVv()) {
                    if (dVar.bTA().size() > 0 && (postData2 = dVar.bTA().get(0)) != null && postData2.cqz() == 1 && !com.baidu.tbadk.core.util.v.aa(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hPJ, arrayList, this.hPL);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.hPJ.bTB());
                    }
                }
                int c = c(this.hPJ, arrayList, this.hPL);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.hPJ.bTC());
                }
                com.baidu.tieba.tbadkCore.s.p(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hLb);
                    if (dVar != null && dVar.bTy() != null) {
                        iVar.hLd = dVar.bTy().aet();
                    }
                    iVar.isNew = !this.hPL;
                    iVar.hLg = this.hPu.bVH();
                    iVar.sortType = dVar.hKI;
                    if (dVar.hKH != null && dVar.hKH.size() > dVar.hKI) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hKH.size()) {
                                break;
                            } else if (dVar.hKH.get(i3).sort_type.intValue() != dVar.hKI) {
                                i2 = i3 + 1;
                            } else {
                                iVar.hLf = dVar.hKH.get(i3).sort_name;
                                break;
                            }
                        }
                    }
                    com.baidu.tbadk.core.util.v.a(arrayList, c2, iVar);
                    z10 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.m> f = f(dVar);
                if (com.baidu.tbadk.core.util.v.aa(f) || b2 < 0) {
                    z3 = z10;
                } else {
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, b2);
                    if (mVar instanceof PostData) {
                        ((PostData) mVar).jjl = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) f);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hPL);
                }
                if (i < 0 || dVar.bTV() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, i, dVar.bTV());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bVY = bVY()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i + 1, bVY);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bVZ = bVZ();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bVZ != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i4, bVZ);
                    }
                }
                this.hPv.oC(!z4);
                boolean z12 = false;
                if (this.hPu.bUE() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hPu.bUE().getPostId())) {
                    z12 = true;
                }
                if (this.hPM && !z12) {
                    arrayList.remove(postData3);
                    this.hPM = false;
                }
                if (dVar.bTV() != null) {
                    if (z5) {
                        dVar.bTV().oi(false);
                    } else {
                        dVar.bTV().oi(true);
                    }
                }
                if (this.mListView != null) {
                    this.dRB = arrayList;
                    this.mListView.setData(this.dRB);
                }
                if (!z12 && !z && ((this.hPO || this.hPN) && b2 != -1 && !com.baidu.tbadk.core.util.v.aa(f) && !this.hPP)) {
                    this.hPV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + f.size(), 0 - f.this.hPX);
                            f.this.hPP = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.iK().post(this.hPV);
                }
                if (postData3 == null) {
                    if (this.hPS != null && !this.hPN) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, this.hPS);
                    } else {
                        PostData postData4 = new PostData();
                        postData4.Bk(1);
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, postData4);
                    }
                    this.mListView.setData(arrayList);
                } else if (z9) {
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData3);
                    this.mListView.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m bVY() {
        PbModel bUE = this.hPu.bUE();
        if (bUE == null) {
            return null;
        }
        String bXm = bUE.bXm();
        if (TextUtils.isEmpty(bXm)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.Fj(bXm);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bVZ() {
        if (this.hPJ == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bWJ = this.hPu.bUE().bWJ();
        if (bWJ == null) {
            bWJ = this.hPJ.bTN();
        }
        if (bWJ != null) {
            AdvertAppInfo.ILegoAdvert cqo = bWJ.cqo();
            if (cqo != null) {
                cqo.setAdvertAppInfo(bWJ.pi());
            }
            int acL = bWJ.cqn().acL();
            if (acL != 0) {
                a(bWJ, acL);
                if (acL == 28 || acL == 31 || bWJ.cqn().goods == null) {
                    return null;
                }
                bWJ.cqn().goods.goods_style = -1001;
                return null;
            }
            if (this.hPJ.getForum() != null) {
                bWJ.forumId = this.hPJ.getForum().getId();
            }
            if (this.hPJ.bTy() != null) {
                bWJ.threadId = com.baidu.adp.lib.g.b.e(this.hPJ.bTy().getId(), 0L);
            }
            if (this.hPJ != null && this.hPJ.getPage() != null) {
                bWJ.pageNumber = this.hPJ.getPage().adu();
            }
            c(bWJ);
            return bWJ;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hPN || dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bTA()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bTW() && this.hPL) ? 0 : -1;
        } else if (this.hPu.bUE() == null || !this.hPu.bUE().getIsFromMark()) {
            if (this.hPu.bUW() == null || !this.hPu.bUW().bZh()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = arrayList.get(i2);
                    if (mVar instanceof PostData) {
                        PostData postData = (PostData) mVar;
                        if (postData.cqz() == 1 && postData.jji == 0) {
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
                return dVar.bTW() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bTA()) || com.baidu.tbadk.core.util.v.aa(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.bTA(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.m mVar = arrayList.get(i2);
            if (mVar instanceof PostData) {
                PostData postData = (PostData) mVar;
                if (postData.cqz() == 1 && postData.jji == 0) {
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

    private int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || com.baidu.tbadk.core.util.v.aa(dVar.bTA()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bTW()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bTA().get(0) == null || dVar.bTA().get(0).cqz() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bTJ() == null || com.baidu.tbadk.core.util.v.aa(dVar.bTJ().hLr)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bTJ().hLr;
        if (com.baidu.tbadk.core.util.v.aa(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.jjv = true;
                postData.jjk = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.Z(dVar.bTJ().hLs) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).jjk = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).jjk = true;
            }
        }
        com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hLc);
        iVar.hLe = dVar.bTJ().forum_top_list;
        arrayList.add(0, iVar);
        return arrayList;
    }

    private void bxW() {
        if (this.hPu != null && !bxX()) {
            this.hPu.registerListener(this.fNM);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bxX() {
        if (this.hPu == null) {
            return false;
        }
        this.fNK = new ArrayList();
        ArrayList<BdUniqueId> cpM = com.baidu.tieba.tbadkCore.s.cpM();
        if (cpM == null || cpM.size() <= 0) {
            return false;
        }
        int size = cpM.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bME().a(this.hPu.getPageContext(), cpM.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.fNK.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.fNK)) {
            this.mListView.addAdapters(this.fNK);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bTA() == null || dVar.bTB() == null || dVar.bTA().size() == 0 || dVar.bTy() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bTB().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bTA().get(0) == null || dVar.bTA().get(0).cqz() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().adu() != dVar.getPage().adr()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bTA() == null || dVar.bTC() == null || dVar.bTA().size() == 0 || dVar.bTy() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bTC().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bTA().get(0) == null || dVar.bTA().get(0).cqz() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().adu() != dVar.getPage().adr()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bWa() {
        return this.postList;
    }

    public BdUniqueId xS(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hPE == null || !this.hPE.bUx()) {
            this.hPW = bWb();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bWb() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.mListView.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.i.hLb) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bWc() {
        return this.hPW;
    }

    private void bWd() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hPJ != null) {
            ArrayList<PostData> bTA = this.hPJ.bTA();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bTM = this.hPJ.bTM();
            if (bTM != null) {
                int size = bTM.size();
                if (bTA != null && bTA.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bTM.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next = it.next();
                        if (next != null && next.getAdId() != null) {
                            sb.append(next.getAdId());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bTM.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fNI = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bTM.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cqn() != null) {
                            int acL = next3.cqn().acL();
                            if (acL != 0) {
                                a(next3, acL);
                                if (acL != 28 && acL != 31) {
                                    if (next3.cqn().goods != null) {
                                        next3.cqn().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.w.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cqn().apk_name)) {
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
                        com.baidu.tieba.tbadkCore.data.m mVar3 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(sparseArray.keyAt(i));
                        if (mVar3 != null && (mVar2 = (com.baidu.tieba.tbadkCore.data.m) hashMap.put(mVar3.getAdId(), mVar3)) != null) {
                            b(mVar2, 30);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (mVar = (com.baidu.tieba.tbadkCore.data.m) entry.getValue()) != null) {
                            sparseArray.put(mVar.getPosition(), mVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.f.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: b */
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.m mVar4 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.hPJ.getForum() != null) {
                            mVar4.forumId = this.hPJ.getForum().getId();
                        }
                        if (this.hPJ.bTy() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.e(this.hPJ.bTy().getId(), 0L);
                        }
                        if (this.hPJ != null && this.hPJ.getPage() != null) {
                            mVar4.pageNumber = this.hPJ.getPage().adu();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bTA.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hPL) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bTA.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hPu.getPageContext().getContext(), "pb_show_app", "", 1, DpStatConstants.KEY_APP_NAME, mVar4.cqn().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.zL(i);
        com.baidu.tieba.recapp.report.c.cjE().a(c);
        if (mVar != null && mVar.cqn() != null) {
            mVar.cqn().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cqn() != null && mVar.cqn().goods != null && mVar.cqn().goods.goods_style != 1001 && mVar.cqn().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hPJ != null && mVar.cqn() != null) {
            mVar.cqn().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hPJ.getPage() != null) {
                mVar.cqn().advertAppContext.pn = this.hPJ.getPage().adu();
            }
            mVar.cqn().advertAppContext.page = mVar.cqq();
            if (this.hPJ.getForum() != null && (forum = this.hPJ.getForum()) != null) {
                mVar.cqn().advertAppContext.fid = forum.getId();
                mVar.cqn().advertAppContext.bEX = forum.getFirst_class();
                mVar.cqn().advertAppContext.bEY = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cqn().advertAppContext.bEZ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cqn().advertAppContext.extensionInfo = mVar.cqn().ext_info;
            mVar.cqn().advertAppContext.Rm = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hPv.setFromCDN(z);
        if (this.hPB != null && (this.hPB instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hPB).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hPI.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bWe() {
        return this.hPK;
    }

    public void ok(boolean z) {
        this.hPK = z;
    }

    public void ol(boolean z) {
        this.hPL = z;
    }

    public void om(boolean z) {
        this.hPQ = z;
    }

    public void N(View.OnClickListener onClickListener) {
        this.hPT = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cLe = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cmw = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cnB = onLongClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void xT(int i) {
        switch (i) {
            case 1:
                if (this.hPE != null) {
                    this.hPE.pause();
                }
                if (this.hPv != null) {
                    this.hPv.pause();
                    return;
                }
                return;
            case 2:
                if (this.hPE != null) {
                    this.hPE.resume();
                }
                if (this.hPv != null) {
                    this.hPv.resume();
                    return;
                }
                return;
            case 3:
                if (this.hPE != null) {
                    this.hPE.release();
                }
                if (this.hPv != null) {
                    this.hPv.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dH(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.afE())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.ms(postData.afE());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hPV);
        if (this.hPx != null) {
            this.hPx.onDestroy();
        }
        if (this.hPy != null) {
            this.hPy.onDestroy();
        }
        if (this.hPw != null) {
            this.hPw.onDestroy();
        }
    }

    public void ox(boolean z) {
        this.hPN = z;
    }

    public void oy(boolean z) {
        this.hPO = z;
    }

    public void oz(boolean z) {
        this.hPM = z;
    }

    public void oA(boolean z) {
        this.hPP = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bWf() {
        return this.hPw;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.dRB;
    }

    public View bWg() {
        if (this.hPv == null || this.hPv.bWk() == null) {
            return null;
        }
        if (this.hPv.bWk().hRu != null && this.hPv.bWk().hRu.isShown()) {
            return this.hPv.bWk().hRu;
        }
        return this.hPv.bWk().hRt;
    }

    public p bWh() {
        if (this.hPv == null || this.hPv.bWk() == null) {
            return null;
        }
        return this.hPv.bWk();
    }
}
