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
public class bu {
    private BdTypeListView aVi;
    private com.baidu.tieba.pb.a.c cDR;
    private int cDq;
    private PbActivity cGj;
    private cx cGk;
    private bx cGl;
    private bz cGm;
    private by cGn;
    private cw cGo;
    private com.baidu.tieba.pb.pb.a.g cGp;
    private com.baidu.tieba.pb.pb.a.a cGq;
    private cb cGr;
    private com.baidu.tieba.pb.pb.a.n cGs;
    private cp cGt;
    private ct cGu;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.r> cGv = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cDr = true;
    private boolean cDQ = true;
    private boolean cDs = true;
    private String cDX = null;
    private View.OnClickListener cEa = null;
    private View.OnClickListener bjD = null;
    private TbRichTextView.d aFq = null;
    private com.baidu.tieba.pb.pb.sub.am cDY = null;
    private com.baidu.tieba.pb.b.c cDu = null;
    private View.OnLongClickListener amQ = null;
    private List<com.baidu.adp.widget.ListView.a> aVK = new ArrayList();
    private final CustomMessageListener bdV = new bv(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public bu(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cDq = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.cDq = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.cDq;
        this.cGj = pbActivity;
        this.aVi = bdTypeListView;
        pbActivity.registerListener(this.bdV);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cGs = new com.baidu.tieba.pb.pb.a.n(pbActivity, com.baidu.tieba.tbadkCore.data.r.dHf);
        this.cGk = new cx(pbActivity, com.baidu.tieba.tbadkCore.data.r.dHb);
        this.cGl = new bx(pbActivity, com.baidu.tbadk.core.data.b.UF);
        this.cGm = new bz(pbActivity, com.baidu.tbadk.core.data.b.UG);
        this.cGn = new by(pbActivity, com.baidu.tbadk.core.data.b.UH);
        this.cGo = new cw(pbActivity, com.baidu.tbadk.core.data.ad.Xz);
        this.cGp = new com.baidu.tieba.pb.pb.a.g(pbActivity, com.baidu.tieba.tbadkCore.data.r.dHc);
        this.cGq = new com.baidu.tieba.pb.pb.a.a(pbActivity, com.baidu.tieba.tbadkCore.data.r.dHd);
        this.cGr = new cb(pbActivity, com.baidu.tieba.tbadkCore.data.r.dHe);
        this.cGt = new cp(pbActivity, com.baidu.tieba.tbadkCore.data.r.dHg);
        this.cGu = new ct(pbActivity, com.baidu.tieba.tbadkCore.data.r.dHh);
        this.aVK.add(this.cGk);
        this.aVK.add(this.cGs);
        this.aVK.add(this.cGl);
        this.aVK.add(this.cGm);
        this.aVK.add(this.cGn);
        this.aVK.add(this.cGo);
        this.aVK.add(this.cGp);
        this.aVK.add(this.cGq);
        this.aVK.add(this.cGr);
        this.aVK.add(this.cGt);
        this.aVK.add(this.cGu);
        bdTypeListView.g(this.aVK);
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.data.r rVar;
        int size2;
        if (this.cDR != cVar) {
            z = (cVar == null || cVar.akE()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.cDR = cVar;
        if (z) {
            alG();
            if (cVar != null) {
                cVar.eR(false);
            }
        }
        if (this.cGv == null) {
            this.cGv = new ArrayList<>();
        }
        this.cGv.clear();
        if (this.cDR != null && this.cDR.akI() != null && this.cDR.akI().size() > 0) {
            this.cGv.addAll(this.cDR.akI());
        }
        if (cVar != null && cVar.akH() != null && cVar.akH().getAuthor() != null) {
            this.cDX = cVar.akH().getAuthor().getUserId();
        }
        if (this.cGk != null && this.cGl != null) {
            this.cGs.a(cVar);
            this.cGs.setFromCDN(this.mIsFromCDN);
            this.cGs.kv(this.cDX);
            this.cGs.setImageMaxWidth(this.cDq);
            this.cGs.eS(this.cDr);
            this.cGs.eU(this.cDQ);
            this.cGs.eT(this.cDs);
            this.cGs.setCommonClickListener(this.bjD);
            this.cGs.B(this.cEa);
            this.cGs.setOnImageClickListener(this.aFq);
            this.cGs.setOnLongClickListener(this.amQ);
            this.cGs.a(this.cDu);
            this.cGk.a(cVar);
            this.cGk.setFromCDN(this.mIsFromCDN);
            this.cGk.kv(this.cDX);
            this.cGk.setImageMaxWidth(this.cDq);
            this.cGk.eS(this.cDr);
            this.cGk.eU(this.cDQ);
            this.cGk.eT(this.cDs);
            this.cGk.setCommonClickListener(this.bjD);
            this.cGk.B(this.cEa);
            this.cGk.setOnImageClickListener(this.aFq);
            this.cGk.setOnLongClickListener(this.amQ);
            this.cGk.a(this.cDu);
            this.cGp.a(cVar);
            this.cGp.setFromCDN(this.mIsFromCDN);
            this.cGp.setImageMaxWidth(this.cDq);
            this.cGp.eS(this.cDr);
            this.cGp.eU(this.cDQ);
            this.cGp.eT(this.cDs);
            this.cGp.setCommonClickListener(this.bjD);
            this.cGp.setOnImageClickListener(this.aFq);
            this.cGp.setOnLongClickListener(this.amQ);
            this.cGp.a(this.cDu);
            this.cGq.a(cVar);
            this.cGq.setFromCDN(this.mIsFromCDN);
            this.cGq.setImageMaxWidth(this.cDq);
            this.cGq.eS(this.cDr);
            this.cGq.eT(this.cDs);
            this.cGq.setCommonClickListener(this.bjD);
            this.cGq.setOnImageClickListener(this.aFq);
            this.cGq.setOnLongClickListener(this.amQ);
            this.cGq.a(this.cDu);
            this.cGl.setFromCDN(this.mIsFromCDN);
            this.cGm.setFromCDN(this.mIsFromCDN);
            this.cGn.setFromCDN(this.mIsFromCDN);
            this.cGr.a(cVar);
            this.cGr.setFromCDN(this.mIsFromCDN);
            this.cGr.kv(this.cDX);
            this.cGr.setImageMaxWidth(this.cDq);
            this.cGr.eS(this.cDr);
            this.cGr.eU(this.cDQ);
            this.cGr.eT(this.cDs);
            this.cGr.setCommonClickListener(this.bjD);
            this.cGr.B(this.cEa);
            this.cGr.setOnImageClickListener(this.aFq);
            this.cGr.setOnLongClickListener(this.amQ);
            this.cGr.a(this.cDu);
            this.cGt.a(cVar);
            this.cGt.setFromCDN(this.mIsFromCDN);
            this.cGt.kv(this.cDX);
            this.cGt.setImageMaxWidth(this.cDq);
            this.cGt.eS(this.cDr);
            this.cGt.eU(this.cDQ);
            this.cGt.eT(this.cDs);
            this.cGt.setCommonClickListener(this.bjD);
            this.cGt.B(this.cEa);
            this.cGt.setOnImageClickListener(this.aFq);
            this.cGt.setOnLongClickListener(this.amQ);
            this.cGt.a(this.cDu);
            this.cGu.a(cVar);
            this.cGu.setFromCDN(this.mIsFromCDN);
            this.cGu.kv(this.cDX);
            this.cGu.setImageMaxWidth(this.cDq);
            this.cGu.eS(this.cDr);
            this.cGu.eU(this.cDQ);
            this.cGu.eT(this.cDs);
            this.cGu.setCommonClickListener(this.bjD);
            this.cGu.B(this.cEa);
            this.cGu.setOnImageClickListener(this.aFq);
            this.cGu.setOnLongClickListener(this.amQ);
            this.cGu.a(this.cDu);
            ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
            if (cVar.akI() != null) {
                arrayList.addAll(cVar.akI());
            }
            if (!this.cDs && cVar != null && cVar.akI() != null && (size = cVar.akI().size()) > 0 && (rVar = cVar.akI().get(size - 1)) != null && rVar.aFq() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            int a = a(this.cDR, arrayList, this.cDs);
            if (a >= 0) {
                arrayList.add(a, this.cDR.akJ());
            }
            this.cGo.r(this.bjD);
            if (this.aVi != null) {
                this.aVi.setData(arrayList);
            }
        }
    }

    public int Nw() {
        return this.aVi.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.a.c cVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList, boolean z) {
        if (cVar == null || cVar.akI() == null || cVar.akJ() == null || cVar.akI().size() == 0 || cVar.akH() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(cVar.akJ().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (cVar.akI().get(0) == null || cVar.akI().get(0).aFq() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (cVar.getPage() == null || cVar.getPage().rM() != cVar.getPage().rK()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.u au(int i) {
        return this.aVi.au(i);
    }

    public BdUniqueId ko(int i) {
        if (this.aVi.au(i) != null) {
            return this.aVi.au(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).notifyDataSetChanged();
        }
    }

    private void alG() {
        com.baidu.tieba.tbadkCore.data.q qVar;
        int position;
        if (this.cDR != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.r> akI = this.cDR.akI();
            ArrayList<com.baidu.tieba.tbadkCore.data.q> akP = this.cDR.akP();
            if (akP != null) {
                int size = akP.size();
                if (akI != null && akI.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.q> it = akP.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.q next = it.next();
                        if (next != null && next.aFg() != null) {
                            sb.append(next.aFg());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.q> it2 = akP.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.q next2 = it2.next();
                        if (next2 != null) {
                            next2.bkF = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.q> it3 = akP.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.q next3 = it3.next();
                        if (next3.aFf() != null && next3.aFf().rk() && !com.baidu.tieba.tbadkCore.ah.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.aFf().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.q qVar2 = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(sparseArray.keyAt(i));
                        if (qVar2 != null) {
                            hashMap.put(qVar2.aFg(), qVar2);
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
                    Collections.sort(arrayList, new bw(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.q qVar3 = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = qVar3.getPosition();
                        if (!a(qVar3, akI)) {
                            if (position2 + i3 < akI.size()) {
                                if (this.cDR.akG() != null) {
                                    qVar3.dHa = this.cDR.akG().getId();
                                }
                                if (this.cDR.akH() != null) {
                                    qVar3.threadId = com.baidu.adp.lib.h.b.c(this.cDR.akH().getId(), 0L);
                                }
                                if (this.cDR != null && this.cDR.getPage() != null) {
                                    qVar3.pageNumber = this.cDR.getPage().rM();
                                }
                                akI.add(position2, qVar3);
                                TiebaStatic.eventStat(this.cGj.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", qVar3.aFf().apk_name);
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
        int l = com.baidu.tbadk.core.util.y.l(arrayList);
        if (qVar == null || l <= 0) {
            return false;
        }
        int position = qVar.getPosition();
        if (l >= 2 || position != l + 1) {
            return false;
        }
        if (this.cDR != null && this.cDR.getPage() != null) {
            qVar.pageNumber = this.cDR.getPage().rM();
        }
        arrayList.add(qVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.cGs.setFromCDN(z);
        this.cGk.setFromCDN(z);
        this.cGp.setFromCDN(z);
        this.cGq.setFromCDN(z);
        this.cGl.setFromCDN(z);
        this.cGm.setFromCDN(z);
        this.cGn.setFromCDN(z);
    }

    public void eS(boolean z) {
        this.cDr = z;
    }

    public void eU(boolean z) {
        this.cDQ = z;
    }

    public void eT(boolean z) {
        this.cDs = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cEa = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aFq = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cDu = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amQ = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bjD = onClickListener;
    }
}
