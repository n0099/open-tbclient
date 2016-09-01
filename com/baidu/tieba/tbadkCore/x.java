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
    private String fqX;
    private a fqY;
    private String fqZ;
    private String from;
    private String mForumId;
    private String mForumName;

    public x(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.fqX = null;
        this.fqY = null;
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

    public void bij() {
        if (this.fqY != null) {
            this.fqY.cancel();
            this.fqY = null;
        }
    }

    public void I(String str, String str2, String str3) {
        bP(str, str2);
        this.fqX = str3;
    }

    public void bP(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.fqY == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.fqY = new a(this, null);
            this.fqY.setPriority(2);
            this.fqY.execute(new Object[0]);
        }
    }

    public boolean bik() {
        return this.fqY != null;
    }

    public void qR(String str) {
        this.fqZ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, y> {
        private volatile com.baidu.tbadk.core.util.ab aiS;

        private a() {
            this.aiS = null;
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public y doInBackground(Object... objArr) {
            try {
                this.aiS = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.aiS.n("kw", x.this.mForumName);
                this.aiS.n("fid", x.this.mForumId);
                this.aiS.n("st_type", x.this.from);
                if (!StringUtils.isNull(x.this.fqZ)) {
                    this.aiS.n("dev_id", x.this.fqZ);
                }
                if (!TextUtils.isEmpty(x.this.fqX)) {
                    this.aiS.n("pagefrom", x.this.fqX);
                }
                this.aiS.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.aiS.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.aiS.n("forum_name", x.this.mForumName);
                this.aiS.uD().vz().mIsNeedTbs = true;
                String ue = this.aiS.ue();
                if (!this.aiS.uD().vA().uG()) {
                    x.this.setErrorCode(this.aiS.uI());
                    x.this.setErrorString(this.aiS.uJ());
                } else {
                    x.this.setErrorCode(this.aiS.uH());
                    x.this.setErrorString(this.aiS.getErrorString());
                }
                if (this.aiS.uD().vA().oE() && ue != null) {
                    y yVar = new y();
                    yVar.parserJson(ue);
                    yVar.hi(x.this.mForumId);
                    return yVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            y yVar2 = new y();
            yVar2.setLike(0);
            yVar2.hi(x.this.mForumId);
            return yVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(y yVar) {
            x.this.fqY = null;
            com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
            aVar.forumId = com.baidu.adp.lib.h.b.c(yVar.aaL(), 0L);
            if (this.aiS != null) {
                if (this.aiS.uD().vA().oE() && x.this.getErrorCode() == 0 && yVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(yVar.aaL(), 0L))));
                    TbadkCoreApplication.m9getInst().addLikeForum(x.this.mForumName);
                    aVar.isSuccess = true;
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = this.aiS.uD().vA().mErrorString;
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
            if (this.aiS != null) {
                this.aiS.eg();
                this.aiS = null;
            }
            x.this.fqY = null;
            super.cancel(true);
            x.this.mLoadDataCallBack.g(null);
        }
    }
}
