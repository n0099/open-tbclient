package com.baidu.tieba.pb.pb.report;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.view.c;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a implements com.baidu.tieba.ueg.a {
    private BdUniqueId afZ;
    private HttpMessageListener dNE = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.pb.pb.report.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof UEGReportResponsedMessage) {
                if (a.this.mWaitingDialog != null) {
                    a.this.mWaitingDialog.setDialogVisiable(false);
                }
                UEGReportResponsedMessage uEGReportResponsedMessage = (UEGReportResponsedMessage) httpResponsedMessage;
                String url = uEGReportResponsedMessage.getUrl();
                if (!StringUtils.isNull(url)) {
                    a.this.Jm(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.mContext.getString(R.string.neterror);
                }
                a.this.jYa.showFailToast(errorString);
            }
        }
    };
    private b jXZ = new b();
    private c jYa = new c();
    private Context mContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;

    public a(Context context) {
        this.mContext = context;
        this.jYa.toastTime = 1000L;
    }

    @Override // com.baidu.tieba.ueg.a
    public void w(BdUniqueId bdUniqueId) {
        this.afZ = bdUniqueId;
        this.jXZ.setTag(bdUniqueId);
        this.dNE.setTag(bdUniqueId);
        this.dNE.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.dNE);
    }

    public void JM(String str) {
        showLoadingDialog();
        this.jXZ.JM(str);
    }

    @Override // com.baidu.tieba.ueg.a
    public void CU(String str) {
        showLoadingDialog();
        this.jXZ.CU(str);
    }

    private void showLoadingDialog() {
        TbPageContext tbPageContext;
        if (this.mWaitingDialog == null) {
            e<?> G = i.G(this.mContext);
            if (!(G instanceof TbPageContext)) {
                tbPageContext = null;
            } else {
                tbPageContext = (TbPageContext) G;
            }
            if (tbPageContext != null) {
                this.mWaitingDialog = new com.baidu.tbadk.core.view.a(tbPageContext);
                this.mWaitingDialog.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.report.a.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        MessageManager.getInstance().removeMessage(a.this.afZ);
                    }
                });
            } else {
                return;
            }
        }
        this.mWaitingDialog.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jm(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mContext, this.mContext.getString(R.string.pb_web_view_report_title), str, true)));
    }
}
