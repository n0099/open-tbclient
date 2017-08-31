package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class u {
    private String aiP = "bar_detail";
    private a ghs;

    /* loaded from: classes.dex */
    public interface a {
        void k(String str, long j);

        void l(String str, long j);
    }

    public void setFrom(String str) {
        this.aiP = str;
    }

    public void a(a aVar) {
        this.ghs = aVar;
    }

    public void r(String str, long j) {
        new b(str, j, this.aiP, this.ghs).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String aiP;
        private WeakReference<a> ght;
        private long mForumId;
        private String mForumName;
        private x mNetwork = null;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.ght = null;
            this.mForumName = str;
            this.mForumId = j;
            this.ght = new WeakReference<>(aVar);
            this.aiP = str2;
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
                    this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.n("fid", String.valueOf(this.mForumId));
                    this.mNetwork.n("kw", this.mForumName);
                    this.mNetwork.n("favo_type", "1");
                    this.mNetwork.n("st_type", this.aiP);
                    this.mNetwork.vj().wf().mIsNeedTbs = true;
                    this.mNetwork.uM();
                    if (this.mNetwork.vj().wg().isRequestSuccess()) {
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
            if (this.ght != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.ght.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.vj().wg().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.k(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM_NAME, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar2.l(this.mForumName, this.mForumId);
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            aVar.errorMessage = this.mNetwork.vm() ? this.mNetwork.getErrorString() : this.mNetwork.vp();
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM, aVar));
                }
            }
        }
    }
}
