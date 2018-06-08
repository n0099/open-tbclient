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
    private String gHK;
    private String gHL;
    private a gHM;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.gHK = null;
        this.gHM = null;
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

    public void bwp() {
        if (this.gHM != null) {
            this.gHM.cancel();
            this.gHM = null;
        }
    }

    public void J(String str, String str2, String str3) {
        cj(str, str2);
        this.gHK = str3;
    }

    public void cj(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.gHM == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.gHM = new a();
            this.gHM.setPriority(2);
            this.gHM.execute(new Object[0]);
        }
    }

    public boolean bwq() {
        return this.gHM != null;
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
                if (!StringUtils.isNull(LikeModel.this.gHL)) {
                    this.mNetwork.o("dev_id", LikeModel.this.gHL);
                }
                if (!TextUtils.isEmpty(LikeModel.this.gHK)) {
                    this.mNetwork.o("pagefrom", LikeModel.this.gHK);
                }
                this.mNetwork.o("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.o("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.o("forum_name", LikeModel.this.mForumName);
                this.mNetwork.yJ().zI().mIsNeedTbs = true;
                String yl = this.mNetwork.yl();
                int yN = this.mNetwork.yN();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(yN);
                LikeModel.this.setErrorString(errorString);
                if (yl != null) {
                    r rVar = new r();
                    rVar.setErrorCode(yN);
                    rVar.setErrorMsg(errorString);
                    rVar.parserJson(yl);
                    if (this.mNetwork.yJ().zJ().isRequestSuccess()) {
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
            LikeModel.this.gHM = null;
            if (this.mNetwork != null && rVar != null && !AntiHelper.e(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), rVar.bwr())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.c(rVar.getFid(), 0L);
                if (rVar != null && this.mNetwork.yJ().zJ().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(com.baidu.adp.lib.g.b.c(rVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new c.a(LikeModel.this.mForumName, rVar.btx())));
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
            LikeModel.this.gHM = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.i(null);
            }
        }
    }
}
