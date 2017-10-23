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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    public static final int HASLIKE_ERROR = 22;
    private String from;
    private String gfg;
    private a gfh;
    private String gfi;
    private String mForumId;
    private String mForumName;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.gfg = null;
        this.gfh = null;
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

    public void bqB() {
        if (this.gfh != null) {
            this.gfh.cancel();
            this.gfh = null;
        }
    }

    public void J(String str, String str2, String str3) {
        ca(str, str2);
        this.gfg = str3;
    }

    public void ca(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.gfh == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.gfh = new a();
            this.gfh.setPriority(2);
            this.gfh.execute(new Object[0]);
        }
    }

    public boolean bqC() {
        return this.gfh != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, o> {
        private volatile x mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: B */
        public o doInBackground(Object... objArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.n("kw", LikeModel.this.mForumName);
                this.mNetwork.n("fid", LikeModel.this.mForumId);
                this.mNetwork.n("st_type", LikeModel.this.from);
                if (!StringUtils.isNull(LikeModel.this.gfi)) {
                    this.mNetwork.n("dev_id", LikeModel.this.gfi);
                }
                if (!TextUtils.isEmpty(LikeModel.this.gfg)) {
                    this.mNetwork.n("pagefrom", LikeModel.this.gfg);
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("forum_name", LikeModel.this.mForumName);
                this.mNetwork.uG().vC().mIsNeedTbs = true;
                String ui = this.mNetwork.ui();
                int uK = this.mNetwork.uJ() ? this.mNetwork.uK() : this.mNetwork.uL();
                String errorString = this.mNetwork.uJ() ? this.mNetwork.getErrorString() : this.mNetwork.uM();
                LikeModel.this.setErrorCode(uK);
                LikeModel.this.setErrorString(errorString);
                if (this.mNetwork.uG().vD().isRequestSuccess() && ui != null) {
                    o oVar = new o();
                    oVar.parserJson(ui);
                    oVar.setFid(LikeModel.this.mForumId);
                    return oVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            o oVar2 = new o();
            oVar2.setLike(0);
            oVar2.setFid(LikeModel.this.mForumId);
            return oVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(o oVar) {
            if (this.mNetwork != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.c(oVar.getFid(), 0L);
                if (oVar != null && this.mNetwork.uG().vD().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(oVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new c.a(LikeModel.this.mForumName, oVar.getUserLevel())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.f(oVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
                LikeModel.this.gfh = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
                this.mNetwork = null;
            }
            LikeModel.this.gfh = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.f(null);
            }
        }
    }
}
