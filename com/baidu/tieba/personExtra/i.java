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
    private k izB;
    private com.baidu.tbadk.core.dialog.g kRL;
    private Context mContext;
    private TbPageContext mPageContext;
    private SmartApp mzc;
    private com.baidu.tbadk.core.dialog.i mzf;
    private a mzg;
    private k.b mzh = new k.b() { // from class: com.baidu.tieba.personExtra.i.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (i.this.mzc != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", i.this.mzc.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (i.this.mzg != null) {
                    i.this.mzg.Qv(i.this.mzc.id);
                }
                ar arVar = new ar("c13436");
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.v("obj_id", i.this.mzc.swan_app_id.longValue());
                arVar.dR("obj_name", i.this.mzc.name);
                TiebaStatic.log(arVar);
                if (i.this.mzf != null) {
                    i.this.mzf.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> eza = new ArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void Qv(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.izB = new k(this.mContext);
    }

    public void create() {
        if (this.mzf == null) {
            this.kRL = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.izB);
            this.kRL.a(this.mzh);
            this.eza.add(this.kRL);
            this.izB.bw(this.eza);
            this.mzf = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.izB);
        }
    }

    public void a(a aVar) {
        this.mzg = aVar;
    }

    public void b(SmartApp smartApp) {
        this.mzc = smartApp;
    }

    public void show() {
        if (this.mzf != null) {
            this.mzf.QE();
        }
    }
}
