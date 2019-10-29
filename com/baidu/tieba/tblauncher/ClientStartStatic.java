package com.baidu.tieba.tblauncher;

import android.os.SystemClock;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.x;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes4.dex */
public class ClientStartStatic {
    static {
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            new a().execute(new Void[0]);
            MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.tblauncher.ClientStartStatic.1
                private long mTimeStamp;

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Boolean data;
                    if ((customResponsedMessage instanceof BackgroundSwitchMessage) && (data = ((BackgroundSwitchMessage) customResponsedMessage).getData()) != null) {
                        if (data.booleanValue()) {
                            this.mTimeStamp = SystemClock.elapsedRealtime();
                            return;
                        }
                        if (SystemClock.elapsedRealtime() - this.mTimeStamp > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                            new a().execute(new Void[0]);
                        }
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.HOST_START).O("obj_param1", 1));
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
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.STAT_CLIENT_START);
                xVar.addPostData("type", "1");
                xVar.postNetData();
            }
            return null;
        }
    }
}
