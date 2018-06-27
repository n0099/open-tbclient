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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private String gLK;
    private String gLL;
    private a gLM;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.gLK = null;
        this.gLM = null;
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

    public void bwQ() {
        if (this.gLM != null) {
            this.gLM.cancel();
            this.gLM = null;
        }
    }

    public void H(String str, String str2, String str3) {
        cn(str, str2);
        this.gLK = str3;
    }

    public void cn(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.gLM == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.gLM = new a();
            this.gLM.setPriority(2);
            this.gLM.execute(new Object[0]);
        }
    }

    public boolean bwR() {
        return this.gLM != null;
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
        private volatile y mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public r doInBackground(Object... objArr) {
            try {
                this.mNetwork = new y(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.o("kw", LikeModel.this.mForumName);
                this.mNetwork.o(ImageViewerConfig.FORUM_ID, LikeModel.this.mForumId);
                this.mNetwork.o("st_type", LikeModel.this.from);
                if (!StringUtils.isNull(LikeModel.this.gLL)) {
                    this.mNetwork.o("dev_id", LikeModel.this.gLL);
                }
                if (!TextUtils.isEmpty(LikeModel.this.gLK)) {
                    this.mNetwork.o("pagefrom", LikeModel.this.gLK);
                }
                this.mNetwork.o("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.o("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.o("forum_name", LikeModel.this.mForumName);
                this.mNetwork.yX().zX().mIsNeedTbs = true;
                String yz = this.mNetwork.yz();
                int zb = this.mNetwork.zb();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(zb);
                LikeModel.this.setErrorString(errorString);
                if (yz != null) {
                    r rVar = new r();
                    rVar.setErrorCode(zb);
                    rVar.setErrorMsg(errorString);
                    rVar.parserJson(yz);
                    if (this.mNetwork.yX().zY().isRequestSuccess()) {
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
            LikeModel.this.gLM = null;
            if (this.mNetwork != null && rVar != null && !AntiHelper.e(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), rVar.bwS())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.c(rVar.getFid(), 0L);
                if (rVar != null && this.mNetwork.yX().zY().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(com.baidu.adp.lib.g.b.c(rVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new c.a(LikeModel.this.mForumName, rVar.btX())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.i(rVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.hN();
                this.mNetwork = null;
            }
            LikeModel.this.gLM = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.i(null);
            }
        }
    }
}
