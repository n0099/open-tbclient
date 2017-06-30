package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class ae {
    private String ahE = "bar_detail";
    private a fLq;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, long j);

        void j(String str, long j);
    }

    public void setFrom(String str) {
        this.ahE = str;
    }

    public void a(a aVar) {
        this.fLq = aVar;
    }

    public void r(String str, long j) {
        new b(str, j, this.ahE, this.fLq).execute(new Integer[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String ahE;
        private WeakReference<a> fLr;
        private long mForumId;
        private String mForumName;
        private com.baidu.tbadk.core.util.ab mNetwork = null;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.fLr = null;
            this.mForumName = str;
            this.mForumId = j;
            this.fLr = new WeakReference<>(aVar);
            this.ahE = str2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public Integer doInBackground(Integer... numArr) {
            int i;
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.mNetwork = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.n("fid", String.valueOf(this.mForumId));
                    this.mNetwork.n("kw", this.mForumName);
                    this.mNetwork.n("favo_type", "1");
                    this.mNetwork.n("st_type", this.ahE);
                    this.mNetwork.uV().vR().mIsNeedTbs = true;
                    this.mNetwork.uy();
                    if (this.mNetwork.uV().vS().isRequestSuccess()) {
                        i = 1;
                        return i;
                    }
                }
                i = 0;
                return i;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((b) num);
            if (this.fLr != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.fLr.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.uV().vS().isRequestSuccess()) {
                        TbadkCoreApplication.m9getInst().delLikeForum(this.mForumName);
                        aVar2.i(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar2.j(this.mForumName, this.mForumId);
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            aVar.errorMessage = this.mNetwork.uY() ? this.mNetwork.getErrorString() : this.mNetwork.vb();
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM, aVar));
                }
            }
        }
    }
}
