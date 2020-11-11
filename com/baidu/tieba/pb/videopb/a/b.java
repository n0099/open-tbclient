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
    private ArrayList<q> fZE;
    private BdTypeRecyclerView iNq;
    private com.baidu.adp.widget.ListView.a jFt;
    private d lNn;
    private com.baidu.tieba.pb.pb.main.adapter.c lNo;
    private c lNp;
    private h lNq;
    private ab lNr;
    private DetailInfoAndReplyFragment lNv;
    private at lNw;
    private ae lNx;
    private k lNy;
    private SortSwitchButton.a lqG;
    private com.baidu.tieba.pb.pb.main.adapter.d lqg;
    private m lqk;
    private com.baidu.adp.widget.ListView.a lqn;
    private an lqq;
    private com.baidu.tieba.pb.pb.a.c lqr;
    private f lqv;
    private final BdUniqueId lNu = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private boolean lMI = true;
    private String bhP = null;
    private boolean lqw = true;
    private boolean mIsFromCDN = false;
    private int lNz = -1;
    private int lNA = -1;
    private View.OnClickListener lqF = null;
    private View.OnClickListener aZX = null;
    private TbRichTextView.i fFW = null;
    private com.baidu.tieba.pb.a.c fhK = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener lNs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.FQ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.FS(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.FQ(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.FS(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lNv = detailInfoAndReplyFragment;
        this.iNq = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.lNn = new d(this.lNv.dld(), PostData.mWQ);
        this.lNo = new com.baidu.tieba.pb.pb.main.adapter.c(this.lNv.dld(), o.lot);
        this.lNo.setOnClickListener(this.lNs);
        this.lNp = new c(this.lNv.getContext(), s.TYPE);
        this.lqg = new com.baidu.tieba.pb.pb.main.adapter.d(this.lNv.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lNw = new at(this.lNv.dld(), n.lol);
        this.lNx = new ae(this.lNv.dld(), j.lnT, this.lNv.getUniqueId());
        this.lqq = new an(this.lNv.dld(), l.Xs);
        this.lNy = new k(this.lNv.dld(), e.lmM);
        this.lNq = new h(this.lNv.dld(), com.baidu.tbadk.core.data.n.ezO);
        this.lNq.ud(true);
        this.lNr = new ab(this.lNv.dld());
        this.lqk = new m(this.lNv.dld(), PostData.mWR);
        this.lqk.a((TbRichTextView.c) this.lNv.dld());
        this.lqr = new com.baidu.tieba.pb.pb.a.c(this.lNv.dld(), PostData.mWV);
        this.jFt = r.dAo().a(this.lNv.dld().getBaseFragmentActivity(), AdvertAppInfo.eyC);
        this.lqn = r.dAo().a(this.lNv.dld().getBaseFragmentActivity(), AdvertAppInfo.eyG);
        this.bky.add(this.lNn);
        this.bky.add(this.lNo);
        this.bky.add(this.lNp);
        this.bky.add(this.lqg);
        this.bky.add(this.lNw);
        this.bky.add(this.lqq);
        this.bky.add(this.lNx);
        this.bky.add(this.lNy);
        this.bky.add(this.lNq);
        this.bky.add(this.lNr);
        this.bky.add(this.jFt);
        this.bky.add(this.lqn);
        this.bky.add(this.lqk);
        this.bky.add(this.lqr);
        this.iNq.addAdapters(this.bky);
    }

    public void setData(f fVar) {
        PostData postData;
        bw dik;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.lqv = fVar;
            if (fVar != null && fVar.dik() != null && fVar.dik().bmA() != null) {
                this.bhP = fVar.dik().bmA().getUserId();
            }
            if (this.fZE == null) {
                this.fZE = new ArrayList<>();
            }
            this.fZE.clear();
            Iterator<PostData> it = fVar.dim().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dJZ() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.dit() != null) {
                postData = fVar.dit();
            }
            if (postData != null) {
                this.fZE.add(postData);
            }
            this.lNn.setPbData(fVar);
            o oVar = new o(fVar.dik(), fVar.getAnti());
            oVar.tS(false);
            oVar.lov = false;
            this.fZE.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lNv.djz().djr()) || !this.lNv.djz().dlA())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.lNv.djz().dlx();
                hVar.lnQ = false;
                this.fZE.add(hVar);
                oVar.tS(false);
                oVar.lov = false;
            }
            n nVar2 = new n(n.lol);
            nVar2.loo = fVar.dik() != null ? dik.bmr() : 0L;
            nVar2.isNew = !this.lNv.djz().dlz();
            nVar2.lor = dkX();
            nVar2.sortType = fVar.lmU;
            nVar2.loq = fVar.diO();
            nVar2.isDynamic = fVar.diN();
            nVar2.los = fVar.lmT;
            this.lNw.setData(fVar);
            this.fZE.add(nVar2);
            djY();
            if (this.lqn != null && (this.lqn instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.lqn).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dim().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dJZ() == 1) {
                    z = z2;
                } else {
                    this.fZE.add(next2);
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                l lVar = new l();
                lVar.loe = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.lod = R.drawable.new_pic_emotion_03;
                lVar.gjD = com.baidu.adp.lib.util.l.getDimens(this.lNv.getContext(), R.dimen.tbds730);
                lVar.lof = com.baidu.adp.lib.util.l.getDimens(this.lNv.getContext(), R.dimen.tbds74);
                lVar.loh = com.baidu.adp.lib.util.l.getDimens(this.lNv.getContext(), R.dimen.tbds74);
                this.fZE.add(lVar);
            }
            this.lqk.setData(fVar);
            this.lqk.setFromCDN(this.mIsFromCDN);
            this.lqk.hE(this.bhP);
            this.lqk.tT(this.lqw);
            this.lqk.B(this.aZX);
            this.lqk.T(this.lqF);
            this.lqk.setOnImageClickListener(this.fFW);
            this.lqk.setOnLongClickListener(this.mOnLongClickListener);
            this.lqk.setTbGestureDetector(this.fhK);
            this.lNw.B(this.aZX);
            this.lNw.a(this.lqG);
            this.lqr.setOnClickListener(this.aZX);
            if (fVar.getPage().blq() == 0) {
                if (z2) {
                    this.lNx.setOnClickListener(this.lNv.dld().dqQ());
                    j jVar = new j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.fZE.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> diR = fVar.diR();
                int i3 = -1;
                if (diR == null || diR.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = diR.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!y.isEmpty(fVar.diM())) {
                    e eVar = new e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.lNu);
                    this.fZE.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.n nVar5 : fVar.diM()) {
                        if (diR != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.fZE.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.eyC) {
                                    i++;
                                }
                            }
                            if (i2 < diR.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = diR.get(i2);
                                nVar4 = nVar6;
                                i4 = nVar6.getPosition();
                            }
                        }
                        this.fZE.add(nVar5);
                        i++;
                        if (i == 4 && fVar.diq() != null) {
                            this.fZE.add(fVar.diq());
                            i++;
                        }
                    }
                }
            }
            if (this.iNq != null) {
                this.iNq.setData(this.fZE);
            }
            drE();
        }
    }

    private void djY() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lqv != null && !this.lqv.lnJ && this.lqv.YH != 2) {
            ArrayList<PostData> dim = this.lqv.dim();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> diB = this.lqv.diB();
            if (diB != null && !diB.isEmpty() && dim != null && !dim.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = diB.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = diB.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.jbX = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = diB.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dJN() != null) {
                        int bkr = next3.dJN().bkr();
                        if (bkr != 0) {
                            a(next3, bkr);
                            if (bkr != 28 && bkr != 31) {
                                if (next3.dJN().goods != null) {
                                    next3.dJN().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bkr);
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
                    if (this.lqv.getForum() != null) {
                        nVar4.forumId = this.lqv.getForum().getId();
                    }
                    if (this.lqv.dik() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lqv.dik().getId(), 0L);
                    }
                    if (this.lqv != null && this.lqv.getPage() != null) {
                        nVar4.pageNumber = this.lqv.getPage().blo();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lqv.lnI;
                    if (position + i3 >= dim.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.lMI) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dim, position)) {
                        a(nVar4, 1);
                    } else {
                        dim.add(position, nVar4);
                        TiebaStatic.eventStat(this.lNv.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dJN().apk_name);
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
        c.Ia(i);
        com.baidu.tieba.recapp.report.d.dBp().a(c);
        if (nVar != null && nVar.dJN() != null) {
            nVar.dJN().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dJN() != null && nVar.dJN().goods != null && nVar.dJN().goods.goods_style != 1001 && nVar.dJN().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lqv != null && nVar.dJN() != null) {
            nVar.dJN().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.lqv.getPage() != null) {
                nVar.dJN().advertAppContext.pn = this.lqv.getPage().blo();
            }
            nVar.dJN().advertAppContext.page = nVar.dJQ();
            if (this.lqv.getForum() != null && (forum = this.lqv.getForum()) != null) {
                nVar.dJN().advertAppContext.fid = forum.getId();
                nVar.dJN().advertAppContext.eyt = forum.getFirst_class();
                nVar.dJN().advertAppContext.eyu = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dJN().advertAppContext.eyv = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dJN().advertAppContext.extensionInfo = nVar.dJN().ext_info;
            nVar.dJN().advertAppContext.YN = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void T(View.OnClickListener onClickListener) {
        this.lqF = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fFW = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fhK = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void G(View.OnClickListener onClickListener) {
        this.aZX = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iNq.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.iNq.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fZE;
    }

    public void vv(boolean z) {
        this.lMI = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FQ(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.lNv.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lNv.dle(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS(final int i) {
        com.baidu.tbadk.util.ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bjC */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(b.this.lNv.getContext(), b.this.dky(), i2, b.this.lNv.djz());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.lNv.getContext(), i, shareItem, false));
            }
        });
        aq aqVar = new aq("c13833");
        aqVar.al("obj_locate", 1);
        if (i == 3) {
            aqVar.al("obj_type", 1);
        } else if (i == 8) {
            aqVar.al("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dky() {
        if (this.lqv == null || this.lqv.dik() == null) {
            return -1;
        }
        return this.lqv.dik().bnn();
    }

    private void drE() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.fZE.size(); i++) {
            q qVar = this.fZE.get(i);
            if (qVar instanceof n) {
                this.lNz = i;
                z2 = true;
            } else if ((qVar instanceof e) && ((e) qVar).getTag() == this.lNu) {
                this.lNA = i;
                z = true;
            }
        }
        if (!z2) {
            this.lNz = -1;
        }
        if (!z) {
            this.lNA = -1;
        }
    }

    public int drF() {
        return this.lNz;
    }

    public int drG() {
        return this.lNA;
    }

    public boolean dkX() {
        if (this.lNv.djz() != null) {
            return this.lNv.djz().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lqG = aVar;
    }
}
