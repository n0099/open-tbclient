package com.baidu.tieba.tbadkCore;

import android.content.Context;
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
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.util.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private String jdN;
    private String jdO;
    private a jdP;
    private String mAuthSid;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.jdN = null;
        this.jdP = null;
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

    public void coE() {
        if (this.jdP != null) {
            this.jdP.cancel();
            this.jdP = null;
        }
    }

    public void ac(String str, String str2, String str3) {
        el(str, str2);
        this.jdN = str3;
    }

    public void el(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.jdP == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.jdP = new a();
            this.jdP.setPriority(2);
            this.jdP.execute(new Object[0]);
        }
    }

    public boolean coF() {
        return this.jdP != null;
    }

    public Context getContext() {
        if (this.mPageContext != null) {
            return this.mPageContext.getPageActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, r> {
        private volatile x mNetwork;
        private AuthTokenData tokenData;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: J */
        public r doInBackground(Object... objArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.o("kw", LikeModel.this.mForumName);
                this.mNetwork.o("fid", LikeModel.this.mForumId);
                this.mNetwork.o("st_type", LikeModel.this.from);
                this.mNetwork.o("authsid", LikeModel.this.mAuthSid);
                if (!StringUtils.isNull(LikeModel.this.jdO)) {
                    this.mNetwork.o("dev_id", LikeModel.this.jdO);
                }
                if (!TextUtils.isEmpty(LikeModel.this.jdN)) {
                    this.mNetwork.o("pagefrom", LikeModel.this.jdN);
                }
                this.mNetwork.o("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.o("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.o("forum_name", LikeModel.this.mForumName);
                this.mNetwork.aiE().ajE().mIsNeedTbs = true;
                this.mNetwork.eb(true);
                String aig = this.mNetwork.aig();
                int aiI = this.mNetwork.aiI();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(aiI);
                LikeModel.this.setErrorString(errorString);
                this.tokenData = AuthTokenData.parse(aig);
                if (aig != null) {
                    r rVar = new r();
                    rVar.parserJson(aig);
                    if (this.mNetwork.aiE().ajF().isRequestSuccess()) {
                        rVar.setBlockPopInfoData(null);
                    }
                    LikeModel.this.mBlockPopInfoData = rVar.getBlockPopInfoData();
                    rVar.setFid(LikeModel.this.mForumId);
                    return rVar;
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
        /* renamed from: c */
        public void onPostExecute(r rVar) {
            LikeModel.this.jdP = null;
            if (this.mNetwork != null && rVar != null && !AntiHelper.d(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), rVar.coG())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.c(rVar.getFid(), 0L);
                if (rVar != null && this.mNetwork.aiE().ajF().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(com.baidu.adp.lib.g.b.c(rVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new d.a(LikeModel.this.mForumName, rVar.cmV())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.m(rVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ik();
                this.mNetwork = null;
            }
            LikeModel.this.jdP = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.m(null);
            }
        }
    }
}
