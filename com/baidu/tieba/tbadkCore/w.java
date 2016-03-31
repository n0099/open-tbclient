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
    private String enX;
    private a enY;
    private String enZ;
    private String from;
    private String mForumId;
    private String mForumName;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.enX = null;
        this.enY = null;
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

    public void aSx() {
        if (this.enY != null) {
            this.enY.cancel();
            this.enY = null;
        }
    }

    public void B(String str, String str2, String str3) {
        bC(str, str2);
        this.enX = str3;
    }

    public void bC(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.enY == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.enY = new a(this, null);
            this.enY.setPriority(2);
            this.enY.execute(new Object[0]);
        }
    }

    public boolean aSy() {
        return this.enY != null;
    }

    public void nP(String str) {
        this.enZ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, x> {
        private volatile com.baidu.tbadk.core.util.ab aiW;

        private a() {
            this.aiW = null;
        }

        /* synthetic */ a(w wVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public x doInBackground(Object... objArr) {
            try {
                this.aiW = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.aiW.p("kw", w.this.mForumName);
                this.aiW.p("fid", w.this.mForumId);
                this.aiW.p("st_type", w.this.from);
                if (!StringUtils.isNull(w.this.enZ)) {
                    this.aiW.p("dev_id", w.this.enZ);
                }
                if (!TextUtils.isEmpty(w.this.enX)) {
                    this.aiW.p("pagefrom", w.this.enX);
                }
                this.aiW.p("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.aiW.p("user_id", TbadkCoreApplication.getCurrentAccount());
                this.aiW.p("forum_name", w.this.mForumName);
                this.aiW.vU().wO().mIsNeedTbs = true;
                String vw = this.aiW.vw();
                if (!this.aiW.vU().wP().vX()) {
                    w.this.setErrorCode(this.aiW.vZ());
                    w.this.setErrorString(this.aiW.wa());
                } else {
                    w.this.setErrorCode(this.aiW.vY());
                    w.this.setErrorString(this.aiW.getErrorString());
                }
                if (this.aiW.vU().wP().qC() && vw != null) {
                    x xVar = new x();
                    xVar.parserJson(vw);
                    xVar.nQ(w.this.mForumId);
                    return xVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            x xVar2 = new x();
            xVar2.setLike(0);
            xVar2.nQ(w.this.mForumId);
            return xVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(x xVar) {
            w.this.enY = null;
            if (this.aiW != null && this.aiW.vU().wP().qC() && w.this.getErrorCode() == 0 && xVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(xVar.getFid(), 0L))));
                TbadkCoreApplication.m411getInst().addLikeForum(w.this.mForumName);
            }
            if (w.this.mLoadDataCallBack != null) {
                w.this.mLoadDataCallBack.d(xVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiW != null) {
                this.aiW.gX();
                this.aiW = null;
            }
            w.this.enY = null;
            super.cancel(true);
            w.this.mLoadDataCallBack.d(null);
        }
    }
}
