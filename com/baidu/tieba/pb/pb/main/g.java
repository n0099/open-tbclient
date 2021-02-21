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
    private ArrayList<com.baidu.adp.widget.ListView.n> gqm;
    private BdTypeListView gzp;
    private List<com.baidu.adp.widget.ListView.a> jEa;
    private com.baidu.adp.widget.ListView.a kla;
    private p lNO;
    private PbFirstFloorCommentAndPraiseAdapter lNP;
    private PbFirstFloorEnterForumAdapter lNQ;
    private PbFirstFloorItemAdapter lNR;
    private com.baidu.tieba.pb.pb.main.adapter.a lNS;
    private ak lNT;
    private ak lNU;
    private k lNV;
    private com.baidu.tieba.pb.video.a lNW;
    private com.baidu.tieba.card.divider.a lNX;
    private com.baidu.adp.widget.ListView.a lNY;
    private com.baidu.adp.widget.ListView.a lNZ;
    private PbFragment lNm;
    private com.baidu.adp.widget.ListView.a lOa;
    private ah lOb;
    private ai lOc;
    private ag lOd;
    private PbReplyLoadMoreAdapter lOe;
    private h lOg;
    private u lOh;
    private com.baidu.tieba.pb.data.f lOi;
    private boolean lOn;
    private boolean lOo;
    private int lOq;
    private Runnable lOv;
    private int lOx;
    private cb lOz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.adapter.a> lOf = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lOj = true;
    private boolean lOk = true;
    private boolean lOl = false;
    private boolean lOm = false;
    private boolean lOp = false;
    private String bkB = null;
    private PostData lOr = null;
    private View.OnClickListener lOs = null;
    private View.OnClickListener bbI = null;
    private TbRichTextView.i fUw = null;
    private com.baidu.tieba.pb.a.c fvK = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lOt = null;
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lOu = new ArrayList();
    private int lOw = -1;
    private int lOy = -1;
    private final CustomMessageListener lOA = new CustomMessageListener(2921523) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.n)) {
                com.baidu.tieba.tbadkCore.data.n nVar = (com.baidu.tieba.tbadkCore.data.n) customResponsedMessage.getData();
                if (g.this.lOz != null && g.this.lOz.eUi == nVar) {
                    g.this.lOz.eUi.aR(null);
                    g.this.gzp.setData(g.this.gqm);
                    g.this.notifyDataSetChanged();
                }
            }
        }
    };
    private CustomMessageListener jpp = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dNh = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dNh();
                Iterator it = dNh.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof l) {
                        ((l) aVar).a(g.this.lNm);
                        if (aVar instanceof com.baidu.tieba.pb.pb.adapter.a) {
                            g.this.lOf.add((com.baidu.tieba.pb.pb.adapter.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dNh);
                g.this.lOu.clear();
                g.this.lOu.addAll(arrayList);
                if (g.this.gzp != null) {
                    g.this.gzp.addAdapters(arrayList);
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
            if (customResponsedMessage != null && g.this.lOi != null && !com.baidu.adp.base.j.I(g.this.lNm.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener lOB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lNm != null && g.this.lOi != null && g.this.lOi.dlu() != null) {
                g.this.lNm.dnr().dqA().dmt();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12040"));
            }
        }
    };
    private CustomMessageListener jEc = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.jEa)) {
                g.this.cRC();
                g.this.a(g.this.lOi, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lOq = 0;
        this.width = -1;
        this.lOx = 0;
        this.lOq = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lOq;
        this.lNm = pbFragment;
        this.gzp = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.fsV);
        this.lOx = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lNm.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lNO = new p(pbFragment, PostData.nwX);
        this.lNO.a((TbRichTextView.c) pbFragment);
        this.lNP = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, com.baidu.tieba.pb.data.p.lLM);
        this.lNQ = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lNR = new PbFirstFloorItemAdapter(pbFragment.getContext(), com.baidu.tieba.pb.data.i.TYPE);
        this.lNS = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lJZ);
        this.lNT = new ak(pbFragment, com.baidu.tieba.pb.data.o.lLF);
        this.lNU = new ak(pbFragment, com.baidu.tieba.pb.data.o.lLG);
        this.lNV = new k(pbFragment, PostData.nwY);
        this.lNV.a((TbRichTextView.c) pbFragment);
        this.kla = com.baidu.tieba.recapp.s.dDt().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eLf);
        this.lNY = com.baidu.tieba.recapp.s.dDt().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eLj);
        this.lNZ = com.baidu.tieba.h.b.cNt().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eLk);
        this.lOa = com.baidu.tieba.h.b.cNt().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eLl);
        this.lOd = new ag(pbFragment, com.baidu.tieba.pb.data.m.Yl);
        this.lOb = new ah(pbFragment, af.lXt);
        this.lOc = new ai(pbFragment, bd.eOI);
        this.lOe = new PbReplyLoadMoreAdapter(pbFragment, PostData.nxc);
        this.lNW = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.miM);
        this.lNX = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lOg = new h(pbFragment, com.baidu.tbadk.core.data.p.eMv);
        this.lOh = new u(pbFragment, pbFragment.getUniqueId());
        this.bns.add(this.lNO);
        this.bns.add(this.lNP);
        this.bns.add(this.lNQ);
        this.bns.add(this.lNR);
        this.bns.add(this.lNS);
        this.bns.add(this.lNV);
        this.bns.add(this.lNT);
        this.bns.add(this.lNU);
        this.bns.add(this.kla);
        this.bns.add(this.lNY);
        this.bns.add(this.lNZ);
        this.bns.add(this.lOa);
        this.bns.add(this.lOd);
        this.bns.add(this.lOb);
        this.bns.add(this.lOc);
        this.bns.add(this.lNW);
        this.bns.add(this.lOe);
        this.bns.add(this.lNX);
        this.bns.add(this.lOg);
        this.bns.add(this.lOh);
        this.jpp.setPriority(1);
        this.jpp.setSelfListener(true);
        pbFragment.registerListener(this.jpp);
        pbFragment.registerListener(this.lOA);
        cRB();
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
            this.lOi = fVar;
            dmY();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lOi != null && this.lOi.dli() != null && this.lOi.dli().size() > 0) {
                this.postList.addAll(this.lOi.dli());
            }
            if (fVar.dlg() != null && fVar.dlg().bnQ() != null) {
                this.bkB = fVar.dlg().bnQ().getUserId();
            }
            if (this.lNO != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>(fVar.dli());
                PostData aW = aW(arrayList);
                boolean z6 = aW != null;
                if (aW != null) {
                    this.lOr = aW;
                }
                boolean z7 = false;
                if (!this.lOk && aW != null) {
                    arrayList.remove(aW);
                    z7 = true;
                    z6 = true;
                    if (fVar.dlG() && aW.dNH() != null) {
                        aW.c(null);
                    }
                }
                if (!z6 && fVar.dlp() != null) {
                    aW = fVar.dlp();
                    z7 = true;
                    z6 = true;
                    if (!this.lOk && fVar.dlG() && aW.dNH() != null) {
                        aW.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aW;
                fl(arrayList);
                if (this.lNm.dnQ()) {
                    if (fVar.dli().size() > 0 && (postData = fVar.dli().get(0)) != null && postData.dNF() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b2 = b(this.lOi, arrayList, this.lOk);
                    if (b2 >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b2, this.lOi.dlj());
                    }
                }
                int c = c(this.lOi, arrayList, this.lOk);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.lOi.dlk());
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
                        ((PostData) nVar2).nxJ = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i2 = -1;
                if (z6) {
                    i2 = a(fVar, arrayList, this.lOk);
                }
                if (i2 >= 0 && fVar.dlF() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i2, fVar.dlF());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.nxI = true;
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
                        this.lOy = i5;
                        if (d(arrayList, i5) != null) {
                            this.lOy = -1;
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
                                vVar.lUk = a4;
                            }
                        }
                        this.lNO.uX(z4);
                        boolean h = h(postData2);
                        if (this.lOl && !h) {
                            arrayList.remove(postData2);
                            this.lOl = false;
                        }
                        if (fVar.dlF() != null) {
                            fVar.dlF().uH(!z3);
                        }
                        if (this.gzp != null) {
                            this.gqm = arrayList;
                            this.gzp.setData(this.gqm);
                        }
                        a(h, z, a2, g);
                        if (!a(postData2, arrayList, z8)) {
                            this.gzp.setData(arrayList);
                            return;
                        }
                        return;
                    }
                }
                i = i5;
                z5 = z11;
                if (z6) {
                }
                this.lNO.uX(z4);
                boolean h2 = h(postData2);
                if (this.lOl) {
                    arrayList.remove(postData2);
                    this.lOl = false;
                }
                if (fVar.dlF() != null) {
                }
                if (this.gzp != null) {
                }
                a(h2, z, a2, g);
                if (!a(postData2, arrayList, z8)) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.n d(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        List<cb> Lr;
        if (com.baidu.tbadk.a.d.biU() && i > 0) {
            if (this.lOz == null && (Lr = com.baidu.tieba.h.a.cNq().Lr("6051001641-1251655838")) != null && Lr.size() > 0) {
                this.lOz = Lr.get(0);
            }
            if (this.lOz != null && this.lOz.eUi != null && this.lOz.eUi.dNp() != null) {
                com.baidu.tbadk.core.util.y.add(arrayList, i, this.lOz);
            }
        }
        return this.lOz;
    }

    public void dmU() {
        if (this.lOy > 0 && d(this.gqm, this.lOy) != null) {
            this.lOy = -1;
            this.gzp.setData(this.gqm);
            notifyDataSetChanged();
        }
    }

    private PostData aW(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dNF() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLF);
        cb dlg = fVar.dlg();
        oVar.lLH = dlg != null ? dlg.bnH() : 0L;
        oVar.isNew = !this.lOk;
        oVar.lLK = this.lNm.doa();
        oVar.sortType = fVar.lKn;
        oVar.lLJ = fVar.dlK();
        oVar.isDynamic = fVar.dlJ();
        oVar.lLL = fVar.lKm;
        com.baidu.tbadk.core.util.y.add(arrayList, i, oVar);
    }

    private com.baidu.adp.widget.ListView.n b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lNm.dmx().dmq()) || !this.lNm.dmx().doD())) {
            if (!this.lNm.dmp() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlD())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.dlD().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lNm.dmx().doA();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n a(com.baidu.tieba.pb.data.f fVar, PostData postData, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        com.baidu.tieba.pb.data.i iVar = null;
        if (fVar.getForum() == null || StringUtils.isNull(fVar.getForum().getName()) || !TextUtils.equals(fVar.getForum().getName(), this.lNm.dmx().dmq()) || !this.lNm.dmx().doD()) {
            if (postData != null) {
                if (postData.nxY != null) {
                    iVar = new com.baidu.tieba.pb.data.i(postData.nxY);
                }
            } else if (this.lOr != null && this.lOr.nxY != null) {
                iVar = new com.baidu.tieba.pb.data.i(this.lOr.nxY);
            }
            if (iVar != null) {
                iVar.tid = this.lNm.dmx().doA();
                com.baidu.tbadk.core.util.y.add(arrayList, i + 1, iVar);
            }
        }
        return iVar;
    }

    private boolean h(PostData postData) {
        return (this.lNm.dmx() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lNm.dmx().doy())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.n> list) {
        if (!z && !z2) {
            if ((this.lOn || this.lOm) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.lOo) {
                this.lOv = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.5
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gzp.setSelectionFromTop(g.this.gzp.getHeaderViewsCount() + list.size(), 0 - g.this.lOx);
                        g.this.lOo = false;
                    }
                };
                com.baidu.adp.lib.f.e.mA().post(this.lOv);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (postData == null) {
            if (this.lOr != null && !this.lOm) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.lOr);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.dlI()) && fVar.dlI().size() > 2) {
            int min = Math.min(fVar.dlI().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.p pVar = fVar.dlI().get(i5);
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
        if (i < 0 || fVar == null || !fVar.lKr || fVar.lKs == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lKs;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lNO.setData(fVar);
        this.lNO.setFromCDN(this.mIsFromCDN);
        this.lNO.setImageMaxWidth(this.lOq);
        this.lNO.uJ(this.lOj);
        this.lNO.C(this.bbI);
        this.lNO.U(this.lOs);
        this.lNO.setOnImageClickListener(this.fUw);
        this.lNO.setOnLongClickListener(this.mOnLongClickListener);
        this.lNO.setTbGestureDetector(this.fvK);
        this.lNV.setData(fVar);
        this.lNV.setFromCDN(this.mIsFromCDN);
        this.lNV.gW(this.bkB);
        this.lNV.uJ(this.lOj);
        this.lNV.C(this.bbI);
        this.lNV.U(this.lOs);
        this.lNV.setOnImageClickListener(this.fUw);
        this.lNV.setOnLongClickListener(this.mOnLongClickListener);
        this.lNV.setTbGestureDetector(this.fvK);
        this.lNP.setOnClickListener(this.bbI);
        this.lOe.setOnClickListener(this.bbI);
        this.lNW.setOnClickListener(this.lOB);
        if (this.lNY != null && (this.lNY instanceof com.baidu.tieba.recapp.p)) {
            ((com.baidu.tieba.recapp.p) this.lNY).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lOf.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.adapter.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.gW(this.bkB);
                next.setImageMaxWidth(this.lOq);
                next.uJ(this.lOj);
                next.uK(this.lOk);
                next.uL(this.lOp);
                next.C(this.bbI);
                next.U(this.lOs);
                next.setOnImageClickListener(this.fUw);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lNT.C(this.bbI);
        this.lNT.a(this.lOt);
        this.lNU.C(this.bbI);
        this.lNT.setData(fVar);
        this.lNS.setData(fVar);
        this.lNU.setData(fVar);
        this.lOb.setData(fVar);
        this.lOc.setData(fVar);
        this.lOg.setPbData(fVar);
        this.lOg.setFrom(this.lNm.lSu);
        this.lOh.setPbData(fVar);
    }

    private v a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.adp.widget.ListView.n nVar, int i, int i2) {
        v dll = this.lOi.dll();
        if (dll != null) {
            if (nVar != null) {
                if (i2 < 0 && nVar.getType() != AdvertAppInfo.eLj) {
                    i2 = i + 2;
                } else if (nVar.getType() == AdvertAppInfo.eLj) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dll instanceof v)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, dll);
                return dll;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n e(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        PbModel dmx;
        if (i >= 0 && (dmx = this.lNm.dmx()) != null) {
            String dpr = dmx.dpr();
            if (TextUtils.isEmpty(dpr)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.o oVar = new com.baidu.tieba.tbadkCore.data.o();
            oVar.Tp(dpr);
            c(oVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, oVar);
            return oVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.n f(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, int i) {
        if (this.lOi == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.o doP = this.lNm.dmx().doP();
        if (doP == null) {
            doP = this.lOi.dly();
        }
        if (doP != null) {
            AdvertAppInfo.ILegoAdvert dNu = doP.dNu();
            if (dNu != null) {
                dNu.setAdvertAppInfo(doP.qS());
            }
            int blD = doP.dNt().blD();
            if (blD != 0) {
                com.baidu.tieba.recapp.report.d.a(doP, blD);
                if (blD == 28 || blD == 31 || doP.dNt().goods == null) {
                    return null;
                }
                doP.dNt().goods.goods_style = -1001;
                return null;
            }
            if (this.lOi.getForum() != null) {
                doP.forumId = this.lOi.getForum().getId();
            }
            if (this.lOi.dlg() != null) {
                doP.threadId = com.baidu.adp.lib.f.b.toLong(this.lOi.dlg().getId(), 0L);
            }
            if (this.lOi != null && this.lOi.getPage() != null) {
                doP.pageNumber = this.lOi.getPage().bmD();
            }
            c(doP);
            if (i >= 0) {
                com.baidu.tieba.lego.card.c.a.a(arrayList, doP, i);
                return doP;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (this.lOm || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dli()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.dlG() && this.lOk) ? 0 : -1;
        } else if (this.lNm.dmx() == null || !this.lNm.dmx().getIsFromMark()) {
            if (this.lNm.dnr() == null || !this.lNm.dnr().drE()) {
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
                        if (postData.dNF() == 1 && postData.nxF == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                }
                if (z) {
                    return i + 1;
                }
                return fVar.dlG() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        boolean z;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dli()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dli(), 0)) == null) {
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
                if (postData.dNF() == 1 && postData.nxF == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dli()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.dlG()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dli().get(0) == null || fVar.dli().get(0).dNF() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.n> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.dlu() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dlu().lLW)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.dlu().lLW;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.nxS = true;
                postData.nxH = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.dlu().lLX) > 2) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (nVar instanceof PostData) {
                ((PostData) nVar).nxH = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).nxH = true;
            }
        }
        com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLG);
        oVar.lLI = fVar.dlu().forum_top_list;
        arrayList.add(0, oVar);
        return arrayList;
    }

    private void cRB() {
        if (this.lNm != null && !cRC()) {
            this.lNm.registerListener(this.jEc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRC() {
        if (this.lNm == null) {
            return false;
        }
        this.jEa = new ArrayList();
        ArrayList<BdUniqueId> dMT = com.baidu.tieba.tbadkCore.v.dMT();
        if (dMT == null || dMT.size() <= 0) {
            return false;
        }
        int size = dMT.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.dda().a(this.lNm.getPageContext(), dMT.get(i), 2);
            if (a2 != null) {
                this.bns.add(a2);
                this.jEa.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jEa)) {
            this.gzp.addAdapters(this.jEa);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.gzp.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.dli() == null || fVar.dlj() == null || fVar.dli().size() == 0 || fVar.dlg() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dlj().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dli().get(0) == null || fVar.dli().get(0).dNF() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bmD() != fVar.getPage().bmA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, boolean z) {
        if (fVar == null || fVar.dli() == null || fVar.dlk() == null || fVar.dli().size() == 0 || fVar.dlg() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dlk().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dli().get(0) == null || fVar.dli().get(0).dNF() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().bmD() != fVar.getPage().bmA()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.n getItem(int i) {
        return this.gzp.getItem(i);
    }

    public ArrayList<PostData> dmV() {
        return this.postList;
    }

    public BdUniqueId FA(int i) {
        if (this.gzp.getItem(i) != null) {
            return this.gzp.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lOw = dmW();
        if (this.gzp.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }

    public int dmW() {
        if (this.gzp != null && this.gzp.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gzp.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n nVar = this.gzp.getData().get(i2);
                if (nVar == null || nVar.getType() != com.baidu.tieba.pb.data.o.lLF) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int dmX() {
        return this.lOw;
    }

    private void dmY() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lOi != null && !this.lOi.lLb && this.lOi.aam != 2) {
            ArrayList<PostData> dli = this.lOi.dli();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dlx = this.lOi.dlx();
            if (!com.baidu.tieba.lego.card.c.a.isEmpty(dli) && !com.baidu.tieba.lego.card.c.a.isEmpty(dlx)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dlx.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dlx.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jDY = sb.toString();
                        next2.position = next2.getPosition() - 1;
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dlx.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dNt() != null) {
                        int blD = next3.dNt().blD();
                        if (blD != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, blD);
                            if (blD != 28 && blD != 31) {
                                if (next3.dNt().goods != null) {
                                    next3.dNt().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                dlx.clear();
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
                    if (this.lOi.getForum() != null) {
                        oVar4.forumId = this.lOi.getForum().getId();
                    }
                    if (this.lOi.dlg() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lOi.dlg().getId(), 0L);
                    }
                    if (this.lOi != null && this.lOi.getPage() != null) {
                        oVar4.pageNumber = this.lOi.getPage().bmD();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lOi.lLa;
                    if (position >= com.baidu.tieba.lego.card.c.a.eL(dli)) {
                        oVar4.position = position;
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, position, com.baidu.tieba.lego.card.c.a.eL(dli));
                        return;
                    }
                    if (!this.lOk) {
                        position--;
                        oVar4.position = position;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.c.a.a(dli, oVar4, position);
                        TiebaStatic.eventStat(this.lNm.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dNt().apk_name);
                    }
                }
            }
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lOi != null && oVar.dNt() != null) {
            oVar.dNt().advertAppContext = new com.baidu.tbadk.core.data.d();
            if (this.lOi.getPage() != null) {
                oVar.dNt().advertAppContext.pn = this.lOi.getPage().bmD();
            }
            oVar.dNt().advertAppContext.page = oVar.dNw();
            if (this.lOi.getForum() != null && (forum = this.lOi.getForum()) != null) {
                oVar.dNt().advertAppContext.fid = forum.getId();
                oVar.dNt().advertAppContext.eKW = forum.getFirst_class();
                oVar.dNt().advertAppContext.eKX = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dNt().advertAppContext.eKY = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dNt().advertAppContext.extensionInfo = oVar.dNt().ext_info;
            oVar.dNt().advertAppContext.aas = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lNO.setFromCDN(z);
        if (this.lNY != null && (this.lNY instanceof com.baidu.tieba.recapp.p)) {
            ((com.baidu.tieba.recapp.p) this.lNY).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.adapter.a> it = this.lOf.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean dmZ() {
        return this.lOj;
    }

    public void uJ(boolean z) {
        this.lOj = z;
    }

    public void uK(boolean z) {
        this.lOk = z;
    }

    public void uL(boolean z) {
        this.lOp = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lOs = onClickListener;
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
        this.lOt = aVar;
    }

    public void FB(int i) {
        switch (i) {
            case 1:
                if (this.lNO != null) {
                    this.lNO.pause();
                }
                if (this.lNY instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lNY).onPause();
                }
                if (this.lNZ instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lNZ).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lNO != null) {
                    this.lNO.resume();
                }
                if (this.lNY instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lNY).onResume();
                }
                if (this.lNZ instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lNZ).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lNO != null) {
                    this.lNO.release();
                }
                if (this.lNY instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lNY).onDestroy();
                }
                if (this.lNZ instanceof com.baidu.tieba.recapp.l) {
                    ((com.baidu.tieba.recapp.l) this.lNZ).onDestroy();
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
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lOv);
        if (this.lNT != null) {
            this.lNT.onDestroy();
        }
        if (this.lNU != null) {
            this.lNU.onDestroy();
        }
        if (this.lNP != null) {
            this.lNP.onDestroy();
        }
        if (this.lNS != null) {
            this.lNS.onDestroy();
        }
    }

    public void uP(boolean z) {
        this.lOm = z;
    }

    public void uQ(boolean z) {
        this.lOn = z;
    }

    public void uR(boolean z) {
        this.lOl = z;
    }

    public void uS(boolean z) {
        this.lOo = z;
    }

    public PbFirstFloorCommentAndPraiseAdapter dna() {
        return this.lNP;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.gqm;
    }

    public View dnb() {
        if (this.lNO == null || this.lNO.dng() == null) {
            return null;
        }
        if (this.lNO.dng().lQQ != null && this.lNO.dng().lQQ.isShown()) {
            return this.lNO.dng().lQQ;
        }
        return this.lNO.dng().lQP;
    }

    public PbFirstFloorViewHolder dnc() {
        if (this.lNO == null || this.lNO.dng() == null) {
            return null;
        }
        return this.lNO.dng();
    }

    public void uT(boolean z) {
        if (this.lNV != null) {
            this.lNV.uT(z);
        }
    }
}
