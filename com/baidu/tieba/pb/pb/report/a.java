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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a implements com.baidu.tieba.ueg.a {
    private BdUniqueId Xk;
    private HttpMessageListener bSe = new HttpMessageListener(CmdConfigHttp.CMD_UEG_REPORT) { // from class: com.baidu.tieba.pb.pb.report.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.mWaitingDialog != null) {
                    a.this.mWaitingDialog.ef(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.Bz(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.mContext.getString(R.string.neterror);
                }
                a.this.hTf.j(errorString);
            }
        }
    };
    private b hTe = new b();
    private e hTf = new e();
    private Context mContext;
    private com.baidu.tbadk.core.view.b mWaitingDialog;

    public a(Context context) {
        this.mContext = context;
        this.hTf.bXF = 1000L;
    }

    @Override // com.baidu.tieba.ueg.a
    public void r(BdUniqueId bdUniqueId) {
        this.Xk = bdUniqueId;
        this.hTe.setTag(bdUniqueId);
        this.bSe.setTag(bdUniqueId);
        this.bSe.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.bSe);
    }

    public void By(String str) {
        showLoadingDialog();
        this.hTe.By(str);
    }

    @Override // com.baidu.tieba.ueg.a
    public void ut(String str) {
        showLoadingDialog();
        this.hTe.ut(str);
    }

    private void showLoadingDialog() {
        TbPageContext tbPageContext;
        if (this.mWaitingDialog == null) {
            com.baidu.adp.base.e<?> ab = i.ab(this.mContext);
            if (!(ab instanceof TbPageContext)) {
                tbPageContext = null;
            } else {
                tbPageContext = (TbPageContext) ab;
            }
            if (tbPageContext != null) {
                this.mWaitingDialog = new com.baidu.tbadk.core.view.b(tbPageContext);
                this.mWaitingDialog.e(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.report.a.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        MessageManager.getInstance().removeMessage(a.this.Xk);
                    }
                });
            } else {
                return;
            }
        }
        this.mWaitingDialog.ef(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bz(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.mContext, this.mContext.getString(R.string.pb_web_view_report_title), str, true)));
    }
}
