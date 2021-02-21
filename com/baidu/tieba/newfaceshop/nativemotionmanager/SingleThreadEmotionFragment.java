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
public class SingleThreadEmotionFragment extends BaseFragment implements a.InterfaceC0815a<List<EmotionPackageData>> {
    private CustomMessageListener iXQ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (SingleThreadEmotionFragment.this.lDc != null) {
                SingleThreadEmotionFragment.this.lDc.loadData();
            }
        }
    };
    private f lDb;
    private SingleThreadEmotionModel lDc;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lDb = new f(getPageContext());
        this.lDc = new SingleThreadEmotionModel();
        this.lDc.a(this);
        registerListener(this.iXQ);
        diZ();
        return this.lDb.getView();
    }

    private void diZ() {
        if (this.lDc != null) {
            this.lDc.loadData();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0815a
    /* renamed from: aj */
    public void onSuccess(final List<EmotionPackageData> list) {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.lDb != null) {
                    SingleThreadEmotionFragment.this.lDb.fa(list);
                    SingleThreadEmotionFragment.this.djb();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iXQ != null) {
            MessageManager.getInstance().unRegisterListener(this.iXQ);
        }
        if (this.lDc != null) {
            this.lDc.djj();
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0815a
    public void onFail() {
        e.mA().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.lDb != null) {
                    SingleThreadEmotionFragment.this.lDb.showNoDataView();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lDb != null) {
            this.lDb.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0815a
    public void dja() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djb() {
        if (this.lDb != null) {
            this.lDb.hideLoadingView();
        }
    }
}
