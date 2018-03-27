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
import com.baidu.tbadk.util.c;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
public class LikeModel extends BdBaseModel {
    private String from;
    private String gZO;
    private String gZP;
    private a gZQ;
    private BlockPopInfoData mBlockPopInfoData;
    private String mForumId;
    private String mForumName;
    private TbPageContext mPageContext;

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.gZO = null;
        this.gZQ = null;
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
        if (this.gZQ != null) {
            this.gZQ.cancel();
            this.gZQ = null;
        }
    }

    public void L(String str, String str2, String str3) {
        cc(str, str2);
        this.gZO = str3;
    }

    public void cc(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.gZQ == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.gZQ = new a();
            this.gZQ.setPriority(2);
            this.gZQ.execute(new Object[0]);
        }
    }

    public boolean bwq() {
        return this.gZQ != null;
    }

    public Context getContext() {
        if (this.mPageContext != null) {
            return this.mPageContext.getPageActivity();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, s> {
        private volatile com.baidu.tbadk.core.util.x mNetwork;

        private a() {
            this.mNetwork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: K */
        public s doInBackground(Object... objArr) {
            try {
                this.mNetwork = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.mNetwork.n("kw", LikeModel.this.mForumName);
                this.mNetwork.n(ImageViewerConfig.FORUM_ID, LikeModel.this.mForumId);
                this.mNetwork.n("st_type", LikeModel.this.from);
                if (!StringUtils.isNull(LikeModel.this.gZP)) {
                    this.mNetwork.n("dev_id", LikeModel.this.gZP);
                }
                if (!TextUtils.isEmpty(LikeModel.this.gZO)) {
                    this.mNetwork.n("pagefrom", LikeModel.this.gZO);
                }
                this.mNetwork.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.mNetwork.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.mNetwork.n("forum_name", LikeModel.this.mForumName);
                this.mNetwork.Cz().Dw().mIsNeedTbs = true;
                String Cb = this.mNetwork.Cb();
                int CD = this.mNetwork.CD();
                String errorString = this.mNetwork.getErrorString();
                LikeModel.this.setErrorCode(CD);
                LikeModel.this.setErrorString(errorString);
                if (Cb != null) {
                    s sVar = new s();
                    sVar.setErrorCode(CD);
                    sVar.setErrorMsg(errorString);
                    sVar.parserJson(Cb);
                    if (this.mNetwork.Cz().Dx().isRequestSuccess()) {
                        sVar.setBlockPopInfoData(null);
                    }
                    LikeModel.this.mBlockPopInfoData = sVar.getBlockPopInfoData();
                    sVar.setFid(LikeModel.this.mForumId);
                    return sVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            s sVar2 = new s();
            sVar2.setLike(0);
            sVar2.setFid(LikeModel.this.mForumId);
            return sVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(s sVar) {
            LikeModel.this.gZQ = null;
            if (this.mNetwork != null && sVar != null && !AntiHelper.e(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), sVar.bwr())) {
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = com.baidu.adp.lib.g.b.c(sVar.getFid(), 0L);
                if (sVar != null && this.mNetwork.Cz().Dx().isRequestSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(com.baidu.adp.lib.g.b.c(sVar.getFid(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new c.a(LikeModel.this.mForumName, sVar.btq())));
                    TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.mForumName);
                    aVar.isSuccess = true;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = LikeModel.this.getErrorString();
                }
                if (LikeModel.this.mLoadDataCallBack != null) {
                    LikeModel.this.mLoadDataCallBack.ak(sVar);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, aVar));
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.mS();
                this.mNetwork = null;
            }
            LikeModel.this.gZQ = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.ak(null);
            }
        }
    }
}
