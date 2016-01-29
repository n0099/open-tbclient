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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.base.e {
    private String dVt;
    private a dVu;
    private String dVv;
    private String from;
    private String mForumId;
    private String mForumName;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.dVt = null;
        this.dVu = null;
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

    public void QJ() {
        if (this.dVu != null) {
            this.dVu.cancel();
            this.dVu = null;
        }
    }

    public void z(String str, String str2, String str3) {
        bl(str, str2);
        this.dVt = str3;
    }

    public void bl(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.dVu == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.dVu = new a(this, null);
            this.dVu.setPriority(2);
            this.dVu.execute(new Object[0]);
        }
    }

    public boolean aLE() {
        return this.dVu != null;
    }

    public void mE(String str) {
        this.dVv = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, x> {
        private volatile com.baidu.tbadk.core.util.aa aiG;

        private a() {
            this.aiG = null;
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
                this.aiG = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.aiG.p("kw", w.this.mForumName);
                this.aiG.p(ImageViewerConfig.FORUM_ID, w.this.mForumId);
                this.aiG.p("st_type", w.this.from);
                if (!StringUtils.isNull(w.this.dVv)) {
                    this.aiG.p("dev_id", w.this.dVv);
                }
                if (!TextUtils.isEmpty(w.this.dVt)) {
                    this.aiG.p("pagefrom", w.this.dVt);
                }
                this.aiG.p("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.aiG.p("user_id", TbadkCoreApplication.getCurrentAccount());
                this.aiG.p("forum_name", w.this.mForumName);
                this.aiG.vB().wv().mIsNeedTbs = true;
                String uZ = this.aiG.uZ();
                if (!this.aiG.vB().ww().vE()) {
                    w.this.setErrorCode(this.aiG.vG());
                    w.this.setErrorString(this.aiG.vH());
                } else {
                    w.this.setErrorCode(this.aiG.vF());
                    w.this.setErrorString(this.aiG.getErrorString());
                }
                if (this.aiG.vB().ww().rl() && uZ != null) {
                    x xVar = new x();
                    xVar.parserJson(uZ);
                    xVar.mF(w.this.mForumId);
                    return xVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            x xVar2 = new x();
            xVar2.setLike(0);
            xVar2.mF(w.this.mForumId);
            return xVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(x xVar) {
            w.this.dVu = null;
            if (this.aiG != null && this.aiG.vB().ww().rl() && w.this.getErrorCode() == 0 && xVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(xVar.getFid(), 0L))));
                TbadkCoreApplication.m411getInst().addLikeForum(w.this.mForumName);
            }
            if (w.this.mLoadDataCallBack != null) {
                w.this.mLoadDataCallBack.d(xVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiG != null) {
                this.aiG.gT();
                this.aiG = null;
            }
            w.this.dVu = null;
            super.cancel(true);
            w.this.mLoadDataCallBack.d(null);
        }
    }
}
