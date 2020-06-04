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
import com.baidu.tbadk.core.data.bk;
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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class g {
    private ArrayList<com.baidu.adp.widget.ListView.o> eVq;
    private BdTypeListView fbb;
    private List<com.baidu.adp.widget.ListView.a> hFU;
    private com.baidu.adp.widget.ListView.a ifc;
    private PbFragment jHL;
    private com.baidu.tieba.pb.data.e jIA;
    private boolean jIF;
    private boolean jIG;
    private int jII;
    private Runnable jIN;
    private int jIP;
    private q jIj;
    private com.baidu.tieba.pb.pb.main.adapter.c jIk;
    private com.baidu.tieba.pb.pb.main.adapter.d jIl;
    private com.baidu.tieba.pb.pb.main.adapter.a jIm;
    private ap jIn;
    private ap jIo;
    private k jIp;
    private com.baidu.tieba.pb.video.a jIq;
    private com.baidu.tieba.card.divider.a jIr;
    private com.baidu.adp.widget.ListView.a jIs;
    private al jIt;
    private am jIu;
    private aj jIv;
    private com.baidu.tieba.pb.pb.a.c jIw;
    private h jIy;
    private w jIz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> jIx = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean jIB = true;
    private boolean jIC = true;
    private boolean jID = false;
    private boolean jIE = false;
    private boolean jIH = false;
    private String aPJ = null;
    private PostData jIJ = null;
    private View.OnClickListener jIK = null;
    private View.OnClickListener aIH = null;
    private TbRichTextView.i eBN = null;
    private com.baidu.tieba.pb.a.c efF = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a jIL = null;
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> jIM = new ArrayList();
    private int jIO = -1;
    private CustomMessageListener huJ = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList ddo = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).ddo();
                Iterator it = ddo.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).a(g.this.jHL);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.jIx.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(ddo);
                g.this.jIM.clear();
                g.this.jIM.addAll(arrayList);
                if (g.this.fbb != null) {
                    g.this.fbb.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener edg = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.jIA != null && !com.baidu.adp.base.i.E(g.this.jHL.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener jIQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.jHL != null && g.this.jIA != null && g.this.jIA.cCM() != null) {
                g.this.jHL.cEE().cHD().cDJ();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener hFW = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(g.this.hFU)) {
                g.this.cgs();
                g.this.a(g.this.jIA, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.jII = 0;
        this.width = -1;
        this.jIP = 0;
        this.jII = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.jII;
        this.jHL = pbFragment;
        this.fbb = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.edg);
        this.jIP = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jHL.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.jIj = new q(pbFragment, PostData.llR);
        this.jIj.a((TbRichTextView.c) pbFragment);
        this.jIk = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.m.jGv);
        this.jIl = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.g.TYPE);
        this.jIm = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.jEP);
        this.jIn = new ap(pbFragment, com.baidu.tieba.pb.data.l.jGo);
        this.jIo = new ap(pbFragment, com.baidu.tieba.pb.data.l.jGp);
        this.jIp = new k(pbFragment, PostData.llS);
        this.jIp.a((TbRichTextView.c) pbFragment);
        this.ifc = com.baidu.tieba.recapp.q.cUC().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dAi);
        this.jIs = com.baidu.tieba.recapp.q.cUC().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dAm);
        this.jIv = new aj(pbFragment, com.baidu.tieba.pb.data.j.VD);
        this.jIt = new al(pbFragment, ai.jQD);
        this.jIu = new am(pbFragment, com.baidu.tbadk.core.data.as.dDq);
        this.jIw = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.llX);
        this.jIq = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.kbF);
        this.jIr = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.jIy = new h(pbFragment, com.baidu.tbadk.core.data.k.dBs);
        this.jIz = new w(pbFragment, pbFragment.getUniqueId());
        this.aSj.add(this.jIj);
        this.aSj.add(this.jIk);
        this.aSj.add(this.jIl);
        this.aSj.add(this.jIm);
        this.aSj.add(this.jIp);
        this.aSj.add(this.jIn);
        this.aSj.add(this.jIo);
        this.aSj.add(this.ifc);
        this.aSj.add(this.jIs);
        this.aSj.add(this.jIv);
        this.aSj.add(this.jIt);
        this.aSj.add(this.jIu);
        this.aSj.add(this.jIq);
        this.aSj.add(this.jIw);
        this.aSj.add(this.jIr);
        this.aSj.add(this.jIy);
        this.aSj.add(this.jIz);
        this.huJ.setPriority(1);
        this.huJ.setSelfListener(true);
        pbFragment.registerListener(this.huJ);
        cgr();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.aSj);
    }

    public void a(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        x xVar;
        boolean z5;
        int i2;
        com.baidu.adp.widget.ListView.o oVar;
        PostData postData;
        if (eVar != null) {
            boolean z6 = false;
            if (this.jIA != eVar) {
                z6 = eVar.cCw() && TbadkCoreApplication.getInst().isRecAppExist();
            }
            this.jIA = eVar;
            if (z6) {
                cEn();
                eVar.rb(false);
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.jIA != null && this.jIA.cCA() != null && this.jIA.cCA().size() > 0) {
                this.postList.addAll(this.jIA.cCA());
            }
            if (eVar.cCy() != null && eVar.cCy().aQx() != null) {
                this.aPJ = eVar.cCy().aQx().getUserId();
            }
            if (this.jIj != null) {
                f(eVar);
                ArrayList<com.baidu.adp.widget.ListView.o> arrayList = new ArrayList<>(eVar.cCA());
                PostData aM = aM(arrayList);
                boolean z7 = aM != null;
                if (aM != null) {
                    this.jIJ = aM;
                }
                boolean z8 = false;
                if (!this.jIC && aM != null) {
                    arrayList.remove(aM);
                    z8 = true;
                    z7 = true;
                    if (eVar.aWj() && aM.ddL() != null) {
                        aM.c(null);
                    }
                }
                if (!z7 && eVar.cCH() != null) {
                    aM = eVar.cCH();
                    z8 = true;
                    z7 = true;
                    if (!this.jIC && eVar.aWj() && aM.ddL() != null) {
                        aM.c(null);
                    }
                }
                boolean z9 = z8;
                PostData postData2 = aM;
                dY(arrayList);
                if (this.jHL.cFc()) {
                    if (eVar.cCA().size() > 0 && (postData = eVar.cCA().get(0)) != null && postData.ddJ() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.jIA, arrayList, this.jIC);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList, b, this.jIA.cCB());
                    }
                }
                int c = c(this.jIA, arrayList, this.jIC);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList, c, this.jIA.cCC());
                }
                com.baidu.tieba.tbadkCore.t.s(arrayList, 1);
                boolean z10 = false;
                int b2 = b(eVar, arrayList);
                if (b2 >= 0) {
                    z10 = true;
                    a(eVar, arrayList, b2);
                }
                int a = a(eVar, arrayList);
                List<com.baidu.adp.widget.ListView.o> g = g(eVar);
                if (com.baidu.tbadk.core.util.v.isEmpty(g) || a < 0) {
                    z2 = z10;
                } else {
                    com.baidu.adp.widget.ListView.o oVar2 = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, a);
                    if (oVar2 instanceof PostData) {
                        ((PostData) oVar2).lmF = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList, a, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z7) {
                    i3 = a(eVar, arrayList, this.jIC);
                }
                if (i3 >= 0 && eVar.cCW() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList, i3, eVar.cCW());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.lmE = true;
                    }
                    z3 = false;
                    z4 = z2;
                }
                int i4 = b(eVar, arrayList, i3) != null ? i3 + 1 : i3;
                int i5 = c(eVar, arrayList, i4) != null ? i4 + 1 : i4;
                int i6 = -1;
                if (!z7) {
                    i = -1;
                    xVar = null;
                    z5 = false;
                } else {
                    com.baidu.adp.widget.ListView.o b3 = b(arrayList, i5);
                    boolean z11 = b3 != null;
                    if (z11) {
                        i2 = -1;
                        oVar = b3;
                    } else {
                        if (i5 >= 0) {
                            i6 = i5 + 1;
                        } else if (a >= 0) {
                            i6 = a;
                        } else if (b2 >= 0) {
                            i6 = b2;
                        }
                        com.baidu.adp.widget.ListView.o c2 = c(arrayList, i6);
                        z11 = c2 != null;
                        i2 = i6;
                        oVar = c2;
                    }
                    x a2 = a(arrayList, oVar, i5, i2);
                    if (a2 == null) {
                        i = i2;
                        xVar = a2;
                        z5 = z11;
                    } else if (!z11) {
                        i = i2;
                        xVar = a2;
                        z5 = true;
                    } else if (i2 > 0) {
                        i = i2 + 1;
                        xVar = a2;
                        z5 = z11;
                    } else {
                        i5++;
                        i = i2;
                        xVar = a2;
                        z5 = z11;
                    }
                }
                if (z7) {
                    boolean a3 = a(eVar, arrayList, z5, xVar != null, i, i5, a, b2);
                    if (xVar != null) {
                        xVar.jNU = a3;
                    }
                }
                this.jIj.rr(!z4);
                boolean h = h(postData2);
                if (this.jID && !h) {
                    arrayList.remove(postData2);
                    this.jID = false;
                }
                if (eVar.cCW() != null) {
                    eVar.cCW().rd(!z3);
                }
                if (this.fbb != null) {
                    this.eVq = arrayList;
                    this.fbb.setData(this.eVq);
                }
                a(h, z, a, g);
                if (a(postData2, arrayList, z9)) {
                    this.fbb.setData(arrayList);
                }
            }
        }
    }

    private PostData aM(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.o> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.o next = it.next();
            if ((next instanceof PostData) && ((PostData) next).ddJ() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jGo);
        bk cCy = eVar.cCy();
        lVar.jGq = cCy != null ? cCy.aQo() : 0L;
        lVar.isNew = !this.jIC;
        lVar.jGt = this.jHL.cFm();
        lVar.sortType = eVar.jFc;
        lVar.jGs = eVar.cDa();
        lVar.isDynamic = eVar.cCZ();
        lVar.jGu = eVar.jFb;
        com.baidu.tbadk.core.util.v.add(arrayList, i, lVar);
    }

    private com.baidu.adp.widget.ListView.o b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        com.baidu.tieba.pb.data.g gVar;
        if (com.baidu.tbadk.a.d.aMr() && eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.jHL.cDO().cDF()) || !this.jHL.cDO().cFM())) {
            if (!this.jHL.cDE() && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cCU())) {
                gVar = new com.baidu.tieba.pb.data.g(eVar.cCU().get(0));
            } else {
                gVar = new com.baidu.tieba.pb.data.g(eVar.getForum());
            }
            gVar.tid = this.jHL.cDO().cFJ();
            com.baidu.tbadk.core.util.v.add(arrayList, i + 1, gVar);
            return gVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.jHL.cDO() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.jHL.cDO().cFH())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.o> list) {
        if (!z && !z2) {
            if ((this.jIF || this.jIE) && i != -1 && !com.baidu.tbadk.core.util.v.isEmpty(list) && !this.jIG) {
                this.jIN = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fbb.setSelectionFromTop(g.this.fbb.getHeaderViewsCount() + list.size(), 0 - g.this.jIP);
                        g.this.jIG = false;
                    }
                };
                com.baidu.adp.lib.f.e.ld().post(this.jIN);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z) {
        if (postData == null) {
            if (this.jIJ != null && !this.jIE) {
                com.baidu.tbadk.core.util.v.add(arrayList, 0, this.jIJ);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.DU(1);
            com.baidu.tbadk.core.util.v.add(arrayList, 0, postData2);
            return true;
        } else if (z) {
            com.baidu.tbadk.core.util.v.add(arrayList, 0, postData);
            return true;
        } else {
            return false;
        }
    }

    private boolean a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        ArrayList arrayList2 = new ArrayList();
        if (!com.baidu.tbadk.core.util.v.isEmpty(eVar.cCY()) && eVar.cCY().size() > 2) {
            int min = Math.min(eVar.cCY().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.k kVar = eVar.cCY().get(i5);
                if (!z2 && i5 == 0) {
                    kVar.gK(true);
                }
                if (kVar.aQQ() == null) {
                    if (i5 == min - 1) {
                        kVar.gL(true);
                    }
                } else if (i5 == min - 2) {
                    kVar.gL(true);
                } else if (i5 == min - 1) {
                    kVar.gM(true);
                }
                arrayList2.add(kVar);
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
                    com.baidu.tbadk.core.util.v.add(arrayList, i3, arrayList2.get(size));
                }
                return true;
            }
        }
        return false;
    }

    private com.baidu.adp.widget.ListView.o c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        if (i < 0 || eVar == null || !eVar.jFg || eVar.jFh == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = eVar.jFh;
        com.baidu.tbadk.core.util.v.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.e eVar) {
        this.jIj.setData(eVar);
        this.jIj.setFromCDN(this.mIsFromCDN);
        this.jIj.setImageMaxWidth(this.jII);
        this.jIj.re(this.jIB);
        this.jIj.y(this.aIH);
        this.jIj.Q(this.jIK);
        this.jIj.setOnImageClickListener(this.eBN);
        this.jIj.setOnLongClickListener(this.mOnLongClickListener);
        this.jIj.setTbGestureDetector(this.efF);
        this.jIp.setData(eVar);
        this.jIp.setFromCDN(this.mIsFromCDN);
        this.jIp.fl(this.aPJ);
        this.jIp.re(this.jIB);
        this.jIp.y(this.aIH);
        this.jIp.Q(this.jIK);
        this.jIp.setOnImageClickListener(this.eBN);
        this.jIp.setOnLongClickListener(this.mOnLongClickListener);
        this.jIp.setTbGestureDetector(this.efF);
        this.jIk.setOnClickListener(this.aIH);
        this.jIw.setOnClickListener(this.aIH);
        this.jIq.setOnClickListener(this.jIQ);
        if (this.jIs != null && (this.jIs instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.jIs).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.jIx.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(eVar);
                next.setFromCDN(this.mIsFromCDN);
                next.fl(this.aPJ);
                next.setImageMaxWidth(this.jII);
                next.re(this.jIB);
                next.rf(this.jIC);
                next.rg(this.jIH);
                next.y(this.aIH);
                next.Q(this.jIK);
                next.setOnImageClickListener(this.eBN);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.jIn.y(this.aIH);
        this.jIn.a(this.jIL);
        this.jIo.y(this.aIH);
        this.jIn.setData(eVar);
        this.jIm.setData(eVar);
        this.jIo.setData(eVar);
        this.jIt.setData(eVar);
        this.jIu.setData(eVar);
        this.jIy.setPbData(eVar);
        this.jIy.setFrom(this.jHL.jMi);
        this.jIz.setPbData(eVar);
    }

    private x a(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, com.baidu.adp.widget.ListView.o oVar, int i, int i2) {
        x cCD = this.jIA.cCD();
        if (cCD != null) {
            if (oVar != null) {
                if (i2 < 0 && oVar.getType() != AdvertAppInfo.dAm) {
                    i2 = i + 2;
                } else if (oVar.getType() == AdvertAppInfo.dAm) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (cCD instanceof x)) {
                com.baidu.tbadk.core.util.v.add(arrayList, i2, cCD);
                return cCD;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.o b(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        PbModel cDO;
        if (i >= 0 && (cDO = this.jHL.cDO()) != null) {
            String cGz = cDO.cGz();
            if (TextUtils.isEmpty(cGz)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.MB(cGz);
            c(nVar);
            com.baidu.tbadk.core.util.v.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.o c(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, int i) {
        if (this.jIA == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n cFX = this.jHL.cDO().cFX();
        if (cFX == null) {
            cFX = this.jIA.cCQ();
        }
        if (cFX != null) {
            AdvertAppInfo.ILegoAdvert ddy = cFX.ddy();
            if (ddy != null) {
                ddy.setAdvertAppInfo(cFX.pu());
            }
            int aOy = cFX.ddx().aOy();
            if (aOy != 0) {
                a(cFX, aOy);
                if (aOy == 28 || aOy == 31 || cFX.ddx().goods == null) {
                    return null;
                }
                cFX.ddx().goods.goods_style = -1001;
                return null;
            }
            if (this.jIA.getForum() != null) {
                cFX.forumId = this.jIA.getForum().getId();
            }
            if (this.jIA.cCy() != null) {
                cFX.threadId = com.baidu.adp.lib.f.b.toLong(this.jIA.cCy().getId(), 0L);
            }
            if (this.jIA != null && this.jIA.getPage() != null) {
                cFX.pageNumber = this.jIA.getPage().aPr();
            }
            c(cFX);
            if (i >= 0) {
                com.baidu.tbadk.core.util.v.add(arrayList, i, cFX);
                return cFX;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        boolean z;
        int i;
        if (this.jIE || eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cCA()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.aWj() && this.jIC) ? 0 : -1;
        } else if (this.jHL.cDO() == null || !this.jHL.cDO().getIsFromMark()) {
            if (this.jHL.cEE() == null || !this.jHL.cEE().cIF()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.o oVar = arrayList.get(i2);
                    if (oVar instanceof PostData) {
                        PostData postData = (PostData) oVar;
                        if (postData.ddJ() == 1 && postData.lmB == 0) {
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
                return eVar.aWj() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        boolean z;
        int i;
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cCA()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(eVar.cCA(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.o oVar = arrayList.get(i2);
            if (oVar instanceof PostData) {
                PostData postData = (PostData) oVar;
                if (postData.ddJ() == 1 && postData.lmB == 0) {
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

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z) {
        if (eVar == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cCA()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.aWj()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.cCA().get(0) == null || eVar.cCA().get(0).ddJ() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.o> g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cCM() == null || com.baidu.tbadk.core.util.v.isEmpty(eVar.cCM().jGE)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.cCM().jGE;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.lmP = true;
                postData.lmD = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(eVar.cCM().jGF) > 2) {
            com.baidu.adp.widget.ListView.o oVar = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (oVar instanceof PostData) {
                ((PostData) oVar).lmD = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.o oVar2 = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (oVar2 instanceof PostData) {
                ((PostData) oVar2).lmD = true;
            }
        }
        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jGp);
        lVar.jGr = eVar.cCM().forum_top_list;
        arrayList.add(0, lVar);
        return arrayList;
    }

    private void cgr() {
        if (this.jHL != null && !cgs()) {
            this.jHL.registerListener(this.hFW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgs() {
        if (this.jHL == null) {
            return false;
        }
        this.hFU = new ArrayList();
        ArrayList<BdUniqueId> dda = com.baidu.tieba.tbadkCore.t.dda();
        if (dda == null || dda.size() <= 0) {
            return false;
        }
        int size = dda.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cuO().a(this.jHL.getPageContext(), dda.get(i), 2);
            if (a != null) {
                this.aSj.add(a);
                this.hFU.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.hFU)) {
            this.fbb.addAdapters(this.hFU);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.fbb.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z) {
        if (eVar == null || eVar.cCA() == null || eVar.cCB() == null || eVar.cCA().size() == 0 || eVar.cCy() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cCB().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cCA().get(0) == null || eVar.cCA().get(0).ddJ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aPr() != eVar.getPage().aPo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.o> arrayList, boolean z) {
        if (eVar == null || eVar.cCA() == null || eVar.cCC() == null || eVar.cCA().size() == 0 || eVar.cCy() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cCC().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cCA().get(0) == null || eVar.cCA().get(0).ddJ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aPr() != eVar.getPage().aPo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.o getItem(int i) {
        return this.fbb.getItem(i);
    }

    public ArrayList<PostData> cEk() {
        return this.postList;
    }

    public BdUniqueId Ab(int i) {
        if (this.fbb.getItem(i) != null) {
            return this.fbb.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.jIO = cEl();
        if (this.fbb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }

    public int cEl() {
        if (this.fbb != null && this.fbb.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fbb.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.o oVar = this.fbb.getData().get(i2);
                if (oVar == null || oVar.getType() != com.baidu.tieba.pb.data.l.jGo) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cEm() {
        return this.jIO;
    }

    private void cEn() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.jIA != null) {
            ArrayList<PostData> cCA = this.jIA.cCA();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cCP = this.jIA.cCP();
            if (cCP != null) {
                int size = cCP.size();
                if (cCA != null && cCA.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it = cCP.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cCP.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                        if (next2 != null) {
                            next2.hFS = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cCP.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                        if (next3.ddx() != null) {
                            int aOy = next3.ddx().aOy();
                            if (aOy != 0) {
                                a(next3, aOy);
                                if (aOy != 28 && aOy != 31) {
                                    if (next3.ddx().goods != null) {
                                        next3.ddx().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.x.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.ddx().apk_name)) {
                                int position = next3.getPosition();
                                if (position >= 1 && position < 30) {
                                    sparseArray.put(position, next3);
                                } else {
                                    b(next3, 33);
                                }
                            } else {
                                b(next3, 3);
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(sparseArray.keyAt(i));
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
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.g.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.jIA.getForum() != null) {
                            nVar4.forumId = this.jIA.getForum().getId();
                        }
                        if (this.jIA.cCy() != null) {
                            nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.jIA.cCy().getId(), 0L);
                        }
                        if (this.jIA != null && this.jIA.getPage() != null) {
                            nVar4.pageNumber = this.jIA.getPage().aPr();
                        }
                        c(nVar4);
                        int position2 = nVar4.getPosition();
                        if (position2 + i3 >= cCA.size()) {
                            a(nVar4, 2);
                            return;
                        }
                        if (!this.jIC) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(nVar4, 23);
                            return;
                        }
                        cCA.add(position2, nVar4);
                        TiebaStatic.eventStat(this.jHL.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.ddx().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.Cu(i);
        com.baidu.tieba.recapp.report.d.cVA().a(c);
        if (nVar != null && nVar.ddx() != null) {
            nVar.ddx().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.ddx() != null && nVar.ddx().goods != null && nVar.ddx().goods.goods_style != 1001 && nVar.ddx().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.jIA != null && nVar.ddx() != null) {
            nVar.ddx().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.jIA.getPage() != null) {
                nVar.ddx().advertAppContext.pn = this.jIA.getPage().aPr();
            }
            nVar.ddx().advertAppContext.page = nVar.ddA();
            if (this.jIA.getForum() != null && (forum = this.jIA.getForum()) != null) {
                nVar.ddx().advertAppContext.fid = forum.getId();
                nVar.ddx().advertAppContext.dzZ = forum.getFirst_class();
                nVar.ddx().advertAppContext.dAa = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.ddx().advertAppContext.dAb = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.ddx().advertAppContext.extensionInfo = nVar.ddx().ext_info;
            nVar.ddx().advertAppContext.WZ = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.jIj.setFromCDN(z);
        if (this.jIs != null && (this.jIs instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.jIs).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.jIx.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cEo() {
        return this.jIB;
    }

    public void re(boolean z) {
        this.jIB = z;
    }

    public void rf(boolean z) {
        this.jIC = z;
    }

    public void rg(boolean z) {
        this.jIH = z;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.jIK = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eBN = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.efF = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void D(View.OnClickListener onClickListener) {
        this.aIH = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.jIL = aVar;
    }

    public void Ac(int i) {
        switch (i) {
            case 1:
                if (this.jIj != null) {
                    this.jIj.pause();
                    return;
                }
                return;
            case 2:
                if (this.jIj != null) {
                    this.jIj.resume();
                    return;
                }
                return;
            case 3:
                if (this.jIj != null) {
                    this.jIj.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dY(List<com.baidu.adp.widget.ListView.o> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.aRI())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.vt(postData.aRI());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jIN);
        if (this.jIn != null) {
            this.jIn.onDestroy();
        }
        if (this.jIo != null) {
            this.jIo.onDestroy();
        }
        if (this.jIk != null) {
            this.jIk.onDestroy();
        }
        if (this.jIm != null) {
            this.jIm.onDestroy();
        }
    }

    public void rk(boolean z) {
        this.jIE = z;
    }

    public void rl(boolean z) {
        this.jIF = z;
    }

    public void rm(boolean z) {
        this.jID = z;
    }

    public void rn(boolean z) {
        this.jIG = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cEp() {
        return this.jIk;
    }

    public ArrayList<com.baidu.adp.widget.ListView.o> getDataList() {
        return this.eVq;
    }

    public View cEq() {
        if (this.jIj == null || this.jIj.cEt() == null) {
            return null;
        }
        if (this.jIj.cEt().jKM != null && this.jIj.cEt().jKM.isShown()) {
            return this.jIj.cEt().jKM;
        }
        return this.jIj.cEt().jKL;
    }

    public r cEr() {
        if (this.jIj == null || this.jIj.cEt() == null) {
            return null;
        }
        return this.jIj.cEt();
    }
}
