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
    private BdTypeListView bCe;
    private List<com.baidu.adp.widget.ListView.a> bVL;
    private com.baidu.adp.widget.ListView.a bVu;
    private com.baidu.adp.widget.ListView.a bVv;
    private com.baidu.adp.widget.ListView.a bVw;
    private com.baidu.adp.widget.ListView.a bZm;
    private com.baidu.tieba.pb.data.h emS;
    private int enp;
    private PbActivity eow;
    private dt eqA;
    private du eqt;
    private ef equ;
    private em eqv;
    private com.baidu.tieba.pb.pb.a.b eqw;
    private com.baidu.tieba.pb.pb.a.w eqx;
    private com.baidu.tieba.pb.pb.a.e eqy;
    private cy eqz;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> eqB = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.q> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cIH = true;
    private boolean enq = true;
    private boolean enr = true;
    private boolean eqC = false;
    private String ens = null;
    private View.OnClickListener env = null;
    private View.OnClickListener bmo = null;
    private TbRichTextView.e aJh = null;
    private com.baidu.tieba.pb.a.d emU = null;
    private View.OnLongClickListener anY = null;
    private cs eqD = null;
    private final List<com.baidu.adp.widget.ListView.a> bOo = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eqE = new ArrayList();
    private boolean eqF = false;
    private CustomMessageListener bVP = new ck(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bQc = new cl(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bVQ = new cn(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public cj(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.enp = 0;
        this.width = -1;
        this.enp = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.enp;
        this.eow = pbActivity;
        this.bCe = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bQc);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eqx = new com.baidu.tieba.pb.pb.a.w(pbActivity, com.baidu.tieba.tbadkCore.data.q.fvi);
        this.eqy = new com.baidu.tieba.pb.pb.a.e(pbActivity, com.baidu.tieba.tbadkCore.data.q.Tt);
        this.eqt = new du(pbActivity, com.baidu.tieba.tbadkCore.data.q.fvf);
        this.eqt.a(pbActivity);
        this.bVu = com.baidu.tieba.recapp.e.bbV().c(pbActivity, com.baidu.tbadk.core.data.b.OS);
        this.bVv = com.baidu.tieba.recapp.e.bbV().c(pbActivity, com.baidu.tbadk.core.data.b.OT);
        this.bVw = com.baidu.tieba.recapp.e.bbV().c(pbActivity, com.baidu.tbadk.core.data.b.OU);
        this.bZm = com.baidu.tieba.recapp.e.bbV().c(pbActivity, com.baidu.tbadk.core.data.b.OX);
        this.eqz = new cy(pbActivity, com.baidu.tieba.pb.data.c.elN);
        this.eqA = new dt(pbActivity, com.baidu.tieba.pb.data.m.emz);
        this.equ = new ef(pbActivity, ds.esw);
        this.eqv = new em(pbActivity, com.baidu.tbadk.core.data.ap.Se);
        this.bOo.add(this.eqt);
        this.bOo.add(this.eqx);
        this.bOo.add(this.eqy);
        this.bOo.add(this.bVu);
        this.bOo.add(this.bVv);
        this.bOo.add(this.bVw);
        this.bOo.add(this.bZm);
        this.bOo.add(this.eqz);
        this.bOo.add(this.eqA);
        this.bOo.add(this.equ);
        this.bOo.add(this.eqv);
        this.bVP.setPriority(1);
        this.bVP.setSelfListener(true);
        pbActivity.registerListener(this.bVP);
        adj();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(0);
        aVar.elH = pbActivity;
        aVar.bOo = this.bOo;
        aVar.aMe();
        this.eqD = aVar.elK;
        bdTypeListView.g(this.bOo);
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        boolean z;
        com.baidu.tieba.tbadkCore.data.q qVar;
        int size;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        int size2;
        if (this.emS != hVar) {
            z = (hVar == null || hVar.aMo()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.emS = hVar;
        if (z) {
            aNX();
            if (hVar != null) {
                hVar.hP(false);
            }
        }
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }
        this.postList.clear();
        if (this.emS != null && this.emS.aMt() != null && this.emS.aMt().size() > 0) {
            this.postList.addAll(this.emS.aMt());
        }
        if (hVar != null && hVar.aMs() != null && hVar.aMs().getAuthor() != null) {
            this.ens = hVar.aMs().getAuthor().getUserId();
        }
        if (this.eqt != null) {
            this.eqx.b(hVar);
            this.eqx.setFromCDN(this.mIsFromCDN);
            this.eqx.oZ(this.ens);
            this.eqx.ok(this.enp);
            this.eqx.hQ(this.cIH);
            this.eqx.hR(this.enq);
            this.eqx.hS(this.enr);
            this.eqx.setCommonClickListener(this.bmo);
            this.eqx.F(this.env);
            this.eqx.setOnImageClickListener(this.aJh);
            this.eqx.setOnLongClickListener(this.anY);
            this.eqx.a(this.emU);
            this.eqy.b(hVar);
            this.eqy.setFromCDN(this.mIsFromCDN);
            this.eqy.a(this.emU);
            this.eqt.b(hVar);
            this.eqt.setFromCDN(this.mIsFromCDN);
            this.eqt.oZ(this.ens);
            this.eqt.ok(this.enp);
            this.eqt.hQ(this.cIH);
            this.eqt.hR(this.enq);
            this.eqt.hS(this.enr);
            this.eqt.hT(this.eqC);
            this.eqt.setCommonClickListener(this.bmo);
            this.eqt.F(this.env);
            this.eqt.setOnImageClickListener(this.aJh);
            this.eqt.setOnLongClickListener(this.anY);
            this.eqt.a(this.emU);
            if (this.bVu != null && (this.bVu instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVu).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bVv != null && (this.bVv instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVv).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bZm != null && (this.bZm instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bZm).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eqB.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(hVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.oZ(this.ens);
                    next.ok(this.enp);
                    next.hQ(this.cIH);
                    next.hR(this.enq);
                    next.hS(this.enr);
                    next.hT(this.eqC);
                    next.setCommonClickListener(this.bmo);
                    next.F(this.env);
                    next.setOnImageClickListener(this.aJh);
                    next.setOnLongClickListener(this.anY);
                    next.a(this.emU);
                }
            }
            com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(1);
            aVar.elJ = this.bmo;
            aVar.elK = this.eqD;
            aVar.aMe();
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (hVar.aMt() != null) {
                arrayList.addAll(hVar.aMt());
            }
            cw(arrayList);
            if (!this.enr && hVar != null && hVar.aMt() != null && (size = hVar.aMt().size()) > 0 && (qVar2 = hVar.aMt().get(size - 1)) != null && qVar2.bjO() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.eow.aNE()) {
                if (hVar.aMt().size() > 0 && (qVar = hVar.aMt().get(0)) != null && qVar.bjO() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int a = a(this.emS, arrayList, this.enr);
                if (a >= 0) {
                    com.baidu.tbadk.core.util.y.a(arrayList, a, this.emS.aMu());
                }
            }
            int b = b(this.emS, arrayList, this.enr);
            if (b >= 0) {
                com.baidu.tbadk.core.util.y.a(arrayList, b, this.emS.aMv());
            }
            int c = c(this.emS, arrayList, this.enr);
            int size3 = arrayList.size();
            if (!this.eow.aNE()) {
                if (c < 0) {
                    this.eow.hV(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.emS.aMp());
                    } else if (c >= size3) {
                        arrayList.add(this.emS.aMp());
                    } else {
                        arrayList.add(c, this.emS.aMp());
                    }
                    this.eow.hV(true);
                }
            }
            if (c < 0) {
                this.eqt.hV(false);
                this.eqy.hV(false);
            } else {
                this.eqt.hV(true);
                this.eqy.hV(true);
            }
            if (arrayList.size() == 0 && this.eow.aNE()) {
                arrayList.add(new com.baidu.tieba.pb.data.m());
            }
            if (hVar != null && hVar.aMs() != null && hVar.aMs().UH != null) {
                DealInfoData sK = hVar.aMs().sK();
                com.baidu.tieba.pb.data.a aVar2 = new com.baidu.tieba.pb.data.a(2);
                aVar2.elI = sK;
                aVar2.bFc = arrayList;
                aVar2.aMe();
            }
            com.baidu.tieba.tbadkCore.v.s(arrayList, 1);
            if (this.bCe != null) {
                this.bCe.setData(arrayList);
            }
        }
    }

    private void adj() {
        if (this.eow != null && !adk()) {
            this.eow.registerListener(this.bVQ);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean adk() {
        if (this.eow == null) {
            return false;
        }
        this.bVL = new ArrayList();
        ArrayList<BdUniqueId> biS = com.baidu.tieba.tbadkCore.v.biS();
        if (biS == null || biS.size() <= 0) {
            return false;
        }
        int size = biS.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aCF().a(this.eow.getPageContext(), biS.get(i), 2);
            if (a != null) {
                this.bOo.add(a);
                this.bVL.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bVL)) {
            this.bCe.g(this.bVL);
        }
        return true;
    }

    public int aNV() {
        return this.bCe.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (hVar == null || hVar.aMt() == null || hVar.aMu() == null || hVar.aMt().size() == 0 || hVar.aMs() == null || arrayList == null) {
            return -1;
        }
        if (hVar.aMu().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (hVar.aMt().get(0) == null || hVar.aMt().get(0).bjO() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (hVar.getPage() == null || hVar.getPage().qz() != hVar.getPage().qw()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (hVar == null || hVar.aMt() == null || hVar.aMv() == null || hVar.aMt().size() == 0 || hVar.aMs() == null || arrayList == null) {
            return -1;
        }
        if (hVar.aMv().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (hVar.aMt().get(0) == null || hVar.aMt().get(0).bjO() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (hVar.getPage() == null || hVar.getPage().qz() != hVar.getPage().qw()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.ad aMp;
        if (hVar == null || hVar.aMt() == null || hVar.aMp() == null || hVar.aMt().size() == 0 || hVar.aMs() == null || arrayList == null) {
            return -1;
        }
        com.baidu.tieba.tbadkCore.data.q aMx = hVar.aMx();
        com.baidu.tieba.tbadkCore.data.q qVar = (aMx == null && hVar.aMt().get(0) != null && hVar.aMt().get(0).bjO() == 1) ? hVar.aMt().get(0) : aMx;
        if (qVar == null) {
            return -1;
        }
        if ((qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fvf || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.Tt || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fvi) && com.baidu.tieba.graffiti.d.ajV()) {
            if (!this.eqF) {
                this.eqF = o(com.baidu.tbadk.core.data.ad.Ru);
            }
            if (this.eqF && (aMp = hVar.aMp()) != null) {
                if (StringUtils.isNull(aMp.getForumId()) || StringUtils.isNull(aMp.getThreadId())) {
                    return -1;
                }
                return z ? 1 : -1;
            }
            return -1;
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v aJ(int i) {
        return this.bCe.aJ(i);
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.q> aNW() {
        return this.postList;
    }

    public BdUniqueId oo(int i) {
        if (this.bCe.aJ(i) != null) {
            return this.bCe.aJ(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.eqw == null || !this.eqw.aMX()) && (this.bCe.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.bCe.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aNX() {
        com.baidu.tieba.tbadkCore.data.p pVar;
        int position;
        if (this.emS != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMt = this.emS.aMt();
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aMD = this.emS.aMD();
            if (aMD != null) {
                int size = aMD.size();
                if (aMt != null && aMt.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it = aMD.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next = it.next();
                        if (next != null && next.bjF() != null) {
                            sb.append(next.bjF());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it2 = aMD.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next2 = it2.next();
                        if (next2 != null) {
                            next2.bZM = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it3 = aMD.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next3 = it3.next();
                        if (next3.bjD() != null && next3.bjD().ph() && !com.baidu.tieba.tbadkCore.ak.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bjD().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.p pVar2 = (com.baidu.tieba.tbadkCore.data.p) sparseArray.get(sparseArray.keyAt(i));
                        if (pVar2 != null) {
                            hashMap.put(pVar2.bjF(), pVar2);
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
                        if (!a(pVar3, aMt)) {
                            if (position2 + i3 < aMt.size()) {
                                if (this.emS.aMr() != null) {
                                    pVar3.btz = this.emS.aMr().getId();
                                }
                                if (this.emS.aMs() != null) {
                                    pVar3.threadId = com.baidu.adp.lib.h.b.c(this.emS.aMs().getId(), 0L);
                                }
                                if (this.emS != null && this.emS.getPage() != null) {
                                    pVar3.pageNumber = this.emS.getPage().qz();
                                }
                                aMt.add(position2, pVar3);
                                TiebaStatic.eventStat(this.eow.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", pVar3.bjD().apk_name);
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
        if (this.emS != null && this.emS.getPage() != null) {
            pVar.pageNumber = this.emS.getPage().qz();
        }
        arrayList.add(pVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.eqx.setFromCDN(z);
        this.eqy.setFromCDN(z);
        this.eqt.setFromCDN(z);
        if (this.bVu != null && (this.bVu instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bVu).setIsFromCDN(z);
        }
        if (this.bVv != null && (this.bVv instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bVv).setIsFromCDN(z);
        }
        if (this.bZm != null && (this.bZm instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bZm).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.eqB.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void hQ(boolean z) {
        this.cIH = z;
    }

    public void hR(boolean z) {
        this.enq = z;
    }

    public void hS(boolean z) {
        this.enr = z;
    }

    public void hT(boolean z) {
        this.eqC = z;
    }

    public void F(View.OnClickListener onClickListener) {
        this.env = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJh = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.emU = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anY = onLongClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.bmo = onClickListener;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (this.bCe == null || bdUniqueId == null || com.baidu.tbadk.core.util.y.t(this.eqE)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.eqE) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.pb.pb.a.e aNY() {
        return this.eqy;
    }

    public com.baidu.tieba.recapp.a aNZ() {
        return (com.baidu.tieba.recapp.a) this.bVu;
    }

    public com.baidu.tieba.recapp.a aOa() {
        return (com.baidu.tieba.recapp.a) this.bVv;
    }

    public com.baidu.tieba.recapp.a aOb() {
        return (com.baidu.tieba.recapp.a) this.bZm;
    }

    public void op(int i) {
        switch (i) {
            case 1:
                if (this.eqw != null) {
                    this.eqw.pause();
                }
                if (this.bVw != null && (this.bVw instanceof com.baidu.tieba.recapp.d)) {
                    ((com.baidu.tieba.recapp.d) this.bVw).release();
                    return;
                }
                return;
            case 2:
                if (this.eqw != null) {
                    this.eqw.resume();
                }
                if (this.bVw != null && (this.bVw instanceof com.baidu.tieba.recapp.d)) {
                    ((com.baidu.tieba.recapp.d) this.bVw).resume();
                    return;
                }
                return;
            case 3:
                if (this.eqw != null) {
                    this.eqw.release();
                }
                if (this.bVw != null && (this.bVw instanceof com.baidu.tieba.recapp.d)) {
                    ((com.baidu.tieba.recapp.d) this.bVw).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cw(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.tbadkCore.data.q) {
                    com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) list.get(i);
                    if (!TextUtils.isEmpty(qVar.sH())) {
                        com.baidu.tbadk.core.data.af afVar = new com.baidu.tbadk.core.data.af();
                        afVar.cn(qVar.sH());
                        list.set(i, afVar);
                    }
                }
            }
        }
    }
}
