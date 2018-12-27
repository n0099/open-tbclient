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
    private BaseFragmentActivity bLT;
    private CustomMessageListener dry;
    private e gAf;
    private p gAg;
    private com.baidu.tieba.personPolymeric.event.c gAh;
    private f gAi;
    private d gAj;
    private PersonPostModel gAk;
    private CustomMessageListener gAl;
    private CustomMessageListener gAm;
    private PersonPolymericModel gzC;
    private g gzG;
    private BaseFragment gzz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.e> mList;
    private long mUserId;
    private View mView;
    private boolean bRW = true;
    private int mSex = 1;
    private int mSkinType = 3;
    private a gAn = new a() { // from class: com.baidu.tieba.personPolymeric.b.i.1
        @Override // com.baidu.tieba.personPolymeric.b.i.a
        public void tP(String str) {
            boolean z;
            if (!ao.isEmpty(str) && i.this.mList != null && i.this.mList.get(0) != null && ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bpj() != null && i.this.gAg != null) {
                ArrayList<com.baidu.adp.widget.ListView.h> bpj = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bpj();
                Iterator<com.baidu.adp.widget.ListView.h> it = bpj.iterator();
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
                    i.this.gAg.du(PersonPostModel.mergeDynamicThreadByTime(bpj));
                }
            }
        }
    };
    private final com.baidu.tieba.view.i gAo = new com.baidu.tieba.view.i() { // from class: com.baidu.tieba.personPolymeric.b.i.6
        @Override // com.baidu.tieba.view.i
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                i.this.bmY();
            }
        }

        @Override // com.baidu.tieba.view.i
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void tP(String str);
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(BaseFragmentActivity baseFragmentActivity, e eVar, BdUniqueId bdUniqueId, long j, boolean z, boolean z2) {
        this.bLT = baseFragmentActivity;
        this.mContext = baseFragmentActivity.getPageContext();
        this.mUserId = j;
        this.mIsHost = z;
        this.gAf = eVar;
        this.aBS = bdUniqueId;
        this.mView = eVar.mRootView;
        this.gAk = new PersonPostModel(baseFragmentActivity.getPageContext(), bdUniqueId, null, this.mIsHost, PersonPostModel.FROM_PERSON_POLYMERIC);
        this.gAg = new p(baseFragmentActivity.getPageContext(), eVar, bdUniqueId, z, z2);
        this.gAg.initView(this.mView);
        this.gAh = new com.baidu.tieba.personPolymeric.event.c(baseFragmentActivity.getPageContext());
        this.gAh.a(this.gAf);
        this.gAg.setOnViewResponseListener(this.gAh);
        this.gAg.a(this);
        resetData();
        this.gAg.a(this.gAo);
        this.gzG = this.gAf.bqK();
        this.gAg.Q(this.gzG);
        this.gzC = this.gAf.bqL();
        this.gzC.d(new com.baidu.tieba.personPolymeric.c.p(z));
        this.gAj = this.gAf.bqO();
        this.gAi = new f(baseFragmentActivity.getPageContext(), this.gAf.bqN(), this.gAf.bqM(), this.gAg.abW(), bdUniqueId);
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
                    if (!eVar.bpi() && !z2) {
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gAg.aHD();
                                i.this.gAj.fF(true);
                            }
                        }, 800L);
                    } else if (!this.mIsHost && z && this.gzC != null && this.gzC.brl() != null && this.gzC.brl().bre()) {
                        this.gAg.aHD();
                        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                        com.baidu.tieba.personPolymeric.c.i iVar = new com.baidu.tieba.personPolymeric.c.i();
                        iVar.sex = this.mSex;
                        iVar.isHost = this.mIsHost;
                        arrayList.add(iVar);
                        this.gAg.as(arrayList);
                        this.mView.postDelayed(new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.i.3
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.gAg.aHD();
                                i.this.gAj.fF(true);
                            }
                        }, 800L);
                    } else {
                        this.gAj.ml(z2);
                        this.gAk.setOnResult(new PersonPostModel.b() { // from class: com.baidu.tieba.personPolymeric.b.i.4
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.b
                            public void a(PersonPostModel personPostModel, boolean z4) {
                                i.this.gAg.aHD();
                                if (personPostModel != null) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                } else {
                                    l.showToast(i.this.mContext.getContext(), i.this.mContext.getString(e.j.data_load_error));
                                }
                                if (z4) {
                                    i.this.gAg.as(null);
                                    i.this.gAj.abd();
                                }
                            }
                        });
                        this.gAk.fetchPost(this.bLT.getPageContext(), new PersonPostModel.a() { // from class: com.baidu.tieba.personPolymeric.b.i.5
                            @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
                            public void b(PersonPostModel personPostModel, boolean z4) {
                                int H;
                                if (personPostModel.getErrorCode() != 0) {
                                    l.showToast(i.this.mContext.getContext(), personPostModel.getErrorString());
                                }
                                i.this.gAg.aHD();
                                if (z) {
                                    com.baidu.tieba.person.data.e eVar2 = (com.baidu.tieba.person.data.e) i.this.mList.get(1);
                                    if (!z4) {
                                        ArrayList<com.baidu.adp.widget.ListView.h> bpj = ((com.baidu.tieba.person.data.e) i.this.mList.get(1)).bpj();
                                        if (v.I(bpj)) {
                                            i.this.gAj.abd();
                                            return;
                                        } else if (i.this.ar(personPostModel.postList)) {
                                            eVar2.lY(false);
                                            i.this.gAg.as(bpj);
                                            i.this.gAj.c(true, bpj);
                                            return;
                                        } else if (i.dv(personPostModel.postList) == 0) {
                                            eVar2.lY(false);
                                            i.this.gAg.as(bpj);
                                            i.this.gAj.c(true, bpj);
                                            return;
                                        } else {
                                            bpj.addAll(personPostModel.postList);
                                            i.this.gAj.Fd();
                                            eVar2.aq(bpj);
                                            i.this.gAg.as(bpj);
                                            return;
                                        }
                                    }
                                    eVar2.lY(true);
                                    eVar2.aq(personPostModel.postList);
                                    i.this.gAg.as(personPostModel.postList);
                                    if (eVar2.bpj() != null && (H = v.H(eVar2.bpj())) > 0 && H <= 2) {
                                        for (int i = 0; i < H; i++) {
                                            if (eVar2.bpj().get(i) instanceof com.baidu.tieba.personPolymeric.c.i) {
                                                ((com.baidu.tieba.personPolymeric.c.i) eVar2.bpj().get(i)).isHost = i.this.mIsHost;
                                                i.this.gAj.abd();
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                ArrayList<com.baidu.adp.widget.ListView.h> bpj2 = ((com.baidu.tieba.person.data.e) i.this.mList.get(0)).bpj();
                                if (!v.I(bpj2)) {
                                    if (i.this.ar(personPostModel.postList)) {
                                        eVar.lY(false);
                                        i.this.gAg.as(bpj2);
                                        i.this.gAj.c(true, bpj2);
                                        return;
                                    }
                                    Iterator<com.baidu.adp.widget.ListView.h> it = personPostModel.threadList.iterator();
                                    while (it.hasNext()) {
                                        com.baidu.adp.widget.ListView.h next = it.next();
                                        if (next instanceof CardPersonDynamicThreadData) {
                                            ((CardPersonDynamicThreadData) next).isHost = i.this.mIsHost;
                                        }
                                    }
                                    bpj2.addAll(personPostModel.threadList);
                                    ArrayList<com.baidu.adp.widget.ListView.h> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(bpj2);
                                    eVar.lY(true);
                                    eVar.aq(mergeDynamicThreadByTime);
                                    i.this.gAj.Fd();
                                    i.this.gAg.du(mergeDynamicThreadByTime);
                                }
                            }
                        }, z2, String.valueOf(this.mUserId), false, z, false);
                    }
                }
            }
        } else if (!z2) {
            this.gAj.Fc();
        } else {
            l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
            if (z) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                com.baidu.tieba.personPolymeric.c.i iVar2 = new com.baidu.tieba.personPolymeric.c.i();
                iVar2.isHost = this.mIsHost;
                arrayList2.add(iVar2);
                this.gAj.abd();
                this.gAg.as(arrayList2);
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

    public static int dv(List<com.baidu.adp.widget.ListView.h> list) {
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
        if (this.gAf != null) {
            this.gAf.refreshData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void g(boolean z, boolean z2, boolean z3) {
        j(z, z2, z3);
    }

    @Override // com.baidu.tieba.model.a
    public void loadData() {
        if (this.gAf != null) {
            this.gAf.loadData();
        }
    }

    @Override // com.baidu.tieba.model.a
    public void resetData() {
        this.gAk.resetThreadPn();
        if (this.gzC != null) {
            this.gzC.resetData();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        boolean z;
        this.gAg.aHD();
        this.bLT.hideLoadingView(this.mView);
        if (aVar == null) {
            this.gAj.O(TbadkCoreApplication.getInst().getString(e.j.neterror), true);
            this.gAj.abd();
            this.gAj.ts(8);
        } else if (aVar.aAM() != null && ((aVar.aAM().getHide_stat() == 1 && aVar.aAM().getBlock_stat() == 1) || (aVar.aAM().getHide_stat() == 1 && aVar.aAM().getBlock_stat() == 2))) {
            this.gAj.mk(this.mIsHost);
            this.gAj.ts(8);
            this.gAj.aba();
        } else {
            this.gAj.aba();
            aVar.brc();
            if (aVar.aNx() != null) {
                z = aVar.aNx().size() >= 20;
            } else {
                z = false;
            }
            if (aVar.getUserData() != null) {
                this.mSex = aVar.getUserData().getSex();
            }
            this.bRW = false;
            if (this.mIsHost) {
                aVar.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                com.baidu.tbadk.getUserInfo.b.Nm().a(aVar.getUserData());
            }
            if (this.gzG != null) {
                this.gzG.a(aVar);
            }
            if (this.gAi != null) {
                this.gAi.c(aVar);
            }
            com.baidu.tieba.person.data.e eVar = this.mList.get(0);
            eVar.aq(aVar.aNx());
            eVar.lY(z);
            this.gAj.ts(0);
            this.gAg.a(aVar, z);
            bra();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public f bqE() {
        return this.gAi;
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.gAg != null) {
                this.gAg.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void b(BaseFragment baseFragment) {
        this.gzz = baseFragment;
    }

    public void bra() {
        if (!this.bRW) {
            if ((this.gzz == null || this.gzz.isPrimary()) && this.gAg != null && (this.gAg.brs() instanceof com.baidu.tieba.view.d)) {
                ((com.baidu.tieba.view.d) this.gAg.brs()).bra();
            }
        }
    }

    public void bmY() {
        if (this.gAg != null && (this.gAg.brs() instanceof com.baidu.tieba.view.d)) {
            ((com.baidu.tieba.view.d) this.gAg.brs()).bmY();
        }
    }

    public void brb() {
        if (this.gAg != null && this.gAg.abW() != null && (this.gAg.brs() instanceof com.baidu.tieba.personPolymeric.a)) {
            ((com.baidu.tieba.personPolymeric.a) this.gAg.brs()).a(this.bLT, this.gAg.abW());
            if (this.gAh != null) {
                this.gAg.setOnViewResponseListener(this.gAh);
            }
            this.gAg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void tP(String str) {
        if (!ao.isEmpty(str) && this.mList != null && this.mList.get(0) != null && this.mList.get(0).bpj() != null && this.gAg != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> bpj = this.mList.get(0).bpj();
            for (int i = 0; i < bpj.size() && bpj.get(i) != null; i++) {
                com.baidu.adp.widget.ListView.h hVar = bpj.get(i);
                if ((hVar instanceof CardPersonDynamicThreadData) && ao.equals(str, ((CardPersonDynamicThreadData) hVar).threadId)) {
                    this.gAg.a(i, str, this.gAn);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aBS);
        this.gzG.onDestroy();
        if (this.gAg != null) {
            this.gAg.onDestory();
        }
        bmY();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void gx(boolean z) {
        if (z) {
            if (this.bRW) {
                loadData();
            }
            if (TbadkCoreApplication.isLogin()) {
                bra();
                return;
            } else {
                bmY();
                return;
            }
        }
        bmY();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void onResume() {
        if (TbadkCoreApplication.isLogin()) {
            bra();
            brb();
            if (!this.mIsHost && this.mUserId == TbadkCoreApplication.getCurrentAccountId()) {
                this.mIsHost = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.mContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
                this.bLT.finish();
                return;
            }
            return;
        }
        bmY();
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void tN(String str) {
        if (this.gAg != null) {
            this.gAg.tN(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void tO(String str) {
        if (this.gAg != null) {
            this.gAg.tO(str);
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void bqF() {
        if (this.gAg != null) {
            this.gAg.bqF();
        }
    }

    @Override // com.baidu.tieba.personPolymeric.b.a
    public void mj(boolean z) {
        this.gAg.mj(z);
    }

    private void initListener() {
        this.dry = new CustomMessageListener(2921003) { // from class: com.baidu.tieba.personPolymeric.b.i.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                i.this.bmY();
            }
        };
        this.dry.setTag(this.aBS);
        MessageManager.getInstance().registerListener(this.dry);
        this.gAl = new CustomMessageListener(2016557) { // from class: com.baidu.tieba.personPolymeric.b.i.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.tP((String) customResponsedMessage.getData());
                }
            }
        };
        this.gAl.setTag(this.aBS);
        MessageManager.getInstance().registerListener(this.gAl);
        this.gAm = new CustomMessageListener(2016558) { // from class: com.baidu.tieba.personPolymeric.b.i.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    i.this.tP((String) customResponsedMessage.getData());
                    l.showToast(i.this.mContext.getPageActivity(), e.j.person_polymeric_set_privacy_success);
                }
            }
        };
        this.gAm.setTag(this.aBS);
        MessageManager.getInstance().registerListener(this.gAm);
    }
}
