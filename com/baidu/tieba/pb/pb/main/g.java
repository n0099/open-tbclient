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
    private ArrayList<com.baidu.adp.widget.ListView.q> fTO;
    private BdTypeListView gcr;
    private List<com.baidu.adp.widget.ListView.a> iWc;
    private com.baidu.adp.widget.ListView.a jzw;
    private PbFragment ljH;
    private boolean lkA;
    private int lkC;
    private Runnable lkH;
    private int lkJ;
    private s lkd;
    private com.baidu.tieba.pb.pb.main.adapter.c lke;
    private com.baidu.tieba.pb.pb.main.adapter.d lkf;
    private com.baidu.tieba.pb.pb.main.adapter.a lkg;
    private at lkh;
    private at lki;
    private m lkj;
    private com.baidu.tieba.pb.video.a lkk;
    private com.baidu.tieba.card.divider.a lkl;
    private com.baidu.adp.widget.ListView.a lkm;
    private ap lkn;
    private aq lko;
    private an lkp;
    private com.baidu.tieba.pb.pb.a.c lkq;
    private h lks;
    private y lkt;
    private com.baidu.tieba.pb.data.f lku;
    private boolean lkz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> lkr = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lkv = true;
    private boolean lkw = true;
    private boolean lkx = false;
    private boolean lky = false;
    private boolean lkB = false;
    private String bgw = null;
    private PostData lkD = null;
    private View.OnClickListener lkE = null;
    private View.OnClickListener aYF = null;
    private TbRichTextView.i fAg = null;
    private com.baidu.tieba.pb.a.c fbT = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lkF = null;
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lkG = new ArrayList();
    private int lkI = -1;
    private CustomMessageListener iKi = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dHc = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dHc();
                Iterator it = dHc.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.ljH);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.lkr.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dHc);
                g.this.lkG.clear();
                g.this.lkG.addAll(arrayList);
                if (g.this.gcr != null) {
                    g.this.gcr.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener eZe = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.lku != null && !com.baidu.adp.base.i.G(g.this.ljH.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener lkK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.ljH != null && g.this.lku != null && g.this.lku.dfW() != null) {
                g.this.ljH.dhN().dkR().dgT();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12040"));
            }
        }
    };
    private CustomMessageListener iWe = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.iWc)) {
                g.this.cIL();
                g.this.a(g.this.lku, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lkC = 0;
        this.width = -1;
        this.lkJ = 0;
        this.lkC = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lkC;
        this.ljH = pbFragment;
        this.gcr = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.eZe);
        this.lkJ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.ljH.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lkd = new s(pbFragment, PostData.mQM);
        this.lkd.a((TbRichTextView.c) pbFragment);
        this.lke = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.lit);
        this.lkf = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lkg = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lgK);
        this.lkh = new at(pbFragment, com.baidu.tieba.pb.data.n.lim);
        this.lki = new at(pbFragment, com.baidu.tieba.pb.data.n.lin);
        this.lkj = new m(pbFragment, PostData.mQN);
        this.lkj.a((TbRichTextView.c) pbFragment);
        this.jzw = com.baidu.tieba.recapp.r.dxM().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.esI);
        this.lkm = com.baidu.tieba.recapp.r.dxM().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.esM);
        this.lkp = new an(pbFragment, com.baidu.tieba.pb.data.l.Xs);
        this.lkn = new ap(pbFragment, am.ltw);
        this.lko = new aq(pbFragment, com.baidu.tbadk.core.data.az.ewh);
        this.lkq = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.mQR);
        this.lkk = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.lEv);
        this.lkl = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lks = new h(pbFragment, com.baidu.tbadk.core.data.n.etV);
        this.lkt = new y(pbFragment, pbFragment.getUniqueId());
        this.bje.add(this.lkd);
        this.bje.add(this.lke);
        this.bje.add(this.lkf);
        this.bje.add(this.lkg);
        this.bje.add(this.lkj);
        this.bje.add(this.lkh);
        this.bje.add(this.lki);
        this.bje.add(this.jzw);
        this.bje.add(this.lkm);
        this.bje.add(this.lkp);
        this.bje.add(this.lkn);
        this.bje.add(this.lko);
        this.bje.add(this.lkk);
        this.bje.add(this.lkq);
        this.bje.add(this.lkl);
        this.bje.add(this.lks);
        this.bje.add(this.lkt);
        this.iKi.setPriority(1);
        this.iKi.setSelfListener(true);
        pbFragment.registerListener(this.iKi);
        cIK();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.bje);
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
            this.lku = fVar;
            dhw();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lku != null && this.lku.dfK() != null && this.lku.dfK().size() > 0) {
                this.postList.addAll(this.lku.dfK());
            }
            if (fVar.dfI() != null && fVar.dfI().bka() != null) {
                this.bgw = fVar.dfI().bka().getUserId();
            }
            if (this.lkd != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.dfK());
                PostData aZ = aZ(arrayList);
                boolean z6 = aZ != null;
                if (aZ != null) {
                    this.lkD = aZ;
                }
                boolean z7 = false;
                if (!this.lkw && aZ != null) {
                    arrayList.remove(aZ);
                    z7 = true;
                    z6 = true;
                    if (fVar.dgi() && aZ.dHz() != null) {
                        aZ.c(null);
                    }
                }
                if (!z6 && fVar.dfR() != null) {
                    aZ = fVar.dfR();
                    z7 = true;
                    z6 = true;
                    if (!this.lkw && fVar.dgi() && aZ.dHz() != null) {
                        aZ.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aZ;
                eU(arrayList);
                if (this.ljH.dil()) {
                    if (fVar.dfK().size() > 0 && (postData = fVar.dfK().get(0)) != null && postData.dHx() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.lku, arrayList, this.lkw);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.lku.dfL());
                    }
                }
                int c = c(this.lku, arrayList, this.lkw);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.lku.dfM());
                }
                com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
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
                        ((PostData) qVar2).mRz = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.lkw);
                }
                if (i3 >= 0 && fVar.dgh() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, fVar.dgh());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.mRy = true;
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
                        zVar.lqn = a4;
                    }
                }
                this.lkd.tX(!z4);
                boolean h = h(postData2);
                if (this.lkx && !h) {
                    arrayList.remove(postData2);
                    this.lkx = false;
                }
                if (fVar.dgh() != null) {
                    fVar.dgh().tJ(!z3);
                }
                if (this.gcr != null) {
                    this.fTO = arrayList;
                    this.gcr.setData(this.fTO);
                }
                a(h, z, a2, g);
                if (a(postData2, arrayList, z8)) {
                    this.gcr.setData(arrayList);
                }
            }
        }
    }

    private PostData aZ(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dHx() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lim);
        bw dfI = fVar.dfI();
        nVar.lio = dfI != null ? dfI.bjR() : 0L;
        nVar.isNew = !this.lkw;
        nVar.lir = this.ljH.div();
        nVar.sortType = fVar.lgY;
        nVar.liq = fVar.dgm();
        nVar.isDynamic = fVar.dgl();
        nVar.lis = fVar.lgX;
        com.baidu.tbadk.core.util.y.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.ljH.dgX().dgP()) || !this.ljH.dgX().diY())) {
            if (!this.ljH.dgO() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dgf())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.dgf().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.ljH.dgX().diV();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.ljH.dgX() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.ljH.dgX().diT())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.lkz || this.lky) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.lkA) {
                this.lkH = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gcr.setSelectionFromTop(g.this.gcr.getHeaderViewsCount() + list.size(), 0 - g.this.lkJ);
                        g.this.lkA = false;
                    }
                };
                com.baidu.adp.lib.f.e.mY().post(this.lkH);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.lkD != null && !this.lky) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.lkD);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.Jq(1);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dgk()) && fVar.dgk().size() > 2) {
            int min = Math.min(fVar.dgk().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.n nVar = fVar.dgk().get(i5);
                if (!z2 && i5 == 0) {
                    nVar.iy(true);
                }
                if (nVar.bks() == null) {
                    if (i5 == min - 1) {
                        nVar.iz(true);
                    }
                } else if (i5 == min - 2) {
                    nVar.iz(true);
                } else if (i5 == min - 1) {
                    nVar.iA(true);
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
        if (i < 0 || fVar == null || !fVar.lhc || fVar.lhd == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lhd;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lkd.setData(fVar);
        this.lkd.setFromCDN(this.mIsFromCDN);
        this.lkd.setImageMaxWidth(this.lkC);
        this.lkd.tK(this.lkv);
        this.lkd.A(this.aYF);
        this.lkd.S(this.lkE);
        this.lkd.setOnImageClickListener(this.fAg);
        this.lkd.setOnLongClickListener(this.mOnLongClickListener);
        this.lkd.setTbGestureDetector(this.fbT);
        this.lkj.setData(fVar);
        this.lkj.setFromCDN(this.mIsFromCDN);
        this.lkj.hx(this.bgw);
        this.lkj.tK(this.lkv);
        this.lkj.A(this.aYF);
        this.lkj.S(this.lkE);
        this.lkj.setOnImageClickListener(this.fAg);
        this.lkj.setOnLongClickListener(this.mOnLongClickListener);
        this.lkj.setTbGestureDetector(this.fbT);
        this.lke.setOnClickListener(this.aYF);
        this.lkq.setOnClickListener(this.aYF);
        this.lkk.setOnClickListener(this.lkK);
        if (this.lkm != null && (this.lkm instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.lkm).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lkr.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.hx(this.bgw);
                next.setImageMaxWidth(this.lkC);
                next.tK(this.lkv);
                next.tL(this.lkw);
                next.tM(this.lkB);
                next.A(this.aYF);
                next.S(this.lkE);
                next.setOnImageClickListener(this.fAg);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lkh.A(this.aYF);
        this.lkh.a(this.lkF);
        this.lki.A(this.aYF);
        this.lkh.setData(fVar);
        this.lkg.setData(fVar);
        this.lki.setData(fVar);
        this.lkn.setData(fVar);
        this.lko.setData(fVar);
        this.lks.setPbData(fVar);
        this.lks.setFrom(this.ljH.lov);
        this.lkt.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z dfN = this.lku.dfN();
        if (dfN != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.esM) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.esM) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dfN instanceof z)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, dfN);
                return dfN;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel dgX;
        if (i >= 0 && (dgX = this.ljH.dgX()) != null) {
            String djL = dgX.djL();
            if (TextUtils.isEmpty(djL)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.Sz(djL);
            c(nVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q d(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.lku == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n djj = this.ljH.dgX().djj();
        if (djj == null) {
            djj = this.lku.dga();
        }
        if (djj != null) {
            AdvertAppInfo.ILegoAdvert dHm = djj.dHm();
            if (dHm != null) {
                dHm.setAdvertAppInfo(djj.rq());
            }
            int bhR = djj.dHl().bhR();
            if (bhR != 0) {
                a(djj, bhR);
                if (bhR == 28 || bhR == 31 || djj.dHl().goods == null) {
                    return null;
                }
                djj.dHl().goods.goods_style = -1001;
                return null;
            }
            if (this.lku.getForum() != null) {
                djj.forumId = this.lku.getForum().getId();
            }
            if (this.lku.dfI() != null) {
                djj.threadId = com.baidu.adp.lib.f.b.toLong(this.lku.dfI().getId(), 0L);
            }
            if (this.lku != null && this.lku.getPage() != null) {
                djj.pageNumber = this.lku.getPage().biO();
            }
            c(djj);
            if (i >= 0) {
                com.baidu.tieba.lego.card.d.a.a(arrayList, djj, i);
                return djj;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.lky || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dfK()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dgi() && this.lkw) ? 0 : -1;
        } else if (this.ljH.dgX() == null || !this.ljH.dgX().getIsFromMark()) {
            if (this.ljH.dhN() == null || !this.ljH.dhN().dlT()) {
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
                        if (postData.dHx() == 1 && postData.mRv == 0) {
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
                return fVar.dgi() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dfK()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dfK(), 0)) == null) {
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
                if (postData.dHx() == 1 && postData.mRv == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dfK()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dgi()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dfK().get(0) == null || fVar.dfK().get(0).dHx() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dfW() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dfW().liC)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dfW().liC;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.mRI = true;
                postData.mRx = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.dfW().liD) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).mRx = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).mRx = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lin);
        nVar.lip = fVar.dfW().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cIK() {
        if (this.ljH != null && !cIL()) {
            this.ljH.registerListener(this.iWe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cIL() {
        if (this.ljH == null) {
            return false;
        }
        this.iWc = new ArrayList();
        ArrayList<BdUniqueId> dGO = com.baidu.tieba.tbadkCore.u.dGO();
        if (dGO == null || dGO.size() <= 0) {
            return false;
        }
        int size = dGO.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.cXR().a(this.ljH.getPageContext(), dGO.get(i), 2);
            if (a2 != null) {
                this.bje.add(a2);
                this.iWc.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iWc)) {
            this.gcr.addAdapters(this.iWc);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.gcr.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dfK() == null || fVar.dfL() == null || fVar.dfK().size() == 0 || fVar.dfI() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dfL().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dfK().get(0) == null || fVar.dfK().get(0).dHx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().biO() != fVar.getPage().biL()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dfK() == null || fVar.dfM() == null || fVar.dfK().size() == 0 || fVar.dfI() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dfM().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dfK().get(0) == null || fVar.dfK().get(0).dHx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().biO() != fVar.getPage().biL()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.gcr.getItem(i);
    }

    public ArrayList<PostData> dht() {
        return this.postList;
    }

    public BdUniqueId Fv(int i) {
        if (this.gcr.getItem(i) != null) {
            return this.gcr.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lkI = dhu();
        if (this.gcr.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }

    public int dhu() {
        if (this.gcr != null && this.gcr.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gcr.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.gcr.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.lim) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int dhv() {
        return this.lkI;
    }

    private void dhw() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lku != null && !this.lku.lhM && this.lku.YH != 2) {
            ArrayList<PostData> dfK = this.lku.dfK();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dfZ = this.lku.dfZ();
            if (!com.baidu.tieba.lego.card.d.a.isEmpty(dfK) && !com.baidu.tieba.lego.card.d.a.isEmpty(dfZ)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dfZ.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dfZ.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.iWa = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dfZ.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dHl() != null) {
                        int bhR = next3.dHl().bhR();
                        if (bhR != 0) {
                            a(next3, bhR);
                            if (bhR != 28 && bhR != 31) {
                                if (next3.dHl().goods != null) {
                                    next3.dHl().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dfZ.clear();
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
                for (int i3 = 0; i3 < com.baidu.tieba.lego.card.d.a.eu(arrayList); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) com.baidu.tieba.lego.card.d.a.l(arrayList, i3)).intValue());
                    if (this.lku.getForum() != null) {
                        nVar4.forumId = this.lku.getForum().getId();
                    }
                    if (this.lku.dfI() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lku.dfI().getId(), 0L);
                    }
                    if (this.lku != null && this.lku.getPage() != null) {
                        nVar4.pageNumber = this.lku.getPage().biO();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lku.lhL;
                    if (position + i3 >= com.baidu.tieba.lego.card.d.a.eu(dfK)) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lkw) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.d.a.a(dfK, nVar4, position);
                        TiebaStatic.eventStat(this.ljH.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dHl().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.HN(i);
        com.baidu.tieba.recapp.report.d.dyN().a(c);
        if (nVar != null && nVar.dHl() != null) {
            nVar.dHl().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dHl() != null && nVar.dHl().goods != null && nVar.dHl().goods.goods_style != 1001 && nVar.dHl().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lku != null && nVar.dHl() != null) {
            nVar.dHl().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.lku.getPage() != null) {
                nVar.dHl().advertAppContext.pn = this.lku.getPage().biO();
            }
            nVar.dHl().advertAppContext.page = nVar.dHo();
            if (this.lku.getForum() != null && (forum = this.lku.getForum()) != null) {
                nVar.dHl().advertAppContext.fid = forum.getId();
                nVar.dHl().advertAppContext.esz = forum.getFirst_class();
                nVar.dHl().advertAppContext.esA = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dHl().advertAppContext.esB = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dHl().advertAppContext.extensionInfo = nVar.dHl().ext_info;
            nVar.dHl().advertAppContext.YN = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lkd.setFromCDN(z);
        if (this.lkm != null && (this.lkm instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.lkm).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lkr.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean dhx() {
        return this.lkv;
    }

    public void tK(boolean z) {
        this.lkv = z;
    }

    public void tL(boolean z) {
        this.lkw = z;
    }

    public void tM(boolean z) {
        this.lkB = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lkE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fAg = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fbT = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lkF = aVar;
    }

    public void Fw(int i) {
        switch (i) {
            case 1:
                if (this.lkd != null) {
                    this.lkd.pause();
                }
                if (this.lkm instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.lkm).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lkd != null) {
                    this.lkd.resume();
                }
                if (this.lkm instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.lkm).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lkd != null) {
                    this.lkd.release();
                }
                if (this.lkm instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.lkm).onDestroy();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void eU(List<com.baidu.adp.widget.ListView.q> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.blk())) {
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.AC(postData.blk());
                        list.set(i, akVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lkH);
        if (this.lkh != null) {
            this.lkh.onDestroy();
        }
        if (this.lki != null) {
            this.lki.onDestroy();
        }
        if (this.lke != null) {
            this.lke.onDestroy();
        }
        if (this.lkg != null) {
            this.lkg.onDestroy();
        }
    }

    public void tQ(boolean z) {
        this.lky = z;
    }

    public void tR(boolean z) {
        this.lkz = z;
    }

    public void tS(boolean z) {
        this.lkx = z;
    }

    public void tT(boolean z) {
        this.lkA = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c dhy() {
        return this.lke;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.fTO;
    }

    public View dhz() {
        if (this.lkd == null || this.lkd.dhC() == null) {
            return null;
        }
        if (this.lkd.dhC().lmS != null && this.lkd.dhC().lmS.isShown()) {
            return this.lkd.dhC().lmS;
        }
        return this.lkd.dhC().lmR;
    }

    public t dhA() {
        if (this.lkd == null || this.lkd.dhC() == null) {
            return null;
        }
        return this.lkd.dhC();
    }
}
