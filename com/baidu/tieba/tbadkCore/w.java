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
    private String cQe;
    private a cQf;
    private String cQg;
    private String from;
    private String mForumId;
    private String mForumName;

    public w(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.cQe = null;
        this.cQf = null;
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

    public void MF() {
        if (this.cQf != null) {
            this.cQf.cancel();
            this.cQf = null;
        }
    }

    public void s(String str, String str2, String str3) {
        be(str, str2);
        this.cQe = str3;
    }

    public void be(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cQf == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cQf = new a(this, null);
            this.cQf.setPriority(2);
            this.cQf.execute(new Object[0]);
        }
    }

    public boolean atD() {
        return this.cQf != null;
    }

    public void kV(String str) {
        this.cQg = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, x> {
        private volatile com.baidu.tbadk.core.util.v afT;

        private a() {
            this.afT = null;
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
                this.afT = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.afT.o("kw", w.this.mForumName);
                this.afT.o(ImageViewerConfig.FORUM_ID, w.this.mForumId);
                this.afT.o("st_type", w.this.from);
                if (!StringUtils.isNull(w.this.cQg)) {
                    this.afT.o("dev_id", w.this.cQg);
                }
                if (!TextUtils.isEmpty(w.this.cQe)) {
                    this.afT.o("pagefrom", w.this.cQe);
                }
                this.afT.uj().uZ().mIsNeedTbs = true;
                String tI = this.afT.tI();
                if (this.afT.uj().va().qZ() && tI != null) {
                    x xVar = new x();
                    xVar.parserJson(tI);
                    xVar.kW(w.this.mForumId);
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
            w.this.cQf = null;
            if (xVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(xVar.getFid(), 0L))));
                TbadkCoreApplication.m411getInst().addLikeForum(w.this.mForumName);
            }
            if (xVar == null && this.afT != null) {
                w.this.mErrorCode = this.afT.un();
                w.this.mErrorString = this.afT.getErrorString();
            }
            if (w.this.mLoadDataCallBack != null) {
                w.this.mLoadDataCallBack.d(xVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afT != null) {
                this.afT.gJ();
                this.afT = null;
            }
            w.this.cQf = null;
            super.cancel(true);
            w.this.mLoadDataCallBack.d(null);
        }
    }
}
