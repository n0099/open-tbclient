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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class j {
    private k ezP;
    private SmartApp iie;
    private com.baidu.tbadk.core.dialog.i iih;
    private com.baidu.tbadk.core.dialog.g iii;
    private a iij;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b iik = new k.b() { // from class: com.baidu.tieba.personExtra.j.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (j.this.iie != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", j.this.iie.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (j.this.iij != null) {
                    j.this.iij.BZ(j.this.iie.id);
                }
                am amVar = new am("c13436");
                amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
                amVar.l(VideoPlayActivityConfig.OBJ_ID, j.this.iie.swan_app_id.longValue());
                amVar.bT("obj_name", j.this.iie.name);
                TiebaStatic.log(amVar);
                if (j.this.iih != null) {
                    j.this.iih.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> bvX = new ArrayList();

    /* loaded from: classes6.dex */
    public interface a {
        void BZ(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public j(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.ezP = new k(this.mContext);
    }

    public void create() {
        if (this.iih == null) {
            this.iii = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.ezP);
            this.iii.a(this.iik);
            this.bvX.add(this.iii);
            this.ezP.W(this.bvX);
            this.iih = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.ezP.afZ());
        }
    }

    public void a(a aVar) {
        this.iij = aVar;
    }

    public void c(SmartApp smartApp) {
        this.iie = smartApp;
    }

    public void show() {
        if (this.iih != null) {
            this.iih.showDialog();
        }
    }
}
