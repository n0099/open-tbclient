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
    private BdUniqueId Xj;
    private BaseFragmentActivity djs;
    private CustomMessageListener eSr;
    private e ijM;
    private p ijN;
    private com.baidu.tieba.personPolymeric.event.c ijO;
    private f ijP;
    private d ijQ;
    private PersonPostModel ijR;
    private CustomMessageListener ijS;
    private CustomMessageListener ijT;
    private BaseFragment ijg;
    private PersonPolymericModel ijj;
    private g ijn;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean dnK = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a ijU = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!ap.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bYj() != null && i.this.ijN != null) {
                ArrayList<m> bYj = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bYj();
                Iterator<m> it = bYj.iterator();
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
                    i.this.ijN.dQ(PersonPostModel.mergeDynamicThreadByTime(bYj));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i ijV = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bVU();
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
        this.ijM = eVar;
        this.Xj = bdUniqueId;
        this.mView = eVar.mRootView;
        this.ijR = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.ijN = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.ijN.O(this.mView);
        this.ijO = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.ijO.a(this.ijM);
        this.ijN.setOnViewResponseListener(this.ijO);
        this.ijN.a(this);
        resetData();
        this.ijN.a(this.ijV);
        this.ijn = this.ijM.bZS();
        this.ijN.T(this.ijn);
        this.ijj = this.ijM.bZT();
        this.ijj.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.ijQ = this.ijM.bZW();
        this.ijP = new f(baseFragmentActivity.getPageContext(), this.ijM.bZV(), this.ijM.bZU(), this.ijN.aJC(), bdUniqueId);
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
                    if (!eVar.bYi() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ijN.bpI();
                                i.this.ijQ.iF(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.ijj != null && this.ijj.cat() != null && this.ijj.cat().cam()) {
                        this.ijN.bpI();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.ijN.aA(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ijN.bpI();
                                i.this.ijQ.iF(true);
                            }
                        }, 800L);
                    } else {
                        this.ijQ.py(z2);
                        this.ijR.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.ijN.bpI();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(R.string.data_load_error));
                                }
                                if (z4) {
                                    i.this.ijN.aA(null);
                                    i.this.ijQ.aIJ();
                                }
                            }
                        });
                        this.ijR.fetchPost(this.djs.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int Z;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.ijN.bpI();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> bYj = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bYj();
                                        if (v.aa(bYj)) {
                                            i.this.ijQ.aIJ();
                                            return;
                                        } else if (i.this.az(personPostModel.postList)) {
                                            eVar2.pl(false);
                                            i.this.ijN.aA(bYj);
                                            i.this.ijQ.c(true, bYj);
                                            return;
                                        } else if (i.dR(personPostModel.postList) == 0) {
                                            eVar2.pl(false);
                                            i.this.ijN.aA(bYj);
                                            i.this.ijQ.c(true, bYj);
                                            return;
                                        } else {
                                            bYj.addAll(personPostModel.postList);
                                            i.this.ijQ.ajz();
                                            eVar2.ay(bYj);
                                            i.this.ijN.aA(bYj);
                                            return;
                                        }
                                    }
                                    eVar2.pl(true);
                                    eVar2.ay(personPostModel.postList);
                                    i.this.ijN.aA(personPostModel.postList);
                                    if (eVar2.bYj() != null && (Z = v.Z(eVar2.bYj())) > 0 && Z <= 2) {
                                        for (int i = 0; i < Z; i++) {
                                            if (eVar2.bYj().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bYj().get(i)).isHost = i.this.mIsHost;
                                                i.this.ijQ.aIJ();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> bYj2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bYj();
                                if (!v.aa(bYj2)) {
                                    if (i.this.az(personPostModel.postList)) {
                                        eVar.pl(false);
                                        i.this.ijN.aA(bYj2);
                                        i.this.ijQ.c(true, bYj2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bYj2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bYj2);
                                    eVar.pl(true);
                                    eVar.ay(mergeDynamicThreadByTime);
                                    i.this.ijQ.ajz();
                                    i.this.ijN.dQ(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.ijQ.ajy();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.ijQ.aIJ();
                this.ijN.aA(arrayList2);
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
        if (this.ijM != null) {
            this.ijM.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.ijM != null) {
            this.ijM.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.ijR.resetThreadPn();
        if (this.ijj != null) {
            this.ijj.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.ijN.bpI();
        this.djs.hideLoadingView(this.mView);
        if (aVar == null) {
            this.ijQ.aj(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.ijQ.aIJ();
            this.ijQ.yj(8);
        } else if (aVar.biZ() != null && ((aVar.biZ().getHide_stat() == 1 && aVar.biZ().getBlock_stat() == 1) || (aVar.biZ().getHide_stat() == 1 && aVar.biZ().getBlock_stat() == 2))) {
            this.ijQ.px(this.mIsHost);
            this.ijQ.yj(8);
            this.ijQ.aHK();
        } else {
            this.ijQ.aHK();
            aVar.cak();
            if (aVar.bwf() != null) {
                z = aVar.bwf().size() >= 20;
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
            if (this.ijn != null) {
                this.ijn.a(aVar);
            }
            if (this.ijP != null) {
                this.ijP.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ay(aVar.bwf());
            eVar.pl(z);
            this.ijQ.yj(0);
            this.ijN.a(aVar, z);
            cai();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bZL() {
        return this.ijP;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ijN != null) {
                this.ijN.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.ijg = baseFragment;
    }

    public void cai() {
        if (!this.dnK) {
            if ((this.ijg == null || this.ijg.isPrimary()) && this.ijN != null && (this.ijN.caA() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.ijN.caA()).cai();
            }
        }
    }

    public void bVU() {
        if (this.ijN != null && (this.ijN.caA() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.ijN.caA()).bVU();
        }
    }

    public void caj() {
        if (this.ijN != null && this.ijN.aJC() != null && (this.ijN.caA() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.ijN.caA()).a(this.djs, this.ijN.aJC());
            if (this.ijO != null) {
                this.ijN.setOnViewResponseListener(this.ijO);
            }
            this.ijN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!ap.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bYj() != null && this.ijN != null) {
            ArrayList<m> bYj = this.mList.get(0).bYj();
            for (int i = 0; i < bYj.size() && bYj.get(i) != null; i++) {
                m mVar = bYj.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.ijN.a(i, str, this.ijU);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Xj);
        this.ijn.onDestroy();
        if (this.ijN != null) {
            this.ijN.onDestory();
        }
        bVU();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void jI(boolean z) {
        if (z) {
            if (this.dnK) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                cai();
                return;
            } else {
                bVU();
                return;
            }
        }
        bVU();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            cai();
            caj();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.djs.finish();
                return;
            }
            return;
        }
        bVU();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Cb(String str) {
        if (this.ijN != null) {
            this.ijN.Cb(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Cc(String str) {
        if (this.ijN != null) {
            this.ijN.Cc(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bZM() {
        if (this.ijN != null) {
            this.ijN.bZM();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void pw(boolean z) {
        this.ijN.pw(z);
    }

    private void initListener() {
        this.eSr = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bVU();
            }
        };
        this.eSr.setTag(this.Xj);
        MessageManager.getInstance().registerListener(this.eSr);
        this.ijS = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.ijS.setTag(this.Xj);
        MessageManager.getInstance().registerListener(this.ijS);
        this.ijT = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), (int) R.string.person_polymeric_set_privacy_success);
                }
            }
        };
        this.ijT.setTag(this.Xj);
        MessageManager.getInstance().registerListener(this.ijT);
    }
}
