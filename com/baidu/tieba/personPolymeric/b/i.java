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
    private BdUniqueId Hx;
    private TbPageContext cfl;
    private CustomMessageListener fbS;
    private BaseFragmentActivity fyM;
    private e irH;
    private p irI;
    private com.baidu.tieba.personPolymeric.event.c irJ;
    private f irK;
    private d irL;
    private PersonPostModel irM;
    private CustomMessageListener irN;
    private CustomMessageListener irO;
    private BaseFragment irb;
    private PersonPolymericModel ire;
    private g iri;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean dyK = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a irP = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void removeThread(String str) {
            boolean z;
            if (!aq.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bZg() != null && i.this.irI != null) {
                ArrayList<m> bZg = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bZg();
                Iterator<m> it = bZg.iterator();
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
                    i.this.irI.ee(PersonPostModel.mergeDynamicThreadByTime(bZg));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i irQ = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bWP();
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
        this.fyM = baseFragmentActivity;
        this.cfl = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.irH = eVar;
        this.Hx = bdUniqueId;
        this.mView = eVar.mRootView;
        this.irM = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.irI = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.irI.W(this.mView);
        this.irJ = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.irJ.a(this.irH);
        this.irI.setOnViewResponseListener(this.irJ);
        this.irI.a(this);
        resetData();
        this.irI.a(this.irQ);
        this.iri = this.irH.caO();
        this.irI.W(this.iri);
        this.ire = this.irH.caP();
        this.ire.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.irL = this.irH.caS();
        this.irK = new f(baseFragmentActivity.getPageContext(), this.irH.caR(), this.irH.caQ(), this.irI.aKR(), bdUniqueId);
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
                    if (!eVar.bZf() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.irI.bpN();
                                i.this.irL.iU(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.ire != null && this.ire.cbq() != null && this.ire.cbq().cbj()) {
                        this.irI.bpN();
                        ArrayList<m> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.irI.aE(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.irI.bpN();
                                i.this.irL.iU(true);
                            }
                        }, 800L);
                    } else {
                        this.irL.py(z2);
                        this.irM.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.irI.bpN();
                                if (personPostModel != null) {
                                    l.showToast(i.this.cfl.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.cfl.getContext(), i.this.cfl.getString(R.string.data_load_error));
                                }
                                if (z4) {
                                    i.this.irI.aE(null);
                                    i.this.irL.aKk();
                                }
                            }
                        });
                        this.irM.fetchPost(this.fyM.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int count;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.cfl.getContext(), personPostModel.getErrorString());
                                }
                                i.this.irI.bpN();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<m> bZg = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bZg();
                                        if (v.isEmpty(bZg)) {
                                            i.this.irL.aKk();
                                            return;
                                        } else if (i.this.aD(personPostModel.postList)) {
                                            eVar2.pm(false);
                                            i.this.irI.aE(bZg);
                                            i.this.irL.e(true, bZg);
                                            return;
                                        } else if (i.ef(personPostModel.postList) == 0) {
                                            eVar2.pm(false);
                                            i.this.irI.aE(bZg);
                                            i.this.irL.e(true, bZg);
                                            return;
                                        } else {
                                            bZg.addAll(personPostModel.postList);
                                            i.this.irL.endLoadData();
                                            eVar2.aC(bZg);
                                            i.this.irI.aE(bZg);
                                            return;
                                        }
                                    }
                                    eVar2.pm(true);
                                    eVar2.aC(personPostModel.postList);
                                    i.this.irI.aE(personPostModel.postList);
                                    if (eVar2.bZg() != null && (count = v.getCount(eVar2.bZg())) > 0 && count <= 2) {
                                        for (int i = 0; i < count; i++) {
                                            if (eVar2.bZg().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bZg().get(i)).isHost = i.this.mIsHost;
                                                i.this.irL.aKk();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<m> bZg2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bZg();
                                if (!v.isEmpty(bZg2)) {
                                    if (i.this.aD(personPostModel.postList)) {
                                        eVar.pm(false);
                                        i.this.irI.aE(bZg2);
                                        i.this.irL.e(true, bZg2);
                                        return;
                                    }
                                    Iterator<m> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        m next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bZg2.addAll(personPostModel.threadList);
                                    ArrayList<m> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bZg2);
                                    eVar.pm(true);
                                    eVar.aC(mergeDynamicThreadByTime);
                                    i.this.irL.endLoadData();
                                    i.this.irI.ee(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.irL.startLoadData();
        } else {
            l.showToast(this.cfl.getContext(), this.cfl.getString(R.string.data_load_error));
            if (z) {
                ArrayList<m> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.irL.aKk();
                this.irI.aE(arrayList2);
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
        if (this.irH != null) {
            this.irH.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void i(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.irH != null) {
            this.irH.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.irM.resetThreadPn();
        if (this.ire != null) {
            this.ire.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.irI.bpN();
        this.fyM.hideLoadingView(this.mView);
        if (aVar == null) {
            this.irL.aj(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.irL.aKk();
            this.irL.xy(8);
        } else if (aVar.biZ() != null && ((aVar.biZ().getHide_stat() == 1 && aVar.biZ().getBlock_stat() == 1) || (aVar.biZ().getHide_stat() == 1 && aVar.biZ().getBlock_stat() == 2))) {
            this.irL.px(this.mIsHost);
            this.irL.xy(8);
            this.irL.aJo();
        } else {
            this.irL.aJo();
            aVar.cbh();
            if (aVar.bww() != null) {
                z = aVar.bww().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.dyK = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.avm().a(aVar.getUserData());
            }
            if (this.iri != null) {
                this.iri.a(aVar);
            }
            if (this.irK != null) {
                this.irK.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.aC(aVar.bww());
            eVar.pm(z);
            this.irL.xy(0);
            this.irI.a(aVar, z);
            cbf();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f caH() {
        return this.irK;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.irI != null) {
                this.irI.onChangeSkinType(i);
            }
            if (this.irK != null) {
                this.irK.anO();
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.irb = baseFragment;
    }

    public void cbf() {
        if (!this.dyK) {
            if ((this.irb == null || this.irb.isPrimary()) && this.irI != null && (this.irI.cbx() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.irI.cbx()).cbf();
            }
        }
    }

    public void bWP() {
        if (this.irI != null && (this.irI.cbx() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.irI.cbx()).bWP();
        }
    }

    public void cbg() {
        if (this.irI != null && this.irI.aKR() != null && (this.irI.cbx() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.irI.cbx()).a(this.fyM, this.irI.aKR());
            if (this.irJ != null) {
                this.irI.setOnViewResponseListener(this.irJ);
            }
            this.irI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void removeThread(String str) {
        if (!aq.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bZg() != null && this.irI != null) {
            ArrayList<m> bZg = this.mList.get(0).bZg();
            for (int i = 0; i < bZg.size() && bZg.get(i) != null; i++) {
                m mVar = bZg.get(i);
                if ((mVar instanceof CardPersonDynamicThreadData) && aq.equals(str, ((CardPersonDynamicThreadData) mVar).threadId)) {
                    this.irI.a(i, str, this.irP);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.Hx);
        this.iri.onDestroy();
        if (this.irI != null) {
            this.irI.onDestory();
        }
        bWP();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void jJ(boolean z) {
        if (z) {
            if (this.dyK) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                cbf();
                return;
            } else {
                bWP();
                return;
            }
        }
        bWP();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            cbf();
            cbg();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.cfl.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.fyM.finish();
                return;
            }
            return;
        }
        bWP();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void BH(String str) {
        if (this.irI != null) {
            this.irI.BH(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void BI(String str) {
        if (this.irI != null) {
            this.irI.BI(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void caI() {
        if (this.irI != null) {
            this.irI.caI();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void pw(boolean z) {
        this.irI.pw(z);
    }

    private void initListener() {
        this.fbS = new CustomMessageListener(CmdConfigCustom.CMD_HOME_HIDE_GUIDE) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bWP();
            }
        };
        this.fbS.setTag(this.Hx);
        MessageManager.getInstance().registerListener(this.fbS);
        this.irN = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_CARD_PERSON_DYNAMIC_THREAD) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                }
            }
        };
        this.irN.setTag(this.Hx);
        MessageManager.getInstance().registerListener(this.irN);
        this.irO = new CustomMessageListener(CmdConfigCustom.CMD_CARD_PERSON_DYNAMIC_THREAD_HIDE) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.removeThread((String) customResponsedMessage.getData());
                    l.showToast(i.this.cfl.getPageActivity(), (int) R.string.person_polymeric_set_privacy_success);
                }
            }
        };
        this.irO.setTag(this.Hx);
        MessageManager.getInstance().registerListener(this.irO);
    }
}
