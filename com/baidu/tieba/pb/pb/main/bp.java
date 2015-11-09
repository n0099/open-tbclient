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
public class bp {
    private BdTypeListView aVo;
    private com.baidu.tieba.pb.a.c chP;
    private int cho;
    private PbActivity cjZ;
    private ch cka;
    private bs ckb;
    private bu ckc;
    private bt ckd;
    private cg cke;
    private com.baidu.tieba.pb.pb.a.g ckf;
    private com.baidu.tieba.pb.pb.a.a ckg;
    private bw ckh;
    private com.baidu.tieba.pb.pb.a.n cki;
    private int width;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> ckj = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean chp = true;
    private boolean chO = true;
    private boolean chq = true;
    private String chV = null;
    private View.OnClickListener chY = null;
    private View.OnClickListener aZI = null;
    private TbRichTextView.d aBf = null;
    private com.baidu.tieba.pb.pb.sub.ak chW = null;
    private com.baidu.tieba.pb.b.c chs = null;
    private View.OnLongClickListener ajZ = null;
    private List<com.baidu.adp.widget.ListView.a> aVK = new ArrayList();
    private final CustomMessageListener aUK = new bq(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);

    public bp(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cho = 0;
        this.width = -1;
        a(pbActivity, bdTypeListView);
        this.cho = com.baidu.adp.lib.util.k.K(pbActivity.getPageContext().getPageActivity());
        this.width = this.cho;
        this.cjZ = pbActivity;
        this.aVo = bdTypeListView;
        pbActivity.registerListener(this.aUK);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.cki = new com.baidu.tieba.pb.pb.a.n(pbActivity, com.baidu.tieba.tbadkCore.data.o.daQ);
        this.cka = new ch(pbActivity, com.baidu.tieba.tbadkCore.data.o.daM);
        this.ckb = new bs(pbActivity, com.baidu.tbadk.core.data.b.TP);
        this.ckc = new bu(pbActivity, com.baidu.tbadk.core.data.b.TQ);
        this.ckd = new bt(pbActivity, com.baidu.tbadk.core.data.b.TR);
        this.cke = new cg(pbActivity, com.baidu.tbadk.core.data.aa.Wl);
        this.ckf = new com.baidu.tieba.pb.pb.a.g(pbActivity, com.baidu.tieba.tbadkCore.data.o.daN);
        this.ckg = new com.baidu.tieba.pb.pb.a.a(pbActivity, com.baidu.tieba.tbadkCore.data.o.daO);
        this.ckh = new bw(pbActivity, com.baidu.tieba.tbadkCore.data.o.daP);
        this.aVK.add(this.cka);
        this.aVK.add(this.cki);
        this.aVK.add(this.ckb);
        this.aVK.add(this.ckc);
        this.aVK.add(this.ckd);
        this.aVK.add(this.cke);
        this.aVK.add(this.ckf);
        this.aVK.add(this.ckg);
        this.aVK.add(this.ckh);
        bdTypeListView.h(this.aVK);
    }

    public void a(com.baidu.tieba.pb.a.c cVar) {
        boolean z;
        int size;
        com.baidu.tieba.tbadkCore.data.o oVar;
        int size2;
        if (this.chP != cVar) {
            z = (cVar == null || cVar.afe()) && TbadkCoreApplication.m411getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.chP = cVar;
        if (z) {
            agh();
            if (cVar != null) {
                cVar.eq(false);
            }
        }
        if (this.ckj == null) {
            this.ckj = new ArrayList<>();
        }
        this.ckj.clear();
        if (this.chP != null && this.chP.afi() != null && this.chP.afi().size() > 0) {
            this.ckj.addAll(this.chP.afi());
        }
        if (cVar != null && cVar.afh() != null && cVar.afh().getAuthor() != null) {
            this.chV = cVar.afh().getAuthor().getUserId();
        }
        if (this.cka != null && this.ckb != null) {
            this.cki.a(cVar);
            this.cki.setFromCDN(this.mIsFromCDN);
            this.cki.jJ(this.chV);
            this.cki.setImageMaxWidth(this.cho);
            this.cki.er(this.chp);
            this.cki.et(this.chO);
            this.cki.es(this.chq);
            this.cki.setCommonClickListener(this.aZI);
            this.cki.B(this.chY);
            this.cki.setOnImageClickListener(this.aBf);
            this.cki.setOnLongClickListener(this.ajZ);
            this.cki.a(this.chs);
            this.cka.a(cVar);
            this.cka.setFromCDN(this.mIsFromCDN);
            this.cka.jJ(this.chV);
            this.cka.setImageMaxWidth(this.cho);
            this.cka.er(this.chp);
            this.cka.et(this.chO);
            this.cka.es(this.chq);
            this.cka.setCommonClickListener(this.aZI);
            this.cka.B(this.chY);
            this.cka.setOnImageClickListener(this.aBf);
            this.cka.setOnLongClickListener(this.ajZ);
            this.cka.a(this.chs);
            this.ckf.a(cVar);
            this.ckf.setFromCDN(this.mIsFromCDN);
            this.ckf.setImageMaxWidth(this.cho);
            this.ckf.er(this.chp);
            this.ckf.et(this.chO);
            this.ckf.es(this.chq);
            this.ckf.setCommonClickListener(this.aZI);
            this.ckf.setOnImageClickListener(this.aBf);
            this.ckf.setOnLongClickListener(this.ajZ);
            this.ckf.a(this.chs);
            this.ckg.a(cVar);
            this.ckg.setFromCDN(this.mIsFromCDN);
            this.ckg.setImageMaxWidth(this.cho);
            this.ckg.er(this.chp);
            this.ckg.es(this.chq);
            this.ckg.setCommonClickListener(this.aZI);
            this.ckg.setOnImageClickListener(this.aBf);
            this.ckg.setOnLongClickListener(this.ajZ);
            this.ckg.a(this.chs);
            this.ckb.setFromCDN(this.mIsFromCDN);
            this.ckc.setFromCDN(this.mIsFromCDN);
            this.ckd.setFromCDN(this.mIsFromCDN);
            this.ckh.a(cVar);
            this.ckh.setFromCDN(this.mIsFromCDN);
            this.ckh.jJ(this.chV);
            this.ckh.setImageMaxWidth(this.cho);
            this.ckh.er(this.chp);
            this.ckh.et(this.chO);
            this.ckh.es(this.chq);
            this.ckh.setCommonClickListener(this.aZI);
            this.ckh.B(this.chY);
            this.ckh.setOnImageClickListener(this.aBf);
            this.ckh.setOnLongClickListener(this.ajZ);
            this.ckh.a(this.chs);
            ArrayList<com.baidu.adp.widget.ListView.u> arrayList = new ArrayList<>();
            if (cVar.afi() != null) {
                arrayList.addAll(cVar.afi());
            }
            if (!this.chq && cVar != null && cVar.afi() != null && (size = cVar.afi().size()) > 0 && (oVar = cVar.afi().get(size - 1)) != null && oVar.axt() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            int a = a(this.chP, arrayList, this.chq);
            if (a >= 0) {
                arrayList.add(a, this.chP.afj());
            }
            this.cke.r(this.aZI);
            if (this.aVo != null) {
                this.aVo.setData(arrayList);
            }
        }
    }

    public int LF() {
        return this.aVo.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.a.c cVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList, boolean z) {
        if (cVar == null || cVar.afi() == null || cVar.afj() == null || cVar.afi().size() == 0 || cVar.afh() == null || arrayList == null) {
            return -1;
        }
        if (StringUtils.isNull(cVar.afj().getSummary())) {
            return -1;
        }
        int size = arrayList.size();
        if (z) {
            return (cVar.afi().get(0) == null || cVar.afi().get(0).axt() != 1) ? -1 : 1;
        } else if (size != 0) {
            return (cVar.getPage() == null || cVar.getPage().rI() != cVar.getPage().rG()) ? -1 : 1;
        } else {
            return 0;
        }
    }

    public com.baidu.adp.widget.ListView.u aA(int i) {
        return this.aVo.aA(i);
    }

    public BdUniqueId iZ(int i) {
        if (this.aVo.aA(i) != null) {
            return this.aVo.aA(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.aVo.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVo.getAdapter()).notifyDataSetChanged();
        }
    }

    private void agh() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        int position;
        if (this.chP != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.o> afi = this.chP.afi();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> afp = this.chP.afp();
            if (afp != null) {
                int size = afp.size();
                if (afi != null && afi.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it = afp.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next = it.next();
                        if (next != null && next.axh() != null) {
                            sb.append(next.axh());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = afp.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                        if (next2 != null) {
                            next2.baw = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = afp.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                        if (next3.axg() != null && next3.axg().rn() && !com.baidu.tieba.tbadkCore.ag.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), next3.axg().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.n nVar2 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(sparseArray.keyAt(i));
                        if (nVar2 != null) {
                            hashMap.put(nVar2.axh(), nVar2);
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
                    Collections.sort(arrayList, new br(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = nVar3.getPosition();
                        if (!a(nVar3, afi)) {
                            if (position2 + i3 < afi.size()) {
                                if (this.chP.afg() != null) {
                                    nVar3.daL = this.chP.afg().getId();
                                }
                                if (this.chP.afh() != null) {
                                    nVar3.threadId = com.baidu.adp.lib.g.b.c(this.chP.afh().getId(), 0L);
                                }
                                if (this.chP != null && this.chP.getPage() != null) {
                                    nVar3.cJj = this.chP.getPage().rI();
                                }
                                afi.add(position2, nVar3);
                                TiebaStatic.eventStat(this.cjZ.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", nVar3.axg().apk_name);
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
        int m = com.baidu.tbadk.core.util.u.m(arrayList);
        if (nVar == null || m <= 0) {
            return false;
        }
        int position = nVar.getPosition();
        if (m >= 2 || position != m + 1) {
            return false;
        }
        if (this.chP != null && this.chP.getPage() != null) {
            nVar.cJj = this.chP.getPage().rI();
        }
        arrayList.add(nVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.cki.setFromCDN(z);
        this.cka.setFromCDN(z);
        this.ckf.setFromCDN(z);
        this.ckg.setFromCDN(z);
        this.ckb.setFromCDN(z);
        this.ckc.setFromCDN(z);
        this.ckd.setFromCDN(z);
    }

    public void er(boolean z) {
        this.chp = z;
    }

    public void et(boolean z) {
        this.chO = z;
    }

    public void es(boolean z) {
        this.chq = z;
    }

    public void B(View.OnClickListener onClickListener) {
        this.chY = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.aBf = dVar;
    }

    public void a(com.baidu.tieba.pb.b.c cVar) {
        this.chs = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajZ = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.aZI = onClickListener;
    }
}
