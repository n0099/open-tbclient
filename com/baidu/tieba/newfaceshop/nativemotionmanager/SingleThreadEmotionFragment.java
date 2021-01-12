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
/* loaded from: classes8.dex */
public class SingleThreadEmotionFragment extends BaseFragment implements a.InterfaceC0813a<List<EmotionPackageData>> {
    private CustomMessageListener iRV = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (SingleThreadEmotionFragment.this.luK != null) {
                SingleThreadEmotionFragment.this.luK.loadData();
            }
        }
    };
    private f luJ;
    private SingleThreadEmotionModel luK;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.luJ = new f(getPageContext());
        this.luK = new SingleThreadEmotionModel();
        this.luK.a(this);
        registerListener(this.iRV);
        dgR();
        return this.luJ.getView();
    }

    private void dgR() {
        if (this.luK != null) {
            this.luK.loadData();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0813a
    /* renamed from: ai */
    public void onSuccess(final List<EmotionPackageData> list) {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.luJ != null) {
                    SingleThreadEmotionFragment.this.luJ.fc(list);
                    SingleThreadEmotionFragment.this.dgT();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iRV != null) {
            MessageManager.getInstance().unRegisterListener(this.iRV);
        }
        if (this.luK != null) {
            this.luK.dhb();
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0813a
    public void onFail() {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.luJ != null) {
                    SingleThreadEmotionFragment.this.luJ.showNoDataView();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.luJ != null) {
            this.luJ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0813a
    public void dgS() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dgT() {
        if (this.luJ != null) {
            this.luJ.hideLoadingView();
        }
    }
}
