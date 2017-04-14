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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class cn {
    private List<com.baidu.adp.widget.ListView.a> bRT;
    private com.baidu.adp.widget.ListView.a bVA;
    private com.baidu.adp.widget.ListView.a bVB;
    private com.baidu.adp.widget.ListView.a bVC;
    private com.baidu.adp.widget.ListView.a bVz;
    private int ehf;
    private com.baidu.tieba.pb.data.f ehh;
    private PbActivity eig;
    private dd ekA;
    private dv ekB;
    private com.baidu.tieba.pb.pb.a.c ekC;
    private dw ekr;
    private com.baidu.tieba.pb.video.r eks;
    private com.baidu.tieba.pb.video.t ekt;
    private int eku;
    private com.baidu.adp.widget.ListView.a ekv;
    private ef ekw;
    private em ekx;
    private com.baidu.tieba.pb.pb.a.b eky;
    private com.baidu.tieba.pb.pb.a.h ekz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> ekD = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cAb = true;
    private boolean ekE = true;
    private boolean ehg = true;
    private boolean ekF = false;
    private String mHostId = null;
    private View.OnClickListener ehk = null;
    private View.OnClickListener cpI = null;
    private TbRichTextView.e aNK = null;
    private com.baidu.tieba.pb.a.d ehl = null;
    private View.OnLongClickListener atl = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> ekG = new ArrayList();
    private boolean ekH = false;
    private CustomMessageListener bSa = new co(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bNF = new cp(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bSb = new cr(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public cn(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ehf = 0;
        this.width = -1;
        this.ehf = com.baidu.adp.lib.util.k.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.ehf;
        this.eig = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bNF);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ekz = new com.baidu.tieba.pb.pb.a.h(pbActivity, PostData.fvR);
        this.ekr = new dw(pbActivity, PostData.fvP);
        this.ekr.a(pbActivity);
        this.bVz = com.baidu.tieba.recapp.v.aZP().c(pbActivity, AdvertAppInfo.TH);
        this.bVA = com.baidu.tieba.recapp.v.aZP().c(pbActivity, AdvertAppInfo.TI);
        this.bVB = com.baidu.tieba.recapp.v.aZP().c(pbActivity, AdvertAppInfo.TJ);
        this.ekv = com.baidu.tieba.recapp.v.aZP().c(pbActivity, AdvertAppInfo.TK);
        this.bVC = com.baidu.tieba.recapp.v.aZP().c(pbActivity, AdvertAppInfo.TP);
        this.ekA = new dd(pbActivity, com.baidu.tieba.pb.data.a.efH);
        this.ekB = new dv(pbActivity, com.baidu.tieba.pb.data.i.egt);
        this.ekw = new ef(pbActivity, du.emX);
        this.ekx = new em(pbActivity, com.baidu.tbadk.core.data.as.Xg);
        this.eks = new com.baidu.tieba.pb.video.r(pbActivity, com.baidu.tieba.pb.video.s.evc);
        this.ekt = new com.baidu.tieba.pb.video.t(pbActivity, com.baidu.tieba.pb.video.u.evl);
        this.ekt.setOnClickListener(new cs(this));
        this.ekC = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Vc);
        this.mAdapters.add(this.ekr);
        this.mAdapters.add(this.ekz);
        this.mAdapters.add(this.bVz);
        this.mAdapters.add(this.bVA);
        this.mAdapters.add(this.bVB);
        this.mAdapters.add(this.ekv);
        this.mAdapters.add(this.bVC);
        this.mAdapters.add(this.ekA);
        this.mAdapters.add(this.ekB);
        this.mAdapters.add(this.ekw);
        this.mAdapters.add(this.ekx);
        this.mAdapters.add(this.eks);
        this.mAdapters.add(this.ekt);
        this.mAdapters.add(this.ekC);
        this.bSa.setPriority(1);
        this.bSa.setSelfListener(true);
        pbActivity.registerListener(this.bSa);
        abn();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        boolean z;
        PostData postData;
        int size;
        PostData postData2;
        int size2;
        if (this.ehh != fVar) {
            z = (fVar == null || fVar.aJt()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.ehh = fVar;
        if (z) {
            aLe();
            if (fVar != null) {
                fVar.hZ(false);
            }
        }
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }
        this.postList.clear();
        if (this.ehh != null && this.ehh.aJz() != null && this.ehh.aJz().size() > 0) {
            this.postList.addAll(this.ehh.aJz());
        }
        if (fVar != null && fVar.aJx() != null && fVar.aJx().getAuthor() != null) {
            this.mHostId = fVar.aJx().getAuthor().getUserId();
        }
        if (this.ekr != null) {
            this.ekz.b(fVar);
            this.ekz.setFromCDN(this.mIsFromCDN);
            this.ekz.setHostId(this.mHostId);
            this.ekz.oa(this.ehf);
            this.ekz.ia(this.cAb);
            this.ekz.ib(this.ehg);
            this.ekz.setCommonClickListener(this.cpI);
            this.ekz.H(this.ehk);
            this.ekz.setOnImageClickListener(this.aNK);
            this.ekz.setOnLongClickListener(this.atl);
            this.ekz.a(this.ehl);
            this.ekr.b(fVar);
            this.ekr.setFromCDN(this.mIsFromCDN);
            this.ekr.setHostId(this.mHostId);
            this.ekr.oa(this.ehf);
            this.ekr.ia(this.cAb);
            this.ekr.ib(this.ehg);
            this.ekr.ic(this.ekF);
            this.ekr.setCommonClickListener(this.cpI);
            this.ekr.H(this.ehk);
            this.ekr.setOnImageClickListener(this.aNK);
            this.ekr.setOnLongClickListener(this.atl);
            this.ekr.a(this.ehl);
            if (this.bVA != null && (this.bVA instanceof com.baidu.tieba.recapp.r)) {
                ((com.baidu.tieba.recapp.r) this.bVA).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bVB != null && (this.bVB instanceof com.baidu.tieba.recapp.r)) {
                ((com.baidu.tieba.recapp.r) this.bVB).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bVC != null && (this.bVC instanceof com.baidu.tieba.recapp.r)) {
                ((com.baidu.tieba.recapp.r) this.bVC).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ekD.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(fVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.setHostId(this.mHostId);
                    next.oa(this.ehf);
                    next.ia(this.cAb);
                    next.ib(this.ehg);
                    next.ic(this.ekF);
                    next.setCommonClickListener(this.cpI);
                    next.H(this.ehk);
                    next.setOnImageClickListener(this.aNK);
                    next.setOnLongClickListener(this.atl);
                    next.a(this.ehl);
                }
            }
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (fVar.aJz() != null) {
                arrayList.addAll(fVar.aJz());
            }
            ca(arrayList);
            if (!this.ehg && fVar != null && fVar.aJz() != null && (size = fVar.aJz().size()) > 0 && (postData2 = fVar.aJz().get(size - 1)) != null && postData2.bio() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.eig.aKI()) {
                if (fVar.aJz().size() > 0 && (postData = fVar.aJz().get(0)) != null && postData.bio() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int b = b(this.ehh, arrayList, this.ehg);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.x.a(arrayList, b, this.ehh.aJA());
                }
            }
            int c = c(this.ehh, arrayList, this.ehg);
            if (c >= 0) {
                com.baidu.tbadk.core.util.x.a(arrayList, c, this.ehh.aJB());
            }
            int a = a(this.ehh, this.ehg);
            int i = -1;
            if (a < 0) {
                i = d(this.ehh, arrayList, this.ehg);
            }
            int size3 = arrayList.size();
            if (a >= 0) {
                if (size3 == 0 || a >= size3) {
                    arrayList.add(this.ehh.sN());
                } else {
                    arrayList.add(a, this.ehh.sN());
                }
            }
            if (!this.eig.aKI()) {
                if (i < 0) {
                    this.eig.ig(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.ehh.aJu());
                    } else if (i >= size3) {
                        arrayList.add(this.ehh.aJu());
                    } else {
                        arrayList.add(i, this.ehh.aJu());
                    }
                    this.eig.ig(true);
                }
            }
            if (i < 0) {
                this.ekr.ig(false);
            } else {
                this.ekr.ig(true);
            }
            if (arrayList.size() == 0 && this.eig.aKI()) {
                arrayList.add(new com.baidu.tieba.pb.data.i());
            }
            int a2 = a(fVar, arrayList, this.ehg);
            if (a2 >= 0) {
                List<com.baidu.adp.widget.ListView.v> a3 = a(fVar, arrayList);
                if (a3 != null && a3.size() > 0) {
                    com.baidu.tbadk.core.util.x.a((List) arrayList, a2, (List) a3);
                } else {
                    this.eku = 0;
                }
            } else {
                this.eku = 0;
            }
            com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
            if (this.mListView != null) {
                this.mListView.setData(arrayList);
            }
        }
    }

    public void aLb() {
        this.eku = 0;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.x.q(fVar.aJz()) || com.baidu.tbadk.core.util.x.q(fVar.aJy())) {
            return -1;
        }
        if (z) {
            return (fVar.aJz().get(0) == null || fVar.aJz().get(0).bio() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.v> a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (fVar == null || arrayList == null || fVar.aJy() == null || fVar.aJy().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<com.baidu.tbadk.core.data.bi> aJy = fVar.aJy();
        if (this.eku + 5 >= aJy.size()) {
            int i = 0;
            for (com.baidu.tbadk.core.data.bi biVar : aJy) {
                if (biVar != null) {
                    com.baidu.tieba.pb.video.s sVar = new com.baidu.tieba.pb.video.s();
                    i++;
                    if (i == 1) {
                        sVar.a(biVar, true, true, true, i);
                    } else {
                        sVar.a(biVar, true, true, false, i);
                    }
                    arrayList2.add(sVar);
                    this.eku++;
                }
            }
            if (this.eku <= 0) {
                return null;
            }
            return arrayList2;
        }
        int i2 = this.eku + 5;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            com.baidu.tbadk.core.data.bi biVar2 = aJy.get(i4);
            if (biVar2 != null) {
                com.baidu.tieba.pb.video.s sVar2 = new com.baidu.tieba.pb.video.s();
                i3++;
                boolean z = i3 == 1;
                if (i4 == i2 - 1) {
                    sVar2.a(biVar2, false, true, z, i3);
                } else {
                    sVar2.a(biVar2, true, true, z, i3);
                }
                arrayList2.add(sVar2);
                this.eku++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.u());
        return arrayList2;
    }

    private void abn() {
        if (this.eig != null && !abo()) {
            this.eig.registerListener(this.bSb);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean abo() {
        if (this.eig == null) {
            return false;
        }
        this.bRT = new ArrayList();
        ArrayList<BdUniqueId> bhu = com.baidu.tieba.tbadkCore.t.bhu();
        if (bhu == null || bhu.size() <= 0) {
            return false;
        }
        int size = bhu.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.azs().a(this.eig.getPageContext(), bhu.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.bRT.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bRT)) {
            this.mListView.addAdapters(this.bRT);
        }
        return true;
    }

    public int aLc() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aJz() == null || fVar.aJA() == null || fVar.aJz().size() == 0 || fVar.aJx() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aJA().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aJz().get(0) == null || fVar.aJz().get(0).bio() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.rr() == null || fVar.rr().rl() != fVar.rr().ri()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aJz() == null || fVar.aJB() == null || fVar.aJz().size() == 0 || fVar.aJx() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aJB().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aJz().get(0) == null || fVar.aJz().get(0).bio() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.rr() == null || fVar.rr().rl() != fVar.rr().ri()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (z) {
            if (fVar == null || com.baidu.tbadk.core.util.x.q(fVar.aJz()) || fVar.aJx() == null || fVar.aJx().sN() == null) {
                return -1;
            }
            PostData aJD = fVar.aJD();
            PostData postData = (aJD == null && fVar.aJz().get(0) != null && fVar.aJz().get(0).bio() == 1) ? fVar.aJz().get(0) : aJD;
            if (postData == null) {
                return -1;
            }
            return (postData.getType() == PostData.fvP || postData.getType() == PostData.Yc || postData.getType() == PostData.fvR) ? 1 : -1;
        }
        return -1;
    }

    public int d(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.af aJu;
        if (fVar == null || fVar.aJz() == null || fVar.aJu() == null || fVar.aJz().size() == 0 || fVar.aJx() == null || arrayList == null) {
            return -1;
        }
        PostData aJD = fVar.aJD();
        PostData postData = (aJD == null && fVar.aJz().get(0) != null && fVar.aJz().get(0).bio() == 1) ? fVar.aJz().get(0) : aJD;
        if (postData == null) {
            return -1;
        }
        if ((postData.getType() == PostData.fvP || postData.getType() == PostData.Yc || postData.getType() == PostData.fvR) && com.baidu.tieba.graffiti.c.agD()) {
            if (!this.ekH) {
                this.ekH = o(com.baidu.tbadk.core.data.af.TYPE);
            }
            if (this.ekH && (aJu = fVar.aJu()) != null) {
                if (StringUtils.isNull(aJu.getForumId()) || StringUtils.isNull(aJu.getThreadId())) {
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

    public ArrayList<PostData> aLd() {
        return this.postList;
    }

    public BdUniqueId oe(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.eky == null || !this.eky.aKf()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aLe() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.ehh != null) {
            ArrayList<PostData> aJz = this.ehh.aJz();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> aJK = this.ehh.aJK();
            if (aJK != null) {
                int size = aJK.size();
                if (aJz != null && aJz.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it = aJK.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next = it.next();
                        if (next != null && next.bie() != null) {
                            sb.append(next.bie());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = aJK.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                        if (next2 != null) {
                            next2.bWe = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = aJK.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                        if (next3.bic() != null && next3.bic().pO()) {
                            if (!com.baidu.tieba.tbadkCore.ae.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bic().apk_name)) {
                                int position = next3.getPosition();
                                if (position >= 2 && position < 30) {
                                    sparseArray.put(position, next3);
                                } else {
                                    a(next3, 100);
                                }
                            } else {
                                a(next3, 3);
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(sparseArray.keyAt(i));
                        if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.bie(), oVar3)) != null) {
                            a(oVar2, 100);
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
                    Collections.sort(arrayList, new ct(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = oVar4.getPosition();
                        if (a(oVar4, aJz)) {
                            a(oVar4, 100);
                        } else if (position2 + i3 >= aJz.size()) {
                            a(oVar4, 2);
                            return;
                        } else {
                            if (this.ehh.aJw() != null) {
                                oVar4.forumId = this.ehh.aJw().getId();
                            }
                            if (this.ehh.aJx() != null) {
                                oVar4.threadId = com.baidu.adp.lib.g.b.c(this.ehh.aJx().getId(), 0L);
                            }
                            if (this.ehh != null && this.ehh.rr() != null) {
                                oVar4.pageNumber = this.ehh.rr().rl();
                            }
                            b(oVar4);
                            aJz.add(position2, oVar4);
                            TiebaStatic.eventStat(this.eig.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", oVar4.bic().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.o oVar, int i) {
        com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 5);
        b.qQ(i);
        com.baidu.tieba.recapp.report.b.baz().a(b);
    }

    private void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData aJw;
        if (oVar != null && this.ehh != null && oVar.bic() != null) {
            oVar.bic().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.ehh.rr() != null) {
                oVar.bic().advertAppContext.pn = this.ehh.rr().rl();
            }
            oVar.bic().advertAppContext.Tw = "PB";
            if (this.ehh.aJw() != null && (aJw = this.ehh.aJw()) != null) {
                oVar.bic().advertAppContext.fid = aJw.getId();
                oVar.bic().advertAppContext.Ty = aJw.getFirst_class();
                oVar.bic().advertAppContext.Tz = aJw.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.bic().advertAppContext.TA = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.bic().advertAppContext.extensionInfo = oVar.bic().ext_info;
            oVar.bic().advertAppContext.TB = false;
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.o oVar, ArrayList<PostData> arrayList) {
        int p = com.baidu.tbadk.core.util.x.p(arrayList);
        if (oVar == null || p <= 0) {
            return false;
        }
        int position = oVar.getPosition();
        if (p >= 2 || position != p + 1) {
            return false;
        }
        if (this.ehh != null && this.ehh.rr() != null) {
            oVar.pageNumber = this.ehh.rr().rl();
        }
        arrayList.add(oVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.ekz.setFromCDN(z);
        this.ekr.setFromCDN(z);
        if (this.bVA != null && (this.bVA instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.bVA).setIsFromCDN(z);
        }
        if (this.bVB != null && (this.bVB instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.bVB).setIsFromCDN(z);
        }
        if (this.bVC != null && (this.bVC instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.bVC).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ekD.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void ia(boolean z) {
        this.cAb = z;
    }

    public void ib(boolean z) {
        this.ehg = z;
    }

    public void ic(boolean z) {
        this.ekF = z;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ehk = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNK = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ehl = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atl = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.cpI = onClickListener;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (this.mListView == null || bdUniqueId == null || com.baidu.tbadk.core.util.x.q(this.ekG)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.ekG) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.recapp.r aLf() {
        return (com.baidu.tieba.recapp.r) this.bVA;
    }

    public com.baidu.tieba.recapp.r aLg() {
        return (com.baidu.tieba.recapp.r) this.bVB;
    }

    public void of(int i) {
        switch (i) {
            case 1:
                if (this.eky != null) {
                    this.eky.pause();
                }
                if (this.ekv != null && (this.ekv instanceof com.baidu.tieba.recapp.u)) {
                    ((com.baidu.tieba.recapp.u) this.ekv).release();
                    return;
                }
                return;
            case 2:
                if (this.eky != null) {
                    this.eky.resume();
                }
                if (this.ekv != null && (this.ekv instanceof com.baidu.tieba.recapp.u)) {
                    ((com.baidu.tieba.recapp.u) this.ekv).resume();
                    return;
                }
                return;
            case 3:
                if (this.eky != null) {
                    this.eky.release();
                }
                if (this.ekv != null && (this.ekv instanceof com.baidu.tieba.recapp.u)) {
                    ((com.baidu.tieba.recapp.u) this.ekv).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void ca(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.tj())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.co(postData.tj());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }
}
