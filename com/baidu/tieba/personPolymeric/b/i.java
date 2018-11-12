package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId ays;
    private BaseFragmentActivity bIb;
    private CustomMessageListener dia;
    private BaseFragment gpS;
    private PersonPolymericModel gpV;
    private g gpZ;
    private com.baidu.tieba.personPolymeric.event.c gqA;
    private f gqB;
    private d gqC;
    private PersonPostModel gqD;
    private CustomMessageListener gqE;
    private CustomMessageListener gqF;
    private e gqy;
    private p gqz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean bOc = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a gqG = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void tk(String str) {
            boolean z;
            if (!ao.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bmF() != null && i.this.gqz != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> bmF = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bmF();
                Iterator<com.baidu.adp.widget.ListView.h> it = bmF.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    i.this.gqz.dp(PersonPostModel.mergeDynamicThreadByTime(bmF));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i gqH = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bku();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void tk(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bIb = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.gqy = eVar;
        this.ays = bdUniqueId;
        this.mView = eVar.mRootView;
        this.gqD = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.gqz = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.gqz.initView(this.mView);
        this.gqA = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.gqA.a(this.gqy);
        this.gqz.setOnViewResponseListener(this.gqA);
        this.gqz.a(this);
        resetData();
        this.gqz.a(this.gqH);
        this.gpZ = this.gqy.bog();
        this.gqz.Q(this.gpZ);
        this.gpV = this.gqy.boh();
        this.gpV.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.gqC = this.gqy.bok();
        this.gqB = new f(baseFragmentActivity.getPageContext(), this.gqy.boj(), this.gqy.boi(), this.gqz.aaO(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void j(final boolean z, boolean z2, boolean z3) {
        if (j.kK()) {
            if (!v.I(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bmE() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gqz.aFc();
                                i.this.gqC.fC(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.gpV != null && this.gpV.boH() != null && this.gpV.boH().boA()) {
                        this.gqz.aFc();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.gqz.as(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gqz.aFc();
                                i.this.gqC.fC(true);
                            }
                        }, 800L);
                    } else {
                        this.gqC.mf(z2);
                        this.gqD.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.gqz.aFc();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(e.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.gqz.as(null);
                                    i.this.gqC.ZV();
                                }
                            }
                        });
                        this.gqD.fetchPost(this.bIb.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int H;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.gqz.aFc();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bmF = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bmF();
                                        if (v.I(bmF)) {
                                            i.this.gqC.ZV();
                                            return;
                                        } else if (i.this.ar(personPostModel.postList)) {
                                            eVar2.lS(false);
                                            i.this.gqz.as(bmF);
                                            i.this.gqC.c(true, bmF);
                                            return;
                                        } else if (i.dq(personPostModel.postList) == 0) {
                                            eVar2.lS(false);
                                            i.this.gqz.as(bmF);
                                            i.this.gqC.c(true, bmF);
                                            return;
                                        } else {
                                            bmF.addAll(personPostModel.postList);
                                            i.this.gqC.DZ();
                                            eVar2.aq(bmF);
                                            i.this.gqz.as(bmF);
                                            return;
                                        }
                                    }
                                    eVar2.lS(true);
                                    eVar2.aq(personPostModel.postList);
                                    i.this.gqz.as(personPostModel.postList);
                                    if (eVar2.bmF() != null && (H = v.H(eVar2.bmF())) > 0 && H <= 2) {
                                        for (int i = 0; i < H; i++) {
                                            if (eVar2.bmF().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bmF().get(i)).isHost = i.this.mIsHost;
                                                i.this.gqC.ZV();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bmF2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bmF();
                                if (!v.I(bmF2)) {
                                    if (i.this.ar(personPostModel.postList)) {
                                        eVar.lS(false);
                                        i.this.gqz.as(bmF2);
                                        i.this.gqC.c(true, bmF2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bmF2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bmF2);
                                    eVar.lS(true);
                                    eVar.aq(mergeDynamicThreadByTime);
                                    i.this.gqC.DZ();
                                    i.this.gqz.dp(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.gqC.DY();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.gqC.ZV();
                this.gqz.as(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ar(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int H = v.H(arrayList);
        if (H != 0) {
            if (H > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int dq(List<com.baidu.adp.widget.ListView.h> list) {
        int i = 0;
        if (v.H(list) == 0) {
            return 0;
        }
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) != null && (list.get(i2) instanceof PersonPostModel.PostInfoList)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((PersonPostModel.PostInfoList) list.get(i2));
            }
        }
        if (v.H(arrayList) == 0) {
            return 0;
        }
        int size2 = list.size();
        int i3 = 0;
        while (i3 < size2) {
            int length = ((PersonPostModel.PostInfoList) arrayList.get(i3)).content.length + i;
            i3++;
            i = length;
        }
        return i;
    }

    @Override // com.baidu.tieba.model.a
    public void refreshData() {
        if (this.gqy != null) {
            this.gqy.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.gqy != null) {
            this.gqy.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.gqD.resetThreadPn();
        if (this.gpV != null) {
            this.gpV.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.gqz.aFc();
        this.bIb.hideLoadingView(this.mView);
        if (aVar == null) {
            this.gqC.M(TbadkCoreApplication.getInst().getString(e.j.neterror), true);
            this.gqC.ZV();
            this.gqC.sL(8);
        } else if (aVar.ayn() != null && ((aVar.ayn().getHide_stat() == 1 && aVar.ayn().getBlock_stat() == 1) || (aVar.ayn().getHide_stat() == 1 && aVar.ayn().getBlock_stat() == 2))) {
            this.gqC.me(this.mIsHost);
            this.gqC.sL(8);
            this.gqC.ZS();
        } else {
            this.gqC.ZS();
            aVar.boy();
            if (aVar.aKS() != null) {
                z = aVar.aKS().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.bOc = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.Mh().a(aVar.getUserData());
            }
            if (this.gpZ != null) {
                this.gpZ.a(aVar);
            }
            if (this.gqB != null) {
                this.gqB.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.aq(aVar.aKS());
            eVar.lS(z);
            this.gqC.sL(0);
            this.gqz.a(aVar, z);
            bow();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f boa() {
        return this.gqB;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gqz != null) {
                this.gqz.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.gpS = baseFragment;
    }

    public void bow() {
        if (!this.bOc) {
            if ((this.gpS == null || this.gpS.isPrimary()) && this.gqz != null && (this.gqz.boO() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.gqz.boO()).bow();
            }
        }
    }

    public void bku() {
        if (this.gqz != null && (this.gqz.boO() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.gqz.boO()).bku();
        }
    }

    public void box() {
        if (this.gqz != null && this.gqz.aaO() != null && (this.gqz.boO() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.gqz.boO()).a(this.bIb, this.gqz.aaO());
            if (this.gqA != null) {
                this.gqz.setOnViewResponseListener(this.gqA);
            }
            this.gqz.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void tk(String str) {
        if (!ao.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bmF() != null && this.gqz != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bmF = this.mList.get(0).bmF();
            for (int i = 0; i < bmF.size() && bmF.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bmF.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.gqz.a(i, str, this.gqG);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ays);
        this.gpZ.onDestroy();
        if (this.gqz != null) {
            this.gqz.onDestory();
        }
        bku();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void gt(boolean z) {
        if (z) {
            if (this.bOc) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                bow();
                return;
            } else {
                bku();
                return;
            }
        }
        bku();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bow();
            box();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.bIb.finish();
                return;
            }
            return;
        }
        bku();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ti(String str) {
        if (this.gqz != null) {
            this.gqz.ti(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void tj(String str) {
        if (this.gqz != null) {
            this.gqz.tj(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bob() {
        if (this.gqz != null) {
            this.gqz.bob();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void md(boolean z) {
        this.gqz.md(z);
    }

    private void initListener() {
        this.dia = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bku();
            }
        };
        this.dia.setTag(this.ays);
        MessageManager.getInstance().registerListener(this.dia);
        this.gqE = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.tk((String) customResponsedMessage.getData());
                }
            }
        };
        this.gqE.setTag(this.ays);
        MessageManager.getInstance().registerListener(this.gqE);
        this.gqF = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.tk((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), e.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.gqF.setTag(this.ays);
        MessageManager.getInstance().registerListener(this.gqF);
    }
}
