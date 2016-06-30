package com.baidu.tieba.pb.pb.main;

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
    private BdTypeListView bou;
    private com.baidu.tieba.pb.data.h dMC;
    private int dNb;
    private PbActivity dOg;
    private dt dPY;
    private cl dPZ;
    private cn dQa;
    private cm dQb;
    private ee dQc;
    private com.baidu.tieba.pb.pb.a.b dQd;
    private com.baidu.tieba.pb.pb.a.z dQe;
    private com.baidu.tieba.pb.pb.a.e dQf;
    private cx dQg;
    private ds dQh;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> dQi = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.s> dQj = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean ctv = true;
    private boolean dNc = true;
    private boolean dNd = true;
    private boolean dQk = false;
    private String dNe = null;
    private View.OnClickListener dNh = null;
    private View.OnClickListener aZG = null;
    private TbRichTextView.d aFF = null;
    private com.baidu.tieba.pb.a.d dME = null;
    private View.OnLongClickListener aku = null;
    private cr dQl = null;
    private final List<com.baidu.adp.widget.ListView.a> bAz = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> dQm = new ArrayList();
    private boolean dQn = false;
    private CustomMessageListener bJb = new ci(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bDv = new cj(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public ch(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.dNb = 0;
        this.width = -1;
        this.dNb = com.baidu.adp.lib.util.k.A(pbActivity.getPageContext().getPageActivity());
        this.width = this.dNb;
        this.dOg = pbActivity;
        this.bou = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bDv);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.dQe = new com.baidu.tieba.pb.pb.a.z(pbActivity, com.baidu.tieba.tbadkCore.data.s.eXH);
        this.dQf = new com.baidu.tieba.pb.pb.a.e(pbActivity, com.baidu.tieba.tbadkCore.data.s.Qh);
        this.dPY = new dt(pbActivity, com.baidu.tieba.tbadkCore.data.s.eXE);
        this.dPZ = new cl(pbActivity, com.baidu.tbadk.core.data.b.My);
        this.dQa = new cn(pbActivity, com.baidu.tbadk.core.data.b.Mz);
        this.dQb = new cm(pbActivity, com.baidu.tbadk.core.data.b.MA);
        this.dQg = new cx(pbActivity, com.baidu.tieba.pb.data.c.dLB);
        this.dQh = new ds(pbActivity, com.baidu.tieba.pb.data.l.dMj);
        this.dQc = new ee(pbActivity, dr.dSc);
        this.bAz.add(this.dPY);
        this.bAz.add(this.dQe);
        this.bAz.add(this.dQf);
        this.bAz.add(this.dPZ);
        this.bAz.add(this.dQa);
        this.bAz.add(this.dQb);
        this.bAz.add(this.dQg);
        this.bAz.add(this.dQh);
        this.bAz.add(this.dQc);
        this.bJb.setPriority(1);
        this.bJb.setSelfListener(true);
        pbActivity.registerListener(this.bJb);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(0);
        aVar.dLv = pbActivity;
        aVar.bAz = this.bAz;
        aVar.aDA();
        this.dQl = aVar.dLy;
        bdTypeListView.g(this.bAz);
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        boolean z;
        com.baidu.tieba.tbadkCore.data.s sVar;
        int size;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        int size2;
        if (this.dMC != hVar) {
            z = (hVar == null || hVar.aDK()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.dMC = hVar;
        if (z) {
            aFn();
            if (hVar != null) {
                hVar.hf(false);
            }
        }
        if (this.dQj == null) {
            this.dQj = new ArrayList<>();
        }
        this.dQj.clear();
        if (this.dMC != null && this.dMC.aDP() != null && this.dMC.aDP().size() > 0) {
            this.dQj.addAll(this.dMC.aDP());
        }
        if (hVar != null && hVar.aDO() != null && hVar.aDO().getAuthor() != null) {
            this.dNe = hVar.aDO().getAuthor().getUserId();
        }
        if (this.dPY != null && this.dPZ != null) {
            this.dQe.b(hVar);
            this.dQe.setFromCDN(this.mIsFromCDN);
            this.dQe.nq(this.dNe);
            this.dQe.nf(this.dNb);
            this.dQe.hg(this.ctv);
            this.dQe.hh(this.dNc);
            this.dQe.hi(this.dNd);
            this.dQe.setCommonClickListener(this.aZG);
            this.dQe.H(this.dNh);
            this.dQe.setOnImageClickListener(this.aFF);
            this.dQe.setOnLongClickListener(this.aku);
            this.dQe.a(this.dME);
            this.dQf.b(hVar);
            this.dQf.setFromCDN(this.mIsFromCDN);
            this.dQf.a(this.dME);
            this.dPY.b(hVar);
            this.dPY.setFromCDN(this.mIsFromCDN);
            this.dPY.nq(this.dNe);
            this.dPY.nf(this.dNb);
            this.dPY.hg(this.ctv);
            this.dPY.hh(this.dNc);
            this.dPY.hi(this.dNd);
            this.dPY.hj(this.dQk);
            this.dPY.setCommonClickListener(this.aZG);
            this.dPY.H(this.dNh);
            this.dPY.setOnImageClickListener(this.aFF);
            this.dPY.setOnLongClickListener(this.aku);
            this.dPY.a(this.dME);
            this.dPZ.setFromCDN(this.mIsFromCDN);
            this.dQa.setFromCDN(this.mIsFromCDN);
            this.dQb.setFromCDN(this.mIsFromCDN);
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.dQi.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(hVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.nq(this.dNe);
                    next.nf(this.dNb);
                    next.hg(this.ctv);
                    next.hh(this.dNc);
                    next.hi(this.dNd);
                    next.hj(this.dQk);
                    next.setCommonClickListener(this.aZG);
                    next.H(this.dNh);
                    next.setOnImageClickListener(this.aFF);
                    next.setOnLongClickListener(this.aku);
                    next.a(this.dME);
                }
            }
            com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(1);
            aVar.dLx = this.aZG;
            aVar.dLy = this.dQl;
            aVar.aDA();
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (hVar.aDP() != null) {
                arrayList.addAll(hVar.aDP());
            }
            if (!this.dNd && hVar != null && hVar.aDP() != null && (size = hVar.aDP().size()) > 0 && (sVar2 = hVar.aDP().get(size - 1)) != null && sVar2.bcm() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.dOg.aEV()) {
                if (hVar.aDP().size() > 0 && (sVar = hVar.aDP().get(0)) != null && sVar.bcm() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int a = a(this.dMC, arrayList, this.dNd);
                if (a >= 0) {
                    com.baidu.tbadk.core.util.y.a(arrayList, a, this.dMC.aDQ());
                }
            }
            int b = b(this.dMC, arrayList, this.dNd);
            int size3 = arrayList.size();
            if (!this.dOg.aEV()) {
                if (b < 0) {
                    this.dOg.hl(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.dMC.aDL());
                    } else if (b >= size3) {
                        arrayList.add(this.dMC.aDL());
                    } else {
                        arrayList.add(b, this.dMC.aDL());
                    }
                    this.dOg.hl(true);
                }
            }
            if (b < 0) {
                this.dPY.hl(false);
                this.dQf.hl(false);
            } else {
                this.dPY.hl(true);
                this.dQf.hl(true);
            }
            if (arrayList.size() == 0 && this.dOg.aEV()) {
                arrayList.add(new com.baidu.tieba.pb.data.l());
            }
            if (hVar != null && hVar.aDO() != null && hVar.aDO().Rl != null) {
                DealInfoData rt = hVar.aDO().rt();
                com.baidu.tieba.pb.data.a aVar2 = new com.baidu.tieba.pb.data.a(2);
                aVar2.dLw = rt;
                aVar2.brq = arrayList;
                aVar2.aDA();
            }
            if (this.bou != null) {
                this.bou.setData(arrayList);
            }
        }
    }

    public int aFm() {
        return this.bou.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (hVar == null || hVar.aDP() == null || hVar.aDQ() == null || hVar.aDP().size() == 0 || hVar.aDO() == null || arrayList == null) {
            return -1;
        }
        if (hVar.aDQ().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (hVar.aDP().get(0) == null || hVar.aDP().get(0).bcm() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (hVar.getPage() == null || hVar.getPage().pC() != hVar.getPage().pz()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.x aDL;
        if (hVar == null || hVar.aDP() == null || hVar.aDL() == null || hVar.aDP().size() == 0 || hVar.aDO() == null || arrayList == null) {
            return -1;
        }
        com.baidu.tieba.tbadkCore.data.s aDS = hVar.aDS();
        com.baidu.tieba.tbadkCore.data.s sVar = (aDS == null && hVar.aDP().get(0) != null && hVar.aDP().get(0).bcm() == 1) ? hVar.aDP().get(0) : aDS;
        if (sVar == null) {
            return -1;
        }
        if ((sVar.getType() == com.baidu.tieba.tbadkCore.data.s.eXE || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.Qh || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.eXH) && com.baidu.tieba.graffiti.d.aet()) {
            if (!this.dQn) {
                this.dQn = o(com.baidu.tbadk.core.data.x.Op);
            }
            if (this.dQn && (aDL = hVar.aDL()) != null) {
                if (StringUtils.isNull(aDL.getForumId()) || StringUtils.isNull(aDL.getThreadId())) {
                    return -1;
                }
                return z ? 1 : -1;
            }
            return -1;
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v at(int i) {
        return this.bou.at(i);
    }

    public BdUniqueId nj(int i) {
        if (this.bou.at(i) != null) {
            return this.bou.at(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.dQd == null || !this.dQd.aEp()) && (this.bou.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.bou.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aFn() {
        com.baidu.tieba.tbadkCore.data.r rVar;
        int position;
        if (this.dMC != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aDP = this.dMC.aDP();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aDY = this.dMC.aDY();
            if (aDY != null) {
                int size = aDY.size();
                if (aDP != null && aDP.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it = aDY.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next = it.next();
                        if (next != null && next.bcc() != null) {
                            sb.append(next.bcc());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it2 = aDY.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next2 = it2.next();
                        if (next2 != null) {
                            next2.bMN = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it3 = aDY.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next3 = it3.next();
                        if (next3.bcb() != null && next3.bcb().ov() && !com.baidu.tieba.tbadkCore.al.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bcb().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(sparseArray.keyAt(i));
                        if (rVar2 != null) {
                            hashMap.put(rVar2.bcc(), rVar2);
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
                    Collections.sort(arrayList, new ck(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.r rVar3 = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = rVar3.getPosition();
                        if (!a(rVar3, aDP)) {
                            if (position2 + i3 < aDP.size()) {
                                if (this.dMC.aDN() != null) {
                                    rVar3.bgH = this.dMC.aDN().getId();
                                }
                                if (this.dMC.aDO() != null) {
                                    rVar3.threadId = com.baidu.adp.lib.h.b.c(this.dMC.aDO().getId(), 0L);
                                }
                                if (this.dMC != null && this.dMC.getPage() != null) {
                                    rVar3.pageNumber = this.dMC.getPage().pC();
                                }
                                aDP.add(position2, rVar3);
                                TiebaStatic.eventStat(this.dOg.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", rVar3.bcb().apk_name);
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
        if (this.dMC != null && this.dMC.getPage() != null) {
            rVar.pageNumber = this.dMC.getPage().pC();
        }
        arrayList.add(rVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.dQe.setFromCDN(z);
        this.dQf.setFromCDN(z);
        this.dPY.setFromCDN(z);
        this.dPZ.setFromCDN(z);
        this.dQa.setFromCDN(z);
        this.dQb.setFromCDN(z);
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.dQi.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void hg(boolean z) {
        this.ctv = z;
    }

    public void hh(boolean z) {
        this.dNc = z;
    }

    public void hi(boolean z) {
        this.dNd = z;
    }

    public void hj(boolean z) {
        this.dQk = z;
    }

    public void H(View.OnClickListener onClickListener) {
        this.dNh = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFF = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dME = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aku = onLongClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.aZG = onClickListener;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (this.bou == null || bdUniqueId == null || com.baidu.tbadk.core.util.y.t(this.dQm)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.dQm) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.pb.pb.a.e aFo() {
        return this.dQf;
    }

    public cn aFp() {
        return this.dQa;
    }

    public cm aFq() {
        return this.dQb;
    }

    public com.baidu.tieba.pb.pb.a.b aFr() {
        return this.dQd;
    }
}
