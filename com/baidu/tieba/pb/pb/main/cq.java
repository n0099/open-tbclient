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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class cq {
    private List<com.baidu.adp.widget.ListView.a> bSe;
    private com.baidu.adp.widget.ListView.a bVQ;
    private com.baidu.adp.widget.ListView.a bVR;
    private com.baidu.adp.widget.ListView.a bVS;
    private com.baidu.adp.widget.ListView.a bVT;
    private com.baidu.tieba.pb.data.f eeB;
    private int eey;
    private PbActivity efF;
    private dl ehW;
    private fi ehX;
    private fd ehY;
    private dc ehZ;
    private com.baidu.tieba.pb.video.u eia;
    private com.baidu.tieba.pb.video.w eib;
    private com.baidu.tieba.pb.video.a eic;
    private int eid;
    private com.baidu.adp.widget.ListView.a eif;
    private en eig;
    private eu eih;
    private com.baidu.tieba.pb.pb.a.b eii;
    private com.baidu.tieba.pb.pb.a.h eij;
    private dr eik;
    private ek eil;
    private com.baidu.tieba.pb.pb.a.c eim;
    private boolean eiq;
    private Runnable eiv;
    private BdTypeListView mListView;
    private int width;
    private final int ehV = -1;
    private int eie = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> ein = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eez = true;
    private boolean eio = true;
    private boolean eeA = true;
    private boolean eip = false;
    private boolean eir = false;
    private boolean eis = false;
    private String mHostId = null;
    private View.OnClickListener eeE = null;
    private View.OnClickListener coZ = null;
    private TbRichTextView.e aOe = null;
    private com.baidu.tieba.pb.a.d eeF = null;
    private View.OnLongClickListener atr = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eit = new ArrayList();
    private boolean eiu = false;
    private CustomMessageListener bSl = new cr(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bPk = new cs(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bSm = new cu(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public cq(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eey = 0;
        this.width = -1;
        this.eey = com.baidu.adp.lib.util.k.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.eey;
        this.efF = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bPk);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eij = new com.baidu.tieba.pb.pb.a.h(pbActivity, PostData.fun);
        this.ehW = new dl(pbActivity, PostData.fuk);
        this.ehW.a(pbActivity);
        this.ehX = new fi(pbActivity, com.baidu.tieba.pb.data.k.edG);
        this.ehY = new fd(pbActivity, com.baidu.tieba.pb.data.j.edE);
        this.ehZ = new dc(pbActivity, PostData.ful);
        this.ehZ.a(pbActivity);
        this.bVQ = com.baidu.tieba.recapp.x.aYp().a(pbActivity, AdvertAppInfo.Tc);
        this.bVR = com.baidu.tieba.recapp.x.aYp().a(pbActivity, AdvertAppInfo.Td);
        this.bVS = com.baidu.tieba.recapp.x.aYp().a(pbActivity, AdvertAppInfo.Te);
        this.eif = com.baidu.tieba.recapp.x.aYp().a(pbActivity, AdvertAppInfo.Tf);
        this.bVT = com.baidu.tieba.recapp.x.aYp().a(pbActivity, AdvertAppInfo.Tj);
        this.eik = new dr(pbActivity, com.baidu.tieba.pb.data.a.ecH);
        this.eil = new ek(pbActivity, com.baidu.tieba.pb.data.i.edD);
        this.eig = new en(pbActivity, ej.elo);
        this.eih = new eu(pbActivity, com.baidu.tbadk.core.data.at.Wz);
        this.eia = new com.baidu.tieba.pb.video.u(pbActivity, com.baidu.tieba.pb.video.v.etd);
        this.eib = new com.baidu.tieba.pb.video.w(pbActivity, com.baidu.tieba.pb.video.x.etm);
        this.eib.setOnClickListener(new cv(this));
        this.eic = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.esA);
        this.eic.setOnClickListener(new cw(this));
        this.eim = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Uv);
        this.mAdapters.add(this.ehW);
        this.mAdapters.add(this.ehX);
        this.mAdapters.add(this.ehZ);
        this.mAdapters.add(this.ehY);
        this.mAdapters.add(this.eij);
        this.mAdapters.add(this.bVQ);
        this.mAdapters.add(this.bVR);
        this.mAdapters.add(this.bVS);
        this.mAdapters.add(this.eif);
        this.mAdapters.add(this.bVT);
        this.mAdapters.add(this.eik);
        this.mAdapters.add(this.eil);
        this.mAdapters.add(this.eig);
        this.mAdapters.add(this.eih);
        this.mAdapters.add(this.eia);
        this.mAdapters.add(this.eib);
        this.mAdapters.add(this.eim);
        this.mAdapters.add(this.eic);
        this.bSl.setPriority(1);
        this.bSl.setSelfListener(true);
        pbActivity.registerListener(this.bSl);
        aaA();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        int size;
        PostData postData;
        int size2;
        PostData postData2;
        if (this.eeB != fVar) {
            z2 = (fVar == null || fVar.aHB()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z2 = false;
        }
        this.eeB = fVar;
        if (z2) {
            aJE();
            if (fVar != null) {
                fVar.hJ(false);
            }
        }
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }
        this.postList.clear();
        if (this.eeB != null && this.eeB.aHI() != null && this.eeB.aHI().size() > 0) {
            this.postList.addAll(this.eeB.aHI());
        }
        if (fVar != null && fVar.aHG() != null && fVar.aHG().getAuthor() != null) {
            this.mHostId = fVar.aHG().getAuthor().getUserId();
        }
        if (this.ehW != null) {
            this.eij.b(fVar);
            this.eij.setFromCDN(this.mIsFromCDN);
            this.eij.setHostId(this.mHostId);
            this.eij.nW(this.eey);
            this.eij.hL(this.eez);
            this.eij.hM(this.eeA);
            this.eij.setCommonClickListener(this.coZ);
            this.eij.H(this.eeE);
            this.eij.setOnImageClickListener(this.aOe);
            this.eij.setOnLongClickListener(this.atr);
            this.eij.a(this.eeF);
            this.ehW.b(fVar);
            this.ehW.setFromCDN(this.mIsFromCDN);
            this.ehW.setHostId(this.mHostId);
            this.ehW.nW(this.eey);
            this.ehW.hL(this.eez);
            this.ehW.hM(this.eeA);
            this.ehW.setCommonClickListener(this.coZ);
            this.ehW.H(this.eeE);
            this.ehW.setOnImageClickListener(this.aOe);
            this.ehW.setOnLongClickListener(this.atr);
            this.ehW.a(this.eeF);
            this.ehW.oe(fVar != null ? fVar.aHG().rr() : 0);
            this.ehZ.b(fVar);
            this.ehZ.setFromCDN(this.mIsFromCDN);
            this.ehZ.setHostId(this.mHostId);
            this.ehZ.hL(this.eez);
            this.ehZ.setCommonClickListener(this.coZ);
            this.ehZ.H(this.eeE);
            this.ehZ.setOnImageClickListener(this.aOe);
            this.ehZ.setOnLongClickListener(this.atr);
            this.ehZ.a(this.eeF);
            this.ehX.setOnClickListener(this.coZ);
            if (this.bVR != null && (this.bVR instanceof com.baidu.tieba.recapp.t)) {
                ((com.baidu.tieba.recapp.t) this.bVR).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bVS != null && (this.bVS instanceof com.baidu.tieba.recapp.t)) {
                ((com.baidu.tieba.recapp.t) this.bVS).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bVT != null && (this.bVT instanceof com.baidu.tieba.recapp.t)) {
                ((com.baidu.tieba.recapp.t) this.bVT).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ein.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(fVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.setHostId(this.mHostId);
                    next.nW(this.eey);
                    next.hL(this.eez);
                    next.hM(this.eeA);
                    next.hN(this.eis);
                    next.setCommonClickListener(this.coZ);
                    next.H(this.eeE);
                    next.setOnImageClickListener(this.aOe);
                    next.setOnLongClickListener(this.atr);
                    next.a(this.eeF);
                }
            }
            this.ehY.setCommonClickListener(this.coZ);
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(fVar.aHI());
            Iterator<com.baidu.adp.widget.ListView.v> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                com.baidu.adp.widget.ListView.v next2 = it2.next();
                if ((next2 instanceof PostData) && ((PostData) next2).bgM() == 1) {
                    z3 = true;
                    break;
                }
            }
            bV(arrayList);
            if (this.efF.aJf()) {
                if (fVar.aHI().size() > 0 && (postData2 = fVar.aHI().get(0)) != null && postData2.bgM() == 1 && !com.baidu.tbadk.core.util.x.r(arrayList)) {
                    arrayList.remove(0);
                }
            } else {
                int b = b(this.eeB, arrayList, this.eeA);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.x.a(arrayList, b, this.eeB.aHJ());
                }
            }
            int c = c(this.eeB, arrayList, this.eeA);
            if (c >= 0) {
                com.baidu.tbadk.core.util.x.a(arrayList, c, this.eeB.aHK());
            }
            if (arrayList.size() == 0 && this.efF.aJf()) {
                arrayList.add(new com.baidu.tieba.pb.data.i());
            }
            int a = a(null, arrayList, this.eeA);
            if (a >= 0) {
                List<com.baidu.adp.widget.ListView.v> c2 = c(fVar, arrayList);
                if (c2 != null && c2.size() > 0) {
                    com.baidu.tbadk.core.util.x.a((List) arrayList, a, (List) c2);
                } else {
                    this.eid = 0;
                }
            } else {
                this.eid = 0;
            }
            com.baidu.tieba.tbadkCore.s.r(arrayList, 1);
            if (!z3 || !this.eeA) {
                int q = com.baidu.tbadk.core.util.x.q(arrayList);
                int i = 0;
                while (i < q) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i);
                    if (vVar instanceof PostData) {
                        ((PostData) vVar).bXh = i == 0;
                    }
                    i++;
                }
            }
            int a2 = a(fVar, arrayList);
            List<com.baidu.adp.widget.ListView.v> d = d(fVar);
            if (com.baidu.tbadk.core.util.x.r(d) || a2 < 0) {
                z4 = false;
            } else {
                com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, a2);
                if (vVar2 instanceof PostData) {
                    ((PostData) vVar2).bXh = true;
                }
                com.baidu.tbadk.core.util.x.a((List) arrayList, a2, (List) d);
                z4 = true;
            }
            int b2 = z3 ? b(fVar, arrayList) : -1;
            if (b2 >= 0 && fVar.aId() != null && fVar.aHG().getThreadType() != 40) {
                com.baidu.tbadk.core.util.x.a(arrayList, b2, fVar.aId());
                fVar.aId().hK(!z4);
                z4 = true;
            }
            this.ehW.ia(z4 ? false : true);
            if (!this.eeA && fVar != null && fVar.aHI() != null && (size = fVar.aHI().size()) > 0 && (postData = fVar.aHI().get(size - 1)) != null && postData.bgM() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.mListView != null) {
                this.mListView.setData(arrayList);
            }
            if (!z && this.eiq && a2 != -1 && !com.baidu.tbadk.core.util.x.r(d)) {
                this.eiv = new cx(this, d);
                com.baidu.adp.lib.g.h.fS().post(this.eiv);
            }
        }
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        PostData postData;
        int i;
        int i2 = 0;
        if (fVar == null || com.baidu.tbadk.core.util.x.r(fVar.aHI()) || arrayList == null || arrayList.size() <= 0 || this.efF.aJs() || this.eir || (postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aHI(), 0)) == null) {
            return -1;
        }
        int bgM = postData.bgM();
        int size = arrayList.size();
        while (true) {
            if (i2 >= size) {
                i = -1;
                break;
            }
            com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
            if (vVar != null && (vVar instanceof PostData)) {
                PostData postData2 = (PostData) vVar;
                if (postData2.bgM() == bgM && postData2.fuS == 0) {
                    i = bgM == 1 ? i2 + 1 : i2;
                }
                i2++;
            } else {
                if (vVar != null && (vVar instanceof com.baidu.tieba.pb.data.j)) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (!this.eeA) {
            return -1;
        }
        if (fVar == null || com.baidu.tbadk.core.util.x.r(fVar.aHI()) || arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return -1;
            }
            com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
            if (!(vVar instanceof PostData) || ((PostData) vVar).bgM() != 1) {
                i = i2 + 1;
            } else {
                return i2 + 1;
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.v> d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aHQ() == null || com.baidu.tbadk.core.util.x.r(fVar.aHQ().edU) || this.efF.aJs() || this.eir) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aHQ().edU;
        if (com.baidu.tbadk.core.util.x.r(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.fuU = true;
                arrayList.add(postData);
            }
        }
        int q = com.baidu.tbadk.core.util.x.q(fVar.aHQ().edV);
        if (fVar.aHQ().getCount() != q && q > 2) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, arrayList.size() - 1);
            if (vVar instanceof PostData) {
                ((PostData) vVar).fuU = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, arrayList.size() - 1);
            if (vVar2 instanceof PostData) {
                ((PostData) vVar2).fuU = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
        jVar.mType = 0;
        arrayList.add(0, jVar);
        return arrayList;
    }

    public void aJA() {
        this.eid = 0;
    }

    public int aJB() {
        return this.eie;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.x.r(fVar.aHI()) || com.baidu.tbadk.core.util.x.r(fVar.aHH())) {
            return -1;
        }
        if (z) {
            return (fVar.aHI().get(0) == null || fVar.aHI().get(0).bgM() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.v> c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (fVar == null || arrayList == null || fVar.aHH() == null || fVar.aHH().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<com.baidu.tbadk.core.data.bk> aHH = fVar.aHH();
        int size = aHH.size();
        this.eie = 0;
        if (this.eid + 5 >= size) {
            int i = 0;
            for (com.baidu.tbadk.core.data.bk bkVar : aHH) {
                if (bkVar != null) {
                    com.baidu.tieba.pb.video.v vVar = new com.baidu.tieba.pb.video.v();
                    i++;
                    if (i == 1) {
                        vVar.a(bkVar, true, true, true, i);
                    } else {
                        vVar.a(bkVar, true, true, false, i);
                    }
                    arrayList2.add(vVar);
                    this.eid++;
                }
            }
            if (this.eid <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.eie = arrayList2.size();
            }
            return arrayList2;
        }
        int i2 = this.eid + 5;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            com.baidu.tbadk.core.data.bk bkVar2 = aHH.get(i4);
            if (bkVar2 != null) {
                com.baidu.tieba.pb.video.v vVar2 = new com.baidu.tieba.pb.video.v();
                i3++;
                boolean z = i3 == 1;
                if (i4 == i2 - 1) {
                    vVar2.a(bkVar2, false, true, z, i3);
                } else {
                    vVar2.a(bkVar2, true, true, z, i3);
                }
                arrayList2.add(vVar2);
                this.eid++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.x());
        this.eie = arrayList2.size();
        return arrayList2;
    }

    private void aaA() {
        if (this.efF != null && !aaB()) {
            this.efF.registerListener(this.bSm);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aaB() {
        if (this.efF == null) {
            return false;
        }
        this.bSe = new ArrayList();
        ArrayList<BdUniqueId> bfT = com.baidu.tieba.tbadkCore.s.bfT();
        if (bfT == null || bfT.size() <= 0) {
            return false;
        }
        int size = bfT.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.axu().a(this.efF.getPageContext(), bfT.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.bSe.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.r(this.bSe)) {
            this.mListView.addAdapters(this.bSe);
        }
        return true;
    }

    public int aJC() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aHI() == null || fVar.aHJ() == null || fVar.aHI().size() == 0 || fVar.aHG() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aHJ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aHI().get(0) == null || fVar.aHI().get(0).bgM() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qB() == null || fVar.qB().qv() != fVar.qB().qs()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aHI() == null || fVar.aHK() == null || fVar.aHI().size() == 0 || fVar.aHG() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aHK().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aHI().get(0) == null || fVar.aHI().get(0).bgM() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qB() == null || fVar.qB().qv() != fVar.qB().qs()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aJD() {
        return this.postList;
    }

    public BdUniqueId ob(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.eii == null || !this.eii.aIB()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aJE() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.eeB != null) {
            ArrayList<PostData> aHI = this.eeB.aHI();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> aHU = this.eeB.aHU();
            if (aHU != null) {
                int size = aHU.size();
                if (aHI != null && aHI.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it = aHU.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next = it.next();
                        if (next != null && next.bgC() != null) {
                            sb.append(next.bgC());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = aHU.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                        if (next2 != null) {
                            next2.bWv = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = aHU.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                        if (next3.bgA() != null && next3.bgA().pv()) {
                            if (!com.baidu.tieba.tbadkCore.ac.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bgA().apk_name)) {
                                int position = next3.getPosition();
                                if (position >= 2 && position < 30) {
                                    sparseArray.put(position, next3);
                                } else {
                                    a(next3, 100);
                                }
                            } else {
                                a(next3, 3);
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(sparseArray.keyAt(i));
                        if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.bgC(), oVar3)) != null) {
                            a(oVar2, 100);
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
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new cy(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = oVar4.getPosition();
                        if (a(oVar4, aHI)) {
                            a(oVar4, 100);
                        } else if (position2 + i3 >= aHI.size()) {
                            a(oVar4, 2);
                            return;
                        } else {
                            if (this.eeB.aHE() != null) {
                                oVar4.forumId = this.eeB.aHE().getId();
                            }
                            if (this.eeB.aHG() != null) {
                                oVar4.threadId = com.baidu.adp.lib.g.b.c(this.eeB.aHG().getId(), 0L);
                            }
                            if (this.eeB != null && this.eeB.qB() != null) {
                                oVar4.pageNumber = this.eeB.qB().qv();
                            }
                            b(oVar4);
                            aHI.add(position2, oVar4);
                            TiebaStatic.eventStat(this.efF.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", oVar4.bgA().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.o oVar, int i) {
        com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 5);
        b.qO(i);
        com.baidu.tieba.recapp.report.b.aYZ().a(b);
    }

    private void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData aHE;
        if (oVar != null && this.eeB != null && oVar.bgA() != null) {
            oVar.bgA().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eeB.qB() != null) {
                oVar.bgA().advertAppContext.pn = this.eeB.qB().qv();
            }
            oVar.bgA().advertAppContext.SR = "PB";
            if (this.eeB.aHE() != null && (aHE = this.eeB.aHE()) != null) {
                oVar.bgA().advertAppContext.fid = aHE.getId();
                oVar.bgA().advertAppContext.ST = aHE.getFirst_class();
                oVar.bgA().advertAppContext.SU = aHE.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.bgA().advertAppContext.SV = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.bgA().advertAppContext.extensionInfo = oVar.bgA().ext_info;
            oVar.bgA().advertAppContext.SW = false;
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.o oVar, ArrayList<PostData> arrayList) {
        int q = com.baidu.tbadk.core.util.x.q(arrayList);
        if (oVar == null || q <= 0) {
            return false;
        }
        int position = oVar.getPosition();
        if (q >= 2 || position != q + 1) {
            return false;
        }
        if (this.eeB != null && this.eeB.qB() != null) {
            oVar.pageNumber = this.eeB.qB().qv();
        }
        arrayList.add(oVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eij.setFromCDN(z);
        this.ehW.setFromCDN(z);
        if (this.bVR != null && (this.bVR instanceof com.baidu.tieba.recapp.t)) {
            ((com.baidu.tieba.recapp.t) this.bVR).setIsFromCDN(z);
        }
        if (this.bVS != null && (this.bVS instanceof com.baidu.tieba.recapp.t)) {
            ((com.baidu.tieba.recapp.t) this.bVS).setIsFromCDN(z);
        }
        if (this.bVT != null && (this.bVT instanceof com.baidu.tieba.recapp.t)) {
            ((com.baidu.tieba.recapp.t) this.bVT).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ein.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void hL(boolean z) {
        this.eez = z;
    }

    public void hM(boolean z) {
        this.eeA = z;
    }

    public void hN(boolean z) {
        this.eis = z;
    }

    public void H(View.OnClickListener onClickListener) {
        this.eeE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aOe = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.eeF = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atr = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.coZ = onClickListener;
    }

    public com.baidu.tieba.recapp.t aJF() {
        return (com.baidu.tieba.recapp.t) this.bVR;
    }

    public com.baidu.tieba.recapp.t aJG() {
        return (com.baidu.tieba.recapp.t) this.bVS;
    }

    public void oc(int i) {
        switch (i) {
            case 1:
                if (this.eii != null) {
                    this.eii.pause();
                }
                if (this.eif != null && (this.eif instanceof com.baidu.tieba.recapp.w)) {
                    ((com.baidu.tieba.recapp.w) this.eif).release();
                    return;
                }
                return;
            case 2:
                if (this.eii != null) {
                    this.eii.resume();
                }
                if (this.eif != null && (this.eif instanceof com.baidu.tieba.recapp.w)) {
                    ((com.baidu.tieba.recapp.w) this.eif).resume();
                    return;
                }
                return;
            case 3:
                if (this.eii != null) {
                    this.eii.release();
                }
                if (this.eif != null && (this.eif instanceof com.baidu.tieba.recapp.w)) {
                    ((com.baidu.tieba.recapp.w) this.eif).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void bV(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.st())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.co(postData.st());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eiv);
    }

    public void hX(boolean z) {
        this.eir = z;
    }

    public void hY(boolean z) {
        this.eip = z;
    }

    public void hZ(boolean z) {
        this.eiq = z;
    }
}
