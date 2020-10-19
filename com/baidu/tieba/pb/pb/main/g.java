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
import com.baidu.tbadk.core.data.bw;
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
/* loaded from: classes22.dex */
public class g {
    private ArrayList<com.baidu.adp.widget.ListView.q> fLx;
    private BdTypeListView fSo;
    private List<com.baidu.adp.widget.ListView.a> iJG;
    private com.baidu.adp.widget.ListView.a jmW;
    private s kXE;
    private com.baidu.tieba.pb.pb.main.adapter.c kXF;
    private com.baidu.tieba.pb.pb.main.adapter.d kXG;
    private com.baidu.tieba.pb.pb.main.adapter.a kXH;
    private at kXI;
    private at kXJ;
    private m kXK;
    private com.baidu.tieba.pb.video.a kXL;
    private com.baidu.tieba.card.divider.a kXM;
    private com.baidu.adp.widget.ListView.a kXN;
    private ap kXO;
    private aq kXP;
    private an kXQ;
    private com.baidu.tieba.pb.pb.a.c kXR;
    private h kXT;
    private y kXU;
    private com.baidu.tieba.pb.data.f kXV;
    private PbFragment kXi;
    private boolean kYa;
    private boolean kYb;
    private int kYd;
    private Runnable kYi;
    private int kYk;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> kXS = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean kXW = true;
    private boolean kXX = true;
    private boolean kXY = false;
    private boolean kXZ = false;
    private boolean kYc = false;
    private String bfg = null;
    private PostData kYe = null;
    private View.OnClickListener kYf = null;
    private View.OnClickListener aXk = null;
    private TbRichTextView.i frJ = null;
    private com.baidu.tieba.pb.a.c eTx = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a kYg = null;
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> kYh = new ArrayList();
    private int kYj = -1;
    private CustomMessageListener ixM = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dDU = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dDU();
                Iterator it = dDU.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.kXi);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.kXS.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dDU);
                g.this.kYh.clear();
                g.this.kYh.addAll(arrayList);
                if (g.this.fSo != null) {
                    g.this.fSo.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener eQI = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.kXV != null && !com.baidu.adp.base.i.G(g.this.kXi.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener kYl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.kXi != null && g.this.kXV != null && g.this.kXV.dcO() != null) {
                g.this.kXi.deG().dhK().ddL();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12040"));
            }
        }
    };
    private CustomMessageListener iJI = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.iJG)) {
                g.this.cFE();
                g.this.a(g.this.kXV, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kYd = 0;
        this.width = -1;
        this.kYk = 0;
        this.kYd = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.kYd;
        this.kXi = pbFragment;
        this.fSo = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.eQI);
        this.kYk = com.baidu.adp.lib.util.l.getEquipmentHeight(this.kXi.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kXE = new s(pbFragment, PostData.mEg);
        this.kXE.a((TbRichTextView.c) pbFragment);
        this.kXF = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.kVU);
        this.kXG = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kXH = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.kUl);
        this.kXI = new at(pbFragment, com.baidu.tieba.pb.data.n.kVN);
        this.kXJ = new at(pbFragment, com.baidu.tieba.pb.data.n.kVO);
        this.kXK = new m(pbFragment, PostData.mEh);
        this.kXK.a((TbRichTextView.c) pbFragment);
        this.jmW = com.baidu.tieba.recapp.r.duF().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.ekj);
        this.kXN = com.baidu.tieba.recapp.r.duF().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.ekn);
        this.kXQ = new an(pbFragment, com.baidu.tieba.pb.data.l.Xr);
        this.kXO = new ap(pbFragment, am.lgT);
        this.kXP = new aq(pbFragment, com.baidu.tbadk.core.data.az.enJ);
        this.kXR = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.mEl);
        this.kXL = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.lrW);
        this.kXM = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.kXT = new h(pbFragment, com.baidu.tbadk.core.data.n.elv);
        this.kXU = new y(pbFragment, pbFragment.getUniqueId());
        this.bhH.add(this.kXE);
        this.bhH.add(this.kXF);
        this.bhH.add(this.kXG);
        this.bhH.add(this.kXH);
        this.bhH.add(this.kXK);
        this.bhH.add(this.kXI);
        this.bhH.add(this.kXJ);
        this.bhH.add(this.jmW);
        this.bhH.add(this.kXN);
        this.bhH.add(this.kXQ);
        this.bhH.add(this.kXO);
        this.bhH.add(this.kXP);
        this.bhH.add(this.kXL);
        this.bhH.add(this.kXR);
        this.bhH.add(this.kXM);
        this.bhH.add(this.kXT);
        this.bhH.add(this.kXU);
        this.ixM.setPriority(1);
        this.ixM.setSelfListener(true);
        pbFragment.registerListener(this.ixM);
        cFD();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.bhH);
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
            this.kXV = fVar;
            dep();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kXV != null && this.kXV.dcC() != null && this.kXV.dcC().size() > 0) {
                this.postList.addAll(this.kXV.dcC());
            }
            if (fVar.dcA() != null && fVar.dcA().bih() != null) {
                this.bfg = fVar.dcA().bih().getUserId();
            }
            if (this.kXE != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.dcC());
                PostData aW = aW(arrayList);
                boolean z6 = aW != null;
                if (aW != null) {
                    this.kYe = aW;
                }
                boolean z7 = false;
                if (!this.kXX && aW != null) {
                    arrayList.remove(aW);
                    z7 = true;
                    z6 = true;
                    if (fVar.dda() && aW.dEr() != null) {
                        aW.c(null);
                    }
                }
                if (!z6 && fVar.dcJ() != null) {
                    aW = fVar.dcJ();
                    z7 = true;
                    z6 = true;
                    if (!this.kXX && fVar.dda() && aW.dEr() != null) {
                        aW.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aW;
                eL(arrayList);
                if (this.kXi.dfe()) {
                    if (fVar.dcC().size() > 0 && (postData = fVar.dcC().get(0)) != null && postData.dEp() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.kXV, arrayList, this.kXX);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.kXV.dcD());
                    }
                }
                int c = c(this.kXV, arrayList, this.kXX);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.kXV.dcE());
                }
                com.baidu.tieba.tbadkCore.u.w(arrayList, 1);
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
                        ((PostData) qVar2).mES = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.kXX);
                }
                if (i3 >= 0 && fVar.dcZ() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, fVar.dcZ());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.mER = true;
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
                        zVar.ldK = a4;
                    }
                }
                this.kXE.tG(!z4);
                boolean h = h(postData2);
                if (this.kXY && !h) {
                    arrayList.remove(postData2);
                    this.kXY = false;
                }
                if (fVar.dcZ() != null) {
                    fVar.dcZ().ts(!z3);
                }
                if (this.fSo != null) {
                    this.fLx = arrayList;
                    this.fSo.setData(this.fLx);
                }
                a(h, z, a2, g);
                if (a(postData2, arrayList, z8)) {
                    this.fSo.setData(arrayList);
                }
            }
        }
    }

    private PostData aW(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dEp() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kVN);
        bw dcA = fVar.dcA();
        nVar.kVP = dcA != null ? dcA.bhY() : 0L;
        nVar.isNew = !this.kXX;
        nVar.kVS = this.kXi.dfo();
        nVar.sortType = fVar.kUz;
        nVar.kVR = fVar.dde();
        nVar.isDynamic = fVar.ddd();
        nVar.kVT = fVar.kUy;
        com.baidu.tbadk.core.util.y.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kXi.ddQ().ddH()) || !this.kXi.ddQ().dfR())) {
            if (!this.kXi.ddG() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dcX())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.dcX().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.kXi.ddQ().dfO();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.kXi.ddQ() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.kXi.ddQ().dfM())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.kYa || this.kXZ) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.kYb) {
                this.kYi = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fSo.setSelectionFromTop(g.this.fSo.getHeaderViewsCount() + list.size(), 0 - g.this.kYk);
                        g.this.kYb = false;
                    }
                };
                com.baidu.adp.lib.f.e.mY().post(this.kYi);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.kYe != null && !this.kXZ) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.kYe);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.IY(1);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.ddc()) && fVar.ddc().size() > 2) {
            int min = Math.min(fVar.ddc().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.n nVar = fVar.ddc().get(i5);
                if (!z2 && i5 == 0) {
                    nVar.il(true);
                }
                if (nVar.biz() == null) {
                    if (i5 == min - 1) {
                        nVar.im(true);
                    }
                } else if (i5 == min - 2) {
                    nVar.im(true);
                } else if (i5 == min - 1) {
                    nVar.in(true);
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
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, arrayList2.get(size));
                }
                return true;
            }
        }
        return false;
    }

    private com.baidu.adp.widget.ListView.q c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (i < 0 || fVar == null || !fVar.kUD || fVar.kUE == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.kUE;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.kXE.setData(fVar);
        this.kXE.setFromCDN(this.mIsFromCDN);
        this.kXE.setImageMaxWidth(this.kYd);
        this.kXE.tt(this.kXW);
        this.kXE.A(this.aXk);
        this.kXE.S(this.kYf);
        this.kXE.setOnImageClickListener(this.frJ);
        this.kXE.setOnLongClickListener(this.mOnLongClickListener);
        this.kXE.setTbGestureDetector(this.eTx);
        this.kXK.setData(fVar);
        this.kXK.setFromCDN(this.mIsFromCDN);
        this.kXK.hp(this.bfg);
        this.kXK.tt(this.kXW);
        this.kXK.A(this.aXk);
        this.kXK.S(this.kYf);
        this.kXK.setOnImageClickListener(this.frJ);
        this.kXK.setOnLongClickListener(this.mOnLongClickListener);
        this.kXK.setTbGestureDetector(this.eTx);
        this.kXF.setOnClickListener(this.aXk);
        this.kXR.setOnClickListener(this.aXk);
        this.kXL.setOnClickListener(this.kYl);
        if (this.kXN != null && (this.kXN instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kXN).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kXS.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.hp(this.bfg);
                next.setImageMaxWidth(this.kYd);
                next.tt(this.kXW);
                next.tu(this.kXX);
                next.tv(this.kYc);
                next.A(this.aXk);
                next.S(this.kYf);
                next.setOnImageClickListener(this.frJ);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.kXI.A(this.aXk);
        this.kXI.a(this.kYg);
        this.kXJ.A(this.aXk);
        this.kXI.setData(fVar);
        this.kXH.setData(fVar);
        this.kXJ.setData(fVar);
        this.kXO.setData(fVar);
        this.kXP.setData(fVar);
        this.kXT.setPbData(fVar);
        this.kXT.setFrom(this.kXi.lbT);
        this.kXU.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z dcF = this.kXV.dcF();
        if (dcF != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.ekn) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.ekn) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dcF instanceof z)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, dcF);
                return dcF;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel ddQ;
        if (i >= 0 && (ddQ = this.kXi.ddQ()) != null) {
            String dgE = ddQ.dgE();
            if (TextUtils.isEmpty(dgE)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.Sa(dgE);
            c(nVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q d(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.kXV == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n dgc = this.kXi.ddQ().dgc();
        if (dgc == null) {
            dgc = this.kXV.dcS();
        }
        if (dgc != null) {
            AdvertAppInfo.ILegoAdvert dEe = dgc.dEe();
            if (dEe != null) {
                dEe.setAdvertAppInfo(dgc.rq());
            }
            int bfY = dgc.dEd().bfY();
            if (bfY != 0) {
                a(dgc, bfY);
                if (bfY == 28 || bfY == 31 || dgc.dEd().goods == null) {
                    return null;
                }
                dgc.dEd().goods.goods_style = -1001;
                return null;
            }
            if (this.kXV.getForum() != null) {
                dgc.forumId = this.kXV.getForum().getId();
            }
            if (this.kXV.dcA() != null) {
                dgc.threadId = com.baidu.adp.lib.f.b.toLong(this.kXV.dcA().getId(), 0L);
            }
            if (this.kXV != null && this.kXV.getPage() != null) {
                dgc.pageNumber = this.kXV.getPage().bgV();
            }
            c(dgc);
            if (i >= 0) {
                com.baidu.tieba.lego.card.d.a.a(arrayList, dgc, i);
                return dgc;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.kXZ || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dcC()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dda() && this.kXX) ? 0 : -1;
        } else if (this.kXi.ddQ() == null || !this.kXi.ddQ().getIsFromMark()) {
            if (this.kXi.deG() == null || !this.kXi.deG().diM()) {
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
                        if (postData.dEp() == 1 && postData.mEO == 0) {
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
                return fVar.dda() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dcC()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dcC(), 0)) == null) {
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
                if (postData.dEp() == 1 && postData.mEO == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dcC()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dda()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dcC().get(0) == null || fVar.dcC().get(0).dEp() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dcO() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dcO().kWd)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dcO().kWd;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.mFb = true;
                postData.mEQ = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.dcO().kWe) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).mEQ = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).mEQ = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kVO);
        nVar.kVQ = fVar.dcO().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cFD() {
        if (this.kXi != null && !cFE()) {
            this.kXi.registerListener(this.iJI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cFE() {
        if (this.kXi == null) {
            return false;
        }
        this.iJG = new ArrayList();
        ArrayList<BdUniqueId> dDG = com.baidu.tieba.tbadkCore.u.dDG();
        if (dDG == null || dDG.size() <= 0) {
            return false;
        }
        int size = dDG.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.cUK().a(this.kXi.getPageContext(), dDG.get(i), 2);
            if (a2 != null) {
                this.bhH.add(a2);
                this.iJG.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iJG)) {
            this.fSo.addAdapters(this.iJG);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.fSo.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dcC() == null || fVar.dcD() == null || fVar.dcC().size() == 0 || fVar.dcA() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dcD().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dcC().get(0) == null || fVar.dcC().get(0).dEp() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bgV() != fVar.getPage().bgS()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dcC() == null || fVar.dcE() == null || fVar.dcC().size() == 0 || fVar.dcA() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dcE().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dcC().get(0) == null || fVar.dcC().get(0).dEp() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bgV() != fVar.getPage().bgS()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.fSo.getItem(i);
    }

    public ArrayList<PostData> dem() {
        return this.postList;
    }

    public BdUniqueId Fc(int i) {
        if (this.fSo.getItem(i) != null) {
            return this.fSo.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.kYj = den();
        if (this.fSo.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }

    public int den() {
        if (this.fSo != null && this.fSo.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fSo.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.fSo.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.kVN) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int deo() {
        return this.kYj;
    }

    private void dep() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kXV != null && !this.kXV.kVn && this.kXV.YG != 2) {
            ArrayList<PostData> dcC = this.kXV.dcC();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dcR = this.kXV.dcR();
            if (!com.baidu.tieba.lego.card.d.a.isEmpty(dcC) && !com.baidu.tieba.lego.card.d.a.isEmpty(dcR)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dcR.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dcR.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.iJE = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dcR.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dEd() != null) {
                        int bfY = next3.dEd().bfY();
                        if (bfY != 0) {
                            a(next3, bfY);
                            if (bfY != 28 && bfY != 31) {
                                if (next3.dEd().goods != null) {
                                    next3.dEd().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dcR.clear();
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
                for (int i3 = 0; i3 < com.baidu.tieba.lego.card.d.a.el(arrayList); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) com.baidu.tieba.lego.card.d.a.l(arrayList, i3)).intValue());
                    if (this.kXV.getForum() != null) {
                        nVar4.forumId = this.kXV.getForum().getId();
                    }
                    if (this.kXV.dcA() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kXV.dcA().getId(), 0L);
                    }
                    if (this.kXV != null && this.kXV.getPage() != null) {
                        nVar4.pageNumber = this.kXV.getPage().bgV();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kXV.kVm;
                    if (position + i3 >= com.baidu.tieba.lego.card.d.a.el(dcC)) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kXX) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.d.a.a(dcC, nVar4, position);
                        TiebaStatic.eventStat(this.kXi.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dEd().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.Hu(i);
        com.baidu.tieba.recapp.report.d.dvG().a(c);
        if (nVar != null && nVar.dEd() != null) {
            nVar.dEd().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dEd() != null && nVar.dEd().goods != null && nVar.dEd().goods.goods_style != 1001 && nVar.dEd().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kXV != null && nVar.dEd() != null) {
            nVar.dEd().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kXV.getPage() != null) {
                nVar.dEd().advertAppContext.pn = this.kXV.getPage().bgV();
            }
            nVar.dEd().advertAppContext.page = nVar.dEg();
            if (this.kXV.getForum() != null && (forum = this.kXV.getForum()) != null) {
                nVar.dEd().advertAppContext.fid = forum.getId();
                nVar.dEd().advertAppContext.eka = forum.getFirst_class();
                nVar.dEd().advertAppContext.ekb = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dEd().advertAppContext.ekc = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dEd().advertAppContext.extensionInfo = nVar.dEd().ext_info;
            nVar.dEd().advertAppContext.YM = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.kXE.setFromCDN(z);
        if (this.kXN != null && (this.kXN instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kXN).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kXS.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean deq() {
        return this.kXW;
    }

    public void tt(boolean z) {
        this.kXW = z;
    }

    public void tu(boolean z) {
        this.kXX = z;
    }

    public void tv(boolean z) {
        this.kYc = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kYf = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.frJ = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eTx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kYg = aVar;
    }

    public void Fd(int i) {
        switch (i) {
            case 1:
                if (this.kXE != null) {
                    this.kXE.pause();
                }
                if (this.kXN instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kXN).onPause();
                    return;
                }
                return;
            case 2:
                if (this.kXE != null) {
                    this.kXE.resume();
                }
                if (this.kXN instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kXN).onResume();
                    return;
                }
                return;
            case 3:
                if (this.kXE != null) {
                    this.kXE.release();
                }
                if (this.kXN instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kXN).onDestroy();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void eL(List<com.baidu.adp.widget.ListView.q> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.bjr())) {
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.Aj(postData.bjr());
                        list.set(i, akVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kYi);
        if (this.kXI != null) {
            this.kXI.onDestroy();
        }
        if (this.kXJ != null) {
            this.kXJ.onDestroy();
        }
        if (this.kXF != null) {
            this.kXF.onDestroy();
        }
        if (this.kXH != null) {
            this.kXH.onDestroy();
        }
    }

    public void tz(boolean z) {
        this.kXZ = z;
    }

    public void tA(boolean z) {
        this.kYa = z;
    }

    public void tB(boolean z) {
        this.kXY = z;
    }

    public void tC(boolean z) {
        this.kYb = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c der() {
        return this.kXF;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.fLx;
    }

    public View des() {
        if (this.kXE == null || this.kXE.dev() == null) {
            return null;
        }
        if (this.kXE.dev().lau != null && this.kXE.dev().lau.isShown()) {
            return this.kXE.dev().lau;
        }
        return this.kXE.dev().las;
    }

    public t det() {
        if (this.kXE == null || this.kXE.dev() == null) {
            return null;
        }
        return this.kXE.dev();
    }
}
