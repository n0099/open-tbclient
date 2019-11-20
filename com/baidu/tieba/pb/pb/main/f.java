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
    private BdTypeListView duK;
    private List<com.baidu.adp.widget.ListView.a> fMm;
    private com.baidu.adp.widget.ListView.a glk;
    private boolean hNC;
    private boolean hND;
    private int hNF;
    private Runnable hNJ;
    private int hNL;
    private PbActivity hNh;
    private o hNi;
    private com.baidu.tieba.pb.pb.main.a.a hNj;
    private ak hNk;
    private ak hNl;
    private i hNm;
    private com.baidu.tieba.pb.video.a hNn;
    private com.baidu.adp.widget.ListView.a hNo;
    private ag hNp;
    private ah hNq;
    private com.baidu.tieba.pb.pb.a.b hNr;
    private v hNs;
    private ae hNt;
    private com.baidu.tieba.pb.pb.a.d hNu;
    private com.baidu.tieba.pb.data.d hNw;
    private ArrayList<com.baidu.adp.widget.ListView.m> hNx;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> hNv = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean hNy = true;
    private boolean hNz = true;
    private boolean hNA = false;
    private boolean hNB = false;
    private boolean hNE = false;
    private String aeO = null;
    private PostData hNG = null;
    private View.OnClickListener hNH = null;
    private View.OnClickListener ZF = null;
    private TbRichTextView.h cTN = null;
    private com.baidu.tieba.pb.a.c cyE = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> hNI = new ArrayList();
    private int hNK = -1;
    private CustomMessageListener fCd = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cnO = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cnO();
                Iterator it = cnO.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).av(f.this.hNh);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.hNv.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.hNr = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cnO);
                f.this.hNI.clear();
                f.this.hNI.addAll(arrayList);
                if (f.this.duK != null) {
                    f.this.duK.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener cwi = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.hNw != null && !com.baidu.adp.base.i.Z(f.this.hNh.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
    private CustomMessageListener fMo = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.fMm)) {
                f.this.buZ();
                f.this.a(f.this.hNw, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hNF = 0;
        this.width = -1;
        this.hNL = 0;
        this.hNF = com.baidu.adp.lib.util.l.getEquipmentWidth(pbActivity.getPageContext().getPageActivity());
        this.width = this.hNF;
        this.hNh = pbActivity;
        this.duK = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cwi);
        this.hNL = com.baidu.adp.lib.util.l.getEquipmentHeight(this.hNh) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.hNi = new o(pbActivity, PostData.jhv);
        this.hNi.a(pbActivity);
        this.hNj = new com.baidu.tieba.pb.pb.main.a.a(pbActivity, com.baidu.tieba.pb.data.j.hIW);
        this.hNk = new ak(pbActivity, com.baidu.tieba.pb.data.i.hIQ);
        this.hNl = new ak(pbActivity, com.baidu.tieba.pb.data.i.hIR);
        this.hNm = new i(pbActivity, PostData.jhw);
        this.hNm.a(pbActivity);
        this.glk = com.baidu.tieba.recapp.r.cfJ().a(pbActivity, AdvertAppInfo.bWh);
        this.hNo = com.baidu.tieba.recapp.r.cfJ().a(pbActivity, AdvertAppInfo.bWl);
        this.hNs = new v(pbActivity, com.baidu.tieba.pb.data.a.hHM);
        this.hNt = new ae(pbActivity, com.baidu.tieba.pb.data.h.hIO);
        this.hNp = new ag(pbActivity, ad.hSA);
        this.hNq = new ah(pbActivity, com.baidu.tbadk.core.data.aq.bZo);
        this.hNu = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.jhB);
        this.hNn = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.icE);
        this.hNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.hNw.bQI() != null) {
                    pbActivity.bRV().bVf().bRy();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
                }
            }
        });
        this.agy.add(this.hNi);
        this.agy.add(this.hNj);
        this.agy.add(this.hNm);
        this.agy.add(this.hNk);
        this.agy.add(this.hNl);
        this.agy.add(this.glk);
        this.agy.add(this.hNo);
        this.agy.add(this.hNs);
        this.agy.add(this.hNt);
        this.agy.add(this.hNp);
        this.agy.add(this.hNq);
        this.agy.add(this.hNn);
        this.agy.add(this.hNu);
        this.fCd.setPriority(1);
        this.fCd.setSelfListener(true);
        pbActivity.registerListener(this.fCd);
        buY();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.agy);
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z) {
        PostData postData;
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        boolean z5;
        com.baidu.adp.widget.ListView.m bSY;
        PostData postData2;
        if (dVar != null) {
            boolean z6 = false;
            if (this.hNw != dVar) {
                z6 = true;
                if ((dVar != null && !dVar.bQv()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z6 = false;
                }
            }
            this.hNw = dVar;
            if (z6) {
                bTd();
                if (dVar != null) {
                    dVar.nR(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.hNw != null && this.hNw.bQz() != null && this.hNw.bQz().size() > 0) {
                this.postList.addAll(this.hNw.bQz());
            }
            if (dVar != null && dVar.bQx() != null && dVar.bQx().aiE() != null) {
                this.aeO = dVar.bQx().aiE().getUserId();
            }
            if (this.hNi != null) {
                this.hNi.setData(dVar);
                this.hNi.setFromCDN(this.mIsFromCDN);
                this.hNi.wp(this.hNF);
                this.hNi.nT(this.hNy);
                this.hNi.w(this.ZF);
                this.hNi.O(this.hNH);
                this.hNi.setOnImageClickListener(this.cTN);
                this.hNi.setOnLongClickListener(this.mOnLongClickListener);
                this.hNi.setTbGestureDetector(this.cyE);
                this.hNm.setData(dVar);
                this.hNm.setFromCDN(this.mIsFromCDN);
                this.hNm.cD(this.aeO);
                this.hNm.nT(this.hNy);
                this.hNm.w(this.ZF);
                this.hNm.O(this.hNH);
                this.hNm.setOnImageClickListener(this.cTN);
                this.hNm.setOnLongClickListener(this.mOnLongClickListener);
                this.hNm.setTbGestureDetector(this.cyE);
                this.hNj.setOnClickListener(this.ZF);
                this.hNu.setOnClickListener(this.ZF);
                if (this.hNo != null && (this.hNo instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.hNo).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hNv.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.cD(this.aeO);
                        next.wp(this.hNF);
                        next.nT(this.hNy);
                        next.nU(this.hNz);
                        next.nV(this.hNE);
                        next.w(this.ZF);
                        next.O(this.hNH);
                        next.setOnImageClickListener(this.cTN);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.hNk.w(this.ZF);
                this.hNl.w(this.ZF);
                this.hNk.setData(dVar);
                this.hNl.setData(dVar);
                this.hNp.setData(dVar);
                this.hNq.setData(dVar);
                this.hNs.setData(dVar);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>(dVar.bQz());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).con() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.hNG = postData;
                }
                boolean z7 = false;
                if (!this.hNz && postData != null) {
                    arrayList.remove(postData);
                    z7 = true;
                    z2 = true;
                    if (dVar.bQV() && postData.cop() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && dVar.bQE() != null) {
                    postData = dVar.bQE();
                    z7 = true;
                    z2 = true;
                    if (!this.hNz && dVar.bQV() && postData.cop() != null) {
                        postData.c(null);
                    }
                }
                boolean z8 = z2;
                PostData postData3 = postData;
                boolean z9 = z7;
                dU(arrayList);
                if (this.hNh.bSu()) {
                    if (dVar.bQz().size() > 0 && (postData2 = dVar.bQz().get(0)) != null && postData2.con() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.hNw, arrayList, this.hNz);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList, b, this.hNw.bQA());
                    }
                }
                int c = c(this.hNw, arrayList, this.hNz);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList, c, this.hNw.bQB());
                }
                com.baidu.tieba.tbadkCore.s.n(arrayList, 1);
                boolean z10 = false;
                int c2 = c(dVar, arrayList);
                if (c2 >= 0) {
                    com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hIQ);
                    if (dVar != null && dVar.bQx() != null) {
                        iVar.hIS = dVar.bQx().aiv();
                    }
                    iVar.isNew = !this.hNz;
                    iVar.hIV = this.hNh.bSG();
                    iVar.sortType = dVar.hIw;
                    if (dVar.hIv != null && dVar.hIv.size() > dVar.hIw) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= dVar.hIv.size()) {
                                break;
                            } else if (dVar.hIv.get(i3).sort_type.intValue() != dVar.hIw) {
                                i2 = i3 + 1;
                            } else {
                                iVar.hIU = dVar.hIv.get(i3).sort_name;
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
                        ((PostData) mVar).jii = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList, b2, f);
                    z3 = true;
                }
                if (!z8) {
                    i = -1;
                } else {
                    i = a(dVar, arrayList, this.hNz);
                }
                if (i < 0 || dVar.bQU() == null) {
                    z4 = z3;
                    z5 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList, i, dVar.bQU());
                    z4 = true;
                    z5 = true;
                }
                boolean z11 = false;
                if (z8 && (bSY = bSY()) != null && i >= 0) {
                    z11 = true;
                    com.baidu.tbadk.core.util.v.add(arrayList, i + 1, bSY);
                }
                if (z8 && !z11) {
                    com.baidu.adp.widget.ListView.m bSZ = bSZ();
                    int i4 = -1;
                    if (i >= 0) {
                        i4 = i + 1;
                    } else if (b2 >= 0) {
                        i4 = b2;
                    } else if (c2 >= 0) {
                        i4 = c2;
                    }
                    if (bSZ != null && i4 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList, i4, bSZ);
                    }
                }
                this.hNi.ol(!z4);
                boolean z12 = false;
                if (this.hNh.bRD() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.hNh.bRD().getPostId())) {
                    z12 = true;
                }
                if (this.hNA && !z12) {
                    arrayList.remove(postData3);
                    this.hNA = false;
                }
                if (dVar.bQU() != null) {
                    if (z5) {
                        dVar.bQU().nS(false);
                    } else {
                        dVar.bQU().nS(true);
                    }
                }
                if (this.duK != null) {
                    this.hNx = arrayList;
                    this.duK.setData(this.hNx);
                }
                if (!z12 && !z && ((this.hNC || this.hNB) && b2 != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.hND)) {
                    this.hNJ = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.duK.setSelectionFromTop(f.this.duK.getHeaderViewsCount() + f.size(), 0 - f.this.hNL);
                            f.this.hND = false;
                        }
                    };
                    com.baidu.adp.lib.g.e.fZ().post(this.hNJ);
                }
                if (postData3 == null) {
                    if (this.hNG != null && !this.hNB) {
                        com.baidu.tbadk.core.util.v.add(arrayList, 0, this.hNG);
                    } else {
                        PostData postData4 = new PostData();
                        postData4.zQ(1);
                        com.baidu.tbadk.core.util.v.add(arrayList, 0, postData4);
                    }
                    this.duK.setData(arrayList);
                } else if (z9) {
                    com.baidu.tbadk.core.util.v.add(arrayList, 0, postData3);
                    this.duK.setData(arrayList);
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m bSY() {
        PbModel bRD = this.hNh.bRD();
        if (bRD == null) {
            return null;
        }
        String bUm = bRD.bUm();
        if (TextUtils.isEmpty(bUm)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.DN(bUm);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m bSZ() {
        if (this.hNw == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m bTJ = this.hNh.bRD().bTJ();
        if (bTJ == null) {
            bTJ = this.hNw.bQM();
        }
        if (bTJ != null) {
            AdvertAppInfo.ILegoAdvert coc = bTJ.coc();
            if (coc != null) {
                coc.setAdvertAppInfo(bTJ.kd());
            }
            int agP = bTJ.cob().agP();
            if (agP != 0) {
                a(bTJ, agP);
                if (agP == 28 || agP == 31 || bTJ.cob().goods == null) {
                    return null;
                }
                bTJ.cob().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                return null;
            }
            if (this.hNw.getForum() != null) {
                bTJ.forumId = this.hNw.getForum().getId();
            }
            if (this.hNw.bQx() != null) {
                bTJ.threadId = com.baidu.adp.lib.g.b.toLong(this.hNw.bQx().getId(), 0L);
            }
            if (this.hNw != null && this.hNw.getPage() != null) {
                bTJ.pageNumber = this.hNw.getPage().ahw();
            }
            c(bTJ);
            return bTJ;
        }
        return null;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.hNB || dVar == null || com.baidu.tbadk.core.util.v.isEmpty(dVar.bQz()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.bQV() && this.hNz) ? 0 : -1;
        } else if (this.hNh.bRD() == null || !this.hNh.bRD().getIsFromMark()) {
            if (this.hNh.bRV() == null || !this.hNh.bRV().bWh()) {
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
                        if (postData.con() == 1 && postData.jif == 0) {
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
                return dVar.bQV() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.v.isEmpty(dVar.bQz()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(dVar.bQz(), 0)) == null) {
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
                if (postData.con() == 1 && postData.jif == 0) {
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
        if (dVar == null || com.baidu.tbadk.core.util.v.isEmpty(dVar.bQz()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.bQV()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (dVar.bQz().get(0) == null || dVar.bQz().get(0).con() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.bQI() == null || com.baidu.tbadk.core.util.v.isEmpty(dVar.bQI().hJg)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.bQI().hJg;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.jis = true;
                postData.jih = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(dVar.bQI().hJh) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).jih = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).jih = true;
            }
        }
        com.baidu.tieba.pb.data.i iVar = new com.baidu.tieba.pb.data.i(com.baidu.tieba.pb.data.i.hIR);
        iVar.hIT = dVar.bQI().forum_top_list;
        arrayList.add(0, iVar);
        return arrayList;
    }

    private void buY() {
        if (this.hNh != null && !buZ()) {
            this.hNh.registerListener(this.fMo);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean buZ() {
        if (this.hNh == null) {
            return false;
        }
        this.fMm = new ArrayList();
        ArrayList<BdUniqueId> cnB = com.baidu.tieba.tbadkCore.s.cnB();
        if (cnB == null || cnB.size() <= 0) {
            return false;
        }
        int size = cnB.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.bJl().a(this.hNh.getPageContext(), cnB.get(i), 2);
            if (a != null) {
                this.agy.add(a);
                this.fMm.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.fMm)) {
            this.duK.addAdapters(this.fMm);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.duK.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bQz() == null || dVar.bQA() == null || dVar.bQz().size() == 0 || dVar.bQx() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bQA().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bQz().get(0) == null || dVar.bQz().get(0).con() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().ahw() != dVar.getPage().aht()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (dVar == null || dVar.bQz() == null || dVar.bQB() == null || dVar.bQz().size() == 0 || dVar.bQx() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bQB().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.bQz().get(0) == null || dVar.bQz().get(0).con() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.getPage() == null || dVar.getPage().ahw() != dVar.getPage().aht()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.duK.getItem(i);
    }

    public ArrayList<PostData> bTa() {
        return this.postList;
    }

    public BdUniqueId ww(int i) {
        if (this.duK.getItem(i) != null) {
            return this.duK.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.hNr == null || !this.hNr.bRw()) {
            this.hNK = bTb();
            if (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.duK.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bTb() {
        if (this.duK != null && this.duK.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.duK.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.duK.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.i.hIQ) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bTc() {
        return this.hNK;
    }

    private void bTd() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.hNw != null) {
            ArrayList<PostData> bQz = this.hNw.bQz();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> bQL = this.hNw.bQL();
            if (bQL != null) {
                int size = bQL.size();
                if (bQz != null && bQz.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = bQL.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = bQL.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.fMk = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = bQL.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cob() != null) {
                            int agP = next3.cob().agP();
                            if (agP != 0) {
                                a(next3, agP);
                                if (agP != 28 && agP != 31) {
                                    if (next3.cob().goods != null) {
                                        next3.cob().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.w.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cob().apk_name)) {
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
                        if (this.hNw.getForum() != null) {
                            mVar4.forumId = this.hNw.getForum().getId();
                        }
                        if (this.hNw.bQx() != null) {
                            mVar4.threadId = com.baidu.adp.lib.g.b.toLong(this.hNw.bQx().getId(), 0L);
                        }
                        if (this.hNw != null && this.hNw.getPage() != null) {
                            mVar4.pageNumber = this.hNw.getPage().ahw();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= bQz.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.hNz) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        bQz.add(position2, mVar4);
                        TiebaStatic.eventStat(this.hNh.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cob().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.yq(i);
        com.baidu.tieba.recapp.report.c.cgG().a(c);
        if (mVar != null && mVar.cob() != null) {
            mVar.cob().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cob() != null && mVar.cob().goods != null && mVar.cob().goods.goods_style != 1001 && mVar.cob().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.hNw != null && mVar.cob() != null) {
            mVar.cob().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.hNw.getPage() != null) {
                mVar.cob().advertAppContext.pn = this.hNw.getPage().ahw();
            }
            mVar.cob().advertAppContext.page = mVar.coe();
            if (this.hNw.getForum() != null && (forum = this.hNw.getForum()) != null) {
                mVar.cob().advertAppContext.fid = forum.getId();
                mVar.cob().advertAppContext.bVY = forum.getFirst_class();
                mVar.cob().advertAppContext.bVZ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cob().advertAppContext.bWa = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cob().advertAppContext.extensionInfo = mVar.cob().ext_info;
            mVar.cob().advertAppContext.Aj = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.hNi.setFromCDN(z);
        if (this.hNo != null && (this.hNo instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.hNo).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.hNv.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bTe() {
        return this.hNy;
    }

    public void nT(boolean z) {
        this.hNy = z;
    }

    public void nU(boolean z) {
        this.hNz = z;
    }

    public void nV(boolean z) {
        this.hNE = z;
    }

    public void O(View.OnClickListener onClickListener) {
        this.hNH = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.cTN = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.cyE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.ZF = onClickListener;
    }

    public void wx(int i) {
        switch (i) {
            case 1:
                if (this.hNr != null) {
                    this.hNr.pause();
                }
                if (this.hNi != null) {
                    this.hNi.pause();
                    return;
                }
                return;
            case 2:
                if (this.hNr != null) {
                    this.hNr.resume();
                }
                if (this.hNi != null) {
                    this.hNi.resume();
                    return;
                }
                return;
            case 3:
                if (this.hNr != null) {
                    this.hNr.release();
                }
                if (this.hNi != null) {
                    this.hNi.release();
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
                    if (!TextUtils.isEmpty(postData.ajG())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.mP(postData.ajG());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hNJ);
        if (this.hNk != null) {
            this.hNk.onDestroy();
        }
        if (this.hNl != null) {
            this.hNl.onDestroy();
        }
        if (this.hNj != null) {
            this.hNj.onDestroy();
        }
    }

    public void og(boolean z) {
        this.hNB = z;
    }

    public void oh(boolean z) {
        this.hNC = z;
    }

    public void oi(boolean z) {
        this.hNA = z;
    }

    public void oj(boolean z) {
        this.hND = z;
    }

    public com.baidu.tieba.pb.pb.main.a.a bTf() {
        return this.hNj;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.hNx;
    }

    public View bTg() {
        if (this.hNi == null || this.hNi.bTk() == null) {
            return null;
        }
        if (this.hNi.bTk().hPi != null && this.hNi.bTk().hPi.isShown()) {
            return this.hNi.bTk().hPi;
        }
        return this.hNi.bTk().hPh;
    }

    public p bTh() {
        if (this.hNi == null || this.hNi.bTk() == null) {
            return null;
        }
        return this.hNi.bTk();
    }
}
