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
import com.baidu.tbadk.util.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes2.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private String mAuthSid;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private String mdC;
    private String mdD;
    private a mdE;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.mdC = null;
        this.mdE = null;
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

    public void dvY() {
        if (this.mdE != null) {
            this.mdE.cancel();
            this.mdE = null;
        }
    }

    public void ay(String str, String str2, String str3) {
        fQ(str, str2);
        this.mdC = str3;
    }

    public void fQ(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.mdE == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.mdE = new a();
            this.mdE.setPriority(2);
            this.mdE.execute(new Object[0]);
        }
    }

    public boolean dvZ() {
        return this.mdE != null;
    }

    public Context getContext() {
        if (this.mPageContext != null) {
            return this.mPageContext.getPageActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Object, Integer, v> {
        private volatile com.baidu.tbadk.core.util.aa mNetwork;
        private AuthTokenData tokenData;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public v doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.addPostData("kw", LikeModel.this.mForumName);
                this.mNetwork.addPostData("fid", LikeModel.this.mForumId);
                this.mNetwork.addPostData("st_type", LikeModel.this.from);
                this.mNetwork.addPostData("authsid", LikeModel.this.mAuthSid);
                if (!StringUtils.isNull(LikeModel.this.mdD)) {
                    this.mNetwork.addPostData("dev_id", LikeModel.this.mdD);
                }
                if (!TextUtils.isEmpty(LikeModel.this.mdC)) {
                    this.mNetwork.addPostData("pagefrom", LikeModel.this.mdC);
                }
                this.mNetwork.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.addPostData("forum_name", LikeModel.this.mForumName);
                this.mNetwork.biQ().bjv().mIsNeedTbs = true;
                this.mNetwork.ik(true);
                String postNetData = this.mNetwork.postNetData();
                int serverErrorCode = this.mNetwork.getServerErrorCode();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(serverErrorCode);
                LikeModel.this.setErrorString(errorString);
                this.tokenData = AuthTokenData.parse(postNetData);
                if (postNetData != null) {
                    v vVar = new v();
                    vVar.parserJson(postNetData);
                    if (this.mNetwork.biQ().bjw().isRequestSuccess()) {
                        vVar.setBlockPopInfoData(null);
                    }
                    LikeModel.this.mBlockPopInfoData = vVar.getBlockPopInfoData();
                    vVar.setFid(LikeModel.this.mForumId);
                    return vVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            v vVar2 = new v();
            vVar2.setLike(0);
            vVar2.setFid(LikeModel.this.mForumId);
            return vVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(v vVar) {
            LikeModel.this.mdE = null;
            if (this.mNetwork != null && vVar != null && !AntiHelper.c(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), vVar.dwa())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.f.b.toLong(vVar.getFid(), 0L);
                aVar.likeNum = vVar.getLikeNum();
                if (vVar != null && this.mNetwork.biQ().bjw().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(vVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new f.a(LikeModel.this.mForumName, vVar.dtV())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.callback(vVar);
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
            LikeModel.this.mdE = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.callback(null);
            }
        }
    }
}
