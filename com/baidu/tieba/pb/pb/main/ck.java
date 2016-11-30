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
import com.baidu.tbadk.core.data.DealInfoData;
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
public class ck {
    private BdTypeListView aML;
    private com.baidu.adp.widget.ListView.a bYB;
    private com.baidu.adp.widget.ListView.a bYC;
    private com.baidu.adp.widget.ListView.a bYD;
    private com.baidu.adp.widget.ListView.a bYE;
    private List<com.baidu.adp.widget.ListView.a> bYT;
    private com.baidu.adp.widget.ListView.a ccJ;
    private com.baidu.tieba.pb.data.h esP;
    private int etg;
    private PbActivity eug;
    private dx ewh;
    private eg ewi;
    private en ewj;
    private com.baidu.tieba.pb.pb.a.b ewk;
    private com.baidu.tieba.pb.pb.a.u ewl;
    private com.baidu.tieba.pb.pb.a.e ewm;
    private da ewn;
    private dw ewo;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> ewp = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.q> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cNW = true;
    private boolean ewq = true;
    private boolean eth = true;
    private boolean ewr = false;
    private String eti = null;
    private View.OnClickListener etl = null;
    private View.OnClickListener bpk = null;
    private TbRichTextView.e aJZ = null;
    private com.baidu.tieba.pb.a.d esT = null;
    private View.OnLongClickListener aoS = null;
    private ct ews = null;
    private final List<com.baidu.adp.widget.ListView.a> bRh = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> ewt = new ArrayList();
    private boolean ewu = false;
    private CustomMessageListener bYZ = new cl(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bSW = new cm(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bZa = new co(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public ck(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.etg = 0;
        this.width = -1;
        this.etg = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.etg;
        this.eug = pbActivity;
        this.aML = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bSW);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ewl = new com.baidu.tieba.pb.pb.a.u(pbActivity, com.baidu.tieba.tbadkCore.data.q.fCt);
        this.ewm = new com.baidu.tieba.pb.pb.a.e(pbActivity, com.baidu.tieba.tbadkCore.data.q.TP);
        this.ewh = new dx(pbActivity, com.baidu.tieba.tbadkCore.data.q.fCr);
        this.ewh.a(pbActivity);
        this.bYB = com.baidu.tieba.recapp.e.bes().c(pbActivity, com.baidu.tbadk.core.data.c.Pd);
        this.bYC = com.baidu.tieba.recapp.e.bes().c(pbActivity, com.baidu.tbadk.core.data.c.Pe);
        this.bYD = com.baidu.tieba.recapp.e.bes().c(pbActivity, com.baidu.tbadk.core.data.c.Pf);
        this.bYE = com.baidu.tieba.recapp.e.bes().c(pbActivity, com.baidu.tbadk.core.data.c.Pg);
        this.ccJ = com.baidu.tieba.recapp.e.bes().c(pbActivity, com.baidu.tbadk.core.data.c.Pk);
        this.ewn = new da(pbActivity, com.baidu.tieba.pb.data.c.erK);
        this.ewo = new dw(pbActivity, com.baidu.tieba.pb.data.m.esw);
        this.ewi = new eg(pbActivity, dv.eyO);
        this.ewj = new en(pbActivity, com.baidu.tbadk.core.data.ar.Sz);
        this.bRh.add(this.ewh);
        this.bRh.add(this.ewl);
        this.bRh.add(this.ewm);
        this.bRh.add(this.bYB);
        this.bRh.add(this.bYC);
        this.bRh.add(this.bYD);
        this.bRh.add(this.bYE);
        this.bRh.add(this.ccJ);
        this.bRh.add(this.ewn);
        this.bRh.add(this.ewo);
        this.bRh.add(this.ewi);
        this.bRh.add(this.ewj);
        this.bYZ.setPriority(1);
        this.bYZ.setSelfListener(true);
        pbActivity.registerListener(this.bYZ);
        aew();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(0);
        aVar.erE = pbActivity;
        aVar.bRh = this.bRh;
        aVar.aNX();
        this.ews = aVar.erH;
        bdTypeListView.g(this.bRh);
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        boolean z;
        com.baidu.tieba.tbadkCore.data.q qVar;
        int size;
        com.baidu.tieba.tbadkCore.data.q qVar2;
        int size2;
        if (this.esP != hVar) {
            z = (hVar == null || hVar.aOh()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.esP = hVar;
        if (z) {
            aPO();
            if (hVar != null) {
                hVar.ii(false);
            }
        }
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }
        this.postList.clear();
        if (this.esP != null && this.esP.aOm() != null && this.esP.aOm().size() > 0) {
            this.postList.addAll(this.esP.aOm());
        }
        if (hVar != null && hVar.aOl() != null && hVar.aOl().getAuthor() != null) {
            this.eti = hVar.aOl().getAuthor().getUserId();
        }
        if (this.ewh != null) {
            this.ewl.b(hVar);
            this.ewl.setFromCDN(this.mIsFromCDN);
            this.ewl.pm(this.eti);
            this.ewl.ou(this.etg);
            this.ewl.ij(this.cNW);
            this.ewl.ik(this.eth);
            this.ewl.setCommonClickListener(this.bpk);
            this.ewl.I(this.etl);
            this.ewl.setOnImageClickListener(this.aJZ);
            this.ewl.setOnLongClickListener(this.aoS);
            this.ewl.a(this.esT);
            this.ewm.b(hVar);
            this.ewm.setFromCDN(this.mIsFromCDN);
            this.ewm.a(this.esT);
            this.ewh.b(hVar);
            this.ewh.setFromCDN(this.mIsFromCDN);
            this.ewh.pm(this.eti);
            this.ewh.ou(this.etg);
            this.ewh.ij(this.cNW);
            this.ewh.ik(this.eth);
            this.ewh.il(this.ewr);
            this.ewh.setCommonClickListener(this.bpk);
            this.ewh.I(this.etl);
            this.ewh.setOnImageClickListener(this.aJZ);
            this.ewh.setOnLongClickListener(this.aoS);
            this.ewh.a(this.esT);
            if (this.bYC != null && (this.bYC instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bYC).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bYD != null && (this.bYD instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bYD).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.ccJ != null && (this.ccJ instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.ccJ).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ewp.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(hVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.pm(this.eti);
                    next.ou(this.etg);
                    next.ij(this.cNW);
                    next.ik(this.eth);
                    next.il(this.ewr);
                    next.setCommonClickListener(this.bpk);
                    next.I(this.etl);
                    next.setOnImageClickListener(this.aJZ);
                    next.setOnLongClickListener(this.aoS);
                    next.a(this.esT);
                }
            }
            com.baidu.tieba.pb.data.a aVar = new com.baidu.tieba.pb.data.a(1);
            aVar.erG = this.bpk;
            aVar.erH = this.ews;
            aVar.aNX();
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (hVar.aOm() != null) {
                arrayList.addAll(hVar.aOm());
            }
            cy(arrayList);
            if (!this.eth && hVar != null && hVar.aOm() != null && (size = hVar.aOm().size()) > 0 && (qVar2 = hVar.aOm().get(size - 1)) != null && qVar2.bml() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.eug.aPv()) {
                if (hVar.aOm().size() > 0 && (qVar = hVar.aOm().get(0)) != null && qVar.bml() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int a = a(this.esP, arrayList, this.eth);
                if (a >= 0) {
                    com.baidu.tbadk.core.util.x.a(arrayList, a, this.esP.aOn());
                }
            }
            int b = b(this.esP, arrayList, this.eth);
            if (b >= 0) {
                com.baidu.tbadk.core.util.x.a(arrayList, b, this.esP.aOo());
            }
            int c = c(this.esP, arrayList, this.eth);
            int size3 = arrayList.size();
            if (!this.eug.aPv()) {
                if (c < 0) {
                    this.eug.in(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.esP.aOi());
                    } else if (c >= size3) {
                        arrayList.add(this.esP.aOi());
                    } else {
                        arrayList.add(c, this.esP.aOi());
                    }
                    this.eug.in(true);
                }
            }
            if (c < 0) {
                this.ewh.in(false);
            } else {
                this.ewh.in(true);
            }
            if (arrayList.size() == 0 && this.eug.aPv()) {
                arrayList.add(new com.baidu.tieba.pb.data.m());
            }
            if (hVar != null && hVar.aOl() != null && hVar.aOl().Ve != null) {
                DealInfoData sM = hVar.aOl().sM();
                com.baidu.tieba.pb.data.a aVar2 = new com.baidu.tieba.pb.data.a(2);
                aVar2.erF = sM;
                aVar2.bHW = arrayList;
                aVar2.aNX();
            }
            com.baidu.tieba.tbadkCore.v.s(arrayList, 1);
            if (this.aML != null) {
                this.aML.setData(arrayList);
            }
        }
    }

    private void aew() {
        if (this.eug != null && !aex()) {
            this.eug.registerListener(this.bZa);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aex() {
        if (this.eug == null) {
            return false;
        }
        this.bYT = new ArrayList();
        ArrayList<BdUniqueId> bls = com.baidu.tieba.tbadkCore.v.bls();
        if (bls == null || bls.size() <= 0) {
            return false;
        }
        int size = bls.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aEB().a(this.eug.getPageContext(), bls.get(i), 2);
            if (a != null) {
                this.bRh.add(a);
                this.bYT.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.t(this.bYT)) {
            this.aML.g(this.bYT);
        }
        return true;
    }

    public int aPM() {
        return this.aML.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (hVar == null || hVar.aOm() == null || hVar.aOn() == null || hVar.aOm().size() == 0 || hVar.aOl() == null || arrayList == null) {
            return -1;
        }
        if (hVar.aOn().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (hVar.aOm().get(0) == null || hVar.aOm().get(0).bml() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (hVar.getPage() == null || hVar.getPage().qB() != hVar.getPage().qy()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (hVar == null || hVar.aOm() == null || hVar.aOo() == null || hVar.aOm().size() == 0 || hVar.aOl() == null || arrayList == null) {
            return -1;
        }
        if (hVar.aOo().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (hVar.aOm().get(0) == null || hVar.aOm().get(0).bml() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (hVar.getPage() == null || hVar.getPage().qB() != hVar.getPage().qy()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.h hVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.af aOi;
        if (hVar == null || hVar.aOm() == null || hVar.aOi() == null || hVar.aOm().size() == 0 || hVar.aOl() == null || arrayList == null) {
            return -1;
        }
        com.baidu.tieba.tbadkCore.data.q aOq = hVar.aOq();
        com.baidu.tieba.tbadkCore.data.q qVar = (aOq == null && hVar.aOm().get(0) != null && hVar.aOm().get(0).bml() == 1) ? hVar.aOm().get(0) : aOq;
        if (qVar == null) {
            return -1;
        }
        if ((qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fCr || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.TP || qVar.getType() == com.baidu.tieba.tbadkCore.data.q.fCt) && com.baidu.tieba.graffiti.d.alQ()) {
            if (!this.ewu) {
                this.ewu = o(com.baidu.tbadk.core.data.af.RQ);
            }
            if (this.ewu && (aOi = hVar.aOi()) != null) {
                if (StringUtils.isNull(aOi.getForumId()) || StringUtils.isNull(aOi.getThreadId())) {
                    return -1;
                }
                return z ? 1 : -1;
            }
            return -1;
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v aJ(int i) {
        return this.aML.aJ(i);
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.q> aPN() {
        return this.postList;
    }

    public BdUniqueId oy(int i) {
        if (this.aML.aJ(i) != null) {
            return this.aML.aJ(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.ewk == null || !this.ewk.aOQ()) && (this.aML.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aML.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aPO() {
        com.baidu.tieba.tbadkCore.data.p pVar;
        int position;
        if (this.esP != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aOm = this.esP.aOm();
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aOw = this.esP.aOw();
            if (aOw != null) {
                int size = aOw.size();
                if (aOm != null && aOm.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it = aOw.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next = it.next();
                        if (next != null && next.bmb() != null) {
                            sb.append(next.bmb());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it2 = aOw.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next2 = it2.next();
                        if (next2 != null) {
                            next2.cdj = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.p> it3 = aOw.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.p next3 = it3.next();
                        if (next3.blZ() != null && next3.blZ().pj() && !com.baidu.tieba.tbadkCore.aj.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.blZ().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.p pVar2 = (com.baidu.tieba.tbadkCore.data.p) sparseArray.get(sparseArray.keyAt(i));
                        if (pVar2 != null) {
                            hashMap.put(pVar2.bmb(), pVar2);
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
                    Collections.sort(arrayList, new cp(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.p pVar3 = (com.baidu.tieba.tbadkCore.data.p) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = pVar3.getPosition();
                        if (!a(pVar3, aOm)) {
                            if (position2 + i3 < aOm.size()) {
                                if (this.esP.aOk() != null) {
                                    pVar3.forumId = this.esP.aOk().getId();
                                }
                                if (this.esP.aOl() != null) {
                                    pVar3.threadId = com.baidu.adp.lib.h.b.c(this.esP.aOl().getId(), 0L);
                                }
                                if (this.esP != null && this.esP.getPage() != null) {
                                    pVar3.pageNumber = this.esP.getPage().qB();
                                }
                                b(pVar3);
                                aOm.add(position2, pVar3);
                                TiebaStatic.eventStat(this.eug.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", pVar3.blZ().apk_name);
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
        ForumData aOk;
        if (pVar != null && this.esP != null && pVar.blZ() != null) {
            pVar.blZ().PD = new com.baidu.tbadk.core.data.b();
            if (this.esP.getPage() != null) {
                pVar.blZ().PD.pn = this.esP.getPage().qB();
            }
            pVar.blZ().PD.OS = "PB";
            if (this.esP.aOk() != null && (aOk = this.esP.aOk()) != null) {
                pVar.blZ().PD.fid = aOk.getId();
                pVar.blZ().PD.OU = aOk.getFirst_class();
                pVar.blZ().PD.OV = aOk.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                pVar.blZ().PD.OW = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            pVar.blZ().PD.extensionInfo = pVar.blZ().ext_info;
            pVar.blZ().PD.OX = false;
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
        if (this.esP != null && this.esP.getPage() != null) {
            pVar.pageNumber = this.esP.getPage().qB();
        }
        arrayList.add(pVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.ewl.setFromCDN(z);
        this.ewm.setFromCDN(z);
        this.ewh.setFromCDN(z);
        if (this.bYC != null && (this.bYC instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bYC).setIsFromCDN(z);
        }
        if (this.bYD != null && (this.bYD instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bYD).setIsFromCDN(z);
        }
        if (this.ccJ != null && (this.ccJ instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.ccJ).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ewp.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void ij(boolean z) {
        this.cNW = z;
    }

    public void ik(boolean z) {
        this.eth = z;
    }

    public void il(boolean z) {
        this.ewr = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.etl = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aJZ = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.esT = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoS = onLongClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.bpk = onClickListener;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (this.aML == null || bdUniqueId == null || com.baidu.tbadk.core.util.x.t(this.ewt)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.ewt) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.pb.pb.a.e aPP() {
        return this.ewm;
    }

    public com.baidu.tieba.recapp.a aPQ() {
        return (com.baidu.tieba.recapp.a) this.bYC;
    }

    public com.baidu.tieba.recapp.a aPR() {
        return (com.baidu.tieba.recapp.a) this.bYD;
    }

    public void oz(int i) {
        switch (i) {
            case 1:
                if (this.ewk != null) {
                    this.ewk.pause();
                }
                if (this.bYE != null && (this.bYE instanceof com.baidu.tieba.recapp.d)) {
                    ((com.baidu.tieba.recapp.d) this.bYE).release();
                    return;
                }
                return;
            case 2:
                if (this.ewk != null) {
                    this.ewk.resume();
                }
                if (this.bYE != null && (this.bYE instanceof com.baidu.tieba.recapp.d)) {
                    ((com.baidu.tieba.recapp.d) this.bYE).resume();
                    return;
                }
                return;
            case 3:
                if (this.ewk != null) {
                    this.ewk.release();
                }
                if (this.bYE != null && (this.bYE instanceof com.baidu.tieba.recapp.d)) {
                    ((com.baidu.tieba.recapp.d) this.bYE).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cy(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.tbadkCore.data.q) {
                    com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) list.get(i);
                    if (!TextUtils.isEmpty(qVar.sJ())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.cp(qVar.sJ());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }
}
