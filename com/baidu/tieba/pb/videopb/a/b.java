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
    private com.baidu.adp.widget.ListView.a iAr;
    private d kHh;
    private com.baidu.tieba.pb.pb.main.adapter.c kHi;
    private c kHj;
    private h kHk;
    private ab kHl;
    private DetailInfoAndReplyFragment kHo;
    private at kHp;
    private ae kHq;
    private k kHr;
    private m kkB;
    private com.baidu.adp.widget.ListView.a kkE;
    private an kkH;
    private com.baidu.tieba.pb.pb.a.c kkI;
    private f kkM;
    private SortSwitchButton.a kkX;
    private com.baidu.tieba.pb.pb.main.adapter.d kkx;
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private boolean kGC = true;
    private String aTI = null;
    private boolean kkN = true;
    private boolean mIsFromCDN = false;
    private View.OnClickListener kkW = null;
    private View.OnClickListener aMH = null;
    private TbRichTextView.i eRR = null;
    private com.baidu.tieba.pb.a.c euG = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener kHm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
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
        this.kHo = detailInfoAndReplyFragment;
        this.hKL = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.kHh = new d(this.kHo.cNs(), PostData.lNa);
        this.kHi = new com.baidu.tieba.pb.pb.main.adapter.c(this.kHo.cNs(), o.kiL);
        this.kHi.setOnClickListener(this.kHm);
        this.kHj = new c(this.kHo.getContext(), s.TYPE);
        this.kkx = new com.baidu.tieba.pb.pb.main.adapter.d(this.kHo.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kHp = new at(this.kHo.cNs(), n.kiE);
        this.kHq = new ae(this.kHo.cNs(), j.kin, this.kHo.getUniqueId());
        this.kkH = new an(this.kHo.cNs(), l.Wc);
        this.kHr = new k(this.kHo.cNs(), e.khf);
        this.kHk = new h(this.kHo.cNs(), com.baidu.tbadk.core.data.n.dNW);
        this.kHk.sg(true);
        this.kHl = new ab(this.kHo.cNs());
        this.kkB = new m(this.kHo.cNs(), PostData.lNb);
        this.kkB.a((TbRichTextView.c) this.kHo.cNs());
        this.kkI = new com.baidu.tieba.pb.pb.a.c(this.kHo.cNs(), PostData.lNf);
        this.iAr = r.dca().a(this.kHo.cNs().getBaseFragmentActivity(), AdvertAppInfo.dMK);
        this.kkE = r.dca().a(this.kHo.cNs().getBaseFragmentActivity(), AdvertAppInfo.dMO);
        this.aWf.add(this.kHh);
        this.aWf.add(this.kHi);
        this.aWf.add(this.kHj);
        this.aWf.add(this.kkx);
        this.aWf.add(this.kHp);
        this.aWf.add(this.kkH);
        this.aWf.add(this.kHq);
        this.aWf.add(this.kHr);
        this.aWf.add(this.kHk);
        this.aWf.add(this.kHl);
        this.aWf.add(this.iAr);
        this.aWf.add(this.kkE);
        this.aWf.add(this.kkB);
        this.aWf.add(this.kkI);
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
            this.kkM = fVar;
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
                if ((next instanceof PostData) && next.dlh() == 1) {
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
            this.kHh.setPbData(fVar);
            o oVar = new o(fVar.cKx(), fVar.getAnti());
            oVar.rV(false);
            oVar.kiN = false;
            this.fkE.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kHo.cLP().cLG()) || !this.kHo.cLP().cNO())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.kHo.cLP().cNL();
                hVar.kik = false;
                this.fkE.add(hVar);
                oVar.rV(false);
                oVar.kiN = false;
            }
            n nVar2 = new n(n.kiE);
            nVar2.kiG = fVar.cKx() != null ? cKx.aWc() : 0L;
            nVar2.isNew = !this.kHo.cLP().cNN();
            nVar2.kiJ = cNn();
            nVar2.sortType = fVar.khn;
            nVar2.kiI = fVar.cLb();
            nVar2.isDynamic = fVar.cLa();
            nVar2.kiK = fVar.khm;
            this.kHp.setData(fVar);
            this.fkE.add(nVar2);
            Iterator<PostData> it2 = fVar.cKz().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dlh() == 1) {
                    z = z2;
                } else {
                    this.fkE.add(next2);
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                l lVar = new l();
                lVar.kix = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.kiw = R.drawable.new_pic_emotion_03;
                lVar.fsQ = com.baidu.adp.lib.util.l.getDimens(this.kHo.getContext(), R.dimen.tbds730);
                lVar.kiy = com.baidu.adp.lib.util.l.getDimens(this.kHo.getContext(), R.dimen.tbds74);
                lVar.kiz = com.baidu.adp.lib.util.l.getDimens(this.kHo.getContext(), R.dimen.tbds74);
                this.fkE.add(lVar);
            }
            this.kkB.setData(fVar);
            this.kkB.setFromCDN(this.mIsFromCDN);
            this.kkB.fq(this.aTI);
            this.kkB.rW(this.kkN);
            this.kkB.z(this.aMH);
            this.kkB.R(this.kkW);
            this.kkB.setOnImageClickListener(this.eRR);
            this.kkB.setOnLongClickListener(this.mOnLongClickListener);
            this.kkB.setTbGestureDetector(this.euG);
            this.kHp.z(this.aMH);
            this.kHp.a(this.kkX);
            this.kkI.setOnClickListener(this.aMH);
            cMo();
            if (this.kkE != null && (this.kkE instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kkE).setIsFromCDN(this.mIsFromCDN);
            }
            if (fVar.getPage().aVb() == 0) {
                if (z2) {
                    this.kHq.setOnClickListener(this.kHo.cNs().cTa());
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
        if (this.kkM != null && !this.kkM.kic && this.kkM.Xq != 2) {
            ArrayList<PostData> cKz = this.kkM.cKz();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cKO = this.kkM.cKO();
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
                        next2.hZe = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cKO.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dkV() != null) {
                        int aUe = next3.dkV().aUe();
                        if (aUe != 0) {
                            a(next3, aUe);
                            if (aUe != 28 && aUe != 31) {
                                if (next3.dkV().goods != null) {
                                    next3.dkV().goods.goods_style = -1001;
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
                    if (this.kkM.getForum() != null) {
                        nVar4.forumId = this.kkM.getForum().getId();
                    }
                    if (this.kkM.cKx() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kkM.cKx().getId(), 0L);
                    }
                    if (this.kkM != null && this.kkM.getPage() != null) {
                        nVar4.pageNumber = this.kkM.getPage().aUZ();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kkM.kib;
                    if (position + i3 >= cKz.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kGC) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cKz, position)) {
                        a(nVar4, 1);
                    } else {
                        cKz.add(position, nVar4);
                        TiebaStatic.eventStat(this.kHo.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dkV().apk_name);
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
        if (nVar != null && nVar.dkV() != null) {
            nVar.dkV().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dkV() != null && nVar.dkV().goods != null && nVar.dkV().goods.goods_style != 1001 && nVar.dkV().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kkM != null && nVar.dkV() != null) {
            nVar.dkV().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kkM.getPage() != null) {
                nVar.dkV().advertAppContext.pn = this.kkM.getPage().aUZ();
            }
            nVar.dkV().advertAppContext.page = nVar.dkY();
            if (this.kkM.getForum() != null && (forum = this.kkM.getForum()) != null) {
                nVar.dkV().advertAppContext.fid = forum.getId();
                nVar.dkV().advertAppContext.dMB = forum.getFirst_class();
                nVar.dkV().advertAppContext.dMC = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dkV().advertAppContext.dMD = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dkV().advertAppContext.extensionInfo = nVar.dkV().ext_info;
            nVar.dkV().advertAppContext.Xw = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void R(View.OnClickListener onClickListener) {
        this.kkW = onClickListener;
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
        this.kGC = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean BJ(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.kHo.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.kHo.cNt(), true, i)));
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
                return com.baidu.tieba.pb.pb.main.d.a.a(b.this.kHo.getContext(), b.this.cMO(), i2, b.this.kHo.cLP());
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.kHo.getContext(), i, shareItem, false));
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
        if (this.kkM == null || this.kkM.cKx() == null) {
            return -1;
        }
        return this.kkM.cKx().aWY();
    }

    public boolean cNn() {
        if (this.kHo.cLP() != null) {
            return this.kHo.cLP().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kkX = aVar;
    }
}
