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
/* loaded from: classes8.dex */
public class i {
    private k iyk;
    private com.baidu.tbadk.core.dialog.g kNZ;
    private Context mContext;
    private TbPageContext mPageContext;
    private SmartApp mus;
    private com.baidu.tbadk.core.dialog.i muv;
    private a muw;
    private k.b mux = new k.b() { // from class: com.baidu.tieba.personExtra.i.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (i.this.mus != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", i.this.mus.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (i.this.muw != null) {
                    i.this.muw.QK(i.this.mus.id);
                }
                aq aqVar = new aq("c13436");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.w("obj_id", i.this.mus.swan_app_id.longValue());
                aqVar.dX("obj_name", i.this.mus.name);
                TiebaStatic.log(aqVar);
                if (i.this.muv != null) {
                    i.this.muv.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> eBG = new ArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void QK(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.iyk = new k(this.mContext);
    }

    public void create() {
        if (this.muv == null) {
            this.kNZ = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.iyk);
            this.kNZ.a(this.mux);
            this.eBG.add(this.kNZ);
            this.iyk.bB(this.eBG);
            this.muv = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.iyk);
        }
    }

    public void a(a aVar) {
        this.muw = aVar;
    }

    public void b(SmartApp smartApp) {
        this.mus = smartApp;
    }

    public void show() {
        if (this.muv != null) {
            this.muv.SY();
        }
    }
}
