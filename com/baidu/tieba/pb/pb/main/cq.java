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
public class cq {
    private BdTypeListView bcd;
    private int ddn;
    private com.baidu.tieba.pb.data.e ddq;
    private PbActivity dfw;
    private dz dhP;
    private cu dhQ;
    private cw dhR;
    private cv dhS;
    private dx dhT;
    private com.baidu.tieba.pb.pb.a.k dhU;
    private com.baidu.tieba.pb.pb.a.d dhV;
    private cy dhW;
    private com.baidu.tieba.pb.pb.a.ao dhX;
    private com.baidu.tieba.pb.pb.a.r dhY;
    private dq dhZ;
    private du dia;
    private com.baidu.tieba.pb.pb.a.a dib;
    private dy dic;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.s> did = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean ddo = true;
    private boolean ddp = true;
    private boolean ddr = true;
    private String deG = null;
    private View.OnClickListener deJ = null;
    private View.OnClickListener brL = null;
    private TbRichTextView.d aJc = null;
    private com.baidu.tieba.pb.a.c dds = null;
    private View.OnLongClickListener aoa = null;
    private final List<com.baidu.adp.widget.ListView.a> bcG = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> die = new ArrayList();
    private boolean dif = false;
    private CustomMessageListener bmk = new cr(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener blc = new cs(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public cq(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ddn = 0;
        this.width = -1;
        this.ddn = com.baidu.adp.lib.util.k.B(pbActivity.getPageContext().getPageActivity());
        this.width = this.ddn;
        this.dfw = pbActivity;
        this.bcd = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.blc);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.dhX = new com.baidu.tieba.pb.pb.a.ao(pbActivity, com.baidu.tieba.tbadkCore.data.s.epJ);
        this.dhY = new com.baidu.tieba.pb.pb.a.r(pbActivity, com.baidu.tieba.tbadkCore.data.s.UX);
        this.dhP = new dz(pbActivity, com.baidu.tieba.tbadkCore.data.s.epG);
        this.dhQ = new cu(pbActivity, com.baidu.tbadk.core.data.c.RS);
        this.dhR = new cw(pbActivity, com.baidu.tbadk.core.data.c.RT);
        this.dhS = new cv(pbActivity, com.baidu.tbadk.core.data.c.RU);
        this.dhT = new dx(pbActivity, com.baidu.tbadk.core.data.aw.Wb);
        this.dhU = new com.baidu.tieba.pb.pb.a.k(pbActivity, com.baidu.tieba.tbadkCore.data.s.epH);
        this.dhV = new com.baidu.tieba.pb.pb.a.d(pbActivity, com.baidu.tieba.tbadkCore.data.s.VR);
        this.dhW = new cy(pbActivity, com.baidu.tieba.tbadkCore.data.s.epI);
        this.dhZ = new dq(pbActivity, com.baidu.tieba.tbadkCore.data.s.epK);
        this.dia = new du(pbActivity, com.baidu.tieba.tbadkCore.data.s.epL);
        this.dib = new com.baidu.tieba.pb.pb.a.a(pbActivity, com.baidu.tieba.tbadkCore.data.s.epM);
        this.dic = new dy(pbActivity, com.baidu.tieba.pb.data.f.dcW);
        this.bcG.add(this.dhP);
        this.bcG.add(this.dhX);
        this.bcG.add(this.dhY);
        this.bcG.add(this.dhQ);
        this.bcG.add(this.dhR);
        this.bcG.add(this.dhS);
        this.bcG.add(this.dhT);
        this.bcG.add(this.dhU);
        this.bcG.add(this.dhV);
        this.bcG.add(this.dhW);
        this.bcG.add(this.dhZ);
        this.bcG.add(this.dia);
        this.bcG.add(this.dib);
        this.bcG.add(this.dic);
        this.bmk.setPriority(1);
        this.bmk.setSelfListener(true);
        pbActivity.registerListener(this.bmk);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.g(this.bcG);
    }

    public void a(com.baidu.tieba.pb.data.e eVar) {
        boolean z;
        com.baidu.tieba.tbadkCore.data.s sVar;
        int size;
        com.baidu.tieba.tbadkCore.data.s sVar2;
        int size2;
        if (this.ddq != eVar) {
            z = (eVar == null || eVar.avr()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.ddq = eVar;
        if (z) {
            awQ();
            if (eVar != null) {
                eVar.fP(false);
            }
        }
        if (this.did == null) {
            this.did = new ArrayList<>();
        }
        this.did.clear();
        if (this.ddq != null && this.ddq.avw() != null && this.ddq.avw().size() > 0) {
            this.did.addAll(this.ddq.avw());
        }
        if (eVar != null && eVar.avv() != null && eVar.avv().getAuthor() != null) {
            this.deG = eVar.avv().getAuthor().getUserId();
        }
        if (this.dhP != null && this.dhQ != null) {
            this.dhX.a(eVar);
            this.dhX.setFromCDN(this.mIsFromCDN);
            this.dhX.lM(this.deG);
            this.dhX.lP(this.ddn);
            this.dhX.fQ(this.ddo);
            this.dhX.fR(this.ddp);
            this.dhX.fS(this.ddr);
            this.dhX.setCommonClickListener(this.brL);
            this.dhX.L(this.deJ);
            this.dhX.setOnImageClickListener(this.aJc);
            this.dhX.setOnLongClickListener(this.aoa);
            this.dhX.a(this.dds);
            this.dhY.a(eVar);
            this.dhY.setFromCDN(this.mIsFromCDN);
            this.dhY.a(this.dds);
            this.dhP.a(eVar);
            this.dhP.setFromCDN(this.mIsFromCDN);
            this.dhP.lM(this.deG);
            this.dhP.lP(this.ddn);
            this.dhP.fQ(this.ddo);
            this.dhP.fR(this.ddp);
            this.dhP.fS(this.ddr);
            this.dhP.setCommonClickListener(this.brL);
            this.dhP.L(this.deJ);
            this.dhP.setOnImageClickListener(this.aJc);
            this.dhP.setOnLongClickListener(this.aoa);
            this.dhP.a(this.dds);
            this.dhU.a(eVar);
            this.dhU.setFromCDN(this.mIsFromCDN);
            this.dhU.lP(this.ddn);
            this.dhU.fQ(this.ddo);
            this.dhU.fR(this.ddp);
            this.dhU.fS(this.ddr);
            this.dhU.setCommonClickListener(this.brL);
            this.dhU.setOnImageClickListener(this.aJc);
            this.dhU.setOnLongClickListener(this.aoa);
            this.dhU.a(this.dds);
            this.dhV.a(eVar);
            this.dhV.setFromCDN(this.mIsFromCDN);
            this.dhV.lP(this.ddn);
            this.dhV.fQ(this.ddo);
            this.dhV.fS(this.ddr);
            this.dhV.setCommonClickListener(this.brL);
            this.dhV.setOnImageClickListener(this.aJc);
            this.dhV.setOnLongClickListener(this.aoa);
            this.dhV.a(this.dds);
            this.dhQ.setFromCDN(this.mIsFromCDN);
            this.dhR.setFromCDN(this.mIsFromCDN);
            this.dhS.setFromCDN(this.mIsFromCDN);
            this.dhW.a(eVar);
            this.dhW.setFromCDN(this.mIsFromCDN);
            this.dhW.lM(this.deG);
            this.dhW.lP(this.ddn);
            this.dhW.fQ(this.ddo);
            this.dhW.fR(this.ddp);
            this.dhW.fS(this.ddr);
            this.dhW.setCommonClickListener(this.brL);
            this.dhW.L(this.deJ);
            this.dhW.setOnImageClickListener(this.aJc);
            this.dhW.setOnLongClickListener(this.aoa);
            this.dhW.a(this.dds);
            this.dhZ.a(eVar);
            this.dhZ.setFromCDN(this.mIsFromCDN);
            this.dhZ.lM(this.deG);
            this.dhZ.lP(this.ddn);
            this.dhZ.fQ(this.ddo);
            this.dhZ.fR(this.ddp);
            this.dhZ.fS(this.ddr);
            this.dhZ.setCommonClickListener(this.brL);
            this.dhZ.L(this.deJ);
            this.dhZ.setOnImageClickListener(this.aJc);
            this.dhZ.setOnLongClickListener(this.aoa);
            this.dhZ.a(this.dds);
            this.dia.a(eVar);
            this.dia.setFromCDN(this.mIsFromCDN);
            this.dia.lM(this.deG);
            this.dia.lP(this.ddn);
            this.dia.fQ(this.ddo);
            this.dia.fR(this.ddp);
            this.dia.fS(this.ddr);
            this.dia.setCommonClickListener(this.brL);
            this.dia.L(this.deJ);
            this.dia.setOnImageClickListener(this.aJc);
            this.dia.setOnLongClickListener(this.aoa);
            this.dia.a(this.dds);
            this.dib.a(eVar);
            this.dib.setFromCDN(this.mIsFromCDN);
            this.dib.lP(this.ddn);
            this.dib.fQ(this.ddo);
            this.dib.fR(this.ddp);
            this.dib.fS(this.ddr);
            this.dib.setCommonClickListener(this.brL);
            this.dib.setOnImageClickListener(this.aJc);
            this.dib.setOnLongClickListener(this.aoa);
            this.dib.a(this.dds);
            ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
            if (eVar.avw() != null) {
                arrayList.addAll(eVar.avw());
            }
            if (!this.ddr && eVar != null && eVar.avw() != null && (size = eVar.avw().size()) > 0 && (sVar2 = eVar.avw().get(size - 1)) != null && sVar2.aTs() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.dfw.awE() && eVar.avw().size() > 0 && (sVar = eVar.avw().get(0)) != null && sVar.aTs() == 1) {
                arrayList.remove(0);
            }
            int a = a(this.ddq, arrayList, this.ddr);
            if (a >= 0) {
                arrayList.add(a, this.ddq.avx());
            }
            this.dhT.y(this.brL);
            int b = b(this.ddq, arrayList, this.ddr);
            int size3 = arrayList.size();
            if (!this.dfw.awE()) {
                if (b < 0) {
                    this.dfw.fT(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.ddq.avs());
                    } else if (b >= size3) {
                        arrayList.add(this.ddq.avs());
                    } else {
                        arrayList.add(b, this.ddq.avs());
                    }
                    this.dfw.fT(true);
                }
            }
            if (arrayList.size() == 0 && this.dfw.awE()) {
                arrayList.add(new com.baidu.tieba.pb.data.f());
            }
            if (this.bcd != null) {
                this.bcd.setData(arrayList);
            }
        }
    }

    public int Rl() {
        return this.bcd.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList, boolean z) {
        if (eVar == null || eVar.avw() == null || eVar.avx() == null || eVar.avw().size() == 0 || eVar.avv() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(eVar.avx().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (eVar.avw().get(0) == null || eVar.avw().get(0).aTs() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (eVar.getPage() == null || eVar.getPage().so() != eVar.getPage().sl()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public int b(com.baidu.tieba.pb.data.e eVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList, boolean z) {
        com.baidu.tbadk.core.data.v avs;
        if (eVar == null || eVar.avw() == null || eVar.avs() == null || eVar.avw().size() == 0 || eVar.avv() == null || arrayList == null) {
            return -1;
        }
        com.baidu.tieba.tbadkCore.data.s avz = eVar.avz();
        com.baidu.tieba.tbadkCore.data.s sVar = (avz == null && eVar.avw().get(0) != null && eVar.avw().get(0).aTs() == 1) ? eVar.avw().get(0) : avz;
        if (sVar == null) {
            return -1;
        }
        if ((sVar.getType() == com.baidu.tieba.tbadkCore.data.s.epG || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.UX || sVar.getType() == com.baidu.tieba.tbadkCore.data.s.epJ) && com.baidu.tieba.graffiti.d.Yf()) {
            if (!this.dif) {
                this.dif = l(com.baidu.tbadk.core.data.v.TC);
            }
            if (this.dif && (avs = eVar.avs()) != null) {
                if (StringUtils.isNull(avs.getForumId()) || StringUtils.isNull(avs.getThreadId())) {
                    return -1;
                }
                return z ? 1 : -1;
            }
            return -1;
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.u aF(int i) {
        return this.bcd.aF(i);
    }

    public BdUniqueId lW(int i) {
        if (this.bcd.aF(i) != null) {
            return this.bcd.aF(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).notifyDataSetChanged();
        }
    }

    private void awQ() {
        com.baidu.tieba.tbadkCore.data.r rVar;
        int position;
        if (this.ddq != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avw = this.ddq.avw();
            ArrayList<com.baidu.tieba.tbadkCore.data.r> avF = this.ddq.avF();
            if (avF != null) {
                int size = avF.size();
                if (avw != null && avw.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it = avF.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next = it.next();
                        if (next != null && next.aTi() != null) {
                            sb.append(next.aTi());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it2 = avF.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next2 = it2.next();
                        if (next2 != null) {
                            next2.bsz = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.r> it3 = avF.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.r next3 = it3.next();
                        if (next3.aTh() != null && next3.aTh().rk() && !com.baidu.tieba.tbadkCore.ag.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.aTh().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.r rVar2 = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(sparseArray.keyAt(i));
                        if (rVar2 != null) {
                            hashMap.put(rVar2.aTi(), rVar2);
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
                    Collections.sort(arrayList, new ct(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.r rVar3 = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = rVar3.getPosition();
                        if (!a(rVar3, avw)) {
                            if (position2 + i3 < avw.size()) {
                                if (this.ddq.avu() != null) {
                                    rVar3.epF = this.ddq.avu().getId();
                                }
                                if (this.ddq.avv() != null) {
                                    rVar3.threadId = com.baidu.adp.lib.h.b.c(this.ddq.avv().getId(), 0L);
                                }
                                if (this.ddq != null && this.ddq.getPage() != null) {
                                    rVar3.pageNumber = this.ddq.getPage().so();
                                }
                                avw.add(position2, rVar3);
                                TiebaStatic.eventStat(this.dfw.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", rVar3.aTh().apk_name);
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
        int p = com.baidu.tbadk.core.util.y.p(arrayList);
        if (rVar == null || p <= 0) {
            return false;
        }
        int position = rVar.getPosition();
        if (p >= 2 || position != p + 1) {
            return false;
        }
        if (this.ddq != null && this.ddq.getPage() != null) {
            rVar.pageNumber = this.ddq.getPage().so();
        }
        arrayList.add(rVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.dhX.setFromCDN(z);
        this.dhY.setFromCDN(z);
        this.dhP.setFromCDN(z);
        this.dhU.setFromCDN(z);
        this.dhV.setFromCDN(z);
        this.dhQ.setFromCDN(z);
        this.dhR.setFromCDN(z);
        this.dhS.setFromCDN(z);
        this.dib.setFromCDN(z);
    }

    public void fQ(boolean z) {
        this.ddo = z;
    }

    public void fR(boolean z) {
        this.ddp = z;
    }

    public void fS(boolean z) {
        this.ddr = z;
    }

    public void L(View.OnClickListener onClickListener) {
        this.deJ = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aJc = dVar;
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        this.dds = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aoa = onLongClickListener;
    }

    public void M(View.OnClickListener onClickListener) {
        this.brL = onClickListener;
    }

    public boolean l(BdUniqueId bdUniqueId) {
        if (this.bcd == null || bdUniqueId == null || com.baidu.tbadk.core.util.y.q(this.die)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.die) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }
}
