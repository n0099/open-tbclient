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
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.GodUserData;
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
/* loaded from: classes.dex */
public class g {
    private List<com.baidu.adp.widget.ListView.a> cnV;
    private com.baidu.adp.widget.ListView.a crC;
    private com.baidu.adp.widget.ListView.a crD;
    private int eHp;
    private com.baidu.tieba.pb.data.f eHs;
    private PbActivity eIw;
    private com.baidu.tieba.pb.pb.a.f eKZ;
    private Runnable eLC;
    private o eLa;
    private am eLb;
    private aj eLc;
    private j eLd;
    private com.baidu.tieba.pb.video.j eLe;
    private com.baidu.tieba.pb.video.l eLf;
    private com.baidu.tieba.pb.video.a eLg;
    private int eLh;
    private com.baidu.adp.widget.ListView.a eLj;
    private com.baidu.adp.widget.ListView.a eLk;
    private com.baidu.adp.widget.ListView.a eLl;
    private ac eLm;
    private ag eLn;
    private com.baidu.tieba.pb.pb.a.b eLo;
    private com.baidu.tieba.pb.pb.a.g eLp;
    private r eLq;
    private aa eLr;
    private com.baidu.tieba.pb.pb.a.c eLs;
    private boolean eLw;
    private boolean eLx;
    private BdTypeListView mListView;
    private int width;
    private int eLi = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eLt = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eHq = true;
    private boolean eLu = true;
    private boolean eHr = true;
    private boolean eLv = false;
    private boolean eLy = false;
    private boolean eLz = false;
    private String mHostId = null;
    private View.OnClickListener eHv = null;
    private View.OnClickListener cNL = null;
    private TbRichTextView.e aRO = null;
    private com.baidu.tieba.pb.a.c aRP = null;
    private View.OnLongClickListener awp = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eLA = new ArrayList();
    private boolean eLB = false;
    private CustomMessageListener coc = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bsz = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bsz();
                Iterator it = bsz.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).aq(g.this.eIw);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.eLt.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            g.this.eLo = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bsz);
                g.this.eLA.clear();
                g.this.eLA.addAll(arrayList);
                if (g.this.mListView != null) {
                    g.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener ckM = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.eHs != null && !com.baidu.adp.base.i.Y(g.this.eIw.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener cod = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.u.v(g.this.cnV)) {
                g.this.ahb();
                g.this.a(g.this.eHs, false);
            }
        }
    };

    public g(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eHp = 0;
        this.width = -1;
        this.eHp = com.baidu.adp.lib.util.k.ag(pbActivity.getPageContext().getPageActivity());
        this.width = this.eHp;
        this.eIw = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.ckM);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eLp = new com.baidu.tieba.pb.pb.a.g(pbActivity, PostData.gjJ);
        this.eLa = new o(pbActivity, PostData.gjG);
        this.eLa.a(pbActivity);
        this.eKZ = new com.baidu.tieba.pb.pb.a.f(pbActivity, com.baidu.tieba.pb.data.j.TYPE);
        this.eLb = new am(pbActivity, com.baidu.tieba.pb.data.m.eGy);
        this.eLc = new aj(pbActivity, com.baidu.tieba.pb.data.k.eGu);
        this.eLd = new j(pbActivity, PostData.gjH);
        this.eLd.a(pbActivity);
        this.crC = com.baidu.tieba.recapp.r.big().a(pbActivity, AdvertAppInfo.UB);
        this.eLj = com.baidu.tieba.recapp.r.big().a(pbActivity, AdvertAppInfo.UC);
        this.eLk = com.baidu.tieba.recapp.r.big().a(pbActivity, AdvertAppInfo.UD);
        this.eLl = com.baidu.tieba.recapp.r.big().a(pbActivity, AdvertAppInfo.UE);
        this.crD = com.baidu.tieba.recapp.r.big().a(pbActivity, AdvertAppInfo.UI);
        this.eLq = new r(pbActivity, com.baidu.tieba.pb.data.a.eFt);
        this.eLr = new aa(pbActivity, com.baidu.tieba.pb.data.i.eGq);
        this.eLm = new ac(pbActivity, z.eOE);
        this.eLn = new ag(pbActivity, com.baidu.tbadk.core.data.au.Yj);
        this.eLe = new com.baidu.tieba.pb.video.j(pbActivity, com.baidu.tieba.pb.video.k.faf);
        this.eLf = new com.baidu.tieba.pb.video.l(pbActivity, com.baidu.tieba.pb.video.m.fao);
        this.eLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.a(g.this.eHs, false);
                g.this.notifyDataSetChanged();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11926"));
            }
        });
        this.eLg = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.eYR);
        this.eLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eHs.aPV() != null) {
                    List<Long> list = g.this.eHs.aPV().eGL;
                    int count = g.this.eHs.aPV().getCount();
                    if (list.size() != count) {
                        if (list.size() >= count + 5) {
                            g.this.eHs.aPV().setCount(count + 5);
                            g.this.eIw.aQP().aSA().cF(list.subList(count, count + 5));
                        } else if (list.size() < count + 5) {
                            g.this.eIw.aQP().aSA().cF(list.subList(count, list.size()));
                            g.this.eHs.aPV().setCount(list.size());
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12040"));
                    }
                }
            }
        });
        this.eLs = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.VZ);
        if (this.eHs != null && this.eHs.aPL() != null) {
            this.eLs.aou = this.eHs.aPL().aaW;
        }
        this.mAdapters.add(this.eLa);
        this.mAdapters.add(this.eLb);
        this.mAdapters.add(this.eLd);
        this.mAdapters.add(this.eLc);
        this.mAdapters.add(this.eLp);
        this.mAdapters.add(this.crC);
        this.mAdapters.add(this.eLj);
        this.mAdapters.add(this.eLk);
        this.mAdapters.add(this.eLl);
        this.mAdapters.add(this.crD);
        this.mAdapters.add(this.eLq);
        this.mAdapters.add(this.eLr);
        this.mAdapters.add(this.eLm);
        this.mAdapters.add(this.eLn);
        this.mAdapters.add(this.eLe);
        this.mAdapters.add(this.eLf);
        this.mAdapters.add(this.eLs);
        this.mAdapters.add(this.eLg);
        this.mAdapters.add(this.eKZ);
        this.coc.setPriority(1);
        this.coc.setSelfListener(true);
        pbActivity.registerListener(this.coc);
        aha();
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
        int size;
        PostData postData2;
        int size2;
        PostData postData3;
        boolean z5 = false;
        if (fVar != null) {
            if (this.eHs != fVar) {
                z2 = (fVar == null || fVar.aPG()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eHs = fVar;
            if (z2) {
                aRM();
                if (fVar != null) {
                    fVar.iQ(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eHs != null && this.eHs.aPN() != null && this.eHs.aPN().size() > 0) {
                this.postList.addAll(this.eHs.aPN());
            }
            if (fVar != null && fVar.aPL() != null && fVar.aPL().getAuthor() != null) {
                this.mHostId = fVar.aPL().getAuthor().getUserId();
            }
            if (this.eLa != null) {
                this.eLp.b(fVar);
                this.eLp.setFromCDN(this.mIsFromCDN);
                this.eLp.setHostId(this.mHostId);
                this.eLp.oY(this.eHp);
                this.eLp.iS(this.eHq);
                this.eLp.iT(this.eHr);
                this.eLp.setCommonClickListener(this.cNL);
                this.eLp.C(this.eHv);
                this.eLp.setOnImageClickListener(this.aRO);
                this.eLp.setOnLongClickListener(this.awp);
                this.eLa.b(fVar);
                this.eLa.setFromCDN(this.mIsFromCDN);
                this.eLa.setHostId(this.mHostId);
                this.eLa.oY(this.eHp);
                this.eLa.iS(this.eHq);
                this.eLa.iT(this.eHr);
                this.eLa.setCommonClickListener(this.cNL);
                this.eLa.C(this.eHv);
                this.eLa.setOnImageClickListener(this.aRO);
                this.eLa.setOnLongClickListener(this.awp);
                this.eLa.setTbGestureDetector(this.aRP);
                this.eLa.ph(fVar != null ? fVar.aPL().ry() : 0);
                this.eLd.b(fVar);
                this.eLd.setFromCDN(this.mIsFromCDN);
                this.eLd.setHostId(this.mHostId);
                this.eLd.iS(this.eHq);
                this.eLd.setCommonClickListener(this.cNL);
                this.eLd.C(this.eHv);
                this.eLd.setOnImageClickListener(this.aRO);
                this.eLd.setOnLongClickListener(this.awp);
                this.eLd.setTbGestureDetector(this.aRP);
                this.eLb.setOnClickListener(this.cNL);
                this.eLb.setTbGestureDetector(this.aRP);
                if (this.eLj != null && (this.eLj instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eLj).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eLk != null && (this.eLk instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eLk).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.crD != null && (this.crD instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.crD).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eLt.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.oY(this.eHp);
                        next.iS(this.eHq);
                        next.iT(this.eHr);
                        next.iU(this.eLz);
                        next.setCommonClickListener(this.cNL);
                        next.C(this.eHv);
                        next.setOnImageClickListener(this.aRO);
                        next.setOnLongClickListener(this.awp);
                    }
                }
                this.eLc.setCommonClickListener(this.cNL);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aPN());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bsZ() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                cE(arrayList);
                if (this.eIw.aRl()) {
                    if (fVar.aPN().size() > 0 && (postData3 = fVar.aPN().get(0)) != null && postData3.bsZ() == 1 && !com.baidu.tbadk.core.util.u.v(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.eHs, arrayList, this.eHr);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.u.a(arrayList, b, this.eHs.aPO());
                    }
                }
                int c = c(this.eHs, arrayList, this.eHr);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.u.a(arrayList, c, this.eHs.aPP());
                }
                if (arrayList.size() == 0 && this.eIw.aRl()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.eHr);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.f> c2 = c(fVar, arrayList);
                    if (c2 != null && c2.size() > 0) {
                        com.baidu.tbadk.core.util.u.a((List) arrayList, a, (List) c2);
                    } else {
                        this.eLh = 0;
                    }
                } else {
                    this.eLh = 0;
                }
                com.baidu.tieba.tbadkCore.n.q(arrayList, 1);
                int u = com.baidu.tbadk.core.util.u.u(arrayList);
                int i = 0;
                while (i < u) {
                    com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, i);
                    if (fVar2 instanceof PostData) {
                        ((PostData) fVar2).ctl = i == 0;
                    }
                    i++;
                }
                int a2 = a(fVar, arrayList);
                final List<com.baidu.adp.widget.ListView.f> d = d(fVar);
                if (com.baidu.tbadk.core.util.u.v(d) || a2 < 0) {
                    z4 = false;
                } else {
                    com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, a2);
                    if (fVar3 instanceof PostData) {
                        ((PostData) fVar3).ctl = true;
                    }
                    com.baidu.tbadk.core.util.u.a((List) arrayList, a2, (List) d);
                    z4 = true;
                }
                int b2 = z3 ? b(fVar, arrayList) : -1;
                if (b2 >= 0 && fVar.aQi() != null) {
                    com.baidu.tbadk.core.util.u.a(arrayList, b2, fVar.aQi());
                    fVar.aQi().iR((b(arrayList, b2) || z4) ? false : true);
                    z4 = true;
                }
                this.eLa.ji(!z4);
                if (!this.eHr && fVar != null && fVar.aPN() != null && (size = fVar.aPN().size()) > 0 && (postData2 = fVar.aPN().get(size - 1)) != null && postData2.bsZ() == 1 && (size2 = arrayList.size()) > 0) {
                    arrayList.remove(size2 - 1);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (this.eIw.aQP() != null && postData != null && postData.getId() != null && postData.getId().equals(this.eIw.aQP().getPostId())) {
                    z5 = true;
                }
                if (!z5 && !z) {
                    if ((this.eLw || this.eLv) && a2 != -1 && !com.baidu.tbadk.core.util.u.v(d) && !this.eLx) {
                        this.eLC = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.mListView.setSelection(g.this.mListView.getHeaderViewsCount() + d.size());
                                g.this.eLx = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.ga().post(this.eLC);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        MetaData author;
        GodUserData godUserData;
        if (this.eIw.aPS() == null || this.eIw.aQO() == null) {
            return false;
        }
        if (this.eIw.aQO().aUo() || (author = this.eIw.aPS().getAuthor()) == null || (godUserData = author.getGodUserData()) == null || !godUserData.isBigV() || godUserData.getIsLike()) {
            return false;
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
        jVar.eGr = author;
        com.baidu.tbadk.core.util.u.a(arrayList, i + 1, jVar);
        jVar.eGs = true;
        if (!UtilHelper.isCurrentAccount(author.getUserId())) {
            jVar.eGt = true;
            return true;
        }
        jVar.eGt = false;
        return true;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        PostData postData;
        int i;
        int i2 = 0;
        if (fVar == null || com.baidu.tbadk.core.util.u.v(fVar.aPN()) || arrayList == null || arrayList.size() <= 0 || this.eIw.aRy() || this.eLy) {
            return -1;
        }
        if ((this.eIw.aQP() == null || !this.eIw.aQP().getIsFromMark()) && (postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPN(), 0)) != null) {
            int bsZ = postData.bsZ();
            int size = arrayList.size();
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
                if (fVar2 != null && (fVar2 instanceof PostData)) {
                    PostData postData2 = (PostData) fVar2;
                    if (postData2.bsZ() == bsZ && postData2.gkq == 0) {
                        i = bsZ == 1 ? i2 + 1 : i2;
                    }
                    i2++;
                } else {
                    if (fVar2 != null && (fVar2 instanceof com.baidu.tieba.pb.data.k)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            return i;
        }
        return -1;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!this.eHr) {
            return -1;
        }
        if (fVar == null || com.baidu.tbadk.core.util.u.v(fVar.aPN()) || arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return -1;
            }
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
            if (!(fVar2 instanceof PostData) || ((PostData) fVar2).bsZ() != 1) {
                i = i2 + 1;
            } else {
                return i2 + 1;
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.f> d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aPV() == null || com.baidu.tbadk.core.util.u.v(fVar.aPV().eGK) || this.eIw.aRy() || this.eLy) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aPV().eGK;
        if (com.baidu.tbadk.core.util.u.v(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.gks = true;
                arrayList.add(postData);
            }
        }
        int u = com.baidu.tbadk.core.util.u.u(fVar.aPV().eGL);
        if (fVar.aPV().getCount() != u && u > 2) {
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, arrayList.size() - 1);
            if (fVar2 instanceof PostData) {
                ((PostData) fVar2).gks = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.f fVar3 = (com.baidu.adp.widget.ListView.f) com.baidu.tbadk.core.util.u.c(arrayList, arrayList.size() - 1);
            if (fVar3 instanceof PostData) {
                ((PostData) fVar3).gks = true;
            }
        }
        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
        kVar.mType = 0;
        arrayList.add(0, kVar);
        return arrayList;
    }

    public void aRI() {
        this.eLh = 0;
    }

    public int aRJ() {
        return this.eLi;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.u.v(fVar.aPN()) || com.baidu.tbadk.core.util.u.v(fVar.aPM())) {
            return -1;
        }
        if (z) {
            return (fVar.aPN().get(0) == null || fVar.aPN().get(0).bsZ() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.f> c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (fVar == null || arrayList == null || fVar.aPM() == null || fVar.aPM().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<bl> aPM = fVar.aPM();
        int size = aPM.size();
        this.eLi = 0;
        if (this.eLh + 5 >= size) {
            int i2 = 0;
            for (bl blVar : aPM) {
                if (blVar != null) {
                    com.baidu.tieba.pb.video.k kVar = new com.baidu.tieba.pb.video.k();
                    int i3 = i2 + 1;
                    if (i3 == 1) {
                        kVar.a(blVar, true, true, true, i3);
                    } else {
                        kVar.a(blVar, true, true, false, i3);
                    }
                    arrayList2.add(kVar);
                    this.eLh++;
                    i = i3;
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (this.eLh <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.eLi = arrayList2.size();
            }
            return arrayList2;
        }
        int i4 = this.eLh + 5;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            bl blVar2 = aPM.get(i6);
            if (blVar2 != null) {
                com.baidu.tieba.pb.video.k kVar2 = new com.baidu.tieba.pb.video.k();
                i5++;
                boolean z = i5 == 1;
                if (i6 == i4 - 1) {
                    kVar2.a(blVar2, false, true, z, i5);
                } else {
                    kVar2.a(blVar2, true, true, z, i5);
                }
                arrayList2.add(kVar2);
                this.eLh++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.m());
        this.eLi = arrayList2.size();
        return arrayList2;
    }

    private void aha() {
        if (this.eIw != null && !ahb()) {
            this.eIw.registerListener(this.cod);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ahb() {
        if (this.eIw == null) {
            return false;
        }
        this.cnV = new ArrayList();
        ArrayList<BdUniqueId> bsj = com.baidu.tieba.tbadkCore.n.bsj();
        if (bsj == null || bsj.size() <= 0) {
            return false;
        }
        int size = bsj.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aEk().a(this.eIw.getPageContext(), bsj.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cnV.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.u.v(this.cnV)) {
            this.mListView.addAdapters(this.cnV);
        }
        return true;
    }

    public int aRK() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPN() == null || fVar.aPO() == null || fVar.aPN().size() == 0 || fVar.aPL() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPO().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPN().get(0) == null || fVar.aPN().get(0).bsZ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qI() == null || fVar.qI().qC() != fVar.qI().qz()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPN() == null || fVar.aPP() == null || fVar.aPN().size() == 0 || fVar.aPL() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPP().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPN().get(0) == null || fVar.aPN().get(0).bsZ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qI() == null || fVar.qI().qC() != fVar.qI().qz()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aRL() {
        return this.postList;
    }

    public BdUniqueId pe(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.eLo == null || !this.eLo.aQD()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aRM() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eHs != null) {
            ArrayList<PostData> aPN = this.eHs.aPN();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aPZ = this.eHs.aPZ();
            if (aPZ != null) {
                int size = aPZ.size();
                if (aPN != null && aPN.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aPZ.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.bsQ() != null) {
                            sb.append(next.bsQ());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aPZ.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.csz = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aPZ.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bsO() != null) {
                            int py = next3.bsO().py();
                            if (py != 0) {
                                a(next3, py);
                                if (py != 28 && py != 31) {
                                    if (next3.bsO().goods != null) {
                                        next3.bsO().goods.goods_style = TbErrInfo.ERR_IMG_GET_REMOTE;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bsO().apk_name)) {
                                int position = next3.getPosition();
                                if (position >= 2 && position < 30) {
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
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.bsQ(), lVar3)) != null) {
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
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.g.7
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.eHs.aPJ() != null) {
                            lVar4.forumId = this.eHs.aPJ().getId();
                        }
                        if (this.eHs.aPL() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.d(this.eHs.aPL().getId(), 0L);
                        }
                        if (this.eHs != null && this.eHs.qI() != null) {
                            lVar4.pageNumber = this.eHs.qI().qC();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (a(lVar4, aPN)) {
                            aPN.add(lVar4);
                        } else if (position2 + i3 >= aPN.size()) {
                            a(lVar4, 2);
                            return;
                        } else {
                            aPN.add(position2, lVar4);
                            TiebaStatic.eventStat(this.eIw.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bsO().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 5);
        c.sf(i);
        com.baidu.tieba.recapp.report.b.biO().a(c);
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bsO() != null && lVar.bsO().goods != null && lVar.bsO().goods.goods_style != 1001 && lVar.bsO().goods.goods_style != -1001) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 5);
            c.sf(i);
            com.baidu.tieba.recapp.report.b.biO().a(c);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aPJ;
        if (lVar != null && this.eHs != null && lVar.bsO() != null) {
            lVar.bsO().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eHs.qI() != null) {
                lVar.bsO().advertAppContext.pn = this.eHs.qI().qC();
            }
            lVar.bsO().advertAppContext.Up = "PB";
            if (this.eHs.aPJ() != null && (aPJ = this.eHs.aPJ()) != null) {
                lVar.bsO().advertAppContext.fid = aPJ.getId();
                lVar.bsO().advertAppContext.Ur = aPJ.getFirst_class();
                lVar.bsO().advertAppContext.Us = aPJ.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bsO().advertAppContext.Ut = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bsO().advertAppContext.extensionInfo = lVar.bsO().ext_info;
            lVar.bsO().advertAppContext.Uu = false;
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.l lVar, ArrayList<PostData> arrayList) {
        int u = com.baidu.tbadk.core.util.u.u(arrayList);
        if (lVar == null || u <= 0) {
            return false;
        }
        int position = lVar.getPosition();
        if (u >= 2 || position != u + 1) {
            return false;
        }
        if (this.eHs != null && this.eHs.qI() != null) {
            lVar.pageNumber = this.eHs.qI().qC();
        }
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eLp.setFromCDN(z);
        this.eLa.setFromCDN(z);
        if (this.eLj != null && (this.eLj instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eLj).setIsFromCDN(z);
        }
        if (this.eLk != null && (this.eLk instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eLk).setIsFromCDN(z);
        }
        if (this.crD != null && (this.crD instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.crD).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eLt.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void iS(boolean z) {
        this.eHq = z;
    }

    public void iT(boolean z) {
        this.eHr = z;
    }

    public void iU(boolean z) {
        this.eLz = z;
    }

    public void C(View.OnClickListener onClickListener) {
        this.eHv = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRO = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRP = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awp = onLongClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.cNL = onClickListener;
    }

    public void pf(int i) {
        if (this.eLb != null) {
            this.eLb.pf(i);
        }
        switch (i) {
            case 1:
                if (this.eLo != null) {
                    this.eLo.pause();
                }
                if (this.eLa != null) {
                    this.eLa.pause();
                }
                if (this.eLl != null && (this.eLl instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eLl).release();
                    return;
                }
                return;
            case 2:
                if (this.eLo != null) {
                    this.eLo.resume();
                }
                if (this.eLa != null) {
                    this.eLa.resume();
                }
                if (this.eLl != null && (this.eLl instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eLl).resume();
                    return;
                }
                return;
            case 3:
                if (this.eLo != null) {
                    this.eLo.release();
                }
                if (this.eLa != null) {
                    this.eLa.release();
                }
                if (this.eLl != null && (this.eLl instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eLl).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cE(List<com.baidu.adp.widget.ListView.f> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sB())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.cH(postData.sB());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.eLC);
    }

    public void je(boolean z) {
        this.eLy = z;
    }

    public void jf(boolean z) {
        this.eLv = z;
    }

    public void jg(boolean z) {
        this.eLw = z;
    }

    public void jh(boolean z) {
        this.eLx = z;
    }

    public am aRN() {
        return this.eLb;
    }
}
