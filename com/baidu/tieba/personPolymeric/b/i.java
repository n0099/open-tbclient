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
    private BaseFragmentActivity djr;
    private CustomMessageListener eSq;
    private e ijI;
    private p ijJ;
    private com.baidu.tieba.personPolymeric.event.c ijK;
    private f ijL;
    private d ijM;
    private PersonPostModel ijN;
    private CustomMessageListener ijO;
    private CustomMessageListener ijP;
    private BaseFragment ijc;
    private PersonPolymericModel ijf;
    private g ijj;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean dnJ = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a ijQ = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!ap.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bYf() != null && i.this.ijJ != null) {
                ArrayList<m> bYf = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bYf();
                Iterator<m> it = bYf.iterator();
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
                    i.this.ijJ.dQ(PersonPostModel.mergeDynamicThreadByTime(bYf));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i ijR = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bVQ();
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
        this.djr = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.ijI = eVar;
        this.Xk = bdUniqueId;
        this.mView = eVar.mRootView;
        this.ijN = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.ijJ = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.ijJ.O(this.mView);
        this.ijK = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.ijK.a(this.ijI);
        this.ijJ.setOnViewResponseListener(this.ijK);
        this.ijJ.a(this);
        resetData();
        this.ijJ.a(this.ijR);
        this.ijj = this.ijI.bZO();
        this.ijJ.T(this.ijj);
        this.ijf = this.ijI.bZP();
        this.ijf.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.ijM = this.ijI.bZS();
        this.ijL = new f(baseFragmentActivity.getPageContext(), this.ijI.bZR(), this.ijI.bZQ(), this.ijJ.aJz(), bdUniqueId);
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
                    if (!eVar.bYe() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ijJ.bpD();
                                i.this.ijM.iF(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.ijf != null && this.ijf.cap() != null && this.ijf.cap().cai()) {
                        this.ijJ.bpD();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.ijJ.aA(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ijJ.bpD();
                                i.this.ijM.iF(true);
                            }
                        }, 800L);
                    } else {
                        this.ijM.px(z2);
                        this.ijN.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.ijJ.bpD();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(R.string.data_load_error));
                                }
                                if (z4) {
                                    i.this.ijJ.aA(null);
                                    i.this.ijM.aIG();
                                }
                            }
                        });
                        this.ijN.fetchPost(this.djr.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int Z;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.ijJ.bpD();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> bYf = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bYf();
                                        if (v.aa(bYf)) {
                                            i.this.ijM.aIG();
                                            return;
                                        } else if (i.this.az(personPostModel.postList)) {
                                            eVar2.pk(false);
                                            i.this.ijJ.aA(bYf);
                                            i.this.ijM.c(true, bYf);
                                            return;
                                        } else if (i.dR(personPostModel.postList) == 0) {
                                            eVar2.pk(false);
                                            i.this.ijJ.aA(bYf);
                                            i.this.ijM.c(true, bYf);
                                            return;
                                        } else {
                                            bYf.addAll(personPostModel.postList);
                                            i.this.ijM.ajz();
                                            eVar2.ay(bYf);
                                            i.this.ijJ.aA(bYf);
                                            return;
                                        }
                                    }
                                    eVar2.pk(true);
                                    eVar2.ay(personPostModel.postList);
                                    i.this.ijJ.aA(personPostModel.postList);
                                    if (eVar2.bYf() != null && (Z = v.Z(eVar2.bYf())) > 0 && Z <= 2) {
                                        for (int i = 0; i < Z; i++) {
                                            if (eVar2.bYf().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bYf().get(i)).isHost = i.this.mIsHost;
                                                i.this.ijM.aIG();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> bYf2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bYf();
                                if (!v.aa(bYf2)) {
                                    if (i.this.az(personPostModel.postList)) {
                                        eVar.pk(false);
                                        i.this.ijJ.aA(bYf2);
                                        i.this.ijM.c(true, bYf2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bYf2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bYf2);
                                    eVar.pk(true);
                                    eVar.ay(mergeDynamicThreadByTime);
                                    i.this.ijM.ajz();
                                    i.this.ijJ.dQ(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.ijM.ajy();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.ijM.aIG();
                this.ijJ.aA(arrayList2);
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
        if (this.ijI != null) {
            this.ijI.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.ijI != null) {
            this.ijI.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.ijN.resetThreadPn();
        if (this.ijf != null) {
            this.ijf.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.ijJ.bpD();
        this.djr.hideLoadingView(this.mView);
        if (aVar == null) {
            this.ijM.aj(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.ijM.aIG();
            this.ijM.yj(8);
        } else if (aVar.biW() != null && ((aVar.biW().getHide_stat() == 1 && aVar.biW().getBlock_stat() == 1) || (aVar.biW().getHide_stat() == 1 && aVar.biW().getBlock_stat() == 2))) {
            this.ijM.pw(this.mIsHost);
            this.ijM.yj(8);
            this.ijM.aHH();
        } else {
            this.ijM.aHH();
            aVar.cag();
            if (aVar.bwb() != null) {
                z = aVar.bwb().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.dnJ = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.ash().a(aVar.getUserData());
            }
            if (this.ijj != null) {
                this.ijj.a(aVar);
            }
            if (this.ijL != null) {
                this.ijL.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ay(aVar.bwb());
            eVar.pk(z);
            this.ijM.yj(0);
            this.ijJ.a(aVar, z);
            cae();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bZH() {
        return this.ijL;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ijJ != null) {
                this.ijJ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.ijc = baseFragment;
    }

    public void cae() {
        if (!this.dnJ) {
            if ((this.ijc == null || this.ijc.isPrimary()) && this.ijJ != null && (this.ijJ.caw() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.ijJ.caw()).cae();
            }
        }
    }

    public void bVQ() {
        if (this.ijJ != null && (this.ijJ.caw() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.ijJ.caw()).bVQ();
        }
    }

    public void caf() {
        if (this.ijJ != null && this.ijJ.aJz() != null && (this.ijJ.caw() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.ijJ.caw()).a(this.djr, this.ijJ.aJz());
            if (this.ijK != null) {
                this.ijJ.setOnViewResponseListener(this.ijK);
            }
            this.ijJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!ap.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bYf() != null && this.ijJ != null) {
            ArrayList<m> bYf = this.mList.get(0).bYf();
            for (int i = 0; i < bYf.size() && bYf.get(i) != null; i++) {
                m mVar = bYf.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.ijJ.a(i, str, this.ijQ);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Xk);
        this.ijj.onDestroy();
        if (this.ijJ != null) {
            this.ijJ.onDestory();
        }
        bVQ();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void jI(boolean z) {
        if (z) {
            if (this.dnJ) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                cae();
                return;
            } else {
                bVQ();
                return;
            }
        }
        bVQ();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            cae();
            caf();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.djr.finish();
                return;
            }
            return;
        }
        bVQ();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void BZ(String str) {
        if (this.ijJ != null) {
            this.ijJ.BZ(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Ca(String str) {
        if (this.ijJ != null) {
            this.ijJ.Ca(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bZI() {
        if (this.ijJ != null) {
            this.ijJ.bZI();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void pv(boolean z) {
        this.ijJ.pv(z);
    }

    private void initListener() {
        this.eSq = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bVQ();
            }
        };
        this.eSq.setTag(this.Xk);
        MessageManager.getInstance().registerListener(this.eSq);
        this.ijO = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.ijO.setTag(this.Xk);
        MessageManager.getInstance().registerListener(this.ijO);
        this.ijP = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), (int) R.string.person_polymeric_set_privacy_success);
                }
            }
        };
        this.ijP.setTag(this.Xk);
        MessageManager.getInstance().registerListener(this.ijP);
    }
}
