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
    private String cXU;
    private a cXV;
    private String cXW;
    private String from;
    private String mForumId;
    private String mForumName;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.cXU = null;
        this.cXV = null;
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

    public void ME() {
        if (this.cXV != null) {
            this.cXV.cancel();
            this.cXV = null;
        }
    }

    public void r(String str, String str2, String str3) {
        be(str, str2);
        this.cXU = str3;
    }

    public void be(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cXV == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cXV = new a(this, null);
            this.cXV.setPriority(2);
            this.cXV.execute(new Object[0]);
        }
    }

    public boolean awb() {
        return this.cXV != null;
    }

    public void lw(String str) {
        this.cXW = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, x> {
        private volatile com.baidu.tbadk.core.util.w afh;

        private a() {
            this.afh = null;
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
                this.afh = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.afh.o("kw", w.this.mForumName);
                this.afh.o(ImageViewerConfig.FORUM_ID, w.this.mForumId);
                this.afh.o("st_type", w.this.from);
                if (!StringUtils.isNull(w.this.cXW)) {
                    this.afh.o("dev_id", w.this.cXW);
                }
                if (!TextUtils.isEmpty(w.this.cXU)) {
                    this.afh.o("pagefrom", w.this.cXU);
                }
                this.afh.uh().uY().mIsNeedTbs = true;
                String tG = this.afh.tG();
                if (this.afh.uh().uZ().qV() && tG != null) {
                    x xVar = new x();
                    xVar.parserJson(tG);
                    xVar.lx(w.this.mForumId);
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
        /* renamed from: c */
        public void onPostExecute(x xVar) {
            w.this.cXV = null;
            if (xVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(xVar.getFid(), 0L))));
                TbadkCoreApplication.m411getInst().addLikeForum(w.this.mForumName);
            }
            if (xVar == null && this.afh != null) {
                w.this.mErrorCode = this.afh.ul();
                w.this.mErrorString = this.afh.getErrorString();
            }
            if (w.this.mLoadDataCallBack != null) {
                w.this.mLoadDataCallBack.d(xVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afh != null) {
                this.afh.gJ();
                this.afh = null;
            }
            w.this.cXV = null;
            super.cancel(true);
            w.this.mLoadDataCallBack.d(null);
        }
    }
}
