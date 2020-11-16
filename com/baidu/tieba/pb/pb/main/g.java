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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class g {
    private ArrayList<com.baidu.adp.widget.ListView.q> fZl;
    private BdTypeListView ghN;
    private com.baidu.adp.widget.ListView.a jGs;
    private List<com.baidu.adp.widget.ListView.a> jcM;
    private PbFragment lpX;
    private com.baidu.tieba.pb.video.a lqA;
    private com.baidu.tieba.card.divider.a lqB;
    private com.baidu.adp.widget.ListView.a lqC;
    private ap lqD;
    private aq lqE;
    private an lqF;
    private com.baidu.tieba.pb.pb.a.c lqG;
    private h lqI;
    private y lqJ;
    private com.baidu.tieba.pb.data.f lqK;
    private boolean lqP;
    private boolean lqQ;
    private int lqS;
    private Runnable lqX;
    private int lqZ;
    private s lqt;
    private com.baidu.tieba.pb.pb.main.adapter.c lqu;
    private com.baidu.tieba.pb.pb.main.adapter.d lqv;
    private com.baidu.tieba.pb.pb.main.adapter.a lqw;
    private at lqx;
    private at lqy;
    private m lqz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> lqH = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lqL = true;
    private boolean lqM = true;
    private boolean lqN = false;
    private boolean lqO = false;
    private boolean lqR = false;
    private String bgd = null;
    private PostData lqT = null;
    private View.OnClickListener lqU = null;
    private View.OnClickListener aYm = null;
    private TbRichTextView.i fFy = null;
    private com.baidu.tieba.pb.a.c fgS = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lqV = null;
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lqW = new ArrayList();
    private int lqY = -1;
    private CustomMessageListener iQS = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dJv = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dJv();
                Iterator it = dJv.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.lpX);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.lqH.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dJv);
                g.this.lqW.clear();
                g.this.lqW.addAll(arrayList);
                if (g.this.ghN != null) {
                    g.this.ghN.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener fed = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.lqK != null && !com.baidu.adp.base.i.G(g.this.lpX.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener lra = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lpX != null && g.this.lqK != null && g.this.lqK.dhV() != null) {
                g.this.lpX.djM().dmS().diR();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12040"));
            }
        }
    };
    private CustomMessageListener jcO = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.jcM)) {
                g.this.cKS();
                g.this.a(g.this.lqK, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lqS = 0;
        this.width = -1;
        this.lqZ = 0;
        this.lqS = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lqS;
        this.lpX = pbFragment;
        this.ghN = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.fed);
        this.lqZ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lpX.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lqt = new s(pbFragment, PostData.mXI);
        this.lqt.a((TbRichTextView.c) pbFragment);
        this.lqu = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.loL);
        this.lqv = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lqw = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lmW);
        this.lqx = new at(pbFragment, com.baidu.tieba.pb.data.n.loE);
        this.lqy = new at(pbFragment, com.baidu.tieba.pb.data.n.loF);
        this.lqz = new m(pbFragment, PostData.mXJ);
        this.lqz.a((TbRichTextView.c) pbFragment);
        this.jGs = com.baidu.tieba.recapp.q.dzO().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.ewQ);
        this.lqC = com.baidu.tieba.recapp.q.dzO().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.ewU);
        this.lqF = new an(pbFragment, com.baidu.tieba.pb.data.l.Xw);
        this.lqD = new ap(pbFragment, am.lzL);
        this.lqE = new aq(pbFragment, com.baidu.tbadk.core.data.ba.eAr);
        this.lqG = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.mXN);
        this.lqA = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.lKJ);
        this.lqB = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lqI = new h(pbFragment, com.baidu.tbadk.core.data.o.eyd);
        this.lqJ = new y(pbFragment, pbFragment.getUniqueId());
        this.biN.add(this.lqt);
        this.biN.add(this.lqu);
        this.biN.add(this.lqv);
        this.biN.add(this.lqw);
        this.biN.add(this.lqz);
        this.biN.add(this.lqx);
        this.biN.add(this.lqy);
        this.biN.add(this.jGs);
        this.biN.add(this.lqC);
        this.biN.add(this.lqF);
        this.biN.add(this.lqD);
        this.biN.add(this.lqE);
        this.biN.add(this.lqA);
        this.biN.add(this.lqG);
        this.biN.add(this.lqB);
        this.biN.add(this.lqI);
        this.biN.add(this.lqJ);
        this.iQS.setPriority(1);
        this.iQS.setSelfListener(true);
        pbFragment.registerListener(this.iQS);
        cKR();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.biN);
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
            this.lqK = fVar;
            dju();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lqK != null && this.lqK.dhJ() != null && this.lqK.dhJ().size() > 0) {
                this.postList.addAll(this.lqK.dhJ());
            }
            if (fVar.dhH() != null && fVar.dhH().blC() != null) {
                this.bgd = fVar.dhH().blC().getUserId();
            }
            if (this.lqt != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.dhJ());
                PostData ba = ba(arrayList);
                boolean z6 = ba != null;
                if (ba != null) {
                    this.lqT = ba;
                }
                boolean z7 = false;
                if (!this.lqM && ba != null) {
                    arrayList.remove(ba);
                    z7 = true;
                    z6 = true;
                    if (fVar.dih() && ba.dJS() != null) {
                        ba.c(null);
                    }
                }
                if (!z6 && fVar.dhQ() != null) {
                    ba = fVar.dhQ();
                    z7 = true;
                    z6 = true;
                    if (!this.lqM && fVar.dih() && ba.dJS() != null) {
                        ba.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = ba;
                fc(arrayList);
                if (this.lpX.dkk()) {
                    if (fVar.dhJ().size() > 0 && (postData = fVar.dhJ().get(0)) != null && postData.dJQ() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.lqK, arrayList, this.lqM);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.lqK.dhK());
                    }
                }
                int c = c(this.lqK, arrayList, this.lqM);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.lqK.dhL());
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
                        ((PostData) qVar2).mYu = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.lqM);
                }
                if (i3 >= 0 && fVar.dig() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, fVar.dig());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.mYt = true;
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
                        zVar.lwA = a4;
                    }
                }
                this.lqt.uj(!z4);
                boolean h = h(postData2);
                if (this.lqN && !h) {
                    arrayList.remove(postData2);
                    this.lqN = false;
                }
                if (fVar.dig() != null) {
                    fVar.dig().tV(!z3);
                }
                if (this.ghN != null) {
                    this.fZl = arrayList;
                    this.ghN.setData(this.fZl);
                }
                a(h, z, a2, g);
                if (a(postData2, arrayList, z8)) {
                    this.ghN.setData(arrayList);
                }
            }
        }
    }

    private PostData ba(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dJQ() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.loE);
        bx dhH = fVar.dhH();
        nVar.loG = dhH != null ? dhH.blt() : 0L;
        nVar.isNew = !this.lqM;
        nVar.loJ = this.lpX.dku();
        nVar.sortType = fVar.lnl;
        nVar.loI = fVar.dil();
        nVar.isDynamic = fVar.dik();
        nVar.loK = fVar.lnk;
        com.baidu.tbadk.core.util.y.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lpX.diV().diO()) || !this.lpX.diV().dkX())) {
            if (!this.lpX.diN() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.die())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.die().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lpX.diV().dkU();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.lpX.diV() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lpX.diV().dkS())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.lqP || this.lqO) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.lqQ) {
                this.lqX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.ghN.setSelectionFromTop(g.this.ghN.getHeaderViewsCount() + list.size(), 0 - g.this.lqZ);
                        g.this.lqQ = false;
                    }
                };
                com.baidu.adp.lib.f.e.mY().post(this.lqX);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.lqT != null && !this.lqO) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.lqT);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.Kf(1);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dij()) && fVar.dij().size() > 2) {
            int min = Math.min(fVar.dij().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.o oVar = fVar.dij().get(i5);
                if (!z2 && i5 == 0) {
                    oVar.iI(true);
                }
                if (oVar.blU() == null) {
                    if (i5 == min - 1) {
                        oVar.iJ(true);
                    }
                } else if (i5 == min - 2) {
                    oVar.iJ(true);
                } else if (i5 == min - 1) {
                    oVar.iK(true);
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
        if (i < 0 || fVar == null || !fVar.lnp || fVar.lnq == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lnq;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lqt.setData(fVar);
        this.lqt.setFromCDN(this.mIsFromCDN);
        this.lqt.setImageMaxWidth(this.lqS);
        this.lqt.tW(this.lqL);
        this.lqt.B(this.aYm);
        this.lqt.S(this.lqU);
        this.lqt.setOnImageClickListener(this.fFy);
        this.lqt.setOnLongClickListener(this.mOnLongClickListener);
        this.lqt.setTbGestureDetector(this.fgS);
        this.lqz.setData(fVar);
        this.lqz.setFromCDN(this.mIsFromCDN);
        this.lqz.hy(this.bgd);
        this.lqz.tW(this.lqL);
        this.lqz.B(this.aYm);
        this.lqz.S(this.lqU);
        this.lqz.setOnImageClickListener(this.fFy);
        this.lqz.setOnLongClickListener(this.mOnLongClickListener);
        this.lqz.setTbGestureDetector(this.fgS);
        this.lqu.setOnClickListener(this.aYm);
        this.lqG.setOnClickListener(this.aYm);
        this.lqA.setOnClickListener(this.lra);
        if (this.lqC != null && (this.lqC instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.lqC).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lqH.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.hy(this.bgd);
                next.setImageMaxWidth(this.lqS);
                next.tW(this.lqL);
                next.tX(this.lqM);
                next.tY(this.lqR);
                next.B(this.aYm);
                next.S(this.lqU);
                next.setOnImageClickListener(this.fFy);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lqx.B(this.aYm);
        this.lqx.a(this.lqV);
        this.lqy.B(this.aYm);
        this.lqx.setData(fVar);
        this.lqw.setData(fVar);
        this.lqy.setData(fVar);
        this.lqD.setData(fVar);
        this.lqE.setData(fVar);
        this.lqI.setPbData(fVar);
        this.lqI.setFrom(this.lpX.luJ);
        this.lqJ.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z dhM = this.lqK.dhM();
        if (dhM != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.ewU) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.ewU) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dhM instanceof z)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, dhM);
                return dhM;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel diV;
        if (i >= 0 && (diV = this.lpX.diV()) != null) {
            String dlK = diV.dlK();
            if (TextUtils.isEmpty(dlK)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.Sr(dlK);
            c(nVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q d(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.lqK == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n dli = this.lpX.diV().dli();
        if (dli == null) {
            dli = this.lqK.dhZ();
        }
        if (dli != null) {
            AdvertAppInfo.ILegoAdvert dJF = dli.dJF();
            if (dJF != null) {
                dJF.setAdvertAppInfo(dli.rq());
            }
            int bjt = dli.dJE().bjt();
            if (bjt != 0) {
                a(dli, bjt);
                if (bjt == 28 || bjt == 31 || dli.dJE().goods == null) {
                    return null;
                }
                dli.dJE().goods.goods_style = -1001;
                return null;
            }
            if (this.lqK.getForum() != null) {
                dli.forumId = this.lqK.getForum().getId();
            }
            if (this.lqK.dhH() != null) {
                dli.threadId = com.baidu.adp.lib.f.b.toLong(this.lqK.dhH().getId(), 0L);
            }
            if (this.lqK != null && this.lqK.getPage() != null) {
                dli.pageNumber = this.lqK.getPage().bkq();
            }
            c(dli);
            if (i >= 0) {
                com.baidu.tieba.lego.card.d.a.a(arrayList, dli, i);
                return dli;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.lqO || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dhJ()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dih() && this.lqM) ? 0 : -1;
        } else if (this.lpX.diV() == null || !this.lpX.diV().getIsFromMark()) {
            if (this.lpX.djM() == null || !this.lpX.djM().dnV()) {
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
                        if (postData.dJQ() == 1 && postData.mYq == 0) {
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
                return fVar.dih() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dhJ()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dhJ(), 0)) == null) {
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
                if (postData.dJQ() == 1 && postData.mYq == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dhJ()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dih()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dhJ().get(0) == null || fVar.dhJ().get(0).dJQ() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dhV() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dhV().loU)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dhV().loU;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.mYD = true;
                postData.mYs = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.dhV().loV) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).mYs = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).mYs = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.loF);
        nVar.loH = fVar.dhV().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cKR() {
        if (this.lpX != null && !cKS()) {
            this.lpX.registerListener(this.jcO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cKS() {
        if (this.lpX == null) {
            return false;
        }
        this.jcM = new ArrayList();
        ArrayList<BdUniqueId> dJh = com.baidu.tieba.tbadkCore.u.dJh();
        if (dJh == null || dJh.size() <= 0) {
            return false;
        }
        int size = dJh.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.cZP().a(this.lpX.getPageContext(), dJh.get(i), 2);
            if (a2 != null) {
                this.biN.add(a2);
                this.jcM.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jcM)) {
            this.ghN.addAdapters(this.jcM);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.ghN.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dhJ() == null || fVar.dhK() == null || fVar.dhJ().size() == 0 || fVar.dhH() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dhK().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dhJ().get(0) == null || fVar.dhJ().get(0).dJQ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bkq() != fVar.getPage().bkn()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dhJ() == null || fVar.dhL() == null || fVar.dhJ().size() == 0 || fVar.dhH() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dhL().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dhJ().get(0) == null || fVar.dhJ().get(0).dJQ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bkq() != fVar.getPage().bkn()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.ghN.getItem(i);
    }

    public ArrayList<PostData> djr() {
        return this.postList;
    }

    public BdUniqueId Gg(int i) {
        if (this.ghN.getItem(i) != null) {
            return this.ghN.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lqY = djs();
        if (this.ghN.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }

    public int djs() {
        if (this.ghN != null && this.ghN.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ghN.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.ghN.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.loE) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int djt() {
        return this.lqY;
    }

    private void dju() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lqK != null && !this.lqK.lnZ && this.lqK.YM != 2) {
            ArrayList<PostData> dhJ = this.lqK.dhJ();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dhY = this.lqK.dhY();
            if (!com.baidu.tieba.lego.card.d.a.isEmpty(dhJ) && !com.baidu.tieba.lego.card.d.a.isEmpty(dhY)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dhY.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dhY.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.jcK = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dhY.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dJE() != null) {
                        int bjt = next3.dJE().bjt();
                        if (bjt != 0) {
                            a(next3, bjt);
                            if (bjt != 28 && bjt != 31) {
                                if (next3.dJE().goods != null) {
                                    next3.dJE().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dhY.clear();
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
                for (int i3 = 0; i3 < com.baidu.tieba.lego.card.d.a.eC(arrayList); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) com.baidu.tieba.lego.card.d.a.l(arrayList, i3)).intValue());
                    if (this.lqK.getForum() != null) {
                        nVar4.forumId = this.lqK.getForum().getId();
                    }
                    if (this.lqK.dhH() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lqK.dhH().getId(), 0L);
                    }
                    if (this.lqK != null && this.lqK.getPage() != null) {
                        nVar4.pageNumber = this.lqK.getPage().bkq();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lqK.lnY;
                    if (position + i3 >= com.baidu.tieba.lego.card.d.a.eC(dhJ)) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lqM) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.d.a.a(dhJ, nVar4, position);
                        TiebaStatic.eventStat(this.lpX.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dJE().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.IB(i);
        com.baidu.tieba.recapp.report.d.dAT().a(c);
        if (nVar != null && nVar.dJE() != null) {
            nVar.dJE().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dJE() != null && nVar.dJE().goods != null && nVar.dJE().goods.goods_style != 1001 && nVar.dJE().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lqK != null && nVar.dJE() != null) {
            nVar.dJE().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lqK.getPage() != null) {
                nVar.dJE().advertAppContext.pn = this.lqK.getPage().bkq();
            }
            nVar.dJE().advertAppContext.page = nVar.dJH();
            if (this.lqK.getForum() != null && (forum = this.lqK.getForum()) != null) {
                nVar.dJE().advertAppContext.fid = forum.getId();
                nVar.dJE().advertAppContext.ewH = forum.getFirst_class();
                nVar.dJE().advertAppContext.ewI = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dJE().advertAppContext.ewJ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dJE().advertAppContext.extensionInfo = nVar.dJE().ext_info;
            nVar.dJE().advertAppContext.YS = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lqt.setFromCDN(z);
        if (this.lqC != null && (this.lqC instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.lqC).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lqH.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean djv() {
        return this.lqL;
    }

    public void tW(boolean z) {
        this.lqL = z;
    }

    public void tX(boolean z) {
        this.lqM = z;
    }

    public void tY(boolean z) {
        this.lqR = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lqU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fgS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lqV = aVar;
    }

    public void Gh(int i) {
        switch (i) {
            case 1:
                if (this.lqt != null) {
                    this.lqt.pause();
                }
                if (this.lqC instanceof com.baidu.tieba.recapp.j) {
                    ((com.baidu.tieba.recapp.j) this.lqC).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lqt != null) {
                    this.lqt.resume();
                }
                if (this.lqC instanceof com.baidu.tieba.recapp.j) {
                    ((com.baidu.tieba.recapp.j) this.lqC).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lqt != null) {
                    this.lqt.release();
                }
                if (this.lqC instanceof com.baidu.tieba.recapp.j) {
                    ((com.baidu.tieba.recapp.j) this.lqC).onDestroy();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void fc(List<com.baidu.adp.widget.ListView.q> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.bmO())) {
                        com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                        alVar.Al(postData.bmO());
                        list.set(i, alVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lqX);
        if (this.lqx != null) {
            this.lqx.onDestroy();
        }
        if (this.lqy != null) {
            this.lqy.onDestroy();
        }
        if (this.lqu != null) {
            this.lqu.onDestroy();
        }
        if (this.lqw != null) {
            this.lqw.onDestroy();
        }
    }

    public void uc(boolean z) {
        this.lqO = z;
    }

    public void ud(boolean z) {
        this.lqP = z;
    }

    public void ue(boolean z) {
        this.lqN = z;
    }

    public void uf(boolean z) {
        this.lqQ = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c djw() {
        return this.lqu;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.fZl;
    }

    public View djx() {
        if (this.lqt == null || this.lqt.djB() == null) {
            return null;
        }
        if (this.lqt.djB().ltj != null && this.lqt.djB().ltj.isShown()) {
            return this.lqt.djB().ltj;
        }
        return this.lqt.djB().lti;
    }

    public t djy() {
        if (this.lqt == null || this.lqt.djB() == null) {
            return null;
        }
        return this.lqt.djB();
    }
}
