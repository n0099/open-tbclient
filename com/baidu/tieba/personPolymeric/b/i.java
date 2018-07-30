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
    private BdUniqueId aqv;
    private BaseFragmentActivity bsO;
    private CustomMessageListener cSR;
    private BaseFragment fZA;
    private PersonPolymericModel fZD;
    private g fZH;
    private e gag;
    private p gah;
    private com.baidu.tieba.personPolymeric.event.c gai;
    private f gaj;
    private d gak;
    private PersonPostModel gal;
    private CustomMessageListener gam;
    private CustomMessageListener gan;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean byX = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a gao = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void rV(String str) {
            boolean z;
            if (!ap.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bhD() != null && i.this.gah != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> bhD = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bhD();
                Iterator<com.baidu.adp.widget.ListView.h> it = bhD.iterator();
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
                    i.this.gah.dc(PersonPostModel.mergeDynamicThreadByTime(bhD));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i gap = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bfm();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void rV(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bsO = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.gag = eVar;
        this.aqv = bdUniqueId;
        this.mView = eVar.mRootView;
        this.gal = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.gah = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.gah.Y(this.mView);
        this.gai = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.gai.a(this.gag);
        this.gah.setOnViewResponseListener(this.gai);
        this.gah.a(this);
        resetData();
        this.gah.a(this.gap);
        this.fZH = this.gag.bjc();
        this.gah.P(this.fZH);
        this.fZD = this.gag.bjd();
        this.fZD.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.gak = this.gag.bjg();
        this.gaj = new f(baseFragmentActivity.getPageContext(), this.gag.bjf(), this.gag.bje(), this.gah.Vf(), bdUniqueId);
        this.mList = new ArrayList(2);
        this.mList.add(new com.baidu.tieba.person.data.e());
        this.mList.add(new com.baidu.tieba.person.data.e());
        initListener();
    }

    public void j(final boolean z, boolean z2, boolean z3) {
        if (j.js()) {
            if (!w.z(this.mList) && this.mList.size() >= 2) {
                final com.baidu.tieba.person.data.e eVar = this.mList.get(z ? 1 : 0);
                if (eVar != null) {
                    if (!eVar.bhC() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gah.aAh();
                                i.this.gak.eI(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.fZD != null && this.fZD.bjD() != null && this.fZD.bjD().bjw()) {
                        this.gah.aAh();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.gah.at(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gah.aAh();
                                i.this.gak.eI(true);
                            }
                        }, 800L);
                    } else {
                        this.gak.lh(z2);
                        this.gal.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.gah.aAh();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(d.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.gah.at(null);
                                    i.this.gak.Un();
                                }
                            }
                        });
                        this.gal.fetchPost(this.bsO.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int y;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.gah.aAh();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bhD = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bhD();
                                        if (w.z(bhD)) {
                                            i.this.gak.Un();
                                            return;
                                        } else if (i.this.as(personPostModel.postList)) {
                                            eVar2.kU(false);
                                            i.this.gah.at(bhD);
                                            i.this.gak.c(true, bhD);
                                            return;
                                        } else if (i.dd(personPostModel.postList) == 0) {
                                            eVar2.kU(false);
                                            i.this.gah.at(bhD);
                                            i.this.gak.c(true, bhD);
                                            return;
                                        } else {
                                            bhD.addAll(personPostModel.postList);
                                            i.this.gak.Ay();
                                            eVar2.ar(bhD);
                                            i.this.gah.at(bhD);
                                            return;
                                        }
                                    }
                                    eVar2.kU(true);
                                    eVar2.ar(personPostModel.postList);
                                    i.this.gah.at(personPostModel.postList);
                                    if (eVar2.bhD() != null && (y = w.y(eVar2.bhD())) > 0 && y <= 2) {
                                        for (int i = 0; i < y; i++) {
                                            if (eVar2.bhD().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bhD().get(i)).isHost = i.this.mIsHost;
                                                i.this.gak.Un();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bhD2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bhD();
                                if (!w.z(bhD2)) {
                                    if (i.this.as(personPostModel.postList)) {
                                        eVar.kU(false);
                                        i.this.gah.at(bhD2);
                                        i.this.gak.c(true, bhD2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bhD2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bhD2);
                                    eVar.kU(true);
                                    eVar.ar(mergeDynamicThreadByTime);
                                    i.this.gak.Ay();
                                    i.this.gah.dc(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.gak.Ax();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.gak.Un();
                this.gah.at(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean as(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
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
        if (this.gag != null) {
            this.gag.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void SS() {
        if (this.gag != null) {
            this.gag.SS();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.gal.resetThreadPn();
        if (this.fZD != null) {
            this.fZD.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.gah.aAh();
        this.bsO.hideLoadingView(this.mView);
        if (aVar == null) {
            this.gak.E(TbadkCoreApplication.getInst().getString(d.j.neterror), true);
            this.gak.Un();
            this.gak.ry(8);
        } else if (aVar.Ce() != null && ((aVar.Ce().getHide_stat() == 1 && aVar.Ce().getBlock_stat() == 1) || (aVar.Ce().getHide_stat() == 1 && aVar.Ce().getBlock_stat() == 2))) {
            this.gak.lg(this.mIsHost);
            this.gak.ry(8);
            this.gak.Uk();
        } else {
            this.gak.Uk();
            aVar.bju();
            if (aVar.aFQ() != null) {
                z = aVar.aFQ().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.byX = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.IH().a(aVar.getUserData());
            }
            if (this.fZH != null) {
                this.fZH.a(aVar);
            }
            if (this.gaj != null) {
                this.gaj.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.ar(aVar.aFQ());
            eVar.kU(z);
            this.gak.ry(0);
            this.gah.a(aVar, z);
            bjs();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f biW() {
        return this.gaj;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gah != null) {
                this.gah.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.fZA = baseFragment;
    }

    public void bjs() {
        if (!this.byX) {
            if ((this.fZA == null || this.fZA.isPrimary()) && this.gah != null && (this.gah.bjK() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.gah.bjK()).bjs();
            }
        }
    }

    public void bfm() {
        if (this.gah != null && (this.gah.bjK() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.gah.bjK()).bfm();
        }
    }

    public void bjt() {
        if (this.gah != null && this.gah.Vf() != null && (this.gah.bjK() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.gah.bjK()).a(this.bsO, this.gah.Vf());
            if (this.gai != null) {
                this.gah.setOnViewResponseListener(this.gai);
            }
            this.gah.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void rV(String str) {
        if (!ap.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bhD() != null && this.gah != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bhD = this.mList.get(0).bhD();
            for (int i = 0; i < bhD.size() && bhD.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bhD.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.gah.a(i, str, this.gao);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aqv);
        this.fZH.onDestroy();
        if (this.gah != null) {
            this.gah.onDestory();
        }
        bfm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void fA(boolean z) {
        if (z) {
            if (this.byX) {
                SS();
            }
            if (TbadkCoreApplication.isLogin()) {
                bjs();
                return;
            } else {
                bfm();
                return;
            }
        }
        bfm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bjs();
            bjt();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.bsO.finish();
                return;
            }
            return;
        }
        bfm();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void biX() {
        if (this.gah != null) {
            this.gah.biX();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void lf(boolean z) {
        this.gah.lf(z);
    }

    private void initListener() {
        this.cSR = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bfm();
            }
        };
        this.cSR.setTag(this.aqv);
        MessageManager.getInstance().registerListener(this.cSR);
        this.gam = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rV((String) customResponsedMessage.getData());
                }
            }
        };
        this.gam.setTag(this.aqv);
        MessageManager.getInstance().registerListener(this.gam);
        this.gan = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rV((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), d.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.gan.setTag(this.aqv);
        MessageManager.getInstance().registerListener(this.gan);
    }
}
