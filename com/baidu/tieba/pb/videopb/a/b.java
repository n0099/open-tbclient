package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.data.s;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.pb.main.ae;
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.main.m;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> fkE;
    private BdTypeRecyclerView hKL;
    private com.baidu.adp.widget.ListView.a iAt;
    private d kHj;
    private com.baidu.tieba.pb.pb.main.adapter.c kHk;
    private c kHl;
    private h kHm;
    private ab kHn;
    private DetailInfoAndReplyFragment kHq;
    private at kHr;
    private ae kHs;
    private k kHt;
    private m kkD;
    private com.baidu.adp.widget.ListView.a kkG;
    private an kkJ;
    private com.baidu.tieba.pb.pb.a.c kkK;
    private f kkO;
    private SortSwitchButton.a kkZ;
    private com.baidu.tieba.pb.pb.main.adapter.d kkz;
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private boolean kGE = true;
    private String aTI = null;
    private boolean kkP = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener kkY = null;
    private View.OnClickListener aMH = null;
    private TbRichTextView.i eRR = null;
    private com.baidu.tieba.pb.a.c euG = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener kHo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.BJ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.BL(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.BJ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.BL(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kHq = detailInfoAndReplyFragment;
        this.hKL = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.kHj = new d(this.kHq.cNs(), PostData.lNc);
        this.kHk = new com.baidu.tieba.pb.pb.main.adapter.c(this.kHq.cNs(), o.kiN);
        this.kHk.setOnClickListener(this.kHo);
        this.kHl = new c(this.kHq.getContext(), s.TYPE);
        this.kkz = new com.baidu.tieba.pb.pb.main.adapter.d(this.kHq.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kHr = new at(this.kHq.cNs(), n.kiG);
        this.kHs = new ae(this.kHq.cNs(), j.kip, this.kHq.getUniqueId());
        this.kkJ = new an(this.kHq.cNs(), l.Wc);
        this.kHt = new k(this.kHq.cNs(), e.khh);
        this.kHm = new h(this.kHq.cNs(), com.baidu.tbadk.core.data.n.dNW);
        this.kHm.sg(true);
        this.kHn = new ab(this.kHq.cNs());
        this.kkD = new m(this.kHq.cNs(), PostData.lNd);
        this.kkD.a((TbRichTextView.c) this.kHq.cNs());
        this.kkK = new com.baidu.tieba.pb.pb.a.c(this.kHq.cNs(), PostData.lNh);
        this.iAt = r.dca().a(this.kHq.cNs().getBaseFragmentActivity(), AdvertAppInfo.dMK);
        this.kkG = r.dca().a(this.kHq.cNs().getBaseFragmentActivity(), AdvertAppInfo.dMO);
        this.aWf.add(this.kHj);
        this.aWf.add(this.kHk);
        this.aWf.add(this.kHl);
        this.aWf.add(this.kkz);
        this.aWf.add(this.kHr);
        this.aWf.add(this.kkJ);
        this.aWf.add(this.kHs);
        this.aWf.add(this.kHt);
        this.aWf.add(this.kHm);
        this.aWf.add(this.kHn);
        this.aWf.add(this.iAt);
        this.aWf.add(this.kkG);
        this.aWf.add(this.kkD);
        this.aWf.add(this.kkK);
        this.hKL.addAdapters(this.aWf);
    }

    public void setData(f fVar) {
        PostData postData;
        bv cKx;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.kkO = fVar;
            if (fVar != null && fVar.cKx() != null && fVar.cKx().aWl() != null) {
                this.aTI = fVar.cKx().aWl().getUserId();
            }
            if (this.fkE == null) {
                this.fkE = new ArrayList<>();
            }
            this.fkE.clear();
            Iterator<PostData> it = fVar.cKz().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dli() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.cKG() != null) {
                postData = fVar.cKG();
            }
            if (postData != null) {
                this.fkE.add(postData);
            }
            this.kHj.setPbData(fVar);
            o oVar = new o(fVar.cKx(), fVar.getAnti());
            oVar.rV(false);
            oVar.kiP = false;
            this.fkE.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kHq.cLP().cLG()) || !this.kHq.cLP().cNO())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.kHq.cLP().cNL();
                hVar.kim = false;
                this.fkE.add(hVar);
                oVar.rV(false);
                oVar.kiP = false;
            }
            n nVar2 = new n(n.kiG);
            nVar2.kiI = fVar.cKx() != null ? cKx.aWc() : 0L;
            nVar2.isNew = !this.kHq.cLP().cNN();
            nVar2.kiL = cNn();
            nVar2.sortType = fVar.khp;
            nVar2.kiK = fVar.cLb();
            nVar2.isDynamic = fVar.cLa();
            nVar2.kiM = fVar.kho;
            this.kHr.setData(fVar);
            this.fkE.add(nVar2);
            Iterator<PostData> it2 = fVar.cKz().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dli() == 1) {
                    z = z2;
                } else {
                    this.fkE.add(next2);
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                l lVar = new l();
                lVar.kiz = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.kiy = R.drawable.new_pic_emotion_03;
                lVar.fsQ = com.baidu.adp.lib.util.l.getDimens(this.kHq.getContext(), R.dimen.tbds730);
                lVar.kiA = com.baidu.adp.lib.util.l.getDimens(this.kHq.getContext(), R.dimen.tbds74);
                lVar.kiB = com.baidu.adp.lib.util.l.getDimens(this.kHq.getContext(), R.dimen.tbds74);
                this.fkE.add(lVar);
            }
            this.kkD.setData(fVar);
            this.kkD.setFromCDN(this.mIsFromCDN);
            this.kkD.fq(this.aTI);
            this.kkD.rW(this.kkP);
            this.kkD.z(this.aMH);
            this.kkD.R(this.kkY);
            this.kkD.setOnImageClickListener(this.eRR);
            this.kkD.setOnLongClickListener(this.mOnLongClickListener);
            this.kkD.setTbGestureDetector(this.euG);
            this.kHr.z(this.aMH);
            this.kHr.a(this.kkZ);
            this.kkK.setOnClickListener(this.aMH);
            cMo();
            if (this.kkG != null && (this.kkG instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kkG).setIsFromCDN(this.mIsFromCDN);
            }
            if (fVar.getPage().aVb() == 0) {
                if (z2) {
                    this.kHs.setOnClickListener(this.kHq.cNs().cTa());
                    j jVar = new j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.fkE.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> cLe = fVar.cLe();
                int i3 = -1;
                if (cLe == null || cLe.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = cLe.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!x.isEmpty(fVar.cKZ())) {
                    e eVar = new e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    this.fkE.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.n nVar5 : fVar.cKZ()) {
                        if (cLe != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.fkE.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.dMK) {
                                    i++;
                                }
                            }
                            if (i2 < cLe.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = cLe.get(i2);
                                nVar4 = nVar6;
                                i4 = nVar6.getPosition();
                            }
                        }
                        this.fkE.add(nVar5);
                        i++;
                        if (i == 4 && fVar.cKD() != null) {
                            this.fkE.add(fVar.cKD());
                            i++;
                        }
                    }
                }
            }
            if (this.hKL != null) {
                this.hKL.setData(this.fkE);
            }
        }
    }

    private void cMo() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kkO != null && !this.kkO.kif && this.kkO.Xq != 2) {
            ArrayList<PostData> cKz = this.kkO.cKz();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cKO = this.kkO.cKO();
            if (cKO != null && !cKO.isEmpty() && cKz != null && !cKz.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = cKO.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cKO.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.hZg = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cKO.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dkW() != null) {
                        int aUe = next3.dkW().aUe();
                        if (aUe != 0) {
                            a(next3, aUe);
                            if (aUe != 28 && aUe != 31) {
                                if (next3.dkW().goods != null) {
                                    next3.dkW().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + aUe);
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(sparseArray.keyAt(i));
                    if (nVar3 != null && (nVar2 = (com.baidu.tieba.tbadkCore.data.n) hashMap.put(nVar3.getAdId(), nVar3)) != null) {
                        b(nVar2, 30);
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
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.baidu.tieba.tbadkCore.data.n nVar4 = (com.baidu.tieba.tbadkCore.data.n) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.kkO.getForum() != null) {
                        nVar4.forumId = this.kkO.getForum().getId();
                    }
                    if (this.kkO.cKx() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kkO.cKx().getId(), 0L);
                    }
                    if (this.kkO != null && this.kkO.getPage() != null) {
                        nVar4.pageNumber = this.kkO.getPage().aUZ();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kkO.kie;
                    if (position + i3 >= cKz.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kGE) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cKz, position)) {
                        a(nVar4, 1);
                    } else {
                        cKz.add(position, nVar4);
                        TiebaStatic.eventStat(this.kHq.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dkW().apk_name);
                    }
                }
            }
        }
    }

    private boolean d(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof com.baidu.tieba.tbadkCore.data.n) {
                return true;
            }
        }
        return false;
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = g.c(nVar, 5);
        c.DS(i);
        com.baidu.tieba.recapp.report.d.dcY().a(c);
        if (nVar != null && nVar.dkW() != null) {
            nVar.dkW().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dkW() != null && nVar.dkW().goods != null && nVar.dkW().goods.goods_style != 1001 && nVar.dkW().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kkO != null && nVar.dkW() != null) {
            nVar.dkW().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kkO.getPage() != null) {
                nVar.dkW().advertAppContext.pn = this.kkO.getPage().aUZ();
            }
            nVar.dkW().advertAppContext.page = nVar.dkZ();
            if (this.kkO.getForum() != null && (forum = this.kkO.getForum()) != null) {
                nVar.dkW().advertAppContext.fid = forum.getId();
                nVar.dkW().advertAppContext.dMB = forum.getFirst_class();
                nVar.dkW().advertAppContext.dMC = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dkW().advertAppContext.dMD = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dkW().advertAppContext.extensionInfo = nVar.dkW().ext_info;
            nVar.dkW().advertAppContext.Xw = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kkY = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.eRR = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.euG = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void E(View.OnClickListener onClickListener) {
        this.aMH = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hKL.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.hKL.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fkE;
    }

    public void tv(boolean z) {
        this.kGE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BJ(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.kHq.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.kHq.cNt(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BL(final int i) {
        ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: aTq */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(b.this.kHq.getContext(), b.this.cMO(), i2, b.this.kHq.cLP());
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.kHq.getContext(), i, shareItem, false));
            }
        });
        ap apVar = new ap("c13833");
        apVar.ah("obj_locate", 1);
        if (i == 3) {
            apVar.ah("obj_type", 1);
        } else if (i == 8) {
            apVar.ah("obj_type", 2);
        }
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cMO() {
        if (this.kkO == null || this.kkO.cKx() == null) {
            return -1;
        }
        return this.kkO.cKx().aWY();
    }

    public boolean cNn() {
        if (this.kHq.cLP() != null) {
            return this.kHq.cLP().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kkZ = aVar;
    }
}
