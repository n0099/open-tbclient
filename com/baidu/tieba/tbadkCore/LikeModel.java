package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private String hhs;
    private a hht;
    private String hhu;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.hhs = null;
        this.hht = null;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.mBlockPopInfoData;
    }

    public void bBx() {
        if (this.hht != null) {
            this.hht.cancel();
            this.hht = null;
        }
    }

    public void K(String str, String str2, String str3) {
        cf(str, str2);
        this.hhs = str3;
    }

    public void cf(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.hht == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.hht = new a();
            this.hht.setPriority(2);
            this.hht.execute(new Object[0]);
        }
    }

    public boolean bBy() {
        return this.hht != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, r> {
        private volatile com.baidu.tbadk.core.util.x mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public r doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.n("kw", LikeModel.this.mForumName);
                this.mNetwork.n(ImageViewerConfig.FORUM_ID, LikeModel.this.mForumId);
                this.mNetwork.n("st_type", LikeModel.this.from);
                if (!StringUtils.isNull(LikeModel.this.hhu)) {
                    this.mNetwork.n("dev_id", LikeModel.this.hhu);
                }
                if (!TextUtils.isEmpty(LikeModel.this.hhs)) {
                    this.mNetwork.n("pagefrom", LikeModel.this.hhs);
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("forum_name", LikeModel.this.mForumName);
                this.mNetwork.Cn().Dk().mIsNeedTbs = true;
                String BP = this.mNetwork.BP();
                int Cr = this.mNetwork.Cq() ? this.mNetwork.Cr() : this.mNetwork.Cs();
                String errorString = this.mNetwork.Cq() ? this.mNetwork.getErrorString() : this.mNetwork.Ct();
                LikeModel.this.setErrorCode(Cr);
                LikeModel.this.setErrorString(errorString);
                if (BP != null) {
                    r rVar = new r();
                    rVar.parserJson(BP);
                    if (rVar.getBlockPopInfoData() != null) {
                        LikeModel.this.mBlockPopInfoData = rVar.getBlockPopInfoData();
                    }
                    if (this.mNetwork.Cn().Dl().isRequestSuccess()) {
                        rVar.setFid(LikeModel.this.mForumId);
                        return rVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            r rVar2 = new r();
            rVar2.setLike(0);
            rVar2.setFid(LikeModel.this.mForumId);
            return rVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(r rVar) {
            if (this.mNetwork != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.c(rVar.getFid(), 0L);
                if (rVar != null && this.mNetwork.Cn().Dl().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(rVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new c.a(LikeModel.this.mForumName, rVar.getUserLevel())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.ak(rVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
                LikeModel.this.hht = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mR();
                this.mNetwork = null;
            }
            LikeModel.this.hht = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.ak(null);
            }
        }
    }
}
