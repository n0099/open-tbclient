package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof TbPageContext)) {
            TbPageContext tbPageContext = (TbPageContext) customResponsedMessage.getData();
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cb(r.j.across_forum_dialog_tips);
            aVar.b(r.j.across_forum_dialog_right_button, new g(this));
            aVar.a(r.j.across_forum_dialog_left_button, new h(this));
            aVar.av(false);
            aVar.b(tbPageContext).tb();
            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("across_forum_dialog_has_show", true);
        }
    }
}
