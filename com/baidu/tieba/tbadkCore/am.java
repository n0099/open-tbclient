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
    private String adg = "bar_detail";
    private a fuh;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, long j);

        void j(String str, long j);
    }

    public void setFrom(String str) {
        this.adg = str;
    }

    public void a(a aVar) {
        this.fuh = aVar;
    }

    public void t(String str, long j) {
        new b(str, j, this.adg, this.fuh).execute(new Integer[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String adg;
        private com.baidu.tbadk.core.util.ab aiu = null;
        private WeakReference<a> fui;
        private long mForumId;
        private String mForumName;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.fui = null;
            this.mForumName = str;
            this.mForumId = j;
            this.fui = new WeakReference<>(aVar);
            this.adg = str2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.aiu = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.aiu.n("fid", String.valueOf(this.mForumId));
                    this.aiu.n("kw", this.mForumName);
                    this.aiu.n("favo_type", "1");
                    this.aiu.n("st_type", this.adg);
                    this.aiu.uS().vN().mIsNeedTbs = true;
                    this.aiu.uu();
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
            if (this.fui != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.fui.get();
                if (aVar2 != null) {
                    if (this.aiu != null) {
                        if (this.aiu.uS().vO().oF()) {
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
