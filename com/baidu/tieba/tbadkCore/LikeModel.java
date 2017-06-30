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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    public static final int HASLIKE_ERROR = 22;
    private String fKR;
    private a fKS;
    private String fKT;
    private String from;
    private String mForumId;
    private String mForumName;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.fKR = null;
        this.fKS = null;
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

    public void blG() {
        if (this.fKS != null) {
            this.fKS.cancel();
            this.fKS = null;
        }
    }

    public void I(String str, String str2, String str3) {
        cc(str, str2);
        this.fKR = str3;
    }

    public void cc(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.fKS == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.fKS = new a(this, null);
            this.fKS.setPriority(2);
            this.fKS.execute(new Object[0]);
        }
    }

    public boolean blH() {
        return this.fKS != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, t> {
        private volatile com.baidu.tbadk.core.util.ab mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* synthetic */ a(LikeModel likeModel, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public t doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.mNetwork.n("kw", LikeModel.this.mForumName);
                this.mNetwork.n("fid", LikeModel.this.mForumId);
                this.mNetwork.n("st_type", LikeModel.this.from);
                if (!StringUtils.isNull(LikeModel.this.fKT)) {
                    this.mNetwork.n("dev_id", LikeModel.this.fKT);
                }
                if (!TextUtils.isEmpty(LikeModel.this.fKR)) {
                    this.mNetwork.n("pagefrom", LikeModel.this.fKR);
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("forum_name", LikeModel.this.mForumName);
                this.mNetwork.uV().vR().mIsNeedTbs = true;
                String uy = this.mNetwork.uy();
                int uZ = this.mNetwork.uY() ? this.mNetwork.uZ() : this.mNetwork.va();
                String errorString = this.mNetwork.uY() ? this.mNetwork.getErrorString() : this.mNetwork.vb();
                LikeModel.this.setErrorCode(uZ);
                LikeModel.this.setErrorString(errorString);
                if (this.mNetwork.uV().vS().isRequestSuccess() && uy != null) {
                    t tVar = new t();
                    tVar.parserJson(uy);
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
        /* renamed from: d */
        public void onPostExecute(t tVar) {
            if (this.mNetwork != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.c(tVar.getFid(), 0L);
                if (tVar != null && this.mNetwork.uV().vS().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(tVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new c.a(LikeModel.this.mForumName, tVar.getUserLevel())));
                    TbadkCoreApplication.m9getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.g(tVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
                LikeModel.this.fKS = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fr();
                this.mNetwork = null;
            }
            LikeModel.this.fKS = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.g(null);
            }
        }
    }
}
