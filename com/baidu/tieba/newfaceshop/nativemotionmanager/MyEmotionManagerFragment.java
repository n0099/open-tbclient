package com.baidu.tieba.newfaceshop.nativemotionmanager;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.c;
import com.baidu.tieba.newfaceshop.nativemotionmanager.b.a;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.MyEmotionManagerModel;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class MyEmotionManagerFragment extends BaseFragment implements com.baidu.tieba.newfaceshop.nativemotionmanager.b.a, a.InterfaceC0813a<Pair<List<EmotionPackageData>, Integer>> {
    private d luB;
    private MyEmotionManagerModel luC;
    private a.InterfaceC0811a luD;
    private CustomMessageListener luE = new CustomMessageListener(CmdConfigCustom.CMD_DEL_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                com.baidu.tieba.newfaceshop.a.dgi().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String valueOf = String.valueOf(customResponsedMessage.getData());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(valueOf);
                        if (!c.dgk().u(arrayList, true) || !j.isNetWorkAvailable()) {
                            if (MyEmotionManagerFragment.this.luC != null) {
                                MyEmotionManagerFragment.this.luC.dgY();
                            }
                        } else if (MyEmotionManagerFragment.this.luC != null) {
                            MyEmotionManagerFragment.this.luC.loadData();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE));
                        }
                    }
                });
            }
        }
    };
    private CustomMessageListener iRV = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.luC != null) {
                MyEmotionManagerFragment.this.luC.loadData();
            }
        }
    };
    private CustomMessageListener luF = new CustomMessageListener(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.luC != null) {
                MyEmotionManagerFragment.this.luC.dgS();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a.dgQ().Si();
        registerListener(this.iRV);
        registerListener(this.luF);
        registerListener(this.luE);
        this.luB = new d(getPageContext());
        this.luC = new MyEmotionManagerModel(getPageContext());
        this.luC.a(this);
        return this.luB.getView();
    }

    private void dgR() {
        this.luC.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        dgR();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0813a
    /* renamed from: g */
    public void onSuccess(final Pair<List<EmotionPackageData>, Integer> pair) {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (pair != null) {
                    if (MyEmotionManagerFragment.this.luB != null) {
                        MyEmotionManagerFragment.this.luB.fc((List) pair.first);
                        MyEmotionManagerFragment.this.luB.hideLoadingView();
                    }
                    if (MyEmotionManagerFragment.this.luD != null && pair.second != null) {
                        MyEmotionManagerFragment.this.uh(((Integer) pair.second).intValue() > 0);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0813a
    public void onFail() {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (MyEmotionManagerFragment.this.luB != null) {
                    MyEmotionManagerFragment.this.luB.showNoDataView();
                }
                if (MyEmotionManagerFragment.this.luD != null) {
                    MyEmotionManagerFragment.this.uh(false);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.luC != null) {
            this.luC.dhb();
        }
        if (this.iRV != null) {
            MessageManager.getInstance().unRegisterListener(this.iRV);
        }
        if (this.luF != null) {
            MessageManager.getInstance().unRegisterListener(this.luF);
        }
        if (this.luE != null) {
            MessageManager.getInstance().unRegisterListener(this.luE);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0813a
    public void dgS() {
        if (this.luB != null) {
            this.luB.dgS();
        }
    }

    public void uh(boolean z) {
        if (this.luD != null) {
            this.luD.onUpdate(Boolean.valueOf(z));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.luB != null) {
            this.luB.onChangeSkinType(i);
        }
    }

    public void a(a.InterfaceC0811a interfaceC0811a) {
        if (interfaceC0811a != null) {
            this.luD = interfaceC0811a;
        }
    }
}
