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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
    private BdUniqueId aBL;
    private BaseFragmentActivity biB;
    private CustomMessageListener cJb;
    private BaseFragment fJL;
    private PersonPolymericModel fJO;
    private g fJS;
    private CustomMessageListener fKA;
    private e fKs;
    private p fKt;
    private com.baidu.tieba.personPolymeric.event.c fKu;
    private f fKv;
    private d fKw;
    private PersonPostModel fKx;
    private CustomMessageListener fKy;
    private CustomMessageListener fKz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean bwa = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a fKB = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void rl(String str) {
            boolean z;
            if (!an.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bdE() != null && i.this.fKt != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> bdE = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bdE();
                Iterator<com.baidu.adp.widget.ListView.h> it = bdE.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && an.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    i.this.fKt.cX(PersonPostModel.mergeDynamicThreadByTime(bdE));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i fKC = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.7
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bbm();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void rl(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.biB = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.fKs = eVar;
        this.aBL = bdUniqueId;
        this.mView = eVar.mRootView;
        this.fKx = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.fKt = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.fKt.Y(this.mView);
        this.fKu = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.fKu.a(this.fKs);
        this.fKt.setOnViewResponseListener(this.fKu);
        this.fKt.a(this);
        resetData();
        this.fKt.a(this.fKC);
        this.fJS = this.fKs.bfd();
        this.fKt.N(this.fJS);
        this.fJO = this.fKs.bfe();
        this.fJO.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.fKw = this.fKs.bfh();
        this.fKv = new f(baseFragmentActivity.getPageContext(), this.fKs.bfg(), this.fKs.bff(), this.fKt.Rd(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void k(final boolean z, boolean z2, boolean z3) {
        if (com.baidu.adp.lib.util.j.gD()) {
            if (!v.w(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bdD() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fKt.auK();
                                i.this.fKw.eD(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.fJO != null && this.fJO.bfF() != null && this.fJO.bfF().bfy()) {
                        this.fKt.auK();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.fKt.ar(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fKt.auK();
                                i.this.fKw.eD(true);
                            }
                        }, 800L);
                    } else {
                        this.fKw.lf(z2);
                        this.fKx.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.fKt.auK();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(d.k.data_load_error));
                                }
                                if (z4) {
                                    i.this.fKt.ar(null);
                                    i.this.fKw.Qn();
                                }
                            }
                        });
                        this.fKx.fetchPost(this.biB.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.6
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int v;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.fKt.auK();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bdE = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bdE();
                                        if (v.w(bdE)) {
                                            i.this.fKw.Qn();
                                            return;
                                        } else if (i.this.aq(personPostModel.postList)) {
                                            eVar2.kS(false);
                                            i.this.fKt.ar(bdE);
                                            i.this.fKw.b(true, bdE);
                                            return;
                                        } else if (i.cY(personPostModel.postList) == 0) {
                                            eVar2.kS(false);
                                            i.this.fKt.ar(bdE);
                                            i.this.fKw.b(true, bdE);
                                            return;
                                        } else {
                                            bdE.addAll(personPostModel.postList);
                                            i.this.fKw.wR();
                                            eVar2.ap(bdE);
                                            i.this.fKt.ar(bdE);
                                            return;
                                        }
                                    }
                                    eVar2.kS(true);
                                    eVar2.ap(personPostModel.postList);
                                    i.this.fKt.ar(personPostModel.postList);
                                    if (eVar2.bdE() != null && (v = v.v(eVar2.bdE())) > 0 && v <= 2) {
                                        for (int i = 0; i < v; i++) {
                                            if (eVar2.bdE().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bdE().get(i)).isHost = i.this.mIsHost;
                                                i.this.fKw.Qn();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bdE2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bdE();
                                if (!v.w(bdE2)) {
                                    if (i.this.aq(personPostModel.postList)) {
                                        eVar.kS(false);
                                        i.this.fKt.ar(bdE2);
                                        i.this.fKw.b(true, bdE2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bdE2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bdE2);
                                    eVar.kS(true);
                                    eVar.ap(mergeDynamicThreadByTime);
                                    i.this.fKw.wR();
                                    i.this.fKt.cX(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.fKw.wQ();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.k.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.fKw.Qn();
                this.fKt.ar(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aq(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int v = v.v(arrayList);
        if (v != 0) {
            if (v > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int cY(List<com.baidu.adp.widget.ListView.h> list) {
        int i = 0;
        if (v.v(list) == 0) {
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
        if (v.v(arrayList) == 0) {
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
        if (this.fKs != null) {
            this.fKs.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void h(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void OQ() {
        if (this.fKs != null) {
            this.fKs.OQ();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fKx.resetThreadPn();
        if (this.fJO != null) {
            this.fJO.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.fKt.auK();
        this.biB.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fKw.E(TbadkCoreApplication.getInst().getString(d.k.neterror), true);
            this.fKw.Qn();
            this.fKw.rg(8);
        } else if (aVar.aWk() != null && ((aVar.aWk().getHide_stat() == 1 && aVar.aWk().getBlock_stat() == 1) || (aVar.aWk().getHide_stat() == 1 && aVar.aWk().getBlock_stat() == 2))) {
            this.fKw.le(this.mIsHost);
            this.fKw.rg(8);
            this.fKw.Qk();
        } else {
            this.fKw.Qk();
            aVar.bfw();
            if (aVar.azl() != null) {
                z = aVar.azl().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.bwa = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.EQ().a(aVar.getUserData());
            }
            if (this.fJS != null) {
                this.fJS.a(aVar);
            }
            if (this.fKv != null) {
                this.fKv.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ap(aVar.azl());
            eVar.kS(z);
            this.fKw.rg(0);
            this.fKt.a(aVar, z);
            bft();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f beX() {
        return this.fKv;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fKt != null) {
                this.fKt.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.fJL = baseFragment;
    }

    public void bft() {
        if (!this.bwa) {
            if ((this.fJL == null || this.fJL.isPrimary()) && this.fKt != null && (this.fKt.bfN() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fKt.bfN()).bft();
            }
        }
    }

    public void bbm() {
        if (this.fKt != null && (this.fKt.bfN() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fKt.bfN()).bbm();
        }
    }

    public void bfu() {
        if (this.fKt != null && this.fKt.Rd() != null && (this.fKt.bfN() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.fKt.bfN()).a(this.biB, this.fKt.Rd());
            if (this.fKu != null) {
                this.fKt.setOnViewResponseListener(this.fKu);
            }
            this.fKt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void rl(String str) {
        if (!an.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bdE() != null && this.fKt != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bdE = this.mList.get(0).bdE();
            for (int i = 0; i < bdE.size() && bdE.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bdE.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && an.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.fKt.a(i, str, this.fKB);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBL);
        this.fJS.onDestroy();
        if (this.fKt != null) {
            this.fKt.onDestory();
        }
        bbm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void fW(boolean z) {
        if (z) {
            if (this.bwa) {
                OQ();
            }
            if (TbadkCoreApplication.isLogin()) {
                bft();
                return;
            } else {
                bbm();
                return;
            }
        }
        bbm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bft();
            bfu();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.biB.finish();
                return;
            }
            return;
        }
        bbm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void beY() {
        if (this.fKt != null) {
            this.fKt.beY();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void ld(boolean z) {
        this.fKt.ld(z);
    }

    private void initListener() {
        this.cJb = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bbm();
            }
        };
        this.cJb.setTag(this.aBL);
        MessageManager.getInstance().registerListener(this.cJb);
        this.fKy = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rl((String) customResponsedMessage.getData());
                }
            }
        };
        this.fKy.setTag(this.aBL);
        MessageManager.getInstance().registerListener(this.fKy);
        this.fKz = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rl((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), d.k.person_polymeric_set_privacy_success);
                }
            }
        };
        this.fKz.setTag(this.aBL);
        MessageManager.getInstance().registerListener(this.fKz);
        this.fKA = new CustomMessageListener(2016559) { // from class: com.baidu.tieba.personPolymeric.b.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && i.this.fKt != null) {
                    i.this.fKt.bfQ();
                }
            }
        };
        this.fKA.setTag(this.aBL);
        MessageManager.getInstance().registerListener(this.fKA);
    }
}
