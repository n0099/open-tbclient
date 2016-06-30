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
    private String eWd;
    private a eWe;
    private String eWf;
    private String from;
    private String mForumId;
    private String mForumName;

    public y(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.eWd = null;
        this.eWe = null;
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

    public void bbp() {
        if (this.eWe != null) {
            this.eWe.cancel();
            this.eWe = null;
        }
    }

    public void H(String str, String str2, String str3) {
        bJ(str, str2);
        this.eWd = str3;
    }

    public void bJ(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.eWe == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.eWe = new a(this, null);
            this.eWe.setPriority(2);
            this.eWe.execute(new Object[0]);
        }
    }

    public boolean bbq() {
        return this.eWe != null;
    }

    public void px(String str) {
        this.eWf = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, z> {
        private volatile com.baidu.tbadk.core.util.ab afj;

        private a() {
            this.afj = null;
        }

        /* synthetic */ a(y yVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public z doInBackground(Object... objArr) {
            try {
                this.afj = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.afj.n("kw", y.this.mForumName);
                this.afj.n("fid", y.this.mForumId);
                this.afj.n("st_type", y.this.from);
                if (!StringUtils.isNull(y.this.eWf)) {
                    this.afj.n("dev_id", y.this.eWf);
                }
                if (!TextUtils.isEmpty(y.this.eWd)) {
                    this.afj.n("pagefrom", y.this.eWd);
                }
                this.afj.n("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.afj.n("user_id", TbadkCoreApplication.getCurrentAccount());
                this.afj.n("forum_name", y.this.mForumName);
                this.afj.ty().uu().mIsNeedTbs = true;
                String ta = this.afj.ta();
                if (!this.afj.ty().uv().tB()) {
                    y.this.setErrorCode(this.afj.tD());
                    y.this.setErrorString(this.afj.tE());
                } else {
                    y.this.setErrorCode(this.afj.tC());
                    y.this.setErrorString(this.afj.getErrorString());
                }
                if (this.afj.ty().uv().nU() && ta != null) {
                    z zVar = new z();
                    zVar.parserJson(ta);
                    zVar.setFid(y.this.mForumId);
                    return zVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            z zVar2 = new z();
            zVar2.setLike(0);
            zVar2.setFid(y.this.mForumId);
            return zVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(z zVar) {
            y.this.eWe = null;
            if (this.afj != null && this.afj.ty().uv().nU() && y.this.getErrorCode() == 0 && zVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(zVar.getFid(), 0L))));
                TbadkCoreApplication.m9getInst().addLikeForum(y.this.mForumName);
            }
            if (y.this.mLoadDataCallBack != null) {
                y.this.mLoadDataCallBack.d(zVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afj != null) {
                this.afj.dm();
                this.afj = null;
            }
            y.this.eWe = null;
            super.cancel(true);
            y.this.mLoadDataCallBack.d(null);
        }
    }
}
