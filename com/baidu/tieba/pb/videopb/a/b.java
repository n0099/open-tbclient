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
    private ArrayList<q> fLx;
    private BdTypeRecyclerView iuX;
    private com.baidu.adp.widget.ListView.a jmW;
    private com.baidu.tieba.pb.pb.main.adapter.d kXG;
    private m kXK;
    private com.baidu.adp.widget.ListView.a kXN;
    private an kXQ;
    private com.baidu.tieba.pb.pb.a.c kXR;
    private f kXV;
    private SortSwitchButton.a kYg;
    private d luT;
    private com.baidu.tieba.pb.pb.main.adapter.c luU;
    private c luV;
    private h luW;
    private ab luX;
    private DetailInfoAndReplyFragment lvb;
    private at lvc;
    private ae lvd;
    private k lve;
    private final BdUniqueId lva = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private boolean luo = true;
    private String bfg = null;
    private boolean kXW = true;
    private boolean mIsFromCDN = false;
    private int lvf = -1;
    private int lvg = -1;
    private View.OnClickListener kYf = null;
    private View.OnClickListener aXk = null;
    private TbRichTextView.i frJ = null;
    private com.baidu.tieba.pb.a.c eTx = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener luY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.Fk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.Fm(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.Fk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.Fm(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lvb = detailInfoAndReplyFragment;
        this.iuX = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.luT = new d(this.lvb.dfu(), PostData.mEg);
        this.luU = new com.baidu.tieba.pb.pb.main.adapter.c(this.lvb.dfu(), o.kVU);
        this.luU.setOnClickListener(this.luY);
        this.luV = new c(this.lvb.getContext(), s.TYPE);
        this.kXG = new com.baidu.tieba.pb.pb.main.adapter.d(this.lvb.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lvc = new at(this.lvb.dfu(), n.kVN);
        this.lvd = new ae(this.lvb.dfu(), j.kVx, this.lvb.getUniqueId());
        this.kXQ = new an(this.lvb.dfu(), l.Xr);
        this.lve = new k(this.lvb.dfu(), e.kUr);
        this.luW = new h(this.lvb.dfu(), com.baidu.tbadk.core.data.n.elv);
        this.luW.tD(true);
        this.luX = new ab(this.lvb.dfu());
        this.kXK = new m(this.lvb.dfu(), PostData.mEh);
        this.kXK.a((TbRichTextView.c) this.lvb.dfu());
        this.kXR = new com.baidu.tieba.pb.pb.a.c(this.lvb.dfu(), PostData.mEl);
        this.jmW = r.duF().a(this.lvb.dfu().getBaseFragmentActivity(), AdvertAppInfo.ekj);
        this.kXN = r.duF().a(this.lvb.dfu().getBaseFragmentActivity(), AdvertAppInfo.ekn);
        this.bhH.add(this.luT);
        this.bhH.add(this.luU);
        this.bhH.add(this.luV);
        this.bhH.add(this.kXG);
        this.bhH.add(this.lvc);
        this.bhH.add(this.kXQ);
        this.bhH.add(this.lvd);
        this.bhH.add(this.lve);
        this.bhH.add(this.luW);
        this.bhH.add(this.luX);
        this.bhH.add(this.jmW);
        this.bhH.add(this.kXN);
        this.bhH.add(this.kXK);
        this.bhH.add(this.kXR);
        this.iuX.addAdapters(this.bhH);
    }

    public void setData(f fVar) {
        PostData postData;
        bw dcA;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.kXV = fVar;
            if (fVar != null && fVar.dcA() != null && fVar.dcA().bih() != null) {
                this.bfg = fVar.dcA().bih().getUserId();
            }
            if (this.fLx == null) {
                this.fLx = new ArrayList<>();
            }
            this.fLx.clear();
            Iterator<PostData> it = fVar.dcC().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dEp() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.dcJ() != null) {
                postData = fVar.dcJ();
            }
            if (postData != null) {
                this.fLx.add(postData);
            }
            this.luT.setPbData(fVar);
            o oVar = new o(fVar.dcA(), fVar.getAnti());
            oVar.ts(false);
            oVar.kVW = false;
            this.fLx.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lvb.ddQ().ddH()) || !this.lvb.ddQ().dfR())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.lvb.ddQ().dfO();
                hVar.kVu = false;
                this.fLx.add(hVar);
                oVar.ts(false);
                oVar.kVW = false;
            }
            n nVar2 = new n(n.kVN);
            nVar2.kVP = fVar.dcA() != null ? dcA.bhY() : 0L;
            nVar2.isNew = !this.lvb.ddQ().dfQ();
            nVar2.kVS = dfo();
            nVar2.sortType = fVar.kUz;
            nVar2.kVR = fVar.dde();
            nVar2.isDynamic = fVar.ddd();
            nVar2.kVT = fVar.kUy;
            this.lvc.setData(fVar);
            this.fLx.add(nVar2);
            dep();
            if (this.kXN != null && (this.kXN instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kXN).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dcC().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dEp() == 1) {
                    z = z2;
                } else {
                    this.fLx.add(next2);
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                l lVar = new l();
                lVar.kVH = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.kVG = R.drawable.new_pic_emotion_03;
                lVar.fTK = com.baidu.adp.lib.util.l.getDimens(this.lvb.getContext(), R.dimen.tbds730);
                lVar.kVI = com.baidu.adp.lib.util.l.getDimens(this.lvb.getContext(), R.dimen.tbds74);
                lVar.kVJ = com.baidu.adp.lib.util.l.getDimens(this.lvb.getContext(), R.dimen.tbds74);
                this.fLx.add(lVar);
            }
            this.kXK.setData(fVar);
            this.kXK.setFromCDN(this.mIsFromCDN);
            this.kXK.hp(this.bfg);
            this.kXK.tt(this.kXW);
            this.kXK.A(this.aXk);
            this.kXK.S(this.kYf);
            this.kXK.setOnImageClickListener(this.frJ);
            this.kXK.setOnLongClickListener(this.mOnLongClickListener);
            this.kXK.setTbGestureDetector(this.eTx);
            this.lvc.A(this.aXk);
            this.lvc.a(this.kYg);
            this.kXR.setOnClickListener(this.aXk);
            if (fVar.getPage().bgX() == 0) {
                if (z2) {
                    this.lvd.setOnClickListener(this.lvb.dfu().dlg());
                    j jVar = new j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.fLx.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> ddh = fVar.ddh();
                int i3 = -1;
                if (ddh == null || ddh.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = ddh.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!y.isEmpty(fVar.ddc())) {
                    e eVar = new e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.lva);
                    this.fLx.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.n nVar5 : fVar.ddc()) {
                        if (ddh != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.fLx.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.ekj) {
                                    i++;
                                }
                            }
                            if (i2 < ddh.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = ddh.get(i2);
                                nVar4 = nVar6;
                                i4 = nVar6.getPosition();
                            }
                        }
                        this.fLx.add(nVar5);
                        i++;
                        if (i == 4 && fVar.dcG() != null) {
                            this.fLx.add(fVar.dcG());
                            i++;
                        }
                    }
                }
            }
            if (this.iuX != null) {
                this.iuX.setData(this.fLx);
            }
            dlU();
        }
    }

    private void dep() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kXV != null && !this.kXV.kVn && this.kXV.YG != 2) {
            ArrayList<PostData> dcC = this.kXV.dcC();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dcR = this.kXV.dcR();
            if (dcR != null && !dcR.isEmpty() && dcC != null && !dcC.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dcR.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dcR.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.iJE = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dcR.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dEd() != null) {
                        int bfY = next3.dEd().bfY();
                        if (bfY != 0) {
                            a(next3, bfY);
                            if (bfY != 28 && bfY != 31) {
                                if (next3.dEd().goods != null) {
                                    next3.dEd().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bfY);
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
                    if (this.kXV.getForum() != null) {
                        nVar4.forumId = this.kXV.getForum().getId();
                    }
                    if (this.kXV.dcA() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kXV.dcA().getId(), 0L);
                    }
                    if (this.kXV != null && this.kXV.getPage() != null) {
                        nVar4.pageNumber = this.kXV.getPage().bgV();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kXV.kVm;
                    if (position + i3 >= dcC.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.luo) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dcC, position)) {
                        a(nVar4, 1);
                    } else {
                        dcC.add(position, nVar4);
                        TiebaStatic.eventStat(this.lvb.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dEd().apk_name);
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
        c.Hu(i);
        com.baidu.tieba.recapp.report.d.dvG().a(c);
        if (nVar != null && nVar.dEd() != null) {
            nVar.dEd().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dEd() != null && nVar.dEd().goods != null && nVar.dEd().goods.goods_style != 1001 && nVar.dEd().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kXV != null && nVar.dEd() != null) {
            nVar.dEd().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kXV.getPage() != null) {
                nVar.dEd().advertAppContext.pn = this.kXV.getPage().bgV();
            }
            nVar.dEd().advertAppContext.page = nVar.dEg();
            if (this.kXV.getForum() != null && (forum = this.kXV.getForum()) != null) {
                nVar.dEd().advertAppContext.fid = forum.getId();
                nVar.dEd().advertAppContext.eka = forum.getFirst_class();
                nVar.dEd().advertAppContext.ekb = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dEd().advertAppContext.ekc = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dEd().advertAppContext.extensionInfo = nVar.dEd().ext_info;
            nVar.dEd().advertAppContext.YM = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kYf = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.frJ = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eTx = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aXk = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iuX.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.iuX.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fLx;
    }

    public void uV(boolean z) {
        this.luo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fk(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.lvb.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lvb.dfv(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm(final int i) {
        com.baidu.tbadk.util.ae.a(new ad<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bfj */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(b.this.lvb.getContext(), b.this.deP(), i2, b.this.lvb.ddQ());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.lvb.getContext(), i, shareItem, false));
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
    public int deP() {
        if (this.kXV == null || this.kXV.dcA() == null) {
            return -1;
        }
        return this.kXV.dcA().biU();
    }

    private void dlU() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.fLx.size(); i++) {
            q qVar = this.fLx.get(i);
            if (qVar instanceof n) {
                this.lvf = i;
                z2 = true;
            } else if ((qVar instanceof e) && ((e) qVar).getTag() == this.lva) {
                this.lvg = i;
                z = true;
            }
        }
        if (!z2) {
            this.lvf = -1;
        }
        if (!z) {
            this.lvg = -1;
        }
    }

    public int dlV() {
        return this.lvf;
    }

    public int dlW() {
        return this.lvg;
    }

    public boolean dfo() {
        if (this.lvb.ddQ() != null) {
            return this.lvb.ddQ().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kYg = aVar;
    }
}
