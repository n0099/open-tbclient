package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
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
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> fTO;
    private BdTypeRecyclerView iHt;
    private com.baidu.adp.widget.ListView.a jzw;
    private at lHA;
    private ae lHB;
    private k lHC;
    private d lHr;
    private com.baidu.tieba.pb.pb.main.adapter.c lHs;
    private c lHt;
    private h lHu;
    private ab lHv;
    private DetailInfoAndReplyFragment lHz;
    private SortSwitchButton.a lkF;
    private com.baidu.tieba.pb.pb.main.adapter.d lkf;
    private m lkj;
    private com.baidu.adp.widget.ListView.a lkm;
    private an lkp;
    private com.baidu.tieba.pb.pb.a.c lkq;
    private f lku;
    private final BdUniqueId lHy = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private boolean lGM = true;
    private String bgw = null;
    private boolean lkv = true;
    private boolean mIsFromCDN = false;
    private int lHD = -1;
    private int lHE = -1;
    private View.OnClickListener lkE = null;
    private View.OnClickListener aYF = null;
    private TbRichTextView.i fAg = null;
    private com.baidu.tieba.pb.a.c fbT = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener lHw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.FD(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.FF(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.FD(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.FF(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lHz = detailInfoAndReplyFragment;
        this.iHt = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.lHr = new d(this.lHz.diB(), PostData.mQM);
        this.lHs = new com.baidu.tieba.pb.pb.main.adapter.c(this.lHz.diB(), o.lit);
        this.lHs.setOnClickListener(this.lHw);
        this.lHt = new c(this.lHz.getContext(), s.TYPE);
        this.lkf = new com.baidu.tieba.pb.pb.main.adapter.d(this.lHz.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lHA = new at(this.lHz.diB(), n.lim);
        this.lHB = new ae(this.lHz.diB(), j.lhW, this.lHz.getUniqueId());
        this.lkp = new an(this.lHz.diB(), l.Xs);
        this.lHC = new k(this.lHz.diB(), e.lgQ);
        this.lHu = new h(this.lHz.diB(), com.baidu.tbadk.core.data.n.etV);
        this.lHu.tU(true);
        this.lHv = new ab(this.lHz.diB());
        this.lkj = new m(this.lHz.diB(), PostData.mQN);
        this.lkj.a((TbRichTextView.c) this.lHz.diB());
        this.lkq = new com.baidu.tieba.pb.pb.a.c(this.lHz.diB(), PostData.mQR);
        this.jzw = r.dxM().a(this.lHz.diB().getBaseFragmentActivity(), AdvertAppInfo.esI);
        this.lkm = r.dxM().a(this.lHz.diB().getBaseFragmentActivity(), AdvertAppInfo.esM);
        this.bje.add(this.lHr);
        this.bje.add(this.lHs);
        this.bje.add(this.lHt);
        this.bje.add(this.lkf);
        this.bje.add(this.lHA);
        this.bje.add(this.lkp);
        this.bje.add(this.lHB);
        this.bje.add(this.lHC);
        this.bje.add(this.lHu);
        this.bje.add(this.lHv);
        this.bje.add(this.jzw);
        this.bje.add(this.lkm);
        this.bje.add(this.lkj);
        this.bje.add(this.lkq);
        this.iHt.addAdapters(this.bje);
    }

    public void setData(f fVar) {
        PostData postData;
        bw dfI;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.lku = fVar;
            if (fVar != null && fVar.dfI() != null && fVar.dfI().bka() != null) {
                this.bgw = fVar.dfI().bka().getUserId();
            }
            if (this.fTO == null) {
                this.fTO = new ArrayList<>();
            }
            this.fTO.clear();
            Iterator<PostData> it = fVar.dfK().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dHx() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.dfR() != null) {
                postData = fVar.dfR();
            }
            if (postData != null) {
                this.fTO.add(postData);
            }
            this.lHr.setPbData(fVar);
            o oVar = new o(fVar.dfI(), fVar.getAnti());
            oVar.tJ(false);
            oVar.liv = false;
            this.fTO.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lHz.dgX().dgP()) || !this.lHz.dgX().diY())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.lHz.dgX().diV();
                hVar.lhT = false;
                this.fTO.add(hVar);
                oVar.tJ(false);
                oVar.liv = false;
            }
            n nVar2 = new n(n.lim);
            nVar2.lio = fVar.dfI() != null ? dfI.bjR() : 0L;
            nVar2.isNew = !this.lHz.dgX().diX();
            nVar2.lir = div();
            nVar2.sortType = fVar.lgY;
            nVar2.liq = fVar.dgm();
            nVar2.isDynamic = fVar.dgl();
            nVar2.lis = fVar.lgX;
            this.lHA.setData(fVar);
            this.fTO.add(nVar2);
            dhw();
            if (this.lkm != null && (this.lkm instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.lkm).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dfK().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dHx() == 1) {
                    z = z2;
                } else {
                    this.fTO.add(next2);
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                l lVar = new l();
                lVar.lig = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.lif = R.drawable.new_pic_emotion_03;
                lVar.gdN = com.baidu.adp.lib.util.l.getDimens(this.lHz.getContext(), R.dimen.tbds730);
                lVar.lih = com.baidu.adp.lib.util.l.getDimens(this.lHz.getContext(), R.dimen.tbds74);
                lVar.lii = com.baidu.adp.lib.util.l.getDimens(this.lHz.getContext(), R.dimen.tbds74);
                this.fTO.add(lVar);
            }
            this.lkj.setData(fVar);
            this.lkj.setFromCDN(this.mIsFromCDN);
            this.lkj.hx(this.bgw);
            this.lkj.tK(this.lkv);
            this.lkj.A(this.aYF);
            this.lkj.S(this.lkE);
            this.lkj.setOnImageClickListener(this.fAg);
            this.lkj.setOnLongClickListener(this.mOnLongClickListener);
            this.lkj.setTbGestureDetector(this.fbT);
            this.lHA.A(this.aYF);
            this.lHA.a(this.lkF);
            this.lkq.setOnClickListener(this.aYF);
            if (fVar.getPage().biQ() == 0) {
                if (z2) {
                    this.lHB.setOnClickListener(this.lHz.diB().doo());
                    j jVar = new j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.fTO.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> dgp = fVar.dgp();
                int i3 = -1;
                if (dgp == null || dgp.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = dgp.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!y.isEmpty(fVar.dgk())) {
                    e eVar = new e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.lHy);
                    this.fTO.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.n nVar5 : fVar.dgk()) {
                        if (dgp != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.fTO.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.esI) {
                                    i++;
                                }
                            }
                            if (i2 < dgp.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = dgp.get(i2);
                                nVar4 = nVar6;
                                i4 = nVar6.getPosition();
                            }
                        }
                        this.fTO.add(nVar5);
                        i++;
                        if (i == 4 && fVar.dfO() != null) {
                            this.fTO.add(fVar.dfO());
                            i++;
                        }
                    }
                }
            }
            if (this.iHt != null) {
                this.iHt.setData(this.fTO);
            }
            dpc();
        }
    }

    private void dhw() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lku != null && !this.lku.lhM && this.lku.YH != 2) {
            ArrayList<PostData> dfK = this.lku.dfK();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dfZ = this.lku.dfZ();
            if (dfZ != null && !dfZ.isEmpty() && dfK != null && !dfK.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dfZ.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dfZ.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.iWa = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dfZ.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dHl() != null) {
                        int bhR = next3.dHl().bhR();
                        if (bhR != 0) {
                            a(next3, bhR);
                            if (bhR != 28 && bhR != 31) {
                                if (next3.dHl().goods != null) {
                                    next3.dHl().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bhR);
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
                    if (this.lku.getForum() != null) {
                        nVar4.forumId = this.lku.getForum().getId();
                    }
                    if (this.lku.dfI() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lku.dfI().getId(), 0L);
                    }
                    if (this.lku != null && this.lku.getPage() != null) {
                        nVar4.pageNumber = this.lku.getPage().biO();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lku.lhL;
                    if (position + i3 >= dfK.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lGM) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dfK, position)) {
                        a(nVar4, 1);
                    } else {
                        dfK.add(position, nVar4);
                        TiebaStatic.eventStat(this.lHz.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dHl().apk_name);
                    }
                }
            }
        }
    }

    private boolean e(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof com.baidu.tieba.tbadkCore.data.n) {
                return true;
            }
        }
        return false;
    }

    private void a(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        com.baidu.tieba.recapp.report.c c = g.c(nVar, 5);
        c.HN(i);
        com.baidu.tieba.recapp.report.d.dyN().a(c);
        if (nVar != null && nVar.dHl() != null) {
            nVar.dHl().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dHl() != null && nVar.dHl().goods != null && nVar.dHl().goods.goods_style != 1001 && nVar.dHl().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lku != null && nVar.dHl() != null) {
            nVar.dHl().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.lku.getPage() != null) {
                nVar.dHl().advertAppContext.pn = this.lku.getPage().biO();
            }
            nVar.dHl().advertAppContext.page = nVar.dHo();
            if (this.lku.getForum() != null && (forum = this.lku.getForum()) != null) {
                nVar.dHl().advertAppContext.fid = forum.getId();
                nVar.dHl().advertAppContext.esz = forum.getFirst_class();
                nVar.dHl().advertAppContext.esA = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dHl().advertAppContext.esB = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dHl().advertAppContext.extensionInfo = nVar.dHl().ext_info;
            nVar.dHl().advertAppContext.YN = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lkE = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fAg = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fbT = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aYF = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iHt.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.iHt.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fTO;
    }

    public void vm(boolean z) {
        this.lGM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FD(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.lHz.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lHz.diC(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FF(final int i) {
        com.baidu.tbadk.util.ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bhc */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(b.this.lHz.getContext(), b.this.dhW(), i2, b.this.lHz.dgX());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.lHz.getContext(), i, shareItem, false));
            }
        });
        aq aqVar = new aq("c13833");
        aqVar.aj("obj_locate", 1);
        if (i == 3) {
            aqVar.aj("obj_type", 1);
        } else if (i == 8) {
            aqVar.aj("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dhW() {
        if (this.lku == null || this.lku.dfI() == null) {
            return -1;
        }
        return this.lku.dfI().bkN();
    }

    private void dpc() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.fTO.size(); i++) {
            q qVar = this.fTO.get(i);
            if (qVar instanceof n) {
                this.lHD = i;
                z2 = true;
            } else if ((qVar instanceof e) && ((e) qVar).getTag() == this.lHy) {
                this.lHE = i;
                z = true;
            }
        }
        if (!z2) {
            this.lHD = -1;
        }
        if (!z) {
            this.lHE = -1;
        }
    }

    public int dpd() {
        return this.lHD;
    }

    public int dpe() {
        return this.lHE;
    }

    public boolean div() {
        if (this.lHz.dgX() != null) {
            return this.lHz.dgX().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lkF = aVar;
    }
}
