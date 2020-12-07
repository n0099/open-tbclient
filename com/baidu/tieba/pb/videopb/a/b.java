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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.data.s;
import com.baidu.tieba.pb.pb.a.j;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.pb.videopb.fragment.a {
    private ArrayList<q> ghw;
    private BdTypeRecyclerView iYU;
    private com.baidu.adp.widget.ListView.a jTV;
    private SortSwitchButton.a lEE;
    private com.baidu.tieba.pb.pb.main.adapter.d lEe;
    private m lEi;
    private com.baidu.adp.widget.ListView.a lEl;
    private an lEo;
    private j lEp;
    private f lEt;
    private e mbH;
    private com.baidu.tieba.pb.pb.main.adapter.c mbI;
    private c mbJ;
    private h mbK;
    private ab mbL;
    private DetailInfoAndReplyFragment mbP;
    private at mbQ;
    private ae mbR;
    private k mbS;
    private d mbT;
    private final BdUniqueId mbO = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private boolean mbc = true;
    private String bkt = null;
    private boolean lEu = true;
    private boolean mIsFromCDN = false;
    private int mbU = -1;
    private int mbV = -1;
    private View.OnClickListener lED = null;
    private View.OnClickListener bbH = null;
    private TbRichTextView.i fNk = null;
    private com.baidu.tieba.pb.a.c fos = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener mbM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (b.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    b.this.Hg(8);
                }
            } else if (view.getId() == R.id.share_num_container && b.this.He(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                b.this.Hg(3);
            }
        }
    };

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mbP = detailInfoAndReplyFragment;
        this.iYU = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.mbH = new e(this.mbP.dpP(), PostData.nlG);
        this.mbI = new com.baidu.tieba.pb.pb.main.adapter.c(this.mbP.dpP(), o.lCh);
        this.mbI.setOnClickListener(this.mbM);
        this.mbJ = new c(this.mbP.getContext(), s.TYPE);
        this.lEe = new com.baidu.tieba.pb.pb.main.adapter.d(this.mbP.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mbQ = new at(this.mbP.dpP(), n.lCa);
        this.mbR = new ae(this.mbP.dpP(), com.baidu.tieba.pb.data.j.lBJ, this.mbP.getUniqueId());
        this.lEo = new an(this.mbP.dpP(), l.Yt);
        this.mbS = new k(this.mbP.dpP(), com.baidu.tieba.pb.data.e.lAC);
        this.mbK = new h(this.mbP.dpP(), com.baidu.tbadk.core.data.o.eFe);
        this.mbK.uI(true);
        this.mbL = new ab(this.mbP.dpP());
        this.lEi = new m(this.mbP.dpP(), PostData.nlH);
        this.lEi.a((TbRichTextView.c) this.mbP.dpP());
        this.lEp = new j(this.mbP.dpP(), PostData.nlL);
        this.jTV = r.dFf().a(this.mbP.dpP().getBaseFragmentActivity(), AdvertAppInfo.eDR);
        this.lEl = r.dFf().a(this.mbP.dpP().getBaseFragmentActivity(), AdvertAppInfo.eDV);
        this.mbT = new d(this.mbP.getPageContext(), by.eJj, this.mbP.getUniqueId());
        this.mbT.a(this.iYU);
        this.bnf.add(this.mbH);
        this.bnf.add(this.mbI);
        this.bnf.add(this.mbJ);
        this.bnf.add(this.lEe);
        this.bnf.add(this.mbQ);
        this.bnf.add(this.lEo);
        this.bnf.add(this.mbR);
        this.bnf.add(this.mbS);
        this.bnf.add(this.mbK);
        this.bnf.add(this.mbL);
        this.bnf.add(this.jTV);
        this.bnf.add(this.lEl);
        this.bnf.add(this.lEi);
        this.bnf.add(this.lEp);
        this.bnf.add(this.mbT);
        this.iYU.addAdapters(this.bnf);
    }

    public void setData(f fVar) {
        a(fVar, false);
    }

    public void a(f fVar, boolean z) {
        PostData postData;
        by dmT;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z2;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.lEt = fVar;
            if (fVar != null && fVar.dmT() != null && fVar.dmT().boP() != null) {
                this.bkt = fVar.dmT().boP().getUserId();
            }
            if (this.ghw == null) {
                this.ghw = new ArrayList<>();
            }
            this.ghw.clear();
            Iterator<PostData> it = fVar.dmV().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dPg() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.dnc() != null) {
                postData = fVar.dnc();
            }
            if (postData != null) {
                this.ghw.add(postData);
            }
            this.mbH.setPbData(fVar);
            this.mbH.hY(this.bkt);
            if (!y.isEmpty(fVar.dmV()) && fVar.dmV().get(0) != null && fVar.dmT() != null) {
                fVar.dmT().a(fVar.dmV().get(0).bqV());
                fVar.dmT().br(fVar.dmV().get(0).bqW());
            }
            if (fVar.dmT() != null && fVar.dmT().bqS() != null) {
                bx bxVar = new bx();
                bxVar.eCR = fVar.dmT();
                bxVar.eIK = true;
                this.ghw.add(bxVar);
            }
            o oVar = new o(fVar.dmT(), fVar.getAnti());
            oVar.ux(false);
            oVar.lCj = false;
            this.ghw.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mbP.dok().dod()) || !this.mbP.dok().dqm())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.mbP.dok().dqj();
                hVar.lBG = false;
                this.ghw.add(hVar);
                oVar.ux(false);
                oVar.lCj = false;
            }
            n nVar2 = new n(n.lCa);
            nVar2.lCc = fVar.dmT() != null ? dmT.boG() : 0L;
            nVar2.isNew = !this.mbP.dok().dql();
            nVar2.lCf = dpJ();
            nVar2.sortType = fVar.lAK;
            nVar2.lCe = fVar.dny();
            nVar2.isDynamic = fVar.dnx();
            nVar2.lCg = fVar.lAJ;
            this.mbQ.setData(fVar);
            this.ghw.add(nVar2);
            doJ();
            if (this.lEl != null && (this.lEl instanceof com.baidu.tieba.recapp.o)) {
                ((com.baidu.tieba.recapp.o) this.lEl).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dmV().iterator();
            boolean z3 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dPg() == 1) {
                    z2 = z3;
                } else {
                    this.ghw.add(next2);
                    z2 = true;
                }
                z3 = z2;
            }
            if (!z3 && (!z || !com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                l lVar = new l();
                lVar.lBT = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.lBS = R.drawable.new_pic_emotion_03;
                lVar.grt = -2;
                lVar.lBU = com.baidu.adp.lib.util.l.getDimens(this.mbP.getContext(), R.dimen.tbds74);
                this.ghw.add(lVar);
            }
            this.lEi.setData(fVar);
            this.lEi.setFromCDN(this.mIsFromCDN);
            this.lEi.hY(this.bkt);
            this.lEi.uy(this.lEu);
            this.lEi.B(this.bbH);
            this.lEi.S(this.lED);
            this.lEi.setOnImageClickListener(this.fNk);
            this.lEi.setOnLongClickListener(this.mOnLongClickListener);
            this.lEi.setTbGestureDetector(this.fos);
            this.mbQ.B(this.bbH);
            this.mbQ.a(this.lEE);
            this.lEp.setOnClickListener(this.bbH);
            if (fVar.getPage().bnF() == 0) {
                if (z3) {
                    this.mbR.setOnClickListener(this.mbP.dpP().dvJ());
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.ghw.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> dnB = fVar.dnB();
                int i3 = -1;
                if (dnB == null || dnB.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = dnB.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!y.isEmpty(fVar.dnw())) {
                    com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.mbO);
                    this.ghw.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.o oVar2 : fVar.dnw()) {
                        if (dnB != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.ghw.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.eDR) {
                                    i++;
                                }
                            }
                            if (i2 < dnB.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar5 = dnB.get(i2);
                                nVar4 = nVar5;
                                i4 = nVar5.getPosition();
                            }
                        }
                        this.ghw.add(oVar2);
                        i++;
                        if (i == 4 && fVar.dmZ() != null) {
                            this.ghw.add(fVar.dmZ());
                            i++;
                        }
                    }
                }
            }
            if (this.iYU != null) {
                this.iYU.setData(this.ghw);
            }
            dwx();
        }
    }

    private void doJ() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lEt != null && !this.lEt.lBy && this.lEt.ZJ != 2) {
            ArrayList<PostData> dmV = this.lEt.dmV();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dnk = this.lEt.dnk();
            if (dnk != null && !dnk.isEmpty() && dmV != null && !dmV.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dnk.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next = it.next();
                    if (next != null && next.getAdId() != null) {
                        sb.append(next.getAdId());
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dnk.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.jqn = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dnk.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dOU() != null) {
                        int bmD = next3.dOU().bmD();
                        if (bmD != 0) {
                            a(next3, bmD);
                            if (bmD != 28 && bmD != 31) {
                                if (next3.dOU().goods != null) {
                                    next3.dOU().goods.goods_style = -1001;
                                }
                                Log.e("cq", "updateAppData，Data InValidate: " + bmD);
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
                    if (this.lEt.getForum() != null) {
                        nVar4.forumId = this.lEt.getForum().getId();
                    }
                    if (this.lEt.dmT() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lEt.dmT().getId(), 0L);
                    }
                    if (this.lEt != null && this.lEt.getPage() != null) {
                        nVar4.pageNumber = this.lEt.getPage().bnD();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lEt.lBx;
                    if (position + i3 >= dmV.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.mbc) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dmV, position)) {
                        a(nVar4, 1);
                    } else {
                        dmV.add(position, nVar4);
                        TiebaStatic.eventStat(this.mbP.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dOU().apk_name);
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
        c.Js(i);
        com.baidu.tieba.recapp.report.d.dGf().a(c);
        if (nVar != null && nVar.dOU() != null) {
            nVar.dOU().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dOU() != null && nVar.dOU().goods != null && nVar.dOU().goods.goods_style != 1001 && nVar.dOU().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lEt != null && nVar.dOU() != null) {
            nVar.dOU().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lEt.getPage() != null) {
                nVar.dOU().advertAppContext.pn = this.lEt.getPage().bnD();
            }
            nVar.dOU().advertAppContext.page = nVar.dOX();
            if (this.lEt.getForum() != null && (forum = this.lEt.getForum()) != null) {
                nVar.dOU().advertAppContext.fid = forum.getId();
                nVar.dOU().advertAppContext.eDI = forum.getFirst_class();
                nVar.dOU().advertAppContext.eDJ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dOU().advertAppContext.eDK = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dOU().advertAppContext.extensionInfo = nVar.dOU().ext_info;
            nVar.dOU().advertAppContext.ZP = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lED = onClickListener;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.fNk = iVar;
    }

    public void setTbGestureDetector(com.baidu.tieba.pb.a.c cVar) {
        this.fos = cVar;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void F(View.OnClickListener onClickListener) {
        this.bbH = onClickListener;
    }

    public void notifyDataSetChanged() {
        if (this.iYU.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.iYU.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.ghw;
    }

    public void wb(boolean z) {
        this.mbc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean He(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mbP.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mbP.dpQ(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg(final int i) {
        ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: blQ */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.b.a(b.this.mbP.getContext(), b.this.dpk(), i2, b.this.mbP.dok());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mbP.getContext(), i, shareItem, false));
            }
        });
        ar arVar = new ar("c13833");
        arVar.al("obj_locate", 1);
        if (i == 3) {
            arVar.al("obj_type", 1);
        } else if (i == 8) {
            arVar.al("obj_type", 2);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dpk() {
        if (this.lEt == null || this.lEt.dmT() == null) {
            return -1;
        }
        return this.lEt.dmT().bpC();
    }

    private void dwx() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.ghw.size(); i++) {
            q qVar = this.ghw.get(i);
            if (qVar instanceof n) {
                this.mbU = i;
                z2 = true;
            } else if ((qVar instanceof com.baidu.tieba.pb.data.e) && ((com.baidu.tieba.pb.data.e) qVar).getTag() == this.mbO) {
                this.mbV = i;
                z = true;
            }
        }
        if (!z2) {
            this.mbU = -1;
        }
        if (!z) {
            this.mbV = -1;
        }
    }

    public int dwy() {
        return this.mbU;
    }

    public int dwz() {
        return this.mbV;
    }

    public boolean dpJ() {
        if (this.mbP.dok() != null) {
            return this.mbP.dok().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lEE = aVar;
    }
}
