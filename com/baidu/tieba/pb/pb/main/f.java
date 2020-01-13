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
import com.baidu.tbadk.core.data.bj;
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
/* loaded from: classes7.dex */
public class f {
    private ArrayList<com.baidu.adp.widget.ListView.m> eei;
    private BdTypeListView efW;
    private List<com.baidu.adp.widget.ListView.a> gDJ;
    private com.baidu.adp.widget.ListView.a hcm;
    private q iCI;
    private com.baidu.tieba.pb.pb.main.adapter.c iCJ;
    private com.baidu.tieba.pb.pb.main.adapter.a iCK;
    private al iCL;
    private al iCM;
    private k iCN;
    private com.baidu.tieba.pb.video.a iCO;
    private com.baidu.tieba.card.divider.a iCP;
    private com.baidu.adp.widget.ListView.a iCQ;
    private ah iCR;
    private ai iCS;
    private com.baidu.tieba.pb.pb.a.b iCT;
    private w iCU;
    private af iCV;
    private com.baidu.tieba.pb.pb.a.d iCW;
    private g iCY;
    private com.baidu.tieba.pb.data.f iCZ;
    private PbFragment iCe;
    private boolean iDe;
    private boolean iDf;
    private int iDh;
    private Runnable iDl;
    private int iDn;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> iCX = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean iDa = true;
    private boolean iDb = true;
    private boolean iDc = false;
    private boolean iDd = false;
    private boolean iDg = false;
    private String anD = null;
    private PostData iDi = null;
    private View.OnClickListener iDj = null;
    private View.OnClickListener ain = null;
    private TbRichTextView.i dIr = null;
    private com.baidu.tieba.pb.a.c dmA = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> iDk = new ArrayList();
    private int iDm = -1;
    private CustomMessageListener gtx = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList cIY = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).cIY();
                Iterator it = cIY.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).a(f.this.iCe);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.iCX.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.iCT = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(cIY);
                f.this.iDk.clear();
                f.this.iDk.addAll(arrayList);
                if (f.this.efW != null) {
                    f.this.efW.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener dkk = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.iCZ != null && !com.baidu.adp.base.i.Z(f.this.iCe.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private final View.OnClickListener iDo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.iCe != null && f.this.iCZ != null && f.this.iCZ.cjd() != null) {
                f.this.iCe.ckX().cnY().cjX();
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12040"));
            }
        }
    };
    private CustomMessageListener gDL = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.isEmpty(f.this.gDJ)) {
                f.this.bNv();
                f.this.a(f.this.iCZ, false);
            }
        }
    };

    public f(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iDh = 0;
        this.width = -1;
        this.iDn = 0;
        this.iDh = com.baidu.adp.lib.util.l.getEquipmentWidth(pbFragment.getPageContext().getPageActivity());
        this.width = this.iDh;
        this.iCe = pbFragment;
        this.efW = bdTypeListView;
        a(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.dkk);
        this.iDn = com.baidu.adp.lib.util.l.getEquipmentHeight(this.iCe.getContext()) / 3;
    }

    public void a(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        this.iCI = new q(pbFragment, PostData.kfl);
        this.iCI.a((TbRichTextView.c) pbFragment);
        this.iCJ = new com.baidu.tieba.pb.pb.main.adapter.c(pbFragment, com.baidu.tieba.pb.data.l.iAO);
        this.iCK = new com.baidu.tieba.pb.pb.main.adapter.a(pbFragment, com.baidu.tieba.pb.data.b.izx);
        this.iCL = new al(pbFragment, com.baidu.tieba.pb.data.k.iAI);
        this.iCM = new al(pbFragment, com.baidu.tieba.pb.data.k.iAJ);
        this.iCN = new k(pbFragment, PostData.kfm);
        this.iCN.a((TbRichTextView.c) pbFragment);
        this.hcm = com.baidu.tieba.recapp.r.cAV().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cIG);
        this.iCQ = com.baidu.tieba.recapp.r.cAV().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.cIK);
        this.iCU = new w(pbFragment, com.baidu.tieba.pb.data.a.izu);
        this.iCV = new af(pbFragment, com.baidu.tieba.pb.data.j.iAG);
        this.iCR = new ah(pbFragment, ae.iKL);
        this.iCS = new ai(pbFragment, com.baidu.tbadk.core.data.at.cLQ);
        this.iCW = new com.baidu.tieba.pb.pb.a.d(pbFragment, PostData.kfr);
        this.iCO = new com.baidu.tieba.pb.video.a(pbFragment, com.baidu.tieba.pb.video.b.iVt);
        this.iCP = new com.baidu.tieba.card.divider.a(pbFragment.getPageContext());
        this.iCY = new g(pbFragment, com.baidu.tbadk.core.data.l.cJQ);
        this.apl.add(this.iCI);
        this.apl.add(this.iCJ);
        this.apl.add(this.iCK);
        this.apl.add(this.iCN);
        this.apl.add(this.iCL);
        this.apl.add(this.iCM);
        this.apl.add(this.hcm);
        this.apl.add(this.iCQ);
        this.apl.add(this.iCU);
        this.apl.add(this.iCV);
        this.apl.add(this.iCR);
        this.apl.add(this.iCS);
        this.apl.add(this.iCO);
        this.apl.add(this.iCW);
        this.apl.add(this.iCP);
        this.apl.add(this.iCY);
        this.gtx.setPriority(1);
        this.gtx.setSelfListener(true);
        pbFragment.registerListener(this.gtx);
        bNu();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbFragment.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.apl);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04cf A[LOOP:3: B:175:0x04cd->B:176:0x04cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x04b2 A[EDGE_INSN: B:251:0x04b2->B:165:0x04b2 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        PostData postData;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        boolean z7;
        int i2;
        ArrayList arrayList;
        boolean z8;
        int i3;
        int size;
        int min;
        int i4;
        int i5;
        com.baidu.adp.widget.ListView.m ckA;
        bj ciS;
        PostData postData2;
        if (fVar != null) {
            boolean z9 = false;
            if (this.iCZ != fVar) {
                z9 = true;
                if ((fVar != null && !fVar.ciQ()) || !TbadkCoreApplication.getInst().isRecAppExist()) {
                    z9 = false;
                }
            }
            this.iCZ = fVar;
            if (z9) {
                ckF();
                if (fVar != null) {
                    fVar.pr(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.iCZ != null && this.iCZ.ciU() != null && this.iCZ.ciU().size() > 0) {
                this.postList.addAll(this.iCZ.ciU());
            }
            if (fVar != null && fVar.ciS() != null && fVar.ciS().azX() != null) {
                this.anD = fVar.ciS().azX().getUserId();
            }
            if (this.iCI != null) {
                this.iCI.setData(fVar);
                this.iCI.setFromCDN(this.mIsFromCDN);
                this.iCI.setImageMaxWidth(this.iDh);
                this.iCI.pt(this.iDa);
                this.iCI.x(this.ain);
                this.iCI.O(this.iDj);
                this.iCI.setOnImageClickListener(this.dIr);
                this.iCI.setOnLongClickListener(this.mOnLongClickListener);
                this.iCI.setTbGestureDetector(this.dmA);
                this.iCN.setData(fVar);
                this.iCN.setFromCDN(this.mIsFromCDN);
                this.iCN.dx(this.anD);
                this.iCN.pt(this.iDa);
                this.iCN.x(this.ain);
                this.iCN.O(this.iDj);
                this.iCN.setOnImageClickListener(this.dIr);
                this.iCN.setOnLongClickListener(this.mOnLongClickListener);
                this.iCN.setTbGestureDetector(this.dmA);
                this.iCJ.setOnClickListener(this.ain);
                this.iCW.setOnClickListener(this.ain);
                this.iCO.setOnClickListener(this.iDo);
                if (this.iCQ != null && (this.iCQ instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.iCQ).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iCX.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.setData(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.dx(this.anD);
                        next.setImageMaxWidth(this.iDh);
                        next.pt(this.iDa);
                        next.pu(this.iDb);
                        next.pv(this.iDg);
                        next.x(this.ain);
                        next.O(this.iDj);
                        next.setOnImageClickListener(this.dIr);
                        next.setOnLongClickListener(this.mOnLongClickListener);
                    }
                }
                this.iCL.x(this.ain);
                this.iCM.x(this.ain);
                this.iCL.setData(fVar);
                this.iCK.setData(fVar);
                this.iCM.setData(fVar);
                this.iCR.setData(fVar);
                this.iCS.setData(fVar);
                this.iCU.setData(fVar);
                this.iCY.setPbData(fVar);
                this.iCY.setFrom(this.iCe.iGA);
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>(fVar.ciU());
                Iterator<com.baidu.adp.widget.ListView.m> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z2 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.m next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).cJx() == 1) {
                        z2 = true;
                        postData = (PostData) next2;
                        break;
                    }
                }
                if (postData != null) {
                    this.iDi = postData;
                }
                boolean z10 = false;
                if (!this.iDb && postData != null) {
                    arrayList2.remove(postData);
                    z10 = true;
                    z2 = true;
                    if (fVar.cjp() && postData.cJz() != null) {
                        postData.c(null);
                    }
                }
                if (!z2 && fVar.ciZ() != null) {
                    postData = fVar.ciZ();
                    z10 = true;
                    z2 = true;
                    if (!this.iDb && fVar.cjp() && postData.cJz() != null) {
                        postData.c(null);
                    }
                }
                boolean z11 = z2;
                PostData postData3 = postData;
                boolean z12 = z10;
                dJ(arrayList2);
                if (this.iCe.clw()) {
                    if (fVar.ciU().size() > 0 && (postData2 = fVar.ciU().get(0)) != null && postData2.cJx() == 1 && !com.baidu.tbadk.core.util.v.isEmpty(arrayList2)) {
                        arrayList2.remove(0);
                    }
                } else {
                    int b = b(this.iCZ, arrayList2, this.iDb);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, b, this.iCZ.ciV());
                    }
                }
                int c = c(this.iCZ, arrayList2, this.iDb);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, c, this.iCZ.ciW());
                }
                com.baidu.tieba.tbadkCore.s.o(arrayList2, 1);
                boolean z13 = false;
                int b2 = b(fVar, arrayList2);
                if (b2 >= 0) {
                    com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k(com.baidu.tieba.pb.data.k.iAI);
                    kVar.iAK = fVar.ciS() != null ? ciS.azO() : 0L;
                    kVar.isNew = !this.iDb;
                    kVar.iAN = this.iCe.clG();
                    kVar.sortType = fVar.izK;
                    kVar.iAM = fVar.cjt();
                    kVar.isDynamic = fVar.cjs();
                    com.baidu.tbadk.core.util.v.add(arrayList2, b2, kVar);
                    z13 = true;
                }
                int a = a(fVar, arrayList2);
                final List<com.baidu.adp.widget.ListView.m> f = f(fVar);
                if (com.baidu.tbadk.core.util.v.isEmpty(f) || a < 0) {
                    z3 = z13;
                } else {
                    com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList2, a);
                    if (mVar instanceof PostData) {
                        ((PostData) mVar).kfY = true;
                    }
                    com.baidu.tbadk.core.util.v.addAll(arrayList2, a, f);
                    z3 = true;
                }
                int i6 = -1;
                if (z11) {
                    i6 = a(fVar, arrayList2, this.iDb);
                }
                if (i6 >= 0 && fVar.cjo() != null) {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, fVar.cjo());
                    z4 = true;
                    z5 = true;
                } else {
                    postData3.kfX = true;
                    z4 = false;
                    z5 = z3;
                }
                if (i6 < 0 || !fVar.izO || fVar.izP == null) {
                    i = i6;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i6, fVar.izP);
                    i = i6 + 1;
                }
                boolean z14 = false;
                if (!z11 || (ckA = ckA()) == null || i < 0) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.add(arrayList2, i + 1, ckA);
                    z14 = true;
                    z6 = true;
                }
                int i7 = -1;
                if (z11 && !z6) {
                    com.baidu.adp.widget.ListView.m ckB = ckB();
                    if (i >= 0) {
                        i7 = i + 1;
                    } else if (a >= 0) {
                        i7 = a;
                    } else if (b2 >= 0) {
                        i7 = b2;
                    }
                    if (ckB != null && i7 >= 0) {
                        com.baidu.tbadk.core.util.v.add(arrayList2, i7, ckB);
                        z7 = true;
                        i2 = i7;
                        arrayList = new ArrayList();
                        if (!com.baidu.tbadk.core.util.v.isEmpty(fVar.cjr()) && fVar.cjr().size() > 2) {
                            min = Math.min(fVar.cjr().size(), 7);
                            i4 = 0;
                            while (true) {
                                i5 = i4;
                                if (i5 < min) {
                                    break;
                                }
                                com.baidu.tbadk.core.data.l lVar = fVar.cjr().get(i5);
                                if (i5 == 0) {
                                    lVar.fn(true);
                                }
                                if (lVar.aAo() == null) {
                                    if (i5 == min - 1) {
                                        lVar.fo(true);
                                    }
                                } else if (i5 == min - 2) {
                                    lVar.fo(true);
                                } else if (i5 == min - 1) {
                                    lVar.fp(true);
                                }
                                arrayList.add(lVar);
                                i4 = i5 + 1;
                            }
                        }
                        if (z11 && arrayList != null) {
                            if (!z7 && i2 >= 0) {
                                i3 = i2 + 1;
                            } else if (!z7) {
                                i3 = i + 2;
                            } else if (i >= 0) {
                                i3 = i + 1;
                            } else if (a >= 0) {
                                i3 = a;
                            } else {
                                i3 = b2 >= 0 ? b2 : -1;
                            }
                            if (i3 >= 0 && arrayList.size() > 1) {
                                for (size = arrayList.size() - 1; size >= 0; size--) {
                                    com.baidu.tbadk.core.util.v.add(arrayList2, i3, arrayList.get(size));
                                }
                            }
                        }
                        this.iCI.pG(z5);
                        z8 = false;
                        if (this.iCe.ckc() != null && postData3 != null && postData3.getId() != null && postData3.getId().equals(this.iCe.ckc().cma())) {
                            z8 = true;
                        }
                        if (this.iDc && !z8) {
                            arrayList2.remove(postData3);
                            this.iDc = false;
                        }
                        if (fVar.cjo() != null) {
                            fVar.cjo().ps(!z4);
                        }
                        if (this.efW != null) {
                            this.eei = arrayList2;
                            this.efW.setData(this.eei);
                        }
                        if (!z8 && !z && ((this.iDe || this.iDd) && a != -1 && !com.baidu.tbadk.core.util.v.isEmpty(f) && !this.iDf)) {
                            this.iDl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.efW.setSelectionFromTop(f.this.efW.getHeaderViewsCount() + f.size(), 0 - f.this.iDn);
                                    f.this.iDf = false;
                                }
                            };
                            com.baidu.adp.lib.f.e.gx().post(this.iDl);
                        }
                        if (postData3 != null) {
                            if (this.iDi != null && !this.iDd) {
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, this.iDi);
                            } else {
                                PostData postData4 = new PostData();
                                postData4.Cq(1);
                                com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData4);
                            }
                            this.efW.setData(arrayList2);
                            return;
                        } else if (z12) {
                            com.baidu.tbadk.core.util.v.add(arrayList2, 0, postData3);
                            this.efW.setData(arrayList2);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z7 = z14;
                i2 = i7;
                arrayList = new ArrayList();
                if (!com.baidu.tbadk.core.util.v.isEmpty(fVar.cjr())) {
                    min = Math.min(fVar.cjr().size(), 7);
                    i4 = 0;
                    while (true) {
                        i5 = i4;
                        if (i5 < min) {
                        }
                        arrayList.add(lVar);
                        i4 = i5 + 1;
                    }
                }
                if (z11) {
                    if (!z7) {
                    }
                    if (!z7) {
                    }
                    if (i3 >= 0) {
                        while (size >= 0) {
                        }
                    }
                }
                this.iCI.pG(z5);
                z8 = false;
                if (this.iCe.ckc() != null) {
                    z8 = true;
                }
                if (this.iDc) {
                    arrayList2.remove(postData3);
                    this.iDc = false;
                }
                if (fVar.cjo() != null) {
                }
                if (this.efW != null) {
                }
                if (!z8) {
                    this.iDl = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.efW.setSelectionFromTop(f.this.efW.getHeaderViewsCount() + f.size(), 0 - f.this.iDn);
                            f.this.iDf = false;
                        }
                    };
                    com.baidu.adp.lib.f.e.gx().post(this.iDl);
                }
                if (postData3 != null) {
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.m ckA() {
        PbModel ckc = this.iCe.ckc();
        if (ckc == null) {
            return null;
        }
        String cmU = ckc.cmU();
        if (TextUtils.isEmpty(cmU)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m mVar = new com.baidu.tieba.tbadkCore.data.m();
        mVar.IM(cmU);
        c(mVar);
        return mVar;
    }

    private com.baidu.adp.widget.ListView.m ckB() {
        if (this.iCZ == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.m cmp = this.iCe.ckc().cmp();
        if (cmp == null) {
            cmp = this.iCZ.cjh();
        }
        if (cmp != null) {
            AdvertAppInfo.ILegoAdvert cJm = cmp.cJm();
            if (cJm != null) {
                cJm.setAdvertAppInfo(cmp.kv());
            }
            int axZ = cmp.cJl().axZ();
            if (axZ != 0) {
                a(cmp, axZ);
                if (axZ == 28 || axZ == 31 || cmp.cJl().goods == null) {
                    return null;
                }
                cmp.cJl().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                return null;
            }
            if (this.iCZ.getForum() != null) {
                cmp.forumId = this.iCZ.getForum().getId();
            }
            if (this.iCZ.ciS() != null) {
                cmp.threadId = com.baidu.adp.lib.f.b.toLong(this.iCZ.ciS().getId(), 0L);
            }
            if (this.iCZ != null && this.iCZ.getPage() != null) {
                cmp.pageNumber = this.iCZ.getPage().ayP();
            }
            c(cmp);
            return cmp;
        }
        return null;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (this.iDd || fVar == null || com.baidu.tbadk.core.util.v.isEmpty(fVar.ciU()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.cjp() && this.iDb) ? 0 : -1;
        } else if (this.iCe.ckc() == null || !this.iCe.ckc().getIsFromMark()) {
            if (this.iCe.ckX() == null || !this.iCe.ckX().coZ()) {
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
                        if (postData.cJx() == 1 && postData.kfU == 0) {
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
                return fVar.cjp() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.isEmpty(fVar.ciU()) || com.baidu.tbadk.core.util.v.isEmpty(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.getItem(fVar.ciU(), 0)) == null) {
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
                if (postData.cJx() == 1 && postData.kfU == 0) {
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

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (fVar == null || com.baidu.tbadk.core.util.v.isEmpty(fVar.ciU()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.cjp()) ? -1 : 0;
        }
        arrayList.size();
        if (z) {
            return (fVar.ciU().get(0) == null || fVar.ciU().get(0).cJx() != 1) ? -1 : 1;
        }
        return 0;
    }

    private List<com.baidu.adp.widget.ListView.m> f(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.cjd() == null || com.baidu.tbadk.core.util.v.isEmpty(fVar.cjd().iAX)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.cjd().iAX;
        if (com.baidu.tbadk.core.util.v.isEmpty(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.kgi = true;
                postData.kfW = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.getCount(fVar.cjd().iAY) > 2) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar instanceof PostData) {
                ((PostData) mVar).kfW = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, arrayList.size() - 1);
            if (mVar2 instanceof PostData) {
                ((PostData) mVar2).kfW = true;
            }
        }
        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k(com.baidu.tieba.pb.data.k.iAJ);
        kVar.iAL = fVar.cjd().forum_top_list;
        arrayList.add(0, kVar);
        return arrayList;
    }

    private void bNu() {
        if (this.iCe != null && !bNv()) {
            this.iCe.registerListener(this.gDL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bNv() {
        if (this.iCe == null) {
            return false;
        }
        this.gDJ = new ArrayList();
        ArrayList<BdUniqueId> cIK = com.baidu.tieba.tbadkCore.s.cIK();
        if (cIK == null || cIK.size() <= 0) {
            return false;
        }
        int size = cIK.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cbH().a(this.iCe.getPageContext(), cIK.get(i), 2);
            if (a != null) {
                this.apl.add(a);
                this.gDJ.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gDJ)) {
            this.efW.addAdapters(this.gDJ);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.efW.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (fVar == null || fVar.ciU() == null || fVar.ciV() == null || fVar.ciU().size() == 0 || fVar.ciS() == null || arrayList == null) {
            return -1;
        }
        if (fVar.ciV().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.ciU().get(0) == null || fVar.ciU().get(0).cJx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().ayP() != fVar.getPage().ayM()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, boolean z) {
        if (fVar == null || fVar.ciU() == null || fVar.ciW() == null || fVar.ciU().size() == 0 || fVar.ciS() == null || arrayList == null) {
            return -1;
        }
        if (fVar.ciW().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.ciU().get(0) == null || fVar.ciU().get(0).cJx() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().ayP() != fVar.getPage().ayM()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.m getItem(int i) {
        return this.efW.getItem(i);
    }

    public ArrayList<PostData> ckC() {
        return this.postList;
    }

    public BdUniqueId yz(int i) {
        if (this.efW.getItem(i) != null) {
            return this.efW.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.iCT == null || !this.iCT.cjV()) {
            this.iDm = ckD();
            if (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.efW.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int ckD() {
        if (this.efW != null && this.efW.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.efW.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar = this.efW.getData().get(i2);
                if (mVar == null || mVar.getType() != com.baidu.tieba.pb.data.k.iAI) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int ckE() {
        return this.iDm;
    }

    private void ckF() {
        com.baidu.tieba.tbadkCore.data.m mVar;
        com.baidu.tieba.tbadkCore.data.m mVar2;
        if (this.iCZ != null) {
            ArrayList<PostData> ciU = this.iCZ.ciU();
            ArrayList<com.baidu.tieba.tbadkCore.data.m> cjg = this.iCZ.cjg();
            if (cjg != null) {
                int size = cjg.size();
                if (ciU != null && ciU.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it = cjg.iterator();
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
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it2 = cjg.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next2 = it2.next();
                        if (next2 != null) {
                            next2.gDH = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.m> it3 = cjg.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.m next3 = it3.next();
                        if (next3.cJl() != null) {
                            int axZ = next3.cJl().axZ();
                            if (axZ != 0) {
                                a(next3, axZ);
                                if (axZ != 28 && axZ != 31) {
                                    if (next3.cJl().goods != null) {
                                        next3.cJl().goods.goods_style = MessageConfig.ERROR_TASK_OUTTIME;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.w.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.cJl().apk_name)) {
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
                        if (this.iCZ.getForum() != null) {
                            mVar4.forumId = this.iCZ.getForum().getId();
                        }
                        if (this.iCZ.ciS() != null) {
                            mVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.iCZ.ciS().getId(), 0L);
                        }
                        if (this.iCZ != null && this.iCZ.getPage() != null) {
                            mVar4.pageNumber = this.iCZ.getPage().ayP();
                        }
                        c(mVar4);
                        int position2 = mVar4.getPosition();
                        if (position2 + i3 >= ciU.size()) {
                            a(mVar4, 2);
                            return;
                        }
                        if (!this.iDb) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(mVar4, 23);
                            return;
                        }
                        ciU.add(position2, mVar4);
                        TiebaStatic.eventStat(this.iCe.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mVar4.cJl().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(mVar, 5);
        c.AR(i);
        com.baidu.tieba.recapp.report.c.cBP().a(c);
        if (mVar != null && mVar.cJl() != null) {
            mVar.cJl().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.m mVar, int i) {
        if (mVar != null && mVar.cJl() != null && mVar.cJl().goods != null && mVar.cJl().goods.goods_style != 1001 && mVar.cJl().goods.goods_style != -1001) {
            a(mVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.m mVar) {
        ForumData forum;
        if (mVar != null && this.iCZ != null && mVar.cJl() != null) {
            mVar.cJl().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.iCZ.getPage() != null) {
                mVar.cJl().advertAppContext.pn = this.iCZ.getPage().ayP();
            }
            mVar.cJl().advertAppContext.page = mVar.cJo();
            if (this.iCZ.getForum() != null && (forum = this.iCZ.getForum()) != null) {
                mVar.cJl().advertAppContext.fid = forum.getId();
                mVar.cJl().advertAppContext.cIx = forum.getFirst_class();
                mVar.cJl().advertAppContext.cIy = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mVar.cJl().advertAppContext.cIz = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mVar.cJl().advertAppContext.extensionInfo = mVar.cJl().ext_info;
            mVar.cJl().advertAppContext.CU = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.iCI.setFromCDN(z);
        if (this.iCQ != null && (this.iCQ instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.iCQ).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.iCX.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean ckG() {
        return this.iDa;
    }

    public void pt(boolean z) {
        this.iDa = z;
    }

    public void pu(boolean z) {
        this.iDb = z;
    }

    public void pv(boolean z) {
        this.iDg = z;
    }

    public void O(View.OnClickListener onClickListener) {
        this.iDj = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.dIr = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.dmA = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }

    public void yA(int i) {
        switch (i) {
            case 1:
                if (this.iCT != null) {
                    this.iCT.pause();
                }
                if (this.iCI != null) {
                    this.iCI.pause();
                    return;
                }
                return;
            case 2:
                if (this.iCT != null) {
                    this.iCT.resume();
                }
                if (this.iCI != null) {
                    this.iCI.resume();
                    return;
                }
                return;
            case 3:
                if (this.iCT != null) {
                    this.iCT.release();
                }
                if (this.iCI != null) {
                    this.iCI.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void dJ(List<com.baidu.adp.widget.ListView.m> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.aBf())) {
                        com.baidu.tbadk.core.data.ae aeVar = new com.baidu.tbadk.core.data.ae();
                        aeVar.sg(postData.aBf());
                        list.set(i, aeVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iDl);
        if (this.iCL != null) {
            this.iCL.onDestroy();
        }
        if (this.iCM != null) {
            this.iCM.onDestroy();
        }
        if (this.iCJ != null) {
            this.iCJ.onDestroy();
        }
        if (this.iCK != null) {
            this.iCK.onDestroy();
        }
    }

    public void pz(boolean z) {
        this.iDd = z;
    }

    public void pA(boolean z) {
        this.iDe = z;
    }

    public void pB(boolean z) {
        this.iDc = z;
    }

    public void pC(boolean z) {
        this.iDf = z;
    }

    public com.baidu.tieba.pb.pb.main.adapter.c ckH() {
        return this.iCJ;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.eei;
    }

    public View ckI() {
        if (this.iCI == null || this.iCI.ckM() == null) {
            return null;
        }
        if (this.iCI.ckM().iFg != null && this.iCI.ckM().iFg.isShown()) {
            return this.iCI.ckM().iFg;
        }
        return this.iCI.ckM().iFf;
    }

    public r ckJ() {
        if (this.iCI == null || this.iCI.ckM() == null) {
            return null;
        }
        return this.iCI.ckM();
    }
}
