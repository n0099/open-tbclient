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
    private String kfl;
    private String kfm;
    private a kfn;
    private String mAuthSid;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.kfl = null;
        this.kfn = null;
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

    public void cKu() {
        if (this.kfn != null) {
            this.kfn.cancel();
            this.kfn = null;
        }
    }

    public void au(String str, String str2, String str3) {
        eC(str, str2);
        this.kfl = str3;
    }

    public void eC(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.kfn == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.kfn = new a();
            this.kfn.setPriority(2);
            this.kfn.execute(new Object[0]);
        }
    }

    public boolean cKv() {
        return this.kfn != null;
    }

    public Context getContext() {
        if (this.mPageContext != null) {
            return this.mPageContext.getPageActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, t> {
        private volatile com.baidu.tbadk.core.util.x mNetwork;
        private AuthTokenData tokenData;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public t doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.addPostData("kw", LikeModel.this.mForumName);
                this.mNetwork.addPostData("fid", LikeModel.this.mForumId);
                this.mNetwork.addPostData("st_type", LikeModel.this.from);
                this.mNetwork.addPostData("authsid", LikeModel.this.mAuthSid);
                if (!StringUtils.isNull(LikeModel.this.kfm)) {
                    this.mNetwork.addPostData("dev_id", LikeModel.this.kfm);
                }
                if (!TextUtils.isEmpty(LikeModel.this.kfl)) {
                    this.mNetwork.addPostData("pagefrom", LikeModel.this.kfl);
                }
                this.mNetwork.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.addPostData("forum_name", LikeModel.this.mForumName);
                this.mNetwork.aGg().aGH().mIsNeedTbs = true;
                this.mNetwork.fK(true);
                String postNetData = this.mNetwork.postNetData();
                int serverErrorCode = this.mNetwork.getServerErrorCode();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(serverErrorCode);
                LikeModel.this.setErrorString(errorString);
                this.tokenData = AuthTokenData.parse(postNetData);
                if (postNetData != null) {
                    t tVar = new t();
                    tVar.parserJson(postNetData);
                    if (this.mNetwork.aGg().aGI().isRequestSuccess()) {
                        tVar.setBlockPopInfoData(null);
                    }
                    LikeModel.this.mBlockPopInfoData = tVar.getBlockPopInfoData();
                    tVar.setFid(LikeModel.this.mForumId);
                    return tVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            t tVar2 = new t();
            tVar2.setLike(0);
            tVar2.setFid(LikeModel.this.mForumId);
            return tVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(t tVar) {
            LikeModel.this.kfn = null;
            if (this.mNetwork != null && tVar != null && !AntiHelper.d(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), tVar.cKw())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.f.b.toLong(tVar.getFid(), 0L);
                if (tVar != null && this.mNetwork.aGg().aGI().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(tVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new e.a(LikeModel.this.mForumName, tVar.cIK())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.callback(tVar);
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
            LikeModel.this.kfn = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.callback(null);
            }
        }
    }
}
