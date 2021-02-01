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
public class MyEmotionManagerFragment extends BaseFragment implements com.baidu.tieba.newfaceshop.nativemotionmanager.b.a, a.InterfaceC0814a<Pair<List<EmotionPackageData>, Integer>> {
    private d lCF;
    private MyEmotionManagerModel lCG;
    private a.InterfaceC0812a lCH;
    private CustomMessageListener lCI = new CustomMessageListener(CmdConfigCustom.CMD_DEL_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String valueOf = String.valueOf(customResponsedMessage.getData());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(valueOf);
                        if (!c.dil().v(arrayList, true) || !j.isNetWorkAvailable()) {
                            if (MyEmotionManagerFragment.this.lCG != null) {
                                MyEmotionManagerFragment.this.lCG.diZ();
                            }
                        } else if (MyEmotionManagerFragment.this.lCG != null) {
                            MyEmotionManagerFragment.this.lCG.loadData();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE));
                        }
                    }
                });
            }
        }
    };
    private CustomMessageListener iXC = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.lCG != null) {
                MyEmotionManagerFragment.this.lCG.loadData();
            }
        }
    };
    private CustomMessageListener lCJ = new CustomMessageListener(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.lCG != null) {
                MyEmotionManagerFragment.this.lCG.diT();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a.diR().TP();
        registerListener(this.iXC);
        registerListener(this.lCJ);
        registerListener(this.lCI);
        this.lCF = new d(getPageContext());
        this.lCG = new MyEmotionManagerModel(getPageContext());
        this.lCG.a(this);
        return this.lCF.getView();
    }

    private void diS() {
        this.lCG.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        diS();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0814a
    /* renamed from: g */
    public void onSuccess(final Pair<List<EmotionPackageData>, Integer> pair) {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (pair != null) {
                    if (MyEmotionManagerFragment.this.lCF != null) {
                        MyEmotionManagerFragment.this.lCF.fa((List) pair.first);
                        MyEmotionManagerFragment.this.lCF.hideLoadingView();
                    }
                    if (MyEmotionManagerFragment.this.lCH != null && pair.second != null) {
                        MyEmotionManagerFragment.this.uu(((Integer) pair.second).intValue() > 0);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0814a
    public void onFail() {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (MyEmotionManagerFragment.this.lCF != null) {
                    MyEmotionManagerFragment.this.lCF.showNoDataView();
                }
                if (MyEmotionManagerFragment.this.lCH != null) {
                    MyEmotionManagerFragment.this.uu(false);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lCG != null) {
            this.lCG.djc();
        }
        if (this.iXC != null) {
            MessageManager.getInstance().unRegisterListener(this.iXC);
        }
        if (this.lCJ != null) {
            MessageManager.getInstance().unRegisterListener(this.lCJ);
        }
        if (this.lCI != null) {
            MessageManager.getInstance().unRegisterListener(this.lCI);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0814a
    public void diT() {
        if (this.lCF != null) {
            this.lCF.diT();
        }
    }

    public void uu(boolean z) {
        if (this.lCH != null) {
            this.lCH.onUpdate(Boolean.valueOf(z));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lCF != null) {
            this.lCF.onChangeSkinType(i);
        }
    }

    public void a(a.InterfaceC0812a interfaceC0812a) {
        if (interfaceC0812a != null) {
            this.lCH = interfaceC0812a;
        }
    }
}
