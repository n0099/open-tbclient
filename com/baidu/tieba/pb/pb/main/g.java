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
/* loaded from: classes16.dex */
public class g {
    private BdTypeListView fCT;
    private ArrayList<com.baidu.adp.widget.ListView.q> fwe;
    private com.baidu.adp.widget.ListView.a iPr;
    private List<com.baidu.adp.widget.ListView.a> inx;
    private Runnable kAA;
    private int kAC;
    private at kAa;
    private at kAb;
    private m kAc;
    private com.baidu.tieba.pb.video.a kAd;
    private com.baidu.tieba.card.divider.a kAe;
    private com.baidu.adp.widget.ListView.a kAf;
    private ap kAg;
    private aq kAh;
    private an kAi;
    private com.baidu.tieba.pb.pb.a.c kAj;
    private h kAl;
    private y kAm;
    private com.baidu.tieba.pb.data.f kAn;
    private boolean kAs;
    private boolean kAt;
    private int kAv;
    private PbFragment kzA;
    private s kzW;
    private com.baidu.tieba.pb.pb.main.adapter.c kzX;
    private com.baidu.tieba.pb.pb.main.adapter.d kzY;
    private com.baidu.tieba.pb.pb.main.adapter.a kzZ;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> kAk = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean kAo = true;
    private boolean kAp = true;
    private boolean kAq = false;
    private boolean kAr = false;
    private boolean kAu = false;
    private String aYY = null;
    private PostData kAw = null;
    private View.OnClickListener kAx = null;
    private View.OnClickListener aRW = null;
    private TbRichTextView.i fcC = null;
    private com.baidu.tieba.pb.a.c eFj = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a kAy = null;
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> kAz = new ArrayList();
    private int kAB = -1;
    private CustomMessageListener ibL = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dwp = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dwp();
                Iterator it = dwp.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.kzA);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.kAk.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dwp);
                g.this.kAz.clear();
                g.this.kAz.addAll(arrayList);
                if (g.this.fCT != null) {
                    g.this.fCT.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener eCw = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.kAn != null && !com.baidu.adp.base.i.G(g.this.kzA.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener kAD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.kzA != null && g.this.kAn != null && g.this.kAn.cVA() != null) {
                g.this.kzA.cXu().day().cWz();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12040"));
            }
        }
    };
    private CustomMessageListener inz = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.inx)) {
                g.this.cyo();
                g.this.a(g.this.kAn, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kAv = 0;
        this.width = -1;
        this.kAC = 0;
        this.kAv = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.kAv;
        this.kzA = pbFragment;
        this.fCT = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.eCw);
        this.kAC = com.baidu.adp.lib.util.l.getEquipmentHeight(this.kzA.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kzW = new s(pbFragment, PostData.mfb);
        this.kzW.a((TbRichTextView.c) pbFragment);
        this.kzX = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.kym);
        this.kzY = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kzZ = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.kwB);
        this.kAa = new at(pbFragment, com.baidu.tieba.pb.data.n.kyf);
        this.kAb = new at(pbFragment, com.baidu.tieba.pb.data.n.kyg);
        this.kAc = new m(pbFragment, PostData.mfc);
        this.kAc.a((TbRichTextView.c) pbFragment);
        this.iPr = com.baidu.tieba.recapp.r.dnk().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dVX);
        this.kAf = com.baidu.tieba.recapp.r.dnk().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dWb);
        this.kAi = new an(pbFragment, com.baidu.tieba.pb.data.l.WI);
        this.kAg = new ap(pbFragment, am.kJg);
        this.kAh = new aq(pbFragment, com.baidu.tbadk.core.data.az.dZv);
        this.kAj = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.mfg);
        this.kAd = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.kUb);
        this.kAe = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.kAl = new h(pbFragment, com.baidu.tbadk.core.data.n.dXj);
        this.kAm = new y(pbFragment, pbFragment.getUniqueId());
        this.bbw.add(this.kzW);
        this.bbw.add(this.kzX);
        this.bbw.add(this.kzY);
        this.bbw.add(this.kzZ);
        this.bbw.add(this.kAc);
        this.bbw.add(this.kAa);
        this.bbw.add(this.kAb);
        this.bbw.add(this.iPr);
        this.bbw.add(this.kAf);
        this.bbw.add(this.kAi);
        this.bbw.add(this.kAg);
        this.bbw.add(this.kAh);
        this.bbw.add(this.kAd);
        this.bbw.add(this.kAj);
        this.bbw.add(this.kAe);
        this.bbw.add(this.kAl);
        this.bbw.add(this.kAm);
        this.ibL.setPriority(1);
        this.ibL.setSelfListener(true);
        pbFragment.registerListener(this.ibL);
        cyn();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.bbw);
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
            this.kAn = fVar;
            cXd();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kAn != null && this.kAn.cVo() != null && this.kAn.cVo().size() > 0) {
                this.postList.addAll(this.kAn.cVo());
            }
            if (fVar.cVm() != null && fVar.cVm().beE() != null) {
                this.aYY = fVar.cVm().beE().getUserId();
            }
            if (this.kzW != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.cVo());
                PostData aU = aU(arrayList);
                boolean z6 = aU != null;
                if (aU != null) {
                    this.kAw = aU;
                }
                boolean z7 = false;
                if (!this.kAp && aU != null) {
                    arrayList.remove(aU);
                    z7 = true;
                    z6 = true;
                    if (fVar.cVM() && aU.dwM() != null) {
                        aU.c(null);
                    }
                }
                if (!z6 && fVar.cVv() != null) {
                    aU = fVar.cVv();
                    z7 = true;
                    z6 = true;
                    if (!this.kAp && fVar.cVM() && aU.dwM() != null) {
                        aU.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aU;
                eA(arrayList);
                if (this.kzA.cXS()) {
                    if (fVar.cVo().size() > 0 && (postData = fVar.cVo().get(0)) != null && postData.dwK() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.kAn, arrayList, this.kAp);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.kAn.cVp());
                    }
                }
                int c = c(this.kAn, arrayList, this.kAp);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.kAn.cVq());
                }
                com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
                boolean z9 = false;
                int b2 = b(fVar, arrayList);
                if (b2 >= 0) {
                    z9 = true;
                    a(fVar, arrayList, b2);
                }
                int a = a(fVar, arrayList);
                List<com.baidu.adp.widget.ListView.q> g = g(fVar);
                if (com.baidu.tbadk.core.util.y.isEmpty(g) || a < 0) {
                    z2 = z9;
                } else {
                    com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, a);
                    if (qVar2 instanceof PostData) {
                        ((PostData) qVar2).mfN = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.kAp);
                }
                if (i3 >= 0 && fVar.cVL() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, fVar.cVL());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.mfM = true;
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
                        zVar.kFZ = a3;
                    }
                }
                this.kzW.sS(!z4);
                boolean h = h(postData2);
                if (this.kAq && !h) {
                    arrayList.remove(postData2);
                    this.kAq = false;
                }
                if (fVar.cVL() != null) {
                    fVar.cVL().sE(!z3);
                }
                if (this.fCT != null) {
                    this.fwe = arrayList;
                    this.fCT.setData(this.fwe);
                }
                a(h, z, a, g);
                if (a(postData2, arrayList, z8)) {
                    this.fCT.setData(arrayList);
                }
            }
        }
    }

    private PostData aU(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dwK() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kyf);
        bw cVm = fVar.cVm();
        nVar.kyh = cVm != null ? cVm.bev() : 0L;
        nVar.isNew = !this.kAp;
        nVar.kyk = this.kzA.cYc();
        nVar.sortType = fVar.kwP;
        nVar.kyj = fVar.cVQ();
        nVar.isDynamic = fVar.cVP();
        nVar.kyl = fVar.kwO;
        com.baidu.tbadk.core.util.y.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kzA.cWE().cWv()) || !this.kzA.cWE().cYF())) {
            if (!this.kzA.cWu() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.cVJ())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.cVJ().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.kzA.cWE().cYC();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.kzA.cWE() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.kzA.cWE().cYA())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.kAs || this.kAr) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.kAt) {
                this.kAA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fCT.setSelectionFromTop(g.this.fCT.getHeaderViewsCount() + list.size(), 0 - g.this.kAC);
                        g.this.kAt = false;
                    }
                };
                com.baidu.adp.lib.f.e.mS().post(this.kAA);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.kAw != null && !this.kAr) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.kAw);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.HP(1);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.cVO()) && fVar.cVO().size() > 2) {
            int min = Math.min(fVar.cVO().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.n nVar = fVar.cVO().get(i5);
                if (!z2 && i5 == 0) {
                    nVar.hS(true);
                }
                if (nVar.beW() == null) {
                    if (i5 == min - 1) {
                        nVar.hT(true);
                    }
                } else if (i5 == min - 2) {
                    nVar.hT(true);
                } else if (i5 == min - 1) {
                    nVar.hU(true);
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
        if (i < 0 || fVar == null || !fVar.kwT || fVar.kwU == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.kwU;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.kzW.setData(fVar);
        this.kzW.setFromCDN(this.mIsFromCDN);
        this.kzW.setImageMaxWidth(this.kAv);
        this.kzW.sF(this.kAo);
        this.kzW.A(this.aRW);
        this.kzW.S(this.kAx);
        this.kzW.setOnImageClickListener(this.fcC);
        this.kzW.setOnLongClickListener(this.mOnLongClickListener);
        this.kzW.setTbGestureDetector(this.eFj);
        this.kAc.setData(fVar);
        this.kAc.setFromCDN(this.mIsFromCDN);
        this.kAc.gM(this.aYY);
        this.kAc.sF(this.kAo);
        this.kAc.A(this.aRW);
        this.kAc.S(this.kAx);
        this.kAc.setOnImageClickListener(this.fcC);
        this.kAc.setOnLongClickListener(this.mOnLongClickListener);
        this.kAc.setTbGestureDetector(this.eFj);
        this.kzX.setOnClickListener(this.aRW);
        this.kAj.setOnClickListener(this.aRW);
        this.kAd.setOnClickListener(this.kAD);
        if (this.kAf != null && (this.kAf instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kAf).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kAk.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.gM(this.aYY);
                next.setImageMaxWidth(this.kAv);
                next.sF(this.kAo);
                next.sG(this.kAp);
                next.sH(this.kAu);
                next.A(this.aRW);
                next.S(this.kAx);
                next.setOnImageClickListener(this.fcC);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.kAa.A(this.aRW);
        this.kAa.a(this.kAy);
        this.kAb.A(this.aRW);
        this.kAa.setData(fVar);
        this.kzZ.setData(fVar);
        this.kAb.setData(fVar);
        this.kAg.setData(fVar);
        this.kAh.setData(fVar);
        this.kAl.setPbData(fVar);
        this.kAl.setFrom(this.kzA.kEi);
        this.kAm.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z cVr = this.kAn.cVr();
        if (cVr != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.dWb) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.dWb) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (cVr instanceof z)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, cVr);
                return cVr;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel cWE;
        if (i >= 0 && (cWE = this.kzA.cWE()) != null) {
            String cZs = cWE.cZs();
            if (TextUtils.isEmpty(cZs)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.QM(cZs);
            c(nVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.kAn == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n cYQ = this.kzA.cWE().cYQ();
        if (cYQ == null) {
            cYQ = this.kAn.cVE();
        }
        if (cYQ != null) {
            AdvertAppInfo.ILegoAdvert dwz = cYQ.dwz();
            if (dwz != null) {
                dwz.setAdvertAppInfo(cYQ.rl());
            }
            int bcv = cYQ.dwy().bcv();
            if (bcv != 0) {
                a(cYQ, bcv);
                if (bcv == 28 || bcv == 31 || cYQ.dwy().goods == null) {
                    return null;
                }
                cYQ.dwy().goods.goods_style = -1001;
                return null;
            }
            if (this.kAn.getForum() != null) {
                cYQ.forumId = this.kAn.getForum().getId();
            }
            if (this.kAn.cVm() != null) {
                cYQ.threadId = com.baidu.adp.lib.f.b.toLong(this.kAn.cVm().getId(), 0L);
            }
            if (this.kAn != null && this.kAn.getPage() != null) {
                cYQ.pageNumber = this.kAn.getPage().bds();
            }
            c(cYQ);
            if (i >= 0) {
                com.baidu.tieba.lego.card.d.a.a(arrayList, cYQ, i);
                return cYQ;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.kAr || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cVo()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.cVM() && this.kAp) ? 0 : -1;
        } else if (this.kzA.cWE() == null || !this.kzA.cWE().getIsFromMark()) {
            if (this.kzA.cXu() == null || !this.kzA.cXu().dbA()) {
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
                        if (postData.dwK() == 1 && postData.mfJ == 0) {
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
                return fVar.cVM() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cVo()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.cVo(), 0)) == null) {
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
                if (postData.dwK() == 1 && postData.mfJ == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cVo()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.cVM()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.cVo().get(0) == null || fVar.cVo().get(0).dwK() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cVA() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cVA().kyv)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.cVA().kyv;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.mfW = true;
                postData.mfL = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.cVA().kyw) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).mfL = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).mfL = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kyg);
        nVar.kyi = fVar.cVA().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cyn() {
        if (this.kzA != null && !cyo()) {
            this.kzA.registerListener(this.inz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyo() {
        if (this.kzA == null) {
            return false;
        }
        this.inx = new ArrayList();
        ArrayList<BdUniqueId> dwb = com.baidu.tieba.tbadkCore.u.dwb();
        if (dwb == null || dwb.size() <= 0) {
            return false;
        }
        int size = dwb.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cNv().a(this.kzA.getPageContext(), dwb.get(i), 2);
            if (a != null) {
                this.bbw.add(a);
                this.inx.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.inx)) {
            this.fCT.addAdapters(this.inx);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.fCT.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.cVo() == null || fVar.cVp() == null || fVar.cVo().size() == 0 || fVar.cVm() == null || arrayList == null) {
            return -1;
        }
        if (fVar.cVp().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.cVo().get(0) == null || fVar.cVo().get(0).dwK() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bds() != fVar.getPage().bdp()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.cVo() == null || fVar.cVq() == null || fVar.cVo().size() == 0 || fVar.cVm() == null || arrayList == null) {
            return -1;
        }
        if (fVar.cVq().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.cVo().get(0) == null || fVar.cVo().get(0).dwK() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bds() != fVar.getPage().bdp()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.fCT.getItem(i);
    }

    public ArrayList<PostData> cXa() {
        return this.postList;
    }

    public BdUniqueId DV(int i) {
        if (this.fCT.getItem(i) != null) {
            return this.fCT.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.kAB = cXb();
        if (this.fCT.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }

    public int cXb() {
        if (this.fCT != null && this.fCT.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fCT.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.fCT.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.kyf) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cXc() {
        return this.kAB;
    }

    private void cXd() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kAn != null && !this.kAn.kxE && this.kAn.XX != 2) {
            ArrayList<PostData> cVo = this.kAn.cVo();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cVD = this.kAn.cVD();
            if (!com.baidu.tieba.lego.card.d.a.isEmpty(cVo) && !com.baidu.tieba.lego.card.d.a.isEmpty(cVD)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = cVD.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cVD.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.inv = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cVD.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dwy() != null) {
                        int bcv = next3.dwy().bcv();
                        if (bcv != 0) {
                            a(next3, bcv);
                            if (bcv != 28 && bcv != 31) {
                                if (next3.dwy().goods != null) {
                                    next3.dwy().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                cVD.clear();
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
                for (int i3 = 0; i3 < com.baidu.tieba.lego.card.d.a.ea(arrayList); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) com.baidu.tieba.lego.card.d.a.l(arrayList, i3)).intValue());
                    if (this.kAn.getForum() != null) {
                        nVar4.forumId = this.kAn.getForum().getId();
                    }
                    if (this.kAn.cVm() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kAn.cVm().getId(), 0L);
                    }
                    if (this.kAn != null && this.kAn.getPage() != null) {
                        nVar4.pageNumber = this.kAn.getPage().bds();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kAn.kxD;
                    if (position + i3 >= com.baidu.tieba.lego.card.d.a.ea(cVo)) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kAp) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.d.a.a(cVo, nVar4, position);
                        TiebaStatic.eventStat(this.kzA.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dwy().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.Gn(i);
        com.baidu.tieba.recapp.report.d.dol().a(c);
        if (nVar != null && nVar.dwy() != null) {
            nVar.dwy().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dwy() != null && nVar.dwy().goods != null && nVar.dwy().goods.goods_style != 1001 && nVar.dwy().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kAn != null && nVar.dwy() != null) {
            nVar.dwy().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kAn.getPage() != null) {
                nVar.dwy().advertAppContext.pn = this.kAn.getPage().bds();
            }
            nVar.dwy().advertAppContext.page = nVar.dwB();
            if (this.kAn.getForum() != null && (forum = this.kAn.getForum()) != null) {
                nVar.dwy().advertAppContext.fid = forum.getId();
                nVar.dwy().advertAppContext.dVO = forum.getFirst_class();
                nVar.dwy().advertAppContext.dVP = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dwy().advertAppContext.dVQ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dwy().advertAppContext.extensionInfo = nVar.dwy().ext_info;
            nVar.dwy().advertAppContext.Ye = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.kzW.setFromCDN(z);
        if (this.kAf != null && (this.kAf instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kAf).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kAk.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cXe() {
        return this.kAo;
    }

    public void sF(boolean z) {
        this.kAo = z;
    }

    public void sG(boolean z) {
        this.kAp = z;
    }

    public void sH(boolean z) {
        this.kAu = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAx = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcC = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kAy = aVar;
    }

    public void DW(int i) {
        switch (i) {
            case 1:
                if (this.kzW != null) {
                    this.kzW.pause();
                }
                if (this.kAf instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kAf).onPause();
                    return;
                }
                return;
            case 2:
                if (this.kzW != null) {
                    this.kzW.resume();
                }
                if (this.kAf instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kAf).onResume();
                    return;
                }
                return;
            case 3:
                if (this.kzW != null) {
                    this.kzW.release();
                }
                if (this.kAf instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kAf).onDestroy();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void eA(List<com.baidu.adp.widget.ListView.q> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.bfO())) {
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.zc(postData.bfO());
                        list.set(i, akVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kAA);
        if (this.kAa != null) {
            this.kAa.onDestroy();
        }
        if (this.kAb != null) {
            this.kAb.onDestroy();
        }
        if (this.kzX != null) {
            this.kzX.onDestroy();
        }
        if (this.kzZ != null) {
            this.kzZ.onDestroy();
        }
    }

    public void sL(boolean z) {
        this.kAr = z;
    }

    public void sM(boolean z) {
        this.kAs = z;
    }

    public void sN(boolean z) {
        this.kAq = z;
    }

    public void sO(boolean z) {
        this.kAt = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cXf() {
        return this.kzX;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.fwe;
    }

    public View cXg() {
        if (this.kzW == null || this.kzW.cXj() == null) {
            return null;
        }
        if (this.kzW.cXj().kCK != null && this.kzW.cXj().kCK.isShown()) {
            return this.kzW.cXj().kCK;
        }
        return this.kzW.cXj().kCJ;
    }

    public t cXh() {
        if (this.kzW == null || this.kzW.cXj() == null) {
            return null;
        }
        return this.kzW.cXj();
    }
}
