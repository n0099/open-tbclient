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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes11.dex */
public class j {
    private k gTw;
    private com.baidu.tbadk.core.dialog.g jgS;
    private SmartApp kLc;
    private com.baidu.tbadk.core.dialog.i kLf;
    private a kLg;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b kLh = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.kLc != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.kLc.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.kLg != null) {
                    j.this.kLg.KO(j.this.kLc.id);
                }
                ao aoVar = new ao("c13436");
                aoVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                aoVar.s("obj_id", j.this.kLc.swan_app_id.longValue());
                aoVar.dk("obj_name", j.this.kLc.name);
                TiebaStatic.log(aoVar);
                if (j.this.kLf != null) {
                    j.this.kLf.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> dvd = new ArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void KO(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.gTw = new k(this.mContext);
    }

    public void create() {
        if (this.kLf == null) {
            this.jgS = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gTw);
            this.jgS.a(this.kLh);
            this.dvd.add(this.jgS);
            this.gTw.aL(this.dvd);
            this.kLf = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gTw);
        }
    }

    public void a(a aVar) {
        this.kLg = aVar;
    }

    public void b(SmartApp smartApp) {
        this.kLc = smartApp;
    }

    public void show() {
        if (this.kLf != null) {
            this.kLf.showDialog();
        }
    }
}
