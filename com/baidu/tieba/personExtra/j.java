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
    private k gGw;
    private SmartApp kre;
    private com.baidu.tbadk.core.dialog.i krh;
    private com.baidu.tbadk.core.dialog.g kri;
    private a krj;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b krk = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.kre != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.kre.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.krj != null) {
                    j.this.krj.Kn(j.this.kre.id);
                }
                an anVar = new an("c13436");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("obj_id", j.this.kre.swan_app_id.longValue());
                anVar.dh("obj_name", j.this.kre.name);
                TiebaStatic.log(anVar);
                if (j.this.krh != null) {
                    j.this.krh.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> dqr = new ArrayList();

    /* loaded from: classes11.dex */
    public interface a {
        void Kn(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.gGw = new k(this.mContext);
    }

    public void create() {
        if (this.krh == null) {
            this.kri = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.gGw);
            this.kri.a(this.krk);
            this.dqr.add(this.kri);
            this.gGw.aD(this.dqr);
            this.krh = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.gGw);
        }
    }

    public void a(a aVar) {
        this.krj = aVar;
    }

    public void b(SmartApp smartApp) {
        this.kre = smartApp;
    }

    public void show() {
        if (this.krh != null) {
            this.krh.showDialog();
        }
    }
}
