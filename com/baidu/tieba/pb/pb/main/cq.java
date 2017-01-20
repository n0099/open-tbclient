package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class cq {
    private List<com.baidu.adp.widget.ListView.a> bKZ;
    private com.baidu.adp.widget.ListView.a bOD;
    private com.baidu.adp.widget.ListView.a bOE;
    private com.baidu.adp.widget.ListView.a bOF;
    private com.baidu.adp.widget.ListView.a bOG;
    private int egh;
    private com.baidu.tieba.pb.data.f egj;
    private PbActivity ehi;
    private com.baidu.tieba.pb.pb.a.d ejA;
    private de ejB;
    private dw ejC;
    private dx ejs;
    private com.baidu.tieba.pb.video.k ejt;
    private com.baidu.tieba.pb.video.m eju;
    private int ejv;
    private com.baidu.adp.widget.ListView.a ejw;
    private eg ejx;
    private en ejy;
    private com.baidu.tieba.pb.pb.a.b ejz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> ejD = new ArrayList<>();
    private ArrayList<com.baidu.tieba.tbadkCore.data.p> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cAg = true;
    private boolean ejE = true;
    private boolean egi = true;
    private boolean ejF = false;
    private String mHostId = null;
    private View.OnClickListener egm = null;
    private View.OnClickListener cpK = null;
    private TbRichTextView.e aHX = null;
    private com.baidu.tieba.pb.a.d egn = null;
    private View.OnLongClickListener anA = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> ejG = new ArrayList();
    private boolean ejH = false;
    private CustomMessageListener bLg = new cr(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bGH = new cs(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bLh = new cu(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public cq(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.egh = 0;
        this.width = -1;
        this.egh = com.baidu.adp.lib.util.k.I(pbActivity.getPageContext().getPageActivity());
        this.width = this.egh;
        this.ehi = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bGH);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ejA = new com.baidu.tieba.pb.pb.a.d(pbActivity, com.baidu.tieba.tbadkCore.data.p.fpN);
        this.ejs = new dx(pbActivity, com.baidu.tieba.tbadkCore.data.p.fpL);
        this.ejs.a(pbActivity);
        this.bOD = com.baidu.tieba.recapp.p.aZV().c(pbActivity, com.baidu.tbadk.core.data.c.Ol);
        this.bOE = com.baidu.tieba.recapp.p.aZV().c(pbActivity, com.baidu.tbadk.core.data.c.Om);
        this.bOF = com.baidu.tieba.recapp.p.aZV().c(pbActivity, com.baidu.tbadk.core.data.c.On);
        this.ejw = com.baidu.tieba.recapp.p.aZV().c(pbActivity, com.baidu.tbadk.core.data.c.Oo);
        this.bOG = com.baidu.tieba.recapp.p.aZV().c(pbActivity, com.baidu.tbadk.core.data.c.Os);
        this.ejB = new de(pbActivity, com.baidu.tieba.pb.data.a.eff);
        this.ejC = new dw(pbActivity, com.baidu.tieba.pb.data.i.efQ);
        this.ejx = new eg(pbActivity, dv.elT);
        this.ejy = new en(pbActivity, com.baidu.tbadk.core.data.ar.RD);
        this.ejt = new com.baidu.tieba.pb.video.k(pbActivity, com.baidu.tieba.pb.video.l.etB);
        this.eju = new com.baidu.tieba.pb.video.m(pbActivity, com.baidu.tieba.pb.video.n.etK);
        this.eju.setOnClickListener(new cv(this));
        this.mAdapters.add(this.ejs);
        this.mAdapters.add(this.ejA);
        this.mAdapters.add(this.bOD);
        this.mAdapters.add(this.bOE);
        this.mAdapters.add(this.bOF);
        this.mAdapters.add(this.ejw);
        this.mAdapters.add(this.bOG);
        this.mAdapters.add(this.ejB);
        this.mAdapters.add(this.ejC);
        this.mAdapters.add(this.ejx);
        this.mAdapters.add(this.ejy);
        this.mAdapters.add(this.ejt);
        this.mAdapters.add(this.eju);
        this.bLg.setPriority(1);
        this.bLg.setSelfListener(true);
        pbActivity.registerListener(this.bLg);
        ZS();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        boolean z;
        com.baidu.tieba.tbadkCore.data.p pVar;
        int size;
        com.baidu.tieba.tbadkCore.data.p pVar2;
        int size2;
        if (this.egj != fVar) {
            z = (fVar == null || fVar.aJV()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.egj = fVar;
        if (z) {
            aLB();
            if (fVar != null) {
                fVar.ih(false);
            }
        }
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }
        this.postList.clear();
        if (this.egj != null && this.egj.aKb() != null && this.egj.aKb().size() > 0) {
            this.postList.addAll(this.egj.aKb());
        }
        if (fVar != null && fVar.aJZ() != null && fVar.aJZ().getAuthor() != null) {
            this.mHostId = fVar.aJZ().getAuthor().getUserId();
        }
        if (this.ejs != null) {
            this.ejA.b(fVar);
            this.ejA.setFromCDN(this.mIsFromCDN);
            this.ejA.setHostId(this.mHostId);
            this.ejA.oo(this.egh);
            this.ejA.ii(this.cAg);
            this.ejA.ij(this.egi);
            this.ejA.setCommonClickListener(this.cpK);
            this.ejA.I(this.egm);
            this.ejA.setOnImageClickListener(this.aHX);
            this.ejA.setOnLongClickListener(this.anA);
            this.ejA.a(this.egn);
            this.ejs.b(fVar);
            this.ejs.setFromCDN(this.mIsFromCDN);
            this.ejs.setHostId(this.mHostId);
            this.ejs.oo(this.egh);
            this.ejs.ii(this.cAg);
            this.ejs.ij(this.egi);
            this.ejs.ik(this.ejF);
            this.ejs.setCommonClickListener(this.cpK);
            this.ejs.I(this.egm);
            this.ejs.setOnImageClickListener(this.aHX);
            this.ejs.setOnLongClickListener(this.anA);
            this.ejs.a(this.egn);
            if (this.bOE != null && (this.bOE instanceof com.baidu.tieba.recapp.l)) {
                ((com.baidu.tieba.recapp.l) this.bOE).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bOF != null && (this.bOF instanceof com.baidu.tieba.recapp.l)) {
                ((com.baidu.tieba.recapp.l) this.bOF).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bOG != null && (this.bOG instanceof com.baidu.tieba.recapp.l)) {
                ((com.baidu.tieba.recapp.l) this.bOG).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ejD.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(fVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.setHostId(this.mHostId);
                    next.oo(this.egh);
                    next.ii(this.cAg);
                    next.ij(this.egi);
                    next.ik(this.ejF);
                    next.setCommonClickListener(this.cpK);
                    next.I(this.egm);
                    next.setOnImageClickListener(this.aHX);
                    next.setOnLongClickListener(this.anA);
                    next.a(this.egn);
                }
            }
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (fVar.aKb() != null) {
                arrayList.addAll(fVar.aKb());
            }
            cu(arrayList);
            if (!this.egi && fVar != null && fVar.aKb() != null && (size = fVar.aKb().size()) > 0 && (pVar2 = fVar.aKb().get(size - 1)) != null && pVar2.bhQ() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.ehi.aLh()) {
                if (fVar.aKb().size() > 0 && (pVar = fVar.aKb().get(0)) != null && pVar.bhQ() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int b = b(this.egj, arrayList, this.egi);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.w.a(arrayList, b, this.egj.aKc());
                }
            }
            int c = c(this.egj, arrayList, this.egi);
            if (c >= 0) {
                com.baidu.tbadk.core.util.w.a(arrayList, c, this.egj.aKd());
            }
            int d = d(this.egj, arrayList, this.egi);
            int size3 = arrayList.size();
            if (!this.ehi.aLh()) {
                if (d < 0) {
                    this.ehi.im(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.egj.aJW());
                    } else if (d >= size3) {
                        arrayList.add(this.egj.aJW());
                    } else {
                        arrayList.add(d, this.egj.aJW());
                    }
                    this.ehi.im(true);
                }
            }
            if (d < 0) {
                this.ejs.im(false);
            } else {
                this.ejs.im(true);
            }
            if (arrayList.size() == 0 && this.ehi.aLh()) {
                arrayList.add(new com.baidu.tieba.pb.data.i());
            }
            int a = a(fVar, arrayList, this.egi);
            if (a >= 0) {
                List<com.baidu.adp.widget.ListView.v> a2 = a(fVar, arrayList);
                if (a2 != null && a2.size() > 0) {
                    com.baidu.tbadk.core.util.w.a((List) arrayList, a, (List) a2);
                } else {
                    this.ejv = 0;
                }
            } else {
                this.ejv = 0;
            }
            com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
            if (this.mListView != null) {
                this.mListView.setData(arrayList);
            }
        }
    }

    public void aLy() {
        this.ejv = 0;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || arrayList == null || fVar.aKb() == null || fVar.aKa() == null || fVar.aKa().size() <= 0) {
            return -1;
        }
        if (z) {
            return (fVar.aKb().get(0) == null || fVar.aKb().get(0).bhQ() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.v> a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (fVar == null || arrayList == null || fVar.aKa() == null || fVar.aKa().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<com.baidu.tbadk.core.data.bh> aKa = fVar.aKa();
        if (this.ejv + 5 >= aKa.size()) {
            int i = 0;
            for (com.baidu.tbadk.core.data.bh bhVar : aKa) {
                if (bhVar != null) {
                    com.baidu.tieba.pb.video.l lVar = new com.baidu.tieba.pb.video.l();
                    i++;
                    if (i == 1) {
                        lVar.a(bhVar, true, true, true, i);
                    } else {
                        lVar.a(bhVar, true, true, false, i);
                    }
                    arrayList2.add(lVar);
                    this.ejv++;
                }
            }
            if (this.ejv <= 0) {
                return null;
            }
            return arrayList2;
        }
        int i2 = this.ejv + 5;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            com.baidu.tbadk.core.data.bh bhVar2 = aKa.get(i4);
            if (bhVar2 != null) {
                com.baidu.tieba.pb.video.l lVar2 = new com.baidu.tieba.pb.video.l();
                i3++;
                boolean z = i3 == 1;
                if (i4 == i2 - 1) {
                    lVar2.a(bhVar2, false, true, z, i3);
                } else {
                    lVar2.a(bhVar2, true, true, z, i3);
                }
                arrayList2.add(lVar2);
                this.ejv++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.n());
        return arrayList2;
    }

    private void ZS() {
        if (this.ehi != null && !ZT()) {
            this.ehi.registerListener(this.bLh);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ZT() {
        if (this.ehi == null) {
            return false;
        }
        this.bKZ = new ArrayList();
        ArrayList<BdUniqueId> bgW = com.baidu.tieba.tbadkCore.t.bgW();
        if (bgW == null || bgW.size() <= 0) {
            return false;
        }
        int size = bgW.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.aAp().a(this.ehi.getPageContext(), bgW.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.bKZ.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.w.s(this.bKZ)) {
            this.mListView.addAdapters(this.bKZ);
        }
        return true;
    }

    public int aLz() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aKb() == null || fVar.aKc() == null || fVar.aKb().size() == 0 || fVar.aJZ() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aKc().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aKb().get(0) == null || fVar.aKb().get(0).bhQ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().qv() != fVar.getPage().qs()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aKb() == null || fVar.aKd() == null || fVar.aKb().size() == 0 || fVar.aJZ() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aKd().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aKb().get(0) == null || fVar.aKb().get(0).bhQ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().qv() != fVar.getPage().qs()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int d(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.af aJW;
        if (fVar == null || fVar.aKb() == null || fVar.aJW() == null || fVar.aKb().size() == 0 || fVar.aJZ() == null || arrayList == null) {
            return -1;
        }
        com.baidu.tieba.tbadkCore.data.p aKf = fVar.aKf();
        com.baidu.tieba.tbadkCore.data.p pVar = (aKf == null && fVar.aKb().get(0) != null && fVar.aKb().get(0).bhQ() == 1) ? fVar.aKb().get(0) : aKf;
        if (pVar == null) {
            return -1;
        }
        if ((pVar.getType() == com.baidu.tieba.tbadkCore.data.p.fpL || pVar.getType() == com.baidu.tieba.tbadkCore.data.p.Sz || pVar.getType() == com.baidu.tieba.tbadkCore.data.p.fpN) && com.baidu.tieba.graffiti.c.ahy()) {
            if (!this.ejH) {
                this.ejH = p(com.baidu.tbadk.core.data.af.TYPE);
            }
            if (this.ejH && (aJW = fVar.aJW()) != null) {
                if (StringUtils.isNull(aJW.getForumId()) || StringUtils.isNull(aJW.getThreadId())) {
                    return -1;
                }
                return z ? 1 : -1;
            }
            return -1;
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<com.baidu.tieba.tbadkCore.data.p> aLA() {
        return this.postList;
    }

    public BdUniqueId os(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.ejz == null || !this.ejz.aKG()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aLB() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        int position;
        if (this.egj != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aKb = this.egj.aKb();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> aKm = this.egj.aKm();
            if (aKm != null) {
                int size = aKm.size();
                if (aKb != null && aKb.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it = aKm.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next = it.next();
                        if (next != null && next.bhG() != null) {
                            sb.append(next.bhG());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = aKm.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                        if (next2 != null) {
                            next2.bPi = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = aKm.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                        if (next3.bhE() != null && next3.bhE().pc() && !com.baidu.tieba.tbadkCore.af.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bhE().apk_name) && (position = next3.getPosition()) >= 2 && position < 30) {
                            sparseArray.put(position, next3);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.o oVar2 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(sparseArray.keyAt(i));
                        if (oVar2 != null) {
                            hashMap.put(oVar2.bhG(), oVar2);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (oVar = (com.baidu.tieba.tbadkCore.data.o) entry.getValue()) != null) {
                            sparseArray.put(oVar.getPosition(), oVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new cw(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = oVar3.getPosition();
                        if (!a(oVar3, aKb)) {
                            if (position2 + i3 < aKb.size()) {
                                if (this.egj.aJY() != null) {
                                    oVar3.forumId = this.egj.aJY().getId();
                                }
                                if (this.egj.aJZ() != null) {
                                    oVar3.threadId = com.baidu.adp.lib.g.b.c(this.egj.aJZ().getId(), 0L);
                                }
                                if (this.egj != null && this.egj.getPage() != null) {
                                    oVar3.pageNumber = this.egj.getPage().qv();
                                }
                                b(oVar3);
                                aKb.add(position2, oVar3);
                                TiebaStatic.eventStat(this.ehi.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", oVar3.bhE().apk_name);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData aJY;
        if (oVar != null && this.egj != null && oVar.bhE() != null) {
            oVar.bhE().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.egj.getPage() != null) {
                oVar.bhE().advertAppContext.pn = this.egj.getPage().qv();
            }
            oVar.bhE().advertAppContext.Oa = "PB";
            if (this.egj.aJY() != null && (aJY = this.egj.aJY()) != null) {
                oVar.bhE().advertAppContext.fid = aJY.getId();
                oVar.bhE().advertAppContext.Oc = aJY.getFirst_class();
                oVar.bhE().advertAppContext.Od = aJY.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.bhE().advertAppContext.Oe = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.bhE().advertAppContext.extensionInfo = oVar.bhE().ext_info;
            oVar.bhE().advertAppContext.Of = false;
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.o oVar, ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList) {
        int r = com.baidu.tbadk.core.util.w.r(arrayList);
        if (oVar == null || r <= 0) {
            return false;
        }
        int position = oVar.getPosition();
        if (r >= 2 || position != r + 1) {
            return false;
        }
        if (this.egj != null && this.egj.getPage() != null) {
            oVar.pageNumber = this.egj.getPage().qv();
        }
        arrayList.add(oVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.ejA.setFromCDN(z);
        this.ejs.setFromCDN(z);
        if (this.bOE != null && (this.bOE instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.bOE).setIsFromCDN(z);
        }
        if (this.bOF != null && (this.bOF instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.bOF).setIsFromCDN(z);
        }
        if (this.bOG != null && (this.bOG instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.bOG).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ejD.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void ii(boolean z) {
        this.cAg = z;
    }

    public void ij(boolean z) {
        this.egi = z;
    }

    public void ik(boolean z) {
        this.ejF = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.egm = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aHX = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.egn = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anA = onLongClickListener;
    }

    public void w(View.OnClickListener onClickListener) {
        this.cpK = onClickListener;
    }

    public boolean p(BdUniqueId bdUniqueId) {
        if (this.mListView == null || bdUniqueId == null || com.baidu.tbadk.core.util.w.s(this.ejG)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.ejG) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.recapp.l aLC() {
        return (com.baidu.tieba.recapp.l) this.bOE;
    }

    public com.baidu.tieba.recapp.l aLD() {
        return (com.baidu.tieba.recapp.l) this.bOF;
    }

    public void ot(int i) {
        switch (i) {
            case 1:
                if (this.ejz != null) {
                    this.ejz.pause();
                }
                if (this.ejw != null && (this.ejw instanceof com.baidu.tieba.recapp.o)) {
                    ((com.baidu.tieba.recapp.o) this.ejw).release();
                    return;
                }
                return;
            case 2:
                if (this.ejz != null) {
                    this.ejz.resume();
                }
                if (this.ejw != null && (this.ejw instanceof com.baidu.tieba.recapp.o)) {
                    ((com.baidu.tieba.recapp.o) this.ejw).resume();
                    return;
                }
                return;
            case 3:
                if (this.ejz != null) {
                    this.ejz.release();
                }
                if (this.ejw != null && (this.ejw instanceof com.baidu.tieba.recapp.o)) {
                    ((com.baidu.tieba.recapp.o) this.ejw).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cu(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof com.baidu.tieba.tbadkCore.data.p) {
                    com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) list.get(i);
                    if (!TextUtils.isEmpty(pVar.sq())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.co(pVar.sq());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }
}
