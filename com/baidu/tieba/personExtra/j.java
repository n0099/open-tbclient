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
/* loaded from: classes6.dex */
public class j {
    private k eOr;
    private SmartApp ipi;
    private com.baidu.tbadk.core.dialog.i ipl;
    private com.baidu.tbadk.core.dialog.g ipm;
    private a ipn;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b ipo = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.ipi != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.ipi.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.ipn != null) {
                    j.this.ipn.BF(j.this.ipi.id);
                }
                an anVar = new an("c13436");
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.p("obj_id", j.this.ipi.swan_app_id.longValue());
                anVar.bS("obj_name", j.this.ipi.name);
                TiebaStatic.log(anVar);
                if (j.this.ipl != null) {
                    j.this.ipl.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> bPb = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void BF(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.eOr = new k(this.mContext);
    }

    public void create() {
        if (this.ipl == null) {
            this.ipm = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eOr);
            this.ipm.a(this.ipo);
            this.bPb.add(this.ipm);
            this.eOr.at(this.bPb);
            this.ipl = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eOr);
        }
    }

    public void a(a aVar) {
        this.ipn = aVar;
    }

    public void c(SmartApp smartApp) {
        this.ipi = smartApp;
    }

    public void show() {
        if (this.ipl != null) {
            this.ipl.showDialog();
        }
    }
}
