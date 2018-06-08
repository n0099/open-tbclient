package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId aKh;
    private BaseFragmentActivity bqF;
    private CustomMessageListener cSh;
    private e fVN;
    private p fVO;
    private com.baidu.tieba.personPolymeric.event.c fVP;
    private f fVQ;
    private d fVR;
    private PersonPostModel fVS;
    private CustomMessageListener fVT;
    private CustomMessageListener fVU;
    private BaseFragment fVg;
    private PersonPolymericModel fVj;
    private g fVn;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean bEd = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a fVV = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void sc(String str) {
            boolean z;
            if (!ao.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biE() != null && i.this.fVO != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> biE = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biE();
                Iterator<com.baidu.adp.widget.ListView.h> it = biE.iterator();
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
                    i.this.fVO.dc(PersonPostModel.mergeDynamicThreadByTime(biE));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i fVW = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bgl();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void sc(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bqF = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.fVN = eVar;
        this.aKh = bdUniqueId;
        this.mView = eVar.mRootView;
        this.fVS = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.fVO = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.fVO.Y(this.mView);
        this.fVP = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.fVP.a(this.fVN);
        this.fVO.setOnViewResponseListener(this.fVP);
        this.fVO.a(this);
        resetData();
        this.fVO.a(this.fVW);
        this.fVn = this.fVN.bkd();
        this.fVO.N(this.fVn);
        this.fVj = this.fVN.bke();
        this.fVj.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.fVR = this.fVN.bkh();
        this.fVQ = new f(baseFragmentActivity.getPageContext(), this.fVN.bkg(), this.fVN.bkf(), this.fVO.UB(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void k(final boolean z, boolean z2, boolean z3) {
        if (com.baidu.adp.lib.util.j.jr()) {
            if (!w.z(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.biD() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fVO.ayU();
                                i.this.fVR.eH(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.fVj != null && this.fVj.bkE() != null && this.fVj.bkE().bkx()) {
                        this.fVO.ayU();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.fVO.ar(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fVO.ayU();
                                i.this.fVR.eH(true);
                            }
                        }, 800L);
                    } else {
                        this.fVR.ll(z2);
                        this.fVS.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.fVO.ayU();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(d.k.data_load_error));
                                }
                                if (z4) {
                                    i.this.fVO.ar(null);
                                    i.this.fVR.TL();
                                }
                            }
                        });
                        this.fVS.fetchPost(this.bqF.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int y;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.fVO.ayU();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> biE = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).biE();
                                        if (w.z(biE)) {
                                            i.this.fVR.TL();
                                            return;
                                        } else if (i.this.aq(personPostModel.postList)) {
                                            eVar2.kY(false);
                                            i.this.fVO.ar(biE);
                                            i.this.fVR.b(true, biE);
                                            return;
                                        } else if (i.dd(personPostModel.postList) == 0) {
                                            eVar2.kY(false);
                                            i.this.fVO.ar(biE);
                                            i.this.fVR.b(true, biE);
                                            return;
                                        } else {
                                            biE.addAll(personPostModel.postList);
                                            i.this.fVR.As();
                                            eVar2.ap(biE);
                                            i.this.fVO.ar(biE);
                                            return;
                                        }
                                    }
                                    eVar2.kY(true);
                                    eVar2.ap(personPostModel.postList);
                                    i.this.fVO.ar(personPostModel.postList);
                                    if (eVar2.biE() != null && (y = w.y(eVar2.biE())) > 0 && y <= 2) {
                                        for (int i = 0; i < y; i++) {
                                            if (eVar2.biE().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.biE().get(i)).isHost = i.this.mIsHost;
                                                i.this.fVR.TL();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> biE2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).biE();
                                if (!w.z(biE2)) {
                                    if (i.this.aq(personPostModel.postList)) {
                                        eVar.kY(false);
                                        i.this.fVO.ar(biE2);
                                        i.this.fVR.b(true, biE2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    biE2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(biE2);
                                    eVar.kY(true);
                                    eVar.ap(mergeDynamicThreadByTime);
                                    i.this.fVR.As();
                                    i.this.fVO.dc(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.fVR.Ar();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.k.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.fVR.TL();
                this.fVO.ar(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aq(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int y = w.y(arrayList);
        if (y != 0) {
            if (y > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int dd(List<com.baidu.adp.widget.ListView.h> list) {
        int i = 0;
        if (w.y(list) == 0) {
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
        if (w.y(arrayList) == 0) {
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
        if (this.fVN != null) {
            this.fVN.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void h(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void So() {
        if (this.fVN != null) {
            this.fVN.So();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fVS.resetThreadPn();
        if (this.fVj != null) {
            this.fVj.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.fVO.ayU();
        this.bqF.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fVR.E(TbadkCoreApplication.getInst().getString(d.k.neterror), true);
            this.fVR.TL();
            this.fVR.rs(8);
        } else if (aVar.bbg() != null && ((aVar.bbg().getHide_stat() == 1 && aVar.bbg().getBlock_stat() == 1) || (aVar.bbg().getHide_stat() == 1 && aVar.bbg().getBlock_stat() == 2))) {
            this.fVR.lk(this.mIsHost);
            this.fVR.rs(8);
            this.fVR.TI();
        } else {
            this.fVR.TI();
            aVar.bkv();
            if (aVar.aEg() != null) {
                z = aVar.aEg().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.bEd = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.Iu().a(aVar.getUserData());
            }
            if (this.fVn != null) {
                this.fVn.a(aVar);
            }
            if (this.fVQ != null) {
                this.fVQ.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ap(aVar.aEg());
            eVar.kY(z);
            this.fVR.rs(0);
            this.fVO.a(aVar, z);
            bkt();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bjX() {
        return this.fVQ;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fVO != null) {
                this.fVO.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.fVg = baseFragment;
    }

    public void bkt() {
        if (!this.bEd) {
            if ((this.fVg == null || this.fVg.isPrimary()) && this.fVO != null && (this.fVO.bkM() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fVO.bkM()).bkt();
            }
        }
    }

    public void bgl() {
        if (this.fVO != null && (this.fVO.bkM() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fVO.bkM()).bgl();
        }
    }

    public void bku() {
        if (this.fVO != null && this.fVO.UB() != null && (this.fVO.bkM() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.fVO.bkM()).a(this.bqF, this.fVO.UB());
            if (this.fVP != null) {
                this.fVO.setOnViewResponseListener(this.fVP);
            }
            this.fVO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void sc(String str) {
        if (!ao.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).biE() != null && this.fVO != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> biE = this.mList.get(0).biE();
            for (int i = 0; i < biE.size() && biE.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = biE.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.fVO.a(i, str, this.fVV);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aKh);
        this.fVn.onDestroy();
        if (this.fVO != null) {
            this.fVO.onDestory();
        }
        bgl();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void fw(boolean z) {
        if (z) {
            if (this.bEd) {
                So();
            }
            if (TbadkCoreApplication.isLogin()) {
                bkt();
                return;
            } else {
                bgl();
                return;
            }
        }
        bgl();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bkt();
            bku();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.bqF.finish();
                return;
            }
            return;
        }
        bgl();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bjY() {
        if (this.fVO != null) {
            this.fVO.bjY();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void lj(boolean z) {
        this.fVO.lj(z);
    }

    private void initListener() {
        this.cSh = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bgl();
            }
        };
        this.cSh.setTag(this.aKh);
        MessageManager.getInstance().registerListener(this.cSh);
        this.fVT = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.sc((String) customResponsedMessage.getData());
                }
            }
        };
        this.fVT.setTag(this.aKh);
        MessageManager.getInstance().registerListener(this.fVT);
        this.fVU = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.sc((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), d.k.person_polymeric_set_privacy_success);
                }
            }
        };
        this.fVU.setTag(this.aKh);
        MessageManager.getInstance().registerListener(this.fVU);
    }
}
