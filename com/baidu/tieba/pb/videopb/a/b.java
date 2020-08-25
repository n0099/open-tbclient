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
    private ArrayList<q> fwa;
    private BdTypeRecyclerView hYQ;
    private com.baidu.adp.widget.ListView.a iPl;
    private an kAb;
    private com.baidu.tieba.pb.pb.a.c kAc;
    private f kAg;
    private SortSwitchButton.a kAr;
    private d kWQ;
    private com.baidu.tieba.pb.pb.main.adapter.c kWR;
    private c kWS;
    private h kWT;
    private ab kWU;
    private DetailInfoAndReplyFragment kWY;
    private at kWZ;
    private ae kXa;
    private k kXb;
    private com.baidu.tieba.pb.pb.main.adapter.d kzR;
    private m kzV;
    private com.baidu.adp.widget.ListView.a kzY;
    private final BdUniqueId kWX = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private boolean kWl = true;
    private String aYW = null;
    private boolean kAh = true;
    private boolean mIsFromCDN = false;
    private int kXc = -1;
    private int kXd = -1;
    private View.OnClickListener kAq = null;
    private View.OnClickListener aRU = null;
    private TbRichTextView.i fcy = null;
    private com.baidu.tieba.pb.a.c eFf = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener kWV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.Ef(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.Ed(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.Ef(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kWY = detailInfoAndReplyFragment;
        this.hYQ = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.kWQ = new d(this.kWY.cYh(), PostData.meM);
        this.kWR = new com.baidu.tieba.pb.pb.main.adapter.c(this.kWY.cYh(), o.kyf);
        this.kWR.setOnClickListener(this.kWV);
        this.kWS = new c(this.kWY.getContext(), s.TYPE);
        this.kzR = new com.baidu.tieba.pb.pb.main.adapter.d(this.kWY.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kWZ = new at(this.kWY.cYh(), n.kxY);
        this.kXa = new ae(this.kWY.cYh(), j.kxH, this.kWY.getUniqueId());
        this.kAb = new an(this.kWY.cYh(), l.WI);
        this.kXb = new k(this.kWY.cYh(), e.kwA);
        this.kWT = new h(this.kWY.cYh(), com.baidu.tbadk.core.data.n.dXf);
        this.kWT.sN(true);
        this.kWU = new ab(this.kWY.cYh());
        this.kzV = new m(this.kWY.cYh(), PostData.meN);
        this.kzV.a((TbRichTextView.c) this.kWY.cYh());
        this.kAc = new com.baidu.tieba.pb.pb.a.c(this.kWY.cYh(), PostData.meR);
        this.iPl = r.dnh().a(this.kWY.cYh().getBaseFragmentActivity(), AdvertAppInfo.dVT);
        this.kzY = r.dnh().a(this.kWY.cYh().getBaseFragmentActivity(), AdvertAppInfo.dVX);
        this.bbu.add(this.kWQ);
        this.bbu.add(this.kWR);
        this.bbu.add(this.kWS);
        this.bbu.add(this.kzR);
        this.bbu.add(this.kWZ);
        this.bbu.add(this.kAb);
        this.bbu.add(this.kXa);
        this.bbu.add(this.kXb);
        this.bbu.add(this.kWT);
        this.bbu.add(this.kWU);
        this.bbu.add(this.iPl);
        this.bbu.add(this.kzY);
        this.bbu.add(this.kzV);
        this.bbu.add(this.kAc);
        this.hYQ.addAdapters(this.bbu);
    }

    public void setData(f fVar) {
        PostData postData;
        bw cVl;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.kAg = fVar;
            if (fVar != null && fVar.cVl() != null && fVar.cVl().beE() != null) {
                this.aYW = fVar.cVl().beE().getUserId();
            }
            if (this.fwa == null) {
                this.fwa = new ArrayList<>();
            }
            this.fwa.clear();
            Iterator<PostData> it = fVar.cVn().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dwF() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.cVu() != null) {
                postData = fVar.cVu();
            }
            if (postData != null) {
                this.fwa.add(postData);
            }
            this.kWQ.setPbData(fVar);
            o oVar = new o(fVar.cVl(), fVar.getAnti());
            oVar.sC(false);
            oVar.kyh = false;
            this.fwa.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kWY.cWD().cWu()) || !this.kWY.cWD().cYE())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.kWY.cWD().cYB();
                hVar.kxE = false;
                this.fwa.add(hVar);
                oVar.sC(false);
                oVar.kyh = false;
            }
            n nVar2 = new n(n.kxY);
            nVar2.kya = fVar.cVl() != null ? cVl.bev() : 0L;
            nVar2.isNew = !this.kWY.cWD().cYD();
            nVar2.kyd = cYb();
            nVar2.sortType = fVar.kwI;
            nVar2.kyc = fVar.cVP();
            nVar2.isDynamic = fVar.cVO();
            nVar2.kye = fVar.kwH;
            this.kWZ.setData(fVar);
            this.fwa.add(nVar2);
            Iterator<PostData> it2 = fVar.cVn().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dwF() == 1) {
                    z = z2;
                } else {
                    this.fwa.add(next2);
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                l lVar = new l();
                lVar.kxR = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.kxQ = R.drawable.new_pic_emotion_03;
                lVar.fEk = com.baidu.adp.lib.util.l.getDimens(this.kWY.getContext(), R.dimen.tbds730);
                lVar.kxS = com.baidu.adp.lib.util.l.getDimens(this.kWY.getContext(), R.dimen.tbds74);
                lVar.kxT = com.baidu.adp.lib.util.l.getDimens(this.kWY.getContext(), R.dimen.tbds74);
                this.fwa.add(lVar);
            }
            this.kzV.setData(fVar);
            this.kzV.setFromCDN(this.mIsFromCDN);
            this.kzV.gL(this.aYW);
            this.kzV.sD(this.kAh);
            this.kzV.A(this.aRU);
            this.kzV.S(this.kAq);
            this.kzV.setOnImageClickListener(this.fcy);
            this.kzV.setOnLongClickListener(this.mOnLongClickListener);
            this.kzV.setTbGestureDetector(this.eFf);
            this.kWZ.A(this.aRU);
            this.kWZ.a(this.kAr);
            this.kAc.setOnClickListener(this.aRU);
            cXc();
            if (this.kzY != null && (this.kzY instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kzY).setIsFromCDN(this.mIsFromCDN);
            }
            if (fVar.getPage().bdu() == 0) {
                if (z2) {
                    this.kXa.setOnClickListener(this.kWY.cYh().ddS());
                    j jVar = new j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.fwa.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> cVS = fVar.cVS();
                int i3 = -1;
                if (cVS == null || cVS.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = cVS.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!y.isEmpty(fVar.cVN())) {
                    e eVar = new e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.kWX);
                    this.fwa.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.n nVar5 : fVar.cVN()) {
                        if (cVS != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.fwa.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.dVT) {
                                    i++;
                                }
                            }
                            if (i2 < cVS.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = cVS.get(i2);
                                nVar4 = nVar6;
                                i4 = nVar6.getPosition();
                            }
                        }
                        this.fwa.add(nVar5);
                        i++;
                        if (i == 4 && fVar.cVr() != null) {
                            this.fwa.add(fVar.cVr());
                            i++;
                        }
                    }
                }
            }
            if (this.hYQ != null) {
                this.hYQ.setData(this.fwa);
            }
            deG();
        }
    }

    private void cXc() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kAg != null && !this.kAg.kxx && this.kAg.XV != 2) {
            ArrayList<PostData> cVn = this.kAg.cVn();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cVC = this.kAg.cVC();
            if (cVC != null && !cVC.isEmpty() && cVn != null && !cVn.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = cVC.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cVC.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.ino = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cVC.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dwt() != null) {
                        int bcv = next3.dwt().bcv();
                        if (bcv != 0) {
                            a(next3, bcv);
                            if (bcv != 28 && bcv != 31) {
                                if (next3.dwt().goods != null) {
                                    next3.dwt().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bcv);
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
                    if (this.kAg.getForum() != null) {
                        nVar4.forumId = this.kAg.getForum().getId();
                    }
                    if (this.kAg.cVl() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kAg.cVl().getId(), 0L);
                    }
                    if (this.kAg != null && this.kAg.getPage() != null) {
                        nVar4.pageNumber = this.kAg.getPage().bds();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kAg.kxw;
                    if (position + i3 >= cVn.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kWl) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cVn, position)) {
                        a(nVar4, 1);
                    } else {
                        cVn.add(position, nVar4);
                        TiebaStatic.eventStat(this.kWY.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dwt().apk_name);
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
        c.Gn(i);
        com.baidu.tieba.recapp.report.d.doi().a(c);
        if (nVar != null && nVar.dwt() != null) {
            nVar.dwt().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dwt() != null && nVar.dwt().goods != null && nVar.dwt().goods.goods_style != 1001 && nVar.dwt().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kAg != null && nVar.dwt() != null) {
            nVar.dwt().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kAg.getPage() != null) {
                nVar.dwt().advertAppContext.pn = this.kAg.getPage().bds();
            }
            nVar.dwt().advertAppContext.page = nVar.dww();
            if (this.kAg.getForum() != null && (forum = this.kAg.getForum()) != null) {
                nVar.dwt().advertAppContext.fid = forum.getId();
                nVar.dwt().advertAppContext.dVK = forum.getFirst_class();
                nVar.dwt().advertAppContext.dVL = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dwt().advertAppContext.dVM = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dwt().advertAppContext.extensionInfo = nVar.dwt().ext_info;
            nVar.dwt().advertAppContext.Yb = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAq = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcy = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFf = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aRU = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hYQ.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.hYQ.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fwa;
    }

    public void ue(boolean z) {
        this.kWl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ed(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.kWY.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.kWY.cYi(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ef(final int i) {
        ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bbH */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(b.this.kWY.getContext(), b.this.cXC(), i2, b.this.kWY.cWD());
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.kWY.getContext(), i, shareItem, false));
            }
        });
        aq aqVar = new aq("c13833");
        aqVar.ai("obj_locate", 1);
        if (i == 3) {
            aqVar.ai("obj_type", 1);
        } else if (i == 8) {
            aqVar.ai("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cXC() {
        if (this.kAg == null || this.kAg.cVl() == null) {
            return -1;
        }
        return this.kAg.cVl().bfr();
    }

    private void deG() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.fwa.size(); i++) {
            q qVar = this.fwa.get(i);
            if (qVar instanceof n) {
                this.kXc = i;
                z2 = true;
            } else if ((qVar instanceof e) && ((e) qVar).getTag() == this.kWX) {
                this.kXd = i;
                z = true;
            }
        }
        if (!z2) {
            this.kXc = -1;
        }
        if (!z) {
            this.kXd = -1;
        }
    }

    public int deH() {
        return this.kXc;
    }

    public int deI() {
        return this.kXd;
    }

    public boolean cYb() {
        if (this.kWY.cWD() != null) {
            return this.kWY.cWD().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kAr = aVar;
    }
}
