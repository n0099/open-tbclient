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
public class SingleThreadEmotionFragment extends BaseFragment implements a.InterfaceC0830a<List<EmotionPackageData>> {
    private CustomMessageListener iWC = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (SingleThreadEmotionFragment.this.lzq != null) {
                SingleThreadEmotionFragment.this.lzq.loadData();
            }
        }
    };
    private f lzp;
    private SingleThreadEmotionModel lzq;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lzp = new f(getPageContext());
        this.lzq = new SingleThreadEmotionModel();
        this.lzq.a(this);
        registerListener(this.iWC);
        dkJ();
        return this.lzp.getView();
    }

    private void dkJ() {
        if (this.lzq != null) {
            this.lzq.loadData();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0830a
    /* renamed from: ai */
    public void onSuccess(final List<EmotionPackageData> list) {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.2
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.lzp != null) {
                    SingleThreadEmotionFragment.this.lzp.fc(list);
                    SingleThreadEmotionFragment.this.dkL();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iWC != null) {
            MessageManager.getInstance().unRegisterListener(this.iWC);
        }
        if (this.lzq != null) {
            this.lzq.dkT();
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0830a
    public void onFail() {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.SingleThreadEmotionFragment.3
            @Override // java.lang.Runnable
            public void run() {
                if (SingleThreadEmotionFragment.this.lzp != null) {
                    SingleThreadEmotionFragment.this.lzp.showNoDataView();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lzp != null) {
            this.lzp.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0830a
    public void dkK() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkL() {
        if (this.lzp != null) {
            this.lzp.hideLoadingView();
        }
    }
}
