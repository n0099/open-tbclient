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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    private BdUniqueId aPy;
    private com.baidu.tbadk.core.dialog.e foM;
    private ArrayList<com.baidu.tbadk.core.dialog.g> foN;
    private String foO;
    private String foP;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private HttpMessageListener foQ = new HttpMessageListener(CmdConfigHttp.CMD_USER_REPORT) { // from class: com.baidu.tieba.personPolymeric.b.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof JsonHttpResponsedMessage) {
                k.this.VR();
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                String errorString = jsonHttpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = k.this.mPageContext.getString(jsonHttpResponsedMessage.getError() == 0 ? d.j.report_success : d.j.neterror);
                }
                if (jsonHttpResponsedMessage.getError() == 0) {
                    k.this.foL.c(errorString);
                } else {
                    k.this.foL.d(errorString);
                }
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.core.dialog.g gVar = (com.baidu.tbadk.core.dialog.g) v.c(k.this.foN, i);
            if (gVar != null) {
                k.this.foO = gVar.getTag();
                k.this.foM.setPositiveButtonEnable(true);
            }
            k.this.foM.cm(i);
        }
    };
    private View.OnClickListener abM = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_REPORT, k.this.aPy);
            httpMessage.addParam("complaint_type", k.this.foO);
            httpMessage.addParam("complaint_uid", k.this.foP);
            MessageManager.getInstance().sendMessage(httpMessage);
            k.this.showLoadingDialog();
            k.this.foM.dismiss();
        }
    };
    private View.OnClickListener foR = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.foM.dismiss();
        }
    };
    private com.baidu.tbadk.core.view.c foL = new com.baidu.tbadk.core.view.c();

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aPy = bdUniqueId;
        YM();
    }

    private void bad() {
        this.foN = new ArrayList<>();
        this.foN.add(new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(d.j.report_bad_account_nickname), null, false, "0"));
        this.foN.add(new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(d.j.report_illegal_content), null, false, "1"));
        this.foN.add(new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(d.j.report_photo_problem), null, false, "2"));
        this.foN.add(new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(d.j.report_bad_tail), null, false, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
    }

    private void YM() {
        this.foQ.setTag(this.aPy);
        this.foQ.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.foQ);
    }

    public void jl(String str) {
        bad();
        this.foP = str;
        this.foM = new com.baidu.tbadk.core.dialog.e(this.mPageContext);
        this.foM.cl(d.j.report_dialog_title);
        this.foM.a(this.foN, this.mOnItemClickListener);
        this.foM.a(d.j.confirm, this.abM);
        this.foM.b(d.j.cancel, this.foR);
        this.foM.tm().tn();
        this.foM.setPositiveButtonEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.mPageContext);
            this.mWaitingDialog.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.k.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(k.this.aPy);
                }
            });
        }
        this.mWaitingDialog.aE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VR() {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.aE(false);
        }
    }
}
