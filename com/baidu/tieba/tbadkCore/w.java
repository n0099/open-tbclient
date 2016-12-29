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
public class w extends com.baidu.adp.base.e {
    private String feX;
    private a feY;
    private String feZ;
    private String from;
    private String mForumId;
    private String mForumName;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.feX = null;
        this.feY = null;
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

    public void bfj() {
        if (this.feY != null) {
            this.feY.cancel();
            this.feY = null;
        }
    }

    public void I(String str, String str2, String str3) {
        bV(str, str2);
        this.feX = str3;
    }

    public void bV(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.feY == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.feY = new a(this, null);
            this.feY.setPriority(2);
            this.feY.execute(new Object[0]);
        }
    }

    public boolean bfk() {
        return this.feY != null;
    }

    public void qe(String str) {
        this.feZ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, x> {
        private volatile com.baidu.tbadk.core.util.z aiN;

        private a() {
            this.aiN = null;
        }

        /* synthetic */ a(w wVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public x doInBackground(Object... objArr) {
            try {
                this.aiN = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.aiN.n("kw", w.this.mForumName);
                this.aiN.n("fid", w.this.mForumId);
                this.aiN.n("st_type", w.this.from);
                if (!StringUtils.isNull(w.this.feZ)) {
                    this.aiN.n("dev_id", w.this.feZ);
                }
                if (!TextUtils.isEmpty(w.this.feX)) {
                    this.aiN.n("pagefrom", w.this.feX);
                }
                this.aiN.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.aiN.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.aiN.n("forum_name", w.this.mForumName);
                this.aiN.uI().vB().mIsNeedTbs = true;
                String uk = this.aiN.uk();
                if (!this.aiN.uI().vC().uL()) {
                    w.this.setErrorCode(this.aiN.uN());
                    w.this.setErrorString(this.aiN.uO());
                } else {
                    w.this.setErrorCode(this.aiN.uM());
                    w.this.setErrorString(this.aiN.getErrorString());
                }
                if (this.aiN.uI().vC().oH() && uk != null) {
                    x xVar = new x();
                    xVar.parserJson(uk);
                    xVar.setFid(w.this.mForumId);
                    return xVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            x xVar2 = new x();
            xVar2.setLike(0);
            xVar2.setFid(w.this.mForumId);
            return xVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(x xVar) {
            w.this.feY = null;
            com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
            aVar.forumId = com.baidu.adp.lib.h.b.c(xVar.getFid(), 0L);
            if (this.aiN != null) {
                if (this.aiN.uI().vC().oH() && w.this.getErrorCode() == 0 && xVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(xVar.getFid(), 0L))));
                    TbadkCoreApplication.m9getInst().addLikeForum(w.this.mForumName);
                    aVar.isSuccess = true;
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = this.aiN.uI().vC().mErrorString;
                }
            } else {
                aVar.isSuccess = false;
            }
            if (w.this.mLoadDataCallBack != null) {
                w.this.mLoadDataCallBack.g(xVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiN != null) {
                this.aiN.eg();
                this.aiN = null;
            }
            w.this.feY = null;
            super.cancel(true);
            w.this.mLoadDataCallBack.g(null);
        }
    }
}
