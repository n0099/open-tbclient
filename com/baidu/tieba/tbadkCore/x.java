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
    private String fAS;
    private a fAT;
    private String fAU;
    private String from;
    private String mForumId;
    private String mForumName;

    public x(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.fAS = null;
        this.fAT = null;
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

    public void blu() {
        if (this.fAT != null) {
            this.fAT.cancel();
            this.fAT = null;
        }
    }

    public void I(String str, String str2, String str3) {
        bS(str, str2);
        this.fAS = str3;
    }

    public void bS(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.fAT == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.fAT = new a(this, null);
            this.fAT.setPriority(2);
            this.fAT.execute(new Object[0]);
        }
    }

    public boolean blv() {
        return this.fAT != null;
    }

    public void rA(String str) {
        this.fAU = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, y> {
        private volatile com.baidu.tbadk.core.util.z ajm;

        private a() {
            this.ajm = null;
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: I */
        public y doInBackground(Object... objArr) {
            try {
                this.ajm = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.ajm.n("kw", x.this.mForumName);
                this.ajm.n("fid", x.this.mForumId);
                this.ajm.n("st_type", x.this.from);
                if (!StringUtils.isNull(x.this.fAU)) {
                    this.ajm.n("dev_id", x.this.fAU);
                }
                if (!TextUtils.isEmpty(x.this.fAS)) {
                    this.ajm.n("pagefrom", x.this.fAS);
                }
                this.ajm.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.ajm.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.ajm.n("forum_name", x.this.mForumName);
                this.ajm.uW().vR().mIsNeedTbs = true;
                String uy = this.ajm.uy();
                if (!this.ajm.uW().vS().uZ()) {
                    x.this.setErrorCode(this.ajm.vb());
                    x.this.setErrorString(this.ajm.vc());
                } else {
                    x.this.setErrorCode(this.ajm.va());
                    x.this.setErrorString(this.ajm.getErrorString());
                }
                if (this.ajm.uW().vS().oH() && uy != null) {
                    y yVar = new y();
                    yVar.parserJson(uy);
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
            x.this.fAT = null;
            com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
            aVar.forumId = com.baidu.adp.lib.h.b.c(yVar.getFid(), 0L);
            if (this.ajm != null) {
                if (this.ajm.uW().vS().oH() && x.this.getErrorCode() == 0 && yVar != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(yVar.getFid(), 0L))));
                    TbadkCoreApplication.m9getInst().addLikeForum(x.this.mForumName);
                    aVar.isSuccess = true;
                } else {
                    aVar.isSuccess = false;
                    aVar.errorMessage = this.ajm.uW().vS().mErrorString;
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
            if (this.ajm != null) {
                this.ajm.eg();
                this.ajm = null;
            }
            x.this.fAT = null;
            super.cancel(true);
            x.this.mLoadDataCallBack.g(null);
        }
    }
}
