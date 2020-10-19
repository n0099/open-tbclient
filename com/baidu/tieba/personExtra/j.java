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
/* loaded from: classes24.dex */
public class j {
    private k hHV;
    private com.baidu.tbadk.core.dialog.g kcp;
    private SmartApp lIl;
    private com.baidu.tbadk.core.dialog.i lIo;
    private a lIp;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b lIq = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.lIl != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.lIl.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.lIp != null) {
                    j.this.lIp.PM(j.this.lIl.id);
                }
                aq aqVar = new aq("c13436");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.u("obj_id", j.this.lIl.swan_app_id.longValue());
                aqVar.dK("obj_name", j.this.lIl.name);
                TiebaStatic.log(aqVar);
                if (j.this.lIo != null) {
                    j.this.lIo.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> dYm = new ArrayList();

    /* loaded from: classes24.dex */
    public interface a {
        void PM(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.hHV = new k(this.mContext);
    }

    public void create() {
        if (this.lIo == null) {
            this.kcp = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hHV);
            this.kcp.a(this.lIq);
            this.dYm.add(this.kcp);
            this.hHV.ba(this.dYm);
            this.lIo = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hHV);
        }
    }

    public void a(a aVar) {
        this.lIp = aVar;
    }

    public void b(SmartApp smartApp) {
        this.lIl = smartApp;
    }

    public void show() {
        if (this.lIo != null) {
            this.lIo.Pd();
        }
    }
}
