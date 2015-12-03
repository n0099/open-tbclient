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
public class br {
    private BdTypeListView aRs;
    private com.baidu.tieba.pb.a.c cAm;
    private bu cCA;
    private bw cCB;
    private bv cCC;
    private cm cCD;
    private com.baidu.tieba.pb.pb.a.g cCE;
    private com.baidu.tieba.pb.pb.a.a cCF;
    private by cCG;
    private com.baidu.tieba.pb.pb.a.n cCH;
    private PbActivity cCy;
    private cn cCz;
    private int czL;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> cCI = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean czM = true;
    private boolean cAl = true;
    private boolean czN = true;
    private String cAs = null;
    private View.OnClickListener cAv = null;
    private View.OnClickListener bfL = null;
    private TbRichTextView.d aDR = null;
    private com.baidu.tieba.pb.pb.sub.al cAt = null;
    private com.baidu.tieba.pb.b.c czP = null;
    private View.OnLongClickListener alK = null;
    private List<com.baidu.adp.widget.ListView.a> aRI = new ArrayList();
    private final CustomMessageListener aZY = new bs(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public br(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.czL = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.czL = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.czL;
        this.cCy = pbActivity;
        this.aRs = bdTypeListView;
        pbActivity.registerListener(this.aZY);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cCH = new com.baidu.tieba.pb.pb.a.n(pbActivity, com.baidu.tieba.tbadkCore.data.o.dzC);
        this.cCz = new cn(pbActivity, com.baidu.tieba.tbadkCore.data.o.dzy);
        this.cCA = new bu(pbActivity, com.baidu.tbadk.core.data.b.Uf);
        this.cCB = new bw(pbActivity, com.baidu.tbadk.core.data.b.Ug);
        this.cCC = new bv(pbActivity, com.baidu.tbadk.core.data.b.Uh);
        this.cCD = new cm(pbActivity, com.baidu.tbadk.core.data.ad.WX);
        this.cCE = new com.baidu.tieba.pb.pb.a.g(pbActivity, com.baidu.tieba.tbadkCore.data.o.dzz);
        this.cCF = new com.baidu.tieba.pb.pb.a.a(pbActivity, com.baidu.tieba.tbadkCore.data.o.dzA);
        this.cCG = new by(pbActivity, com.baidu.tieba.tbadkCore.data.o.dzB);
        this.aRI.add(this.cCz);
        this.aRI.add(this.cCH);
        this.aRI.add(this.cCA);
        this.aRI.add(this.cCB);
        this.aRI.add(this.cCC);
        this.aRI.add(this.cCD);
        this.aRI.add(this.cCE);
        this.aRI.add(this.cCF);
        this.aRI.add(this.cCG);
        bdTypeListView.g(this.aRI);
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.data.o oVar;
        int size2;
        if (this.cAm != cVar) {
            z = (cVar == null || cVar.ajw()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.cAm = cVar;
        if (z) {
            akz();
            if (cVar != null) {
                cVar.eS(false);
            }
        }
        if (this.cCI == null) {
            this.cCI = new ArrayList<>();
        }
        this.cCI.clear();
        if (this.cAm != null && this.cAm.ajA() != null && this.cAm.ajA().size() > 0) {
            this.cCI.addAll(this.cAm.ajA());
        }
        if (cVar != null && cVar.ajz() != null && cVar.ajz().getAuthor() != null) {
            this.cAs = cVar.ajz().getAuthor().getUserId();
        }
        if (this.cCz != null && this.cCA != null) {
            this.cCH.a(cVar);
            this.cCH.setFromCDN(this.mIsFromCDN);
            this.cCH.ky(this.cAs);
            this.cCH.setImageMaxWidth(this.czL);
            this.cCH.eT(this.czM);
            this.cCH.eV(this.cAl);
            this.cCH.eU(this.czN);
            this.cCH.setCommonClickListener(this.bfL);
            this.cCH.B(this.cAv);
            this.cCH.setOnImageClickListener(this.aDR);
            this.cCH.setOnLongClickListener(this.alK);
            this.cCH.a(this.czP);
            this.cCz.a(cVar);
            this.cCz.setFromCDN(this.mIsFromCDN);
            this.cCz.ky(this.cAs);
            this.cCz.setImageMaxWidth(this.czL);
            this.cCz.eT(this.czM);
            this.cCz.eV(this.cAl);
            this.cCz.eU(this.czN);
            this.cCz.setCommonClickListener(this.bfL);
            this.cCz.B(this.cAv);
            this.cCz.setOnImageClickListener(this.aDR);
            this.cCz.setOnLongClickListener(this.alK);
            this.cCz.a(this.czP);
            this.cCE.a(cVar);
            this.cCE.setFromCDN(this.mIsFromCDN);
            this.cCE.setImageMaxWidth(this.czL);
            this.cCE.eT(this.czM);
            this.cCE.eV(this.cAl);
            this.cCE.eU(this.czN);
            this.cCE.setCommonClickListener(this.bfL);
            this.cCE.setOnImageClickListener(this.aDR);
            this.cCE.setOnLongClickListener(this.alK);
            this.cCE.a(this.czP);
            this.cCF.a(cVar);
            this.cCF.setFromCDN(this.mIsFromCDN);
            this.cCF.setImageMaxWidth(this.czL);
            this.cCF.eT(this.czM);
            this.cCF.eU(this.czN);
            this.cCF.setCommonClickListener(this.bfL);
            this.cCF.setOnImageClickListener(this.aDR);
            this.cCF.setOnLongClickListener(this.alK);
            this.cCF.a(this.czP);
            this.cCA.setFromCDN(this.mIsFromCDN);
            this.cCB.setFromCDN(this.mIsFromCDN);
            this.cCC.setFromCDN(this.mIsFromCDN);
            this.cCG.a(cVar);
            this.cCG.setFromCDN(this.mIsFromCDN);
            this.cCG.ky(this.cAs);
            this.cCG.setImageMaxWidth(this.czL);
            this.cCG.eT(this.czM);
            this.cCG.eV(this.cAl);
            this.cCG.eU(this.czN);
            this.cCG.setCommonClickListener(this.bfL);
            this.cCG.B(this.cAv);
            this.cCG.setOnImageClickListener(this.aDR);
            this.cCG.setOnLongClickListener(this.alK);
            this.cCG.a(this.czP);
            ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
            if (cVar.ajA() != null) {
                arrayList.addAll(cVar.ajA());
            }
            if (!this.czN && cVar != null && cVar.ajA() != null && (size = cVar.ajA().size()) > 0 && (oVar = cVar.ajA().get(size - 1)) != null && oVar.aDd() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            int a = a(this.cAm, arrayList, this.czN);
            if (a >= 0) {
                arrayList.add(a, this.cAm.ajB());
            }
            this.cCD.r(this.bfL);
            if (this.aRs != null) {
                this.aRs.setData(arrayList);
            }
        }
    }

    public int Nd() {
        return this.aRs.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.a.c cVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList, boolean z) {
        if (cVar == null || cVar.ajA() == null || cVar.ajB() == null || cVar.ajA().size() == 0 || cVar.ajz() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(cVar.ajB().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (cVar.ajA().get(0) == null || cVar.ajA().get(0).aDd() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (cVar.getPage() == null || cVar.getPage().sd() != cVar.getPage().sb()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.u aB(int i) {
        return this.aRs.aB(i);
    }

    public BdUniqueId jR(int i) {
        if (this.aRs.aB(i) != null) {
            return this.aRs.aB(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetChanged();
        }
    }

    private void akz() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        int position;
        if (this.cAm != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajA = this.cAm.ajA();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> ajH = this.cAm.ajH();
            if (ajH != null) {
                int size = ajH.size();
                if (ajA != null && ajA.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it = ajH.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next = it.next();
                        if (next != null && next.aCT() != null) {
                            sb.append(next.aCT());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = ajH.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                        if (next2 != null) {
                            next2.bgO = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = ajH.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                        if (next3.aCS() != null && next3.aCS().rB() && !com.baidu.tieba.tbadkCore.ah.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.aCS().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.n nVar2 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(sparseArray.keyAt(i));
                        if (nVar2 != null) {
                            hashMap.put(nVar2.aCT(), nVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (nVar = (com.baidu.tieba.tbadkCore.data.n) entry.getValue()) != null) {
                            sparseArray.put(nVar.getPosition(), nVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new bt(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = nVar3.getPosition();
                        if (!a(nVar3, ajA)) {
                            if (position2 + i3 < ajA.size()) {
                                if (this.cAm.ajy() != null) {
                                    nVar3.dzx = this.cAm.ajy().getId();
                                }
                                if (this.cAm.ajz() != null) {
                                    nVar3.threadId = com.baidu.adp.lib.h.b.c(this.cAm.ajz().getId(), 0L);
                                }
                                if (this.cAm != null && this.cAm.getPage() != null) {
                                    nVar3.pageNumber = this.cAm.getPage().sd();
                                }
                                ajA.add(position2, nVar3);
                                TiebaStatic.eventStat(this.cCy.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", nVar3.aCS().apk_name);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.n nVar, ArrayList<com.baidu.tieba.tbadkCore.data.o> arrayList) {
        int k = com.baidu.tbadk.core.util.y.k(arrayList);
        if (nVar == null || k <= 0) {
            return false;
        }
        int position = nVar.getPosition();
        if (k >= 2 || position != k + 1) {
            return false;
        }
        if (this.cAm != null && this.cAm.getPage() != null) {
            nVar.pageNumber = this.cAm.getPage().sd();
        }
        arrayList.add(nVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.cCH.setFromCDN(z);
        this.cCz.setFromCDN(z);
        this.cCE.setFromCDN(z);
        this.cCF.setFromCDN(z);
        this.cCA.setFromCDN(z);
        this.cCB.setFromCDN(z);
        this.cCC.setFromCDN(z);
    }

    public void eT(boolean z) {
        this.czM = z;
    }

    public void eV(boolean z) {
        this.cAl = z;
    }

    public void eU(boolean z) {
        this.czN = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cAv = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aDR = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.czP = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alK = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bfL = onClickListener;
    }
}
