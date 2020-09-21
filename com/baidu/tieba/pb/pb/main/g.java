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
/* loaded from: classes21.dex */
public class g {
    private BdTypeListView fGf;
    private ArrayList<com.baidu.adp.widget.ListView.q> fzo;
    private com.baidu.adp.widget.ListView.a iXX;
    private List<com.baidu.adp.widget.ListView.a> iuN;
    private PbFragment kHX;
    private com.baidu.tieba.pb.video.a kIA;
    private com.baidu.tieba.card.divider.a kIB;
    private com.baidu.adp.widget.ListView.a kIC;
    private ap kID;
    private aq kIE;
    private an kIF;
    private com.baidu.tieba.pb.pb.a.c kIG;
    private h kII;
    private y kIJ;
    private com.baidu.tieba.pb.data.f kIK;
    private boolean kIP;
    private boolean kIQ;
    private int kIS;
    private Runnable kIX;
    private int kIZ;
    private s kIt;
    private com.baidu.tieba.pb.pb.main.adapter.c kIu;
    private com.baidu.tieba.pb.pb.main.adapter.d kIv;
    private com.baidu.tieba.pb.pb.main.adapter.a kIw;
    private at kIx;
    private at kIy;
    private m kIz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> kIH = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean kIL = true;
    private boolean kIM = true;
    private boolean kIN = false;
    private boolean kIO = false;
    private boolean kIR = false;
    private String bbv = null;
    private PostData kIT = null;
    private View.OnClickListener kIU = null;
    private View.OnClickListener aTZ = null;
    private TbRichTextView.i ffu = null;
    private com.baidu.tieba.pb.a.c eHq = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a kIV = null;
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> kIW = new ArrayList();
    private int kIY = -1;
    private CustomMessageListener iiP = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dAi = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dAi();
                Iterator it = dAi.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.kHX);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.kIH.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dAi);
                g.this.kIW.clear();
                g.this.kIW.addAll(arrayList);
                if (g.this.fGf != null) {
                    g.this.fGf.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener eEB = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.kIK != null && !com.baidu.adp.base.i.G(g.this.kHX.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener kJa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.kHX != null && g.this.kIK != null && g.this.kIK.cZf() != null) {
                g.this.kHX.daX().deb().dac();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12040"));
            }
        }
    };
    private CustomMessageListener iuP = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.iuN)) {
                g.this.cBV();
                g.this.a(g.this.kIK, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kIS = 0;
        this.width = -1;
        this.kIZ = 0;
        this.kIS = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.kIS;
        this.kHX = pbFragment;
        this.fGf = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.eEB);
        this.kIZ = com.baidu.adp.lib.util.l.getEquipmentHeight(this.kHX.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kIt = new s(pbFragment, PostData.moA);
        this.kIt.a((TbRichTextView.c) pbFragment);
        this.kIu = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.kGJ);
        this.kIv = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kIw = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.kFa);
        this.kIx = new at(pbFragment, com.baidu.tieba.pb.data.n.kGC);
        this.kIy = new at(pbFragment, com.baidu.tieba.pb.data.n.kGD);
        this.kIz = new m(pbFragment, PostData.moB);
        this.kIz.a((TbRichTextView.c) pbFragment);
        this.iXX = com.baidu.tieba.recapp.r.dqU().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dYh);
        this.kIC = com.baidu.tieba.recapp.r.dqU().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dYl);
        this.kIF = new an(pbFragment, com.baidu.tieba.pb.data.l.Xa);
        this.kID = new ap(pbFragment, am.kRG);
        this.kIE = new aq(pbFragment, com.baidu.tbadk.core.data.az.ebF);
        this.kIG = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.moF);
        this.kIA = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.lcF);
        this.kIB = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.kII = new h(pbFragment, com.baidu.tbadk.core.data.n.dZt);
        this.kIJ = new y(pbFragment, pbFragment.getUniqueId());
        this.bdV.add(this.kIt);
        this.bdV.add(this.kIu);
        this.bdV.add(this.kIv);
        this.bdV.add(this.kIw);
        this.bdV.add(this.kIz);
        this.bdV.add(this.kIx);
        this.bdV.add(this.kIy);
        this.bdV.add(this.iXX);
        this.bdV.add(this.kIC);
        this.bdV.add(this.kIF);
        this.bdV.add(this.kID);
        this.bdV.add(this.kIE);
        this.bdV.add(this.kIA);
        this.bdV.add(this.kIG);
        this.bdV.add(this.kIB);
        this.bdV.add(this.kII);
        this.bdV.add(this.kIJ);
        this.iiP.setPriority(1);
        this.iiP.setSelfListener(true);
        pbFragment.registerListener(this.iiP);
        cBU();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.bdV);
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
            this.kIK = fVar;
            daG();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kIK != null && this.kIK.cYT() != null && this.kIK.cYT().size() > 0) {
                this.postList.addAll(this.kIK.cYT());
            }
            if (fVar.cYR() != null && fVar.cYR().bfy() != null) {
                this.bbv = fVar.cYR().bfy().getUserId();
            }
            if (this.kIt != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.cYT());
                PostData aW = aW(arrayList);
                boolean z6 = aW != null;
                if (aW != null) {
                    this.kIT = aW;
                }
                boolean z7 = false;
                if (!this.kIM && aW != null) {
                    arrayList.remove(aW);
                    z7 = true;
                    z6 = true;
                    if (fVar.cZr() && aW.dAF() != null) {
                        aW.c(null);
                    }
                }
                if (!z6 && fVar.cZa() != null) {
                    aW = fVar.cZa();
                    z7 = true;
                    z6 = true;
                    if (!this.kIM && fVar.cZr() && aW.dAF() != null) {
                        aW.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aW;
                eI(arrayList);
                if (this.kHX.dbv()) {
                    if (fVar.cYT().size() > 0 && (postData = fVar.cYT().get(0)) != null && postData.dAD() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.kIK, arrayList, this.kIM);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.kIK.cYU());
                    }
                }
                int c = c(this.kIK, arrayList, this.kIM);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.kIK.cYV());
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
                        ((PostData) qVar2).mpm = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.kIM);
                }
                if (i3 >= 0 && fVar.cZq() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, fVar.cZq());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.mpl = true;
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
                        } else if (a >= 0) {
                            i6 = a;
                        } else if (b2 >= 0) {
                            i6 = b2;
                        }
                        com.baidu.adp.widget.ListView.q d = d(arrayList, i6);
                        z10 = d != null;
                        i2 = i6;
                        qVar = d;
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
                        zVar.kOy = a3;
                    }
                }
                this.kIt.sZ(!z4);
                boolean h = h(postData2);
                if (this.kIN && !h) {
                    arrayList.remove(postData2);
                    this.kIN = false;
                }
                if (fVar.cZq() != null) {
                    fVar.cZq().sL(!z3);
                }
                if (this.fGf != null) {
                    this.fzo = arrayList;
                    this.fGf.setData(this.fzo);
                }
                a(h, z, a, g);
                if (a(postData2, arrayList, z8)) {
                    this.fGf.setData(arrayList);
                }
            }
        }
    }

    private PostData aW(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dAD() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kGC);
        bw cYR = fVar.cYR();
        nVar.kGE = cYR != null ? cYR.bfp() : 0L;
        nVar.isNew = !this.kIM;
        nVar.kGH = this.kHX.dbF();
        nVar.sortType = fVar.kFo;
        nVar.kGG = fVar.cZv();
        nVar.isDynamic = fVar.cZu();
        nVar.kGI = fVar.kFn;
        com.baidu.tbadk.core.util.y.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kHX.dah().cZY()) || !this.kHX.dah().dci())) {
            if (!this.kHX.cZX() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.cZo())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.cZo().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.kHX.dah().dcf();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.kHX.dah() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.kHX.dah().dcd())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.kIP || this.kIO) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.kIQ) {
                this.kIX = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fGf.setSelectionFromTop(g.this.fGf.getHeaderViewsCount() + list.size(), 0 - g.this.kIZ);
                        g.this.kIQ = false;
                    }
                };
                com.baidu.adp.lib.f.e.mX().post(this.kIX);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.kIT != null && !this.kIO) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.kIT);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.Is(1);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.cZt()) && fVar.cZt().size() > 2) {
            int min = Math.min(fVar.cZt().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.n nVar = fVar.cZt().get(i5);
                if (!z2 && i5 == 0) {
                    nVar.hP(true);
                }
                if (nVar.bfQ() == null) {
                    if (i5 == min - 1) {
                        nVar.hQ(true);
                    }
                } else if (i5 == min - 2) {
                    nVar.hQ(true);
                } else if (i5 == min - 1) {
                    nVar.hR(true);
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
        if (i < 0 || fVar == null || !fVar.kFs || fVar.kFt == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.kFt;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.kIt.setData(fVar);
        this.kIt.setFromCDN(this.mIsFromCDN);
        this.kIt.setImageMaxWidth(this.kIS);
        this.kIt.sM(this.kIL);
        this.kIt.A(this.aTZ);
        this.kIt.S(this.kIU);
        this.kIt.setOnImageClickListener(this.ffu);
        this.kIt.setOnLongClickListener(this.mOnLongClickListener);
        this.kIt.setTbGestureDetector(this.eHq);
        this.kIz.setData(fVar);
        this.kIz.setFromCDN(this.mIsFromCDN);
        this.kIz.gY(this.bbv);
        this.kIz.sM(this.kIL);
        this.kIz.A(this.aTZ);
        this.kIz.S(this.kIU);
        this.kIz.setOnImageClickListener(this.ffu);
        this.kIz.setOnLongClickListener(this.mOnLongClickListener);
        this.kIz.setTbGestureDetector(this.eHq);
        this.kIu.setOnClickListener(this.aTZ);
        this.kIG.setOnClickListener(this.aTZ);
        this.kIA.setOnClickListener(this.kJa);
        if (this.kIC != null && (this.kIC instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kIC).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kIH.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.gY(this.bbv);
                next.setImageMaxWidth(this.kIS);
                next.sM(this.kIL);
                next.sN(this.kIM);
                next.sO(this.kIR);
                next.A(this.aTZ);
                next.S(this.kIU);
                next.setOnImageClickListener(this.ffu);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.kIx.A(this.aTZ);
        this.kIx.a(this.kIV);
        this.kIy.A(this.aTZ);
        this.kIx.setData(fVar);
        this.kIw.setData(fVar);
        this.kIy.setData(fVar);
        this.kID.setData(fVar);
        this.kIE.setData(fVar);
        this.kII.setPbData(fVar);
        this.kII.setFrom(this.kHX.kMH);
        this.kIJ.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z cYW = this.kIK.cYW();
        if (cYW != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.dYl) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.dYl) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (cYW instanceof z)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, cYW);
                return cYW;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel dah;
        if (i >= 0 && (dah = this.kHX.dah()) != null) {
            String dcV = dah.dcV();
            if (TextUtils.isEmpty(dcV)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.Rm(dcV);
            c(nVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q d(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.kIK == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n dct = this.kHX.dah().dct();
        if (dct == null) {
            dct = this.kIK.cZj();
        }
        if (dct != null) {
            AdvertAppInfo.ILegoAdvert dAs = dct.dAs();
            if (dAs != null) {
                dAs.setAdvertAppInfo(dct.rq());
            }
            int bdp = dct.dAr().bdp();
            if (bdp != 0) {
                a(dct, bdp);
                if (bdp == 28 || bdp == 31 || dct.dAr().goods == null) {
                    return null;
                }
                dct.dAr().goods.goods_style = -1001;
                return null;
            }
            if (this.kIK.getForum() != null) {
                dct.forumId = this.kIK.getForum().getId();
            }
            if (this.kIK.cYR() != null) {
                dct.threadId = com.baidu.adp.lib.f.b.toLong(this.kIK.cYR().getId(), 0L);
            }
            if (this.kIK != null && this.kIK.getPage() != null) {
                dct.pageNumber = this.kIK.getPage().bem();
            }
            c(dct);
            if (i >= 0) {
                com.baidu.tieba.lego.card.d.a.a(arrayList, dct, i);
                return dct;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.kIO || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cYT()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.cZr() && this.kIM) ? 0 : -1;
        } else if (this.kHX.dah() == null || !this.kHX.dah().getIsFromMark()) {
            if (this.kHX.daX() == null || !this.kHX.daX().dfd()) {
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
                        if (postData.dAD() == 1 && postData.mpi == 0) {
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
                return fVar.cZr() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cYT()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.cYT(), 0)) == null) {
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
                if (postData.dAD() == 1 && postData.mpi == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cYT()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.cZr()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.cYT().get(0) == null || fVar.cYT().get(0).dAD() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cZf() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.cZf().kGS)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.cZf().kGS;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.mpv = true;
                postData.mpk = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.cZf().kGT) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).mpk = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).mpk = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kGD);
        nVar.kGF = fVar.cZf().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cBU() {
        if (this.kHX != null && !cBV()) {
            this.kHX.registerListener(this.iuP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cBV() {
        if (this.kHX == null) {
            return false;
        }
        this.iuN = new ArrayList();
        ArrayList<BdUniqueId> dzU = com.baidu.tieba.tbadkCore.u.dzU();
        if (dzU == null || dzU.size() <= 0) {
            return false;
        }
        int size = dzU.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cRa().a(this.kHX.getPageContext(), dzU.get(i), 2);
            if (a != null) {
                this.bdV.add(a);
                this.iuN.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.iuN)) {
            this.fGf.addAdapters(this.iuN);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.fGf.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.cYT() == null || fVar.cYU() == null || fVar.cYT().size() == 0 || fVar.cYR() == null || arrayList == null) {
            return -1;
        }
        if (fVar.cYU().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.cYT().get(0) == null || fVar.cYT().get(0).dAD() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bem() != fVar.getPage().bej()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.cYT() == null || fVar.cYV() == null || fVar.cYT().size() == 0 || fVar.cYR() == null || arrayList == null) {
            return -1;
        }
        if (fVar.cYV().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.cYT().get(0) == null || fVar.cYT().get(0).dAD() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bem() != fVar.getPage().bej()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.fGf.getItem(i);
    }

    public ArrayList<PostData> daD() {
        return this.postList;
    }

    public BdUniqueId Ew(int i) {
        if (this.fGf.getItem(i) != null) {
            return this.fGf.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.kIY = daE();
        if (this.fGf.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }

    public int daE() {
        if (this.fGf != null && this.fGf.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fGf.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.fGf.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.kGC) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int daF() {
        return this.kIY;
    }

    private void daG() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kIK != null && !this.kIK.kGc && this.kIK.Yq != 2) {
            ArrayList<PostData> cYT = this.kIK.cYT();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cZi = this.kIK.cZi();
            if (!com.baidu.tieba.lego.card.d.a.isEmpty(cYT) && !com.baidu.tieba.lego.card.d.a.isEmpty(cZi)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = cZi.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cZi.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.iuL = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cZi.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dAr() != null) {
                        int bdp = next3.dAr().bdp();
                        if (bdp != 0) {
                            a(next3, bdp);
                            if (bdp != 28 && bdp != 31) {
                                if (next3.dAr().goods != null) {
                                    next3.dAr().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                cZi.clear();
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
                for (int i3 = 0; i3 < com.baidu.tieba.lego.card.d.a.ei(arrayList); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) com.baidu.tieba.lego.card.d.a.l(arrayList, i3)).intValue());
                    if (this.kIK.getForum() != null) {
                        nVar4.forumId = this.kIK.getForum().getId();
                    }
                    if (this.kIK.cYR() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kIK.cYR().getId(), 0L);
                    }
                    if (this.kIK != null && this.kIK.getPage() != null) {
                        nVar4.pageNumber = this.kIK.getPage().bem();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kIK.kGb;
                    if (position + i3 >= com.baidu.tieba.lego.card.d.a.ei(cYT)) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kIM) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.d.a.a(cYT, nVar4, position);
                        TiebaStatic.eventStat(this.kHX.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dAr().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.GO(i);
        com.baidu.tieba.recapp.report.d.drV().a(c);
        if (nVar != null && nVar.dAr() != null) {
            nVar.dAr().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dAr() != null && nVar.dAr().goods != null && nVar.dAr().goods.goods_style != 1001 && nVar.dAr().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kIK != null && nVar.dAr() != null) {
            nVar.dAr().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kIK.getPage() != null) {
                nVar.dAr().advertAppContext.pn = this.kIK.getPage().bem();
            }
            nVar.dAr().advertAppContext.page = nVar.dAu();
            if (this.kIK.getForum() != null && (forum = this.kIK.getForum()) != null) {
                nVar.dAr().advertAppContext.fid = forum.getId();
                nVar.dAr().advertAppContext.dXY = forum.getFirst_class();
                nVar.dAr().advertAppContext.dXZ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dAr().advertAppContext.dYa = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dAr().advertAppContext.extensionInfo = nVar.dAr().ext_info;
            nVar.dAr().advertAppContext.Yw = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.kIt.setFromCDN(z);
        if (this.kIC != null && (this.kIC instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.kIC).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kIH.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean daH() {
        return this.kIL;
    }

    public void sM(boolean z) {
        this.kIL = z;
    }

    public void sN(boolean z) {
        this.kIM = z;
    }

    public void sO(boolean z) {
        this.kIR = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kIU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ffu = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eHq = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kIV = aVar;
    }

    public void Ex(int i) {
        switch (i) {
            case 1:
                if (this.kIt != null) {
                    this.kIt.pause();
                }
                if (this.kIC instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kIC).onPause();
                    return;
                }
                return;
            case 2:
                if (this.kIt != null) {
                    this.kIt.resume();
                }
                if (this.kIC instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kIC).onResume();
                    return;
                }
                return;
            case 3:
                if (this.kIt != null) {
                    this.kIt.release();
                }
                if (this.kIC instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.kIC).onDestroy();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void eI(List<com.baidu.adp.widget.ListView.q> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.bgI())) {
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.zx(postData.bgI());
                        list.set(i, akVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.kIX);
        if (this.kIx != null) {
            this.kIx.onDestroy();
        }
        if (this.kIy != null) {
            this.kIy.onDestroy();
        }
        if (this.kIu != null) {
            this.kIu.onDestroy();
        }
        if (this.kIw != null) {
            this.kIw.onDestroy();
        }
    }

    public void sS(boolean z) {
        this.kIO = z;
    }

    public void sT(boolean z) {
        this.kIP = z;
    }

    public void sU(boolean z) {
        this.kIN = z;
    }

    public void sV(boolean z) {
        this.kIQ = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c daI() {
        return this.kIu;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.fzo;
    }

    public View daJ() {
        if (this.kIt == null || this.kIt.daM() == null) {
            return null;
        }
        if (this.kIt.daM().kLi != null && this.kIt.daM().kLi.isShown()) {
            return this.kIt.daM().kLi;
        }
        return this.kIt.daM().kLh;
    }

    public t daK() {
        if (this.kIt == null || this.kIt.daM() == null) {
            return null;
        }
        return this.kIt.daM();
    }
}
