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
public class bk {
    private BdTypeListView aKe;
    private PbActivity bIT;
    private bz bIU;
    private bn bIV;
    private bo bIW;
    private by bIX;
    private com.baidu.tieba.pb.a.b bIY;
    private int mImageMaxWidth;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.c.j> bIZ = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean bJa = true;
    private boolean bJb = true;
    private boolean bJc = true;
    private String bJd = null;
    private View.OnClickListener bJe = null;
    private View.OnClickListener aNa = null;
    private com.baidu.tbadk.widget.richText.s atd = null;
    private com.baidu.tieba.pb.pb.sub.a bJf = null;
    private com.baidu.tieba.pb.b.d bIs = null;
    private View.OnLongClickListener aey = null;
    private List<com.baidu.adp.widget.ListView.a> aKt = new ArrayList();
    private final CustomMessageListener aJI = new bl(this, 2001122);

    public bk(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.mImageMaxWidth = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.mImageMaxWidth = com.baidu.adp.lib.util.n.M(pbActivity.getPageContext().getPageActivity());
        this.width = this.mImageMaxWidth;
        this.bIT = pbActivity;
        this.aKe = bdTypeListView;
        pbActivity.registerListener(this.aJI);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.bIU = new bz(pbActivity, com.baidu.tieba.tbadkCore.c.j.cog);
        this.bIV = new bn(pbActivity, com.baidu.tbadk.core.data.c.OR);
        this.bIW = new bo(pbActivity, com.baidu.tbadk.core.data.c.OS);
        this.bIX = new by(pbActivity, com.baidu.tbadk.core.data.aa.QV);
        this.aKt.add(this.bIU);
        this.aKt.add(this.bIV);
        this.aKt.add(this.bIW);
        this.aKt.add(this.bIX);
        bdTypeListView.g(this.aKt);
    }

    public void b(com.baidu.tieba.pb.a.b bVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.c.j jVar;
        int size2;
        if (this.bIY != bVar) {
            z = (bVar == null || bVar.YZ()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.bIY = bVar;
        if (z) {
            ZS();
            if (bVar != null) {
                bVar.dD(false);
            }
        }
        this.bIZ.clear();
        if (this.bIY != null && this.bIY.Zc() != null && this.bIY.Zc().size() > 0) {
            this.bIZ.addAll(this.bIY.Zc());
        }
        if (bVar != null && bVar.Zb() != null && bVar.Zb().getAuthor() != null) {
            this.bJd = bVar.Zb().getAuthor().getUserId();
        }
        this.bIU.b(bVar);
        this.bIU.setFromCDN(this.mIsFromCDN);
        this.bIU.hM(this.bJd);
        this.bIU.setImageMaxWidth(this.mImageMaxWidth);
        this.bIU.dH(this.bJa);
        this.bIU.dI(this.bJb);
        this.bIU.dJ(this.bJc);
        this.bIU.n(this.aNa);
        this.bIU.u(this.bJe);
        this.bIU.setOnImageClickListener(this.atd);
        this.bIU.setOnLongClickListener(this.aey);
        this.bIU.a(this.bIs);
        this.bIV.setFromCDN(this.mIsFromCDN);
        this.bIW.setFromCDN(this.mIsFromCDN);
        ArrayList<com.baidu.adp.widget.ListView.ai> arrayList = new ArrayList<>(bVar.Zc());
        if (!this.bJc && bVar != null && bVar.Zc() != null && (size = bVar.Zc().size()) > 0 && (jVar = bVar.Zc().get(size - 1)) != null && jVar.amP() == 1 && (size2 = arrayList.size()) > 0) {
            arrayList.remove(size2 - 1);
        }
        int a = a(this.bIY, arrayList, this.bJc);
        if (a >= 0) {
            arrayList.add(a, this.bIY.Zd());
        }
        this.bIX.w(this.aNa);
        this.aKe.setData(arrayList);
    }

    public int a(com.baidu.tieba.pb.a.b bVar, ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, boolean z) {
        if (bVar == null || bVar.Zc() == null || bVar.Zd() == null || bVar.Zc().size() == 0 || bVar.Zb() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(bVar.Zd().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (bVar.Zc().get(0) == null || bVar.Zc().get(0).amP() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (bVar.XQ() == null || bVar.XQ().qj() != bVar.XQ().qh()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.ai aA(int i) {
        return this.aKe.aA(i);
    }

    public BdUniqueId hk(int i) {
        return this.aKe.aA(i).getType();
    }

    public void notifyDataSetChanged() {
        if (this.aKe.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aKe.getAdapter()).notifyDataSetChanged();
        }
    }

    private void ZS() {
        com.baidu.tieba.tbadkCore.c.i iVar;
        int position;
        if (this.bIY != null) {
            ArrayList<com.baidu.tieba.tbadkCore.c.j> Zc = this.bIY.Zc();
            ArrayList<com.baidu.tieba.tbadkCore.c.i> Zh = this.bIY.Zh();
            if (Zh != null) {
                int size = Zh.size();
                if (Zc != null && Zc.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.c.i> it = Zh.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.c.i next = it.next();
                        if (next != null && next.amG() != null) {
                            sb.append(next.amG());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.c.i> it2 = Zh.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.c.i next2 = it2.next();
                        if (next2 != null) {
                            next2.aNz = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.c.i> it3 = Zh.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.c.i next3 = it3.next();
                        if (next3.amF() != null && next3.amF().pO() && !com.baidu.tieba.tbadkCore.au.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.amF().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.c.i iVar2 = (com.baidu.tieba.tbadkCore.c.i) sparseArray.get(sparseArray.keyAt(i));
                        if (iVar2 != null) {
                            hashMap.put(iVar2.amG(), iVar2);
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
                    Collections.sort(arrayList, new bm(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.c.i iVar3 = (com.baidu.tieba.tbadkCore.c.i) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = iVar3.getPosition();
                        if (position2 + i3 < Zc.size()) {
                            if (this.bIY.Za() != null) {
                                iVar3.cof = this.bIY.Za().getId();
                            }
                            if (this.bIY.Zb() != null) {
                                iVar3.threadId = com.baidu.adp.lib.g.c.a(this.bIY.Zb().getId(), 0L);
                            }
                            Zc.add(position2 + i3, iVar3);
                            TiebaStatic.eventStat(this.bIT.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", iVar3.amF().apk_name);
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
        this.bIU.setFromCDN(z);
        this.bIV.setFromCDN(z);
        this.bIW.setFromCDN(z);
    }

    public boolean ZT() {
        return this.bJa;
    }

    public void dH(boolean z) {
        this.bJa = z;
    }

    public boolean ZU() {
        return this.bJb;
    }

    public void dI(boolean z) {
        this.bJb = z;
    }

    public void dJ(boolean z) {
        this.bJc = z;
    }

    public int getWidth() {
        return this.width;
    }

    public void u(View.OnClickListener onClickListener) {
        this.bJe = onClickListener;
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.atd = sVar;
    }

    public void a(com.baidu.tieba.pb.b.d dVar) {
        this.bIs = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aey = onLongClickListener;
    }

    public View.OnLongClickListener ZV() {
        return this.aey;
    }

    public void v(View.OnClickListener onClickListener) {
        this.aNa = onClickListener;
    }
}
