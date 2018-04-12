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
    private BdUniqueId aBK;
    private TbPageContext adf;
    private CustomMessageListener cHV;
    private BaseFragmentActivity epn;
    private BaseFragment fII;
    private PersonPolymericModel fIL;
    private g fIP;
    private e fJp;
    private p fJq;
    private com.baidu.tieba.personPolymeric.event.c fJr;
    private f fJs;
    private d fJt;
    private PersonPostModel fJu;
    private CustomMessageListener fJv;
    private CustomMessageListener fJw;
    private CustomMessageListener fJx;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean bvq = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a fJy = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void ri(String str) {
            boolean z;
            if (!an.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bdE() != null && i.this.fJq != null) {
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
                    i.this.fJq.cU(PersonPostModel.mergeDynamicThreadByTime(bdE));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i fJz = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.7
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
        void ri(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.epn = baseFragmentActivity;
        this.adf = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.fJp = eVar;
        this.aBK = bdUniqueId;
        this.mView = eVar.mRootView;
        this.fJu = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.fJq = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.fJq.Y(this.mView);
        this.fJr = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.fJr.a(this.fJp);
        this.fJq.setOnViewResponseListener(this.fJr);
        this.fJq.a(this);
        resetData();
        this.fJq.a(this.fJz);
        this.fIP = this.fJp.bfd();
        this.fJq.N(this.fIP);
        this.fIL = this.fJp.bfe();
        this.fIL.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.fJt = this.fJp.bfh();
        this.fJs = new f(baseFragmentActivity.getPageContext(), this.fJp.bfg(), this.fJp.bff(), this.fJq.Rg(), bdUniqueId);
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
                                i.this.fJq.auL();
                                i.this.fJt.eC(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.fIL != null && this.fIL.bfF() != null && this.fIL.bfF().bfy()) {
                        this.fJq.auL();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.fJq.ar(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.fJq.auL();
                                i.this.fJt.eC(true);
                            }
                        }, 800L);
                    } else {
                        this.fJt.le(z2);
                        this.fJu.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.fJq.auL();
                                if (personPostModel != null) {
                                    l.showToast(i.this.adf.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.adf.getContext(), i.this.adf.getString(d.k.data_load_error));
                                }
                                if (z4) {
                                    i.this.fJq.ar(null);
                                    i.this.fJt.Qq();
                                }
                            }
                        });
                        this.fJu.fetchPost(this.epn.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.6
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int v;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.adf.getContext(), personPostModel.getErrorString());
                                }
                                i.this.fJq.auL();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bdE = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bdE();
                                        if (v.w(bdE)) {
                                            i.this.fJt.Qq();
                                            return;
                                        } else if (i.this.aq(personPostModel.postList)) {
                                            eVar2.kR(false);
                                            i.this.fJq.ar(bdE);
                                            i.this.fJt.b(true, bdE);
                                            return;
                                        } else if (i.cV(personPostModel.postList) == 0) {
                                            eVar2.kR(false);
                                            i.this.fJq.ar(bdE);
                                            i.this.fJt.b(true, bdE);
                                            return;
                                        } else {
                                            bdE.addAll(personPostModel.postList);
                                            i.this.fJt.wS();
                                            eVar2.ap(bdE);
                                            i.this.fJq.ar(bdE);
                                            return;
                                        }
                                    }
                                    eVar2.kR(true);
                                    eVar2.ap(personPostModel.postList);
                                    i.this.fJq.ar(personPostModel.postList);
                                    if (eVar2.bdE() != null && (v = v.v(eVar2.bdE())) > 0 && v <= 2) {
                                        for (int i = 0; i < v; i++) {
                                            if (eVar2.bdE().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bdE().get(i)).isHost = i.this.mIsHost;
                                                i.this.fJt.Qq();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bdE2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bdE();
                                if (!v.w(bdE2)) {
                                    if (i.this.aq(personPostModel.postList)) {
                                        eVar.kR(false);
                                        i.this.fJq.ar(bdE2);
                                        i.this.fJt.b(true, bdE2);
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
                                    eVar.kR(true);
                                    eVar.ap(mergeDynamicThreadByTime);
                                    i.this.fJt.wS();
                                    i.this.fJq.cU(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.fJt.wR();
        } else {
            l.showToast(this.adf.getContext(), this.adf.getString(d.k.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.fJt.Qq();
                this.fJq.ar(arrayList2);
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

    public static int cV(List<com.baidu.adp.widget.ListView.h> list) {
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
        if (this.fJp != null) {
            this.fJp.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void h(boolean z, boolean z2, boolean z3) {
        k(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void OT() {
        if (this.fJp != null) {
            this.fJp.OT();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.fJu.resetThreadPn();
        if (this.fIL != null) {
            this.fIL.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.fJq.auL();
        this.epn.hideLoadingView(this.mView);
        if (aVar == null) {
            this.fJt.E(TbadkCoreApplication.getInst().getString(d.k.neterror), true);
            this.fJt.Qq();
            this.fJt.ri(8);
        } else if (aVar.aWk() != null && ((aVar.aWk().getHide_stat() == 1 && aVar.aWk().getBlock_stat() == 1) || (aVar.aWk().getHide_stat() == 1 && aVar.aWk().getBlock_stat() == 2))) {
            this.fJt.ld(this.mIsHost);
            this.fJt.ri(8);
            this.fJt.Qn();
        } else {
            this.fJt.Qn();
            aVar.bfw();
            if (aVar.azn() != null) {
                z = aVar.azn().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.bvq = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.ES().a(aVar.getUserData());
            }
            if (this.fIP != null) {
                this.fIP.a(aVar);
            }
            if (this.fJs != null) {
                this.fJs.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ap(aVar.azn());
            eVar.kR(z);
            this.fJt.ri(0);
            this.fJq.a(aVar, z);
            bft();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f beX() {
        return this.fJs;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.fJq != null) {
                this.fJq.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.fII = baseFragment;
    }

    public void bft() {
        if (!this.bvq) {
            if ((this.fII == null || this.fII.isPrimary()) && this.fJq != null && (this.fJq.bfN() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.fJq.bfN()).bft();
            }
        }
    }

    public void bbm() {
        if (this.fJq != null && (this.fJq.bfN() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.fJq.bfN()).bbm();
        }
    }

    public void bfu() {
        if (this.fJq != null && this.fJq.Rg() != null && (this.fJq.bfN() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.fJq.bfN()).a(this.epn, this.fJq.Rg());
            if (this.fJr != null) {
                this.fJq.setOnViewResponseListener(this.fJr);
            }
            this.fJq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void ri(String str) {
        if (!an.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bdE() != null && this.fJq != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bdE = this.mList.get(0).bdE();
            for (int i = 0; i < bdE.size() && bdE.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bdE.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && an.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.fJq.a(i, str, this.fJy);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBK);
        this.fIP.onDestroy();
        if (this.fJq != null) {
            this.fJq.onDestory();
        }
        bbm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void fV(boolean z) {
        if (z) {
            if (this.bvq) {
                OT();
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
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.adf.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.epn.finish();
                return;
            }
            return;
        }
        bbm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void beY() {
        if (this.fJq != null) {
            this.fJq.beY();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void lc(boolean z) {
        this.fJq.lc(z);
    }

    private void initListener() {
        this.cHV = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bbm();
            }
        };
        this.cHV.setTag(this.aBK);
        MessageManager.getInstance().registerListener(this.cHV);
        this.fJv = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.ri((String) customResponsedMessage.getData());
                }
            }
        };
        this.fJv.setTag(this.aBK);
        MessageManager.getInstance().registerListener(this.fJv);
        this.fJw = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.ri((String) customResponsedMessage.getData());
                    l.showToast(i.this.adf.getPageActivity(), d.k.person_polymeric_set_privacy_success);
                }
            }
        };
        this.fJw.setTag(this.aBK);
        MessageManager.getInstance().registerListener(this.fJw);
        this.fJx = new CustomMessageListener(2016559) { // from class: com.baidu.tieba.personPolymeric.b.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && i.this.fJq != null) {
                    i.this.fJq.bfQ();
                }
            }
        };
        this.fJx.setTag(this.aBK);
        MessageManager.getInstance().registerListener(this.fJx);
    }
}
