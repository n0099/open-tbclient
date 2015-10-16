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
public class bd {
    private BdTypeListView aVg;
    private int cgJ;
    private com.baidu.tieba.pb.a.b cgN;
    private PbActivity ciU;
    private bs ciV;
    private bg ciW;
    private bi ciX;
    private bh ciY;
    private br ciZ;
    private com.baidu.tieba.pb.pb.a.f cja;
    private com.baidu.tieba.pb.pb.a.a cjb;
    private com.baidu.tieba.pb.pb.a.k cjc;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> cjd = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cgK = true;
    private boolean cgL = true;
    private boolean cgM = true;
    private String cgO = null;
    private View.OnClickListener cgR = null;
    private View.OnClickListener aZw = null;
    private TbRichTextView.c aCn = null;
    private com.baidu.tieba.pb.pb.sub.ai cgP = null;
    private com.baidu.tieba.pb.b.c cgS = null;
    private View.OnLongClickListener ajU = null;
    private List<com.baidu.adp.widget.ListView.a> aVC = new ArrayList();
    private final CustomMessageListener aUC = new be(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public bd(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cgJ = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.cgJ = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.cgJ;
        this.ciU = pbActivity;
        this.aVg = bdTypeListView;
        pbActivity.registerListener(this.aUC);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cjc = new com.baidu.tieba.pb.pb.a.k(pbActivity, com.baidu.tieba.tbadkCore.data.k.cZi);
        this.ciV = new bs(pbActivity, com.baidu.tieba.tbadkCore.data.k.cZf);
        this.ciW = new bg(pbActivity, com.baidu.tbadk.core.data.b.TO);
        this.ciX = new bi(pbActivity, com.baidu.tbadk.core.data.b.TP);
        this.ciY = new bh(pbActivity, com.baidu.tbadk.core.data.b.TQ);
        this.ciZ = new br(pbActivity, com.baidu.tbadk.core.data.aa.Wi);
        this.cja = new com.baidu.tieba.pb.pb.a.f(pbActivity, com.baidu.tieba.tbadkCore.data.k.cZg);
        this.cjb = new com.baidu.tieba.pb.pb.a.a(pbActivity, com.baidu.tieba.tbadkCore.data.k.cZh);
        this.aVC.add(this.ciV);
        this.aVC.add(this.cjc);
        this.aVC.add(this.ciW);
        this.aVC.add(this.ciX);
        this.aVC.add(this.ciY);
        this.aVC.add(this.ciZ);
        this.aVC.add(this.cja);
        this.aVC.add(this.cjb);
        bdTypeListView.h(this.aVC);
    }

    public void a(com.baidu.tieba.pb.a.b bVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.data.k kVar;
        int size2;
        if (this.cgN != bVar) {
            z = (bVar == null || bVar.aeL()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.cgN = bVar;
        if (z) {
            afG();
            if (bVar != null) {
                bVar.eo(false);
            }
        }
        if (this.cjd == null) {
            this.cjd = new ArrayList<>();
        }
        this.cjd.clear();
        if (this.cgN != null && this.cgN.aeP() != null && this.cgN.aeP().size() > 0) {
            this.cjd.addAll(this.cgN.aeP());
        }
        if (bVar != null && bVar.aeO() != null && bVar.aeO().getAuthor() != null) {
            this.cgO = bVar.aeO().getAuthor().getUserId();
        }
        if (this.ciV != null && this.ciW != null) {
            this.cjc.a(bVar);
            this.cjc.setFromCDN(this.mIsFromCDN);
            this.cjc.jH(this.cgO);
            this.cjc.setImageMaxWidth(this.cgJ);
            this.cjc.ep(this.cgK);
            this.cjc.eq(this.cgL);
            this.cjc.er(this.cgM);
            this.cjc.setCommonClickListener(this.aZw);
            this.cjc.B(this.cgR);
            this.cjc.setOnImageClickListener(this.aCn);
            this.cjc.setOnLongClickListener(this.ajU);
            this.cjc.a(this.cgS);
            this.ciV.a(bVar);
            this.ciV.setFromCDN(this.mIsFromCDN);
            this.ciV.jH(this.cgO);
            this.ciV.setImageMaxWidth(this.cgJ);
            this.ciV.ep(this.cgK);
            this.ciV.eq(this.cgL);
            this.ciV.er(this.cgM);
            this.ciV.setCommonClickListener(this.aZw);
            this.ciV.B(this.cgR);
            this.ciV.setOnImageClickListener(this.aCn);
            this.ciV.setOnLongClickListener(this.ajU);
            this.ciV.a(this.cgS);
            this.cja.a(bVar);
            this.cja.setFromCDN(this.mIsFromCDN);
            this.cja.jH(this.cgO);
            this.cja.setImageMaxWidth(this.cgJ);
            this.cja.ep(this.cgK);
            this.cja.eq(this.cgL);
            this.cja.er(this.cgM);
            this.cja.setCommonClickListener(this.aZw);
            this.cja.B(this.cgR);
            this.cja.setOnImageClickListener(this.aCn);
            this.cja.setOnLongClickListener(this.ajU);
            this.cja.a(this.cgS);
            this.cjb.a(bVar);
            this.cjb.setFromCDN(this.mIsFromCDN);
            this.cjb.jH(this.cgO);
            this.cjb.setImageMaxWidth(this.cgJ);
            this.cjb.ep(this.cgK);
            this.cjb.eq(this.cgL);
            this.cjb.er(this.cgM);
            this.cjb.setCommonClickListener(this.aZw);
            this.cjb.B(this.cgR);
            this.cjb.setOnImageClickListener(this.aCn);
            this.cjb.setOnLongClickListener(this.ajU);
            this.cjb.a(this.cgS);
            this.ciW.setFromCDN(this.mIsFromCDN);
            this.ciX.setFromCDN(this.mIsFromCDN);
            this.ciY.setFromCDN(this.mIsFromCDN);
            ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
            if (bVar.aeP() != null) {
                arrayList.addAll(bVar.aeP());
            }
            if (!this.cgM && bVar != null && bVar.aeP() != null && (size = bVar.aeP().size()) > 0 && (kVar = bVar.aeP().get(size - 1)) != null && kVar.awI() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            int a = a(this.cgN, arrayList, this.cgM);
            if (a >= 0) {
                arrayList.add(a, this.cgN.aeQ());
            }
            this.ciZ.r(this.aZw);
            if (this.aVg != null) {
                this.aVg.setData(arrayList);
            }
        }
    }

    public int Lt() {
        return this.aVg.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList, boolean z) {
        if (bVar == null || bVar.aeP() == null || bVar.aeQ() == null || bVar.aeP().size() == 0 || bVar.aeO() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(bVar.aeQ().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (bVar.aeP().get(0) == null || bVar.aeP().get(0).awI() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (bVar.getPage() == null || bVar.getPage().rJ() != bVar.getPage().rH()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        return this.aVg.aA(i);
    }

    public BdUniqueId iK(int i) {
        if (this.aVg.aA(i) != null) {
            return this.aVg.aA(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aVg.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVg.getAdapter()).notifyDataSetChanged();
        }
    }

    private void afG() {
        com.baidu.tieba.tbadkCore.data.j jVar;
        int position;
        if (this.cgN != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cgN.aeP();
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aeW = this.cgN.aeW();
            if (aeW != null) {
                int size = aeW.size();
                if (aeP != null && aeP.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.j> it = aeW.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.j next = it.next();
                        if (next != null && next.awx() != null) {
                            sb.append(next.awx());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.j> it2 = aeW.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.j next2 = it2.next();
                        if (next2 != null) {
                            next2.bac = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.j> it3 = aeW.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.j next3 = it3.next();
                        if (next3.aww() != null && next3.aww().rp() && !com.baidu.tieba.tbadkCore.ag.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.aww().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.j jVar2 = (com.baidu.tieba.tbadkCore.data.j) sparseArray.get(sparseArray.keyAt(i));
                        if (jVar2 != null) {
                            hashMap.put(jVar2.awx(), jVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (jVar = (com.baidu.tieba.tbadkCore.data.j) entry.getValue()) != null) {
                            sparseArray.put(jVar.getPosition(), jVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new bf(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.j jVar3 = (com.baidu.tieba.tbadkCore.data.j) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = jVar3.getPosition();
                        if (!a(jVar3, aeP)) {
                            if (position2 < aeP.size()) {
                                if (this.cgN.aeN() != null) {
                                    jVar3.cZe = this.cgN.aeN().getId();
                                }
                                if (this.cgN.aeO() != null) {
                                    jVar3.threadId = com.baidu.adp.lib.g.b.c(this.cgN.aeO().getId(), 0L);
                                }
                                if (this.cgN != null && this.cgN.getPage() != null) {
                                    jVar3.cHN = this.cgN.getPage().rJ();
                                }
                                aeP.add(position2, jVar3);
                                TiebaStatic.eventStat(this.ciU.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", jVar3.aww().apk_name);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.j jVar, ArrayList<com.baidu.tieba.tbadkCore.data.k> arrayList) {
        int l = com.baidu.tbadk.core.util.u.l(arrayList);
        if (jVar == null || l <= 0) {
            return false;
        }
        int position = jVar.getPosition();
        if (l >= 2 || position != l + 1) {
            return false;
        }
        if (this.cgN != null && this.cgN.getPage() != null) {
            jVar.cHN = this.cgN.getPage().rJ();
        }
        arrayList.add(jVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.cjc.setFromCDN(z);
        this.ciV.setFromCDN(z);
        this.cja.setFromCDN(z);
        this.cjb.setFromCDN(z);
        this.ciW.setFromCDN(z);
        this.ciX.setFromCDN(z);
        this.ciY.setFromCDN(z);
    }

    public void ep(boolean z) {
        this.cgK = z;
    }

    public void eq(boolean z) {
        this.cgL = z;
    }

    public void er(boolean z) {
        this.cgM = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cgR = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aCn = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cgS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajU = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.aZw = onClickListener;
    }
}
