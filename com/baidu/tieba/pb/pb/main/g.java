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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
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
    private ArrayList<com.baidu.adp.widget.ListView.n> grW;
    private List<com.baidu.adp.widget.ListView.a> jCN;
    private com.baidu.adp.widget.ListView.a khi;
    private PbFragment lIO;
    private com.baidu.adp.widget.ListView.a lJA;
    private ah lJB;
    private ai lJC;
    private ag lJD;
    private PbReplyLoadMoreAdapter lJE;
    private h lJG;
    private u lJH;
    private com.baidu.tieba.pb.data.f lJI;
    private boolean lJN;
    private boolean lJO;
    private int lJQ;
    private Runnable lJV;
    private int lJX;
    private bz lJZ;
    private p lJp;
    private PbFirstFloorCommentAndPraiseAdapter lJq;
    private PbFirstFloorEnterForumAdapter lJr;
    private com.baidu.tieba.pb.pb.main.adapter.a lJs;
    private ak lJt;
    private ak lJu;
    private k lJv;
    private com.baidu.tieba.pb.video.a lJw;
    private com.baidu.tieba.card.divider.a lJx;
    private com.baidu.adp.widget.ListView.a lJy;
    private com.baidu.adp.widget.ListView.a lJz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.adapter.a> lJF = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lJJ = true;
    private boolean lJK = true;
    private boolean lJL = false;
    private boolean lJM = false;
    private boolean lJP = false;
    private String blY = null;
    private PostData lJR = null;
    private View.OnClickListener lJS = null;
    private View.OnClickListener bdp = null;
    private TbRichTextView.i fWO = null;
    private com.baidu.tieba.pb.a.c fyb = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lJT = null;
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lJU = new ArrayList();
    private int lJW = -1;
    private int lJY = -1;
    private final CustomMessageListener lKa = new CustomMessageListener(2921523) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.n)) {
                com.baidu.tieba.tbadkCore.data.n nVar = (com.baidu.tieba.tbadkCore.data.n) customResponsedMessage.getData();
                if (g.this.lJZ != null && g.this.lJZ.eWF == nVar) {
                    g.this.lJZ.eWF.aR(null);
                    g.this.gAY.setData(g.this.grW);
                    g.this.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener job = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dOF = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dOF();
                Iterator it = dOF.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(g.this.lIO);
                        if (aVar instanceof com.baidu.tieba.pb.pb.adapter.a) {
                            g.this.lJF.add((com.baidu.tieba.pb.pb.adapter.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dOF);
                g.this.lJU.clear();
                g.this.lJU.addAll(arrayList);
                if (g.this.gAY != null) {
                    g.this.gAY.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener fvn = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.3
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.lJI != null && !com.baidu.adp.base.j.I(g.this.lIO.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener lKb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lIO != null && g.this.lJI != null && g.this.lJI.dmS() != null) {
                g.this.lIO.doO().drW().dnR();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12040"));
            }
        }
    };
    private CustomMessageListener jCP = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.x.isEmpty(g.this.jCN)) {
                g.this.cTn();
                g.this.a(g.this.lJI, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lJQ = 0;
        this.width = -1;
        this.lJX = 0;
        this.lJQ = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lJQ;
        this.lIO = pbFragment;
        this.gAY = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.fvn);
        this.lJX = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lIO.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lJp = new p(pbFragment, PostData.nru);
        this.lJp.a((TbRichTextView.c) pbFragment);
        this.lJq = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, com.baidu.tieba.pb.data.o.lHp);
        this.lJr = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lJs = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lFE);
        this.lJt = new ak(pbFragment, com.baidu.tieba.pb.data.n.lHi);
        this.lJu = new ak(pbFragment, com.baidu.tieba.pb.data.n.lHj);
        this.lJv = new k(pbFragment, PostData.nrv);
        this.lJv.a((TbRichTextView.c) pbFragment);
        this.khi = com.baidu.tieba.recapp.r.dEV().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eNE);
        this.lJy = com.baidu.tieba.recapp.r.dEV().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eNI);
        this.lJz = com.baidu.tieba.h.b.cPp().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eNJ);
        this.lJA = com.baidu.tieba.h.b.cPp().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eNK);
        this.lJD = new ag(pbFragment, com.baidu.tieba.pb.data.l.Yr);
        this.lJB = new ah(pbFragment, af.lSN);
        this.lJC = new ai(pbFragment, bb.eRh);
        this.lJE = new PbReplyLoadMoreAdapter(pbFragment, PostData.nrz);
        this.lJw = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.mdY);
        this.lJx = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lJG = new h(pbFragment, com.baidu.tbadk.core.data.o.eOU);
        this.lJH = new u(pbFragment, pbFragment.getUniqueId());
        this.boM.add(this.lJp);
        this.boM.add(this.lJq);
        this.boM.add(this.lJr);
        this.boM.add(this.lJs);
        this.boM.add(this.lJv);
        this.boM.add(this.lJt);
        this.boM.add(this.lJu);
        this.boM.add(this.khi);
        this.boM.add(this.lJy);
        this.boM.add(this.lJz);
        this.boM.add(this.lJA);
        this.boM.add(this.lJD);
        this.boM.add(this.lJB);
        this.boM.add(this.lJC);
        this.boM.add(this.lJw);
        this.boM.add(this.lJE);
        this.boM.add(this.lJx);
        this.boM.add(this.lJG);
        this.boM.add(this.lJH);
        this.job.setPriority(1);
        this.job.setSelfListener(true);
        pbFragment.registerListener(this.job);
        pbFragment.registerListener(this.lKa);
        cTm();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.boM);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
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
            this.lJI = fVar;
            dow();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lJI != null && this.lJI.dmG() != null && this.lJI.dmG().size() > 0) {
                this.postList.addAll(this.lJI.dmG());
            }
            if (fVar.dmE() != null && fVar.dmE().brq() != null) {
                this.blY = fVar.dmE().brq().getUserId();
            }
            if (this.lJp != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>(fVar.dmG());
                PostData bc = bc(arrayList);
                boolean z6 = bc != null;
                if (bc != null) {
                    this.lJR = bc;
                }
                boolean z7 = false;
                if (!this.lJK && bc != null) {
                    arrayList.remove(bc);
                    z7 = true;
                    z6 = true;
                    if (fVar.dne() && bc.dPf() != null) {
                        bc.c(null);
                    }
                }
                if (!z6 && fVar.dmN() != null) {
                    bc = fVar.dmN();
                    z7 = true;
                    z6 = true;
                    if (!this.lJK && fVar.dne() && bc.dPf() != null) {
                        bc.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = bc;
                fn(arrayList);
                if (this.lIO.dpm()) {
                    if (fVar.dmG().size() > 0 && (postData = fVar.dmG().get(0)) != null && postData.dPd() == 1 && !com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b2 = b(this.lJI, arrayList, this.lJK);
                    if (b2 >= 0) {
                        com.baidu.tbadk.core.util.x.add(arrayList, b2, this.lJI.dmH());
                    }
                }
                int c = c(this.lJI, arrayList, this.lJK);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.x.add(arrayList, c, this.lJI.dmI());
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
                if (com.baidu.tbadk.core.util.x.isEmpty(g) || a2 < 0) {
                    z2 = z9;
                } else {
                    com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, a2);
                    if (nVar2 instanceof PostData) {
                        ((PostData) nVar2).nsg = true;
                    }
                    com.baidu.tbadk.core.util.x.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i2 = -1;
                if (z6) {
                    i2 = a(fVar, arrayList, this.lJK);
                }
                if (i2 >= 0 && fVar.dnd() != null) {
                    com.baidu.tbadk.core.util.x.add(arrayList, i2, fVar.dnd());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.nsf = true;
                    }
                    z3 = false;
                    z4 = z2;
                }
                int i3 = b(fVar, arrayList, i2) != null ? i2 + 1 : i2;
                int i4 = c(fVar, arrayList, i3) != null ? i3 + 1 : i3;
                boolean z10 = false;
                v vVar = null;
                int i5 = -1;
                if (z6) {
                    com.baidu.adp.widget.ListView.n e = e(arrayList, i4);
                    boolean z11 = e != null;
                    if (z11) {
                        nVar = e;
                        z10 = z11;
                    } else {
                        if (i4 >= 0) {
                            i5 = i4 + 1;
                        } else if (a2 >= 0) {
                            i5 = a2;
                        } else if (b3 >= 0) {
                            i5 = b3;
                        }
                        nVar = f(arrayList, i5);
                        z10 = nVar != null;
                    }
                    boolean z12 = TbadkApplication.getCurrentAccountInfo() == null || TbadkApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
                    if (z12) {
                        this.lJY = i5;
                        if (d(arrayList, i5) != null) {
                            this.lJY = -1;
                            i4++;
                        }
                    }
                    if (!com.baidu.tbadk.a.d.bmB() || !z12) {
                        v a3 = a(arrayList, nVar, i4, i5);
                        if (a3 == null) {
                            i = i5;
                            vVar = a3;
                            z5 = z10;
                        } else if (!z10) {
                            i = i5;
                            vVar = a3;
                            z5 = true;
                        } else if (i5 > 0) {
                            i = i5 + 1;
                            vVar = a3;
                            z5 = z10;
                        } else {
                            i4++;
                            i = i5;
                            vVar = a3;
                            z5 = z10;
                        }
                        if (z6) {
                            boolean a4 = a(fVar, arrayList, z5, vVar != null, i, i4, a2, b3);
                            if (vVar != null) {
                                vVar.lPE = a4;
                            }
                        }
                        this.lJp.uM(z4);
                        boolean h = h(postData2);
                        if (this.lJL && !h) {
                            arrayList.remove(postData2);
                            this.lJL = false;
                        }
                        if (fVar.dnd() != null) {
                            fVar.dnd().uy(!z3);
                        }
                        if (this.gAY != null) {
                            this.grW = arrayList;
                            this.gAY.setData(this.grW);
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
                z5 = z10;
                if (z6) {
                }
                this.lJp.uM(z4);
                boolean h2 = h(postData2);
                if (this.lJL) {
                    arrayList.remove(postData2);
                    this.lJL = false;
                }
                if (fVar.dnd() != null) {
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
        List<bz> LN;
        if (com.baidu.tbadk.a.d.bmB() && i > 0) {
            if (this.lJZ == null && (LN = com.baidu.tieba.h.a.cPm().LN("6051001308-627527144")) != null && LN.size() > 0) {
                this.lJZ = LN.get(0);
            }
            if (this.lJZ != null && this.lJZ.eWF != null && this.lJZ.eWF.dON() != null) {
                com.baidu.tbadk.core.util.x.add(arrayList, i, this.lJZ);
            }
        }
        return this.lJZ;
    }

    public void dos() {
        if (this.lJY > 0 && d(this.grW, this.lJY) != null) {
            this.lJY = -1;
            this.gAY.setData(this.grW);
            notifyDataSetChanged();
        }
    }

    private PostData bc(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dPd() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lHi);
        bz dmE = fVar.dmE();
        nVar.lHk = dmE != null ? dmE.brh() : 0L;
        nVar.isNew = !this.lJK;
        nVar.lHn = this.lIO.dpw();
        nVar.sortType = fVar.lFS;
        nVar.lHm = fVar.dni();
        nVar.isDynamic = fVar.dnh();
        nVar.lHo = fVar.lFR;
        com.baidu.tbadk.core.util.x.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.n b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lIO.dnV().dnO()) || !this.lIO.dnV().dpZ())) {
            if (!this.lIO.dnN() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.dnb())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.dnb().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lIO.dnV().dpW();
            com.baidu.tbadk.core.util.x.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.lIO.dnV() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lIO.dnV().dpU())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.n> list) {
        if (!z && !z2) {
            if ((this.lJN || this.lJM) && i != -1 && !com.baidu.tbadk.core.util.x.isEmpty(list) && !this.lJO) {
                this.lJV = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gAY.setSelectionFromTop(g.this.gAY.getHeaderViewsCount() + list.size(), 0 - g.this.lJX);
                        g.this.lJO = false;
                    }
                };
                com.baidu.adp.lib.f.e.mB().post(this.lJV);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (postData == null) {
            if (this.lJR != null && !this.lJM) {
                com.baidu.tbadk.core.util.x.add(arrayList, 0, this.lJR);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.KR(1);
            com.baidu.tbadk.core.util.x.add(arrayList, 0, postData2);
            return true;
        } else if (z) {
            com.baidu.tbadk.core.util.x.add(arrayList, 0, postData);
            return true;
        } else {
            return false;
        }
    }

    private boolean a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        ArrayList arrayList2 = new ArrayList();
        if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.dng()) && fVar.dng().size() > 2) {
            int min = Math.min(fVar.dng().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.o oVar = fVar.dng().get(i5);
                if (!z2 && i5 == 0) {
                    oVar.js(true);
                }
                if (oVar.brH() == null) {
                    if (i5 == min - 1) {
                        oVar.jt(true);
                    }
                } else if (i5 == min - 2) {
                    oVar.jt(true);
                } else if (i5 == min - 1) {
                    oVar.ju(true);
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
                    com.baidu.tbadk.core.util.x.add(arrayList, i3, arrayList2.get(size));
                }
                return true;
            }
        }
        return false;
    }

    private com.baidu.adp.widget.ListView.n c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        if (i < 0 || fVar == null || !fVar.lFW || fVar.lFX == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lFX;
        com.baidu.tbadk.core.util.x.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lJp.setData(fVar);
        this.lJp.setFromCDN(this.mIsFromCDN);
        this.lJp.setImageMaxWidth(this.lJQ);
        this.lJp.uz(this.lJJ);
        this.lJp.C(this.bdp);
        this.lJp.U(this.lJS);
        this.lJp.setOnImageClickListener(this.fWO);
        this.lJp.setOnLongClickListener(this.mOnLongClickListener);
        this.lJp.setTbGestureDetector(this.fyb);
        this.lJv.setData(fVar);
        this.lJv.setFromCDN(this.mIsFromCDN);
        this.lJv.hJ(this.blY);
        this.lJv.uz(this.lJJ);
        this.lJv.C(this.bdp);
        this.lJv.U(this.lJS);
        this.lJv.setOnImageClickListener(this.fWO);
        this.lJv.setOnLongClickListener(this.mOnLongClickListener);
        this.lJv.setTbGestureDetector(this.fyb);
        this.lJq.setOnClickListener(this.bdp);
        this.lJE.setOnClickListener(this.bdp);
        this.lJw.setOnClickListener(this.lKb);
        if (this.lJy != null && (this.lJy instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lJy).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lJF.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.adapter.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.hJ(this.blY);
                next.setImageMaxWidth(this.lJQ);
                next.uz(this.lJJ);
                next.uA(this.lJK);
                next.uB(this.lJP);
                next.C(this.bdp);
                next.U(this.lJS);
                next.setOnImageClickListener(this.fWO);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lJt.C(this.bdp);
        this.lJt.a(this.lJT);
        this.lJu.C(this.bdp);
        this.lJt.setData(fVar);
        this.lJs.setData(fVar);
        this.lJu.setData(fVar);
        this.lJB.setData(fVar);
        this.lJC.setData(fVar);
        this.lJG.setPbData(fVar);
        this.lJG.setFrom(this.lIO.lNN);
        this.lJH.setPbData(fVar);
    }

    private v a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.adp.widget.ListView.n nVar, int i, int i2) {
        v dmJ = this.lJI.dmJ();
        if (dmJ != null) {
            if (nVar != null) {
                if (i2 < 0 && nVar.getType() != AdvertAppInfo.eNI) {
                    i2 = i + 2;
                } else if (nVar.getType() == AdvertAppInfo.eNI) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dmJ instanceof v)) {
                com.baidu.tbadk.core.util.x.add(arrayList, i2, dmJ);
                return dmJ;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n e(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        PbModel dnV;
        if (i >= 0 && (dnV = this.lIO.dnV()) != null) {
            String dqN = dnV.dqN();
            if (TextUtils.isEmpty(dqN)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
            oVar.To(dqN);
            c(oVar);
            com.baidu.tbadk.core.util.x.add(arrayList, i + 1, oVar);
            return oVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n f(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        if (this.lJI == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.o dql = this.lIO.dnV().dql();
        if (dql == null) {
            dql = this.lJI.dmW();
        }
        if (dql != null) {
            AdvertAppInfo.ILegoAdvert dOS = dql.dOS();
            if (dOS != null) {
                dOS.setAdvertAppInfo(dql.qU());
            }
            int bpe = dql.dOR().bpe();
            if (bpe != 0) {
                com.baidu.tieba.recapp.report.d.a(dql, bpe);
                if (bpe == 28 || bpe == 31 || dql.dOR().goods == null) {
                    return null;
                }
                dql.dOR().goods.goods_style = -1001;
                return null;
            }
            if (this.lJI.getForum() != null) {
                dql.forumId = this.lJI.getForum().getId();
            }
            if (this.lJI.dmE() != null) {
                dql.threadId = com.baidu.adp.lib.f.b.toLong(this.lJI.dmE().getId(), 0L);
            }
            if (this.lJI != null && this.lJI.getPage() != null) {
                dql.pageNumber = this.lJI.getPage().bqd();
            }
            c(dql);
            if (i >= 0) {
                com.baidu.tieba.lego.card.c.a.a(arrayList, dql, i);
                return dql;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (this.lJM || fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.dmG()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dne() && this.lJK) ? 0 : -1;
        } else if (this.lIO.dnV() == null || !this.lIO.dnV().getIsFromMark()) {
            if (this.lIO.doO() == null || !this.lIO.doO().dta()) {
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
                        if (postData.dPd() == 1 && postData.nsc == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
                if (z) {
                    return i + 1;
                }
                return fVar.dne() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.dmG()) || com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.x.getItem(fVar.dmG(), 0)) == null) {
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
                if (postData.dPd() == 1 && postData.nsc == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.dmG()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dne()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dmG().get(0) == null || fVar.dmG().get(0).dPd() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.n> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmS() == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.dmS().lHy)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dmS().lHy;
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.nsp = true;
                postData.nse = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.x.getCount(fVar.dmS().lHz) > 2) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (nVar instanceof PostData) {
                ((PostData) nVar).nse = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).nse = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar3 = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lHj);
        nVar3.lHl = fVar.dmS().forum_top_list;
        arrayList.add(0, nVar3);
        return arrayList;
    }

    private void cTm() {
        if (this.lIO != null && !cTn()) {
            this.lIO.registerListener(this.jCP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTn() {
        if (this.lIO == null) {
            return false;
        }
        this.jCN = new ArrayList();
        ArrayList<BdUniqueId> dOr = com.baidu.tieba.tbadkCore.v.dOr();
        if (dOr == null || dOr.size() <= 0) {
            return false;
        }
        int size = dOr.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.deM().a(this.lIO.getPageContext(), dOr.get(i), 2);
            if (a2 != null) {
                this.boM.add(a2);
                this.jCN.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.jCN)) {
            this.gAY.addAdapters(this.jCN);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.gAY.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.dmG() == null || fVar.dmH() == null || fVar.dmG().size() == 0 || fVar.dmE() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dmH().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dmG().get(0) == null || fVar.dmG().get(0).dPd() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bqd() != fVar.getPage().bqa()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.dmG() == null || fVar.dmI() == null || fVar.dmG().size() == 0 || fVar.dmE() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dmI().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dmG().get(0) == null || fVar.dmG().get(0).dPd() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bqd() != fVar.getPage().bqa()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.n getItem(int i) {
        return this.gAY.getItem(i);
    }

    public ArrayList<PostData> dot() {
        return this.postList;
    }

    public BdUniqueId GN(int i) {
        if (this.gAY.getItem(i) != null) {
            return this.gAY.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lJW = dou();
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public int dou() {
        if (this.gAY != null && this.gAY.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gAY.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n nVar = this.gAY.getData().get(i2);
                if (nVar == null || nVar.getType() != com.baidu.tieba.pb.data.n.lHi) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int dov() {
        return this.lJW;
    }

    private void dow() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lJI != null && !this.lJI.lGG && this.lJI.aas != 2) {
            ArrayList<PostData> dmG = this.lJI.dmG();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dmV = this.lJI.dmV();
            if (!com.baidu.tieba.lego.card.c.a.isEmpty(dmG) && !com.baidu.tieba.lego.card.c.a.isEmpty(dmV)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dmV.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dmV.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jCL = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dmV.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dOR() != null) {
                        int bpe = next3.dOR().bpe();
                        if (bpe != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, bpe);
                            if (bpe != 28 && bpe != 31) {
                                if (next3.dOR().goods != null) {
                                    next3.dOR().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dmV.clear();
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
                for (int i3 = 0; i3 < com.baidu.tieba.lego.card.c.a.eN(arrayList); i3++) {
                    com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) com.baidu.tieba.lego.card.c.a.l(arrayList, i3)).intValue());
                    if (this.lJI.getForum() != null) {
                        oVar4.forumId = this.lJI.getForum().getId();
                    }
                    if (this.lJI.dmE() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lJI.dmE().getId(), 0L);
                    }
                    if (this.lJI != null && this.lJI.getPage() != null) {
                        oVar4.pageNumber = this.lJI.getPage().bqd();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lJI.lGF;
                    if (position + i3 >= com.baidu.tieba.lego.card.c.a.eN(dmG)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, position, com.baidu.tieba.lego.card.c.a.eN(dmG));
                        return;
                    }
                    if (!this.lJK) {
                        position--;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.c.a.a(dmG, oVar4, position);
                        TiebaStatic.eventStat(this.lIO.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dOR().apk_name);
                    }
                }
            }
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lJI != null && oVar.dOR() != null) {
            oVar.dOR().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lJI.getPage() != null) {
                oVar.dOR().advertAppContext.pn = this.lJI.getPage().bqd();
            }
            oVar.dOR().advertAppContext.page = oVar.dOU();
            if (this.lJI.getForum() != null && (forum = this.lJI.getForum()) != null) {
                oVar.dOR().advertAppContext.fid = forum.getId();
                oVar.dOR().advertAppContext.eNv = forum.getFirst_class();
                oVar.dOR().advertAppContext.eNw = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dOR().advertAppContext.eNx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dOR().advertAppContext.extensionInfo = oVar.dOR().ext_info;
            oVar.dOR().advertAppContext.aay = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lJp.setFromCDN(z);
        if (this.lJy != null && (this.lJy instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lJy).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lJF.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean dox() {
        return this.lJJ;
    }

    public void uz(boolean z) {
        this.lJJ = z;
    }

    public void uA(boolean z) {
        this.lJK = z;
    }

    public void uB(boolean z) {
        this.lJP = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJS = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fWO = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fyb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lJT = aVar;
    }

    public void GO(int i) {
        switch (i) {
            case 1:
                if (this.lJp != null) {
                    this.lJp.pause();
                }
                if (this.lJy instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJy).onPause();
                }
                if (this.lJz instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJz).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lJp != null) {
                    this.lJp.resume();
                }
                if (this.lJy instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJy).onResume();
                }
                if (this.lJz instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJz).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lJp != null) {
                    this.lJp.release();
                }
                if (this.lJy instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJy).onDestroy();
                }
                if (this.lJz instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJz).onDestroy();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void fn(List<com.baidu.adp.widget.ListView.n> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.bsC())) {
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.AQ(postData.bsC());
                        list.set(i, amVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lJV);
        if (this.lJt != null) {
            this.lJt.onDestroy();
        }
        if (this.lJu != null) {
            this.lJu.onDestroy();
        }
        if (this.lJq != null) {
            this.lJq.onDestroy();
        }
        if (this.lJs != null) {
            this.lJs.onDestroy();
        }
    }

    public void uF(boolean z) {
        this.lJM = z;
    }

    public void uG(boolean z) {
        this.lJN = z;
    }

    public void uH(boolean z) {
        this.lJL = z;
    }

    public void uI(boolean z) {
        this.lJO = z;
    }

    public PbFirstFloorCommentAndPraiseAdapter doy() {
        return this.lJq;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.grW;
    }

    public View doz() {
        if (this.lJp == null || this.lJp.doD() == null) {
            return null;
        }
        if (this.lJp.doD().lMm != null && this.lJp.doD().lMm.isShown()) {
            return this.lJp.doD().lMm;
        }
        return this.lJp.doD().lMl;
    }

    public PbFirstFloorViewHolder doA() {
        if (this.lJp == null || this.lJp.doD() == null) {
            return null;
        }
        return this.lJp.doD();
    }
}
