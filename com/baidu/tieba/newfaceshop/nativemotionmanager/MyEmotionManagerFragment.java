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
public class MyEmotionManagerFragment extends BaseFragment implements com.baidu.tieba.newfaceshop.nativemotionmanager.b.a, a.InterfaceC0821a<Pair<List<EmotionPackageData>, Integer>> {
    private d lEV;
    private MyEmotionManagerModel lEW;
    private a.InterfaceC0819a lEX;
    private CustomMessageListener lEY = new CustomMessageListener(CmdConfigCustom.CMD_DEL_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                com.baidu.tieba.newfaceshop.a.diz().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String valueOf = String.valueOf(customResponsedMessage.getData());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(valueOf);
                        if (!c.diB().v(arrayList, true) || !j.isNetWorkAvailable()) {
                            if (MyEmotionManagerFragment.this.lEW != null) {
                                MyEmotionManagerFragment.this.lEW.djp();
                            }
                        } else if (MyEmotionManagerFragment.this.lEW != null) {
                            MyEmotionManagerFragment.this.lEW.loadData();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE));
                        }
                    }
                });
            }
        }
    };
    private CustomMessageListener iZz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.lEW != null) {
                MyEmotionManagerFragment.this.lEW.loadData();
            }
        }
    };
    private CustomMessageListener lEZ = new CustomMessageListener(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.lEW != null) {
                MyEmotionManagerFragment.this.lEW.djj();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a.djh().TS();
        registerListener(this.iZz);
        registerListener(this.lEZ);
        registerListener(this.lEY);
        this.lEV = new d(getPageContext());
        this.lEW = new MyEmotionManagerModel(getPageContext());
        this.lEW.a(this);
        return this.lEV.getView();
    }

    private void dji() {
        this.lEW.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        dji();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0821a
    /* renamed from: f */
    public void onSuccess(final Pair<List<EmotionPackageData>, Integer> pair) {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (pair != null) {
                    if (MyEmotionManagerFragment.this.lEV != null) {
                        MyEmotionManagerFragment.this.lEV.fa((List) pair.first);
                        MyEmotionManagerFragment.this.lEV.hideLoadingView();
                    }
                    if (MyEmotionManagerFragment.this.lEX != null && pair.second != null) {
                        MyEmotionManagerFragment.this.uu(((Integer) pair.second).intValue() > 0);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0821a
    public void onFail() {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (MyEmotionManagerFragment.this.lEV != null) {
                    MyEmotionManagerFragment.this.lEV.showNoDataView();
                }
                if (MyEmotionManagerFragment.this.lEX != null) {
                    MyEmotionManagerFragment.this.uu(false);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lEW != null) {
            this.lEW.djs();
        }
        if (this.iZz != null) {
            MessageManager.getInstance().unRegisterListener(this.iZz);
        }
        if (this.lEZ != null) {
            MessageManager.getInstance().unRegisterListener(this.lEZ);
        }
        if (this.lEY != null) {
            MessageManager.getInstance().unRegisterListener(this.lEY);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0821a
    public void djj() {
        if (this.lEV != null) {
            this.lEV.djj();
        }
    }

    public void uu(boolean z) {
        if (this.lEX != null) {
            this.lEX.onUpdate(Boolean.valueOf(z));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lEV != null) {
            this.lEV.onChangeSkinType(i);
        }
    }

    public void a(a.InterfaceC0819a interfaceC0819a) {
        if (interfaceC0819a != null) {
            this.lEX = interfaceC0819a;
        }
    }
}
