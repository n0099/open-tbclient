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
    private k hlU;
    private com.baidu.tbadk.core.dialog.g jEJ;
    private SmartApp ljV;
    private com.baidu.tbadk.core.dialog.i ljY;
    private a ljZ;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b lka = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.ljV != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.ljV.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.ljZ != null) {
                    j.this.ljZ.Ov(j.this.ljV.id);
                }
                aq aqVar = new aq("c13436");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.u("obj_id", j.this.ljV.swan_app_id.longValue());
                aqVar.dD("obj_name", j.this.ljV.name);
                TiebaStatic.log(aqVar);
                if (j.this.ljY != null) {
                    j.this.ljY.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> dKd = new ArrayList();

    /* loaded from: classes18.dex */
    public interface a {
        void Ov(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.hlU = new k(this.mContext);
    }

    public void create() {
        if (this.ljY == null) {
            this.jEJ = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.hlU);
            this.jEJ.a(this.lka);
            this.dKd.add(this.jEJ);
            this.hlU.aT(this.dKd);
            this.ljY = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.hlU);
        }
    }

    public void a(a aVar) {
        this.ljZ = aVar;
    }

    public void b(SmartApp smartApp) {
        this.ljV = smartApp;
    }

    public void show() {
        if (this.ljY != null) {
            this.ljY.Nv();
        }
    }
}
