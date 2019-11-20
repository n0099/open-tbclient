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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private BdUniqueId GX;
    private TbPageContext ceu;
    private CustomMessageListener fbb;
    private BaseFragmentActivity fxV;
    private e iqQ;
    private p iqR;
    private com.baidu.tieba.personPolymeric.event.c iqS;
    private f iqT;
    private d iqU;
    private PersonPostModel iqV;
    private CustomMessageListener iqW;
    private CustomMessageListener iqX;
    private BaseFragment iqk;
    private PersonPolymericModel iqn;
    private g iqr;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean dxT = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a iqY = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!aq.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bZe() != null && i.this.iqR != null) {
                ArrayList<m> bZe = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bZe();
                Iterator<m> it = bZe.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    m next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && aq.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    i.this.iqR.ee(PersonPostModel.mergeDynamicThreadByTime(bZe));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i iqZ = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bWN();
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
        this.fxV = baseFragmentActivity;
        this.ceu = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.iqQ = eVar;
        this.GX = bdUniqueId;
        this.mView = eVar.mRootView;
        this.iqV = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.iqR = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.iqR.W(this.mView);
        this.iqS = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.iqS.a(this.iqQ);
        this.iqR.setOnViewResponseListener(this.iqS);
        this.iqR.a(this);
        resetData();
        this.iqR.a(this.iqZ);
        this.iqr = this.iqQ.caM();
        this.iqR.W(this.iqr);
        this.iqn = this.iqQ.caN();
        this.iqn.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.iqU = this.iqQ.caQ();
        this.iqT = new f(baseFragmentActivity.getPageContext(), this.iqQ.caP(), this.iqQ.caO(), this.iqR.aKP(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void k(final boolean z, boolean z2, boolean z3) {
        if (j.isNetworkAvailableForImmediately()) {
            if (!v.isEmpty(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bZd() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.iqR.bpL();
                                i.this.iqU.iU(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.iqn != null && this.iqn.cbo() != null && this.iqn.cbo().cbh()) {
                        this.iqR.bpL();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.iqR.aE(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.iqR.bpL();
                                i.this.iqU.iU(true);
                            }
                        }, 800L);
                    } else {
                        this.iqU.py(z2);
                        this.iqV.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.iqR.bpL();
                                if (personPostModel != null) {
                                    l.showToast(i.this.ceu.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.ceu.getContext(), i.this.ceu.getString(R.string.data_load_error));
                                }
                                if (z4) {
                                    i.this.iqR.aE(null);
                                    i.this.iqU.aKi();
                                }
                            }
                        });
                        this.iqV.fetchPost(this.fxV.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int count;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.ceu.getContext(), personPostModel.getErrorString());
                                }
                                i.this.iqR.bpL();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> bZe = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bZe();
                                        if (v.isEmpty(bZe)) {
                                            i.this.iqU.aKi();
                                            return;
                                        } else if (i.this.aD(personPostModel.postList)) {
                                            eVar2.pm(false);
                                            i.this.iqR.aE(bZe);
                                            i.this.iqU.e(true, bZe);
                                            return;
                                        } else if (i.ef(personPostModel.postList) == 0) {
                                            eVar2.pm(false);
                                            i.this.iqR.aE(bZe);
                                            i.this.iqU.e(true, bZe);
                                            return;
                                        } else {
                                            bZe.addAll(personPostModel.postList);
                                            i.this.iqU.endLoadData();
                                            eVar2.aC(bZe);
                                            i.this.iqR.aE(bZe);
                                            return;
                                        }
                                    }
                                    eVar2.pm(true);
                                    eVar2.aC(personPostModel.postList);
                                    i.this.iqR.aE(personPostModel.postList);
                                    if (eVar2.bZe() != null && (count = v.getCount(eVar2.bZe())) > 0 && count <= 2) {
                                        for (int i = 0; i < count; i++) {
                                            if (eVar2.bZe().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bZe().get(i)).isHost = i.this.mIsHost;
                                                i.this.iqU.aKi();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> bZe2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bZe();
                                if (!v.isEmpty(bZe2)) {
                                    if (i.this.aD(personPostModel.postList)) {
                                        eVar.pm(false);
                                        i.this.iqR.aE(bZe2);
                                        i.this.iqU.e(true, bZe2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bZe2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bZe2);
                                    eVar.pm(true);
                                    eVar.aC(mergeDynamicThreadByTime);
                                    i.this.iqU.endLoadData();
                                    i.this.iqR.ee(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.iqU.startLoadData();
        } else {
            l.showToast(this.ceu.getContext(), this.ceu.getString(R.string.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.iqU.aKi();
                this.iqR.aE(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aD(ArrayList<m> arrayList) {
        int count = v.getCount(arrayList);
        if (count != 0) {
            if (count > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int ef(List<m> list) {
        int i = 0;
        if (v.getCount(list) == 0) {
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
        if (v.getCount(arrayList) == 0) {
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
        if (this.iqQ != null) {
            this.iqQ.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void i(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.iqQ != null) {
            this.iqQ.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.iqV.resetThreadPn();
        if (this.iqn != null) {
            this.iqn.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.iqR.bpL();
        this.fxV.hideLoadingView(this.mView);
        if (aVar == null) {
            this.iqU.aj(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.iqU.aKi();
            this.iqU.xx(8);
        } else if (aVar.biX() != null && ((aVar.biX().getHide_stat() == 1 && aVar.biX().getBlock_stat() == 1) || (aVar.biX().getHide_stat() == 1 && aVar.biX().getBlock_stat() == 2))) {
            this.iqU.px(this.mIsHost);
            this.iqU.xx(8);
            this.iqU.aJm();
        } else {
            this.iqU.aJm();
            aVar.cbf();
            if (aVar.bwu() != null) {
                z = aVar.bwu().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.dxT = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.avk().a(aVar.getUserData());
            }
            if (this.iqr != null) {
                this.iqr.a(aVar);
            }
            if (this.iqT != null) {
                this.iqT.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.aC(aVar.bwu());
            eVar.pm(z);
            this.iqU.xx(0);
            this.iqR.a(aVar, z);
            cbd();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f caF() {
        return this.iqT;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.iqR != null) {
                this.iqR.onChangeSkinType(i);
            }
            if (this.iqT != null) {
                this.iqT.anM();
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.iqk = baseFragment;
    }

    public void cbd() {
        if (!this.dxT) {
            if ((this.iqk == null || this.iqk.isPrimary()) && this.iqR != null && (this.iqR.cbv() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.iqR.cbv()).cbd();
            }
        }
    }

    public void bWN() {
        if (this.iqR != null && (this.iqR.cbv() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.iqR.cbv()).bWN();
        }
    }

    public void cbe() {
        if (this.iqR != null && this.iqR.aKP() != null && (this.iqR.cbv() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.iqR.cbv()).a(this.fxV, this.iqR.aKP());
            if (this.iqS != null) {
                this.iqR.setOnViewResponseListener(this.iqS);
            }
            this.iqR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!aq.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bZe() != null && this.iqR != null) {
            ArrayList<m> bZe = this.mList.get(0).bZe();
            for (int i = 0; i < bZe.size() && bZe.get(i) != null; i++) {
                m mVar = bZe.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && aq.equals(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.iqR.a(i, str, this.iqY);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.GX);
        this.iqr.onDestroy();
        if (this.iqR != null) {
            this.iqR.onDestory();
        }
        bWN();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void jJ(boolean z) {
        if (z) {
            if (this.dxT) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                cbd();
                return;
            } else {
                bWN();
                return;
            }
        }
        bWN();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            cbd();
            cbe();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.ceu.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.fxV.finish();
                return;
            }
            return;
        }
        bWN();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void BH(String str) {
        if (this.iqR != null) {
            this.iqR.BH(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void BI(String str) {
        if (this.iqR != null) {
            this.iqR.BI(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void caG() {
        if (this.iqR != null) {
            this.iqR.caG();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void pw(boolean z) {
        this.iqR.pw(z);
    }

    private void initListener() {
        this.fbb = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bWN();
            }
        };
        this.fbb.setTag(this.GX);
        MessageManager.getInstance().registerListener(this.fbb);
        this.iqW = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.iqW.setTag(this.GX);
        MessageManager.getInstance().registerListener(this.iqW);
        this.iqX = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.ceu.getPageActivity(), (int) R.string.person_polymeric_set_privacy_success);
                }
            }
        };
        this.iqX.setTag(this.GX);
        MessageManager.getInstance().registerListener(this.iqX);
    }
}
