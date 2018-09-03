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
import com.baidu.tieba.f;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class i implements com.baidu.tieba.model.a, com.baidu.tieba.personPolymeric.b.a {
    private BdUniqueId aqw;
    private BaseFragmentActivity bsQ;
    private CustomMessageListener cSO;
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
    private boolean byZ = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a gao = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void rY(String str) {
            boolean z;
            if (!ap.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bhy() != null && i.this.gah != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> bhy = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bhy();
                Iterator<com.baidu.adp.widget.ListView.h> it = bhy.iterator();
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
                    i.this.gah.dc(PersonPostModel.mergeDynamicThreadByTime(bhy));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i gap = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bfh();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void rY(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bsQ = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.gag = eVar;
        this.aqw = bdUniqueId;
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
        this.fZH = this.gag.biZ();
        this.gah.P(this.fZH);
        this.fZD = this.gag.bja();
        this.fZD.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.gak = this.gag.bjd();
        this.gaj = new f(baseFragmentActivity.getPageContext(), this.gag.bjc(), this.gag.bjb(), this.gah.Vj(), bdUniqueId);
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
                    if (!eVar.bhx() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gah.aAe();
                                i.this.gak.eI(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.fZD != null && this.fZD.bjA() != null && this.fZD.bjA().bjt()) {
                        this.gah.aAe();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.gah.at(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gah.aAe();
                                i.this.gak.eI(true);
                            }
                        }, 800L);
                    } else {
                        this.gak.lh(z2);
                        this.gal.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.gah.aAe();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(f.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.gah.at(null);
                                    i.this.gak.Uq();
                                }
                            }
                        });
                        this.gal.fetchPost(this.bsQ.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int y;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.gah.aAe();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bhy = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bhy();
                                        if (w.z(bhy)) {
                                            i.this.gak.Uq();
                                            return;
                                        } else if (i.this.as(personPostModel.postList)) {
                                            eVar2.kU(false);
                                            i.this.gah.at(bhy);
                                            i.this.gak.c(true, bhy);
                                            return;
                                        } else if (i.dd(personPostModel.postList) == 0) {
                                            eVar2.kU(false);
                                            i.this.gah.at(bhy);
                                            i.this.gak.c(true, bhy);
                                            return;
                                        } else {
                                            bhy.addAll(personPostModel.postList);
                                            i.this.gak.Aw();
                                            eVar2.ar(bhy);
                                            i.this.gah.at(bhy);
                                            return;
                                        }
                                    }
                                    eVar2.kU(true);
                                    eVar2.ar(personPostModel.postList);
                                    i.this.gah.at(personPostModel.postList);
                                    if (eVar2.bhy() != null && (y = w.y(eVar2.bhy())) > 0 && y <= 2) {
                                        for (int i = 0; i < y; i++) {
                                            if (eVar2.bhy().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bhy().get(i)).isHost = i.this.mIsHost;
                                                i.this.gak.Uq();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bhy2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bhy();
                                if (!w.z(bhy2)) {
                                    if (i.this.as(personPostModel.postList)) {
                                        eVar.kU(false);
                                        i.this.gah.at(bhy2);
                                        i.this.gak.c(true, bhy2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bhy2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bhy2);
                                    eVar.kU(true);
                                    eVar.ar(mergeDynamicThreadByTime);
                                    i.this.gak.Aw();
                                    i.this.gah.dc(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.gak.Av();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(f.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.gak.Uq();
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
    public void loadData() {
        if (this.gag != null) {
            this.gag.loadData();
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
        this.gah.aAe();
        this.bsQ.hideLoadingView(this.mView);
        if (aVar == null) {
            this.gak.E(TbadkCoreApplication.getInst().getString(f.j.neterror), true);
            this.gak.Uq();
            this.gak.ry(8);
        } else if (aVar.Cb() != null && ((aVar.Cb().getHide_stat() == 1 && aVar.Cb().getBlock_stat() == 1) || (aVar.Cb().getHide_stat() == 1 && aVar.Cb().getBlock_stat() == 2))) {
            this.gak.lg(this.mIsHost);
            this.gak.ry(8);
            this.gak.Un();
        } else {
            this.gak.Un();
            aVar.bjr();
            if (aVar.aFN() != null) {
                z = aVar.aFN().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.byZ = false;
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
            eVar.ar(aVar.aFN());
            eVar.kU(z);
            this.gak.ry(0);
            this.gah.a(aVar, z);
            bjp();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f biT() {
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

    public void bjp() {
        if (!this.byZ) {
            if ((this.fZA == null || this.fZA.isPrimary()) && this.gah != null && (this.gah.bjH() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.gah.bjH()).bjp();
            }
        }
    }

    public void bfh() {
        if (this.gah != null && (this.gah.bjH() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.gah.bjH()).bfh();
        }
    }

    public void bjq() {
        if (this.gah != null && this.gah.Vj() != null && (this.gah.bjH() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.gah.bjH()).a(this.bsQ, this.gah.Vj());
            if (this.gai != null) {
                this.gah.setOnViewResponseListener(this.gai);
            }
            this.gah.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void rY(String str) {
        if (!ap.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bhy() != null && this.gah != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bhy = this.mList.get(0).bhy();
            for (int i = 0; i < bhy.size() && bhy.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bhy.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ap.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.gah.a(i, str, this.gao);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aqw);
        this.fZH.onDestroy();
        if (this.gah != null) {
            this.gah.onDestory();
        }
        bfh();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void fA(boolean z) {
        if (z) {
            if (this.byZ) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                bjp();
                return;
            } else {
                bfh();
                return;
            }
        }
        bfh();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bjp();
            bjq();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.bsQ.finish();
                return;
            }
            return;
        }
        bfh();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void biU() {
        if (this.gah != null) {
            this.gah.biU();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void lf(boolean z) {
        this.gah.lf(z);
    }

    private void initListener() {
        this.cSO = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bfh();
            }
        };
        this.cSO.setTag(this.aqw);
        MessageManager.getInstance().registerListener(this.cSO);
        this.gam = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rY((String) customResponsedMessage.getData());
                }
            }
        };
        this.gam.setTag(this.aqw);
        MessageManager.getInstance().registerListener(this.gam);
        this.gan = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.rY((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), f.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.gan.setTag(this.aqw);
        MessageManager.getInstance().registerListener(this.gan);
    }
}
