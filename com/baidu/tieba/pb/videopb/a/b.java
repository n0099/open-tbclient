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
    private ArrayList<q> fwe;
    private BdTypeRecyclerView hYW;
    private com.baidu.adp.widget.ListView.a iPr;
    private m kAc;
    private com.baidu.adp.widget.ListView.a kAf;
    private an kAi;
    private com.baidu.tieba.pb.pb.a.c kAj;
    private f kAn;
    private SortSwitchButton.a kAy;
    private d kWX;
    private com.baidu.tieba.pb.pb.main.adapter.c kWY;
    private c kWZ;
    private h kXa;
    private ab kXb;
    private DetailInfoAndReplyFragment kXf;
    private at kXg;
    private ae kXh;
    private k kXi;
    private com.baidu.tieba.pb.pb.main.adapter.d kzY;
    private final BdUniqueId kXe = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private boolean kWs = true;
    private String aYY = null;
    private boolean kAo = true;
    private boolean mIsFromCDN = false;
    private int kXj = -1;
    private int kXk = -1;
    private View.OnClickListener kAx = null;
    private View.OnClickListener aRW = null;
    private TbRichTextView.i fcC = null;
    private com.baidu.tieba.pb.a.c eFj = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener kXc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
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
        this.kXf = detailInfoAndReplyFragment;
        this.hYW = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.kWX = new d(this.kXf.cYi(), PostData.mfb);
        this.kWY = new com.baidu.tieba.pb.pb.main.adapter.c(this.kXf.cYi(), o.kym);
        this.kWY.setOnClickListener(this.kXc);
        this.kWZ = new c(this.kXf.getContext(), s.TYPE);
        this.kzY = new com.baidu.tieba.pb.pb.main.adapter.d(this.kXf.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.kXg = new at(this.kXf.cYi(), n.kyf);
        this.kXh = new ae(this.kXf.cYi(), j.kxO, this.kXf.getUniqueId());
        this.kAi = new an(this.kXf.cYi(), l.WI);
        this.kXi = new k(this.kXf.cYi(), e.kwH);
        this.kXa = new h(this.kXf.cYi(), com.baidu.tbadk.core.data.n.dXj);
        this.kXa.sP(true);
        this.kXb = new ab(this.kXf.cYi());
        this.kAc = new m(this.kXf.cYi(), PostData.mfc);
        this.kAc.a((TbRichTextView.c) this.kXf.cYi());
        this.kAj = new com.baidu.tieba.pb.pb.a.c(this.kXf.cYi(), PostData.mfg);
        this.iPr = r.dnk().a(this.kXf.cYi().getBaseFragmentActivity(), AdvertAppInfo.dVX);
        this.kAf = r.dnk().a(this.kXf.cYi().getBaseFragmentActivity(), AdvertAppInfo.dWb);
        this.bbw.add(this.kWX);
        this.bbw.add(this.kWY);
        this.bbw.add(this.kWZ);
        this.bbw.add(this.kzY);
        this.bbw.add(this.kXg);
        this.bbw.add(this.kAi);
        this.bbw.add(this.kXh);
        this.bbw.add(this.kXi);
        this.bbw.add(this.kXa);
        this.bbw.add(this.kXb);
        this.bbw.add(this.iPr);
        this.bbw.add(this.kAf);
        this.bbw.add(this.kAc);
        this.bbw.add(this.kAj);
        this.hYW.addAdapters(this.bbw);
    }

    public void setData(f fVar) {
        PostData postData;
        bw cVm;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.kAn = fVar;
            if (fVar != null && fVar.cVm() != null && fVar.cVm().beE() != null) {
                this.aYY = fVar.cVm().beE().getUserId();
            }
            if (this.fwe == null) {
                this.fwe = new ArrayList<>();
            }
            this.fwe.clear();
            Iterator<PostData> it = fVar.cVo().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dwK() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.cVv() != null) {
                postData = fVar.cVv();
            }
            if (postData != null) {
                this.fwe.add(postData);
            }
            this.kWX.setPbData(fVar);
            o oVar = new o(fVar.cVm(), fVar.getAnti());
            oVar.sE(false);
            oVar.kyo = false;
            this.fwe.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.kXf.cWE().cWv()) || !this.kXf.cWE().cYF())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.kXf.cWE().cYC();
                hVar.kxL = false;
                this.fwe.add(hVar);
                oVar.sE(false);
                oVar.kyo = false;
            }
            n nVar2 = new n(n.kyf);
            nVar2.kyh = fVar.cVm() != null ? cVm.bev() : 0L;
            nVar2.isNew = !this.kXf.cWE().cYE();
            nVar2.kyk = cYc();
            nVar2.sortType = fVar.kwP;
            nVar2.kyj = fVar.cVQ();
            nVar2.isDynamic = fVar.cVP();
            nVar2.kyl = fVar.kwO;
            this.kXg.setData(fVar);
            this.fwe.add(nVar2);
            Iterator<PostData> it2 = fVar.cVo().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dwK() == 1) {
                    z = z2;
                } else {
                    this.fwe.add(next2);
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                l lVar = new l();
                lVar.kxY = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.kxX = R.drawable.new_pic_emotion_03;
                lVar.fEo = com.baidu.adp.lib.util.l.getDimens(this.kXf.getContext(), R.dimen.tbds730);
                lVar.kxZ = com.baidu.adp.lib.util.l.getDimens(this.kXf.getContext(), R.dimen.tbds74);
                lVar.kya = com.baidu.adp.lib.util.l.getDimens(this.kXf.getContext(), R.dimen.tbds74);
                this.fwe.add(lVar);
            }
            this.kAc.setData(fVar);
            this.kAc.setFromCDN(this.mIsFromCDN);
            this.kAc.gM(this.aYY);
            this.kAc.sF(this.kAo);
            this.kAc.A(this.aRW);
            this.kAc.S(this.kAx);
            this.kAc.setOnImageClickListener(this.fcC);
            this.kAc.setOnLongClickListener(this.mOnLongClickListener);
            this.kAc.setTbGestureDetector(this.eFj);
            this.kXg.A(this.aRW);
            this.kXg.a(this.kAy);
            this.kAj.setOnClickListener(this.aRW);
            cXd();
            if (this.kAf != null && (this.kAf instanceof com.baidu.tieba.recapp.m)) {
                ((com.baidu.tieba.recapp.m) this.kAf).setIsFromCDN(this.mIsFromCDN);
            }
            if (fVar.getPage().bdu() == 0) {
                if (z2) {
                    this.kXh.setOnClickListener(this.kXf.cYi().ddT());
                    j jVar = new j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.fwe.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> cVT = fVar.cVT();
                int i3 = -1;
                if (cVT == null || cVT.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = cVT.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!y.isEmpty(fVar.cVO())) {
                    e eVar = new e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.kXe);
                    this.fwe.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.n nVar5 : fVar.cVO()) {
                        if (cVT != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.fwe.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.dVX) {
                                    i++;
                                }
                            }
                            if (i2 < cVT.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = cVT.get(i2);
                                nVar4 = nVar6;
                                i4 = nVar6.getPosition();
                            }
                        }
                        this.fwe.add(nVar5);
                        i++;
                        if (i == 4 && fVar.cVs() != null) {
                            this.fwe.add(fVar.cVs());
                            i++;
                        }
                    }
                }
            }
            if (this.hYW != null) {
                this.hYW.setData(this.fwe);
            }
            deH();
        }
    }

    private void cXd() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.kAn != null && !this.kAn.kxE && this.kAn.XX != 2) {
            ArrayList<PostData> cVo = this.kAn.cVo();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> cVD = this.kAn.cVD();
            if (cVD != null && !cVD.isEmpty() && cVo != null && !cVo.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = cVD.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = cVD.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.inv = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = cVD.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dwy() != null) {
                        int bcv = next3.dwy().bcv();
                        if (bcv != 0) {
                            a(next3, bcv);
                            if (bcv != 28 && bcv != 31) {
                                if (next3.dwy().goods != null) {
                                    next3.dwy().goods.goods_style = -1001;
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
                    if (this.kAn.getForum() != null) {
                        nVar4.forumId = this.kAn.getForum().getId();
                    }
                    if (this.kAn.cVm() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.kAn.cVm().getId(), 0L);
                    }
                    if (this.kAn != null && this.kAn.getPage() != null) {
                        nVar4.pageNumber = this.kAn.getPage().bds();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.kAn.kxD;
                    if (position + i3 >= cVo.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.kWs) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (d(cVo, position)) {
                        a(nVar4, 1);
                    } else {
                        cVo.add(position, nVar4);
                        TiebaStatic.eventStat(this.kXf.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dwy().apk_name);
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
        com.baidu.tieba.recapp.report.d.dol().a(c);
        if (nVar != null && nVar.dwy() != null) {
            nVar.dwy().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dwy() != null && nVar.dwy().goods != null && nVar.dwy().goods.goods_style != 1001 && nVar.dwy().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kAn != null && nVar.dwy() != null) {
            nVar.dwy().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kAn.getPage() != null) {
                nVar.dwy().advertAppContext.pn = this.kAn.getPage().bds();
            }
            nVar.dwy().advertAppContext.page = nVar.dwB();
            if (this.kAn.getForum() != null && (forum = this.kAn.getForum()) != null) {
                nVar.dwy().advertAppContext.fid = forum.getId();
                nVar.dwy().advertAppContext.dVO = forum.getFirst_class();
                nVar.dwy().advertAppContext.dVP = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dwy().advertAppContext.dVQ = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dwy().advertAppContext.extensionInfo = nVar.dwy().ext_info;
            nVar.dwy().advertAppContext.Ye = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.kAx = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fcC = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.eFj = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.aRW = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.hYW.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.hYW.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.fwe;
    }

    public void ug(boolean z) {
        this.kWs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ed(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.kXf.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.kXf.cYj(), true, i)));
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
                return com.baidu.tieba.pb.pb.main.d.a.a(b.this.kXf.getContext(), b.this.cXD(), i2, b.this.kXf.cWE());
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.kXf.getContext(), i, shareItem, false));
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
    public int cXD() {
        if (this.kAn == null || this.kAn.cVm() == null) {
            return -1;
        }
        return this.kAn.cVm().bfr();
    }

    private void deH() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.fwe.size(); i++) {
            q qVar = this.fwe.get(i);
            if (qVar instanceof n) {
                this.kXj = i;
                z2 = true;
            } else if ((qVar instanceof e) && ((e) qVar).getTag() == this.kXe) {
                this.kXk = i;
                z = true;
            }
        }
        if (!z2) {
            this.kXj = -1;
        }
        if (!z) {
            this.kXk = -1;
        }
    }

    public int deI() {
        return this.kXj;
    }

    public int deJ() {
        return this.kXk;
    }

    public boolean cYc() {
        if (this.kXf.cWE() != null) {
            return this.kXf.cWE().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.kAy = aVar;
    }
}
