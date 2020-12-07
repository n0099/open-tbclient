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
    private ArrayList<com.baidu.adp.widget.ListView.q> ghw;
    private BdTypeListView gpX;
    private com.baidu.adp.widget.ListView.a jTV;
    private List<com.baidu.adp.widget.ListView.a> jqp;
    private PbFragment lDG;
    private int lEB;
    private Runnable lEG;
    private int lEI;
    private s lEc;
    private com.baidu.tieba.pb.pb.main.adapter.c lEd;
    private com.baidu.tieba.pb.pb.main.adapter.d lEe;
    private com.baidu.tieba.pb.pb.main.adapter.a lEf;
    private at lEg;
    private at lEh;
    private m lEi;
    private com.baidu.tieba.pb.video.a lEj;
    private com.baidu.tieba.card.divider.a lEk;
    private com.baidu.adp.widget.ListView.a lEl;
    private ap lEm;
    private aq lEn;
    private an lEo;
    private com.baidu.tieba.pb.pb.a.j lEp;
    private h lEr;
    private y lEs;
    private com.baidu.tieba.pb.data.f lEt;
    private boolean lEy;
    private boolean lEz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> lEq = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lEu = true;
    private boolean lEv = true;
    private boolean lEw = false;
    private boolean lEx = false;
    private boolean lEA = false;
    private String bkt = null;
    private PostData lEC = null;
    private View.OnClickListener lED = null;
    private View.OnClickListener bbH = null;
    private TbRichTextView.i fNk = null;
    private com.baidu.tieba.pb.a.c fos = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lEE = null;
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lEF = new ArrayList();
    private int lEH = -1;
    private CustomMessageListener jbK = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dOM = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dOM();
                Iterator it = dOM.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.lDG);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.lEq.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dOM);
                g.this.lEF.clear();
                g.this.lEF.addAll(arrayList);
                if (g.this.gpX != null) {
                    g.this.gpX.addAdapters(arrayList);
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
            if (customResponsedMessage != null && g.this.lEt != null && !com.baidu.adp.base.i.H(g.this.lDG.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener lEJ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lDG != null && g.this.lEt != null && g.this.lEt.dnh() != null) {
                g.this.lDG.dpb().dsj().dog();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12040"));
            }
        }
    };
    private CustomMessageListener jqr = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.jqp)) {
                g.this.cQg();
                g.this.a(g.this.lEt, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lEB = 0;
        this.width = -1;
        this.lEI = 0;
        this.lEB = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lEB;
        this.lDG = pbFragment;
        this.gpX = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.flC);
        this.lEI = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lDG.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lEc = new s(pbFragment, PostData.nlG);
        this.lEc.a((TbRichTextView.c) pbFragment);
        this.lEd = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.lCh);
        this.lEe = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lEf = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lAw);
        this.lEg = new at(pbFragment, com.baidu.tieba.pb.data.n.lCa);
        this.lEh = new at(pbFragment, com.baidu.tieba.pb.data.n.lCb);
        this.lEi = new m(pbFragment, PostData.nlH);
        this.lEi.a((TbRichTextView.c) pbFragment);
        this.jTV = com.baidu.tieba.recapp.r.dFf().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eDR);
        this.lEl = com.baidu.tieba.recapp.r.dFf().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eDV);
        this.lEo = new an(pbFragment, com.baidu.tieba.pb.data.l.Yt);
        this.lEm = new ap(pbFragment, am.lNy);
        this.lEn = new aq(pbFragment, com.baidu.tbadk.core.data.bb.eHq);
        this.lEp = new com.baidu.tieba.pb.pb.a.j(pbFragment, PostData.nlL);
        this.lEj = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.lYH);
        this.lEk = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lEr = new h(pbFragment, com.baidu.tbadk.core.data.o.eFe);
        this.lEs = new y(pbFragment, pbFragment.getUniqueId());
        this.bnf.add(this.lEc);
        this.bnf.add(this.lEd);
        this.bnf.add(this.lEe);
        this.bnf.add(this.lEf);
        this.bnf.add(this.lEi);
        this.bnf.add(this.lEg);
        this.bnf.add(this.lEh);
        this.bnf.add(this.jTV);
        this.bnf.add(this.lEl);
        this.bnf.add(this.lEo);
        this.bnf.add(this.lEm);
        this.bnf.add(this.lEn);
        this.bnf.add(this.lEj);
        this.bnf.add(this.lEp);
        this.bnf.add(this.lEk);
        this.bnf.add(this.lEr);
        this.bnf.add(this.lEs);
        this.jbK.setPriority(1);
        this.jbK.setSelfListener(true);
        pbFragment.registerListener(this.jbK);
        cQf();
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
            this.lEt = fVar;
            doJ();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lEt != null && this.lEt.dmV() != null && this.lEt.dmV().size() > 0) {
                this.postList.addAll(this.lEt.dmV());
            }
            if (fVar.dmT() != null && fVar.dmT().boP() != null) {
                this.bkt = fVar.dmT().boP().getUserId();
            }
            if (this.lEc != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.dmV());
                PostData bc = bc(arrayList);
                boolean z6 = bc != null;
                if (bc != null) {
                    this.lEC = bc;
                }
                boolean z7 = false;
                if (!this.lEv && bc != null) {
                    arrayList.remove(bc);
                    z7 = true;
                    z6 = true;
                    if (fVar.dnu() && bc.dPi() != null) {
                        bc.c(null);
                    }
                }
                if (!z6 && fVar.dnc() != null) {
                    bc = fVar.dnc();
                    z7 = true;
                    z6 = true;
                    if (!this.lEv && fVar.dnu() && bc.dPi() != null) {
                        bc.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = bc;
                fn(arrayList);
                if (this.lDG.dpz()) {
                    if (fVar.dmV().size() > 0 && (postData = fVar.dmV().get(0)) != null && postData.dPg() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.lEt, arrayList, this.lEv);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.lEt.dmW());
                    }
                }
                int c = c(this.lEt, arrayList, this.lEv);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.lEt.dmX());
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
                        ((PostData) qVar2).nms = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.lEv);
                }
                if (i3 >= 0 && fVar.dnt() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, fVar.dnt());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.nmr = true;
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
                        zVar.lKn = a4;
                    }
                }
                this.lEc.uL(!z4);
                boolean h = h(postData2);
                if (this.lEw && !h) {
                    arrayList.remove(postData2);
                    this.lEw = false;
                }
                if (fVar.dnt() != null) {
                    fVar.dnt().ux(!z3);
                }
                if (this.gpX != null) {
                    this.ghw = arrayList;
                    this.gpX.setData(this.ghw);
                }
                a(h, z, a2, g);
                if (a(postData2, arrayList, z8)) {
                    this.gpX.setData(arrayList);
                }
            }
        }
    }

    private PostData bc(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dPg() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCa);
        by dmT = fVar.dmT();
        nVar.lCc = dmT != null ? dmT.boG() : 0L;
        nVar.isNew = !this.lEv;
        nVar.lCf = this.lDG.dpJ();
        nVar.sortType = fVar.lAK;
        nVar.lCe = fVar.dny();
        nVar.isDynamic = fVar.dnx();
        nVar.lCg = fVar.lAJ;
        com.baidu.tbadk.core.util.y.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lDG.dok().dod()) || !this.lDG.dok().dqm())) {
            if (!this.lDG.doc() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dnq())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.dnq().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lDG.dok().dqj();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.lDG.dok() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lDG.dok().dqh())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.lEy || this.lEx) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.lEz) {
                this.lEG = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gpX.setSelectionFromTop(g.this.gpX.getHeaderViewsCount() + list.size(), 0 - g.this.lEI);
                        g.this.lEz = false;
                    }
                };
                com.baidu.adp.lib.f.e.mY().post(this.lEG);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.lEC != null && !this.lEx) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.lEC);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dnw()) && fVar.dnw().size() > 2) {
            int min = Math.min(fVar.dnw().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.o oVar = fVar.dnw().get(i5);
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
        if (i < 0 || fVar == null || !fVar.lAO || fVar.lAP == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lAP;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lEc.setData(fVar);
        this.lEc.setFromCDN(this.mIsFromCDN);
        this.lEc.setImageMaxWidth(this.lEB);
        this.lEc.uy(this.lEu);
        this.lEc.B(this.bbH);
        this.lEc.S(this.lED);
        this.lEc.setOnImageClickListener(this.fNk);
        this.lEc.setOnLongClickListener(this.mOnLongClickListener);
        this.lEc.setTbGestureDetector(this.fos);
        this.lEi.setData(fVar);
        this.lEi.setFromCDN(this.mIsFromCDN);
        this.lEi.hY(this.bkt);
        this.lEi.uy(this.lEu);
        this.lEi.B(this.bbH);
        this.lEi.S(this.lED);
        this.lEi.setOnImageClickListener(this.fNk);
        this.lEi.setOnLongClickListener(this.mOnLongClickListener);
        this.lEi.setTbGestureDetector(this.fos);
        this.lEd.setOnClickListener(this.bbH);
        this.lEp.setOnClickListener(this.bbH);
        this.lEj.setOnClickListener(this.lEJ);
        if (this.lEl != null && (this.lEl instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lEl).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lEq.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.hY(this.bkt);
                next.setImageMaxWidth(this.lEB);
                next.uy(this.lEu);
                next.uz(this.lEv);
                next.uA(this.lEA);
                next.B(this.bbH);
                next.S(this.lED);
                next.setOnImageClickListener(this.fNk);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lEg.B(this.bbH);
        this.lEg.a(this.lEE);
        this.lEh.B(this.bbH);
        this.lEg.setData(fVar);
        this.lEf.setData(fVar);
        this.lEh.setData(fVar);
        this.lEm.setData(fVar);
        this.lEn.setData(fVar);
        this.lEr.setPbData(fVar);
        this.lEr.setFrom(this.lDG.lIw);
        this.lEs.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z dmY = this.lEt.dmY();
        if (dmY != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.eDV) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.eDV) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dmY instanceof z)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, dmY);
                return dmY;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel dok;
        if (i >= 0 && (dok = this.lDG.dok()) != null) {
            String dra = dok.dra();
            if (TextUtils.isEmpty(dra)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.TF(dra);
            c(nVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q d(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.lEt == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n dqy = this.lDG.dok().dqy();
        if (dqy == null) {
            dqy = this.lEt.dnl();
        }
        if (dqy != null) {
            AdvertAppInfo.ILegoAdvert dOV = dqy.dOV();
            if (dOV != null) {
                dOV.setAdvertAppInfo(dqy.rs());
            }
            int bmD = dqy.dOU().bmD();
            if (bmD != 0) {
                a(dqy, bmD);
                if (bmD == 28 || bmD == 31 || dqy.dOU().goods == null) {
                    return null;
                }
                dqy.dOU().goods.goods_style = -1001;
                return null;
            }
            if (this.lEt.getForum() != null) {
                dqy.forumId = this.lEt.getForum().getId();
            }
            if (this.lEt.dmT() != null) {
                dqy.threadId = com.baidu.adp.lib.f.b.toLong(this.lEt.dmT().getId(), 0L);
            }
            if (this.lEt != null && this.lEt.getPage() != null) {
                dqy.pageNumber = this.lEt.getPage().bnD();
            }
            c(dqy);
            if (i >= 0) {
                com.baidu.tieba.lego.card.d.a.a(arrayList, dqy, i);
                return dqy;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.lEx || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dmV()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dnu() && this.lEv) ? 0 : -1;
        } else if (this.lDG.dok() == null || !this.lDG.dok().getIsFromMark()) {
            if (this.lDG.dpb() == null || !this.lDG.dpb().dtl()) {
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
                        if (postData.dPg() == 1 && postData.nmo == 0) {
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
                return fVar.dnu() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dmV()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dmV(), 0)) == null) {
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
                if (postData.dPg() == 1 && postData.nmo == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dmV()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dnu()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dmV().get(0) == null || fVar.dmV().get(0).dPg() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dnh() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dnh().lCq)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dnh().lCq;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.nmB = true;
                postData.nmq = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.dnh().lCr) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).nmq = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).nmq = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCb);
        nVar.lCd = fVar.dnh().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cQf() {
        if (this.lDG != null && !cQg()) {
            this.lDG.registerListener(this.jqr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQg() {
        if (this.lDG == null) {
            return false;
        }
        this.jqp = new ArrayList();
        ArrayList<BdUniqueId> dOy = com.baidu.tieba.tbadkCore.v.dOy();
        if (dOy == null || dOy.size() <= 0) {
            return false;
        }
        int size = dOy.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.dfa().a(this.lDG.getPageContext(), dOy.get(i), 2);
            if (a2 != null) {
                this.bnf.add(a2);
                this.jqp.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jqp)) {
            this.gpX.addAdapters(this.jqp);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.gpX.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dmV() == null || fVar.dmW() == null || fVar.dmV().size() == 0 || fVar.dmT() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dmW().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dmV().get(0) == null || fVar.dmV().get(0).dPg() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bnD() != fVar.getPage().bnA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dmV() == null || fVar.dmX() == null || fVar.dmV().size() == 0 || fVar.dmT() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dmX().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dmV().get(0) == null || fVar.dmV().get(0).dPg() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bnD() != fVar.getPage().bnA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.gpX.getItem(i);
    }

    public ArrayList<PostData> doG() {
        return this.postList;
    }

    public BdUniqueId GV(int i) {
        if (this.gpX.getItem(i) != null) {
            return this.gpX.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lEH = doH();
        if (this.gpX.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }

    public int doH() {
        if (this.gpX != null && this.gpX.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gpX.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.gpX.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.lCa) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int doI() {
        return this.lEH;
    }

    private void doJ() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lEt != null && !this.lEt.lBy && this.lEt.ZJ != 2) {
            ArrayList<PostData> dmV = this.lEt.dmV();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dnk = this.lEt.dnk();
            if (!com.baidu.tieba.lego.card.d.a.isEmpty(dmV) && !com.baidu.tieba.lego.card.d.a.isEmpty(dnk)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dnk.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dnk.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.jqn = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dnk.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dOU() != null) {
                        int bmD = next3.dOU().bmD();
                        if (bmD != 0) {
                            a(next3, bmD);
                            if (bmD != 28 && bmD != 31) {
                                if (next3.dOU().goods != null) {
                                    next3.dOU().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dnk.clear();
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
                    if (this.lEt.getForum() != null) {
                        nVar4.forumId = this.lEt.getForum().getId();
                    }
                    if (this.lEt.dmT() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lEt.dmT().getId(), 0L);
                    }
                    if (this.lEt != null && this.lEt.getPage() != null) {
                        nVar4.pageNumber = this.lEt.getPage().bnD();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lEt.lBx;
                    if (position + i3 >= com.baidu.tieba.lego.card.d.a.eN(dmV)) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lEv) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.d.a.a(dmV, nVar4, position);
                        TiebaStatic.eventStat(this.lDG.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dOU().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.Js(i);
        com.baidu.tieba.recapp.report.d.dGf().a(c);
        if (nVar != null && nVar.dOU() != null) {
            nVar.dOU().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dOU() != null && nVar.dOU().goods != null && nVar.dOU().goods.goods_style != 1001 && nVar.dOU().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lEt != null && nVar.dOU() != null) {
            nVar.dOU().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lEt.getPage() != null) {
                nVar.dOU().advertAppContext.pn = this.lEt.getPage().bnD();
            }
            nVar.dOU().advertAppContext.page = nVar.dOX();
            if (this.lEt.getForum() != null && (forum = this.lEt.getForum()) != null) {
                nVar.dOU().advertAppContext.fid = forum.getId();
                nVar.dOU().advertAppContext.eDI = forum.getFirst_class();
                nVar.dOU().advertAppContext.eDJ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dOU().advertAppContext.eDK = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dOU().advertAppContext.extensionInfo = nVar.dOU().ext_info;
            nVar.dOU().advertAppContext.ZP = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lEc.setFromCDN(z);
        if (this.lEl != null && (this.lEl instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lEl).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lEq.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean doK() {
        return this.lEu;
    }

    public void uy(boolean z) {
        this.lEu = z;
    }

    public void uz(boolean z) {
        this.lEv = z;
    }

    public void uA(boolean z) {
        this.lEA = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lED = onClickListener;
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
        this.lEE = aVar;
    }

    public void GW(int i) {
        switch (i) {
            case 1:
                if (this.lEc != null) {
                    this.lEc.pause();
                }
                if (this.lEl instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lEl).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lEc != null) {
                    this.lEc.resume();
                }
                if (this.lEl instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lEl).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lEc != null) {
                    this.lEc.release();
                }
                if (this.lEl instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lEl).onDestroy();
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
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lEG);
        if (this.lEg != null) {
            this.lEg.onDestroy();
        }
        if (this.lEh != null) {
            this.lEh.onDestroy();
        }
        if (this.lEd != null) {
            this.lEd.onDestroy();
        }
        if (this.lEf != null) {
            this.lEf.onDestroy();
        }
    }

    public void uE(boolean z) {
        this.lEx = z;
    }

    public void uF(boolean z) {
        this.lEy = z;
    }

    public void uG(boolean z) {
        this.lEw = z;
    }

    public void uH(boolean z) {
        this.lEz = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c doL() {
        return this.lEd;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.ghw;
    }

    public View doM() {
        if (this.lEc == null || this.lEc.doQ() == null) {
            return null;
        }
        if (this.lEc.doQ().lGV != null && this.lEc.doQ().lGV.isShown()) {
            return this.lEc.doQ().lGV;
        }
        return this.lEc.doQ().lGU;
    }

    public t doN() {
        if (this.lEc == null || this.lEc.doQ() == null) {
            return null;
        }
        return this.lEc.doQ();
    }
}
