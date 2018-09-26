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
    private BdUniqueId asU;
    private BaseFragmentActivity byH;
    private CustomMessageListener cYF;
    private BaseFragment ggR;
    private PersonPolymericModel ggU;
    private g ggY;
    private f ghA;
    private d ghB;
    private PersonPostModel ghC;
    private CustomMessageListener ghD;
    private CustomMessageListener ghE;
    private e ghx;
    private p ghy;
    private com.baidu.tieba.personPolymeric.event.c ghz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean bEO = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a ghF = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void sF(String str) {
            boolean z;
            if (!ao.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bjZ() != null && i.this.ghy != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> bjZ = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bjZ();
                Iterator<com.baidu.adp.widget.ListView.h> it = bjZ.iterator();
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
                    i.this.ghy.dd(PersonPostModel.mergeDynamicThreadByTime(bjZ));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i ghG = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bhL();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void sF(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.byH = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.ghx = eVar;
        this.asU = bdUniqueId;
        this.mView = eVar.mRootView;
        this.ghC = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.ghy = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.ghy.am(this.mView);
        this.ghz = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.ghz.a(this.ghx);
        this.ghy.setOnViewResponseListener(this.ghz);
        this.ghy.a(this);
        resetData();
        this.ghy.a(this.ghG);
        this.ggY = this.ghx.blA();
        this.ghy.O(this.ggY);
        this.ggU = this.ghx.blB();
        this.ggU.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.ghB = this.ghx.blE();
        this.ghA = new f(baseFragmentActivity.getPageContext(), this.ghx.blD(), this.ghx.blC(), this.ghy.WW(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void j(final boolean z, boolean z2, boolean z3) {
        if (j.ky()) {
            if (!v.z(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bjY() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ghy.aCn();
                                i.this.ghB.eZ(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.ggU != null && this.ggU.bmb() != null && this.ggU.bmb().blU()) {
                        this.ghy.aCn();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.ghy.at(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.ghy.aCn();
                                i.this.ghB.eZ(true);
                            }
                        }, 800L);
                    } else {
                        this.ghB.lD(z2);
                        this.ghC.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.ghy.aCn();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(e.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.ghy.at(null);
                                    i.this.ghB.Wd();
                                }
                            }
                        });
                        this.ghC.fetchPost(this.byH.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int y;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.ghy.aCn();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bjZ = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bjZ();
                                        if (v.z(bjZ)) {
                                            i.this.ghB.Wd();
                                            return;
                                        } else if (i.this.as(personPostModel.postList)) {
                                            eVar2.lq(false);
                                            i.this.ghy.at(bjZ);
                                            i.this.ghB.c(true, bjZ);
                                            return;
                                        } else if (i.de(personPostModel.postList) == 0) {
                                            eVar2.lq(false);
                                            i.this.ghy.at(bjZ);
                                            i.this.ghB.c(true, bjZ);
                                            return;
                                        } else {
                                            bjZ.addAll(personPostModel.postList);
                                            i.this.ghB.BJ();
                                            eVar2.ar(bjZ);
                                            i.this.ghy.at(bjZ);
                                            return;
                                        }
                                    }
                                    eVar2.lq(true);
                                    eVar2.ar(personPostModel.postList);
                                    i.this.ghy.at(personPostModel.postList);
                                    if (eVar2.bjZ() != null && (y = v.y(eVar2.bjZ())) > 0 && y <= 2) {
                                        for (int i = 0; i < y; i++) {
                                            if (eVar2.bjZ().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bjZ().get(i)).isHost = i.this.mIsHost;
                                                i.this.ghB.Wd();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bjZ2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bjZ();
                                if (!v.z(bjZ2)) {
                                    if (i.this.as(personPostModel.postList)) {
                                        eVar.lq(false);
                                        i.this.ghy.at(bjZ2);
                                        i.this.ghB.c(true, bjZ2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bjZ2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bjZ2);
                                    eVar.lq(true);
                                    eVar.ar(mergeDynamicThreadByTime);
                                    i.this.ghB.BJ();
                                    i.this.ghy.dd(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.ghB.BI();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.ghB.Wd();
                this.ghy.at(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean as(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int y = v.y(arrayList);
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

    public static int de(List<com.baidu.adp.widget.ListView.h> list) {
        int i = 0;
        if (v.y(list) == 0) {
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
        if (v.y(arrayList) == 0) {
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
        if (this.ghx != null) {
            this.ghx.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.ghx != null) {
            this.ghx.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.ghC.resetThreadPn();
        if (this.ggU != null) {
            this.ggU.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.ghy.aCn();
        this.byH.hideLoadingView(this.mView);
        if (aVar == null) {
            this.ghB.F(TbadkCoreApplication.getInst().getString(e.j.neterror), true);
            this.ghB.Wd();
            this.ghB.rV(8);
        } else if (aVar.avt() != null && ((aVar.avt().getHide_stat() == 1 && aVar.avt().getBlock_stat() == 1) || (aVar.avt().getHide_stat() == 1 && aVar.avt().getBlock_stat() == 2))) {
            this.ghB.lC(this.mIsHost);
            this.ghB.rV(8);
            this.ghB.Wa();
        } else {
            this.ghB.Wa();
            aVar.blS();
            if (aVar.aIc() != null) {
                z = aVar.aIc().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.bEO = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.JX().a(aVar.getUserData());
            }
            if (this.ggY != null) {
                this.ggY.a(aVar);
            }
            if (this.ghA != null) {
                this.ghA.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ar(aVar.aIc());
            eVar.lq(z);
            this.ghB.rV(0);
            this.ghy.a(aVar, z);
            blQ();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f blu() {
        return this.ghA;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ghy != null) {
                this.ghy.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.ggR = baseFragment;
    }

    public void blQ() {
        if (!this.bEO) {
            if ((this.ggR == null || this.ggR.isPrimary()) && this.ghy != null && (this.ghy.bmi() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.ghy.bmi()).blQ();
            }
        }
    }

    public void bhL() {
        if (this.ghy != null && (this.ghy.bmi() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.ghy.bmi()).bhL();
        }
    }

    public void blR() {
        if (this.ghy != null && this.ghy.WW() != null && (this.ghy.bmi() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.ghy.bmi()).a(this.byH, this.ghy.WW());
            if (this.ghz != null) {
                this.ghy.setOnViewResponseListener(this.ghz);
            }
            this.ghy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void sF(String str) {
        if (!ao.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bjZ() != null && this.ghy != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bjZ = this.mList.get(0).bjZ();
            for (int i = 0; i < bjZ.size() && bjZ.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bjZ.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.ghy.a(i, str, this.ghF);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.asU);
        this.ggY.onDestroy();
        if (this.ghy != null) {
            this.ghy.onDestory();
        }
        bhL();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void fR(boolean z) {
        if (z) {
            if (this.bEO) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                blQ();
                return;
            } else {
                bhL();
                return;
            }
        }
        bhL();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            blQ();
            blR();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.byH.finish();
                return;
            }
            return;
        }
        bhL();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void blv() {
        if (this.ghy != null) {
            this.ghy.blv();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void lB(boolean z) {
        this.ghy.lB(z);
    }

    private void initListener() {
        this.cYF = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bhL();
            }
        };
        this.cYF.setTag(this.asU);
        MessageManager.getInstance().registerListener(this.cYF);
        this.ghD = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.sF((String) customResponsedMessage.getData());
                }
            }
        };
        this.ghD.setTag(this.asU);
        MessageManager.getInstance().registerListener(this.ghD);
        this.ghE = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.sF((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), e.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.ghE.setTag(this.asU);
        MessageManager.getInstance().registerListener(this.ghE);
    }
}
