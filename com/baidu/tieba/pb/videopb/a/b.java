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
    private ag lJC;
    private PbReplyLoadMoreAdapter lJD;
    private f lJH;
    private SortSwitchButton.a lJS;
    private PbFirstFloorEnterForumAdapter lJq;
    private k lJu;
    private com.baidu.adp.widget.ListView.a lJx;
    private e mgU;
    private PbFirstFloorCommentAndPraiseAdapter mgV;
    private c mgW;
    private h mgX;
    private w mgY;
    private DetailInfoAndReplyFragment mhc;
    private ak mhd;
    private y mhe;
    private j mhf;
    private d mhg;
    private final BdUniqueId mhb = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private boolean mgp = true;
    private String blY = null;
    private boolean lJI = true;
    private boolean mIsFromCDN = false;
    private int mhh = -1;
    private int mhi = -1;
    private View.OnClickListener lJR = null;
    private View.OnClickListener bdp = null;
    private TbRichTextView.i fWO = null;
    private com.baidu.tieba.pb.a.c fyb = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener mgZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
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
        this.mhc = detailInfoAndReplyFragment;
        this.jlj = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.mgU = new e(this.mhc.dpD(), PostData.nrt);
        this.mgV = new PbFirstFloorCommentAndPraiseAdapter(this.mhc.dpD(), o.lHo);
        this.mgV.setOnClickListener(this.mgZ);
        this.mgW = new c(this.mhc.getContext(), s.TYPE);
        this.lJq = new PbFirstFloorEnterForumAdapter(this.mhc.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mhd = new ak(this.mhc.dpD(), com.baidu.tieba.pb.data.n.lHh);
        this.mhe = new y(this.mhc.dpD(), com.baidu.tieba.pb.data.j.lGQ, this.mhc.getUniqueId());
        this.lJC = new ag(this.mhc.dpD(), l.Yr);
        this.mhf = new j(this.mhc.dpD(), com.baidu.tieba.pb.data.e.lFJ);
        this.mgX = new h(this.mhc.dpD(), com.baidu.tbadk.core.data.o.eOU);
        this.mgX.uJ(true);
        this.mgY = new w(this.mhc.dpD());
        this.lJu = new k(this.mhc.dpD(), PostData.nru);
        this.lJu.a((TbRichTextView.c) this.mhc.dpD());
        this.lJD = new PbReplyLoadMoreAdapter(this.mhc.dpD(), PostData.nry);
        this.khi = r.dEW().a(this.mhc.dpD().getBaseFragmentActivity(), AdvertAppInfo.eNE);
        this.lJx = r.dEW().a(this.mhc.dpD().getBaseFragmentActivity(), AdvertAppInfo.eNI);
        this.mhg = new d(this.mhc.getPageContext(), bz.eTc, this.mhc.getUniqueId());
        this.mhg.a(this.jlj);
        this.boM.add(this.mgU);
        this.boM.add(this.mgV);
        this.boM.add(this.mgW);
        this.boM.add(this.lJq);
        this.boM.add(this.mhd);
        this.boM.add(this.lJC);
        this.boM.add(this.mhe);
        this.boM.add(this.mhf);
        this.boM.add(this.mgX);
        this.boM.add(this.mgY);
        this.boM.add(this.khi);
        this.boM.add(this.lJx);
        this.boM.add(this.lJu);
        this.boM.add(this.lJD);
        this.boM.add(this.mhg);
        this.jlj.addAdapters(this.boM);
    }

    public void setData(f fVar) {
        a(fVar, false);
    }

    public void a(f fVar, boolean z) {
        PostData postData;
        bz dmF;
        int i;
        com.baidu.tieba.tbadkCore.data.o oVar;
        int i2;
        int i3;
        boolean z2;
        int i4 = 1;
        if (fVar != null) {
            this.lJH = fVar;
            if (fVar != null && fVar.dmF() != null && fVar.dmF().brr() != null) {
                this.blY = fVar.dmF().brr().getUserId();
            }
            if (this.grW == null) {
                this.grW = new ArrayList<>();
            }
            this.grW.clear();
            Iterator<PostData> it = fVar.dmH().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dPe() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.dmO() != null) {
                postData = fVar.dmO();
            }
            if (postData != null) {
                this.grW.add(postData);
            }
            this.mgU.setPbData(fVar);
            this.mgU.hJ(this.blY);
            if (!x.isEmpty(fVar.dmH()) && fVar.dmH().get(0) != null && fVar.dmF() != null) {
                fVar.dmF().a(fVar.dmH().get(0).bty());
                fVar.dmF().by(fVar.dmH().get(0).btz());
            }
            if (fVar.dmF() != null && fVar.dmF().btv() != null) {
                by byVar = new by();
                byVar.eMv = fVar.dmF();
                byVar.eSD = true;
                this.grW.add(byVar);
            }
            o oVar2 = new o(fVar.dmF(), fVar.getAnti());
            oVar2.uy(false);
            oVar2.lHq = false;
            this.grW.add(oVar2);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mhc.dnW().dnP()) || !this.mhc.dnW().dqa())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.mhc.dnW().dpX();
                hVar.lGN = false;
                this.grW.add(hVar);
                oVar2.uy(false);
                oVar2.lHq = false;
            }
            com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lHh);
            nVar.lHj = fVar.dmF() != null ? dmF.bri() : 0L;
            nVar.isNew = !this.mhc.dnW().dpZ();
            nVar.lHm = dpx();
            nVar.sortType = fVar.lFR;
            nVar.lHl = fVar.dnj();
            nVar.isDynamic = fVar.dni();
            nVar.lHn = fVar.lFQ;
            this.mhd.setData(fVar);
            this.grW.add(nVar);
            dox();
            if (this.lJx != null && (this.lJx instanceof com.baidu.tieba.recapp.o)) {
                ((com.baidu.tieba.recapp.o) this.lJx).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dmH().iterator();
            boolean z3 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dPe() == 1) {
                    z2 = z3;
                } else {
                    this.grW.add(next2);
                    z2 = true;
                }
                z3 = z2;
            }
            if (!z3 && (!z || !com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                l lVar = new l();
                lVar.lHa = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.lGZ = R.drawable.new_pic_emotion_03;
                lVar.gCu = -2;
                lVar.lHb = com.baidu.adp.lib.util.l.getDimens(this.mhc.getContext(), R.dimen.tbds74);
                this.grW.add(lVar);
            }
            this.lJu.setData(fVar);
            this.lJu.setFromCDN(this.mIsFromCDN);
            this.lJu.hJ(this.blY);
            this.lJu.uz(this.lJI);
            this.lJu.C(this.bdp);
            this.lJu.U(this.lJR);
            this.lJu.setOnImageClickListener(this.fWO);
            this.lJu.setOnLongClickListener(this.mOnLongClickListener);
            this.lJu.setTbGestureDetector(this.fyb);
            this.mhd.C(this.bdp);
            this.mhd.a(this.lJS);
            this.lJD.setOnClickListener(this.bdp);
            if (fVar.getPage().bqg() == 0) {
                if (z3) {
                    this.mhe.setOnClickListener(this.mhc.dpD().dvA());
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.grW.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.o> dnm = fVar.dnm();
                if (dnm == null || dnm.isEmpty()) {
                    i = -1;
                    oVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.o oVar3 = dnm.get(0);
                    i = oVar3.getPosition();
                    oVar = oVar3;
                }
                if (!x.isEmpty(fVar.dnh())) {
                    com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.mhb);
                    this.grW.add(eVar);
                    int i5 = 0;
                    com.baidu.tieba.tbadkCore.data.o oVar4 = oVar;
                    for (com.baidu.tbadk.core.data.o oVar5 : fVar.dnh()) {
                        if (dnm != null && i4 == i) {
                            if (oVar4 != null) {
                                c(oVar4);
                                this.grW.add(oVar4);
                                i5++;
                                if (oVar4.getType() != AdvertAppInfo.eNE) {
                                    i4++;
                                }
                            }
                            if (i5 < dnm.size()) {
                                com.baidu.tieba.tbadkCore.data.o oVar6 = dnm.get(i5);
                                i2 = oVar6.getPosition();
                                i3 = i5;
                                oVar4 = oVar6;
                                this.grW.add(oVar5);
                                i4++;
                                if (i4 == 4 && fVar.dmL() != null) {
                                    this.grW.add(fVar.dmL());
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
                            this.grW.add(fVar.dmL());
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
            dwo();
        }
    }

    private void dox() {
        com.baidu.tieba.tbadkCore.data.o oVar;
        com.baidu.tieba.tbadkCore.data.o oVar2;
        if (this.lJH != null && !this.lJH.lGF && this.lJH.aas != 2) {
            ArrayList<PostData> dmH = this.lJH.dmH();
            ArrayList<com.baidu.tieba.tbadkCore.data.o> dmW = this.lJH.dmW();
            if (dmW != null && !dmW.isEmpty() && dmH != null && !dmH.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it = dmW.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.o> it2 = dmW.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next2 = it2.next();
                    if (next2 != null) {
                        next2.jCL = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.o> it3 = dmW.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.o next3 = it3.next();
                    if (next3.dOS() != null) {
                        int bpf = next3.dOS().bpf();
                        if (bpf != 0) {
                            com.baidu.tieba.recapp.report.d.a(next3, bpf);
                            if (bpf != 28 && bpf != 31) {
                                if (next3.dOS().goods != null) {
                                    next3.dOS().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bpf);
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
                    if (this.lJH.getForum() != null) {
                        oVar4.forumId = this.lJH.getForum().getId();
                    }
                    if (this.lJH.dmF() != null) {
                        oVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lJH.dmF().getId(), 0L);
                    }
                    if (this.lJH != null && this.lJH.getPage() != null) {
                        oVar4.pageNumber = this.lJH.getPage().bqe();
                    }
                    c(oVar4);
                    int position = oVar4.getPosition() + this.lJH.lGE;
                    if (position + i3 >= dmH.size()) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 2, i3 + position, dmH.size());
                        return;
                    }
                    if (!this.mgp) {
                        position--;
                    }
                    if (position < 0) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 23);
                    } else if (g(dmH, position)) {
                        com.baidu.tieba.recapp.report.d.a(oVar4, 1);
                    } else {
                        dmH.add(position, oVar4);
                        TiebaStatic.eventStat(this.mhc.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.dOS().apk_name);
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
        if (oVar != null && this.lJH != null && oVar.dOS() != null) {
            oVar.dOS().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lJH.getPage() != null) {
                oVar.dOS().advertAppContext.pn = this.lJH.getPage().bqe();
            }
            oVar.dOS().advertAppContext.page = oVar.dOV();
            if (this.lJH.getForum() != null && (forum = this.lJH.getForum()) != null) {
                oVar.dOS().advertAppContext.fid = forum.getId();
                oVar.dOS().advertAppContext.eNv = forum.getFirst_class();
                oVar.dOS().advertAppContext.eNw = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                oVar.dOS().advertAppContext.eNx = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            oVar.dOS().advertAppContext.extensionInfo = oVar.dOS().ext_info;
            oVar.dOS().advertAppContext.aay = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void U(View.OnClickListener onClickListener) {
        this.lJR = onClickListener;
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
        this.mgp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GX(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mhc.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mhc.dpE(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ(final int i) {
        ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: boq */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(b.this.mhc.getContext(), b.this.doY(), i2, b.this.mhc.dnW());
            }
        }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mhc.getContext(), i, shareItem, false));
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
    public int doY() {
        if (this.lJH == null || this.lJH.dmF() == null) {
            return -1;
        }
        return this.lJH.dmF().bse();
    }

    private void dwo() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.grW.size(); i++) {
            n nVar = this.grW.get(i);
            if (nVar instanceof com.baidu.tieba.pb.data.n) {
                this.mhh = i;
                z2 = true;
            } else if ((nVar instanceof com.baidu.tieba.pb.data.e) && ((com.baidu.tieba.pb.data.e) nVar).getTag() == this.mhb) {
                this.mhi = i;
                z = true;
            }
        }
        if (!z2) {
            this.mhh = -1;
        }
        if (!z) {
            this.mhi = -1;
        }
    }

    public int dwp() {
        return this.mhh;
    }

    public int dwq() {
        return this.mhi;
    }

    public boolean dpx() {
        if (this.mhc.dnW() != null) {
            return this.mhc.dnW().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lJS = aVar;
    }

    public void onDestroy() {
        if (this.mhd != null) {
            this.mhd.onDestroy();
        }
        if (this.mgV != null) {
            this.mgV.onDestroy();
        }
    }
}
