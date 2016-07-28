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
public class y extends com.baidu.adp.base.e {
    private String fjf;
    private a fjg;
    private String fjh;
    private String from;
    private String mForumId;
    private String mForumName;

    public y(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.fjf = null;
        this.fjg = null;
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

    public void beD() {
        if (this.fjg != null) {
            this.fjg.cancel();
            this.fjg = null;
        }
    }

    public void I(String str, String str2, String str3) {
        bO(str, str2);
        this.fjf = str3;
    }

    public void bO(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.fjg == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.fjg = new a(this, null);
            this.fjg.setPriority(2);
            this.fjg.execute(new Object[0]);
        }
    }

    public boolean beE() {
        return this.fjg != null;
    }

    public void qh(String str) {
        this.fjh = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, z> {
        private volatile com.baidu.tbadk.core.util.ab afX;

        private a() {
            this.afX = null;
        }

        /* synthetic */ a(y yVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: G */
        public z doInBackground(Object... objArr) {
            try {
                this.afX = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.afX.n("kw", y.this.mForumName);
                this.afX.n("fid", y.this.mForumId);
                this.afX.n("st_type", y.this.from);
                if (!StringUtils.isNull(y.this.fjh)) {
                    this.afX.n("dev_id", y.this.fjh);
                }
                if (!TextUtils.isEmpty(y.this.fjf)) {
                    this.afX.n("pagefrom", y.this.fjf);
                }
                this.afX.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.afX.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.afX.n("forum_name", y.this.mForumName);
                this.afX.tx().uu().mIsNeedTbs = true;
                String sZ = this.afX.sZ();
                if (!this.afX.tx().uv().tA()) {
                    y.this.setErrorCode(this.afX.tC());
                    y.this.setErrorString(this.afX.tD());
                } else {
                    y.this.setErrorCode(this.afX.tB());
                    y.this.setErrorString(this.afX.getErrorString());
                }
                if (this.afX.tx().uv().nJ() && sZ != null) {
                    z zVar = new z();
                    zVar.parserJson(sZ);
                    zVar.gF(y.this.mForumId);
                    return zVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            z zVar2 = new z();
            zVar2.setLike(0);
            zVar2.gF(y.this.mForumId);
            return zVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(z zVar) {
            y.this.fjg = null;
            if (this.afX != null && this.afX.tx().uv().nJ() && y.this.getErrorCode() == 0 && zVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(zVar.beF(), 0L))));
                TbadkCoreApplication.m10getInst().addLikeForum(y.this.mForumName);
            }
            if (y.this.mLoadDataCallBack != null) {
                y.this.mLoadDataCallBack.g(zVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afX != null) {
                this.afX.dl();
                this.afX = null;
            }
            y.this.fjg = null;
            super.cancel(true);
            y.this.mLoadDataCallBack.g(null);
        }
    }
}
