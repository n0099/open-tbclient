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
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> fzo;
    private com.baidu.adp.widget.ListView.a iXX;
    private BdTypeRecyclerView iga;
    private com.baidu.adp.widget.ListView.a kIC;
    private an kIF;
    private com.baidu.tieba.pb.pb.a.c kIG;
    private f kIK;
    private SortSwitchButton.a kIV;
    private com.baidu.tieba.pb.pb.main.adapter.d kIv;
    private m kIz;
    private d lfC;
    private com.baidu.tieba.pb.pb.main.adapter.c lfD;
    private c lfE;
    private h lfF;
    private ab lfG;
    private DetailInfoAndReplyFragment lfK;
    private at lfL;
    private ae lfM;
    private k lfN;
    private final BdUniqueId lfJ = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private boolean leX = true;
    private String bbv = null;
    private boolean kIL = true;
    private boolean mIsFromCDN = false;
    private int lfO = -1;
    private int lfP = -1;
    private View.OnClickListener kIU = null;
    private View.OnClickListener aTZ = null;
    private TbRichTextView.i ffu = null;
    private com.baidu.tieba.pb.a.c eHq = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener lfH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.EE(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.EG(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.EE(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.EG(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lfK = detailInfoAndReplyFragment;
        this.iga = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.lfC = new d(this.lfK.dbL(), PostData.moA);
        this.lfD = new com.baidu.tieba.pb.pb.main.adapter.c(this.lfK.dbL(), o.kGJ);
        this.lfD.setOnClickListener(this.lfH);
        this.lfE = new c(this.lfK.getContext(), s.TYPE);
        this.kIv = new com.baidu.tieba.pb.pb.main.adapter.d(this.lfK.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lfL = new at(this.lfK.dbL(), n.kGC);
        this.lfM = new ae(this.lfK.dbL(), j.kGm, this.lfK.getUniqueId());
        this.kIF = new an(this.lfK.dbL(), l.Xa);
        this.lfN = new k(this.lfK.dbL(), e.kFg);
        this.lfF = new h(this.lfK.dbL(), com.baidu.tbadk.core.data.n.dZt);
        this.lfF.sW(true);
        this.lfG = new ab(this.lfK.dbL());
        this.kIz = new m(this.lfK.dbL(), PostData.moB);
        this.kIz.a((TbRichTextView.c) this.lfK.dbL());
        this.kIG = new com.baidu.tieba.pb.pb.a.c(this.lfK.dbL(), PostData.moF);
        this.iXX = r.dqU().a(this.lfK.dbL().getBaseFragmentActivity(), AdvertAppInfo.dYh);
        this.kIC = r.dqU().a(this.lfK.dbL().getBaseFragmentActivity(), AdvertAppInfo.dYl);
        this.bdV.add(this.lfC);
        this.bdV.add(this.lfD);
        this.bdV.add(this.lfE);
        this.bdV.add(this.kIv);
        this.bdV.add(this.lfL);
        this.bdV.add(this.kIF);
        this.bdV.add(this.lfM);
        this.bdV.add(this.lfN);
        this.bdV.add(this.lfF);
        this.bdV.add(this.lfG);
        this.bdV.add(this.iXX);
        this.bdV.add(this.kIC);
        this.bdV.add(this.kIz);
        this.bdV.add(this.kIG);
        this.iga.addAdapters(this.bdV);
    }

    public void setData(f fVar) {
        PostData postData;
        bw cYR;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.kIK = fVar;
            if (fVar != null && fVar.cYR() != null && fVar.cYR().bfy() != null) {
                this.bbv = fVar.cYR().bfy().getUserId();
            }
            if (this.fzo == null) {
                this.fzo = new ArrayList<>();
            }
            this.fzo.clear();
            Iterator<PostData> it = fVar.cYT().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dAD() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.cZa() != null) {
                postData = fVar.cZa();
            }
            if (postData != null) {
                this.fzo.add(postData);
            }
            this.lfC.setPbData(fVar);
            o oVar = new o(fVar.cYR(), fVar.getAnti());
            oVar.sL(false);
            oVar.kGL = false;
            this.fzo.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lfK.dah().cZY()) || !this.lfK.dah().dci())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.lfK.dah().dcf();
                hVar.kGj = false;
                this.fzo.add(hVar);
                oVar.sL(false);
                oVar.kGL = false;
            }
            n nVar2 = new n(n.kGC);
            nVar2.kGE = fVar.cYR() != null ? cYR.bfp() : 0L;
            nVar2.isNew = !this.lfK.dah().dch();
            nVar2.kGH = dbF();
            nVar2.sortType = fVar.kFo;
            nVar2.kGG = fVar.cZv();
            nVar2.isDynamic = fVar.cZu();
            nVar2.kGI = fVar.kFn;
            this.lfL.setData(fVar);
            this.fzo.add(nVar2);
            daG();
            if (this.kIC != null && (this.kIC instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kIC).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.cYT().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dAD() == 1) {
                    z = z2;
                } else {
                    this.fzo.add(next2);
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                l lVar = new l();
                lVar.kGw = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.kGv = R.drawable.new_pic_emotion_03;
                lVar.fHA = com.baidu.adp.lib.util.l.getDimens(this.lfK.getContext(), R.dimen.tbds730);
                lVar.kGx = com.baidu.adp.lib.util.l.getDimens(this.lfK.getContext(), R.dimen.tbds74);
                lVar.kGy = com.baidu.adp.lib.util.l.getDimens(this.lfK.getContext(), R.dimen.tbds74);
                this.fzo.add(lVar);
            }
            this.kIz.setData(fVar);
            this.kIz.setFromCDN(this.mIsFromCDN);
            this.kIz.gY(this.bbv);
            this.kIz.sM(this.kIL);
            this.kIz.A(this.aTZ);
            this.kIz.S(this.kIU);
            this.kIz.setOnImageClickListener(this.ffu);
            this.kIz.setOnLongClickListener(this.mOnLongClickListener);
            this.kIz.setTbGestureDetector(this.eHq);
            this.lfL.A(this.aTZ);
            this.lfL.a(this.kIV);
            this.kIG.setOnClickListener(this.aTZ);
            if (fVar.getPage().beo() == 0) {
                if (z2) {
                    this.lfM.setOnClickListener(this.lfK.dbL().dhx());
                    j jVar = new j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.fzo.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> cZy = fVar.cZy();
                int i3 = -1;
                if (cZy == null || cZy.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = cZy.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!y.isEmpty(fVar.cZt())) {
                    e eVar = new e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.lfJ);
                    this.fzo.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.n nVar5 : fVar.cZt()) {
                        if (cZy != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.fzo.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.dYh) {
                                    i++;
                                }
                            }
                            if (i2 < cZy.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = cZy.get(i2);
                                nVar4 = nVar6;
                                i4 = nVar6.getPosition();
                            }
                        }
                        this.fzo.add(nVar5);
                        i++;
                        if (i == 4 && fVar.cYX() != null) {
                            this.fzo.add(fVar.cYX());
                            i++;
                        }
                    }
                }
            }
            if (this.iga != null) {
                this.iga.setData(this.fzo);
            }
            dil();
        }
    }

    private void daG() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kIK != null && !this.kIK.kGc && this.kIK.Yq != 2) {
            ArrayList<PostData> cYT = this.kIK.cYT();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cZi = this.kIK.cZi();
            if (cZi != null && !cZi.isEmpty() && cYT != null && !cYT.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = cZi.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cZi.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.iuL = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cZi.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dAr() != null) {
                        int bdp = next3.dAr().bdp();
                        if (bdp != 0) {
                            a(next3, bdp);
                            if (bdp != 28 && bdp != 31) {
                                if (next3.dAr().goods != null) {
                                    next3.dAr().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bdp);
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
                    if (this.kIK.getForum() != null) {
                        nVar4.forumId = this.kIK.getForum().getId();
                    }
                    if (this.kIK.cYR() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kIK.cYR().getId(), 0L);
                    }
                    if (this.kIK != null && this.kIK.getPage() != null) {
                        nVar4.pageNumber = this.kIK.getPage().bem();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kIK.kGb;
                    if (position + i3 >= cYT.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.leX) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(cYT, position)) {
                        a(nVar4, 1);
                    } else {
                        cYT.add(position, nVar4);
                        TiebaStatic.eventStat(this.lfK.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dAr().apk_name);
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
        c.GO(i);
        com.baidu.tieba.recapp.report.d.drV().a(c);
        if (nVar != null && nVar.dAr() != null) {
            nVar.dAr().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dAr() != null && nVar.dAr().goods != null && nVar.dAr().goods.goods_style != 1001 && nVar.dAr().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kIK != null && nVar.dAr() != null) {
            nVar.dAr().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kIK.getPage() != null) {
                nVar.dAr().advertAppContext.pn = this.kIK.getPage().bem();
            }
            nVar.dAr().advertAppContext.page = nVar.dAu();
            if (this.kIK.getForum() != null && (forum = this.kIK.getForum()) != null) {
                nVar.dAr().advertAppContext.fid = forum.getId();
                nVar.dAr().advertAppContext.dXY = forum.getFirst_class();
                nVar.dAr().advertAppContext.dXZ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dAr().advertAppContext.dYa = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dAr().advertAppContext.extensionInfo = nVar.dAr().ext_info;
            nVar.dAr().advertAppContext.Yw = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kIU = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.ffu = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eHq = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aTZ = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iga.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.iga.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fzo;
    }

    public void uo(boolean z) {
        this.leX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean EE(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.lfK.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lfK.dbM(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG(final int i) {
        com.baidu.tbadk.util.ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bcB */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(b.this.lfK.getContext(), b.this.dbg(), i2, b.this.lfK.dah());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.lfK.getContext(), i, shareItem, false));
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
    public int dbg() {
        if (this.kIK == null || this.kIK.cYR() == null) {
            return -1;
        }
        return this.kIK.cYR().bgl();
    }

    private void dil() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.fzo.size(); i++) {
            q qVar = this.fzo.get(i);
            if (qVar instanceof n) {
                this.lfO = i;
                z2 = true;
            } else if ((qVar instanceof e) && ((e) qVar).getTag() == this.lfJ) {
                this.lfP = i;
                z = true;
            }
        }
        if (!z2) {
            this.lfO = -1;
        }
        if (!z) {
            this.lfP = -1;
        }
    }

    public int dim() {
        return this.lfO;
    }

    public int din() {
        return this.lfP;
    }

    public boolean dbF() {
        if (this.lfK.dah() != null) {
            return this.lfK.dah().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kIV = aVar;
    }
}
