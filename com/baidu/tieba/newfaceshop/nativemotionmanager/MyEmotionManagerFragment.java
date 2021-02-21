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
/* loaded from: classes9.dex */
public class MyEmotionManagerFragment extends BaseFragment implements com.baidu.tieba.newfaceshop.nativemotionmanager.b.a, a.InterfaceC0815a<Pair<List<EmotionPackageData>, Integer>> {
    private d lCT;
    private MyEmotionManagerModel lCU;
    private a.InterfaceC0813a lCV;
    private CustomMessageListener lCW = new CustomMessageListener(CmdConfigCustom.CMD_DEL_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                com.baidu.tieba.newfaceshop.a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String valueOf = String.valueOf(customResponsedMessage.getData());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(valueOf);
                        if (!c.dis().v(arrayList, true) || !j.isNetWorkAvailable()) {
                            if (MyEmotionManagerFragment.this.lCU != null) {
                                MyEmotionManagerFragment.this.lCU.djg();
                            }
                        } else if (MyEmotionManagerFragment.this.lCU != null) {
                            MyEmotionManagerFragment.this.lCU.loadData();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE));
                        }
                    }
                });
            }
        }
    };
    private CustomMessageListener iXQ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.lCU != null) {
                MyEmotionManagerFragment.this.lCU.loadData();
            }
        }
    };
    private CustomMessageListener lCX = new CustomMessageListener(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.lCU != null) {
                MyEmotionManagerFragment.this.lCU.dja();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a.diY().TP();
        registerListener(this.iXQ);
        registerListener(this.lCX);
        registerListener(this.lCW);
        this.lCT = new d(getPageContext());
        this.lCU = new MyEmotionManagerModel(getPageContext());
        this.lCU.a(this);
        return this.lCT.getView();
    }

    private void diZ() {
        this.lCU.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        diZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0815a
    /* renamed from: g */
    public void onSuccess(final Pair<List<EmotionPackageData>, Integer> pair) {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (pair != null) {
                    if (MyEmotionManagerFragment.this.lCT != null) {
                        MyEmotionManagerFragment.this.lCT.fa((List) pair.first);
                        MyEmotionManagerFragment.this.lCT.hideLoadingView();
                    }
                    if (MyEmotionManagerFragment.this.lCV != null && pair.second != null) {
                        MyEmotionManagerFragment.this.uu(((Integer) pair.second).intValue() > 0);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0815a
    public void onFail() {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (MyEmotionManagerFragment.this.lCT != null) {
                    MyEmotionManagerFragment.this.lCT.showNoDataView();
                }
                if (MyEmotionManagerFragment.this.lCV != null) {
                    MyEmotionManagerFragment.this.uu(false);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lCU != null) {
            this.lCU.djj();
        }
        if (this.iXQ != null) {
            MessageManager.getInstance().unRegisterListener(this.iXQ);
        }
        if (this.lCX != null) {
            MessageManager.getInstance().unRegisterListener(this.lCX);
        }
        if (this.lCW != null) {
            MessageManager.getInstance().unRegisterListener(this.lCW);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0815a
    public void dja() {
        if (this.lCT != null) {
            this.lCT.dja();
        }
    }

    public void uu(boolean z) {
        if (this.lCV != null) {
            this.lCV.onUpdate(Boolean.valueOf(z));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lCT != null) {
            this.lCT.onChangeSkinType(i);
        }
    }

    public void a(a.InterfaceC0813a interfaceC0813a) {
        if (interfaceC0813a != null) {
            this.lCV = interfaceC0813a;
        }
    }
}
