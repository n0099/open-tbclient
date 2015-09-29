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
    private String cXu;
    private a cXv;
    private String cXw;
    private String from;
    private String mForumId;
    private String mForumName;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.cXu = null;
        this.cXv = null;
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
        if (this.cXv != null) {
            this.cXv.cancel();
            this.cXv = null;
        }
    }

    public void s(String str, String str2, String str3) {
        be(str, str2);
        this.cXu = str3;
    }

    public void be(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cXv == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cXv = new a(this, null);
            this.cXv.setPriority(2);
            this.cXv.execute(new Object[0]);
        }
    }

    public boolean avT() {
        return this.cXv != null;
    }

    public void lt(String str) {
        this.cXw = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, x> {
        private volatile com.baidu.tbadk.core.util.w afg;

        private a() {
            this.afg = null;
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
                this.afg = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.afg.o("kw", w.this.mForumName);
                this.afg.o(ImageViewerConfig.FORUM_ID, w.this.mForumId);
                this.afg.o("st_type", w.this.from);
                if (!StringUtils.isNull(w.this.cXw)) {
                    this.afg.o("dev_id", w.this.cXw);
                }
                if (!TextUtils.isEmpty(w.this.cXu)) {
                    this.afg.o("pagefrom", w.this.cXu);
                }
                this.afg.uh().uX().mIsNeedTbs = true;
                String tG = this.afg.tG();
                if (this.afg.uh().uY().qV() && tG != null) {
                    x xVar = new x();
                    xVar.parserJson(tG);
                    xVar.lu(w.this.mForumId);
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
            w.this.cXv = null;
            if (xVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(xVar.getFid(), 0L))));
                TbadkCoreApplication.m411getInst().addLikeForum(w.this.mForumName);
            }
            if (xVar == null && this.afg != null) {
                w.this.mErrorCode = this.afg.ul();
                w.this.mErrorString = this.afg.getErrorString();
            }
            if (w.this.mLoadDataCallBack != null) {
                w.this.mLoadDataCallBack.d(xVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afg != null) {
                this.afg.gJ();
                this.afg = null;
            }
            w.this.cXv = null;
            super.cancel(true);
            w.this.mLoadDataCallBack.d(null);
        }
    }
}
