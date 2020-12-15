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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes22.dex */
public class g {
    private ArrayList<com.baidu.adp.widget.ListView.q> ghy;
    private BdTypeListView gpZ;
    private com.baidu.adp.widget.ListView.a jTX;
    private List<com.baidu.adp.widget.ListView.a> jqr;
    private PbFragment lDI;
    private boolean lEA;
    private boolean lEB;
    private int lED;
    private Runnable lEI;
    private int lEK;
    private s lEe;
    private com.baidu.tieba.pb.pb.main.adapter.c lEf;
    private com.baidu.tieba.pb.pb.main.adapter.d lEg;
    private com.baidu.tieba.pb.pb.main.adapter.a lEh;
    private at lEi;
    private at lEj;
    private m lEk;
    private com.baidu.tieba.pb.video.a lEl;
    private com.baidu.tieba.card.divider.a lEm;
    private com.baidu.adp.widget.ListView.a lEn;
    private ap lEo;
    private aq lEp;
    private an lEq;
    private com.baidu.tieba.pb.pb.a.j lEr;
    private h lEt;
    private y lEu;
    private com.baidu.tieba.pb.data.f lEv;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> lEs = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lEw = true;
    private boolean lEx = true;
    private boolean lEy = false;
    private boolean lEz = false;
    private boolean lEC = false;
    private String bkt = null;
    private PostData lEE = null;
    private View.OnClickListener lEF = null;
    private View.OnClickListener bbH = null;
    private TbRichTextView.i fNk = null;
    private com.baidu.tieba.pb.a.c fos = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lEG = null;
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lEH = new ArrayList();
    private int lEJ = -1;
    private CustomMessageListener jbM = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dON = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dON();
                Iterator it = dON.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.lDI);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.lEs.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dON);
                g.this.lEH.clear();
                g.this.lEH.addAll(arrayList);
                if (g.this.gpZ != null) {
                    g.this.gpZ.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener flC = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.lEv != null && !com.baidu.adp.base.i.H(g.this.lDI.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener lEL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lDI != null && g.this.lEv != null && g.this.lEv.dni() != null) {
                g.this.lDI.dpc().dsk().doh();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12040"));
            }
        }
    };
    private CustomMessageListener jqt = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.jqr)) {
                g.this.cQh();
                g.this.a(g.this.lEv, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lED = 0;
        this.width = -1;
        this.lEK = 0;
        this.lED = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lED;
        this.lDI = pbFragment;
        this.gpZ = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.flC);
        this.lEK = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lDI.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lEe = new s(pbFragment, PostData.nlI);
        this.lEe.a((TbRichTextView.c) pbFragment);
        this.lEf = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.lCj);
        this.lEg = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lEh = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lAy);
        this.lEi = new at(pbFragment, com.baidu.tieba.pb.data.n.lCc);
        this.lEj = new at(pbFragment, com.baidu.tieba.pb.data.n.lCd);
        this.lEk = new m(pbFragment, PostData.nlJ);
        this.lEk.a((TbRichTextView.c) pbFragment);
        this.jTX = com.baidu.tieba.recapp.r.dFg().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eDR);
        this.lEn = com.baidu.tieba.recapp.r.dFg().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eDV);
        this.lEq = new an(pbFragment, com.baidu.tieba.pb.data.l.Yt);
        this.lEo = new ap(pbFragment, am.lNA);
        this.lEp = new aq(pbFragment, com.baidu.tbadk.core.data.bb.eHq);
        this.lEr = new com.baidu.tieba.pb.pb.a.j(pbFragment, PostData.nlN);
        this.lEl = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.lYJ);
        this.lEm = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lEt = new h(pbFragment, com.baidu.tbadk.core.data.o.eFe);
        this.lEu = new y(pbFragment, pbFragment.getUniqueId());
        this.bnf.add(this.lEe);
        this.bnf.add(this.lEf);
        this.bnf.add(this.lEg);
        this.bnf.add(this.lEh);
        this.bnf.add(this.lEk);
        this.bnf.add(this.lEi);
        this.bnf.add(this.lEj);
        this.bnf.add(this.jTX);
        this.bnf.add(this.lEn);
        this.bnf.add(this.lEq);
        this.bnf.add(this.lEo);
        this.bnf.add(this.lEp);
        this.bnf.add(this.lEl);
        this.bnf.add(this.lEr);
        this.bnf.add(this.lEm);
        this.bnf.add(this.lEt);
        this.bnf.add(this.lEu);
        this.jbM.setPriority(1);
        this.jbM.setSelfListener(true);
        pbFragment.registerListener(this.jbM);
        cQg();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.bnf);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        z zVar;
        boolean z5;
        int i2;
        com.baidu.adp.widget.ListView.q qVar;
        PostData postData;
        if (fVar != null) {
            this.lEv = fVar;
            doK();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lEv != null && this.lEv.dmW() != null && this.lEv.dmW().size() > 0) {
                this.postList.addAll(this.lEv.dmW());
            }
            if (fVar.dmU() != null && fVar.dmU().boP() != null) {
                this.bkt = fVar.dmU().boP().getUserId();
            }
            if (this.lEe != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.dmW());
                PostData bc = bc(arrayList);
                boolean z6 = bc != null;
                if (bc != null) {
                    this.lEE = bc;
                }
                boolean z7 = false;
                if (!this.lEx && bc != null) {
                    arrayList.remove(bc);
                    z7 = true;
                    z6 = true;
                    if (fVar.dnv() && bc.dPj() != null) {
                        bc.c(null);
                    }
                }
                if (!z6 && fVar.dnd() != null) {
                    bc = fVar.dnd();
                    z7 = true;
                    z6 = true;
                    if (!this.lEx && fVar.dnv() && bc.dPj() != null) {
                        bc.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = bc;
                fn(arrayList);
                if (this.lDI.dpA()) {
                    if (fVar.dmW().size() > 0 && (postData = fVar.dmW().get(0)) != null && postData.dPh() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.lEv, arrayList, this.lEx);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.lEv.dmX());
                    }
                }
                int c = c(this.lEv, arrayList, this.lEx);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.lEv.dmY());
                }
                com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
                boolean z9 = false;
                int b2 = b(fVar, arrayList);
                if (b2 >= 0) {
                    z9 = true;
                    a(fVar, arrayList, b2);
                }
                int a2 = a(fVar, arrayList);
                List<com.baidu.adp.widget.ListView.q> g = g(fVar);
                if (com.baidu.tbadk.core.util.y.isEmpty(g) || a2 < 0) {
                    z2 = z9;
                } else {
                    com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, a2);
                    if (qVar2 instanceof PostData) {
                        ((PostData) qVar2).nmu = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.lEx);
                }
                if (i3 >= 0 && fVar.dnu() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, fVar.dnu());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.nmt = true;
                    }
                    z3 = false;
                    z4 = z2;
                }
                int i4 = b(fVar, arrayList, i3) != null ? i3 + 1 : i3;
                int i5 = c(fVar, arrayList, i4) != null ? i4 + 1 : i4;
                int i6 = -1;
                if (!z6) {
                    i = -1;
                    zVar = null;
                    z5 = false;
                } else {
                    com.baidu.adp.widget.ListView.q c2 = c(arrayList, i5);
                    boolean z10 = c2 != null;
                    if (z10) {
                        i2 = -1;
                        qVar = c2;
                    } else {
                        if (i5 >= 0) {
                            i6 = i5 + 1;
                        } else if (a2 >= 0) {
                            i6 = a2;
                        } else if (b2 >= 0) {
                            i6 = b2;
                        }
                        com.baidu.adp.widget.ListView.q d = d(arrayList, i6);
                        z10 = d != null;
                        i2 = i6;
                        qVar = d;
                    }
                    z a3 = a(arrayList, qVar, i5, i2);
                    if (a3 == null) {
                        i = i2;
                        zVar = a3;
                        z5 = z10;
                    } else if (!z10) {
                        i = i2;
                        zVar = a3;
                        z5 = true;
                    } else if (i2 > 0) {
                        i = i2 + 1;
                        zVar = a3;
                        z5 = z10;
                    } else {
                        i5++;
                        i = i2;
                        zVar = a3;
                        z5 = z10;
                    }
                }
                if (z6) {
                    boolean a4 = a(fVar, arrayList, z5, zVar != null, i, i5, a2, b2);
                    if (zVar != null) {
                        zVar.lKp = a4;
                    }
                }
                this.lEe.uL(!z4);
                boolean h = h(postData2);
                if (this.lEy && !h) {
                    arrayList.remove(postData2);
                    this.lEy = false;
                }
                if (fVar.dnu() != null) {
                    fVar.dnu().ux(!z3);
                }
                if (this.gpZ != null) {
                    this.ghy = arrayList;
                    this.gpZ.setData(this.ghy);
                }
                a(h, z, a2, g);
                if (a(postData2, arrayList, z8)) {
                    this.gpZ.setData(arrayList);
                }
            }
        }
    }

    private PostData bc(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dPh() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCc);
        by dmU = fVar.dmU();
        nVar.lCe = dmU != null ? dmU.boG() : 0L;
        nVar.isNew = !this.lEx;
        nVar.lCh = this.lDI.dpK();
        nVar.sortType = fVar.lAM;
        nVar.lCg = fVar.dnz();
        nVar.isDynamic = fVar.dny();
        nVar.lCi = fVar.lAL;
        com.baidu.tbadk.core.util.y.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lDI.dol().doe()) || !this.lDI.dol().dqn())) {
            if (!this.lDI.dod() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dnr())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.dnr().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lDI.dol().dqk();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.lDI.dol() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lDI.dol().dqi())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.lEA || this.lEz) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.lEB) {
                this.lEI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gpZ.setSelectionFromTop(g.this.gpZ.getHeaderViewsCount() + list.size(), 0 - g.this.lEK);
                        g.this.lEB = false;
                    }
                };
                com.baidu.adp.lib.f.e.mY().post(this.lEI);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.lEE != null && !this.lEz) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.lEE);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.KV(1);
            com.baidu.tbadk.core.util.y.add(arrayList, 0, postData2);
            return true;
        } else if (z) {
            com.baidu.tbadk.core.util.y.add(arrayList, 0, postData);
            return true;
        } else {
            return false;
        }
    }

    private boolean a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        ArrayList arrayList2 = new ArrayList();
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dnx()) && fVar.dnx().size() > 2) {
            int min = Math.min(fVar.dnx().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.o oVar = fVar.dnx().get(i5);
                if (!z2 && i5 == 0) {
                    oVar.iX(true);
                }
                if (oVar.bph() == null) {
                    if (i5 == min - 1) {
                        oVar.iY(true);
                    }
                } else if (i5 == min - 2) {
                    oVar.iY(true);
                } else if (i5 == min - 1) {
                    oVar.iZ(true);
                }
                arrayList2.add(oVar);
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
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, arrayList2.get(size));
                }
                return true;
            }
        }
        return false;
    }

    private com.baidu.adp.widget.ListView.q c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (i < 0 || fVar == null || !fVar.lAQ || fVar.lAR == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lAR;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lEe.setData(fVar);
        this.lEe.setFromCDN(this.mIsFromCDN);
        this.lEe.setImageMaxWidth(this.lED);
        this.lEe.uy(this.lEw);
        this.lEe.B(this.bbH);
        this.lEe.S(this.lEF);
        this.lEe.setOnImageClickListener(this.fNk);
        this.lEe.setOnLongClickListener(this.mOnLongClickListener);
        this.lEe.setTbGestureDetector(this.fos);
        this.lEk.setData(fVar);
        this.lEk.setFromCDN(this.mIsFromCDN);
        this.lEk.hY(this.bkt);
        this.lEk.uy(this.lEw);
        this.lEk.B(this.bbH);
        this.lEk.S(this.lEF);
        this.lEk.setOnImageClickListener(this.fNk);
        this.lEk.setOnLongClickListener(this.mOnLongClickListener);
        this.lEk.setTbGestureDetector(this.fos);
        this.lEf.setOnClickListener(this.bbH);
        this.lEr.setOnClickListener(this.bbH);
        this.lEl.setOnClickListener(this.lEL);
        if (this.lEn != null && (this.lEn instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lEn).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lEs.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.hY(this.bkt);
                next.setImageMaxWidth(this.lED);
                next.uy(this.lEw);
                next.uz(this.lEx);
                next.uA(this.lEC);
                next.B(this.bbH);
                next.S(this.lEF);
                next.setOnImageClickListener(this.fNk);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lEi.B(this.bbH);
        this.lEi.a(this.lEG);
        this.lEj.B(this.bbH);
        this.lEi.setData(fVar);
        this.lEh.setData(fVar);
        this.lEj.setData(fVar);
        this.lEo.setData(fVar);
        this.lEp.setData(fVar);
        this.lEt.setPbData(fVar);
        this.lEt.setFrom(this.lDI.lIy);
        this.lEu.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z dmZ = this.lEv.dmZ();
        if (dmZ != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.eDV) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.eDV) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dmZ instanceof z)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, dmZ);
                return dmZ;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel dol;
        if (i >= 0 && (dol = this.lDI.dol()) != null) {
            String drb = dol.drb();
            if (TextUtils.isEmpty(drb)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.TF(drb);
            c(nVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q d(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.lEv == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n dqz = this.lDI.dol().dqz();
        if (dqz == null) {
            dqz = this.lEv.dnm();
        }
        if (dqz != null) {
            AdvertAppInfo.ILegoAdvert dOW = dqz.dOW();
            if (dOW != null) {
                dOW.setAdvertAppInfo(dqz.rs());
            }
            int bmD = dqz.dOV().bmD();
            if (bmD != 0) {
                a(dqz, bmD);
                if (bmD == 28 || bmD == 31 || dqz.dOV().goods == null) {
                    return null;
                }
                dqz.dOV().goods.goods_style = -1001;
                return null;
            }
            if (this.lEv.getForum() != null) {
                dqz.forumId = this.lEv.getForum().getId();
            }
            if (this.lEv.dmU() != null) {
                dqz.threadId = com.baidu.adp.lib.f.b.toLong(this.lEv.dmU().getId(), 0L);
            }
            if (this.lEv != null && this.lEv.getPage() != null) {
                dqz.pageNumber = this.lEv.getPage().bnD();
            }
            c(dqz);
            if (i >= 0) {
                com.baidu.tieba.lego.card.d.a.a(arrayList, dqz, i);
                return dqz;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.lEz || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dmW()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dnv() && this.lEx) ? 0 : -1;
        } else if (this.lDI.dol() == null || !this.lDI.dol().getIsFromMark()) {
            if (this.lDI.dpc() == null || !this.lDI.dpc().dtm()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.q qVar = arrayList.get(i2);
                    if (qVar instanceof PostData) {
                        PostData postData = (PostData) qVar;
                        if (postData.dPh() == 1 && postData.nmq == 0) {
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
                return fVar.dnv() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dmW()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dmW(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.q qVar = arrayList.get(i2);
            if (qVar instanceof PostData) {
                PostData postData = (PostData) qVar;
                if (postData.dPh() == 1 && postData.nmq == 0) {
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

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dmW()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dnv()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dmW().get(0) == null || fVar.dmW().get(0).dPh() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dni() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dni().lCs)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dni().lCs;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.nmD = true;
                postData.nms = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.dni().lCt) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).nms = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).nms = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCd);
        nVar.lCf = fVar.dni().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cQg() {
        if (this.lDI != null && !cQh()) {
            this.lDI.registerListener(this.jqt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQh() {
        if (this.lDI == null) {
            return false;
        }
        this.jqr = new ArrayList();
        ArrayList<BdUniqueId> dOz = com.baidu.tieba.tbadkCore.v.dOz();
        if (dOz == null || dOz.size() <= 0) {
            return false;
        }
        int size = dOz.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.dfb().a(this.lDI.getPageContext(), dOz.get(i), 2);
            if (a2 != null) {
                this.bnf.add(a2);
                this.jqr.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jqr)) {
            this.gpZ.addAdapters(this.jqr);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.gpZ.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dmW() == null || fVar.dmX() == null || fVar.dmW().size() == 0 || fVar.dmU() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dmX().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dmW().get(0) == null || fVar.dmW().get(0).dPh() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bnD() != fVar.getPage().bnA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dmW() == null || fVar.dmY() == null || fVar.dmW().size() == 0 || fVar.dmU() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dmY().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dmW().get(0) == null || fVar.dmW().get(0).dPh() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bnD() != fVar.getPage().bnA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.gpZ.getItem(i);
    }

    public ArrayList<PostData> doH() {
        return this.postList;
    }

    public BdUniqueId GV(int i) {
        if (this.gpZ.getItem(i) != null) {
            return this.gpZ.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lEJ = doI();
        if (this.gpZ.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }

    public int doI() {
        if (this.gpZ != null && this.gpZ.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gpZ.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.gpZ.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.lCc) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int doJ() {
        return this.lEJ;
    }

    private void doK() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lEv != null && !this.lEv.lBA && this.lEv.ZJ != 2) {
            ArrayList<PostData> dmW = this.lEv.dmW();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dnl = this.lEv.dnl();
            if (!com.baidu.tieba.lego.card.d.a.isEmpty(dmW) && !com.baidu.tieba.lego.card.d.a.isEmpty(dnl)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dnl.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dnl.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.jqp = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dnl.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dOV() != null) {
                        int bmD = next3.dOV().bmD();
                        if (bmD != 0) {
                            a(next3, bmD);
                            if (bmD != 28 && bmD != 31) {
                                if (next3.dOV().goods != null) {
                                    next3.dOV().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dnl.clear();
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.valueAt(i);
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
                    com.baidu.tieba.lego.card.d.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < com.baidu.tieba.lego.card.d.a.eN(arrayList); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) com.baidu.tieba.lego.card.d.a.l(arrayList, i3)).intValue());
                    if (this.lEv.getForum() != null) {
                        nVar4.forumId = this.lEv.getForum().getId();
                    }
                    if (this.lEv.dmU() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lEv.dmU().getId(), 0L);
                    }
                    if (this.lEv != null && this.lEv.getPage() != null) {
                        nVar4.pageNumber = this.lEv.getPage().bnD();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lEv.lBz;
                    if (position + i3 >= com.baidu.tieba.lego.card.d.a.eN(dmW)) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lEx) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.d.a.a(dmW, nVar4, position);
                        TiebaStatic.eventStat(this.lDI.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dOV().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.Js(i);
        com.baidu.tieba.recapp.report.d.dGg().a(c);
        if (nVar != null && nVar.dOV() != null) {
            nVar.dOV().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dOV() != null && nVar.dOV().goods != null && nVar.dOV().goods.goods_style != 1001 && nVar.dOV().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lEv != null && nVar.dOV() != null) {
            nVar.dOV().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lEv.getPage() != null) {
                nVar.dOV().advertAppContext.pn = this.lEv.getPage().bnD();
            }
            nVar.dOV().advertAppContext.page = nVar.dOY();
            if (this.lEv.getForum() != null && (forum = this.lEv.getForum()) != null) {
                nVar.dOV().advertAppContext.fid = forum.getId();
                nVar.dOV().advertAppContext.eDI = forum.getFirst_class();
                nVar.dOV().advertAppContext.eDJ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dOV().advertAppContext.eDK = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dOV().advertAppContext.extensionInfo = nVar.dOV().ext_info;
            nVar.dOV().advertAppContext.ZP = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lEe.setFromCDN(z);
        if (this.lEn != null && (this.lEn instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lEn).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lEs.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean doL() {
        return this.lEw;
    }

    public void uy(boolean z) {
        this.lEw = z;
    }

    public void uz(boolean z) {
        this.lEx = z;
    }

    public void uA(boolean z) {
        this.lEC = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lEF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fos = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lEG = aVar;
    }

    public void GW(int i) {
        switch (i) {
            case 1:
                if (this.lEe != null) {
                    this.lEe.pause();
                }
                if (this.lEn instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lEn).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lEe != null) {
                    this.lEe.resume();
                }
                if (this.lEn instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lEn).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lEe != null) {
                    this.lEe.release();
                }
                if (this.lEn instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lEn).onDestroy();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void fn(List<com.baidu.adp.widget.ListView.q> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.bqb())) {
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.AS(postData.bqb());
                        list.set(i, amVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lEI);
        if (this.lEi != null) {
            this.lEi.onDestroy();
        }
        if (this.lEj != null) {
            this.lEj.onDestroy();
        }
        if (this.lEf != null) {
            this.lEf.onDestroy();
        }
        if (this.lEh != null) {
            this.lEh.onDestroy();
        }
    }

    public void uE(boolean z) {
        this.lEz = z;
    }

    public void uF(boolean z) {
        this.lEA = z;
    }

    public void uG(boolean z) {
        this.lEy = z;
    }

    public void uH(boolean z) {
        this.lEB = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c doM() {
        return this.lEf;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.ghy;
    }

    public View doN() {
        if (this.lEe == null || this.lEe.doR() == null) {
            return null;
        }
        if (this.lEe.doR().lGX != null && this.lEe.doR().lGX.isShown()) {
            return this.lEe.doR().lGX;
        }
        return this.lEe.doR().lGW;
    }

    public t doO() {
        if (this.lEe == null || this.lEe.doR() == null) {
            return null;
        }
        return this.lEe.doR();
    }
}
