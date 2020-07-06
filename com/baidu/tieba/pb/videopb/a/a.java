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
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.g;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.adapter.d;
import com.baidu.tieba.pb.pb.main.h;
import com.baidu.tieba.pb.pb.main.z;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView hEN;
    private com.baidu.adp.widget.ListView.a iun;
    private d kbV;
    private e kcE;
    private com.baidu.adp.widget.ListView.a kcc;
    private DetailInfoFragment kyk;
    private List<q> kyl;
    private c kym;
    private com.baidu.tieba.pb.pb.main.adapter.c kyn;
    private b kyo;
    private h kyp;
    private z kyq;
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private View.OnClickListener kyr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.thread_info_commont_container) {
                if (a.this.Bk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                    a.this.Bm(8);
                }
            } else if (view.getId() == R.id.share_num_container && a.this.Bk(RequestResponseCode.REQUEST_LOGIN_PB_MARK)) {
                a.this.Bm(3);
            }
        }
    };

    public a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kyk = detailInfoFragment;
        this.hEN = bdTypeRecyclerView;
        a(detailInfoFragment, bdTypeRecyclerView);
    }

    private void a(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.kym = new c(detailInfoFragment.cJI(), PostData.lFL);
        this.kyn = new com.baidu.tieba.pb.pb.main.adapter.c(detailInfoFragment.cJI(), m.kaf);
        this.kyn.setOnClickListener(this.kyr);
        this.kyo = new b(detailInfoFragment.getContext(), com.baidu.tieba.pb.data.q.TYPE);
        this.kbV = new d(detailInfoFragment.getContext(), g.TYPE);
        this.kyp = new h(detailInfoFragment.cJI(), n.dHL);
        this.kyp.rB(true);
        this.kyq = new z(detailInfoFragment.cJI());
        this.aUP.add(this.kym);
        this.aUP.add(this.kyn);
        this.aUP.add(this.kyo);
        this.aUP.add(this.kbV);
        this.aUP.add(this.kyp);
        this.aUP.add(this.kyq);
        a(detailInfoFragment);
        bdTypeRecyclerView.addAdapters(this.aUP);
    }

    private void a(DetailInfoFragment detailInfoFragment) {
        this.iun = com.baidu.tieba.recapp.q.cYT().a(detailInfoFragment.cJI().getBaseFragmentActivity(), AdvertAppInfo.dGz);
        this.kcc = com.baidu.tieba.recapp.q.cYT().a(detailInfoFragment.cJI().getBaseFragmentActivity(), AdvertAppInfo.dGD);
        this.aUP.add(this.iun);
        this.aUP.add(this.kcc);
    }

    public void setData(e eVar) {
        if (eVar != null) {
            this.kcE = eVar;
            if (this.hEN != null) {
                this.hEN.setVisibility(0);
            }
            this.kym.setPbData(eVar);
            this.kyp.setPbData(eVar);
            this.kyq.setPbData(eVar);
            this.hEN.setData(M(eVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<q> M(e eVar) {
        PostData postData;
        com.baidu.tieba.tbadkCore.data.n nVar;
        int i;
        int i2;
        com.baidu.tieba.tbadkCore.data.n nVar2;
        int i3;
        int i4;
        int i5;
        if (eVar == null) {
            return null;
        }
        this.kyl = new ArrayList();
        Iterator<PostData> it = eVar.cGQ().iterator();
        while (true) {
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if ((next instanceof PostData) && next.dhZ() == 1) {
                postData = next;
                break;
            }
        }
        if (postData == null && eVar.cGX() != null) {
            postData = eVar.cGX();
        }
        if (postData != null) {
            this.kyl.add(postData);
        }
        m mVar = new m(eVar.cGO(), eVar.getAnti());
        mVar.rq(true);
        mVar.kah = true;
        this.kyl.add(mVar);
        if (eVar.getForum() != null && !StringUtils.isNull(eVar.getForum().getName()) && (!TextUtils.equals(eVar.getForum().getName(), this.kyk.cIf().cHW()) || !this.kyk.cIf().cKd())) {
            if (com.baidu.tbadk.a.d.aNU()) {
                g gVar = new g(eVar.getForum());
                gVar.tid = this.kyk.cIf().cKa();
                gVar.jZI = true;
                this.kyl.add(gVar);
            } else {
                com.baidu.tieba.pb.data.q qVar = new com.baidu.tieba.pb.data.q();
                bu buVar = new bu();
                buVar.tid = eVar.getThreadId();
                buVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForumId(), 0L));
                bq bqVar = new bq();
                bqVar.avatar = eVar.getForum().getImage_url();
                bqVar.forumName = eVar.getForum().getName();
                bqVar.memberNum = eVar.getForum().getMember_num();
                bqVar.postNum = eVar.getForum().getPost_num();
                bqVar.forumId = eVar.getForumId();
                buVar.a(bqVar);
                qVar.dLi = buVar;
                this.kyl.add(qVar);
            }
            mVar.rq(false);
            mVar.kah = false;
        }
        List<com.baidu.tieba.tbadkCore.data.n> cHu = eVar.cHu();
        int i6 = -1;
        if (cHu == null || cHu.isEmpty()) {
            nVar = null;
        } else {
            com.baidu.tieba.tbadkCore.data.n nVar3 = cHu.get(0);
            nVar = nVar3;
            i6 = nVar3.getPosition();
        }
        if (eVar.cHp() != null) {
            int i7 = i6;
            int i8 = 0;
            com.baidu.tieba.tbadkCore.data.n nVar4 = nVar;
            int i9 = 1;
            for (n nVar5 : eVar.cHp()) {
                if (cHu == null || i9 != i7) {
                    int i10 = i9;
                    i = i7;
                    i2 = i8;
                    nVar2 = nVar4;
                    i3 = i10;
                } else {
                    if (nVar4 != null) {
                        c(nVar4);
                        this.kyl.add(nVar4);
                        i8++;
                        if (nVar4.getType() != AdvertAppInfo.dGz) {
                            i4 = i8;
                            i5 = i9 + 1;
                            if (i4 >= cHu.size()) {
                                com.baidu.tieba.tbadkCore.data.n nVar6 = cHu.get(i4);
                                i3 = i5;
                                nVar2 = nVar6;
                                i = nVar6.getPosition();
                                i2 = i4;
                            } else {
                                i = i7;
                                i2 = i4;
                                int i11 = i5;
                                nVar2 = nVar4;
                                i3 = i11;
                            }
                        }
                    }
                    i4 = i8;
                    i5 = i9;
                    if (i4 >= cHu.size()) {
                    }
                }
                this.kyl.add(nVar5);
                int i12 = i3 + 1;
                if (i12 == 4 && eVar.cGU() != null) {
                    this.kyl.add(eVar.cGU());
                    i12++;
                }
                nVar4 = nVar2;
                i8 = i2;
                i7 = i;
                i9 = i12;
            }
        }
        return this.kyl;
    }

    private void c(com.baidu.tieba.tbadkCore.data.n nVar) {
        ForumData forum;
        if (nVar != null && this.kcE != null && nVar.dhN() != null) {
            nVar.dhN().advertAppContext = new com.baidu.tbadk.core.data.b();
            if (this.kcE.getPage() != null) {
                nVar.dhN().advertAppContext.pn = this.kcE.getPage().aRd();
            }
            nVar.dhN().advertAppContext.page = nVar.dhQ();
            if (this.kcE.getForum() != null && (forum = this.kcE.getForum()) != null) {
                nVar.dhN().advertAppContext.fid = forum.getId();
                nVar.dhN().advertAppContext.dGq = forum.getFirst_class();
                nVar.dhN().advertAppContext.dGr = forum.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                nVar.dhN().advertAppContext.dGs = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            nVar.dhN().advertAppContext.extensionInfo = nVar.dhN().ext_info;
            nVar.dhN().advertAppContext.XE = false;
        }
    }

    public void notifyDataSetChanged() {
        if (this.hEN != null && this.hEN.getAdapter() != null) {
            this.hEN.getListAdapter().notifyDataSetChanged();
        }
    }

    public void cPZ() {
        if (this.kym != null) {
            this.kym.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Bk(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.kyk.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(this.kyk.cJJ(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm(final int i) {
        ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: aPv */
            public ShareItem doInBackground() {
                int i2 = 6;
                if (ShareSwitch.isOn()) {
                    i2 = 1;
                }
                return com.baidu.tieba.pb.pb.main.d.a.a(a.this.kyk.getContext(), a.this.cJe(), i2, a.this.kyk.cIf());
            }
        }, new l<ShareItem>() { // from class: com.baidu.tieba.pb.videopb.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: b */
            public void onReturnDataInUI(ShareItem shareItem) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a.this.kyk.getContext(), i, shareItem, false));
            }
        });
        ao aoVar = new ao("c13833");
        aoVar.ag("obj_locate", 1);
        if (i == 3) {
            aoVar.ag("obj_type", 1);
        } else if (i == 8) {
            aoVar.ag("obj_type", 2);
        }
        TiebaStatic.log(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cJe() {
        if (this.kcE == null || this.kcE.cGO() == null) {
            return -1;
        }
        return this.kcE.cGO().aTc();
    }
}
