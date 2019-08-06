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
    private BaseFragmentActivity dlh;
    private CustomMessageListener eXB;
    private BaseFragment iqC;
    private PersonPolymericModel iqF;
    private g iqJ;
    private e iri;
    private p irj;
    private com.baidu.tieba.personPolymeric.event.c irk;
    private f irl;
    private d irm;
    private PersonPostModel irn;
    private CustomMessageListener iro;
    private CustomMessageListener irp;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean dpP = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a irq = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!aq.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).cbq() != null && i.this.irj != null) {
                ArrayList<m> cbq = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).cbq();
                Iterator<m> it = cbq.iterator();
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
                    i.this.irj.dR(PersonPostModel.mergeDynamicThreadByTime(cbq));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i irr = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bYZ();
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
        this.dlh = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.iri = eVar;
        this.XE = bdUniqueId;
        this.mView = eVar.mRootView;
        this.irn = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.irj = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.irj.Q(this.mView);
        this.irk = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.irk.a(this.iri);
        this.irj.setOnViewResponseListener(this.irk);
        this.irj.a(this);
        resetData();
        this.irj.a(this.irr);
        this.iqJ = this.iri.ccZ();
        this.irj.V(this.iqJ);
        this.iqF = this.iri.cda();
        this.iqF.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.irm = this.iri.cdd();
        this.irl = new f(baseFragmentActivity.getPageContext(), this.iri.cdc(), this.iri.cdb(), this.irj.aLj(), bdUniqueId);
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
                    if (!eVar.cbp() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.irj.brW();
                                i.this.irm.iO(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.iqF != null && this.iqF.cdA() != null && this.iqF.cdA().cdt()) {
                        this.irj.brW();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.irj.aA(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.irj.brW();
                                i.this.irm.iO(true);
                            }
                        }, 800L);
                    } else {
                        this.irm.pN(z2);
                        this.irn.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.irj.brW();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(R.string.data_load_error));
                                }
                                if (z4) {
                                    i.this.irj.aA(null);
                                    i.this.irm.aKm();
                                }
                            }
                        });
                        this.irn.fetchPost(this.dlh.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int Z;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.irj.brW();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> cbq = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).cbq();
                                        if (v.aa(cbq)) {
                                            i.this.irm.aKm();
                                            return;
                                        } else if (i.this.az(personPostModel.postList)) {
                                            eVar2.pA(false);
                                            i.this.irj.aA(cbq);
                                            i.this.irm.b(true, cbq);
                                            return;
                                        } else if (i.dS(personPostModel.postList) == 0) {
                                            eVar2.pA(false);
                                            i.this.irj.aA(cbq);
                                            i.this.irm.b(true, cbq);
                                            return;
                                        } else {
                                            cbq.addAll(personPostModel.postList);
                                            i.this.irm.akG();
                                            eVar2.ay(cbq);
                                            i.this.irj.aA(cbq);
                                            return;
                                        }
                                    }
                                    eVar2.pA(true);
                                    eVar2.ay(personPostModel.postList);
                                    i.this.irj.aA(personPostModel.postList);
                                    if (eVar2.cbq() != null && (Z = v.Z(eVar2.cbq())) > 0 && Z <= 2) {
                                        for (int i = 0; i < Z; i++) {
                                            if (eVar2.cbq().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.cbq().get(i)).isHost = i.this.mIsHost;
                                                i.this.irm.aKm();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> cbq2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).cbq();
                                if (!v.aa(cbq2)) {
                                    if (i.this.az(personPostModel.postList)) {
                                        eVar.pA(false);
                                        i.this.irj.aA(cbq2);
                                        i.this.irm.b(true, cbq2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    cbq2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(cbq2);
                                    eVar.pA(true);
                                    eVar.ay(mergeDynamicThreadByTime);
                                    i.this.irm.akG();
                                    i.this.irj.dR(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.irm.akF();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.irm.aKm();
                this.irj.aA(arrayList2);
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

    public static int dS(List<m> list) {
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
        if (this.iri != null) {
            this.iri.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.iri != null) {
            this.iri.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.irn.resetThreadPn();
        if (this.iqF != null) {
            this.iqF.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.irj.brW();
        this.dlh.hideLoadingView(this.mView);
        if (aVar == null) {
            this.irm.an(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.irm.aKm();
            this.irm.yQ(8);
        } else if (aVar.bli() != null && ((aVar.bli().getHide_stat() == 1 && aVar.bli().getBlock_stat() == 1) || (aVar.bli().getHide_stat() == 1 && aVar.bli().getBlock_stat() == 2))) {
            this.irm.pM(this.mIsHost);
            this.irm.yQ(8);
            this.irm.aJj();
        } else {
            this.irm.aJj();
            aVar.cdr();
            if (aVar.byX() != null) {
                z = aVar.byX().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.dpP = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.atq().a(aVar.getUserData());
            }
            if (this.iqJ != null) {
                this.iqJ.a(aVar);
            }
            if (this.irl != null) {
                this.irl.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ay(aVar.byX());
            eVar.pA(z);
            this.irm.yQ(0);
            this.irj.a(aVar, z);
            cdp();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f ccS() {
        return this.irl;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.irj != null) {
                this.irj.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.iqC = baseFragment;
    }

    public void cdp() {
        if (!this.dpP) {
            if ((this.iqC == null || this.iqC.isPrimary()) && this.irj != null && (this.irj.cdH() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.irj.cdH()).cdp();
            }
        }
    }

    public void bYZ() {
        if (this.irj != null && (this.irj.cdH() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.irj.cdH()).bYZ();
        }
    }

    public void cdq() {
        if (this.irj != null && this.irj.aLj() != null && (this.irj.cdH() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.irj.cdH()).a(this.dlh, this.irj.aLj());
            if (this.irk != null) {
                this.irj.setOnViewResponseListener(this.irk);
            }
            this.irj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!aq.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).cbq() != null && this.irj != null) {
            ArrayList<m> cbq = this.mList.get(0).cbq();
            for (int i = 0; i < cbq.size() && cbq.get(i) != null; i++) {
                m mVar = cbq.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && aq.bV(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.irj.a(i, str, this.irq);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.XE);
        this.iqJ.onDestroy();
        if (this.irj != null) {
            this.irj.onDestory();
        }
        bYZ();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void jS(boolean z) {
        if (z) {
            if (this.dpP) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                cdp();
                return;
            } else {
                bYZ();
                return;
            }
        }
        bYZ();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            cdp();
            cdq();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.dlh.finish();
                return;
            }
            return;
        }
        bYZ();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void CP(String str) {
        if (this.irj != null) {
            this.irj.CP(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void CQ(String str) {
        if (this.irj != null) {
            this.irj.CQ(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ccT() {
        if (this.irj != null) {
            this.irj.ccT();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void pL(boolean z) {
        this.irj.pL(z);
    }

    private void initListener() {
        this.eXB = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bYZ();
            }
        };
        this.eXB.setTag(this.XE);
        MessageManager.getInstance().registerListener(this.eXB);
        this.iro = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.iro.setTag(this.XE);
        MessageManager.getInstance().registerListener(this.iro);
        this.irp = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), (int) R.string.person_polymeric_set_privacy_success);
                }
            }
        };
        this.irp.setTag(this.XE);
        MessageManager.getInstance().registerListener(this.irp);
    }
}
