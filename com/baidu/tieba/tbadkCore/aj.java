package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class aj {
    private a dGf;
    private String mFrom = "bar_detail";

    /* loaded from: classes.dex */
    public interface a {
        void g(String str, long j);

        void h(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.dGf = aVar;
    }

    public void m(String str, long j) {
        new b(str, j, this.mFrom, this.dGf).execute(new Integer[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private com.baidu.tbadk.core.util.ab ahV = null;
        private WeakReference<a> dGg;
        private long mForumId;
        private String mForumName;
        private String mFrom;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.dGg = null;
            this.mForumName = str;
            this.mForumId = j;
            this.dGg = new WeakReference<>(aVar);
            this.mFrom = str2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.ahV = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.ahV.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                    this.ahV.o("kw", this.mForumName);
                    this.ahV.o("favo_type", "1");
                    this.ahV.o("st_type", this.mFrom);
                    this.ahV.uw().vp().mIsNeedTbs = true;
                    this.ahV.tV();
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
            if (this.dGg != null && (aVar = this.dGg.get()) != null) {
                if (this.ahV != null) {
                    if (this.ahV.uw().vq().qO()) {
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
