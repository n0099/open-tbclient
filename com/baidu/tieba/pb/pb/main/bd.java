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
    private BdTypeListView aUV;
    private com.baidu.tieba.pb.a.b cgC;
    private int cgy;
    private PbActivity ciJ;
    private bs ciK;
    private bg ciL;
    private bi ciM;
    private bh ciN;
    private br ciO;
    private com.baidu.tieba.pb.pb.a.f ciP;
    private com.baidu.tieba.pb.pb.a.a ciQ;
    private com.baidu.tieba.pb.pb.a.k ciR;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.k> ciS = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cgz = true;
    private boolean cgA = true;
    private boolean cgB = true;
    private String cgD = null;
    private View.OnClickListener cgG = null;
    private View.OnClickListener aZl = null;
    private TbRichTextView.c aCc = null;
    private com.baidu.tieba.pb.pb.sub.ai cgE = null;
    private com.baidu.tieba.pb.b.c cgH = null;
    private View.OnLongClickListener ajT = null;
    private List<com.baidu.adp.widget.ListView.a> aVr = new ArrayList();
    private final CustomMessageListener aUr = new be(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public bd(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cgy = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.cgy = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.cgy;
        this.ciJ = pbActivity;
        this.aUV = bdTypeListView;
        pbActivity.registerListener(this.aUr);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ciR = new com.baidu.tieba.pb.pb.a.k(pbActivity, com.baidu.tieba.tbadkCore.data.k.cYI);
        this.ciK = new bs(pbActivity, com.baidu.tieba.tbadkCore.data.k.cYF);
        this.ciL = new bg(pbActivity, com.baidu.tbadk.core.data.b.TM);
        this.ciM = new bi(pbActivity, com.baidu.tbadk.core.data.b.TO);
        this.ciN = new bh(pbActivity, com.baidu.tbadk.core.data.b.TP);
        this.ciO = new br(pbActivity, com.baidu.tbadk.core.data.z.Wg);
        this.ciP = new com.baidu.tieba.pb.pb.a.f(pbActivity, com.baidu.tieba.tbadkCore.data.k.cYG);
        this.ciQ = new com.baidu.tieba.pb.pb.a.a(pbActivity, com.baidu.tieba.tbadkCore.data.k.cYH);
        this.aVr.add(this.ciK);
        this.aVr.add(this.ciR);
        this.aVr.add(this.ciL);
        this.aVr.add(this.ciM);
        this.aVr.add(this.ciN);
        this.aVr.add(this.ciO);
        this.aVr.add(this.ciP);
        this.aVr.add(this.ciQ);
        bdTypeListView.h(this.aVr);
    }

    public void a(com.baidu.tieba.pb.a.b bVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.data.k kVar;
        int size2;
        if (this.cgC != bVar) {
            z = (bVar == null || bVar.aeL()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.cgC = bVar;
        if (z) {
            afG();
            if (bVar != null) {
                bVar.eo(false);
            }
        }
        if (this.ciS == null) {
            this.ciS = new ArrayList<>();
        }
        this.ciS.clear();
        if (this.cgC != null && this.cgC.aeP() != null && this.cgC.aeP().size() > 0) {
            this.ciS.addAll(this.cgC.aeP());
        }
        if (bVar != null && bVar.aeO() != null && bVar.aeO().getAuthor() != null) {
            this.cgD = bVar.aeO().getAuthor().getUserId();
        }
        if (this.ciK != null && this.ciL != null) {
            this.ciR.a(bVar);
            this.ciR.setFromCDN(this.mIsFromCDN);
            this.ciR.jH(this.cgD);
            this.ciR.setImageMaxWidth(this.cgy);
            this.ciR.ep(this.cgz);
            this.ciR.eq(this.cgA);
            this.ciR.er(this.cgB);
            this.ciR.setCommonClickListener(this.aZl);
            this.ciR.B(this.cgG);
            this.ciR.setOnImageClickListener(this.aCc);
            this.ciR.setOnLongClickListener(this.ajT);
            this.ciR.a(this.cgH);
            this.ciK.a(bVar);
            this.ciK.setFromCDN(this.mIsFromCDN);
            this.ciK.jH(this.cgD);
            this.ciK.setImageMaxWidth(this.cgy);
            this.ciK.ep(this.cgz);
            this.ciK.eq(this.cgA);
            this.ciK.er(this.cgB);
            this.ciK.setCommonClickListener(this.aZl);
            this.ciK.B(this.cgG);
            this.ciK.setOnImageClickListener(this.aCc);
            this.ciK.setOnLongClickListener(this.ajT);
            this.ciK.a(this.cgH);
            this.ciP.a(bVar);
            this.ciP.setFromCDN(this.mIsFromCDN);
            this.ciP.jH(this.cgD);
            this.ciP.setImageMaxWidth(this.cgy);
            this.ciP.ep(this.cgz);
            this.ciP.eq(this.cgA);
            this.ciP.er(this.cgB);
            this.ciP.setCommonClickListener(this.aZl);
            this.ciP.B(this.cgG);
            this.ciP.setOnImageClickListener(this.aCc);
            this.ciP.setOnLongClickListener(this.ajT);
            this.ciP.a(this.cgH);
            this.ciQ.a(bVar);
            this.ciQ.setFromCDN(this.mIsFromCDN);
            this.ciQ.jH(this.cgD);
            this.ciQ.setImageMaxWidth(this.cgy);
            this.ciQ.ep(this.cgz);
            this.ciQ.eq(this.cgA);
            this.ciQ.er(this.cgB);
            this.ciQ.setCommonClickListener(this.aZl);
            this.ciQ.B(this.cgG);
            this.ciQ.setOnImageClickListener(this.aCc);
            this.ciQ.setOnLongClickListener(this.ajT);
            this.ciQ.a(this.cgH);
            this.ciL.setFromCDN(this.mIsFromCDN);
            this.ciM.setFromCDN(this.mIsFromCDN);
            this.ciN.setFromCDN(this.mIsFromCDN);
            ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
            if (bVar.aeP() != null) {
                arrayList.addAll(bVar.aeP());
            }
            if (!this.cgB && bVar != null && bVar.aeP() != null && (size = bVar.aeP().size()) > 0 && (kVar = bVar.aeP().get(size - 1)) != null && kVar.awy() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            int a = a(this.cgC, arrayList, this.cgB);
            if (a >= 0) {
                arrayList.add(a, this.cgC.aeQ());
            }
            this.ciO.r(this.aZl);
            if (this.aUV != null) {
                this.aUV.setData(arrayList);
            }
        }
    }

    public int Lt() {
        return this.aUV.getHeaderViewsCount();
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
            return (bVar.aeP().get(0) == null || bVar.aeP().get(0).awy() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (bVar.getPage() == null || bVar.getPage().rJ() != bVar.getPage().rH()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        return this.aUV.aA(i);
    }

    public BdUniqueId iK(int i) {
        if (this.aUV.aA(i) != null) {
            return this.aUV.aA(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aUV.getAdapter()).notifyDataSetChanged();
        }
    }

    private void afG() {
        com.baidu.tieba.tbadkCore.data.j jVar;
        int position;
        if (this.cgC != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeP = this.cgC.aeP();
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aeW = this.cgC.aeW();
            if (aeW != null) {
                int size = aeW.size();
                if (aeP != null && aeP.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.j> it = aeW.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.j next = it.next();
                        if (next != null && next.awo() != null) {
                            sb.append(next.awo());
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
                            next2.aZR = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.j> it3 = aeW.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.j next3 = it3.next();
                        if (next3.awn() != null && next3.awn().rp() && !com.baidu.tieba.tbadkCore.ag.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.awn().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.j jVar2 = (com.baidu.tieba.tbadkCore.data.j) sparseArray.get(sparseArray.keyAt(i));
                        if (jVar2 != null) {
                            hashMap.put(jVar2.awo(), jVar2);
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
                            if (position2 + i3 < aeP.size()) {
                                if (this.cgC.aeN() != null) {
                                    jVar3.cYE = this.cgC.aeN().getId();
                                }
                                if (this.cgC.aeO() != null) {
                                    jVar3.threadId = com.baidu.adp.lib.g.b.c(this.cgC.aeO().getId(), 0L);
                                }
                                aeP.add(position2 + i3, jVar3);
                                TiebaStatic.eventStat(this.ciJ.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", jVar3.awn().apk_name);
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
        arrayList.add(jVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.ciR.setFromCDN(z);
        this.ciK.setFromCDN(z);
        this.ciP.setFromCDN(z);
        this.ciQ.setFromCDN(z);
        this.ciL.setFromCDN(z);
        this.ciM.setFromCDN(z);
        this.ciN.setFromCDN(z);
    }

    public void ep(boolean z) {
        this.cgz = z;
    }

    public void eq(boolean z) {
        this.cgA = z;
    }

    public void er(boolean z) {
        this.cgB = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.cgG = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aCc = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cgH = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajT = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.aZl = onClickListener;
    }
}
