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
public class ch {
    private List<com.baidu.adp.widget.ListView.a> bKC;
    private BdTypeListView bqG;
    private com.baidu.tieba.pb.data.h dYM;
    private int dZo;
    private PbActivity eat;
    private du ecm;
    private cm ecn;
    private co eco;
    private cn ecp;
    private ef ecq;
    private em ecr;
    private com.baidu.tieba.pb.pb.a.b ecs;
    private com.baidu.tieba.pb.pb.a.z ect;
    private com.baidu.tieba.pb.pb.a.e ecu;
    private cy ecv;
    private dt ecw;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> ecx = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.s> ecy = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cwk = true;
    private boolean dZp = true;
    private boolean dZq = true;
    private boolean ecz = false;
    private String dZr = null;
    private View.OnClickListener dZu = null;
    private View.OnClickListener baF = null;
    private TbRichTextView.d aGw = null;
    private com.baidu.tieba.pb.a.d dYQ = null;
    private View.OnLongClickListener alj = null;
    private cs ecA = null;
    private final List<com.baidu.adp.widget.ListView.a> bCN = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> ecB = new ArrayList();
    private boolean ecC = false;
    private CustomMessageListener bKG = new ci(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bEF = new cj(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bKH = new ck(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public ch(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.dZo = 0;
        this.width = -1;
        this.dZo = com.baidu.adp.lib.util.k.A(pbActivity.getPageContext().getPageActivity());
        this.width = this.dZo;
        this.eat = pbActivity;
        this.bqG = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bEF);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ect = new com.baidu.tieba.pb.pb.a.z(pbActivity, com.baidu.tieba.tbadkCore.data.s.fkJ);
        this.ecu = new com.baidu.tieba.pb.pb.a.e(pbActivity, com.baidu.tieba.tbadkCore.data.s.QC);
        this.ecm = new du(pbActivity, com.baidu.tieba.tbadkCore.data.s.fkG);
        this.ecn = new cm(pbActivity, com.baidu.tbadk.core.data.b.Mw);
        this.eco = new co(pbActivity, com.baidu.tbadk.core.data.b.Mx);
        this.ecp = new cn(pbActivity, com.baidu.tbadk.core.data.b.My);
        this.ecv = new cy(pbActivity, com.baidu.tieba.pb.data.c.dXK);
        this.ecw = new dt(pbActivity, com.baidu.tieba.pb.data.l.dYt);
        this.ecq = new ef(pbActivity, ds.eet);
        this.ecr = new em(pbActivity, com.baidu.tbadk.core.data.am.Pm);
        this.bCN.add(this.ecm);
        this.bCN.add(this.ect);
        this.bCN.add(this.ecu);
        this.bCN.add(this.ecn);
        this.bCN.add(this.eco);
        this.bCN.add(this.ecp);
        this.bCN.add(this.ecv);
        this.bCN.add(this.ecw);
        this.bCN.add(this.ecq);
        this.bCN.add(this.ecr);
        this.bKG.setPriority(1);
        this.bKG.setSelfListener(true);
        pbActivity.registerListener(this.bKG);
        Yj();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(0);
        aVar.dXE = pbActivity;
        aVar.bCN = this.bCN;
        aVar.aGK();
        this.ecA = aVar.dXH;
        bdTypeListView.g(this.bCN);
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        boolean z;
        com.baidu.tieba.tbadkCore.data.s sVar;
        int size;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        int size2;
        if (this.dYM != hVar) {
            z = (hVar == null || hVar.aGU()) && TbadkCoreApplication.m10getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.dYM = hVar;
        if (z) {
            aIy();
            if (hVar != null) {
                hVar.hq(false);
            }
        }
        if (this.ecy == null) {
            this.ecy = new ArrayList<>();
        }
        this.ecy.clear();
        if (this.dYM != null && this.dYM.aGZ() != null && this.dYM.aGZ().size() > 0) {
            this.ecy.addAll(this.dYM.aGZ());
        }
        if (hVar != null && hVar.aGY() != null && hVar.aGY().getAuthor() != null) {
            this.dZr = hVar.aGY().getAuthor().getUserId();
        }
        if (this.ecm != null && this.ecn != null) {
            this.ect.b(hVar);
            this.ect.setFromCDN(this.mIsFromCDN);
            this.ect.ob(this.dZr);
            this.ect.nx(this.dZo);
            this.ect.hr(this.cwk);
            this.ect.hs(this.dZp);
            this.ect.ht(this.dZq);
            this.ect.setCommonClickListener(this.baF);
            this.ect.I(this.dZu);
            this.ect.setOnImageClickListener(this.aGw);
            this.ect.setOnLongClickListener(this.alj);
            this.ect.a(this.dYQ);
            this.ecu.b(hVar);
            this.ecu.setFromCDN(this.mIsFromCDN);
            this.ecu.a(this.dYQ);
            this.ecm.b(hVar);
            this.ecm.setFromCDN(this.mIsFromCDN);
            this.ecm.ob(this.dZr);
            this.ecm.nx(this.dZo);
            this.ecm.hr(this.cwk);
            this.ecm.hs(this.dZp);
            this.ecm.ht(this.dZq);
            this.ecm.hu(this.ecz);
            this.ecm.setCommonClickListener(this.baF);
            this.ecm.I(this.dZu);
            this.ecm.setOnImageClickListener(this.aGw);
            this.ecm.setOnLongClickListener(this.alj);
            this.ecm.a(this.dYQ);
            this.ecn.setFromCDN(this.mIsFromCDN);
            this.eco.setFromCDN(this.mIsFromCDN);
            this.ecp.setFromCDN(this.mIsFromCDN);
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ecx.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(hVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.ob(this.dZr);
                    next.nx(this.dZo);
                    next.hr(this.cwk);
                    next.hs(this.dZp);
                    next.ht(this.dZq);
                    next.hu(this.ecz);
                    next.setCommonClickListener(this.baF);
                    next.I(this.dZu);
                    next.setOnImageClickListener(this.aGw);
                    next.setOnLongClickListener(this.alj);
                    next.a(this.dYQ);
                }
            }
            com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(1);
            aVar.dXG = this.baF;
            aVar.dXH = this.ecA;
            aVar.aGK();
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (hVar.aGZ() != null) {
                arrayList.addAll(hVar.aGZ());
            }
            ct(arrayList);
            if (!this.dZq && hVar != null && hVar.aGZ() != null && (size = hVar.aGZ().size()) > 0 && (sVar2 = hVar.aGZ().get(size - 1)) != null && sVar2.bfB() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.eat.aIg()) {
                if (hVar.aGZ().size() > 0 && (sVar = hVar.aGZ().get(0)) != null && sVar.bfB() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int a = a(this.dYM, arrayList, this.dZq);
                if (a >= 0) {
                    com.baidu.tbadk.core.util.y.a(arrayList, a, this.dYM.aHa());
                }
            }
            int b = b(this.dYM, arrayList, this.dZq);
            if (b >= 0) {
                com.baidu.tbadk.core.util.y.a(arrayList, b, this.dYM.aHb());
            }
            int c = c(this.dYM, arrayList, this.dZq);
            int size3 = arrayList.size();
            if (!this.eat.aIg()) {
                if (c < 0) {
                    this.eat.hw(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.dYM.aGV());
                    } else if (c >= size3) {
                        arrayList.add(this.dYM.aGV());
                    } else {
                        arrayList.add(c, this.dYM.aGV());
                    }
                    this.eat.hw(true);
                }
            }
            if (c < 0) {
                this.ecm.hw(false);
                this.ecu.hw(false);
            } else {
                this.ecm.hw(true);
                this.ecu.hw(true);
            }
            if (arrayList.size() == 0 && this.eat.aIg()) {
                arrayList.add(new com.baidu.tieba.pb.data.l());
            }
            if (hVar != null && hVar.aGY() != null && hVar.aGY().RO != null) {
                DealInfoData rs = hVar.aGY().rs();
                com.baidu.tieba.pb.data.a aVar2 = new com.baidu.tieba.pb.data.a(2);
                aVar2.dXF = rs;
                aVar2.btF = arrayList;
                aVar2.aGK();
            }
            com.baidu.tieba.tbadkCore.w.r(arrayList, 1);
            if (this.bqG != null) {
                this.bqG.setData(arrayList);
            }
        }
    }

    private void Yj() {
        if (this.eat != null && !Yk()) {
            this.eat.registerListener(this.bKH);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean Yk() {
        if (this.eat == null) {
            return false;
        }
        this.bKC = new ArrayList();
        ArrayList<BdUniqueId> beB = com.baidu.tieba.tbadkCore.w.beB();
        if (beB == null || beB.size() <= 0) {
            return false;
        }
        int size = beB.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.axq().a(this.eat.getPageContext(), beB.get(i), 2);
            if (a != null) {
                this.bCN.add(a);
                this.bKC.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bKC)) {
            this.bqG.g(this.bKC);
        }
        return true;
    }

    public int aIx() {
        return this.bqG.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (hVar == null || hVar.aGZ() == null || hVar.aHa() == null || hVar.aGZ().size() == 0 || hVar.aGY() == null || arrayList == null) {
            return -1;
        }
        if (hVar.aHa().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (hVar.aGZ().get(0) == null || hVar.aGZ().get(0).bfB() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (hVar.getPage() == null || hVar.getPage().pl() != hVar.getPage().pi()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (hVar == null || hVar.aGZ() == null || hVar.aHb() == null || hVar.aGZ().size() == 0 || hVar.aGY() == null || arrayList == null) {
            return -1;
        }
        if (hVar.aHb().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (hVar.aGZ().get(0) == null || hVar.aGZ().get(0).bfB() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (hVar.getPage() == null || hVar.getPage().pl() != hVar.getPage().pi()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.aa aGV;
        if (hVar == null || hVar.aGZ() == null || hVar.aGV() == null || hVar.aGZ().size() == 0 || hVar.aGY() == null || arrayList == null) {
            return -1;
        }
        com.baidu.tieba.tbadkCore.data.s aHd = hVar.aHd();
        com.baidu.tieba.tbadkCore.data.s sVar = (aHd == null && hVar.aGZ().get(0) != null && hVar.aGZ().get(0).bfB() == 1) ? hVar.aGZ().get(0) : aHd;
        if (sVar == null) {
            return -1;
        }
        if ((sVar.getType() == com.baidu.tieba.tbadkCore.data.s.fkG || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.QC || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.fkJ) && com.baidu.tieba.graffiti.d.aeW()) {
            if (!this.ecC) {
                this.ecC = o(com.baidu.tbadk.core.data.aa.OB);
            }
            if (this.ecC && (aGV = hVar.aGV()) != null) {
                if (StringUtils.isNull(aGV.getForumId()) || StringUtils.isNull(aGV.getThreadId())) {
                    return -1;
                }
                return z ? 1 : -1;
            }
            return -1;
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v aw(int i) {
        return this.bqG.aw(i);
    }

    public BdUniqueId nB(int i) {
        if (this.bqG.aw(i) != null) {
            return this.bqG.aw(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.ecs == null || !this.ecs.aHz()) && (this.bqG.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.bqG.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aIy() {
        com.baidu.tieba.tbadkCore.data.r rVar;
        int position;
        if (this.dYM != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aGZ = this.dYM.aGZ();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aHj = this.dYM.aHj();
            if (aHj != null) {
                int size = aHj.size();
                if (aGZ != null && aGZ.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it = aHj.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next = it.next();
                        if (next != null && next.bfr() != null) {
                            sb.append(next.bfr());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it2 = aHj.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next2 = it2.next();
                        if (next2 != null) {
                            next2.bOx = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it3 = aHj.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next3 = it3.next();
                        if (next3.bfq() != null && next3.bfq().ok() && !com.baidu.tieba.tbadkCore.al.isInstalledPackage(TbadkCoreApplication.m10getInst().getContext(), next3.bfq().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(sparseArray.keyAt(i));
                        if (rVar2 != null) {
                            hashMap.put(rVar2.bfr(), rVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (rVar = (com.baidu.tieba.tbadkCore.data.r) entry.getValue()) != null) {
                            sparseArray.put(rVar.getPosition(), rVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new cl(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.r rVar3 = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = rVar3.getPosition();
                        if (!a(rVar3, aGZ)) {
                            if (position2 + i3 < aGZ.size()) {
                                if (this.dYM.aGX() != null) {
                                    rVar3.bhU = this.dYM.aGX().getId();
                                }
                                if (this.dYM.aGY() != null) {
                                    rVar3.threadId = com.baidu.adp.lib.h.b.c(this.dYM.aGY().getId(), 0L);
                                }
                                if (this.dYM != null && this.dYM.getPage() != null) {
                                    rVar3.pageNumber = this.dYM.getPage().pl();
                                }
                                aGZ.add(position2, rVar3);
                                TiebaStatic.eventStat(this.eat.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", rVar3.bfq().apk_name);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.r rVar, ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        int s = com.baidu.tbadk.core.util.y.s(arrayList);
        if (rVar == null || s <= 0) {
            return false;
        }
        int position = rVar.getPosition();
        if (s >= 2 || position != s + 1) {
            return false;
        }
        if (this.dYM != null && this.dYM.getPage() != null) {
            rVar.pageNumber = this.dYM.getPage().pl();
        }
        arrayList.add(rVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.ect.setFromCDN(z);
        this.ecu.setFromCDN(z);
        this.ecm.setFromCDN(z);
        this.ecn.setFromCDN(z);
        this.eco.setFromCDN(z);
        this.ecp.setFromCDN(z);
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ecx.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void hr(boolean z) {
        this.cwk = z;
    }

    public void hs(boolean z) {
        this.dZp = z;
    }

    public void ht(boolean z) {
        this.dZq = z;
    }

    public void hu(boolean z) {
        this.ecz = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.dZu = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGw = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dYQ = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alj = onLongClickListener;
    }

    public void J(View.OnClickListener onClickListener) {
        this.baF = onClickListener;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (this.bqG == null || bdUniqueId == null || com.baidu.tbadk.core.util.y.t(this.ecB)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.ecB) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.pb.pb.a.e aIz() {
        return this.ecu;
    }

    public co aIA() {
        return this.eco;
    }

    public cn aIB() {
        return this.ecp;
    }

    public com.baidu.tieba.pb.pb.a.b aIC() {
        return this.ecs;
    }

    private void ct(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.tbadkCore.data.s) {
                    com.baidu.tieba.tbadkCore.data.s sVar = (com.baidu.tieba.tbadkCore.data.s) list.get(i);
                    if (!TextUtils.isEmpty(sVar.rq())) {
                        com.baidu.tbadk.core.data.ac acVar = new com.baidu.tbadk.core.data.ac();
                        acVar.cm(sVar.rq());
                        list.set(i, acVar);
                    }
                }
            }
        }
    }
}
