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
    private String Zw = "bar_detail";
    private a eWF;

    /* loaded from: classes.dex */
    public interface a {
        void h(String str, long j);

        void i(String str, long j);
    }

    public void setFrom(String str) {
        this.Zw = str;
    }

    public void a(a aVar) {
        this.eWF = aVar;
    }

    public void o(String str, long j) {
        new b(str, j, this.Zw, this.eWF).execute(new Integer[0]);
    }

    /* loaded from: classes.dex */
    private static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private String Zw;
        private com.baidu.tbadk.core.util.ab afj = null;
        private WeakReference<a> eWG;
        private long mForumId;
        private String mForumName;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.eWG = null;
            this.mForumName = str;
            this.mForumId = j;
            this.eWG = new WeakReference<>(aVar);
            this.Zw = str2;
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public Integer doInBackground(Integer... numArr) {
            try {
                if (this.mForumId != 0 && this.mForumName != null) {
                    this.afj = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.afj.n("fid", String.valueOf(this.mForumId));
                    this.afj.n("kw", this.mForumName);
                    this.afj.n("favo_type", "1");
                    this.afj.n("st_type", this.Zw);
                    this.afj.ty().uu().mIsNeedTbs = true;
                    this.afj.ta();
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
            if (this.eWG != null && (aVar = this.eWG.get()) != null) {
                if (this.afj != null) {
                    if (this.afj.ty().uv().nU()) {
                        if (num.intValue() == 1) {
                            TbadkCoreApplication.m9getInst().delLikeForum(this.mForumName);
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
