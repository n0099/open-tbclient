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
public class cp {
    private List<com.baidu.adp.widget.ListView.a> bSf;
    private com.baidu.adp.widget.ListView.a bVL;
    private com.baidu.adp.widget.ListView.a bVM;
    private com.baidu.adp.widget.ListView.a bVN;
    private com.baidu.adp.widget.ListView.a bVO;
    private int eiZ;
    private com.baidu.tieba.pb.data.f ejb;
    private PbActivity eka;
    private dy emk;
    private com.baidu.tieba.pb.video.r eml;
    private com.baidu.tieba.pb.video.t emm;
    private int emn;
    private com.baidu.adp.widget.ListView.a emo;
    private eh emp;
    private eo emq;
    private com.baidu.tieba.pb.pb.a.b emr;
    private com.baidu.tieba.pb.pb.a.h ems;
    private df emt;
    private dx emu;
    private com.baidu.tieba.pb.pb.a.c emv;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> emw = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cBC = true;
    private boolean emx = true;
    private boolean eja = true;
    private boolean emy = false;
    private String mHostId = null;
    private View.OnClickListener eje = null;
    private View.OnClickListener crj = null;
    private TbRichTextView.e aNu = null;
    private com.baidu.tieba.pb.a.d ejf = null;
    private View.OnLongClickListener asV = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> emz = new ArrayList();
    private boolean emA = false;
    private CustomMessageListener bSm = new cq(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bNQ = new cr(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bSn = new ct(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public cp(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.eiZ = 0;
        this.width = -1;
        this.eiZ = com.baidu.adp.lib.util.k.ag(pbActivity.getPageContext().getPageActivity());
        this.width = this.eiZ;
        this.eka = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bNQ);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ems = new com.baidu.tieba.pb.pb.a.h(pbActivity, PostData.fui);
        this.emk = new dy(pbActivity, PostData.fug);
        this.emk.a(pbActivity);
        this.bVL = com.baidu.tieba.recapp.r.aZD().c(pbActivity, AdvertAppInfo.Tp);
        this.bVM = com.baidu.tieba.recapp.r.aZD().c(pbActivity, AdvertAppInfo.Tq);
        this.bVN = com.baidu.tieba.recapp.r.aZD().c(pbActivity, AdvertAppInfo.Tr);
        this.emo = com.baidu.tieba.recapp.r.aZD().c(pbActivity, AdvertAppInfo.Ts);
        this.bVO = com.baidu.tieba.recapp.r.aZD().c(pbActivity, AdvertAppInfo.Tw);
        this.emt = new df(pbActivity, com.baidu.tieba.pb.data.a.ehA);
        this.emu = new dx(pbActivity, com.baidu.tieba.pb.data.i.eim);
        this.emp = new eh(pbActivity, dw.eoQ);
        this.emq = new eo(pbActivity, com.baidu.tbadk.core.data.at.WR);
        this.eml = new com.baidu.tieba.pb.video.r(pbActivity, com.baidu.tieba.pb.video.s.ewW);
        this.emm = new com.baidu.tieba.pb.video.t(pbActivity, com.baidu.tieba.pb.video.u.exf);
        this.emm.setOnClickListener(new cu(this));
        this.emv = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.UI);
        this.mAdapters.add(this.emk);
        this.mAdapters.add(this.ems);
        this.mAdapters.add(this.bVL);
        this.mAdapters.add(this.bVM);
        this.mAdapters.add(this.bVN);
        this.mAdapters.add(this.emo);
        this.mAdapters.add(this.bVO);
        this.mAdapters.add(this.emt);
        this.mAdapters.add(this.emu);
        this.mAdapters.add(this.emp);
        this.mAdapters.add(this.emq);
        this.mAdapters.add(this.eml);
        this.mAdapters.add(this.emm);
        this.mAdapters.add(this.emv);
        this.bSm.setPriority(1);
        this.bSm.setSelfListener(true);
        pbActivity.registerListener(this.bSm);
        aaP();
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
        if (this.ejb != fVar) {
            z = (fVar == null || fVar.aJm()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.ejb = fVar;
        if (z) {
            aKW();
            if (fVar != null) {
                fVar.ia(false);
            }
        }
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }
        this.postList.clear();
        if (this.ejb != null && this.ejb.aJs() != null && this.ejb.aJs().size() > 0) {
            this.postList.addAll(this.ejb.aJs());
        }
        if (fVar != null && fVar.aJq() != null && fVar.aJq().getAuthor() != null) {
            this.mHostId = fVar.aJq().getAuthor().getUserId();
        }
        if (this.emk != null) {
            this.ems.b(fVar);
            this.ems.setFromCDN(this.mIsFromCDN);
            this.ems.setHostId(this.mHostId);
            this.ems.oc(this.eiZ);
            this.ems.ib(this.cBC);
            this.ems.ic(this.eja);
            this.ems.setCommonClickListener(this.crj);
            this.ems.G(this.eje);
            this.ems.setOnImageClickListener(this.aNu);
            this.ems.setOnLongClickListener(this.asV);
            this.ems.a(this.ejf);
            this.emk.b(fVar);
            this.emk.setFromCDN(this.mIsFromCDN);
            this.emk.setHostId(this.mHostId);
            this.emk.oc(this.eiZ);
            this.emk.ib(this.cBC);
            this.emk.ic(this.eja);
            this.emk.id(this.emy);
            this.emk.setCommonClickListener(this.crj);
            this.emk.G(this.eje);
            this.emk.setOnImageClickListener(this.aNu);
            this.emk.setOnLongClickListener(this.asV);
            this.emk.a(this.ejf);
            if (this.bVM != null && (this.bVM instanceof com.baidu.tieba.recapp.n)) {
                ((com.baidu.tieba.recapp.n) this.bVM).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bVN != null && (this.bVN instanceof com.baidu.tieba.recapp.n)) {
                ((com.baidu.tieba.recapp.n) this.bVN).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bVO != null && (this.bVO instanceof com.baidu.tieba.recapp.n)) {
                ((com.baidu.tieba.recapp.n) this.bVO).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.emw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(fVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.setHostId(this.mHostId);
                    next.oc(this.eiZ);
                    next.ib(this.cBC);
                    next.ic(this.eja);
                    next.id(this.emy);
                    next.setCommonClickListener(this.crj);
                    next.G(this.eje);
                    next.setOnImageClickListener(this.aNu);
                    next.setOnLongClickListener(this.asV);
                    next.a(this.ejf);
                }
            }
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (fVar.aJs() != null) {
                arrayList.addAll(fVar.aJs());
            }
            cb(arrayList);
            if (!this.eja && fVar != null && fVar.aJs() != null && (size = fVar.aJs().size()) > 0 && (postData2 = fVar.aJs().get(size - 1)) != null && postData2.bhD() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.eka.aKC()) {
                if (fVar.aJs().size() > 0 && (postData = fVar.aJs().get(0)) != null && postData.bhD() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int b = b(this.ejb, arrayList, this.eja);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.x.a(arrayList, b, this.ejb.aJt());
                }
            }
            int c = c(this.ejb, arrayList, this.eja);
            if (c >= 0) {
                com.baidu.tbadk.core.util.x.a(arrayList, c, this.ejb.aJu());
            }
            int a = a(this.ejb, this.eja);
            int i = -1;
            if (a < 0) {
                i = d(this.ejb, arrayList, this.eja);
            }
            int size3 = arrayList.size();
            if (a >= 0) {
                if (size3 == 0 || a >= size3) {
                    arrayList.add(this.ejb.sp());
                } else {
                    arrayList.add(a, this.ejb.sp());
                }
            }
            if (!this.eka.aKC()) {
                if (i < 0) {
                    this.eka.ih(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.ejb.aJn());
                    } else if (i >= size3) {
                        arrayList.add(this.ejb.aJn());
                    } else {
                        arrayList.add(i, this.ejb.aJn());
                    }
                    this.eka.ih(true);
                }
            }
            if (i < 0) {
                this.emk.ih(false);
            } else {
                this.emk.ih(true);
            }
            if (arrayList.size() == 0 && this.eka.aKC()) {
                arrayList.add(new com.baidu.tieba.pb.data.i());
            }
            int a2 = a(fVar, arrayList, this.eja);
            if (a2 >= 0) {
                List<com.baidu.adp.widget.ListView.v> a3 = a(fVar, arrayList);
                if (a3 != null && a3.size() > 0) {
                    com.baidu.tbadk.core.util.x.a((List) arrayList, a2, (List) a3);
                } else {
                    this.emn = 0;
                }
            } else {
                this.emn = 0;
            }
            com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
            if (this.mListView != null) {
                this.mListView.setData(arrayList);
            }
        }
    }

    public void aKT() {
        this.emn = 0;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.x.q(fVar.aJs()) || com.baidu.tbadk.core.util.x.q(fVar.aJr())) {
            return -1;
        }
        if (z) {
            return (fVar.aJs().get(0) == null || fVar.aJs().get(0).bhD() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.v> a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (fVar == null || arrayList == null || fVar.aJr() == null || fVar.aJr().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<com.baidu.tbadk.core.data.bj> aJr = fVar.aJr();
        if (this.emn + 5 >= aJr.size()) {
            int i = 0;
            for (com.baidu.tbadk.core.data.bj bjVar : aJr) {
                if (bjVar != null) {
                    com.baidu.tieba.pb.video.s sVar = new com.baidu.tieba.pb.video.s();
                    i++;
                    if (i == 1) {
                        sVar.a(bjVar, true, true, true, i);
                    } else {
                        sVar.a(bjVar, true, true, false, i);
                    }
                    arrayList2.add(sVar);
                    this.emn++;
                }
            }
            if (this.emn <= 0) {
                return null;
            }
            return arrayList2;
        }
        int i2 = this.emn + 5;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            com.baidu.tbadk.core.data.bj bjVar2 = aJr.get(i4);
            if (bjVar2 != null) {
                com.baidu.tieba.pb.video.s sVar2 = new com.baidu.tieba.pb.video.s();
                i3++;
                boolean z = i3 == 1;
                if (i4 == i2 - 1) {
                    sVar2.a(bjVar2, false, true, z, i3);
                } else {
                    sVar2.a(bjVar2, true, true, z, i3);
                }
                arrayList2.add(sVar2);
                this.emn++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.u());
        return arrayList2;
    }

    private void aaP() {
        if (this.eka != null && !aaQ()) {
            this.eka.registerListener(this.bSn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aaQ() {
        if (this.eka == null) {
            return false;
        }
        this.bSf = new ArrayList();
        ArrayList<BdUniqueId> bgJ = com.baidu.tieba.tbadkCore.t.bgJ();
        if (bgJ == null || bgJ.size() <= 0) {
            return false;
        }
        int size = bgJ.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.azM().a(this.eka.getPageContext(), bgJ.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.bSf.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bSf)) {
            this.mListView.addAdapters(this.bSf);
        }
        return true;
    }

    public int aKU() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aJs() == null || fVar.aJt() == null || fVar.aJs().size() == 0 || fVar.aJq() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aJt().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aJs().get(0) == null || fVar.aJs().get(0).bhD() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().qO() != fVar.getPage().qL()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aJs() == null || fVar.aJu() == null || fVar.aJs().size() == 0 || fVar.aJq() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aJu().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aJs().get(0) == null || fVar.aJs().get(0).bhD() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.getPage() == null || fVar.getPage().qO() != fVar.getPage().qL()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        if (z) {
            if (fVar == null || com.baidu.tbadk.core.util.x.q(fVar.aJs()) || fVar.aJq() == null || fVar.aJq().sp() == null) {
                return -1;
            }
            PostData aJw = fVar.aJw();
            PostData postData = (aJw == null && fVar.aJs().get(0) != null && fVar.aJs().get(0).bhD() == 1) ? fVar.aJs().get(0) : aJw;
            if (postData == null) {
                return -1;
            }
            return (postData.getType() == PostData.fug || postData.getType() == PostData.XM || postData.getType() == PostData.fui) ? 1 : -1;
        }
        return -1;
    }

    public int d(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.ag aJn;
        if (fVar == null || fVar.aJs() == null || fVar.aJn() == null || fVar.aJs().size() == 0 || fVar.aJq() == null || arrayList == null) {
            return -1;
        }
        PostData aJw = fVar.aJw();
        PostData postData = (aJw == null && fVar.aJs().get(0) != null && fVar.aJs().get(0).bhD() == 1) ? fVar.aJs().get(0) : aJw;
        if (postData == null) {
            return -1;
        }
        if ((postData.getType() == PostData.fug || postData.getType() == PostData.XM || postData.getType() == PostData.fui) && com.baidu.tieba.graffiti.c.agJ()) {
            if (!this.emA) {
                this.emA = o(com.baidu.tbadk.core.data.ag.TYPE);
            }
            if (this.emA && (aJn = fVar.aJn()) != null) {
                if (StringUtils.isNull(aJn.getForumId()) || StringUtils.isNull(aJn.getThreadId())) {
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

    public ArrayList<PostData> aKV() {
        return this.postList;
    }

    public BdUniqueId og(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.emr == null || !this.emr.aJY()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aKW() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.ejb != null) {
            ArrayList<PostData> aJs = this.ejb.aJs();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> aJD = this.ejb.aJD();
            if (aJD != null) {
                int size = aJD.size();
                if (aJs != null && aJs.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it = aJD.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next = it.next();
                        if (next != null && next.bht() != null) {
                            sb.append(next.bht());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = aJD.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                        if (next2 != null) {
                            next2.bWq = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = aJD.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                        if (next3.bhr() != null && next3.bhr().pq()) {
                            if (!com.baidu.tieba.tbadkCore.ae.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bhr().apk_name)) {
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
                        if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.bht(), oVar3)) != null) {
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
                    Collections.sort(arrayList, new cv(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        int position2 = oVar4.getPosition();
                        if (a(oVar4, aJs)) {
                            a(oVar4, 100);
                        } else if (position2 + i3 >= aJs.size()) {
                            a(oVar4, 2);
                            return;
                        } else {
                            if (this.ejb.aJp() != null) {
                                oVar4.forumId = this.ejb.aJp().getId();
                            }
                            if (this.ejb.aJq() != null) {
                                oVar4.threadId = com.baidu.adp.lib.g.b.c(this.ejb.aJq().getId(), 0L);
                            }
                            if (this.ejb != null && this.ejb.getPage() != null) {
                                oVar4.pageNumber = this.ejb.getPage().qO();
                            }
                            b(oVar4);
                            aJs.add(position2, oVar4);
                            TiebaStatic.eventStat(this.eka.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", oVar4.bhr().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.o oVar, int i) {
        com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 5);
        b.qS(i);
        com.baidu.tieba.recapp.report.b.aZQ().a(b);
    }

    private void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData aJp;
        if (oVar != null && this.ejb != null && oVar.bhr() != null) {
            oVar.bhr().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.ejb.getPage() != null) {
                oVar.bhr().advertAppContext.pn = this.ejb.getPage().qO();
            }
            oVar.bhr().advertAppContext.Te = "PB";
            if (this.ejb.aJp() != null && (aJp = this.ejb.aJp()) != null) {
                oVar.bhr().advertAppContext.fid = aJp.getId();
                oVar.bhr().advertAppContext.Tg = aJp.getFirst_class();
                oVar.bhr().advertAppContext.Th = aJp.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.bhr().advertAppContext.Ti = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.bhr().advertAppContext.extensionInfo = oVar.bhr().ext_info;
            oVar.bhr().advertAppContext.Tj = false;
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
        if (this.ejb != null && this.ejb.getPage() != null) {
            oVar.pageNumber = this.ejb.getPage().qO();
        }
        arrayList.add(oVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.ems.setFromCDN(z);
        this.emk.setFromCDN(z);
        if (this.bVM != null && (this.bVM instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.bVM).setIsFromCDN(z);
        }
        if (this.bVN != null && (this.bVN instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.bVN).setIsFromCDN(z);
        }
        if (this.bVO != null && (this.bVO instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.bVO).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.emw.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void ib(boolean z) {
        this.cBC = z;
    }

    public void ic(boolean z) {
        this.eja = z;
    }

    public void id(boolean z) {
        this.emy = z;
    }

    public void G(View.OnClickListener onClickListener) {
        this.eje = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNu = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ejf = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.asV = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.crj = onClickListener;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (this.mListView == null || bdUniqueId == null || com.baidu.tbadk.core.util.x.q(this.emz)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.emz) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.recapp.n aKX() {
        return (com.baidu.tieba.recapp.n) this.bVM;
    }

    public com.baidu.tieba.recapp.n aKY() {
        return (com.baidu.tieba.recapp.n) this.bVN;
    }

    public void oh(int i) {
        switch (i) {
            case 1:
                if (this.emr != null) {
                    this.emr.pause();
                }
                if (this.emo != null && (this.emo instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.emo).release();
                    return;
                }
                return;
            case 2:
                if (this.emr != null) {
                    this.emr.resume();
                }
                if (this.emo != null && (this.emo instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.emo).resume();
                    return;
                }
                return;
            case 3:
                if (this.emr != null) {
                    this.emr.release();
                }
                if (this.emo != null && (this.emo instanceof com.baidu.tieba.recapp.q)) {
                    ((com.baidu.tieba.recapp.q) this.emo).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cb(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sL())) {
                        com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
                        aiVar.ch(postData.sL());
                        list.set(i, aiVar);
                    }
                }
            }
        }
    }
}
