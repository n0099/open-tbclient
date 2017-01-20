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
public class ah {
    private String aci = "bar_detail";
    private a foU;

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, long j);

        void k(String str, long j);
    }

    public void setFrom(String str) {
        this.aci = str;
    }

    public void a(a aVar) {
        this.foU = aVar;
    }

    public void t(String str, long j) {
        new b(str, j, this.aci, this.foU).execute(new Integer[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String aci;
        private WeakReference<a> foV;
        private long mForumId;
        private String mForumName;
        private com.baidu.tbadk.core.util.y mNetwork = null;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.foV = null;
            this.mForumName = str;
            this.mForumId = j;
            this.foV = new WeakReference<>(aVar);
            this.aci = str2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.mNetwork = new com.baidu.tbadk.core.util.y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.n("fid", String.valueOf(this.mForumId));
                    this.mNetwork.n("kw", this.mForumName);
                    this.mNetwork.n("favo_type", "1");
                    this.mNetwork.n("st_type", this.aci);
                    this.mNetwork.uC().vv().mIsNeedTbs = true;
                    this.mNetwork.ud();
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
            if (this.foV != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.foV.get();
                if (aVar2 != null) {
                    if (this.mNetwork != null) {
                        if (this.mNetwork.uC().vw().isRequestSuccess()) {
                            if (num.intValue() == 1) {
                                TbadkCoreApplication.m9getInst().delLikeForum(this.mForumName);
                                aVar2.j(this.mForumName, this.mForumId);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(this.mForumId)));
                                aVar.isSuccess = true;
                            } else {
                                aVar2.k(this.mForumName, this.mForumId);
                                aVar.isSuccess = false;
                            }
                        } else {
                            aVar2.k(this.mForumName, this.mForumId);
                            aVar.isSuccess = false;
                        }
                    } else {
                        aVar2.k(this.mForumName, this.mForumId);
                        aVar.isSuccess = false;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM, aVar));
                }
            }
        }
    }
}
