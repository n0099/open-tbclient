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
import com.baidu.tbadk.core.data.bv;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes16.dex */
public class g {
    private ArrayList<com.baidu.adp.widget.ListView.q> fkE;
    private BdTypeListView frv;
    private List<com.baidu.adp.widget.ListView.a> hZg;
    private com.baidu.adp.widget.ListView.a iAr;
    private PbFragment kjZ;
    private at kkA;
    private m kkB;
    private com.baidu.tieba.pb.video.a kkC;
    private com.baidu.tieba.card.divider.a kkD;
    private com.baidu.adp.widget.ListView.a kkE;
    private ap kkF;
    private aq kkG;
    private an kkH;
    private com.baidu.tieba.pb.pb.a.c kkI;
    private h kkK;
    private y kkL;
    private com.baidu.tieba.pb.data.f kkM;
    private boolean kkR;
    private boolean kkS;
    private int kkU;
    private Runnable kkZ;
    private s kkv;
    private com.baidu.tieba.pb.pb.main.adapter.c kkw;
    private com.baidu.tieba.pb.pb.main.adapter.d kkx;
    private com.baidu.tieba.pb.pb.main.adapter.a kky;
    private at kkz;
    private int klb;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> kkJ = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean kkN = true;
    private boolean kkO = true;
    private boolean kkP = false;
    private boolean kkQ = false;
    private boolean kkT = false;
    private String aTI = null;
    private PostData kkV = null;
    private View.OnClickListener kkW = null;
    private View.OnClickListener aMH = null;
    private TbRichTextView.i eRR = null;
    private com.baidu.tieba.pb.a.c euG = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a kkX = null;
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> kkY = new ArrayList();
    private int kla = -1;
    private CustomMessageListener hNy = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dkM = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dkM();
                Iterator it = dkM.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.kjZ);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.kkJ.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dkM);
                g.this.kkY.clear();
                g.this.kkY.addAll(arrayList);
                if (g.this.frv != null) {
                    g.this.frv.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener erZ = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.kkM != null && !com.baidu.adp.base.i.E(g.this.kjZ.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener klc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.kjZ != null && g.this.kkM != null && g.this.kkM.cKL() != null) {
                g.this.kjZ.cMF().cPH().cLK();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12040"));
            }
        }
    };
    private CustomMessageListener hZi = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.x.isEmpty(g.this.hZg)) {
                g.this.cnu();
                g.this.a(g.this.kkM, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kkU = 0;
        this.width = -1;
        this.klb = 0;
        this.kkU = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.kkU;
        this.kjZ = pbFragment;
        this.frv = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.erZ);
        this.klb = com.baidu.adp.lib.util.l.getEquipmentHeight(this.kjZ.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kkv = new s(pbFragment, PostData.lNa);
        this.kkv.a((TbRichTextView.c) pbFragment);
        this.kkw = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.kiL);
        this.kkx = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kky = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.kgZ);
        this.kkz = new at(pbFragment, com.baidu.tieba.pb.data.n.kiE);
        this.kkA = new at(pbFragment, com.baidu.tieba.pb.data.n.kiF);
        this.kkB = new m(pbFragment, PostData.lNb);
        this.kkB.a((TbRichTextView.c) pbFragment);
        this.iAr = com.baidu.tieba.recapp.r.dca().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dMK);
        this.kkE = com.baidu.tieba.recapp.r.dca().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dMO);
        this.kkH = new an(pbFragment, com.baidu.tieba.pb.data.l.Wc);
        this.kkF = new ap(pbFragment, am.kts);
        this.kkG = new aq(pbFragment, com.baidu.tbadk.core.data.ay.dPY);
        this.kkI = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.lNf);
        this.kkC = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.kEl);
        this.kkD = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.kkK = new h(pbFragment, com.baidu.tbadk.core.data.n.dNW);
        this.kkL = new y(pbFragment, pbFragment.getUniqueId());
        this.aWf.add(this.kkv);
        this.aWf.add(this.kkw);
        this.aWf.add(this.kkx);
        this.aWf.add(this.kky);
        this.aWf.add(this.kkB);
        this.aWf.add(this.kkz);
        this.aWf.add(this.kkA);
        this.aWf.add(this.iAr);
        this.aWf.add(this.kkE);
        this.aWf.add(this.kkH);
        this.aWf.add(this.kkF);
        this.aWf.add(this.kkG);
        this.aWf.add(this.kkC);
        this.aWf.add(this.kkI);
        this.aWf.add(this.kkD);
        this.aWf.add(this.kkK);
        this.aWf.add(this.kkL);
        this.hNy.setPriority(1);
        this.hNy.setSelfListener(true);
        pbFragment.registerListener(this.hNy);
        cnt();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.aWf);
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
            this.kkM = fVar;
            cMo();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kkM != null && this.kkM.cKz() != null && this.kkM.cKz().size() > 0) {
                this.postList.addAll(this.kkM.cKz());
            }
            if (fVar.cKx() != null && fVar.cKx().aWl() != null) {
                this.aTI = fVar.cKx().aWl().getUserId();
            }
            if (this.kkv != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.cKz());
                PostData aO = aO(arrayList);
                boolean z6 = aO != null;
                if (aO != null) {
                    this.kkV = aO;
                }
                boolean z7 = false;
                if (!this.kkO && aO != null) {
                    arrayList.remove(aO);
                    z7 = true;
                    z6 = true;
                    if (fVar.cKX() && aO.dlj() != null) {
                        aO.c(null);
                    }
                }
                if (!z6 && fVar.cKG() != null) {
                    aO = fVar.cKG();
                    z7 = true;
                    z6 = true;
                    if (!this.kkO && fVar.cKX() && aO.dlj() != null) {
                        aO.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aO;
                es(arrayList);
                if (this.kjZ.cNd()) {
                    if (fVar.cKz().size() > 0 && (postData = fVar.cKz().get(0)) != null && postData.dlh() == 1 && !com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.kkM, arrayList, this.kkO);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.x.add(arrayList, b, this.kkM.cKA());
                    }
                }
                int c = c(this.kkM, arrayList, this.kkO);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.x.add(arrayList, c, this.kkM.cKB());
                }
                com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
                boolean z9 = false;
                int b2 = b(fVar, arrayList);
                if (b2 >= 0) {
                    z9 = true;
                    a(fVar, arrayList, b2);
                }
                int a = a(fVar, arrayList);
                List<com.baidu.adp.widget.ListView.q> g = g(fVar);
                if (com.baidu.tbadk.core.util.x.isEmpty(g) || a < 0) {
                    z2 = z9;
                } else {
                    com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.x.getItem(arrayList, a);
                    if (qVar2 instanceof PostData) {
                        ((PostData) qVar2).lNM = true;
                    }
                    com.baidu.tbadk.core.util.x.addAll(arrayList, a, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.kkO);
                }
                if (i3 >= 0 && fVar.cKW() != null) {
                    com.baidu.tbadk.core.util.x.add(arrayList, i3, fVar.cKW());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.lNL = true;
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
                    com.baidu.adp.widget.ListView.q b3 = b(arrayList, i5);
                    boolean z10 = b3 != null;
                    if (z10) {
                        i2 = -1;
                        qVar = b3;
                    } else {
                        if (i5 >= 0) {
                            i6 = i5 + 1;
                        } else if (a >= 0) {
                            i6 = a;
                        } else if (b2 >= 0) {
                            i6 = b2;
                        }
                        com.baidu.adp.widget.ListView.q c2 = c(arrayList, i6);
                        z10 = c2 != null;
                        i2 = i6;
                        qVar = c2;
                    }
                    z a2 = a(arrayList, qVar, i5, i2);
                    if (a2 == null) {
                        i = i2;
                        zVar = a2;
                        z5 = z10;
                    } else if (!z10) {
                        i = i2;
                        zVar = a2;
                        z5 = true;
                    } else if (i2 > 0) {
                        i = i2 + 1;
                        zVar = a2;
                        z5 = z10;
                    } else {
                        i5++;
                        i = i2;
                        zVar = a2;
                        z5 = z10;
                    }
                }
                if (z6) {
                    boolean a3 = a(fVar, arrayList, z5, zVar != null, i, i5, a, b2);
                    if (zVar != null) {
                        zVar.kqy = a3;
                    }
                }
                this.kkv.sj(!z4);
                boolean h = h(postData2);
                if (this.kkP && !h) {
                    arrayList.remove(postData2);
                    this.kkP = false;
                }
                if (fVar.cKW() != null) {
                    fVar.cKW().rV(!z3);
                }
                if (this.frv != null) {
                    this.fkE = arrayList;
                    this.frv.setData(this.fkE);
                }
                a(h, z, a, g);
                if (a(postData2, arrayList, z8)) {
                    this.frv.setData(arrayList);
                }
            }
        }
    }

    private PostData aO(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dlh() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kiE);
        bv cKx = fVar.cKx();
        nVar.kiG = cKx != null ? cKx.aWc() : 0L;
        nVar.isNew = !this.kkO;
        nVar.kiJ = this.kjZ.cNn();
        nVar.sortType = fVar.khn;
        nVar.kiI = fVar.cLb();
        nVar.isDynamic = fVar.cLa();
        nVar.kiK = fVar.khm;
        com.baidu.tbadk.core.util.x.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kjZ.cLP().cLG()) || !this.kjZ.cLP().cNO())) {
            if (!this.kjZ.cLF() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.cKU())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.cKU().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.kjZ.cLP().cNL();
            com.baidu.tbadk.core.util.x.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.kjZ.cLP() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.kjZ.cLP().cNJ())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.kkR || this.kkQ) && i != -1 && !com.baidu.tbadk.core.util.x.isEmpty(list) && !this.kkS) {
                this.kkZ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.frv.setSelectionFromTop(g.this.frv.getHeaderViewsCount() + list.size(), 0 - g.this.klb);
                        g.this.kkS = false;
                    }
                };
                com.baidu.adp.lib.f.e.lt().post(this.kkZ);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.kkV != null && !this.kkQ) {
                com.baidu.tbadk.core.util.x.add(arrayList, 0, this.kkV);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.Fs(1);
            com.baidu.tbadk.core.util.x.add(arrayList, 0, postData2);
            return true;
        } else if (z) {
            com.baidu.tbadk.core.util.x.add(arrayList, 0, postData);
            return true;
        } else {
            return false;
        }
    }

    private boolean a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        ArrayList arrayList2 = new ArrayList();
        if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.cKZ()) && fVar.cKZ().size() > 2) {
            int min = Math.min(fVar.cKZ().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.n nVar = fVar.cKZ().get(i5);
                if (!z2 && i5 == 0) {
                    nVar.hv(true);
                }
                if (nVar.aWD() == null) {
                    if (i5 == min - 1) {
                        nVar.hw(true);
                    }
                } else if (i5 == min - 2) {
                    nVar.hw(true);
                } else if (i5 == min - 1) {
                    nVar.hx(true);
                }
                arrayList2.add(nVar);
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
                    com.baidu.tbadk.core.util.x.add(arrayList, i3, arrayList2.get(size));
                }
                return true;
            }
        }
        return false;
    }

    private com.baidu.adp.widget.ListView.q c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (i < 0 || fVar == null || !fVar.khr || fVar.khs == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.khs;
        com.baidu.tbadk.core.util.x.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.kkv.setData(fVar);
        this.kkv.setFromCDN(this.mIsFromCDN);
        this.kkv.setImageMaxWidth(this.kkU);
        this.kkv.rW(this.kkN);
        this.kkv.z(this.aMH);
        this.kkv.R(this.kkW);
        this.kkv.setOnImageClickListener(this.eRR);
        this.kkv.setOnLongClickListener(this.mOnLongClickListener);
        this.kkv.setTbGestureDetector(this.euG);
        this.kkB.setData(fVar);
        this.kkB.setFromCDN(this.mIsFromCDN);
        this.kkB.fq(this.aTI);
        this.kkB.rW(this.kkN);
        this.kkB.z(this.aMH);
        this.kkB.R(this.kkW);
        this.kkB.setOnImageClickListener(this.eRR);
        this.kkB.setOnLongClickListener(this.mOnLongClickListener);
        this.kkB.setTbGestureDetector(this.euG);
        this.kkw.setOnClickListener(this.aMH);
        this.kkI.setOnClickListener(this.aMH);
        this.kkC.setOnClickListener(this.klc);
        if (this.kkE != null && (this.kkE instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kkE).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kkJ.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.fq(this.aTI);
                next.setImageMaxWidth(this.kkU);
                next.rW(this.kkN);
                next.rX(this.kkO);
                next.rY(this.kkT);
                next.z(this.aMH);
                next.R(this.kkW);
                next.setOnImageClickListener(this.eRR);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.kkz.z(this.aMH);
        this.kkz.a(this.kkX);
        this.kkA.z(this.aMH);
        this.kkz.setData(fVar);
        this.kky.setData(fVar);
        this.kkA.setData(fVar);
        this.kkF.setData(fVar);
        this.kkG.setData(fVar);
        this.kkK.setPbData(fVar);
        this.kkK.setFrom(this.kjZ.koI);
        this.kkL.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z cKC = this.kkM.cKC();
        if (cKC != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.dMO) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.dMO) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (cKC instanceof z)) {
                com.baidu.tbadk.core.util.x.add(arrayList, i2, cKC);
                return cKC;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel cLP;
        if (i >= 0 && (cLP = this.kjZ.cLP()) != null) {
            String cOB = cLP.cOB();
            if (TextUtils.isEmpty(cOB)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.NM(cOB);
            c(nVar);
            com.baidu.tbadk.core.util.x.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.kkM == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n cNZ = this.kjZ.cLP().cNZ();
        if (cNZ == null) {
            cNZ = this.kkM.cKP();
        }
        if (cNZ != null) {
            AdvertAppInfo.ILegoAdvert dkW = cNZ.dkW();
            if (dkW != null) {
                dkW.setAdvertAppInfo(cNZ.pM());
            }
            int aUe = cNZ.dkV().aUe();
            if (aUe != 0) {
                a(cNZ, aUe);
                if (aUe == 28 || aUe == 31 || cNZ.dkV().goods == null) {
                    return null;
                }
                cNZ.dkV().goods.goods_style = -1001;
                return null;
            }
            if (this.kkM.getForum() != null) {
                cNZ.forumId = this.kkM.getForum().getId();
            }
            if (this.kkM.cKx() != null) {
                cNZ.threadId = com.baidu.adp.lib.f.b.toLong(this.kkM.cKx().getId(), 0L);
            }
            if (this.kkM != null && this.kkM.getPage() != null) {
                cNZ.pageNumber = this.kkM.getPage().aUZ();
            }
            c(cNZ);
            if (i >= 0) {
                com.baidu.tbadk.core.util.x.add(arrayList, i, cNZ);
                return cNZ;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.kkQ || fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.cKz()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.cKX() && this.kkO) ? 0 : -1;
        } else if (this.kjZ.cLP() == null || !this.kjZ.cLP().getIsFromMark()) {
            if (this.kjZ.cMF() == null || !this.kjZ.cMF().cQJ()) {
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
                        if (postData.dlh() == 1 && postData.lNI == 0) {
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
                return fVar.cKX() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.cKz()) || com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.x.getItem(fVar.cKz(), 0)) == null) {
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
                if (postData.dlh() == 1 && postData.lNI == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.cKz()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.cKX()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.cKz().get(0) == null || fVar.cKz().get(0).dlh() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cKL() == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.cKL().kiU)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.cKL().kiU;
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.lNV = true;
                postData.lNK = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.x.getCount(fVar.cKL().kiV) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).lNK = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).lNK = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kiF);
        nVar.kiH = fVar.cKL().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cnt() {
        if (this.kjZ != null && !cnu()) {
            this.kjZ.registerListener(this.hZi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnu() {
        if (this.kjZ == null) {
            return false;
        }
        this.hZg = new ArrayList();
        ArrayList<BdUniqueId> dky = com.baidu.tieba.tbadkCore.t.dky();
        if (dky == null || dky.size() <= 0) {
            return false;
        }
        int size = dky.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cCC().a(this.kjZ.getPageContext(), dky.get(i), 2);
            if (a != null) {
                this.aWf.add(a);
                this.hZg.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.hZg)) {
            this.frv.addAdapters(this.hZg);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.frv.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.cKz() == null || fVar.cKA() == null || fVar.cKz().size() == 0 || fVar.cKx() == null || arrayList == null) {
            return -1;
        }
        if (fVar.cKA().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.cKz().get(0) == null || fVar.cKz().get(0).dlh() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().aUZ() != fVar.getPage().aUW()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.cKz() == null || fVar.cKB() == null || fVar.cKz().size() == 0 || fVar.cKx() == null || arrayList == null) {
            return -1;
        }
        if (fVar.cKB().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.cKz().get(0) == null || fVar.cKz().get(0).dlh() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().aUZ() != fVar.getPage().aUW()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.frv.getItem(i);
    }

    public ArrayList<PostData> cMl() {
        return this.postList;
    }

    public BdUniqueId BC(int i) {
        if (this.frv.getItem(i) != null) {
            return this.frv.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.kla = cMm();
        if (this.frv.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    public int cMm() {
        if (this.frv != null && this.frv.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.frv.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.frv.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.kiE) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cMn() {
        return this.kla;
    }

    private void cMo() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kkM != null && !this.kkM.kic && this.kkM.Xq != 2) {
            ArrayList<PostData> cKz = this.kkM.cKz();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cKO = this.kkM.cKO();
            if (cKz != null && cKz.size() != 0 && cKO != null && cKO.size() != 0) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = cKO.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cKO.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.hZe = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cKO.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dkV() != null) {
                        int aUe = next3.dkV().aUe();
                        if (aUe != 0) {
                            a(next3, aUe);
                            if (aUe != 28 && aUe != 31) {
                                if (next3.dkV().goods != null) {
                                    next3.dkV().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                cKO.clear();
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
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.kkM.getForum() != null) {
                        nVar4.forumId = this.kkM.getForum().getId();
                    }
                    if (this.kkM.cKx() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kkM.cKx().getId(), 0L);
                    }
                    if (this.kkM != null && this.kkM.getPage() != null) {
                        nVar4.pageNumber = this.kkM.getPage().aUZ();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kkM.kib;
                    if (position + i3 >= cKz.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kkO) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        cKz.add(position, nVar4);
                        TiebaStatic.eventStat(this.kjZ.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dkV().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.DS(i);
        com.baidu.tieba.recapp.report.d.dcY().a(c);
        if (nVar != null && nVar.dkV() != null) {
            nVar.dkV().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dkV() != null && nVar.dkV().goods != null && nVar.dkV().goods.goods_style != 1001 && nVar.dkV().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kkM != null && nVar.dkV() != null) {
            nVar.dkV().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kkM.getPage() != null) {
                nVar.dkV().advertAppContext.pn = this.kkM.getPage().aUZ();
            }
            nVar.dkV().advertAppContext.page = nVar.dkY();
            if (this.kkM.getForum() != null && (forum = this.kkM.getForum()) != null) {
                nVar.dkV().advertAppContext.fid = forum.getId();
                nVar.dkV().advertAppContext.dMB = forum.getFirst_class();
                nVar.dkV().advertAppContext.dMC = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dkV().advertAppContext.dMD = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dkV().advertAppContext.extensionInfo = nVar.dkV().ext_info;
            nVar.dkV().advertAppContext.Xw = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.kkv.setFromCDN(z);
        if (this.kkE != null && (this.kkE instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kkE).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kkJ.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cMp() {
        return this.kkN;
    }

    public void rW(boolean z) {
        this.kkN = z;
    }

    public void rX(boolean z) {
        this.kkO = z;
    }

    public void rY(boolean z) {
        this.kkT = z;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kkW = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eRR = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.euG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kkX = aVar;
    }

    public void BD(int i) {
        switch (i) {
            case 1:
                if (this.kkv != null) {
                    this.kkv.pause();
                }
                if (this.kkE instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kkE).onPause();
                    return;
                }
                return;
            case 2:
                if (this.kkv != null) {
                    this.kkv.resume();
                }
                if (this.kkE instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kkE).onResume();
                    return;
                }
                return;
            case 3:
                if (this.kkv != null) {
                    this.kkv.release();
                }
                if (this.kkE instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kkE).onDestroy();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void es(List<com.baidu.adp.widget.ListView.q> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.aXv())) {
                        com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
                        ajVar.wN(postData.aXv());
                        list.set(i, ajVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kkZ);
        if (this.kkz != null) {
            this.kkz.onDestroy();
        }
        if (this.kkA != null) {
            this.kkA.onDestroy();
        }
        if (this.kkw != null) {
            this.kkw.onDestroy();
        }
        if (this.kky != null) {
            this.kky.onDestroy();
        }
    }

    public void sc(boolean z) {
        this.kkQ = z;
    }

    public void sd(boolean z) {
        this.kkR = z;
    }

    public void se(boolean z) {
        this.kkP = z;
    }

    public void sf(boolean z) {
        this.kkS = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cMq() {
        return this.kkw;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.fkE;
    }

    public View cMr() {
        if (this.kkv == null || this.kkv.cMu() == null) {
            return null;
        }
        if (this.kkv.cMu().knk != null && this.kkv.cMu().knk.isShown()) {
            return this.kkv.cMu().knk;
        }
        return this.kkv.cMu().knj;
    }

    public t cMs() {
        if (this.kkv == null || this.kkv.cMu() == null) {
            return null;
        }
        return this.kkv.cMu();
    }
}
