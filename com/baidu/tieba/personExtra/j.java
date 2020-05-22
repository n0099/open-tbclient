package com.baidu.tieba.personExtra;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes11.dex */
public class j {
    private k gGl;
    private SmartApp kpY;
    private com.baidu.tbadk.core.dialog.i kqb;
    private com.baidu.tbadk.core.dialog.g kqc;
    private a kqd;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b kqe = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.kpY != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.kpY.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.kqd != null) {
                    j.this.kqd.Km(j.this.kpY.id);
                }
                an anVar = new an("c13436");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("obj_id", j.this.kpY.swan_app_id.longValue());
                anVar.dh("obj_name", j.this.kpY.name);
                TiebaStatic.log(anVar);
                if (j.this.kqb != null) {
                    j.this.kqb.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> dqr = new ArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void Km(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.gGl = new k(this.mContext);
    }

    public void create() {
        if (this.kqb == null) {
            this.kqc = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gGl);
            this.kqc.a(this.kqe);
            this.dqr.add(this.kqc);
            this.gGl.aD(this.dqr);
            this.kqb = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gGl);
        }
    }

    public void a(a aVar) {
        this.kqd = aVar;
    }

    public void b(SmartApp smartApp) {
        this.kpY = smartApp;
    }

    public void show() {
        if (this.kqb != null) {
            this.kqb.showDialog();
        }
    }
}
