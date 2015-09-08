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
    private BdTypeListView aVN;
    private int ccC;
    private PbActivity ccs;
    private br cct;
    private bg ccu;
    private bh ccv;
    private bq ccw;
    private com.baidu.tieba.pb.a.b ccx;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.i> ccy = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean ccz = true;
    private boolean ccA = true;
    private boolean ccB = true;
    private String ccD = null;
    private View.OnClickListener ccE = null;
    private View.OnClickListener aZv = null;
    private TbRichTextView.c aDG = null;
    private com.baidu.tieba.pb.pb.sub.ai ccF = null;
    private com.baidu.tieba.pb.b.c cbW = null;
    private View.OnLongClickListener alb = null;
    private List<com.baidu.adp.widget.ListView.a> aWg = new ArrayList();
    private final CustomMessageListener aVr = new be(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public bd(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ccC = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.ccC = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.ccC;
        this.ccs = pbActivity;
        this.aVN = bdTypeListView;
        pbActivity.registerListener(this.aVr);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cct = new br(pbActivity, com.baidu.tieba.tbadkCore.data.i.cRf);
        this.ccu = new bg(pbActivity, com.baidu.tbadk.core.data.c.Uc);
        this.ccv = new bh(pbActivity, com.baidu.tbadk.core.data.c.Ud);
        this.ccw = new bq(pbActivity, com.baidu.tbadk.core.data.ab.Wo);
        this.aWg.add(this.cct);
        this.aWg.add(this.ccu);
        this.aWg.add(this.ccv);
        this.aWg.add(this.ccw);
        bdTypeListView.h(this.aWg);
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        boolean z;
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList;
        int size;
        com.baidu.tieba.tbadkCore.data.i iVar;
        int size2;
        if (this.ccx != bVar) {
            z = (bVar == null || bVar.acO()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.ccx = bVar;
        if (z) {
            adH();
            if (bVar != null) {
                bVar.ej(false);
            }
        }
        if (this.ccy == null) {
            this.ccy = new ArrayList<>();
        }
        this.ccy.clear();
        if (this.ccx != null && this.ccx.acR() != null && this.ccx.acR().size() > 0) {
            this.ccy.addAll(this.ccx.acR());
        }
        if (bVar != null && bVar.acQ() != null && bVar.acQ().getAuthor() != null) {
            this.ccD = bVar.acQ().getAuthor().getUserId();
        }
        if (this.cct != null && this.ccu != null) {
            this.cct.b(bVar);
            this.cct.setFromCDN(this.mIsFromCDN);
            this.cct.ju(this.ccD);
            this.cct.setImageMaxWidth(this.ccC);
            this.cct.eo(this.ccz);
            this.cct.ep(this.ccA);
            this.cct.eq(this.ccB);
            this.cct.setCommonClickListener(this.aZv);
            this.cct.A(this.ccE);
            this.cct.setOnImageClickListener(this.aDG);
            this.cct.setOnLongClickListener(this.alb);
            this.cct.a(this.cbW);
            this.ccu.setFromCDN(this.mIsFromCDN);
            this.ccv.setFromCDN(this.mIsFromCDN);
            if (bVar.acR() != null) {
                arrayList = new ArrayList<>(bVar.acR());
            } else {
                arrayList = new ArrayList<>();
            }
            if (!this.ccB && bVar != null && bVar.acR() != null && (size = bVar.acR().size()) > 0 && (iVar = bVar.acR().get(size - 1)) != null && iVar.auj() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            int a = a(this.ccx, arrayList, this.ccB);
            if (a >= 0) {
                arrayList.add(a, this.ccx.acS());
            }
            this.ccw.r(this.aZv);
            if (this.aVN != null) {
                this.aVN.setData(arrayList);
            }
        }
    }

    public int a(com.baidu.tieba.pb.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList, boolean z) {
        if (bVar == null || bVar.acR() == null || bVar.acS() == null || bVar.acR().size() == 0 || bVar.acQ() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(bVar.acS().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (bVar.acR().get(0) == null || bVar.acR().get(0).auj() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (bVar.getPage() == null || bVar.getPage().rO() != bVar.getPage().rM()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        return this.aVN.aA(i);
    }

    public BdUniqueId iA(int i) {
        if (this.aVN.aA(i) != null) {
            return this.aVN.aA(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aVN.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVN.getAdapter()).notifyDataSetChanged();
        }
    }

    private void adH() {
        com.baidu.tieba.tbadkCore.data.h hVar;
        int position;
        if (this.ccx != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acR = this.ccx.acR();
            ArrayList<com.baidu.tieba.tbadkCore.data.h> acY = this.ccx.acY();
            if (acY != null) {
                int size = acY.size();
                if (acR != null && acR.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.h> it = acY.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.h next = it.next();
                        if (next != null && next.aua() != null) {
                            sb.append(next.aua());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.h> it2 = acY.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.h next2 = it2.next();
                        if (next2 != null) {
                            next2.aZY = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.h> it3 = acY.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.h next3 = it3.next();
                        if (next3.atZ() != null && next3.atZ().ru() && !com.baidu.tieba.tbadkCore.ag.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.atZ().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.h hVar2 = (com.baidu.tieba.tbadkCore.data.h) sparseArray.get(sparseArray.keyAt(i));
                        if (hVar2 != null) {
                            hashMap.put(hVar2.aua(), hVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (hVar = (com.baidu.tieba.tbadkCore.data.h) entry.getValue()) != null) {
                            sparseArray.put(hVar.getPosition(), hVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new bf(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.h hVar3 = (com.baidu.tieba.tbadkCore.data.h) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = hVar3.getPosition();
                        if (position2 + i3 < acR.size()) {
                            if (this.ccx.acP() != null) {
                                hVar3.cRe = this.ccx.acP().getId();
                            }
                            if (this.ccx.acQ() != null) {
                                hVar3.threadId = com.baidu.adp.lib.g.b.c(this.ccx.acQ().getId(), 0L);
                            }
                            acR.add(position2 + i3, hVar3);
                            TiebaStatic.eventStat(this.ccs.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", hVar3.atZ().apk_name);
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
        this.cct.setFromCDN(z);
        this.ccu.setFromCDN(z);
        this.ccv.setFromCDN(z);
    }

    public void eo(boolean z) {
        this.ccz = z;
    }

    public void ep(boolean z) {
        this.ccA = z;
    }

    public void eq(boolean z) {
        this.ccB = z;
    }

    public void A(View.OnClickListener onClickListener) {
        this.ccE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.c cVar) {
        this.aDG = cVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.cbW = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alb = onLongClickListener;
    }

    public void B(View.OnClickListener onClickListener) {
        this.aZv = onClickListener;
    }
}
