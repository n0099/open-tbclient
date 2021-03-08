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
public class SingleThreadEmotionFragment extends BaseFragment implements a.InterfaceC0821a<List<EmotionPackageData>> {
    private CustomMessageListener iZz = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (SingleThreadEmotionFragment.this.lFe != null) {
                SingleThreadEmotionFragment.this.lFe.loadData();
            }
        }
    };
    private f lFd;
    private SingleThreadEmotionModel lFe;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lFd = new f(getPageContext());
        this.lFe = new SingleThreadEmotionModel();
        this.lFe.a(this);
        registerListener(this.iZz);
        dji();
        return this.lFd.getView();
    }

    private void dji() {
        if (this.lFe != null) {
            this.lFe.loadData();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0821a
    /* renamed from: aj */
    public void onSuccess(final List<EmotionPackageData> list) {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.lFd != null) {
                    SingleThreadEmotionFragment.this.lFd.fa(list);
                    SingleThreadEmotionFragment.this.djk();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iZz != null) {
            MessageManager.getInstance().unRegisterListener(this.iZz);
        }
        if (this.lFe != null) {
            this.lFe.djs();
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0821a
    public void onFail() {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.lFd != null) {
                    SingleThreadEmotionFragment.this.lFd.showNoDataView();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lFd != null) {
            this.lFd.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0821a
    public void djj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djk() {
        if (this.lFd != null) {
            this.lFd.hideLoadingView();
        }
    }
}
