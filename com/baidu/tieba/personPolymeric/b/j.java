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
public class j {
    private BdUniqueId bIv;
    private com.baidu.tbadk.core.dialog.f goO;
    private ArrayList<com.baidu.tbadk.core.dialog.h> goP;
    private String goQ;
    private String goR;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.b mWaitingDialog;
    private HttpMessageListener goS = new HttpMessageListener(CmdConfigHttp.CMD_USER_REPORT) { // from class: com.baidu.tieba.personPolymeric.b.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof JsonHttpResponsedMessage) {
                j.this.agf();
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                String errorString = jsonHttpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = j.this.mPageContext.getString(jsonHttpResponsedMessage.getError() == 0 ? d.j.report_success : d.j.neterror);
                }
                if (jsonHttpResponsedMessage.getError() == 0) {
                    j.this.goN.q(errorString);
                } else {
                    j.this.goN.r(errorString);
                }
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personPolymeric.b.j.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.core.dialog.h hVar = (com.baidu.tbadk.core.dialog.h) v.f(j.this.goP, i);
            if (hVar != null) {
                j.this.goQ = hVar.getTag();
                j.this.goO.setPositiveButtonEnable(true);
            }
            j.this.goO.refresh(i);
        }
    };
    private View.OnClickListener aRK = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.j.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_REPORT, j.this.bIv);
            httpMessage.addParam("complaint_type", j.this.goQ);
            httpMessage.addParam("complaint_uid", j.this.goR);
            MessageManager.getInstance().sendMessage(httpMessage);
            j.this.showLoadingDialog();
            j.this.goO.dismiss();
        }
    };
    private View.OnClickListener goT = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.j.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.goO.dismiss();
        }
    };
    private com.baidu.tbadk.core.view.e goN = new com.baidu.tbadk.core.view.e();

    public j(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.bIv = bdUniqueId;
        akh();
    }

    private void bkq() {
        this.goP = new ArrayList<>();
        this.goP.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_bad_account_nickname), null, false, "0"));
        this.goP.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_illegal_content), null, false, "1"));
        this.goP.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_photo_problem), null, false, "2"));
        this.goP.add(new com.baidu.tbadk.core.dialog.h(this.mPageContext.getString(d.j.report_bad_tail), null, false, "3"));
    }

    private void akh() {
        this.goS.setTag(this.bIv);
        this.goS.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.goS);
    }

    public void jJ(String str) {
        bkq();
        this.goR = str;
        this.goO = new com.baidu.tbadk.core.dialog.f(this.mPageContext);
        this.goO.fk(d.j.report_dialog_title);
        this.goO.a(this.goP, this.mOnItemClickListener);
        this.goO.a(d.j.confirm, this.aRK);
        this.goO.b(d.j.cancel, this.goT);
        this.goO.AY().AZ();
        this.goO.setPositiveButtonEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.b(this.mPageContext);
            this.mWaitingDialog.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.j.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(j.this.bIv);
                }
            });
        }
        this.mWaitingDialog.bq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agf() {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.bq(false);
        }
    }
}
