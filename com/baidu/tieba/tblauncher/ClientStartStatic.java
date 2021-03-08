package com.baidu.tieba.tblauncher;

import android.os.SystemClock;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import org.apache.http.cookie.SM;
/* loaded from: classes.dex */
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
                        if (SystemClock.elapsedRealtime() - this.mTimeStamp > 30000) {
                            new a().execute(new Void[0]);
                        }
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.HOST_START).aq("obj_param1", 1).aq(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getStartType()).aq(TiebaInitialize.Params.OBJ_PARAM3, TbadkCoreApplication.getInst().getCanShowSplash()));
                    }
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        private a() {
            setPriority(1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.STAT_CLIENT_START);
                aaVar.addPostData("type", "1");
                aaVar.postNetData();
                if (TbSingleton.getInstance().getBaiduIdForAnti() == null && aaVar.bsu() != null && aaVar.bsu().bte() != null && aaVar.bsu().bte().mHeader != null) {
                    List<String> list = aaVar.bsu().bte().mHeader.get(SM.SET_COOKIE);
                    if (!y.isEmpty(list)) {
                        boolean z = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) != null && list.get(i).contains("BAIDUID=")) {
                                String[] split = list.get(i).split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                                if (split != null) {
                                    int length = split.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= length) {
                                            break;
                                        }
                                        String str = split[i2];
                                        if (str == null || !str.contains("BAIDUID=")) {
                                            i2++;
                                        } else {
                                            TbSingleton.getInstance().setBaiduIdForAnti(str.trim().substring(8));
                                            z = true;
                                            break;
                                        }
                                    }
                                }
                                if (z) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
}
