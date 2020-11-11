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
/* loaded from: classes22.dex */
public class g {
    private ArrayList<com.baidu.adp.widget.ListView.q> fZE;
    private BdTypeListView gih;
    private com.baidu.adp.widget.ListView.a jFt;
    private List<com.baidu.adp.widget.ListView.a> jbZ;
    private PbFragment lpI;
    private boolean lqA;
    private boolean lqB;
    private int lqD;
    private Runnable lqI;
    private int lqK;
    private s lqe;
    private com.baidu.tieba.pb.pb.main.adapter.c lqf;
    private com.baidu.tieba.pb.pb.main.adapter.d lqg;
    private com.baidu.tieba.pb.pb.main.adapter.a lqh;
    private at lqi;
    private at lqj;
    private m lqk;
    private com.baidu.tieba.pb.video.a lql;
    private com.baidu.tieba.card.divider.a lqm;
    private com.baidu.adp.widget.ListView.a lqn;
    private ap lqo;
    private aq lqp;
    private an lqq;
    private com.baidu.tieba.pb.pb.a.c lqr;
    private h lqt;
    private y lqu;
    private com.baidu.tieba.pb.data.f lqv;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> lqs = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean lqw = true;
    private boolean lqx = true;
    private boolean lqy = false;
    private boolean lqz = false;
    private boolean lqC = false;
    private String bhP = null;
    private PostData lqE = null;
    private View.OnClickListener lqF = null;
    private View.OnClickListener aZX = null;
    private TbRichTextView.i fFW = null;
    private com.baidu.tieba.pb.a.c fhK = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private SortSwitchButton.a lqG = null;
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> lqH = new ArrayList();
    private int lqJ = -1;
    private CustomMessageListener iQf = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList dJE = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).dJE();
                Iterator it = dJE.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof o) {
                        ((o) aVar).a(g.this.lpI);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            g.this.lqs.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(dJE);
                g.this.lqH.clear();
                g.this.lqH.addAll(arrayList);
                if (g.this.gih != null) {
                    g.this.gih.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener feV = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.g.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && g.this.lqv != null && !com.baidu.adp.base.i.G(g.this.lpI.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private final View.OnClickListener lqL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.g.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.lpI != null && g.this.lqv != null && g.this.lqv.diy() != null) {
                g.this.lpI.dkp().dnu().djv();
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12040"));
            }
        }
    };
    private CustomMessageListener jcb = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.y.isEmpty(g.this.jbZ)) {
                g.this.cLm();
                g.this.a(g.this.lqv, false);
            }
        }
    };

    public g(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lqD = 0;
        this.width = -1;
        this.lqK = 0;
        this.lqD = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.lqD;
        this.lpI = pbFragment;
        this.gih = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.feV);
        this.lqK = com.baidu.adp.lib.util.l.getEquipmentHeight(this.lpI.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.lqe = new s(pbFragment, PostData.mWQ);
        this.lqe.a((TbRichTextView.c) pbFragment);
        this.lqf = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.o.lot);
        this.lqg = new com.baidu.tieba.pb.pb.main.adapter.d(pbFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lqh = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.a.lmG);
        this.lqi = new at(pbFragment, com.baidu.tieba.pb.data.n.lol);
        this.lqj = new at(pbFragment, com.baidu.tieba.pb.data.n.lom);
        this.lqk = new m(pbFragment, PostData.mWR);
        this.lqk.a((TbRichTextView.c) pbFragment);
        this.jFt = com.baidu.tieba.recapp.r.dAo().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eyC);
        this.lqn = com.baidu.tieba.recapp.r.dAo().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.eyG);
        this.lqq = new an(pbFragment, com.baidu.tieba.pb.data.l.Xs);
        this.lqo = new ap(pbFragment, am.lzt);
        this.lqp = new aq(pbFragment, com.baidu.tbadk.core.data.az.eCa);
        this.lqr = new com.baidu.tieba.pb.pb.a.c(pbFragment, PostData.mWV);
        this.lql = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.lKr);
        this.lqm = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.lqt = new h(pbFragment, com.baidu.tbadk.core.data.n.ezO);
        this.lqu = new y(pbFragment, pbFragment.getUniqueId());
        this.bky.add(this.lqe);
        this.bky.add(this.lqf);
        this.bky.add(this.lqg);
        this.bky.add(this.lqh);
        this.bky.add(this.lqk);
        this.bky.add(this.lqi);
        this.bky.add(this.lqj);
        this.bky.add(this.jFt);
        this.bky.add(this.lqn);
        this.bky.add(this.lqq);
        this.bky.add(this.lqo);
        this.bky.add(this.lqp);
        this.bky.add(this.lql);
        this.bky.add(this.lqr);
        this.bky.add(this.lqm);
        this.bky.add(this.lqt);
        this.bky.add(this.lqu);
        this.iQf.setPriority(1);
        this.iQf.setSelfListener(true);
        pbFragment.registerListener(this.iQf);
        cLl();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.bky);
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
            this.lqv = fVar;
            djY();
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.lqv != null && this.lqv.dim() != null && this.lqv.dim().size() > 0) {
                this.postList.addAll(this.lqv.dim());
            }
            if (fVar.dik() != null && fVar.dik().bmA() != null) {
                this.bhP = fVar.dik().bmA().getUserId();
            }
            if (this.lqe != null) {
                f(fVar);
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>(fVar.dim());
                PostData aZ = aZ(arrayList);
                boolean z6 = aZ != null;
                if (aZ != null) {
                    this.lqE = aZ;
                }
                boolean z7 = false;
                if (!this.lqx && aZ != null) {
                    arrayList.remove(aZ);
                    z7 = true;
                    z6 = true;
                    if (fVar.diK() && aZ.dKb() != null) {
                        aZ.c(null);
                    }
                }
                if (!z6 && fVar.dit() != null) {
                    aZ = fVar.dit();
                    z7 = true;
                    z6 = true;
                    if (!this.lqx && fVar.diK() && aZ.dKb() != null) {
                        aZ.c(null);
                    }
                }
                boolean z8 = z7;
                PostData postData2 = aZ;
                fc(arrayList);
                if (this.lpI.dkN()) {
                    if (fVar.dim().size() > 0 && (postData = fVar.dim().get(0)) != null && postData.dJZ() == 1 && !com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.lqv, arrayList, this.lqx);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.y.add(arrayList, b, this.lqv.din());
                    }
                }
                int c = c(this.lqv, arrayList, this.lqx);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.y.add(arrayList, c, this.lqv.dio());
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
                        ((PostData) qVar2).mXC = true;
                    }
                    com.baidu.tbadk.core.util.y.addAll(arrayList, a2, g);
                    z2 = true;
                }
                int i3 = -1;
                if (z6) {
                    i3 = a(fVar, arrayList, this.lqx);
                }
                if (i3 >= 0 && fVar.diJ() != null) {
                    com.baidu.tbadk.core.util.y.add(arrayList, i3, fVar.diJ());
                    z3 = true;
                    z4 = true;
                } else {
                    if (postData2 != null) {
                        postData2.mXB = true;
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
                        zVar.lwk = a4;
                    }
                }
                this.lqe.ug(!z4);
                boolean h = h(postData2);
                if (this.lqy && !h) {
                    arrayList.remove(postData2);
                    this.lqy = false;
                }
                if (fVar.diJ() != null) {
                    fVar.diJ().tS(!z3);
                }
                if (this.gih != null) {
                    this.fZE = arrayList;
                    this.gih.setData(this.fZE);
                }
                a(h, z, a2, g);
                if (a(postData2, arrayList, z8)) {
                    this.gih.setData(arrayList);
                }
            }
        }
    }

    private PostData aZ(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof PostData) && ((PostData) next).dJZ() == 1) {
                return (PostData) next;
            }
        }
        return null;
    }

    private void a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lol);
        bw dik = fVar.dik();
        nVar.loo = dik != null ? dik.bmr() : 0L;
        nVar.isNew = !this.lqx;
        nVar.lor = this.lpI.dkX();
        nVar.sortType = fVar.lmU;
        nVar.loq = fVar.diO();
        nVar.isDynamic = fVar.diN();
        nVar.los = fVar.lmT;
        com.baidu.tbadk.core.util.y.add(arrayList, i, nVar);
    }

    private com.baidu.adp.widget.ListView.q b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        com.baidu.tieba.pb.data.h hVar;
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lpI.djz().djr()) || !this.lpI.djz().dlA())) {
            if (!this.lpI.djq() && !com.baidu.tbadk.core.util.y.isEmpty(fVar.diH())) {
                hVar = new com.baidu.tieba.pb.data.h(fVar.diH().get(0));
            } else {
                hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            }
            hVar.tid = this.lpI.djz().dlx();
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return null;
    }

    private boolean h(PostData postData) {
        return (this.lpI.djz() == null || postData == null || postData.getId() == null || !postData.getId().equals(this.lpI.djz().dlv())) ? false : true;
    }

    private void a(boolean z, boolean z2, int i, final List<com.baidu.adp.widget.ListView.q> list) {
        if (!z && !z2) {
            if ((this.lqA || this.lqz) && i != -1 && !com.baidu.tbadk.core.util.y.isEmpty(list) && !this.lqB) {
                this.lqI = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.gih.setSelectionFromTop(g.this.gih.getHeaderViewsCount() + list.size(), 0 - g.this.lqK);
                        g.this.lqB = false;
                    }
                };
                com.baidu.adp.lib.f.e.mY().post(this.lqI);
            }
        }
    }

    private boolean a(PostData postData, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (postData == null) {
            if (this.lqE != null && !this.lqz) {
                com.baidu.tbadk.core.util.y.add(arrayList, 0, this.lqE);
                return true;
            }
            PostData postData2 = new PostData();
            postData2.JD(1);
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
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.diM()) && fVar.diM().size() > 2) {
            int min = Math.min(fVar.diM().size(), 7);
            for (int i5 = 0; i5 < min; i5++) {
                com.baidu.tbadk.core.data.n nVar = fVar.diM().get(i5);
                if (!z2 && i5 == 0) {
                    nVar.iH(true);
                }
                if (nVar.bmS() == null) {
                    if (i5 == min - 1) {
                        nVar.iI(true);
                    }
                } else if (i5 == min - 2) {
                    nVar.iI(true);
                } else if (i5 == min - 1) {
                    nVar.iJ(true);
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
        if (i < 0 || fVar == null || !fVar.lmY || fVar.lmZ == null) {
            return null;
        }
        com.baidu.tieba.pb.data.a aVar = fVar.lmZ;
        com.baidu.tbadk.core.util.y.add(arrayList, i, aVar);
        return aVar;
    }

    private void f(@NonNull com.baidu.tieba.pb.data.f fVar) {
        this.lqe.setData(fVar);
        this.lqe.setFromCDN(this.mIsFromCDN);
        this.lqe.setImageMaxWidth(this.lqD);
        this.lqe.tT(this.lqw);
        this.lqe.B(this.aZX);
        this.lqe.T(this.lqF);
        this.lqe.setOnImageClickListener(this.fFW);
        this.lqe.setOnLongClickListener(this.mOnLongClickListener);
        this.lqe.setTbGestureDetector(this.fhK);
        this.lqk.setData(fVar);
        this.lqk.setFromCDN(this.mIsFromCDN);
        this.lqk.hE(this.bhP);
        this.lqk.tT(this.lqw);
        this.lqk.B(this.aZX);
        this.lqk.T(this.lqF);
        this.lqk.setOnImageClickListener(this.fFW);
        this.lqk.setOnLongClickListener(this.mOnLongClickListener);
        this.lqk.setTbGestureDetector(this.fhK);
        this.lqf.setOnClickListener(this.aZX);
        this.lqr.setOnClickListener(this.aZX);
        this.lql.setOnClickListener(this.lqL);
        if (this.lqn != null && (this.lqn instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.lqn).setIsFromCDN(this.mIsFromCDN);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lqs.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.pb.pb.a.a next = it.next();
            if (next != null) {
                next.setData(fVar);
                next.setFromCDN(this.mIsFromCDN);
                next.hE(this.bhP);
                next.setImageMaxWidth(this.lqD);
                next.tT(this.lqw);
                next.tU(this.lqx);
                next.tV(this.lqC);
                next.B(this.aZX);
                next.T(this.lqF);
                next.setOnImageClickListener(this.fFW);
                next.setOnLongClickListener(this.mOnLongClickListener);
            }
        }
        this.lqi.B(this.aZX);
        this.lqi.a(this.lqG);
        this.lqj.B(this.aZX);
        this.lqi.setData(fVar);
        this.lqh.setData(fVar);
        this.lqj.setData(fVar);
        this.lqo.setData(fVar);
        this.lqp.setData(fVar);
        this.lqt.setPbData(fVar);
        this.lqt.setFrom(this.lpI.lut);
        this.lqu.setPbData(fVar);
    }

    private z a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.adp.widget.ListView.q qVar, int i, int i2) {
        z dip = this.lqv.dip();
        if (dip != null) {
            if (qVar != null) {
                if (i2 < 0 && qVar.getType() != AdvertAppInfo.eyG) {
                    i2 = i + 2;
                } else if (qVar.getType() == AdvertAppInfo.eyG) {
                    i2 = -1;
                } else {
                    i2++;
                }
            }
            if (i2 > 0 && (dip instanceof z)) {
                com.baidu.tbadk.core.util.y.add(arrayList, i2, dip);
                return dip;
            }
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q c(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        PbModel djz;
        if (i >= 0 && (djz = this.lpI.djz()) != null) {
            String dmn = djz.dmn();
            if (TextUtils.isEmpty(dmn)) {
                return null;
            }
            com.baidu.tieba.tbadkCore.data.n nVar = new com.baidu.tieba.tbadkCore.data.n();
            nVar.SQ(dmn);
            c(nVar);
            com.baidu.tbadk.core.util.y.add(arrayList, i + 1, nVar);
            return nVar;
        }
        return null;
    }

    private com.baidu.adp.widget.ListView.q d(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, int i) {
        if (this.lqv == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.n dlL = this.lpI.djz().dlL();
        if (dlL == null) {
            dlL = this.lqv.diC();
        }
        if (dlL != null) {
            AdvertAppInfo.ILegoAdvert dJO = dlL.dJO();
            if (dJO != null) {
                dJO.setAdvertAppInfo(dlL.rq());
            }
            int bkr = dlL.dJN().bkr();
            if (bkr != 0) {
                a(dlL, bkr);
                if (bkr == 28 || bkr == 31 || dlL.dJN().goods == null) {
                    return null;
                }
                dlL.dJN().goods.goods_style = -1001;
                return null;
            }
            if (this.lqv.getForum() != null) {
                dlL.forumId = this.lqv.getForum().getId();
            }
            if (this.lqv.dik() != null) {
                dlL.threadId = com.baidu.adp.lib.f.b.toLong(this.lqv.dik().getId(), 0L);
            }
            if (this.lqv != null && this.lqv.getPage() != null) {
                dlL.pageNumber = this.lqv.getPage().blo();
            }
            c(dlL);
            if (i >= 0) {
                com.baidu.tieba.lego.card.d.a.a(arrayList, dlL, i);
                return dlL;
            }
            return null;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (this.lqz || fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dim()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.diK() && this.lqx) ? 0 : -1;
        } else if (this.lpI.djz() == null || !this.lpI.djz().getIsFromMark()) {
            if (this.lpI.dkp() == null || !this.lpI.dkp().dow()) {
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
                        if (postData.dJZ() == 1 && postData.mXy == 0) {
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
                return fVar.diK() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dim()) || com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.y.getItem(fVar.dim(), 0)) == null) {
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
                if (postData.dJZ() == 1 && postData.mXy == 0) {
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
        if (fVar == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.dim()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.diK()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.dim().get(0) == null || fVar.dim().get(0).dJZ() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.q> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.diy() == null || com.baidu.tbadk.core.util.y.isEmpty(fVar.diy().loD)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.diy().loD;
        if (com.baidu.tbadk.core.util.y.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.mXL = true;
                postData.mXA = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.y.getCount(fVar.diy().loE) > 2) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar instanceof PostData) {
                ((PostData) qVar).mXA = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, arrayList.size() - 1);
            if (qVar2 instanceof PostData) {
                ((PostData) qVar2).mXA = true;
            }
        }
        com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lom);
        nVar.lop = fVar.diy().forum_top_list;
        arrayList.add(0, nVar);
        return arrayList;
    }

    private void cLl() {
        if (this.lpI != null && !cLm()) {
            this.lpI.registerListener(this.jcb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cLm() {
        if (this.lpI == null) {
            return false;
        }
        this.jbZ = new ArrayList();
        ArrayList<BdUniqueId> dJq = com.baidu.tieba.tbadkCore.u.dJq();
        if (dJq == null || dJq.size() <= 0) {
            return false;
        }
        int size = dJq.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a2 = com.baidu.tieba.lego.d.b.das().a(this.lpI.getPageContext(), dJq.get(i), 2);
            if (a2 != null) {
                this.bky.add(a2);
                this.jbZ.add(a2);
            }
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jbZ)) {
            this.gih.addAdapters(this.jbZ);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.gih.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dim() == null || fVar.din() == null || fVar.dim().size() == 0 || fVar.dik() == null || arrayList == null) {
            return -1;
        }
        if (fVar.din().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dim().get(0) == null || fVar.dim().get(0).dJZ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().blo() != fVar.getPage().bll()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, boolean z) {
        if (fVar == null || fVar.dim() == null || fVar.dio() == null || fVar.dim().size() == 0 || fVar.dik() == null || arrayList == null) {
            return -1;
        }
        if (fVar.dio().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.dim().get(0) == null || fVar.dim().get(0).dJZ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().blo() != fVar.getPage().bll()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.q getItem(int i) {
        return this.gih.getItem(i);
    }

    public ArrayList<PostData> djV() {
        return this.postList;
    }

    public BdUniqueId FI(int i) {
        if (this.gih.getItem(i) != null) {
            return this.gih.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        this.lqJ = djW();
        if (this.gih.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }

    public int djW() {
        if (this.gih != null && this.gih.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gih.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.q qVar = this.gih.getData().get(i2);
                if (qVar == null || qVar.getType() != com.baidu.tieba.pb.data.n.lol) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int djX() {
        return this.lqJ;
    }

    private void djY() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lqv != null && !this.lqv.lnJ && this.lqv.YH != 2) {
            ArrayList<PostData> dim = this.lqv.dim();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> diB = this.lqv.diB();
            if (!com.baidu.tieba.lego.card.d.a.isEmpty(dim) && !com.baidu.tieba.lego.card.d.a.isEmpty(diB)) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = diB.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = diB.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.jbX = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = diB.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dJN() != null) {
                        int bkr = next3.dJN().bkr();
                        if (bkr != 0) {
                            a(next3, bkr);
                            if (bkr != 28 && bkr != 31) {
                                if (next3.dJN().goods != null) {
                                    next3.dJN().goods.goods_style = -1001;
                                }
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                diB.clear();
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
                    if (this.lqv.getForum() != null) {
                        nVar4.forumId = this.lqv.getForum().getId();
                    }
                    if (this.lqv.dik() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lqv.dik().getId(), 0L);
                    }
                    if (this.lqv != null && this.lqv.getPage() != null) {
                        nVar4.pageNumber = this.lqv.getPage().blo();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lqv.lnI;
                    if (position + i3 >= com.baidu.tieba.lego.card.d.a.eC(dim)) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lqx) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else {
                        com.baidu.tieba.lego.card.d.a.a(dim, nVar4, position);
                        TiebaStatic.eventStat(this.lpI.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dJN().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(nVar, 5);
        c.Ia(i);
        com.baidu.tieba.recapp.report.d.dBp().a(c);
        if (nVar != null && nVar.dJN() != null) {
            nVar.dJN().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dJN() != null && nVar.dJN().goods != null && nVar.dJN().goods.goods_style != 1001 && nVar.dJN().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lqv != null && nVar.dJN() != null) {
            nVar.dJN().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.lqv.getPage() != null) {
                nVar.dJN().advertAppContext.pn = this.lqv.getPage().blo();
            }
            nVar.dJN().advertAppContext.page = nVar.dJQ();
            if (this.lqv.getForum() != null && (forum = this.lqv.getForum()) != null) {
                nVar.dJN().advertAppContext.fid = forum.getId();
                nVar.dJN().advertAppContext.eyt = forum.getFirst_class();
                nVar.dJN().advertAppContext.eyu = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dJN().advertAppContext.eyv = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dJN().advertAppContext.extensionInfo = nVar.dJN().ext_info;
            nVar.dJN().advertAppContext.YN = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.lqe.setFromCDN(z);
        if (this.lqn != null && (this.lqn instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.lqn).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.lqs.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean djZ() {
        return this.lqw;
    }

    public void tT(boolean z) {
        this.lqw = z;
    }

    public void tU(boolean z) {
        this.lqx = z;
    }

    public void tV(boolean z) {
        this.lqC = z;
    }

    public void T(View.OnClickListener onClickListener) {
        this.lqF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fhK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lqG = aVar;
    }

    public void FJ(int i) {
        switch (i) {
            case 1:
                if (this.lqe != null) {
                    this.lqe.pause();
                }
                if (this.lqn instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.lqn).onPause();
                    return;
                }
                return;
            case 2:
                if (this.lqe != null) {
                    this.lqe.resume();
                }
                if (this.lqn instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.lqn).onResume();
                    return;
                }
                return;
            case 3:
                if (this.lqe != null) {
                    this.lqe.release();
                }
                if (this.lqn instanceof com.baidu.tieba.recapp.i) {
                    ((com.baidu.tieba.recapp.i) this.lqn).onDestroy();
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
                    if (!TextUtils.isEmpty(postData.bnK())) {
                        com.baidu.tbadk.core.data.ak akVar = new com.baidu.tbadk.core.data.ak();
                        akVar.AQ(postData.bnK());
                        list.set(i, akVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lqI);
        if (this.lqi != null) {
            this.lqi.onDestroy();
        }
        if (this.lqj != null) {
            this.lqj.onDestroy();
        }
        if (this.lqf != null) {
            this.lqf.onDestroy();
        }
        if (this.lqh != null) {
            this.lqh.onDestroy();
        }
    }

    public void tZ(boolean z) {
        this.lqz = z;
    }

    public void ua(boolean z) {
        this.lqA = z;
    }

    public void ub(boolean z) {
        this.lqy = z;
    }

    public void uc(boolean z) {
        this.lqB = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c dka() {
        return this.lqf;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.fZE;
    }

    public View dkb() {
        if (this.lqe == null || this.lqe.dke() == null) {
            return null;
        }
        if (this.lqe.dke().lsT != null && this.lqe.dke().lsT.isShown()) {
            return this.lqe.dke().lsT;
        }
        return this.lqe.dke().lsS;
    }

    public t dkc() {
        if (this.lqe == null || this.lqe.dke() == null) {
            return null;
        }
        return this.lqe.dke();
    }
}
