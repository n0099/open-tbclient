package com.baidu.tieba.tblauncher;

import android.os.SystemClock;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes4.dex */
public class ClientStartStatic {
    static {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            new a().execute(new Void[0]);
            MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tieba.tblauncher.ClientStartStatic.1
                private long aYH;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Boolean data;
                    if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                        if (data.booleanValue()) {
                            this.aYH = SystemClock.elapsedRealtime();
                            return;
                        }
                        if (SystemClock.elapsedRealtime() - this.aYH > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                            new a().execute(new Void[0]);
                        }
                        TiebaStatic.log(new am("c11894").T("obj_param1", 1));
                    }
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        private a() {
            setPriority(1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.STAT_CLIENT_START);
            xVar.x("type", "1");
            xVar.acj();
            return null;
        }
    }
}
