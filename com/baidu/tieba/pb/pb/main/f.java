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
    private ArrayList<com.baidu.adp.widget.ListView.m> dCo;
    private com.baidu.adp.widget.ListView.a fML;
    private List<com.baidu.adp.widget.ListView.a> fqa;
    private int hpA;
    private Runnable hpE;
    private int hpG;
    private PbActivity hpd;
    private o hpe;
    private com.baidu.tieba.pb.pb.main.a.a hpf;
    private ak hpg;
    private ak hph;
    private i hpi;
    private com.baidu.tieba.pb.video.a hpj;
    private com.baidu.adp.widget.ListView.a hpk;
    private ag hpl;
    private ah hpm;
    private com.baidu.tieba.pb.pb.a.b hpn;
    private v hpo;
    private ae hpp;
    private com.baidu.tieba.pb.pb.a.d hpq;
    private com.baidu.tieba.pb.data.d hps;
    private boolean hpx;
    private boolean hpy;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hpr = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hpt = true;
    private boolean hpu = true;
    private boolean hpv = false;
    private boolean hpw = false;
    private boolean hpz = false;
    private String mHostId = null;
    private PostData hpB = null;
    private View.OnClickListener hpC = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h cAE = null;
    private com.baidu.tieba.pb.a.c cbY = null;
    private View.OnLongClickListener cdd = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hpD = new ArrayList();
    private int hpF = -1;
    private CustomMessageListener fgg = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cdR = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cdR();
                Iterator it = cdR.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).au(f.this.hpd);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hpr.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hpn = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cdR);
                f.this.hpD.clear();
                f.this.hpD.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener bZb = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hps != null && !com.baidu.adp.base.i.aI(f.this.hpd.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener fqb = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.T(f.this.fqa)) {
                f.this.bmP();
                f.this.a(f.this.hps, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hpA = 0;
        this.width = -1;
        this.hpG = 0;
        this.hpA = com.baidu.adp.lib.util.l.aO(pbActivity.getPageContext().getPageActivity());
        this.width = this.hpA;
        this.hpd = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bZb);
        this.hpG = com.baidu.adp.lib.util.l.aQ(this.hpd) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hpe = new o(pbActivity, PostData.iGj);
        this.hpe.a(pbActivity);
        this.hpf = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.i.hkN);
        this.hpg = new ak(pbActivity, com.baidu.tieba.pb.data.h.hkH);
        this.hph = new ak(pbActivity, com.baidu.tieba.pb.data.h.hkI);
        this.hpi = new i(pbActivity, PostData.iGk);
        this.hpi.a(pbActivity);
        this.fML = com.baidu.tieba.recapp.r.bWH().a(pbActivity, AdvertAppInfo.bwp);
        this.hpk = com.baidu.tieba.recapp.r.bWH().a(pbActivity, AdvertAppInfo.bwt);
        this.hpo = new v(pbActivity, com.baidu.tieba.pb.data.a.hjN);
        this.hpp = new ae(pbActivity, com.baidu.tieba.pb.data.g.hkF);
        this.hpl = new ag(pbActivity, ad.hup);
        this.hpm = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bzG);
        this.hpq = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.iGo);
        this.hpj = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.hDT);
        this.hpj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hps.bIl() != null) {
                    pbActivity.bJr().bMx().bIW();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.hpe);
        this.mAdapters.add(this.hpf);
        this.mAdapters.add(this.hpi);
        this.mAdapters.add(this.hpg);
        this.mAdapters.add(this.hph);
        this.mAdapters.add(this.fML);
        this.mAdapters.add(this.hpk);
        this.mAdapters.add(this.hpo);
        this.mAdapters.add(this.hpp);
        this.mAdapters.add(this.hpl);
        this.mAdapters.add(this.hpm);
        this.mAdapters.add(this.hpj);
        this.mAdapters.add(this.hpq);
        this.fgg.setPriority(1);
        this.fgg.setSelfListener(true);
        pbActivity.registerListener(this.fgg);
        bmO();
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
        com.baidu.adp.widget.ListView.m bKs;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hps != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bHY()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hps = dVar;
            if (z6) {
                bKx();
                if (dVar != null) {
                    dVar.mZ(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hps != null && this.hps.bIc() != null && this.hps.bIc().size() > 0) {
                this.postList.addAll(this.hps.bIc());
            }
            if (dVar != null && dVar.bIa() != null && dVar.bIa().YR() != null) {
                this.mHostId = dVar.bIa().YR().getUserId();
            }
            if (this.hpe != null) {
                this.hpe.b(dVar);
                this.hpe.setFromCDN(this.mIsFromCDN);
                this.hpe.wa(this.hpA);
                this.hpe.nc(this.hpt);
                this.hpe.t(this.mCommonClickListener);
                this.hpe.J(this.hpC);
                this.hpe.setOnImageClickListener(this.cAE);
                this.hpe.setOnLongClickListener(this.cdd);
                this.hpe.setTbGestureDetector(this.cbY);
                this.hpi.b(dVar);
                this.hpi.setFromCDN(this.mIsFromCDN);
                this.hpi.setHostId(this.mHostId);
                this.hpi.nc(this.hpt);
                this.hpi.t(this.mCommonClickListener);
                this.hpi.J(this.hpC);
                this.hpi.setOnImageClickListener(this.cAE);
                this.hpi.setOnLongClickListener(this.cdd);
                this.hpi.setTbGestureDetector(this.cbY);
                this.hpf.setOnClickListener(this.mCommonClickListener);
                this.hpq.setOnClickListener(this.mCommonClickListener);
                if (this.hpk != null && (this.hpk instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hpk).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hpr.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.wa(this.hpA);
                        next.nc(this.hpt);
                        next.nd(this.hpu);
                        next.ne(this.hpz);
                        next.t(this.mCommonClickListener);
                        next.J(this.hpC);
                        next.setOnImageClickListener(this.cAE);
                        next.setOnLongClickListener(this.cdd);
                    }
                }
                this.hpg.t(this.mCommonClickListener);
                this.hph.t(this.mCommonClickListener);
                this.hpl.b(dVar);
                this.hpm.b(dVar);
                this.hpo.b(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bIc());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cer() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hpB = postData;
                }
                boolean z7 = false;
                if (!this.hpu && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bIy() && postData.cet() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bIh() != null) {
                    postData = dVar.bIh();
                    z7 = true;
                    z2 = true;
                    if (!this.hpu && dVar.bIy() && postData.cet() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dB(arrayList);
                if (this.hpd.bJQ()) {
                    if (dVar.bIc().size() > 0 && (postData2 = dVar.bIc().get(0)) != null && postData2.cer() == 1 && !com.baidu.tbadk.core.util.v.T(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hps, arrayList, this.hpu);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.hps.bId());
                    }
                }
                int c = c(this.hps, arrayList, this.hpu);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.hps.bIe());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hkH);
                    if (dVar != null && dVar.bIa() != null) {
                        hVar.hkJ = dVar.bIa().YI();
                    }
                    hVar.isNew = !this.hpu;
                    hVar.hkM = this.hpd.bKc();
                    hVar.sortType = dVar.hkx;
                    if (dVar.hkw != null && dVar.hkw.size() > dVar.hkx) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hkw.size()) {
                                break;
                            } else if (dVar.hkw.get(i3).sort_type.intValue() != dVar.hkx) {
                                i2 = i3 + 1;
                            } else {
                                hVar.hkL = dVar.hkw.get(i3).sort_name;
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
                        ((PostData) mVar).iGT = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hpu);
                }
                if (i < 0 || dVar.bIx() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, i, dVar.bIx());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bKs = bKs()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i + 1, bKs);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bKt = bKt();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bKt != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i4, bKt);
                    }
                }
                this.hpe.nu(!z4);
                boolean z12 = false;
                if (this.hpd.bJb() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hpd.bJb().getPostId())) {
                    z12 = true;
                }
                if (this.hpv && !z12) {
                    arrayList.remove(postData3);
                    this.hpv = false;
                }
                if (dVar.bIx() != null) {
                    if (z5) {
                        dVar.bIx().na(false);
                    } else {
                        dVar.bIx().na(true);
                    }
                }
                if (this.mListView != null) {
                    this.dCo = arrayList;
                    this.mListView.setData(this.dCo);
                }
                if (!z12 && !z && ((this.hpx || this.hpw) && b2 != -1 && !com.baidu.tbadk.core.util.v.T(g) && !this.hpy)) {
                    this.hpE = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.hpG);
                            f.this.hpy = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.jH().post(this.hpE);
                }
                if (postData3 == null) {
                    if (this.hpB != null && !this.hpw) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, this.hpB);
                    } else {
                        PostData postData4 = new PostData();
                        postData4.zu(1);
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

    private com.baidu.adp.widget.ListView.m bKs() {
        PbModel bJb = this.hpd.bJb();
        if (bJb == null) {
            return null;
        }
        String bLF = bJb.bLF();
        if (TextUtils.isEmpty(bLF)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.CA(bLF);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bKt() {
        if (this.hps == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bLd = this.hpd.bJb().bLd();
        if (bLd == null) {
            bLd = this.hps.bIp();
        }
        if (bLd != null) {
            AdvertAppInfo.ILegoAdvert ceg = bLd.ceg();
            if (ceg != null) {
                ceg.setAdvertAppInfo(bLd.pR());
            }
            int Xa = bLd.cef().Xa();
            if (Xa != 0) {
                a(bLd, Xa);
                if (Xa == 28 || Xa == 31 || bLd.cef().goods == null) {
                    return null;
                }
                bLd.cef().goods.goods_style = -1001;
                return null;
            }
            if (this.hps.getForum() != null) {
                bLd.forumId = this.hps.getForum().getId();
            }
            if (this.hps.bIa() != null) {
                bLd.threadId = com.baidu.adp.lib.g.b.d(this.hps.bIa().getId(), 0L);
            }
            if (this.hps != null && this.hps.getPage() != null) {
                bLd.pageNumber = this.hps.getPage().XI();
            }
            c(bLd);
            return bLd;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hpw || dVar == null || com.baidu.tbadk.core.util.v.T(dVar.bIc()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bIy() && this.hpu) ? 0 : -1;
        } else if (this.hpd.bJb() == null || !this.hpd.bJb().getIsFromMark()) {
            if (this.hpd.bJr() == null || !this.hpd.bJr().bNw()) {
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
                        if (postData.cer() == 1 && postData.iGQ == 0) {
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
                return dVar.bIy() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.T(dVar.bIc()) || com.baidu.tbadk.core.util.v.T(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.bIc(), 0)) == null) {
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
                if (postData.cer() == 1 && postData.iGQ == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.T(dVar.bIc()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bIy()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bIc().get(0) == null || dVar.bIc().get(0).cer() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bIl() == null || com.baidu.tbadk.core.util.v.T(dVar.bIl().hkX)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bIl().hkX;
        if (com.baidu.tbadk.core.util.v.T(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.iHd = true;
                postData.iGS = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.S(dVar.bIl().hkY) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).iGS = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).iGS = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hkI);
        hVar.hkK = dVar.bIl().forum_top_list;
        arrayList.add(0, hVar);
        return arrayList;
    }

    private void bmO() {
        if (this.hpd != null && !bmP()) {
            this.hpd.registerListener(this.fqb);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bmP() {
        if (this.hpd == null) {
            return false;
        }
        this.fqa = new ArrayList();
        ArrayList<BdUniqueId> cdE = com.baidu.tieba.tbadkCore.q.cdE();
        if (cdE == null || cdE.size() <= 0) {
            return false;
        }
        int size = cdE.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bBm().a(this.hpd.getPageContext(), cdE.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.fqa.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fqa)) {
            this.mListView.addAdapters(this.fqa);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bIc() == null || dVar.bId() == null || dVar.bIc().size() == 0 || dVar.bIa() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bId().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bIc().get(0) == null || dVar.bIc().get(0).cer() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().XI() != dVar.getPage().XF()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bIc() == null || dVar.bIe() == null || dVar.bIc().size() == 0 || dVar.bIa() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bIe().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bIc().get(0) == null || dVar.bIc().get(0).cer() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().XI() != dVar.getPage().XF()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bKu() {
        return this.postList;
    }

    public BdUniqueId wh(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hpn == null || !this.hpn.bIU()) {
            this.hpF = bKv();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bKv() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.mListView.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.h.hkH) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bKw() {
        return this.hpF;
    }

    private void bKx() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hps != null) {
            ArrayList<PostData> bIc = this.hps.bIc();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bIo = this.hps.bIo();
            if (bIo != null) {
                int size = bIo.size();
                if (bIc != null && bIc.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bIo.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bIo.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fpY = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bIo.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cef() != null) {
                            int Xa = next3.cef().Xa();
                            if (Xa != 0) {
                                a(next3, Xa);
                                if (Xa != 28 && Xa != 31) {
                                    if (next3.cef().goods != null) {
                                        next3.cef().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cef().apk_name)) {
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
                        if (this.hps.getForum() != null) {
                            mVar4.forumId = this.hps.getForum().getId();
                        }
                        if (this.hps.bIa() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.d(this.hps.bIa().getId(), 0L);
                        }
                        if (this.hps != null && this.hps.getPage() != null) {
                            mVar4.pageNumber = this.hps.getPage().XI();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bIc.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hpu) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bIc.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hpd.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", mVar4.cef().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.xY(i);
        com.baidu.tieba.recapp.report.c.bXC().a(c);
        if (mVar != null && mVar.cef() != null) {
            mVar.cef().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cef() != null && mVar.cef().goods != null && mVar.cef().goods.goods_style != 1001 && mVar.cef().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hps != null && mVar.cef() != null) {
            mVar.cef().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hps.getPage() != null) {
                mVar.cef().advertAppContext.pn = this.hps.getPage().XI();
            }
            mVar.cef().advertAppContext.page = mVar.cei();
            if (this.hps.getForum() != null && (forum = this.hps.getForum()) != null) {
                mVar.cef().advertAppContext.fid = forum.getId();
                mVar.cef().advertAppContext.bwh = forum.getFirst_class();
                mVar.cef().advertAppContext.bwi = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cef().advertAppContext.bwj = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cef().advertAppContext.extensionInfo = mVar.cef().ext_info;
            mVar.cef().advertAppContext.Tj = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hpe.setFromCDN(z);
        if (this.hpk != null && (this.hpk instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hpk).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hpr.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bKy() {
        return this.hpt;
    }

    public void nc(boolean z) {
        this.hpt = z;
    }

    public void nd(boolean z) {
        this.hpu = z;
    }

    public void ne(boolean z) {
        this.hpz = z;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpC = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cbY = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.cdd = onLongClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void wi(int i) {
        switch (i) {
            case 1:
                if (this.hpn != null) {
                    this.hpn.pause();
                }
                if (this.hpe != null) {
                    this.hpe.pause();
                    return;
                }
                return;
            case 2:
                if (this.hpn != null) {
                    this.hpn.resume();
                }
                if (this.hpe != null) {
                    this.hpe.resume();
                    return;
                }
                return;
            case 3:
                if (this.hpn != null) {
                    this.hpn.release();
                }
                if (this.hpe != null) {
                    this.hpe.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dB(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.ZT())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.la(postData.ZT());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hpE);
        if (this.hpg != null) {
            this.hpg.onDestroy();
        }
        if (this.hph != null) {
            this.hph.onDestroy();
        }
        if (this.hpf != null) {
            this.hpf.onDestroy();
        }
    }

    public void np(boolean z) {
        this.hpw = z;
    }

    public void nq(boolean z) {
        this.hpx = z;
    }

    public void nr(boolean z) {
        this.hpv = z;
    }

    public void ns(boolean z) {
        this.hpy = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bKz() {
        return this.hpf;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.dCo;
    }

    public ThreadForumEnterButtonContainer bKA() {
        if (this.hpe == null || this.hpe.bKE() == null) {
            return null;
        }
        return this.hpe.bKE().hrb;
    }

    public p bKB() {
        if (this.hpe == null || this.hpe.bKE() == null) {
            return null;
        }
        return this.hpe.bKE();
    }
}
