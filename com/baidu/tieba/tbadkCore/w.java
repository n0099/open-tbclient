package com.baidu.tieba.tbadkCore;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.y;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class w {
    private a gMg;
    private String mFrom = "bar_detail";

    /* loaded from: classes.dex */
    public interface a {
        void m(String str, long j);

        void n(String str, long j);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void a(a aVar) {
        this.gMg = aVar;
    }

    public void t(String str, long j) {
        new b(str, j, this.mFrom, this.gMg).execute(new Integer[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<Integer, Integer, Integer> {
        private WeakReference<a> gMh;
        private long mForumId;
        private String mForumName;
        private String mFrom;
        private y mNetwork = null;

        public b(String str, long j, String str2, a aVar) {
            this.mForumName = null;
            this.mForumId = 0L;
            this.gMh = null;
            this.mForumName = str;
            this.mForumId = j;
            this.gMh = new WeakReference<>(aVar);
            this.mFrom = str2;
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
                    this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.mForumId));
                    this.mNetwork.o("kw", this.mForumName);
                    this.mNetwork.o("favo_type", "1");
                    this.mNetwork.o("st_type", this.mFrom);
                    this.mNetwork.yX().zX().mIsNeedTbs = true;
                    this.mNetwork.yz();
                    if (this.mNetwork.yX().zY().isRequestSuccess()) {
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
            if (this.gMh != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = this.mForumId;
                a aVar2 = this.gMh.get();
                if (aVar2 != null) {
                    if (num.intValue() == 1 && this.mNetwork != null && this.mNetwork.yX().zY().isRequestSuccess()) {
                        TbadkCoreApplication.getInst().delLikeForum(this.mForumName);
                        aVar2.m(this.mForumName, this.mForumId);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(this.mForumId)));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.mForumName));
                        aVar.isSuccess = true;
                    } else {
                        aVar2.n(this.mForumName, this.mForumId);
                        aVar.isSuccess = false;
                        if (this.mNetwork != null) {
                            aVar.errorMessage = this.mNetwork.za() ? this.mNetwork.getErrorString() : this.mNetwork.zd();
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001438, aVar));
                }
            }
        }
    }
}
