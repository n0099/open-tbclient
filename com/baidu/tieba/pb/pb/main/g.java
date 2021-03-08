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
    private BdTypeListView gAY;
    private ArrayList<com.baidu.adp.widget.ListView.n> grV;
    private List<com.baidu.adp.widget.ListView.a> jFJ;
    private com.baidu.adp.widget.ListView.a knc;
    private p lPQ;
    private PbFirstFloorCommentAndPraiseAdapter lPR;
    private PbFirstFloorEnterForumAdapter lPS;
    private PbFirstFloorItemAdapter lPT;
    private com.baidu.tieba.pb.pb.main.adapter.a lPU;
    private ak lPV;
    private ak lPW;
    private k lPX;
    private com.baidu.tieba.pb.video.a lPY;
    private com.baidu.tieba.card.divider.a lPZ;
    private PbFragment lPo;
    private cb lQB;
    private com.baidu.adp.widget.ListView.a lQa;
    private com.baidu.adp.widget.ListView.a lQb;
    private com.baidu.adp.widget.ListView.a lQc;
    private ah lQd;
    private ai lQe;
    private ag lQf;
    private PbReplyLoadMoreAdapter lQg;
    private h lQi;
    private u lQj;
    private com.baidu.tieba.pb.data.f lQk;
    private boolean lQp;
    private boolean lQq;
    private int lQs;
    private Runnable lQx;
    private int lQz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.adapter.a> lQh = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lQl = true;
    private boolean lQm = true;
    private boolean lQn = false;
    private boolean lQo = false;
    private boolean lQr = false;
    private String bmb = null;
    private PostData lQt = null;
    private View.OnClickListener lQu = null;
    private View.OnClickListener bdi = null;
    private TbRichTextView.i fVW = null;
    private com.baidu.tieba.pb.a.c fxj = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lQv = null;
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lQw = new ArrayList();
    private int lQy = -1;
    private int lQA = -1;
    private final CustomMessageListener lQC = new CustomMessageListener(2921523) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.n)) {
                com.baidu.tieba.tbadkCore.data.n nVar = (com.baidu.tieba.tbadkCore.data.n) customResponsedMessage.getData();
                if (g.this.lQB != null && g.this.lQB.eVH == nVar) {
                    g.this.lQB.eVH.yp(true);
                    g.this.gAY.setData(g.this.grV);
                    g.this.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener jqY = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dNp = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dNp();
                Iterator it = dNp.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(g.this.lPo);
                        if (aVar instanceof com.baidu.tieba.pb.pb.adapter.a) {
                            g.this.lQh.add((com.baidu.tieba.pb.pb.adapter.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dNp);
                g.this.lQw.clear();
                g.this.lQw.addAll(arrayList);
                if (g.this.gAY != null) {
                    g.this.gAY.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener fuv = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.3
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.lQk != null && !com.baidu.adp.base.j.H(g.this.lPo.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener lQD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lPo != null && g.this.lQk != null && g.this.lQk.dlD() != null) {
                g.this.lPo.dnB().dqJ().dmC();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12040"));
            }
        }
    };
    private CustomMessageListener jFL = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.jFJ)) {
                g.this.cRJ();
                g.this.a(g.this.lQk, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lQs = 0;
        this.width = -1;
        this.lQz = 0;
        this.lQs = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lQs;
        this.lPo = pbFragment;
        this.gAY = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.fuv);
        this.lQz = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lPo.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lPQ = new p(pbFragment, PostData.nzc);
        this.lPQ.a((TbRichTextView.c) pbFragment);
        this.lPR = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, com.baidu.tieba.pb.data.p.lNO);
        this.lPS = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lPT = new PbFirstFloorItemAdapter(pbFragment.getContext(), com.baidu.tieba.pb.data.i.TYPE);
        this.lPU = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lMb);
        this.lPV = new ak(pbFragment, com.baidu.tieba.pb.data.o.lNH);
        this.lPW = new ak(pbFragment, com.baidu.tieba.pb.data.o.lNI);
        this.lPX = new k(pbFragment, PostData.nzd);
        this.lPX.a((TbRichTextView.c) pbFragment);
        this.knc = com.baidu.tieba.recapp.s.dDB().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eMG);
        this.lQa = com.baidu.tieba.recapp.s.dDB().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eMK);
        this.lQb = com.baidu.tieba.h.b.cNB().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eML);
        this.lQc = com.baidu.tieba.h.b.cNB().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eMM);
        this.lQf = new ag(pbFragment, com.baidu.tieba.pb.data.m.ZE);
        this.lQd = new ah(pbFragment, af.lZv);
        this.lQe = new ai(pbFragment, bd.eQj);
        this.lQg = new PbReplyLoadMoreAdapter(pbFragment, PostData.nzh);
        this.lPY = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.mkO);
        this.lPZ = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lQi = new h(pbFragment, com.baidu.tbadk.core.data.p.eNW);
        this.lQj = new u(pbFragment, pbFragment.getUniqueId());
        this.boS.add(this.lPQ);
        this.boS.add(this.lPR);
        this.boS.add(this.lPS);
        this.boS.add(this.lPT);
        this.boS.add(this.lPU);
        this.boS.add(this.lPX);
        this.boS.add(this.lPV);
        this.boS.add(this.lPW);
        this.boS.add(this.knc);
        this.boS.add(this.lQa);
        this.boS.add(this.lQb);
        this.boS.add(this.lQc);
        this.boS.add(this.lQf);
        this.boS.add(this.lQd);
        this.boS.add(this.lQe);
        this.boS.add(this.lPY);
        this.boS.add(this.lQg);
        this.boS.add(this.lPZ);
        this.boS.add(this.lQi);
        this.boS.add(this.lQj);
        this.jqY.setPriority(1);
        this.jqY.setSelfListener(true);
        pbFragment.registerListener(this.jqY);
        pbFragment.registerListener(this.lQC);
        cRI();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.boS);
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
            this.lQk = fVar;
            dnh();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lQk != null && this.lQk.dlr() != null && this.lQk.dlr().size() > 0) {
                this.postList.addAll(this.lQk.dlr());
            }
            if (fVar.dlp() != null && fVar.dlp().bnS() != null) {
                this.bmb = fVar.dlp().bnS().getUserId();
            }
            if (this.lPQ != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>(fVar.dlr());
                PostData aW = aW(arrayList);
                boolean z6 = aW != null;
                if (aW != null) {
                    this.lQt = aW;
                }
                boolean z7 = false;
                if (!this.lQm && aW != null) {
                    arrayList.remove(aW);
                    z7 = true;
                    z6 = true;
                    if (fVar.dlP() && aW.dNQ() != null) {
                        aW.c(null);
                    }
                }
                if (!z6 && fVar.dly() != null) {
                    aW = fVar.dly();
                    z7 = true;
                    z6 = true;
                    if (!this.lQm && fVar.dlP() && aW.dNQ() != null) {
                        aW.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aW;
                fl(arrayList);
                if (this.lPo.dnZ()) {
                    if (fVar.dlr().size() > 0 && (postData = fVar.dlr().get(0)) != null && postData.dNO() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.lQk, arrayList, this.lQm);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.lQk.dls());
                    }
                }
                int c = c(this.lQk, arrayList, this.lQm);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.lQk.dlt());
                }
                com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
                boolean z9 = false;
                int b2 = b(fVar, arrayList);
                if (b2 >= 0) {
                    z9 = true;
                    a(fVar, arrayList, b2);
                }
                int a2 = a(fVar, arrayList);
                List<com.baidu.adp.widget.ListView.n> g = g(fVar);
                if (com.baidu.tbadk.core.util.y.isEmpty(g) || a2 < 0) {
                    z2 = z9;
                } else {
                    com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, a2);
                    if (nVar2 instanceof PostData) {
                        ((PostData) nVar2).nzO = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i2 = -1;
                if (z6) {
                    i2 = a(fVar, arrayList, this.lQm);
                }
                if (i2 >= 0 && fVar.dlO() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i2, fVar.dlO());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.nzN = true;
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
                        } else if (b2 >= 0) {
                            i5 = b2;
                        }
                        nVar = f(arrayList, i5);
                        z11 = nVar != null;
                    }
                    boolean z13 = TbadkApplication.getCurrentAccountInfo() == null || TbadkApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
                    if (z13) {
                        this.lQA = i5;
                        if (d(arrayList, i5) != null) {
                            this.lQA = -1;
                            i4++;
                        }
                    }
                    if (!com.baidu.tbadk.a.d.biW() || !z13) {
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
                            boolean a4 = a(fVar, arrayList, z5, vVar != null, i, i4, a2, b2);
                            if (vVar != null) {
                                vVar.lWm = a4;
                            }
                        }
                        this.lPQ.uX(z4);
                        boolean h = h(postData2);
                        if (this.lQn && !h) {
                            arrayList.remove(postData2);
                            this.lQn = false;
                        }
                        if (fVar.dlO() != null) {
                            fVar.dlO().uH(!z3);
                        }
                        if (this.gAY != null) {
                            this.grV = arrayList;
                            this.gAY.setData(this.grV);
                        }
                        a(h, z, a2, g);
                        if (!a(postData2, arrayList, z8)) {
                            this.gAY.setData(arrayList);
                            return;
                        }
                        return;
                    }
                }
                i = i5;
                z5 = z11;
                if (z6) {
                }
                this.lPQ.uX(z4);
                boolean h2 = h(postData2);
                if (this.lQn) {
                    arrayList.remove(postData2);
                    this.lQn = false;
                }
                if (fVar.dlO() != null) {
                }
                if (this.gAY != null) {
                }
                a(h2, z, a2, g);
                if (!a(postData2, arrayList, z8)) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.n d(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        if (com.baidu.tbadk.a.d.biW() && i > 0) {
            if (this.lQB == null && com.baidu.tieba.h.a.cNx().isAdReady("6051001775-457565154")) {
                this.lQB = new cb();
                this.lQB.eVH = new com.baidu.tieba.tbadkCore.data.n();
            }
            if (this.lQB != null && this.lQB.eVH != null) {
                com.baidu.tbadk.core.util.y.add(arrayList, i, this.lQB);
            }
        }
        return this.lQB;
    }

    public void dnd() {
        if (this.lQA > 0 && d(this.grV, this.lQA) != null) {
            this.lQA = -1;
            this.gAY.setData(this.grV);
            notifyDataSetChanged();
        }
    }

    private PostData aW(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dNO() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lNH);
        cb dlp = fVar.dlp();
        oVar.lNJ = dlp != null ? dlp.bnJ() : 0L;
        oVar.isNew = !this.lQm;
        oVar.lNM = this.lPo.doj();
        oVar.sortType = fVar.lMp;
        oVar.lNL = fVar.dlT();
        oVar.isDynamic = fVar.dlS();
        oVar.lNN = fVar.lMo;
        com.baidu.tbadk.core.util.y.add(arrayList, i, oVar);
    }

    private com.baidu.adp.widget.ListView.n b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lPo.dmG().dmz()) || !this.lPo.dmG().doM())) {
            if (!this.lPo.dmy() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlM())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.dlM().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lPo.dmG().doJ();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n a(com.baidu.tieba.pb.data.f fVar, PostData postData, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.i iVar = null;
        if (fVar.getForum() == null || StringUtils.isNull(fVar.getForum().getName()) || !TextUtils.equals(fVar.getForum().getName(), this.lPo.dmG().dmz()) || !this.lPo.dmG().doM()) {
            if (postData != null) {
                if (postData.nAd != null) {
                    iVar = new com.baidu.tieba.pb.data.i(postData.nAd);
                }
            } else if (this.lQt != null && this.lQt.nAd != null) {
                iVar = new com.baidu.tieba.pb.data.i(this.lQt.nAd);
            }
            if (iVar != null) {
                iVar.tid = this.lPo.dmG().doJ();
                com.baidu.tbadk.core.util.y.add(arrayList, i + 1, iVar);
            }
        }
        return iVar;
    }

    private boolean h(PostData postData) {
        return (this.lPo.dmG() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lPo.dmG().doH())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.n> list) {
        if (!z && !z2) {
            if ((this.lQp || this.lQo) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.lQq) {
                this.lQx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gAY.setSelectionFromTop(g.this.gAY.getHeaderViewsCount() + list.size(), 0 - g.this.lQz);
                        g.this.lQq = false;
                    }
                };
                com.baidu.adp.lib.f.e.mA().post(this.lQx);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (postData == null) {
            if (this.lQt != null && !this.lQo) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.lQt);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.JJ(1);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlR()) && fVar.dlR().size() > 2) {
            int min = Math.min(fVar.dlR().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.p pVar = fVar.dlR().get(i5);
                if (!z2 && i5 == 0) {
                    pVar.jq(true);
                }
                if (pVar.boj() == null) {
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
        if (i < 0 || fVar == null || !fVar.lMt || fVar.lMu == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lMu;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lPQ.setData(fVar);
        this.lPQ.setFromCDN(this.mIsFromCDN);
        this.lPQ.setImageMaxWidth(this.lQs);
        this.lPQ.uJ(this.lQl);
        this.lPQ.C(this.bdi);
        this.lPQ.V(this.lQu);
        this.lPQ.setOnImageClickListener(this.fVW);
        this.lPQ.setOnLongClickListener(this.mOnLongClickListener);
        this.lPQ.setTbGestureDetector(this.fxj);
        this.lPX.setData(fVar);
        this.lPX.setFromCDN(this.mIsFromCDN);
        this.lPX.hc(this.bmb);
        this.lPX.uJ(this.lQl);
        this.lPX.C(this.bdi);
        this.lPX.V(this.lQu);
        this.lPX.setOnImageClickListener(this.fVW);
        this.lPX.setOnLongClickListener(this.mOnLongClickListener);
        this.lPX.setTbGestureDetector(this.fxj);
        this.lPR.setOnClickListener(this.bdi);
        this.lQg.setOnClickListener(this.bdi);
        this.lPY.setOnClickListener(this.lQD);
        if (this.lQa != null && (this.lQa instanceof com.baidu.tieba.recapp.p)) {
            ((com.baidu.tieba.recapp.p) this.lQa).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lQh.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.adapter.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.hc(this.bmb);
                next.setImageMaxWidth(this.lQs);
                next.uJ(this.lQl);
                next.uK(this.lQm);
                next.uL(this.lQr);
                next.C(this.bdi);
                next.V(this.lQu);
                next.setOnImageClickListener(this.fVW);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lPV.C(this.bdi);
        this.lPV.a(this.lQv);
        this.lPW.C(this.bdi);
        this.lPV.setData(fVar);
        this.lPU.setData(fVar);
        this.lPW.setData(fVar);
        this.lQd.setData(fVar);
        this.lQe.setData(fVar);
        this.lQi.setPbData(fVar);
        this.lQi.setFrom(this.lPo.lUw);
        this.lQj.setPbData(fVar);
    }

    private v a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.adp.widget.ListView.n nVar, int i, int i2) {
        v dlu = this.lQk.dlu();
        if (dlu != null) {
            if (nVar != null) {
                if (i2 < 0 && nVar.getType() != AdvertAppInfo.eMK) {
                    i2 = i + 2;
                } else if (nVar.getType() == AdvertAppInfo.eMK) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dlu instanceof v)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, dlu);
                return dlu;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n e(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        PbModel dmG;
        if (i >= 0 && (dmG = this.lPo.dmG()) != null) {
            String dpA = dmG.dpA();
            if (TextUtils.isEmpty(dpA)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
            oVar.Tw(dpA);
            c(oVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, oVar);
            return oVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n f(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        if (this.lQk == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.o doY = this.lPo.dmG().doY();
        if (doY == null) {
            doY = this.lQk.dlH();
        }
        if (doY != null) {
            AdvertAppInfo.ILegoAdvert dND = doY.dND();
            if (dND != null) {
                dND.setAdvertAppInfo(doY.qS());
            }
            int blF = doY.dNC().blF();
            if (blF != 0) {
                com.baidu.tieba.recapp.report.d.a(doY, blF);
                if (blF == 28 || blF == 31 || doY.dNC().goods == null) {
                    return null;
                }
                doY.dNC().goods.goods_style = -1001;
                return null;
            }
            if (this.lQk.getForum() != null) {
                doY.forumId = this.lQk.getForum().getId();
            }
            if (this.lQk.dlp() != null) {
                doY.threadId = com.baidu.adp.lib.f.b.toLong(this.lQk.dlp().getId(), 0L);
            }
            if (this.lQk != null && this.lQk.getPage() != null) {
                doY.pageNumber = this.lQk.getPage().bmF();
            }
            c(doY);
            if (i >= 0) {
                com.baidu.tieba.lego.card.c.a.a(arrayList, doY, i);
                return doY;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (this.lQo || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dlr()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dlP() && this.lQm) ? 0 : -1;
        } else if (this.lPo.dmG() == null || !this.lPo.dmG().getIsFromMark()) {
            if (this.lPo.dnB() == null || !this.lPo.dnB().drN()) {
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
                        if (postData.dNO() == 1 && postData.nzK == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
                if (z) {
                    return i + 1;
                }
                return fVar.dlP() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dlr()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dlr(), 0)) == null) {
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
                if (postData.dNO() == 1 && postData.nzK == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dlr()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dlP()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dlr().get(0) == null || fVar.dlr().get(0).dNO() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.n> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dlD() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dlD().lNY)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dlD().lNY;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.nzX = true;
                postData.nzM = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.dlD().lNZ) > 2) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (nVar instanceof PostData) {
                ((PostData) nVar).nzM = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).nzM = true;
            }
        }
        com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lNI);
        oVar.lNK = fVar.dlD().forum_top_list;
        arrayList.add(0, oVar);
        return arrayList;
    }

    private void cRI() {
        if (this.lPo != null && !cRJ()) {
            this.lPo.registerListener(this.jFL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRJ() {
        if (this.lPo == null) {
            return false;
        }
        this.jFJ = new ArrayList();
        ArrayList<BdUniqueId> dNb = com.baidu.tieba.tbadkCore.v.dNb();
        if (dNb == null || dNb.size() <= 0) {
            return false;
        }
        int size = dNb.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.ddj().a(this.lPo.getPageContext(), dNb.get(i), 2);
            if (a2 != null) {
                this.boS.add(a2);
                this.jFJ.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jFJ)) {
            this.gAY.addAdapters(this.jFJ);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.gAY.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.dlr() == null || fVar.dls() == null || fVar.dlr().size() == 0 || fVar.dlp() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dls().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dlr().get(0) == null || fVar.dlr().get(0).dNO() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bmF() != fVar.getPage().bmC()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.dlr() == null || fVar.dlt() == null || fVar.dlr().size() == 0 || fVar.dlp() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dlt().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dlr().get(0) == null || fVar.dlr().get(0).dNO() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bmF() != fVar.getPage().bmC()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.n getItem(int i) {
        return this.gAY.getItem(i);
    }

    public ArrayList<PostData> dne() {
        return this.postList;
    }

    public BdUniqueId FD(int i) {
        if (this.gAY.getItem(i) != null) {
            return this.gAY.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lQy = dnf();
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public int dnf() {
        if (this.gAY != null && this.gAY.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gAY.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n nVar = this.gAY.getData().get(i2);
                if (nVar == null || nVar.getType() != com.baidu.tieba.pb.data.o.lNH) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int dng() {
        return this.lQy;
    }

    private void dnh() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lQk != null && !this.lQk.lNd && this.lQk.abG != 2) {
            ArrayList<PostData> dlr = this.lQk.dlr();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dlG = this.lQk.dlG();
            if (!com.baidu.tieba.lego.card.c.a.isEmpty(dlr) && !com.baidu.tieba.lego.card.c.a.isEmpty(dlG)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dlG.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dlG.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jFH = sb.toString();
                        next2.position = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dlG.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dNC() != null) {
                        int blF = next3.dNC().blF();
                        if (blF != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, blF);
                            if (blF != 28 && blF != 31) {
                                if (next3.dNC().goods != null) {
                                    next3.dNC().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dlG.clear();
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
                    if (this.lQk.getForum() != null) {
                        oVar4.forumId = this.lQk.getForum().getId();
                    }
                    if (this.lQk.dlp() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lQk.dlp().getId(), 0L);
                    }
                    if (this.lQk != null && this.lQk.getPage() != null) {
                        oVar4.pageNumber = this.lQk.getPage().bmF();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lQk.lNc;
                    if (position >= com.baidu.tieba.lego.card.c.a.eL(dlr)) {
                        oVar4.position = position;
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, position, com.baidu.tieba.lego.card.c.a.eL(dlr));
                        return;
                    }
                    if (!this.lQm) {
                        position--;
                        oVar4.position = position;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.c.a.a(dlr, oVar4, position);
                        TiebaStatic.eventStat(this.lPo.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dNC().apk_name);
                    }
                }
            }
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lQk != null && oVar.dNC() != null) {
            oVar.dNC().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lQk.getPage() != null) {
                oVar.dNC().advertAppContext.pn = this.lQk.getPage().bmF();
            }
            oVar.dNC().advertAppContext.page = oVar.dNF();
            if (this.lQk.getForum() != null && (forum = this.lQk.getForum()) != null) {
                oVar.dNC().advertAppContext.fid = forum.getId();
                oVar.dNC().advertAppContext.eMx = forum.getFirst_class();
                oVar.dNC().advertAppContext.eMy = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dNC().advertAppContext.eMz = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dNC().advertAppContext.extensionInfo = oVar.dNC().ext_info;
            oVar.dNC().advertAppContext.abM = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lPQ.setFromCDN(z);
        if (this.lQa != null && (this.lQa instanceof com.baidu.tieba.recapp.p)) {
            ((com.baidu.tieba.recapp.p) this.lQa).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lQh.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean dni() {
        return this.lQl;
    }

    public void uJ(boolean z) {
        this.lQl = z;
    }

    public void uK(boolean z) {
        this.lQm = z;
    }

    public void uL(boolean z) {
        this.lQr = z;
    }

    public void V(View.OnClickListener onClickListener) {
        this.lQu = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fVW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fxj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lQv = aVar;
    }

    public void FE(int i) {
        switch (i) {
            case 1:
                if (this.lPQ != null) {
                    this.lPQ.pause();
                }
                if (this.lQa instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lQa).onPause();
                }
                if (this.lQb instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lQb).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lPQ != null) {
                    this.lPQ.resume();
                }
                if (this.lQa instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lQa).onResume();
                }
                if (this.lQb instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lQb).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lPQ != null) {
                    this.lPQ.release();
                }
                if (this.lQa instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lQa).onDestroy();
                }
                if (this.lQb instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lQb).onDestroy();
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
                    if (!TextUtils.isEmpty(postData.bpd())) {
                        com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
                        anVar.Ac(postData.bpd());
                        list.set(i, anVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lQx);
        if (this.lPV != null) {
            this.lPV.onDestroy();
        }
        if (this.lPW != null) {
            this.lPW.onDestroy();
        }
        if (this.lPR != null) {
            this.lPR.onDestroy();
        }
        if (this.lPU != null) {
            this.lPU.onDestroy();
        }
    }

    public void uP(boolean z) {
        this.lQo = z;
    }

    public void uQ(boolean z) {
        this.lQp = z;
    }

    public void uR(boolean z) {
        this.lQn = z;
    }

    public void uS(boolean z) {
        this.lQq = z;
    }

    public PbFirstFloorCommentAndPraiseAdapter dnj() {
        return this.lPR;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.grV;
    }

    public View dnk() {
        if (this.lPQ == null || this.lPQ.dnp() == null) {
            return null;
        }
        if (this.lPQ.dnp().lSS != null && this.lPQ.dnp().lSS.isShown()) {
            return this.lPQ.dnp().lSS;
        }
        return this.lPQ.dnp().lSR;
    }

    public PbFirstFloorViewHolder dnl() {
        if (this.lPQ == null || this.lPQ.dnp() == null) {
            return null;
        }
        return this.lPQ.dnp();
    }

    public void uT(boolean z) {
        if (this.lPX != null) {
            this.lPX.uT(z);
        }
    }
}
