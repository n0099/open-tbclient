package com.baidu.tieba.newfaceshop.nativemotionmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.SingleThreadEmotionModel;
import com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.f;
import java.util.List;
/* loaded from: classes9.dex */
public class SingleThreadEmotionFragment extends BaseFragment implements a.InterfaceC0814a<List<EmotionPackageData>> {
    private CustomMessageListener iXC = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (SingleThreadEmotionFragment.this.lCO != null) {
                SingleThreadEmotionFragment.this.lCO.loadData();
            }
        }
    };
    private f lCN;
    private SingleThreadEmotionModel lCO;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lCN = new f(getPageContext());
        this.lCO = new SingleThreadEmotionModel();
        this.lCO.a(this);
        registerListener(this.iXC);
        diS();
        return this.lCN.getView();
    }

    private void diS() {
        if (this.lCO != null) {
            this.lCO.loadData();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0814a
    /* renamed from: aj */
    public void onSuccess(final List<EmotionPackageData> list) {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.lCN != null) {
                    SingleThreadEmotionFragment.this.lCN.fa(list);
                    SingleThreadEmotionFragment.this.diU();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iXC != null) {
            MessageManager.getInstance().unRegisterListener(this.iXC);
        }
        if (this.lCO != null) {
            this.lCO.djc();
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0814a
    public void onFail() {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.lCN != null) {
                    SingleThreadEmotionFragment.this.lCN.showNoDataView();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lCN != null) {
            this.lCN.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0814a
    public void diT() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diU() {
        if (this.lCN != null) {
            this.lCN.hideLoadingView();
        }
    }
}
