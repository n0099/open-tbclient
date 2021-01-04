package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.data.s;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.ag;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.j;
import com.baidu.tieba.pb.pb.main.k;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<n> grW;
    private BdTypeRecyclerView jlj;
    private com.baidu.adp.widget.ListView.a khi;
    private ag lJD;
    private PbReplyLoadMoreAdapter lJE;
    private f lJI;
    private SortSwitchButton.a lJT;
    private PbFirstFloorEnterForumAdapter lJr;
    private k lJv;
    private com.baidu.adp.widget.ListView.a lJy;
    private e mgV;
    private PbFirstFloorCommentAndPraiseAdapter mgW;
    private c mgX;
    private h mgY;
    private w mgZ;
    private DetailInfoAndReplyFragment mhd;
    private ak mhe;
    private y mhf;
    private j mhg;
    private d mhh;
    private final BdUniqueId mhc = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private boolean mgq = true;
    private String blY = null;
    private boolean lJJ = true;
    private boolean mIsFromCDN = false;
    private int mhi = -1;
    private int mhj = -1;
    private View.OnClickListener lJS = null;
    private View.OnClickListener bdp = null;
    private TbRichTextView.i fWO = null;
    private com.baidu.tieba.pb.a.c fyb = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener mha = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.GZ(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.GX(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.GZ(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mhd = detailInfoAndReplyFragment;
        this.jlj = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.mgV = new e(this.mhd.dpC(), PostData.nru);
        this.mgW = new PbFirstFloorCommentAndPraiseAdapter(this.mhd.dpC(), o.lHp);
        this.mgW.setOnClickListener(this.mha);
        this.mgX = new c(this.mhd.getContext(), s.TYPE);
        this.lJr = new PbFirstFloorEnterForumAdapter(this.mhd.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mhe = new ak(this.mhd.dpC(), com.baidu.tieba.pb.data.n.lHi);
        this.mhf = new y(this.mhd.dpC(), com.baidu.tieba.pb.data.j.lGR, this.mhd.getUniqueId());
        this.lJD = new ag(this.mhd.dpC(), l.Yr);
        this.mhg = new j(this.mhd.dpC(), com.baidu.tieba.pb.data.e.lFK);
        this.mgY = new h(this.mhd.dpC(), com.baidu.tbadk.core.data.o.eOU);
        this.mgY.uJ(true);
        this.mgZ = new w(this.mhd.dpC());
        this.lJv = new k(this.mhd.dpC(), PostData.nrv);
        this.lJv.a((TbRichTextView.c) this.mhd.dpC());
        this.lJE = new PbReplyLoadMoreAdapter(this.mhd.dpC(), PostData.nrz);
        this.khi = r.dEV().a(this.mhd.dpC().getBaseFragmentActivity(), AdvertAppInfo.eNE);
        this.lJy = r.dEV().a(this.mhd.dpC().getBaseFragmentActivity(), AdvertAppInfo.eNI);
        this.mhh = new d(this.mhd.getPageContext(), bz.eTc, this.mhd.getUniqueId());
        this.mhh.a(this.jlj);
        this.boM.add(this.mgV);
        this.boM.add(this.mgW);
        this.boM.add(this.mgX);
        this.boM.add(this.lJr);
        this.boM.add(this.mhe);
        this.boM.add(this.lJD);
        this.boM.add(this.mhf);
        this.boM.add(this.mhg);
        this.boM.add(this.mgY);
        this.boM.add(this.mgZ);
        this.boM.add(this.khi);
        this.boM.add(this.lJy);
        this.boM.add(this.lJv);
        this.boM.add(this.lJE);
        this.boM.add(this.mhh);
        this.jlj.addAdapters(this.boM);
    }

    public void setData(f fVar) {
        a(fVar, false);
    }

    public void a(f fVar, boolean z) {
        PostData postData;
        bz dmE;
        int i;
        com.baidu.tieba.tbadkCore.data.o oVar;
        int i2;
        int i3;
        boolean z2;
        int i4 = 1;
        if (fVar != null) {
            this.lJI = fVar;
            if (fVar != null && fVar.dmE() != null && fVar.dmE().brq() != null) {
                this.blY = fVar.dmE().brq().getUserId();
            }
            if (this.grW == null) {
                this.grW = new ArrayList<>();
            }
            this.grW.clear();
            Iterator<PostData> it = fVar.dmG().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dPd() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.dmN() != null) {
                postData = fVar.dmN();
            }
            if (postData != null) {
                this.grW.add(postData);
            }
            this.mgV.setPbData(fVar);
            this.mgV.hJ(this.blY);
            if (!x.isEmpty(fVar.dmG()) && fVar.dmG().get(0) != null && fVar.dmE() != null) {
                fVar.dmE().a(fVar.dmG().get(0).btx());
                fVar.dmE().by(fVar.dmG().get(0).bty());
            }
            if (fVar.dmE() != null && fVar.dmE().btu() != null) {
                by byVar = new by();
                byVar.eMv = fVar.dmE();
                byVar.eSD = true;
                this.grW.add(byVar);
            }
            o oVar2 = new o(fVar.dmE(), fVar.getAnti());
            oVar2.uy(false);
            oVar2.lHr = false;
            this.grW.add(oVar2);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mhd.dnV().dnO()) || !this.mhd.dnV().dpZ())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.mhd.dnV().dpW();
                hVar.lGO = false;
                this.grW.add(hVar);
                oVar2.uy(false);
                oVar2.lHr = false;
            }
            com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lHi);
            nVar.lHk = fVar.dmE() != null ? dmE.brh() : 0L;
            nVar.isNew = !this.mhd.dnV().dpY();
            nVar.lHn = dpw();
            nVar.sortType = fVar.lFS;
            nVar.lHm = fVar.dni();
            nVar.isDynamic = fVar.dnh();
            nVar.lHo = fVar.lFR;
            this.mhe.setData(fVar);
            this.grW.add(nVar);
            dow();
            if (this.lJy != null && (this.lJy instanceof com.baidu.tieba.recapp.o)) {
                ((com.baidu.tieba.recapp.o) this.lJy).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dmG().iterator();
            boolean z3 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dPd() == 1) {
                    z2 = z3;
                } else {
                    this.grW.add(next2);
                    z2 = true;
                }
                z3 = z2;
            }
            if (!z3 && (!z || !com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                l lVar = new l();
                lVar.lHb = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.lHa = R.drawable.new_pic_emotion_03;
                lVar.gCu = -2;
                lVar.lHc = com.baidu.adp.lib.util.l.getDimens(this.mhd.getContext(), R.dimen.tbds74);
                this.grW.add(lVar);
            }
            this.lJv.setData(fVar);
            this.lJv.setFromCDN(this.mIsFromCDN);
            this.lJv.hJ(this.blY);
            this.lJv.uz(this.lJJ);
            this.lJv.C(this.bdp);
            this.lJv.U(this.lJS);
            this.lJv.setOnImageClickListener(this.fWO);
            this.lJv.setOnLongClickListener(this.mOnLongClickListener);
            this.lJv.setTbGestureDetector(this.fyb);
            this.mhe.C(this.bdp);
            this.mhe.a(this.lJT);
            this.lJE.setOnClickListener(this.bdp);
            if (fVar.getPage().bqf() == 0) {
                if (z3) {
                    this.mhf.setOnClickListener(this.mhd.dpC().dvz());
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.grW.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.o> dnl = fVar.dnl();
                if (dnl == null || dnl.isEmpty()) {
                    i = -1;
                    oVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = dnl.get(0);
                    i = oVar3.getPosition();
                    oVar = oVar3;
                }
                if (!x.isEmpty(fVar.dng())) {
                    com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.mhc);
                    this.grW.add(eVar);
                    int i5 = 0;
                    com.baidu.tieba.tbadkCore.data.o oVar4 = oVar;
                    for (com.baidu.tbadk.core.data.o oVar5 : fVar.dng()) {
                        if (dnl != null && i4 == i) {
                            if (oVar4 != null) {
                                c(oVar4);
                                this.grW.add(oVar4);
                                i5++;
                                if (oVar4.getType() != AdvertAppInfo.eNE) {
                                    i4++;
                                }
                            }
                            if (i5 < dnl.size()) {
                                com.baidu.tieba.tbadkCore.data.o oVar6 = dnl.get(i5);
                                i2 = oVar6.getPosition();
                                i3 = i5;
                                oVar4 = oVar6;
                                this.grW.add(oVar5);
                                i4++;
                                if (i4 == 4 && fVar.dmK() != null) {
                                    this.grW.add(fVar.dmK());
                                    i4++;
                                }
                                i = i2;
                                i5 = i3;
                            }
                        }
                        i2 = i;
                        i3 = i5;
                        this.grW.add(oVar5);
                        i4++;
                        if (i4 == 4) {
                            this.grW.add(fVar.dmK());
                            i4++;
                        }
                        i = i2;
                        i5 = i3;
                    }
                }
            }
            if (this.jlj != null) {
                this.jlj.setData(this.grW);
            }
            dwn();
        }
    }

    private void dow() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lJI != null && !this.lJI.lGG && this.lJI.aas != 2) {
            ArrayList<PostData> dmG = this.lJI.dmG();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dmV = this.lJI.dmV();
            if (dmV != null && !dmV.isEmpty() && dmG != null && !dmG.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dmV.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dmV.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jCL = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dmV.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dOR() != null) {
                        int bpe = next3.dOR().bpe();
                        if (bpe != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, bpe);
                            if (bpe != 28 && bpe != 31) {
                                if (next3.dOR().goods != null) {
                                    next3.dOR().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bpe);
                            }
                        }
                        sparseArray.put(next3.getPosition(), next3);
                    }
                }
                HashMap hashMap = new HashMap();
                for (int i = 0; i < sparseArray.size(); i++) {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(sparseArray.keyAt(i));
                    if (oVar3 != null && (oVar2 = (com.baidu.tieba.tbadkCore.data.o) hashMap.put(oVar3.getAdId(), oVar3)) != null) {
                        com.baidu.tieba.recapp.report.d.a(oVar2, 30);
                    }
                }
                sparseArray.clear();
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (entry != null && (oVar = (com.baidu.tieba.tbadkCore.data.o) entry.getValue()) != null) {
                        sparseArray.put(oVar.getPosition(), oVar);
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
                }
                Collections.sort(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    com.baidu.tieba.tbadkCore.data.o oVar4 = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                    if (this.lJI.getForum() != null) {
                        oVar4.forumId = this.lJI.getForum().getId();
                    }
                    if (this.lJI.dmE() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lJI.dmE().getId(), 0L);
                    }
                    if (this.lJI != null && this.lJI.getPage() != null) {
                        oVar4.pageNumber = this.lJI.getPage().bqd();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lJI.lGF;
                    if (position + i3 >= dmG.size()) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, dmG.size());
                        return;
                    }
                    if (!this.mgq) {
                        position--;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dmG, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dmG.add(position, oVar4);
                        TiebaStatic.eventStat(this.mhd.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dOR().apk_name);
                    }
                }
            }
        }
    }

    private boolean g(ArrayList<PostData> arrayList, int i) {
        for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
            if (arrayList.get(max) instanceof com.baidu.tieba.tbadkCore.data.o) {
                return true;
            }
        }
        return false;
    }

    private void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        ForumData forum;
        if (oVar != null && this.lJI != null && oVar.dOR() != null) {
            oVar.dOR().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lJI.getPage() != null) {
                oVar.dOR().advertAppContext.pn = this.lJI.getPage().bqd();
            }
            oVar.dOR().advertAppContext.page = oVar.dOU();
            if (this.lJI.getForum() != null && (forum = this.lJI.getForum()) != null) {
                oVar.dOR().advertAppContext.fid = forum.getId();
                oVar.dOR().advertAppContext.eNv = forum.getFirst_class();
                oVar.dOR().advertAppContext.eNw = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dOR().advertAppContext.eNx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dOR().advertAppContext.extensionInfo = oVar.dOR().ext_info;
            oVar.dOR().advertAppContext.aay = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJS = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fWO = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fyb = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void H(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.jlj.getAdapter() instanceof BdRecyclerAdapter) {
            this.jlj.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<n> getDataList() {
        return this.grW;
    }

    public void wc(boolean z) {
        this.mgq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GX(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mhd.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mhd.dpD(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ(final int i) {
        ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bop */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(b.this.mhd.getContext(), b.this.doX(), i2, b.this.mhd.dnV());
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mhd.getContext(), i, shareItem, false));
            }
        });
        aq aqVar = new aq("c13833");
        aqVar.an("obj_locate", 1);
        if (i == 3) {
            aqVar.an("obj_type", 1);
        } else if (i == 8) {
            aqVar.an("obj_type", 2);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doX() {
        if (this.lJI == null || this.lJI.dmE() == null) {
            return -1;
        }
        return this.lJI.dmE().bsd();
    }

    private void dwn() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.grW.size(); i++) {
            n nVar = this.grW.get(i);
            if (nVar instanceof com.baidu.tieba.pb.data.n) {
                this.mhi = i;
                z2 = true;
            } else if ((nVar instanceof com.baidu.tieba.pb.data.e) && ((com.baidu.tieba.pb.data.e) nVar).getTag() == this.mhc) {
                this.mhj = i;
                z = true;
            }
        }
        if (!z2) {
            this.mhi = -1;
        }
        if (!z) {
            this.mhj = -1;
        }
    }

    public int dwo() {
        return this.mhi;
    }

    public int dwp() {
        return this.mhj;
    }

    public boolean dpw() {
        if (this.mhd.dnV() != null) {
            return this.mhd.dnV().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lJT = aVar;
    }

    public void onDestroy() {
        if (this.mhe != null) {
            this.mhe.onDestroy();
        }
        if (this.mgW != null) {
            this.mgW.onDestroy();
        }
    }
}
