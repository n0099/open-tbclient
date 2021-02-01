package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class g {
    private ArrayList<com.baidu.adp.widget.ListView.n> gpY;
    private BdTypeListView gzb;
    private List<com.baidu.adp.widget.ListView.a> jDM;
    private com.baidu.adp.widget.ListView.a kkM;
    private PbFragment lMX;
    private PbFirstFloorCommentAndPraiseAdapter lNA;
    private PbFirstFloorEnterForumAdapter lNB;
    private PbFirstFloorItemAdapter lNC;
    private com.baidu.tieba.pb.pb.main.adapter.a lND;
    private ak lNE;
    private ak lNF;
    private k lNG;
    private com.baidu.tieba.pb.video.a lNH;
    private com.baidu.tieba.card.divider.a lNI;
    private com.baidu.adp.widget.ListView.a lNJ;
    private com.baidu.adp.widget.ListView.a lNK;
    private com.baidu.adp.widget.ListView.a lNL;
    private ah lNM;
    private ai lNN;
    private ag lNO;
    private PbReplyLoadMoreAdapter lNP;
    private h lNR;
    private u lNS;
    private com.baidu.tieba.pb.data.f lNT;
    private boolean lNY;
    private boolean lNZ;
    private p lNz;
    private int lOb;
    private Runnable lOg;
    private int lOi;
    private cb lOk;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.adapter.a> lNQ = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lNU = true;
    private boolean lNV = true;
    private boolean lNW = false;
    private boolean lNX = false;
    private boolean lOa = false;
    private String bkB = null;
    private PostData lOc = null;
    private View.OnClickListener lOd = null;
    private View.OnClickListener bbI = null;
    private TbRichTextView.i fUw = null;
    private com.baidu.tieba.pb.a.c fvK = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lOe = null;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lOf = new ArrayList();
    private int lOh = -1;
    private int lOj = -1;
    private final CustomMessageListener lOl = new CustomMessageListener(2921523) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.n)) {
                com.baidu.tieba.tbadkCore.data.n nVar = (com.baidu.tieba.tbadkCore.data.n) customResponsedMessage.getData();
                if (g.this.lOk != null && g.this.lOk.eUi == nVar) {
                    g.this.lOk.eUi.aR(null);
                    g.this.gzb.setData(g.this.gpY);
                    g.this.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener jpb = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dMZ = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dMZ();
                Iterator it = dMZ.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(g.this.lMX);
                        if (aVar instanceof com.baidu.tieba.pb.pb.adapter.a) {
                            g.this.lNQ.add((com.baidu.tieba.pb.pb.adapter.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dMZ);
                g.this.lOf.clear();
                g.this.lOf.addAll(arrayList);
                if (g.this.gzb != null) {
                    g.this.gzb.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener fsV = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.3
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.lNT != null && !com.baidu.adp.base.j.I(g.this.lMX.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener lOm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lMX != null && g.this.lNT != null && g.this.lNT.dln() != null) {
                g.this.lMX.dnk().dqt().dmm();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12040"));
            }
        }
    };
    private CustomMessageListener jDO = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.jDM)) {
                g.this.cRv();
                g.this.a(g.this.lNT, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lOb = 0;
        this.width = -1;
        this.lOi = 0;
        this.lOb = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lOb;
        this.lMX = pbFragment;
        this.gzb = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.fsV);
        this.lOi = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lMX.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lNz = new p(pbFragment, PostData.nwx);
        this.lNz.a((TbRichTextView.c) pbFragment);
        this.lNA = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, com.baidu.tieba.pb.data.p.lLx);
        this.lNB = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lNC = new PbFirstFloorItemAdapter(pbFragment.getContext(), com.baidu.tieba.pb.data.i.TYPE);
        this.lND = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lJL);
        this.lNE = new ak(pbFragment, com.baidu.tieba.pb.data.o.lLq);
        this.lNF = new ak(pbFragment, com.baidu.tieba.pb.data.o.lLr);
        this.lNG = new k(pbFragment, PostData.nwy);
        this.lNG.a((TbRichTextView.c) pbFragment);
        this.kkM = com.baidu.tieba.recapp.r.dDm().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eLf);
        this.lNJ = com.baidu.tieba.recapp.r.dDm().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eLj);
        this.lNK = com.baidu.tieba.h.b.cNm().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eLk);
        this.lNL = com.baidu.tieba.h.b.cNm().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eLl);
        this.lNO = new ag(pbFragment, com.baidu.tieba.pb.data.m.Yl);
        this.lNM = new ah(pbFragment, af.lXe);
        this.lNN = new ai(pbFragment, bd.eOI);
        this.lNP = new PbReplyLoadMoreAdapter(pbFragment, PostData.nwC);
        this.lNH = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.mix);
        this.lNI = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lNR = new h(pbFragment, com.baidu.tbadk.core.data.p.eMv);
        this.lNS = new u(pbFragment, pbFragment.getUniqueId());
        this.bns.add(this.lNz);
        this.bns.add(this.lNA);
        this.bns.add(this.lNB);
        this.bns.add(this.lNC);
        this.bns.add(this.lND);
        this.bns.add(this.lNG);
        this.bns.add(this.lNE);
        this.bns.add(this.lNF);
        this.bns.add(this.kkM);
        this.bns.add(this.lNJ);
        this.bns.add(this.lNK);
        this.bns.add(this.lNL);
        this.bns.add(this.lNO);
        this.bns.add(this.lNM);
        this.bns.add(this.lNN);
        this.bns.add(this.lNH);
        this.bns.add(this.lNP);
        this.bns.add(this.lNI);
        this.bns.add(this.lNR);
        this.bns.add(this.lNS);
        this.jpb.setPriority(1);
        this.jpb.setSelfListener(true);
        pbFragment.registerListener(this.jpb);
        pbFragment.registerListener(this.lOl);
        cRu();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.bns);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        boolean z5;
        com.baidu.adp.widget.ListView.n nVar;
        PostData postData;
        if (fVar != null) {
            this.lNT = fVar;
            dmR();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lNT != null && this.lNT.dlb() != null && this.lNT.dlb().size() > 0) {
                this.postList.addAll(this.lNT.dlb());
            }
            if (fVar.dkZ() != null && fVar.dkZ().bnQ() != null) {
                this.bkB = fVar.dkZ().bnQ().getUserId();
            }
            if (this.lNz != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>(fVar.dlb());
                PostData aW = aW(arrayList);
                boolean z6 = aW != null;
                if (aW != null) {
                    this.lOc = aW;
                }
                boolean z7 = false;
                if (!this.lNV && aW != null) {
                    arrayList.remove(aW);
                    z7 = true;
                    z6 = true;
                    if (fVar.dlz() && aW.dNz() != null) {
                        aW.c(null);
                    }
                }
                if (!z6 && fVar.dli() != null) {
                    aW = fVar.dli();
                    z7 = true;
                    z6 = true;
                    if (!this.lNV && fVar.dlz() && aW.dNz() != null) {
                        aW.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aW;
                fl(arrayList);
                if (this.lMX.dnJ()) {
                    if (fVar.dlb().size() > 0 && (postData = fVar.dlb().get(0)) != null && postData.dNx() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b2 = b(this.lNT, arrayList, this.lNV);
                    if (b2 >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b2, this.lNT.dlc());
                    }
                }
                int c = c(this.lNT, arrayList, this.lNV);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.lNT.dld());
                }
                com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
                boolean z9 = false;
                int b3 = b(fVar, arrayList);
                if (b3 >= 0) {
                    z9 = true;
                    a(fVar, arrayList, b3);
                }
                int a2 = a(fVar, arrayList);
                List<com.baidu.adp.widget.ListView.n> g = g(fVar);
                if (com.baidu.tbadk.core.util.y.isEmpty(g) || a2 < 0) {
                    z2 = z9;
                } else {
                    com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, a2);
                    if (nVar2 instanceof PostData) {
                        ((PostData) nVar2).nxj = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i2 = -1;
                if (z6) {
                    i2 = a(fVar, arrayList, this.lNV);
                }
                if (i2 >= 0 && fVar.dly() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i2, fVar.dly());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.nxi = true;
                    }
                    z3 = false;
                    z4 = z2;
                }
                boolean z10 = a(fVar, postData2, arrayList, i2) != null;
                int i3 = z10 ? i2 + 1 : i2;
                if (!z10 && b(fVar, arrayList, i3) != null) {
                    i3++;
                }
                int i4 = c(fVar, arrayList, i3) != null ? i3 + 1 : i3;
                boolean z11 = false;
                v vVar = null;
                int i5 = -1;
                if (z6) {
                    com.baidu.adp.widget.ListView.n e = e(arrayList, i4);
                    boolean z12 = e != null;
                    if (z12) {
                        nVar = e;
                        z11 = z12;
                    } else {
                        if (i4 >= 0) {
                            i5 = i4 + 1;
                        } else if (a2 >= 0) {
                            i5 = a2;
                        } else if (b3 >= 0) {
                            i5 = b3;
                        }
                        nVar = f(arrayList, i5);
                        z11 = nVar != null;
                    }
                    boolean z13 = TbadkApplication.getCurrentAccountInfo() == null || TbadkApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
                    if (z13) {
                        this.lOj = i5;
                        if (d(arrayList, i5) != null) {
                            this.lOj = -1;
                            i4++;
                        }
                    }
                    if (!com.baidu.tbadk.a.d.biU() || !z13) {
                        v a3 = a(arrayList, nVar, i4, i5);
                        if (a3 == null) {
                            i = i5;
                            vVar = a3;
                            z5 = z11;
                        } else if (!z11) {
                            i = i5;
                            vVar = a3;
                            z5 = true;
                        } else if (i5 > 0) {
                            i = i5 + 1;
                            vVar = a3;
                            z5 = z11;
                        } else {
                            i4++;
                            i = i5;
                            vVar = a3;
                            z5 = z11;
                        }
                        if (z6) {
                            boolean a4 = a(fVar, arrayList, z5, vVar != null, i, i4, a2, b3);
                            if (vVar != null) {
                                vVar.lTV = a4;
                            }
                        }
                        this.lNz.uX(z4);
                        boolean h = h(postData2);
                        if (this.lNW && !h) {
                            arrayList.remove(postData2);
                            this.lNW = false;
                        }
                        if (fVar.dly() != null) {
                            fVar.dly().uH(!z3);
                        }
                        if (this.gzb != null) {
                            this.gpY = arrayList;
                            this.gzb.setData(this.gpY);
                        }
                        a(h, z, a2, g);
                        if (!a(postData2, arrayList, z8)) {
                            this.gzb.setData(arrayList);
                            return;
                        }
                        return;
                    }
                }
                i = i5;
                z5 = z11;
                if (z6) {
                }
                this.lNz.uX(z4);
                boolean h2 = h(postData2);
                if (this.lNW) {
                    arrayList.remove(postData2);
                    this.lNW = false;
                }
                if (fVar.dly() != null) {
                }
                if (this.gzb != null) {
                }
                a(h2, z, a2, g);
                if (!a(postData2, arrayList, z8)) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.n d(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        List<cb> Lq;
        if (com.baidu.tbadk.a.d.biU() && i > 0) {
            if (this.lOk == null && (Lq = com.baidu.tieba.h.a.cNj().Lq("6051001641-1251655838")) != null && Lq.size() > 0) {
                this.lOk = Lq.get(0);
            }
            if (this.lOk != null && this.lOk.eUi != null && this.lOk.eUi.dNh() != null) {
                com.baidu.tbadk.core.util.y.add(arrayList, i, this.lOk);
            }
        }
        return this.lOk;
    }

    public void dmN() {
        if (this.lOj > 0 && d(this.gpY, this.lOj) != null) {
            this.lOj = -1;
            this.gzb.setData(this.gpY);
            notifyDataSetChanged();
        }
    }

    private PostData aW(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dNx() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLq);
        cb dkZ = fVar.dkZ();
        oVar.lLs = dkZ != null ? dkZ.bnH() : 0L;
        oVar.isNew = !this.lNV;
        oVar.lLv = this.lMX.dnT();
        oVar.sortType = fVar.lJZ;
        oVar.lLu = fVar.dlD();
        oVar.isDynamic = fVar.dlC();
        oVar.lLw = fVar.lJY;
        com.baidu.tbadk.core.util.y.add(arrayList, i, oVar);
    }

    private com.baidu.adp.widget.ListView.n b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lMX.dmq().dmj()) || !this.lMX.dmq().dow())) {
            if (!this.lMX.dmi() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlw())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.dlw().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lMX.dmq().dot();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n a(com.baidu.tieba.pb.data.f fVar, PostData postData, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.i iVar = null;
        if (fVar.getForum() == null || StringUtils.isNull(fVar.getForum().getName()) || !TextUtils.equals(fVar.getForum().getName(), this.lMX.dmq().dmj()) || !this.lMX.dmq().dow()) {
            if (postData != null) {
                if (postData.nxy != null) {
                    iVar = new com.baidu.tieba.pb.data.i(postData.nxy);
                }
            } else if (this.lOc != null && this.lOc.nxy != null) {
                iVar = new com.baidu.tieba.pb.data.i(this.lOc.nxy);
            }
            if (iVar != null) {
                iVar.tid = this.lMX.dmq().dot();
                com.baidu.tbadk.core.util.y.add(arrayList, i + 1, iVar);
            }
        }
        return iVar;
    }

    private boolean h(PostData postData) {
        return (this.lMX.dmq() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lMX.dmq().dor())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.n> list) {
        if (!z && !z2) {
            if ((this.lNY || this.lNX) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.lNZ) {
                this.lOg = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gzb.setSelectionFromTop(g.this.gzb.getHeaderViewsCount() + list.size(), 0 - g.this.lOi);
                        g.this.lNZ = false;
                    }
                };
                com.baidu.adp.lib.f.e.mA().post(this.lOg);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (postData == null) {
            if (this.lOc != null && !this.lNX) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.lOc);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.JE(1);
            com.baidu.tbadk.core.util.y.add(arrayList, 0, postData2);
            return true;
        } else if (z) {
            com.baidu.tbadk.core.util.y.add(arrayList, 0, postData);
            return true;
        } else {
            return false;
        }
    }

    private boolean a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        ArrayList arrayList2 = new ArrayList();
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlB()) && fVar.dlB().size() > 2) {
            int min = Math.min(fVar.dlB().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.p pVar = fVar.dlB().get(i5);
                if (!z2 && i5 == 0) {
                    pVar.jq(true);
                }
                if (pVar.boh() == null) {
                    if (i5 == min - 1) {
                        pVar.jr(true);
                    }
                } else if (i5 == min - 2) {
                    pVar.jr(true);
                } else if (i5 == min - 1) {
                    pVar.js(true);
                }
                arrayList2.add(pVar);
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

    private com.baidu.adp.widget.ListView.n c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        if (i < 0 || fVar == null || !fVar.lKd || fVar.lKe == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lKe;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lNz.setData(fVar);
        this.lNz.setFromCDN(this.mIsFromCDN);
        this.lNz.setImageMaxWidth(this.lOb);
        this.lNz.uJ(this.lNU);
        this.lNz.C(this.bbI);
        this.lNz.U(this.lOd);
        this.lNz.setOnImageClickListener(this.fUw);
        this.lNz.setOnLongClickListener(this.mOnLongClickListener);
        this.lNz.setTbGestureDetector(this.fvK);
        this.lNG.setData(fVar);
        this.lNG.setFromCDN(this.mIsFromCDN);
        this.lNG.gW(this.bkB);
        this.lNG.uJ(this.lNU);
        this.lNG.C(this.bbI);
        this.lNG.U(this.lOd);
        this.lNG.setOnImageClickListener(this.fUw);
        this.lNG.setOnLongClickListener(this.mOnLongClickListener);
        this.lNG.setTbGestureDetector(this.fvK);
        this.lNA.setOnClickListener(this.bbI);
        this.lNP.setOnClickListener(this.bbI);
        this.lNH.setOnClickListener(this.lOm);
        if (this.lNJ != null && (this.lNJ instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lNJ).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lNQ.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.adapter.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.gW(this.bkB);
                next.setImageMaxWidth(this.lOb);
                next.uJ(this.lNU);
                next.uK(this.lNV);
                next.uL(this.lOa);
                next.C(this.bbI);
                next.U(this.lOd);
                next.setOnImageClickListener(this.fUw);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lNE.C(this.bbI);
        this.lNE.a(this.lOe);
        this.lNF.C(this.bbI);
        this.lNE.setData(fVar);
        this.lND.setData(fVar);
        this.lNF.setData(fVar);
        this.lNM.setData(fVar);
        this.lNN.setData(fVar);
        this.lNR.setPbData(fVar);
        this.lNR.setFrom(this.lMX.lSf);
        this.lNS.setPbData(fVar);
    }

    private v a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.adp.widget.ListView.n nVar, int i, int i2) {
        v dle = this.lNT.dle();
        if (dle != null) {
            if (nVar != null) {
                if (i2 < 0 && nVar.getType() != AdvertAppInfo.eLj) {
                    i2 = i + 2;
                } else if (nVar.getType() == AdvertAppInfo.eLj) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dle instanceof v)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, dle);
                return dle;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n e(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        PbModel dmq;
        if (i >= 0 && (dmq = this.lMX.dmq()) != null) {
            String dpk = dmq.dpk();
            if (TextUtils.isEmpty(dpk)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
            oVar.Td(dpk);
            c(oVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, oVar);
            return oVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n f(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        if (this.lNT == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.o doI = this.lMX.dmq().doI();
        if (doI == null) {
            doI = this.lNT.dlr();
        }
        if (doI != null) {
            AdvertAppInfo.ILegoAdvert dNm = doI.dNm();
            if (dNm != null) {
                dNm.setAdvertAppInfo(doI.qS());
            }
            int blD = doI.dNl().blD();
            if (blD != 0) {
                com.baidu.tieba.recapp.report.d.a(doI, blD);
                if (blD == 28 || blD == 31 || doI.dNl().goods == null) {
                    return null;
                }
                doI.dNl().goods.goods_style = -1001;
                return null;
            }
            if (this.lNT.getForum() != null) {
                doI.forumId = this.lNT.getForum().getId();
            }
            if (this.lNT.dkZ() != null) {
                doI.threadId = com.baidu.adp.lib.f.b.toLong(this.lNT.dkZ().getId(), 0L);
            }
            if (this.lNT != null && this.lNT.getPage() != null) {
                doI.pageNumber = this.lNT.getPage().bmD();
            }
            c(doI);
            if (i >= 0) {
                com.baidu.tieba.lego.card.c.a.a(arrayList, doI, i);
                return doI;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (this.lNX || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dlb()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dlz() && this.lNV) ? 0 : -1;
        } else if (this.lMX.dmq() == null || !this.lMX.dmq().getIsFromMark()) {
            if (this.lMX.dnk() == null || !this.lMX.dnk().drx()) {
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.n nVar = arrayList.get(i);
                    if (nVar instanceof PostData) {
                        PostData postData = (PostData) nVar;
                        if (postData.dNx() == 1 && postData.nxf == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
                if (z) {
                    return i + 1;
                }
                return fVar.dlz() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dlb()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dlb(), 0)) == null) {
            return 0;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                i = 0;
                break;
            }
            com.baidu.adp.widget.ListView.n nVar = arrayList.get(i);
            if (nVar instanceof PostData) {
                PostData postData = (PostData) nVar;
                if (postData.dNx() == 1 && postData.nxf == 0) {
                    z = true;
                    break;
                }
            }
            i++;
        }
        if (z) {
            return i + 1;
        }
        return 0;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dlb()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dlz()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dlb().get(0) == null || fVar.dlb().get(0).dNx() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.n> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dln() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dln().lLH)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dln().lLH;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.nxs = true;
                postData.nxh = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.dln().lLI) > 2) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (nVar instanceof PostData) {
                ((PostData) nVar).nxh = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).nxh = true;
            }
        }
        com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLr);
        oVar.lLt = fVar.dln().forum_top_list;
        arrayList.add(0, oVar);
        return arrayList;
    }

    private void cRu() {
        if (this.lMX != null && !cRv()) {
            this.lMX.registerListener(this.jDO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRv() {
        if (this.lMX == null) {
            return false;
        }
        this.jDM = new ArrayList();
        ArrayList<BdUniqueId> dML = com.baidu.tieba.tbadkCore.v.dML();
        if (dML == null || dML.size() <= 0) {
            return false;
        }
        int size = dML.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.dcT().a(this.lMX.getPageContext(), dML.get(i), 2);
            if (a2 != null) {
                this.bns.add(a2);
                this.jDM.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jDM)) {
            this.gzb.addAdapters(this.jDM);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.gzb.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.dlb() == null || fVar.dlc() == null || fVar.dlb().size() == 0 || fVar.dkZ() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dlc().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dlb().get(0) == null || fVar.dlb().get(0).dNx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bmD() != fVar.getPage().bmA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.dlb() == null || fVar.dld() == null || fVar.dlb().size() == 0 || fVar.dkZ() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dld().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dlb().get(0) == null || fVar.dlb().get(0).dNx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bmD() != fVar.getPage().bmA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.n getItem(int i) {
        return this.gzb.getItem(i);
    }

    public ArrayList<PostData> dmO() {
        return this.postList;
    }

    public BdUniqueId FA(int i) {
        if (this.gzb.getItem(i) != null) {
            return this.gzb.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lOh = dmP();
        if (this.gzb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }

    public int dmP() {
        if (this.gzb != null && this.gzb.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gzb.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n nVar = this.gzb.getData().get(i2);
                if (nVar == null || nVar.getType() != com.baidu.tieba.pb.data.o.lLq) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int dmQ() {
        return this.lOh;
    }

    private void dmR() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lNT != null && !this.lNT.lKN && this.lNT.aam != 2) {
            ArrayList<PostData> dlb = this.lNT.dlb();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dlq = this.lNT.dlq();
            if (!com.baidu.tieba.lego.card.c.a.isEmpty(dlb) && !com.baidu.tieba.lego.card.c.a.isEmpty(dlq)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dlq.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dlq.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jDK = sb.toString();
                        next2.position = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dlq.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dNl() != null) {
                        int blD = next3.dNl().blD();
                        if (blD != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, blD);
                            if (blD != 28 && blD != 31) {
                                if (next3.dNl().goods != null) {
                                    next3.dNl().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dlq.clear();
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.valueAt(i);
                    if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.getAdId(), oVar3)) != null) {
                        com.baidu.tieba.recapp.report.d.a(oVar2, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && (oVar = (com.baidu.tieba.tbadkCore.data.o) entry.getValue()) != null) {
                        sparseArray.put(oVar.getPosition(), oVar);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    com.baidu.tieba.lego.card.c.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < com.baidu.tieba.lego.card.c.a.eL(arrayList); i3++) {
                    com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) com.baidu.tieba.lego.card.c.a.l(arrayList, i3)).intValue());
                    if (this.lNT.getForum() != null) {
                        oVar4.forumId = this.lNT.getForum().getId();
                    }
                    if (this.lNT.dkZ() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lNT.dkZ().getId(), 0L);
                    }
                    if (this.lNT != null && this.lNT.getPage() != null) {
                        oVar4.pageNumber = this.lNT.getPage().bmD();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lNT.lKM;
                    if (position >= com.baidu.tieba.lego.card.c.a.eL(dlb)) {
                        oVar4.position = position;
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, position, com.baidu.tieba.lego.card.c.a.eL(dlb));
                        return;
                    }
                    if (!this.lNV) {
                        position--;
                        oVar4.position = position;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.c.a.a(dlb, oVar4, position);
                        TiebaStatic.eventStat(this.lMX.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dNl().apk_name);
                    }
                }
            }
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lNT != null && oVar.dNl() != null) {
            oVar.dNl().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lNT.getPage() != null) {
                oVar.dNl().advertAppContext.pn = this.lNT.getPage().bmD();
            }
            oVar.dNl().advertAppContext.page = oVar.dNo();
            if (this.lNT.getForum() != null && (forum = this.lNT.getForum()) != null) {
                oVar.dNl().advertAppContext.fid = forum.getId();
                oVar.dNl().advertAppContext.eKW = forum.getFirst_class();
                oVar.dNl().advertAppContext.eKX = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dNl().advertAppContext.eKY = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dNl().advertAppContext.extensionInfo = oVar.dNl().ext_info;
            oVar.dNl().advertAppContext.aas = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lNz.setFromCDN(z);
        if (this.lNJ != null && (this.lNJ instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lNJ).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lNQ.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean dmS() {
        return this.lNU;
    }

    public void uJ(boolean z) {
        this.lNU = z;
    }

    public void uK(boolean z) {
        this.lNV = z;
    }

    public void uL(boolean z) {
        this.lOa = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOd = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fUw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fvK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lOe = aVar;
    }

    public void FB(int i) {
        switch (i) {
            case 1:
                if (this.lNz != null) {
                    this.lNz.pause();
                }
                if (this.lNJ instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lNJ).onPause();
                }
                if (this.lNK instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lNK).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lNz != null) {
                    this.lNz.resume();
                }
                if (this.lNJ instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lNJ).onResume();
                }
                if (this.lNK instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lNK).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lNz != null) {
                    this.lNz.release();
                }
                if (this.lNJ instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lNJ).onDestroy();
                }
                if (this.lNK instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lNK).onDestroy();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void fl(List<com.baidu.adp.widget.ListView.n> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.bpb())) {
                        com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
                        anVar.zV(postData.bpb());
                        list.set(i, anVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lOg);
        if (this.lNE != null) {
            this.lNE.onDestroy();
        }
        if (this.lNF != null) {
            this.lNF.onDestroy();
        }
        if (this.lNA != null) {
            this.lNA.onDestroy();
        }
        if (this.lND != null) {
            this.lND.onDestroy();
        }
    }

    public void uP(boolean z) {
        this.lNX = z;
    }

    public void uQ(boolean z) {
        this.lNY = z;
    }

    public void uR(boolean z) {
        this.lNW = z;
    }

    public void uS(boolean z) {
        this.lNZ = z;
    }

    public PbFirstFloorCommentAndPraiseAdapter dmT() {
        return this.lNA;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.gpY;
    }

    public View dmU() {
        if (this.lNz == null || this.lNz.dmZ() == null) {
            return null;
        }
        if (this.lNz.dmZ().lQB != null && this.lNz.dmZ().lQB.isShown()) {
            return this.lNz.dmZ().lQB;
        }
        return this.lNz.dmZ().lQA;
    }

    public PbFirstFloorViewHolder dmV() {
        if (this.lNz == null || this.lNz.dmZ() == null) {
            return null;
        }
        return this.lNz.dmZ();
    }

    public void uT(boolean z) {
        if (this.lNG != null) {
            this.lNG.uT(z);
        }
    }
}
