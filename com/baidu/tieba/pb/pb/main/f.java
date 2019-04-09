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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
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
    private ArrayList<com.baidu.adp.widget.ListView.m> dBB;
    private com.baidu.adp.widget.ListView.a fMy;
    private List<com.baidu.adp.widget.ListView.a> fpL;
    private PbActivity hoK;
    private o hoL;
    private com.baidu.tieba.pb.pb.main.a.a hoM;
    private ak hoN;
    private ak hoO;
    private i hoP;
    private com.baidu.tieba.pb.video.a hoQ;
    private com.baidu.adp.widget.ListView.a hoR;
    private ag hoS;
    private ah hoT;
    private com.baidu.tieba.pb.pb.a.b hoU;
    private v hoV;
    private ae hoW;
    private com.baidu.tieba.pb.pb.a.d hoX;
    private com.baidu.tieba.pb.data.d hoZ;
    private boolean hpe;
    private boolean hpf;
    private int hph;
    private Runnable hpl;
    private int hpn;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hoY = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hpa = true;
    private boolean hpb = true;
    private boolean hpc = false;
    private boolean hpd = false;
    private boolean hpg = false;
    private String mHostId = null;
    private PostData hpi = null;
    private View.OnClickListener hpj = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h cAE = null;
    private com.baidu.tieba.pb.a.c ccb = null;
    private View.OnLongClickListener cdg = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hpk = new ArrayList();
    private int hpm = -1;
    private CustomMessageListener ffS = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cdP = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cdP();
                Iterator it = cdP.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).as(f.this.hoK);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hoY.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hoU = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cdP);
                f.this.hpk.clear();
                f.this.hpk.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener bZf = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hoZ != null && !com.baidu.adp.base.i.aI(f.this.hoK.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener fpM = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.T(f.this.fpL)) {
                f.this.bmL();
                f.this.a(f.this.hoZ, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hph = 0;
        this.width = -1;
        this.hpn = 0;
        this.hph = com.baidu.adp.lib.util.l.aO(pbActivity.getPageContext().getPageActivity());
        this.width = this.hph;
        this.hoK = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bZf);
        this.hpn = com.baidu.adp.lib.util.l.aQ(this.hoK) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hoL = new o(pbActivity, PostData.iFM);
        this.hoL.a(pbActivity);
        this.hoM = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.i.hkA);
        this.hoN = new ak(pbActivity, com.baidu.tieba.pb.data.h.hku);
        this.hoO = new ak(pbActivity, com.baidu.tieba.pb.data.h.hkv);
        this.hoP = new i(pbActivity, PostData.iFN);
        this.hoP.a(pbActivity);
        this.fMy = com.baidu.tieba.recapp.r.bWF().a(pbActivity, AdvertAppInfo.bwv);
        this.hoR = com.baidu.tieba.recapp.r.bWF().a(pbActivity, AdvertAppInfo.bwz);
        this.hoV = new v(pbActivity, com.baidu.tieba.pb.data.a.hjA);
        this.hoW = new ae(pbActivity, com.baidu.tieba.pb.data.g.hks);
        this.hoS = new ag(pbActivity, ad.htW);
        this.hoT = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bzM);
        this.hoX = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.iFR);
        this.hoQ = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.hDA);
        this.hoQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hoZ.bIh() != null) {
                    pbActivity.bJn().bMt().bIS();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.hoL);
        this.mAdapters.add(this.hoM);
        this.mAdapters.add(this.hoP);
        this.mAdapters.add(this.hoN);
        this.mAdapters.add(this.hoO);
        this.mAdapters.add(this.fMy);
        this.mAdapters.add(this.hoR);
        this.mAdapters.add(this.hoV);
        this.mAdapters.add(this.hoW);
        this.mAdapters.add(this.hoS);
        this.mAdapters.add(this.hoT);
        this.mAdapters.add(this.hoQ);
        this.mAdapters.add(this.hoX);
        this.ffS.setPriority(1);
        this.ffS.setSelfListener(true);
        pbActivity.registerListener(this.ffS);
        bmK();
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
        com.baidu.adp.widget.ListView.m bKo;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hoZ != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bHU()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hoZ = dVar;
            if (z6) {
                bKt();
                if (dVar != null) {
                    dVar.mZ(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hoZ != null && this.hoZ.bHY() != null && this.hoZ.bHY().size() > 0) {
                this.postList.addAll(this.hoZ.bHY());
            }
            if (dVar != null && dVar.bHW() != null && dVar.bHW().YO() != null) {
                this.mHostId = dVar.bHW().YO().getUserId();
            }
            if (this.hoL != null) {
                this.hoL.b(dVar);
                this.hoL.setFromCDN(this.mIsFromCDN);
                this.hoL.vW(this.hph);
                this.hoL.nc(this.hpa);
                this.hoL.t(this.mCommonClickListener);
                this.hoL.J(this.hpj);
                this.hoL.setOnImageClickListener(this.cAE);
                this.hoL.setOnLongClickListener(this.cdg);
                this.hoL.setTbGestureDetector(this.ccb);
                this.hoP.b(dVar);
                this.hoP.setFromCDN(this.mIsFromCDN);
                this.hoP.setHostId(this.mHostId);
                this.hoP.nc(this.hpa);
                this.hoP.t(this.mCommonClickListener);
                this.hoP.J(this.hpj);
                this.hoP.setOnImageClickListener(this.cAE);
                this.hoP.setOnLongClickListener(this.cdg);
                this.hoP.setTbGestureDetector(this.ccb);
                this.hoM.setOnClickListener(this.mCommonClickListener);
                this.hoX.setOnClickListener(this.mCommonClickListener);
                if (this.hoR != null && (this.hoR instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hoR).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hoY.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.vW(this.hph);
                        next.nc(this.hpa);
                        next.nd(this.hpb);
                        next.ne(this.hpg);
                        next.t(this.mCommonClickListener);
                        next.J(this.hpj);
                        next.setOnImageClickListener(this.cAE);
                        next.setOnLongClickListener(this.cdg);
                    }
                }
                this.hoN.t(this.mCommonClickListener);
                this.hoO.t(this.mCommonClickListener);
                this.hoS.b(dVar);
                this.hoT.b(dVar);
                this.hoV.b(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bHY());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cep() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hpi = postData;
                }
                boolean z7 = false;
                if (!this.hpb && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bIu() && postData.cer() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bId() != null) {
                    postData = dVar.bId();
                    z7 = true;
                    z2 = true;
                    if (!this.hpb && dVar.bIu() && postData.cer() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dy(arrayList);
                if (this.hoK.bJM()) {
                    if (dVar.bHY().size() > 0 && (postData2 = dVar.bHY().get(0)) != null && postData2.cep() == 1 && !com.baidu.tbadk.core.util.v.T(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hoZ, arrayList, this.hpb);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.hoZ.bHZ());
                    }
                }
                int c = c(this.hoZ, arrayList, this.hpb);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.hoZ.bIa());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hku);
                    if (dVar != null && dVar.bHW() != null) {
                        hVar.hkw = dVar.bHW().YF();
                    }
                    hVar.isNew = !this.hpb;
                    hVar.hkz = this.hoK.bJY();
                    hVar.sortType = dVar.hkk;
                    if (dVar.hkj != null && dVar.hkj.size() > dVar.hkk) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hkj.size()) {
                                break;
                            } else if (dVar.hkj.get(i3).sort_type.intValue() != dVar.hkk) {
                                i2 = i3 + 1;
                            } else {
                                hVar.hky = dVar.hkj.get(i3).sort_name;
                                break;
                            }
                        }
                    }
                    com.baidu.tbadk.core.util.v.a(arrayList, c2, hVar);
                    z10 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.m> g = g(dVar);
                if (com.baidu.tbadk.core.util.v.T(g) || b2 < 0) {
                    z3 = z10;
                } else {
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, b2);
                    if (mVar instanceof PostData) {
                        ((PostData) mVar).iGw = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hpb);
                }
                if (i < 0 || dVar.bIt() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, i, dVar.bIt());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bKo = bKo()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i + 1, bKo);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bKp = bKp();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bKp != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i4, bKp);
                    }
                }
                this.hoL.nu(!z4);
                boolean z12 = false;
                if (this.hoK.bIX() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hoK.bIX().getPostId())) {
                    z12 = true;
                }
                if (this.hpc && !z12) {
                    arrayList.remove(postData3);
                    this.hpc = false;
                }
                if (dVar.bIt() != null) {
                    if (z5) {
                        dVar.bIt().na(false);
                    } else {
                        dVar.bIt().na(true);
                    }
                }
                if (this.mListView != null) {
                    this.dBB = arrayList;
                    this.mListView.setData(this.dBB);
                }
                if (!z12 && !z && ((this.hpe || this.hpd) && b2 != -1 && !com.baidu.tbadk.core.util.v.T(g) && !this.hpf)) {
                    this.hpl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.hpn);
                            f.this.hpf = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.jH().post(this.hpl);
                }
                if (postData3 == null) {
                    if (this.hpi != null && !this.hpd) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, this.hpi);
                    } else {
                        PostData postData4 = new PostData();
                        postData4.zq(1);
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

    private com.baidu.adp.widget.ListView.m bKo() {
        PbModel bIX = this.hoK.bIX();
        if (bIX == null) {
            return null;
        }
        String bLB = bIX.bLB();
        if (TextUtils.isEmpty(bLB)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.Cx(bLB);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bKp() {
        if (this.hoZ == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bKZ = this.hoK.bIX().bKZ();
        if (bKZ == null) {
            bKZ = this.hoZ.bIl();
        }
        if (bKZ != null) {
            AdvertAppInfo.ILegoAdvert cee = bKZ.cee();
            if (cee != null) {
                cee.setAdvertAppInfo(bKZ.pR());
            }
            int WX = bKZ.ced().WX();
            if (WX != 0) {
                a(bKZ, WX);
                if (WX == 28 || WX == 31 || bKZ.ced().goods == null) {
                    return null;
                }
                bKZ.ced().goods.goods_style = -1001;
                return null;
            }
            if (this.hoZ.getForum() != null) {
                bKZ.forumId = this.hoZ.getForum().getId();
            }
            if (this.hoZ.bHW() != null) {
                bKZ.threadId = com.baidu.adp.lib.g.b.d(this.hoZ.bHW().getId(), 0L);
            }
            if (this.hoZ != null && this.hoZ.getPage() != null) {
                bKZ.pageNumber = this.hoZ.getPage().XF();
            }
            c(bKZ);
            return bKZ;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hpd || dVar == null || com.baidu.tbadk.core.util.v.T(dVar.bHY()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bIu() && this.hpb) ? 0 : -1;
        } else if (this.hoK.bIX() == null || !this.hoK.bIX().getIsFromMark()) {
            if (this.hoK.bJn() == null || !this.hoK.bJn().bNt()) {
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
                        if (postData.cep() == 1 && postData.iGt == 0) {
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
                return dVar.bIu() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.T(dVar.bHY()) || com.baidu.tbadk.core.util.v.T(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.bHY(), 0)) == null) {
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
                if (postData.cep() == 1 && postData.iGt == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.T(dVar.bHY()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bIu()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bHY().get(0) == null || dVar.bHY().get(0).cep() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bIh() == null || com.baidu.tbadk.core.util.v.T(dVar.bIh().hkK)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bIh().hkK;
        if (com.baidu.tbadk.core.util.v.T(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.iGG = true;
                postData.iGv = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.S(dVar.bIh().hkL) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).iGv = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).iGv = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hkv);
        hVar.hkx = dVar.bIh().forum_top_list;
        arrayList.add(0, hVar);
        return arrayList;
    }

    private void bmK() {
        if (this.hoK != null && !bmL()) {
            this.hoK.registerListener(this.fpM);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bmL() {
        if (this.hoK == null) {
            return false;
        }
        this.fpL = new ArrayList();
        ArrayList<BdUniqueId> cdC = com.baidu.tieba.tbadkCore.q.cdC();
        if (cdC == null || cdC.size() <= 0) {
            return false;
        }
        int size = cdC.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bBi().a(this.hoK.getPageContext(), cdC.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.fpL.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fpL)) {
            this.mListView.addAdapters(this.fpL);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bHY() == null || dVar.bHZ() == null || dVar.bHY().size() == 0 || dVar.bHW() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bHZ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bHY().get(0) == null || dVar.bHY().get(0).cep() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().XF() != dVar.getPage().XC()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bHY() == null || dVar.bIa() == null || dVar.bHY().size() == 0 || dVar.bHW() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bIa().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bHY().get(0) == null || dVar.bHY().get(0).cep() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().XF() != dVar.getPage().XC()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bKq() {
        return this.postList;
    }

    public BdUniqueId wd(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hoU == null || !this.hoU.bIQ()) {
            this.hpm = bKr();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bKr() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.mListView.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.h.hku) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bKs() {
        return this.hpm;
    }

    private void bKt() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hoZ != null) {
            ArrayList<PostData> bHY = this.hoZ.bHY();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bIk = this.hoZ.bIk();
            if (bIk != null) {
                int size = bIk.size();
                if (bHY != null && bHY.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bIk.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bIk.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fpJ = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bIk.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.ced() != null) {
                            int WX = next3.ced().WX();
                            if (WX != 0) {
                                a(next3, WX);
                                if (WX != 28 && WX != 31) {
                                    if (next3.ced().goods != null) {
                                        next3.ced().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.ced().apk_name)) {
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
                        if (this.hoZ.getForum() != null) {
                            mVar4.forumId = this.hoZ.getForum().getId();
                        }
                        if (this.hoZ.bHW() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.d(this.hoZ.bHW().getId(), 0L);
                        }
                        if (this.hoZ != null && this.hoZ.getPage() != null) {
                            mVar4.pageNumber = this.hoZ.getPage().XF();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bHY.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hpb) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bHY.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hoK.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", mVar4.ced().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.xU(i);
        com.baidu.tieba.recapp.report.c.bXA().a(c);
        if (mVar != null && mVar.ced() != null) {
            mVar.ced().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.ced() != null && mVar.ced().goods != null && mVar.ced().goods.goods_style != 1001 && mVar.ced().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hoZ != null && mVar.ced() != null) {
            mVar.ced().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hoZ.getPage() != null) {
                mVar.ced().advertAppContext.pn = this.hoZ.getPage().XF();
            }
            mVar.ced().advertAppContext.page = mVar.ceg();
            if (this.hoZ.getForum() != null && (forum = this.hoZ.getForum()) != null) {
                mVar.ced().advertAppContext.fid = forum.getId();
                mVar.ced().advertAppContext.bwn = forum.getFirst_class();
                mVar.ced().advertAppContext.bwo = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.ced().advertAppContext.bwp = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.ced().advertAppContext.extensionInfo = mVar.ced().ext_info;
            mVar.ced().advertAppContext.Tl = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hoL.setFromCDN(z);
        if (this.hoR != null && (this.hoR instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hoR).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hoY.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bKu() {
        return this.hpa;
    }

    public void nc(boolean z) {
        this.hpa = z;
    }

    public void nd(boolean z) {
        this.hpb = z;
    }

    public void ne(boolean z) {
        this.hpg = z;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpj = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ccb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdg = onLongClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void we(int i) {
        switch (i) {
            case 1:
                if (this.hoU != null) {
                    this.hoU.pause();
                }
                if (this.hoL != null) {
                    this.hoL.pause();
                    return;
                }
                return;
            case 2:
                if (this.hoU != null) {
                    this.hoU.resume();
                }
                if (this.hoL != null) {
                    this.hoL.resume();
                    return;
                }
                return;
            case 3:
                if (this.hoU != null) {
                    this.hoU.release();
                }
                if (this.hoL != null) {
                    this.hoL.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dy(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.ZQ())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.lb(postData.ZQ());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hpl);
        if (this.hoN != null) {
            this.hoN.onDestroy();
        }
        if (this.hoO != null) {
            this.hoO.onDestroy();
        }
        if (this.hoM != null) {
            this.hoM.onDestroy();
        }
    }

    public void np(boolean z) {
        this.hpd = z;
    }

    public void nq(boolean z) {
        this.hpe = z;
    }

    public void nr(boolean z) {
        this.hpc = z;
    }

    public void ns(boolean z) {
        this.hpf = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bKv() {
        return this.hoM;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.dBB;
    }

    public ThreadForumEnterButtonContainer bKw() {
        if (this.hoL == null || this.hoL.bKA() == null) {
            return null;
        }
        return this.hoL.bKA().hqI;
    }

    public p bKx() {
        if (this.hoL == null || this.hoL.bKA() == null) {
            return null;
        }
        return this.hoL.bKA();
    }
}
