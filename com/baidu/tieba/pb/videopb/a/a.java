package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.pb.data.s;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView iOd;
    private com.baidu.adp.widget.ListView.a jGs;
    private DetailInfoFragment lND;
    private List<q> lNE;
    private d lNF;
    private com.baidu.tieba.pb.pb.main.adapter.c lNG;
    private c lNH;
    private h lNI;
    private ab lNJ;
    private com.baidu.adp.widget.ListView.a lqC;
    private com.baidu.tieba.pb.pb.main.adapter.d lqv;
    private f lre;
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private View.OnClickListener lNK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.Go(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.Gq(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.Go(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.Gq(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lND = detailInfoFragment;
        this.iOd = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.lNF = new d(detailInfoFragment.dkA(), PostData.mXI);
        this.lNG = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.dkA(), o.loL);
        this.lNG.setOnClickListener(this.lNK);
        this.lNH = new c(detailInfoFragment.getContext(), s.TYPE);
        this.lqv = new com.baidu.tieba.pb.pb.main.adapter.d(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.h.TYPE);
        this.lNI = new h(detailInfoFragment.dkA(), com.baidu.tbadk.core.data.o.eyd);
        this.lNI.ug(true);
        this.lNJ = new ab(detailInfoFragment.dkA());
        this.biN.add(this.lNF);
        this.biN.add(this.lNG);
        this.biN.add(this.lNH);
        this.biN.add(this.lqv);
        this.biN.add(this.lNI);
        this.biN.add(this.lNJ);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.biN);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.jGs = com.baidu.tieba.recapp.q.dzO().a(detailInfoFragment.dkA().getBaseFragmentActivity(), AdvertAppInfo.ewQ);
        this.lqC = com.baidu.tieba.recapp.q.dzO().a(detailInfoFragment.dkA().getBaseFragmentActivity(), AdvertAppInfo.ewU);
        this.biN.add(this.jGs);
        this.biN.add(this.lqC);
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.lre = fVar;
            if (this.iOd != null) {
                this.iOd.setVisibility(0);
            }
            this.lNF.setPbData(fVar);
            this.lNI.setPbData(fVar);
            this.lNJ.setPbData(fVar);
            this.iOd.setData(O(fVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<q> O(f fVar) {
        PostData postData;
        int i;
        n nVar;
        int i2;
        int i3;
        n nVar2;
        int i4;
        int i5;
        int i6;
        if (fVar == null) {
            return null;
        }
        this.lNE = new ArrayList();
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
            this.lNE.add(postData);
        }
        o oVar = new o(fVar.dhH(), fVar.getAnti());
        oVar.tV(true);
        oVar.loN = true;
        this.lNE.add(oVar);
        if (fVar.getForum() != null && !StringUtils.isNull(fVar.getForum().getName()) && (!TextUtils.equals(fVar.getForum().getName(), this.lND.diV().diO()) || !this.lND.diV().dkX())) {
            com.baidu.tieba.pb.data.h hVar = new com.baidu.tieba.pb.data.h(fVar.getForum());
            hVar.tid = this.lND.diV().dkU();
            hVar.loi = true;
            this.lNE.add(hVar);
            oVar.tV(false);
            oVar.loN = false;
        }
        List<n> dio = fVar.dio();
        if (com.baidu.tieba.lego.card.d.a.isEmpty(dio)) {
            i = -1;
            nVar = null;
        } else {
            n nVar3 = (n) com.baidu.tieba.lego.card.d.a.l(dio, 0);
            if (nVar3 == null) {
                nVar = nVar3;
                i = -1;
            } else {
                nVar = nVar3;
                i = nVar3.getPosition();
            }
        }
        if (fVar.dij() != null) {
            int i7 = i;
            int i8 = 0;
            n nVar4 = nVar;
            int i9 = 1;
            for (com.baidu.tbadk.core.data.o oVar2 : fVar.dij()) {
                if (dio == null || i9 != i7) {
                    int i10 = i9;
                    i2 = i7;
                    i3 = i8;
                    nVar2 = nVar4;
                    i4 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        com.baidu.tieba.lego.card.d.a.a(this.lNE, nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.ewQ) {
                            i5 = i8;
                            i6 = i9 + 1;
                            if (i5 >= dio.size()) {
                                n nVar5 = (n) com.baidu.tieba.lego.card.d.a.l(dio, i5);
                                if (nVar5 != null) {
                                    i4 = i6;
                                    nVar2 = nVar5;
                                    i2 = nVar5.getPosition();
                                    i3 = i5;
                                } else {
                                    i4 = i6;
                                    nVar2 = nVar5;
                                    i2 = i7;
                                    i3 = i5;
                                }
                            } else {
                                i2 = i7;
                                i3 = i5;
                                int i11 = i6;
                                nVar2 = nVar4;
                                i4 = i11;
                            }
                        }
                    }
                    i5 = i8;
                    i6 = i9;
                    if (i5 >= dio.size()) {
                    }
                }
                com.baidu.tieba.lego.card.d.a.a(this.lNE, oVar2);
                int i12 = i4 + 1;
                if (i12 == 4 && fVar.dhN() != null) {
                    com.baidu.tieba.lego.card.d.a.a(this.lNE, fVar.dhN());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i3;
                i7 = i2;
                i9 = i12;
            }
        }
        return this.lNE;
    }

    private void c(n nVar) {
        ForumData forum;
        if (nVar != null && this.lre != null && nVar.dJE() != null) {
            nVar.dJE().advertAppContext = new com.baidu.tbadk.core.data.c();
            if (this.lre.getPage() != null) {
                nVar.dJE().advertAppContext.pn = this.lre.getPage().bkq();
            }
            nVar.dJE().advertAppContext.page = nVar.dJH();
            if (this.lre.getForum() != null && (forum = this.lre.getForum()) != null) {
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

    public void notifyDataSetChanged() {
        if (this.iOd != null && this.iOd.getAdapter() != null) {
            this.iOd.getListAdapter().notifyDataSetChanged();
        }
    }

    public void drd() {
        if (this.lNF != null) {
            this.lNF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Go(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.lND.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.lND.dkB(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(final int i) {
        ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: biG */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(a.this.lND.getContext(), a.this.djV(), i2, a.this.lND.diV());
            }
        }, new m<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.lND.getContext(), i, shareItem, false));
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
        if (this.lre == null || this.lre.dhH() == null) {
            return -1;
        }
        return this.lre.dhH().bmp();
    }
}
