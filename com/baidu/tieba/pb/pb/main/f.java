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
    private ArrayList<com.baidu.adp.widget.ListView.m> dCk;
    private com.baidu.adp.widget.ListView.a fMK;
    private List<com.baidu.adp.widget.ListView.a> fpZ;
    private PbActivity hoW;
    private o hoX;
    private com.baidu.tieba.pb.pb.main.a.a hoY;
    private ak hoZ;
    private ak hpa;
    private i hpb;
    private com.baidu.tieba.pb.video.a hpc;
    private com.baidu.adp.widget.ListView.a hpd;
    private ag hpe;
    private ah hpf;
    private com.baidu.tieba.pb.pb.a.b hpg;
    private v hph;
    private ae hpi;
    private com.baidu.tieba.pb.pb.a.d hpj;
    private com.baidu.tieba.pb.data.d hpl;
    private boolean hpq;
    private boolean hpr;
    private int hpt;
    private Runnable hpx;
    private int hpz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hpk = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hpm = true;
    private boolean hpn = true;
    private boolean hpo = false;
    private boolean hpp = false;
    private boolean hps = false;
    private String mHostId = null;
    private PostData hpu = null;
    private View.OnClickListener hpv = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h cAB = null;
    private com.baidu.tieba.pb.a.c cbY = null;
    private View.OnLongClickListener cdd = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hpw = new ArrayList();
    private int hpy = -1;
    private CustomMessageListener fgf = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cdT = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cdT();
                Iterator it = cdT.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).as(f.this.hoW);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hpk.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hpg = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cdT);
                f.this.hpw.clear();
                f.this.hpw.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener bZc = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hpl != null && !com.baidu.adp.base.i.aI(f.this.hoW.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener fqa = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.T(f.this.fpZ)) {
                f.this.bmO();
                f.this.a(f.this.hpl, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hpt = 0;
        this.width = -1;
        this.hpz = 0;
        this.hpt = com.baidu.adp.lib.util.l.aO(pbActivity.getPageContext().getPageActivity());
        this.width = this.hpt;
        this.hoW = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bZc);
        this.hpz = com.baidu.adp.lib.util.l.aQ(this.hoW) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hoX = new o(pbActivity, PostData.iGb);
        this.hoX.a(pbActivity);
        this.hoY = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.i.hkM);
        this.hoZ = new ak(pbActivity, com.baidu.tieba.pb.data.h.hkG);
        this.hpa = new ak(pbActivity, com.baidu.tieba.pb.data.h.hkH);
        this.hpb = new i(pbActivity, PostData.iGc);
        this.hpb.a(pbActivity);
        this.fMK = com.baidu.tieba.recapp.r.bWJ().a(pbActivity, AdvertAppInfo.bwr);
        this.hpd = com.baidu.tieba.recapp.r.bWJ().a(pbActivity, AdvertAppInfo.bwv);
        this.hph = new v(pbActivity, com.baidu.tieba.pb.data.a.hjM);
        this.hpi = new ae(pbActivity, com.baidu.tieba.pb.data.g.hkE);
        this.hpe = new ag(pbActivity, ad.hui);
        this.hpf = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bzI);
        this.hpj = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.iGg);
        this.hpc = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.hDN);
        this.hpc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hpl.bIk() != null) {
                    pbActivity.bJq().bMw().bIV();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.hoX);
        this.mAdapters.add(this.hoY);
        this.mAdapters.add(this.hpb);
        this.mAdapters.add(this.hoZ);
        this.mAdapters.add(this.hpa);
        this.mAdapters.add(this.fMK);
        this.mAdapters.add(this.hpd);
        this.mAdapters.add(this.hph);
        this.mAdapters.add(this.hpi);
        this.mAdapters.add(this.hpe);
        this.mAdapters.add(this.hpf);
        this.mAdapters.add(this.hpc);
        this.mAdapters.add(this.hpj);
        this.fgf.setPriority(1);
        this.fgf.setSelfListener(true);
        pbActivity.registerListener(this.fgf);
        bmN();
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
        com.baidu.adp.widget.ListView.m bKr;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hpl != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bHX()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hpl = dVar;
            if (z6) {
                bKw();
                if (dVar != null) {
                    dVar.mZ(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hpl != null && this.hpl.bIb() != null && this.hpl.bIb().size() > 0) {
                this.postList.addAll(this.hpl.bIb());
            }
            if (dVar != null && dVar.bHZ() != null && dVar.bHZ().YR() != null) {
                this.mHostId = dVar.bHZ().YR().getUserId();
            }
            if (this.hoX != null) {
                this.hoX.b(dVar);
                this.hoX.setFromCDN(this.mIsFromCDN);
                this.hoX.wa(this.hpt);
                this.hoX.nc(this.hpm);
                this.hoX.t(this.mCommonClickListener);
                this.hoX.J(this.hpv);
                this.hoX.setOnImageClickListener(this.cAB);
                this.hoX.setOnLongClickListener(this.cdd);
                this.hoX.setTbGestureDetector(this.cbY);
                this.hpb.b(dVar);
                this.hpb.setFromCDN(this.mIsFromCDN);
                this.hpb.setHostId(this.mHostId);
                this.hpb.nc(this.hpm);
                this.hpb.t(this.mCommonClickListener);
                this.hpb.J(this.hpv);
                this.hpb.setOnImageClickListener(this.cAB);
                this.hpb.setOnLongClickListener(this.cdd);
                this.hpb.setTbGestureDetector(this.cbY);
                this.hoY.setOnClickListener(this.mCommonClickListener);
                this.hpj.setOnClickListener(this.mCommonClickListener);
                if (this.hpd != null && (this.hpd instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hpd).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hpk.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.wa(this.hpt);
                        next.nc(this.hpm);
                        next.nd(this.hpn);
                        next.ne(this.hps);
                        next.t(this.mCommonClickListener);
                        next.J(this.hpv);
                        next.setOnImageClickListener(this.cAB);
                        next.setOnLongClickListener(this.cdd);
                    }
                }
                this.hoZ.t(this.mCommonClickListener);
                this.hpa.t(this.mCommonClickListener);
                this.hpe.b(dVar);
                this.hpf.b(dVar);
                this.hph.b(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bIb());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cet() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hpu = postData;
                }
                boolean z7 = false;
                if (!this.hpn && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bIx() && postData.cev() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bIg() != null) {
                    postData = dVar.bIg();
                    z7 = true;
                    z2 = true;
                    if (!this.hpn && dVar.bIx() && postData.cev() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dB(arrayList);
                if (this.hoW.bJP()) {
                    if (dVar.bIb().size() > 0 && (postData2 = dVar.bIb().get(0)) != null && postData2.cet() == 1 && !com.baidu.tbadk.core.util.v.T(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hpl, arrayList, this.hpn);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.hpl.bIc());
                    }
                }
                int c = c(this.hpl, arrayList, this.hpn);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.hpl.bId());
                }
                com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hkG);
                    if (dVar != null && dVar.bHZ() != null) {
                        hVar.hkI = dVar.bHZ().YI();
                    }
                    hVar.isNew = !this.hpn;
                    hVar.hkL = this.hoW.bKb();
                    hVar.sortType = dVar.hkw;
                    if (dVar.hkv != null && dVar.hkv.size() > dVar.hkw) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hkv.size()) {
                                break;
                            } else if (dVar.hkv.get(i3).sort_type.intValue() != dVar.hkw) {
                                i2 = i3 + 1;
                            } else {
                                hVar.hkK = dVar.hkv.get(i3).sort_name;
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
                        ((PostData) mVar).iGL = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hpn);
                }
                if (i < 0 || dVar.bIw() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, i, dVar.bIw());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bKr = bKr()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i + 1, bKr);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bKs = bKs();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bKs != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i4, bKs);
                    }
                }
                this.hoX.nu(!z4);
                boolean z12 = false;
                if (this.hoW.bJa() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hoW.bJa().getPostId())) {
                    z12 = true;
                }
                if (this.hpo && !z12) {
                    arrayList.remove(postData3);
                    this.hpo = false;
                }
                if (dVar.bIw() != null) {
                    if (z5) {
                        dVar.bIw().na(false);
                    } else {
                        dVar.bIw().na(true);
                    }
                }
                if (this.mListView != null) {
                    this.dCk = arrayList;
                    this.mListView.setData(this.dCk);
                }
                if (!z12 && !z && ((this.hpq || this.hpp) && b2 != -1 && !com.baidu.tbadk.core.util.v.T(g) && !this.hpr)) {
                    this.hpx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.hpz);
                            f.this.hpr = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.jH().post(this.hpx);
                }
                if (postData3 == null) {
                    if (this.hpu != null && !this.hpp) {
                        com.baidu.tbadk.core.util.v.a(arrayList, 0, this.hpu);
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

    private com.baidu.adp.widget.ListView.m bKr() {
        PbModel bJa = this.hoW.bJa();
        if (bJa == null) {
            return null;
        }
        String bLE = bJa.bLE();
        if (TextUtils.isEmpty(bLE)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.Cy(bLE);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bKs() {
        if (this.hpl == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bLc = this.hoW.bJa().bLc();
        if (bLc == null) {
            bLc = this.hpl.bIo();
        }
        if (bLc != null) {
            AdvertAppInfo.ILegoAdvert cei = bLc.cei();
            if (cei != null) {
                cei.setAdvertAppInfo(bLc.pR());
            }
            int Xa = bLc.ceh().Xa();
            if (Xa != 0) {
                a(bLc, Xa);
                if (Xa == 28 || Xa == 31 || bLc.ceh().goods == null) {
                    return null;
                }
                bLc.ceh().goods.goods_style = -1001;
                return null;
            }
            if (this.hpl.getForum() != null) {
                bLc.forumId = this.hpl.getForum().getId();
            }
            if (this.hpl.bHZ() != null) {
                bLc.threadId = com.baidu.adp.lib.g.b.d(this.hpl.bHZ().getId(), 0L);
            }
            if (this.hpl != null && this.hpl.getPage() != null) {
                bLc.pageNumber = this.hpl.getPage().XI();
            }
            c(bLc);
            return bLc;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hpp || dVar == null || com.baidu.tbadk.core.util.v.T(dVar.bIb()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bIx() && this.hpn) ? 0 : -1;
        } else if (this.hoW.bJa() == null || !this.hoW.bJa().getIsFromMark()) {
            if (this.hoW.bJq() == null || !this.hoW.bJq().bNw()) {
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
                        if (postData.cet() == 1 && postData.iGI == 0) {
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
                return dVar.bIx() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.T(dVar.bIb()) || com.baidu.tbadk.core.util.v.T(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.bIb(), 0)) == null) {
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
                if (postData.cet() == 1 && postData.iGI == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.T(dVar.bIb()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bIx()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bIb().get(0) == null || dVar.bIb().get(0).cet() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bIk() == null || com.baidu.tbadk.core.util.v.T(dVar.bIk().hkW)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bIk().hkW;
        if (com.baidu.tbadk.core.util.v.T(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.iGV = true;
                postData.iGK = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.S(dVar.bIk().hkX) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).iGK = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).iGK = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.hkH);
        hVar.hkJ = dVar.bIk().forum_top_list;
        arrayList.add(0, hVar);
        return arrayList;
    }

    private void bmN() {
        if (this.hoW != null && !bmO()) {
            this.hoW.registerListener(this.fqa);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bmO() {
        if (this.hoW == null) {
            return false;
        }
        this.fpZ = new ArrayList();
        ArrayList<BdUniqueId> cdG = com.baidu.tieba.tbadkCore.q.cdG();
        if (cdG == null || cdG.size() <= 0) {
            return false;
        }
        int size = cdG.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bBl().a(this.hoW.getPageContext(), cdG.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.fpZ.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.T(this.fpZ)) {
            this.mListView.addAdapters(this.fpZ);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bIb() == null || dVar.bIc() == null || dVar.bIb().size() == 0 || dVar.bHZ() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bIc().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bIb().get(0) == null || dVar.bIb().get(0).cet() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().XI() != dVar.getPage().XF()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bIb() == null || dVar.bId() == null || dVar.bIb().size() == 0 || dVar.bHZ() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bId().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bIb().get(0) == null || dVar.bIb().get(0).cet() != 1) ? -1 : 1;
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

    public ArrayList<PostData> bKt() {
        return this.postList;
    }

    public BdUniqueId wh(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hpg == null || !this.hpg.bIT()) {
            this.hpy = bKu();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bKu() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.mListView.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.h.hkG) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bKv() {
        return this.hpy;
    }

    private void bKw() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hpl != null) {
            ArrayList<PostData> bIb = this.hpl.bIb();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bIn = this.hpl.bIn();
            if (bIn != null) {
                int size = bIn.size();
                if (bIb != null && bIb.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bIn.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bIn.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fpX = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bIn.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.ceh() != null) {
                            int Xa = next3.ceh().Xa();
                            if (Xa != 0) {
                                a(next3, Xa);
                                if (Xa != 28 && Xa != 31) {
                                    if (next3.ceh().goods != null) {
                                        next3.ceh().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.ceh().apk_name)) {
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
                        if (this.hpl.getForum() != null) {
                            mVar4.forumId = this.hpl.getForum().getId();
                        }
                        if (this.hpl.bHZ() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.d(this.hpl.bHZ().getId(), 0L);
                        }
                        if (this.hpl != null && this.hpl.getPage() != null) {
                            mVar4.pageNumber = this.hpl.getPage().XI();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bIb.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hpn) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bIb.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hoW.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", mVar4.ceh().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.xY(i);
        com.baidu.tieba.recapp.report.c.bXE().a(c);
        if (mVar != null && mVar.ceh() != null) {
            mVar.ceh().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.ceh() != null && mVar.ceh().goods != null && mVar.ceh().goods.goods_style != 1001 && mVar.ceh().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hpl != null && mVar.ceh() != null) {
            mVar.ceh().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hpl.getPage() != null) {
                mVar.ceh().advertAppContext.pn = this.hpl.getPage().XI();
            }
            mVar.ceh().advertAppContext.page = mVar.cek();
            if (this.hpl.getForum() != null && (forum = this.hpl.getForum()) != null) {
                mVar.ceh().advertAppContext.fid = forum.getId();
                mVar.ceh().advertAppContext.bwj = forum.getFirst_class();
                mVar.ceh().advertAppContext.bwk = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.ceh().advertAppContext.bwl = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.ceh().advertAppContext.extensionInfo = mVar.ceh().ext_info;
            mVar.ceh().advertAppContext.Tk = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hoX.setFromCDN(z);
        if (this.hpd != null && (this.hpd instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hpd).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hpk.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bKx() {
        return this.hpm;
    }

    public void nc(boolean z) {
        this.hpm = z;
    }

    public void nd(boolean z) {
        this.hpn = z;
    }

    public void ne(boolean z) {
        this.hps = z;
    }

    public void J(View.OnClickListener onClickListener) {
        this.hpv = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cAB = hVar;
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
                if (this.hpg != null) {
                    this.hpg.pause();
                }
                if (this.hoX != null) {
                    this.hoX.pause();
                    return;
                }
                return;
            case 2:
                if (this.hpg != null) {
                    this.hpg.resume();
                }
                if (this.hoX != null) {
                    this.hoX.resume();
                    return;
                }
                return;
            case 3:
                if (this.hpg != null) {
                    this.hpg.release();
                }
                if (this.hoX != null) {
                    this.hoX.release();
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
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hpx);
        if (this.hoZ != null) {
            this.hoZ.onDestroy();
        }
        if (this.hpa != null) {
            this.hpa.onDestroy();
        }
        if (this.hoY != null) {
            this.hoY.onDestroy();
        }
    }

    public void np(boolean z) {
        this.hpp = z;
    }

    public void nq(boolean z) {
        this.hpq = z;
    }

    public void nr(boolean z) {
        this.hpo = z;
    }

    public void ns(boolean z) {
        this.hpr = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bKy() {
        return this.hoY;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.dCk;
    }

    public ThreadForumEnterButtonContainer bKz() {
        if (this.hoX == null || this.hoX.bKD() == null) {
            return null;
        }
        return this.hoX.bKD().hqU;
    }

    public p bKA() {
        if (this.hoX == null || this.hoX.bKD() == null) {
            return null;
        }
        return this.hoX.bKD();
    }
}
