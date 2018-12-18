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
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
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
/* loaded from: classes6.dex */
public class f {
    private List<com.baidu.adp.widget.ListView.a> dPH;
    private com.baidu.adp.widget.ListView.a dYq;
    private com.baidu.adp.widget.ListView.a dYr;
    private PbActivity fUU;
    private o fUV;
    private com.baidu.tieba.pb.pb.main.a.a fUW;
    private ak fUX;
    private ak fUY;
    private i fUZ;
    private com.baidu.tieba.pb.video.a fVa;
    private ag fVb;
    private ah fVc;
    private com.baidu.tieba.pb.pb.a.b fVd;
    private v fVe;
    private ae fVf;
    private com.baidu.tieba.pb.pb.a.d fVg;
    private ao fVh;
    private com.baidu.tieba.pb.data.d fVj;
    private boolean fVo;
    private boolean fVp;
    private int fVr;
    private Runnable fVu;
    private int fVw;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fVi = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fVk = true;
    private boolean fVl = true;
    private boolean fVm = false;
    private boolean fVn = false;
    private boolean fVq = false;
    private String mHostId = null;
    private View.OnClickListener fVs = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h brM = null;
    private com.baidu.tieba.pb.a.c brN = null;
    private View.OnLongClickListener aTo = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fVt = new ArrayList();
    private int fVv = -1;
    private CustomMessageListener dOJ = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bCR = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bCR();
                Iterator it = bCR.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).aq(f.this.fUU);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fVi.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fVd = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bCR);
                f.this.fVt.clear();
                f.this.fVt.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener aPU = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fVj != null && !com.baidu.adp.base.i.aI(f.this.fUU.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dPQ = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.I(f.this.dPH)) {
                f.this.aDK();
                f.this.a(f.this.fVj, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fVr = 0;
        this.width = -1;
        this.fVw = 0;
        this.fVr = com.baidu.adp.lib.util.l.aO(pbActivity.getPageContext().getPageActivity());
        this.width = this.fVr;
        this.fUU = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aPU);
        this.fVw = com.baidu.adp.lib.util.l.aQ(this.fUU) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fUV = new o(pbActivity, PostData.hlm);
        this.fUV.a(pbActivity);
        this.fUW = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.i.fQK);
        this.fUX = new ak(pbActivity, com.baidu.tieba.pb.data.h.fQE);
        this.fUY = new ak(pbActivity, com.baidu.tieba.pb.data.h.fQF);
        this.fUZ = new i(pbActivity, PostData.hln);
        this.fUZ.a(pbActivity);
        this.dYq = com.baidu.tieba.recapp.r.buy().a(pbActivity, AdvertAppInfo.apd);
        this.dYr = com.baidu.tieba.recapp.r.buy().a(pbActivity, AdvertAppInfo.aph);
        this.fVe = new v(pbActivity, com.baidu.tieba.pb.data.a.fPJ);
        this.fVf = new ae(pbActivity, com.baidu.tieba.pb.data.g.fQD);
        this.fVb = new ag(pbActivity, ad.gao);
        this.fVc = new ah(pbActivity, com.baidu.tbadk.core.data.ao.asr);
        this.fVg = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.hlr);
        this.fVh = new ao(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fVa = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.gjN);
        this.fVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fVj.bgu() != null) {
                    pbActivity.bhE().bkH().bhi();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fUV);
        this.mAdapters.add(this.fUW);
        this.mAdapters.add(this.fUZ);
        this.mAdapters.add(this.fUX);
        this.mAdapters.add(this.fUY);
        this.mAdapters.add(this.dYq);
        this.mAdapters.add(this.dYr);
        this.mAdapters.add(this.fVe);
        this.mAdapters.add(this.fVf);
        this.mAdapters.add(this.fVb);
        this.mAdapters.add(this.fVc);
        this.mAdapters.add(this.fVa);
        this.mAdapters.add(this.fVg);
        this.mAdapters.add(this.fVh);
        this.dOJ.setPriority(1);
        this.dOJ.setSelfListener(true);
        pbActivity.registerListener(this.dOJ);
        aDJ();
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
        boolean z4;
        boolean z5;
        PostData postData2;
        boolean z6;
        com.baidu.adp.widget.ListView.h biF;
        PostData postData3;
        if (dVar != null) {
            boolean z7 = false;
            if (this.fVj != dVar) {
                z7 = true;
                if ((dVar != null && !dVar.bgg()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z7 = false;
                }
            }
            this.fVj = dVar;
            if (z7) {
                biK();
                if (dVar != null) {
                    dVar.kv(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fVj != null && this.fVj.bgl() != null && this.fVj.bgl().size() > 0) {
                this.postList.addAll(this.fVj.bgl());
            }
            if (dVar != null && dVar.bgj() != null && dVar.bgj().zG() != null) {
                this.mHostId = dVar.bgj().zG().getUserId();
            }
            if (this.fUV != null) {
                this.fUV.b(dVar);
                this.fUV.setFromCDN(this.mIsFromCDN);
                this.fUV.setImageMaxWidth(this.fVr);
                this.fUV.kz(this.fVk);
                this.fUV.s(this.mCommonClickListener);
                this.fUV.I(this.fVs);
                this.fUV.setOnImageClickListener(this.brM);
                this.fUV.setOnLongClickListener(this.aTo);
                this.fUV.setTbGestureDetector(this.brN);
                this.fUZ.b(dVar);
                this.fUZ.setFromCDN(this.mIsFromCDN);
                this.fUZ.setHostId(this.mHostId);
                this.fUZ.kz(this.fVk);
                this.fUZ.s(this.mCommonClickListener);
                this.fUZ.I(this.fVs);
                this.fUZ.setOnImageClickListener(this.brM);
                this.fUZ.setOnLongClickListener(this.aTo);
                this.fUZ.setTbGestureDetector(this.brN);
                this.fUW.setOnClickListener(this.mCommonClickListener);
                this.fVg.setOnClickListener(this.mCommonClickListener);
                if (this.dYr != null && (this.dYr instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dYr).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fVi.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.setImageMaxWidth(this.fVr);
                        next.kz(this.fVk);
                        next.kA(this.fVl);
                        next.kB(this.fVq);
                        next.s(this.mCommonClickListener);
                        next.I(this.fVs);
                        next.setOnImageClickListener(this.brM);
                        next.setOnLongClickListener(this.aTo);
                    }
                }
                this.fUX.s(this.mCommonClickListener);
                this.fUY.s(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.bgl());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bDr() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (this.fVl || postData == null) {
                    z3 = z2;
                    z4 = false;
                } else {
                    arrayList.remove(postData);
                    z4 = true;
                    z3 = true;
                    if (dVar.bgI() && postData.bDt() != null) {
                        postData.c(null);
                    }
                }
                if (z3 || dVar.bgq() == null) {
                    z5 = z3;
                    postData2 = postData;
                } else {
                    PostData bgq = dVar.bgq();
                    if (!this.fVl && dVar.bgI() && bgq.bDt() != null) {
                        bgq.c(null);
                    }
                    z5 = true;
                    postData2 = bgq;
                    z4 = true;
                }
                dl(arrayList);
                if (this.fUU.bid()) {
                    if (dVar.bgl().size() > 0 && (postData3 = dVar.bgl().get(0)) != null && postData3.bDr() == 1 && !com.baidu.tbadk.core.util.v.I(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.fVj, arrayList, this.fVl);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, b, this.fVj.bgm());
                    }
                }
                int c = c(this.fVj, arrayList, this.fVl);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, c, this.fVj.bgn());
                }
                if (arrayList.size() == 0 && this.fUU.bid()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.q(arrayList, 1);
                boolean z8 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fQE);
                    if (dVar != null && dVar.bgj() != null) {
                        hVar.fQG = dVar.bgj().zx();
                    }
                    hVar.isNew = !this.fVl;
                    hVar.fQJ = this.fUU.bip();
                    hVar.sortType = dVar.fQv;
                    if (dVar.fQu != null && dVar.fQu.size() > dVar.fQv) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= dVar.fQu.size()) {
                                break;
                            } else if (dVar.fQu.get(i2).sort_type.intValue() != dVar.fQv) {
                                i = i2 + 1;
                            } else {
                                hVar.fQI = dVar.fQu.get(i2).sort_name;
                                break;
                            }
                        }
                    }
                    com.baidu.tbadk.core.util.v.a(arrayList, c2, hVar);
                    z8 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.h> g = g(dVar);
                if (com.baidu.tbadk.core.util.v.I(g) || b2 < 0) {
                    z6 = z8;
                } else {
                    com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, b2);
                    if (hVar2 instanceof PostData) {
                        ((PostData) hVar2).hlW = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z6 = true;
                }
                int i3 = -1;
                boolean z9 = false;
                if (z5) {
                    i3 = a(dVar, arrayList, this.fVl);
                }
                if (i3 >= 0 && dVar.bgH() != null) {
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, dVar.bgH());
                    z6 = true;
                    z9 = true;
                }
                boolean z10 = false;
                if (!this.fUU.bim() && this.fVj != null && this.fVj.bgh() != null && !StringUtils.isNull(this.fVj.bgh().getName()) && !StringUtils.isNull(this.fVj.bgh().getId())) {
                    i3++;
                    com.baidu.tbadk.core.util.v.a(arrayList, i3, this.fVj.bgh());
                    z10 = true;
                    if (this.fVh != null && this.fVj.bgj() != null) {
                        this.fVh.setThreadId(this.fVj.bgj().getId());
                    }
                }
                int i4 = i3;
                boolean z11 = z10;
                boolean z12 = false;
                if (z5 && (biF = biF()) != null && i4 >= 0) {
                    z12 = true;
                    com.baidu.tbadk.core.util.v.a(arrayList, i4 + 1, biF);
                }
                if (z5 && !z12) {
                    com.baidu.adp.widget.ListView.h biG = biG();
                    int i5 = -1;
                    if (i4 >= 0) {
                        i5 = i4 + 1;
                    } else if (b2 >= 0) {
                        i5 = b2;
                    } else if (c2 >= 0) {
                        i5 = c2;
                    }
                    if (biG != null && i5 >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, i5, biG);
                    }
                }
                this.fUV.kQ(!z6);
                boolean z13 = false;
                if (this.fUU.bhn() != null && postData2 != null && postData2.getId() != null && postData2.getId().equals(this.fUU.bhn().getPostId())) {
                    z13 = true;
                }
                if (this.fVm && !z13) {
                    arrayList.remove(postData2);
                    this.fVm = false;
                }
                if (dVar.bgH() != null) {
                    if (z9 && !z11) {
                        dVar.bgH().kw(false);
                    } else {
                        dVar.bgH().kw(true);
                    }
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z13 && !z && ((this.fVo || this.fVn) && b2 != -1 && !com.baidu.tbadk.core.util.v.I(g) && !this.fVp)) {
                    this.fVu = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fVw);
                            f.this.fVp = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.jG().post(this.fVu);
                }
                if (postData2 == null) {
                    PostData postData4 = new PostData();
                    postData4.vv(1);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData4);
                    this.mListView.setData(arrayList);
                } else if (z4) {
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData2);
                    this.mListView.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h biF() {
        PbModel bhn = this.fUU.bhn();
        if (bhn == null) {
            return null;
        }
        String bjN = bhn.bjN();
        if (TextUtils.isEmpty(bjN)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.vC(bjN);
        b(lVar);
        return lVar;
    }

    private com.baidu.adp.widget.ListView.h biG() {
        com.baidu.tieba.tbadkCore.data.l bgz;
        if (this.fVj == null || (bgz = this.fVj.bgz()) == null) {
            return null;
        }
        AdvertAppInfo.ILegoAdvert bDg = bgz.bDg();
        if (bDg != null) {
            bDg.setAdvertAppInfo(bgz.pu());
        }
        int yc = bgz.bDf().yc();
        if (yc != 0) {
            a(bgz, yc);
            if (yc == 28 || yc == 31 || bgz.bDf().goods == null) {
                return null;
            }
            bgz.bDf().goods.goods_style = -1001;
            return null;
        }
        if (this.fVj.bgh() != null) {
            bgz.forumId = this.fVj.bgh().getId();
        }
        if (this.fVj.bgj() != null) {
            bgz.threadId = com.baidu.adp.lib.g.b.d(this.fVj.bgj().getId(), 0L);
        }
        if (this.fVj != null && this.fVj.yS() != null) {
            bgz.pageNumber = this.fVj.yS().yN();
        }
        b(bgz);
        return bgz;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fVn || dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bgl()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bgI() && this.fVl) ? 0 : -1;
        } else if (this.fUU.bhn() == null || !this.fUU.bhn().getIsFromMark()) {
            if (this.fUU.bhE() == null || !this.fUU.bhE().blI()) {
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
                        if (postData.bDr() == 1 && postData.hlT == 0) {
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
                return dVar.bgI() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bgl()) || com.baidu.tbadk.core.util.v.I(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.d(dVar.bgl(), 0)) == null) {
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
                if (postData.bDr() == 1 && postData.hlT == 0) {
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

    private int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || com.baidu.tbadk.core.util.v.I(dVar.bgl()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bgI()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bgl().get(0) == null || dVar.bgl().get(0).bDr() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bgu() == null || com.baidu.tbadk.core.util.v.I(dVar.bgu().fQU)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bgu().fQU;
        if (com.baidu.tbadk.core.util.v.I(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.hlV = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.H(dVar.bgu().fQV) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).hlV = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.d(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).hlV = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fQF);
        hVar3.fQH = dVar.bgu().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void aDJ() {
        if (this.fUU != null && !aDK()) {
            this.fUU.registerListener(this.dPQ);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aDK() {
        if (this.fUU == null) {
            return false;
        }
        this.dPH = new ArrayList();
        ArrayList<BdUniqueId> bCE = com.baidu.tieba.tbadkCore.q.bCE();
        if (bCE == null || bCE.size() <= 0) {
            return false;
        }
        int size = bCE.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aZu().a(this.fUU.getPageContext(), bCE.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dPH.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.I(this.dPH)) {
            this.mListView.addAdapters(this.dPH);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bgl() == null || dVar.bgm() == null || dVar.bgl().size() == 0 || dVar.bgj() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bgm().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bgl().get(0) == null || dVar.bgl().get(0).bDr() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.yS() == null || dVar.yS().yN() != dVar.yS().yK()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.bgl() == null || dVar.bgn() == null || dVar.bgl().size() == 0 || dVar.bgj() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bgn().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bgl().get(0) == null || dVar.bgl().get(0).bDr() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.yS() == null || dVar.yS().yN() != dVar.yS().yK()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> biH() {
        return this.postList;
    }

    public BdUniqueId sh(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fVd == null || !this.fVd.bhg()) {
            this.fVv = biI();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int biI() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fQE) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int biJ() {
        return this.fVv;
    }

    private void biK() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fVj != null) {
            ArrayList<PostData> bgl = this.fVj.bgl();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> bgy = this.fVj.bgy();
            if (bgy != null) {
                int size = bgy.size();
                if (bgl != null && bgl.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = bgy.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = bgy.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dYT = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = bgy.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bDf() != null) {
                            int yc = next3.bDf().yc();
                            if (yc != 0) {
                                a(next3, yc);
                                if (yc != 28 && yc != 31) {
                                    if (next3.bDf().goods != null) {
                                        next3.bDf().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bDf().apk_name)) {
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
                        /* renamed from: b */
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.fVj.bgh() != null) {
                            lVar4.forumId = this.fVj.bgh().getId();
                        }
                        if (this.fVj.bgj() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.d(this.fVj.bgj().getId(), 0L);
                        }
                        if (this.fVj != null && this.fVj.yS() != null) {
                            lVar4.pageNumber = this.fVj.yS().yN();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= bgl.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fVl) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        bgl.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fUU.getPageContext().getContext(), "pb_show_app", "", 1, AiAppsApsUtils.APP_NAME, lVar4.bDf().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(lVar, 5);
        c.tV(i);
        com.baidu.tieba.recapp.report.c.bvt().a(c);
        if (lVar != null && lVar.bDf() != null) {
            lVar.bDf().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bDf() != null && lVar.bDf().goods != null && lVar.bDf().goods.goods_style != 1001 && lVar.bDf().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData bgh;
        if (lVar != null && this.fVj != null && lVar.bDf() != null) {
            lVar.bDf().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fVj.yS() != null) {
                lVar.bDf().advertAppContext.pn = this.fVj.yS().yN();
            }
            lVar.bDf().advertAppContext.page = lVar.bDi();
            if (this.fVj.bgh() != null && (bgh = this.fVj.bgh()) != null) {
                lVar.bDf().advertAppContext.fid = bgh.getId();
                lVar.bDf().advertAppContext.aoV = bgh.getFirst_class();
                lVar.bDf().advertAppContext.aoW = bgh.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bDf().advertAppContext.aoX = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bDf().advertAppContext.extensionInfo = lVar.bDf().ext_info;
            lVar.bDf().advertAppContext.RT = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fUV.setFromCDN(z);
        if (this.dYr != null && (this.dYr instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dYr).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fVi.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean biL() {
        return this.fVk;
    }

    public void kz(boolean z) {
        this.fVk = z;
    }

    public void kA(boolean z) {
        this.fVl = z;
    }

    public void kB(boolean z) {
        this.fVq = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.fVs = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.brM = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.brN = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTo = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void si(int i) {
        switch (i) {
            case 1:
                if (this.fVd != null) {
                    this.fVd.pause();
                }
                if (this.fUV != null) {
                    this.fUV.pause();
                    return;
                }
                return;
            case 2:
                if (this.fVd != null) {
                    this.fVd.resume();
                }
                if (this.fUV != null) {
                    this.fUV.resume();
                    return;
                }
                return;
            case 3:
                if (this.fVd != null) {
                    this.fVd.release();
                }
                if (this.fUV != null) {
                    this.fUV.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dl(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.AA())) {
                        com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
                        abVar.eh(postData.AA());
                        list.set(i, abVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fVu);
        if (this.fUX != null) {
            this.fUX.onDestroy();
        }
        if (this.fUY != null) {
            this.fUY.onDestroy();
        }
        if (this.fUW != null) {
            this.fUW.onDestroy();
        }
    }

    public void kM(boolean z) {
        this.fVn = z;
    }

    public void kN(boolean z) {
        this.fVo = z;
    }

    public void kO(boolean z) {
        this.fVm = z;
    }

    public void kP(boolean z) {
        this.fVp = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a biM() {
        return this.fUW;
    }
}
