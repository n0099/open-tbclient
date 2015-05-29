package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class bh {
    private BdTypeListView aMl;
    private PbActivity bKZ;
    private bw bLa;
    private bk bLb;
    private bl bLc;
    private bv bLd;
    private com.baidu.tieba.pb.a.b bLe;
    private int mImageMaxWidth;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.j> bLf = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean bLg = true;
    private boolean bLh = true;
    private boolean bLi = true;
    private String bLj = null;
    private View.OnClickListener bLk = null;
    private View.OnClickListener aPm = null;
    private com.baidu.tbadk.widget.richText.s auJ = null;
    private com.baidu.tieba.pb.pb.sub.ag bLl = null;
    private com.baidu.tieba.pb.b.d bKG = null;
    private View.OnLongClickListener afC = null;
    private List<com.baidu.adp.widget.ListView.a> aMA = new ArrayList();
    private final CustomMessageListener aLP = new bi(this, 2001122);

    public bh(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.mImageMaxWidth = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.mImageMaxWidth = com.baidu.adp.lib.util.n.M(pbActivity.getPageContext().getPageActivity());
        this.width = this.mImageMaxWidth;
        this.bKZ = pbActivity;
        this.aMl = bdTypeListView;
        pbActivity.registerListener(this.aLP);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.bLa = new bw(pbActivity, com.baidu.tieba.tbadkCore.data.j.cse);
        this.bLb = new bk(pbActivity, com.baidu.tbadk.core.data.c.Pm);
        this.bLc = new bl(pbActivity, com.baidu.tbadk.core.data.c.Pn);
        this.bLd = new bv(pbActivity, com.baidu.tbadk.core.data.aa.Rq);
        this.aMA.add(this.bLa);
        this.aMA.add(this.bLb);
        this.aMA.add(this.bLc);
        this.aMA.add(this.bLd);
        bdTypeListView.h(this.aMA);
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.data.j jVar;
        int size2;
        if (this.bLe != bVar) {
            z = (bVar == null || bVar.aaq()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.bLe = bVar;
        if (z) {
            abj();
            if (bVar != null) {
                bVar.dP(false);
            }
        }
        this.bLf.clear();
        if (this.bLe != null && this.bLe.aat() != null && this.bLe.aat().size() > 0) {
            this.bLf.addAll(this.bLe.aat());
        }
        if (bVar != null && bVar.aas() != null && bVar.aas().getAuthor() != null) {
            this.bLj = bVar.aas().getAuthor().getUserId();
        }
        this.bLa.b(bVar);
        this.bLa.setFromCDN(this.mIsFromCDN);
        this.bLa.ir(this.bLj);
        this.bLa.setImageMaxWidth(this.mImageMaxWidth);
        this.bLa.setIsShowImage(this.bLg);
        this.bLa.dT(this.bLh);
        this.bLa.dU(this.bLi);
        this.bLa.n(this.aPm);
        this.bLa.t(this.bLk);
        this.bLa.setOnImageClickListener(this.auJ);
        this.bLa.setOnLongClickListener(this.afC);
        this.bLa.a(this.bKG);
        this.bLb.setFromCDN(this.mIsFromCDN);
        this.bLc.setFromCDN(this.mIsFromCDN);
        ArrayList<com.baidu.adp.widget.ListView.ai> arrayList = new ArrayList<>(bVar.aat());
        if (!this.bLi && bVar != null && bVar.aat() != null && (size = bVar.aat().size()) > 0 && (jVar = bVar.aat().get(size - 1)) != null && jVar.aoB() == 1 && (size2 = arrayList.size()) > 0) {
            arrayList.remove(size2 - 1);
        }
        int a = a(this.bLe, arrayList, this.bLi);
        if (a >= 0) {
            arrayList.add(a, this.bLe.aau());
        }
        this.bLd.v(this.aPm);
        this.aMl.setData(arrayList);
    }

    public int a(com.baidu.tieba.pb.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, boolean z) {
        if (bVar == null || bVar.aat() == null || bVar.aau() == null || bVar.aat().size() == 0 || bVar.aas() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(bVar.aau().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (bVar.aat().get(0) == null || bVar.aat().get(0).aoB() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (bVar.Zp() == null || bVar.Zp().qP() != bVar.Zp().qN()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.ai ay(int i) {
        return this.aMl.ay(i);
    }

    public BdUniqueId hy(int i) {
        if (this.aMl.ay(i) != null) {
            return this.aMl.ay(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aMl.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMl.getAdapter()).notifyDataSetChanged();
        }
    }

    private void abj() {
        com.baidu.tieba.tbadkCore.data.i iVar;
        int position;
        if (this.bLe != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aat = this.bLe.aat();
            ArrayList<com.baidu.tieba.tbadkCore.data.i> aay = this.bLe.aay();
            if (aay != null) {
                int size = aay.size();
                if (aat != null && aat.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.i> it = aay.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.i next = it.next();
                        if (next != null && next.aos() != null) {
                            sb.append(next.aos());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.i> it2 = aay.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.i next2 = it2.next();
                        if (next2 != null) {
                            next2.aPL = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.i> it3 = aay.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.i next3 = it3.next();
                        if (next3.aor() != null && next3.aor().qu() && !com.baidu.tieba.tbadkCore.au.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.aor().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.i iVar2 = (com.baidu.tieba.tbadkCore.data.i) sparseArray.get(sparseArray.keyAt(i));
                        if (iVar2 != null) {
                            hashMap.put(iVar2.aos(), iVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (iVar = (com.baidu.tieba.tbadkCore.data.i) entry.getValue()) != null) {
                            sparseArray.put(iVar.getPosition(), iVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new bj(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.i iVar3 = (com.baidu.tieba.tbadkCore.data.i) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = iVar3.getPosition();
                        if (position2 + i3 < aat.size()) {
                            if (this.bLe.aar() != null) {
                                iVar3.csd = this.bLe.aar().getId();
                            }
                            if (this.bLe.aas() != null) {
                                iVar3.threadId = com.baidu.adp.lib.g.c.c(this.bLe.aas().getId(), 0L);
                            }
                            aat.add(position2 + i3, iVar3);
                            TiebaStatic.eventStat(this.bKZ.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", iVar3.aor().apk_name);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.bLa.setFromCDN(z);
        this.bLb.setFromCDN(z);
        this.bLc.setFromCDN(z);
    }

    public void setIsShowImage(boolean z) {
        this.bLg = z;
    }

    public void dT(boolean z) {
        this.bLh = z;
    }

    public void dU(boolean z) {
        this.bLi = z;
    }

    public void t(View.OnClickListener onClickListener) {
        this.bLk = onClickListener;
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.auJ = sVar;
    }

    public void a(com.baidu.tieba.pb.b.d dVar) {
        this.bKG = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afC = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aPm = onClickListener;
    }
}
