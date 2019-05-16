package com.baidu.tieba.personExtra;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class j {
    private k ezO;
    private SmartApp iia;
    private com.baidu.tbadk.core.dialog.i iid;
    private com.baidu.tbadk.core.dialog.g iie;
    private a iif;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b iig = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.iia != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.iia.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.iif != null) {
                    j.this.iif.BX(j.this.iia.id);
                }
                am amVar = new am("c13436");
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.l(VideoPlayActivityConfig.OBJ_ID, j.this.iia.swan_app_id.longValue());
                amVar.bT("obj_name", j.this.iia.name);
                TiebaStatic.log(amVar);
                if (j.this.iid != null) {
                    j.this.iid.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> bvX = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void BX(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ezO = new k(this.mContext);
    }

    public void create() {
        if (this.iid == null) {
            this.iie = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ezO);
            this.iie.a(this.iig);
            this.bvX.add(this.iie);
            this.ezO.W(this.bvX);
            this.iid = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ezO.afZ());
        }
    }

    public void a(a aVar) {
        this.iif = aVar;
    }

    public void c(SmartApp smartApp) {
        this.iia = smartApp;
    }

    public void show() {
        if (this.iid != null) {
            this.iid.showDialog();
        }
    }
}
