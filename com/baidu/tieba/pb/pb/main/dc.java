package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class dc {
    private List<com.baidu.adp.widget.ListView.a> cgf;
    private com.baidu.adp.widget.ListView.a ckc;
    private com.baidu.adp.widget.ListView.a ckd;
    private int esX;
    private com.baidu.tieba.pb.data.f eta;
    private PbActivity euf;
    private com.baidu.tieba.pb.pb.a.h ewF;
    private dy ewG;
    private ga ewH;
    private fv ewI;
    private Cdo ewJ;
    private com.baidu.tieba.pb.video.ab ewK;
    private com.baidu.tieba.pb.video.ad ewL;
    private com.baidu.tieba.pb.video.a ewM;
    private int ewN;
    private com.baidu.adp.widget.ListView.a ewP;
    private com.baidu.adp.widget.ListView.a ewQ;
    private com.baidu.adp.widget.ListView.a ewR;
    private ff ewS;
    private fm ewT;
    private com.baidu.tieba.pb.pb.a.b ewU;
    private com.baidu.tieba.pb.pb.a.i ewV;
    private ej ewW;
    private fc ewX;
    private com.baidu.tieba.pb.pb.a.c ewY;
    private boolean exc;
    private boolean exd;
    private Runnable exi;
    private BdTypeListView mListView;
    private int width;
    private int ewO = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> ewZ = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean esY = true;
    private boolean exa = true;
    private boolean esZ = true;
    private boolean exb = false;
    private boolean exe = false;
    private boolean exf = false;
    private String mHostId = null;
    private View.OnClickListener ete = null;
    private View.OnClickListener cDj = null;
    private TbRichTextView.e aPr = null;
    private com.baidu.tieba.pb.a.d aPs = null;
    private View.OnLongClickListener aue = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> exg = new ArrayList();
    private boolean exh = false;
    private CustomMessageListener cgm = new dd(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener cdh = new de(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener cgn = new dg(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public dc(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.esX = 0;
        this.width = -1;
        this.esX = com.baidu.adp.lib.util.k.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.esX;
        this.euf = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.cdh);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ewV = new com.baidu.tieba.pb.pb.a.i(pbActivity, PostData.fMi);
        this.ewG = new dy(pbActivity, PostData.fMf);
        this.ewG.a(pbActivity);
        this.ewF = new com.baidu.tieba.pb.pb.a.h(pbActivity, com.baidu.tieba.pb.data.j.TYPE);
        this.ewH = new ga(pbActivity, com.baidu.tieba.pb.data.m.esg);
        this.ewI = new fv(pbActivity, com.baidu.tieba.pb.data.k.esc);
        this.ewJ = new Cdo(pbActivity, PostData.fMg);
        this.ewJ.a(pbActivity);
        this.ckc = com.baidu.tieba.recapp.aa.bdU().a(pbActivity, AdvertAppInfo.SK);
        this.ewP = com.baidu.tieba.recapp.aa.bdU().a(pbActivity, AdvertAppInfo.SL);
        this.ewQ = com.baidu.tieba.recapp.aa.bdU().a(pbActivity, AdvertAppInfo.SM);
        this.ewR = com.baidu.tieba.recapp.aa.bdU().a(pbActivity, AdvertAppInfo.SN);
        this.ckd = com.baidu.tieba.recapp.aa.bdU().a(pbActivity, AdvertAppInfo.SR);
        this.ewW = new ej(pbActivity, com.baidu.tieba.pb.data.a.erb);
        this.ewX = new fc(pbActivity, com.baidu.tieba.pb.data.i.erY);
        this.ewS = new ff(pbActivity, fb.eAm);
        this.ewT = new fm(pbActivity, com.baidu.tbadk.core.data.av.Wu);
        this.ewK = new com.baidu.tieba.pb.video.ab(pbActivity, com.baidu.tieba.pb.video.ac.eKx);
        this.ewL = new com.baidu.tieba.pb.video.ad(pbActivity, com.baidu.tieba.pb.video.ae.eKG);
        this.ewL.setOnClickListener(new dh(this));
        this.ewM = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.eJk);
        this.ewM.setOnClickListener(new di(this));
        this.ewY = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.q.Uh);
        if (this.eta != null && this.eta.aMv() != null) {
            this.ewY.amt = this.eta.aMv().Zh;
        }
        this.mAdapters.add(this.ewG);
        this.mAdapters.add(this.ewH);
        this.mAdapters.add(this.ewJ);
        this.mAdapters.add(this.ewI);
        this.mAdapters.add(this.ewV);
        this.mAdapters.add(this.ckc);
        this.mAdapters.add(this.ewP);
        this.mAdapters.add(this.ewQ);
        this.mAdapters.add(this.ewR);
        this.mAdapters.add(this.ckd);
        this.mAdapters.add(this.ewW);
        this.mAdapters.add(this.ewX);
        this.mAdapters.add(this.ewS);
        this.mAdapters.add(this.ewT);
        this.mAdapters.add(this.ewK);
        this.mAdapters.add(this.ewL);
        this.mAdapters.add(this.ewY);
        this.mAdapters.add(this.ewM);
        this.mAdapters.add(this.ewF);
        this.cgm.setPriority(1);
        this.cgm.setSelfListener(true);
        pbActivity.registerListener(this.cgm);
        afu();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        int size;
        PostData postData;
        int size2;
        PostData postData2;
        if (fVar != null) {
            if (this.eta != fVar) {
                z2 = (fVar == null || fVar.aMq()) && TbadkCoreApplication.m9getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.eta = fVar;
            if (z2) {
                aOw();
                if (fVar != null) {
                    fVar.it(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.eta != null && this.eta.aMx() != null && this.eta.aMx().size() > 0) {
                this.postList.addAll(this.eta.aMx());
            }
            if (fVar != null && fVar.aMv() != null && fVar.aMv().getAuthor() != null) {
                this.mHostId = fVar.aMv().getAuthor().getUserId();
            }
            if (this.ewG != null) {
                this.ewV.b(fVar);
                this.ewV.setFromCDN(this.mIsFromCDN);
                this.ewV.setHostId(this.mHostId);
                this.ewV.oF(this.esX);
                this.ewV.iv(this.esY);
                this.ewV.iw(this.esZ);
                this.ewV.setCommonClickListener(this.cDj);
                this.ewV.I(this.ete);
                this.ewV.setOnImageClickListener(this.aPr);
                this.ewV.setOnLongClickListener(this.aue);
                this.ewG.b(fVar);
                this.ewG.setFromCDN(this.mIsFromCDN);
                this.ewG.setHostId(this.mHostId);
                this.ewG.oF(this.esX);
                this.ewG.iv(this.esY);
                this.ewG.iw(this.esZ);
                this.ewG.setCommonClickListener(this.cDj);
                this.ewG.I(this.ete);
                this.ewG.setOnImageClickListener(this.aPr);
                this.ewG.setOnLongClickListener(this.aue);
                this.ewG.setTbGestureDetector(this.aPs);
                this.ewG.oO(fVar != null ? fVar.aMv().rj() : 0);
                this.ewJ.b(fVar);
                this.ewJ.setFromCDN(this.mIsFromCDN);
                this.ewJ.setHostId(this.mHostId);
                this.ewJ.iv(this.esY);
                this.ewJ.setCommonClickListener(this.cDj);
                this.ewJ.I(this.ete);
                this.ewJ.setOnImageClickListener(this.aPr);
                this.ewJ.setOnLongClickListener(this.aue);
                this.ewJ.setTbGestureDetector(this.aPs);
                this.ewH.setOnClickListener(this.cDj);
                this.ewH.setTbGestureDetector(this.aPs);
                if (this.ewP != null && (this.ewP instanceof com.baidu.tieba.recapp.w)) {
                    ((com.baidu.tieba.recapp.w) this.ewP).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.ewQ != null && (this.ewQ instanceof com.baidu.tieba.recapp.w)) {
                    ((com.baidu.tieba.recapp.w) this.ewQ).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.ckd != null && (this.ckd instanceof com.baidu.tieba.recapp.w)) {
                    ((com.baidu.tieba.recapp.w) this.ckd).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ewZ.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.oF(this.esX);
                        next.iv(this.esY);
                        next.iw(this.esZ);
                        next.ix(this.exf);
                        next.setCommonClickListener(this.cDj);
                        next.I(this.ete);
                        next.setOnImageClickListener(this.aPr);
                        next.setOnLongClickListener(this.aue);
                    }
                }
                this.ewI.setCommonClickListener(this.cDj);
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(fVar.aMx());
                Iterator<com.baidu.adp.widget.ListView.v> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.v next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bmu() == 1) {
                        z3 = true;
                        break;
                    }
                }
                cj(arrayList);
                if (this.euf.aNU()) {
                    if (fVar.aMx().size() > 0 && (postData2 = fVar.aMx().get(0)) != null && postData2.bmu() == 1 && !com.baidu.tbadk.core.util.z.t(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.eta, arrayList, this.esZ);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.z.a(arrayList, b, this.eta.aMy());
                    }
                }
                int c = c(this.eta, arrayList, this.esZ);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.z.a(arrayList, c, this.eta.aMz());
                }
                if (arrayList.size() == 0 && this.euf.aNU()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.esZ);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.v> c2 = c(fVar, arrayList);
                    if (c2 != null && c2.size() > 0) {
                        com.baidu.tbadk.core.util.z.a((List) arrayList, a, (List) c2);
                    } else {
                        this.ewN = 0;
                    }
                } else {
                    this.ewN = 0;
                }
                com.baidu.tieba.tbadkCore.s.q(arrayList, 1);
                int s = com.baidu.tbadk.core.util.z.s(arrayList);
                int i = 0;
                while (i < s) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.z.c(arrayList, i);
                    if (vVar instanceof PostData) {
                        ((PostData) vVar).cls = i == 0;
                    }
                    i++;
                }
                int a2 = a(fVar, arrayList);
                List<com.baidu.adp.widget.ListView.v> d = d(fVar);
                if (com.baidu.tbadk.core.util.z.t(d) || a2 < 0) {
                    z4 = false;
                } else {
                    com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.z.c(arrayList, a2);
                    if (vVar2 instanceof PostData) {
                        ((PostData) vVar2).cls = true;
                    }
                    com.baidu.tbadk.core.util.z.a((List) arrayList, a2, (List) d);
                    z4 = true;
                }
                int b2 = z3 ? b(fVar, arrayList) : -1;
                if (b2 >= 0 && fVar.aMS() != null) {
                    com.baidu.tbadk.core.util.z.a(arrayList, b2, fVar.aMS());
                    fVar.aMS().iu((b(arrayList, b2) || z4) ? false : true);
                    z4 = true;
                }
                this.ewG.iL(z4 ? false : true);
                if (!this.esZ && fVar != null && fVar.aMx() != null && (size = fVar.aMx().size()) > 0 && (postData = fVar.aMx().get(size - 1)) != null && postData.bmu() == 1 && (size2 = arrayList.size()) > 0) {
                    arrayList.remove(size2 - 1);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z) {
                    if ((this.exc || this.exb) && a2 != -1 && !com.baidu.tbadk.core.util.z.t(d) && !this.exd) {
                        this.exi = new dj(this, d);
                        com.baidu.adp.lib.g.h.fR().post(this.exi);
                    }
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, int i) {
        MetaData author;
        GodUserData godUserData;
        if (this.euf.aMC() == null || this.euf.aNy() == null) {
            return false;
        }
        if (this.euf.aNy().aQX() || (author = this.euf.aMC().getAuthor()) == null || (godUserData = author.getGodUserData()) == null || !godUserData.isBigV() || godUserData.getIsLike()) {
            return false;
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
        jVar.erZ = author;
        com.baidu.tbadk.core.util.z.a(arrayList, i + 1, jVar);
        jVar.esa = true;
        if (!UtilHelper.isCurrentAccount(author.getUserId())) {
            jVar.esb = true;
            return true;
        }
        jVar.esb = false;
        return true;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        PostData postData;
        int i;
        int i2 = 0;
        if (fVar == null || com.baidu.tbadk.core.util.z.t(fVar.aMx()) || arrayList == null || arrayList.size() <= 0 || this.euf.aOh() || this.exe) {
            return -1;
        }
        if ((this.euf.aNz() == null || !this.euf.aNz().getIsFromMark()) && (postData = (PostData) com.baidu.tbadk.core.util.z.c(fVar.aMx(), 0)) != null) {
            int bmu = postData.bmu();
            int size = arrayList.size();
            while (true) {
                if (i2 >= size) {
                    i = -1;
                    break;
                }
                com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
                if (vVar != null && (vVar instanceof PostData)) {
                    PostData postData2 = (PostData) vVar;
                    if (postData2.bmu() == bmu && postData2.fMO == 0) {
                        i = bmu == 1 ? i2 + 1 : i2;
                    }
                    i2++;
                } else {
                    if (vVar != null && (vVar instanceof com.baidu.tieba.pb.data.k)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            return i;
        }
        return -1;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (!this.esZ) {
            return -1;
        }
        if (fVar == null || com.baidu.tbadk.core.util.z.t(fVar.aMx()) || arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return -1;
            }
            com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
            if (!(vVar instanceof PostData) || ((PostData) vVar).bmu() != 1) {
                i = i2 + 1;
            } else {
                return i2 + 1;
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.v> d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aMF() == null || com.baidu.tbadk.core.util.z.t(fVar.aMF().ess) || this.euf.aOh() || this.exe) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aMF().ess;
        if (com.baidu.tbadk.core.util.z.t(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.fMQ = true;
                arrayList.add(postData);
            }
        }
        int s = com.baidu.tbadk.core.util.z.s(fVar.aMF().est);
        if (fVar.aMF().getCount() != s && s > 2) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.z.c(arrayList, arrayList.size() - 1);
            if (vVar instanceof PostData) {
                ((PostData) vVar).fMQ = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.z.c(arrayList, arrayList.size() - 1);
            if (vVar2 instanceof PostData) {
                ((PostData) vVar2).fMQ = true;
            }
        }
        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
        kVar.mType = 0;
        arrayList.add(0, kVar);
        return arrayList;
    }

    public void aOs() {
        this.ewN = 0;
    }

    public int aOt() {
        return this.ewO;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.z.t(fVar.aMx()) || com.baidu.tbadk.core.util.z.t(fVar.aMw())) {
            return -1;
        }
        if (z) {
            return (fVar.aMx().get(0) == null || fVar.aMx().get(0).bmu() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.v> c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (fVar == null || arrayList == null || fVar.aMw() == null || fVar.aMw().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<com.baidu.tbadk.core.data.bm> aMw = fVar.aMw();
        int size = aMw.size();
        this.ewO = 0;
        if (this.ewN + 5 >= size) {
            int i = 0;
            for (com.baidu.tbadk.core.data.bm bmVar : aMw) {
                if (bmVar != null) {
                    com.baidu.tieba.pb.video.ac acVar = new com.baidu.tieba.pb.video.ac();
                    i++;
                    if (i == 1) {
                        acVar.a(bmVar, true, true, true, i);
                    } else {
                        acVar.a(bmVar, true, true, false, i);
                    }
                    arrayList2.add(acVar);
                    this.ewN++;
                }
            }
            if (this.ewN <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.ewO = arrayList2.size();
            }
            return arrayList2;
        }
        int i2 = this.ewN + 5;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            com.baidu.tbadk.core.data.bm bmVar2 = aMw.get(i4);
            if (bmVar2 != null) {
                com.baidu.tieba.pb.video.ac acVar2 = new com.baidu.tieba.pb.video.ac();
                i3++;
                boolean z = i3 == 1;
                if (i4 == i2 - 1) {
                    acVar2.a(bmVar2, false, true, z, i3);
                } else {
                    acVar2.a(bmVar2, true, true, z, i3);
                }
                arrayList2.add(acVar2);
                this.ewN++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.ae());
        this.ewO = arrayList2.size();
        return arrayList2;
    }

    private void afu() {
        if (this.euf != null && !afv()) {
            this.euf.registerListener(this.cgn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean afv() {
        if (this.euf == null) {
            return false;
        }
        this.cgf = new ArrayList();
        ArrayList<BdUniqueId> blE = com.baidu.tieba.tbadkCore.s.blE();
        if (blE == null || blE.size() <= 0) {
            return false;
        }
        int size = blE.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aBU().a(this.euf.getPageContext(), blE.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.cgf.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.z.t(this.cgf)) {
            this.mListView.addAdapters(this.cgf);
        }
        return true;
    }

    public int aOu() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aMx() == null || fVar.aMy() == null || fVar.aMx().size() == 0 || fVar.aMv() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aMy().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aMx().get(0) == null || fVar.aMx().get(0).bmu() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qu() == null || fVar.qu().qo() != fVar.qu().ql()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aMx() == null || fVar.aMz() == null || fVar.aMx().size() == 0 || fVar.aMv() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aMz().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aMx().get(0) == null || fVar.aMx().get(0).bmu() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qu() == null || fVar.qu().qo() != fVar.qu().ql()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aOv() {
        return this.postList;
    }

    public BdUniqueId oL(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.ewU == null || !this.ewU.aNn()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aOw() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.eta != null) {
            ArrayList<PostData> aMx = this.eta.aMx();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> aMJ = this.eta.aMJ();
            if (aMJ != null) {
                int size = aMJ.size();
                if (aMx != null && aMx.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it = aMJ.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next = it.next();
                        if (next != null && next.bml() != null) {
                            sb.append(next.bml());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = aMJ.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                        if (next2 != null) {
                            next2.ckG = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = aMJ.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                        if (next3.bmj() != null) {
                            int pk = next3.bmj().pk();
                            if (pk != 0) {
                                a(next3, pk);
                                if (pk != 28 && pk != 31) {
                                    if (next3.bmj().goods != null) {
                                        next3.bmj().goods.goods_style = 1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.ac.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bmj().apk_name)) {
                                int position = next3.getPosition();
                                if (position >= 2 && position < 30) {
                                    sparseArray.put(position, next3);
                                } else {
                                    b(next3, 33);
                                }
                            } else {
                                b(next3, 3);
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < sparseArray.size(); i++) {
                        com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(sparseArray.keyAt(i));
                        if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.bml(), oVar3)) != null) {
                            b(oVar2, 30);
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
                    Collections.sort(arrayList, new dk(this));
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.eta.aMt() != null) {
                            oVar4.forumId = this.eta.aMt().getId();
                        }
                        if (this.eta.aMv() != null) {
                            oVar4.threadId = com.baidu.adp.lib.g.b.c(this.eta.aMv().getId(), 0L);
                        }
                        if (this.eta != null && this.eta.qu() != null) {
                            oVar4.pageNumber = this.eta.qu().qo();
                        }
                        b(oVar4);
                        int position2 = oVar4.getPosition();
                        if (a(oVar4, aMx)) {
                            aMx.add(oVar4);
                        } else if (position2 + i3 >= aMx.size()) {
                            a(oVar4, 2);
                            return;
                        } else {
                            aMx.add(position2, oVar4);
                            TiebaStatic.eventStat(this.euf.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", oVar4.bmj().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.o oVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(oVar, 5);
        c.rE(i);
        com.baidu.tieba.recapp.report.b.beC().a(c);
    }

    private void b(com.baidu.tieba.tbadkCore.data.o oVar, int i) {
        if (oVar != null && oVar.bmj() != null && oVar.bmj().goods != null && oVar.bmj().goods.goods_style != 1001) {
            com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(oVar, 5);
            c.rE(i);
            com.baidu.tieba.recapp.report.b.beC().a(c);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData aMt;
        if (oVar != null && this.eta != null && oVar.bmj() != null) {
            oVar.bmj().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.eta.qu() != null) {
                oVar.bmj().advertAppContext.pn = this.eta.qu().qo();
            }
            oVar.bmj().advertAppContext.Sz = "PB";
            if (this.eta.aMt() != null && (aMt = this.eta.aMt()) != null) {
                oVar.bmj().advertAppContext.fid = aMt.getId();
                oVar.bmj().advertAppContext.SB = aMt.getFirst_class();
                oVar.bmj().advertAppContext.SC = aMt.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.bmj().advertAppContext.SD = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.bmj().advertAppContext.extensionInfo = oVar.bmj().ext_info;
            oVar.bmj().advertAppContext.SE = false;
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.o oVar, ArrayList<PostData> arrayList) {
        int s = com.baidu.tbadk.core.util.z.s(arrayList);
        if (oVar == null || s <= 0) {
            return false;
        }
        int position = oVar.getPosition();
        if (s >= 2 || position != s + 1) {
            return false;
        }
        if (this.eta != null && this.eta.qu() != null) {
            oVar.pageNumber = this.eta.qu().qo();
        }
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.ewV.setFromCDN(z);
        this.ewG.setFromCDN(z);
        if (this.ewP != null && (this.ewP instanceof com.baidu.tieba.recapp.w)) {
            ((com.baidu.tieba.recapp.w) this.ewP).setIsFromCDN(z);
        }
        if (this.ewQ != null && (this.ewQ instanceof com.baidu.tieba.recapp.w)) {
            ((com.baidu.tieba.recapp.w) this.ewQ).setIsFromCDN(z);
        }
        if (this.ckd != null && (this.ckd instanceof com.baidu.tieba.recapp.w)) {
            ((com.baidu.tieba.recapp.w) this.ckd).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ewZ.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void iv(boolean z) {
        this.esY = z;
    }

    public void iw(boolean z) {
        this.esZ = z;
    }

    public void ix(boolean z) {
        this.exf = z;
    }

    public void I(View.OnClickListener onClickListener) {
        this.ete = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aPr = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.d dVar) {
        this.aPs = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aue = onLongClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.cDj = onClickListener;
    }

    public void oM(int i) {
        if (this.ewH != null) {
            this.ewH.oM(i);
        }
        switch (i) {
            case 1:
                if (this.ewU != null) {
                    this.ewU.pause();
                }
                if (this.ewG != null) {
                    this.ewG.pause();
                }
                if (this.ewR != null && (this.ewR instanceof com.baidu.tieba.recapp.z)) {
                    ((com.baidu.tieba.recapp.z) this.ewR).release();
                    return;
                }
                return;
            case 2:
                if (this.ewU != null) {
                    this.ewU.resume();
                }
                if (this.ewG != null) {
                    this.ewG.resume();
                }
                if (this.ewR != null && (this.ewR instanceof com.baidu.tieba.recapp.z)) {
                    ((com.baidu.tieba.recapp.z) this.ewR).resume();
                    return;
                }
                return;
            case 3:
                if (this.ewU != null) {
                    this.ewU.release();
                }
                if (this.ewG != null) {
                    this.ewG.release();
                }
                if (this.ewR != null && (this.ewR instanceof com.baidu.tieba.recapp.z)) {
                    ((com.baidu.tieba.recapp.z) this.ewR).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cj(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sm())) {
                        com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
                        aiVar.ct(postData.sm());
                        list.set(i, aiVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.exi);
    }

    public void iH(boolean z) {
        this.exe = z;
    }

    public void iI(boolean z) {
        this.exb = z;
    }

    public void iJ(boolean z) {
        this.exc = z;
    }

    public void iK(boolean z) {
        this.exd = z;
    }

    public ga aOx() {
        return this.ewH;
    }
}
