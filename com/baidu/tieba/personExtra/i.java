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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class i {
    private k izn;
    private com.baidu.tbadk.core.dialog.g kRx;
    private Context mContext;
    private TbPageContext mPageContext;
    private SmartApp myN;
    private com.baidu.tbadk.core.dialog.i myQ;
    private a myR;
    private k.b myS = new k.b() { // from class: com.baidu.tieba.personExtra.i.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (i.this.myN != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", i.this.myN.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (i.this.myR != null) {
                    i.this.myR.Qu(i.this.myN.id);
                }
                ar arVar = new ar("c13436");
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.v("obj_id", i.this.myN.swan_app_id.longValue());
                arVar.dR("obj_name", i.this.myN.name);
                TiebaStatic.log(arVar);
                if (i.this.myQ != null) {
                    i.this.myQ.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> eza = new ArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void Qu(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.izn = new k(this.mContext);
    }

    public void create() {
        if (this.myQ == null) {
            this.kRx = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.izn);
            this.kRx.a(this.myS);
            this.eza.add(this.kRx);
            this.izn.bw(this.eza);
            this.myQ = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.izn);
        }
    }

    public void a(a aVar) {
        this.myR = aVar;
    }

    public void b(SmartApp smartApp) {
        this.myN = smartApp;
    }

    public void show() {
        if (this.myQ != null) {
            this.myQ.QE();
        }
    }
}
