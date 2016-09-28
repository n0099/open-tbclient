package com.baidu.tieba.tblauncher;

import android.os.SystemClock;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.tblauncher.ClientStartStatic;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    private long mTimeStamp;

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
                this.mTimeStamp = SystemClock.elapsedRealtime();
            } else if (SystemClock.elapsedRealtime() - this.mTimeStamp > 30000) {
                new ClientStartStatic.a(null).execute(new Void[0]);
            }
        }
    }
}
