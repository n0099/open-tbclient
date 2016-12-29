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
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
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
    private BdTypeListView aMc;
    private List<com.baidu.adp.widget.ListView.a> bEG;
    private com.baidu.adp.widget.ListView.a bEp;
    private com.baidu.adp.widget.ListView.a bEq;
    private com.baidu.adp.widget.ListView.a bEr;
    private com.baidu.adp.widget.ListView.a bEs;
    private com.baidu.adp.widget.ListView.a bIq;
    private int dXB;
    private com.baidu.tieba.pb.data.f dXl;
    private PbActivity dYB;
    private dq eaD;
    private dz eaE;
    private eg eaF;
    private com.baidu.tieba.pb.pb.a.b eaG;
    private com.baidu.tieba.pb.pb.a.t eaH;
    private com.baidu.tieba.pb.pb.a.d eaI;
    private cw eaJ;
    private dp eaK;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eaL = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.q> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean ctc = true;
    private boolean eaM = true;
    private boolean dXC = true;
    private boolean eaN = false;
    private String dXD = null;
    private View.OnClickListener dXG = null;
    private View.OnClickListener cjr = null;
    private TbRichTextView.e aJq = null;
    private com.baidu.tieba.pb.a.d dXp = null;
    private View.OnLongClickListener aou = null;
    private final List<com.baidu.adp.widget.ListView.a> bbV = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eaO = new ArrayList();
    private boolean eaP = false;
    private CustomMessageListener bEN = new ck(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bzh = new cl(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bEO = new cn(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public cj(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.dXB = 0;
        this.width = -1;
        this.dXB = com.baidu.adp.lib.util.k.I(pbActivity.getPageContext().getPageActivity());
        this.width = this.dXB;
        this.dYB = pbActivity;
        this.aMc = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bzh);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eaH = new com.baidu.tieba.pb.pb.a.t(pbActivity, com.baidu.tieba.tbadkCore.data.q.fgy);
        this.eaI = new com.baidu.tieba.pb.pb.a.d(pbActivity, com.baidu.tieba.tbadkCore.data.q.Tp);
        this.eaD = new dq(pbActivity, com.baidu.tieba.tbadkCore.data.q.fgw);
        this.eaD.a(pbActivity);
        this.bEp = com.baidu.tieba.recapp.j.aYf().c(pbActivity, com.baidu.tbadk.core.data.c.OZ);
        this.bEq = com.baidu.tieba.recapp.j.aYf().c(pbActivity, com.baidu.tbadk.core.data.c.Pa);
        this.bEr = com.baidu.tieba.recapp.j.aYf().c(pbActivity, com.baidu.tbadk.core.data.c.Pc);
        this.bEs = com.baidu.tieba.recapp.j.aYf().c(pbActivity, com.baidu.tbadk.core.data.c.Pd);
        this.bIq = com.baidu.tieba.recapp.j.aYf().c(pbActivity, com.baidu.tbadk.core.data.c.Ph);
        this.eaJ = new cw(pbActivity, com.baidu.tieba.pb.data.a.dWm);
        this.eaK = new dp(pbActivity, com.baidu.tieba.pb.data.i.dWU);
        this.eaE = new dz(pbActivity, Cdo.eda);
        this.eaF = new eg(pbActivity, com.baidu.tbadk.core.data.aq.Su);
        this.bbV.add(this.eaD);
        this.bbV.add(this.eaH);
        this.bbV.add(this.eaI);
        this.bbV.add(this.bEp);
        this.bbV.add(this.bEq);
        this.bbV.add(this.bEr);
        this.bbV.add(this.bEs);
        this.bbV.add(this.bIq);
        this.bbV.add(this.eaJ);
        this.bbV.add(this.eaK);
        this.bbV.add(this.eaE);
        this.bbV.add(this.eaF);
        this.bEN.setPriority(1);
        this.bEN.setSelfListener(true);
        pbActivity.registerListener(this.bEN);
        YQ();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.g(this.bbV);
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        boolean z;
        com.baidu.tieba.tbadkCore.data.q qVar;
        int size;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        int size2;
        if (this.dXl != fVar) {
            z = (fVar == null || fVar.aIh()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.dXl = fVar;
        if (z) {
            aJN();
            if (fVar != null) {
                fVar.hW(false);
            }
        }
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }
        this.postList.clear();
        if (this.dXl != null && this.dXl.aIm() != null && this.dXl.aIm().size() > 0) {
            this.postList.addAll(this.dXl.aIm());
        }
        if (fVar != null && fVar.aIl() != null && fVar.aIl().getAuthor() != null) {
            this.dXD = fVar.aIl().getAuthor().getUserId();
        }
        if (this.eaD != null) {
            this.eaH.b(fVar);
            this.eaH.setFromCDN(this.mIsFromCDN);
            this.eaH.nN(this.dXD);
            this.eaH.nw(this.dXB);
            this.eaH.hX(this.ctc);
            this.eaH.hY(this.dXC);
            this.eaH.setCommonClickListener(this.cjr);
            this.eaH.F(this.dXG);
            this.eaH.setOnImageClickListener(this.aJq);
            this.eaH.setOnLongClickListener(this.aou);
            this.eaH.a(this.dXp);
            this.eaI.b(fVar);
            this.eaI.setFromCDN(this.mIsFromCDN);
            this.eaI.a(this.dXp);
            this.eaD.b(fVar);
            this.eaD.setFromCDN(this.mIsFromCDN);
            this.eaD.nN(this.dXD);
            this.eaD.nw(this.dXB);
            this.eaD.hX(this.ctc);
            this.eaD.hY(this.dXC);
            this.eaD.hZ(this.eaN);
            this.eaD.setCommonClickListener(this.cjr);
            this.eaD.F(this.dXG);
            this.eaD.setOnImageClickListener(this.aJq);
            this.eaD.setOnLongClickListener(this.aou);
            this.eaD.a(this.dXp);
            if (this.bEq != null && (this.bEq instanceof com.baidu.tieba.recapp.f)) {
                ((com.baidu.tieba.recapp.f) this.bEq).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bEr != null && (this.bEr instanceof com.baidu.tieba.recapp.f)) {
                ((com.baidu.tieba.recapp.f) this.bEr).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bIq != null && (this.bIq instanceof com.baidu.tieba.recapp.f)) {
                ((com.baidu.tieba.recapp.f) this.bIq).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eaL.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(fVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.nN(this.dXD);
                    next.nw(this.dXB);
                    next.hX(this.ctc);
                    next.hY(this.dXC);
                    next.hZ(this.eaN);
                    next.setCommonClickListener(this.cjr);
                    next.F(this.dXG);
                    next.setOnImageClickListener(this.aJq);
                    next.setOnLongClickListener(this.aou);
                    next.a(this.dXp);
                }
            }
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (fVar.aIm() != null) {
                arrayList.addAll(fVar.aIm());
            }
            cp(arrayList);
            if (!this.dXC && fVar != null && fVar.aIm() != null && (size = fVar.aIm().size()) > 0 && (qVar2 = fVar.aIm().get(size - 1)) != null && qVar2.bga() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.dYB.aJu()) {
                if (fVar.aIm().size() > 0 && (qVar = fVar.aIm().get(0)) != null && qVar.bga() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int a = a(this.dXl, arrayList, this.dXC);
                if (a >= 0) {
                    com.baidu.tbadk.core.util.x.a(arrayList, a, this.dXl.aIn());
                }
            }
            int b = b(this.dXl, arrayList, this.dXC);
            if (b >= 0) {
                com.baidu.tbadk.core.util.x.a(arrayList, b, this.dXl.aIo());
            }
            int c = c(this.dXl, arrayList, this.dXC);
            int size3 = arrayList.size();
            if (!this.dYB.aJu()) {
                if (c < 0) {
                    this.dYB.ib(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.dXl.aIi());
                    } else if (c >= size3) {
                        arrayList.add(this.dXl.aIi());
                    } else {
                        arrayList.add(c, this.dXl.aIi());
                    }
                    this.dYB.ib(true);
                }
            }
            if (c < 0) {
                this.eaD.ib(false);
            } else {
                this.eaD.ib(true);
            }
            if (arrayList.size() == 0 && this.dYB.aJu()) {
                arrayList.add(new com.baidu.tieba.pb.data.i());
            }
            com.baidu.tieba.tbadkCore.u.r(arrayList, 1);
            if (this.aMc != null) {
                this.aMc.setData(arrayList);
            }
        }
    }

    private void YQ() {
        if (this.dYB != null && !YR()) {
            this.dYB.registerListener(this.bEO);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean YR() {
        if (this.dYB == null) {
            return false;
        }
        this.bEG = new ArrayList();
        ArrayList<BdUniqueId> bfh = com.baidu.tieba.tbadkCore.u.bfh();
        if (bfh == null || bfh.size() <= 0) {
            return false;
        }
        int size = bfh.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.ayu().a(this.dYB.getPageContext(), bfh.get(i), 2);
            if (a != null) {
                this.bbV.add(a);
                this.bEG.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.t(this.bEG)) {
            this.aMc.g(this.bEG);
        }
        return true;
    }

    public int aJL() {
        return this.aMc.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aIm() == null || fVar.aIn() == null || fVar.aIm().size() == 0 || fVar.aIl() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aIn().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aIm().get(0) == null || fVar.aIm().get(0).bga() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().qC() != fVar.getPage().qz()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aIm() == null || fVar.aIo() == null || fVar.aIm().size() == 0 || fVar.aIl() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aIo().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aIm().get(0) == null || fVar.aIm().get(0).bga() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().qC() != fVar.getPage().qz()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.ae aIi;
        if (fVar == null || fVar.aIm() == null || fVar.aIi() == null || fVar.aIm().size() == 0 || fVar.aIl() == null || arrayList == null) {
            return -1;
        }
        com.baidu.tieba.tbadkCore.data.q aIq = fVar.aIq();
        com.baidu.tieba.tbadkCore.data.q qVar = (aIq == null && fVar.aIm().get(0) != null && fVar.aIm().get(0).bga() == 1) ? fVar.aIm().get(0) : aIq;
        if (qVar == null) {
            return -1;
        }
        if ((qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fgw || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.Tp || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fgy) && com.baidu.tieba.graffiti.d.agr()) {
            if (!this.eaP) {
                this.eaP = o(com.baidu.tbadk.core.data.ae.TYPE);
            }
            if (this.eaP && (aIi = fVar.aIi()) != null) {
                if (StringUtils.isNull(aIi.getForumId()) || StringUtils.isNull(aIi.getThreadId())) {
                    return -1;
                }
                return z ? 1 : -1;
            }
            return -1;
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v aK(int i) {
        return this.aMc.aK(i);
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.q> aJM() {
        return this.postList;
    }

    public BdUniqueId nA(int i) {
        if (this.aMc.aK(i) != null) {
            return this.aMc.aK(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.eaG == null || !this.eaG.aIP()) && (this.aMc.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aMc.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aJN() {
        com.baidu.tieba.tbadkCore.data.p pVar;
        int position;
        if (this.dXl != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aIm = this.dXl.aIm();
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aIx = this.dXl.aIx();
            if (aIx != null) {
                int size = aIx.size();
                if (aIm != null && aIm.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it = aIx.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next = it.next();
                        if (next != null && next.bfQ() != null) {
                            sb.append(next.bfQ());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it2 = aIx.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next2 = it2.next();
                        if (next2 != null) {
                            next2.bIQ = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it3 = aIx.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next3 = it3.next();
                        if (next3.bfO() != null && next3.bfO().pj() && !com.baidu.tieba.tbadkCore.ai.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bfO().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.p pVar2 = (com.baidu.tieba.tbadkCore.data.p) sparseArray.get(sparseArray.keyAt(i));
                        if (pVar2 != null) {
                            hashMap.put(pVar2.bfQ(), pVar2);
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
                        if (!a(pVar3, aIm)) {
                            if (position2 + i3 < aIm.size()) {
                                if (this.dXl.aIk() != null) {
                                    pVar3.forumId = this.dXl.aIk().getId();
                                }
                                if (this.dXl.aIl() != null) {
                                    pVar3.threadId = com.baidu.adp.lib.h.b.c(this.dXl.aIl().getId(), 0L);
                                }
                                if (this.dXl != null && this.dXl.getPage() != null) {
                                    pVar3.pageNumber = this.dXl.getPage().qC();
                                }
                                b(pVar3);
                                aIm.add(position2, pVar3);
                                TiebaStatic.eventStat(this.dYB.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", pVar3.bfO().apk_name);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.p pVar) {
        ForumData aIk;
        if (pVar != null && this.dXl != null && pVar.bfO() != null) {
            pVar.bfO().Pz = new com.baidu.tbadk.core.data.b();
            if (this.dXl.getPage() != null) {
                pVar.bfO().Pz.pn = this.dXl.getPage().qC();
            }
            pVar.bfO().Pz.OO = "PB";
            if (this.dXl.aIk() != null && (aIk = this.dXl.aIk()) != null) {
                pVar.bfO().Pz.fid = aIk.getId();
                pVar.bfO().Pz.OQ = aIk.getFirst_class();
                pVar.bfO().Pz.OR = aIk.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                pVar.bfO().Pz.OS = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            pVar.bfO().Pz.extensionInfo = pVar.bfO().ext_info;
            pVar.bfO().Pz.OT = false;
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.p pVar, ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        int s = com.baidu.tbadk.core.util.x.s(arrayList);
        if (pVar == null || s <= 0) {
            return false;
        }
        int position = pVar.getPosition();
        if (s >= 2 || position != s + 1) {
            return false;
        }
        if (this.dXl != null && this.dXl.getPage() != null) {
            pVar.pageNumber = this.dXl.getPage().qC();
        }
        arrayList.add(pVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eaH.setFromCDN(z);
        this.eaI.setFromCDN(z);
        this.eaD.setFromCDN(z);
        if (this.bEq != null && (this.bEq instanceof com.baidu.tieba.recapp.f)) {
            ((com.baidu.tieba.recapp.f) this.bEq).setIsFromCDN(z);
        }
        if (this.bEr != null && (this.bEr instanceof com.baidu.tieba.recapp.f)) {
            ((com.baidu.tieba.recapp.f) this.bEr).setIsFromCDN(z);
        }
        if (this.bIq != null && (this.bIq instanceof com.baidu.tieba.recapp.f)) {
            ((com.baidu.tieba.recapp.f) this.bIq).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eaL.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void hX(boolean z) {
        this.ctc = z;
    }

    public void hY(boolean z) {
        this.dXC = z;
    }

    public void hZ(boolean z) {
        this.eaN = z;
    }

    public void F(View.OnClickListener onClickListener) {
        this.dXG = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJq = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dXp = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aou = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.cjr = onClickListener;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (this.aMc == null || bdUniqueId == null || com.baidu.tbadk.core.util.x.t(this.eaO)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.eaO) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.pb.pb.a.d aJO() {
        return this.eaI;
    }

    public com.baidu.tieba.recapp.f aJP() {
        return (com.baidu.tieba.recapp.f) this.bEq;
    }

    public com.baidu.tieba.recapp.f aJQ() {
        return (com.baidu.tieba.recapp.f) this.bEr;
    }

    public void nB(int i) {
        switch (i) {
            case 1:
                if (this.eaG != null) {
                    this.eaG.pause();
                }
                if (this.bEs != null && (this.bEs instanceof com.baidu.tieba.recapp.i)) {
                    ((com.baidu.tieba.recapp.i) this.bEs).release();
                    return;
                }
                return;
            case 2:
                if (this.eaG != null) {
                    this.eaG.resume();
                }
                if (this.bEs != null && (this.bEs instanceof com.baidu.tieba.recapp.i)) {
                    ((com.baidu.tieba.recapp.i) this.bEs).resume();
                    return;
                }
                return;
            case 3:
                if (this.eaG != null) {
                    this.eaG.release();
                }
                if (this.bEs != null && (this.bEs instanceof com.baidu.tieba.recapp.i)) {
                    ((com.baidu.tieba.recapp.i) this.bEs).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cp(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.tbadkCore.data.q) {
                    com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) list.get(i);
                    if (!TextUtils.isEmpty(qVar.sy())) {
                        com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
                        agVar.cq(qVar.sy());
                        list.set(i, agVar);
                    }
                }
            }
        }
    }
}
