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
    private BdUniqueId XD;
    private BaseFragmentActivity dmS;
    private CustomMessageListener eZh;
    private BaseFragment isB;
    private PersonPolymericModel isE;
    private g isI;
    private e ith;
    private p iti;
    private com.baidu.tieba.personPolymeric.event.c itj;
    private f itk;
    private d itl;
    private PersonPostModel itm;
    private CustomMessageListener itn;
    private CustomMessageListener ito;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean drA = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a itp = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!aq.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).cce() != null && i.this.iti != null) {
                ArrayList<m> cce = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).cce();
                Iterator<m> it = cce.iterator();
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
                    i.this.iti.dR(PersonPostModel.mergeDynamicThreadByTime(cce));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i itq = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bZN();
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
        this.dmS = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.ith = eVar;
        this.XD = bdUniqueId;
        this.mView = eVar.mRootView;
        this.itm = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.iti = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.iti.Q(this.mView);
        this.itj = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.itj.a(this.ith);
        this.iti.setOnViewResponseListener(this.itj);
        this.iti.a(this);
        resetData();
        this.iti.a(this.itq);
        this.isI = this.ith.cdN();
        this.iti.V(this.isI);
        this.isE = this.ith.cdO();
        this.isE.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.itl = this.ith.cdR();
        this.itk = new f(baseFragmentActivity.getPageContext(), this.ith.cdQ(), this.ith.cdP(), this.iti.aLN(), bdUniqueId);
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
                    if (!eVar.ccd() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.iti.bsJ();
                                i.this.itl.iR(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.isE != null && this.isE.ceo() != null && this.isE.ceo().ceh()) {
                        this.iti.bsJ();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.iti.aA(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.iti.bsJ();
                                i.this.itl.iR(true);
                            }
                        }, 800L);
                    } else {
                        this.itl.pQ(z2);
                        this.itm.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.iti.bsJ();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(R.string.data_load_error));
                                }
                                if (z4) {
                                    i.this.iti.aA(null);
                                    i.this.itl.aKQ();
                                }
                            }
                        });
                        this.itm.fetchPost(this.dmS.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int Z;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.iti.bsJ();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> cce = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).cce();
                                        if (v.aa(cce)) {
                                            i.this.itl.aKQ();
                                            return;
                                        } else if (i.this.az(personPostModel.postList)) {
                                            eVar2.pD(false);
                                            i.this.iti.aA(cce);
                                            i.this.itl.b(true, cce);
                                            return;
                                        } else if (i.dS(personPostModel.postList) == 0) {
                                            eVar2.pD(false);
                                            i.this.iti.aA(cce);
                                            i.this.itl.b(true, cce);
                                            return;
                                        } else {
                                            cce.addAll(personPostModel.postList);
                                            i.this.itl.akS();
                                            eVar2.ay(cce);
                                            i.this.iti.aA(cce);
                                            return;
                                        }
                                    }
                                    eVar2.pD(true);
                                    eVar2.ay(personPostModel.postList);
                                    i.this.iti.aA(personPostModel.postList);
                                    if (eVar2.cce() != null && (Z = v.Z(eVar2.cce())) > 0 && Z <= 2) {
                                        for (int i = 0; i < Z; i++) {
                                            if (eVar2.cce().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.cce().get(i)).isHost = i.this.mIsHost;
                                                i.this.itl.aKQ();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> cce2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).cce();
                                if (!v.aa(cce2)) {
                                    if (i.this.az(personPostModel.postList)) {
                                        eVar.pD(false);
                                        i.this.iti.aA(cce2);
                                        i.this.itl.b(true, cce2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    cce2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(cce2);
                                    eVar.pD(true);
                                    eVar.ay(mergeDynamicThreadByTime);
                                    i.this.itl.akS();
                                    i.this.iti.dR(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.itl.akR();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.itl.aKQ();
                this.iti.aA(arrayList2);
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
        if (this.ith != null) {
            this.ith.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        i(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.ith != null) {
            this.ith.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.itm.resetThreadPn();
        if (this.isE != null) {
            this.isE.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.iti.bsJ();
        this.dmS.hideLoadingView(this.mView);
        if (aVar == null) {
            this.itl.an(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.itl.aKQ();
            this.itl.yT(8);
        } else if (aVar.blT() != null && ((aVar.blT().getHide_stat() == 1 && aVar.blT().getBlock_stat() == 1) || (aVar.blT().getHide_stat() == 1 && aVar.blT().getBlock_stat() == 2))) {
            this.itl.pP(this.mIsHost);
            this.itl.yT(8);
            this.itl.aJN();
        } else {
            this.itl.aJN();
            aVar.cef();
            if (aVar.bzL() != null) {
                z = aVar.bzL().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.drA = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.atC().a(aVar.getUserData());
            }
            if (this.isI != null) {
                this.isI.a(aVar);
            }
            if (this.itk != null) {
                this.itk.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ay(aVar.bzL());
            eVar.pD(z);
            this.itl.yT(0);
            this.iti.a(aVar, z);
            ced();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f cdG() {
        return this.itk;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iti != null) {
                this.iti.onChangeSkinType(i);
            }
            if (this.itk != null) {
                this.itk.akZ();
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.isB = baseFragment;
    }

    public void ced() {
        if (!this.drA) {
            if ((this.isB == null || this.isB.isPrimary()) && this.iti != null && (this.iti.cev() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.iti.cev()).ced();
            }
        }
    }

    public void bZN() {
        if (this.iti != null && (this.iti.cev() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.iti.cev()).bZN();
        }
    }

    public void cee() {
        if (this.iti != null && this.iti.aLN() != null && (this.iti.cev() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.iti.cev()).a(this.dmS, this.iti.aLN());
            if (this.itj != null) {
                this.iti.setOnViewResponseListener(this.itj);
            }
            this.iti.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!aq.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).cce() != null && this.iti != null) {
            ArrayList<m> cce = this.mList.get(0).cce();
            for (int i = 0; i < cce.size() && cce.get(i) != null; i++) {
                m mVar = cce.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && aq.bV(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.iti.a(i, str, this.itp);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.XD);
        this.isI.onDestroy();
        if (this.iti != null) {
            this.iti.onDestory();
        }
        bZN();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void jV(boolean z) {
        if (z) {
            if (this.drA) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                ced();
                return;
            } else {
                bZN();
                return;
            }
        }
        bZN();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            ced();
            cee();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.dmS.finish();
                return;
            }
            return;
        }
        bZN();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Do(String str) {
        if (this.iti != null) {
            this.iti.Do(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void Dp(String str) {
        if (this.iti != null) {
            this.iti.Dp(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void cdH() {
        if (this.iti != null) {
            this.iti.cdH();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void pO(boolean z) {
        this.iti.pO(z);
    }

    private void initListener() {
        this.eZh = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bZN();
            }
        };
        this.eZh.setTag(this.XD);
        MessageManager.getInstance().registerListener(this.eZh);
        this.itn = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.itn.setTag(this.XD);
        MessageManager.getInstance().registerListener(this.itn);
        this.ito = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), (int) R.string.person_polymeric_set_privacy_success);
                }
            }
        };
        this.ito.setTag(this.XD);
        MessageManager.getInstance().registerListener(this.ito);
    }
}
