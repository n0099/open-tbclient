package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public x(int i) {
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
            SignAllForumStatic.cvC = new com.baidu.tbadk.d.d();
            context = SignAllForumStatic.mContext;
            if (context != null) {
                dVar = SignAllForumStatic.cvC;
                onClickListener = SignAllForumStatic.mClickListener;
                dVar.d(onClickListener);
                dVar2 = SignAllForumStatic.cvC;
                dVar2.setPosition(4);
                dVar3 = SignAllForumStatic.cvC;
                context2 = SignAllForumStatic.mContext;
                dVar3.setIcon(context2.getResources().getDrawable(n.e.icon_all_sign_dis));
                dVar4 = SignAllForumStatic.cvC;
                context3 = SignAllForumStatic.mContext;
                dVar4.setTitle(context3.getResources().getString(n.i.ba_all_sign));
                dVar5 = SignAllForumStatic.cvC;
                ((com.baidu.tbadk.d.a) customResponsedMessage.getData()).a(dVar5);
            }
        }
    }
}
