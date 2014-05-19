package com.baidu.tieba.mention;

import android.support.v4.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, int i) {
        super(i);
        this.a = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Fragment fragment;
        com.baidu.tbadk.core.d[] dVarArr;
        Object data;
        if (customResponsedMessage == null || (data = customResponsedMessage.getData()) == null || !(data instanceof Fragment)) {
            fragment = null;
        } else {
            fragment = (Fragment) data;
        }
        if (fragment != null) {
            this.a.a = new com.baidu.tbadk.core.d[]{(com.baidu.tbadk.core.d) fragment, new af(), new a()};
            this.a.b = new int[]{0, 1, 2};
        } else {
            this.a.a = new com.baidu.tbadk.core.d[]{new af(), new a()};
            this.a.b = new int[]{1, 2};
        }
        k kVar = this.a;
        dVarArr = this.a.a;
        kVar.c = dVarArr.length;
    }
}
