package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.DealInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class cj {
    private BdTypeListView bBT;
    private List<com.baidu.adp.widget.ListView.a> bVM;
    private com.baidu.adp.widget.ListView.a bVw;
    private com.baidu.adp.widget.ListView.a bVx;
    private com.baidu.adp.widget.ListView.a bVy;
    private com.baidu.tieba.pb.data.h ekQ;
    private int els;
    private PbActivity emy;
    private com.baidu.tieba.pb.pb.a.e eoA;
    private cy eoB;
    private dt eoC;
    private du eov;
    private ef eow;
    private em eox;
    private com.baidu.tieba.pb.pb.a.b eoy;
    private com.baidu.tieba.pb.pb.a.z eoz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eoD = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.q> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cHP = true;
    private boolean elt = true;
    private boolean elu = true;
    private boolean eoE = false;
    private String elv = null;
    private View.OnClickListener ely = null;
    private View.OnClickListener bmb = null;
    private TbRichTextView.d aJI = null;
    private com.baidu.tieba.pb.a.d ekU = null;
    private View.OnLongClickListener aoq = null;
    private cs eoF = null;
    private final List<com.baidu.adp.widget.ListView.a> bOr = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eoG = new ArrayList();
    private boolean eoH = false;
    private CustomMessageListener bVQ = new ck(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bQj = new cl(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bVR = new cn(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public cj(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.els = 0;
        this.width = -1;
        this.els = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.els;
        this.emy = pbActivity;
        this.bBT = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bQj);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eoz = new com.baidu.tieba.pb.pb.a.z(pbActivity, com.baidu.tieba.tbadkCore.data.q.fsC);
        this.eoA = new com.baidu.tieba.pb.pb.a.e(pbActivity, com.baidu.tieba.tbadkCore.data.q.Tl);
        this.eov = new du(pbActivity, com.baidu.tieba.tbadkCore.data.q.fsz);
        this.bVw = com.baidu.tieba.recapp.e.bbp().c(pbActivity, com.baidu.tbadk.core.data.b.OR);
        this.bVx = com.baidu.tieba.recapp.e.bbp().c(pbActivity, com.baidu.tbadk.core.data.b.OS);
        this.bVy = com.baidu.tieba.recapp.e.bbp().c(pbActivity, com.baidu.tbadk.core.data.b.OT);
        this.eoB = new cy(pbActivity, com.baidu.tieba.pb.data.c.ejP);
        this.eoC = new dt(pbActivity, com.baidu.tieba.pb.data.l.ekx);
        this.eow = new ef(pbActivity, ds.eqy);
        this.eox = new em(pbActivity, com.baidu.tbadk.core.data.an.RY);
        this.bOr.add(this.eov);
        this.bOr.add(this.eoz);
        this.bOr.add(this.eoA);
        this.bOr.add(this.bVw);
        this.bOr.add(this.bVx);
        this.bOr.add(this.bVy);
        this.bOr.add(this.eoB);
        this.bOr.add(this.eoC);
        this.bOr.add(this.eow);
        this.bOr.add(this.eox);
        this.bVQ.setPriority(1);
        this.bVQ.setSelfListener(true);
        pbActivity.registerListener(this.bVQ);
        acV();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(0);
        aVar.ejJ = pbActivity;
        aVar.bOr = this.bOr;
        aVar.aLC();
        this.eoF = aVar.ejM;
        bdTypeListView.g(this.bOr);
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        boolean z;
        com.baidu.tieba.tbadkCore.data.q qVar;
        int size;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        int size2;
        if (this.ekQ != hVar) {
            z = (hVar == null || hVar.aLM()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.ekQ = hVar;
        if (z) {
            aNq();
            if (hVar != null) {
                hVar.hM(false);
            }
        }
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }
        this.postList.clear();
        if (this.ekQ != null && this.ekQ.aLR() != null && this.ekQ.aLR().size() > 0) {
            this.postList.addAll(this.ekQ.aLR());
        }
        if (hVar != null && hVar.aLQ() != null && hVar.aLQ().getAuthor() != null) {
            this.elv = hVar.aLQ().getAuthor().getUserId();
        }
        if (this.eov != null) {
            this.eoz.b(hVar);
            this.eoz.setFromCDN(this.mIsFromCDN);
            this.eoz.oL(this.elv);
            this.eoz.oa(this.els);
            this.eoz.hN(this.cHP);
            this.eoz.hO(this.elt);
            this.eoz.hP(this.elu);
            this.eoz.setCommonClickListener(this.bmb);
            this.eoz.G(this.ely);
            this.eoz.setOnImageClickListener(this.aJI);
            this.eoz.setOnLongClickListener(this.aoq);
            this.eoz.a(this.ekU);
            this.eoA.b(hVar);
            this.eoA.setFromCDN(this.mIsFromCDN);
            this.eoA.a(this.ekU);
            this.eov.b(hVar);
            this.eov.setFromCDN(this.mIsFromCDN);
            this.eov.oL(this.elv);
            this.eov.oa(this.els);
            this.eov.hN(this.cHP);
            this.eov.hO(this.elt);
            this.eov.hP(this.elu);
            this.eov.hQ(this.eoE);
            this.eov.setCommonClickListener(this.bmb);
            this.eov.G(this.ely);
            this.eov.setOnImageClickListener(this.aJI);
            this.eov.setOnLongClickListener(this.aoq);
            this.eov.a(this.ekU);
            if (this.bVw != null && (this.bVw instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVw).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bVx != null && (this.bVx instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVx).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eoD.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(hVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.oL(this.elv);
                    next.oa(this.els);
                    next.hN(this.cHP);
                    next.hO(this.elt);
                    next.hP(this.elu);
                    next.hQ(this.eoE);
                    next.setCommonClickListener(this.bmb);
                    next.G(this.ely);
                    next.setOnImageClickListener(this.aJI);
                    next.setOnLongClickListener(this.aoq);
                    next.a(this.ekU);
                }
            }
            com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(1);
            aVar.ejL = this.bmb;
            aVar.ejM = this.eoF;
            aVar.aLC();
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (hVar.aLR() != null) {
                arrayList.addAll(hVar.aLR());
            }
            cv(arrayList);
            if (!this.elu && hVar != null && hVar.aLR() != null && (size = hVar.aLR().size()) > 0 && (qVar2 = hVar.aLR().get(size - 1)) != null && qVar2.bjc() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.emy.aMY()) {
                if (hVar.aLR().size() > 0 && (qVar = hVar.aLR().get(0)) != null && qVar.bjc() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int a = a(this.ekQ, arrayList, this.elu);
                if (a >= 0) {
                    com.baidu.tbadk.core.util.y.a(arrayList, a, this.ekQ.aLS());
                }
            }
            int b = b(this.ekQ, arrayList, this.elu);
            if (b >= 0) {
                com.baidu.tbadk.core.util.y.a(arrayList, b, this.ekQ.aLT());
            }
            int c = c(this.ekQ, arrayList, this.elu);
            int size3 = arrayList.size();
            if (!this.emy.aMY()) {
                if (c < 0) {
                    this.emy.hS(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.ekQ.aLN());
                    } else if (c >= size3) {
                        arrayList.add(this.ekQ.aLN());
                    } else {
                        arrayList.add(c, this.ekQ.aLN());
                    }
                    this.emy.hS(true);
                }
            }
            if (c < 0) {
                this.eov.hS(false);
                this.eoA.hS(false);
            } else {
                this.eov.hS(true);
                this.eoA.hS(true);
            }
            if (arrayList.size() == 0 && this.emy.aMY()) {
                arrayList.add(new com.baidu.tieba.pb.data.l());
            }
            if (hVar != null && hVar.aLQ() != null && hVar.aLQ().Uw != null) {
                DealInfoData sx = hVar.aLQ().sx();
                com.baidu.tieba.pb.data.a aVar2 = new com.baidu.tieba.pb.data.a(2);
                aVar2.ejK = sx;
                aVar2.bER = arrayList;
                aVar2.aLC();
            }
            com.baidu.tieba.tbadkCore.v.r(arrayList, 1);
            if (this.bBT != null) {
                this.bBT.setData(arrayList);
            }
        }
    }

    private void acV() {
        if (this.emy != null && !acW()) {
            this.emy.registerListener(this.bVR);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean acW() {
        if (this.emy == null) {
            return false;
        }
        this.bVM = new ArrayList();
        ArrayList<BdUniqueId> bih = com.baidu.tieba.tbadkCore.v.bih();
        if (bih == null || bih.size() <= 0) {
            return false;
        }
        int size = bih.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aCf().a(this.emy.getPageContext(), bih.get(i), 2);
            if (a != null) {
                this.bOr.add(a);
                this.bVM.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bVM)) {
            this.bBT.g(this.bVM);
        }
        return true;
    }

    public int aNp() {
        return this.bBT.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (hVar == null || hVar.aLR() == null || hVar.aLS() == null || hVar.aLR().size() == 0 || hVar.aLQ() == null || arrayList == null) {
            return -1;
        }
        if (hVar.aLS().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (hVar.aLR().get(0) == null || hVar.aLR().get(0).bjc() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (hVar.getPage() == null || hVar.getPage().qo() != hVar.getPage().ql()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (hVar == null || hVar.aLR() == null || hVar.aLT() == null || hVar.aLR().size() == 0 || hVar.aLQ() == null || arrayList == null) {
            return -1;
        }
        if (hVar.aLT().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (hVar.aLR().get(0) == null || hVar.aLR().get(0).bjc() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (hVar.getPage() == null || hVar.getPage().qo() != hVar.getPage().ql()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.ab aLN;
        if (hVar == null || hVar.aLR() == null || hVar.aLN() == null || hVar.aLR().size() == 0 || hVar.aLQ() == null || arrayList == null) {
            return -1;
        }
        com.baidu.tieba.tbadkCore.data.q aLV = hVar.aLV();
        com.baidu.tieba.tbadkCore.data.q qVar = (aLV == null && hVar.aLR().get(0) != null && hVar.aLR().get(0).bjc() == 1) ? hVar.aLR().get(0) : aLV;
        if (qVar == null) {
            return -1;
        }
        if ((qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fsz || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.Tl || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fsC) && com.baidu.tieba.graffiti.d.ajH()) {
            if (!this.eoH) {
                this.eoH = o(com.baidu.tbadk.core.data.ab.Ro);
            }
            if (this.eoH && (aLN = hVar.aLN()) != null) {
                if (StringUtils.isNull(aLN.getForumId()) || StringUtils.isNull(aLN.getThreadId())) {
                    return -1;
                }
                return z ? 1 : -1;
            }
            return -1;
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v aJ(int i) {
        return this.bBT.aJ(i);
    }

    public BdUniqueId oe(int i) {
        if (this.bBT.aJ(i) != null) {
            return this.bBT.aJ(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.eoy == null || !this.eoy.aMr()) && (this.bBT.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.bBT.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aNq() {
        com.baidu.tieba.tbadkCore.data.p pVar;
        int position;
        if (this.ekQ != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aLR = this.ekQ.aLR();
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aMb = this.ekQ.aMb();
            if (aMb != null) {
                int size = aMb.size();
                if (aLR != null && aLR.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it = aMb.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next = it.next();
                        if (next != null && next.biT() != null) {
                            sb.append(next.biT());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it2 = aMb.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next2 = it2.next();
                        if (next2 != null) {
                            next2.bZP = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it3 = aMb.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next3 = it3.next();
                        if (next3.biS() != null && next3.biS().pg() && !com.baidu.tieba.tbadkCore.ak.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.biS().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.p pVar2 = (com.baidu.tieba.tbadkCore.data.p) sparseArray.get(sparseArray.keyAt(i));
                        if (pVar2 != null) {
                            hashMap.put(pVar2.biT(), pVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (pVar = (com.baidu.tieba.tbadkCore.data.p) entry.getValue()) != null) {
                            sparseArray.put(pVar.getPosition(), pVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new co(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.p pVar3 = (com.baidu.tieba.tbadkCore.data.p) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = pVar3.getPosition();
                        if (!a(pVar3, aLR)) {
                            if (position2 + i3 < aLR.size()) {
                                if (this.ekQ.aLP() != null) {
                                    pVar3.btl = this.ekQ.aLP().getId();
                                }
                                if (this.ekQ.aLQ() != null) {
                                    pVar3.threadId = com.baidu.adp.lib.h.b.c(this.ekQ.aLQ().getId(), 0L);
                                }
                                if (this.ekQ != null && this.ekQ.getPage() != null) {
                                    pVar3.pageNumber = this.ekQ.getPage().qo();
                                }
                                aLR.add(position2, pVar3);
                                TiebaStatic.eventStat(this.emy.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", pVar3.biS().apk_name);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.p pVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        int s = com.baidu.tbadk.core.util.y.s(arrayList);
        if (pVar == null || s <= 0) {
            return false;
        }
        int position = pVar.getPosition();
        if (s >= 2 || position != s + 1) {
            return false;
        }
        if (this.ekQ != null && this.ekQ.getPage() != null) {
            pVar.pageNumber = this.ekQ.getPage().qo();
        }
        arrayList.add(pVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eoz.setFromCDN(z);
        this.eoA.setFromCDN(z);
        this.eov.setFromCDN(z);
        if (this.bVw != null && (this.bVw instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bVw).setIsFromCDN(z);
        }
        if (this.bVx != null && (this.bVx instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bVx).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eoD.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void hN(boolean z) {
        this.cHP = z;
    }

    public void hO(boolean z) {
        this.elt = z;
    }

    public void hP(boolean z) {
        this.elu = z;
    }

    public void hQ(boolean z) {
        this.eoE = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.ely = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJI = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ekU = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoq = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.bmb = onClickListener;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (this.bBT == null || bdUniqueId == null || com.baidu.tbadk.core.util.y.t(this.eoG)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.eoG) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.pb.pb.a.e aNr() {
        return this.eoA;
    }

    public com.baidu.tieba.recapp.a aNs() {
        return (com.baidu.tieba.recapp.a) this.bVw;
    }

    public com.baidu.tieba.recapp.a aNt() {
        return (com.baidu.tieba.recapp.a) this.bVx;
    }

    public void of(int i) {
        switch (i) {
            case 1:
                if (this.eoy != null) {
                    this.eoy.pause();
                }
                if (this.bVy != null && (this.bVy instanceof com.baidu.tieba.recapp.d)) {
                    ((com.baidu.tieba.recapp.d) this.bVy).release();
                    return;
                }
                return;
            case 2:
                if (this.eoy != null) {
                    this.eoy.resume();
                }
                if (this.bVy != null && (this.bVy instanceof com.baidu.tieba.recapp.d)) {
                    ((com.baidu.tieba.recapp.d) this.bVy).resume();
                    return;
                }
                return;
            case 3:
                if (this.eoy != null) {
                    this.eoy.release();
                }
                if (this.bVy != null && (this.bVy instanceof com.baidu.tieba.recapp.d)) {
                    ((com.baidu.tieba.recapp.d) this.bVy).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cv(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.tbadkCore.data.q) {
                    com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) list.get(i);
                    if (!TextUtils.isEmpty(qVar.sv())) {
                        com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
                        adVar.cn(qVar.sv());
                        list.set(i, adVar);
                    }
                }
            }
        }
    }
}
