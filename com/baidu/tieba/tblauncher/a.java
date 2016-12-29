package com.baidu.tieba.tblauncher;

import android.os.SystemClock;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tblauncher.ClientStartStatic;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    private long csw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Boolean data;
        if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
            if (data.booleanValue()) {
                this.csw = SystemClock.elapsedRealtime();
                return;
            }
            if (SystemClock.elapsedRealtime() - this.csw > 30000) {
                new ClientStartStatic.a(null).execute(new Void[0]);
            }
            TiebaStatic.log("c11894");
        }
    }
}
