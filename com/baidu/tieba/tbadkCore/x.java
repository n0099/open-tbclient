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
    private String dxX;
    private a dxY;
    private String dxZ;
    private String from;
    private String mForumId;
    private String mForumName;

    public x(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mForumName = null;
        this.mForumId = null;
        this.dxX = null;
        this.dxY = null;
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

    public void Op() {
        if (this.dxY != null) {
            this.dxY.cancel();
            this.dxY = null;
        }
    }

    public void u(String str, String str2, String str3) {
        bg(str, str2);
        this.dxX = str3;
    }

    public void bg(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.dxY == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.dxY = new a(this, null);
            this.dxY.setPriority(2);
            this.dxY.execute(new Object[0]);
        }
    }

    public boolean aCq() {
        return this.dxY != null;
    }

    public void mq(String str) {
        this.dxZ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, y> {
        private volatile com.baidu.tbadk.core.util.ab agS;

        private a() {
            this.agS = null;
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
                this.agS = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LIKE_ADDRESS);
                this.agS.o("kw", x.this.mForumName);
                this.agS.o(ImageViewerConfig.FORUM_ID, x.this.mForumId);
                this.agS.o("st_type", x.this.from);
                if (!StringUtils.isNull(x.this.dxZ)) {
                    this.agS.o("dev_id", x.this.dxZ);
                }
                if (!TextUtils.isEmpty(x.this.dxX)) {
                    this.agS.o("pagefrom", x.this.dxX);
                }
                this.agS.o("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.agS.o("user_id", TbadkCoreApplication.getCurrentAccount());
                this.agS.o("forum_name", x.this.mForumName);
                this.agS.uM().vF().mIsNeedTbs = true;
                String ul = this.agS.ul();
                if (!this.agS.uM().vG().uP()) {
                    x.this.setErrorCode(this.agS.uR());
                    x.this.setErrorString(this.agS.uS());
                } else {
                    x.this.setErrorCode(this.agS.uQ());
                    x.this.setErrorString(this.agS.getErrorString());
                }
                if (this.agS.uM().vG().rf() && ul != null) {
                    y yVar = new y();
                    yVar.parserJson(ul);
                    yVar.mr(x.this.mForumId);
                    return yVar;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            y yVar2 = new y();
            yVar2.setLike(0);
            yVar2.mr(x.this.mForumId);
            return yVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(y yVar) {
            x.this.dxY = null;
            if (this.agS != null && this.agS.uM().vG().rf() && yVar != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(com.baidu.adp.lib.h.b.c(yVar.getFid(), 0L))));
                TbadkCoreApplication.m411getInst().addLikeForum(x.this.mForumName);
            }
            if (x.this.mLoadDataCallBack != null) {
                x.this.mLoadDataCallBack.d(yVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.agS != null) {
                this.agS.gL();
                this.agS = null;
            }
            x.this.dxY = null;
            super.cancel(true);
            x.this.mLoadDataCallBack.d(null);
        }
    }
}
