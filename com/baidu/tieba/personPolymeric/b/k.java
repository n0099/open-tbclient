package com.baidu.tieba.personPolymeric.b;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class k {
    private BdUniqueId aTs;
    private com.baidu.tbadk.core.dialog.f fKJ;
    private ArrayList<com.baidu.tbadk.core.dialog.h> fKK;
    private String fKL;
    private String fKM;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private HttpMessageListener fKN = new HttpMessageListener(CmdConfigHttp.CMD_USER_REPORT) { // from class: com.baidu.tieba.personPolymeric.b.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof JsonHttpResponsedMessage) {
                k.this.aav();
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                String errorString = jsonHttpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = k.this.mPageContext.getString(jsonHttpResponsedMessage.getError() == 0 ? d.k.report_success : d.k.neterror);
                }
                if (jsonHttpResponsedMessage.getError() == 0) {
                    k.this.fKI.i(errorString);
                } else {
                    k.this.fKI.j(errorString);
                }
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            com.baidu.tbadk.core.dialog.h hVar = (com.baidu.tbadk.core.dialog.h) v.c(k.this.fKK, i);
            if (hVar != null) {
                k.this.fKL = hVar.getTag();
                k.this.fKJ.setPositiveButtonEnable(true);
            }
            k.this.fKJ.refresh(i);
        }
    };
    private View.OnClickListener adj = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_REPORT, k.this.aTs);
            httpMessage.addParam("complaint_type", k.this.fKL);
            httpMessage.addParam("complaint_uid", k.this.fKM);
            MessageManager.getInstance().sendMessage(httpMessage);
            k.this.showLoadingDialog();
            k.this.fKJ.dismiss();
        }
    };
    private View.OnClickListener fKO = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            k.this.fKJ.dismiss();
        }
    };
    private com.baidu.tbadk.core.view.b fKI = new com.baidu.tbadk.core.view.b();

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aTs = bdUniqueId;
        aen();
    }

    private void bfv() {
        this.fKK = new ArrayList<>();
        this.fKK.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_bad_account_nickname), null, false, "0"));
        this.fKK.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_illegal_content), null, false, "1"));
        this.fKK.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_photo_problem), null, false, "2"));
        this.fKK.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.k.report_bad_tail), null, false, "3"));
    }

    private void aen() {
        this.fKN.setTag(this.aTs);
        this.fKN.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fKN);
    }

    public void jQ(String str) {
        bfv();
        this.fKM = str;
        this.fKJ = new com.baidu.tbadk.core.dialog.f(this.mPageContext);
        this.fKJ.cj(d.k.report_dialog_title);
        this.fKJ.a(this.fKK, this.mOnItemClickListener);
        this.fKJ.a(d.k.confirm, this.adj);
        this.fKJ.b(d.k.cancel, this.fKO);
        this.fKJ.tG().tH();
        this.fKJ.setPositiveButtonEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.mPageContext);
            this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.k.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(k.this.aTs);
                }
            });
        }
        this.mWaitingDialog.aI(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aav() {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.aI(false);
        }
    }
}
