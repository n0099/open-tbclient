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
public class x extends com.baidu.adp.base.e {
    private String dFA;
    private String dFy;
    private a dFz;
    private String from;
    private String mForumId;
    private String mForumName;

    public x(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.dFy = null;
        this.dFz = null;
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

    public void OH() {
        if (this.dFz != null) {
            this.dFz.cancel();
            this.dFz = null;
        }
    }

    public void x(String str, String str2, String str3) {
        bc(str, str2);
        this.dFy = str3;
    }

    public void bc(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.dFz == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.dFz = new a(this, null);
            this.dFz.setPriority(2);
            this.dFz.execute(new Object[0]);
        }
    }

    public boolean aEy() {
        return this.dFz != null;
    }

    public void mn(String str) {
        this.dFA = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, y> {
        private volatile com.baidu.tbadk.core.util.ab ahV;

        private a() {
            this.ahV = null;
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public y doInBackground(Object... objArr) {
            try {
                this.ahV = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.ahV.o("kw", x.this.mForumName);
                this.ahV.o(ImageViewerConfig.FORUM_ID, x.this.mForumId);
                this.ahV.o("st_type", x.this.from);
                if (!StringUtils.isNull(x.this.dFA)) {
                    this.ahV.o("dev_id", x.this.dFA);
                }
                if (!TextUtils.isEmpty(x.this.dFy)) {
                    this.ahV.o("pagefrom", x.this.dFy);
                }
                this.ahV.o("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.ahV.o("user_id", TbadkCoreApplication.getCurrentAccount());
                this.ahV.o("forum_name", x.this.mForumName);
                this.ahV.uw().vp().mIsNeedTbs = true;
                String tV = this.ahV.tV();
                if (!this.ahV.uw().vq().uz()) {
                    x.this.setErrorCode(this.ahV.uB());
                    x.this.setErrorString(this.ahV.uC());
                } else {
                    x.this.setErrorCode(this.ahV.uA());
                    x.this.setErrorString(this.ahV.getErrorString());
                }
                if (this.ahV.uw().vq().qO() && tV != null) {
                    y yVar = new y();
                    yVar.parserJson(tV);
                    yVar.mo(x.this.mForumId);
                    return yVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            y yVar2 = new y();
            yVar2.setLike(0);
            yVar2.mo(x.this.mForumId);
            return yVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(y yVar) {
            x.this.dFz = null;
            if (this.ahV != null && this.ahV.uw().vq().qO() && yVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(yVar.getFid(), 0L))));
                TbadkCoreApplication.m411getInst().addLikeForum(x.this.mForumName);
            }
            if (x.this.mLoadDataCallBack != null) {
                x.this.mLoadDataCallBack.d(yVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ahV != null) {
                this.ahV.gL();
                this.ahV = null;
            }
            x.this.dFz = null;
            super.cancel(true);
            x.this.mLoadDataCallBack.d(null);
        }
    }
}
