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
public class f {
    private List<com.baidu.adp.widget.ListView.a> dde;
    private com.baidu.adp.widget.ListView.a dlF;
    private com.baidu.adp.widget.ListView.a dlG;
    private PbActivity fgJ;
    private o fgK;
    private ao fgL;
    private aj fgM;
    private aj fgN;
    private i fgO;
    private com.baidu.tieba.pb.video.a fgP;
    private af fgQ;
    private ag fgR;
    private com.baidu.tieba.pb.pb.a.b fgS;
    private u fgT;
    private ad fgU;
    private com.baidu.tieba.pb.pb.a.d fgV;
    private an fgW;
    private com.baidu.tieba.pb.data.d fgY;
    private boolean fhd;
    private boolean fhe;
    private int fhg;
    private Runnable fhj;
    private int fhl;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fgX = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fgZ = true;
    private boolean fha = true;
    private boolean fhb = false;
    private boolean fhc = false;
    private boolean fhf = false;
    private String mHostId = null;
    private View.OnClickListener fhh = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h aWw = null;
    private com.baidu.tieba.pb.a.c aWx = null;
    private View.OnLongClickListener axW = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fhi = new ArrayList();
    private int fhk = -1;
    private CustomMessageListener dcl = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList brB = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).brB();
                Iterator it = brB.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).aq(f.this.fgJ);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.fgX.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fgS = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(brB);
                f.this.fhi.clear();
                f.this.fhi.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener auR = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.fgY != null && !com.baidu.adp.base.i.Z(f.this.fgJ.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener ddn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.w(f.this.dde)) {
                f.this.arK();
                f.this.a(f.this.fgY, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fhg = 0;
        this.width = -1;
        this.fhl = 0;
        this.fhg = com.baidu.adp.lib.util.l.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.fhg;
        this.fgJ = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.auR);
        this.fhl = com.baidu.adp.lib.util.l.ah(this.fgJ) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fgK = new o(pbActivity, PostData.gwr);
        this.fgK.a(pbActivity);
        this.fgL = new ao(pbActivity, com.baidu.tieba.pb.data.j.fcF);
        this.fgM = new aj(pbActivity, com.baidu.tieba.pb.data.h.fcy);
        this.fgN = new aj(pbActivity, com.baidu.tieba.pb.data.h.fcz);
        this.fgO = new i(pbActivity, PostData.gws);
        this.fgO.a(pbActivity);
        this.dlF = com.baidu.tieba.recapp.r.bjl().a(pbActivity, AdvertAppInfo.VD);
        this.dlG = com.baidu.tieba.recapp.r.bjl().a(pbActivity, AdvertAppInfo.VH);
        this.fgT = new u(pbActivity, com.baidu.tieba.pb.data.a.fbH);
        this.fgU = new ad(pbActivity, com.baidu.tieba.pb.data.g.fcx);
        this.fgQ = new af(pbActivity, ac.fmf);
        this.fgR = new ag(pbActivity, com.baidu.tbadk.core.data.ap.YU);
        this.fgV = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gww);
        this.fgW = new an(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.fgP = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fvz);
        this.fgP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.fgY.aVD() != null) {
                    pbActivity.aWO().aZO().aWs();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.al("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fgK);
        this.mAdapters.add(this.fgL);
        this.mAdapters.add(this.fgO);
        this.mAdapters.add(this.fgM);
        this.mAdapters.add(this.fgN);
        this.mAdapters.add(this.dlF);
        this.mAdapters.add(this.dlG);
        this.mAdapters.add(this.fgT);
        this.mAdapters.add(this.fgU);
        this.mAdapters.add(this.fgQ);
        this.mAdapters.add(this.fgR);
        this.mAdapters.add(this.fgP);
        this.mAdapters.add(this.fgV);
        this.mAdapters.add(this.fgW);
        this.dcl.setPriority(1);
        this.dcl.setSelfListener(true);
        pbActivity.registerListener(this.dcl);
        arJ();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(2004015);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        PostData postData2;
        boolean z5;
        boolean z6;
        boolean z7;
        com.baidu.adp.widget.ListView.h aXL;
        PostData postData3;
        if (dVar != null) {
            if (this.fgY != dVar) {
                z2 = (dVar == null || dVar.aVp()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.fgY = dVar;
            if (z2) {
                aXP();
                if (dVar != null) {
                    dVar.jo(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fgY != null && this.fgY.aVu() != null && this.fgY.aVu().size() > 0) {
                this.postList.addAll(this.fgY.aVu());
            }
            if (dVar != null && dVar.aVs() != null && dVar.aVs().rQ() != null) {
                this.mHostId = dVar.aVs().rQ().getUserId();
            }
            if (this.fgK != null) {
                this.fgK.b(dVar);
                this.fgK.setFromCDN(this.mIsFromCDN);
                this.fgK.qa(this.fhg);
                this.fgK.jq(this.fgZ);
                this.fgK.n(this.mCommonClickListener);
                this.fgK.F(this.fhh);
                this.fgK.setOnImageClickListener(this.aWw);
                this.fgK.setOnLongClickListener(this.axW);
                this.fgK.setTbGestureDetector(this.aWx);
                this.fgO.b(dVar);
                this.fgO.setFromCDN(this.mIsFromCDN);
                this.fgO.setHostId(this.mHostId);
                this.fgO.jq(this.fgZ);
                this.fgO.n(this.mCommonClickListener);
                this.fgO.F(this.fhh);
                this.fgO.setOnImageClickListener(this.aWw);
                this.fgO.setOnLongClickListener(this.axW);
                this.fgO.setTbGestureDetector(this.aWx);
                this.fgL.setOnClickListener(this.mCommonClickListener);
                this.fgL.setTbGestureDetector(this.aWx);
                this.fgV.setOnClickListener(this.mCommonClickListener);
                if (this.dlG != null && (this.dlG instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dlG).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fgX.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.qa(this.fhg);
                        next.jq(this.fgZ);
                        next.jr(this.fha);
                        next.js(this.fhf);
                        next.n(this.mCommonClickListener);
                        next.F(this.fhh);
                        next.setOnImageClickListener(this.aWw);
                        next.setOnLongClickListener(this.axW);
                    }
                }
                this.fgM.n(this.mCommonClickListener);
                this.fgN.n(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.aVu());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).brZ() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.fha && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (dVar.aVP() && postData.bsb() != null) {
                        postData.c(null);
                    }
                    z3 = true;
                }
                if (z3 || dVar.aVz() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aVz = dVar.aVz();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, dVar.aVz());
                    if (!this.fha && dVar.aVP() && aVz.bsb() != null) {
                        aVz.c(null);
                    }
                    postData2 = aVz;
                    z4 = true;
                }
                cM(arrayList);
                if (this.fgJ.aXl()) {
                    if (dVar.aVu().size() > 0 && (postData3 = dVar.aVu().get(0)) != null && postData3.brZ() == 1 && !com.baidu.tbadk.core.util.v.w(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fgY, arrayList, this.fha);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.fgY.aVv());
                    }
                }
                int b = b(this.fgY, arrayList, this.fha);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.fgY.aVw());
                }
                if (arrayList.size() == 0 && this.fgJ.aXl()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.n(arrayList, 1);
                int c = c(dVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fcy);
                    if (dVar != null && dVar.aVs() != null) {
                        hVar.fcA = dVar.aVs().rI();
                    }
                    hVar.isNew = !this.fha;
                    hVar.fcC = this.fgJ.aXx();
                    com.baidu.tbadk.core.util.v.a(arrayList, c, hVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.h> g = g(dVar);
                if (!com.baidu.tbadk.core.util.v.w(g) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.c(arrayList, b2);
                    if (hVar2 instanceof PostData) {
                        ((PostData) hVar2).gxb = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(dVar, arrayList) : -1;
                if (d < 0 || dVar.aVO() == null) {
                    z6 = z5;
                    z7 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, dVar.aVO());
                    dVar.aVO().jp((b(arrayList, d) || z5) ? false : true);
                    z7 = true;
                    z6 = true;
                }
                if (!this.fgJ.aXu() && this.fgY != null && this.fgY.aVq() != null && !StringUtils.isNull(this.fgY.aVq().getName()) && !StringUtils.isNull(this.fgY.aVq().getId())) {
                    d++;
                    com.baidu.tbadk.core.util.v.a(arrayList, d, this.fgY.aVq());
                    if (this.fgW != null && this.fgY.aVs() != null) {
                        this.fgW.setThreadId(this.fgY.aVs().getId());
                    }
                }
                if (z4 && (aXL = aXL()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, aXL);
                }
                this.fgK.jI(!z6);
                boolean z8 = (this.fgJ.aWx() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.fgJ.aWx().getPostId())) ? false : true;
                if (this.fhb && !z8) {
                    arrayList.remove(postData2);
                    this.fhb = false;
                }
                if (z7 && (com.baidu.tbadk.core.util.v.c(arrayList, 0) instanceof com.baidu.tieba.pb.data.j)) {
                    jH(false);
                } else {
                    jH(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z8 && !z) {
                    if ((this.fhd || this.fhc) && b2 != -1 && !com.baidu.tbadk.core.util.v.w(g) && !this.fhe) {
                        this.fhj = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.fhl);
                                f.this.fhe = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.fw().post(this.fhj);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h aXL() {
        PbModel aWx = this.fgJ.aWx();
        if (aWx == null) {
            return null;
        }
        String aYU = aWx.aYU();
        if (TextUtils.isEmpty(aYU)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.sS(aYU);
        b(lVar);
        return lVar;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, int i) {
        if (this.fgJ.aVz() == null || this.fgJ.aWO() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.fhc || dVar == null || com.baidu.tbadk.core.util.v.w(dVar.aVu()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.aVP() && this.fha) ? 0 : -1;
        } else if (this.fgJ.aWx() == null || !this.fgJ.aWx().getIsFromMark()) {
            if (this.fgJ.aWO() == null || !this.fgJ.aWO().baN()) {
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
                        if (postData.brZ() == 1 && postData.gwY == 0) {
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
                return dVar.aVP() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.w(dVar.aVu()) || com.baidu.tbadk.core.util.v.w(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.c(dVar.aVu(), 0)) == null) {
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
                if (postData.brZ() == 1 && postData.gwY == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.w(dVar.aVu()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.aVP()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i);
            if ((hVar instanceof PostData) && ((PostData) hVar).brZ() == 1) {
                return i + 1;
            }
        }
        return !dVar.aVP() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.aVD() == null || com.baidu.tbadk.core.util.v.w(dVar.aVD().fcU)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.aVD().fcU;
        if (com.baidu.tbadk.core.util.v.w(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gxa = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.v(dVar.aVD().fcV) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).gxa = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.v.c(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).gxa = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fcz);
        hVar3.fcB = dVar.aVD().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void arJ() {
        if (this.fgJ != null && !arK()) {
            this.fgJ.registerListener(this.ddn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean arK() {
        if (this.fgJ == null) {
            return false;
        }
        this.dde = new ArrayList();
        ArrayList<BdUniqueId> brn = com.baidu.tieba.tbadkCore.q.brn();
        if (brn == null || brn.size() <= 0) {
            return false;
        }
        int size = brn.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aMe().a(this.fgJ.getPageContext(), brn.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dde.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.w(this.dde)) {
            this.mListView.addAdapters(this.dde);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.aVu() == null || dVar.aVv() == null || dVar.aVu().size() == 0 || dVar.aVs() == null || arrayList == null) {
            return -1;
        }
        if (dVar.aVv().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.aVu().get(0) == null || dVar.aVu().get(0).brZ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.rg() == null || dVar.rg().ra() != dVar.rg().qX()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.aVu() == null || dVar.aVw() == null || dVar.aVu().size() == 0 || dVar.aVs() == null || arrayList == null) {
            return -1;
        }
        if (dVar.aVw().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.aVu().get(0) == null || dVar.aVu().get(0).brZ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.rg() == null || dVar.rg().ra() != dVar.rg().qX()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aXM() {
        return this.postList;
    }

    public BdUniqueId qi(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fgS == null || !this.fgS.aWq()) {
            this.fhk = aXN();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int aXN() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fcy) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int aXO() {
        return this.fhk;
    }

    private void aXP() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fgY != null) {
            ArrayList<PostData> aVu = this.fgY.aVu();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aVH = this.fgY.aVH();
            if (aVH != null) {
                int size = aVH.size();
                if (aVu != null && aVu.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aVH.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aVH.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dmd = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aVH.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.brP() != null) {
                            int qs = next3.brP().qs();
                            if (qs != 0) {
                                a(next3, qs);
                                if (qs != 28 && qs != 31) {
                                    if (next3.brP().goods != null) {
                                        next3.brP().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.brP().apk_name)) {
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
                        if (this.fgY.aVq() != null) {
                            lVar4.forumId = this.fgY.aVq().getId();
                        }
                        if (this.fgY.aVs() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fgY.aVs().getId(), 0L);
                        }
                        if (this.fgY != null && this.fgY.rg() != null) {
                            lVar4.pageNumber = this.fgY.rg().ra();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aVu.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fha) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aVu.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fgJ.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.brP().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.rU(i);
        com.baidu.tieba.recapp.report.b.bke().a(c);
        if (lVar != null && lVar.brP() != null) {
            lVar.brP().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.brP() != null && lVar.brP().goods != null && lVar.brP().goods.goods_style != 1001 && lVar.brP().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aVq;
        if (lVar != null && this.fgY != null && lVar.brP() != null) {
            lVar.brP().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fgY.rg() != null) {
                lVar.brP().advertAppContext.pn = this.fgY.rg().ra();
            }
            lVar.brP().advertAppContext.Vt = "PB";
            if (this.fgY.aVq() != null && (aVq = this.fgY.aVq()) != null) {
                lVar.brP().advertAppContext.fid = aVq.getId();
                lVar.brP().advertAppContext.Vv = aVq.getFirst_class();
                lVar.brP().advertAppContext.Vw = aVq.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.brP().advertAppContext.Vx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.brP().advertAppContext.extensionInfo = lVar.brP().ext_info;
            lVar.brP().advertAppContext.IR = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fgK.setFromCDN(z);
        if (this.dlG != null && (this.dlG instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dlG).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fgX.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean aXQ() {
        return this.fgZ;
    }

    public void jq(boolean z) {
        this.fgZ = z;
    }

    public void jr(boolean z) {
        this.fha = z;
    }

    public void js(boolean z) {
        this.fhf = z;
    }

    public void F(View.OnClickListener onClickListener) {
        this.fhh = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.aWw = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aWx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axW = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void qj(int i) {
        if (this.fgL != null) {
            this.fgL.qj(i);
        }
        switch (i) {
            case 1:
                if (this.fgS != null) {
                    this.fgS.pause();
                }
                if (this.fgK != null) {
                    this.fgK.pause();
                    return;
                }
                return;
            case 2:
                if (this.fgS != null) {
                    this.fgS.resume();
                }
                if (this.fgK != null) {
                    this.fgK.resume();
                    return;
                }
                return;
            case 3:
                if (this.fgS != null) {
                    this.fgS.release();
                }
                if (this.fgK != null) {
                    this.fgK.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cM(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sH())) {
                        com.baidu.tbadk.core.data.ac acVar = new com.baidu.tbadk.core.data.ac();
                        acVar.cI(postData.sH());
                        list.set(i, acVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fhj);
        if (this.fgM != null) {
            this.fgM.onDestroy();
        }
        if (this.fgN != null) {
            this.fgN.onDestroy();
        }
    }

    public void jD(boolean z) {
        this.fhc = z;
    }

    public void jE(boolean z) {
        this.fhd = z;
    }

    public void jF(boolean z) {
        this.fhb = z;
    }

    public void jG(boolean z) {
        this.fhe = z;
    }

    public ao aXR() {
        return this.fgL;
    }

    public void jH(boolean z) {
        if (this.fgL != null) {
            this.fgL.fnA = z;
        }
    }
}
