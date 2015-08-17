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
public class v extends com.baidu.adp.base.e {
    private String cHE;
    private a cHF;
    private String cHG;
    private String from;
    private String mForumId;
    private String mForumName;

    public v(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.cHE = null;
        this.cHF = null;
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
        if (this.cHF != null) {
            this.cHF.cancel();
            this.cHF = null;
        }
    }

    public void r(String str, String str2, String str3) {
        ba(str, str2);
        this.cHE = str3;
    }

    public void ba(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.cHF == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.cHF = new a(this, null);
            this.cHF.setPriority(2);
            this.cHF.execute(new Object[0]);
        }
    }

    public boolean apq() {
        return this.cHF != null;
    }

    public void kq(String str) {
        this.cHG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, w> {
        private volatile com.baidu.tbadk.core.util.v afJ;

        private a() {
            this.afJ = null;
        }

        /* synthetic */ a(v vVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
        public w doInBackground(Object... objArr) {
            try {
                this.afJ = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.afJ.o("kw", v.this.mForumName);
                this.afJ.o(ImageViewerConfig.FORUM_ID, v.this.mForumId);
                this.afJ.o("st_type", v.this.from);
                if (!StringUtils.isNull(v.this.cHG)) {
                    this.afJ.o("dev_id", v.this.cHG);
                }
                if (!TextUtils.isEmpty(v.this.cHE)) {
                    this.afJ.o("pagefrom", v.this.cHE);
                }
                this.afJ.ue().uV().mIsNeedTbs = true;
                String tD = this.afJ.tD();
                if (this.afJ.ue().uW().rb() && tD != null) {
                    w wVar = new w();
                    wVar.parserJson(tD);
                    wVar.kr(v.this.mForumId);
                    return wVar;
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
        public void onPostExecute(w wVar) {
            v.this.cHF = null;
            if (wVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.g.b.c(wVar.getFid(), 0L))));
                TbadkCoreApplication.m411getInst().addLikeForum(v.this.mForumName);
            }
            if (wVar == null && this.afJ != null) {
                v.this.mErrorCode = this.afJ.ui();
                v.this.mErrorString = this.afJ.getErrorString();
            }
            if (v.this.mLoadDataCallBack != null) {
                v.this.mLoadDataCallBack.d(wVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afJ != null) {
                this.afJ.gM();
                this.afJ = null;
            }
            v.this.cHF = null;
            super.cancel(true);
            v.this.mLoadDataCallBack.d(null);
        }
    }
}
