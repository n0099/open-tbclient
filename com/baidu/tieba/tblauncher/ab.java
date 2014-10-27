package com.baidu.tieba.tblauncher;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        if (customResponsedMessage != null) {
            if (com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("game_is_show_tip", false)) {
                imageView2 = this.this$0.bON;
                imageView2.setVisibility(0);
                imageView3 = this.this$0.bON;
                aw.c(imageView3, com.baidu.tieba.u.icon_news_down_bar_one);
                return;
            }
            imageView = this.this$0.bON;
            imageView.setVisibility(4);
        }
    }
}
