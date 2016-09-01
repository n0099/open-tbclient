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
public class am {
    private String acU = "bar_detail";
    private a frA;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, long j);

        void j(String str, long j);
    }

    public void setFrom(String str) {
        this.acU = str;
    }

    public void a(a aVar) {
        this.frA = aVar;
    }

    public void s(String str, long j) {
        new b(str, j, this.acU, this.frA).execute(new Integer[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String acU;
        private com.baidu.tbadk.core.util.ab aiS = null;
        private WeakReference<a> frB;
        private long mForumId;
        private String mForumName;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.frB = null;
            this.mForumName = str;
            this.mForumId = j;
            this.frB = new WeakReference<>(aVar);
            this.acU = str2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.aiS = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.aiS.n("fid", String.valueOf(this.mForumId));
                    this.aiS.n("kw", this.mForumName);
                    this.aiS.n("favo_type", "1");
                    this.aiS.n("st_type", this.acU);
                    this.aiS.uD().vz().mIsNeedTbs = true;
                    this.aiS.ue();
                }
                return 1;
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
            if (this.frB != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.frB.get();
                if (aVar2 != null) {
                    if (this.aiS != null) {
                        if (this.aiS.uD().vA().oE()) {
                            if (num.intValue() == 1) {
                                TbadkCoreApplication.m9getInst().delLikeForum(this.mForumName);
                                aVar2.i(this.mForumName, this.mForumId);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(this.mForumId)));
                                aVar.isSuccess = true;
                            } else {
                                aVar2.j(this.mForumName, this.mForumId);
                                aVar.isSuccess = false;
                            }
                        } else {
                            aVar2.j(this.mForumName, this.mForumId);
                            aVar.isSuccess = false;
                        }
                    } else {
                        aVar2.j(this.mForumName, this.mForumId);
                        aVar.isSuccess = false;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM, aVar));
                }
            }
        }
    }
}
