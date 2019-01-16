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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.util.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private String hor;
    private String hos;
    private a hot;
    private String mAuthSid;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.hor = null;
        this.hot = null;
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

    public void bEh() {
        if (this.hot != null) {
            this.hot.cancel();
            this.hot = null;
        }
    }

    public void Q(String str, String str2, String str3) {
        cM(str, str2);
        this.hor = str3;
    }

    public void cM(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.hot == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.hot = new a();
            this.hot.setPriority(2);
            this.hot.execute(new Object[0]);
        }
    }

    public boolean bEi() {
        return this.hot != null;
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
        /* renamed from: I */
        public r doInBackground(Object... objArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.x("kw", LikeModel.this.mForumName);
                this.mNetwork.x(ImageViewerConfig.FORUM_ID, LikeModel.this.mForumId);
                this.mNetwork.x("st_type", LikeModel.this.from);
                this.mNetwork.x("authsid", LikeModel.this.mAuthSid);
                if (!StringUtils.isNull(LikeModel.this.hos)) {
                    this.mNetwork.x("dev_id", LikeModel.this.hos);
                }
                if (!TextUtils.isEmpty(LikeModel.this.hor)) {
                    this.mNetwork.x("pagefrom", LikeModel.this.hor);
                }
                this.mNetwork.x("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.x("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.x("forum_name", LikeModel.this.mForumName);
                this.mNetwork.Dw().Eu().mIsNeedTbs = true;
                this.mNetwork.bt(true);
                String CY = this.mNetwork.CY();
                int DA = this.mNetwork.DA();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(DA);
                LikeModel.this.setErrorString(errorString);
                this.tokenData = AuthTokenData.parse(CY);
                if (CY != null) {
                    r rVar = new r();
                    rVar.parserJson(CY);
                    if (this.mNetwork.Dw().Ev().isRequestSuccess()) {
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
        /* renamed from: d */
        public void onPostExecute(r rVar) {
            LikeModel.this.hot = null;
            if (this.mNetwork != null && rVar != null && !AntiHelper.e(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), rVar.bEj())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.d(rVar.getFid(), 0L);
                if (rVar != null && this.mNetwork.Dw().Ev().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(com.baidu.adp.lib.g.b.d(rVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new d.a(LikeModel.this.mForumName, rVar.bBj())));
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
                this.mNetwork.jg();
                this.mNetwork = null;
            }
            LikeModel.this.hot = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.m(null);
            }
        }
    }
}
