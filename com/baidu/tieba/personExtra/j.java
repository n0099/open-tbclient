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
/* loaded from: classes18.dex */
public class j {
    private k hlY;
    private com.baidu.tbadk.core.dialog.g jEP;
    private SmartApp lkc;
    private com.baidu.tbadk.core.dialog.i lkf;
    private a lkg;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b lkh = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.lkc != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.lkc.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.lkg != null) {
                    j.this.lkg.Ow(j.this.lkc.id);
                }
                aq aqVar = new aq("c13436");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.u("obj_id", j.this.lkc.swan_app_id.longValue());
                aqVar.dD("obj_name", j.this.lkc.name);
                TiebaStatic.log(aqVar);
                if (j.this.lkf != null) {
                    j.this.lkf.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> dKh = new ArrayList();

    /* loaded from: classes18.dex */
    public interface a {
        void Ow(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.hlY = new k(this.mContext);
    }

    public void create() {
        if (this.lkf == null) {
            this.jEP = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hlY);
            this.jEP.a(this.lkh);
            this.dKh.add(this.jEP);
            this.hlY.aT(this.dKh);
            this.lkf = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hlY);
        }
    }

    public void a(a aVar) {
        this.lkg = aVar;
    }

    public void b(SmartApp smartApp) {
        this.lkc = smartApp;
    }

    public void show() {
        if (this.lkf != null) {
            this.lkf.Nv();
        }
    }
}
