package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
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
public class bj {
    private BdTypeListView aJU;
    private PbActivity bIF;
    private by bIG;
    private bm bIH;
    private bn bII;
    private bx bIJ;
    private com.baidu.tieba.pb.a.b bIK;
    private int mImageMaxWidth;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.c.j> bIL = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean bIM = true;
    private boolean bIN = true;
    private boolean bIO = true;
    private String bIP = null;
    private View.OnClickListener bIQ = null;
    private View.OnClickListener aMP = null;
    private com.baidu.tbadk.widget.richText.s asV = null;
    private com.baidu.tieba.pb.pb.sub.a bIR = null;
    private com.baidu.tieba.pb.b.d bIf = null;
    private View.OnLongClickListener aeq = null;
    private List<com.baidu.adp.widget.ListView.a> aKj = new ArrayList();
    private final CustomMessageListener aJy = new bk(this, 2001122);

    public bj(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.mImageMaxWidth = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.mImageMaxWidth = com.baidu.adp.lib.util.n.M(pbActivity.getPageContext().getPageActivity());
        this.width = this.mImageMaxWidth;
        this.bIF = pbActivity;
        this.aJU = bdTypeListView;
        pbActivity.registerListener(this.aJy);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.bIG = new by(pbActivity, com.baidu.tieba.tbadkCore.c.j.cnQ);
        this.bIH = new bm(pbActivity, com.baidu.tbadk.core.data.c.OP);
        this.bII = new bn(pbActivity, com.baidu.tbadk.core.data.c.OQ);
        this.bIJ = new bx(pbActivity, com.baidu.tbadk.core.data.aa.QT);
        this.aKj.add(this.bIG);
        this.aKj.add(this.bIH);
        this.aKj.add(this.bII);
        this.aKj.add(this.bIJ);
        bdTypeListView.g(this.aKj);
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.c.j jVar;
        int size2;
        if (this.bIK != bVar) {
            z = (bVar == null || bVar.YN()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.bIK = bVar;
        if (z) {
            ZF();
            if (bVar != null) {
                bVar.dF(false);
            }
        }
        this.bIL.clear();
        if (this.bIK != null && this.bIK.YQ() != null && this.bIK.YQ().size() > 0) {
            this.bIL.addAll(this.bIK.YQ());
        }
        if (bVar != null && bVar.YP() != null && bVar.YP().getAuthor() != null) {
            this.bIP = bVar.YP().getAuthor().getUserId();
        }
        this.bIG.b(bVar);
        this.bIG.setFromCDN(this.mIsFromCDN);
        this.bIG.hJ(this.bIP);
        this.bIG.setImageMaxWidth(this.mImageMaxWidth);
        this.bIG.dJ(this.bIM);
        this.bIG.dK(this.bIN);
        this.bIG.dL(this.bIO);
        this.bIG.n(this.aMP);
        this.bIG.t(this.bIQ);
        this.bIG.setOnImageClickListener(this.asV);
        this.bIG.setOnLongClickListener(this.aeq);
        this.bIG.a(this.bIf);
        this.bIH.setFromCDN(this.mIsFromCDN);
        this.bII.setFromCDN(this.mIsFromCDN);
        ArrayList<com.baidu.adp.widget.ListView.ai> arrayList = new ArrayList<>(bVar.YQ());
        if (!this.bIO && bVar != null && bVar.YQ() != null && (size = bVar.YQ().size()) > 0 && (jVar = bVar.YQ().get(size - 1)) != null && jVar.amA() == 1 && (size2 = arrayList.size()) > 0) {
            arrayList.remove(size2 - 1);
        }
        int a = a(this.bIK, arrayList, this.bIO);
        if (a >= 0) {
            arrayList.add(a, this.bIK.YR());
        }
        this.bIJ.v(this.aMP);
        this.aJU.setData(arrayList);
    }

    public int a(com.baidu.tieba.pb.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, boolean z) {
        if (bVar == null || bVar.YQ() == null || bVar.YR() == null || bVar.YQ().size() == 0 || bVar.YP() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(bVar.YR().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (bVar.YQ().get(0) == null || bVar.YQ().get(0).amA() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (bVar.XE() == null || bVar.XE().qj() != bVar.XE().qh()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.ai aA(int i) {
        return this.aJU.aA(i);
    }

    public BdUniqueId hi(int i) {
        return this.aJU.aA(i).getType();
    }

    public void notifyDataSetChanged() {
        if (this.aJU.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aJU.getAdapter()).notifyDataSetChanged();
        }
    }

    private void ZF() {
        com.baidu.tieba.tbadkCore.c.i iVar;
        int position;
        if (this.bIK != null) {
            ArrayList<com.baidu.tieba.tbadkCore.c.j> YQ = this.bIK.YQ();
            ArrayList<com.baidu.tieba.tbadkCore.c.i> YV = this.bIK.YV();
            if (YV != null) {
                int size = YV.size();
                if (YQ != null && YQ.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.c.i> it = YV.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.c.i next = it.next();
                        if (next != null && next.amr() != null) {
                            sb.append(next.amr());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.c.i> it2 = YV.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.c.i next2 = it2.next();
                        if (next2 != null) {
                            next2.aNi = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.c.i> it3 = YV.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.c.i next3 = it3.next();
                        if (next3.amq() != null && next3.amq().pO() && !com.baidu.tieba.tbadkCore.au.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.amq().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.c.i iVar2 = (com.baidu.tieba.tbadkCore.c.i) sparseArray.get(sparseArray.keyAt(i));
                        if (iVar2 != null) {
                            hashMap.put(iVar2.amr(), iVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (iVar = (com.baidu.tieba.tbadkCore.c.i) entry.getValue()) != null) {
                            sparseArray.put(iVar.getPosition(), iVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new bl(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.c.i iVar3 = (com.baidu.tieba.tbadkCore.c.i) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = iVar3.getPosition();
                        if (position2 + i3 < YQ.size()) {
                            if (this.bIK.YO() != null) {
                                iVar3.cnP = this.bIK.YO().getId();
                            }
                            if (this.bIK.YP() != null) {
                                iVar3.threadId = com.baidu.adp.lib.g.c.a(this.bIK.YP().getId(), 0L);
                            }
                            YQ.add(position2 + i3, iVar3);
                            TiebaStatic.eventStat(this.bIF.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", iVar3.amq().apk_name);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, TextView textView, int i) {
        String string = TbadkCoreApplication.m411getInst().getApp().getString(com.baidu.tieba.y.sub_pb_load_more);
        String valueOf = String.valueOf(i);
        int indexOf = string.indexOf("%d");
        SpannableString spannableString = new SpannableString(string.replace("%d", valueOf));
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_link_tip_c)), indexOf, valueOf.length() + indexOf, 33);
        com.baidu.tbadk.core.util.ba.b(textView, com.baidu.tieba.s.cp_link_tip_c, 1);
        textView.setText(spannableString);
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.bIG.setFromCDN(z);
        this.bIH.setFromCDN(z);
        this.bII.setFromCDN(z);
    }

    public boolean ZG() {
        return this.bIM;
    }

    public void dJ(boolean z) {
        this.bIM = z;
    }

    public boolean ZH() {
        return this.bIN;
    }

    public void dK(boolean z) {
        this.bIN = z;
    }

    public void dL(boolean z) {
        this.bIO = z;
    }

    public int getWidth() {
        return this.width;
    }

    public void t(View.OnClickListener onClickListener) {
        this.bIQ = onClickListener;
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.asV = sVar;
    }

    public void a(com.baidu.tieba.pb.b.d dVar) {
        this.bIf = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aeq = onLongClickListener;
    }

    public View.OnLongClickListener ZI() {
        return this.aeq;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aMP = onClickListener;
    }
}
