package com.baidu.tieba.pb.pb.report;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.ueg.a {
    private BdUniqueId Zs;
    private HttpMessageListener bKu = new HttpMessageListener(CmdConfigHttp.CMD_UEG_REPORT) { // from class: com.baidu.tieba.pb.pb.report.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.mWaitingDialog != null) {
                    a.this.mWaitingDialog.dJ(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.Aj(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.mContext.getString(d.j.neterror);
                }
                a.this.hBb.j(errorString);
            }
        }
    };
    private b hBa = new b();
    private e hBb = new e();
    private Context mContext;
    private com.baidu.tbadk.core.view.b mWaitingDialog;

    public a(Context context) {
        this.mContext = context;
        this.hBb.bPR = 1000L;
    }

    @Override // com.baidu.tieba.ueg.a
    public void p(BdUniqueId bdUniqueId) {
        this.Zs = bdUniqueId;
        this.hBa.setTag(bdUniqueId);
        this.bKu.setTag(bdUniqueId);
        this.bKu.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bKu);
    }

    public void Ai(String str) {
        showLoadingDialog();
        this.hBa.Ai(str);
    }

    @Override // com.baidu.tieba.ueg.a
    public void tg(String str) {
        showLoadingDialog();
        this.hBa.tg(str);
    }

    private void showLoadingDialog() {
        TbPageContext tbPageContext;
        if (this.mWaitingDialog == null) {
            com.baidu.adp.base.e<?> aK = i.aK(this.mContext);
            if (!(aK instanceof TbPageContext)) {
                tbPageContext = null;
            } else {
                tbPageContext = (TbPageContext) aK;
            }
            if (tbPageContext != null) {
                this.mWaitingDialog = new com.baidu.tbadk.core.view.b(tbPageContext);
                this.mWaitingDialog.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.report.a.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        MessageManager.getInstance().removeMessage(a.this.Zs);
                    }
                });
            } else {
                return;
            }
        }
        this.mWaitingDialog.dJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aj(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mContext, this.mContext.getString(d.j.pb_web_view_report_title), str, true)));
    }
}
