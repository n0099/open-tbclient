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
/* loaded from: classes16.dex */
public class a implements com.baidu.tieba.ueg.a {
    private BdUniqueId ahK;
    private HttpMessageListener ekw = new HttpMessageListener(1003402) { // from class: com.baidu.tieba.pb.pb.report.a.2
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
                    a.this.Nv(url);
                    return;
                }
                String errorString = uEGReportResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = a.this.mContext.getString(R.string.neterror);
                }
                a.this.kRt.showFailToast(errorString);
            }
        }
    };
    private b kRs = new b();
    private c kRt = new c();
    private Context mContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;

    public a(Context context) {
        this.mContext = context;
        this.kRt.toastTime = 1000L;
    }

    @Override // com.baidu.tieba.ueg.a
    public void x(BdUniqueId bdUniqueId) {
        this.ahK = bdUniqueId;
        this.kRs.setTag(bdUniqueId);
        this.ekw.setTag(bdUniqueId);
        this.ekw.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.ekw);
    }

    public void NV(String str) {
        showLoadingDialog();
        this.kRs.NV(str);
    }

    @Override // com.baidu.tieba.ueg.a
    public void NW(String str) {
        showLoadingDialog();
        this.kRs.NW(str);
    }

    private void showLoadingDialog() {
        TbPageContext tbPageContext;
        if (this.mWaitingDialog == null) {
            e<?> I = i.I(this.mContext);
            if (!(I instanceof TbPageContext)) {
                tbPageContext = null;
            } else {
                tbPageContext = (TbPageContext) I;
            }
            if (tbPageContext != null) {
                this.mWaitingDialog = new com.baidu.tbadk.core.view.a(tbPageContext);
                this.mWaitingDialog.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.pb.report.a.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        MessageManager.getInstance().removeMessage(a.this.ahK);
                    }
                });
            } else {
                return;
            }
        }
        this.mWaitingDialog.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nv(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.mContext, this.mContext.getString(R.string.pb_web_view_report_title), str, true)));
    }
}
