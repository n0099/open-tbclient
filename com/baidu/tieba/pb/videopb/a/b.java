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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> fZl;
    private BdTypeRecyclerView iOd;
    private com.baidu.adp.widget.ListView.a jGs;
    private d lNF;
    private com.baidu.tieba.pb.pb.main.adapter.c lNG;
    private c lNH;
    private h lNI;
    private ab lNJ;
    private DetailInfoAndReplyFragment lNN;
    private at lNO;
    private ae lNP;
    private k lNQ;
    private com.baidu.adp.widget.ListView.a lqC;
    private an lqF;
    private com.baidu.tieba.pb.pb.a.c lqG;
    private f lqK;
    private SortSwitchButton.a lqV;
    private com.baidu.tieba.pb.pb.main.adapter.d lqv;
    private m lqz;
    private final BdUniqueId lNM = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private boolean lNa = true;
    private String bgd = null;
    private boolean lqL = true;
    private boolean mIsFromCDN = false;
    private int lNR = -1;
    private int lNS = -1;
    private View.OnClickListener lqU = null;
    private View.OnClickListener aYm = null;
    private TbRichTextView.i fFy = null;
    private com.baidu.tieba.pb.a.c fgS = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener lNK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.Go(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.Gq(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.Go(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.Gq(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lNN = detailInfoAndReplyFragment;
        this.iOd = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.lNF = new d(this.lNN.dkA(), PostData.mXI);
        this.lNG = new com.baidu.tieba.pb.pb.main.adapter.c(this.lNN.dkA(), o.loL);
        this.lNG.setOnClickListener(this.lNK);
        this.lNH = new c(this.lNN.getContext(), s.TYPE);
        this.lqv = new com.baidu.tieba.pb.pb.main.adapter.d(this.lNN.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lNO = new at(this.lNN.dkA(), n.loE);
        this.lNP = new ae(this.lNN.dkA(), j.lol, this.lNN.getUniqueId());
        this.lqF = new an(this.lNN.dkA(), l.Xw);
        this.lNQ = new k(this.lNN.dkA(), e.lnc);
        this.lNI = new h(this.lNN.dkA(), com.baidu.tbadk.core.data.o.eyd);
        this.lNI.ug(true);
        this.lNJ = new ab(this.lNN.dkA());
        this.lqz = new m(this.lNN.dkA(), PostData.mXJ);
        this.lqz.a((TbRichTextView.c) this.lNN.dkA());
        this.lqG = new com.baidu.tieba.pb.pb.a.c(this.lNN.dkA(), PostData.mXN);
        this.jGs = com.baidu.tieba.recapp.q.dzO().a(this.lNN.dkA().getBaseFragmentActivity(), AdvertAppInfo.ewQ);
        this.lqC = com.baidu.tieba.recapp.q.dzO().a(this.lNN.dkA().getBaseFragmentActivity(), AdvertAppInfo.ewU);
        this.biN.add(this.lNF);
        this.biN.add(this.lNG);
        this.biN.add(this.lNH);
        this.biN.add(this.lqv);
        this.biN.add(this.lNO);
        this.biN.add(this.lqF);
        this.biN.add(this.lNP);
        this.biN.add(this.lNQ);
        this.biN.add(this.lNI);
        this.biN.add(this.lNJ);
        this.biN.add(this.jGs);
        this.biN.add(this.lqC);
        this.biN.add(this.lqz);
        this.biN.add(this.lqG);
        this.iOd.addAdapters(this.biN);
    }

    public void setData(f fVar) {
        a(fVar, false);
    }

    public void a(f fVar, boolean z) {
        PostData postData;
        bx dhH;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z2;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.lqK = fVar;
            if (fVar != null && fVar.dhH() != null && fVar.dhH().blC() != null) {
                this.bgd = fVar.dhH().blC().getUserId();
            }
            if (this.fZl == null) {
                this.fZl = new ArrayList<>();
            }
            this.fZl.clear();
            Iterator<PostData> it = fVar.dhJ().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dJQ() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.dhQ() != null) {
                postData = fVar.dhQ();
            }
            if (postData != null) {
                this.fZl.add(postData);
            }
            this.lNF.setPbData(fVar);
            this.lNF.hy(this.bgd);
            o oVar = new o(fVar.dhH(), fVar.getAnti());
            oVar.tV(false);
            oVar.loN = false;
            this.fZl.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lNN.diV().diO()) || !this.lNN.diV().dkX())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.lNN.diV().dkU();
                hVar.loi = false;
                this.fZl.add(hVar);
                oVar.tV(false);
                oVar.loN = false;
            }
            n nVar2 = new n(n.loE);
            nVar2.loG = fVar.dhH() != null ? dhH.blt() : 0L;
            nVar2.isNew = !this.lNN.diV().dkW();
            nVar2.loJ = dku();
            nVar2.sortType = fVar.lnl;
            nVar2.loI = fVar.dil();
            nVar2.isDynamic = fVar.dik();
            nVar2.loK = fVar.lnk;
            this.lNO.setData(fVar);
            this.fZl.add(nVar2);
            dju();
            if (this.lqC != null && (this.lqC instanceof com.baidu.tieba.recapp.n)) {
                ((com.baidu.tieba.recapp.n) this.lqC).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dhJ().iterator();
            boolean z3 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dJQ() == 1) {
                    z2 = z3;
                } else {
                    this.fZl.add(next2);
                    z2 = true;
                }
                z3 = z2;
            }
            if (!z3 && (!z || !com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                l lVar = new l();
                lVar.lox = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.lov = R.drawable.new_pic_emotion_03;
                lVar.gjk = -2;
                lVar.loy = com.baidu.adp.lib.util.l.getDimens(this.lNN.getContext(), R.dimen.tbds74);
                this.fZl.add(lVar);
            }
            this.lqz.setData(fVar);
            this.lqz.setFromCDN(this.mIsFromCDN);
            this.lqz.hy(this.bgd);
            this.lqz.tW(this.lqL);
            this.lqz.B(this.aYm);
            this.lqz.S(this.lqU);
            this.lqz.setOnImageClickListener(this.fFy);
            this.lqz.setOnLongClickListener(this.mOnLongClickListener);
            this.lqz.setTbGestureDetector(this.fgS);
            this.lNO.B(this.aYm);
            this.lNO.a(this.lqV);
            this.lqG.setOnClickListener(this.aYm);
            if (fVar.getPage().bks() == 0) {
                if (z3) {
                    this.lNP.setOnClickListener(this.lNN.dkA().dqq());
                    j jVar = new j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.fZl.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> dio = fVar.dio();
                int i3 = -1;
                if (dio == null || dio.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = dio.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!y.isEmpty(fVar.dij())) {
                    e eVar = new e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.lNM);
                    this.fZl.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.o oVar2 : fVar.dij()) {
                        if (dio != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.fZl.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.ewQ) {
                                    i++;
                                }
                            }
                            if (i2 < dio.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar5 = dio.get(i2);
                                nVar4 = nVar5;
                                i4 = nVar5.getPosition();
                            }
                        }
                        this.fZl.add(oVar2);
                        i++;
                        if (i == 4 && fVar.dhN() != null) {
                            this.fZl.add(fVar.dhN());
                            i++;
                        }
                    }
                }
            }
            if (this.iOd != null) {
                this.iOd.setData(this.fZl);
            }
            dre();
        }
    }

    private void dju() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lqK != null && !this.lqK.lnZ && this.lqK.YM != 2) {
            ArrayList<PostData> dhJ = this.lqK.dhJ();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dhY = this.lqK.dhY();
            if (dhY != null && !dhY.isEmpty() && dhJ != null && !dhJ.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dhY.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dhY.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.jcK = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dhY.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dJE() != null) {
                        int bjt = next3.dJE().bjt();
                        if (bjt != 0) {
                            a(next3, bjt);
                            if (bjt != 28 && bjt != 31) {
                                if (next3.dJE().goods != null) {
                                    next3.dJE().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bjt);
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
                    if (this.lqK.getForum() != null) {
                        nVar4.forumId = this.lqK.getForum().getId();
                    }
                    if (this.lqK.dhH() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lqK.dhH().getId(), 0L);
                    }
                    if (this.lqK != null && this.lqK.getPage() != null) {
                        nVar4.pageNumber = this.lqK.getPage().bkq();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lqK.lnY;
                    if (position + i3 >= dhJ.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lNa) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dhJ, position)) {
                        a(nVar4, 1);
                    } else {
                        dhJ.add(position, nVar4);
                        TiebaStatic.eventStat(this.lNN.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dJE().apk_name);
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
        c.IB(i);
        com.baidu.tieba.recapp.report.d.dAT().a(c);
        if (nVar != null && nVar.dJE() != null) {
            nVar.dJE().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dJE() != null && nVar.dJE().goods != null && nVar.dJE().goods.goods_style != 1001 && nVar.dJE().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lqK != null && nVar.dJE() != null) {
            nVar.dJE().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lqK.getPage() != null) {
                nVar.dJE().advertAppContext.pn = this.lqK.getPage().bkq();
            }
            nVar.dJE().advertAppContext.page = nVar.dJH();
            if (this.lqK.getForum() != null && (forum = this.lqK.getForum()) != null) {
                nVar.dJE().advertAppContext.fid = forum.getId();
                nVar.dJE().advertAppContext.ewH = forum.getFirst_class();
                nVar.dJE().advertAppContext.ewI = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dJE().advertAppContext.ewJ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dJE().advertAppContext.extensionInfo = nVar.dJE().ext_info;
            nVar.dJE().advertAppContext.YS = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lqU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fgS = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aYm = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iOd.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.iOd.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fZl;
    }

    public void vy(boolean z) {
        this.lNa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Go(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.lNN.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lNN.dkB(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(final int i) {
        ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: biG */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(b.this.lNN.getContext(), b.this.djV(), i2, b.this.lNN.diV());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.lNN.getContext(), i, shareItem, false));
            }
        });
        ar arVar = new ar("c13833");
        arVar.ak("obj_locate", 1);
        if (i == 3) {
            arVar.ak("obj_type", 1);
        } else if (i == 8) {
            arVar.ak("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int djV() {
        if (this.lqK == null || this.lqK.dhH() == null) {
            return -1;
        }
        return this.lqK.dhH().bmp();
    }

    private void dre() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.fZl.size(); i++) {
            q qVar = this.fZl.get(i);
            if (qVar instanceof n) {
                this.lNR = i;
                z2 = true;
            } else if ((qVar instanceof e) && ((e) qVar).getTag() == this.lNM) {
                this.lNS = i;
                z = true;
            }
        }
        if (!z2) {
            this.lNR = -1;
        }
        if (!z) {
            this.lNS = -1;
        }
    }

    public int drf() {
        return this.lNR;
    }

    public int drg() {
        return this.lNS;
    }

    public boolean dku() {
        if (this.lNN.diV() != null) {
            return this.lNN.diV().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lqV = aVar;
    }
}
