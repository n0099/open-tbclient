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
public class MyEmotionManagerFragment extends BaseFragment implements com.baidu.tieba.newfaceshop.nativemotionmanager.b.a, a.InterfaceC0830a<Pair<List<EmotionPackageData>, Integer>> {
    private d lzh;
    private MyEmotionManagerModel lzi;
    private a.InterfaceC0828a lzj;
    private CustomMessageListener lzk = new CustomMessageListener(CmdConfigCustom.CMD_DEL_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                com.baidu.tieba.newfaceshop.a.dka().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String valueOf = String.valueOf(customResponsedMessage.getData());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(valueOf);
                        if (!c.dkc().u(arrayList, true) || !j.isNetWorkAvailable()) {
                            if (MyEmotionManagerFragment.this.lzi != null) {
                                MyEmotionManagerFragment.this.lzi.dkQ();
                            }
                        } else if (MyEmotionManagerFragment.this.lzi != null) {
                            MyEmotionManagerFragment.this.lzi.loadData();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_SINGLE_THREAD_EMOTION_PACKAGE));
                        }
                    }
                });
            }
        }
    };
    private CustomMessageListener iWC = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.lzi != null) {
                MyEmotionManagerFragment.this.lzi.loadData();
            }
        }
    };
    private CustomMessageListener lzl = new CustomMessageListener(CmdConfigCustom.CMD_EDIT_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (MyEmotionManagerFragment.this.lzi != null) {
                MyEmotionManagerFragment.this.lzi.dkK();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a.dkI().Wb();
        registerListener(this.iWC);
        registerListener(this.lzl);
        registerListener(this.lzk);
        this.lzh = new d(getPageContext());
        this.lzi = new MyEmotionManagerModel(getPageContext());
        this.lzi.a(this);
        return this.lzh.getView();
    }

    private void dkJ() {
        this.lzi.loadData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        dkJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0830a
    /* renamed from: g */
    public void onSuccess(final Pair<List<EmotionPackageData>, Integer> pair) {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (pair != null) {
                    if (MyEmotionManagerFragment.this.lzh != null) {
                        MyEmotionManagerFragment.this.lzh.fc((List) pair.first);
                        MyEmotionManagerFragment.this.lzh.hideLoadingView();
                    }
                    if (MyEmotionManagerFragment.this.lzj != null && pair.second != null) {
                        MyEmotionManagerFragment.this.ul(((Integer) pair.second).intValue() > 0);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0830a
    public void onFail() {
        e.mB().post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.MyEmotionManagerFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (MyEmotionManagerFragment.this.lzh != null) {
                    MyEmotionManagerFragment.this.lzh.showNoDataView();
                }
                if (MyEmotionManagerFragment.this.lzj != null) {
                    MyEmotionManagerFragment.this.ul(false);
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lzi != null) {
            this.lzi.dkT();
        }
        if (this.iWC != null) {
            MessageManager.getInstance().unRegisterListener(this.iWC);
        }
        if (this.lzl != null) {
            MessageManager.getInstance().unRegisterListener(this.lzl);
        }
        if (this.lzk != null) {
            MessageManager.getInstance().unRegisterListener(this.lzk);
        }
    }

    @Override // com.baidu.tieba.newfaceshop.nativemotionmanager.model.a.a.InterfaceC0830a
    public void dkK() {
        if (this.lzh != null) {
            this.lzh.dkK();
        }
    }

    public void ul(boolean z) {
        if (this.lzj != null) {
            this.lzj.onUpdate(Boolean.valueOf(z));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lzh != null) {
            this.lzh.onChangeSkinType(i);
        }
    }

    public void a(a.InterfaceC0828a interfaceC0828a) {
        if (interfaceC0828a != null) {
            this.lzj = interfaceC0828a;
        }
    }
}
