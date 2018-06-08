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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class f {
    private List<com.baidu.adp.widget.ListView.a> dnB;
    private com.baidu.adp.widget.ListView.a dwe;
    private com.baidu.adp.widget.ListView.a dwf;
    private ad ftA;
    private com.baidu.tieba.pb.pb.a.d ftB;
    private an ftC;
    private com.baidu.tieba.pb.data.d ftE;
    private boolean ftJ;
    private boolean ftK;
    private int ftM;
    private Runnable ftP;
    private int ftR;
    private PbActivity ftp;
    private o ftq;
    private ao ftr;
    private aj fts;
    private aj ftt;
    private i ftu;
    private com.baidu.tieba.pb.video.a ftv;
    private af ftw;
    private ag ftx;
    private com.baidu.tieba.pb.pb.a.b fty;
    private u ftz;
    private BdTypeListView mListView;
    private int width;
    private ArrayList<com.baidu.tieba.pb.pb.a.a> ftD = new ArrayList<>();
    private ArrayList<PostData> postList = new ArrayList<>();
    private boolean mIsFromCDN = false;
    private boolean ftF = true;
    private boolean ftG = true;
    private boolean ftH = false;
    private boolean ftI = false;
    private boolean ftL = false;
    private String mHostId = null;
    private View.OnClickListener ftN = null;
    private View.OnClickListener mCommonClickListener = null;
    private TbRichTextView.h beD = null;
    private com.baidu.tieba.pb.a.c beE = null;
    private View.OnLongClickListener aGs = null;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> ftO = new ArrayList();
    private int ftQ = -1;
    private CustomMessageListener dmI = new CustomMessageListener(2004015) { // from class: com.baidu.tieba.pb.pb.main.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.d)) {
                AbsDelegateAdapterList bwB = ((com.baidu.tieba.tbadkCore.data.d) customResponsedMessage.getData()).bwB();
                Iterator it = bwB.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).ap(f.this.ftp);
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.a) {
                            f.this.ftD.add((com.baidu.tieba.pb.pb.a.a) aVar);
                        }
                        if (aVar instanceof com.baidu.tieba.pb.pb.a.b) {
                            f.this.fty = (com.baidu.tieba.pb.pb.a.b) aVar;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(bwB);
                f.this.ftO.clear();
                f.this.ftO.addAll(arrayList);
                if (f.this.mListView != null) {
                    f.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private final CustomMessageListener aDd = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.pb.pb.main.f.2
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            boolean z;
            if (customResponsedMessage != null && f.this.ftE != null && !com.baidu.adp.base.i.ab(f.this.ftp.getActivity()).isScroll() && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
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
                    com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.notifyDataSetChanged();
                        }
                    }, TimeUnit.SECONDS.toMillis(2L));
                }
            }
        }
    };
    private CustomMessageListener dnK = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.pb.pb.main.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && com.baidu.tbadk.core.util.w.z(f.this.dnB)) {
                f.this.avO();
                f.this.a(f.this.ftE, false);
            }
        }
    };

    public f(PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ftM = 0;
        this.width = -1;
        this.ftR = 0;
        this.ftM = com.baidu.adp.lib.util.l.ah(pbActivity.getPageContext().getPageActivity());
        this.width = this.ftM;
        this.ftp = pbActivity;
        this.mListView = bdTypeListView;
        a(pbActivity, bdTypeListView);
        pbActivity.registerListener(this.aDd);
        this.ftR = com.baidu.adp.lib.util.l.aj(this.ftp) / 3;
    }

    public void a(final PbActivity pbActivity, BdTypeListView bdTypeListView) {
        this.ftq = new o(pbActivity, PostData.gIU);
        this.ftq.a(pbActivity);
        this.ftr = new ao(pbActivity, com.baidu.tieba.pb.data.j.fpi);
        this.fts = new aj(pbActivity, com.baidu.tieba.pb.data.h.fpb);
        this.ftt = new aj(pbActivity, com.baidu.tieba.pb.data.h.fpc);
        this.ftu = new i(pbActivity, PostData.gIV);
        this.ftu.a(pbActivity);
        this.dwe = com.baidu.tieba.recapp.r.boj().a(pbActivity, AdvertAppInfo.adz);
        this.dwf = com.baidu.tieba.recapp.r.boj().a(pbActivity, AdvertAppInfo.adD);
        this.ftz = new u(pbActivity, com.baidu.tieba.pb.data.a.foj);
        this.ftA = new ad(pbActivity, com.baidu.tieba.pb.data.g.fpa);
        this.ftw = new af(pbActivity, ac.fyG);
        this.ftx = new ag(pbActivity, com.baidu.tbadk.core.data.ap.agW);
        this.ftB = new com.baidu.tieba.pb.pb.a.d(pbActivity, PostData.gIZ);
        this.ftC = new an(pbActivity, ForumData.FORUM_FLOOR_TYPE);
        this.ftv = new com.baidu.tieba.pb.video.a(pbActivity, com.baidu.tieba.pb.video.b.fHZ);
        this.ftv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ftE.baz() != null) {
                    pbActivity.bbK().beM().bbo();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.am("c12040"));
                }
            }
        });
        this.mAdapters.add(this.ftq);
        this.mAdapters.add(this.ftr);
        this.mAdapters.add(this.ftu);
        this.mAdapters.add(this.fts);
        this.mAdapters.add(this.ftt);
        this.mAdapters.add(this.dwe);
        this.mAdapters.add(this.dwf);
        this.mAdapters.add(this.ftz);
        this.mAdapters.add(this.ftA);
        this.mAdapters.add(this.ftw);
        this.mAdapters.add(this.ftx);
        this.mAdapters.add(this.ftv);
        this.mAdapters.add(this.ftB);
        this.mAdapters.add(this.ftC);
        this.dmI.setPriority(1);
        this.dmI.setSelfListener(true);
        pbActivity.registerListener(this.dmI);
        avN();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new com.baidu.tieba.tbadkCore.data.d(pbActivity.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
        CustomMessage customMessage = new CustomMessage(2004015);
        customMessage.setTag(pbActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        PostData postData2;
        boolean z5;
        boolean z6;
        boolean z7;
        com.baidu.adp.widget.ListView.h bcJ;
        PostData postData3;
        if (dVar != null) {
            if (this.ftE != dVar) {
                z2 = (dVar == null || dVar.bal()) && TbadkCoreApplication.getInst().isRecAppExist();
            } else {
                z2 = false;
            }
            this.ftE = dVar;
            if (z2) {
                bcN();
                if (dVar != null) {
                    dVar.jv(false);
                }
            }
            if (this.postList == null) {
                this.postList = new ArrayList<>();
            }
            this.postList.clear();
            if (this.ftE != null && this.ftE.baq() != null && this.ftE.baq().size() > 0) {
                this.postList.addAll(this.ftE.baq());
            }
            if (dVar != null && dVar.bao() != null && dVar.bao().vm() != null) {
                this.mHostId = dVar.bao().vm().getUserId();
            }
            if (this.ftq != null) {
                this.ftq.b(dVar);
                this.ftq.setFromCDN(this.mIsFromCDN);
                this.ftq.ql(this.ftM);
                this.ftq.jx(this.ftF);
                this.ftq.n(this.mCommonClickListener);
                this.ftq.F(this.ftN);
                this.ftq.setOnImageClickListener(this.beD);
                this.ftq.setOnLongClickListener(this.aGs);
                this.ftq.setTbGestureDetector(this.beE);
                this.ftu.b(dVar);
                this.ftu.setFromCDN(this.mIsFromCDN);
                this.ftu.setHostId(this.mHostId);
                this.ftu.jx(this.ftF);
                this.ftu.n(this.mCommonClickListener);
                this.ftu.F(this.ftN);
                this.ftu.setOnImageClickListener(this.beD);
                this.ftu.setOnLongClickListener(this.aGs);
                this.ftu.setTbGestureDetector(this.beE);
                this.ftr.setOnClickListener(this.mCommonClickListener);
                this.ftr.setTbGestureDetector(this.beE);
                this.ftB.setOnClickListener(this.mCommonClickListener);
                if (this.dwf != null && (this.dwf instanceof com.baidu.tieba.recapp.m)) {
                    ((com.baidu.tieba.recapp.m) this.dwf).setIsFromCDN(this.mIsFromCDN);
                }
                Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ftD.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.pb.pb.a.a next = it.next();
                    if (next != null) {
                        next.b(dVar);
                        next.setFromCDN(this.mIsFromCDN);
                        next.setHostId(this.mHostId);
                        next.ql(this.ftM);
                        next.jx(this.ftF);
                        next.jy(this.ftG);
                        next.jz(this.ftL);
                        next.n(this.mCommonClickListener);
                        next.F(this.ftN);
                        next.setOnImageClickListener(this.beD);
                        next.setOnLongClickListener(this.aGs);
                    }
                }
                this.fts.n(this.mCommonClickListener);
                this.ftt.n(this.mCommonClickListener);
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>(dVar.baq());
                Iterator<com.baidu.adp.widget.ListView.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        postData = null;
                        z3 = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next2 = it2.next();
                    if ((next2 instanceof PostData) && ((PostData) next2).bwZ() == 1) {
                        postData = (PostData) next2;
                        z3 = true;
                        break;
                    }
                }
                if (!this.ftG && postData != null) {
                    arrayList.remove(postData);
                    com.baidu.tbadk.core.util.w.a(arrayList, 0, postData);
                    if (dVar.baL() && postData.bxb() != null) {
                        postData.c(null);
                    }
                    z3 = true;
                }
                if (z3 || dVar.bav() == null) {
                    z4 = z3;
                    postData2 = postData;
                } else {
                    PostData bav = dVar.bav();
                    com.baidu.tbadk.core.util.w.a(arrayList, 0, dVar.bav());
                    if (!this.ftG && dVar.baL() && bav.bxb() != null) {
                        bav.c(null);
                    }
                    postData2 = bav;
                    z4 = true;
                }
                cU(arrayList);
                if (this.ftp.bch()) {
                    if (dVar.baq().size() > 0 && (postData3 = dVar.baq().get(0)) != null && postData3.bwZ() == 1 && !com.baidu.tbadk.core.util.w.z(arrayList)) {
                        arrayList.remove(0);
                    }
                } else {
                    int a = a(this.ftE, arrayList, this.ftG);
                    if (a >= 0) {
                        com.baidu.tbadk.core.util.w.a(arrayList, a, this.ftE.bar());
                    }
                }
                int b = b(this.ftE, arrayList, this.ftG);
                if (b >= 0) {
                    com.baidu.tbadk.core.util.w.a(arrayList, b, this.ftE.bas());
                }
                if (arrayList.size() == 0 && this.ftp.bch()) {
                    arrayList.add(new com.baidu.tieba.pb.data.g());
                }
                com.baidu.tieba.tbadkCore.q.o(arrayList, 1);
                int c = c(dVar, arrayList);
                if (c >= 0) {
                    com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fpb);
                    if (dVar != null && dVar.bao() != null) {
                        hVar.fpd = dVar.bao().ve();
                    }
                    hVar.isNew = !this.ftG;
                    hVar.fpf = this.ftp.bct();
                    com.baidu.tbadk.core.util.w.a(arrayList, c, hVar);
                    z5 = true;
                } else {
                    z5 = false;
                }
                int b2 = b(dVar, arrayList);
                final List<com.baidu.adp.widget.ListView.h> g = g(dVar);
                if (!com.baidu.tbadk.core.util.w.z(g) && b2 >= 0) {
                    com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.c(arrayList, b2);
                    if (hVar2 instanceof PostData) {
                        ((PostData) hVar2).gJE = true;
                    }
                    com.baidu.tbadk.core.util.w.a((List) arrayList, b2, (List) g);
                    z5 = true;
                }
                int d = z4 ? d(dVar, arrayList) : -1;
                if (d < 0 || dVar.baK() == null) {
                    z6 = z5;
                    z7 = false;
                } else {
                    com.baidu.tbadk.core.util.w.a(arrayList, d, dVar.baK());
                    dVar.baK().jw((b(arrayList, d) || z5) ? false : true);
                    z7 = true;
                    z6 = true;
                }
                if (!this.ftp.bcq() && this.ftE != null && this.ftE.bam() != null && !StringUtils.isNull(this.ftE.bam().getName()) && !StringUtils.isNull(this.ftE.bam().getId())) {
                    d++;
                    com.baidu.tbadk.core.util.w.a(arrayList, d, this.ftE.bam());
                    if (this.ftC != null && this.ftE.bao() != null) {
                        this.ftC.setThreadId(this.ftE.bao().getId());
                    }
                }
                if (z4 && (bcJ = bcJ()) != null && d >= 0) {
                    com.baidu.tbadk.core.util.w.a(arrayList, d + 1, bcJ);
                }
                this.ftq.jP(!z6);
                boolean z8 = (this.ftp.bbt() == null || postData2 == null || postData2.getId() == null || !postData2.getId().equals(this.ftp.bbt().getPostId())) ? false : true;
                if (this.ftH && !z8) {
                    arrayList.remove(postData2);
                    this.ftH = false;
                }
                if (z7 && (com.baidu.tbadk.core.util.w.c(arrayList, 0) instanceof com.baidu.tieba.pb.data.j)) {
                    jO(false);
                } else {
                    jO(true);
                }
                if (this.mListView != null) {
                    this.mListView.setData(arrayList);
                }
                if (!z8 && !z) {
                    if ((this.ftJ || this.ftI) && b2 != -1 && !com.baidu.tbadk.core.util.w.z(g) && !this.ftK) {
                        this.ftP = new Runnable() { // from class: com.baidu.tieba.pb.pb.main.f.4
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.mListView.setSelectionFromTop(f.this.mListView.getHeaderViewsCount() + g.size(), 0 - f.this.ftR);
                                f.this.ftK = false;
                            }
                        };
                        com.baidu.adp.lib.g.e.im().post(this.ftP);
                    }
                }
            }
        }
    }

    private com.baidu.adp.widget.ListView.h bcJ() {
        PbModel bbt = this.ftp.bbt();
        if (bbt == null) {
            return null;
        }
        String bdS = bbt.bdS();
        if (TextUtils.isEmpty(bdS)) {
            return null;
        }
        com.baidu.tieba.tbadkCore.data.l lVar = new com.baidu.tieba.tbadkCore.data.l();
        lVar.tM(bdS);
        b(lVar);
        return lVar;
    }

    private boolean b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, int i) {
        if (this.ftp.bav() == null || this.ftp.bbK() == null) {
        }
        return false;
    }

    private int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (this.ftI || dVar == null || com.baidu.tbadk.core.util.w.z(dVar.baq()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar != null && dVar.baL() && this.ftG) ? 0 : -1;
        } else if (this.ftp.bbt() == null || !this.ftp.bbt().getIsFromMark()) {
            if (this.ftp.bbK() == null || !this.ftp.bbK().bfL()) {
                int size = arrayList.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        i = -1;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
                    if (hVar instanceof PostData) {
                        PostData postData = (PostData) hVar;
                        if (postData.bwZ() == 1 && postData.gJB == 0) {
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
                return dVar.baL() ? 0 : -1;
            }
            return -1;
        } else {
            return -1;
        }
    }

    private int c(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        boolean z;
        int i;
        if (dVar == null || com.baidu.tbadk.core.util.w.z(dVar.baq()) || com.baidu.tbadk.core.util.w.z(arrayList)) {
            return 0;
        }
        if (((PostData) com.baidu.tbadk.core.util.w.c(dVar.baq(), 0)) == null) {
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
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
            if (hVar instanceof PostData) {
                PostData postData = (PostData) hVar;
                if (postData.bwZ() == 1 && postData.gJB == 0) {
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

    private int d(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (dVar == null || com.baidu.tbadk.core.util.w.z(dVar.baq()) || arrayList == null || arrayList.size() <= 0) {
            return (dVar == null || !dVar.baL()) ? -1 : 0;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i);
            if ((hVar instanceof PostData) && ((PostData) hVar).bwZ() == 1) {
                return i + 1;
            }
        }
        return !dVar.baL() ? -1 : 0;
    }

    private List<com.baidu.adp.widget.ListView.h> g(com.baidu.tieba.pb.data.d dVar) {
        if (dVar == null || dVar.baz() == null || com.baidu.tbadk.core.util.w.z(dVar.baz().fpy)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<PostData> list = dVar.baz().fpy;
        if (com.baidu.tbadk.core.util.w.z(list)) {
            return null;
        }
        int min = Math.min(2, list.size());
        for (int i = 0; i < min; i++) {
            PostData postData = list.get(i);
            if (postData != null) {
                postData.gJD = true;
                arrayList.add(postData);
            }
        }
        if (com.baidu.tbadk.core.util.w.y(dVar.baz().fpz) > 2) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.c(arrayList, arrayList.size() - 1);
            if (hVar instanceof PostData) {
                ((PostData) hVar).gJD = false;
            }
            arrayList.add(new com.baidu.tieba.pb.video.b());
        } else {
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) com.baidu.tbadk.core.util.w.c(arrayList, arrayList.size() - 1);
            if (hVar2 instanceof PostData) {
                ((PostData) hVar2).gJD = true;
            }
        }
        com.baidu.tieba.pb.data.h hVar3 = new com.baidu.tieba.pb.data.h(com.baidu.tieba.pb.data.h.fpc);
        hVar3.fpe = dVar.baz().forum_top_list;
        arrayList.add(0, hVar3);
        return arrayList;
    }

    private void avN() {
        if (this.ftp != null && !avO()) {
            this.ftp.registerListener(this.dnK);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean avO() {
        if (this.ftp == null) {
            return false;
        }
        this.dnB = new ArrayList();
        ArrayList<BdUniqueId> bwn = com.baidu.tieba.tbadkCore.q.bwn();
        if (bwn == null || bwn.size() <= 0) {
            return false;
        }
        int size = bwn.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRa().a(this.ftp.getPageContext(), bwn.get(i), 2);
            if (a != null) {
                this.mAdapters.add(a);
                this.dnB.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.w.z(this.dnB)) {
            this.mListView.addAdapters(this.dnB);
        }
        return true;
    }

    public int getHeaderCount() {
        return this.mListView.getHeaderViewsCount();
    }

    public int a(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.baq() == null || dVar.bar() == null || dVar.baq().size() == 0 || dVar.bao() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bar().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.baq().get(0) == null || dVar.baq().get(0).bwZ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.uB() == null || dVar.uB().uv() != dVar.uB().us()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public int b(com.baidu.tieba.pb.data.d dVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, boolean z) {
        if (dVar == null || dVar.baq() == null || dVar.bas() == null || dVar.baq().size() == 0 || dVar.bao() == null || arrayList == null) {
            return -1;
        }
        if (dVar.bas().hasData()) {
            int size = arrayList.size();
            if (z) {
                return (dVar.baq().get(0) == null || dVar.baq().get(0).bwZ() != 1) ? -1 : 1;
            } else if (size != 0) {
                return (dVar.uB() == null || dVar.uB().uv() != dVar.uB().us()) ? -1 : 0;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public com.baidu.adp.widget.ListView.h getItem(int i) {
        return this.mListView.getItem(i);
    }

    public ArrayList<PostData> bcK() {
        return this.postList;
    }

    public BdUniqueId qt(int i) {
        if (this.mListView.getItem(i) != null) {
            return this.mListView.getItem(i).getType();
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.fty == null || !this.fty.bbm()) {
            this.ftQ = bcL();
            if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
                this.mListView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public int bcL() {
        if (this.mListView != null && this.mListView.getData() != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mListView.getData().size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = this.mListView.getData().get(i2);
                if (hVar == null || hVar.getType() != com.baidu.tieba.pb.data.h.fpb) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int bcM() {
        return this.ftQ;
    }

    private void bcN() {
        com.baidu.tieba.tbadkCore.data.l lVar;
        com.baidu.tieba.tbadkCore.data.l lVar2;
        if (this.ftE != null) {
            ArrayList<PostData> baq = this.ftE.baq();
            ArrayList<com.baidu.tieba.tbadkCore.data.l> baD = this.ftE.baD();
            if (baD != null) {
                int size = baD.size();
                if (baq != null && baq.size() != 0 && size != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it = baD.iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next = it.next();
                        if (next != null && next.getAdId() != null) {
                            sb.append(next.getAdId());
                            sb.append(",");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it2 = baD.iterator();
                    while (it2.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next2 = it2.next();
                        if (next2 != null) {
                            next2.dwC = sb.toString();
                        }
                    }
                    SparseArray sparseArray = new SparseArray();
                    Iterator<com.baidu.tieba.tbadkCore.data.l> it3 = baD.iterator();
                    while (it3.hasNext()) {
                        com.baidu.tieba.tbadkCore.data.l next3 = it3.next();
                        if (next3.bwP() != null) {
                            int tN = next3.bwP().tN();
                            if (tN != 0) {
                                a(next3, tN);
                                if (tN != 28 && tN != 31) {
                                    if (next3.bwP().goods != null) {
                                        next3.bwP().goods.goods_style = -1001;
                                    }
                                }
                            }
                            if (!com.baidu.tieba.tbadkCore.u.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), next3.bwP().apk_name)) {
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
                    Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.baidu.tieba.pb.pb.main.f.6
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(Integer num, Integer num2) {
                            return (num != null ? num.intValue() : 0) - (num != null ? num2.intValue() : 0);
                        }
                    });
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        com.baidu.tieba.tbadkCore.data.l lVar4 = (com.baidu.tieba.tbadkCore.data.l) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                        if (this.ftE.bam() != null) {
                            lVar4.forumId = this.ftE.bam().getId();
                        }
                        if (this.ftE.bao() != null) {
                            lVar4.threadId = com.baidu.adp.lib.g.b.c(this.ftE.bao().getId(), 0L);
                        }
                        if (this.ftE != null && this.ftE.uB() != null) {
                            lVar4.pageNumber = this.ftE.uB().uv();
                        }
                        b(lVar4);
                        int position2 = lVar4.getPosition();
                        if (position2 + i3 >= baq.size()) {
                            a(lVar4, 2);
                            return;
                        }
                        if (!this.ftG) {
                            position2--;
                        }
                        if (position2 < 0) {
                            a(lVar4, 23);
                            return;
                        }
                        baq.add(position2, lVar4);
                        TiebaStatic.eventStat(this.ftp.getPageContext().getContext(), "pb_show_app", "", 1, "app_name", lVar4.bwP().apk_name);
                    }
                }
            }
        }
    }

    private void a(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        com.baidu.tieba.recapp.report.a c = com.baidu.tieba.recapp.report.e.c(lVar, 5);
        c.sf(i);
        com.baidu.tieba.recapp.report.b.bpc().a(c);
        if (lVar != null && lVar.bwP() != null) {
            lVar.bwP().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar, int i) {
        if (lVar != null && lVar.bwP() != null && lVar.bwP().goods != null && lVar.bwP().goods.goods_style != 1001 && lVar.bwP().goods.goods_style != -1001) {
            a(lVar, i);
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.l lVar) {
        ForumData bam;
        if (lVar != null && this.ftE != null && lVar.bwP() != null) {
            lVar.bwP().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.ftE.uB() != null) {
                lVar.bwP().advertAppContext.pn = this.ftE.uB().uv();
            }
            lVar.bwP().advertAppContext.adp = "PB";
            if (this.ftE.bam() != null && (bam = this.ftE.bam()) != null) {
                lVar.bwP().advertAppContext.fid = bam.getId();
                lVar.bwP().advertAppContext.adr = bam.getFirst_class();
                lVar.bwP().advertAppContext.ads = bam.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                lVar.bwP().advertAppContext.adt = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            lVar.bwP().advertAppContext.extensionInfo = lVar.bwP().ext_info;
            lVar.bwP().advertAppContext.OZ = false;
        }
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
        this.ftq.setFromCDN(z);
        if (this.dwf != null && (this.dwf instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.dwf).setIsFromCDN(z);
        }
        Iterator<com.baidu.tieba.pb.pb.a.a> it = this.ftD.iterator();
        while (it.hasNext()) {
            it.next().setFromCDN(z);
        }
    }

    public boolean bcO() {
        return this.ftF;
    }

    public void jx(boolean z) {
        this.ftF = z;
    }

    public void jy(boolean z) {
        this.ftG = z;
    }

    public void jz(boolean z) {
        this.ftL = z;
    }

    public void F(View.OnClickListener onClickListener) {
        this.ftN = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.h hVar) {
        this.beD = hVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.beE = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aGs = onLongClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }

    public void qu(int i) {
        if (this.ftr != null) {
            this.ftr.qu(i);
        }
        switch (i) {
            case 1:
                if (this.fty != null) {
                    this.fty.pause();
                }
                if (this.ftq != null) {
                    this.ftq.pause();
                    return;
                }
                return;
            case 2:
                if (this.fty != null) {
                    this.fty.resume();
                }
                if (this.ftq != null) {
                    this.ftq.resume();
                    return;
                }
                return;
            case 3:
                if (this.fty != null) {
                    this.fty.release();
                }
                if (this.ftq != null) {
                    this.ftq.release();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void cU(List<com.baidu.adp.widget.ListView.h> list) {
        int size;
        if (list != null && (size = list.size()) > 0) {
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof PostData) {
                    PostData postData = (PostData) list.get(i);
                    if (!TextUtils.isEmpty(postData.wd())) {
                        com.baidu.tbadk.core.data.ac acVar = new com.baidu.tbadk.core.data.ac();
                        acVar.dg(postData.wd());
                        list.set(i, acVar);
                    }
                }
            }
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.ftP);
        if (this.fts != null) {
            this.fts.onDestroy();
        }
        if (this.ftt != null) {
            this.ftt.onDestroy();
        }
    }

    public void jK(boolean z) {
        this.ftI = z;
    }

    public void jL(boolean z) {
        this.ftJ = z;
    }

    public void jM(boolean z) {
        this.ftH = z;
    }

    public void jN(boolean z) {
        this.ftK = z;
    }

    public ao bcP() {
        return this.ftr;
    }

    public void jO(boolean z) {
        if (this.ftr != null) {
            this.ftr.fAb = z;
        }
    }
}
