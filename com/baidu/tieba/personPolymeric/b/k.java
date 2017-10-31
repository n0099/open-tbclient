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
    private BdUniqueId aPq;
    private com.baidu.tbadk.core.dialog.e foo;
    private ArrayList<com.baidu.tbadk.core.dialog.g> fop;
    private String foq;

    /* renamed from: for  reason: not valid java name */
    private String f0for;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.view.a mWaitingDialog;
    private HttpMessageListener fot = new HttpMessageListener(CmdConfigHttp.CMD_USER_REPORT) { // from class: com.baidu.tieba.personPolymeric.b.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof JsonHttpResponsedMessage) {
                k.this.VG();
                JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
                String errorString = jsonHttpResponsedMessage.getErrorString();
                if (StringUtils.isNull(errorString)) {
                    errorString = k.this.mPageContext.getString(jsonHttpResponsedMessage.getError() == 0 ? d.j.report_success : d.j.neterror);
                }
                if (jsonHttpResponsedMessage.getError() == 0) {
                    k.this.fon.c(errorString);
                } else {
                    k.this.fon.d(errorString);
                }
            }
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.core.dialog.g gVar = (com.baidu.tbadk.core.dialog.g) v.c(k.this.fop, i);
            if (gVar != null) {
                k.this.foq = gVar.getTag();
                k.this.foo.setPositiveButtonEnable(true);
            }
            k.this.foo.cm(i);
        }
    };
    private View.OnClickListener abM = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_USER_REPORT, k.this.aPq);
            httpMessage.addParam("complaint_type", k.this.foq);
            httpMessage.addParam("complaint_uid", k.this.f0for);
            MessageManager.getInstance().sendMessage(httpMessage);
            k.this.showLoadingDialog();
            k.this.foo.dismiss();
        }
    };
    private View.OnClickListener fou = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.b.k.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.foo.dismiss();
        }
    };
    private com.baidu.tbadk.core.view.c fon = new com.baidu.tbadk.core.view.c();

    public k(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aPq = bdUniqueId;
        YA();
    }

    private void aZV() {
        this.fop = new ArrayList<>();
        this.fop.add(new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(d.j.report_bad_account_nickname), null, false, "0"));
        this.fop.add(new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(d.j.report_illegal_content), null, false, "1"));
        this.fop.add(new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(d.j.report_photo_problem), null, false, "2"));
        this.fop.add(new com.baidu.tbadk.core.dialog.g(this.mPageContext.getString(d.j.report_bad_tail), null, false, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
    }

    private void YA() {
        this.fot.setTag(this.aPq);
        this.fot.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fot);
    }

    public void jk(String str) {
        aZV();
        this.f0for = str;
        this.foo = new com.baidu.tbadk.core.dialog.e(this.mPageContext);
        this.foo.cl(d.j.report_dialog_title);
        this.foo.a(this.fop, this.mOnItemClickListener);
        this.foo.a(d.j.confirm, this.abM);
        this.foo.b(d.j.cancel, this.fou);
        this.foo.tm().tn();
        this.foo.setPositiveButtonEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (this.mWaitingDialog == null) {
            this.mWaitingDialog = new com.baidu.tbadk.core.view.a(this.mPageContext);
            this.mWaitingDialog.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personPolymeric.b.k.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    MessageManager.getInstance().removeMessage(k.this.aPq);
                }
            });
        }
        this.mWaitingDialog.aE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VG() {
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.aE(false);
        }
    }
}
