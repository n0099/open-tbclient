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
    private BdTypeListView aMm;
    private PbActivity bLa;
    private bw bLb;
    private bk bLc;
    private bl bLd;
    private bv bLe;
    private com.baidu.tieba.pb.a.b bLf;
    private int mImageMaxWidth;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.j> bLg = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean bLh = true;
    private boolean bLi = true;
    private boolean bLj = true;
    private String bLk = null;
    private View.OnClickListener bLl = null;
    private View.OnClickListener aPn = null;
    private com.baidu.tbadk.widget.richText.s auJ = null;
    private com.baidu.tieba.pb.pb.sub.ag bLm = null;
    private com.baidu.tieba.pb.b.d bKH = null;
    private View.OnLongClickListener afC = null;
    private List<com.baidu.adp.widget.ListView.a> aMB = new ArrayList();
    private final CustomMessageListener aLQ = new bi(this, 2001122);

    public bh(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.mImageMaxWidth = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.mImageMaxWidth = com.baidu.adp.lib.util.n.M(pbActivity.getPageContext().getPageActivity());
        this.width = this.mImageMaxWidth;
        this.bLa = pbActivity;
        this.aMm = bdTypeListView;
        pbActivity.registerListener(this.aLQ);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.bLb = new bw(pbActivity, com.baidu.tieba.tbadkCore.data.j.csf);
        this.bLc = new bk(pbActivity, com.baidu.tbadk.core.data.c.Pm);
        this.bLd = new bl(pbActivity, com.baidu.tbadk.core.data.c.Pn);
        this.bLe = new bv(pbActivity, com.baidu.tbadk.core.data.aa.Rq);
        this.aMB.add(this.bLb);
        this.aMB.add(this.bLc);
        this.aMB.add(this.bLd);
        this.aMB.add(this.bLe);
        bdTypeListView.h(this.aMB);
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.data.j jVar;
        int size2;
        if (this.bLf != bVar) {
            z = (bVar == null || bVar.aar()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.bLf = bVar;
        if (z) {
            abk();
            if (bVar != null) {
                bVar.dP(false);
            }
        }
        this.bLg.clear();
        if (this.bLf != null && this.bLf.aau() != null && this.bLf.aau().size() > 0) {
            this.bLg.addAll(this.bLf.aau());
        }
        if (bVar != null && bVar.aat() != null && bVar.aat().getAuthor() != null) {
            this.bLk = bVar.aat().getAuthor().getUserId();
        }
        this.bLb.b(bVar);
        this.bLb.setFromCDN(this.mIsFromCDN);
        this.bLb.ir(this.bLk);
        this.bLb.setImageMaxWidth(this.mImageMaxWidth);
        this.bLb.setIsShowImage(this.bLh);
        this.bLb.dT(this.bLi);
        this.bLb.dU(this.bLj);
        this.bLb.n(this.aPn);
        this.bLb.t(this.bLl);
        this.bLb.setOnImageClickListener(this.auJ);
        this.bLb.setOnLongClickListener(this.afC);
        this.bLb.a(this.bKH);
        this.bLc.setFromCDN(this.mIsFromCDN);
        this.bLd.setFromCDN(this.mIsFromCDN);
        ArrayList<com.baidu.adp.widget.ListView.ai> arrayList = new ArrayList<>(bVar.aau());
        if (!this.bLj && bVar != null && bVar.aau() != null && (size = bVar.aau().size()) > 0 && (jVar = bVar.aau().get(size - 1)) != null && jVar.aoC() == 1 && (size2 = arrayList.size()) > 0) {
            arrayList.remove(size2 - 1);
        }
        int a = a(this.bLf, arrayList, this.bLj);
        if (a >= 0) {
            arrayList.add(a, this.bLf.aav());
        }
        this.bLe.v(this.aPn);
        this.aMm.setData(arrayList);
    }

    public int a(com.baidu.tieba.pb.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, boolean z) {
        if (bVar == null || bVar.aau() == null || bVar.aav() == null || bVar.aau().size() == 0 || bVar.aat() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(bVar.aav().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (bVar.aau().get(0) == null || bVar.aau().get(0).aoC() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (bVar.Zq() == null || bVar.Zq().qP() != bVar.Zq().qN()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.ai ay(int i) {
        return this.aMm.ay(i);
    }

    public BdUniqueId hy(int i) {
        if (this.aMm.ay(i) != null) {
            return this.aMm.ay(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aMm.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMm.getAdapter()).notifyDataSetChanged();
        }
    }

    private void abk() {
        com.baidu.tieba.tbadkCore.data.i iVar;
        int position;
        if (this.bLf != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aau = this.bLf.aau();
            ArrayList<com.baidu.tieba.tbadkCore.data.i> aaz = this.bLf.aaz();
            if (aaz != null) {
                int size = aaz.size();
                if (aau != null && aau.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.i> it = aaz.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.i next = it.next();
                        if (next != null && next.aot() != null) {
                            sb.append(next.aot());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.i> it2 = aaz.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.i next2 = it2.next();
                        if (next2 != null) {
                            next2.aPM = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.i> it3 = aaz.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.i next3 = it3.next();
                        if (next3.aos() != null && next3.aos().qu() && !com.baidu.tieba.tbadkCore.au.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.aos().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.i iVar2 = (com.baidu.tieba.tbadkCore.data.i) sparseArray.get(sparseArray.keyAt(i));
                        if (iVar2 != null) {
                            hashMap.put(iVar2.aot(), iVar2);
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
                        if (position2 + i3 < aau.size()) {
                            if (this.bLf.aas() != null) {
                                iVar3.cse = this.bLf.aas().getId();
                            }
                            if (this.bLf.aat() != null) {
                                iVar3.threadId = com.baidu.adp.lib.g.c.c(this.bLf.aat().getId(), 0L);
                            }
                            aau.add(position2 + i3, iVar3);
                            TiebaStatic.eventStat(this.bLa.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", iVar3.aos().apk_name);
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
        this.bLb.setFromCDN(z);
        this.bLc.setFromCDN(z);
        this.bLd.setFromCDN(z);
    }

    public void setIsShowImage(boolean z) {
        this.bLh = z;
    }

    public void dT(boolean z) {
        this.bLi = z;
    }

    public void dU(boolean z) {
        this.bLj = z;
    }

    public void t(View.OnClickListener onClickListener) {
        this.bLl = onClickListener;
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.auJ = sVar;
    }

    public void a(com.baidu.tieba.pb.b.d dVar) {
        this.bKH = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afC = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aPn = onClickListener;
    }
}
