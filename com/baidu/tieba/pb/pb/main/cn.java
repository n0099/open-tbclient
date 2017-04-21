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
    private List<com.baidu.adp.widget.ListView.a> bUk;
    private com.baidu.adp.widget.ListView.a bXQ;
    private com.baidu.adp.widget.ListView.a bXR;
    private com.baidu.adp.widget.ListView.a bXS;
    private com.baidu.adp.widget.ListView.a bXT;
    private int ejv;
    private com.baidu.tieba.pb.data.f ejx;
    private PbActivity ekw;
    private dw emH;
    private com.baidu.tieba.pb.video.r emI;
    private com.baidu.tieba.pb.video.t emJ;
    private int emK;
    private com.baidu.adp.widget.ListView.a emM;
    private ef emN;
    private em emO;
    private com.baidu.tieba.pb.pb.a.b emP;
    private com.baidu.tieba.pb.pb.a.h emQ;
    private dd emR;
    private dv emS;
    private com.baidu.tieba.pb.pb.a.c emT;
    private BdTypeListView mListView;
    private int width;
    private int emL = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> emU = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean cCs = true;
    private boolean emV = true;
    private boolean ejw = true;
    private boolean emW = false;
    private String mHostId = null;
    private View.OnClickListener ejA = null;
    private View.OnClickListener csa = null;
    private TbRichTextView.e aNM = null;
    private com.baidu.tieba.pb.a.d ejB = null;
    private View.OnLongClickListener atn = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> emX = new ArrayList();
    private boolean emY = false;
    private CustomMessageListener bUr = new co(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bPW = new cp(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bUs = new cr(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public cn(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ejv = 0;
        this.width = -1;
        this.ejv = com.baidu.adp.lib.util.k.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.ejv;
        this.ekw = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bPW);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.emQ = new com.baidu.tieba.pb.pb.a.h(pbActivity, PostData.fyi);
        this.emH = new dw(pbActivity, PostData.fyg);
        this.emH.a(pbActivity);
        this.bXQ = com.baidu.tieba.recapp.v.baQ().c(pbActivity, AdvertAppInfo.TJ);
        this.bXR = com.baidu.tieba.recapp.v.baQ().c(pbActivity, AdvertAppInfo.TK);
        this.bXS = com.baidu.tieba.recapp.v.baQ().c(pbActivity, AdvertAppInfo.TL);
        this.emM = com.baidu.tieba.recapp.v.baQ().c(pbActivity, AdvertAppInfo.TM);
        this.bXT = com.baidu.tieba.recapp.v.baQ().c(pbActivity, AdvertAppInfo.TR);
        this.emR = new dd(pbActivity, com.baidu.tieba.pb.data.a.ehX);
        this.emS = new dv(pbActivity, com.baidu.tieba.pb.data.i.eiJ);
        this.emN = new ef(pbActivity, du.epq);
        this.emO = new em(pbActivity, com.baidu.tbadk.core.data.as.Xh);
        this.emI = new com.baidu.tieba.pb.video.r(pbActivity, com.baidu.tieba.pb.video.s.exs);
        this.emJ = new com.baidu.tieba.pb.video.t(pbActivity, com.baidu.tieba.pb.video.u.exC);
        this.emJ.setOnClickListener(new cs(this));
        this.emT = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Ve);
        this.mAdapters.add(this.emH);
        this.mAdapters.add(this.emQ);
        this.mAdapters.add(this.bXQ);
        this.mAdapters.add(this.bXR);
        this.mAdapters.add(this.bXS);
        this.mAdapters.add(this.emM);
        this.mAdapters.add(this.bXT);
        this.mAdapters.add(this.emR);
        this.mAdapters.add(this.emS);
        this.mAdapters.add(this.emN);
        this.mAdapters.add(this.emO);
        this.mAdapters.add(this.emI);
        this.mAdapters.add(this.emJ);
        this.mAdapters.add(this.emT);
        this.bUr.setPriority(1);
        this.bUr.setSelfListener(true);
        pbActivity.registerListener(this.bUr);
        aco();
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
        if (this.ejx != fVar) {
            z = (fVar == null || fVar.aKu()) && TbadkCoreApplication.m9getInst().isRecAppExist();
        } else {
            z = false;
        }
        this.ejx = fVar;
        if (z) {
            aMf();
            if (fVar != null) {
                fVar.ij(false);
            }
        }
        if (this.postList == null) {
            this.postList = new ArrayList<>();
        }
        this.postList.clear();
        if (this.ejx != null && this.ejx.aKA() != null && this.ejx.aKA().size() > 0) {
            this.postList.addAll(this.ejx.aKA());
        }
        if (fVar != null && fVar.aKy() != null && fVar.aKy().getAuthor() != null) {
            this.mHostId = fVar.aKy().getAuthor().getUserId();
        }
        if (this.emH != null) {
            this.emQ.b(fVar);
            this.emQ.setFromCDN(this.mIsFromCDN);
            this.emQ.setHostId(this.mHostId);
            this.emQ.og(this.ejv);
            this.emQ.ik(this.cCs);
            this.emQ.il(this.ejw);
            this.emQ.setCommonClickListener(this.csa);
            this.emQ.H(this.ejA);
            this.emQ.setOnImageClickListener(this.aNM);
            this.emQ.setOnLongClickListener(this.atn);
            this.emQ.a(this.ejB);
            this.emH.b(fVar);
            this.emH.setFromCDN(this.mIsFromCDN);
            this.emH.setHostId(this.mHostId);
            this.emH.og(this.ejv);
            this.emH.ik(this.cCs);
            this.emH.il(this.ejw);
            this.emH.im(this.emW);
            this.emH.setCommonClickListener(this.csa);
            this.emH.H(this.ejA);
            this.emH.setOnImageClickListener(this.aNM);
            this.emH.setOnLongClickListener(this.atn);
            this.emH.a(this.ejB);
            if (this.bXR != null && (this.bXR instanceof com.baidu.tieba.recapp.r)) {
                ((com.baidu.tieba.recapp.r) this.bXR).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bXS != null && (this.bXS instanceof com.baidu.tieba.recapp.r)) {
                ((com.baidu.tieba.recapp.r) this.bXS).setIsFromCDN(this.mIsFromCDN);
            }
            if (this.bXT != null && (this.bXT instanceof com.baidu.tieba.recapp.r)) {
                ((com.baidu.tieba.recapp.r) this.bXT).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<com.baidu.tieba.pb.pb.a.a> it = this.emU.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.pb.pb.a.a next = it.next();
                if (next != null) {
                    next.b(fVar);
                    next.setFromCDN(this.mIsFromCDN);
                    next.setHostId(this.mHostId);
                    next.og(this.ejv);
                    next.ik(this.cCs);
                    next.il(this.ejw);
                    next.im(this.emW);
                    next.setCommonClickListener(this.csa);
                    next.H(this.ejA);
                    next.setOnImageClickListener(this.aNM);
                    next.setOnLongClickListener(this.atn);
                    next.a(this.ejB);
                }
            }
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
            if (fVar.aKA() != null) {
                arrayList.addAll(fVar.aKA());
            }
            cb(arrayList);
            if (!this.ejw && fVar != null && fVar.aKA() != null && (size = fVar.aKA().size()) > 0 && (postData2 = fVar.aKA().get(size - 1)) != null && postData2.bjp() == 1 && (size2 = arrayList.size()) > 0) {
                arrayList.remove(size2 - 1);
            }
            if (this.ekw.aLI()) {
                if (fVar.aKA().size() > 0 && (postData = fVar.aKA().get(0)) != null && postData.bjp() == 1) {
                    arrayList.remove(0);
                }
            } else {
                int b = b(this.ejx, arrayList, this.ejw);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.x.a(arrayList, b, this.ejx.aKB());
                }
            }
            int c = c(this.ejx, arrayList, this.ejw);
            if (c >= 0) {
                com.baidu.tbadk.core.util.x.a(arrayList, c, this.ejx.aKC());
            }
            int a = a(this.ejx, this.ejw);
            int i = -1;
            if (a < 0) {
                i = d(this.ejx, arrayList, this.ejw);
            }
            int size3 = arrayList.size();
            if (a >= 0) {
                if (size3 == 0 || a >= size3) {
                    arrayList.add(this.ejx.sN());
                } else {
                    arrayList.add(a, this.ejx.sN());
                }
            }
            if (!this.ekw.aLI()) {
                if (i < 0) {
                    this.ekw.iq(false);
                } else {
                    if (size3 == 0) {
                        arrayList.add(this.ejx.aKv());
                    } else if (i >= size3) {
                        arrayList.add(this.ejx.aKv());
                    } else {
                        arrayList.add(i, this.ejx.aKv());
                    }
                    this.ekw.iq(true);
                }
            }
            if (i < 0) {
                this.emH.iq(false);
            } else {
                this.emH.iq(true);
            }
            if (arrayList.size() == 0 && this.ekw.aLI()) {
                arrayList.add(new com.baidu.tieba.pb.data.i());
            }
            int a2 = a(fVar, arrayList, this.ejw);
            if (a2 >= 0) {
                List<com.baidu.adp.widget.ListView.v> a3 = a(fVar, arrayList);
                if (a3 != null && a3.size() > 0) {
                    com.baidu.tbadk.core.util.x.a((List) arrayList, a2, (List) a3);
                } else {
                    this.emK = 0;
                }
            } else {
                this.emK = 0;
            }
            com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
            if (this.mListView != null) {
                this.mListView.setData(arrayList);
            }
        }
    }

    public void aMb() {
        this.emK = 0;
    }

    public int aMc() {
        return this.emL;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.x.q(fVar.aKA()) || com.baidu.tbadk.core.util.x.q(fVar.aKz())) {
            return -1;
        }
        if (z) {
            return (fVar.aKA().get(0) == null || fVar.aKA().get(0).bjp() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.v> a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (fVar == null || arrayList == null || fVar.aKz() == null || fVar.aKz().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<com.baidu.tbadk.core.data.bi> aKz = fVar.aKz();
        int size = aKz.size();
        this.emL = 0;
        if (this.emK + 5 >= size) {
            int i = 0;
            for (com.baidu.tbadk.core.data.bi biVar : aKz) {
                if (biVar != null) {
                    com.baidu.tieba.pb.video.s sVar = new com.baidu.tieba.pb.video.s();
                    i++;
                    if (i == 1) {
                        sVar.a(biVar, true, true, true, i);
                    } else {
                        sVar.a(biVar, true, true, false, i);
                    }
                    arrayList2.add(sVar);
                    this.emK++;
                }
            }
            if (this.emK <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.emL = arrayList2.size();
            }
            return arrayList2;
        }
        int i2 = this.emK + 5;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            com.baidu.tbadk.core.data.bi biVar2 = aKz.get(i4);
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
                this.emK++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.u());
        this.emL = arrayList2.size();
        return arrayList2;
    }

    private void aco() {
        if (this.ekw != null && !acp()) {
            this.ekw.registerListener(this.bUs);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean acp() {
        if (this.ekw == null) {
            return false;
        }
        this.bUk = new ArrayList();
        ArrayList<BdUniqueId> biv = com.baidu.tieba.tbadkCore.t.biv();
        if (biv == null || biv.size() <= 0) {
            return false;
        }
        int size = biv.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.aAt().a(this.ekw.getPageContext(), biv.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.bUk.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bUk)) {
            this.mListView.addAdapters(this.bUk);
        }
        return true;
    }

    public int aMd() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aKA() == null || fVar.aKB() == null || fVar.aKA().size() == 0 || fVar.aKy() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aKB().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aKA().get(0) == null || fVar.aKA().get(0).bjp() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.rr() == null || fVar.rr().rl() != fVar.rr().ri()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aKA() == null || fVar.aKC() == null || fVar.aKA().size() == 0 || fVar.aKy() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aKC().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aKA().get(0) == null || fVar.aKA().get(0).bjp() != 1) ? -1 : 1;
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
            if (fVar == null || com.baidu.tbadk.core.util.x.q(fVar.aKA()) || fVar.aKy() == null || fVar.aKy().sN() == null) {
                return -1;
            }
            PostData aKE = fVar.aKE();
            PostData postData = (aKE == null && fVar.aKA().get(0) != null && fVar.aKA().get(0).bjp() == 1) ? fVar.aKA().get(0) : aKE;
            if (postData == null) {
                return -1;
            }
            return (postData.getType() == PostData.fyg || postData.getType() == PostData.Yd || postData.getType() == PostData.fyi) ? 1 : -1;
        }
        return -1;
    }

    public int d(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        com.baidu.tbadk.core.data.af aKv;
        if (fVar == null || fVar.aKA() == null || fVar.aKv() == null || fVar.aKA().size() == 0 || fVar.aKy() == null || arrayList == null) {
            return -1;
        }
        PostData aKE = fVar.aKE();
        PostData postData = (aKE == null && fVar.aKA().get(0) != null && fVar.aKA().get(0).bjp() == 1) ? fVar.aKA().get(0) : aKE;
        if (postData == null) {
            return -1;
        }
        if ((postData.getType() == PostData.fyg || postData.getType() == PostData.Yd || postData.getType() == PostData.fyi) && com.baidu.tieba.graffiti.c.ahE()) {
            if (!this.emY) {
                this.emY = o(com.baidu.tbadk.core.data.af.TYPE);
            }
            if (this.emY && (aKv = fVar.aKv()) != null) {
                if (StringUtils.isNull(aKv.getForumId()) || StringUtils.isNull(aKv.getThreadId())) {
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

    public ArrayList<PostData> aMe() {
        return this.postList;
    }

    public BdUniqueId ok(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.emP == null || !this.emP.aLg()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aMf() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.ejx != null) {
            ArrayList<PostData> aKA = this.ejx.aKA();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> aKL = this.ejx.aKL();
            if (aKL != null) {
                int size = aKL.size();
                if (aKA != null && aKA.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it = aKL.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next = it.next();
                        if (next != null && next.bjf() != null) {
                            sb.append(next.bjf());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = aKL.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                        if (next2 != null) {
                            next2.bYv = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = aKL.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                        if (next3.bjd() != null && next3.bjd().pO()) {
                            if (!com.baidu.tieba.tbadkCore.ae.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bjd().apk_name)) {
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
                        if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.bjf(), oVar3)) != null) {
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
                        if (a(oVar4, aKA)) {
                            a(oVar4, 100);
                        } else if (position2 + i3 >= aKA.size()) {
                            a(oVar4, 2);
                            return;
                        } else {
                            if (this.ejx.aKx() != null) {
                                oVar4.forumId = this.ejx.aKx().getId();
                            }
                            if (this.ejx.aKy() != null) {
                                oVar4.threadId = com.baidu.adp.lib.g.b.c(this.ejx.aKy().getId(), 0L);
                            }
                            if (this.ejx != null && this.ejx.rr() != null) {
                                oVar4.pageNumber = this.ejx.rr().rl();
                            }
                            b(oVar4);
                            aKA.add(position2, oVar4);
                            TiebaStatic.eventStat(this.ekw.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", oVar4.bjd().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.o oVar, int i) {
        com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 5);
        b.qW(i);
        com.baidu.tieba.recapp.report.b.bbA().a(b);
    }

    private void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData aKx;
        if (oVar != null && this.ejx != null && oVar.bjd() != null) {
            oVar.bjd().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.ejx.rr() != null) {
                oVar.bjd().advertAppContext.pn = this.ejx.rr().rl();
            }
            oVar.bjd().advertAppContext.Ty = "PB";
            if (this.ejx.aKx() != null && (aKx = this.ejx.aKx()) != null) {
                oVar.bjd().advertAppContext.fid = aKx.getId();
                oVar.bjd().advertAppContext.TA = aKx.getFirst_class();
                oVar.bjd().advertAppContext.TB = aKx.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.bjd().advertAppContext.TC = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.bjd().advertAppContext.extensionInfo = oVar.bjd().ext_info;
            oVar.bjd().advertAppContext.TD = false;
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
        if (this.ejx != null && this.ejx.rr() != null) {
            oVar.pageNumber = this.ejx.rr().rl();
        }
        arrayList.add(oVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.emQ.setFromCDN(z);
        this.emH.setFromCDN(z);
        if (this.bXR != null && (this.bXR instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.bXR).setIsFromCDN(z);
        }
        if (this.bXS != null && (this.bXS instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.bXS).setIsFromCDN(z);
        }
        if (this.bXT != null && (this.bXT instanceof com.baidu.tieba.recapp.r)) {
            ((com.baidu.tieba.recapp.r) this.bXT).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.emU.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void ik(boolean z) {
        this.cCs = z;
    }

    public void il(boolean z) {
        this.ejw = z;
    }

    public void im(boolean z) {
        this.emW = z;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ejA = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aNM = eVar;
    }

    public void a(com.baidu.tieba.pb.a.d dVar) {
        this.ejB = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atn = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.csa = onClickListener;
    }

    public boolean o(BdUniqueId bdUniqueId) {
        if (this.mListView == null || bdUniqueId == null || com.baidu.tbadk.core.util.x.q(this.emX)) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.emX) {
            if (aVar != null && bdUniqueId.getId() == aVar.getType().getId()) {
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.recapp.r aMg() {
        return (com.baidu.tieba.recapp.r) this.bXR;
    }

    public com.baidu.tieba.recapp.r aMh() {
        return (com.baidu.tieba.recapp.r) this.bXS;
    }

    public void ol(int i) {
        switch (i) {
            case 1:
                if (this.emP != null) {
                    this.emP.pause();
                }
                if (this.emM != null && (this.emM instanceof com.baidu.tieba.recapp.u)) {
                    ((com.baidu.tieba.recapp.u) this.emM).release();
                    return;
                }
                return;
            case 2:
                if (this.emP != null) {
                    this.emP.resume();
                }
                if (this.emM != null && (this.emM instanceof com.baidu.tieba.recapp.u)) {
                    ((com.baidu.tieba.recapp.u) this.emM).resume();
                    return;
                }
                return;
            case 3:
                if (this.emP != null) {
                    this.emP.release();
                }
                if (this.emM != null && (this.emM instanceof com.baidu.tieba.recapp.u)) {
                    ((com.baidu.tieba.recapp.u) this.emM).release();
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
