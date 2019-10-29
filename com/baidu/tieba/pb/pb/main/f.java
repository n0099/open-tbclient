package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class f {
    private BdTypeListView dvB;
    private List<com.baidu.adp.widget.ListView.a> fNd;
    private com.baidu.adp.widget.ListView.a gmb;
    private PbActivity hNY;
    private o hNZ;
    private Runnable hOA;
    private int hOC;
    private com.baidu.tieba.pb.pb.main.a.a hOa;
    private ak hOb;
    private ak hOc;
    private i hOd;
    private com.baidu.tieba.pb.video.a hOe;
    private com.baidu.adp.widget.ListView.a hOf;
    private ag hOg;
    private ah hOh;
    private com.baidu.tieba.pb.pb.a.b hOi;
    private v hOj;
    private ae hOk;
    private com.baidu.tieba.pb.pb.a.d hOl;
    private com.baidu.tieba.pb.data.d hOn;
    private ArrayList<com.baidu.adp.widget.ListView.m> hOo;
    private boolean hOt;
    private boolean hOu;
    private int hOw;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hOm = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hOp = true;
    private boolean hOq = true;
    private boolean hOr = false;
    private boolean hOs = false;
    private boolean hOv = false;
    private String afg = null;
    private PostData hOx = null;
    private View.OnClickListener hOy = null;
    private View.OnClickListener ZX = null;
    private TbRichTextView.h cUE = null;
    private com.baidu.tieba.pb.a.c czv = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hOz = new ArrayList();
    private int hOB = -1;
    private CustomMessageListener fCU = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cnQ = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cnQ();
                Iterator it = cnQ.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).av(f.this.hNY);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hOm.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hOi = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cnQ);
                f.this.hOz.clear();
                f.this.hOz.addAll(arrayList);
                if (f.this.dvB != null) {
                    f.this.dvB.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cwZ = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hOn != null && !com.baidu.adp.base.i.Z(f.this.hNY.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener fNf = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.fNd)) {
                f.this.bvb();
                f.this.a(f.this.hOn, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hOw = 0;
        this.width = -1;
        this.hOC = 0;
        this.hOw = com.baidu.adp.lib.util.l.getEquipmentWidth(pbActivity.getPageContext().getPageActivity());
        this.width = this.hOw;
        this.hNY = pbActivity;
        this.dvB = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cwZ);
        this.hOC = com.baidu.adp.lib.util.l.getEquipmentHeight(this.hNY) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hNZ = new o(pbActivity, PostData.jin);
        this.hNZ.a(pbActivity);
        this.hOa = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.j.hJN);
        this.hOb = new ak(pbActivity, com.baidu.tieba.pb.data.i.hJH);
        this.hOc = new ak(pbActivity, com.baidu.tieba.pb.data.i.hJI);
        this.hOd = new i(pbActivity, PostData.jio);
        this.hOd.a(pbActivity);
        this.gmb = com.baidu.tieba.recapp.r.cfL().a(pbActivity, AdvertAppInfo.bWY);
        this.hOf = com.baidu.tieba.recapp.r.cfL().a(pbActivity, AdvertAppInfo.bXc);
        this.hOj = new v(pbActivity, com.baidu.tieba.pb.data.a.hID);
        this.hOk = new ae(pbActivity, com.baidu.tieba.pb.data.h.hJF);
        this.hOg = new ag(pbActivity, ad.hTr);
        this.hOh = new ah(pbActivity, com.baidu.tbadk.core.data.aq.caf);
        this.hOl = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.jit);
        this.hOe = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.idy);
        this.hOe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hOn.bQK() != null) {
                    pbActivity.bRX().bVh().bRA();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
                }
            }
        });
        this.agQ.add(this.hNZ);
        this.agQ.add(this.hOa);
        this.agQ.add(this.hOd);
        this.agQ.add(this.hOb);
        this.agQ.add(this.hOc);
        this.agQ.add(this.gmb);
        this.agQ.add(this.hOf);
        this.agQ.add(this.hOj);
        this.agQ.add(this.hOk);
        this.agQ.add(this.hOg);
        this.agQ.add(this.hOh);
        this.agQ.add(this.hOe);
        this.agQ.add(this.hOl);
        this.fCU.setPriority(1);
        this.fCU.setSelfListener(true);
        pbActivity.registerListener(this.fCU);
        bva();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.agQ);
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        boolean z5;
        com.baidu.adp.widget.ListView.m bTa;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hOn != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bQx()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hOn = dVar;
            if (z6) {
                bTf();
                if (dVar != null) {
                    dVar.nR(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hOn != null && this.hOn.bQB() != null && this.hOn.bQB().size() > 0) {
                this.postList.addAll(this.hOn.bQB());
            }
            if (dVar != null && dVar.bQz() != null && dVar.bQz().aiG() != null) {
                this.afg = dVar.bQz().aiG().getUserId();
            }
            if (this.hNZ != null) {
                this.hNZ.setData(dVar);
                this.hNZ.setFromCDN(this.mIsFromCDN);
                this.hNZ.wq(this.hOw);
                this.hNZ.nT(this.hOp);
                this.hNZ.w(this.ZX);
                this.hNZ.O(this.hOy);
                this.hNZ.setOnImageClickListener(this.cUE);
                this.hNZ.setOnLongClickListener(this.mOnLongClickListener);
                this.hNZ.setTbGestureDetector(this.czv);
                this.hOd.setData(dVar);
                this.hOd.setFromCDN(this.mIsFromCDN);
                this.hOd.cD(this.afg);
                this.hOd.nT(this.hOp);
                this.hOd.w(this.ZX);
                this.hOd.O(this.hOy);
                this.hOd.setOnImageClickListener(this.cUE);
                this.hOd.setOnLongClickListener(this.mOnLongClickListener);
                this.hOd.setTbGestureDetector(this.czv);
                this.hOa.setOnClickListener(this.ZX);
                this.hOl.setOnClickListener(this.ZX);
                if (this.hOf != null && (this.hOf instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hOf).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hOm.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.cD(this.afg);
                        next.wq(this.hOw);
                        next.nT(this.hOp);
                        next.nU(this.hOq);
                        next.nV(this.hOv);
                        next.w(this.ZX);
                        next.O(this.hOy);
                        next.setOnImageClickListener(this.cUE);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.hOb.w(this.ZX);
                this.hOc.w(this.ZX);
                this.hOb.setData(dVar);
                this.hOc.setData(dVar);
                this.hOg.setData(dVar);
                this.hOh.setData(dVar);
                this.hOj.setData(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bQB());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cop() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hOx = postData;
                }
                boolean z7 = false;
                if (!this.hOq && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bQX() && postData.cor() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bQG() != null) {
                    postData = dVar.bQG();
                    z7 = true;
                    z2 = true;
                    if (!this.hOq && dVar.bQX() && postData.cor() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dU(arrayList);
                if (this.hNY.bSw()) {
                    if (dVar.bQB().size() > 0 && (postData2 = dVar.bQB().get(0)) != null && postData2.cop() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hOn, arrayList, this.hOq);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList, b, this.hOn.bQC());
                    }
                }
                int c = c(this.hOn, arrayList, this.hOq);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList, c, this.hOn.bQD());
                }
                com.baidu.tieba.tbadkCore.s.n(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hJH);
                    if (dVar != null && dVar.bQz() != null) {
                        iVar.hJJ = dVar.bQz().aix();
                    }
                    iVar.isNew = !this.hOq;
                    iVar.hJM = this.hNY.bSI();
                    iVar.sortType = dVar.hJn;
                    if (dVar.hJm != null && dVar.hJm.size() > dVar.hJn) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hJm.size()) {
                                break;
                            } else if (dVar.hJm.get(i3).sort_type.intValue() != dVar.hJn) {
                                i2 = i3 + 1;
                            } else {
                                iVar.hJL = dVar.hJm.get(i3).sort_name;
                                break;
                            }
                        }
                    }
                    com.baidu.tbadk.core.util.v.add(arrayList, c2, iVar);
                    z10 = true;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.m> f = f(dVar);
                if (com.baidu.tbadk.core.util.v.isEmpty(f) || b2 < 0) {
                    z3 = z10;
                } else {
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, b2);
                    if (mVar instanceof PostData) {
                        ((PostData) mVar).jiZ = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList, b2, f);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hOq);
                }
                if (i < 0 || dVar.bQW() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList, i, dVar.bQW());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bTa = bTa()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.add(arrayList, i + 1, bTa);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bTb = bTb();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bTb != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList, i4, bTb);
                    }
                }
                this.hNZ.ol(!z4);
                boolean z12 = false;
                if (this.hNY.bRF() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hNY.bRF().getPostId())) {
                    z12 = true;
                }
                if (this.hOr && !z12) {
                    arrayList.remove(postData3);
                    this.hOr = false;
                }
                if (dVar.bQW() != null) {
                    if (z5) {
                        dVar.bQW().nS(false);
                    } else {
                        dVar.bQW().nS(true);
                    }
                }
                if (this.dvB != null) {
                    this.hOo = arrayList;
                    this.dvB.setData(this.hOo);
                }
                if (!z12 && !z && ((this.hOt || this.hOs) && b2 != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.hOu)) {
                    this.hOA = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.dvB.setSelectionFromTop(f.this.dvB.getHeaderViewsCount() + f.size(), 0 - f.this.hOC);
                            f.this.hOu = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.fZ().post(this.hOA);
                }
                if (postData3 == null) {
                    if (this.hOx != null && !this.hOs) {
                        com.baidu.tbadk.core.util.v.add(arrayList, 0, this.hOx);
                    } else {
                        PostData postData4 = new PostData();
                        postData4.zR(1);
                        com.baidu.tbadk.core.util.v.add(arrayList, 0, postData4);
                    }
                    this.dvB.setData(arrayList);
                } else if (z9) {
                    com.baidu.tbadk.core.util.v.add(arrayList, 0, postData3);
                    this.dvB.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m bTa() {
        PbModel bRF = this.hNY.bRF();
        if (bRF == null) {
            return null;
        }
        String bUo = bRF.bUo();
        if (TextUtils.isEmpty(bUo)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.DN(bUo);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bTb() {
        if (this.hOn == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bTL = this.hNY.bRF().bTL();
        if (bTL == null) {
            bTL = this.hOn.bQO();
        }
        if (bTL != null) {
            AdvertAppInfo.ILegoAdvert coe = bTL.coe();
            if (coe != null) {
                coe.setAdvertAppInfo(bTL.kd());
            }
            int agR = bTL.cod().agR();
            if (agR != 0) {
                a(bTL, agR);
                if (agR == 28 || agR == 31 || bTL.cod().goods == null) {
                    return null;
                }
                bTL.cod().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                return null;
            }
            if (this.hOn.getForum() != null) {
                bTL.forumId = this.hOn.getForum().getId();
            }
            if (this.hOn.bQz() != null) {
                bTL.threadId = com.baidu.adp.lib.g.b.toLong(this.hOn.bQz().getId(), 0L);
            }
            if (this.hOn != null && this.hOn.getPage() != null) {
                bTL.pageNumber = this.hOn.getPage().ahy();
            }
            c(bTL);
            return bTL;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hOs || dVar == null || com.baidu.tbadk.core.util.v.isEmpty(dVar.bQB()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bQX() && this.hOq) ? 0 : -1;
        } else if (this.hNY.bRF() == null || !this.hNY.bRF().getIsFromMark()) {
            if (this.hNY.bRX() == null || !this.hNY.bRX().bWj()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = arrayList.get(i2);
                    if (mVar instanceof PostData) {
                        PostData postData = (PostData) mVar;
                        if (postData.cop() == 1 && postData.jiW == 0) {
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
                return dVar.bQX() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.isEmpty(dVar.bQB()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(dVar.bQB(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.m mVar = arrayList.get(i2);
            if (mVar instanceof PostData) {
                PostData postData = (PostData) mVar;
                if (postData.cop() == 1 && postData.jiW == 0) {
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

    private int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || com.baidu.tbadk.core.util.v.isEmpty(dVar.bQB()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bQX()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bQB().get(0) == null || dVar.bQB().get(0).cop() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bQK() == null || com.baidu.tbadk.core.util.v.isEmpty(dVar.bQK().hJX)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bQK().hJX;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.jjj = true;
                postData.jiY = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(dVar.bQK().hJY) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).jiY = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).jiY = true;
            }
        }
        com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hJI);
        iVar.hJK = dVar.bQK().forum_top_list;
        arrayList.add(0, iVar);
        return arrayList;
    }

    private void bva() {
        if (this.hNY != null && !bvb()) {
            this.hNY.registerListener(this.fNf);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean bvb() {
        if (this.hNY == null) {
            return false;
        }
        this.fNd = new ArrayList();
        ArrayList<BdUniqueId> cnD = com.baidu.tieba.tbadkCore.s.cnD();
        if (cnD == null || cnD.size() <= 0) {
            return false;
        }
        int size = cnD.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bJn().a(this.hNY.getPageContext(), cnD.get(i), 2);
            if (a != null) {
                this.agQ.add(a);
                this.fNd.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.fNd)) {
            this.dvB.addAdapters(this.fNd);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.dvB.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bQB() == null || dVar.bQC() == null || dVar.bQB().size() == 0 || dVar.bQz() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bQC().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bQB().get(0) == null || dVar.bQB().get(0).cop() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().ahy() != dVar.getPage().ahv()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bQB() == null || dVar.bQD() == null || dVar.bQB().size() == 0 || dVar.bQz() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bQD().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bQB().get(0) == null || dVar.bQB().get(0).cop() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().ahy() != dVar.getPage().ahv()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.dvB.getItem(i);
    }

    public ArrayList<PostData> bTc() {
        return this.postList;
    }

    public BdUniqueId wx(int i) {
        if (this.dvB.getItem(i) != null) {
            return this.dvB.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hOi == null || !this.hOi.bRy()) {
            this.hOB = bTd();
            if (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.dvB.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bTd() {
        if (this.dvB != null && this.dvB.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dvB.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.dvB.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.i.hJH) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bTe() {
        return this.hOB;
    }

    private void bTf() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hOn != null) {
            ArrayList<PostData> bQB = this.hOn.bQB();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bQN = this.hOn.bQN();
            if (bQN != null) {
                int size = bQN.size();
                if (bQB != null && bQB.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bQN.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next = it.next();
                        if (next != null && next.getAdId() != null) {
                            sb.append(next.getAdId());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bQN.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fNb = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bQN.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cod() != null) {
                            int agR = next3.cod().agR();
                            if (agR != 0) {
                                a(next3, agR);
                                if (agR != 28 && agR != 31) {
                                    if (next3.cod().goods != null) {
                                        next3.cod().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.w.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cod().apk_name)) {
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
                        com.baidu.tieba.tbadkCore.data.m mVar3 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(sparseArray.keyAt(i));
                        if (mVar3 != null && (mVar2 = (com.baidu.tieba.tbadkCore.data.m) hashMap.put(mVar3.getAdId(), mVar3)) != null) {
                            b(mVar2, 30);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (mVar = (com.baidu.tieba.tbadkCore.data.m) entry.getValue()) != null) {
                            sparseArray.put(mVar.getPosition(), mVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.f.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: b */
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.m mVar4 = (com.baidu.tieba.tbadkCore.data.m) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.hOn.getForum() != null) {
                            mVar4.forumId = this.hOn.getForum().getId();
                        }
                        if (this.hOn.bQz() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.toLong(this.hOn.bQz().getId(), 0L);
                        }
                        if (this.hOn != null && this.hOn.getPage() != null) {
                            mVar4.pageNumber = this.hOn.getPage().ahy();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bQB.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hOq) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bQB.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hNY.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cod().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.yr(i);
        com.baidu.tieba.recapp.report.c.cgI().a(c);
        if (mVar != null && mVar.cod() != null) {
            mVar.cod().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cod() != null && mVar.cod().goods != null && mVar.cod().goods.goods_style != 1001 && mVar.cod().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hOn != null && mVar.cod() != null) {
            mVar.cod().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hOn.getPage() != null) {
                mVar.cod().advertAppContext.pn = this.hOn.getPage().ahy();
            }
            mVar.cod().advertAppContext.page = mVar.cog();
            if (this.hOn.getForum() != null && (forum = this.hOn.getForum()) != null) {
                mVar.cod().advertAppContext.fid = forum.getId();
                mVar.cod().advertAppContext.bWP = forum.getFirst_class();
                mVar.cod().advertAppContext.bWQ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cod().advertAppContext.bWR = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cod().advertAppContext.extensionInfo = mVar.cod().ext_info;
            mVar.cod().advertAppContext.AJ = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hNZ.setFromCDN(z);
        if (this.hOf != null && (this.hOf instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hOf).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hOm.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bTg() {
        return this.hOp;
    }

    public void nT(boolean z) {
        this.hOp = z;
    }

    public void nU(boolean z) {
        this.hOq = z;
    }

    public void nV(boolean z) {
        this.hOv = z;
    }

    public void O(View.OnClickListener onClickListener) {
        this.hOy = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cUE = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.czv = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.ZX = onClickListener;
    }

    public void wy(int i) {
        switch (i) {
            case 1:
                if (this.hOi != null) {
                    this.hOi.pause();
                }
                if (this.hNZ != null) {
                    this.hNZ.pause();
                    return;
                }
                return;
            case 2:
                if (this.hOi != null) {
                    this.hOi.resume();
                }
                if (this.hNZ != null) {
                    this.hNZ.resume();
                    return;
                }
                return;
            case 3:
                if (this.hOi != null) {
                    this.hOi.release();
                }
                if (this.hNZ != null) {
                    this.hNZ.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dU(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.ajI())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.mP(postData.ajI());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hOA);
        if (this.hOb != null) {
            this.hOb.onDestroy();
        }
        if (this.hOc != null) {
            this.hOc.onDestroy();
        }
        if (this.hOa != null) {
            this.hOa.onDestroy();
        }
    }

    public void og(boolean z) {
        this.hOs = z;
    }

    public void oh(boolean z) {
        this.hOt = z;
    }

    public void oi(boolean z) {
        this.hOr = z;
    }

    public void oj(boolean z) {
        this.hOu = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bTh() {
        return this.hOa;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.hOo;
    }

    public View bTi() {
        if (this.hNZ == null || this.hNZ.bTm() == null) {
            return null;
        }
        if (this.hNZ.bTm().hPZ != null && this.hNZ.bTm().hPZ.isShown()) {
            return this.hNZ.bTm().hPZ;
        }
        return this.hNZ.bTm().hPY;
    }

    public p bTj() {
        if (this.hNZ == null || this.hNZ.bTm() == null) {
            return null;
        }
        return this.hNZ.bTm();
    }
}
