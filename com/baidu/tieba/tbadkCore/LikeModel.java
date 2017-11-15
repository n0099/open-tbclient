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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.c;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private String goZ;
    private a gpa;
    private String gpb;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.goZ = null;
        this.gpa = null;
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

    public void btT() {
        if (this.gpa != null) {
            this.gpa.cancel();
            this.gpa = null;
        }
    }

    public void H(String str, String str2, String str3) {
        cb(str, str2);
        this.goZ = str3;
    }

    public void cb(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.gpa == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.gpa = new a();
            this.gpa.setPriority(2);
            this.gpa.execute(new Object[0]);
        }
    }

    public boolean btU() {
        return this.gpa != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, p> {
        private volatile x mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public p doInBackground(Object... objArr) {
            try {
                this.mNetwork = new x(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.n("kw", LikeModel.this.mForumName);
                this.mNetwork.n(ImageViewerConfig.FORUM_ID, LikeModel.this.mForumId);
                this.mNetwork.n("st_type", LikeModel.this.from);
                if (!StringUtils.isNull(LikeModel.this.gpb)) {
                    this.mNetwork.n("dev_id", LikeModel.this.gpb);
                }
                if (!TextUtils.isEmpty(LikeModel.this.goZ)) {
                    this.mNetwork.n("pagefrom", LikeModel.this.goZ);
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("forum_name", LikeModel.this.mForumName);
                this.mNetwork.uN().vK().mIsNeedTbs = true;
                String up = this.mNetwork.up();
                int uR = this.mNetwork.uQ() ? this.mNetwork.uR() : this.mNetwork.uS();
                String errorString = this.mNetwork.uQ() ? this.mNetwork.getErrorString() : this.mNetwork.uT();
                LikeModel.this.setErrorCode(uR);
                LikeModel.this.setErrorString(errorString);
                if (up != null) {
                    p pVar = new p();
                    pVar.parserJson(up);
                    if (pVar.getBlockPopInfoData() != null) {
                        LikeModel.this.mBlockPopInfoData = pVar.getBlockPopInfoData();
                    }
                    if (this.mNetwork.uN().vL().isRequestSuccess()) {
                        pVar.setFid(LikeModel.this.mForumId);
                        return pVar;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            p pVar2 = new p();
            pVar2.setLike(0);
            pVar2.setFid(LikeModel.this.mForumId);
            return pVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(p pVar) {
            if (this.mNetwork != null) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.c(pVar.getFid(), 0L);
                if (pVar != null && this.mNetwork.uN().vL().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(pVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM_NAME, new c.a(LikeModel.this.mForumName, pVar.getUserLevel())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.f(pVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
                LikeModel.this.gpa = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
                this.mNetwork = null;
            }
            LikeModel.this.gpa = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.f(null);
            }
        }
    }
}
