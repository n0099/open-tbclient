package com.baidu.tieba.setting.im.more;

import android.net.http.Headers;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.dialog.e;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c iIZ;
    private a iJa;
    private ArrayList<m> iJc;
    private int iJd;
    private int iJe;
    private int iJf;
    private int iJg;
    private int iJh;
    private e iJi;
    private boolean iJb = false;
    private c.a iJj = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cgF() {
            SecretSettingActivity.this.cgD();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cgG() {
            SecretSettingActivity.this.ec("like", SecretSettingActivity.this.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cgH() {
            SecretSettingActivity.this.ec("group", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cgI() {
            SecretSettingActivity.this.ec("live", SecretSettingActivity.this.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cgJ() {
            SecretSettingActivity.this.cgE();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cgK() {
            SecretSettingActivity.this.ec("reply", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void cgL() {
            SecretSettingActivity.this.sendMessage(new CustomMessage(2002001, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener iJk = new HttpMessageListener(CmdConfigHttp.SET_PRIVATE_CMD, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                SecretSettingActivity.this.hideProgressBar();
                if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    String operation = privacySettingMessage.getOperation();
                    int type = privacySettingMessage.getType();
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        SecretSettingActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                    SecretSettingActivity.this.showToast(R.string.success);
                    if (!TextUtils.equals(Headers.LOCATION, operation)) {
                        SecretSettingActivity.this.iJa.bj(operation, type);
                        SecretSettingActivity.this.iIZ.bl(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a byk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.iJb = true;
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    SecretSettingActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                    return;
                }
                a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (aVar != null) {
                    SecretSettingActivity.this.iJa.b(aVar);
                    SecretSettingActivity.this.iJa.cgy();
                    SecretSettingActivity.this.iIZ.ql(true);
                    SecretSettingActivity.this.iIZ.d(SecretSettingActivity.this.iJa);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.iJa);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.iJa.cgB());
                }
            }
        }
    };
    private CustomMessageListener iJl = new CustomMessageListener(2921065) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.iJa.zr(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.iIZ.d(SecretSettingActivity.this.iJa);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iIZ = new c(this);
        this.iJa = new a();
        this.iIZ.a(this.iJj);
        if (this.iJa.cgw()) {
            this.iIZ.ql(true);
            this.iIZ.d(this.iJa);
            c(this.iJa);
        } else {
            this.iIZ.ql(false);
        }
        registerListener(this.byk);
        registerListener(this.iJk);
        registerListener(this.iJl);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.iJd = aVar.cgz();
        this.iJe = aVar.cgx();
        this.iJf = aVar.cgA();
        this.iJg = aVar.aqs();
        this.iJh = aVar.cgC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iIZ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.iIZ.cgM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ec(final String str, String str2) {
        if (this.iJb) {
            if ("group".equals(str)) {
                this.iJc = zy(this.iJf);
            } else if ("post".equals(str)) {
                this.iJc = zy(this.iJe);
            } else if ("like".equals(str)) {
                this.iJc = zy(this.iJd);
            } else if ("live".equals(str)) {
                this.iJc = zz(this.iJg);
            } else if ("reply".equals(str)) {
                this.iJc = zA(this.iJh);
            }
            if (this.iJi != null) {
                this.iJi.dismiss();
            }
            this.iJi = new e(getPageContext());
            this.iJi.mF(str2);
            this.iJi.a(this.iJc, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((m) SecretSettingActivity.this.iJc.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bk(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bk(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bk(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bk(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bk(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.iJi.refresh(i);
                    if ("group".equals(str)) {
                        SecretSettingActivity.this.iJf = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.iJe = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.iJd = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.iJg = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.iJh = i2;
                    }
                }
            }).mF(str2);
            this.iJi.afK().afL();
        }
    }

    private ArrayList<m> zy(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> zz(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> zA(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.all_person), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new m(getPageContext().getString(R.string.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgD() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgE() {
        sendMessage(new CustomMessage(2016302, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iJi != null) {
            this.iJi.dismiss();
        }
    }
}
