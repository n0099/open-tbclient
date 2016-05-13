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
    private String erp;
    private a erq;
    private String err;
    private String from;
    private String mForumId;
    private String mForumName;

    public x(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.erp = null;
        this.erq = null;
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

    public void aTc() {
        if (this.erq != null) {
            this.erq.cancel();
            this.erq = null;
        }
    }

    public void C(String str, String str2, String str3) {
        bH(str, str2);
        this.erp = str3;
    }

    public void bH(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.erq == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.erq = new a(this, null);
            this.erq.setPriority(2);
            this.erq.execute(new Object[0]);
        }
    }

    public boolean aTd() {
        return this.erq != null;
    }

    public void nP(String str) {
        this.err = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, y> {
        private volatile com.baidu.tbadk.core.util.ab aeI;

        private a() {
            this.aeI = null;
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public y doInBackground(Object... objArr) {
            try {
                this.aeI = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.aeI.n("kw", x.this.mForumName);
                this.aeI.n("fid", x.this.mForumId);
                this.aeI.n("st_type", x.this.from);
                if (!StringUtils.isNull(x.this.err)) {
                    this.aeI.n("dev_id", x.this.err);
                }
                if (!TextUtils.isEmpty(x.this.erp)) {
                    this.aeI.n("pagefrom", x.this.erp);
                }
                this.aeI.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.aeI.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.aeI.n("forum_name", x.this.mForumName);
                this.aeI.tB().uv().mIsNeedTbs = true;
                String td = this.aeI.td();
                if (!this.aeI.tB().uw().tE()) {
                    x.this.setErrorCode(this.aeI.tG());
                    x.this.setErrorString(this.aeI.tH());
                } else {
                    x.this.setErrorCode(this.aeI.tF());
                    x.this.setErrorString(this.aeI.getErrorString());
                }
                if (this.aeI.tB().uw().nZ() && td != null) {
                    y yVar = new y();
                    yVar.parserJson(td);
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
            x.this.erq = null;
            if (this.aeI != null && this.aeI.tB().uw().nZ() && x.this.getErrorCode() == 0 && yVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(yVar.getFid(), 0L))));
                TbadkCoreApplication.m11getInst().addLikeForum(x.this.mForumName);
            }
            if (x.this.mLoadDataCallBack != null) {
                x.this.mLoadDataCallBack.d(yVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
                this.aeI = null;
            }
            x.this.erq = null;
            super.cancel(true);
            x.this.mLoadDataCallBack.d(null);
        }
    }
}
