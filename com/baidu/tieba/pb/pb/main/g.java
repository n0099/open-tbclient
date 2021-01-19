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
    private ArrayList<com.baidu.adp.widget.ListView.n> gnp;
    private BdTypeListView gwr;
    private List<com.baidu.adp.widget.ListView.a> jyh;
    private com.baidu.adp.widget.ListView.a kcC;
    private p lEK;
    private PbFirstFloorCommentAndPraiseAdapter lEL;
    private PbFirstFloorEnterForumAdapter lEM;
    private com.baidu.tieba.pb.pb.main.adapter.a lEN;
    private ak lEO;
    private ak lEP;
    private k lEQ;
    private com.baidu.tieba.pb.video.a lER;
    private com.baidu.tieba.card.divider.a lES;
    private com.baidu.adp.widget.ListView.a lET;
    private com.baidu.adp.widget.ListView.a lEU;
    private com.baidu.adp.widget.ListView.a lEV;
    private ah lEW;
    private ai lEX;
    private ag lEY;
    private PbReplyLoadMoreAdapter lEZ;
    private PbFragment lEi;
    private h lFb;
    private u lFc;
    private com.baidu.tieba.pb.data.f lFd;
    private boolean lFi;
    private boolean lFj;
    private int lFl;
    private Runnable lFq;
    private int lFs;
    private bz lFu;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.adapter.a> lFa = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lFe = true;
    private boolean lFf = true;
    private boolean lFg = false;
    private boolean lFh = false;
    private boolean lFk = false;
    private String bhj = null;
    private PostData lFm = null;
    private View.OnClickListener lFn = null;
    private View.OnClickListener aYB = null;
    private TbRichTextView.i fSh = null;
    private com.baidu.tieba.pb.a.c ftt = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lFo = null;
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lFp = new ArrayList();
    private int lFr = -1;
    private int lFt = -1;
    private final CustomMessageListener lFv = new CustomMessageListener(2921523) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.n)) {
                com.baidu.tieba.tbadkCore.data.n nVar = (com.baidu.tieba.tbadkCore.data.n) customResponsedMessage.getData();
                if (g.this.lFu != null && g.this.lFu.eRU == nVar) {
                    g.this.lFu.eRU.aR(null);
                    g.this.gwr.setData(g.this.gnp);
                    g.this.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener jju = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dKO = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dKO();
                Iterator it = dKO.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(g.this.lEi);
                        if (aVar instanceof com.baidu.tieba.pb.pb.adapter.a) {
                            g.this.lFa.add((com.baidu.tieba.pb.pb.adapter.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dKO);
                g.this.lFp.clear();
                g.this.lFp.addAll(arrayList);
                if (g.this.gwr != null) {
                    g.this.gwr.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener fqC = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.3
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.lFd != null && !com.baidu.adp.base.j.I(g.this.lEi.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener lFw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lEi != null && g.this.lFd != null && g.this.lFd.djb() != null) {
                g.this.lEi.dkW().dof().djZ();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12040"));
            }
        }
    };
    private CustomMessageListener jyj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.x.isEmpty(g.this.jyh)) {
                g.this.cPw();
                g.this.a(g.this.lFd, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lFl = 0;
        this.width = -1;
        this.lFs = 0;
        this.lFl = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lFl;
        this.lEi = pbFragment;
        this.gwr = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.fqC);
        this.lFs = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lEi.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lEK = new p(pbFragment, PostData.nmN);
        this.lEK.a((TbRichTextView.c) pbFragment);
        this.lEL = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, com.baidu.tieba.pb.data.o.lCJ);
        this.lEM = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lEN = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lAY);
        this.lEO = new ak(pbFragment, com.baidu.tieba.pb.data.n.lCC);
        this.lEP = new ak(pbFragment, com.baidu.tieba.pb.data.n.lCD);
        this.lEQ = new k(pbFragment, PostData.nmO);
        this.lEQ.a((TbRichTextView.c) pbFragment);
        this.kcC = com.baidu.tieba.recapp.r.dBe().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eIT);
        this.lET = com.baidu.tieba.recapp.r.dBe().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eIX);
        this.lEU = com.baidu.tieba.h.b.cLy().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eIY);
        this.lEV = com.baidu.tieba.h.b.cLy().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eIZ);
        this.lEY = new ag(pbFragment, com.baidu.tieba.pb.data.l.Yp);
        this.lEW = new ah(pbFragment, af.lOi);
        this.lEX = new ai(pbFragment, bb.eMw);
        this.lEZ = new PbReplyLoadMoreAdapter(pbFragment, PostData.nmS);
        this.lER = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.lZq);
        this.lES = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lFb = new h(pbFragment, com.baidu.tbadk.core.data.o.eKj);
        this.lFc = new u(pbFragment, pbFragment.getUniqueId());
        this.bjZ.add(this.lEK);
        this.bjZ.add(this.lEL);
        this.bjZ.add(this.lEM);
        this.bjZ.add(this.lEN);
        this.bjZ.add(this.lEQ);
        this.bjZ.add(this.lEO);
        this.bjZ.add(this.lEP);
        this.bjZ.add(this.kcC);
        this.bjZ.add(this.lET);
        this.bjZ.add(this.lEU);
        this.bjZ.add(this.lEV);
        this.bjZ.add(this.lEY);
        this.bjZ.add(this.lEW);
        this.bjZ.add(this.lEX);
        this.bjZ.add(this.lER);
        this.bjZ.add(this.lEZ);
        this.bjZ.add(this.lES);
        this.bjZ.add(this.lFb);
        this.bjZ.add(this.lFc);
        this.jju.setPriority(1);
        this.jju.setSelfListener(true);
        pbFragment.registerListener(this.jju);
        pbFragment.registerListener(this.lFv);
        cPv();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.bjZ);
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
            this.lFd = fVar;
            dkE();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lFd != null && this.lFd.diP() != null && this.lFd.diP().size() > 0) {
                this.postList.addAll(this.lFd.diP());
            }
            if (fVar.diN() != null && fVar.diN().bnx() != null) {
                this.bhj = fVar.diN().bnx().getUserId();
            }
            if (this.lEK != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>(fVar.diP());
                PostData aX = aX(arrayList);
                boolean z6 = aX != null;
                if (aX != null) {
                    this.lFm = aX;
                }
                boolean z7 = false;
                if (!this.lFf && aX != null) {
                    arrayList.remove(aX);
                    z7 = true;
                    z6 = true;
                    if (fVar.djn() && aX.dLo() != null) {
                        aX.c(null);
                    }
                }
                if (!z6 && fVar.diW() != null) {
                    aX = fVar.diW();
                    z7 = true;
                    z6 = true;
                    if (!this.lFf && fVar.djn() && aX.dLo() != null) {
                        aX.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aX;
                fn(arrayList);
                if (this.lEi.dlu()) {
                    if (fVar.diP().size() > 0 && (postData = fVar.diP().get(0)) != null && postData.dLm() == 1 && !com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b2 = b(this.lFd, arrayList, this.lFf);
                    if (b2 >= 0) {
                        com.baidu.tbadk.core.util.x.add(arrayList, b2, this.lFd.diQ());
                    }
                }
                int c = c(this.lFd, arrayList, this.lFf);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.x.add(arrayList, c, this.lFd.diR());
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
                        ((PostData) nVar2).nnz = true;
                    }
                    com.baidu.tbadk.core.util.x.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i2 = -1;
                if (z6) {
                    i2 = a(fVar, arrayList, this.lFf);
                }
                if (i2 >= 0 && fVar.djm() != null) {
                    com.baidu.tbadk.core.util.x.add(arrayList, i2, fVar.djm());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.nny = true;
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
                        this.lFt = i5;
                        if (d(arrayList, i5) != null) {
                            this.lFt = -1;
                            i4++;
                        }
                    }
                    if (!com.baidu.tbadk.a.d.biI() || !z12) {
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
                                vVar.lKZ = a4;
                            }
                        }
                        this.lEK.uI(z4);
                        boolean h = h(postData2);
                        if (this.lFg && !h) {
                            arrayList.remove(postData2);
                            this.lFg = false;
                        }
                        if (fVar.djm() != null) {
                            fVar.djm().uu(!z3);
                        }
                        if (this.gwr != null) {
                            this.gnp = arrayList;
                            this.gwr.setData(this.gnp);
                        }
                        a(h, z, a2, g);
                        if (!a(postData2, arrayList, z8)) {
                            this.gwr.setData(arrayList);
                            return;
                        }
                        return;
                    }
                }
                i = i5;
                z5 = z10;
                if (z6) {
                }
                this.lEK.uI(z4);
                boolean h2 = h(postData2);
                if (this.lFg) {
                    arrayList.remove(postData2);
                    this.lFg = false;
                }
                if (fVar.djm() != null) {
                }
                if (this.gwr != null) {
                }
                a(h2, z, a2, g);
                if (!a(postData2, arrayList, z8)) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.n d(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        List<bz> KD;
        if (com.baidu.tbadk.a.d.biI() && i > 0) {
            if (this.lFu == null && (KD = com.baidu.tieba.h.a.cLv().KD("6051001537-901554884")) != null && KD.size() > 0) {
                this.lFu = KD.get(0);
            }
            if (this.lFu != null && this.lFu.eRU != null && this.lFu.eRU.dKW() != null) {
                com.baidu.tbadk.core.util.x.add(arrayList, i, this.lFu);
            }
        }
        return this.lFu;
    }

    public void dkA() {
        if (this.lFt > 0 && d(this.gnp, this.lFt) != null) {
            this.lFt = -1;
            this.gwr.setData(this.gnp);
            notifyDataSetChanged();
        }
    }

    private PostData aX(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dLm() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCC);
        bz diN = fVar.diN();
        nVar.lCE = diN != null ? diN.bno() : 0L;
        nVar.isNew = !this.lFf;
        nVar.lCH = this.lEi.dlE();
        nVar.sortType = fVar.lBm;
        nVar.lCG = fVar.djr();
        nVar.isDynamic = fVar.djq();
        nVar.lCI = fVar.lBl;
        com.baidu.tbadk.core.util.x.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.n b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lEi.dkd().djW()) || !this.lEi.dkd().dmh())) {
            if (!this.lEi.djV() && !com.baidu.tbadk.core.util.x.isEmpty(fVar.djk())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.djk().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lEi.dkd().dme();
            com.baidu.tbadk.core.util.x.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.lEi.dkd() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lEi.dkd().dmc())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.n> list) {
        if (!z && !z2) {
            if ((this.lFi || this.lFh) && i != -1 && !com.baidu.tbadk.core.util.x.isEmpty(list) && !this.lFj) {
                this.lFq = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gwr.setSelectionFromTop(g.this.gwr.getHeaderViewsCount() + list.size(), 0 - g.this.lFs);
                        g.this.lFj = false;
                    }
                };
                com.baidu.adp.lib.f.e.mB().post(this.lFq);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (postData == null) {
            if (this.lFm != null && !this.lFh) {
                com.baidu.tbadk.core.util.x.add(arrayList, 0, this.lFm);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.Jk(1);
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
        if (!com.baidu.tbadk.core.util.x.isEmpty(fVar.djp()) && fVar.djp().size() > 2) {
            int min = Math.min(fVar.djp().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.o oVar = fVar.djp().get(i5);
                if (!z2 && i5 == 0) {
                    oVar.jo(true);
                }
                if (oVar.bnO() == null) {
                    if (i5 == min - 1) {
                        oVar.jp(true);
                    }
                } else if (i5 == min - 2) {
                    oVar.jp(true);
                } else if (i5 == min - 1) {
                    oVar.jq(true);
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
        if (i < 0 || fVar == null || !fVar.lBq || fVar.lBr == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lBr;
        com.baidu.tbadk.core.util.x.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lEK.setData(fVar);
        this.lEK.setFromCDN(this.mIsFromCDN);
        this.lEK.setImageMaxWidth(this.lFl);
        this.lEK.uv(this.lFe);
        this.lEK.C(this.aYB);
        this.lEK.U(this.lFn);
        this.lEK.setOnImageClickListener(this.fSh);
        this.lEK.setOnLongClickListener(this.mOnLongClickListener);
        this.lEK.setTbGestureDetector(this.ftt);
        this.lEQ.setData(fVar);
        this.lEQ.setFromCDN(this.mIsFromCDN);
        this.lEQ.gy(this.bhj);
        this.lEQ.uv(this.lFe);
        this.lEQ.C(this.aYB);
        this.lEQ.U(this.lFn);
        this.lEQ.setOnImageClickListener(this.fSh);
        this.lEQ.setOnLongClickListener(this.mOnLongClickListener);
        this.lEQ.setTbGestureDetector(this.ftt);
        this.lEL.setOnClickListener(this.aYB);
        this.lEZ.setOnClickListener(this.aYB);
        this.lER.setOnClickListener(this.lFw);
        if (this.lET != null && (this.lET instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lET).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lFa.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.adapter.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.gy(this.bhj);
                next.setImageMaxWidth(this.lFl);
                next.uv(this.lFe);
                next.uw(this.lFf);
                next.ux(this.lFk);
                next.C(this.aYB);
                next.U(this.lFn);
                next.setOnImageClickListener(this.fSh);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lEO.C(this.aYB);
        this.lEO.a(this.lFo);
        this.lEP.C(this.aYB);
        this.lEO.setData(fVar);
        this.lEN.setData(fVar);
        this.lEP.setData(fVar);
        this.lEW.setData(fVar);
        this.lEX.setData(fVar);
        this.lFb.setPbData(fVar);
        this.lFb.setFrom(this.lEi.lJi);
        this.lFc.setPbData(fVar);
    }

    private v a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.adp.widget.ListView.n nVar, int i, int i2) {
        v diS = this.lFd.diS();
        if (diS != null) {
            if (nVar != null) {
                if (i2 < 0 && nVar.getType() != AdvertAppInfo.eIX) {
                    i2 = i + 2;
                } else if (nVar.getType() == AdvertAppInfo.eIX) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (diS instanceof v)) {
                com.baidu.tbadk.core.util.x.add(arrayList, i2, diS);
                return diS;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n e(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        PbModel dkd;
        if (i >= 0 && (dkd = this.lEi.dkd()) != null) {
            String dmV = dkd.dmV();
            if (TextUtils.isEmpty(dmV)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
            oVar.Sg(dmV);
            c(oVar);
            com.baidu.tbadk.core.util.x.add(arrayList, i + 1, oVar);
            return oVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n f(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        if (this.lFd == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.o dmt = this.lEi.dkd().dmt();
        if (dmt == null) {
            dmt = this.lFd.djf();
        }
        if (dmt != null) {
            AdvertAppInfo.ILegoAdvert dLb = dmt.dLb();
            if (dLb != null) {
                dLb.setAdvertAppInfo(dmt.qU());
            }
            int bll = dmt.dLa().bll();
            if (bll != 0) {
                com.baidu.tieba.recapp.report.d.a(dmt, bll);
                if (bll == 28 || bll == 31 || dmt.dLa().goods == null) {
                    return null;
                }
                dmt.dLa().goods.goods_style = -1001;
                return null;
            }
            if (this.lFd.getForum() != null) {
                dmt.forumId = this.lFd.getForum().getId();
            }
            if (this.lFd.diN() != null) {
                dmt.threadId = com.baidu.adp.lib.f.b.toLong(this.lFd.diN().getId(), 0L);
            }
            if (this.lFd != null && this.lFd.getPage() != null) {
                dmt.pageNumber = this.lFd.getPage().bmk();
            }
            c(dmt);
            if (i >= 0) {
                com.baidu.tieba.lego.card.c.a.a(arrayList, dmt, i);
                return dmt;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (this.lFh || fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.diP()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.djn() && this.lFf) ? 0 : -1;
        } else if (this.lEi.dkd() == null || !this.lEi.dkd().getIsFromMark()) {
            if (this.lEi.dkW() == null || !this.lEi.dkW().dpj()) {
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
                        if (postData.dLm() == 1 && postData.nnv == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
                if (z) {
                    return i + 1;
                }
                return fVar.djn() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.diP()) || com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.x.getItem(fVar.diP(), 0)) == null) {
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
                if (postData.dLm() == 1 && postData.nnv == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.diP()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.djn()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.diP().get(0) == null || fVar.diP().get(0).dLm() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.n> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.djb() == null || com.baidu.tbadk.core.util.x.isEmpty(fVar.djb().lCS)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.djb().lCS;
        if (com.baidu.tbadk.core.util.x.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.nnI = true;
                postData.nnx = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.x.getCount(fVar.djb().lCT) > 2) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (nVar instanceof PostData) {
                ((PostData) nVar).nnx = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, arrayList.size() - 1);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).nnx = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar3 = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCD);
        nVar3.lCF = fVar.djb().forum_top_list;
        arrayList.add(0, nVar3);
        return arrayList;
    }

    private void cPv() {
        if (this.lEi != null && !cPw()) {
            this.lEi.registerListener(this.jyj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPw() {
        if (this.lEi == null) {
            return false;
        }
        this.jyh = new ArrayList();
        ArrayList<BdUniqueId> dKA = com.baidu.tieba.tbadkCore.v.dKA();
        if (dKA == null || dKA.size() <= 0) {
            return false;
        }
        int size = dKA.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.daV().a(this.lEi.getPageContext(), dKA.get(i), 2);
            if (a2 != null) {
                this.bjZ.add(a2);
                this.jyh.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.jyh)) {
            this.gwr.addAdapters(this.jyh);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.gwr.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.diP() == null || fVar.diQ() == null || fVar.diP().size() == 0 || fVar.diN() == null || arrayList == null) {
            return -1;
        }
        if (fVar.diQ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.diP().get(0) == null || fVar.diP().get(0).dLm() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bmk() != fVar.getPage().bmh()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.diP() == null || fVar.diR() == null || fVar.diP().size() == 0 || fVar.diN() == null || arrayList == null) {
            return -1;
        }
        if (fVar.diR().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.diP().get(0) == null || fVar.diP().get(0).dLm() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bmk() != fVar.getPage().bmh()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.n getItem(int i) {
        return this.gwr.getItem(i);
    }

    public ArrayList<PostData> dkB() {
        return this.postList;
    }

    public BdUniqueId Fh(int i) {
        if (this.gwr.getItem(i) != null) {
            return this.gwr.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lFr = dkC();
        if (this.gwr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }

    public int dkC() {
        if (this.gwr != null && this.gwr.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gwr.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n nVar = this.gwr.getData().get(i2);
                if (nVar == null || nVar.getType() != com.baidu.tieba.pb.data.n.lCC) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int dkD() {
        return this.lFr;
    }

    private void dkE() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lFd != null && !this.lFd.lCa && this.lFd.aaq != 2) {
            ArrayList<PostData> diP = this.lFd.diP();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dje = this.lFd.dje();
            if (!com.baidu.tieba.lego.card.c.a.isEmpty(diP) && !com.baidu.tieba.lego.card.c.a.isEmpty(dje)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dje.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dje.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jyf = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dje.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dLa() != null) {
                        int bll = next3.dLa().bll();
                        if (bll != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, bll);
                            if (bll != 28 && bll != 31) {
                                if (next3.dLa().goods != null) {
                                    next3.dLa().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dje.clear();
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
                    if (this.lFd.getForum() != null) {
                        oVar4.forumId = this.lFd.getForum().getId();
                    }
                    if (this.lFd.diN() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lFd.diN().getId(), 0L);
                    }
                    if (this.lFd != null && this.lFd.getPage() != null) {
                        oVar4.pageNumber = this.lFd.getPage().bmk();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lFd.lBZ;
                    if (position + i3 >= com.baidu.tieba.lego.card.c.a.eN(diP)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, position, com.baidu.tieba.lego.card.c.a.eN(diP));
                        return;
                    }
                    if (!this.lFf) {
                        position--;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.c.a.a(diP, oVar4, position);
                        TiebaStatic.eventStat(this.lEi.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dLa().apk_name);
                    }
                }
            }
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lFd != null && oVar.dLa() != null) {
            oVar.dLa().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lFd.getPage() != null) {
                oVar.dLa().advertAppContext.pn = this.lFd.getPage().bmk();
            }
            oVar.dLa().advertAppContext.page = oVar.dLd();
            if (this.lFd.getForum() != null && (forum = this.lFd.getForum()) != null) {
                oVar.dLa().advertAppContext.fid = forum.getId();
                oVar.dLa().advertAppContext.eIK = forum.getFirst_class();
                oVar.dLa().advertAppContext.eIL = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dLa().advertAppContext.eIM = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dLa().advertAppContext.extensionInfo = oVar.dLa().ext_info;
            oVar.dLa().advertAppContext.aaw = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lEK.setFromCDN(z);
        if (this.lET != null && (this.lET instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.lET).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lFa.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean dkF() {
        return this.lFe;
    }

    public void uv(boolean z) {
        this.lFe = z;
    }

    public void uw(boolean z) {
        this.lFf = z;
    }

    public void ux(boolean z) {
        this.lFk = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lFn = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fSh = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.ftt = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lFo = aVar;
    }

    public void Fi(int i) {
        switch (i) {
            case 1:
                if (this.lEK != null) {
                    this.lEK.pause();
                }
                if (this.lET instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lET).onPause();
                }
                if (this.lEU instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lEU).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lEK != null) {
                    this.lEK.resume();
                }
                if (this.lET instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lET).onResume();
                }
                if (this.lEU instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lEU).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lEK != null) {
                    this.lEK.release();
                }
                if (this.lET instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lET).onDestroy();
                }
                if (this.lEU instanceof com.baidu.tieba.recapp.k) {
                    ((com.baidu.tieba.recapp.k) this.lEU).onDestroy();
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
                    if (!TextUtils.isEmpty(postData.boJ())) {
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        amVar.zE(postData.boJ());
                        list.set(i, amVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lFq);
        if (this.lEO != null) {
            this.lEO.onDestroy();
        }
        if (this.lEP != null) {
            this.lEP.onDestroy();
        }
        if (this.lEL != null) {
            this.lEL.onDestroy();
        }
        if (this.lEN != null) {
            this.lEN.onDestroy();
        }
    }

    public void uB(boolean z) {
        this.lFh = z;
    }

    public void uC(boolean z) {
        this.lFi = z;
    }

    public void uD(boolean z) {
        this.lFg = z;
    }

    public void uE(boolean z) {
        this.lFj = z;
    }

    public PbFirstFloorCommentAndPraiseAdapter dkG() {
        return this.lEL;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.gnp;
    }

    public View dkH() {
        if (this.lEK == null || this.lEK.dkL() == null) {
            return null;
        }
        if (this.lEK.dkL().lHH != null && this.lEK.dkL().lHH.isShown()) {
            return this.lEK.dkL().lHH;
        }
        return this.lEK.dkL().lHG;
    }

    public PbFirstFloorViewHolder dkI() {
        if (this.lEK == null || this.lEK.dkL() == null) {
            return null;
        }
        return this.lEK.dkL();
    }
}
