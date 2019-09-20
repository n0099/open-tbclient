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
    private k eGB;
    private com.baidu.tbadk.core.dialog.i irC;
    private com.baidu.tbadk.core.dialog.g irD;
    private a irE;
    private SmartApp irz;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b irF = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.irz != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.irz.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.irE != null) {
                    j.this.irE.Dm(j.this.irz.id);
                }
                an anVar = new an("c13436");
                anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.n(VideoPlayActivityConfig.OBJ_ID, j.this.irz.swan_app_id.longValue());
                anVar.bT("obj_name", j.this.irz.name);
                TiebaStatic.log(anVar);
                if (j.this.irC != null) {
                    j.this.irC.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> bxl = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void Dm(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.eGB = new k(this.mContext);
    }

    public void create() {
        if (this.irC == null) {
            this.irD = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.eGB);
            this.irD.a(this.irF);
            this.bxl.add(this.irD);
            this.eGB.W(this.bxl);
            this.irC = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.eGB);
        }
    }

    public void a(a aVar) {
        this.irE = aVar;
    }

    public void c(SmartApp smartApp) {
        this.irz = smartApp;
    }

    public void show() {
        if (this.irC != null) {
            this.irC.showDialog();
        }
    }
}
