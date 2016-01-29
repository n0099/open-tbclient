package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class cb {
    private BdTypeListView aXu;
    private int cJW;
    private com.baidu.tieba.pb.a.c cJZ;
    private PbActivity cNL;
    private de cNM;
    private ce cNN;
    private cg cNO;
    private cf cNP;
    private dd cNQ;
    private com.baidu.tieba.pb.pb.a.j cNR;
    private com.baidu.tieba.pb.pb.a.d cNS;
    private ci cNT;
    private com.baidu.tieba.pb.pb.a.an cNU;
    private com.baidu.tieba.pb.pb.a.q cNV;
    private cw cNW;
    private da cNX;
    private com.baidu.tieba.pb.pb.a.a cNY;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.r> cNZ = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cJX = true;
    private boolean cJY = true;
    private boolean cKa = true;
    private String cLq = null;
    private View.OnClickListener cLt = null;
    private View.OnClickListener bmy = null;
    private TbRichTextView.d aGi = null;
    private com.baidu.tieba.pb.pb.sub.am cLr = null;
    private com.baidu.tieba.pb.b.c cKb = null;
    private View.OnLongClickListener anJ = null;
    private List<com.baidu.adp.widget.ListView.a> aXX = new ArrayList();
    private final CustomMessageListener bgq = new cc(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public cb(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cJW = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.cJW = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.cJW;
        this.cNL = pbActivity;
        this.aXu = bdTypeListView;
        pbActivity.registerListener(this.bgq);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cNU = new com.baidu.tieba.pb.pb.a.an(pbActivity, com.baidu.tieba.tbadkCore.data.r.dXb);
        this.cNV = new com.baidu.tieba.pb.pb.a.q(pbActivity, com.baidu.tieba.tbadkCore.data.r.WH);
        this.cNM = new de(pbActivity, com.baidu.tieba.tbadkCore.data.r.dWX);
        this.cNN = new ce(pbActivity, com.baidu.tbadk.core.data.c.Um);
        this.cNO = new cg(pbActivity, com.baidu.tbadk.core.data.c.Un);
        this.cNP = new cf(pbActivity, com.baidu.tbadk.core.data.c.Uo);
        this.cNQ = new dd(pbActivity, com.baidu.tbadk.core.data.al.XH);
        this.cNR = new com.baidu.tieba.pb.pb.a.j(pbActivity, com.baidu.tieba.tbadkCore.data.r.dWY);
        this.cNS = new com.baidu.tieba.pb.pb.a.d(pbActivity, com.baidu.tieba.tbadkCore.data.r.dWZ);
        this.cNT = new ci(pbActivity, com.baidu.tieba.tbadkCore.data.r.dXa);
        this.cNW = new cw(pbActivity, com.baidu.tieba.tbadkCore.data.r.dXc);
        this.cNX = new da(pbActivity, com.baidu.tieba.tbadkCore.data.r.dXd);
        this.cNY = new com.baidu.tieba.pb.pb.a.a(pbActivity, com.baidu.tieba.tbadkCore.data.r.dXe);
        this.aXX.add(this.cNM);
        this.aXX.add(this.cNU);
        this.aXX.add(this.cNV);
        this.aXX.add(this.cNN);
        this.aXX.add(this.cNO);
        this.aXX.add(this.cNP);
        this.aXX.add(this.cNQ);
        this.aXX.add(this.cNR);
        this.aXX.add(this.cNS);
        this.aXX.add(this.cNT);
        this.aXX.add(this.cNW);
        this.aXX.add(this.cNX);
        this.aXX.add(this.cNY);
        bdTypeListView.g(this.aXX);
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.data.r rVar;
        int size2;
        if (this.cJZ != cVar) {
            z = (cVar == null || cVar.aoC()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.cJZ = cVar;
        if (z) {
            apJ();
            if (cVar != null) {
                cVar.ff(false);
            }
        }
        if (this.cNZ == null) {
            this.cNZ = new ArrayList<>();
        }
        this.cNZ.clear();
        if (this.cJZ != null && this.cJZ.aoG() != null && this.cJZ.aoG().size() > 0) {
            this.cNZ.addAll(this.cJZ.aoG());
        }
        if (cVar != null && cVar.aoF() != null && cVar.aoF().getAuthor() != null) {
            this.cLq = cVar.aoF().getAuthor().getUserId();
        }
        if (this.cNM != null && this.cNN != null) {
            this.cNU.a(cVar);
            this.cNU.setFromCDN(this.mIsFromCDN);
            this.cNU.kz(this.cLq);
            this.cNU.setImageMaxWidth(this.cJW);
            this.cNU.fg(this.cJX);
            this.cNU.fh(this.cJY);
            this.cNU.fi(this.cKa);
            this.cNU.setCommonClickListener(this.bmy);
            this.cNU.H(this.cLt);
            this.cNU.setOnImageClickListener(this.aGi);
            this.cNU.setOnLongClickListener(this.anJ);
            this.cNU.a(this.cKb);
            this.cNV.a(cVar);
            this.cNV.setFromCDN(this.mIsFromCDN);
            this.cNV.a(this.cKb);
            this.cNM.a(cVar);
            this.cNM.setFromCDN(this.mIsFromCDN);
            this.cNM.kz(this.cLq);
            this.cNM.setImageMaxWidth(this.cJW);
            this.cNM.fg(this.cJX);
            this.cNM.fh(this.cJY);
            this.cNM.fi(this.cKa);
            this.cNM.setCommonClickListener(this.bmy);
            this.cNM.H(this.cLt);
            this.cNM.setOnImageClickListener(this.aGi);
            this.cNM.setOnLongClickListener(this.anJ);
            this.cNM.a(this.cKb);
            this.cNR.a(cVar);
            this.cNR.setFromCDN(this.mIsFromCDN);
            this.cNR.setImageMaxWidth(this.cJW);
            this.cNR.fg(this.cJX);
            this.cNR.fh(this.cJY);
            this.cNR.fi(this.cKa);
            this.cNR.setCommonClickListener(this.bmy);
            this.cNR.setOnImageClickListener(this.aGi);
            this.cNR.setOnLongClickListener(this.anJ);
            this.cNR.a(this.cKb);
            this.cNS.a(cVar);
            this.cNS.setFromCDN(this.mIsFromCDN);
            this.cNS.setImageMaxWidth(this.cJW);
            this.cNS.fg(this.cJX);
            this.cNS.fi(this.cKa);
            this.cNS.setCommonClickListener(this.bmy);
            this.cNS.setOnImageClickListener(this.aGi);
            this.cNS.setOnLongClickListener(this.anJ);
            this.cNS.a(this.cKb);
            this.cNN.setFromCDN(this.mIsFromCDN);
            this.cNO.setFromCDN(this.mIsFromCDN);
            this.cNP.setFromCDN(this.mIsFromCDN);
            this.cNT.a(cVar);
            this.cNT.setFromCDN(this.mIsFromCDN);
            this.cNT.kz(this.cLq);
            this.cNT.setImageMaxWidth(this.cJW);
            this.cNT.fg(this.cJX);
            this.cNT.fh(this.cJY);
            this.cNT.fi(this.cKa);
            this.cNT.setCommonClickListener(this.bmy);
            this.cNT.H(this.cLt);
            this.cNT.setOnImageClickListener(this.aGi);
            this.cNT.setOnLongClickListener(this.anJ);
            this.cNT.a(this.cKb);
            this.cNW.a(cVar);
            this.cNW.setFromCDN(this.mIsFromCDN);
            this.cNW.kz(this.cLq);
            this.cNW.setImageMaxWidth(this.cJW);
            this.cNW.fg(this.cJX);
            this.cNW.fh(this.cJY);
            this.cNW.fi(this.cKa);
            this.cNW.setCommonClickListener(this.bmy);
            this.cNW.H(this.cLt);
            this.cNW.setOnImageClickListener(this.aGi);
            this.cNW.setOnLongClickListener(this.anJ);
            this.cNW.a(this.cKb);
            this.cNX.a(cVar);
            this.cNX.setFromCDN(this.mIsFromCDN);
            this.cNX.kz(this.cLq);
            this.cNX.setImageMaxWidth(this.cJW);
            this.cNX.fg(this.cJX);
            this.cNX.fh(this.cJY);
            this.cNX.fi(this.cKa);
            this.cNX.setCommonClickListener(this.bmy);
            this.cNX.H(this.cLt);
            this.cNX.setOnImageClickListener(this.aGi);
            this.cNX.setOnLongClickListener(this.anJ);
            this.cNX.a(this.cKb);
            this.cNY.a(cVar);
            this.cNY.setFromCDN(this.mIsFromCDN);
            this.cNY.setImageMaxWidth(this.cJW);
            this.cNY.fg(this.cJX);
            this.cNY.fh(this.cJY);
            this.cNY.fi(this.cKa);
            this.cNY.setCommonClickListener(this.bmy);
            this.cNY.setOnImageClickListener(this.aGi);
            this.cNY.setOnLongClickListener(this.anJ);
            this.cNY.a(this.cKb);
            ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
            if (cVar.aoG() != null) {
                arrayList.addAll(cVar.aoG());
            }
            if (!this.cKa && cVar != null && cVar.aoG() != null && (size = cVar.aoG().size()) > 0 && (rVar = cVar.aoG().get(size - 1)) != null && rVar.aMw() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            int a = a(this.cJZ, arrayList, this.cKa);
            if (a >= 0) {
                arrayList.add(a, this.cJZ.aoH());
            }
            this.cNQ.x(this.bmy);
            if (this.aXu != null) {
                this.aXu.setData(arrayList);
            }
        }
    }

    public int Pw() {
        return this.aXu.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.a.c cVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList, boolean z) {
        if (cVar == null || cVar.aoG() == null || cVar.aoH() == null || cVar.aoG().size() == 0 || cVar.aoF() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(cVar.aoH().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (cVar.aoG().get(0) == null || cVar.aoG().get(0).aMw() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (cVar.getPage() == null || cVar.getPage().st() != cVar.getPage().sq()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.u aG(int i) {
        return this.aXu.aG(i);
    }

    public BdUniqueId kO(int i) {
        if (this.aXu.aG(i) != null) {
            return this.aXu.aG(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetChanged();
        }
    }

    private void apJ() {
        com.baidu.tieba.tbadkCore.data.q qVar;
        int position;
        if (this.cJZ != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoG = this.cJZ.aoG();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aoN = this.cJZ.aoN();
            if (aoN != null) {
                int size = aoN.size();
                if (aoG != null && aoG.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.q> it = aoN.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.q next = it.next();
                        if (next != null && next.aMm() != null) {
                            sb.append(next.aMm());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.q> it2 = aoN.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.q next2 = it2.next();
                        if (next2 != null) {
                            next2.bnC = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.q> it3 = aoN.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.q next3 = it3.next();
                        if (next3.aMl() != null && next3.aMl().rM() && !com.baidu.tieba.tbadkCore.ag.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.aMl().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(sparseArray.keyAt(i));
                        if (qVar2 != null) {
                            hashMap.put(qVar2.aMm(), qVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (qVar = (com.baidu.tieba.tbadkCore.data.q) entry.getValue()) != null) {
                            sparseArray.put(qVar.getPosition(), qVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new cd(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = qVar3.getPosition();
                        if (!a(qVar3, aoG)) {
                            if (position2 + i3 < aoG.size()) {
                                if (this.cJZ.aoE() != null) {
                                    qVar3.dWW = this.cJZ.aoE().getId();
                                }
                                if (this.cJZ.aoF() != null) {
                                    qVar3.threadId = com.baidu.adp.lib.h.b.c(this.cJZ.aoF().getId(), 0L);
                                }
                                if (this.cJZ != null && this.cJZ.getPage() != null) {
                                    qVar3.pageNumber = this.cJZ.getPage().st();
                                }
                                aoG.add(position2, qVar3);
                                TiebaStatic.eventStat(this.cNL.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", qVar3.aMl().apk_name);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.q qVar, ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList) {
        int o = com.baidu.tbadk.core.util.x.o(arrayList);
        if (qVar == null || o <= 0) {
            return false;
        }
        int position = qVar.getPosition();
        if (o >= 2 || position != o + 1) {
            return false;
        }
        if (this.cJZ != null && this.cJZ.getPage() != null) {
            qVar.pageNumber = this.cJZ.getPage().st();
        }
        arrayList.add(qVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.cNU.setFromCDN(z);
        this.cNV.setFromCDN(z);
        this.cNM.setFromCDN(z);
        this.cNR.setFromCDN(z);
        this.cNS.setFromCDN(z);
        this.cNN.setFromCDN(z);
        this.cNO.setFromCDN(z);
        this.cNP.setFromCDN(z);
        this.cNY.setFromCDN(z);
    }

    public void fg(boolean z) {
        this.cJX = z;
    }

    public void fh(boolean z) {
        this.cJY = z;
    }

    public void fi(boolean z) {
        this.cKa = z;
    }

    public void H(View.OnClickListener onClickListener) {
        this.cLt = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aGi = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cKb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anJ = onLongClickListener;
    }

    public void I(View.OnClickListener onClickListener) {
        this.bmy = onClickListener;
    }
}
