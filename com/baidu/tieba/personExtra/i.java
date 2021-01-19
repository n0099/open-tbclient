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
/* loaded from: classes7.dex */
public class i {
    private k itD;
    private com.baidu.tbadk.core.dialog.g kJu;
    private Context mContext;
    private TbPageContext mPageContext;
    private SmartApp mpN;
    private com.baidu.tbadk.core.dialog.i mpQ;
    private a mpR;
    private k.b mpS = new k.b() { // from class: com.baidu.tieba.personExtra.i.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (i.this.mpN != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", i.this.mpN.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (i.this.mpR != null) {
                    i.this.mpR.PD(i.this.mpN.id);
                }
                aq aqVar = new aq("c13436");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.w("obj_id", i.this.mpN.swan_app_id.longValue());
                aqVar.dW("obj_name", i.this.mpN.name);
                TiebaStatic.log(aqVar);
                if (i.this.mpQ != null) {
                    i.this.mpQ.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> ewR = new ArrayList();

    /* loaded from: classes7.dex */
    public interface a {
        void PD(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.itD = new k(this.mContext);
    }

    public void create() {
        if (this.mpQ == null) {
            this.kJu = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.itD);
            this.kJu.a(this.mpS);
            this.ewR.add(this.kJu);
            this.itD.bB(this.ewR);
            this.mpQ = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.itD);
        }
    }

    public void a(a aVar) {
        this.mpR = aVar;
    }

    public void b(SmartApp smartApp) {
        this.mpN = smartApp;
    }

    public void show() {
        if (this.mpQ != null) {
            this.mpQ.Pd();
        }
    }
}
