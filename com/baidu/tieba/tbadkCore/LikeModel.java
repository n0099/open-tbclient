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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    public static final int HASLIKE_ERROR = 22;
    private String from;
    private a ggA;
    private String ggB;
    private String ggz;
    private String mForumId;
    private String mForumName;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.ggz = null;
        this.ggA = null;
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

    public void brK() {
        if (this.ggA != null) {
            this.ggA.cancel();
            this.ggA = null;
        }
    }

    public void J(String str, String str2, String str3) {
        ce(str, str2);
        this.ggz = str3;
    }

    public void ce(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.ggA == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.ggA = new a();
            this.ggA.setPriority(2);
            this.ggA.execute(new Object[0]);
        }
    }

    public boolean brL() {
        return this.ggA != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, o> {
        private volatile w mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public o doInBackground(Object... objArr) {
            try {
                this.mNetwork = new w(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.n("kw", LikeModel.this.mForumName);
                this.mNetwork.n("fid", LikeModel.this.mForumId);
                this.mNetwork.n("st_type", LikeModel.this.from);
                if (!StringUtils.isNull(LikeModel.this.ggB)) {
                    this.mNetwork.n("dev_id", LikeModel.this.ggB);
                }
                if (!TextUtils.isEmpty(LikeModel.this.ggz)) {
                    this.mNetwork.n("pagefrom", LikeModel.this.ggz);
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("forum_name", LikeModel.this.mForumName);
                this.mNetwork.vl().wh().mIsNeedTbs = true;
                String uO = this.mNetwork.uO();
                int vp = this.mNetwork.vo() ? this.mNetwork.vp() : this.mNetwork.vq();
                String errorString = this.mNetwork.vo() ? this.mNetwork.getErrorString() : this.mNetwork.vr();
                LikeModel.this.setErrorCode(vp);
                LikeModel.this.setErrorString(errorString);
                if (this.mNetwork.vl().wi().isRequestSuccess() && uO != null) {
                    o oVar = new o();
                    oVar.parserJson(uO);
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
                aVar.forumId = com.baidu.adp.lib.g.b.d(oVar.getFid(), 0L);
                if (oVar != null && this.mNetwork.vl().wi().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.d(oVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new c.a(LikeModel.this.mForumName, oVar.getUserLevel())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.g(oVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
                LikeModel.this.ggA = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fA();
                this.mNetwork = null;
            }
            LikeModel.this.ggA = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.g(null);
            }
        }
    }
}
