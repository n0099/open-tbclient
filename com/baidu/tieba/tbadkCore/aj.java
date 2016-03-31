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
public class aj {
    private String adH = "bar_detail";
    private a eoH;

    /* loaded from: classes.dex */
    public interface a {
        void g(String str, long j);

        void h(String str, long j);
    }

    public void setFrom(String str) {
        this.adH = str;
    }

    public void a(a aVar) {
        this.eoH = aVar;
    }

    public void m(String str, long j) {
        new b(str, j, this.adH, this.eoH).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String adH;
        private com.baidu.tbadk.core.util.ab aiW = null;
        private WeakReference<a> eoI;
        private long mForumId;
        private String mForumName;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.eoI = null;
            this.mForumName = str;
            this.mForumId = j;
            this.eoI = new WeakReference<>(aVar);
            this.adH = str2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.aiW = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.aiW.p("fid", String.valueOf(this.mForumId));
                    this.aiW.p("kw", this.mForumName);
                    this.aiW.p("favo_type", "1");
                    this.aiW.p("st_type", this.adH);
                    this.aiW.vU().wO().mIsNeedTbs = true;
                    this.aiW.vw();
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
            if (this.eoI != null && (aVar = this.eoI.get()) != null) {
                if (this.aiW != null) {
                    if (this.aiW.vU().wP().qC()) {
                        if (num.intValue() == 1) {
                            TbadkCoreApplication.m411getInst().delLikeForum(this.mForumName);
                            aVar.g(this.mForumName, this.mForumId);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(this.mForumId)));
                            return;
                        }
                        aVar.h(this.mForumName, this.mForumId);
                        return;
                    }
                    aVar.h(this.mForumName, this.mForumId);
                    return;
                }
                aVar.h(this.mForumName, this.mForumId);
            }
        }
    }
}
