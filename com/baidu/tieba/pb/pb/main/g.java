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
import com.baidu.tbadk.core.data.bu;
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
/* loaded from: classes9.dex */
public class g {
    private ArrayList<com.baidu.adp.widget.ListView.q> ffB;
    private BdTypeListView fml;
    private List<com.baidu.adp.widget.ListView.a> hTh;
    private com.baidu.adp.widget.ListView.a iun;
    private q kbT;
    private com.baidu.tieba.pb.pb.main.adapter.c kbU;
    private com.baidu.tieba.pb.pb.main.adapter.d kbV;
    private com.baidu.tieba.pb.pb.main.adapter.a kbW;
    private ap kbX;
    private ap kbY;
    private k kbZ;
    private PbFragment kbv;
    private com.baidu.tieba.pb.video.a kca;
    private com.baidu.tieba.card.divider.a kcb;
    private com.baidu.adp.widget.ListView.a kcc;
    private al kcd;
    private am kce;
    private aj kcf;
    private com.baidu.tieba.pb.pb.a.c kcg;
    private h kci;
    private w kcj;
    private com.baidu.tieba.pb.data.e kck;
    private boolean kcp;
    private boolean kcq;
    private int kcs;
    private Runnable kcx;
    private int kcz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> kch = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean kcl = true;
    private boolean kcm = true;
    private boolean kcn = false;
    private boolean kco = false;
    private boolean kcr = false;
    private String aSp = null;
    private PostData kct = null;
    private View.OnClickListener kcu = null;
    private View.OnClickListener aLl = null;
    private TbRichTextView.i eLw = null;
    private com.baidu.tieba.pb.a.c eor = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a kcv = null;
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> kcw = new ArrayList();
    private int kcy = -1;
    private CustomMessageListener hHz = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dhD = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dhD();
                Iterator it = dhD.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).a(g.this.kbv);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.kch.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dhD);
                g.this.kcw.clear();
                g.this.kcw.addAll(arrayList);
                if (g.this.fml != null) {
                    g.this.fml.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener elO = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.kck != null && !com.baidu.adp.base.i.E(g.this.kbv.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener kcA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.kbv != null && g.this.kck != null && g.this.kck.cHb() != null) {
                g.this.kbv.cIU().cLU().cHZ();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c12040"));
            }
        }
    };
    private CustomMessageListener hTj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.w.isEmpty(g.this.hTh)) {
                g.this.cjS();
                g.this.a(g.this.kck, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kcs = 0;
        this.width = -1;
        this.kcz = 0;
        this.kcs = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.kcs;
        this.kbv = pbFragment;
        this.fml = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.elO);
        this.kcz = com.baidu.adp.lib.util.l.getEquipmentHeight(this.kbv.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.kbT = new q(pbFragment, PostData.lFL);
        this.kbT.a((TbRichTextView.c) pbFragment);
        this.kbU = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.m.kaf);
        this.kbV = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.g.TYPE);
        this.kbW = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.jYz);
        this.kbX = new ap(pbFragment, com.baidu.tieba.pb.data.l.jZY);
        this.kbY = new ap(pbFragment, com.baidu.tieba.pb.data.l.jZZ);
        this.kbZ = new k(pbFragment, PostData.lFM);
        this.kbZ.a((TbRichTextView.c) pbFragment);
        this.iun = com.baidu.tieba.recapp.q.cYS().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dGz);
        this.kcc = com.baidu.tieba.recapp.q.cYS().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.dGD);
        this.kcf = new aj(pbFragment, com.baidu.tieba.pb.data.j.Wk);
        this.kcd = new al(pbFragment, ai.kkt);
        this.kce = new am(pbFragment, com.baidu.tbadk.core.data.ax.dJM);
        this.kcg = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.lFQ);
        this.kca = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.kvs);
        this.kcb = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.kci = new h(pbFragment, com.baidu.tbadk.core.data.n.dHL);
        this.kcj = new w(pbFragment, pbFragment.getUniqueId());
        this.aUP.add(this.kbT);
        this.aUP.add(this.kbU);
        this.aUP.add(this.kbV);
        this.aUP.add(this.kbW);
        this.aUP.add(this.kbZ);
        this.aUP.add(this.kbX);
        this.aUP.add(this.kbY);
        this.aUP.add(this.iun);
        this.aUP.add(this.kcc);
        this.aUP.add(this.kcf);
        this.aUP.add(this.kcd);
        this.aUP.add(this.kce);
        this.aUP.add(this.kca);
        this.aUP.add(this.kcg);
        this.aUP.add(this.kcb);
        this.aUP.add(this.kci);
        this.aUP.add(this.kcj);
        this.hHz.setPriority(1);
        this.hHz.setSelfListener(true);
        pbFragment.registerListener(this.hHz);
        cjR();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.aUP);
    }

    public void a(com.baidu.tieba.pb.data.e eVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        x xVar;
        boolean z5;
        int i2;
        com.baidu.adp.widget.ListView.q qVar;
        PostData postData;
        if (eVar != null) {
            this.kck = eVar;
            cID();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.kck != null && this.kck.cGP() != null && this.kck.cGP().size() > 0) {
                this.postList.addAll(this.kck.cGP());
            }
            if (eVar.cGN() != null && eVar.cGN().aSp() != null) {
                this.aSp = eVar.cGN().aSp().getUserId();
            }
            if (this.kbT != null) {
                f(eVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(eVar.cGP());
                PostData aN = aN(arrayList);
                boolean z6 = aN != null;
                if (aN != null) {
                    this.kct = aN;
                }
                boolean z7 = false;
                if (!this.kcm && aN != null) {
                    arrayList.remove(aN);
                    z7 = true;
                    z6 = true;
                    if (eVar.cHm() && aN.dia() != null) {
                        aN.c(null);
                    }
                }
                if (!z6 && eVar.cGW() != null) {
                    aN = eVar.cGW();
                    z7 = true;
                    z6 = true;
                    if (!this.kcm && eVar.cHm() && aN.dia() != null) {
                        aN.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aN;
                em(arrayList);
                if (this.kbv.cJs()) {
                    if (eVar.cGP().size() > 0 && (postData = eVar.cGP().get(0)) != null && postData.dhY() == 1 && !com.baidu.tbadk.core.util.w.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.kck, arrayList, this.kcm);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.w.add(arrayList, b, this.kck.cGQ());
                    }
                }
                int c = c(this.kck, arrayList, this.kcm);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.w.add(arrayList, c, this.kck.cGR());
                }
                com.baidu.tieba.tbadkCore.t.t(arrayList, 1);
                boolean z9 = false;
                int b2 = b(eVar, arrayList);
                if (b2 >= 0) {
                    z9 = true;
                    a(eVar, arrayList, b2);
                }
                int a = a(eVar, arrayList);
                List<com.baidu.adp.widget.ListView.q> g = g(eVar);
                if (com.baidu.tbadk.core.util.w.isEmpty(g) || a < 0) {
                    z2 = z9;
                } else {
                    com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.w.getItem(arrayList, a);
                    if (qVar2 instanceof PostData) {
                        ((PostData) qVar2).lGy = true;
                    }
                    com.baidu.tbadk.core.util.w.addAll(arrayList, a, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(eVar, arrayList, this.kcm);
                }
                if (i3 >= 0 && eVar.cHl() != null) {
                    com.baidu.tbadk.core.util.w.add(arrayList, i3, eVar.cHl());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.lGx = true;
                    }
                    z3 = false;
                    z4 = z2;
                }
                int i4 = b(eVar, arrayList, i3) != null ? i3 + 1 : i3;
                int i5 = c(eVar, arrayList, i4) != null ? i4 + 1 : i4;
                int i6 = -1;
                if (!z6) {
                    i = -1;
                    xVar = null;
                    z5 = false;
                } else {
                    com.baidu.adp.widget.ListView.q b3 = b(arrayList, i5);
                    boolean z10 = b3 != null;
                    if (z10) {
                        i2 = -1;
                        qVar = b3;
                    } else {
                        if (i5 >= 0) {
                            i6 = i5 + 1;
                        } else if (a >= 0) {
                            i6 = a;
                        } else if (b2 >= 0) {
                            i6 = b2;
                        }
                        com.baidu.adp.widget.ListView.q c2 = c(arrayList, i6);
                        z10 = c2 != null;
                        i2 = i6;
                        qVar = c2;
                    }
                    x a2 = a(arrayList, qVar, i5, i2);
                    if (a2 == null) {
                        i = i2;
                        xVar = a2;
                        z5 = z10;
                    } else if (!z10) {
                        i = i2;
                        xVar = a2;
                        z5 = true;
                    } else if (i2 > 0) {
                        i = i2 + 1;
                        xVar = a2;
                        z5 = z10;
                    } else {
                        i5++;
                        i = i2;
                        xVar = a2;
                        z5 = z10;
                    }
                }
                if (z6) {
                    boolean a3 = a(eVar, arrayList, z5, xVar != null, i, i5, a, b2);
                    if (xVar != null) {
                        xVar.khI = a3;
                    }
                }
                this.kbT.rE(!z4);
                boolean h = h(postData2);
                if (this.kcn && !h) {
                    arrayList.remove(postData2);
                    this.kcn = false;
                }
                if (eVar.cHl() != null) {
                    eVar.cHl().rq(!z3);
                }
                if (this.fml != null) {
                    this.ffB = arrayList;
                    this.fml.setData(this.ffB);
                }
                a(h, z, a, g);
                if (a(postData2, arrayList, z8)) {
                    this.fml.setData(arrayList);
                }
            }
        }
    }

    private PostData aN(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dhY() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jZY);
        bu cGN = eVar.cGN();
        lVar.kaa = cGN != null ? cGN.aSg() : 0L;
        lVar.isNew = !this.kcm;
        lVar.kad = this.kbv.cJC();
        lVar.sortType = eVar.jYM;
        lVar.kac = eVar.cHq();
        lVar.isDynamic = eVar.cHp();
        lVar.kae = eVar.jYL;
        com.baidu.tbadk.core.util.w.add(arrayList, i, lVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.g gVar;
        if (com.baidu.tbadk.a.d.aNU() && eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.kbv.cIe().cHV()) || !this.kbv.cIe().cKc())) {
            if (!this.kbv.cHU() && !com.baidu.tbadk.core.util.w.isEmpty(eVar.cHj())) {
                gVar = new com.baidu.tieba.pb.data.g(eVar.cHj().get(0));
            } else {
                gVar = new com.baidu.tieba.pb.data.g(eVar.getForum());
            }
            gVar.tid = this.kbv.cIe().cJZ();
            com.baidu.tbadk.core.util.w.add(arrayList, i + 1, gVar);
            return gVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.kbv.cIe() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.kbv.cIe().cJX())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.kcp || this.kco) && i != -1 && !com.baidu.tbadk.core.util.w.isEmpty(list) && !this.kcq) {
                this.kcx = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.fml.setSelectionFromTop(g.this.fml.getHeaderViewsCount() + list.size(), 0 - g.this.kcz);
                        g.this.kcq = false;
                    }
                };
                com.baidu.adp.lib.f.e.lt().post(this.kcx);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.kct != null && !this.kco) {
                com.baidu.tbadk.core.util.w.add(arrayList, 0, this.kct);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.EW(1);
            com.baidu.tbadk.core.util.w.add(arrayList, 0, postData2);
            return true;
        } else if (z) {
            com.baidu.tbadk.core.util.w.add(arrayList, 0, postData);
            return true;
        } else {
            return false;
        }
    }

    private boolean a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        ArrayList arrayList2 = new ArrayList();
        if (!com.baidu.tbadk.core.util.w.isEmpty(eVar.cHo()) && eVar.cHo().size() > 2) {
            int min = Math.min(eVar.cHo().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.n nVar = eVar.cHo().get(i5);
                if (!z2 && i5 == 0) {
                    nVar.gR(true);
                }
                if (nVar.aSH() == null) {
                    if (i5 == min - 1) {
                        nVar.gS(true);
                    }
                } else if (i5 == min - 2) {
                    nVar.gS(true);
                } else if (i5 == min - 1) {
                    nVar.gT(true);
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
                    com.baidu.tbadk.core.util.w.add(arrayList, i3, arrayList2.get(size));
                }
                return true;
            }
        }
        return false;
    }

    private com.baidu.adp.widget.ListView.q c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (i < 0 || eVar == null || !eVar.jYQ || eVar.jYR == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = eVar.jYR;
        com.baidu.tbadk.core.util.w.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.e eVar) {
        this.kbT.setData(eVar);
        this.kbT.setFromCDN(this.mIsFromCDN);
        this.kbT.setImageMaxWidth(this.kcs);
        this.kbT.rr(this.kcl);
        this.kbT.z(this.aLl);
        this.kbT.R(this.kcu);
        this.kbT.setOnImageClickListener(this.eLw);
        this.kbT.setOnLongClickListener(this.mOnLongClickListener);
        this.kbT.setTbGestureDetector(this.eor);
        this.kbZ.setData(eVar);
        this.kbZ.setFromCDN(this.mIsFromCDN);
        this.kbZ.fr(this.aSp);
        this.kbZ.rr(this.kcl);
        this.kbZ.z(this.aLl);
        this.kbZ.R(this.kcu);
        this.kbZ.setOnImageClickListener(this.eLw);
        this.kbZ.setOnLongClickListener(this.mOnLongClickListener);
        this.kbZ.setTbGestureDetector(this.eor);
        this.kbU.setOnClickListener(this.aLl);
        this.kcg.setOnClickListener(this.aLl);
        this.kca.setOnClickListener(this.kcA);
        if (this.kcc != null && (this.kcc instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.kcc).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kch.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(eVar);
                next.setFromCDN(this.mIsFromCDN);
                next.fr(this.aSp);
                next.setImageMaxWidth(this.kcs);
                next.rr(this.kcl);
                next.rs(this.kcm);
                next.rt(this.kcr);
                next.z(this.aLl);
                next.R(this.kcu);
                next.setOnImageClickListener(this.eLw);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.kbX.z(this.aLl);
        this.kbX.a(this.kcv);
        this.kbY.z(this.aLl);
        this.kbX.setData(eVar);
        this.kbW.setData(eVar);
        this.kbY.setData(eVar);
        this.kcd.setData(eVar);
        this.kce.setData(eVar);
        this.kci.setPbData(eVar);
        this.kci.setFrom(this.kbv.kfT);
        this.kcj.setPbData(eVar);
    }

    private x a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        x cGS = this.kck.cGS();
        if (cGS != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.dGD) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.dGD) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (cGS instanceof x)) {
                com.baidu.tbadk.core.util.w.add(arrayList, i2, cGS);
                return cGS;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel cIe;
        if (i >= 0 && (cIe = this.kbv.cIe()) != null) {
            String cKP = cIe.cKP();
            if (TextUtils.isEmpty(cKP)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.Ne(cKP);
            c(nVar);
            com.baidu.tbadk.core.util.w.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.kck == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n cKn = this.kbv.cIe().cKn();
        if (cKn == null) {
            cKn = this.kck.cHf();
        }
        if (cKn != null) {
            AdvertAppInfo.ILegoAdvert dhN = cKn.dhN();
            if (dhN != null) {
                dhN.setAdvertAppInfo(cKn.pL());
            }
            int aQi = cKn.dhM().aQi();
            if (aQi != 0) {
                a(cKn, aQi);
                if (aQi == 28 || aQi == 31 || cKn.dhM().goods == null) {
                    return null;
                }
                cKn.dhM().goods.goods_style = -1001;
                return null;
            }
            if (this.kck.getForum() != null) {
                cKn.forumId = this.kck.getForum().getId();
            }
            if (this.kck.cGN() != null) {
                cKn.threadId = com.baidu.adp.lib.f.b.toLong(this.kck.cGN().getId(), 0L);
            }
            if (this.kck != null && this.kck.getPage() != null) {
                cKn.pageNumber = this.kck.getPage().aRd();
            }
            c(cKn);
            if (i >= 0) {
                com.baidu.tbadk.core.util.w.add(arrayList, i, cKn);
                return cKn;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.kco || eVar == null || com.baidu.tbadk.core.util.w.isEmpty(eVar.cGP()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar != null && eVar.cHm() && this.kcm) ? 0 : -1;
        } else if (this.kbv.cIe() == null || !this.kbv.cIe().getIsFromMark()) {
            if (this.kbv.cIU() == null || !this.kbv.cIU().cMW()) {
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
                        if (postData.dhY() == 1 && postData.lGu == 0) {
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
                return eVar.cHm() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (eVar == null || com.baidu.tbadk.core.util.w.isEmpty(eVar.cGP()) || com.baidu.tbadk.core.util.w.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.w.getItem(eVar.cGP(), 0)) == null) {
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
                if (postData.dhY() == 1 && postData.lGu == 0) {
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

    private int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (eVar == null || com.baidu.tbadk.core.util.w.isEmpty(eVar.cGP()) || arrayList == null || arrayList.size() <= 0) {
            return (eVar == null || !eVar.cHm()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (eVar.cGP().get(0) == null || eVar.cGP().get(0).dhY() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar == null || eVar.cHb() == null || com.baidu.tbadk.core.util.w.isEmpty(eVar.cHb().kao)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = eVar.cHb().kao;
        if (com.baidu.tbadk.core.util.w.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.lGH = true;
                postData.lGw = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.w.getCount(eVar.cHb().kap) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.w.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).lGw = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.w.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).lGw = true;
            }
        }
        com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jZZ);
        lVar.kab = eVar.cHb().forum_top_list;
        arrayList.add(0, lVar);
        return arrayList;
    }

    private void cjR() {
        if (this.kbv != null && !cjS()) {
            this.kbv.registerListener(this.hTj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cjS() {
        if (this.kbv == null) {
            return false;
        }
        this.hTh = new ArrayList();
        ArrayList<BdUniqueId> dhp = com.baidu.tieba.tbadkCore.t.dhp();
        if (dhp == null || dhp.size() <= 0) {
            return false;
        }
        int size = dhp.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cyD().a(this.kbv.getPageContext(), dhp.get(i), 2);
            if (a != null) {
                this.aUP.add(a);
                this.hTh.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.w.isEmpty(this.hTh)) {
            this.fml.addAdapters(this.hTh);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.fml.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (eVar == null || eVar.cGP() == null || eVar.cGQ() == null || eVar.cGP().size() == 0 || eVar.cGN() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cGQ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cGP().get(0) == null || eVar.cGP().get(0).dhY() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aRd() != eVar.getPage().aRa()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (eVar == null || eVar.cGP() == null || eVar.cGR() == null || eVar.cGP().size() == 0 || eVar.cGN() == null || arrayList == null) {
            return -1;
        }
        if (eVar.cGR().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (eVar.cGP().get(0) == null || eVar.cGP().get(0).dhY() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (eVar.getPage() == null || eVar.getPage().aRd() != eVar.getPage().aRa()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.fml.getItem(i);
    }

    public ArrayList<PostData> cIA() {
        return this.postList;
    }

    public BdUniqueId Bd(int i) {
        if (this.fml.getItem(i) != null) {
            return this.fml.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.kcy = cIB();
        if (this.fml.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }

    public int cIB() {
        if (this.fml != null && this.fml.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fml.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.fml.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.l.jZY) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int cIC() {
        return this.kcy;
    }

    private void cID() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kck != null && !this.kck.jZB && this.kck.Xx != 2) {
            ArrayList<PostData> cGP = this.kck.cGP();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cHe = this.kck.cHe();
            if (cGP != null && cGP.size() != 0 && cHe != null && cHe.size() != 0) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = cHe.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cHe.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.hTf = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cHe.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dhM() != null) {
                        int aQi = next3.dhM().aQi();
                        if (aQi != 0) {
                            a(next3, aQi);
                            if (aQi != 28 && aQi != 31) {
                                if (next3.dhM().goods != null) {
                                    next3.dhM().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                cHe.clear();
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
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.kck.getForum() != null) {
                        nVar4.forumId = this.kck.getForum().getId();
                    }
                    if (this.kck.cGN() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kck.cGN().getId(), 0L);
                    }
                    if (this.kck != null && this.kck.getPage() != null) {
                        nVar4.pageNumber = this.kck.getPage().aRd();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kck.jZA;
                    if (position + i3 >= cGP.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kcm) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        cGP.add(position, nVar4);
                        TiebaStatic.eventStat(this.kbv.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dhM().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.Dw(i);
        com.baidu.tieba.recapp.report.d.cZQ().a(c);
        if (nVar != null && nVar.dhM() != null) {
            nVar.dhM().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dhM() != null && nVar.dhM().goods != null && nVar.dhM().goods.goods_style != 1001 && nVar.dhM().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kck != null && nVar.dhM() != null) {
            nVar.dhM().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kck.getPage() != null) {
                nVar.dhM().advertAppContext.pn = this.kck.getPage().aRd();
            }
            nVar.dhM().advertAppContext.page = nVar.dhP();
            if (this.kck.getForum() != null && (forum = this.kck.getForum()) != null) {
                nVar.dhM().advertAppContext.fid = forum.getId();
                nVar.dhM().advertAppContext.dGq = forum.getFirst_class();
                nVar.dhM().advertAppContext.dGr = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dhM().advertAppContext.dGs = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dhM().advertAppContext.extensionInfo = nVar.dhM().ext_info;
            nVar.dhM().advertAppContext.XE = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.kbT.setFromCDN(z);
        if (this.kcc != null && (this.kcc instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.kcc).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.kch.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean cIE() {
        return this.kcl;
    }

    public void rr(boolean z) {
        this.kcl = z;
    }

    public void rs(boolean z) {
        this.kcm = z;
    }

    public void rt(boolean z) {
        this.kcr = z;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kcu = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eLw = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eor = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.aLl = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kcv = aVar;
    }

    public void Be(int i) {
        switch (i) {
            case 1:
                if (this.kbT != null) {
                    this.kbT.pause();
                    return;
                }
                return;
            case 2:
                if (this.kbT != null) {
                    this.kbT.resume();
                    return;
                }
                return;
            case 3:
                if (this.kbT != null) {
                    this.kbT.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void em(List<com.baidu.adp.widget.ListView.q> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.aTz())) {
                        com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
                        aiVar.vG(postData.aTz());
                        list.set(i, aiVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kcx);
        if (this.kbX != null) {
            this.kbX.onDestroy();
        }
        if (this.kbY != null) {
            this.kbY.onDestroy();
        }
        if (this.kbU != null) {
            this.kbU.onDestroy();
        }
        if (this.kbW != null) {
            this.kbW.onDestroy();
        }
    }

    public void rx(boolean z) {
        this.kco = z;
    }

    public void ry(boolean z) {
        this.kcp = z;
    }

    public void rz(boolean z) {
        this.kcn = z;
    }

    public void rA(boolean z) {
        this.kcq = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c cIF() {
        return this.kbU;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.ffB;
    }

    public View cIG() {
        if (this.kbT == null || this.kbT.cIJ() == null) {
            return null;
        }
        if (this.kbT.cIJ().kew != null && this.kbT.cIJ().kew.isShown()) {
            return this.kbT.cIJ().kew;
        }
        return this.kbT.cIJ().kev;
    }

    public r cIH() {
        if (this.kbT == null || this.kbT.cIJ() == null) {
            return null;
        }
        return this.kbT.cIJ();
    }
}
