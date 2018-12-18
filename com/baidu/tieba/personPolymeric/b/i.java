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
    private BdUniqueId aBS;
    private BaseFragmentActivity bLQ;
    private CustomMessageListener doI;
    private BaseFragment gwI;
    private PersonPolymericModel gwL;
    private g gwP;
    private e gxo;
    private p gxp;
    private com.baidu.tieba.personPolymeric.event.c gxq;
    private f gxr;
    private d gxs;
    private PersonPostModel gxt;
    private CustomMessageListener gxu;
    private CustomMessageListener gxv;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean bRT = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a gxw = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void tM(String str) {
            boolean z;
            if (!ao.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).box() != null && i.this.gxp != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> box = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).box();
                Iterator<com.baidu.adp.widget.ListView.h> it = box.iterator();
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
                    i.this.gxp.dt(PersonPostModel.mergeDynamicThreadByTime(box));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i gxx = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bmm();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void tM(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bLQ = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.gxo = eVar;
        this.aBS = bdUniqueId;
        this.mView = eVar.mRootView;
        this.gxt = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.gxp = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.gxp.initView(this.mView);
        this.gxq = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.gxq.a(this.gxo);
        this.gxp.setOnViewResponseListener(this.gxq);
        this.gxp.a(this);
        resetData();
        this.gxp.a(this.gxx);
        this.gwP = this.gxo.bpY();
        this.gxp.Q(this.gwP);
        this.gwL = this.gxo.bpZ();
        this.gwL.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.gxs = this.gxo.bqc();
        this.gxr = new f(baseFragmentActivity.getPageContext(), this.gxo.bqb(), this.gxo.bqa(), this.gxp.abU(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void j(final boolean z, boolean z2, boolean z3) {
        if (j.kK()) {
            if (!v.I(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bow() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gxp.aGO();
                                i.this.gxs.fD(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.gwL != null && this.gwL.bqz() != null && this.gwL.bqz().bqs()) {
                        this.gxp.aGO();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.gxp.as(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gxp.aGO();
                                i.this.gxs.fD(true);
                            }
                        }, 800L);
                    } else {
                        this.gxs.mi(z2);
                        this.gxt.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.gxp.aGO();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(e.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.gxp.as(null);
                                    i.this.gxs.abb();
                                }
                            }
                        });
                        this.gxt.fetchPost(this.bLQ.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int H;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.gxp.aGO();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> box = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).box();
                                        if (v.I(box)) {
                                            i.this.gxs.abb();
                                            return;
                                        } else if (i.this.ar(personPostModel.postList)) {
                                            eVar2.lV(false);
                                            i.this.gxp.as(box);
                                            i.this.gxs.c(true, box);
                                            return;
                                        } else if (i.du(personPostModel.postList) == 0) {
                                            eVar2.lV(false);
                                            i.this.gxp.as(box);
                                            i.this.gxs.c(true, box);
                                            return;
                                        } else {
                                            box.addAll(personPostModel.postList);
                                            i.this.gxs.Fd();
                                            eVar2.aq(box);
                                            i.this.gxp.as(box);
                                            return;
                                        }
                                    }
                                    eVar2.lV(true);
                                    eVar2.aq(personPostModel.postList);
                                    i.this.gxp.as(personPostModel.postList);
                                    if (eVar2.box() != null && (H = v.H(eVar2.box())) > 0 && H <= 2) {
                                        for (int i = 0; i < H; i++) {
                                            if (eVar2.box().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.box().get(i)).isHost = i.this.mIsHost;
                                                i.this.gxs.abb();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> box2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).box();
                                if (!v.I(box2)) {
                                    if (i.this.ar(personPostModel.postList)) {
                                        eVar.lV(false);
                                        i.this.gxp.as(box2);
                                        i.this.gxs.c(true, box2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    box2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(box2);
                                    eVar.lV(true);
                                    eVar.aq(mergeDynamicThreadByTime);
                                    i.this.gxs.Fd();
                                    i.this.gxp.dt(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.gxs.Fc();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.gxs.abb();
                this.gxp.as(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ar(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int H = v.H(arrayList);
        if (H != 0) {
            if (H > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int du(List<com.baidu.adp.widget.ListView.h> list) {
        int i = 0;
        if (v.H(list) == 0) {
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
        if (v.H(arrayList) == 0) {
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
        if (this.gxo != null) {
            this.gxo.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.gxo != null) {
            this.gxo.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.gxt.resetThreadPn();
        if (this.gwL != null) {
            this.gwL.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.gxp.aGO();
        this.bLQ.hideLoadingView(this.mView);
        if (aVar == null) {
            this.gxs.O(TbadkCoreApplication.getInst().getString(e.j.neterror), true);
            this.gxs.abb();
            this.gxs.tf(8);
        } else if (aVar.azX() != null && ((aVar.azX().getHide_stat() == 1 && aVar.azX().getBlock_stat() == 1) || (aVar.azX().getHide_stat() == 1 && aVar.azX().getBlock_stat() == 2))) {
            this.gxs.mh(this.mIsHost);
            this.gxs.tf(8);
            this.gxs.aaY();
        } else {
            this.gxs.aaY();
            aVar.bqq();
            if (aVar.aMJ() != null) {
                z = aVar.aMJ().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.bRT = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.Nl().a(aVar.getUserData());
            }
            if (this.gwP != null) {
                this.gwP.a(aVar);
            }
            if (this.gxr != null) {
                this.gxr.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.aq(aVar.aMJ());
            eVar.lV(z);
            this.gxs.tf(0);
            this.gxp.a(aVar, z);
            bqo();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bpS() {
        return this.gxr;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gxp != null) {
                this.gxp.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.gwI = baseFragment;
    }

    public void bqo() {
        if (!this.bRT) {
            if ((this.gwI == null || this.gwI.isPrimary()) && this.gxp != null && (this.gxp.bqG() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.gxp.bqG()).bqo();
            }
        }
    }

    public void bmm() {
        if (this.gxp != null && (this.gxp.bqG() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.gxp.bqG()).bmm();
        }
    }

    public void bqp() {
        if (this.gxp != null && this.gxp.abU() != null && (this.gxp.bqG() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.gxp.bqG()).a(this.bLQ, this.gxp.abU());
            if (this.gxq != null) {
                this.gxp.setOnViewResponseListener(this.gxq);
            }
            this.gxp.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void tM(String str) {
        if (!ao.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).box() != null && this.gxp != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> box = this.mList.get(0).box();
            for (int i = 0; i < box.size() && box.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = box.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.gxp.a(i, str, this.gxw);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBS);
        this.gwP.onDestroy();
        if (this.gxp != null) {
            this.gxp.onDestory();
        }
        bmm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void gu(boolean z) {
        if (z) {
            if (this.bRT) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                bqo();
                return;
            } else {
                bmm();
                return;
            }
        }
        bmm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bqo();
            bqp();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.bLQ.finish();
                return;
            }
            return;
        }
        bmm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void tK(String str) {
        if (this.gxp != null) {
            this.gxp.tK(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void tL(String str) {
        if (this.gxp != null) {
            this.gxp.tL(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bpT() {
        if (this.gxp != null) {
            this.gxp.bpT();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void mg(boolean z) {
        this.gxp.mg(z);
    }

    private void initListener() {
        this.doI = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bmm();
            }
        };
        this.doI.setTag(this.aBS);
        MessageManager.getInstance().registerListener(this.doI);
        this.gxu = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.tM((String) customResponsedMessage.getData());
                }
            }
        };
        this.gxu.setTag(this.aBS);
        MessageManager.getInstance().registerListener(this.gxu);
        this.gxv = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.tM((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), e.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.gxv.setTag(this.aBS);
        MessageManager.getInstance().registerListener(this.gxv);
    }
}
