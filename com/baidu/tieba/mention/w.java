package com.baidu.tieba.mention;

import android.support.v4.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ v bnU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.bnU = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Fragment fragment;
        BaseFragment[] baseFragmentArr;
        Object data;
        if (customResponsedMessage == null || (data = customResponsedMessage.getData()) == null || !(data instanceof Fragment)) {
            fragment = null;
        } else {
            fragment = (Fragment) data;
        }
        if (fragment != null) {
            this.bnU.aLU = new BaseFragment[]{(BaseFragment) fragment, new ae(), new a()};
            this.bnU.bfV = new int[]{0, 1, 2};
        } else {
            this.bnU.aLU = new BaseFragment[]{new ae(), new a()};
            this.bnU.bfV = new int[]{1, 2};
        }
        v vVar = this.bnU;
        baseFragmentArr = this.bnU.aLU;
        vVar.mq = baseFragmentArr.length;
    }
}
