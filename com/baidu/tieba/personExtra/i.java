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
/* loaded from: classes7.dex */
public class i {
    private k iBk;
    private com.baidu.tbadk.core.dialog.g kTN;
    private SmartApp mBe;
    private com.baidu.tbadk.core.dialog.i mBi;
    private a mBj;
    private Context mContext;
    private TbPageContext mPageContext;
    private k.b mBk = new k.b() { // from class: com.baidu.tieba.personExtra.i.1
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            if (i.this.mBe != null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY);
                httpMessage.addParam("swan_app_key", i.this.mBe.id);
                MessageManager.getInstance().sendMessage(httpMessage);
                if (i.this.mBj != null) {
                    i.this.mBj.QB(i.this.mBe.id);
                }
                ar arVar = new ar("c13436");
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.v("obj_id", i.this.mBe.swan_app_id.longValue());
                arVar.dR("obj_name", i.this.mBe.name);
                TiebaStatic.log(arVar);
                if (i.this.mBi != null) {
                    i.this.mBi.dismiss();
                }
            }
        }
    };
    private List<com.baidu.tbadk.core.dialog.g> eAB = new ArrayList();

    /* loaded from: classes7.dex */
    public interface a {
        void QB(String str);
    }

    static {
        MessageManager.getInstance().registerTask(new TbHttpMessageTask(CmdConfigHttp.CMD_SMART_APP_DEL_BROWSE_HISTORY, TbConfig.SERVER_ADDRESS + TbConfig.URL_SMART_APP_DEL_BROWSE_HISTORY));
    }

    public i(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.iBk = new k(this.mContext);
    }

    public void create() {
        if (this.mBi == null) {
            this.kTN = new com.baidu.tbadk.core.dialog.g(this.mContext.getString(R.string.delete), this.iBk);
            this.kTN.a(this.mBk);
            this.eAB.add(this.kTN);
            this.iBk.bw(this.eAB);
            this.mBi = new com.baidu.tbadk.core.dialog.i(this.mPageContext, this.iBk);
        }
    }

    public void a(a aVar) {
        this.mBj = aVar;
    }

    public void b(SmartApp smartApp) {
        this.mBe = smartApp;
    }

    public void show() {
        if (this.mBi != null) {
            this.mBi.QH();
        }
    }
}
