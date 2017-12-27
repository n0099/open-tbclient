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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class h {
    private List<com.baidu.adp.widget.ListView.a> dCg;
    private com.baidu.adp.widget.ListView.a dJD;
    private com.baidu.adp.widget.ListView.a dJE;
    private int fDu;
    private com.baidu.tieba.pb.data.f fDx;
    private PbActivity fHW;
    private q fHX;
    private ao fHY;
    private ak fHZ;
    private ak fIa;
    private k fIb;
    private com.baidu.tieba.pb.video.a fIc;
    private ag fId;
    private ah fIe;
    private com.baidu.tieba.pb.pb.a.b fIf;
    private com.baidu.tieba.pb.pb.a.e fIg;
    private v fIh;
    private ae fIi;
    private com.baidu.tieba.pb.pb.a.d fIj;
    private boolean fIn;
    private boolean fIo;
    private Runnable fIr;
    private int fIt;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> fIk = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean fDv = true;
    private boolean fDw = true;
    private boolean fIl = false;
    private boolean fIm = false;
    private boolean fIp = false;
    private String mHostId = null;
    private View.OnClickListener fDA = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h bJx = null;
    private com.baidu.tieba.pb.a.c bJy = null;
    private View.OnLongClickListener bjN = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> fIq = new ArrayList();
    private int fIs = -1;
    private CustomMessageListener dCp = new CustomMessageListener(CmdConfigCustom.PB_ADD_ADAPTER) { // from class: com.baidu.tieba.pb.pb.main.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bBL = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bBL();
                Iterator it = bBL.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof m) {
                        ((m) aVar).ao(h.this.fHW);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            h.this.fIk.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            h.this.fIf = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bBL);
                h.this.fIq.clear();
                h.this.fIq.addAll(arrayList);
                if (h.this.mListView != null) {
                    h.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener dxK = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tieba.pb.pb.main.h.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && h.this.fDx != null && !com.baidu.adp.base.i.ai(h.this.fHW.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                Iterator<DownloadData> it = data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next().getStatus() == 0) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dCq = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.pb.pb.main.h.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.v.G(h.this.dCg)) {
                h.this.ave();
                h.this.a(h.this.fDx, false);
            }
        }
    };

    public h(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fDu = 0;
        this.width = -1;
        this.fIt = 0;
        this.fDu = com.baidu.adp.lib.util.l.ao(pbActivity.getPageContext().getPageActivity());
        this.width = this.fDu;
        this.fHW = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.dxK);
        this.fIt = com.baidu.adp.lib.util.l.aq(this.fHW) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.fIg = new com.baidu.tieba.pb.pb.a.e(pbActivity, PostData.hiI);
        this.fHX = new q(pbActivity, PostData.hiF);
        this.fHX.a(pbActivity);
        this.fHY = new ao(pbActivity, com.baidu.tieba.pb.data.l.fCH);
        this.fHZ = new ak(pbActivity, com.baidu.tieba.pb.data.j.fCA);
        this.fIa = new ak(pbActivity, com.baidu.tieba.pb.data.j.fCB);
        this.fIb = new k(pbActivity, PostData.hiG);
        this.fIb.a(pbActivity);
        this.dJD = com.baidu.tieba.recapp.q.bty().a(pbActivity, AdvertAppInfo.aIZ);
        this.dJE = com.baidu.tieba.recapp.q.bty().a(pbActivity, AdvertAppInfo.aJd);
        this.fIh = new v(pbActivity, com.baidu.tieba.pb.data.a.fBC);
        this.fIi = new ae(pbActivity, com.baidu.tieba.pb.data.i.fCz);
        this.fId = new ag(pbActivity, ad.fNb);
        this.fIe = new ah(pbActivity, com.baidu.tbadk.core.data.ap.aMl);
        this.fIj = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.hiM);
        this.fIc = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fWl);
        this.fIc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.fDx.aYM() != null) {
                    pbActivity.bad().bdh().aZF();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12040"));
                }
            }
        });
        this.mAdapters.add(this.fHX);
        this.mAdapters.add(this.fHY);
        this.mAdapters.add(this.fIb);
        this.mAdapters.add(this.fHZ);
        this.mAdapters.add(this.fIa);
        this.mAdapters.add(this.fIg);
        this.mAdapters.add(this.dJD);
        this.mAdapters.add(this.dJE);
        this.mAdapters.add(this.fIh);
        this.mAdapters.add(this.fIi);
        this.mAdapters.add(this.fId);
        this.mAdapters.add(this.fIe);
        this.mAdapters.add(this.fIc);
        this.mAdapters.add(this.fIj);
        this.dCp.setPriority(1);
        this.dCp.setSelfListener(true);
        pbActivity.registerListener(this.dCp);
        avd();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.PB_ADD_ADAPTER, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.PB_ADD_ADAPTER);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.f fVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        PostData postData2;
        boolean z5;
        boolean z6;
        com.baidu.adp.widget.ListView.i bbc;
        PostData postData3;
        if (fVar != null) {
            if (this.fDx != fVar) {
                z2 = (fVar == null || fVar.aYw()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.fDx = fVar;
            if (z2) {
                bbg();
                if (fVar != null) {
                    fVar.jy(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.fDx != null && this.fDx.aYC() != null && this.fDx.aYC().size() > 0) {
                this.postList.addAll(this.fDx.aYC());
            }
            if (fVar != null && fVar.aYA() != null && fVar.aYA().yX() != null) {
                this.mHostId = fVar.aYA().yX().getUserId();
            }
            if (this.fHX != null) {
                this.fIg.b(fVar);
                this.fIg.setFromCDN(this.mIsFromCDN);
                this.fIg.setHostId(this.mHostId);
                this.fIg.sI(this.fDu);
                this.fIg.jA(this.fDv);
                this.fIg.jB(this.fDw);
                this.fIg.setCommonClickListener(this.mCommonClickListener);
                this.fIg.D(this.fDA);
                this.fIg.setOnImageClickListener(this.bJx);
                this.fIg.setOnLongClickListener(this.bjN);
                this.fHX.b(fVar);
                this.fHX.setFromCDN(this.mIsFromCDN);
                this.fHX.sI(this.fDu);
                this.fHX.jA(this.fDv);
                this.fHX.setCommonClickListener(this.mCommonClickListener);
                this.fHX.D(this.fDA);
                this.fHX.setOnImageClickListener(this.bJx);
                this.fHX.setOnLongClickListener(this.bjN);
                this.fHX.setTbGestureDetector(this.bJy);
                this.fIb.b(fVar);
                this.fIb.setFromCDN(this.mIsFromCDN);
                this.fIb.setHostId(this.mHostId);
                this.fIb.jA(this.fDv);
                this.fIb.setCommonClickListener(this.mCommonClickListener);
                this.fIb.D(this.fDA);
                this.fIb.setOnImageClickListener(this.bJx);
                this.fIb.setOnLongClickListener(this.bjN);
                this.fIb.setTbGestureDetector(this.bJy);
                this.fHY.setOnClickListener(this.mCommonClickListener);
                this.fHY.setTbGestureDetector(this.bJy);
                this.fIj.setOnClickListener(this.mCommonClickListener);
                if (this.dJE != null && (this.dJE instanceof com.baidu.tieba.recapp.n)) {
                    ((com.baidu.tieba.recapp.n) this.dJE).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fIk.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(fVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.sI(this.fDu);
                        next.jA(this.fDv);
                        next.jB(this.fDw);
                        next.jC(this.fIp);
                        next.setCommonClickListener(this.mCommonClickListener);
                        next.D(this.fDA);
                        next.setOnImageClickListener(this.bJx);
                        next.setOnLongClickListener(this.bjN);
                    }
                }
                this.fHZ.setCommonClickListener(this.mCommonClickListener);
                this.fIa.setCommonClickListener(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>(fVar.aYC());
                Iterator<com.baidu.adp.widget.ListView.i> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bCl() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.fDw && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, postData);
                    if (fVar.aYZ() && postData.bCo() != null) {
                        postData.d(null);
                    }
                    z3 = true;
                }
                if (z3 || fVar.aYI() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData aYI = fVar.aYI();
                    com.baidu.tbadk.core.util.v.a(arrayList, 0, fVar.aYI());
                    if (!this.fDw && fVar.aYZ() && aYI.bCo() != null) {
                        aYI.d(null);
                    }
                    postData2 = aYI;
                    z4 = true;
                }
                cU(arrayList);
                if (this.fHW.baB()) {
                    if (fVar.aYC().size() > 0 && (postData3 = fVar.aYC().get(0)) != null && postData3.bCl() == 1 && !com.baidu.tbadk.core.util.v.G(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.fDx, arrayList, this.fDw);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.v.a(arrayList, a, this.fDx.aYD());
                    }
                }
                int b = b(this.fDx, arrayList, this.fDw);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, b, this.fDx.aYE());
                }
                if (arrayList.size() == 0 && this.fHW.baB()) {
                    arrayList.add(new com.baidu.tieba.pb.data.i());
                }
                com.baidu.tieba.tbadkCore.q.s(arrayList, 1);
                int c = c(fVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.fCA);
                    if (fVar != null && fVar.aYA() != null) {
                        jVar.fCC = fVar.aYA().yP();
                    }
                    jVar.btL = !this.fDw;
                    jVar.fCE = this.fHW.baO();
                    com.baidu.tbadk.core.util.v.a(arrayList, c, jVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(fVar, arrayList);
                final List<com.baidu.adp.widget.ListView.i> g = g(fVar);
                if (!com.baidu.tbadk.core.util.v.G(g) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, b2);
                    if (iVar instanceof PostData) {
                        ((PostData) iVar).hjr = true;
                    }
                    com.baidu.tbadk.core.util.v.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(fVar, arrayList) : -1;
                if (d < 0 || fVar.aYY() == null) {
                    z6 = false;
                } else {
                    com.baidu.tbadk.core.util.v.a(arrayList, d, fVar.aYY());
                    fVar.aYY().jz((b(arrayList, d) || z5) ? false : true);
                    z6 = true;
                    z5 = true;
                }
                if (z4 && (bbc = bbc()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.v.a(arrayList, d + 1, bbc);
                }
                this.fHX.jS(!z5);
                boolean z7 = (this.fHW.aZK() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.fHW.aZK().getPostId())) ? false : true;
                if (this.fIl && !z7) {
                    arrayList.remove(postData2);
                    this.fIl = false;
                }
                if (z6 && (com.baidu.tbadk.core.util.v.f(arrayList, 0) instanceof com.baidu.tieba.pb.data.l)) {
                    jR(false);
                } else {
                    jR(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z7 && !z) {
                    if ((this.fIn || this.fIm) && b2 != -1 && !com.baidu.tbadk.core.util.v.G(g) && !this.fIo) {
                        this.fIr = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.h.4
                            @Override // java.lang.Runnable
                            public void run() {
                                h.this.mListView.setSelectionFromTop(h.this.mListView.getHeaderViewsCount() + g.size(), 0 - h.this.fIt);
                                h.this.fIo = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.nr().post(this.fIr);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.i bbc() {
        PbModel aZK = this.fHW.aZK();
        if (aZK == null) {
            return null;
        }
        String bcm = aZK.bcm();
        if (TextUtils.isEmpty(bcm)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.tc(bcm);
        b(lVar);
        return lVar;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, int i) {
        if (this.fHW.aYI() == null || this.fHW.bad() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (this.fIm || fVar == null || com.baidu.tbadk.core.util.v.G(fVar.aYC()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar != null && fVar.aYZ() && this.fDw) ? 0 : -1;
        } else if (this.fHW.aZK() == null || !this.fHW.aZK().getIsFromMark()) {
            if (this.fHW.bad() == null || !this.fHW.bad().getIsInterviewLive()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.i iVar = arrayList.get(i2);
                    if (iVar instanceof PostData) {
                        PostData postData = (PostData) iVar;
                        if (postData.bCl() == 1 && postData.hjo == 0) {
                            z = true;
                            i = i2;
                            break;
                        }
                    }
                    i2++;
                }
                if (z) {
                    return i + 1;
                }
                return fVar.aYZ() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        boolean z;
        int i;
        if (fVar == null || com.baidu.tbadk.core.util.v.G(fVar.aYC()) || com.baidu.tbadk.core.util.v.G(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.v.f(fVar.aYC(), 0)) == null) {
            return 0;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = false;
                i = 0;
                break;
            }
            com.baidu.adp.widget.ListView.i iVar = arrayList.get(i2);
            if (iVar instanceof PostData) {
                PostData postData = (PostData) iVar;
                if (postData.bCl() == 1 && postData.hjo == 0) {
                    z = true;
                    i = i2;
                    break;
                }
            }
            i2++;
        }
        if (z) {
            return i + 1;
        }
        return 0;
    }

    private int d(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (fVar == null || com.baidu.tbadk.core.util.v.G(fVar.aYC()) || arrayList == null || arrayList.size() <= 0) {
            return (fVar == null || !fVar.aYZ()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.i iVar = arrayList.get(i);
            if ((iVar instanceof PostData) && ((PostData) iVar).bCl() == 1) {
                return i + 1;
            }
        }
        return !fVar.aYZ() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.i> g(com.baidu.tieba.pb.data.f fVar) {
        if (fVar == null || fVar.aYM() == null || com.baidu.tbadk.core.util.v.G(fVar.aYM().fCX)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = fVar.aYM().fCX;
        if (com.baidu.tbadk.core.util.v.G(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.hjq = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.v.F(fVar.aYM().fCY) > 2) {
            com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar instanceof PostData) {
                ((PostData) iVar).hjq = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) com.baidu.tbadk.core.util.v.f(arrayList, arrayList.size() - 1);
            if (iVar2 instanceof PostData) {
                ((PostData) iVar2).hjq = true;
            }
        }
        com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j(com.baidu.tieba.pb.data.j.fCB);
        jVar.fCD = fVar.aYM().forum_top_list;
        arrayList.add(0, jVar);
        return arrayList;
    }

    private void avd() {
        if (this.fHW != null && !ave()) {
            this.fHW.registerListener(this.dCq);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ave() {
        if (this.fHW == null) {
            return false;
        }
        this.dCg = new ArrayList();
        ArrayList<BdUniqueId> bBv = com.baidu.tieba.tbadkCore.q.bBv();
        if (bBv == null || bBv.size() <= 0) {
            return false;
        }
        int size = bBv.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aPk().a(this.fHW.getPageContext(), bBv.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dCg.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.G(this.dCg)) {
            this.mListView.addAdapters(this.dCg);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (fVar == null || fVar.aYC() == null || fVar.aYD() == null || fVar.aYC().size() == 0 || fVar.aYA() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aYD().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aYC().get(0) == null || fVar.aYC().get(0).bCl() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.yb() == null || fVar.yb().xV() != fVar.yb().xS()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.f fVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z) {
        if (fVar == null || fVar.aYC() == null || fVar.aYE() == null || fVar.aYC().size() == 0 || fVar.aYA() == null || arrayList == null) {
            return -1;
        }
        if (fVar.aYE().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (fVar.aYC().get(0) == null || fVar.aYC().get(0).bCl() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (fVar.yb() == null || fVar.yb().xV() != fVar.yb().xS()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.i getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bbd() {
        return this.postList;
    }

    public BdUniqueId sP(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fIf == null || !this.fIf.aZD()) {
            this.fIs = bbe();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bbe() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = this.mListView.getData().get(i2);
                if (iVar == null || iVar.getType() != com.baidu.tieba.pb.data.j.fCA) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bbf() {
        return this.fIs;
    }

    private void bbg() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.fDx != null) {
            ArrayList<PostData> aYC = this.fDx.aYC();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> aYQ = this.fDx.aYQ();
            if (aYQ != null) {
                int size = aYQ.size();
                if (aYC != null && aYC.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = aYQ.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.getAdId() != null) {
                            sb.append(next.getAdId());
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = aYQ.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dKg = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = aYQ.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bBZ() != null) {
                            int wZ = next3.bBZ().wZ();
                            if (wZ != 0) {
                                a(next3, wZ);
                                if (wZ != 28 && wZ != 31) {
                                    if (next3.bBZ().goods != null) {
                                        next3.bBZ().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.v.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bBZ().apk_name)) {
                                int position = next3.getPosition();
                                if (position >= 1 && position < 30) {
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
                        com.baidu.tieba.tbadkCore.data.l lVar3 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(sparseArray.keyAt(i));
                        if (lVar3 != null && (lVar2 = (com.baidu.tieba.tbadkCore.data.l) hashMap.put(lVar3.getAdId(), lVar3)) != null) {
                            b(lVar2, 30);
                        }
                    }
                    sparseArray.clear();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        if (entry != null && (lVar = (com.baidu.tieba.tbadkCore.data.l) entry.getValue()) != null) {
                            sparseArray.put(lVar.getPosition(), lVar);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                    }
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.h.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.fDx.aYy() != null) {
                            lVar4.forumId = this.fDx.aYy().getId();
                        }
                        if (this.fDx.aYA() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.fDx.aYA().getId(), 0L);
                        }
                        if (this.fDx != null && this.fDx.yb() != null) {
                            lVar4.pageNumber = this.fDx.yb().xV();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= aYC.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.fDw) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        aYC.add(position2, lVar4);
                        TiebaStatic.eventStat(this.fHW.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bBZ().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.vT(i);
        com.baidu.tieba.recapp.report.b.bui().a(c);
        if (lVar != null && lVar.bBZ() != null) {
            lVar.bBZ().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bBZ() != null && lVar.bBZ().goods != null && lVar.bBZ().goods.goods_style != 1001 && lVar.bBZ().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData aYy;
        if (lVar != null && this.fDx != null && lVar.bBZ() != null) {
            lVar.bBZ().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.fDx.yb() != null) {
                lVar.bBZ().advertAppContext.pn = this.fDx.yb().xV();
            }
            lVar.bBZ().advertAppContext.aIO = "PB";
            if (this.fDx.aYy() != null && (aYy = this.fDx.aYy()) != null) {
                lVar.bBZ().advertAppContext.fid = aYy.getId();
                lVar.bBZ().advertAppContext.aIQ = aYy.getFirst_class();
                lVar.bBZ().advertAppContext.aIR = aYy.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bBZ().advertAppContext.aIS = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bBZ().advertAppContext.extensionInfo = lVar.bBZ().ext_info;
            lVar.bBZ().advertAppContext.aIT = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.fIg.setFromCDN(z);
        this.fHX.setFromCDN(z);
        if (this.dJE != null && (this.dJE instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.dJE).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.fIk.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bbh() {
        return this.fDv;
    }

    public void jA(boolean z) {
        this.fDv = z;
    }

    public void jB(boolean z) {
        this.fDw = z;
    }

    public void jC(boolean z) {
        this.fIp = z;
    }

    public void D(View.OnClickListener onClickListener) {
        this.fDA = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.bJx = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.bJy = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bjN = onLongClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void sQ(int i) {
        if (this.fHY != null) {
            this.fHY.sQ(i);
        }
        switch (i) {
            case 1:
                if (this.fIf != null) {
                    this.fIf.pause();
                }
                if (this.fHX != null) {
                    this.fHX.pause();
                    return;
                }
                return;
            case 2:
                if (this.fIf != null) {
                    this.fIf.resume();
                }
                if (this.fHX != null) {
                    this.fHX.resume();
                    return;
                }
                return;
            case 3:
                if (this.fIf != null) {
                    this.fIf.release();
                }
                if (this.fHX != null) {
                    this.fHX.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cU(List<com.baidu.adp.widget.ListView.i> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.zT())) {
                        com.baidu.tbadk.core.data.ac acVar = new com.baidu.tbadk.core.data.ac();
                        acVar.cJ(postData.zT());
                        list.set(i, acVar);
                    }
                }
            }
        }
    }

    public void onDestory() {
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.fIr);
        if (this.fHZ != null) {
            this.fHZ.onDestory();
        }
    }

    public void jN(boolean z) {
        this.fIm = z;
    }

    public void jO(boolean z) {
        this.fIn = z;
    }

    public void jP(boolean z) {
        this.fIl = z;
    }

    public void jQ(boolean z) {
        this.fIo = z;
    }

    public ao bbi() {
        return this.fHY;
    }

    public void jR(boolean z) {
        if (this.fHY != null) {
            this.fHY.fOn = z;
        }
    }
}
