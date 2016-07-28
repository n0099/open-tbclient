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
public class an {
    private String aaf = "bar_detail";
    private a fjH;

    /* loaded from: classes.dex */
    public interface a {
        void h(String str, long j);

        void i(String str, long j);
    }

    public void setFrom(String str) {
        this.aaf = str;
    }

    public void a(a aVar) {
        this.fjH = aVar;
    }

    public void r(String str, long j) {
        new b(str, j, this.aaf, this.fjH).execute(new Integer[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String aaf;
        private com.baidu.tbadk.core.util.ab afX = null;
        private WeakReference<a> fjI;
        private long mForumId;
        private String mForumName;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.fjI = null;
            this.mForumName = str;
            this.mForumId = j;
            this.fjI = new WeakReference<>(aVar);
            this.aaf = str2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.afX = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.afX.n("fid", String.valueOf(this.mForumId));
                    this.afX.n("kw", this.mForumName);
                    this.afX.n("favo_type", "1");
                    this.afX.n("st_type", this.aaf);
                    this.afX.tx().uu().mIsNeedTbs = true;
                    this.afX.sZ();
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
            a aVar;
            super.onPostExecute((b) num);
            if (this.fjI != null && (aVar = this.fjI.get()) != null) {
                if (this.afX != null) {
                    if (this.afX.tx().uv().nJ()) {
                        if (num.intValue() == 1) {
                            TbadkCoreApplication.m10getInst().delLikeForum(this.mForumName);
                            aVar.h(this.mForumName, this.mForumId);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(this.mForumId)));
                            return;
                        }
                        aVar.i(this.mForumName, this.mForumId);
                        return;
                    }
                    aVar.i(this.mForumName, this.mForumId);
                    return;
                }
                aVar.i(this.mForumName, this.mForumId);
            }
        }
    }
}
