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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes23.dex */
public class j {
    private k htb;
    private com.baidu.tbadk.core.dialog.g jNr;
    private SmartApp lsY;
    private com.baidu.tbadk.core.dialog.i ltb;
    private a ltc;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b ltd = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.lsY != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.lsY.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.ltc != null) {
                    j.this.ltc.OX(j.this.lsY.id);
                }
                aq aqVar = new aq("c13436");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.u("obj_id", j.this.lsY.swan_app_id.longValue());
                aqVar.dF("obj_name", j.this.lsY.name);
                TiebaStatic.log(aqVar);
                if (j.this.ltb != null) {
                    j.this.ltb.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> dMl = new ArrayList();

    /* loaded from: classes23.dex */
    public interface a {
        void OX(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.htb = new k(this.mContext);
    }

    public void create() {
        if (this.ltb == null) {
            this.jNr = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.htb);
            this.jNr.a(this.ltd);
            this.dMl.add(this.jNr);
            this.htb.aX(this.dMl);
            this.ltb = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.htb);
        }
    }

    public void a(a aVar) {
        this.ltc = aVar;
    }

    public void b(SmartApp smartApp) {
        this.lsY = smartApp;
    }

    public void show() {
        if (this.ltb != null) {
            this.ltb.NY();
        }
    }
}
