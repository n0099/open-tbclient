package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
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
public class x extends com.baidu.adp.base.e {
    private String from;
    private String ftF;
    private a ftG;
    private String ftH;
    private String mForumId;
    private String mForumName;

    public x(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.ftF = null;
        this.ftG = null;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void biU() {
        if (this.ftG != null) {
            this.ftG.cancel();
            this.ftG = null;
        }
    }

    public void I(String str, String str2, String str3) {
        bQ(str, str2);
        this.ftF = str3;
    }

    public void bQ(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.ftG == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.ftG = new a(this, null);
            this.ftG.setPriority(2);
            this.ftG.execute(new Object[0]);
        }
    }

    public boolean biV() {
        return this.ftG != null;
    }

    public void rg(String str) {
        this.ftH = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, y> {
        private volatile com.baidu.tbadk.core.util.ab aiu;

        private a() {
            this.aiu = null;
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public y doInBackground(Object... objArr) {
            try {
                this.aiu = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.aiu.n("kw", x.this.mForumName);
                this.aiu.n("fid", x.this.mForumId);
                this.aiu.n("st_type", x.this.from);
                if (!StringUtils.isNull(x.this.ftH)) {
                    this.aiu.n("dev_id", x.this.ftH);
                }
                if (!TextUtils.isEmpty(x.this.ftF)) {
                    this.aiu.n("pagefrom", x.this.ftF);
                }
                this.aiu.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.aiu.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.aiu.n("forum_name", x.this.mForumName);
                this.aiu.uS().vN().mIsNeedTbs = true;
                String uu = this.aiu.uu();
                if (!this.aiu.uS().vO().uV()) {
                    x.this.setErrorCode(this.aiu.uX());
                    x.this.setErrorString(this.aiu.uY());
                } else {
                    x.this.setErrorCode(this.aiu.uW());
                    x.this.setErrorString(this.aiu.getErrorString());
                }
                if (this.aiu.uS().vO().oF() && uu != null) {
                    y yVar = new y();
                    yVar.parserJson(uu);
                    yVar.setFid(x.this.mForumId);
                    return yVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            y yVar2 = new y();
            yVar2.setLike(0);
            yVar2.setFid(x.this.mForumId);
            return yVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(y yVar) {
            x.this.ftG = null;
            com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
            aVar.forumId = com.baidu.adp.lib.h.b.c(yVar.getFid(), 0L);
            if (this.aiu != null) {
                if (this.aiu.uS().vO().oF() && x.this.getErrorCode() == 0 && yVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(yVar.getFid(), 0L))));
                    TbadkCoreApplication.m9getInst().addLikeForum(x.this.mForumName);
                    aVar.isSuccess = true;
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = this.aiu.uS().vO().mErrorString;
                }
            } else {
                aVar.isSuccess = false;
            }
            if (x.this.mLoadDataCallBack != null) {
                x.this.mLoadDataCallBack.g(yVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiu != null) {
                this.aiu.eg();
                this.aiu = null;
            }
            x.this.ftG = null;
            super.cancel(true);
            x.this.mLoadDataCallBack.g(null);
        }
    }
}
