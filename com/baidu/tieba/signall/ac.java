package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ac extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Context context;
        com.baidu.tbadk.d.d dVar;
        View.OnClickListener onClickListener;
        com.baidu.tbadk.d.d dVar2;
        com.baidu.tbadk.d.d dVar3;
        Context context2;
        com.baidu.tbadk.d.d dVar4;
        Context context3;
        com.baidu.tbadk.d.d dVar5;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2009501 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.d.a)) {
            SignAllForumStatic.mContext = ((com.baidu.tbadk.d.a) customResponsedMessage.getData()).getContext();
            SignAllForumStatic.cGi = new com.baidu.tbadk.d.d();
            context = SignAllForumStatic.mContext;
            if (context != null) {
                dVar = SignAllForumStatic.cGi;
                onClickListener = SignAllForumStatic.OS;
                dVar.h(onClickListener);
                dVar2 = SignAllForumStatic.cGi;
                dVar2.setPosition(4);
                dVar3 = SignAllForumStatic.cGi;
                context2 = SignAllForumStatic.mContext;
                dVar3.setIcon(context2.getResources().getDrawable(t.f.icon_all_sign_dis));
                dVar4 = SignAllForumStatic.cGi;
                context3 = SignAllForumStatic.mContext;
                dVar4.setTitle(context3.getResources().getString(t.j.ba_all_sign));
                dVar5 = SignAllForumStatic.cGi;
                ((com.baidu.tbadk.d.a) customResponsedMessage.getData()).a(dVar5);
            }
        }
    }
}
