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
import com.baidu.tbadk.core.util.ap;
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
    private BdUniqueId Xk;
    private BaseFragmentActivity djs;
    private CustomMessageListener eSr;
    private e ijL;
    private p ijM;
    private com.baidu.tieba.personPolymeric.event.c ijN;
    private f ijO;
    private d ijP;
    private PersonPostModel ijQ;
    private CustomMessageListener ijR;
    private CustomMessageListener ijS;
    private BaseFragment ijf;
    private PersonPolymericModel iji;
    private g ijm;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean dnK = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a ijT = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!ap.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bYi() != null && i.this.ijM != null) {
                ArrayList<m> bYi = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bYi();
                Iterator<m> it = bYi.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    m next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    i.this.ijM.dQ(PersonPostModel.mergeDynamicThreadByTime(bYi));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i ijU = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bVT();
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
        this.djs = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.ijL = eVar;
        this.Xk = bdUniqueId;
        this.mView = eVar.mRootView;
        this.ijQ = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.ijM = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.ijM.O(this.mView);
        this.ijN = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.ijN.a(this.ijL);
        this.ijM.setOnViewResponseListener(this.ijN);
        this.ijM.a(this);
        resetData();
        this.ijM.a(this.ijU);
        this.ijm = this.ijL.bZR();
        this.ijM.T(this.ijm);
        this.iji = this.ijL.bZS();
        this.iji.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.ijP = this.ijL.bZV();
        this.ijO = new f(baseFragmentActivity.getPageContext(), this.ijL.bZU(), this.ijL.bZT(), this.ijM.aJC(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void i(final boolean z, boolean z2, boolean z3) {
        if (j.jG()) {
            if (!v.aa(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bYh() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ijM.bpG();
                                i.this.ijP.iF(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.iji != null && this.iji.cas() != null && this.iji.cas().cal()) {
                        this.ijM.bpG();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.ijM.aA(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ijM.bpG();
                                i.this.ijP.iF(true);
                            }
                        }, 800L);
                    } else {
                        this.ijP.px(z2);
                        this.ijQ.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.ijM.bpG();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(R.string.data_load_error));
                                }
                                if (z4) {
                                    i.this.ijM.aA(null);
                                    i.this.ijP.aIJ();
                                }
                            }
                        });
                        this.ijQ.fetchPost(this.djs.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int Z;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.ijM.bpG();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> bYi = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bYi();
                                        if (v.aa(bYi)) {
                                            i.this.ijP.aIJ();
                                            return;
                                        } else if (i.this.az(personPostModel.postList)) {
                                            eVar2.pk(false);
                                            i.this.ijM.aA(bYi);
                                            i.this.ijP.c(true, bYi);
                                            return;
                                        } else if (i.dR(personPostModel.postList) == 0) {
                                            eVar2.pk(false);
                                            i.this.ijM.aA(bYi);
                                            i.this.ijP.c(true, bYi);
                                            return;
                                        } else {
                                            bYi.addAll(personPostModel.postList);
                                            i.this.ijP.ajz();
                                            eVar2.ay(bYi);
                                            i.this.ijM.aA(bYi);
                                            return;
                                        }
                                    }
                                    eVar2.pk(true);
                                    eVar2.ay(personPostModel.postList);
                                    i.this.ijM.aA(personPostModel.postList);
                                    if (eVar2.bYi() != null && (Z = v.Z(eVar2.bYi())) > 0 && Z <= 2) {
                                        for (int i = 0; i < Z; i++) {
                                            if (eVar2.bYi().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bYi().get(i)).isHost = i.this.mIsHost;
                                                i.this.ijP.aIJ();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> bYi2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bYi();
                                if (!v.aa(bYi2)) {
                                    if (i.this.az(personPostModel.postList)) {
                                        eVar.pk(false);
                                        i.this.ijM.aA(bYi2);
                                        i.this.ijP.c(true, bYi2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bYi2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bYi2);
                                    eVar.pk(true);
                                    eVar.ay(mergeDynamicThreadByTime);
                                    i.this.ijP.ajz();
                                    i.this.ijM.dQ(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.ijP.ajy();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.ijP.aIJ();
                this.ijM.aA(arrayList2);
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

    public static int dR(List<m> list) {
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
        if (this.ijL != null) {
            this.ijL.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.ijL != null) {
            this.ijL.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.ijQ.resetThreadPn();
        if (this.iji != null) {
            this.iji.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.ijM.bpG();
        this.djs.hideLoadingView(this.mView);
        if (aVar == null) {
            this.ijP.aj(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.ijP.aIJ();
            this.ijP.yj(8);
        } else if (aVar.biZ() != null && ((aVar.biZ().getHide_stat() == 1 && aVar.biZ().getBlock_stat() == 1) || (aVar.biZ().getHide_stat() == 1 && aVar.biZ().getBlock_stat() == 2))) {
            this.ijP.pw(this.mIsHost);
            this.ijP.yj(8);
            this.ijP.aHK();
        } else {
            this.ijP.aHK();
            aVar.caj();
            if (aVar.bwe() != null) {
                z = aVar.bwe().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.dnK = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.ash().a(aVar.getUserData());
            }
            if (this.ijm != null) {
                this.ijm.a(aVar);
            }
            if (this.ijO != null) {
                this.ijO.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ay(aVar.bwe());
            eVar.pk(z);
            this.ijP.yj(0);
            this.ijM.a(aVar, z);
            cah();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bZK() {
        return this.ijO;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ijM != null) {
                this.ijM.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.ijf = baseFragment;
    }

    public void cah() {
        if (!this.dnK) {
            if ((this.ijf == null || this.ijf.isPrimary()) && this.ijM != null && (this.ijM.caz() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.ijM.caz()).cah();
            }
        }
    }

    public void bVT() {
        if (this.ijM != null && (this.ijM.caz() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.ijM.caz()).bVT();
        }
    }

    public void cai() {
        if (this.ijM != null && this.ijM.aJC() != null && (this.ijM.caz() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.ijM.caz()).a(this.djs, this.ijM.aJC());
            if (this.ijN != null) {
                this.ijM.setOnViewResponseListener(this.ijN);
            }
            this.ijM.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!ap.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bYi() != null && this.ijM != null) {
            ArrayList<m> bYi = this.mList.get(0).bYi();
            for (int i = 0; i < bYi.size() && bYi.get(i) != null; i++) {
                m mVar = bYi.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.ijM.a(i, str, this.ijT);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Xk);
        this.ijm.onDestroy();
        if (this.ijM != null) {
            this.ijM.onDestory();
        }
        bVT();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void jI(boolean z) {
        if (z) {
            if (this.dnK) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                cah();
                return;
            } else {
                bVT();
                return;
            }
        }
        bVT();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            cah();
            cai();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.djs.finish();
                return;
            }
            return;
        }
        bVT();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void BZ(String str) {
        if (this.ijM != null) {
            this.ijM.BZ(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Ca(String str) {
        if (this.ijM != null) {
            this.ijM.Ca(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bZL() {
        if (this.ijM != null) {
            this.ijM.bZL();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void pv(boolean z) {
        this.ijM.pv(z);
    }

    private void initListener() {
        this.eSr = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bVT();
            }
        };
        this.eSr.setTag(this.Xk);
        MessageManager.getInstance().registerListener(this.eSr);
        this.ijR = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.ijR.setTag(this.Xk);
        MessageManager.getInstance().registerListener(this.ijR);
        this.ijS = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), (int) R.string.person_polymeric_set_privacy_success);
                }
            }
        };
        this.ijS.setTag(this.Xk);
        MessageManager.getInstance().registerListener(this.ijS);
    }
}
