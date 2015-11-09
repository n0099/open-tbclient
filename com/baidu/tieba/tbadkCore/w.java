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
    private String cZr;
    private a cZs;
    private String cZt;
    private String from;
    private String mForumId;
    private String mForumName;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.cZr = null;
        this.cZs = null;
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

    public void MQ() {
        if (this.cZs != null) {
            this.cZs.cancel();
            this.cZs = null;
        }
    }

    public void r(String str, String str2, String str3) {
        bd(str, str2);
        this.cZr = str3;
    }

    public void bd(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cZs == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cZs = new a(this, null);
            this.cZs.setPriority(2);
            this.cZs.execute(new Object[0]);
        }
    }

    public boolean awF() {
        return this.cZs != null;
    }

    public void lA(String str) {
        this.cZt = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, x> {
        private volatile com.baidu.tbadk.core.util.w afm;

        private a() {
            this.afm = null;
        }

        /* synthetic */ a(w wVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public x doInBackground(Object... objArr) {
            try {
                this.afm = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.afm.o("kw", w.this.mForumName);
                this.afm.o(ImageViewerConfig.FORUM_ID, w.this.mForumId);
                this.afm.o("st_type", w.this.from);
                if (!StringUtils.isNull(w.this.cZt)) {
                    this.afm.o("dev_id", w.this.cZt);
                }
                if (!TextUtils.isEmpty(w.this.cZr)) {
                    this.afm.o("pagefrom", w.this.cZr);
                }
                this.afm.uh().uZ().mIsNeedTbs = true;
                String tG = this.afm.tG();
                if (this.afm.uh().va().qT() && tG != null) {
                    x xVar = new x();
                    xVar.parserJson(tG);
                    xVar.lB(w.this.mForumId);
                    return xVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(x xVar) {
            w.this.cZs = null;
            if (xVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(xVar.getFid(), 0L))));
                TbadkCoreApplication.m411getInst().addLikeForum(w.this.mForumName);
            }
            if (xVar == null && this.afm != null) {
                w.this.mErrorCode = this.afm.ul();
                w.this.mErrorString = this.afm.getErrorString();
            }
            if (w.this.mLoadDataCallBack != null) {
                w.this.mLoadDataCallBack.d(xVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afm != null) {
                this.afm.gJ();
                this.afm = null;
            }
            w.this.cZs = null;
            super.cancel(true);
            w.this.mLoadDataCallBack.d(null);
        }
    }
}
