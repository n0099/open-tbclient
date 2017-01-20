package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ClientStartStatic {
    static {
        if (TbadkCoreApplication.m9getInst().isMainProcess(false)) {
            new a(null).execute(new Void[0]);
            MessageManager.getInstance().registerListener(new com.baidu.tieba.tblauncher.a(CmdConfigCustom.CMD_BACKGROUND_SWTICH));
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        private a() {
            setPriority(1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.STAT_CLIENT_START);
            yVar.n("type", "1");
            yVar.ud();
            return null;
        }
    }
}
