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
    private String gnV;
    private a gnW;
    private String gnX;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.gnV = null;
        this.gnW = null;
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

    public void btH() {
        if (this.gnW != null) {
            this.gnW.cancel();
            this.gnW = null;
        }
    }

    public void H(String str, String str2, String str3) {
        bX(str, str2);
        this.gnV = str3;
    }

    public void bX(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.gnW == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.gnW = new a();
            this.gnW.setPriority(2);
            this.gnW.execute(new Object[0]);
        }
    }

    public boolean btI() {
        return this.gnW != null;
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
                if (!StringUtils.isNull(LikeModel.this.gnX)) {
                    this.mNetwork.n("dev_id", LikeModel.this.gnX);
                }
                if (!TextUtils.isEmpty(LikeModel.this.gnV)) {
                    this.mNetwork.n("pagefrom", LikeModel.this.gnV);
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
                LikeModel.this.gnW = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fo();
                this.mNetwork = null;
            }
            LikeModel.this.gnW = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.f(null);
            }
        }
    }
}
