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
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.util.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private String jhp;
    private String jhq;
    private a jhr;
    private String mAuthSid;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.jhp = null;
        this.jhr = null;
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

    public void cpO() {
        if (this.jhr != null) {
            this.jhr.cancel();
            this.jhr = null;
        }
    }

    public void ae(String str, String str2, String str3) {
        em(str, str2);
        this.jhp = str3;
    }

    public void em(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.jhr == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.jhr = new a();
            this.jhr.setPriority(2);
            this.jhr.execute(new Object[0]);
        }
    }

    public boolean cpP() {
        return this.jhr != null;
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
        /* renamed from: J */
        public t doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.o("kw", LikeModel.this.mForumName);
                this.mNetwork.o("fid", LikeModel.this.mForumId);
                this.mNetwork.o("st_type", LikeModel.this.from);
                this.mNetwork.o("authsid", LikeModel.this.mAuthSid);
                if (!StringUtils.isNull(LikeModel.this.jhq)) {
                    this.mNetwork.o("dev_id", LikeModel.this.jhq);
                }
                if (!TextUtils.isEmpty(LikeModel.this.jhp)) {
                    this.mNetwork.o("pagefrom", LikeModel.this.jhp);
                }
                this.mNetwork.o("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.o("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.o("forum_name", LikeModel.this.mForumName);
                this.mNetwork.aiK().ajM().mIsNeedTbs = true;
                this.mNetwork.eb(true);
                String aim = this.mNetwork.aim();
                int aiO = this.mNetwork.aiO();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(aiO);
                LikeModel.this.setErrorString(errorString);
                this.tokenData = AuthTokenData.parse(aim);
                if (aim != null) {
                    t tVar = new t();
                    tVar.parserJson(aim);
                    if (this.mNetwork.aiK().ajN().isRequestSuccess()) {
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
            LikeModel.this.jhr = null;
            if (this.mNetwork != null && tVar != null && !AntiHelper.d(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), tVar.cpQ())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.e(tVar.getFid(), 0L);
                if (tVar != null && this.mNetwork.aiK().ajN().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(com.baidu.adp.lib.g.b.e(tVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new d.a(LikeModel.this.mForumName, tVar.coa())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.m(tVar);
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
            LikeModel.this.jhr = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.m(null);
            }
        }
    }
}
