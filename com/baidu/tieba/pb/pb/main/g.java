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
    private List<com.baidu.adp.widget.ListView.a> cnU;
    private com.baidu.adp.widget.ListView.a crC;
    private com.baidu.adp.widget.ListView.a crD;
    private int eHn;
    private com.baidu.tieba.pb.data.f eHq;
    private PbActivity eIu;
    private com.baidu.tieba.pb.pb.a.f eKX;
    private o eKY;
    private am eKZ;
    private Runnable eLA;
    private aj eLa;
    private j eLb;
    private com.baidu.tieba.pb.video.j eLc;
    private com.baidu.tieba.pb.video.l eLd;
    private com.baidu.tieba.pb.video.a eLe;
    private int eLf;
    private com.baidu.adp.widget.ListView.a eLh;
    private com.baidu.adp.widget.ListView.a eLi;
    private com.baidu.adp.widget.ListView.a eLj;
    private ac eLk;
    private ag eLl;
    private com.baidu.tieba.pb.pb.a.b eLm;
    private com.baidu.tieba.pb.pb.a.g eLn;
    private r eLo;
    private aa eLp;
    private com.baidu.tieba.pb.pb.a.c eLq;
    private boolean eLu;
    private boolean eLv;
    private BdTypeListView mListView;
    private int width;
    private int eLg = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eLr = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eHo = true;
    private boolean eLs = true;
    private boolean eHp = true;
    private boolean eLt = false;
    private boolean eLw = false;
    private boolean eLx = false;
    private String mHostId = null;
    private View.OnClickListener eHt = null;
    private View.OnClickListener cNL = null;
    private TbRichTextView.e aRN = null;
    private com.baidu.tieba.pb.a.c aRO = null;
    private View.OnLongClickListener awo = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eLy = new ArrayList();
    private boolean eLz = false;
    private CustomMessageListener cob = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bsG = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bsG();
                Iterator it = bsG.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).aq(g.this.eIu);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.eLr.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            g.this.eLm = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bsG);
                g.this.eLy.clear();
                g.this.eLy.addAll(arrayList);
                if (g.this.mListView != null) {
                    g.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener ckL = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.eHq != null && !com.baidu.adp.base.i.Y(g.this.eIu.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener coc = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.u.v(g.this.cnU)) {
                g.this.ahh();
                g.this.a(g.this.eHq, false);
            }
        }
    };

    public g(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eHn = 0;
        this.width = -1;
        this.eHn = com.baidu.adp.lib.util.k.ag(pbActivity.getPageContext().getPageActivity());
        this.width = this.eHn;
        this.eIu = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.ckL);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eLn = new com.baidu.tieba.pb.pb.a.g(pbActivity, PostData.gjJ);
        this.eKY = new o(pbActivity, PostData.gjG);
        this.eKY.a(pbActivity);
        this.eKX = new com.baidu.tieba.pb.pb.a.f(pbActivity, com.baidu.tieba.pb.data.j.TYPE);
        this.eKZ = new am(pbActivity, com.baidu.tieba.pb.data.m.eGw);
        this.eLa = new aj(pbActivity, com.baidu.tieba.pb.data.k.eGs);
        this.eLb = new j(pbActivity, PostData.gjH);
        this.eLb.a(pbActivity);
        this.crC = com.baidu.tieba.recapp.r.bil().a(pbActivity, AdvertAppInfo.Uz);
        this.eLh = com.baidu.tieba.recapp.r.bil().a(pbActivity, AdvertAppInfo.UB);
        this.eLi = com.baidu.tieba.recapp.r.bil().a(pbActivity, AdvertAppInfo.UC);
        this.eLj = com.baidu.tieba.recapp.r.bil().a(pbActivity, AdvertAppInfo.UD);
        this.crD = com.baidu.tieba.recapp.r.bil().a(pbActivity, AdvertAppInfo.UH);
        this.eLo = new r(pbActivity, com.baidu.tieba.pb.data.a.eFr);
        this.eLp = new aa(pbActivity, com.baidu.tieba.pb.data.i.eGo);
        this.eLk = new ac(pbActivity, z.eOC);
        this.eLl = new ag(pbActivity, com.baidu.tbadk.core.data.au.Yi);
        this.eLc = new com.baidu.tieba.pb.video.j(pbActivity, com.baidu.tieba.pb.video.k.fad);
        this.eLd = new com.baidu.tieba.pb.video.l(pbActivity, com.baidu.tieba.pb.video.m.fam);
        this.eLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.a(g.this.eHq, false);
                g.this.notifyDataSetChanged();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11926"));
            }
        });
        this.eLe = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.eYP);
        this.eLe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.eHq.aQa() != null) {
                    List<Long> list = g.this.eHq.aQa().eGJ;
                    int count = g.this.eHq.aQa().getCount();
                    if (list.size() != count) {
                        if (list.size() >= count + 5) {
                            g.this.eHq.aQa().setCount(count + 5);
                            g.this.eIu.aQU().aSF().cF(list.subList(count, count + 5));
                        } else if (list.size() < count + 5) {
                            g.this.eIu.aQU().aSF().cF(list.subList(count, list.size()));
                            g.this.eHq.aQa().setCount(list.size());
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12040"));
                    }
                }
            }
        });
        this.eLq = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.VY);
        if (this.eHq != null && this.eHq.aPQ() != null) {
            this.eLq.aou = this.eHq.aPQ().aaW;
        }
        this.mAdapters.add(this.eKY);
        this.mAdapters.add(this.eKZ);
        this.mAdapters.add(this.eLb);
        this.mAdapters.add(this.eLa);
        this.mAdapters.add(this.eLn);
        this.mAdapters.add(this.crC);
        this.mAdapters.add(this.eLh);
        this.mAdapters.add(this.eLi);
        this.mAdapters.add(this.eLj);
        this.mAdapters.add(this.crD);
        this.mAdapters.add(this.eLo);
        this.mAdapters.add(this.eLp);
        this.mAdapters.add(this.eLk);
        this.mAdapters.add(this.eLl);
        this.mAdapters.add(this.eLc);
        this.mAdapters.add(this.eLd);
        this.mAdapters.add(this.eLq);
        this.mAdapters.add(this.eLe);
        this.mAdapters.add(this.eKX);
        this.cob.setPriority(1);
        this.cob.setSelfListener(true);
        pbActivity.registerListener(this.cob);
        ahg();
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
            if (this.eHq != fVar) {
                z2 = (fVar == null || fVar.aPL()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eHq = fVar;
            if (z2) {
                aRR();
                if (fVar != null) {
                    fVar.iQ(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eHq != null && this.eHq.aPS() != null && this.eHq.aPS().size() > 0) {
                this.postList.addAll(this.eHq.aPS());
            }
            if (fVar != null && fVar.aPQ() != null && fVar.aPQ().getAuthor() != null) {
                this.mHostId = fVar.aPQ().getAuthor().getUserId();
            }
            if (this.eKY != null) {
                this.eLn.b(fVar);
                this.eLn.setFromCDN(this.mIsFromCDN);
                this.eLn.setHostId(this.mHostId);
                this.eLn.oY(this.eHn);
                this.eLn.iS(this.eHo);
                this.eLn.iT(this.eHp);
                this.eLn.setCommonClickListener(this.cNL);
                this.eLn.G(this.eHt);
                this.eLn.setOnImageClickListener(this.aRN);
                this.eLn.setOnLongClickListener(this.awo);
                this.eKY.b(fVar);
                this.eKY.setFromCDN(this.mIsFromCDN);
                this.eKY.setHostId(this.mHostId);
                this.eKY.oY(this.eHn);
                this.eKY.iS(this.eHo);
                this.eKY.iT(this.eHp);
                this.eKY.setCommonClickListener(this.cNL);
                this.eKY.G(this.eHt);
                this.eKY.setOnImageClickListener(this.aRN);
                this.eKY.setOnLongClickListener(this.awo);
                this.eKY.setTbGestureDetector(this.aRO);
                this.eKY.ph(fVar != null ? fVar.aPQ().rx() : 0);
                this.eLb.b(fVar);
                this.eLb.setFromCDN(this.mIsFromCDN);
                this.eLb.setHostId(this.mHostId);
                this.eLb.iS(this.eHo);
                this.eLb.setCommonClickListener(this.cNL);
                this.eLb.G(this.eHt);
                this.eLb.setOnImageClickListener(this.aRN);
                this.eLb.setOnLongClickListener(this.awo);
                this.eLb.setTbGestureDetector(this.aRO);
                this.eKZ.setOnClickListener(this.cNL);
                this.eKZ.setTbGestureDetector(this.aRO);
                if (this.eLh != null && (this.eLh instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eLh).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.eLi != null && (this.eLi instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.eLi).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.crD != null && (this.crD instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.crD).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eLr.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.oY(this.eHn);
                        next.iS(this.eHo);
                        next.iT(this.eHp);
                        next.iU(this.eLx);
                        next.setCommonClickListener(this.cNL);
                        next.G(this.eHt);
                        next.setOnImageClickListener(this.aRN);
                        next.setOnLongClickListener(this.awo);
                    }
                }
                this.eLa.setCommonClickListener(this.cNL);
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>(fVar.aPS());
                Iterator<com.baidu.adp.widget.ListView.f> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.f next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).btg() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                cE(arrayList);
                if (this.eIu.aRq()) {
                    if (fVar.aPS().size() > 0 && (postData3 = fVar.aPS().get(0)) != null && postData3.btg() == 1 && !com.baidu.tbadk.core.util.u.v(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.eHq, arrayList, this.eHp);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.u.a(arrayList, b, this.eHq.aPT());
                    }
                }
                int c = c(this.eHq, arrayList, this.eHp);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.u.a(arrayList, c, this.eHq.aPU());
                }
                if (arrayList.size() == 0 && this.eIu.aRq()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.eHp);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.f> c2 = c(fVar, arrayList);
                    if (c2 != null && c2.size() > 0) {
                        com.baidu.tbadk.core.util.u.a((List) arrayList, a, (List) c2);
                    } else {
                        this.eLf = 0;
                    }
                } else {
                    this.eLf = 0;
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
                if (b2 >= 0 && fVar.aQn() != null) {
                    com.baidu.tbadk.core.util.u.a(arrayList, b2, fVar.aQn());
                    fVar.aQn().iR((b(arrayList, b2) || z4) ? false : true);
                    z4 = true;
                }
                this.eKY.ji(!z4);
                if (!this.eHp && fVar != null && fVar.aPS() != null && (size = fVar.aPS().size()) > 0 && (postData2 = fVar.aPS().get(size - 1)) != null && postData2.btg() == 1 && (size2 = arrayList.size()) > 0) {
                    arrayList.remove(size2 - 1);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (this.eIu.aQU() != null && postData != null && postData.getId() != null && postData.getId().equals(this.eIu.aQU().getPostId())) {
                    z5 = true;
                }
                if (!z5 && !z) {
                    if ((this.eLu || this.eLt) && a2 != -1 && !com.baidu.tbadk.core.util.u.v(d) && !this.eLv) {
                        this.eLA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                            @Override // java.lang.Runnable
                            public void run() {
                                g.this.mListView.setSelection(g.this.mListView.getHeaderViewsCount() + d.size());
                                g.this.eLv = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.ga().post(this.eLA);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, int i) {
        MetaData author;
        GodUserData godUserData;
        if (this.eIu.aPX() == null || this.eIu.aQT() == null) {
            return false;
        }
        if (this.eIu.aQT().aUt() || (author = this.eIu.aPX().getAuthor()) == null || (godUserData = author.getGodUserData()) == null || !godUserData.isBigV() || godUserData.getIsLike()) {
            return false;
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
        jVar.eGp = author;
        com.baidu.tbadk.core.util.u.a(arrayList, i + 1, jVar);
        jVar.eGq = true;
        if (!UtilHelper.isCurrentAccount(author.getUserId())) {
            jVar.eGr = true;
            return true;
        }
        jVar.eGr = false;
        return true;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        PostData postData;
        int i;
        int i2 = 0;
        if (fVar == null || com.baidu.tbadk.core.util.u.v(fVar.aPS()) || arrayList == null || arrayList.size() <= 0 || this.eIu.aRD() || this.eLw) {
            return -1;
        }
        if ((this.eIu.aQU() == null || !this.eIu.aQU().getIsFromMark()) && (postData = (PostData) com.baidu.tbadk.core.util.u.c(fVar.aPS(), 0)) != null) {
            int btg = postData.btg();
            int size = arrayList.size();
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
                if (fVar2 != null && (fVar2 instanceof PostData)) {
                    PostData postData2 = (PostData) fVar2;
                    if (postData2.btg() == btg && postData2.gkq == 0) {
                        i = btg == 1 ? i2 + 1 : i2;
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
        if (!this.eHp) {
            return -1;
        }
        if (fVar == null || com.baidu.tbadk.core.util.u.v(fVar.aPS()) || arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return -1;
            }
            com.baidu.adp.widget.ListView.f fVar2 = arrayList.get(i2);
            if (!(fVar2 instanceof PostData) || ((PostData) fVar2).btg() != 1) {
                i = i2 + 1;
            } else {
                return i2 + 1;
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.f> d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aQa() == null || com.baidu.tbadk.core.util.u.v(fVar.aQa().eGI) || this.eIu.aRD() || this.eLw) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aQa().eGI;
        if (com.baidu.tbadk.core.util.u.v(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.gks = true;
                arrayList.add(postData);
            }
        }
        int u = com.baidu.tbadk.core.util.u.u(fVar.aQa().eGJ);
        if (fVar.aQa().getCount() != u && u > 2) {
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

    public void aRN() {
        this.eLf = 0;
    }

    public int aRO() {
        return this.eLg;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.u.v(fVar.aPS()) || com.baidu.tbadk.core.util.u.v(fVar.aPR())) {
            return -1;
        }
        if (z) {
            return (fVar.aPS().get(0) == null || fVar.aPS().get(0).btg() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.f> c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (fVar == null || arrayList == null || fVar.aPR() == null || fVar.aPR().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<bl> aPR = fVar.aPR();
        int size = aPR.size();
        this.eLg = 0;
        if (this.eLf + 5 >= size) {
            int i2 = 0;
            for (bl blVar : aPR) {
                if (blVar != null) {
                    com.baidu.tieba.pb.video.k kVar = new com.baidu.tieba.pb.video.k();
                    int i3 = i2 + 1;
                    if (i3 == 1) {
                        kVar.a(blVar, true, true, true, i3);
                    } else {
                        kVar.a(blVar, true, true, false, i3);
                    }
                    arrayList2.add(kVar);
                    this.eLf++;
                    i = i3;
                } else {
                    i = i2;
                }
                i2 = i;
            }
            if (this.eLf <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.eLg = arrayList2.size();
            }
            return arrayList2;
        }
        int i4 = this.eLf + 5;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            bl blVar2 = aPR.get(i6);
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
                this.eLf++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.m());
        this.eLg = arrayList2.size();
        return arrayList2;
    }

    private void ahg() {
        if (this.eIu != null && !ahh()) {
            this.eIu.registerListener(this.coc);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ahh() {
        if (this.eIu == null) {
            return false;
        }
        this.cnU = new ArrayList();
        ArrayList<BdUniqueId> bsq = com.baidu.tieba.tbadkCore.n.bsq();
        if (bsq == null || bsq.size() <= 0) {
            return false;
        }
        int size = bsq.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aEp().a(this.eIu.getPageContext(), bsq.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cnU.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.u.v(this.cnU)) {
            this.mListView.addAdapters(this.cnU);
        }
        return true;
    }

    public int aRP() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPS() == null || fVar.aPT() == null || fVar.aPS().size() == 0 || fVar.aPQ() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPT().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPS().get(0) == null || fVar.aPS().get(0).btg() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qH() == null || fVar.qH().qB() != fVar.qH().qy()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z) {
        if (fVar == null || fVar.aPS() == null || fVar.aPU() == null || fVar.aPS().size() == 0 || fVar.aPQ() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aPU().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aPS().get(0) == null || fVar.aPS().get(0).btg() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qH() == null || fVar.qH().qB() != fVar.qH().qy()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.f getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aRQ() {
        return this.postList;
    }

    public BdUniqueId pe(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.eLm == null || !this.eLm.aQI()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aRR() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.eHq != null) {
            ArrayList<PostData> aPS = this.eHq.aPS();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aQe = this.eHq.aQe();
            if (aQe != null) {
                int size = aQe.size();
                if (aPS != null && aPS.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aQe.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.bsX() != null) {
                            sb.append(next.bsX());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aQe.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.csz = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aQe.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bsV() != null) {
                            int px = next3.bsV().px();
                            if (px != 0) {
                                a(next3, px);
                                if (px != 28 && px != 31) {
                                    if (next3.bsV().goods != null) {
                                        next3.bsV().goods.goods_style = TbErrInfo.ERR_IMG_GET_REMOTE;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bsV().apk_name)) {
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
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.bsX(), lVar3)) != null) {
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
                        if (this.eHq.aPO() != null) {
                            lVar4.forumId = this.eHq.aPO().getId();
                        }
                        if (this.eHq.aPQ() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.d(this.eHq.aPQ().getId(), 0L);
                        }
                        if (this.eHq != null && this.eHq.qH() != null) {
                            lVar4.pageNumber = this.eHq.qH().qB();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (a(lVar4, aPS)) {
                            aPS.add(lVar4);
                        } else if (position2 + i3 >= aPS.size()) {
                            a(lVar4, 2);
                            return;
                        } else {
                            aPS.add(position2, lVar4);
                            TiebaStatic.eventStat(this.eIu.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bsV().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 5);
        c.sf(i);
        com.baidu.tieba.recapp.report.b.biT().a(c);
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bsV() != null && lVar.bsV().goods != null && lVar.bsV().goods.goods_style != 1001 && lVar.bsV().goods.goods_style != -1001) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.d.c(lVar, 5);
            c.sf(i);
            com.baidu.tieba.recapp.report.b.biT().a(c);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aPO;
        if (lVar != null && this.eHq != null && lVar.bsV() != null) {
            lVar.bsV().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eHq.qH() != null) {
                lVar.bsV().advertAppContext.pn = this.eHq.qH().qB();
            }
            lVar.bsV().advertAppContext.Uo = "PB";
            if (this.eHq.aPO() != null && (aPO = this.eHq.aPO()) != null) {
                lVar.bsV().advertAppContext.fid = aPO.getId();
                lVar.bsV().advertAppContext.Uq = aPO.getFirst_class();
                lVar.bsV().advertAppContext.Ur = aPO.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bsV().advertAppContext.Us = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bsV().advertAppContext.extensionInfo = lVar.bsV().ext_info;
            lVar.bsV().advertAppContext.Ut = false;
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
        if (this.eHq != null && this.eHq.qH() != null) {
            lVar.pageNumber = this.eHq.qH().qB();
        }
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eLn.setFromCDN(z);
        this.eKY.setFromCDN(z);
        if (this.eLh != null && (this.eLh instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eLh).setIsFromCDN(z);
        }
        if (this.eLi != null && (this.eLi instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eLi).setIsFromCDN(z);
        }
        if (this.crD != null && (this.crD instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.crD).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eLr.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void iS(boolean z) {
        this.eHo = z;
    }

    public void iT(boolean z) {
        this.eHp = z;
    }

    public void iU(boolean z) {
        this.eLx = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eHt = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aRN = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.aRO = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awo = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.cNL = onClickListener;
    }

    public void pf(int i) {
        if (this.eKZ != null) {
            this.eKZ.pf(i);
        }
        switch (i) {
            case 1:
                if (this.eLm != null) {
                    this.eLm.pause();
                }
                if (this.eKY != null) {
                    this.eKY.pause();
                }
                if (this.eLj != null && (this.eLj instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eLj).release();
                    return;
                }
                return;
            case 2:
                if (this.eLm != null) {
                    this.eLm.resume();
                }
                if (this.eKY != null) {
                    this.eKY.resume();
                }
                if (this.eLj != null && (this.eLj instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eLj).resume();
                    return;
                }
                return;
            case 3:
                if (this.eLm != null) {
                    this.eLm.release();
                }
                if (this.eKY != null) {
                    this.eKY.release();
                }
                if (this.eLj != null && (this.eLj instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.eLj).release();
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
                    if (!TextUtils.isEmpty(postData.sA())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.cE(postData.sA());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.eLA);
    }

    public void je(boolean z) {
        this.eLw = z;
    }

    public void jf(boolean z) {
        this.eLt = z;
    }

    public void jg(boolean z) {
        this.eLu = z;
    }

    public void jh(boolean z) {
        this.eLv = z;
    }

    public am aRS() {
        return this.eKZ;
    }
}
