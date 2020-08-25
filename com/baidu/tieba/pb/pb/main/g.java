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
    private BdTypeListView fCP;
    private ArrayList<com.baidu.adp.widget.ListView.q> fwa;
    private com.baidu.adp.widget.ListView.a iPl;
    private List<com.baidu.adp.widget.ListView.a> inq;
    private aq kAa;
    private an kAb;
    private com.baidu.tieba.pb.pb.a.c kAc;
    private h kAe;
    private y kAf;
    private com.baidu.tieba.pb.data.f kAg;
    private boolean kAl;
    private boolean kAm;
    private int kAo;
    private Runnable kAt;
    private int kAv;
    private s kzP;
    private com.baidu.tieba.pb.pb.main.adapter.c kzQ;
    private com.baidu.tieba.pb.pb.main.adapter.d kzR;
    private com.baidu.tieba.pb.pb.main.adapter.a kzS;
    private at kzT;
    private at kzU;
    private m kzV;
    private com.baidu.tieba.pb.video.a kzW;
    private com.baidu.tieba.card.divider.a kzX;
    private com.baidu.adp.widget.ListView.a kzY;
    private ap kzZ;
    private PbFragment kzt;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> kAd = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean kAh = true;
    private boolean kAi = true;
    private boolean kAj = false;
    private boolean kAk = false;
    private boolean kAn = false;
    private String aYW = null;
    private PostData kAp = null;
    private View.OnClickListener kAq = null;
    private View.OnClickListener aRU = null;
    private TbRichTextView.i fcy = null;
    private com.baidu.tieba.pb.a.c eFf = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a kAr = null;
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> kAs = new ArrayList();
    private int kAu = -1;
    private CustomMessageListener ibF = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dwk = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dwk();
                Iterator it = dwk.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.kzt);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.kAd.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dwk);
                g.this.kAs.clear();
                g.this.kAs.addAll(arrayList);
                if (g.this.fCP != null) {
                    g.this.fCP.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener eCs = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.kAg != null && !com.baidu.adp.base.i.G(g.this.kzt.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener kAw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.kzt != null && g.this.kAg != null && g.this.kAg.cVz() != null) {
                g.this.kzt.cXt().dax().cWy();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12040"));
            }
        }
    };

    /* renamed from: int  reason: not valid java name */
    private CustomMessageListener f6int = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.inq)) {
                g.this.cyn();
                g.this.a(g.this.kAg, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kAo = 0;
        this.width = -1;
        this.kAv = 0;
        this.kAo = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.kAo;
        this.kzt = pbFragment;
        this.fCP = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.eCs);
        this.kAv = com.baidu.adp.lib.util.l.getEquipmentHeight(this.kzt.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kzP = new s(pbFragment, PostData.meM);
        this.kzP.a((TbRichTextView.c) pbFragment);
        this.kzQ = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.kyf);
        this.kzR = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kzS = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.kwu);
        this.kzT = new at(pbFragment, com.baidu.tieba.pb.data.n.kxY);
        this.kzU = new at(pbFragment, com.baidu.tieba.pb.data.n.kxZ);
        this.kzV = new m(pbFragment, PostData.meN);
        this.kzV.a((TbRichTextView.c) pbFragment);
        this.iPl = com.baidu.tieba.recapp.r.dnh().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dVT);
        this.kzY = com.baidu.tieba.recapp.r.dnh().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dVX);
        this.kAb = new an(pbFragment, com.baidu.tieba.pb.data.l.WI);
        this.kzZ = new ap(pbFragment, am.kIZ);
        this.kAa = new aq(pbFragment, com.baidu.tbadk.core.data.az.dZr);
        this.kAc = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.meR);
        this.kzW = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.kTU);
        this.kzX = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.kAe = new h(pbFragment, com.baidu.tbadk.core.data.n.dXf);
        this.kAf = new y(pbFragment, pbFragment.getUniqueId());
        this.bbu.add(this.kzP);
        this.bbu.add(this.kzQ);
        this.bbu.add(this.kzR);
        this.bbu.add(this.kzS);
        this.bbu.add(this.kzV);
        this.bbu.add(this.kzT);
        this.bbu.add(this.kzU);
        this.bbu.add(this.iPl);
        this.bbu.add(this.kzY);
        this.bbu.add(this.kAb);
        this.bbu.add(this.kzZ);
        this.bbu.add(this.kAa);
        this.bbu.add(this.kzW);
        this.bbu.add(this.kAc);
        this.bbu.add(this.kzX);
        this.bbu.add(this.kAe);
        this.bbu.add(this.kAf);
        this.ibF.setPriority(1);
        this.ibF.setSelfListener(true);
        pbFragment.registerListener(this.ibF);
        cym();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.bbu);
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
            this.kAg = fVar;
            cXc();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kAg != null && this.kAg.cVn() != null && this.kAg.cVn().size() > 0) {
                this.postList.addAll(this.kAg.cVn());
            }
            if (fVar.cVl() != null && fVar.cVl().beE() != null) {
                this.aYW = fVar.cVl().beE().getUserId();
            }
            if (this.kzP != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.cVn());
                PostData aU = aU(arrayList);
                boolean z6 = aU != null;
                if (aU != null) {
                    this.kAp = aU;
                }
                boolean z7 = false;
                if (!this.kAi && aU != null) {
                    arrayList.remove(aU);
                    z7 = true;
                    z6 = true;
                    if (fVar.cVL() && aU.dwH() != null) {
                        aU.c(null);
                    }
                }
                if (!z6 && fVar.cVu() != null) {
                    aU = fVar.cVu();
                    z7 = true;
                    z6 = true;
                    if (!this.kAi && fVar.cVL() && aU.dwH() != null) {
                        aU.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aU;
                eA(arrayList);
                if (this.kzt.cXR()) {
                    if (fVar.cVn().size() > 0 && (postData = fVar.cVn().get(0)) != null && postData.dwF() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.kAg, arrayList, this.kAi);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.kAg.cVo());
                    }
                }
                int c = c(this.kAg, arrayList, this.kAi);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.kAg.cVp());
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
                        ((PostData) qVar2).mfy = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.kAi);
                }
                if (i3 >= 0 && fVar.cVK() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, fVar.cVK());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.mfx = true;
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
                        zVar.kFS = a3;
                    }
                }
                this.kzP.sQ(!z4);
                boolean h = h(postData2);
                if (this.kAj && !h) {
                    arrayList.remove(postData2);
                    this.kAj = false;
                }
                if (fVar.cVK() != null) {
                    fVar.cVK().sC(!z3);
                }
                if (this.fCP != null) {
                    this.fwa = arrayList;
                    this.fCP.setData(this.fwa);
                }
                a(h, z, a, g);
                if (a(postData2, arrayList, z8)) {
                    this.fCP.setData(arrayList);
                }
            }
        }
    }

    private PostData aU(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dwF() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kxY);
        bw cVl = fVar.cVl();
        nVar.kya = cVl != null ? cVl.bev() : 0L;
        nVar.isNew = !this.kAi;
        nVar.kyd = this.kzt.cYb();
        nVar.sortType = fVar.kwI;
        nVar.kyc = fVar.cVP();
        nVar.isDynamic = fVar.cVO();
        nVar.kye = fVar.kwH;
        com.baidu.tbadk.core.util.y.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kzt.cWD().cWu()) || !this.kzt.cWD().cYE())) {
            if (!this.kzt.cWt() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.cVI())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.cVI().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.kzt.cWD().cYB();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.kzt.cWD() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.kzt.cWD().cYz())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.kAl || this.kAk) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.kAm) {
                this.kAt = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fCP.setSelectionFromTop(g.this.fCP.getHeaderViewsCount() + list.size(), 0 - g.this.kAv);
                        g.this.kAm = false;
                    }
                };
                com.baidu.adp.lib.f.e.mS().post(this.kAt);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.kAp != null && !this.kAk) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.kAp);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.cVN()) && fVar.cVN().size() > 2) {
            int min = Math.min(fVar.cVN().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.n nVar = fVar.cVN().get(i5);
                if (!z2 && i5 == 0) {
                    nVar.hR(true);
                }
                if (nVar.beW() == null) {
                    if (i5 == min - 1) {
                        nVar.hS(true);
                    }
                } else if (i5 == min - 2) {
                    nVar.hS(true);
                } else if (i5 == min - 1) {
                    nVar.hT(true);
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
        if (i < 0 || fVar == null || !fVar.kwM || fVar.kwN == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.kwN;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.kzP.setData(fVar);
        this.kzP.setFromCDN(this.mIsFromCDN);
        this.kzP.setImageMaxWidth(this.kAo);
        this.kzP.sD(this.kAh);
        this.kzP.A(this.aRU);
        this.kzP.S(this.kAq);
        this.kzP.setOnImageClickListener(this.fcy);
        this.kzP.setOnLongClickListener(this.mOnLongClickListener);
        this.kzP.setTbGestureDetector(this.eFf);
        this.kzV.setData(fVar);
        this.kzV.setFromCDN(this.mIsFromCDN);
        this.kzV.gL(this.aYW);
        this.kzV.sD(this.kAh);
        this.kzV.A(this.aRU);
        this.kzV.S(this.kAq);
        this.kzV.setOnImageClickListener(this.fcy);
        this.kzV.setOnLongClickListener(this.mOnLongClickListener);
        this.kzV.setTbGestureDetector(this.eFf);
        this.kzQ.setOnClickListener(this.aRU);
        this.kAc.setOnClickListener(this.aRU);
        this.kzW.setOnClickListener(this.kAw);
        if (this.kzY != null && (this.kzY instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kzY).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kAd.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.gL(this.aYW);
                next.setImageMaxWidth(this.kAo);
                next.sD(this.kAh);
                next.sE(this.kAi);
                next.sF(this.kAn);
                next.A(this.aRU);
                next.S(this.kAq);
                next.setOnImageClickListener(this.fcy);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.kzT.A(this.aRU);
        this.kzT.a(this.kAr);
        this.kzU.A(this.aRU);
        this.kzT.setData(fVar);
        this.kzS.setData(fVar);
        this.kzU.setData(fVar);
        this.kzZ.setData(fVar);
        this.kAa.setData(fVar);
        this.kAe.setPbData(fVar);
        this.kAe.setFrom(this.kzt.kEb);
        this.kAf.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z cVq = this.kAg.cVq();
        if (cVq != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.dVX) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.dVX) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (cVq instanceof z)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, cVq);
                return cVq;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel cWD;
        if (i >= 0 && (cWD = this.kzt.cWD()) != null) {
            String cZr = cWD.cZr();
            if (TextUtils.isEmpty(cZr)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.QM(cZr);
            c(nVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.kAg == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n cYP = this.kzt.cWD().cYP();
        if (cYP == null) {
            cYP = this.kAg.cVD();
        }
        if (cYP != null) {
            AdvertAppInfo.ILegoAdvert dwu = cYP.dwu();
            if (dwu != null) {
                dwu.setAdvertAppInfo(cYP.rl());
            }
            int bcv = cYP.dwt().bcv();
            if (bcv != 0) {
                a(cYP, bcv);
                if (bcv == 28 || bcv == 31 || cYP.dwt().goods == null) {
                    return null;
                }
                cYP.dwt().goods.goods_style = -1001;
                return null;
            }
            if (this.kAg.getForum() != null) {
                cYP.forumId = this.kAg.getForum().getId();
            }
            if (this.kAg.cVl() != null) {
                cYP.threadId = com.baidu.adp.lib.f.b.toLong(this.kAg.cVl().getId(), 0L);
            }
            if (this.kAg != null && this.kAg.getPage() != null) {
                cYP.pageNumber = this.kAg.getPage().bds();
            }
            c(cYP);
            if (i >= 0) {
                com.baidu.tieba.lego.card.d.a.a(arrayList, cYP, i);
                return cYP;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.kAk || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cVn()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.cVL() && this.kAi) ? 0 : -1;
        } else if (this.kzt.cWD() == null || !this.kzt.cWD().getIsFromMark()) {
            if (this.kzt.cXt() == null || !this.kzt.cXt().dbz()) {
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
                        if (postData.dwF() == 1 && postData.mfu == 0) {
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
                return fVar.cVL() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cVn()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.cVn(), 0)) == null) {
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
                if (postData.dwF() == 1 && postData.mfu == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cVn()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.cVL()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.cVn().get(0) == null || fVar.cVn().get(0).dwF() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cVz() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cVz().kyo)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.cVz().kyo;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.mfH = true;
                postData.mfw = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.cVz().kyp) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).mfw = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).mfw = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kxZ);
        nVar.kyb = fVar.cVz().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cym() {
        if (this.kzt != null && !cyn()) {
            this.kzt.registerListener(this.f6int);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cyn() {
        if (this.kzt == null) {
            return false;
        }
        this.inq = new ArrayList();
        ArrayList<BdUniqueId> dvW = com.baidu.tieba.tbadkCore.u.dvW();
        if (dvW == null || dvW.size() <= 0) {
            return false;
        }
        int size = dvW.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cNu().a(this.kzt.getPageContext(), dvW.get(i), 2);
            if (a != null) {
                this.bbu.add(a);
                this.inq.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.inq)) {
            this.fCP.addAdapters(this.inq);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.fCP.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.cVn() == null || fVar.cVo() == null || fVar.cVn().size() == 0 || fVar.cVl() == null || arrayList == null) {
            return -1;
        }
        if (fVar.cVo().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.cVn().get(0) == null || fVar.cVn().get(0).dwF() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bds() != fVar.getPage().bdp()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.cVn() == null || fVar.cVp() == null || fVar.cVn().size() == 0 || fVar.cVl() == null || arrayList == null) {
            return -1;
        }
        if (fVar.cVp().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.cVn().get(0) == null || fVar.cVn().get(0).dwF() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bds() != fVar.getPage().bdp()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.fCP.getItem(i);
    }

    public ArrayList<PostData> cWZ() {
        return this.postList;
    }

    public BdUniqueId DV(int i) {
        if (this.fCP.getItem(i) != null) {
            return this.fCP.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.kAu = cXa();
        if (this.fCP.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    public int cXa() {
        if (this.fCP != null && this.fCP.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fCP.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.fCP.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.kxY) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cXb() {
        return this.kAu;
    }

    private void cXc() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kAg != null && !this.kAg.kxx && this.kAg.XV != 2) {
            ArrayList<PostData> cVn = this.kAg.cVn();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cVC = this.kAg.cVC();
            if (!com.baidu.tieba.lego.card.d.a.isEmpty(cVn) && !com.baidu.tieba.lego.card.d.a.isEmpty(cVC)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = cVC.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cVC.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.ino = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cVC.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dwt() != null) {
                        int bcv = next3.dwt().bcv();
                        if (bcv != 0) {
                            a(next3, bcv);
                            if (bcv != 28 && bcv != 31) {
                                if (next3.dwt().goods != null) {
                                    next3.dwt().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                cVC.clear();
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
                    if (this.kAg.getForum() != null) {
                        nVar4.forumId = this.kAg.getForum().getId();
                    }
                    if (this.kAg.cVl() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kAg.cVl().getId(), 0L);
                    }
                    if (this.kAg != null && this.kAg.getPage() != null) {
                        nVar4.pageNumber = this.kAg.getPage().bds();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kAg.kxw;
                    if (position + i3 >= com.baidu.tieba.lego.card.d.a.ea(cVn)) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kAi) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.d.a.a(cVn, nVar4, position);
                        TiebaStatic.eventStat(this.kzt.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dwt().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.Gn(i);
        com.baidu.tieba.recapp.report.d.doi().a(c);
        if (nVar != null && nVar.dwt() != null) {
            nVar.dwt().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dwt() != null && nVar.dwt().goods != null && nVar.dwt().goods.goods_style != 1001 && nVar.dwt().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kAg != null && nVar.dwt() != null) {
            nVar.dwt().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kAg.getPage() != null) {
                nVar.dwt().advertAppContext.pn = this.kAg.getPage().bds();
            }
            nVar.dwt().advertAppContext.page = nVar.dww();
            if (this.kAg.getForum() != null && (forum = this.kAg.getForum()) != null) {
                nVar.dwt().advertAppContext.fid = forum.getId();
                nVar.dwt().advertAppContext.dVK = forum.getFirst_class();
                nVar.dwt().advertAppContext.dVL = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dwt().advertAppContext.dVM = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dwt().advertAppContext.extensionInfo = nVar.dwt().ext_info;
            nVar.dwt().advertAppContext.Yb = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.kzP.setFromCDN(z);
        if (this.kzY != null && (this.kzY instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kzY).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kAd.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cXd() {
        return this.kAh;
    }

    public void sD(boolean z) {
        this.kAh = z;
    }

    public void sE(boolean z) {
        this.kAi = z;
    }

    public void sF(boolean z) {
        this.kAn = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAq = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFf = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aRU = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kAr = aVar;
    }

    public void DW(int i) {
        switch (i) {
            case 1:
                if (this.kzP != null) {
                    this.kzP.pause();
                }
                if (this.kzY instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kzY).onPause();
                    return;
                }
                return;
            case 2:
                if (this.kzP != null) {
                    this.kzP.resume();
                }
                if (this.kzY instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kzY).onResume();
                    return;
                }
                return;
            case 3:
                if (this.kzP != null) {
                    this.kzP.release();
                }
                if (this.kzY instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kzY).onDestroy();
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
                        akVar.zb(postData.bfO());
                        list.set(i, akVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kAt);
        if (this.kzT != null) {
            this.kzT.onDestroy();
        }
        if (this.kzU != null) {
            this.kzU.onDestroy();
        }
        if (this.kzQ != null) {
            this.kzQ.onDestroy();
        }
        if (this.kzS != null) {
            this.kzS.onDestroy();
        }
    }

    public void sJ(boolean z) {
        this.kAk = z;
    }

    public void sK(boolean z) {
        this.kAl = z;
    }

    public void sL(boolean z) {
        this.kAj = z;
    }

    public void sM(boolean z) {
        this.kAm = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cXe() {
        return this.kzQ;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.fwa;
    }

    public View cXf() {
        if (this.kzP == null || this.kzP.cXi() == null) {
            return null;
        }
        if (this.kzP.cXi().kCD != null && this.kzP.cXi().kCD.isShown()) {
            return this.kzP.cXi().kCD;
        }
        return this.kzP.cXi().kCC;
    }

    public t cXg() {
        if (this.kzP == null || this.kzP.cXi() == null) {
            return null;
        }
        return this.kzP.cXi();
    }
}
