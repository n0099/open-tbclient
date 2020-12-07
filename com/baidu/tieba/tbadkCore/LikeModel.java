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
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private String mAuthSid;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;
    private String nkx;
    private String nky;
    private a nkz;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.nkx = null;
        this.nkz = null;
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

    public void dOA() {
        if (this.nkz != null) {
            this.nkz.cancel();
            this.nkz = null;
        }
    }

    public void aL(String str, String str2, String str3) {
        gu(str, str2);
        this.nkx = str3;
    }

    public void gu(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.nkz == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.nkz = new a();
            this.nkz.setPriority(2);
            this.nkz.execute(new Object[0]);
        }
    }

    public boolean dOB() {
        return this.nkz != null;
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
        private volatile com.baidu.tbadk.core.util.aa mNetwork;
        private AuthTokenData tokenData;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public w doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.addPostData("kw", LikeModel.this.mForumName);
                this.mNetwork.addPostData("fid", LikeModel.this.mForumId);
                this.mNetwork.addPostData("st_type", LikeModel.this.from);
                this.mNetwork.addPostData("authsid", LikeModel.this.mAuthSid);
                if (!StringUtils.isNull(LikeModel.this.nky)) {
                    this.mNetwork.addPostData("dev_id", LikeModel.this.nky);
                }
                if (!TextUtils.isEmpty(LikeModel.this.nkx)) {
                    this.mNetwork.addPostData("pagefrom", LikeModel.this.nkx);
                }
                this.mNetwork.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.addPostData("forum_name", LikeModel.this.mForumName);
                this.mNetwork.btv().bue().mIsNeedTbs = true;
                this.mNetwork.jq(true);
                String postNetData = this.mNetwork.postNetData();
                int serverErrorCode = this.mNetwork.getServerErrorCode();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(serverErrorCode);
                LikeModel.this.setErrorString(errorString);
                this.tokenData = AuthTokenData.parse(postNetData);
                if (postNetData != null) {
                    w wVar = new w();
                    wVar.parserJson(postNetData);
                    if (this.mNetwork.btv().buf().isRequestSuccess()) {
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
            LikeModel.this.nkz = null;
            if (this.mNetwork != null && wVar != null && !AntiHelper.c(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), wVar.dOC())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.f.b.toLong(wVar.getFid(), 0L);
                aVar.likeNum = wVar.getLikeNum();
                if (wVar != null && this.mNetwork.btv().buf().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.f.b.toLong(wVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new f.a(LikeModel.this.mForumName, wVar.bLB())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.callback(wVar);
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
            LikeModel.this.nkz = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.callback(null);
            }
        }
    }
}
