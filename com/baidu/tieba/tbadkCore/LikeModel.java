package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.util.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private a ljA;
    private String ljy;
    private String ljz;
    private String mAuthSid;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.ljy = null;
        this.ljA = null;
        this.mPageContext = tbPageContext;
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

    public void dcN() {
        if (this.ljA != null) {
            this.ljA.cancel();
            this.ljA = null;
        }
    }

    public void ay(String str, String str2, String str3) {
        fq(str, str2);
        this.ljy = str3;
    }

    public void fq(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.ljA == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.ljA = new a();
            this.ljA.setPriority(2);
            this.ljA.execute(new Object[0]);
        }
    }

    public boolean dcO() {
        return this.ljA != null;
    }

    public Context getContext() {
        if (this.mPageContext != null) {
            return this.mPageContext.getPageActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, u> {
        private volatile com.baidu.tbadk.core.util.x mNetwork;
        private AuthTokenData tokenData;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public u doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.addPostData("kw", LikeModel.this.mForumName);
                this.mNetwork.addPostData("fid", LikeModel.this.mForumId);
                this.mNetwork.addPostData("st_type", LikeModel.this.from);
                this.mNetwork.addPostData("authsid", LikeModel.this.mAuthSid);
                if (!StringUtils.isNull(LikeModel.this.ljz)) {
                    this.mNetwork.addPostData("dev_id", LikeModel.this.ljz);
                }
                if (!TextUtils.isEmpty(LikeModel.this.ljy)) {
                    this.mNetwork.addPostData("pagefrom", LikeModel.this.ljy);
                }
                this.mNetwork.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.addPostData("forum_name", LikeModel.this.mForumName);
                this.mNetwork.aUA().aVa().mIsNeedTbs = true;
                this.mNetwork.ha(true);
                String postNetData = this.mNetwork.postNetData();
                int serverErrorCode = this.mNetwork.getServerErrorCode();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(serverErrorCode);
                LikeModel.this.setErrorString(errorString);
                this.tokenData = AuthTokenData.parse(postNetData);
                if (postNetData != null) {
                    u uVar = new u();
                    uVar.parserJson(postNetData);
                    if (this.mNetwork.aUA().aVb().isRequestSuccess()) {
                        uVar.setBlockPopInfoData(null);
                    }
                    LikeModel.this.mBlockPopInfoData = uVar.getBlockPopInfoData();
                    uVar.setFid(LikeModel.this.mForumId);
                    return uVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            u uVar2 = new u();
            uVar2.setLike(0);
            uVar2.setFid(LikeModel.this.mForumId);
            return uVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(u uVar) {
            LikeModel.this.ljA = null;
            if (this.mNetwork != null && uVar != null && !AntiHelper.c(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), uVar.dcP())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.f.b.toLong(uVar.getFid(), 0L);
                if (uVar != null && this.mNetwork.aUA().aVb().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(uVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new e.a(LikeModel.this.mForumName, uVar.daK())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.callback(uVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            LikeModel.this.ljA = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.callback(null);
            }
        }
    }
}
