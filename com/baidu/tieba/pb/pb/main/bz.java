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
public class bz {
    private BdTypeListView bej;
    private int dfH;
    private com.baidu.tieba.pb.data.e dfK;
    private PbActivity dhY;
    private dq djX;
    private cd djY;
    private cf djZ;
    private ce dka;
    private Cdo dkb;
    private com.baidu.tieba.pb.pb.a.k dkc;
    private com.baidu.tieba.pb.pb.a.d dkd;
    private ch dke;
    private com.baidu.tieba.pb.pb.a.ao dkf;
    private com.baidu.tieba.pb.pb.a.r dkg;
    private dh dkh;
    private dl dki;
    private com.baidu.tieba.pb.pb.a.a dkj;
    private dp dkk;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.s> dkl = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean dfI = true;
    private boolean dfJ = true;
    private boolean dfL = true;
    private boolean dkm = false;
    private String dgZ = null;
    private View.OnClickListener dhc = null;
    private View.OnClickListener bnn = null;
    private TbRichTextView.d aFe = null;
    private com.baidu.tieba.pb.a.d dfM = null;
    private View.OnLongClickListener ajO = null;
    private final List<com.baidu.adp.widget.ListView.a> bei = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> dkn = new ArrayList();
    private boolean dko = false;
    private CustomMessageListener boJ = new ca(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bhg = new cb(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public bz(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.dfH = 0;
        this.width = -1;
        this.dfH = com.baidu.adp.lib.util.k.B(pbActivity.getPageContext().getPageActivity());
        this.width = this.dfH;
        this.dhY = pbActivity;
        this.bej = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bhg);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.dkf = new com.baidu.tieba.pb.pb.a.ao(pbActivity, com.baidu.tieba.tbadkCore.data.s.esT);
        this.dkg = new com.baidu.tieba.pb.pb.a.r(pbActivity, com.baidu.tieba.tbadkCore.data.s.PV);
        this.djX = new dq(pbActivity, com.baidu.tieba.tbadkCore.data.s.esQ);
        this.djY = new cd(pbActivity, com.baidu.tbadk.core.data.c.MG);
        this.djZ = new cf(pbActivity, com.baidu.tbadk.core.data.c.MH);
        this.dka = new ce(pbActivity, com.baidu.tbadk.core.data.c.MI);
        this.dkb = new Cdo(pbActivity, com.baidu.tbadk.core.data.bc.Rm);
        this.dkc = new com.baidu.tieba.pb.pb.a.k(pbActivity, com.baidu.tieba.tbadkCore.data.s.esR);
        this.dkd = new com.baidu.tieba.pb.pb.a.d(pbActivity, com.baidu.tieba.tbadkCore.data.s.QU);
        this.dke = new ch(pbActivity, com.baidu.tieba.tbadkCore.data.s.esS);
        this.dkh = new dh(pbActivity, com.baidu.tieba.tbadkCore.data.s.esU);
        this.dki = new dl(pbActivity, com.baidu.tieba.tbadkCore.data.s.esV);
        this.dkj = new com.baidu.tieba.pb.pb.a.a(pbActivity, com.baidu.tieba.tbadkCore.data.s.esW);
        this.dkk = new dp(pbActivity, com.baidu.tieba.pb.data.g.dfq);
        this.bei.add(this.djX);
        this.bei.add(this.dkf);
        this.bei.add(this.dkg);
        this.bei.add(this.djY);
        this.bei.add(this.djZ);
        this.bei.add(this.dka);
        this.bei.add(this.dkb);
        this.bei.add(this.dkc);
        this.bei.add(this.dkd);
        this.bei.add(this.dke);
        this.bei.add(this.dkh);
        this.bei.add(this.dki);
        this.bei.add(this.dkj);
        this.bei.add(this.dkk);
        this.boJ.setPriority(1);
        this.boJ.setSelfListener(true);
        pbActivity.registerListener(this.boJ);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.g(this.bei);
    }

    public void b(com.baidu.tieba.pb.data.e eVar) {
        boolean z;
        com.baidu.tieba.tbadkCore.data.s sVar;
        int size;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        int size2;
        if (this.dfK != eVar) {
            z = (eVar == null || eVar.avA()) && TbadkCoreApplication.m11getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.dfK = eVar;
        if (z) {
            axg();
            if (eVar != null) {
                eVar.gp(false);
            }
        }
        if (this.dkl == null) {
            this.dkl = new ArrayList<>();
        }
        this.dkl.clear();
        if (this.dfK != null && this.dfK.avF() != null && this.dfK.avF().size() > 0) {
            this.dkl.addAll(this.dfK.avF());
        }
        if (eVar != null && eVar.avE() != null && eVar.avE().getAuthor() != null) {
            this.dgZ = eVar.avE().getAuthor().getUserId();
        }
        if (this.djX != null && this.djY != null) {
            this.dkf.b(eVar);
            this.dkf.setFromCDN(this.mIsFromCDN);
            this.dkf.lQ(this.dgZ);
            this.dkf.lD(this.dfH);
            this.dkf.gq(this.dfI);
            this.dkf.gr(this.dfJ);
            this.dkf.gs(this.dfL);
            this.dkf.setCommonClickListener(this.bnn);
            this.dkf.H(this.dhc);
            this.dkf.setOnImageClickListener(this.aFe);
            this.dkf.setOnLongClickListener(this.ajO);
            this.dkf.a(this.dfM);
            this.dkg.b(eVar);
            this.dkg.setFromCDN(this.mIsFromCDN);
            this.dkg.a(this.dfM);
            this.djX.b(eVar);
            this.djX.setFromCDN(this.mIsFromCDN);
            this.djX.lQ(this.dgZ);
            this.djX.lD(this.dfH);
            this.djX.gq(this.dfI);
            this.djX.gr(this.dfJ);
            this.djX.gs(this.dfL);
            this.djX.gC(this.dkm);
            this.djX.setCommonClickListener(this.bnn);
            this.djX.H(this.dhc);
            this.djX.setOnImageClickListener(this.aFe);
            this.djX.setOnLongClickListener(this.ajO);
            this.djX.a(this.dfM);
            this.dkc.b(eVar);
            this.dkc.setFromCDN(this.mIsFromCDN);
            this.dkc.lD(this.dfH);
            this.dkc.gq(this.dfI);
            this.dkc.gr(this.dfJ);
            this.dkc.gs(this.dfL);
            this.dkc.setCommonClickListener(this.bnn);
            this.dkc.setOnImageClickListener(this.aFe);
            this.dkc.setOnLongClickListener(this.ajO);
            this.dkc.a(this.dfM);
            this.dkd.b(eVar);
            this.dkd.setFromCDN(this.mIsFromCDN);
            this.dkd.lD(this.dfH);
            this.dkd.gq(this.dfI);
            this.dkd.gs(this.dfL);
            this.dkd.setCommonClickListener(this.bnn);
            this.dkd.setOnImageClickListener(this.aFe);
            this.dkd.setOnLongClickListener(this.ajO);
            this.dkd.a(this.dfM);
            this.djY.setFromCDN(this.mIsFromCDN);
            this.djZ.setFromCDN(this.mIsFromCDN);
            this.dka.setFromCDN(this.mIsFromCDN);
            this.dke.b(eVar);
            this.dke.setFromCDN(this.mIsFromCDN);
            this.dke.lQ(this.dgZ);
            this.dke.lD(this.dfH);
            this.dke.gq(this.dfI);
            this.dke.gr(this.dfJ);
            this.dke.gs(this.dfL);
            this.dke.setCommonClickListener(this.bnn);
            this.dke.H(this.dhc);
            this.dke.setOnImageClickListener(this.aFe);
            this.dke.setOnLongClickListener(this.ajO);
            this.dke.a(this.dfM);
            this.dkh.b(eVar);
            this.dkh.setFromCDN(this.mIsFromCDN);
            this.dkh.lQ(this.dgZ);
            this.dkh.lD(this.dfH);
            this.dkh.gq(this.dfI);
            this.dkh.gr(this.dfJ);
            this.dkh.gs(this.dfL);
            this.dkh.setCommonClickListener(this.bnn);
            this.dkh.H(this.dhc);
            this.dkh.setOnImageClickListener(this.aFe);
            this.dkh.setOnLongClickListener(this.ajO);
            this.dkh.a(this.dfM);
            this.dki.b(eVar);
            this.dki.setFromCDN(this.mIsFromCDN);
            this.dki.lQ(this.dgZ);
            this.dki.lD(this.dfH);
            this.dki.gq(this.dfI);
            this.dki.gr(this.dfJ);
            this.dki.gs(this.dfL);
            this.dki.setCommonClickListener(this.bnn);
            this.dki.H(this.dhc);
            this.dki.setOnImageClickListener(this.aFe);
            this.dki.setOnLongClickListener(this.ajO);
            this.dki.a(this.dfM);
            this.dkj.b(eVar);
            this.dkj.setFromCDN(this.mIsFromCDN);
            this.dkj.lD(this.dfH);
            this.dkj.gq(this.dfI);
            this.dkj.gr(this.dfJ);
            this.dkj.gs(this.dfL);
            this.dkj.setCommonClickListener(this.bnn);
            this.dkj.setOnImageClickListener(this.aFe);
            this.dkj.setOnLongClickListener(this.ajO);
            this.dkj.a(this.dfM);
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (eVar.avF() != null) {
                arrayList.addAll(eVar.avF());
            }
            if (!this.dfL && eVar != null && eVar.avF() != null && (size = eVar.avF().size()) > 0 && (sVar2 = eVar.avF().get(size - 1)) != null && sVar2.aTY() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.dhY.awP()) {
                if (eVar.avF().size() > 0 && (sVar = eVar.avF().get(0)) != null && sVar.aTY() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int a = a(this.dfK, arrayList, this.dfL);
                if (a >= 0) {
                    com.baidu.tbadk.core.util.y.a(arrayList, a, this.dfK.avG());
                }
            }
            this.dkb.u(this.bnn);
            int b = b(this.dfK, arrayList, this.dfL);
            int size3 = arrayList.size();
            if (!this.dhY.awP()) {
                if (b < 0) {
                    this.dhY.gu(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.dfK.avB());
                    } else if (b >= size3) {
                        arrayList.add(this.dfK.avB());
                    } else {
                        arrayList.add(b, this.dfK.avB());
                    }
                    this.dhY.gu(true);
                }
            }
            if (b < 0) {
                this.djX.gu(false);
            } else {
                this.djX.gu(true);
            }
            if (arrayList.size() == 0 && this.dhY.awP()) {
                arrayList.add(new com.baidu.tieba.pb.data.g());
            }
            if (this.bej != null) {
                this.bej.setData(arrayList);
            }
        }
    }

    public int axf() {
        return this.bej.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (eVar == null || eVar.avF() == null || eVar.avG() == null || eVar.avF().size() == 0 || eVar.avE() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(eVar.avG().rC())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (eVar.avF().get(0) == null || eVar.avF().get(0).aTY() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (eVar.getPage() == null || eVar.getPage().pI() != eVar.getPage().pF()) ? -1 : 0;
        } else {
            return 0;
        }
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.v avB;
        if (eVar == null || eVar.avF() == null || eVar.avB() == null || eVar.avF().size() == 0 || eVar.avE() == null || arrayList == null) {
            return -1;
        }
        com.baidu.tieba.tbadkCore.data.s avI = eVar.avI();
        com.baidu.tieba.tbadkCore.data.s sVar = (avI == null && eVar.avF().get(0) != null && eVar.avF().get(0).aTY() == 1) ? eVar.avF().get(0) : avI;
        if (sVar == null) {
            return -1;
        }
        if ((sVar.getType() == com.baidu.tieba.tbadkCore.data.s.esQ || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.PV || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.esT) && com.baidu.tieba.graffiti.d.Yb()) {
            if (!this.dko) {
                this.dko = l(com.baidu.tbadk.core.data.v.Oq);
            }
            if (this.dko && (avB = eVar.avB()) != null) {
                if (StringUtils.isNull(avB.getForumId()) || StringUtils.isNull(avB.getThreadId())) {
                    return -1;
                }
                return z ? 1 : -1;
            }
            return -1;
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v as(int i) {
        return this.bej.as(i);
    }

    public BdUniqueId lK(int i) {
        if (this.bej.as(i) != null) {
            return this.bej.as(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.bej.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bej.getAdapter()).notifyDataSetChanged();
        }
    }

    private void axg() {
        com.baidu.tieba.tbadkCore.data.r rVar;
        int position;
        if (this.dfK != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avF = this.dfK.avF();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> avO = this.dfK.avO();
            if (avO != null) {
                int size = avO.size();
                if (avF != null && avF.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it = avO.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next = it.next();
                        if (next != null && next.aTO() != null) {
                            sb.append(next.aTO());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it2 = avO.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next2 = it2.next();
                        if (next2 != null) {
                            next2.brg = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it3 = avO.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next3 = it3.next();
                        if (next3.aTN() != null && next3.aTN().oF() && !com.baidu.tieba.tbadkCore.ah.isInstalledPackage(TbadkCoreApplication.m11getInst().getContext(), next3.aTN().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(sparseArray.keyAt(i));
                        if (rVar2 != null) {
                            hashMap.put(rVar2.aTO(), rVar2);
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
                    Collections.sort(arrayList, new cc(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.r rVar3 = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = rVar3.getPosition();
                        if (!a(rVar3, avF)) {
                            if (position2 + i3 < avF.size()) {
                                if (this.dfK.avD() != null) {
                                    rVar3.esP = this.dfK.avD().getId();
                                }
                                if (this.dfK.avE() != null) {
                                    rVar3.threadId = com.baidu.adp.lib.h.b.c(this.dfK.avE().getId(), 0L);
                                }
                                if (this.dfK != null && this.dfK.getPage() != null) {
                                    rVar3.pageNumber = this.dfK.getPage().pI();
                                }
                                avF.add(position2, rVar3);
                                TiebaStatic.eventStat(this.dhY.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", rVar3.aTN().apk_name);
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
        int r = com.baidu.tbadk.core.util.y.r(arrayList);
        if (rVar == null || r <= 0) {
            return false;
        }
        int position = rVar.getPosition();
        if (r >= 2 || position != r + 1) {
            return false;
        }
        if (this.dfK != null && this.dfK.getPage() != null) {
            rVar.pageNumber = this.dfK.getPage().pI();
        }
        arrayList.add(rVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.dkf.setFromCDN(z);
        this.dkg.setFromCDN(z);
        this.djX.setFromCDN(z);
        this.dkc.setFromCDN(z);
        this.dkd.setFromCDN(z);
        this.djY.setFromCDN(z);
        this.djZ.setFromCDN(z);
        this.dka.setFromCDN(z);
        this.dkj.setFromCDN(z);
    }

    public void gq(boolean z) {
        this.dfI = z;
    }

    public void gr(boolean z) {
        this.dfJ = z;
    }

    public void gs(boolean z) {
        this.dfL = z;
    }

    public void gC(boolean z) {
        this.dkm = z;
    }

    public void H(View.OnClickListener onClickListener) {
        this.dhc = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFe = dVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.dfM = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajO = onLongClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.bnn = onClickListener;
    }

    public boolean l(BdUniqueId bdUniqueId) {
        if (this.bej == null || bdUniqueId == null || com.baidu.tbadk.core.util.y.s(this.dkn)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.dkn) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.pb.pb.a.r axh() {
        return this.dkg;
    }

    public cf axi() {
        return this.djZ;
    }

    public ce axj() {
        return this.dka;
    }
}
