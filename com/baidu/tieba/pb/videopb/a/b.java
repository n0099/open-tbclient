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
    private ArrayList<q> ghy;
    private BdTypeRecyclerView iYW;
    private com.baidu.adp.widget.ListView.a jTX;
    private SortSwitchButton.a lEG;
    private com.baidu.tieba.pb.pb.main.adapter.d lEg;
    private m lEk;
    private com.baidu.adp.widget.ListView.a lEn;
    private an lEq;
    private j lEr;
    private f lEv;
    private e mbJ;
    private com.baidu.tieba.pb.pb.main.adapter.c mbK;
    private c mbL;
    private h mbM;
    private ab mbN;
    private DetailInfoAndReplyFragment mbR;
    private at mbS;
    private ae mbT;
    private k mbU;
    private d mbV;
    private final BdUniqueId mbQ = BdUniqueId.gen();
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private boolean mbe = true;
    private String bkt = null;
    private boolean lEw = true;
    private boolean mIsFromCDN = false;
    private int mbW = -1;
    private int mbX = -1;
    private View.OnClickListener lEF = null;
    private View.OnClickListener bbH = null;
    private TbRichTextView.i fNk = null;
    private com.baidu.tieba.pb.a.c fos = null;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener mbO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.b.1
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
        this.mbR = detailInfoAndReplyFragment;
        this.iYW = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.mbJ = new e(this.mbR.dpQ(), PostData.nlI);
        this.mbK = new com.baidu.tieba.pb.pb.main.adapter.c(this.mbR.dpQ(), o.lCj);
        this.mbK.setOnClickListener(this.mbO);
        this.mbL = new c(this.mbR.getContext(), s.TYPE);
        this.lEg = new com.baidu.tieba.pb.pb.main.adapter.d(this.mbR.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.mbS = new at(this.mbR.dpQ(), n.lCc);
        this.mbT = new ae(this.mbR.dpQ(), com.baidu.tieba.pb.data.j.lBL, this.mbR.getUniqueId());
        this.lEq = new an(this.mbR.dpQ(), l.Yt);
        this.mbU = new k(this.mbR.dpQ(), com.baidu.tieba.pb.data.e.lAE);
        this.mbM = new h(this.mbR.dpQ(), com.baidu.tbadk.core.data.o.eFe);
        this.mbM.uI(true);
        this.mbN = new ab(this.mbR.dpQ());
        this.lEk = new m(this.mbR.dpQ(), PostData.nlJ);
        this.lEk.a((TbRichTextView.c) this.mbR.dpQ());
        this.lEr = new j(this.mbR.dpQ(), PostData.nlN);
        this.jTX = r.dFg().a(this.mbR.dpQ().getBaseFragmentActivity(), AdvertAppInfo.eDR);
        this.lEn = r.dFg().a(this.mbR.dpQ().getBaseFragmentActivity(), AdvertAppInfo.eDV);
        this.mbV = new d(this.mbR.getPageContext(), by.eJj, this.mbR.getUniqueId());
        this.mbV.a(this.iYW);
        this.bnf.add(this.mbJ);
        this.bnf.add(this.mbK);
        this.bnf.add(this.mbL);
        this.bnf.add(this.lEg);
        this.bnf.add(this.mbS);
        this.bnf.add(this.lEq);
        this.bnf.add(this.mbT);
        this.bnf.add(this.mbU);
        this.bnf.add(this.mbM);
        this.bnf.add(this.mbN);
        this.bnf.add(this.jTX);
        this.bnf.add(this.lEn);
        this.bnf.add(this.lEk);
        this.bnf.add(this.lEr);
        this.bnf.add(this.mbV);
        this.iYW.addAdapters(this.bnf);
    }

    public void setData(f fVar) {
        a(fVar, false);
    }

    public void a(f fVar, boolean z) {
        PostData postData;
        by dmU;
        com.baidu.tieba.tbadkCore.data.n nVar;
        boolean z2;
        int i = 1;
        int i2 = 0;
        if (fVar != null) {
            this.lEv = fVar;
            if (fVar != null && fVar.dmU() != null && fVar.dmU().boP() != null) {
                this.bkt = fVar.dmU().boP().getUserId();
            }
            if (this.ghy == null) {
                this.ghy = new ArrayList<>();
            }
            this.ghy.clear();
            Iterator<PostData> it = fVar.dmW().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if ((next instanceof PostData) && next.dPh() == 1) {
                    postData = next;
                    break;
                }
            }
            if (postData == null && fVar.dnd() != null) {
                postData = fVar.dnd();
            }
            if (postData != null) {
                this.ghy.add(postData);
            }
            this.mbJ.setPbData(fVar);
            this.mbJ.hY(this.bkt);
            if (!y.isEmpty(fVar.dmW()) && fVar.dmW().get(0) != null && fVar.dmU() != null) {
                fVar.dmU().a(fVar.dmW().get(0).bqV());
                fVar.dmU().br(fVar.dmW().get(0).bqW());
            }
            if (fVar.dmU() != null && fVar.dmU().bqS() != null) {
                bx bxVar = new bx();
                bxVar.eCR = fVar.dmU();
                bxVar.eIK = true;
                this.ghy.add(bxVar);
            }
            o oVar = new o(fVar.dmU(), fVar.getAnti());
            oVar.ux(false);
            oVar.lCl = false;
            this.ghy.add(oVar);
            if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.mbR.dol().doe()) || !this.mbR.dol().dqn())) {
                com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
                hVar.tid = this.mbR.dol().dqk();
                hVar.lBI = false;
                this.ghy.add(hVar);
                oVar.ux(false);
                oVar.lCl = false;
            }
            n nVar2 = new n(n.lCc);
            nVar2.lCe = fVar.dmU() != null ? dmU.boG() : 0L;
            nVar2.isNew = !this.mbR.dol().dqm();
            nVar2.lCh = dpK();
            nVar2.sortType = fVar.lAM;
            nVar2.lCg = fVar.dnz();
            nVar2.isDynamic = fVar.dny();
            nVar2.lCi = fVar.lAL;
            this.mbS.setData(fVar);
            this.ghy.add(nVar2);
            doK();
            if (this.lEn != null && (this.lEn instanceof com.baidu.tieba.recapp.o)) {
                ((com.baidu.tieba.recapp.o) this.lEn).setIsFromCDN(this.mIsFromCDN);
            }
            Iterator<PostData> it2 = fVar.dmW().iterator();
            boolean z3 = false;
            while (it2.hasNext()) {
                PostData next2 = it2.next();
                if (!(next2 instanceof PostData) || next2.dPh() == 1) {
                    z2 = z3;
                } else {
                    this.ghy.add(next2);
                    z2 = true;
                }
                z3 = z2;
            }
            if (!z3 && (!z || !com.baidu.adp.lib.util.j.isNetWorkAvailable())) {
                l lVar = new l();
                lVar.lBV = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
                lVar.lBU = R.drawable.new_pic_emotion_03;
                lVar.grv = -2;
                lVar.lBW = com.baidu.adp.lib.util.l.getDimens(this.mbR.getContext(), R.dimen.tbds74);
                this.ghy.add(lVar);
            }
            this.lEk.setData(fVar);
            this.lEk.setFromCDN(this.mIsFromCDN);
            this.lEk.hY(this.bkt);
            this.lEk.uy(this.lEw);
            this.lEk.B(this.bbH);
            this.lEk.S(this.lEF);
            this.lEk.setOnImageClickListener(this.fNk);
            this.lEk.setOnLongClickListener(this.mOnLongClickListener);
            this.lEk.setTbGestureDetector(this.fos);
            this.mbS.B(this.bbH);
            this.mbS.a(this.lEG);
            this.lEr.setOnClickListener(this.bbH);
            if (fVar.getPage().bnF() == 0) {
                if (z3) {
                    this.mbT.setOnClickListener(this.mbR.dpQ().dvK());
                    com.baidu.tieba.pb.data.j jVar = new com.baidu.tieba.pb.data.j();
                    jVar.showText = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                    this.ghy.add(jVar);
                }
                List<com.baidu.tieba.tbadkCore.data.n> dnC = fVar.dnC();
                int i3 = -1;
                if (dnC == null || dnC.isEmpty()) {
                    nVar = null;
                } else {
                    com.baidu.tieba.tbadkCore.data.n nVar3 = dnC.get(0);
                    nVar = nVar3;
                    i3 = nVar3.getPosition();
                }
                if (!y.isEmpty(fVar.dnx())) {
                    com.baidu.tieba.pb.data.e eVar = new com.baidu.tieba.pb.data.e();
                    eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                    eVar.setTag(this.mbQ);
                    this.ghy.add(eVar);
                    com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
                    int i4 = i3;
                    for (com.baidu.tbadk.core.data.o oVar2 : fVar.dnx()) {
                        if (dnC != null && i == i4) {
                            if (nVar4 != null) {
                                c(nVar4);
                                this.ghy.add(nVar4);
                                i2++;
                                if (nVar4.getType() != AdvertAppInfo.eDR) {
                                    i++;
                                }
                            }
                            if (i2 < dnC.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar5 = dnC.get(i2);
                                nVar4 = nVar5;
                                i4 = nVar5.getPosition();
                            }
                        }
                        this.ghy.add(oVar2);
                        i++;
                        if (i == 4 && fVar.dna() != null) {
                            this.ghy.add(fVar.dna());
                            i++;
                        }
                    }
                }
            }
            if (this.iYW != null) {
                this.iYW.setData(this.ghy);
            }
            dwy();
        }
    }

    private void doK() {
        com.baidu.tieba.tbadkCore.data.n nVar;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        if (this.lEv != null && !this.lEv.lBA && this.lEv.ZJ != 2) {
            ArrayList<PostData> dmW = this.lEv.dmW();
            ArrayList<com.baidu.tieba.tbadkCore.data.n> dnl = this.lEv.dnl();
            if (dnl != null && !dnl.isEmpty() && dmW != null && !dmW.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it = dnl.iterator();
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
                Iterator<com.baidu.tieba.tbadkCore.data.n> it2 = dnl.iterator();
                while (it2.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next2 = it2.next();
                    if (next2 != null) {
                        next2.jqp = sb.toString();
                    }
                }
                SparseArray sparseArray = new SparseArray();
                Iterator<com.baidu.tieba.tbadkCore.data.n> it3 = dnl.iterator();
                while (it3.hasNext()) {
                    com.baidu.tieba.tbadkCore.data.n next3 = it3.next();
                    if (next3.dOV() != null) {
                        int bmD = next3.dOV().bmD();
                        if (bmD != 0) {
                            a(next3, bmD);
                            if (bmD != 28 && bmD != 31) {
                                if (next3.dOV().goods != null) {
                                    next3.dOV().goods.goods_style = -1001;
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
                    if (this.lEv.getForum() != null) {
                        nVar4.forumId = this.lEv.getForum().getId();
                    }
                    if (this.lEv.dmU() != null) {
                        nVar4.threadId = com.baidu.adp.lib.f.b.toLong(this.lEv.dmU().getId(), 0L);
                    }
                    if (this.lEv != null && this.lEv.getPage() != null) {
                        nVar4.pageNumber = this.lEv.getPage().bnD();
                    }
                    c(nVar4);
                    int position = nVar4.getPosition() + this.lEv.lBz;
                    if (position + i3 >= dmW.size()) {
                        a(nVar4, 2);
                        return;
                    }
                    if (!this.mbe) {
                        position--;
                    }
                    if (position < 0) {
                        a(nVar4, 23);
                    } else if (e(dmW, position)) {
                        a(nVar4, 1);
                    } else {
                        dmW.add(position, nVar4);
                        TiebaStatic.eventStat(this.mbR.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", nVar4.dOV().apk_name);
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
        com.baidu.tieba.recapp.report.d.dGg().a(c);
        if (nVar != null && nVar.dOV() != null) {
            nVar.dOV().mDiscardReason = i;
        }
    }

    private void b(com.baidu.tieba.tbadkCore.data.n nVar, int i) {
        if (nVar != null && nVar.dOV() != null && nVar.dOV().goods != null && nVar.dOV().goods.goods_style != 1001 && nVar.dOV().goods.goods_style != -1001) {
            a(nVar, i);
        }
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.lEv != null && nVar.dOV() != null) {
            nVar.dOV().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lEv.getPage() != null) {
                nVar.dOV().advertAppContext.pn = this.lEv.getPage().bnD();
            }
            nVar.dOV().advertAppContext.page = nVar.dOY();
            if (this.lEv.getForum() != null && (forum = this.lEv.getForum()) != null) {
                nVar.dOV().advertAppContext.fid = forum.getId();
                nVar.dOV().advertAppContext.eDI = forum.getFirst_class();
                nVar.dOV().advertAppContext.eDJ = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dOV().advertAppContext.eDK = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dOV().advertAppContext.extensionInfo = nVar.dOV().ext_info;
            nVar.dOV().advertAppContext.ZP = false;
        }
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void S(View.OnClickListener onClickListener) {
        this.lEF = onClickListener;
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
        if (this.iYW.getAdapter() instanceof com.baidu.adp.widget.ListView.h) {
            this.iYW.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.a
    public ArrayList<q> getDataList() {
        return this.ghy;
    }

    public void wb(boolean z) {
        this.mbe = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean He(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.mbR.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.mbR.dpR(), true, i)));
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
                return com.baidu.tieba.pb.pb.main.d.b.a(b.this.mbR.getContext(), b.this.dpl(), i2, b.this.mbR.dol());
            }
        }, new com.baidu.tbadk.util.m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(b.this.mbR.getContext(), i, shareItem, false));
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
    public int dpl() {
        if (this.lEv == null || this.lEv.dmU() == null) {
            return -1;
        }
        return this.lEv.dmU().bpC();
    }

    private void dwy() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.ghy.size(); i++) {
            q qVar = this.ghy.get(i);
            if (qVar instanceof n) {
                this.mbW = i;
                z2 = true;
            } else if ((qVar instanceof com.baidu.tieba.pb.data.e) && ((com.baidu.tieba.pb.data.e) qVar).getTag() == this.mbQ) {
                this.mbX = i;
                z = true;
            }
        }
        if (!z2) {
            this.mbW = -1;
        }
        if (!z) {
            this.mbX = -1;
        }
    }

    public int dwz() {
        return this.mbW;
    }

    public int dwA() {
        return this.mbX;
    }

    public boolean dpK() {
        if (this.mbR.dol() != null) {
            return this.mbR.dol().getHostMode();
        }
        return false;
    }

    public void setOnSwitchChangeListener(SortSwitchButton.a aVar) {
        this.lEG = aVar;
    }
}
