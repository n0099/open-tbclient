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
    private PbFragment lIN;
    private ah lJA;
    private ai lJB;
    private ag lJC;
    private PbReplyLoadMoreAdapter lJD;
    private h lJF;
    private u lJG;
    private com.baidu.tieba.pb.data.f lJH;
    private boolean lJM;
    private boolean lJN;
    private int lJP;
    private Runnable lJU;
    private int lJW;
    private bz lJY;
    private p lJo;
    private PbFirstFloorCommentAndPraiseAdapter lJp;
    private PbFirstFloorEnterForumAdapter lJq;
    private com.baidu.tieba.pb.pb.main.adapter.a lJr;
    private ak lJs;
    private ak lJt;
    private k lJu;
    private com.baidu.tieba.pb.video.a lJv;
    private com.baidu.tieba.card.divider.a lJw;
    private com.baidu.adp.widget.ListView.a lJx;
    private com.baidu.adp.widget.ListView.a lJy;
    private com.baidu.adp.widget.ListView.a lJz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.adapter.a> lJE = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lJI = true;
    private boolean lJJ = true;
    private boolean lJK = false;
    private boolean lJL = false;
    private boolean lJO = false;
    private String blY = null;
    private PostData lJQ = null;
    private View.OnClickListener lJR = null;
    private View.OnClickListener bdp = null;
    private TbRichTextView.i fWO = null;
    private com.baidu.tieba.pb.a.c fyb = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lJS = null;
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lJT = new ArrayList();
    private int lJV = -1;
    private int lJX = -1;
    private final CustomMessageListener lJZ = new CustomMessageListener(2921523) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.n)) {
                com.baidu.tieba.tbadkCore.data.n nVar = (com.baidu.tieba.tbadkCore.data.n) customResponsedMessage.getData();
                if (g.this.lJY != null && g.this.lJY.eWF == nVar) {
                    g.this.lJY.eWF.aR(null);
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
                AbsDelegateAdapterList dOG = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dOG();
                Iterator it = dOG.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(g.this.lIN);
                        if (aVar instanceof com.baidu.tieba.pb.pb.adapter.a) {
                            g.this.lJE.add((com.baidu.tieba.pb.pb.adapter.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dOG);
                g.this.lJT.clear();
                g.this.lJT.addAll(arrayList);
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
            if (customResponsedMessage != null && g.this.lJH != null && !com.baidu.adp.base.j.I(g.this.lIN.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener lKa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lIN != null && g.this.lJH != null && g.this.lJH.dmT() != null) {
                g.this.lIN.doP().drX().dnS();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12040"));
            }
        }
    };
    private CustomMessageListener jCP = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.x.isEmpty(g.this.jCN)) {
                g.this.cTo();
                g.this.a(g.this.lJH, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lJP = 0;
        this.width = -1;
        this.lJW = 0;
        this.lJP = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lJP;
        this.lIN = pbFragment;
        this.gAY = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.fvn);
        this.lJW = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lIN.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lJo = new p(pbFragment, PostData.nrt);
        this.lJo.a((TbRichTextView.c) pbFragment);
        this.lJp = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, com.baidu.tieba.pb.data.o.lHo);
        this.lJq = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lJr = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lFD);
        this.lJs = new ak(pbFragment, com.baidu.tieba.pb.data.n.lHh);
        this.lJt = new ak(pbFragment, com.baidu.tieba.pb.data.n.lHi);
        this.lJu = new k(pbFragment, PostData.nru);
        this.lJu.a((TbRichTextView.c) pbFragment);
        this.khi = com.baidu.tieba.recapp.r.dEW().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eNE);
        this.lJx = com.baidu.tieba.recapp.r.dEW().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eNI);
        this.lJy = com.baidu.tieba.h.b.cPq().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eNJ);
        this.lJz = com.baidu.tieba.h.b.cPq().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eNK);
        this.lJC = new ag(pbFragment, com.baidu.tieba.pb.data.l.Yr);
        this.lJA = new ah(pbFragment, af.lSM);
        this.lJB = new ai(pbFragment, bb.eRh);
        this.lJD = new PbReplyLoadMoreAdapter(pbFragment, PostData.nry);
        this.lJv = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.mdX);
        this.lJw = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lJF = new h(pbFragment, com.baidu.tbadk.core.data.o.eOU);
        this.lJG = new u(pbFragment, pbFragment.getUniqueId());
        this.boM.add(this.lJo);
        this.boM.add(this.lJp);
        this.boM.add(this.lJq);
        this.boM.add(this.lJr);
        this.boM.add(this.lJu);
        this.boM.add(this.lJs);
        this.boM.add(this.lJt);
        this.boM.add(this.khi);
        this.boM.add(this.lJx);
        this.boM.add(this.lJy);
        this.boM.add(this.lJz);
        this.boM.add(this.lJC);
        this.boM.add(this.lJA);
        this.boM.add(this.lJB);
        this.boM.add(this.lJv);
        this.boM.add(this.lJD);
        this.boM.add(this.lJw);
        this.boM.add(this.lJF);
        this.boM.add(this.lJG);
        this.job.setPriority(1);
        this.job.setSelfListener(true);
        pbFragment.registerListener(this.job);
        pbFragment.registerListener(this.lJZ);
        cTn();
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
            this.lJH = fVar;
            dox();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lJH != null && this.lJH.dmH() != null && this.lJH.dmH().size() > 0) {
                this.postList.addAll(this.lJH.dmH());
            }
            if (fVar.dmF() != null && fVar.dmF().brr() != null) {
                this.blY = fVar.dmF().brr().getUserId();
            }
            if (this.lJo != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>(fVar.dmH());
                PostData bc = bc(arrayList);
                boolean z6 = bc != null;
                if (bc != null) {
                    this.lJQ = bc;
                }
                boolean z7 = false;
                if (!this.lJJ && bc != null) {
                    arrayList.remove(bc);
                    z7 = true;
                    z6 = true;
                    if (fVar.dnf() && bc.dPg() != null) {
                        bc.c(null);
                    }
                }
                if (!z6 && fVar.dmO() != null) {
                    bc = fVar.dmO();
                    z7 = true;
                    z6 = true;
                    if (!this.lJJ && fVar.dnf() && bc.dPg() != null) {
                        bc.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = bc;
                fn(arrayList);
                if (this.lIN.dpn()) {
                    if (fVar.dmH().size() > 0 && (postData = fVar.dmH().get(0)) != null && postData.dPe() == 1 && !com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b2 = b(this.lJH, arrayList, this.lJJ);
                    if (b2 >= 0) {
                        com.baidu.tbadk.core.util.x.add(arrayList, b2, this.lJH.dmI());
                    }
                }
                int c = c(this.lJH, arrayList, this.lJJ);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.x.add(arrayList, c, this.lJH.dmJ());
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
                        ((PostData) nVar2).nsf = true;
                    }
                    com.baidu.tbadk.core.util.x.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i2 = -1;
                if (z6) {
                    i2 = a(fVar, arrayList, this.lJJ);
                }
                if (i2 >= 0 && fVar.dne() != null) {
                    com.baidu.tbadk.core.util.x.add(arrayList, i2, fVar.dne());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.nse = true;
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
                        this.lJX = i5;
                        if (d(arrayList, i5) != null) {
                            this.lJX = -1;
                            i4++;
                        }
                    }
                    if (!com.baidu.tbadk.a.d.bmC() || !z12) {
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
                                vVar.lPD = a4;
                            }
                        }
                        this.lJo.uM(z4);
                        boolean h = h(postData2);
                        if (this.lJK && !h) {
                            arrayList.remove(postData2);
                            this.lJK = false;
                        }
                        if (fVar.dne() != null) {
                            fVar.dne().uy(!z3);
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
                this.lJo.uM(z4);
                boolean h2 = h(postData2);
                if (this.lJK) {
                    arrayList.remove(postData2);
                    this.lJK = false;
                }
                if (fVar.dne() != null) {
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
        List<bz> LM;
        if (com.baidu.tbadk.a.d.bmC() && i > 0) {
            if (this.lJY == null && (LM = com.baidu.tieba.h.a.cPn().LM("6051001308-627527144")) != null && LM.size() > 0) {
                this.lJY = LM.get(0);
            }
            if (this.lJY != null && this.lJY.eWF != null && this.lJY.eWF.dOO() != null) {
                com.baidu.tbadk.core.util.x.add(arrayList, i, this.lJY);
            }
        }
        return this.lJY;
    }

    public void dot() {
        if (this.lJX > 0 && d(this.grW, this.lJX) != null) {
            this.lJX = -1;
            this.gAY.setData(this.grW);
            notifyDataSetChanged();
        }
    }

    private PostData bc(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dPe() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lHh);
        bz dmF = fVar.dmF();
        nVar.lHj = dmF != null ? dmF.bri() : 0L;
        nVar.isNew = !this.lJJ;
        nVar.lHm = this.lIN.dpx();
        nVar.sortType = fVar.lFR;
        nVar.lHl = fVar.dnj();
        nVar.isDynamic = fVar.dni();
        nVar.lHn = fVar.lFQ;
        com.baidu.tbadk.core.util.x.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.n b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lIN.dnW().dnP()) || !this.lIN.dnW().dqa())) {
            if (!this.lIN.dnO() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.dnc())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.dnc().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lIN.dnW().dpX();
            com.baidu.tbadk.core.util.x.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.lIN.dnW() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lIN.dnW().dpV())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.n> list) {
        if (!z && !z2) {
            if ((this.lJM || this.lJL) && i != -1 && !com.baidu.tbadk.core.util.x.isEmpty(list) && !this.lJN) {
                this.lJU = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gAY.setSelectionFromTop(g.this.gAY.getHeaderViewsCount() + list.size(), 0 - g.this.lJW);
                        g.this.lJN = false;
                    }
                };
                com.baidu.adp.lib.f.e.mB().post(this.lJU);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (postData == null) {
            if (this.lJQ != null && !this.lJL) {
                com.baidu.tbadk.core.util.x.add(arrayList, 0, this.lJQ);
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
        if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.dnh()) && fVar.dnh().size() > 2) {
            int min = Math.min(fVar.dnh().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.o oVar = fVar.dnh().get(i5);
                if (!z2 && i5 == 0) {
                    oVar.js(true);
                }
                if (oVar.brI() == null) {
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
        if (i < 0 || fVar == null || !fVar.lFV || fVar.lFW == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lFW;
        com.baidu.tbadk.core.util.x.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lJo.setData(fVar);
        this.lJo.setFromCDN(this.mIsFromCDN);
        this.lJo.setImageMaxWidth(this.lJP);
        this.lJo.uz(this.lJI);
        this.lJo.C(this.bdp);
        this.lJo.U(this.lJR);
        this.lJo.setOnImageClickListener(this.fWO);
        this.lJo.setOnLongClickListener(this.mOnLongClickListener);
        this.lJo.setTbGestureDetector(this.fyb);
        this.lJu.setData(fVar);
        this.lJu.setFromCDN(this.mIsFromCDN);
        this.lJu.hJ(this.blY);
        this.lJu.uz(this.lJI);
        this.lJu.C(this.bdp);
        this.lJu.U(this.lJR);
        this.lJu.setOnImageClickListener(this.fWO);
        this.lJu.setOnLongClickListener(this.mOnLongClickListener);
        this.lJu.setTbGestureDetector(this.fyb);
        this.lJp.setOnClickListener(this.bdp);
        this.lJD.setOnClickListener(this.bdp);
        this.lJv.setOnClickListener(this.lKa);
        if (this.lJx != null && (this.lJx instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lJx).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lJE.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.adapter.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.hJ(this.blY);
                next.setImageMaxWidth(this.lJP);
                next.uz(this.lJI);
                next.uA(this.lJJ);
                next.uB(this.lJO);
                next.C(this.bdp);
                next.U(this.lJR);
                next.setOnImageClickListener(this.fWO);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lJs.C(this.bdp);
        this.lJs.a(this.lJS);
        this.lJt.C(this.bdp);
        this.lJs.setData(fVar);
        this.lJr.setData(fVar);
        this.lJt.setData(fVar);
        this.lJA.setData(fVar);
        this.lJB.setData(fVar);
        this.lJF.setPbData(fVar);
        this.lJF.setFrom(this.lIN.lNM);
        this.lJG.setPbData(fVar);
    }

    private v a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.adp.widget.ListView.n nVar, int i, int i2) {
        v dmK = this.lJH.dmK();
        if (dmK != null) {
            if (nVar != null) {
                if (i2 < 0 && nVar.getType() != AdvertAppInfo.eNI) {
                    i2 = i + 2;
                } else if (nVar.getType() == AdvertAppInfo.eNI) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dmK instanceof v)) {
                com.baidu.tbadk.core.util.x.add(arrayList, i2, dmK);
                return dmK;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n e(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        PbModel dnW;
        if (i >= 0 && (dnW = this.lIN.dnW()) != null) {
            String dqO = dnW.dqO();
            if (TextUtils.isEmpty(dqO)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
            oVar.Tn(dqO);
            c(oVar);
            com.baidu.tbadk.core.util.x.add(arrayList, i + 1, oVar);
            return oVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n f(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        if (this.lJH == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.o dqm = this.lIN.dnW().dqm();
        if (dqm == null) {
            dqm = this.lJH.dmX();
        }
        if (dqm != null) {
            AdvertAppInfo.ILegoAdvert dOT = dqm.dOT();
            if (dOT != null) {
                dOT.setAdvertAppInfo(dqm.qU());
            }
            int bpf = dqm.dOS().bpf();
            if (bpf != 0) {
                com.baidu.tieba.recapp.report.d.a(dqm, bpf);
                if (bpf == 28 || bpf == 31 || dqm.dOS().goods == null) {
                    return null;
                }
                dqm.dOS().goods.goods_style = -1001;
                return null;
            }
            if (this.lJH.getForum() != null) {
                dqm.forumId = this.lJH.getForum().getId();
            }
            if (this.lJH.dmF() != null) {
                dqm.threadId = com.baidu.adp.lib.f.b.toLong(this.lJH.dmF().getId(), 0L);
            }
            if (this.lJH != null && this.lJH.getPage() != null) {
                dqm.pageNumber = this.lJH.getPage().bqe();
            }
            c(dqm);
            if (i >= 0) {
                com.baidu.tieba.lego.card.c.a.a(arrayList, dqm, i);
                return dqm;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (this.lJL || fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.dmH()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dnf() && this.lJJ) ? 0 : -1;
        } else if (this.lIN.dnW() == null || !this.lIN.dnW().getIsFromMark()) {
            if (this.lIN.doP() == null || !this.lIN.doP().dtb()) {
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
                        if (postData.dPe() == 1 && postData.nsb == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
                if (z) {
                    return i + 1;
                }
                return fVar.dnf() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.dmH()) || com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.x.getItem(fVar.dmH(), 0)) == null) {
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
                if (postData.dPe() == 1 && postData.nsb == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.dmH()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dnf()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dmH().get(0) == null || fVar.dmH().get(0).dPe() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.n> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dmT() == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.dmT().lHx)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dmT().lHx;
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.nso = true;
                postData.nsd = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.x.getCount(fVar.dmT().lHy) > 2) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (nVar instanceof PostData) {
                ((PostData) nVar).nsd = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).nsd = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar3 = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lHi);
        nVar3.lHk = fVar.dmT().forum_top_list;
        arrayList.add(0, nVar3);
        return arrayList;
    }

    private void cTn() {
        if (this.lIN != null && !cTo()) {
            this.lIN.registerListener(this.jCP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTo() {
        if (this.lIN == null) {
            return false;
        }
        this.jCN = new ArrayList();
        ArrayList<BdUniqueId> dOs = com.baidu.tieba.tbadkCore.v.dOs();
        if (dOs == null || dOs.size() <= 0) {
            return false;
        }
        int size = dOs.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.deN().a(this.lIN.getPageContext(), dOs.get(i), 2);
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
        if (fVar == null || fVar.dmH() == null || fVar.dmI() == null || fVar.dmH().size() == 0 || fVar.dmF() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dmI().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dmH().get(0) == null || fVar.dmH().get(0).dPe() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bqe() != fVar.getPage().bqb()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.dmH() == null || fVar.dmJ() == null || fVar.dmH().size() == 0 || fVar.dmF() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dmJ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dmH().get(0) == null || fVar.dmH().get(0).dPe() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bqe() != fVar.getPage().bqb()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.n getItem(int i) {
        return this.gAY.getItem(i);
    }

    public ArrayList<PostData> dou() {
        return this.postList;
    }

    public BdUniqueId GN(int i) {
        if (this.gAY.getItem(i) != null) {
            return this.gAY.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lJV = dov();
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public int dov() {
        if (this.gAY != null && this.gAY.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gAY.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n nVar = this.gAY.getData().get(i2);
                if (nVar == null || nVar.getType() != com.baidu.tieba.pb.data.n.lHh) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int dow() {
        return this.lJV;
    }

    private void dox() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lJH != null && !this.lJH.lGF && this.lJH.aas != 2) {
            ArrayList<PostData> dmH = this.lJH.dmH();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dmW = this.lJH.dmW();
            if (!com.baidu.tieba.lego.card.c.a.isEmpty(dmH) && !com.baidu.tieba.lego.card.c.a.isEmpty(dmW)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dmW.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dmW.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jCL = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dmW.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dOS() != null) {
                        int bpf = next3.dOS().bpf();
                        if (bpf != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, bpf);
                            if (bpf != 28 && bpf != 31) {
                                if (next3.dOS().goods != null) {
                                    next3.dOS().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dmW.clear();
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
                    if (this.lJH.getForum() != null) {
                        oVar4.forumId = this.lJH.getForum().getId();
                    }
                    if (this.lJH.dmF() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lJH.dmF().getId(), 0L);
                    }
                    if (this.lJH != null && this.lJH.getPage() != null) {
                        oVar4.pageNumber = this.lJH.getPage().bqe();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lJH.lGE;
                    if (position + i3 >= com.baidu.tieba.lego.card.c.a.eN(dmH)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, position, com.baidu.tieba.lego.card.c.a.eN(dmH));
                        return;
                    }
                    if (!this.lJJ) {
                        position--;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.c.a.a(dmH, oVar4, position);
                        TiebaStatic.eventStat(this.lIN.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dOS().apk_name);
                    }
                }
            }
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lJH != null && oVar.dOS() != null) {
            oVar.dOS().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lJH.getPage() != null) {
                oVar.dOS().advertAppContext.pn = this.lJH.getPage().bqe();
            }
            oVar.dOS().advertAppContext.page = oVar.dOV();
            if (this.lJH.getForum() != null && (forum = this.lJH.getForum()) != null) {
                oVar.dOS().advertAppContext.fid = forum.getId();
                oVar.dOS().advertAppContext.eNv = forum.getFirst_class();
                oVar.dOS().advertAppContext.eNw = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dOS().advertAppContext.eNx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dOS().advertAppContext.extensionInfo = oVar.dOS().ext_info;
            oVar.dOS().advertAppContext.aay = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lJo.setFromCDN(z);
        if (this.lJx != null && (this.lJx instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lJx).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lJE.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean doy() {
        return this.lJI;
    }

    public void uz(boolean z) {
        this.lJI = z;
    }

    public void uA(boolean z) {
        this.lJJ = z;
    }

    public void uB(boolean z) {
        this.lJO = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJR = onClickListener;
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
        this.lJS = aVar;
    }

    public void GO(int i) {
        switch (i) {
            case 1:
                if (this.lJo != null) {
                    this.lJo.pause();
                }
                if (this.lJx instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJx).onPause();
                }
                if (this.lJy instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJy).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lJo != null) {
                    this.lJo.resume();
                }
                if (this.lJx instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJx).onResume();
                }
                if (this.lJy instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJy).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lJo != null) {
                    this.lJo.release();
                }
                if (this.lJx instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJx).onDestroy();
                }
                if (this.lJy instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lJy).onDestroy();
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
                    if (!TextUtils.isEmpty(postData.bsD())) {
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.AP(postData.bsD());
                        list.set(i, amVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lJU);
        if (this.lJs != null) {
            this.lJs.onDestroy();
        }
        if (this.lJt != null) {
            this.lJt.onDestroy();
        }
        if (this.lJp != null) {
            this.lJp.onDestroy();
        }
        if (this.lJr != null) {
            this.lJr.onDestroy();
        }
    }

    public void uF(boolean z) {
        this.lJL = z;
    }

    public void uG(boolean z) {
        this.lJM = z;
    }

    public void uH(boolean z) {
        this.lJK = z;
    }

    public void uI(boolean z) {
        this.lJN = z;
    }

    public PbFirstFloorCommentAndPraiseAdapter doz() {
        return this.lJp;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.grW;
    }

    public View doA() {
        if (this.lJo == null || this.lJo.doE() == null) {
            return null;
        }
        if (this.lJo.doE().lMl != null && this.lJo.doE().lMl.isShown()) {
            return this.lJo.doE().lMl;
        }
        return this.lJo.doE().lMk;
    }

    public PbFirstFloorViewHolder doB() {
        if (this.lJo == null || this.lJo.doE() == null) {
            return null;
        }
        return this.lJo.doE();
    }
}
