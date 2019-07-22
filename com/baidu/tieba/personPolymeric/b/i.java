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
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class i implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId XE;
    private BaseFragmentActivity dla;
    private CustomMessageListener eXr;
    private PersonPolymericModel ipB;
    private g ipF;
    private BaseFragment ipy;
    private e iqe;
    private p iqf;
    private com.baidu.tieba.personPolymeric.event.c iqg;
    private f iqh;
    private d iqi;
    private PersonPostModel iqj;
    private CustomMessageListener iqk;
    private CustomMessageListener iql;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean dpI = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a iqm = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!aq.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).caY() != null && i.this.iqf != null) {
                ArrayList<m> caY = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).caY();
                Iterator<m> it = caY.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    m next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && aq.bV(str, ((CardPersonDynamicThreadData) next).threadId)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    i.this.iqf.dS(PersonPostModel.mergeDynamicThreadByTime(caY));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i iqn = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bYI();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void removeThread(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.dla = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.iqe = eVar;
        this.XE = bdUniqueId;
        this.mView = eVar.mRootView;
        this.iqj = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.iqf = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.iqf.Q(this.mView);
        this.iqg = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.iqg.a(this.iqe);
        this.iqf.setOnViewResponseListener(this.iqg);
        this.iqf.a(this);
        resetData();
        this.iqf.a(this.iqn);
        this.ipF = this.iqe.ccH();
        this.iqf.V(this.ipF);
        this.ipB = this.iqe.ccI();
        this.ipB.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.iqi = this.iqe.ccL();
        this.iqh = new f(baseFragmentActivity.getPageContext(), this.iqe.ccK(), this.iqe.ccJ(), this.iqf.aLh(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void i(final boolean z, boolean z2, boolean z3) {
        if (j.jQ()) {
            if (!v.aa(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.caX() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.iqf.brJ();
                                i.this.iqi.iO(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.ipB != null && this.ipB.cdi() != null && this.ipB.cdi().cdb()) {
                        this.iqf.brJ();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.iqf.aA(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.iqf.brJ();
                                i.this.iqi.iO(true);
                            }
                        }, 800L);
                    } else {
                        this.iqi.pM(z2);
                        this.iqj.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.iqf.brJ();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(R.string.data_load_error));
                                }
                                if (z4) {
                                    i.this.iqf.aA(null);
                                    i.this.iqi.aKk();
                                }
                            }
                        });
                        this.iqj.fetchPost(this.dla.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int Z;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.iqf.brJ();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> caY = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).caY();
                                        if (v.aa(caY)) {
                                            i.this.iqi.aKk();
                                            return;
                                        } else if (i.this.az(personPostModel.postList)) {
                                            eVar2.pz(false);
                                            i.this.iqf.aA(caY);
                                            i.this.iqi.b(true, caY);
                                            return;
                                        } else if (i.dT(personPostModel.postList) == 0) {
                                            eVar2.pz(false);
                                            i.this.iqf.aA(caY);
                                            i.this.iqi.b(true, caY);
                                            return;
                                        } else {
                                            caY.addAll(personPostModel.postList);
                                            i.this.iqi.akE();
                                            eVar2.ay(caY);
                                            i.this.iqf.aA(caY);
                                            return;
                                        }
                                    }
                                    eVar2.pz(true);
                                    eVar2.ay(personPostModel.postList);
                                    i.this.iqf.aA(personPostModel.postList);
                                    if (eVar2.caY() != null && (Z = v.Z(eVar2.caY())) > 0 && Z <= 2) {
                                        for (int i = 0; i < Z; i++) {
                                            if (eVar2.caY().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.caY().get(i)).isHost = i.this.mIsHost;
                                                i.this.iqi.aKk();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> caY2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).caY();
                                if (!v.aa(caY2)) {
                                    if (i.this.az(personPostModel.postList)) {
                                        eVar.pz(false);
                                        i.this.iqf.aA(caY2);
                                        i.this.iqi.b(true, caY2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    caY2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(caY2);
                                    eVar.pz(true);
                                    eVar.ay(mergeDynamicThreadByTime);
                                    i.this.iqi.akE();
                                    i.this.iqf.dS(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.iqi.akD();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.iqi.aKk();
                this.iqf.aA(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean az(ArrayList<m> arrayList) {
        int Z = v.Z(arrayList);
        if (Z != 0) {
            if (Z > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int dT(List<m> list) {
        int i = 0;
        if (v.Z(list) == 0) {
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
        if (v.Z(arrayList) == 0) {
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
        if (this.iqe != null) {
            this.iqe.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.iqe != null) {
            this.iqe.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.iqj.resetThreadPn();
        if (this.ipB != null) {
            this.ipB.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.iqf.brJ();
        this.dla.hideLoadingView(this.mView);
        if (aVar == null) {
            this.iqi.an(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.iqi.aKk();
            this.iqi.yO(8);
        } else if (aVar.blb() != null && ((aVar.blb().getHide_stat() == 1 && aVar.blb().getBlock_stat() == 1) || (aVar.blb().getHide_stat() == 1 && aVar.blb().getBlock_stat() == 2))) {
            this.iqi.pL(this.mIsHost);
            this.iqi.yO(8);
            this.iqi.aJh();
        } else {
            this.iqi.aJh();
            aVar.ccZ();
            if (aVar.byJ() != null) {
                z = aVar.byJ().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.dpI = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.ato().a(aVar.getUserData());
            }
            if (this.ipF != null) {
                this.ipF.a(aVar);
            }
            if (this.iqh != null) {
                this.iqh.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ay(aVar.byJ());
            eVar.pz(z);
            this.iqi.yO(0);
            this.iqf.a(aVar, z);
            ccX();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f ccA() {
        return this.iqh;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iqf != null) {
                this.iqf.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.ipy = baseFragment;
    }

    public void ccX() {
        if (!this.dpI) {
            if ((this.ipy == null || this.ipy.isPrimary()) && this.iqf != null && (this.iqf.cdp() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.iqf.cdp()).ccX();
            }
        }
    }

    public void bYI() {
        if (this.iqf != null && (this.iqf.cdp() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.iqf.cdp()).bYI();
        }
    }

    public void ccY() {
        if (this.iqf != null && this.iqf.aLh() != null && (this.iqf.cdp() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.iqf.cdp()).a(this.dla, this.iqf.aLh());
            if (this.iqg != null) {
                this.iqf.setOnViewResponseListener(this.iqg);
            }
            this.iqf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!aq.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).caY() != null && this.iqf != null) {
            ArrayList<m> caY = this.mList.get(0).caY();
            for (int i = 0; i < caY.size() && caY.get(i) != null; i++) {
                m mVar = caY.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && aq.bV(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.iqf.a(i, str, this.iqm);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.XE);
        this.ipF.onDestroy();
        if (this.iqf != null) {
            this.iqf.onDestory();
        }
        bYI();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void jS(boolean z) {
        if (z) {
            if (this.dpI) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                ccX();
                return;
            } else {
                bYI();
                return;
            }
        }
        bYI();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            ccX();
            ccY();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.dla.finish();
                return;
            }
            return;
        }
        bYI();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void CO(String str) {
        if (this.iqf != null) {
            this.iqf.CO(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void CP(String str) {
        if (this.iqf != null) {
            this.iqf.CP(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ccB() {
        if (this.iqf != null) {
            this.iqf.ccB();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void pK(boolean z) {
        this.iqf.pK(z);
    }

    private void initListener() {
        this.eXr = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bYI();
            }
        };
        this.eXr.setTag(this.XE);
        MessageManager.getInstance().registerListener(this.eXr);
        this.iqk = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.iqk.setTag(this.XE);
        MessageManager.getInstance().registerListener(this.iqk);
        this.iql = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), (int) R.string.person_polymeric_set_privacy_success);
                }
            }
        };
        this.iql.setTag(this.XE);
        MessageManager.getInstance().registerListener(this.iql);
    }
}
