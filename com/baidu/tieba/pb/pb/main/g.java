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
    private List<com.baidu.adp.widget.ListView.a> hZi;
    private com.baidu.adp.widget.ListView.a iAt;
    private com.baidu.tieba.pb.pb.main.adapter.a kkA;
    private at kkB;
    private at kkC;
    private m kkD;
    private com.baidu.tieba.pb.video.a kkE;
    private com.baidu.tieba.card.divider.a kkF;
    private com.baidu.adp.widget.ListView.a kkG;
    private ap kkH;
    private aq kkI;
    private an kkJ;
    private com.baidu.tieba.pb.pb.a.c kkK;
    private h kkM;
    private y kkN;
    private com.baidu.tieba.pb.data.f kkO;
    private boolean kkT;
    private boolean kkU;
    private int kkW;
    private PbFragment kkb;
    private s kkx;
    private com.baidu.tieba.pb.pb.main.adapter.c kky;
    private com.baidu.tieba.pb.pb.main.adapter.d kkz;
    private Runnable klb;
    private int kld;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> kkL = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean kkP = true;
    private boolean kkQ = true;
    private boolean kkR = false;
    private boolean kkS = false;
    private boolean kkV = false;
    private String aTI = null;
    private PostData kkX = null;
    private View.OnClickListener kkY = null;
    private View.OnClickListener aMH = null;
    private TbRichTextView.i eRR = null;
    private com.baidu.tieba.pb.a.c euG = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a kkZ = null;
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> kla = new ArrayList();
    private int klc = -1;
    private CustomMessageListener hNA = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dkN = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dkN();
                Iterator it = dkN.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.kkb);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.kkL.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dkN);
                g.this.kla.clear();
                g.this.kla.addAll(arrayList);
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
            if (customResponsedMessage != null && g.this.kkO != null && !com.baidu.adp.base.i.E(g.this.kkb.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener kle = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.kkb != null && g.this.kkO != null && g.this.kkO.cKL() != null) {
                g.this.kkb.cMF().cPH().cLK();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c12040"));
            }
        }
    };
    private CustomMessageListener hZk = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.x.isEmpty(g.this.hZi)) {
                g.this.cnu();
                g.this.a(g.this.kkO, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kkW = 0;
        this.width = -1;
        this.kld = 0;
        this.kkW = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.kkW;
        this.kkb = pbFragment;
        this.frv = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.erZ);
        this.kld = com.baidu.adp.lib.util.l.getEquipmentHeight(this.kkb.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kkx = new s(pbFragment, PostData.lNc);
        this.kkx.a((TbRichTextView.c) pbFragment);
        this.kky = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.kiN);
        this.kkz = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kkA = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.khb);
        this.kkB = new at(pbFragment, com.baidu.tieba.pb.data.n.kiG);
        this.kkC = new at(pbFragment, com.baidu.tieba.pb.data.n.kiH);
        this.kkD = new m(pbFragment, PostData.lNd);
        this.kkD.a((TbRichTextView.c) pbFragment);
        this.iAt = com.baidu.tieba.recapp.r.dca().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dMK);
        this.kkG = com.baidu.tieba.recapp.r.dca().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dMO);
        this.kkJ = new an(pbFragment, com.baidu.tieba.pb.data.l.Wc);
        this.kkH = new ap(pbFragment, am.ktu);
        this.kkI = new aq(pbFragment, com.baidu.tbadk.core.data.ay.dPY);
        this.kkK = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.lNh);
        this.kkE = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.kEn);
        this.kkF = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.kkM = new h(pbFragment, com.baidu.tbadk.core.data.n.dNW);
        this.kkN = new y(pbFragment, pbFragment.getUniqueId());
        this.aWf.add(this.kkx);
        this.aWf.add(this.kky);
        this.aWf.add(this.kkz);
        this.aWf.add(this.kkA);
        this.aWf.add(this.kkD);
        this.aWf.add(this.kkB);
        this.aWf.add(this.kkC);
        this.aWf.add(this.iAt);
        this.aWf.add(this.kkG);
        this.aWf.add(this.kkJ);
        this.aWf.add(this.kkH);
        this.aWf.add(this.kkI);
        this.aWf.add(this.kkE);
        this.aWf.add(this.kkK);
        this.aWf.add(this.kkF);
        this.aWf.add(this.kkM);
        this.aWf.add(this.kkN);
        this.hNA.setPriority(1);
        this.hNA.setSelfListener(true);
        pbFragment.registerListener(this.hNA);
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
            this.kkO = fVar;
            cMo();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kkO != null && this.kkO.cKz() != null && this.kkO.cKz().size() > 0) {
                this.postList.addAll(this.kkO.cKz());
            }
            if (fVar.cKx() != null && fVar.cKx().aWl() != null) {
                this.aTI = fVar.cKx().aWl().getUserId();
            }
            if (this.kkx != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.cKz());
                PostData aO = aO(arrayList);
                boolean z6 = aO != null;
                if (aO != null) {
                    this.kkX = aO;
                }
                boolean z7 = false;
                if (!this.kkQ && aO != null) {
                    arrayList.remove(aO);
                    z7 = true;
                    z6 = true;
                    if (fVar.cKX() && aO.dlk() != null) {
                        aO.c(null);
                    }
                }
                if (!z6 && fVar.cKG() != null) {
                    aO = fVar.cKG();
                    z7 = true;
                    z6 = true;
                    if (!this.kkQ && fVar.cKX() && aO.dlk() != null) {
                        aO.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aO;
                es(arrayList);
                if (this.kkb.cNd()) {
                    if (fVar.cKz().size() > 0 && (postData = fVar.cKz().get(0)) != null && postData.dli() == 1 && !com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.kkO, arrayList, this.kkQ);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.x.add(arrayList, b, this.kkO.cKA());
                    }
                }
                int c = c(this.kkO, arrayList, this.kkQ);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.x.add(arrayList, c, this.kkO.cKB());
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
                        ((PostData) qVar2).lNO = true;
                    }
                    com.baidu.tbadk.core.util.x.addAll(arrayList, a, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.kkQ);
                }
                if (i3 >= 0 && fVar.cKW() != null) {
                    com.baidu.tbadk.core.util.x.add(arrayList, i3, fVar.cKW());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.lNN = true;
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
                        zVar.kqA = a3;
                    }
                }
                this.kkx.sj(!z4);
                boolean h = h(postData2);
                if (this.kkR && !h) {
                    arrayList.remove(postData2);
                    this.kkR = false;
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
            if ((next instanceof PostData) && ((PostData) next).dli() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kiG);
        bv cKx = fVar.cKx();
        nVar.kiI = cKx != null ? cKx.aWc() : 0L;
        nVar.isNew = !this.kkQ;
        nVar.kiL = this.kkb.cNn();
        nVar.sortType = fVar.khp;
        nVar.kiK = fVar.cLb();
        nVar.isDynamic = fVar.cLa();
        nVar.kiM = fVar.kho;
        com.baidu.tbadk.core.util.x.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kkb.cLP().cLG()) || !this.kkb.cLP().cNO())) {
            if (!this.kkb.cLF() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.cKU())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.cKU().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.kkb.cLP().cNL();
            com.baidu.tbadk.core.util.x.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.kkb.cLP() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.kkb.cLP().cNJ())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.kkT || this.kkS) && i != -1 && !com.baidu.tbadk.core.util.x.isEmpty(list) && !this.kkU) {
                this.klb = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.frv.setSelectionFromTop(g.this.frv.getHeaderViewsCount() + list.size(), 0 - g.this.kld);
                        g.this.kkU = false;
                    }
                };
                com.baidu.adp.lib.f.e.lt().post(this.klb);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.kkX != null && !this.kkS) {
                com.baidu.tbadk.core.util.x.add(arrayList, 0, this.kkX);
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
        if (i < 0 || fVar == null || !fVar.kht || fVar.khu == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.khu;
        com.baidu.tbadk.core.util.x.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.kkx.setData(fVar);
        this.kkx.setFromCDN(this.mIsFromCDN);
        this.kkx.setImageMaxWidth(this.kkW);
        this.kkx.rW(this.kkP);
        this.kkx.z(this.aMH);
        this.kkx.R(this.kkY);
        this.kkx.setOnImageClickListener(this.eRR);
        this.kkx.setOnLongClickListener(this.mOnLongClickListener);
        this.kkx.setTbGestureDetector(this.euG);
        this.kkD.setData(fVar);
        this.kkD.setFromCDN(this.mIsFromCDN);
        this.kkD.fq(this.aTI);
        this.kkD.rW(this.kkP);
        this.kkD.z(this.aMH);
        this.kkD.R(this.kkY);
        this.kkD.setOnImageClickListener(this.eRR);
        this.kkD.setOnLongClickListener(this.mOnLongClickListener);
        this.kkD.setTbGestureDetector(this.euG);
        this.kky.setOnClickListener(this.aMH);
        this.kkK.setOnClickListener(this.aMH);
        this.kkE.setOnClickListener(this.kle);
        if (this.kkG != null && (this.kkG instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kkG).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kkL.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.fq(this.aTI);
                next.setImageMaxWidth(this.kkW);
                next.rW(this.kkP);
                next.rX(this.kkQ);
                next.rY(this.kkV);
                next.z(this.aMH);
                next.R(this.kkY);
                next.setOnImageClickListener(this.eRR);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.kkB.z(this.aMH);
        this.kkB.a(this.kkZ);
        this.kkC.z(this.aMH);
        this.kkB.setData(fVar);
        this.kkA.setData(fVar);
        this.kkC.setData(fVar);
        this.kkH.setData(fVar);
        this.kkI.setData(fVar);
        this.kkM.setPbData(fVar);
        this.kkM.setFrom(this.kkb.koK);
        this.kkN.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z cKC = this.kkO.cKC();
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
        if (i >= 0 && (cLP = this.kkb.cLP()) != null) {
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
        if (this.kkO == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n cNZ = this.kkb.cLP().cNZ();
        if (cNZ == null) {
            cNZ = this.kkO.cKP();
        }
        if (cNZ != null) {
            AdvertAppInfo.ILegoAdvert dkX = cNZ.dkX();
            if (dkX != null) {
                dkX.setAdvertAppInfo(cNZ.pM());
            }
            int aUe = cNZ.dkW().aUe();
            if (aUe != 0) {
                a(cNZ, aUe);
                if (aUe == 28 || aUe == 31 || cNZ.dkW().goods == null) {
                    return null;
                }
                cNZ.dkW().goods.goods_style = -1001;
                return null;
            }
            if (this.kkO.getForum() != null) {
                cNZ.forumId = this.kkO.getForum().getId();
            }
            if (this.kkO.cKx() != null) {
                cNZ.threadId = com.baidu.adp.lib.f.b.toLong(this.kkO.cKx().getId(), 0L);
            }
            if (this.kkO != null && this.kkO.getPage() != null) {
                cNZ.pageNumber = this.kkO.getPage().aUZ();
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
        if (this.kkS || fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.cKz()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.cKX() && this.kkQ) ? 0 : -1;
        } else if (this.kkb.cLP() == null || !this.kkb.cLP().getIsFromMark()) {
            if (this.kkb.cMF() == null || !this.kkb.cMF().cQJ()) {
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
                        if (postData.dli() == 1 && postData.lNK == 0) {
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
                if (postData.dli() == 1 && postData.lNK == 0) {
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
            return (fVar.cKz().get(0) == null || fVar.cKz().get(0).dli() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cKL() == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.cKL().kiW)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.cKL().kiW;
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.lNX = true;
                postData.lNM = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.x.getCount(fVar.cKL().kiX) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).lNM = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).lNM = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kiH);
        nVar.kiJ = fVar.cKL().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cnt() {
        if (this.kkb != null && !cnu()) {
            this.kkb.registerListener(this.hZk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnu() {
        if (this.kkb == null) {
            return false;
        }
        this.hZi = new ArrayList();
        ArrayList<BdUniqueId> dkz = com.baidu.tieba.tbadkCore.t.dkz();
        if (dkz == null || dkz.size() <= 0) {
            return false;
        }
        int size = dkz.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cCC().a(this.kkb.getPageContext(), dkz.get(i), 2);
            if (a != null) {
                this.aWf.add(a);
                this.hZi.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.hZi)) {
            this.frv.addAdapters(this.hZi);
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
                return (fVar.cKz().get(0) == null || fVar.cKz().get(0).dli() != 1) ? -1 : 1;
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
                return (fVar.cKz().get(0) == null || fVar.cKz().get(0).dli() != 1) ? -1 : 1;
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
        this.klc = cMm();
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
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.kiG) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cMn() {
        return this.klc;
    }

    private void cMo() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kkO != null && !this.kkO.kif && this.kkO.Xq != 2) {
            ArrayList<PostData> cKz = this.kkO.cKz();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cKO = this.kkO.cKO();
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
                        next2.hZg = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cKO.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dkW() != null) {
                        int aUe = next3.dkW().aUe();
                        if (aUe != 0) {
                            a(next3, aUe);
                            if (aUe != 28 && aUe != 31) {
                                if (next3.dkW().goods != null) {
                                    next3.dkW().goods.goods_style = -1001;
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
                    if (this.kkO.getForum() != null) {
                        nVar4.forumId = this.kkO.getForum().getId();
                    }
                    if (this.kkO.cKx() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kkO.cKx().getId(), 0L);
                    }
                    if (this.kkO != null && this.kkO.getPage() != null) {
                        nVar4.pageNumber = this.kkO.getPage().aUZ();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kkO.kie;
                    if (position + i3 >= cKz.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kkQ) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        cKz.add(position, nVar4);
                        TiebaStatic.eventStat(this.kkb.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dkW().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.DS(i);
        com.baidu.tieba.recapp.report.d.dcY().a(c);
        if (nVar != null && nVar.dkW() != null) {
            nVar.dkW().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dkW() != null && nVar.dkW().goods != null && nVar.dkW().goods.goods_style != 1001 && nVar.dkW().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kkO != null && nVar.dkW() != null) {
            nVar.dkW().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kkO.getPage() != null) {
                nVar.dkW().advertAppContext.pn = this.kkO.getPage().aUZ();
            }
            nVar.dkW().advertAppContext.page = nVar.dkZ();
            if (this.kkO.getForum() != null && (forum = this.kkO.getForum()) != null) {
                nVar.dkW().advertAppContext.fid = forum.getId();
                nVar.dkW().advertAppContext.dMB = forum.getFirst_class();
                nVar.dkW().advertAppContext.dMC = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dkW().advertAppContext.dMD = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dkW().advertAppContext.extensionInfo = nVar.dkW().ext_info;
            nVar.dkW().advertAppContext.Xw = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.kkx.setFromCDN(z);
        if (this.kkG != null && (this.kkG instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kkG).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kkL.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cMp() {
        return this.kkP;
    }

    public void rW(boolean z) {
        this.kkP = z;
    }

    public void rX(boolean z) {
        this.kkQ = z;
    }

    public void rY(boolean z) {
        this.kkV = z;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kkY = onClickListener;
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
        this.kkZ = aVar;
    }

    public void BD(int i) {
        switch (i) {
            case 1:
                if (this.kkx != null) {
                    this.kkx.pause();
                }
                if (this.kkG instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kkG).onPause();
                    return;
                }
                return;
            case 2:
                if (this.kkx != null) {
                    this.kkx.resume();
                }
                if (this.kkG instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kkG).onResume();
                    return;
                }
                return;
            case 3:
                if (this.kkx != null) {
                    this.kkx.release();
                }
                if (this.kkG instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kkG).onDestroy();
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
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.klb);
        if (this.kkB != null) {
            this.kkB.onDestroy();
        }
        if (this.kkC != null) {
            this.kkC.onDestroy();
        }
        if (this.kky != null) {
            this.kky.onDestroy();
        }
        if (this.kkA != null) {
            this.kkA.onDestroy();
        }
    }

    public void sc(boolean z) {
        this.kkS = z;
    }

    public void sd(boolean z) {
        this.kkT = z;
    }

    public void se(boolean z) {
        this.kkR = z;
    }

    public void sf(boolean z) {
        this.kkU = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cMq() {
        return this.kky;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.fkE;
    }

    public View cMr() {
        if (this.kkx == null || this.kkx.cMu() == null) {
            return null;
        }
        if (this.kkx.cMu().knm != null && this.kkx.cMu().knm.isShown()) {
            return this.kkx.cMu().knm;
        }
        return this.kkx.cMu().knl;
    }

    public t cMs() {
        if (this.kkx == null || this.kkx.cMu() == null) {
            return null;
        }
        return this.kkx.cMu();
    }
}
