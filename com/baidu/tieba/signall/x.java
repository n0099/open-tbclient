package com.baidu.tieba.signall;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.i;
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
        com.baidu.tbadk.b.d dVar;
        View.OnClickListener onClickListener;
        com.baidu.tbadk.b.d dVar2;
        com.baidu.tbadk.b.d dVar3;
        Context context2;
        com.baidu.tbadk.b.d dVar4;
        Context context3;
        com.baidu.tbadk.b.d dVar5;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2009501 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.b.a)) {
            SignAllForumStatic.mContext = ((com.baidu.tbadk.b.a) customResponsedMessage.getData()).getContext();
            SignAllForumStatic.bYi = new com.baidu.tbadk.b.d();
            context = SignAllForumStatic.mContext;
            if (context != null) {
                dVar = SignAllForumStatic.bYi;
                onClickListener = SignAllForumStatic.mClickListener;
                dVar.d(onClickListener);
                dVar2 = SignAllForumStatic.bYi;
                dVar2.setPosition(4);
                dVar3 = SignAllForumStatic.bYi;
                context2 = SignAllForumStatic.mContext;
                dVar3.setIcon(context2.getResources().getDrawable(i.e.icon_all_sign_dis));
                dVar4 = SignAllForumStatic.bYi;
                context3 = SignAllForumStatic.mContext;
                dVar4.setTitle(context3.getResources().getString(i.C0057i.ba_all_sign));
                dVar5 = SignAllForumStatic.bYi;
                ((com.baidu.tbadk.b.a) customResponsedMessage.getData()).a(dVar5);
            }
        }
    }
}
