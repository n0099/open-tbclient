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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class j {
    private k eEL;
    private com.baidu.tbadk.core.dialog.g ioA;
    private a ioB;
    private SmartApp iow;
    private com.baidu.tbadk.core.dialog.i ioz;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b ioC = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.iow != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.iow.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.ioB != null) {
                    j.this.ioB.CM(j.this.iow.id);
                }
                an anVar = new an("c13436");
                anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.l(VideoPlayActivityConfig.OBJ_ID, j.this.iow.swan_app_id.longValue());
                anVar.bT("obj_name", j.this.iow.name);
                TiebaStatic.log(anVar);
                if (j.this.ioz != null) {
                    j.this.ioz.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> bwN = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void CM(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.eEL = new k(this.mContext);
    }

    public void create() {
        if (this.ioz == null) {
            this.ioA = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eEL);
            this.ioA.a(this.ioC);
            this.bwN.add(this.ioA);
            this.eEL.W(this.bwN);
            this.ioz = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eEL.ahb());
        }
    }

    public void a(a aVar) {
        this.ioB = aVar;
    }

    public void c(SmartApp smartApp) {
        this.iow = smartApp;
    }

    public void show() {
        if (this.ioz != null) {
            this.ioz.showDialog();
        }
    }
}
