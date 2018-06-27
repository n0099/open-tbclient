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
import com.baidu.tbadk.core.util.ap;
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
    private BdUniqueId aqU;
    private BaseFragmentActivity bsf;
    private CustomMessageListener cQf;
    private e fZP;
    private p fZQ;
    private com.baidu.tieba.personPolymeric.event.c fZR;
    private f fZS;
    private d fZT;
    private PersonPostModel fZU;
    private CustomMessageListener fZV;
    private CustomMessageListener fZW;
    private BaseFragment fZi;
    private PersonPolymericModel fZl;
    private g fZp;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean byr = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a fZX = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void sb(String str) {
            boolean z;
            if (!ap.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bjk() != null && i.this.fZQ != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> bjk = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bjk();
                Iterator<com.baidu.adp.widget.ListView.h> it = bjk.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    com.baidu.adp.widget.ListView.h next = it.next();
                    if ((next instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) next).threadId)) {
                        it.remove();
                        z = true;
                        break;
                    }
                }
                if (z) {
                    i.this.fZQ.dg(PersonPostModel.mergeDynamicThreadByTime(bjk));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i fZY = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bgT();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void sb(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bsf = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.fZP = eVar;
        this.aqU = bdUniqueId;
        this.mView = eVar.mRootView;
        this.fZU = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.fZQ = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.fZQ.W(this.mView);
        this.fZR = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.fZR.a(this.fZP);
        this.fZQ.setOnViewResponseListener(this.fZR);
        this.fZQ.a(this);
        resetData();
        this.fZQ.a(this.fZY);
        this.fZp = this.fZP.bkI();
        this.fZQ.R(this.fZp);
        this.fZl = this.fZP.bkJ();
        this.fZl.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.fZT = this.fZP.bkM();
        this.fZS = new f(baseFragmentActivity.getPageContext(), this.fZP.bkL(), this.fZP.bkK(), this.fZQ.UW(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void k(final boolean z, boolean z2, boolean z3) {
        if (j.jr()) {
            if (!w.A(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bjj() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fZQ.azA();
                                i.this.fZT.eH(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.fZl != null && this.fZl.blj() != null && this.fZl.blj().blc()) {
                        this.fZQ.azA();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.fZQ.av(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fZQ.azA();
                                i.this.fZT.eH(true);
                            }
                        }, 800L);
                    } else {
                        this.fZT.lv(z2);
                        this.fZU.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.fZQ.azA();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(d.k.data_load_error));
                                }
                                if (z4) {
                                    i.this.fZQ.av(null);
                                    i.this.fZT.Uf();
                                }
                            }
                        });
                        this.fZU.fetchPost(this.bsf.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int z5;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.fZQ.azA();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bjk = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bjk();
                                        if (w.A(bjk)) {
                                            i.this.fZT.Uf();
                                            return;
                                        } else if (i.this.au(personPostModel.postList)) {
                                            eVar2.li(false);
                                            i.this.fZQ.av(bjk);
                                            i.this.fZT.c(true, bjk);
                                            return;
                                        } else if (i.dh(personPostModel.postList) == 0) {
                                            eVar2.li(false);
                                            i.this.fZQ.av(bjk);
                                            i.this.fZT.c(true, bjk);
                                            return;
                                        } else {
                                            bjk.addAll(personPostModel.postList);
                                            i.this.fZT.AI();
                                            eVar2.at(bjk);
                                            i.this.fZQ.av(bjk);
                                            return;
                                        }
                                    }
                                    eVar2.li(true);
                                    eVar2.at(personPostModel.postList);
                                    i.this.fZQ.av(personPostModel.postList);
                                    if (eVar2.bjk() != null && (z5 = w.z(eVar2.bjk())) > 0 && z5 <= 2) {
                                        for (int i = 0; i < z5; i++) {
                                            if (eVar2.bjk().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bjk().get(i)).isHost = i.this.mIsHost;
                                                i.this.fZT.Uf();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bjk2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bjk();
                                if (!w.A(bjk2)) {
                                    if (i.this.au(personPostModel.postList)) {
                                        eVar.li(false);
                                        i.this.fZQ.av(bjk2);
                                        i.this.fZT.c(true, bjk2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bjk2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bjk2);
                                    eVar.li(true);
                                    eVar.at(mergeDynamicThreadByTime);
                                    i.this.fZT.AI();
                                    i.this.fZQ.dg(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.fZT.AH();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.k.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.fZT.Uf();
                this.fZQ.av(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean au(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int z = w.z(arrayList);
        if (z != 0) {
            if (z > 2) {
                return false;
            }
            if (!(arrayList.get(0) instanceof com.baidu.tieba.personPolymeric.c.i) && !(arrayList.get(1) instanceof com.baidu.tieba.personPolymeric.c.i)) {
                return false;
            }
        }
        return true;
    }

    public static int dh(List<com.baidu.adp.widget.ListView.h> list) {
        int i = 0;
        if (w.z(list) == 0) {
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
        if (w.z(arrayList) == 0) {
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
        if (this.fZP != null) {
            this.fZP.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void h(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void SK() {
        if (this.fZP != null) {
            this.fZP.SK();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fZU.resetThreadPn();
        if (this.fZl != null) {
            this.fZl.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.fZQ.azA();
        this.bsf.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fZT.F(TbadkCoreApplication.getInst().getString(d.k.neterror), true);
            this.fZT.Uf();
            this.fZT.rB(8);
        } else if (aVar.Cm() != null && ((aVar.Cm().getHide_stat() == 1 && aVar.Cm().getBlock_stat() == 1) || (aVar.Cm().getHide_stat() == 1 && aVar.Cm().getBlock_stat() == 2))) {
            this.fZT.lu(this.mIsHost);
            this.fZT.rB(8);
            this.fZT.Uc();
        } else {
            this.fZT.Uc();
            aVar.bla();
            if (aVar.aEQ() != null) {
                z = aVar.aEQ().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.byr = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.IM().a(aVar.getUserData());
            }
            if (this.fZp != null) {
                this.fZp.a(aVar);
            }
            if (this.fZS != null) {
                this.fZS.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.at(aVar.aEQ());
            eVar.li(z);
            this.fZT.rB(0);
            this.fZQ.a(aVar, z);
            bkY();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bkC() {
        return this.fZS;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fZQ != null) {
                this.fZQ.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.fZi = baseFragment;
    }

    public void bkY() {
        if (!this.byr) {
            if ((this.fZi == null || this.fZi.isPrimary()) && this.fZQ != null && (this.fZQ.blq() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fZQ.blq()).bkY();
            }
        }
    }

    public void bgT() {
        if (this.fZQ != null && (this.fZQ.blq() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fZQ.blq()).bgT();
        }
    }

    public void bkZ() {
        if (this.fZQ != null && this.fZQ.UW() != null && (this.fZQ.blq() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.fZQ.blq()).a(this.bsf, this.fZQ.UW());
            if (this.fZR != null) {
                this.fZQ.setOnViewResponseListener(this.fZR);
            }
            this.fZQ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void sb(String str) {
        if (!ap.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bjk() != null && this.fZQ != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bjk = this.mList.get(0).bjk();
            for (int i = 0; i < bjk.size() && bjk.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bjk.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.fZQ.a(i, str, this.fZX);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aqU);
        this.fZp.onDestroy();
        if (this.fZQ != null) {
            this.fZQ.onDestory();
        }
        bgT();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void fy(boolean z) {
        if (z) {
            if (this.byr) {
                SK();
            }
            if (TbadkCoreApplication.isLogin()) {
                bkY();
                return;
            } else {
                bgT();
                return;
            }
        }
        bgT();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bkY();
            bkZ();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.bsf.finish();
                return;
            }
            return;
        }
        bgT();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bkD() {
        if (this.fZQ != null) {
            this.fZQ.bkD();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void lt(boolean z) {
        this.fZQ.lt(z);
    }

    private void initListener() {
        this.cQf = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bgT();
            }
        };
        this.cQf.setTag(this.aqU);
        MessageManager.getInstance().registerListener(this.cQf);
        this.fZV = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.sb((String) customResponsedMessage.getData());
                }
            }
        };
        this.fZV.setTag(this.aqU);
        MessageManager.getInstance().registerListener(this.fZV);
        this.fZW = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.sb((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), d.k.person_polymeric_set_privacy_success);
                }
            }
        };
        this.fZW.setTag(this.aqU);
        MessageManager.getInstance().registerListener(this.fZW);
    }
}
