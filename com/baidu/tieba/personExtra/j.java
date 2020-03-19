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
    private k fMJ;
    private SmartApp jnN;
    private com.baidu.tbadk.core.dialog.i jnQ;
    private com.baidu.tbadk.core.dialog.g jnR;
    private a jnS;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b jnT = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.jnN != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.jnN.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.jnS != null) {
                    j.this.jnS.GQ(j.this.jnN.id);
                }
                an anVar = new an("c13436");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("obj_id", j.this.jnN.swan_app_id.longValue());
                anVar.cx("obj_name", j.this.jnN.name);
                TiebaStatic.log(anVar);
                if (j.this.jnQ != null) {
                    j.this.jnQ.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> cFr = new ArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void GQ(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.fMJ = new k(this.mContext);
    }

    public void create() {
        if (this.jnQ == null) {
            this.jnR = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.fMJ);
            this.jnR.a(this.jnT);
            this.cFr.add(this.jnR);
            this.fMJ.az(this.cFr);
            this.jnQ = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.fMJ);
        }
    }

    public void a(a aVar) {
        this.jnS = aVar;
    }

    public void c(SmartApp smartApp) {
        this.jnN = smartApp;
    }

    public void show() {
        if (this.jnQ != null) {
            this.jnQ.showDialog();
        }
    }
}
