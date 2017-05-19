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
    private String from;
    private String fsW;
    private a fsX;
    private String fsY;
    private String mForumId;
    private String mForumName;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.fsW = null;
        this.fsX = null;
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

    public void bfV() {
        if (this.fsX != null) {
            this.fsX.cancel();
            this.fsX = null;
        }
    }

    public void D(String str, String str2, String str3) {
        bY(str, str2);
        this.fsW = str3;
    }

    public void bY(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.fsX == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.fsX = new a(this, null);
            this.fsX.setPriority(2);
            this.fsX.execute(new Object[0]);
        }
    }

    public boolean bfW() {
        return this.fsX != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, t> {
        private volatile com.baidu.tbadk.core.util.z mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* synthetic */ a(LikeModel likeModel, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public t doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.mNetwork.n("kw", LikeModel.this.mForumName);
                this.mNetwork.n("fid", LikeModel.this.mForumId);
                this.mNetwork.n("st_type", LikeModel.this.from);
                if (!StringUtils.isNull(LikeModel.this.fsY)) {
                    this.mNetwork.n("dev_id", LikeModel.this.fsY);
                }
                if (!TextUtils.isEmpty(LikeModel.this.fsW)) {
                    this.mNetwork.n("pagefrom", LikeModel.this.fsW);
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("forum_name", LikeModel.this.mForumName);
                this.mNetwork.uJ().vD().mIsNeedTbs = true;
                String ul = this.mNetwork.ul();
                if (!this.mNetwork.uJ().vE().uM()) {
                    LikeModel.this.setErrorCode(this.mNetwork.uO());
                    LikeModel.this.setErrorString(this.mNetwork.uP());
                } else {
                    LikeModel.this.setErrorCode(this.mNetwork.uN());
                    LikeModel.this.setErrorString(this.mNetwork.getErrorString());
                }
                if (this.mNetwork.uJ().vE().isRequestSuccess() && ul != null) {
                    t tVar = new t();
                    tVar.parserJson(ul);
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
            LikeModel.this.fsX = null;
            com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
            aVar.forumId = com.baidu.adp.lib.g.b.c(tVar.getFid(), 0L);
            if (this.mNetwork != null) {
                if (this.mNetwork.uJ().vE().isRequestSuccess() && LikeModel.this.getErrorCode() == 0 && tVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(tVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new c.a(LikeModel.this.mForumName, tVar.getUserLevel())));
                    TbadkCoreApplication.m9getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = this.mNetwork.uJ().vE().mErrorString;
                }
            } else {
                aVar.isSuccess = false;
            }
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.g(tVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fs();
                this.mNetwork = null;
            }
            LikeModel.this.fsX = null;
            super.cancel(true);
            LikeModel.this.mLoadDataCallBack.g(null);
        }
    }
}
