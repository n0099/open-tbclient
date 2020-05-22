package com.baidu.tieba.pb.pb.main;

import android.support.annotation.NonNull;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class g {
    private ArrayList<com.baidu.adp.widget.ListView.o> eVf;
    private BdTypeListView faQ;
    private List<com.baidu.adp.widget.ListView.a> hFh;
    private com.baidu.adp.widget.ListView.a iep;
    private PbFragment jGF;
    private boolean jHA;
    private int jHC;
    private Runnable jHH;
    private int jHJ;
    private q jHd;
    private com.baidu.tieba.pb.pb.main.adapter.c jHe;
    private com.baidu.tieba.pb.pb.main.adapter.d jHf;
    private com.baidu.tieba.pb.pb.main.adapter.a jHg;
    private ap jHh;
    private ap jHi;
    private k jHj;
    private com.baidu.tieba.pb.video.a jHk;
    private com.baidu.tieba.card.divider.a jHl;
    private com.baidu.adp.widget.ListView.a jHm;
    private al jHn;
    private am jHo;
    private aj jHp;
    private com.baidu.tieba.pb.pb.a.c jHq;
    private h jHs;
    private w jHt;
    private com.baidu.tieba.pb.data.e jHu;
    private boolean jHz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> jHr = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean jHv = true;
    private boolean jHw = true;
    private boolean jHx = false;
    private boolean jHy = false;
    private boolean jHB = false;
    private String aPJ = null;
    private PostData jHD = null;
    private View.OnClickListener jHE = null;
    private View.OnClickListener aIH = null;
    private TbRichTextView.i eBC = null;
    private com.baidu.tieba.pb.a.c efF = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a jHF = null;
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> jHG = new ArrayList();
    private int jHI = -1;
    private CustomMessageListener huy = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dcZ = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dcZ();
                Iterator it = dcZ.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).a(g.this.jGF);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.jHr.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dcZ);
                g.this.jHG.clear();
                g.this.jHG.addAll(arrayList);
                if (g.this.faQ != null) {
                    g.this.faQ.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener edg = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.jHu != null && !com.baidu.adp.base.i.E(g.this.jGF.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener jHK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.jGF != null && g.this.jHu != null && g.this.jHu.cCw() != null) {
                g.this.jGF.cEo().cHn().cDt();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener hFj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(g.this.hFh)) {
                g.this.cgj();
                g.this.a(g.this.jHu, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.jHC = 0;
        this.width = -1;
        this.jHJ = 0;
        this.jHC = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.jHC;
        this.jGF = pbFragment;
        this.faQ = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.edg);
        this.jHJ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jGF.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.jHd = new q(pbFragment, PostData.lkI);
        this.jHd.a((TbRichTextView.c) pbFragment);
        this.jHe = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.m.jFp);
        this.jHf = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.g.TYPE);
        this.jHg = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.jDJ);
        this.jHh = new ap(pbFragment, com.baidu.tieba.pb.data.l.jFi);
        this.jHi = new ap(pbFragment, com.baidu.tieba.pb.data.l.jFj);
        this.jHj = new k(pbFragment, PostData.lkJ);
        this.jHj.a((TbRichTextView.c) pbFragment);
        this.iep = com.baidu.tieba.recapp.q.cUm().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dAi);
        this.jHm = com.baidu.tieba.recapp.q.cUm().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dAm);
        this.jHp = new aj(pbFragment, com.baidu.tieba.pb.data.j.VD);
        this.jHn = new al(pbFragment, ai.jPx);
        this.jHo = new am(pbFragment, com.baidu.tbadk.core.data.as.dDq);
        this.jHq = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.lkO);
        this.jHk = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.kaz);
        this.jHl = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.jHs = new h(pbFragment, com.baidu.tbadk.core.data.k.dBs);
        this.jHt = new w(pbFragment, pbFragment.getUniqueId());
        this.aSj.add(this.jHd);
        this.aSj.add(this.jHe);
        this.aSj.add(this.jHf);
        this.aSj.add(this.jHg);
        this.aSj.add(this.jHj);
        this.aSj.add(this.jHh);
        this.aSj.add(this.jHi);
        this.aSj.add(this.iep);
        this.aSj.add(this.jHm);
        this.aSj.add(this.jHp);
        this.aSj.add(this.jHn);
        this.aSj.add(this.jHo);
        this.aSj.add(this.jHk);
        this.aSj.add(this.jHq);
        this.aSj.add(this.jHl);
        this.aSj.add(this.jHs);
        this.aSj.add(this.jHt);
        this.huy.setPriority(1);
        this.huy.setSelfListener(true);
        pbFragment.registerListener(this.huy);
        cgi();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.aSj);
    }

    public void a(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        x xVar;
        boolean z5;
        int i2;
        com.baidu.adp.widget.ListView.o oVar;
        PostData postData;
        if (eVar != null) {
            boolean z6 = false;
            if (this.jHu != eVar) {
                z6 = eVar.cCg() && TbadkCoreApplication.getInst().isRecAppExist();
            }
            this.jHu = eVar;
            if (z6) {
                cDX();
                eVar.rb(false);
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.jHu != null && this.jHu.cCk() != null && this.jHu.cCk().size() > 0) {
                this.postList.addAll(this.jHu.cCk());
            }
            if (eVar.cCi() != null && eVar.cCi().aQx() != null) {
                this.aPJ = eVar.cCi().aQx().getUserId();
            }
            if (this.jHd != null) {
                f(eVar);
                ArrayList<com.baidu.adp.widget.ListView.o> arrayList = new ArrayList<>(eVar.cCk());
                PostData aM = aM(arrayList);
                boolean z7 = aM != null;
                if (aM != null) {
                    this.jHD = aM;
                }
                boolean z8 = false;
                if (!this.jHw && aM != null) {
                    arrayList.remove(aM);
                    z8 = true;
                    z7 = true;
                    if (eVar.aWi() && aM.ddw() != null) {
                        aM.c(null);
                    }
                }
                if (!z7 && eVar.cCr() != null) {
                    aM = eVar.cCr();
                    z8 = true;
                    z7 = true;
                    if (!this.jHw && eVar.aWi() && aM.ddw() != null) {
                        aM.c(null);
                    }
                }
                boolean z9 = z8;
                PostData postData2 = aM;
                dW(arrayList);
                if (this.jGF.cEM()) {
                    if (eVar.cCk().size() > 0 && (postData = eVar.cCk().get(0)) != null && postData.ddu() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.jHu, arrayList, this.jHw);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList, b, this.jHu.cCl());
                    }
                }
                int c = c(this.jHu, arrayList, this.jHw);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList, c, this.jHu.cCm());
                }
                com.baidu.tieba.tbadkCore.t.s(arrayList, 1);
                boolean z10 = false;
                int b2 = b(eVar, arrayList);
                if (b2 >= 0) {
                    z10 = true;
                    a(eVar, arrayList, b2);
                }
                int a = a(eVar, arrayList);
                List<com.baidu.adp.widget.ListView.o> g = g(eVar);
                if (com.baidu.tbadk.core.util.v.isEmpty(g) || a < 0) {
                    z2 = z10;
                } else {
                    com.baidu.adp.widget.ListView.o oVar2 = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, a);
                    if (oVar2 instanceof PostData) {
                        ((PostData) oVar2).llw = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList, a, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z7) {
                    i3 = a(eVar, arrayList, this.jHw);
                }
                if (i3 >= 0 && eVar.cCG() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList, i3, eVar.cCG());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.llv = true;
                    }
                    z3 = false;
                    z4 = z2;
                }
                int i4 = b(eVar, arrayList, i3) != null ? i3 + 1 : i3;
                int i5 = c(eVar, arrayList, i4) != null ? i4 + 1 : i4;
                int i6 = -1;
                if (!z7) {
                    i = -1;
                    xVar = null;
                    z5 = false;
                } else {
                    com.baidu.adp.widget.ListView.o b3 = b(arrayList, i5);
                    boolean z11 = b3 != null;
                    if (z11) {
                        i2 = -1;
                        oVar = b3;
                    } else {
                        if (i5 >= 0) {
                            i6 = i5 + 1;
                        } else if (a >= 0) {
                            i6 = a;
                        } else if (b2 >= 0) {
                            i6 = b2;
                        }
                        com.baidu.adp.widget.ListView.o c2 = c(arrayList, i6);
                        z11 = c2 != null;
                        i2 = i6;
                        oVar = c2;
                    }
                    x a2 = a(arrayList, oVar, i5, i2);
                    if (a2 == null) {
                        i = i2;
                        xVar = a2;
                        z5 = z11;
                    } else if (!z11) {
                        i = i2;
                        xVar = a2;
                        z5 = true;
                    } else if (i2 > 0) {
                        i = i2 + 1;
                        xVar = a2;
                        z5 = z11;
                    } else {
                        i5++;
                        i = i2;
                        xVar = a2;
                        z5 = z11;
                    }
                }
                if (z7) {
                    boolean a3 = a(eVar, arrayList, z5, xVar != null, i, i5, a, b2);
                    if (xVar != null) {
                        xVar.jMO = a3;
                    }
                }
                this.jHd.rr(!z4);
                boolean h = h(postData2);
                if (this.jHx && !h) {
                    arrayList.remove(postData2);
                    this.jHx = false;
                }
                if (eVar.cCG() != null) {
                    eVar.cCG().rd(!z3);
                }
                if (this.faQ != null) {
                    this.eVf = arrayList;
                    this.faQ.setData(this.eVf);
                }
                a(h, z, a, g);
                if (a(postData2, arrayList, z9)) {
                    this.faQ.setData(arrayList);
                }
            }
        }
    }

    private PostData aM(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.o> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.o next = it.next();
            if ((next instanceof PostData) && ((PostData) next).ddu() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jFi);
        bk cCi = eVar.cCi();
        lVar.jFk = cCi != null ? cCi.aQo() : 0L;
        lVar.isNew = !this.jHw;
        lVar.jFn = this.jGF.cEW();
        lVar.sortType = eVar.jDW;
        lVar.jFm = eVar.cCK();
        lVar.isDynamic = eVar.cCJ();
        lVar.jFo = eVar.jDV;
        com.baidu.tbadk.core.util.v.add(arrayList, i, lVar);
    }

    private com.baidu.adp.widget.ListView.o b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        com.baidu.tieba.pb.data.g gVar;
        if (com.baidu.tbadk.a.d.aMr() && eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.jGF.cDy().cDp()) || !this.jGF.cDy().cFw())) {
            if (!this.jGF.cDo() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cCE())) {
                gVar = new com.baidu.tieba.pb.data.g(eVar.cCE().get(0));
            } else {
                gVar = new com.baidu.tieba.pb.data.g(eVar.getForum());
            }
            gVar.tid = this.jGF.cDy().cFt();
            com.baidu.tbadk.core.util.v.add(arrayList, i + 1, gVar);
            return gVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.jGF.cDy() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.jGF.cDy().cFr())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.o> list) {
        if (!z && !z2) {
            if ((this.jHz || this.jHy) && i != -1 && !com.baidu.tbadk.core.util.v.isEmpty(list) && !this.jHA) {
                this.jHH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.faQ.setSelectionFromTop(g.this.faQ.getHeaderViewsCount() + list.size(), 0 - g.this.jHJ);
                        g.this.jHA = false;
                    }
                };
                com.baidu.adp.lib.f.e.ld().post(this.jHH);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z) {
        if (postData == null) {
            if (this.jHD != null && !this.jHy) {
                com.baidu.tbadk.core.util.v.add(arrayList, 0, this.jHD);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.DS(1);
            com.baidu.tbadk.core.util.v.add(arrayList, 0, postData2);
            return true;
        } else if (z) {
            com.baidu.tbadk.core.util.v.add(arrayList, 0, postData);
            return true;
        } else {
            return false;
        }
    }

    private boolean a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        ArrayList arrayList2 = new ArrayList();
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cCI()) && eVar.cCI().size() > 2) {
            int min = Math.min(eVar.cCI().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.k kVar = eVar.cCI().get(i5);
                if (!z2 && i5 == 0) {
                    kVar.gK(true);
                }
                if (kVar.aQQ() == null) {
                    if (i5 == min - 1) {
                        kVar.gL(true);
                    }
                } else if (i5 == min - 2) {
                    kVar.gL(true);
                } else if (i5 == min - 1) {
                    kVar.gM(true);
                }
                arrayList2.add(kVar);
            }
        }
        if (arrayList2.size() > 0) {
            if (z && i >= 0) {
                i3 = i + 1;
            } else if (z) {
                i3 = i2 + 2;
            } else if (i2 >= 0) {
                i3 = i2 + 1;
            } else if (i3 < 0) {
                i3 = i4 >= 0 ? i4 : -1;
            }
            if (i3 >= 0 && arrayList2.size() > 1) {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    com.baidu.tbadk.core.util.v.add(arrayList, i3, arrayList2.get(size));
                }
                return true;
            }
        }
        return false;
    }

    private com.baidu.adp.widget.ListView.o c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        if (i < 0 || eVar == null || !eVar.jEa || eVar.jEb == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = eVar.jEb;
        com.baidu.tbadk.core.util.v.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.e eVar) {
        this.jHd.setData(eVar);
        this.jHd.setFromCDN(this.mIsFromCDN);
        this.jHd.setImageMaxWidth(this.jHC);
        this.jHd.re(this.jHv);
        this.jHd.y(this.aIH);
        this.jHd.Q(this.jHE);
        this.jHd.setOnImageClickListener(this.eBC);
        this.jHd.setOnLongClickListener(this.mOnLongClickListener);
        this.jHd.setTbGestureDetector(this.efF);
        this.jHj.setData(eVar);
        this.jHj.setFromCDN(this.mIsFromCDN);
        this.jHj.fl(this.aPJ);
        this.jHj.re(this.jHv);
        this.jHj.y(this.aIH);
        this.jHj.Q(this.jHE);
        this.jHj.setOnImageClickListener(this.eBC);
        this.jHj.setOnLongClickListener(this.mOnLongClickListener);
        this.jHj.setTbGestureDetector(this.efF);
        this.jHe.setOnClickListener(this.aIH);
        this.jHq.setOnClickListener(this.aIH);
        this.jHk.setOnClickListener(this.jHK);
        if (this.jHm != null && (this.jHm instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.jHm).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.jHr.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(eVar);
                next.setFromCDN(this.mIsFromCDN);
                next.fl(this.aPJ);
                next.setImageMaxWidth(this.jHC);
                next.re(this.jHv);
                next.rf(this.jHw);
                next.rg(this.jHB);
                next.y(this.aIH);
                next.Q(this.jHE);
                next.setOnImageClickListener(this.eBC);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.jHh.y(this.aIH);
        this.jHh.a(this.jHF);
        this.jHi.y(this.aIH);
        this.jHh.setData(eVar);
        this.jHg.setData(eVar);
        this.jHi.setData(eVar);
        this.jHn.setData(eVar);
        this.jHo.setData(eVar);
        this.jHs.setPbData(eVar);
        this.jHs.setFrom(this.jGF.jLc);
        this.jHt.setPbData(eVar);
    }

    private x a(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, com.baidu.adp.widget.ListView.o oVar, int i, int i2) {
        x cCn = this.jHu.cCn();
        if (cCn != null) {
            if (oVar != null) {
                if (i2 < 0 && oVar.getType() != AdvertAppInfo.dAm) {
                    i2 = i + 2;
                } else if (oVar.getType() == AdvertAppInfo.dAm) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (cCn instanceof x)) {
                com.baidu.tbadk.core.util.v.add(arrayList, i2, cCn);
                return cCn;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.o b(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        PbModel cDy;
        if (i >= 0 && (cDy = this.jGF.cDy()) != null) {
            String cGj = cDy.cGj();
            if (TextUtils.isEmpty(cGj)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.MA(cGj);
            c(nVar);
            com.baidu.tbadk.core.util.v.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.o c(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        if (this.jHu == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n cFH = this.jGF.cDy().cFH();
        if (cFH == null) {
            cFH = this.jHu.cCA();
        }
        if (cFH != null) {
            AdvertAppInfo.ILegoAdvert ddj = cFH.ddj();
            if (ddj != null) {
                ddj.setAdvertAppInfo(cFH.pu());
            }
            int aOy = cFH.ddi().aOy();
            if (aOy != 0) {
                a(cFH, aOy);
                if (aOy == 28 || aOy == 31 || cFH.ddi().goods == null) {
                    return null;
                }
                cFH.ddi().goods.goods_style = -1001;
                return null;
            }
            if (this.jHu.getForum() != null) {
                cFH.forumId = this.jHu.getForum().getId();
            }
            if (this.jHu.cCi() != null) {
                cFH.threadId = com.baidu.adp.lib.f.b.toLong(this.jHu.cCi().getId(), 0L);
            }
            if (this.jHu != null && this.jHu.getPage() != null) {
                cFH.pageNumber = this.jHu.getPage().aPr();
            }
            c(cFH);
            if (i >= 0) {
                com.baidu.tbadk.core.util.v.add(arrayList, i, cFH);
                return cFH;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        boolean z;
        int i;
        if (this.jHy || eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cCk()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.aWi() && this.jHw) ? 0 : -1;
        } else if (this.jGF.cDy() == null || !this.jGF.cDy().getIsFromMark()) {
            if (this.jGF.cEo() == null || !this.jGF.cEo().cIp()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.o oVar = arrayList.get(i2);
                    if (oVar instanceof PostData) {
                        PostData postData = (PostData) oVar;
                        if (postData.ddu() == 1 && postData.lls == 0) {
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
                return eVar.aWi() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        boolean z;
        int i;
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cCk()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cCk(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.o oVar = arrayList.get(i2);
            if (oVar instanceof PostData) {
                PostData postData = (PostData) oVar;
                if (postData.ddu() == 1 && postData.lls == 0) {
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

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z) {
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cCk()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.aWi()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.cCk().get(0) == null || eVar.cCk().get(0).ddu() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.o> g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cCw() == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cCw().jFy)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.cCw().jFy;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.llG = true;
                postData.llu = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(eVar.cCw().jFz) > 2) {
            com.baidu.adp.widget.ListView.o oVar = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (oVar instanceof PostData) {
                ((PostData) oVar).llu = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.o oVar2 = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (oVar2 instanceof PostData) {
                ((PostData) oVar2).llu = true;
            }
        }
        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jFj);
        lVar.jFl = eVar.cCw().forum_top_list;
        arrayList.add(0, lVar);
        return arrayList;
    }

    private void cgi() {
        if (this.jGF != null && !cgj()) {
            this.jGF.registerListener(this.hFj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgj() {
        if (this.jGF == null) {
            return false;
        }
        this.hFh = new ArrayList();
        ArrayList<BdUniqueId> dcL = com.baidu.tieba.tbadkCore.t.dcL();
        if (dcL == null || dcL.size() <= 0) {
            return false;
        }
        int size = dcL.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cuF().a(this.jGF.getPageContext(), dcL.get(i), 2);
            if (a != null) {
                this.aSj.add(a);
                this.hFh.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.hFh)) {
            this.faQ.addAdapters(this.hFh);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.faQ.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z) {
        if (eVar == null || eVar.cCk() == null || eVar.cCl() == null || eVar.cCk().size() == 0 || eVar.cCi() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cCl().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cCk().get(0) == null || eVar.cCk().get(0).ddu() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aPr() != eVar.getPage().aPo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z) {
        if (eVar == null || eVar.cCk() == null || eVar.cCm() == null || eVar.cCk().size() == 0 || eVar.cCi() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cCm().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cCk().get(0) == null || eVar.cCk().get(0).ddu() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aPr() != eVar.getPage().aPo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.o getItem(int i) {
        return this.faQ.getItem(i);
    }

    public ArrayList<PostData> cDU() {
        return this.postList;
    }

    public BdUniqueId zZ(int i) {
        if (this.faQ.getItem(i) != null) {
            return this.faQ.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.jHI = cDV();
        if (this.faQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }

    public int cDV() {
        if (this.faQ != null && this.faQ.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.faQ.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.o oVar = this.faQ.getData().get(i2);
                if (oVar == null || oVar.getType() != com.baidu.tieba.pb.data.l.jFi) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cDW() {
        return this.jHI;
    }

    private void cDX() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.jHu != null) {
            ArrayList<PostData> cCk = this.jHu.cCk();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cCz = this.jHu.cCz();
            if (cCz != null) {
                int size = cCz.size();
                if (cCk != null && cCk.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it = cCz.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next = it.next();
                        if (next != null && next.getAdId() != null) {
                            sb.append(next.getAdId());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cCz.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                        if (next2 != null) {
                            next2.hFf = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cCz.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                        if (next3.ddi() != null) {
                            int aOy = next3.ddi().aOy();
                            if (aOy != 0) {
                                a(next3, aOy);
                                if (aOy != 28 && aOy != 31) {
                                    if (next3.ddi().goods != null) {
                                        next3.ddi().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.x.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.ddi().apk_name)) {
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
                        com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(sparseArray.keyAt(i));
                        if (nVar3 != null && (nVar2 = (com.baidu.tieba.tbadkCore.data.n) hashMap.put(nVar3.getAdId(), nVar3)) != null) {
                            b(nVar2, 30);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (nVar = (com.baidu.tieba.tbadkCore.data.n) entry.getValue()) != null) {
                            sparseArray.put(nVar.getPosition(), nVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.g.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.jHu.getForum() != null) {
                            nVar4.forumId = this.jHu.getForum().getId();
                        }
                        if (this.jHu.cCi() != null) {
                            nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.jHu.cCi().getId(), 0L);
                        }
                        if (this.jHu != null && this.jHu.getPage() != null) {
                            nVar4.pageNumber = this.jHu.getPage().aPr();
                        }
                        c(nVar4);
                        int position2 = nVar4.getPosition();
                        if (position2 + i3 >= cCk.size()) {
                            a(nVar4, 2);
                            return;
                        }
                        if (!this.jHw) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(nVar4, 23);
                            return;
                        }
                        cCk.add(position2, nVar4);
                        TiebaStatic.eventStat(this.jGF.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.ddi().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.Cs(i);
        com.baidu.tieba.recapp.report.d.cVk().a(c);
        if (nVar != null && nVar.ddi() != null) {
            nVar.ddi().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.ddi() != null && nVar.ddi().goods != null && nVar.ddi().goods.goods_style != 1001 && nVar.ddi().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.jHu != null && nVar.ddi() != null) {
            nVar.ddi().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.jHu.getPage() != null) {
                nVar.ddi().advertAppContext.pn = this.jHu.getPage().aPr();
            }
            nVar.ddi().advertAppContext.page = nVar.ddl();
            if (this.jHu.getForum() != null && (forum = this.jHu.getForum()) != null) {
                nVar.ddi().advertAppContext.fid = forum.getId();
                nVar.ddi().advertAppContext.dzZ = forum.getFirst_class();
                nVar.ddi().advertAppContext.dAa = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.ddi().advertAppContext.dAb = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.ddi().advertAppContext.extensionInfo = nVar.ddi().ext_info;
            nVar.ddi().advertAppContext.WZ = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.jHd.setFromCDN(z);
        if (this.jHm != null && (this.jHm instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.jHm).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.jHr.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cDY() {
        return this.jHv;
    }

    public void re(boolean z) {
        this.jHv = z;
    }

    public void rf(boolean z) {
        this.jHw = z;
    }

    public void rg(boolean z) {
        this.jHB = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jHE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBC = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.efF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.jHF = aVar;
    }

    public void Aa(int i) {
        switch (i) {
            case 1:
                if (this.jHd != null) {
                    this.jHd.pause();
                    return;
                }
                return;
            case 2:
                if (this.jHd != null) {
                    this.jHd.resume();
                    return;
                }
                return;
            case 3:
                if (this.jHd != null) {
                    this.jHd.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dW(List<com.baidu.adp.widget.ListView.o> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.aRI())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.vt(postData.aRI());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jHH);
        if (this.jHh != null) {
            this.jHh.onDestroy();
        }
        if (this.jHi != null) {
            this.jHi.onDestroy();
        }
        if (this.jHe != null) {
            this.jHe.onDestroy();
        }
        if (this.jHg != null) {
            this.jHg.onDestroy();
        }
    }

    public void rk(boolean z) {
        this.jHy = z;
    }

    public void rl(boolean z) {
        this.jHz = z;
    }

    public void rm(boolean z) {
        this.jHx = z;
    }

    public void rn(boolean z) {
        this.jHA = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cDZ() {
        return this.jHe;
    }

    public ArrayList<com.baidu.adp.widget.ListView.o> getDataList() {
        return this.eVf;
    }

    public View cEa() {
        if (this.jHd == null || this.jHd.cEd() == null) {
            return null;
        }
        if (this.jHd.cEd().jJG != null && this.jHd.cEd().jJG.isShown()) {
            return this.jHd.cEd().jJG;
        }
        return this.jHd.cEd().jJF;
    }

    public r cEb() {
        if (this.jHd == null || this.jHd.cEd() == null) {
            return null;
        }
        return this.jHd.cEd();
    }
}
