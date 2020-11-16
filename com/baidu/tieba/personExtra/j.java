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
/* loaded from: classes23.dex */
public class j {
    private k iaR;
    private com.baidu.tbadk.core.dialog.g kvu;
    private Context mContext;
    private TbPageContext mPageContext;
    private SmartApp maY;
    private com.baidu.tbadk.core.dialog.i mbb;
    private a mbc;
    private k.b mbd = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.maY != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.maY.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.mbc != null) {
                    j.this.mbc.PW(j.this.maY.id);
                }
                ar arVar = new ar("c13436");
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.w("obj_id", j.this.maY.swan_app_id.longValue());
                arVar.dR("obj_name", j.this.maY.name);
                TiebaStatic.log(arVar);
                if (j.this.mbb != null) {
                    j.this.mbb.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> ekT = new ArrayList();

    /* loaded from: classes23.dex */
    public interface a {
        void PW(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.iaR = new k(this.mContext);
    }

    public void create() {
        if (this.mbb == null) {
            this.kvu = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.iaR);
            this.kvu.a(this.mbd);
            this.ekT.add(this.kvu);
            this.iaR.br(this.ekT);
            this.mbb = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.iaR);
        }
    }

    public void a(a aVar) {
        this.mbc = aVar;
    }

    public void b(SmartApp smartApp) {
        this.maY = smartApp;
    }

    public void show() {
        if (this.mbb != null) {
            this.mbb.PA();
        }
    }
}
