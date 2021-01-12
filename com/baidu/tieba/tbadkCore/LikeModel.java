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
    private String mAuthSid;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private String nlA;
    private a nlB;
    private String nlz;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.nlz = null;
        this.nlB = null;
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

    public void dKC() {
        if (this.nlB != null) {
            this.nlB.cancel();
            this.nlB = null;
        }
    }

    public void aN(String str, String str2, String str3) {
        gq(str, str2);
        this.nlz = str3;
    }

    public void gq(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.nlB == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.nlB = new a();
            this.nlB.setPriority(2);
            this.nlB.execute(new Object[0]);
        }
    }

    public boolean dKD() {
        return this.nlB != null;
    }

    public Context getContext() {
        if (this.mPageContext != null) {
            return this.mPageContext.getPageActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, w> {
        private volatile com.baidu.tbadk.core.util.z mNetwork;
        private AuthTokenData tokenData;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public w doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.addPostData("kw", LikeModel.this.mForumName);
                this.mNetwork.addPostData("fid", LikeModel.this.mForumId);
                this.mNetwork.addPostData("st_type", LikeModel.this.from);
                this.mNetwork.addPostData("authsid", LikeModel.this.mAuthSid);
                if (!StringUtils.isNull(LikeModel.this.nlA)) {
                    this.mNetwork.addPostData("dev_id", LikeModel.this.nlA);
                }
                if (!TextUtils.isEmpty(LikeModel.this.nlz)) {
                    this.mNetwork.addPostData("pagefrom", LikeModel.this.nlz);
                }
                this.mNetwork.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.addPostData("forum_name", LikeModel.this.mForumName);
                this.mNetwork.brX().bsG().mIsNeedTbs = true;
                this.mNetwork.jI(true);
                String postNetData = this.mNetwork.postNetData();
                int serverErrorCode = this.mNetwork.getServerErrorCode();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(serverErrorCode);
                LikeModel.this.setErrorString(errorString);
                this.tokenData = AuthTokenData.parse(postNetData);
                if (postNetData != null) {
                    w wVar = new w();
                    wVar.parserJson(postNetData);
                    if (this.mNetwork.brX().bsH().isRequestSuccess()) {
                        wVar.setBlockPopInfoData(null);
                    }
                    LikeModel.this.mBlockPopInfoData = wVar.getBlockPopInfoData();
                    wVar.setFid(LikeModel.this.mForumId);
                    return wVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            w wVar2 = new w();
            wVar2.setLike(0);
            wVar2.setFid(LikeModel.this.mForumId);
            return wVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(w wVar) {
            LikeModel.this.nlB = null;
            if (this.mNetwork != null && wVar != null && !AntiHelper.c(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), wVar.dKE())) {
                com.baidu.tieba.tbadkCore.writeModel.e eVar = new com.baidu.tieba.tbadkCore.writeModel.e();
                eVar.forumId = com.baidu.adp.lib.f.b.toLong(wVar.getFid(), 0L);
                eVar.likeNum = wVar.getLikeNum();
                if (wVar != null && this.mNetwork.brX().bsH().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(wVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new e.a(LikeModel.this.mForumName, wVar.bKd())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    eVar.isSuccess = true;
                    eVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    eVar.isSuccess = false;
                    eVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.callback(wVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, eVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
                this.mNetwork = null;
            }
            LikeModel.this.nlB = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.callback(null);
            }
        }
    }
}
