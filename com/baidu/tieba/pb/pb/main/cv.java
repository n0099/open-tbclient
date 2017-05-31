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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class cv {
    private List<com.baidu.adp.widget.ListView.a> bXW;
    private com.baidu.adp.widget.ListView.a cbR;
    private com.baidu.adp.widget.ListView.a cbS;
    private int ejZ;
    private com.baidu.tieba.pb.data.f ekc;
    private PbActivity elf;
    private dr enA;
    private fr enB;
    private fm enC;
    private dh enD;
    private com.baidu.tieba.pb.video.ab enE;
    private com.baidu.tieba.pb.video.ad enF;
    private com.baidu.tieba.pb.video.a enG;
    private int enH;
    private com.baidu.adp.widget.ListView.a enJ;
    private com.baidu.adp.widget.ListView.a enK;
    private com.baidu.adp.widget.ListView.a enL;
    private ew enM;
    private fd enN;
    private com.baidu.tieba.pb.pb.a.b enO;
    private com.baidu.tieba.pb.pb.a.i enP;
    private ea enQ;
    private et enR;
    private com.baidu.tieba.pb.pb.a.c enS;
    private boolean enW;
    private boolean enX;
    private com.baidu.tieba.pb.pb.a.h enz;
    private Runnable eoc;
    private BdTypeListView mListView;
    private int width;
    private int enI = 0;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> enT = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean eka = true;
    private boolean enU = true;
    private boolean ekb = true;
    private boolean enV = false;
    private boolean enY = false;
    private boolean enZ = false;
    private String mHostId = null;
    private View.OnClickListener ekf = null;
    private View.OnClickListener cvw = null;
    private TbRichTextView.e aOb = null;
    private com.baidu.tieba.pb.a.d aOc = null;
    private View.OnLongClickListener atb = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> eoa = new ArrayList();
    private boolean eob = false;
    private CustomMessageListener bYd = new cw(this, CmdConfigCustom.PB_ADD_ADAPTER);
    private final CustomMessageListener bUY = new cx(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private CustomMessageListener bYe = new cz(this, CmdConfigCustom.CMD_LEGO_REGISTER);

    public cv(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ejZ = 0;
        this.width = -1;
        this.ejZ = com.baidu.adp.lib.util.k.af(pbActivity.getPageContext().getPageActivity());
        this.width = this.ejZ;
        this.elf = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.bUY);
    }

    public void a(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.enP = new com.baidu.tieba.pb.pb.a.i(pbActivity, PostData.fCe);
        this.enA = new dr(pbActivity, PostData.fCb);
        this.enA.a(pbActivity);
        this.enz = new com.baidu.tieba.pb.pb.a.h(pbActivity, com.baidu.tieba.pb.data.j.TYPE);
        this.enB = new fr(pbActivity, com.baidu.tieba.pb.data.m.eji);
        this.enC = new fm(pbActivity, com.baidu.tieba.pb.data.k.eje);
        this.enD = new dh(pbActivity, PostData.fCc);
        this.enD.a(pbActivity);
        this.cbR = com.baidu.tieba.recapp.z.aZK().a(pbActivity, AdvertAppInfo.SP);
        this.enJ = com.baidu.tieba.recapp.z.aZK().a(pbActivity, AdvertAppInfo.SQ);
        this.enK = com.baidu.tieba.recapp.z.aZK().a(pbActivity, AdvertAppInfo.SR);
        this.enL = com.baidu.tieba.recapp.z.aZK().a(pbActivity, AdvertAppInfo.SS);
        this.cbS = com.baidu.tieba.recapp.z.aZK().a(pbActivity, AdvertAppInfo.SW);
        this.enQ = new ea(pbActivity, com.baidu.tieba.pb.data.a.eie);
        this.enR = new et(pbActivity, com.baidu.tieba.pb.data.i.ejb);
        this.enM = new ew(pbActivity, es.erb);
        this.enN = new fd(pbActivity, com.baidu.tbadk.core.data.au.Wu);
        this.enE = new com.baidu.tieba.pb.video.ab(pbActivity, com.baidu.tieba.pb.video.ac.eAZ);
        this.enF = new com.baidu.tieba.pb.video.ad(pbActivity, com.baidu.tieba.pb.video.ae.eBi);
        this.enF.setOnClickListener(new da(this));
        this.enG = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.ezM);
        this.enG.setOnClickListener(new db(this));
        this.enS = new com.baidu.tieba.pb.pb.a.c(pbActivity.getPageContext(), com.baidu.tbadk.core.data.p.Ui);
        if (this.ekc != null && this.ekc.aIB() != null) {
            this.enS.alE = this.ekc.aIB().Zg;
        }
        this.mAdapters.add(this.enA);
        this.mAdapters.add(this.enB);
        this.mAdapters.add(this.enD);
        this.mAdapters.add(this.enC);
        this.mAdapters.add(this.enP);
        this.mAdapters.add(this.cbR);
        this.mAdapters.add(this.enJ);
        this.mAdapters.add(this.enK);
        this.mAdapters.add(this.enL);
        this.mAdapters.add(this.cbS);
        this.mAdapters.add(this.enQ);
        this.mAdapters.add(this.enR);
        this.mAdapters.add(this.enM);
        this.mAdapters.add(this.enN);
        this.mAdapters.add(this.enE);
        this.mAdapters.add(this.enF);
        this.mAdapters.add(this.enS);
        this.mAdapters.add(this.enG);
        this.mAdapters.add(this.enz);
        this.bYd.setPriority(1);
        this.bYd.setSelfListener(true);
        pbActivity.registerListener(this.bYd);
        abD();
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
            if (this.ekc != fVar) {
                z2 = (fVar == null || fVar.aIw()) && TbadkCoreApplication.m9getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.ekc = fVar;
            if (z2) {
                aKz();
                if (fVar != null) {
                    fVar.hX(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.ekc != null && this.ekc.aID() != null && this.ekc.aID().size() > 0) {
                this.postList.addAll(this.ekc.aID());
            }
            if (fVar != null && fVar.aIB() != null && fVar.aIB().getAuthor() != null) {
                this.mHostId = fVar.aIB().getAuthor().getUserId();
            }
            if (this.enA != null) {
                this.enP.b(fVar);
                this.enP.setFromCDN(this.mIsFromCDN);
                this.enP.setHostId(this.mHostId);
                this.enP.op(this.ejZ);
                this.enP.hZ(this.eka);
                this.enP.ia(this.ekb);
                this.enP.setCommonClickListener(this.cvw);
                this.enP.H(this.ekf);
                this.enP.setOnImageClickListener(this.aOb);
                this.enP.setOnLongClickListener(this.atb);
                this.enA.b(fVar);
                this.enA.setFromCDN(this.mIsFromCDN);
                this.enA.setHostId(this.mHostId);
                this.enA.op(this.ejZ);
                this.enA.hZ(this.eka);
                this.enA.ia(this.ekb);
                this.enA.setCommonClickListener(this.cvw);
                this.enA.H(this.ekf);
                this.enA.setOnImageClickListener(this.aOb);
                this.enA.setOnLongClickListener(this.atb);
                this.enA.setTbGestureDetector(this.aOc);
                this.enA.ox(fVar != null ? fVar.aIB().rn() : 0);
                this.enD.b(fVar);
                this.enD.setFromCDN(this.mIsFromCDN);
                this.enD.setHostId(this.mHostId);
                this.enD.hZ(this.eka);
                this.enD.setCommonClickListener(this.cvw);
                this.enD.H(this.ekf);
                this.enD.setOnImageClickListener(this.aOb);
                this.enD.setOnLongClickListener(this.atb);
                this.enD.setTbGestureDetector(this.aOc);
                this.enB.setOnClickListener(this.cvw);
                if (this.enJ != null && (this.enJ instanceof com.baidu.tieba.recapp.v)) {
                    ((com.baidu.tieba.recapp.v) this.enJ).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.enK != null && (this.enK instanceof com.baidu.tieba.recapp.v)) {
                    ((com.baidu.tieba.recapp.v) this.enK).setIsFromCDN(this.mIsFromCDN);
                }
                if (this.cbS != null && (this.cbS instanceof com.baidu.tieba.recapp.v)) {
                    ((com.baidu.tieba.recapp.v) this.cbS).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.enT.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.op(this.ejZ);
                        next.hZ(this.eka);
                        next.ia(this.ekb);
                        next.ib(this.enZ);
                        next.setCommonClickListener(this.cvw);
                        next.H(this.ekf);
                        next.setOnImageClickListener(this.aOb);
                        next.setOnLongClickListener(this.atb);
                    }
                }
                this.enC.setCommonClickListener(this.cvw);
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>(fVar.aID());
                Iterator<com.baidu.adp.widget.ListView.v> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.v next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).big() == 1) {
                        z3 = true;
                        break;
                    }
                }
                bU(arrayList);
                if (this.elf.aJX()) {
                    if (fVar.aID().size() > 0 && (postData2 = fVar.aID().get(0)) != null && postData2.big() == 1 && !com.baidu.tbadk.core.util.x.r(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int b = b(this.ekc, arrayList, this.ekb);
                    if (b >= 0) {
                        com.baidu.tbadk.core.util.x.a(arrayList, b, this.ekc.aIE());
                    }
                }
                int c = c(this.ekc, arrayList, this.ekb);
                if (c >= 0) {
                    com.baidu.tbadk.core.util.x.a(arrayList, c, this.ekc.aIF());
                }
                if (arrayList.size() == 0 && this.elf.aJX()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                int a = a(null, arrayList, this.ekb);
                if (a >= 0) {
                    List<com.baidu.adp.widget.ListView.v> c2 = c(fVar, arrayList);
                    if (c2 != null && c2.size() > 0) {
                        com.baidu.tbadk.core.util.x.a((List) arrayList, a, (List) c2);
                    } else {
                        this.enH = 0;
                    }
                } else {
                    this.enH = 0;
                }
                com.baidu.tieba.tbadkCore.s.q(arrayList, 1);
                int q = com.baidu.tbadk.core.util.x.q(arrayList);
                int i = 0;
                while (i < q) {
                    com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i);
                    if (vVar instanceof PostData) {
                        ((PostData) vVar).cdg = i == 0;
                    }
                    i++;
                }
                int a2 = a(fVar, arrayList);
                List<com.baidu.adp.widget.ListView.v> d = d(fVar);
                if (com.baidu.tbadk.core.util.x.r(d) || a2 < 0) {
                    z4 = false;
                } else {
                    com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, a2);
                    if (vVar2 instanceof PostData) {
                        ((PostData) vVar2).cdg = true;
                    }
                    com.baidu.tbadk.core.util.x.a((List) arrayList, a2, (List) d);
                    z4 = true;
                }
                int b2 = z3 ? b(fVar, arrayList) : -1;
                if (b2 >= 0 && fVar.aIY() != null) {
                    com.baidu.tbadk.core.util.x.a(arrayList, b2, fVar.aIY());
                    fVar.aIY().hY((b(arrayList, b2) || z4) ? false : true);
                    z4 = true;
                }
                this.enA.ip(z4 ? false : true);
                if (!this.ekb && fVar != null && fVar.aID() != null && (size = fVar.aID().size()) > 0 && (postData = fVar.aID().get(size - 1)) != null && postData.big() == 1 && (size2 = arrayList.size()) > 0) {
                    arrayList.remove(size2 - 1);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z && this.enW && a2 != -1 && !com.baidu.tbadk.core.util.x.r(d) && !this.enX) {
                    this.eoc = new dc(this, d);
                    com.baidu.adp.lib.g.h.fS().post(this.eoc);
                }
            }
        }
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, int i) {
        MetaData author;
        GodUserData godUserData;
        if (this.elf.aII() == null || this.elf.aJE() == null) {
            return false;
        }
        if (this.elf.aJE().aMZ() || (author = this.elf.aII().getAuthor()) == null || UtilHelper.isCurrentAccount(author.getUserId()) || (godUserData = author.getGodUserData()) == null || !godUserData.isBigV() || godUserData.getIsLike()) {
            return false;
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
        jVar.ejc = author;
        com.baidu.tbadk.core.util.x.a(arrayList, i + 1, jVar);
        jVar.ejd = true;
        return true;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        PostData postData;
        int i;
        int i2 = 0;
        if (fVar == null || com.baidu.tbadk.core.util.x.r(fVar.aID()) || arrayList == null || arrayList.size() <= 0 || this.elf.aKk() || this.enY || this.elf.aJF().getIsFromMark() || (postData = (PostData) com.baidu.tbadk.core.util.x.c(fVar.aID(), 0)) == null) {
            return -1;
        }
        int big = postData.big();
        int size = arrayList.size();
        while (true) {
            if (i2 >= size) {
                i = -1;
                break;
            }
            com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
            if (vVar != null && (vVar instanceof PostData)) {
                PostData postData2 = (PostData) vVar;
                if (postData2.big() == big && postData2.fCJ == 0) {
                    i = big == 1 ? i2 + 1 : i2;
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

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (!this.ekb) {
            return -1;
        }
        if (fVar == null || com.baidu.tbadk.core.util.x.r(fVar.aID()) || arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return -1;
            }
            com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
            if (!(vVar instanceof PostData) || ((PostData) vVar).big() != 1) {
                i = i2 + 1;
            } else {
                return i2 + 1;
            }
        }
    }

    private List<com.baidu.adp.widget.ListView.v> d(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aIL() == null || com.baidu.tbadk.core.util.x.r(fVar.aIL().eju) || this.elf.aKk() || this.enY) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aIL().eju;
        if (com.baidu.tbadk.core.util.x.r(list)) {
            return null;
        }
        for (PostData postData : list) {
            if (postData != null) {
                postData.fCL = true;
                arrayList.add(postData);
            }
        }
        int q = com.baidu.tbadk.core.util.x.q(fVar.aIL().ejv);
        if (fVar.aIL().getCount() != q && q > 2) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, arrayList.size() - 1);
            if (vVar instanceof PostData) {
                ((PostData) vVar).fCL = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, arrayList.size() - 1);
            if (vVar2 instanceof PostData) {
                ((PostData) vVar2).fCL = true;
            }
        }
        com.baidu.tieba.pb.data.k kVar = new com.baidu.tieba.pb.data.k();
        kVar.mType = 0;
        arrayList.add(0, kVar);
        return arrayList;
    }

    public void aKv() {
        this.enH = 0;
    }

    public int aKw() {
        return this.enI;
    }

    private int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || arrayList == null || com.baidu.tbadk.core.util.x.r(fVar.aID()) || com.baidu.tbadk.core.util.x.r(fVar.aIC())) {
            return -1;
        }
        if (z) {
            return (fVar.aID().get(0) == null || fVar.aID().get(0).big() != 1) ? -1 : 1;
        }
        return -1;
    }

    private List<com.baidu.adp.widget.ListView.v> c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (fVar == null || arrayList == null || fVar.aIC() == null || fVar.aIC().size() <= 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        List<com.baidu.tbadk.core.data.bl> aIC = fVar.aIC();
        int size = aIC.size();
        this.enI = 0;
        if (this.enH + 5 >= size) {
            int i = 0;
            for (com.baidu.tbadk.core.data.bl blVar : aIC) {
                if (blVar != null) {
                    com.baidu.tieba.pb.video.ac acVar = new com.baidu.tieba.pb.video.ac();
                    i++;
                    if (i == 1) {
                        acVar.a(blVar, true, true, true, i);
                    } else {
                        acVar.a(blVar, true, true, false, i);
                    }
                    arrayList2.add(acVar);
                    this.enH++;
                }
            }
            if (this.enH <= 0) {
                return null;
            }
            if (arrayList2 != null) {
                this.enI = arrayList2.size();
            }
            return arrayList2;
        }
        int i2 = this.enH + 5;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            com.baidu.tbadk.core.data.bl blVar2 = aIC.get(i4);
            if (blVar2 != null) {
                com.baidu.tieba.pb.video.ac acVar2 = new com.baidu.tieba.pb.video.ac();
                i3++;
                boolean z = i3 == 1;
                if (i4 == i2 - 1) {
                    acVar2.a(blVar2, false, true, z, i3);
                } else {
                    acVar2.a(blVar2, true, true, z, i3);
                }
                arrayList2.add(acVar2);
                this.enH++;
            }
        }
        arrayList2.add(new com.baidu.tieba.pb.video.ae());
        this.enI = arrayList2.size();
        return arrayList2;
    }

    private void abD() {
        if (this.elf != null && !abE()) {
            this.elf.registerListener(this.bYe);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean abE() {
        if (this.elf == null) {
            return false;
        }
        this.bXW = new ArrayList();
        ArrayList<BdUniqueId> bhq = com.baidu.tieba.tbadkCore.s.bhq();
        if (bhq == null || bhq.size() <= 0) {
            return false;
        }
        int size = bhq.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.g.b.ayn().a(this.elf.getPageContext(), bhq.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.bXW.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.r(this.bXW)) {
            this.mListView.addAdapters(this.bXW);
        }
        return true;
    }

    public int aKx() {
        return this.mListView.getHeaderViewsCount();
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aID() == null || fVar.aIE() == null || fVar.aID().size() == 0 || fVar.aIB() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aIE().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aID().get(0) == null || fVar.aID().get(0).big() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qx() == null || fVar.qx().qr() != fVar.qx().qo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z) {
        if (fVar == null || fVar.aID() == null || fVar.aIF() == null || fVar.aID().size() == 0 || fVar.aIB() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aIF().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aID().get(0) == null || fVar.aID().get(0).big() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.qx() == null || fVar.qx().qr() != fVar.qx().qo()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.v getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> aKy() {
        return this.postList;
    }

    public BdUniqueId ou(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if ((this.enO == null || !this.enO.aJt()) && (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    private void aKz() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        int i;
        if (this.ekc != null) {
            ArrayList<PostData> aID = this.ekc.aID();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> aIP = this.ekc.aIP();
            if (aIP != null) {
                int size = aIP.size();
                if (aID != null && aID.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it = aIP.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next = it.next();
                        if (next != null && next.bhX() != null) {
                            sb.append(next.bhX());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = aIP.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                        if (next2 != null) {
                            next2.ccu = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = aIP.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                        if (next3.bhV() != null) {
                            int pn = next3.bhV().pn();
                            if (pn != 0) {
                                if (pn == 2) {
                                    i = 11;
                                } else {
                                    i = pn == 3 ? 12 : 100;
                                }
                                a(next3, i);
                            } else if (!com.baidu.tieba.tbadkCore.ac.isInstalledPackage(TbadkCoreApplication.m9getInst().getContext(), next3.bhV().apk_name)) {
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
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(sparseArray.keyAt(i2));
                        if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.bhX(), oVar3)) != null) {
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
                    for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
                    }
                    Collections.sort(arrayList, new dd(this));
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
                        int position2 = oVar4.getPosition();
                        if (a(oVar4, aID)) {
                            a(oVar4, 100);
                        } else if (position2 + i4 >= aID.size()) {
                            a(oVar4, 2);
                            return;
                        } else {
                            if (this.ekc.aIz() != null) {
                                oVar4.forumId = this.ekc.aIz().getId();
                            }
                            if (this.ekc.aIB() != null) {
                                oVar4.threadId = com.baidu.adp.lib.g.b.c(this.ekc.aIB().getId(), 0L);
                            }
                            if (this.ekc != null && this.ekc.qx() != null) {
                                oVar4.pageNumber = this.ekc.qx().qr();
                            }
                            b(oVar4);
                            aID.add(position2, oVar4);
                            TiebaStatic.eventStat(this.elf.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", oVar4.bhV().apk_name);
                        }
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.o oVar, int i) {
        com.baidu.tieba.recapp.report.a b = com.baidu.tieba.recapp.report.e.b(oVar, 5);
        b.rl(i);
        com.baidu.tieba.recapp.report.b.bas().a(b);
    }

    private void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData aIz;
        if (oVar != null && this.ekc != null && oVar.bhV() != null) {
            oVar.bhV().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.ekc.qx() != null) {
                oVar.bhV().advertAppContext.pn = this.ekc.qx().qr();
            }
            oVar.bhV().advertAppContext.SE = "PB";
            if (this.ekc.aIz() != null && (aIz = this.ekc.aIz()) != null) {
                oVar.bhV().advertAppContext.fid = aIz.getId();
                oVar.bhV().advertAppContext.SG = aIz.getFirst_class();
                oVar.bhV().advertAppContext.SH = aIz.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.bhV().advertAppContext.SI = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.bhV().advertAppContext.extensionInfo = oVar.bhV().ext_info;
            oVar.bhV().advertAppContext.SJ = false;
        }
    }

    private boolean a(com.baidu.tieba.tbadkCore.data.o oVar, ArrayList<PostData> arrayList) {
        int q = com.baidu.tbadk.core.util.x.q(arrayList);
        if (oVar == null || q <= 0) {
            return false;
        }
        int position = oVar.getPosition();
        if (q >= 2 || position != q + 1) {
            return false;
        }
        if (this.ekc != null && this.ekc.qx() != null) {
            oVar.pageNumber = this.ekc.qx().qr();
        }
        arrayList.add(oVar);
        return true;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.enP.setFromCDN(z);
        this.enA.setFromCDN(z);
        if (this.enJ != null && (this.enJ instanceof com.baidu.tieba.recapp.v)) {
            ((com.baidu.tieba.recapp.v) this.enJ).setIsFromCDN(z);
        }
        if (this.enK != null && (this.enK instanceof com.baidu.tieba.recapp.v)) {
            ((com.baidu.tieba.recapp.v) this.enK).setIsFromCDN(z);
        }
        if (this.cbS != null && (this.cbS instanceof com.baidu.tieba.recapp.v)) {
            ((com.baidu.tieba.recapp.v) this.cbS).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.enT.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public void hZ(boolean z) {
        this.eka = z;
    }

    public void ia(boolean z) {
        this.ekb = z;
    }

    public void ib(boolean z) {
        this.enZ = z;
    }

    public void H(View.OnClickListener onClickListener) {
        this.ekf = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.aOb = eVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.d dVar) {
        this.aOc = dVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.atb = onLongClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.cvw = onClickListener;
    }

    public void ov(int i) {
        if (this.enB != null) {
            this.enB.ov(i);
        }
        switch (i) {
            case 1:
                if (this.enO != null) {
                    this.enO.pause();
                }
                if (this.enA != null) {
                    this.enA.pause();
                }
                if (this.enL != null && (this.enL instanceof com.baidu.tieba.recapp.y)) {
                    ((com.baidu.tieba.recapp.y) this.enL).release();
                    return;
                }
                return;
            case 2:
                if (this.enO != null) {
                    this.enO.resume();
                }
                if (this.enA != null) {
                    this.enA.resume();
                }
                if (this.enL != null && (this.enL instanceof com.baidu.tieba.recapp.y)) {
                    ((com.baidu.tieba.recapp.y) this.enL).resume();
                    return;
                }
                return;
            case 3:
                if (this.enO != null) {
                    this.enO.release();
                }
                if (this.enA != null) {
                    this.enA.release();
                }
                if (this.enL != null && (this.enL instanceof com.baidu.tieba.recapp.y)) {
                    ((com.baidu.tieba.recapp.y) this.enL).release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void bU(List<com.baidu.adp.widget.ListView.v> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.sp())) {
                        com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                        ahVar.cn(postData.sp());
                        list.set(i, ahVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.eoc);
    }

    public void il(boolean z) {
        this.enY = z;
    }

    public void im(boolean z) {
        this.enV = z;
    }

    public void in(boolean z) {
        this.enW = z;
    }

    public void io(boolean z) {
        this.enX = z;
    }

    public fr aKA() {
        return this.enB;
    }
}
