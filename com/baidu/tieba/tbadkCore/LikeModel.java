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
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    public static final int HASLIKE_ERROR = 22;
    private String from;
    private String fsR;
    private a fsS;
    private String fsT;
    private String mForumId;
    private String mForumName;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.fsR = null;
        this.fsS = null;
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

    public void bgM() {
        if (this.fsS != null) {
            this.fsS.cancel();
            this.fsS = null;
        }
    }

    public void H(String str, String str2, String str3) {
        bY(str, str2);
        this.fsR = str3;
    }

    public void bY(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.fsS == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.fsS = new a(this, null);
            this.fsS.setPriority(2);
            this.fsS.execute(new Object[0]);
        }
    }

    public boolean bgN() {
        return this.fsS != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, v> {
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
        /* renamed from: F */
        public v doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.mNetwork.n("kw", LikeModel.this.mForumName);
                this.mNetwork.n("fid", LikeModel.this.mForumId);
                this.mNetwork.n("st_type", LikeModel.this.from);
                if (!StringUtils.isNull(LikeModel.this.fsT)) {
                    this.mNetwork.n("dev_id", LikeModel.this.fsT);
                }
                if (!TextUtils.isEmpty(LikeModel.this.fsR)) {
                    this.mNetwork.n("pagefrom", LikeModel.this.fsR);
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("forum_name", LikeModel.this.mForumName);
                this.mNetwork.uZ().vS().mIsNeedTbs = true;
                String uB = this.mNetwork.uB();
                if (!this.mNetwork.uZ().vT().vc()) {
                    LikeModel.this.setErrorCode(this.mNetwork.ve());
                    LikeModel.this.setErrorString(this.mNetwork.vf());
                } else {
                    LikeModel.this.setErrorCode(this.mNetwork.vd());
                    LikeModel.this.setErrorString(this.mNetwork.getErrorString());
                }
                if (this.mNetwork.uZ().vT().isRequestSuccess() && uB != null) {
                    v vVar = new v();
                    vVar.parserJson(uB);
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
        /* renamed from: d */
        public void onPostExecute(v vVar) {
            LikeModel.this.fsS = null;
            com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
            aVar.forumId = com.baidu.adp.lib.g.b.c(vVar.getFid(), 0L);
            if (this.mNetwork != null) {
                if (this.mNetwork.uZ().vT().isRequestSuccess() && LikeModel.this.getErrorCode() == 0 && vVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(vVar.getFid(), 0L))));
                    TbadkCoreApplication.m9getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = this.mNetwork.uZ().vT().mErrorString;
                }
            } else {
                aVar.isSuccess = false;
            }
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.g(vVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fm();
                this.mNetwork = null;
            }
            LikeModel.this.fsS = null;
            super.cancel(true);
            LikeModel.this.mLoadDataCallBack.g(null);
        }
    }
}
